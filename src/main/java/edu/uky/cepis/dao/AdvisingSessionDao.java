/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.Date;
import java.util.List;

import org.efs.openreports.providers.ProviderException;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;

import edu.uky.cepis.domain.AdvisingSession;
import edu.uky.cepis.domain.AdvisingSessionSlot;
import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.User;

/**
 * @author scott
 * 
 */
public interface AdvisingSessionDao {

	public abstract AdvisingSession findById(String id);

	public abstract boolean addAdvisingSession(User user, Advisor advisor,
			AdvisingSessionSlot advisingSessionSlot, String sessionType,
			String sessionStatus, String preSessionText, String sessionText,
			String studentNotes, String advisorNotes);

	public abstract AdvisingSession cancelAdvisingSession(
			AdvisingSession advisingSession);

	public abstract boolean removeAdvisingSession(
			AdvisingSession advisingSession);

	public abstract boolean saveAdvisingSession(AdvisingSession advisingSession);

	public abstract AdvisingSession updateAdvisingSession(
			AdvisingSession advisingSession, String sessionType,
			String sessionStatus, String preSessionText, String sessionText,
			String studentNotes, String advisorNotes,
			AdvisingSessionSlot advisingSessionSlot, boolean noShowEmailSentBoolean);

	public abstract List<AdvisingSession> getAdvisingSessionList(User user);

	public abstract List<AdvisingSession> getAdvisingSessionList(Advisor advisor);

	public abstract List<AdvisingSession> getAdvisingSessionList(
			Advisor advisor, Date selectedMonthDate);

	public abstract List<AdvisingSession> getAdvisingSessionListForDay(
			Advisor advisor, Date selectedDate);

	public abstract List<AdvisingSession> getAdvisingSessionListForDay(
			List<Advisor> advisors, Date selectedDate);

	public abstract String getAppointmentLocation(User user);

	public abstract String getAppointmentLocation(Advisor advisor);

	public abstract List<AdvisingSession> getAdvisingSessionListForDays(
			List<Advisor> advisors, Date selectedStartDate, Date selectedEndDate);

	public abstract boolean checkInUser(User user,
			AdvisingSession advisingSession);

	public abstract List<AdvisingSession> getAdvisingSessionList(User user,
			Date selectedDate);

	public abstract void scheduleReminderEmail(JobDetail jobDetail,
			SimpleTrigger trigger) throws ProviderException;

	public abstract void deleteReminderEmail(String name, String group)
			throws ProviderException;

	public abstract List<AdvisingSession> getIncorrectAdvisingSessionList(Date currentDate,
			String status);

	public abstract boolean updateAdvisingSessions(List<AdvisingSession> advisingSessions,
			String newStatus);
	
	public abstract List<AdvisingSession> getNewNoShowAdvisingSessions();
	
	public abstract List<AdvisingSession> getNoShowEmailList();
}