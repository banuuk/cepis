/**
 * 
 */
package edu.uky.cepis.util.cron.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import edu.uky.cepis.service.AdvisingSessionService;
import edu.uky.cepis.domain.AdvisingSession;

/**
 * @author keerthi
 * 
 */
public class UpdateIncorrectAppointmentStatusJob extends QuartzJobBean {

	private AdvisingSessionService advisingSessionService;
	private static Logger log = Logger
			.getLogger(UpdateIncorrectAppointmentStatusJob.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		log.debug("Running UpdateIncorrectAppointmentStatusJob at "
				+ new Date());
		ApplicationContext appContext = null;
		try {
			appContext = (ApplicationContext) context.getScheduler()
					.getContext().get("applicationContext");
		} catch (SchedulerException se) {
			System.err.println(se);
		}

		try {
			advisingSessionService = (AdvisingSessionService) appContext
					.getBean("advisingSessionService",
							AdvisingSessionService.class);
		} catch (Exception e) {
			System.err.println(e);
		}
		if (advisingSessionService != null) {
			List<AdvisingSession> advisingSessionList = new ArrayList<AdvisingSession>(
					0);
			advisingSessionList = advisingSessionService
					.getIncorrectAdvisingSessionList(new Date(), "Checked In");
			if (advisingSessionList == null) {
				log.debug("advisingSessionSlotlist is null.");
				return;
			} else if (advisingSessionList.size() < 1) {
				log.debug("advisingSessionList is empty.");
				return;
			}

			log.debug("Total Incorrect Appointments Available: "
					+ advisingSessionList.size());

			// Update the Incorrect Slots
			if (!advisingSessionService.updateAdvisingSessions(
					advisingSessionList, "Completed")) {
				log.debug("Unknown error in updating Checked In appointment slots.");
				return;
			} else {
				log.debug(" Checked In Incorrect Appointments updated successfully.");
			}
		} else {
			log.debug("advisingSessionService is null.");
		}
	}

	/**
	 * @param advisingSessionService
	 *            the advisingSessionService to set
	 */
	public void setadvisingSessionService(
			AdvisingSessionService advisingSessionService) {
		this.advisingSessionService = advisingSessionService;
	}

	/**
	 * @return the advisingSessionService
	 */
	public AdvisingSessionService getadvisingSessionService() {
		return advisingSessionService;
	}

}
