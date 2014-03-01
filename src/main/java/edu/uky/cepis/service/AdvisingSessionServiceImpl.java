/**
 * 
 */
package edu.uky.cepis.service;

import java.util.Date;
import java.util.List;

import org.efs.openreports.providers.ProviderException;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;

import edu.uky.cepis.dao.AdvisingSessionDao;
import edu.uky.cepis.domain.AdvisingSession;
import edu.uky.cepis.domain.AdvisingSessionSlot;
import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.User;

/**
 * @author scott
 */
public class AdvisingSessionServiceImpl implements AdvisingSessionService {

	/**
	 * @uml.property name="advisingSessionDao"
	 * @uml.associationEnd
	 */
	private AdvisingSessionDao advisingSessionDao;

	/**
	 * @return the advisingSessionDao
	 * @uml.property name="advisingSessionDao"
	 */
	public AdvisingSessionDao getAdvisingSessionDao() {
		return advisingSessionDao;
	}

	/**
	 * @param advisingSessionDao
	 *            the advisingSessionDao to set
	 * @uml.property name="advisingSessionDao"
	 */
	public void setAdvisingSessionDao(AdvisingSessionDao advisingSessionDao) {
		this.advisingSessionDao = advisingSessionDao;
	}

	@Override
	public AdvisingSession findById(String id) {
		return this.getAdvisingSessionDao().findById(id);
	}

	@Override
	public boolean addAdvisingSession(User user, Advisor advisor,
			AdvisingSessionSlot advisingSessionSlot, String sessionType,
			String sessionStatus, String preSessionText, String sessionText,
			String studentNotes, String advisorNotes) {
		return this.getAdvisingSessionDao().addAdvisingSession(user, advisor,
				advisingSessionSlot, sessionType, sessionStatus,
				preSessionText, sessionText, studentNotes, advisorNotes);
	}

	@Override
	public AdvisingSession cancelAdvisingSession(AdvisingSession advisingSession) {
		return this.getAdvisingSessionDao().cancelAdvisingSession(
				advisingSession);
	}

	@Override
	public boolean removeAdvisingSession(AdvisingSession advisingSession) {
		return this.getAdvisingSessionDao().removeAdvisingSession(
				advisingSession);
	}

	@Override
	public boolean saveAdvisingSession(AdvisingSession advisingSession) {
		return this.getAdvisingSessionDao()
				.saveAdvisingSession(advisingSession);
	}

	@Override
	public AdvisingSession updateAdvisingSession(
			AdvisingSession advisingSession, String sessionType,
			String sessionStatus, String preSessionText, String sessionText,
			String studentNotes, String advisorNotes,
			AdvisingSessionSlot advisingSessionSlot,  boolean noShowEmailSentBoolean) {
		return this.getAdvisingSessionDao().updateAdvisingSession(
				advisingSession, sessionType, sessionStatus, preSessionText,
				sessionText, studentNotes, advisorNotes, advisingSessionSlot, noShowEmailSentBoolean);
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionList(User user) {
		return this.getAdvisingSessionDao().getAdvisingSessionList(user);
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionList(Advisor advisor) {
		return this.getAdvisingSessionDao().getAdvisingSessionList(advisor);
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionList(Advisor advisor,
			Date selectedMonthDate) {
		return this.getAdvisingSessionDao().getAdvisingSessionList(advisor,
				selectedMonthDate);
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionListForDay(Advisor advisor,
			Date selectedDate) {
		return this.getAdvisingSessionDao().getAdvisingSessionListForDay(
				advisor, selectedDate);
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionListForDay(
			List<Advisor> advisors, Date selectedDate) {
		return this.getAdvisingSessionDao().getAdvisingSessionListForDay(
				advisors, selectedDate);
	}

	@Override
	public String getAppointmentLocation(User user) {
		return this.getAdvisingSessionDao().getAppointmentLocation(user);
	}

	@Override
	public String getAppointmentLocation(Advisor advisor) {
		return this.getAdvisingSessionDao().getAppointmentLocation(advisor);
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionListForDays(
			List<Advisor> advisors, Date selectedStartDate, Date selectedEndDate) {
		return this.getAdvisingSessionDao().getAdvisingSessionListForDays(
				advisors, selectedStartDate, selectedEndDate);
	}

	@Override
	public boolean checkInUser(User user, AdvisingSession advisingSession) {
		return this.getAdvisingSessionDao().checkInUser(user, advisingSession);
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionList(User user,
			Date selectedDate) {
		return this.getAdvisingSessionDao().getAdvisingSessionList(user,
				selectedDate);
	}

	@Override
	public void scheduleReminderEmail(JobDetail jobDetail, SimpleTrigger trigger)
			throws ProviderException {
		this.getAdvisingSessionDao().scheduleReminderEmail(jobDetail, trigger);

	}

	@Override
	public void deleteReminderEmail(String name, String group)
			throws ProviderException {
		this.getAdvisingSessionDao().deleteReminderEmail(name, group);

	}

	@Override
	public List<AdvisingSession> getIncorrectAdvisingSessionList(
			Date currentDate, String status) {
		return this.getAdvisingSessionDao().getIncorrectAdvisingSessionList(
				currentDate, status);
	}

	@Override
	public boolean updateAdvisingSessions(
			List<AdvisingSession> advisingSessions, String newStatus) {
		return this.getAdvisingSessionDao().updateAdvisingSessions(
				advisingSessions, newStatus);
	}
	
	@Override
	public List<AdvisingSession> getNewNoShowAdvisingSessions(){
		return this.getAdvisingSessionDao().getNewNoShowAdvisingSessions();
	}
	
	@Override
	public List<AdvisingSession> getNoShowEmailList(){
		return this.getAdvisingSessionDao().getNoShowEmailList();
	}

}
