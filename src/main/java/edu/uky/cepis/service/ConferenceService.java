/**
 * 
 */
package edu.uky.cepis.service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import edu.uky.cepis.domain.Attendee;
import edu.uky.cepis.domain.Conference;
import edu.uky.cepis.domain.Ethnic;
import edu.uky.cepis.domain.Event;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public interface ConferenceService {

	Conference updateConference(Conference conference, String name,
			String type, Date conferenceDate, String shortDesc);

	boolean saveConference(Conference conference);

	Set<Attendee> getConferenceAttendeesList(Conference conference);

	List<Conference> getConferenceList();
	
	public List<Conference> getUserConferenceList(User user);

	Conference findConferenceByID(long conferenceId);

	boolean deleteConference(Conference conference);

	Conference createConference(String name, String type, Date conferenceDate,
			String shortDesc);

	Conference findConferenceByName(String name);

	public List<Object> getOldConferenceList();

}
