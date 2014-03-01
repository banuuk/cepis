package edu.uky.cepis.domain;

// Generated Jan 24, 2010 3:37:43 PM by Hibernate Tools 3.2.4.GA

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * LastLogin class has a history of Last login time, attempts etc.
 * 
 * @author cawalk4
 */
@Entity
@Table(name="tbl20LastLogin")
@Cache(region="edu.uky.cepis.cache.lastlogin", usage=CacheConcurrencyStrategy.READ_WRITE)
public class LastLogin implements java.util.Comparator<LastLogin>,
		java.io.Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int lastloginId;


	@Column(name="SqlDate")
	private Date lastLogin;


	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.lastlogin")
	@ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "lastlogins")
	@IndexColumn(name = "user_index", base = 0)
	@NotFound(action=NotFoundAction.IGNORE)	
	private List<User> users = new ArrayList<User>(0);

	
	
	public LastLogin() {
	}

	public LastLogin(Date date) {
		this.lastLogin = date;
	}

	/**
	 * @return
	 * @uml.property name="lastloginId"
	 */
	public int getLastloginId() {
		return this.lastloginId;
	}

	/**
	 * @param lastloginId
	 * @uml.property name="lastloginId"
	 */
	public void setLastloginId(int lastloginId) {
		this.lastloginId = lastloginId;
	}

	/**
	 * @return
	 * @uml.property name="lastLogin"
	 */
	public Date getLastLogin() {
		return this.lastLogin;
	}

	/**
	 * @param lastLogin
	 * @uml.property name="lastLogin"
	 */
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
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

	public String toString() {
		return "Login time: " + getLastLogin();
	}

	@Override
	public int compare(LastLogin o1, LastLogin o2) {
		return o1.lastLogin.compareTo(o2.lastLogin);
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
				+ ((lastLogin == null) ? 0 : lastLogin.hashCode());
		result = prime * result + lastloginId;
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
		if (!(obj instanceof LastLogin)) {
			return false;
		}
		LastLogin other = (LastLogin) obj;
		if (lastLogin == null) {
			if (other.lastLogin != null) {
				return false;
			}
		} else if (!lastLogin.equals(other.lastLogin)) {
			return false;
		}
		if (lastloginId != other.lastloginId) {
			return false;
		}
		return true;
	}

}
