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
public class CalendarViewBean extends CepisWebView implements CalendarView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Event addEventToUser(User user, Date endTime, Date startTime,
			String description, String subtitle, String title, boolean allDay,
			TimeZone timeZone) {
		return this.getEventService().addEventToUser(user, endTime, startTime,
				description, subtitle, title, allDay, timeZone);
	}

	@Override
	public boolean removeEventFromUser(User user, Event event) {
		return this.getEventService().removeEventFromUser(user, event);
	}

	@Override
	public List<Event> getEventList(User user) {
		return this.getEventService().getEventList(user);
	}

	@Override
	public List<Event> getEventList(User user, Date selectedDate) {
		return this.getEventService().getEventList(user, selectedDate);
	}

}
