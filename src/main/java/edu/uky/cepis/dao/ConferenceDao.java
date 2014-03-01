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
public interface ConferenceDao {

	Conference updateConference(Conference conference, String name,
			String type, Date conferenceDate, String shortDesc);

	boolean saveConference(Conference conference);

	Set<Attendee> getConferenceAttendeesList(Conference conference);

	List<Conference> getConferenceList();
	
	List<Conference> getUserConferenceList(User user);

	Conference findConferenceByID(long conferenceId);

	boolean deleteConference(Conference conference);

	Conference createConference(String name, String type, Date conferenceDate,
			String shortDesc);

	Conference findConferenceByName(String name);

	List<Object> getOldConferenceList();



}
