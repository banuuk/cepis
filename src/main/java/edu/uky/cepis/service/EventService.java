/**
 * 
 */
package edu.uky.cepis.service;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import edu.uky.cepis.domain.Event;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public interface EventService {

	public abstract Event findById(long id);

	public abstract List<Event> findByTitle(String title);

	public abstract Event addEventToUser(User user, Date endTime,
			Date startTime, String description, String subtitle, String title,
			boolean allDay, TimeZone timeZone);

	public abstract Event addEventToUser(User user, Event event);

	public abstract boolean removeEventFromUser(User user, Event event);

	public abstract boolean saveEvent(Event event);

	public abstract Event updateEvent(User user, Event event, Date endTime,
			Date startTime, String description, String subtitle, String title,
			boolean allDay, TimeZone timeZone);

	public abstract List<Event> getEventList(User user);

	public abstract List<Event> getEventList(User user, int maxHourInterval);
	public abstract List<Event> getEventList(User user, Date selectedDate);

}
