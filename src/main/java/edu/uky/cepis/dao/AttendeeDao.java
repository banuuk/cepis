/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import edu.uky.cepis.domain.Attendee;
import edu.uky.cepis.domain.Conference;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;

/**
 * @author keerthi
 *
 */
public interface AttendeeDao {

	boolean removeAttendeeFromConference(Conference conference,
			Attendee attendee);

	boolean addAttendeeToConference(Conference conference, Attendee attendee);

	Attendee updateAttendee(Attendee attendee, User user,  boolean attended,
			String shortDesc);

	boolean checkInAttendee(Conference conference, String UID);
	
	boolean registerAttendee(Conference conference, String UID);

	Attendee findAttendeeByID(long attendeeId);

	boolean deleteAttendee(Attendee attendee);

	Attendee createAttendee(Conference conference, User user,  boolean attended,
			String shortDesc);

	boolean removeAttendeesFromConference(Conference conference,
			Set<Attendee> selectedAttendees);

	int addAttendeesToConference(Conference conference, Set<User> users);

}
