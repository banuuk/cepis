/**
 * 
 */
package edu.uky.cepis.util.cron.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import edu.uky.cepis.domain.AdvisingSession;
import edu.uky.cepis.service.AdvisingSessionService;

/**
 * @author cawalk4
 * 
 * Purpose: Update all appointments with a date before the current date time
 * Setting the appointmentStatus to "No Show"
 * 
 * RUNS NIGHTLY AT 10:00
 * 
 */


@Service
public class UpdateNoShowAppointmentJob {

	private static Logger log = Logger.getLogger(UpdateNoShowAppointmentJob.class);
	
	@Autowired
	private AdvisingSessionService advisingSessionService;
		
	private static String NO_SHOW = "No Show";
	
	@Scheduled(cron="0 0 22 * * ?")
	private void execute(){
		log.debug("Running UpdateNoShowAppointmentJob at "	+ new Date());
		
		List<AdvisingSession> advisingSessionList = new ArrayList<AdvisingSession>(0);
		
		advisingSessionList = getAdvisingSessionService().getNewNoShowAdvisingSessions();
		
		if (advisingSessionList == null) {
			log.debug("advisingSessionSlotlist is null.");
			return;
		} else if (advisingSessionList.isEmpty()) {
			log.debug("There are no new No Show advising appointments.");
			return;
		}
		
		log.debug("Total no show e-mails are: " + advisingSessionList.size());

		// Update the appointments 
		
		for(AdvisingSession advisingSession : advisingSessionList){
			
			getAdvisingSessionService().updateAdvisingSession(					
					advisingSession,
					advisingSession.getSessionType(), 
					NO_SHOW,
					advisingSession.getPreSessionText(),
					advisingSession.getSessionText(),
					advisingSession.getStudentNotes(),
					advisingSession.getAdvisorNotes(),
					advisingSession.getAdvisingSessionSlot(),
					advisingSession.getNoShowEmailSentBoolean());
		}
		
	}
	
	public void setAdvisingSessionService(AdvisingSessionService advisingSessionService) {
		this.advisingSessionService = advisingSessionService;
	}

	public AdvisingSessionService getAdvisingSessionService() {
		return advisingSessionService;
	}
	
}
