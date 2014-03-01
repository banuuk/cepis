/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.Event;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public class EventDaoImpl implements EventDao {
	private static Logger log = Logger.getLogger(EventDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Event findById(long id) {
		List<Event> events = new ArrayList<Event>(0);

		String hql = "select a from Event a where a.id = '" + id + "'";
		events = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (events.size() > 0)
			return events.get(0);
		return null;
	}

	@Override
	public List<Event> findByTitle(String title) {
		if (title == null || title.equals("")) {
			return null;
		}
		List<Event> events = new ArrayList<Event>(0);

		String hql = "select a from Event a where a.title like '%" + title
				+ "%'";
		events = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return events;
	}

	@Override
	public Event addEventToUser(User user, Date endTime, Date startTime,
			String description, String subtitle, String title, boolean allDay,
			TimeZone timeZone) {
		if (user == null) {
			return null;
		}

		Event event = new Event(RandomStringUtils.randomNumeric(32), endTime,
				startTime, description, subtitle, title, allDay, timeZone);
		if (event == null) {
			return null;
		}
		if (!this.saveEvent(event)) {
			return null;
		}
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return null;
		}
		newuser.getEvents().add(event);
		return event;

	}

	@Override
	public Event addEventToUser(User user, Event event) {
		if (user == null) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return null;
		}
		Event newevent = (Event) this.sessionFactory.getCurrentSession().load(
				Event.class, event.getId());
		if (newevent == null) {
			return null;
		}
		newuser.getEvents().add(newevent);
		return event;

	}

	@Override
	public boolean removeEventFromUser(User user, Event event) {
		System.out.println("Got in the remove event dao");
		if (user == null) {
			System.out.println("User null");
			return false;
		}
		if (event == null) {
			System.out.println("event null");
			return false;
		}
		System.out.println(event.getId());

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		Event newevent = (Event) this.sessionFactory.getCurrentSession().load(
				Event.class, event.getId());
		if (newevent == null) {
			System.out.println("there is no event available");
			return false;
		}
		System.out.println(newevent.getId());
		System.out.println(newevent);
		List<Event> events = newuser.getEvents();
		System.out.println(events.size());
		Iterator<Event> iter = events.iterator();
		while (iter.hasNext()) {
			Event myevent = iter.next();
			System.out.println("ID:" + myevent.getId() + " Event details:"
					+ myevent);
		}
		if (events.contains(newevent)) {
			System.out.println("User has this event");
			events.remove(newevent);
			this.sessionFactory.getCurrentSession().delete(newevent);
			return true;
		}
		System.out.println("User doesn have this event");
		return false;
	}

	@Override
	public boolean saveEvent(Event event) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(event);
		return true;
	}

	@Override
	public Event updateEvent(User user, Event event, Date endTime,
			Date startTime, String description, String subtitle, String title,
			boolean allDay, TimeZone timeZone) {
		if (user == null) {
			return null;
		}
		if (event == null) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		Event newevent = (Event) this.sessionFactory.getCurrentSession().load(
				Event.class, event.getId());
		if (newevent == null || newuser == null) {
			return null;
		}
		if (!newuser.getEvents().contains(newevent)) {
			return null;
		}
		newevent.setStartTime(startTime);
		newevent.setEndTime(endTime);
		newevent.setDescription(description);
		newevent.setSubtitle(subtitle);
		newevent.setTitle(title);
		newevent.setAllDay(allDay);
		newevent.setTimeZone(timeZone);
		newevent.setLastEdit(new Date());
		this.saveEvent(newevent);
		return newevent;

	}

	@Override
	public List<Event> getEventList(User user) {
		List<Event> events = new ArrayList<Event>(0);
		if (user == null) {
			return events;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return events;
		}
		events = newuser.getEvents();
		return events;
	}

	@Override
	public List<Event> getEventList(User user, int maxHourInterval) {
		List<Event> events = new ArrayList<Event>(0);

		if (user == null) {
			return events;
		}
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.add(Calendar.HOUR, maxHourInterval);

		String hql = "select a from Event a and User u where u.id='"
				+ user.getUid() + "' and a.startTime between '" + new Date()
				+ "' and '" + calendar.getTime() + "'";
		events = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (events.size() > 0)
			return events;
		return null;
	}

	@Override
	public List<Event> getEventList(User user, Date selectedDate) {
		List<Event> events = new ArrayList<Event>(0);

		if (user == null) {
			return events;
		}
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(selectedDate);

		String hql = "select distinct a from User u left join u.events a where u.uid like '"
				+ user.getUid()
				+ "' and month(a.startTime)="
				+ (calendar.get(Calendar.MONTH) + 1)
				+ " and year(a.startTime)=" + calendar.get(Calendar.YEAR);
		events = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (events.size() > 0)
			return events;
		return new ArrayList<Event>(0);
	}

}
