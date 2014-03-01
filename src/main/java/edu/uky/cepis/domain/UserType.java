/**
 * 
 */
package edu.uky.cepis.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @author  keerthi
 */
public class UserType implements java.io.Serializable,
		java.util.Comparator<UserType> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="typeCode"
	 */
	private String typeCode;
	/**
	 * @uml.property  name="shortDesc"
	 */
	private String shortDesc;
	/**
	 * @uml.property  name="userClassifications"
	 */
	private Set<UserClassification> userClassifications = new HashSet<UserClassification>(
			0);

	/**
	 * 
	 */
	public UserType() {
	}

	/**
	 * @param typeCode
	 * @param shortDesc
	 */
	public UserType(String typeCode, String shortDesc) {

		this.setTypeCode(typeCode);
		this.shortDesc = shortDesc;
	}

	/**
	 * @param typeCode
	 *            the typeCode to set
	 * @uml.property name="typeCode"
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	/**
	 * @return the typeCode
	 * @uml.property name="typeCode"
	 */
	public String getTypeCode() {
		return typeCode;
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

	/**
	 * @return  the userClassifications
	 * @uml.property  name="userClassifications"
	 */
	public Set<UserClassification> getUserClassifications() {
		return userClassifications;
	}

	/**
	 * @param userClassifications  the userClassifications to set
	 * @uml.property  name="userClassifications"
	 */
	public void setUserClassifications(
			Set<UserClassification> userClassifications) {
		this.userClassifications = userClassifications;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return shortDesc;
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
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
		result = prime * result
				+ ((typeCode == null) ? 0 : typeCode.hashCode());
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
		if (!(obj instanceof UserType)) {
			return false;
		}
		UserType other = (UserType) obj;
		if (shortDesc == null) {
			if (other.shortDesc != null) {
				return false;
			}
		} else if (!shortDesc.equals(other.shortDesc)) {
			return false;
		}
		if (typeCode == null) {
			if (other.typeCode != null) {
				return false;
			}
		} else if (!typeCode.equals(other.typeCode)) {
			return false;
		}
		return true;
	}

	@Override
	public int compare(UserType o1, UserType o2) {
		return o1.getTypeCode().compareTo(o2.getTypeCode());
	}

}
