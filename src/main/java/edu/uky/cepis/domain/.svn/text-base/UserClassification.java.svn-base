/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author keerthi
 */
public class UserClassification implements Comparator<UserClassification>,
		Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="classificationCode"
	 */
	private String classificationCode;
	/**
	 * @uml.property  name="shortDesc"
	 */
	private String shortDesc;
	/**
	 * @uml.property  name="description"
	 */
	private String description;
	/**
	 * @uml.property  name="status"
	 */
	private String status;

	/**
	 * 
	 */
	public UserClassification() {
	}

	/**
	 * @param classificationCode
	 * @param shortDesc
	 * @param description
	 * @param status
	 */
	public UserClassification(String classificationCode, String shortDesc,
			String description, String status) {
		this.classificationCode = classificationCode;
		this.shortDesc = shortDesc;
		this.description = description;
		this.status = status;
	}

	/**
	 * @return the classificationCode
	 * @uml.property name="classificationCode"
	 */
	public String getClassificationCode() {
		return classificationCode;
	}

	/**
	 * @param classificationCode
	 *            the classificationCode to set
	 * @uml.property name="classificationCode"
	 */
	public void setClassificationCode(String classificationCode) {
		this.classificationCode = classificationCode;
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
	 * @return the description
	 * @uml.property name="description"
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 * @uml.property name="description"
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the status
	 * @uml.property name="status"
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 * @uml.property name="status"
	 */
	public void setStatus(String status) {
		this.status = status;
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
				+ ((classificationCode == null) ? 0 : classificationCode
						.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (!(obj instanceof UserClassification)) {
			return false;
		}
		UserClassification other = (UserClassification) obj;
		if (classificationCode == null) {
			if (other.classificationCode != null) {
				return false;
			}
		} else if (!classificationCode.equals(other.classificationCode)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (shortDesc == null) {
			if (other.shortDesc != null) {
				return false;
			}
		} else if (!shortDesc.equals(other.shortDesc)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
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
		return shortDesc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(UserClassification o1, UserClassification o2) {
		return o1.classificationCode.compareTo(o2.getClassificationCode());
	}

}
