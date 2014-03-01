/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.Attendee;
import edu.uky.cepis.domain.Conference;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public class ConferenceDaoImpl implements ConferenceDao {

	private static Logger log = Logger.getLogger(ConferenceDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Conference createConference(String name, String type,
			Date conferenceDate, String shortDesc) {
		Conference conference = new Conference(name, type, conferenceDate,
				shortDesc);
		if (conference == null) {
			return conference;
		}
		if (!this.saveConference(conference)) {
			return null;
		}
		return conference;
	}

	@Override
	public boolean deleteConference(Conference conference) {
		if (conference == null) {
			return false;
		}

		this.sessionFactory.getCurrentSession().delete(conference);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Conference findConferenceByID(long conferenceId) {
		if (conferenceId < 1) {
			return null;
		}
		List<Conference> conferences = null;
		Conference conference = null;

		String hql = "select a from Conference a where a.id =" + conferenceId
				+ "";
		conferences = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (conferences.size() < 1) {
			return null;
		}
		conference = conferences.get(0);

		return conference;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Conference findConferenceByName(String name) {
		if (name.isEmpty()) {
			return null;
		}
		List<Conference> conferences = null;
		Conference conference = null;

		String hql = "select a from Conference a where a.name ='" + name + "'";
		conferences = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (conferences.size() < 1) {
			return null;
		}
		conference = conferences.get(0);

		return conference;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Conference> getConferenceList() {
		List<Conference> conferences = new ArrayList<Conference>(0);

		String hql = "select a from Conference a order by a.conferenceDate desc";
		conferences = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return conferences;
	}

	@Override
	public Set<Attendee> getConferenceAttendeesList(Conference conference) {
		Set<Attendee> attendees = new HashSet<Attendee>(0);
		if (conference == null) {
			return attendees;
		}

		Conference newConference = (Conference) this.sessionFactory
				.getCurrentSession().load(Conference.class, conference.getId());
		if (newConference == null) {
			return attendees;
		}
		attendees = newConference.getAttendees();
		return attendees;
	}

	@Override
	public boolean saveConference(Conference conference) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(conference);
		return true;
	}

	@Override
	public Conference updateConference(Conference conference, String name,
			String type, Date conferenceDate, String shortDesc) {
		if (conference == null) {
			return null;
		}
		conference.setName(name);
		conference.setType(type);
		conference.setShortDesc(shortDesc);
		conference.setConferenceDate(conferenceDate);
		conference.setLastEdit(new Date());
		this.saveConference(conference);
		return conference;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Conference> getUserConferenceList(User user) {
		List<Conference> conferences = new ArrayList<Conference>(0);
		if (user == null)
			return conferences;

		String hql = "select c from  Conference c join c.attendees a where a.user.uid = '"
				+ user.getUid() + "' order by c.conferenceDate desc";
		conferences = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();

		return conferences;
	}

	@Deprecated
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getOldConferenceList() {

		List<Object> oldConferenceList = new ArrayList<Object>(0);
		final String sQryToFind = "SELECT c.AdvconferenceID,c.UID,"
				+ "a.Descadmissiontype,uc.Descukclassification,"
				+ "concat_ws('',um.short_description,' (',um.currency,')')"
				+ ",c.ConDate,c.Attend,c.Letter,c.Memo,c.Lastedit "
				+ "FROM tblAdvconference c inner join lstAdmissiontype "
				+ "a on c.Admissiontypecode=a.Admissiontypecode "
				+ "inner join lstUkclassification uc on "
				+ "c.Ukclassification=uc.Ukclassificationcode "
				+ "inner join lstUkmajor um on c.Ukmajorcode=um."
				+ "Ukmajorcode where ConDate is not null or ConDate > "
				+ "'0000-00-00 00:00:00'";
		oldConferenceList = (List<Object>) this.sessionFactory
				.getCurrentSession().createSQLQuery(sQryToFind).list();
		return oldConferenceList;
	}

}
