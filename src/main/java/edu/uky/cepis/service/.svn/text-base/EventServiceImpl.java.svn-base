/**
 * 
 */
package edu.uky.cepis.service;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import edu.uky.cepis.dao.EventDao;
import edu.uky.cepis.domain.Event;
import edu.uky.cepis.domain.User;

/**
 * @author  keerthi
 */
public class EventServiceImpl implements EventService {

	/**
	 * @uml.property  name="eventDao"
	 * @uml.associationEnd  
	 */
	private EventDao eventDao;

	/**
	 * @param eventDao  the eventDao to set
	 * @uml.property  name="eventDao"
	 */
	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	/**
	 * @return  the eventDao
	 * @uml.property  name="eventDao"
	 */
	public EventDao getEventDao() {
		return eventDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EventService#addEventToUser(edu.uky.cepis.domain
	 * .User, java.util.Date, java.util.Date, java.lang.String,
	 * java.lang.String, java.lang.String, boolean, java.util.TimeZone)
	 */
	@Override
	public Event addEventToUser(User user, Date endTime, Date startTime,
			String description, String subtitle, String title, boolean allDay,
			TimeZone timeZone) {
		return this.getEventDao().addEventToUser(user, endTime, startTime,
				description, subtitle, title, allDay, timeZone);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EventService#addEventToUser(edu.uky.cepis.domain
	 * .User, edu.uky.cepis.domain.Event)
	 */
	@Override
	public Event addEventToUser(User user, Event event) {
		return this.getEventDao().addEventToUser(user, event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.EventService#findById(long)
	 */
	@Override
	public Event findById(long id) {
		return this.getEventDao().findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.EventService#findByTitle(java.lang.String)
	 */
	@Override
	public List<Event> findByTitle(String title) {
		return this.getEventDao().findByTitle(title);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EventService#getEventList(edu.uky.cepis.domain.
	 * User)
	 */
	@Override
	public List<Event> getEventList(User user) {
		return this.getEventDao().getEventList(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EventService#removeEventFromUser(edu.uky.cepis.
	 * domain.User, edu.uky.cepis.domain.Event)
	 */
	@Override
	public boolean removeEventFromUser(User user, Event event) {
		return this.getEventDao().removeEventFromUser(user, event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EventService#saveEvent(edu.uky.cepis.domain.Event)
	 */
	@Override
	public boolean saveEvent(Event event) {
		return this.getEventDao().saveEvent(event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EventService#updateEvent(edu.uky.cepis.domain.User,
	 * edu.uky.cepis.domain.Event, java.util.Date, java.util.Date,
	 * java.lang.String, java.lang.String, java.lang.String, boolean,
	 * java.util.TimeZone)
	 */
	@Override
	public Event updateEvent(User user, Event event, Date endTime,
			Date startTime, String description, String subtitle, String title,
			boolean allDay, TimeZone timeZone) {
		return this.getEventDao().updateEvent(user, event, endTime, startTime,
				description, subtitle, title, allDay, timeZone);
	}

	@Override
	public List<Event> getEventList(User user, int maxHourInterval) {
		return this.getEventDao().getEventList(user, maxHourInterval);
	}

	@Override
	public List<Event> getEventList(User user, Date selectedDate) {
		return this.getEventDao().getEventList(user, selectedDate);
	}

}
