/**
 * 
 */
package edu.uky.cepis.util.cron.job;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.bouncycastle.openpgp.PGPException;
import org.efs.openreports.objects.MailMessage;
import org.efs.openreports.providers.MailProvider;
import org.efs.openreports.providers.ProviderException;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.context.ApplicationContext;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import edu.uky.cepis.util.operations.security.CEPISPGPUtil;

/**
 * @author cawalk4
 * 
 */
public class ETSScoreLinkJob implements Job {

	private MailProvider mailProvider;
	private JobLauncher jobLauncher;
	private org.springframework.batch.core.Job job;
	private static Logger log = Logger.getLogger(ETSScoreLinkJob.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		log.debug("Running ETSScoreLinkJob at " + new Date());
		// Fetching required dependencies
		ApplicationContext appContext = null;

		try {
			appContext = (ApplicationContext) context.getScheduler()
					.getContext().get("applicationContext");
		} catch (SchedulerException se) {
			throw new JobExecutionException(se);
		}
		// Load all the dependencies
		mailProvider = (MailProvider) appContext.getBean("mailProvider",MailProvider.class);
		
		// Step 0: Read the orphan_records file. Decrypt it. Perform a quick
		// scan for any old records in the
		// orphan_records file with matching user.

		// Step 1: Read Encrypted file from the ETS FTP Server
		try {
			JSch jsch = new JSch();
			
			// jsch.setKnownHosts("PRAXIS/PRX8620.TST");
			Session session;

			session = jsch.getSession("ESRDIuser", "ets-scorelink.ets.org");

			session.setPassword("esrETS2011");
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			
			Channel channel = session.openChannel("sftp");
			channel.connect();
			ChannelSftp sftpChannel = (ChannelSftp) channel;
			
			try {
				sftpChannel.get(
						"/Insts/FTP/private/edsasftp/PRAXIS/PRX1837G.219",
						"C:\\Users\\Keerthi\\Documents\\testfile");
			} catch (SftpException e) {
				System.err.println(e);
			}
			
			// OR			
			// InputStream in =
			// sftpChannel.get("/Insts/FTP/private/edsasftp/PRAXIS/PRX8620.TST");
			// process inputstream as needed
			sftpChannel.exit();
			session.disconnect();
		} catch (JSchException e1) {
			System.err.println(e1);
		}
		// Step 2: Decrypt the file and save it in the server
		File encryptedFile = new File("C:\\Workspace\\cepis\\src\\main\\java\\com\\mytutorial\\praxis\\PRX1837.pgp");
		byte[] encFromFile = null;
		byte[] decrypted = null;
		try {
			encFromFile = CEPISPGPUtil.getBytesFromFile(encryptedFile);
			FileInputStream secKey = new FileInputStream(
					"C:\\Workspace\\cepis\\src\\main\\java\\com\\mytutorial\\praxis\\etsukscorelink-private.asc");
			decrypted = CEPISPGPUtil.decrypt(encFromFile, secKey,
					"s@int007_ed".toCharArray());
		} catch (NoSuchProviderException | IOException | PGPException e1) {
			System.err.println(e1);
		}
		System.out.println(new String(decrypted));
		String decryptedData = new String(decrypted);

		// Step 3: Find the Matching User in the table

		// Step 3.1: If found:

		// Step 3.1.1: add the current test date (with categories) and highest
		// scores for tests taken in the last 10 years
		// to tblPraxis. If a test score is already there (test date + candidate
		// id), skip it.
		try {
			Map<String, JobParameter> parameters = new HashMap<String, JobParameter>();
			parameters.put("date", new JobParameter(new Date()));

			jobLauncher.run(job, new JobParameters(parameters));

		} catch (JobInstanceAlreadyCompleteException e) {
			System.err.println("This job has been completed already !\n" + e);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Step 3.1.2: add the PASSED/NOT PASSED INFORMATION section to
		// tblPraxisArchive

		// Step 3.2: If not found:

		// Step 3.2.1: Open the orphan_records file in the CEPISserver, decrypt
		// it and write this current record to the orphan_records file for
		// processing in the future and encrypt it.

		// Step 4: Dump log and store orphan_records file

		/*JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		String subject = (String) jobDataMap.get("subject");
		String body = (String) jobDataMap.get("body");
		String toAddresses = (String) jobDataMap.get("toAddress");
		System.out.println(toAddresses);
		if (mailProvider != null) {
			MailMessage mail = new MailMessage();
			mail.setSender("teb166@coe.uky.edu");
			mail.setSubject(subject);
			mail.setText(body);
			mail.setBounceAddress("noreply@coe.uky.edu");
			mail.parseRecipients(toAddresses);
			try {
				mailProvider.sendMail(mail);
			} catch (ProviderException e) {
				System.err.println(e);
			}
		}*/
	}

	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

	/**
	 * @param job
	 *            the job to set
	 */
	public void setJob(org.springframework.batch.core.Job job) {
		this.job = job;
	}

}
