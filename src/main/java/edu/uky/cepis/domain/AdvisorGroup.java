/**
 * 
 */
package edu.uky.cepis.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author  keerthi
 */
public class AdvisorGroup implements java.io.Serializable,
		java.util.Comparator<AdvisorGroup> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	/**
	 * @uml.property  name="name"
	 */
	private String name;

	/**
	 * @uml.property  name="shortDesc"
	 */
	private String shortDesc;
	
	private Date lastEdit;

	private Set<Advisor> advisors = new HashSet<Advisor>(
			0);

	/**
	 * 
	 */
	public AdvisorGroup() {
	}

	/**
	 * @param name
	 * @param shortDesc
	 * @param lastEdit
	 */
	public AdvisorGroup(String name, String shortDesc) {
		this.name = name;
		this.shortDesc = shortDesc;
		this.lastEdit = new Date();
	}

	



	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the lastEdit
	 */
	public Date getLastEdit() {
		return lastEdit;
	}

	/**
	 * @return the advisors
	 */
	public Set<Advisor> getAdvisors() {
		return advisors;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param lastEdit the lastEdit to set
	 */
	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}

	/**
	 * @param advisors the advisors to set
	 */
	public void setAdvisors(Set<Advisor> advisors) {
		this.advisors = advisors;
	}

	/**
	 * @return the shortDesc
	 * @uml.property name="shortDesc"
	 */
	public String getShortDesc() {
		return shortDesc;
	}

	/**
	 * @param shortDesc
	 *            the shortDesc to set
	 * @uml.property name="shortDesc"
	 */
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		if (!(obj instanceof AdvisorGroup)) {
			return false;
		}
		AdvisorGroup other = (AdvisorGroup) obj;
		if (id != other.id) {
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
		return true;
	}

	@Override
	public int compare(AdvisorGroup o1, AdvisorGroup o2) {
		return (int) (o1.getId()-o2.getId());
	}
	
}
