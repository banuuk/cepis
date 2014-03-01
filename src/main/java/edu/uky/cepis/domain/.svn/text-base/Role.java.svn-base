
package edu.uky.cepis.domain;

// Generated Jan 24, 2010 3:37:43 PM by Hibernate Tools 3.2.4.GA

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IndexColumn;

/**
 * Role Class to store the role information of a user
 * 
 * @author cawalk4
 *
 */
@Entity
@Table(name="lstRole")
@Cache(region="edu.uky.cepis.cache.role", usage=CacheConcurrencyStrategy.READ_WRITE)
public class Role implements java.util.Comparator<Role>, java.io.Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "incrementGen", strategy = "increment")  
    @GeneratedValue(generator = "incrementGen")  
	@Column(name="ID")
	private long roleid;

	@Column(name="NAME", length = 255)
	private String rolename;

	@Column(name="DESCRIPTION")
	private String roledesc;
	
	@Column(name="OTHERINFO")
	private String otherInfo;

	@Column(name="PURGE")
	private boolean purge;

	@ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy="roles", targetEntity = User.class)
	@IndexColumn(name = "user_index", base = 0)
	private List<User> users = new ArrayList<User>(0);

	public Role() {
	}

	public Role(String rolename, String roledesc) {
		this.rolename = rolename;
		this.roledesc = roledesc;
	}

	public Role(String rolename, String roledesc, String otherInfo) {
		this.rolename = rolename;
		this.roledesc = roledesc;
		this.otherInfo = otherInfo;
	}
	
	
	/**
	 * @return
	 * @uml.property name="roleid"
	 */
	public long getRoleid() {
		return this.roleid;
	}

	/**
	 * @param roleid
	 * @uml.property name="roleid"
	 */
	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}

	/**
	 * @return
	 * @uml.property name="rolename"
	 */
	public String getRolename() {
		return this.rolename;
	}

	/**
	 * @param rolename
	 * @uml.property name="rolename"
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * @return
	 * @uml.property name="roledesc"
	 */
	public String getRoledesc() {
		return this.roledesc;
	}

	/**
	 * @param roledesc
	 * @uml.property name="roledesc"
	 */
	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	/**
	 * @return
	 * @uml.property name="otherInfo"
	 */
	public String getOtherInfo() {
		return this.otherInfo;
	}

	/**
	 * @param otherInfo
	 * @uml.property name="otherInfo"
	 */
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	/**
	 * @param purge
	 *            the purge to set
	 * @uml.property name="purge"
	 */
	public void setPurge(boolean purge) {
		this.purge = purge;
	}

	/**
	 * @return the purge
	 * @uml.property name="purge"
	 */
	public boolean isPurge() {
		return purge;
	}

	/**
	 * @return
	 * @uml.property name="users"
	 */
	public List<User> getUsers() {
		return this.users;
	}

	/**
	 * @param users
	 * @uml.property name="users"
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public int compare(Role o1, Role o2) {
		return o1.getRolename().compareTo(o2.getRolename());
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
				+ ((otherInfo == null) ? 0 : otherInfo.hashCode());
		result = prime * result
				+ ((roledesc == null) ? 0 : roledesc.hashCode());
		result = prime * result + (int) (roleid ^ (roleid >>> 32));
		result = prime * result
				+ ((rolename == null) ? 0 : rolename.hashCode());
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
		if (!(obj instanceof Role)) {
			return false;
		}
		Role other = (Role) obj;
		if (otherInfo == null) {
			if (other.otherInfo != null) {
				return false;
			}
		} else if (!otherInfo.equals(other.otherInfo)) {
			return false;
		}
		if (roledesc == null) {
			if (other.roledesc != null) {
				return false;
			}
		} else if (!roledesc.equals(other.roledesc)) {
			return false;
		}
		if (roleid != other.roleid) {
			return false;
		}
		if (rolename == null) {
			if (other.rolename != null) {
				return false;
			}
		} else if (!rolename.equals(other.rolename)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role: " + this.getRolename() + " (" + this.getRoledesc() + ")";
	}

}
