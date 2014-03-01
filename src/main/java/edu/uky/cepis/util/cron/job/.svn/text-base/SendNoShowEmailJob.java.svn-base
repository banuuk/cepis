/**
 * 
 */
package edu.uky.cepis.util.cron.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.efs.openreports.objects.MailMessage;
import org.efs.openreports.providers.MailProvider;
import org.efs.openreports.providers.ProviderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import edu.uky.cepis.domain.AdvisingSession;
import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.service.AdvisingSessionService;
import edu.uky.cepis.service.EmailAddressService;

/**
 * @author cawalk4
 * 
 * Purpose: Send a reminder email to students informing them they missed
 * an advising appointment.
 * 
 * RUNS NIGHTLY AT 10:30
 * 
 */
@Service
public class SendNoShowEmailJob  {

	private static Logger log = Logger.getLogger(ReminderEmailJob.class);
	
	@Autowired
	private AdvisingSessionService advisingSessionService;
	
	@Autowired
	private EmailAddressService emailAddressService;
	
	@Autowired
	private MailProvider mailProvider;
	
	private static String EMAIL_SUBJECT = "MISSED ADVISING APPOINTMENT: ";

	private static String EMAIL_BODY = "When you miss an appointment without notifying the TEB 166 office or canceling the scheduled appointment within 24 hours you prevent other students from scheduling at that time.  This represents both a waste of time for advisors and fellow students.  Please reschedule your appointment and be mindful for the future to attend your reserved appointments or cancel them appropriately in the CEPIS online appointment scheduler. https://coesis.coe.uky.edu/cepis <br/><br/>";

	private static String EMAIL_FROM_ADDRESSS = "teb166@coe.uky.edu";
	
	private static String EMAIL_BOUNCE_ADDRESS = "noreply@coe.uky.edu";
	
	@Scheduled(cron="0 30 22 * * ?")
	private void execute(){
		
		if (mailProvider != null &&	advisingSessionService != null) {
			
			List<AdvisingSession> noShowAdvisingSessions = new ArrayList<AdvisingSession>();
			
			noShowAdvisingSessions = getAdvisingSessionService().getNoShowEmailList();
			
			for(AdvisingSession advisingSession : noShowAdvisingSessions){
				
				MailMessage mail = new MailMessage();
				
				mail.setSender(EMAIL_FROM_ADDRESSS);
				mail.setSubject(EMAIL_SUBJECT +
					advisingSession.getSessionTime());
				mail.setText(
					"Dear " + 
					advisingSession.getUser().getfName() + 
					" " +
					advisingSession.getUser().getlName() +
					", <br/><br/>" +
					EMAIL_BODY +
					"Thank You.");
				mail.setBounceAddress(EMAIL_BOUNCE_ADDRESS);
				
				EmailAddress ukEmailAddress = getEmailAddressService().getUKYEmailAddress(advisingSession.getUser());
				
				if(ukEmailAddress != null){
					mail.addRecepient(ukEmailAddress.getAddress());
					
					try {
						mailProvider.sendMail(mail);
					} catch (ProviderException e) {
						System.err.println(e);
					}							
				}else{
					log.debug("No Show E-Mail NOT sent to: " + advisingSession.getUser().getUid() + " : No UKY E-Mail Address.");
				}
				
				//NOTE: Update advising session - set no show email sent to true.
				getAdvisingSessionService().updateAdvisingSession(
						advisingSession, 
						advisingSession.getSessionType(), 
						advisingSession.getSessionStatus(), 
						advisingSession.getPreSessionText(),
						advisingSession.getSessionText(),
						advisingSession.getStudentNotes(),
						advisingSession.getAdvisorNotes(), 
						advisingSession.getAdvisingSessionSlot(),
						true);
			}
			
		} else {
			log.debug("MailProvider is Empty");
		}
		log.debug("ReminderEmailJob finished at " + new Date());
	}
	
	public void setAdvisingSessionService(AdvisingSessionService advisingSessionService) {
		this.advisingSessionService = advisingSessionService;
	}

	public AdvisingSessionService getAdvisingSessionService() {
		return advisingSessionService;
	}

	public EmailAddressService getEmailAddressService() {
		return emailAddressService;
	}

	public void setEmailAddressService(EmailAddressService emailAddressService) {
		this.emailAddressService = emailAddressService;
	}

	public MailProvider getMailProvider() {
		return mailProvider;
	}

	public void setMailProvider(MailProvider mailProvider) {
		this.mailProvider = mailProvider;
	}

}
