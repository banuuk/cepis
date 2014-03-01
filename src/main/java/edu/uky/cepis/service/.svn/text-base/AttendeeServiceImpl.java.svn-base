/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import java.util.Set;

import edu.uky.cepis.dao.AttendeeDao;
import edu.uky.cepis.dao.EthnicDao;
import edu.uky.cepis.domain.Attendee;
import edu.uky.cepis.domain.Conference;
import edu.uky.cepis.domain.Ethnic;
import edu.uky.cepis.domain.User;

/**
 * @author  keerthi
 */
public class AttendeeServiceImpl implements AttendeeService {

	/**
	 * @uml.property  name="attendeeDao"
	 * @uml.associationEnd  
	 */
	private AttendeeDao attendeeDao;

	/**
	 * @param attendeeDao  the attendeeDao to set
	 * @uml.property  name="attendeeDao"
	 */
	public void setAttendeeDao(AttendeeDao attendeeDao) {
		this.attendeeDao = attendeeDao;
	}

	/**
	 * @return  the attendeeDao
	 * @uml.property  name="attendeeDao"
	 */
	public AttendeeDao getAttendeeDao() {
		return attendeeDao;
	}

	@Override
	public boolean addAttendeeToConference(Conference conference,
			Attendee attendee) {
		return this.getAttendeeDao().addAttendeeToConference(conference,
				attendee);
	}

	@Override
	public boolean checkInAttendee(Conference conference, String UID) {

		return this.getAttendeeDao().checkInAttendee(conference, UID);
	}

	@Override
	public Attendee createAttendee(Conference conference, User user,
			boolean attended, String shortDesc) {
		return this.getAttendeeDao().createAttendee(conference, user, attended,
				shortDesc);
	}

	@Override
	public boolean deleteAttendee(Attendee attendee) {
		return this.getAttendeeDao().deleteAttendee(attendee);
	}

	@Override
	public Attendee findAttendeeByID(long attendeeId) {
		return this.getAttendeeDao().findAttendeeByID(attendeeId);
	}

	@Override
	public boolean removeAttendeeFromConference(Conference conference,
			Attendee attendee) {
		return this.getAttendeeDao().removeAttendeeFromConference(conference,
				attendee);
	}

	@Override
	public Attendee updateAttendee(Attendee attendee, User user,
			boolean attended, String shortDesc) {
		return this.getAttendeeDao().updateAttendee(attendee, user, attended,
				shortDesc);
	}

	@Override
	public int addAttendeesToConference(Conference conference, Set<User> users) {
		return this.getAttendeeDao()
				.addAttendeesToConference(conference, users);
	}

	@Override
	public boolean removeAttendeesFromConference(Conference conference,
			Set<Attendee> selectedAttendees) {
		return this.getAttendeeDao().removeAttendeesFromConference(conference,
				selectedAttendees);
	}

	@Override
	public boolean registerAttendee(Conference conference, String UID) {
		return this.getAttendeeDao().registerAttendee(conference, UID);
	}

}
