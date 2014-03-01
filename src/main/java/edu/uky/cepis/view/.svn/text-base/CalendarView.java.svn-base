/**
 * 
 */
package edu.uky.cepis.view;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.myfaces.custom.schedule.model.ScheduleEntry;

import edu.uky.cepis.domain.Event;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public interface CalendarView {

	public abstract Event addEventToUser(User user, Date endTime,
			Date startTime, String description, String subtitle, String title,
			boolean allDay, TimeZone timeZone);

	public abstract boolean removeEventFromUser(User user,Event event);

	public abstract List<Event> getEventList(User user);
	public abstract List<Event> getEventList(User user, Date selectedDate);

}
