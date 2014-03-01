/**
 * 
 */
package edu.uky.cepis.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import edu.uky.cepis.dao.ConferenceDao;
import edu.uky.cepis.dao.EthnicDao;
import edu.uky.cepis.domain.Attendee;
import edu.uky.cepis.domain.Conference;
import edu.uky.cepis.domain.Ethnic;
import edu.uky.cepis.domain.User;

/**
 * @author  keerthi
 */
public class ConferenceServiceImpl implements ConferenceService {

	/**
	 * @uml.property  name="conferenceDao"
	 * @uml.associationEnd  
	 */
	private ConferenceDao conferenceDao;

	/**
	 * @param conferenceDao  the conferenceDao to set
	 * @uml.property  name="conferenceDao"
	 */
	public void setConferenceDao(ConferenceDao conferenceDao) {
		this.conferenceDao = conferenceDao;
	}

	/**
	 * @return  the conferenceDao
	 * @uml.property  name="conferenceDao"
	 */
	public ConferenceDao getConferenceDao() {
		return conferenceDao;
	}

	@Override
	public Conference createConference(String name,String type, Date conferenceDate,
			String shortDesc) {
		return this.getConferenceDao().createConference(name, type, conferenceDate,
				shortDesc);
	}

	@Override
	public boolean deleteConference(Conference conference) {

		return this.getConferenceDao().deleteConference(conference);
	}

	@Override
	public Conference findConferenceByID(long conferenceId) {

		return this.getConferenceDao().findConferenceByID(conferenceId);
	}

	@Override
	public Set<Attendee> getConferenceAttendeesList(Conference conference) {
		return this.getConferenceDao().getConferenceAttendeesList(conference);
	}

	@Override
	public List<Conference> getConferenceList() {
		return this.getConferenceDao().getConferenceList();
	}

	@Override
	public boolean saveConference(Conference conference) {
		return this.getConferenceDao().saveConference(conference);
	}

	@Override
	public Conference updateConference(Conference conference, String name,String type,
			Date conferenceDate, String shortDesc) {
		return this.getConferenceDao().updateConference(conference, name,type,
				conferenceDate, shortDesc);
	}

	@Override
	public List<Conference> getUserConferenceList(User user) {
		return this.getConferenceDao().getUserConferenceList(user);
	}

	@Override
	public Conference findConferenceByName(String name) {
		return this.getConferenceDao().findConferenceByName(name);
	}

	@Override
	public List<Object> getOldConferenceList() {
		return this.getConferenceDao().getOldConferenceList();
	}

}
