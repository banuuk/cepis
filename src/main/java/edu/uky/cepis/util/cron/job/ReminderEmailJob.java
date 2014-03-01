/**
 * 
 */
package edu.uky.cepis.util.cron.job;

import java.util.Date;

import org.apache.log4j.Logger;
import org.efs.openreports.objects.MailMessage;
import org.efs.openreports.providers.MailProvider;
import org.efs.openreports.providers.ProviderException;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;

/**
 * @author keerthi
 * 
 */
public class ReminderEmailJob implements Job {

	private MailProvider mailProvider;
	private static Logger log = Logger.getLogger(ReminderEmailJob.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		log.debug("Running ReminderEmailJob at " + new Date());
		ApplicationContext appContext = null;

		try {
			appContext = (ApplicationContext) context.getScheduler()
				.getContext().get("applicationContext");
		} catch (SchedulerException se) {
			throw new JobExecutionException(se);
		}
		mailProvider = (MailProvider) appContext.getBean("mailProvider",
				MailProvider.class);
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		String subject = (String) jobDataMap.get("subject");
		String body = (String) jobDataMap.get("body");
		String toAddresses = (String) jobDataMap.get("toAddress");
		log.debug("Sending Reminder email to " + toAddresses);
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
		} else {
			log.debug("MailProvider is Empty");
		}
		log.debug("ReminderEmailJob finished at " + new Date());
	}

}
