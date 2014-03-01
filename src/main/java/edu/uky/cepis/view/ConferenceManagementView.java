/**
 * 
 */
package edu.uky.cepis.view;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.efs.openreports.objects.ReportUser;

import edu.uky.cepis.domain.Address;
import edu.uky.cepis.domain.AddressType;
import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.Attendee;
import edu.uky.cepis.domain.CohortTerm;
import edu.uky.cepis.domain.CohortType;
import edu.uky.cepis.domain.Conference;
import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.EmailAddressType;
import edu.uky.cepis.domain.Ethnic;
import edu.uky.cepis.domain.Phone;
import edu.uky.cepis.domain.PhoneType;
import edu.uky.cepis.domain.Role;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserClassification;
import edu.uky.cepis.domain.UserCollegeProfile;
import edu.uky.cepis.domain.UserPersonalProfile;
import edu.uky.cepis.domain.UserProgramProfile;
import edu.uky.cepis.domain.UserType;
import edu.uky.cepis.domain.WorkingSet;
import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.ProgramGroup;
import edu.uky.cepis.domain.component.ProgramTrack;
import edu.uky.cepis.domain.component.UKCollege;
import edu.uky.cepis.domain.component.UKDepartment;
import edu.uky.cepis.domain.component.UKMajor;
import edu.uky.cepis.domain.component.UKStatus;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author keerthi
 * 
 */
public interface ConferenceManagementView {

	Conference updateConference(Conference conference, String name,
			String type, Date conferenceDate, String shortDesc);

	boolean saveConference(Conference conference);

	Set<Attendee> getConferenceAttendeesList(Conference conference);

	List<Conference> getConferenceList();

	Conference findConferenceByID(long conferenceId);

	boolean deleteConference(Conference conference);

	Conference createConference(String name, String type, Date conferenceDate,
			String shortDesc);
	
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
	
	public List<Conference> getUserConferenceList(User user);
	
	Conference findConferenceByName(String name);
	
	List<Object> getOldConferenceList();

	User findUserByUID(String uid);


}
