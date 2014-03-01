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
public class AdvisingManagementViewBean extends CepisWebView implements
		AdvisingManagementView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// AdvisingSession stuff
	@Override
	public boolean addAdvisingSession(User user, Advisor advisor,
			AdvisingSessionSlot advisingSessionSlot, String sessionType,
			String sessionStatus, String preSessionText, String sessionText,
			String studentNotes, String advisorNotes) {
		return this.getAdvisingSessionService().addAdvisingSession(user,
				advisor, advisingSessionSlot, sessionType, sessionStatus,
				preSessionText, sessionText, studentNotes, advisorNotes);
	}

	@Override
	public AdvisingSession cancelAdvisingSession(AdvisingSession advisingSession) {
		return this.getAdvisingSessionService().cancelAdvisingSession(
				advisingSession);
	}

	@Override
	public boolean removeAdvisingSession(AdvisingSession advisingSession) {
		return this.getAdvisingSessionService().removeAdvisingSession(
				advisingSession);
	}

	@Override
	public AdvisingSession updateAdvisingSession(
			AdvisingSession advisingSession, String sessionType,
			String sessionStatus, String preSessionText, String sessionText,
			String studentNotes, String advisorNotes,
			AdvisingSessionSlot advisingSessionSlot, boolean noShowEmailSentBoolean) {
		return this.getAdvisingSessionService().updateAdvisingSession(
				advisingSession, sessionType, sessionStatus, preSessionText,
				sessionText, studentNotes, advisorNotes, advisingSessionSlot, noShowEmailSentBoolean);
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionList(User user) {
		return this.getAdvisingSessionService().getAdvisingSessionList(user);
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionList(Advisor advisor) {
		return this.getAdvisingSessionService().getAdvisingSessionList(advisor);
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionList(Advisor advisor,
			Date selectedMonthDate) {
		return this.getAdvisingSessionService().getAdvisingSessionList(advisor,
				selectedMonthDate);
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionListForDay(Advisor advisor,
			Date selectedDate) {
		return this.getAdvisingSessionService().getAdvisingSessionListForDay(
				advisor, selectedDate);
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionListForDay(
			List<Advisor> advisors, Date selectedDate) {
		return this.getAdvisingSessionService().getAdvisingSessionListForDay(
				advisors, selectedDate);
	}

	// AdvisingSessionSlot stuff
	@Override
	public boolean addAdvisingSessionSlotToAdvisor(Advisor advisor,
			int slotNumber, Date slotDate, String status) {
		return this.getAdvisingSessionSlotService()
				.addAdvisingSessionSlotToAdvisor(advisor, slotNumber, slotDate,
						status);
	}

	@Override
	public boolean removeAdvisingSessionSlot(Advisor advisor,
			AdvisingSessionSlot advisingSessionSlot) {
		return this.getAdvisingSessionSlotService().removeAdvisingSessionSlot(
				advisor, advisingSessionSlot);
	}

	@Override
	public boolean updateAdvisingSessionSlot(
			AdvisingSessionSlot advisingSessionSlot, int slotNumber,
			Date slotDate, String status) {
		return this.getAdvisingSessionSlotService().updateAdvisingSessionSlot(
				advisingSessionSlot, slotNumber, slotDate, status);
	}

	@Override
	public Set<AdvisingSessionSlot> getAdvisingSessionSlotList(Advisor advisor) {
		return this.getAdvisingSessionSlotService().getAdvisingSessionSlotList(
				advisor);
	}

	@Override
	public List<AdvisingSessionSlot> getAdvisingSessionSlotList(
			Advisor advisor, Date selectedWeekDate) {
		return this.getAdvisingSessionSlotService().getAdvisingSessionSlotList(
				advisor, selectedWeekDate);
	}

	@Override
	public List<AdvisingSessionSlot> getAvailableAdvisingSessionSlotList(
			Advisor advisor, boolean timeConstraint) {
		return this.getAdvisingSessionSlotService()
				.getAvailableAdvisingSessionSlotList(advisor, timeConstraint);
	}

	// other
	@Override
	public Advisor findAdvisorByUser(User user) {

		return this.getAdvisorService().findAdvisorByUser(user);
	}

	@Override
	public List<Advisor> getAdvisorList() {
		return this.getAdvisorService().getAdvisorList();
	}

	@Override
	public List<AdvisorGroup> getAdvisorGroupList() {
		return this.getAdvisorService().getAdvisorGroupList();
	}

	@Override
	public EmailAddress getUKYEmailAddress(User user) {
		return this.getEmailAddressService().getUKYEmailAddress(user);
	}

	@Override
	public String getAppointmentLocation(User user) {
		return this.getAdvisingSessionService().getAppointmentLocation(user);
	}

	@Override
	public Advisor getStudentAdvisor(User user) {
		return this.getUserProgramProfileService().getStudentAdvisor(user);
	}

	@Override
	public List<EmailAddress> getEmailAddresses(User user) {
		return this.getEmailAddressService().getEmailAddresses(user);
	}

	@Override
	public String getAppointmentLocation(Advisor advisor) {
		return this.getAdvisingSessionService().getAppointmentLocation(advisor);
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionListForDays(
			List<Advisor> advisors, Date selectedStartDate, Date selectedEndDate) {
		return this.getAdvisingSessionService().getAdvisingSessionListForDays(
				advisors, selectedStartDate, selectedEndDate);
	}

	@Override
	public User findUserByUID(String uid) {
		return this.getUserService().findByUid(uid);
	}

	@Override
	public User findUserByUsername(String username) {
		return this.getUserService().findByUsername(username);
	}

	@Override
	public boolean addUserToWorkingSet(WorkingSet ws, User user) {
		return this.getWorkingSetService().addUserToWorkingSet(ws, user);
	}

	@Override
	public boolean checkIn(User user, AdvisingSession advisingSession) {
		return this.getAdvisingSessionService().checkInUser(user,
				advisingSession);
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionList(User user,
			Date selectedDate) {
		return this.getAdvisingSessionService().getAdvisingSessionList(user,
				selectedDate);
	}

	@Override
	public boolean sendEmail(MailMessage mail) {
		return this.getEmailService().sendEmail(mail);
	}

	@Override
	public void scheduleReminderEmail(JobDetail jobDetail, SimpleTrigger trigger)
			throws ProviderException {
		this.getAdvisingSessionService().scheduleReminderEmail(jobDetail,
				trigger);

	}

	@Override
	public void deleteReminderEmail(String name, String group)
			throws ProviderException {
		this.getAdvisingSessionService().deleteReminderEmail(name, group);

	}

	@Override
	public AdvisingSession findAdvisingSessionByID(String id) {
		return this.getAdvisingSessionService().findById(id);
	}

	@Override
	public boolean addUsersToWorkingSet(WorkingSet ws, List<User> users) {
		return this.getWorkingSetService().addUsersToWorkingSet(ws, users);
	}

	@Override
	public boolean addHoldLift(AdvisingSession advisingSession, User liftedBy,
			UKTerm term) {
		return this.getHoldLiftService().addHoldLift(advisingSession, liftedBy,
				term);
	}

	@Override
	public HoldLift findById(long id) {
		return this.getHoldLiftService().findById(id);
	}

	@Override
	public List<HoldLift> getAppointmentHoldLifts(AdvisingSession advisingSession) {
		return this.getHoldLiftService()
				.getAppointmentHoldLifts(advisingSession);
	}

	@Override
	public List<HoldLift> getHoldLiftsByLifter(User liftedBy) {
		return this.getHoldLiftService().getHoldLiftsByLifter(liftedBy);
	}

	@Override
	public List<HoldLift> getHoldLiftsByStudent(User user) {
		return this.getHoldLiftService().getHoldLiftsByStudent(user);
	}

	@Override
	public boolean removeHoldLift(HoldLift holdLift) {
		return this.getHoldLiftService().removeHoldLift(holdLift);
	}

	@Override
	public HoldLift updateHoldLift(HoldLift holdLift, User liftedBy, UKTerm term) {
		return this.getHoldLiftService().updateHoldLift(holdLift, liftedBy,
				term);
	}
	
	@Override
	public List<UserCollegeProfile> getUserCollegeProfiles(User user){
		return this.getUserCollegeProfileService().getUserCollegeProfiles(user);
	}
	
	@Override
	public List<UserProgramProfile> getUserProgramProfiles(User user){
		return this.getUserProgramProfileService().getUserProgramProfiles(user);
	}

	@Override
	public List<AdvisingSession> getNewNoShowAdvisingSessions(){
		return this.getAdvisingSessionService().getNewNoShowAdvisingSessions();
	}
}
