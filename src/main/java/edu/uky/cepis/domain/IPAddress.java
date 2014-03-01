package edu.uky.cepis.domain;

// Generated Jan 24, 2010 3:37:43 PM by Hibernate Tools 3.2.4.GA

import java.util.ArrayList;
import java.util.List;

/**
 * Class that stores the IP Address and other client information
 */
public class IPAddress implements java.util.Comparator<IPAddress>,
		java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="id"
	 */
	private long id;
	/**
	 * @uml.property  name="ipAddr"
	 */
	private String ipAddr;
	/**
	 * @uml.property  name="clientInfo"
	 */
	private String clientInfo;
	/**
	 * @uml.property  name="users"
	 */
	private List<User> users = new ArrayList<User>(0);

	public IPAddress() {
	}

	public IPAddress(String ipAddr, String clientInfo) {
		this.ipAddr = ipAddr;
		this.clientInfo = clientInfo;
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
	 * @uml.property name="ipAddr"
	 */
	public String getIpAddr() {
		return this.ipAddr;
	}

	/**
	 * @param ipAddr
	 * @uml.property name="ipAddr"
	 */
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	/**
	 * @return
	 * @uml.property name="clientInfo"
	 */
	public String getClientInfo() {
		return this.clientInfo;
	}

	/**
	 * @param clientInfo
	 * @uml.property name="clientInfo"
	 */
	public void setClientInfo(String clientInfo) {
		this.clientInfo = clientInfo;
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
	public int compare(IPAddress o1, IPAddress o2) {
		return o1.ipAddr.compareTo(o2.ipAddr);
	}

	@Override
	public String toString() {
		return "At IP address:" + this.getIpAddr() + " Client Information:"
				+ this.getClientInfo();
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
				+ ((clientInfo == null) ? 0 : clientInfo.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((ipAddr == null) ? 0 : ipAddr.hashCode());
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
		if (!(obj instanceof IPAddress)) {
			return false;
		}
		IPAddress other = (IPAddress) obj;
		if (clientInfo == null) {
			if (other.clientInfo != null) {
				return false;
			}
		} else if (!clientInfo.equals(other.clientInfo)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (ipAddr == null) {
			if (other.ipAddr != null) {
				return false;
			}
		} else if (!ipAddr.equals(other.ipAddr)) {
			return false;
		}
		return true;
	}

}
