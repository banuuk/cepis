/**
 * 
 */
package edu.uky.cepis.view;

import java.util.Date;
import java.util.List;
import java.util.Set;

import edu.uky.cepis.domain.Attendee;
import edu.uky.cepis.domain.Conference;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public class ConferenceManagementViewBean extends CepisWebView implements
		ConferenceManagementView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Conference createConference(String name, String type,
			Date conferenceDate, String shortDesc) {
		return this.getConferenceService().createConference(name, type,
				conferenceDate, shortDesc);
	}

	@Override
	public boolean deleteConference(Conference conference) {
		return this.getConferenceService().deleteConference(conference);
	}

	@Override
	public Conference findConferenceByID(long conferenceId) {
		return this.getConferenceService().findConferenceByID(conferenceId);
	}

	@Override
	public Set<Attendee> getConferenceAttendeesList(Conference conference) {
		return this.getConferenceService().getConferenceAttendeesList(
				conference);
	}

	@Override
	public List<Conference> getConferenceList() {
		return this.getConferenceService().getConferenceList();
	}

	@Override
	public boolean saveConference(Conference conference) {
		return this.getConferenceService().saveConference(conference);
	}

	@Override
	public Conference updateConference(Conference conference, String name,
			String type, Date conferenceDate, String shortDesc) {
		return this.getConferenceService().updateConference(conference, name,
				type, conferenceDate, shortDesc);
	}

	@Override
	public boolean addAttendeeToConference(Conference conference,
			Attendee attendee) {
		return this.getAttendeeService().addAttendeeToConference(conference,
				attendee);
	}

	@Override
	public boolean checkInAttendee(Conference conference, String UID) {
		return this.getAttendeeService().checkInAttendee(conference, UID);
	}

	@Override
	public Attendee createAttendee(Conference conference, User user,
			boolean attended, String shortDesc) {
		return this.getAttendeeService().createAttendee(conference, user,
				attended, shortDesc);
	}

	@Override
	public boolean deleteAttendee(Attendee attendee) {
		return this.getAttendeeService().deleteAttendee(attendee);
	}

	@Override
	public Attendee findAttendeeByID(long attendeeId) {
		return this.getAttendeeService().findAttendeeByID(attendeeId);
	}

	@Override
	public boolean removeAttendeeFromConference(Conference conference,
			Attendee attendee) {
		return this.getAttendeeService().removeAttendeeFromConference(
				conference, attendee);
	}

	@Override
	public Attendee updateAttendee(Attendee attendee, User user,
			boolean attended, String shortDesc) {
		return this.getAttendeeService().updateAttendee(attendee, user,
				attended, shortDesc);
	}

	@Override
	public int addAttendeesToConference(Conference conference, Set<User> users) {
		return this.getAttendeeService().addAttendeesToConference(conference,
				users);
	}

	@Override
	public boolean removeAttendeesFromConference(Conference conference,
			Set<Attendee> selectedAttendees) {
		return this.getAttendeeService().removeAttendeesFromConference(
				conference, selectedAttendees);
	}

	@Override
	public boolean registerAttendee(Conference conference, String UID) {
		return this.getAttendeeService().registerAttendee(conference, UID);
	}

	@Override
	public List<Conference> getUserConferenceList(User user) {
		return this.getConferenceService().getUserConferenceList(user);
	}

	@Override
	public Conference findConferenceByName(String name) {
		return this.getConferenceService().findConferenceByName(name);
	}

	@Override
	public List<Object> getOldConferenceList() {
		return this.getConferenceService().getOldConferenceList();
	}

	@Override
	public User findUserByUID(String uid) {
		return this.getUserService().findByUid(uid);
	}

}
