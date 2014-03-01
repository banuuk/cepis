package edu.uky.cepis.domain;

// Generated Jun 20, 2011 3:36:15 PM by Hibernate Tools 3.3.0.GA

import java.util.Date;

/**
 * Attendee class contains CEPIS conference attendee details
 */
public class Attendee implements java.io.Serializable,
		java.util.Comparator<Attendee> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private User user;
	private boolean attended;
	private String shortDesc;
	private Date lastEdit;

	public Attendee() {
	}

	public Attendee(User user, boolean attended, String shortDesc) {
		this.user = user;
		this.attended = attended;
		this.shortDesc = shortDesc;
		this.lastEdit = new Date();
	}

	/**
	 * @return
	 * @uml.property name="id"
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * @param id
	 * @uml.property name="id"
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return
	 * @uml.property name="user"
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * @param user
	 * @uml.property name="user"
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return
	 * @uml.property name="attended"
	 */
	public boolean getAttended() {
		return this.attended;
	}

	/**
	 * @param attended
	 * @uml.property name="attended"
	 */
	public void setAttended(boolean attended) {
		this.attended = attended;
	}

	/**
	 * @return
	 * @uml.property name="shortDesc"
	 */
	public String getShortDesc() {
		return this.shortDesc;
	}

	/**
	 * @param shortDesc
	 * @uml.property name="shortDesc"
	 */
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	/**
	 * @return
	 * @uml.property name="lastEdit"
	 */
	public Date getLastEdit() {
		return this.lastEdit;
	}

	/**
	 * @param lastEdit
	 * @uml.property name="lastEdit"
	 */
	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}

	@Override
	public int compare(Attendee arg0, Attendee arg1) {
		return arg0.user.getFullName().compareTo(arg1.user.getFullName());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return user.getFullName();
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
		result = prime * result + (attended ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attendee other = (Attendee) obj;
		if (attended != other.attended)
			return false;
		if (id != other.id)
			return false;
		if (shortDesc == null) {
			if (other.shortDesc != null)
				return false;
		} else if (!shortDesc.equals(other.shortDesc))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
