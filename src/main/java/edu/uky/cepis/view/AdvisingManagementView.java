/**
 * 
 */
package edu.uky.cepis.view;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.efs.openreports.objects.MailMessage;
import org.efs.openreports.providers.ProviderException;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;

import edu.uky.cepis.domain.AdvisingSession;
import edu.uky.cepis.domain.AdvisingSessionSlot;
import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.AdvisorGroup;
import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.HoldLift;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserCollegeProfile;
import edu.uky.cepis.domain.UserProgramProfile;
import edu.uky.cepis.domain.WorkingSet;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author scott
 * 
 */
public interface AdvisingManagementView {

	// AdvisingSession stuff
	public abstract boolean addAdvisingSession(User user, Advisor advisor,
			AdvisingSessionSlot advisingSessionSlot, String sessionType,
			String sessionStatus, String preSessionText, String sessionText,
			String studentNotes, String advisorNotes);

	public abstract AdvisingSession cancelAdvisingSession(
			AdvisingSession advisingSession);

	public abstract boolean removeAdvisingSession(
			AdvisingSession advisingSession);

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

	// AdvisingSessionSlot stuff
	public abstract boolean addAdvisingSessionSlotToAdvisor(Advisor advisor,
			int slotNumber, Date slotDate, String status);

	public abstract boolean removeAdvisingSessionSlot(Advisor advisor,
			AdvisingSessionSlot advisingSessionSlot);

	public abstract boolean updateAdvisingSessionSlot(
			AdvisingSessionSlot advisingSessionSlot, int slotNumber,
			Date slotDate, String status);

	public abstract Set<AdvisingSessionSlot> getAdvisingSessionSlotList(
			Advisor advisor);

	public abstract List<AdvisingSessionSlot> getAdvisingSessionSlotList(
			Advisor advisor, Date selectedWeekDate);

	public abstract List<AdvisingSessionSlot> getAvailableAdvisingSessionSlotList(
			Advisor advisor, boolean timeConstraint);

	// other
	public abstract Advisor findAdvisorByUser(User user);

	public abstract List<Advisor> getAdvisorList();

	public abstract EmailAddress getUKYEmailAddress(User user);

	public abstract String getAppointmentLocation(User user);

	public abstract Advisor getStudentAdvisor(User user);

	public abstract List<EmailAddress> getEmailAddresses(User user);

	public abstract void scheduleReminderEmail(JobDetail jobDetail,
			SimpleTrigger trigger) throws ProviderException;

	public abstract String getAppointmentLocation(Advisor advisor);

	public abstract List<AdvisingSession> getAdvisingSessionListForDays(
			List<Advisor> advisors, Date selectedStartDate, Date selectedEndDate);

	public abstract User findUserByUID(String uid);

	public abstract boolean addUserToWorkingSet(WorkingSet ws, User user);

	public abstract boolean checkIn(User user, AdvisingSession advisingSession);

	public abstract List<AdvisingSession> getAdvisingSessionList(User user,
			Date selectedDate);

	public abstract List<AdvisorGroup> getAdvisorGroupList();

	public abstract boolean sendEmail(MailMessage mail);

	public abstract void deleteReminderEmail(String name, String group)
			throws ProviderException;

	public abstract User findUserByUsername(String username);

	public AdvisingSession findAdvisingSessionByID(String id);

	public boolean addUsersToWorkingSet(WorkingSet ws, List<User> users);
	
	public HoldLift findById(long id);

	public List<HoldLift> getHoldLiftsByLifter(User liftedBy);

	public List<HoldLift> getHoldLiftsByStudent(User user);

	public List<HoldLift> getAppointmentHoldLifts(AdvisingSession advisingSession);

	public boolean addHoldLift(AdvisingSession advisingSession, User liftedBy,
			UKTerm term);

	public HoldLift updateHoldLift(HoldLift holdLift, User liftedBy, UKTerm term);

	public boolean removeHoldLift(HoldLift holdLift);
	
	public List<UserCollegeProfile> getUserCollegeProfiles(User user);
	
	public List<UserProgramProfile> getUserProgramProfiles(User user);
	
	public List<AdvisingSession> getNewNoShowAdvisingSessions();
}
