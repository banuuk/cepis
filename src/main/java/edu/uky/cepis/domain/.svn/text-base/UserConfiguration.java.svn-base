/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author  keerthi
 */
public class UserConfiguration implements Serializable,
		Comparator<UserConfiguration> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long configurationId;
	/**
	 * @uml.property  name="primaryEmail"
	 * @uml.associationEnd  
	 */
	private EmailAddress primaryEmail;
	/**
	 * @uml.property  name="activeWorkingSet"
	 * @uml.associationEnd  
	 */
	private WorkingSet activeWorkingSet;
	/**
	 * @uml.property  name="primaryAddress"
	 * @uml.associationEnd  
	 */
	private Address primaryAddress;
	/**
	 * @uml.property  name="primaryPhone"
	 * @uml.associationEnd  
	 */
	private Phone primaryPhone;
	/**
	 * @uml.property  name="primaryUserType"
	 * @uml.associationEnd  
	 */
	private UserType primaryUserType;
	private boolean rememberLastWorkingSet;

	private int rowCount = 25;
	private int searchCount = 200;

	/**
	 * 
	 */
	public UserConfiguration() {
	}

	/**
	 * @param primaryEmail
	 * @param activeWorkingSet
	 * @param primaryAddress
	 * @param primaryPhone
	 * @param primaryUserType
	 * @param rememberLastWorkingSet
	 */
	public UserConfiguration(EmailAddress primaryEmail,
			WorkingSet activeWorkingSet, Address primaryAddress,
			Phone primaryPhone, UserType primaryUserType,
			boolean rememberLastWorkingSet) {
		this.primaryEmail = primaryEmail;
		this.activeWorkingSet = activeWorkingSet;
		this.primaryAddress = primaryAddress;
		this.primaryPhone = primaryPhone;
		this.primaryUserType = primaryUserType;
		this.rememberLastWorkingSet = rememberLastWorkingSet;
	}
	

	/**
	 * @return  the configurationId
	 * @uml.property  name="configurationId"
	 */
	public long getConfigurationId() {
		return configurationId;
	}

	/**
	 * @param configurationId  the configurationId to set
	 * @uml.property  name="configurationId"
	 */
	public void setConfigurationId(long configurationId) {
		this.configurationId = configurationId;
	}

	/**
	 * @param primaryEmail
	 *            the primaryEmail to set
	 * @uml.property name="primaryEmail"
	 */
	public void setPrimaryEmail(EmailAddress primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	/**
	 * @return the primaryEmail
	 * @uml.property name="primaryEmail"
	 */
	public EmailAddress getPrimaryEmail() {
		return primaryEmail;
	}

	/**
	 * @return  the primaryAddress
	 * @uml.property  name="primaryAddress"
	 */
	public Address getPrimaryAddress() {
		return primaryAddress;
	}

	/**
	 * @param primaryAddress  the primaryAddress to set
	 * @uml.property  name="primaryAddress"
	 */
	public void setPrimaryAddress(Address primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	/**
	 * @return  the primaryPhone
	 * @uml.property  name="primaryPhone"
	 */
	public Phone getPrimaryPhone() {
		return primaryPhone;
	}

	/**
	 * @param primaryPhone  the primaryPhone to set
	 * @uml.property  name="primaryPhone"
	 */
	public void setPrimaryPhone(Phone primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	/**
	 * @param activeWorkingSet  the activeWorkingSet to set
	 * @uml.property  name="activeWorkingSet"
	 */
	public void setActiveWorkingSet(WorkingSet activeWorkingSet) {
		this.activeWorkingSet = activeWorkingSet;
	}

	/**
	 * @return  the activeWorkingSet
	 * @uml.property  name="activeWorkingSet"
	 */
	public WorkingSet getActiveWorkingSet() {
		return activeWorkingSet;
	}

	/**
	 * @return  the primaryUserType
	 * @uml.property  name="primaryUserType"
	 */
	public UserType getPrimaryUserType() {
		return primaryUserType;
	}

	/**
	 * @param primaryUserType  the primaryUserType to set
	 * @uml.property  name="primaryUserType"
	 */
	public void setPrimaryUserType(UserType primaryUserType) {
		this.primaryUserType = primaryUserType;
	}

	/**
	 * @return  the rememberLastWorkingSet
	 * @uml.property  name="rememberLastWorkingSet"
	 */
	public boolean isRememberLastWorkingSet() {
		return rememberLastWorkingSet;
	}

	/**
	 * @param rememberLastWorkingSet  the rememberLastWorkingSet to set
	 * @uml.property  name="rememberLastWorkingSet"
	 */
	public void setRememberLastWorkingSet(boolean rememberLastWorkingSet) {
		this.rememberLastWorkingSet = rememberLastWorkingSet;
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
		result = prime
				* result
				+ ((activeWorkingSet == null) ? 0 : activeWorkingSet.hashCode());
		result = prime * result
				+ (int) (configurationId ^ (configurationId >>> 32));
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
		if (!(obj instanceof UserConfiguration)) {
			return false;
		}
		UserConfiguration other = (UserConfiguration) obj;
		if (activeWorkingSet == null) {
			if (other.activeWorkingSet != null) {
				return false;
			}
		} else if (!activeWorkingSet.equals(other.activeWorkingSet)) {
			return false;
		}
		if (configurationId != other.configurationId) {
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
		return "UserConfiguration [activeWorkingSet=" + activeWorkingSet
				+ ", configurationId=" + configurationId + ", primaryAddress="
				+ primaryAddress + ", primaryEmail=" + primaryEmail
				+ ", primaryPhone=" + primaryPhone + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(UserConfiguration o1, UserConfiguration o2) {
		return o1.getActiveWorkingSet().compare(o1.getActiveWorkingSet(),
				o2.getActiveWorkingSet())
				& o1.getPrimaryEmail().compare(o1.getPrimaryEmail(),
						o2.getPrimaryEmail())
				& o1.getPrimaryAddress().compare(o1.getPrimaryAddress(),
						o2.getPrimaryAddress())
				& o1.getPrimaryPhone().compare(o1.getPrimaryPhone(),
						o2.getPrimaryPhone());
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getSearchCount() {
		return searchCount;
	}

	public void setSearchCount(int searchCount) {
		this.searchCount = searchCount;
	}

}
