package edu.uky.cepis.domain;

// Generated Jan 24, 2010 3:37:43 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @author keerthi
 * Query class to store the search parameters. 
 */
public class Query implements java.io.Serializable,
		java.util.Comparator<Query> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property name="wid"
	 */
	private long sid;
	/**
	 * @uml.property name="name"
	 */
	private String name;
	/**
	 * @uml.property name="desc"
	 */
	private String desc;
	/**
	 * @uml.property name="dateCreated"
	 */
	private Date dateCreated;
	/**
	 * @uml.property name="dateModified"
	 */
	private Date dateModified;
	/**
	 * @uml.property name="createdBy"
	 */
	private String createdBy;
	/**
	 * @uml.property name="public_status"
	 */
	private DetachedCriteria query;

	/**
	 * 
	 */
	public Query() {
	}

	/**
	 * @param dateCreated
	 * @param dateModified
	 * @param createdBy
	 * @param name
	 * @param desc
	 */
	public Query(String name, String desc,String createdBy) {
		this.dateCreated = new Date();
		this.dateModified = new Date();
		this.createdBy = createdBy;
		this.name = name;
		this.desc = desc;
	}

	/**
	 * @return
	 * @uml.property name="sid"
	 */
	public long getSid() {
		return this.sid;
	}

	/**
	 * @param wid
	 * @uml.property name="wid"
	 */
	public void setSid(long sid) {
		this.sid = sid;
	}

	/**
	 * @return
	 * @uml.property name="name"
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 * @uml.property name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 * @uml.property name="desc"
	 */
	public String getDesc() {
		return this.desc;
	}

	/**
	 * @param desc
	 * @uml.property name="desc"
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return
	 * @uml.property name="dateCreated"
	 */
	public Date getDateCreated() {
		return this.dateCreated;
	}

	/**
	 * @param dateCreated
	 * @uml.property name="dateCreated"
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return
	 * @uml.property name="dateModified"
	 */
	public Date getDateModified() {
		return this.dateModified;
	}

	/**
	 * @param dateModified
	 * @uml.property name="dateModified"
	 */
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	/**
	 * @return
	 * @uml.property name="createdBy"
	 */
	public String getCreatedBy() {
		return this.createdBy;
	}

	/**
	 * @param createdBy
	 * @uml.property name="createdBy"
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Query: created on" + this.getDateCreated() + " Name:"
				+ this.getName();
	}

	/**
	 * @param query
	 *            the query to set
	 */
	public void setQuery(DetachedCriteria query) {
		this.query = query;
	}

	/**
	 * @return the query
	 */
	public DetachedCriteria getQuery() {
		return query;
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
		result = prime * result
				+ ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result
				+ ((dateModified == null) ? 0 : dateModified.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (sid ^ (sid >>> 32));
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
		if (!(obj instanceof Query)) {
			return false;
		}
		Query other = (Query) obj;
		if (createdBy == null) {
			if (other.createdBy != null) {
				return false;
			}
		} else if (!createdBy.equals(other.createdBy)) {
			return false;
		}
		if (dateCreated == null) {
			if (other.dateCreated != null) {
				return false;
			}
		} else if (!dateCreated.equals(other.dateCreated)) {
			return false;
		}
		if (dateModified == null) {
			if (other.dateModified != null) {
				return false;
			}
		} else if (!dateModified.equals(other.dateModified)) {
			return false;
		}
		if (desc == null) {
			if (other.desc != null) {
				return false;
			}
		} else if (!desc.equals(other.desc)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (sid != other.sid) {
			return false;
		}
		return true;
	}

	@Override
	public int compare(Query o1, Query o2) {
		return o1.getName().compareTo(o2.getName())
				& o1.getDateModified().compareTo(o2.getDateModified());
	}

}
