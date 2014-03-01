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
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.context.ApplicationContext;
import edu.uky.cepis.domain.AdvisingSessionSlot;
import edu.uky.cepis.service.AdvisingSessionSlotService;

/**
 * @author keerthi
 * 
 */
public class RemoveOrphanAppointmentSlotsJob extends QuartzJobBean {

	private AdvisingSessionSlotService advisingSessionSlotService;
	private static Logger log = Logger
			.getLogger(RemoveOrphanAppointmentSlotsJob.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext context)	throws JobExecutionException {
		
		log.debug("Running RemoveOrphanAppointmentSlotsJob at " + new Date());

		ApplicationContext appContext = null;
		
		List<AdvisingSessionSlot> advisingSessionSlotlist = new ArrayList<AdvisingSessionSlot>(0);
		try {
			appContext = (ApplicationContext) context.getScheduler()
				.getContext().get("applicationContext");
		} catch (SchedulerException se) {
			throw new JobExecutionException(se);
		}
		try {
			advisingSessionSlotService = 
				(AdvisingSessionSlotService) appContext.getBean(
					"advisingSessionSlotService", AdvisingSessionSlotService.class);
		} catch (Exception e) {
			System.err.println(e);
		}
		if (advisingSessionSlotService != null) {
			advisingSessionSlotlist = advisingSessionSlotService
					.getOrphanAdvisingSessionSlotList(new Date(), "Available");
			if (advisingSessionSlotlist == null) {
				log.debug("advisingSessionSlotlist is null.");
				return;
			} else if (advisingSessionSlotlist.size() < 1) {
				log.debug("advisingSessionSlotlist is empty.");
				return;
			}
			log.debug("Total Orphan Slots Available: "
					+ advisingSessionSlotlist.size());
			// Remove the Orphan Slots
			if (!advisingSessionSlotService
					.removeAdvisingSessionSlots(advisingSessionSlotlist)) {
				log.debug(" Unknown error in removing orphan appointment slots.");
			} else {
				log.debug("Orphan Appointments removed successfully.");
			}
		} else {
			log.debug(" advisingSessionSlotDao is null.");
		}
	}

	/**
	 * @return the advisingSessionSlotService
	 */
	public AdvisingSessionSlotService getAdvisingSessionSlotService() {
		return advisingSessionSlotService;
	}

	/**
	 * @param advisingSessionSlotService the advisingSessionSlotService to set
	 */
	public void setAdvisingSessionSlotService(
			AdvisingSessionSlotService advisingSessionSlotService) {
		this.advisingSessionSlotService = advisingSessionSlotService;
	}

	

}
