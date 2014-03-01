/**
 * 
 */
package edu.uky.cepis.init;

import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.efs.openreports.objects.ReportUser;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import edu.uky.cepis.manager.ConfigurationManager;
import edu.uky.cepis.manager.UserManager;
import edu.uky.cepis.util.cron.job.RemoveOrphanAppointmentSlotsJob;
import edu.uky.cepis.util.cron.job.UpdateIncorrectAppointmentStatusJob;
import edu.uky.cepis.view.CepisWebView;

/**
 * @author keerthi
 * 
 */
public class InitCEPIS extends CepisWebView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(InitCEPIS.class);

	public InitCEPIS() {
		System.out
				.println("InitCEPIS Object created successfully - (Take No Action)");
	}

	public InitCEPIS(Scheduler scheduler) {
		log.debug("Initializing Appointment Schedule Jobs (Id: UnscheduledSlot, UpdateSlot) ...");
		
		
		
		try {
			if (scheduler.getJobDetail("CEPIS" + "-" + "UnscheduledSlots",
					"Appointments") == null) {
				if (log.isDebugEnabled()) {
					System.out
							.println(InitCEPIS.class
									+ " Creating UnscheduledSlots Job for removing old available slots.");
				}
				// Add / check for weekly and monthly CEPIS triggers
				JobDetail jobDetail1 = new JobDetail("CEPIS" + "-"
						+ "UnscheduledSlots", "Appointments",
						RemoveOrphanAppointmentSlotsJob.class);
				// Trigger for removing Unscheduled Slots
				CronTrigger cronTrigger1 = new CronTrigger("UnscheduledSlots",
						"Appointments");
				try {
					// Do this at 2 AM of last Sunday of every month.
					cronTrigger1.setCronExpression("0 0 2 ? * 1#3");
				} catch (ParseException e) {
					System.err.println(e);
				}
				cronTrigger1.setStartTime(new Date());
				cronTrigger1.setPriority(5);
				// cronTrigger.getJobDataMap().put(reportSchedule.getScheduleName(),
				// reportSchedule.getRequestId());
				scheduler.scheduleJob(jobDetail1, cronTrigger1);
			}
		} catch (SchedulerException e1) {
			System.err.println(e1);
		}
		 
		try {
			if (scheduler.getJobDetail("CEPIS" + "-" + "UpdateSlots",
					"Appointments") == null) {
				if (log.isDebugEnabled()) {
					System.out
							.println(InitCEPIS.class
									+ " Creating UpdateSlot Job for converting CheckedIn status to Completed.");
				}
				JobDetail jobDetail2 = new JobDetail("CEPIS" + "-"
						+ "UpdateSlots", "Appointments",
						UpdateIncorrectAppointmentStatusJob.class);
				// Trigger for changing scheduled but uncompleted appointment to
				// No-Show and
				// Checked-in appts to Completed
				CronTrigger cronTrigger2 = new CronTrigger("UpdateSlots",
						"Appointments");
				try {
					// Do this at 2 AM on every Sunday.
					cronTrigger2.setCronExpression("0 0 2 ? * SUN");
				} catch (ParseException e) {
					System.err.println(e);
				}
				cronTrigger2.setStartTime(new Date());
				cronTrigger2.setPriority(5);

				scheduler.scheduleJob(jobDetail2, cronTrigger2);
			}
		} catch (SchedulerException e) {
			System.err.println(e);
		}
		
		
		
		
		
		/*
		 * log.debug("Initializing Hibernate Search - Lucene Index ...");
		 * this.setSearchEngineService(searchEngineService);
		 * this.getSearchEngineService().initializeSearchEngineIndex();
		 * 
		 * log.debug("Testing a sample query ..."); List<User> searchResults =
		 * this.getSearchEngineService() .executeLuceneQuery("ram muru"); if
		 * (searchResults.size() > 0) { log.debug(searchResults.size() +
		 * " matching users resturned. Best Match: " +
		 * searchResults.get(0).getFullName()); }
		 */
		System.out.println("InitCEPIS Object created successfully");
	}

	public boolean initializeUserProfile(UserManager userMgr,
			ConfigurationManager confMgr) {

		if (log.isDebugEnabled()) {
			log.debug("Initializing User profile ...");
		}
		if (userMgr == null || confMgr == null) {
			System.out.println("User or Configuration Manager is Null");
			return false;
		}
		Properties properties = new Properties();
		properties.put("UserService", userService);
		if (userMgr.init(properties)) {
			if (userMgr.isValid()) {
				if (log.isDebugEnabled()) {
					log.debug("Finished creating UserManager for "
							+ userMgr.getUser() + ".");
				}
				properties.put("User", userMgr.getUser());
				properties.put("LastLoginService", lastLoginService);
				properties.put("IPAddressService", ipAddressService);
				properties.put("WorkingSetService", workingSetService);
				if (confMgr.init(properties)) {
					if (log.isDebugEnabled()) {
						log.debug("Finished creating ConfigurationManager for "
								+ userMgr.getUser().getUsername() + ".");
					}
					properties.clear();
					properties = null;
					if (log.isDebugEnabled()) {
						log.debug("CEPIS Profile Initialization successfull.");
					}
				} else {
					if (log.isDebugEnabled()) {
						log.debug("ConfigurationManager Initialization failed.");
					}
				}

			} else {
				if (log.isDebugEnabled()) {
					log.debug("UserManager Authentication is invalid.");
				}
				return false;
			}

		} else {
			if (log.isDebugEnabled()) {
				log.debug("UserManager Initialization failed.");
			}
			return false;
		}

		// Initialize OpenReports ReportUser object
		if (log.isDebugEnabled()) {
			log.debug("Initializing OpenReport ...");
		}

		ReportUser reportUser = this.getUserService().getReportUser(
				userMgr.getUser());
		if (reportUser == null) {
			if (log.isDebugEnabled()) {
				log.debug("OpenReports Initialization failed: No valid OpenReport Account Found.");
			}
		} else {
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			if (session != null) {
				session.setAttribute("user", reportUser);
				if (log.isDebugEnabled()) {
					log.debug("Finished creating OpenReports for "
							+ userMgr.getUser() + ".");
				}
			} else {
				if (log.isDebugEnabled()) {
					log.debug("OpenReport Initialization failed: No valid session found to add the OpenReport settings.");
				}

			}
		}
		return true;
	}

}
