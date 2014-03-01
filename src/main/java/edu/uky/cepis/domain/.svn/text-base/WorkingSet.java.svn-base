package edu.uky.cepis.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * WorkingSet class stores a set of {@link User} object which has similar in
 * functionality to a ShoppingCart.
 * 
 * @author keerthi
 * 
 */
public class WorkingSet implements java.io.Serializable,
		java.util.Comparator<WorkingSet> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String createdBy;
	private Date dateCreated;
	private Date dateModified;
	private String desc;
	private String name;
	private boolean public_status;
	private boolean shared_mode;
	private Set<SharedUser> sharedUsers = new HashSet<SharedUser>(0);
	private Set<User> users = new HashSet<User>(0);
	private long wid;

	/**
	 * 
	 */
	public WorkingSet() {
	}

	/**
	 * @param name
	 * @param desc
	 * @param createdBy
	 * @param publicStatus
	 * @param shared_mode
	 */
	public WorkingSet(String name, String desc, String createdBy,
			boolean publicStatus, boolean shared_mode) {
		this.name = name;
		this.desc = desc;
		this.dateCreated = new Date();
		this.dateModified = new Date();
		this.createdBy = createdBy;
		this.public_status = publicStatus;
		this.shared_mode = shared_mode;
	}

	@Override
	public int compare(WorkingSet o1, WorkingSet o2) {
		return o1.getDateModified().compareTo(o2.getDateModified());
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
		WorkingSet other = (WorkingSet) obj;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (public_status != other.public_status)
			return false;
		if (shared_mode != other.shared_mode)
			return false;
		if (wid != other.wid)
			return false;
		return true;
	}

	/**
	 * @return
	 * @uml.property name="createdBy"
	 */
	public String getCreatedBy() {
		return this.createdBy;
	}

	/**
	 * @return
	 * @uml.property name="dateCreated"
	 */
	public Date getDateCreated() {
		return this.dateCreated;
	}

	/**
	 * @return
	 * @uml.property name="dateModified"
	 */
	public Date getDateModified() {
		return this.dateModified;
	}

	/**
	 * @return
	 * @uml.property name="desc"
	 */
	public String getDesc() {
		return this.desc;
	}

	/**
	 * @return
	 * @uml.property name="name"
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the sharedUsers
	 * @uml.property name="sharedUsers"
	 */
	public Set<SharedUser> getSharedUsers() {
		return sharedUsers;
	}

	/**
	 * @return
	 * @uml.property name="users"
	 */
	public Set<User> getUsers() {
		return this.users;
	}

	/**
	 * @return
	 * @uml.property name="wid"
	 */
	public long getWid() {
		return this.wid;
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
				+ ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (public_status ? 1231 : 1237);
		result = prime * result + (shared_mode ? 1231 : 1237);
		result = prime * result + (int) (wid ^ (wid >>> 32));
		return result;
	}

	/**
	 * @return
	 * @uml.property name="public_status"
	 */
	public boolean isPublic_status() {
		return this.public_status;
	}

	/**
	 * @return
	 * @uml.property name="shared_mode"
	 */
	public boolean isShared_mode() {
		return this.shared_mode;
	}

	/**
	 * @param createdBy
	 * @uml.property name="createdBy"
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @param dateCreated
	 * @uml.property name="dateCreated"
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @param dateModified
	 * @uml.property name="dateModified"
	 */
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	/**
	 * @param desc
	 * @uml.property name="desc"
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @param name
	 * @uml.property name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param public_status
	 * @uml.property name="public_status"
	 */
	public void setPublic_status(boolean public_status) {
		this.public_status = public_status;
	}

	/**
	 * @param shared_mode
	 * @uml.property name="shared_mode"
	 */
	public void setShared_mode(boolean shared_mode) {
		this.shared_mode = shared_mode;
	}

	/**
	 * @param sharedUsers
	 *            the sharedUsers to set
	 * @uml.property name="sharedUsers"
	 */
	public void setSharedUsers(Set<SharedUser> sharedUsers) {
		this.sharedUsers = sharedUsers;
	}

	/**
	 * @param users
	 * @uml.property name="users"
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	/**
	 * @param wid
	 * @uml.property name="wid"
	 */
	public void setWid(long wid) {
		this.wid = wid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getName();
	}

}
