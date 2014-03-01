/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.Attendee;
import edu.uky.cepis.domain.Conference;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;

/**
 * @author keerthi
 * 
 */
public class AttendeeDaoImpl implements AttendeeDao {

	private static Logger logger = Logger.getLogger(AttendeeDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Attendee createAttendee(Conference conference, User user,
			boolean attended, String shortDesc) {
		if (conference == null)
			return null;
		if (user == null)
			return null;
		if (findAttendeeInConference(conference, user))
			return null;
		Attendee attendee = new Attendee(user, attended, shortDesc);
		if (attendee == null) {
			return attendee;
		}
		if (!this.saveAttendee(attendee)) {
			return null;
		}
		return attendee;
	}

	private boolean findAttendeeInConference(Conference conference, User user) {

		Conference newConference = (Conference) this.sessionFactory
				.getCurrentSession().load(Conference.class, conference.getId());
		Iterator<Attendee> attendees = newConference.getAttendees().iterator();
		while (attendees.hasNext()) {
			if (attendees.next().getUser().equals(user)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteAttendee(Attendee attendee) {
		if (attendee == null) {
			return false;
		}

		this.sessionFactory.getCurrentSession().delete(attendee);
		return true;
	}

	@Override
	public Attendee findAttendeeByID(long attendeeId) {
		if (attendeeId < 1) {
			return null;
		}
		List<Attendee> attendees = null;
		Attendee attendee = null;

		String hql = "select a from Attendee a where a.id =" + attendeeId + "";
		attendees = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (attendees.size() < 1) {
			return null;
		}
		attendee = attendees.get(0);

		return attendee;
	}

	private boolean saveAttendee(Attendee attendee) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(attendee);
		return true;
	}

	@Override
	public boolean checkInAttendee(Conference conference, String UID) {
		if (conference == null)
			return false;
		if (UID == null || UID.isEmpty())
			return false;

		Conference newConference = (Conference) this.sessionFactory
				.getCurrentSession().load(Conference.class, conference.getId());

		Attendee attendee = this.getAttendeeByUser(conference.getId(), UID);
		if (attendee == null)
			return false;
		if (newConference.getAttendees().contains(attendee)) {
			attendee.setAttended(true);
			attendee.setLastEdit(new Date());
			this.saveAttendee(attendee);
			return true;
		}

		return false;
	}

	@Override
	public boolean registerAttendee(Conference conference, String UID) {
		if (conference == null)
			return false;
		if (UID == null || UID.isEmpty())
			return false;

		Conference newConference = (Conference) this.sessionFactory
				.getCurrentSession().load(Conference.class, conference.getId());

		Attendee attendee = this.getAttendeeByUser(conference.getId(), UID);
		if (attendee == null) {
			User user = this.findByUid(UID);
			if (user == null) {
				return false;
			}
			attendee = new Attendee(user, true, null);
			newConference.getAttendees().add(attendee);
			this.sessionFactory.getCurrentSession().saveOrUpdate(newConference);
		} else {
			attendee.setAttended(true);
			attendee.setLastEdit(new Date());
			this.saveAttendee(attendee);
		}
		return true;
	}

	private User findByUid(String uid) {
		User cepisuser = null;
		List<User> users = null;

		String hql = "select a from User a where a.uid ='" + uid + "'";
		users = this.sessionFactory.getCurrentSession().createQuery(hql).list();
		if (users.size() > 0) {
			if (logger.isDebugEnabled()) {
				System.out.println("Found Matching user in CEPIS Server for "
						+ cepisuser.getUsername());
			}
			return users.get(0);

		}
		if (logger.isDebugEnabled()) {
			logger.debug("User not found - " + uid);
		}

		return null;
	}

	private Attendee getAttendeeByUser(long conferenceId, String UID) {
		if (UID == null)
			return null;
		List<Attendee> attendees = null;
		Attendee attendee = null;

		String hql = "select a from  Conference c join c.attendees a where c.id = "
				+ conferenceId + " and a.user.uid = '" + UID.trim() + "'";
		attendees = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (attendees.size() < 1) {
			return null;
		}
		attendee = attendees.get(0);

		return attendee;

	}

	@Override
	public Attendee updateAttendee(Attendee attendee, User user,
			boolean attended, String shortDesc) {
		if (attendee == null) {
			return null;
		}
		attendee.setUser(user);
		attendee.setShortDesc(shortDesc);
		attendee.setAttended(attended);
		attendee.setLastEdit(new Date());
		this.saveAttendee(attendee);
		return attendee;
	}

	@Override
	public boolean addAttendeeToConference(Conference conference,
			Attendee attendee) {

		if (conference == null) {
			return false;
		}
		if (attendee == null) {
			return false;
		}
		Conference newConference = (Conference) this.sessionFactory
				.getCurrentSession().load(Conference.class, conference.getId());
		Attendee newAttendee = (Attendee) this.sessionFactory
				.getCurrentSession().load(Attendee.class, attendee.getId());

		if (!newConference.getAttendees().contains(newAttendee)) {
			newConference.getAttendees().add(newAttendee);
			return true;
		}
		this.saveAttendee(newAttendee);
		return false;
	}

	@Override
	public int addAttendeesToConference(Conference conference, Set<User> users) {

		int count = 0;
		if (conference == null) {
			return -1;
		}
		if (users == null || users.size() < 1) {
			return -1;
		}
		Conference newConference = (Conference) this.sessionFactory
				.getCurrentSession().load(Conference.class, conference.getId());
		Iterator<User> iter = users.iterator();
		User newUser = null;

		Attendee newAttendee = null;
		while (iter.hasNext()) {
			newUser = iter.next();
			if (!this.findAttendeeInConference(newConference, newUser)) {
				newAttendee = new Attendee(newUser, false, "");
				if (newConference.getAttendees().add(newAttendee)) {
					count++;
				}
			}
		}
		this.sessionFactory.getCurrentSession().saveOrUpdate(newConference);
		return count;
	}

	@Override
	public boolean removeAttendeeFromConference(Conference conference,
			Attendee attendee) {

		if (conference == null) {
			return false;
		}
		if (attendee == null) {
			return false;
		}
		Conference newConference = (Conference) this.sessionFactory
				.getCurrentSession().load(Conference.class, conference.getId());
		Attendee newAttendee = (Attendee) this.sessionFactory
				.getCurrentSession().load(Attendee.class, attendee.getId());
		Set<Attendee> attendees = newConference.getAttendees();
		if (attendees.contains(newAttendee)) {
			attendees.remove(newAttendee);
			this.sessionFactory.getCurrentSession().delete(newAttendee);
			this.sessionFactory.getCurrentSession().saveOrUpdate(newConference);
			return true;
		}

		return false;
	}

	@Override
	public boolean removeAttendeesFromConference(Conference conference,
			Set<Attendee> selectedAttendees) {
		if (conference == null) {
			return false;
		}
		if (selectedAttendees == null || selectedAttendees.size() < 1) {
			return false;
		}
		Conference newConference = (Conference) this.sessionFactory
				.getCurrentSession().load(Conference.class, conference.getId());
		Set<Attendee> attendees = newConference.getAttendees();
		boolean status = attendees.removeAll(selectedAttendees);
		this.sessionFactory.getCurrentSession().saveOrUpdate(newConference);
		Iterator<Attendee> iter = selectedAttendees.iterator();
		while (iter.hasNext()) {
			this.sessionFactory.getCurrentSession().delete(iter.next());
		}
		return status;
	}

}
