/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.myfaces.custom.schedule.model.ScheduleEntry;
import org.apache.myfaces.custom.schedule.util.ScheduleUtil;

/**
 * @author keerthi
 */
public class Event implements java.util.Comparator<Event>, ScheduleEntry,
		Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="endTime"
	 */
	private Date endTime;
	/**
	 * @uml.property  name="startTime"
	 */
	private Date startTime;
	/**
	 * @uml.property  name="description"
	 */
	private String description;
	/**
	 * @uml.property  name="id"
	 */
	private String id;
	/**
	 * @uml.property  name="subtitle"
	 */
	private String subtitle;
	/**
	 * @uml.property  name="title"
	 */
	private String title;
	/**
	 * @uml.property  name="allDay"
	 */
	private boolean allDay;
	/**
	 * @uml.property  name="timeZone"
	 */
	private TimeZone timeZone;
	/**
	 * @uml.property  name="lastEdit"
	 */
	private Date lastEdit;

	/**
	 * 
	 */
	public Event() {
	}

	/**
	 * @param endTime
	 * @param startTime
	 * @param description
	 * @param subtitle
	 * @param title
	 * @param allDay
	 * @param timeZone
	 */
	public Event(String id, Date endTime, Date startTime, String description,
			String subtitle, String title, boolean allDay, TimeZone timeZone) {
		this.id = id;
		this.endTime = endTime;
		this.startTime = startTime;
		this.description = description;
		this.subtitle = subtitle;
		this.title = title;
		this.allDay = allDay;
		this.timeZone = timeZone;
		this.lastEdit = new Date();
	}

	/**
	 * @return the current timezone
	 * @uml.property name="timeZone"
	 */
	public TimeZone getTimeZone() {
		return this.timeZone;
	}

	/**
	 * Set current timezone
	 * 
	 * @param timeZone
	 *            the timezone
	 * @uml.property name="timeZone"
	 */
	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

	/**
	 * @param description
	 *            The description to set.
	 * @uml.property name="description"
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return Returns the description.
	 * @uml.property name="description"
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param endTime
	 *            The endTime to set.
	 * @uml.property name="endTime"
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return Returns the endTime.
	 * @uml.property name="endTime"
	 */
	public Date getEndTime() {
		if (endTime == null)
			endTime = new Date();
		if (isAllDay()) {
			Date truncated = ScheduleUtil.truncate(endTime, getTimeZone());
			Calendar cal = ScheduleUtil.getCalendarInstance(truncated,
					getTimeZone());
			cal.add(Calendar.MILLISECOND, -1);
			truncated = cal.getTime();
			if (!truncated.equals(endTime)) {
				cal.add(Calendar.DATE, 1);
			}
			return cal.getTime();
		}
		return endTime;
	}

	/**
	 * @param id
	 *            The id to set.
	 * @uml.property name="id"
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return Returns the id.
	 * @uml.property name="id"
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param startTime
	 *            The startTime to set.
	 * @uml.property name="startTime"
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return Returns the startTime. If the allDay property is true, the
	 *         startTime is truncated to 00:00.
	 * @uml.property name="startTime"
	 */
	public Date getStartTime() {
		if (startTime == null)
			startTime = new Date();
		if (isAllDay()) {
			return ScheduleUtil.truncate(startTime, getTimeZone());
		} else {
			return startTime;
		}
	}

	/**
	 * @param subtitle
	 *            The subtitle to set.
	 * @uml.property name="subtitle"
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	/**
	 * @return Returns the subtitle.
	 * @uml.property name="subtitle"
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * @param title
	 *            The title to set.
	 * @uml.property name="title"
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return Returns the title.
	 * @uml.property name="title"
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return Returns true if the entry last all day.
	 * @uml.property name="allDay"
	 */
	public boolean isAllDay() {
		return allDay;
	}

	/**
	 * @param allDay
	 *            does the entry last all day?
	 * @uml.property name="allDay"
	 */
	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	/**
	 * @param lastEdit
	 *            the lastEdit to set
	 * @uml.property name="lastEdit"
	 */
	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}

	/**
	 * @return the lastEdit
	 * @uml.property name="lastEdit"
	 */
	public Date getLastEdit() {
		return lastEdit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastEdit == null) ? 0 : lastEdit.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Event)) {
			return false;
		}
		Event other = (Event) obj;
		System.out.println(other.id + ":" + other);
		if (endTime == null) {
			if (other.endTime != null) {
				return false;
			}
		} else if (!endTime.equals(other.endTime)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			System.out.println("Event object is not equal");
			return false;
		}
		if (lastEdit == null) {
			if (other.lastEdit != null) {
				return false;
			}
		} else if (!lastEdit.equals(other.lastEdit)) {
			return false;
		}
		if (startTime == null) {
			if (other.startTime != null) {
				return false;
			}
		} else if (!startTime.equals(other.startTime)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}

	@Override
	public int compare(Event o1, Event o2) {
		return o1.getId().compareTo(o2.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return title;
	}

}
