package edu.uky.cepis.domain;

// Generated Jun 20, 2011 3:36:15 PM by Hibernate Tools 3.3.0.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Conference class contains CEPIS conference details
 */
public class Conference implements java.io.Serializable,
		java.util.Comparator<Conference> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String type;
	private Date conferenceDate;
	private String shortDesc;
	private Set<Attendee> attendees = new HashSet<Attendee>(0);
	private Date lastEdit;

	public Conference() {
	}

	public Conference(String name, String type, Date conferenceDate,
			String shortDesc) {
		this.name = name;
		this.setType(type);
		this.conferenceDate = conferenceDate;
		this.shortDesc = shortDesc;
		this.lastEdit = new Date();
	}

	/**
	 * @return
	 * @uml.property  name="id"
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * @param id
	 * @uml.property  name="id"
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 * @uml.property  name="conferenceDate"
	 */
	public Date getConferenceDate() {
		return this.conferenceDate;
	}

	/**
	 * @param conferenceDate
	 * @uml.property  name="conferenceDate"
	 */
	public void setConferenceDate(Date conferenceDate) {
		this.conferenceDate = conferenceDate;
	}

	/**
	 * @return
	 * @uml.property  name="shortDesc"
	 */
	public String getShortDesc() {
		return this.shortDesc;
	}

	/**
	 * @param shortDesc
	 * @uml.property  name="shortDesc"
	 */
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	/**
	 * @return
	 * @uml.property  name="attendees"
	 */
	public Set<Attendee> getAttendees() {
		return this.attendees;
	}

	/**
	 * @param attendees
	 * @uml.property  name="attendees"
	 */
	public void setAttendees(Set<Attendee> attendees) {
		this.attendees = attendees;
	}

	/**
	 * @return
	 * @uml.property  name="lastEdit"
	 */
	public Date getLastEdit() {
		return this.lastEdit;
	}

	/**
	 * @param lastEdit
	 * @uml.property  name="lastEdit"
	 */
	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}

	/**
	 * @param type  the type to set
	 * @uml.property  name="type"
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return  the type
	 * @uml.property  name="type"
	 */
	public String getType() {
		return type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Conference [conferenceDate=" + conferenceDate + ", name="
				+ name + "]";
	}

	@Override
	public int compare(Conference o1, Conference o2) {
		return o1.getName().compareTo(o2.getName())
				& o1.getType().compareTo(o2.getType())
				& o1.getConferenceDate().compareTo(o2.getConferenceDate());

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
		result = prime * result
				+ ((conferenceDate == null) ? 0 : conferenceDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((lastEdit == null) ? 0 : lastEdit.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (!(obj instanceof Conference)) {
			return false;
		}
		Conference other = (Conference) obj;
		if (conferenceDate == null) {
			if (other.conferenceDate != null) {
				return false;
			}
		} else if (!conferenceDate.equals(other.conferenceDate)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (lastEdit == null) {
			if (other.lastEdit != null) {
				return false;
			}
		} else if (!lastEdit.equals(other.lastEdit)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (shortDesc == null) {
			if (other.shortDesc != null) {
				return false;
			}
		} else if (!shortDesc.equals(other.shortDesc)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}

}
