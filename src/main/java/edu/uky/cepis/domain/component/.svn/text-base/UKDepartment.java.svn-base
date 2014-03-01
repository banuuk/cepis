/**
 * 
 */
package edu.uky.cepis.domain.component;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author  keerthi
 */
public class UKDepartment implements Comparator<UKDepartment>, Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @uml.property  name="departmentCode"
	 */
	private String departmentCode;
	
	/**
	 * @uml.property  name="departmentName"
	 */
	private String departmentName;
	
	/**
	 * @uml.property  name="departmentAddress"
	 */
	private String departmentAddress;
	
	/**
	 * @uml.property  name="speedSort"
	 */
	private String speedSort;
	
	/**
	 * @uml.property  name="departmentChairName"
	 */
	private String departmentChairName;
	
	/**
	 * @uml.property  name="departmentContact"
	 */
	private String departmentContact;
	
	/**
	 * @uml.property  name="shortDescription"
	 */
	private String shortDescription;
	
	/**
	 * @uml.property  name="status"
	 */
	private String status;

	public UKDepartment() {

	}

	/**
	 * @param departmentCode
	 * @param departmentName
	 * @param departmentAddress
	 * @param speedSort
	 * @param departmentChairName
	 * @param departmentContact
	 * @param shortDescription
	 * @param status
	 */
	public UKDepartment(String departmentCode, String departmentName,
			String departmentAddress, String speedSort,
			String departmentChairName, String departmentContact,
			String shortDescription, String status) {
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
		this.departmentAddress = departmentAddress;
		this.speedSort = speedSort;
		this.departmentChairName = departmentChairName;
		this.departmentContact = departmentContact;
		this.shortDescription = shortDescription;
		this.status = status;
	}

	/**
	 * @return  the departmentCode
	 * @uml.property  name="departmentCode"
	 */
	public String getDepartmentCode() {
		return departmentCode;
	}

	/**
	 * @param departmentCode  the departmentCode to set
	 * @uml.property  name="departmentCode"
	 */
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	/**
	 * @return  the departmentName
	 * @uml.property  name="departmentName"
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName  the departmentName to set
	 * @uml.property  name="departmentName"
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return  the departmentAddress
	 * @uml.property  name="departmentAddress"
	 */
	public String getDepartmentAddress() {
		return departmentAddress;
	}

	/**
	 * @param departmentAddress  the departmentAddress to set
	 * @uml.property  name="departmentAddress"
	 */
	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}

	/**
	 * @return  the speedSort
	 * @uml.property  name="speedSort"
	 */
	public String getSpeedSort() {
		return speedSort;
	}

	/**
	 * @param speedSort  the speedSort to set
	 * @uml.property  name="speedSort"
	 */
	public void setSpeedSort(String speedSort) {
		this.speedSort = speedSort;
	}

	/**
	 * @return  the departmentChairName
	 * @uml.property  name="departmentChairName"
	 */
	public String getDepartmentChairName() {
		return departmentChairName;
	}

	/**
	 * @param departmentChairName  the departmentChairName to set
	 * @uml.property  name="departmentChairName"
	 */
	public void setDepartmentChairName(String departmentChairName) {
		this.departmentChairName = departmentChairName;
	}

	/**
	 * @return  the departmentContact
	 * @uml.property  name="departmentContact"
	 */
	public String getDepartmentContact() {
		return departmentContact;
	}

	/**
	 * @param departmentContact  the departmentContact to set
	 * @uml.property  name="departmentContact"
	 */
	public void setDepartmentContact(String departmentContact) {
		this.departmentContact = departmentContact;
	}

	/**
	 * @return  the shortDescription
	 * @uml.property  name="shortDescription"
	 */
	public String getShortDescription() {
		return shortDescription;
	}

	/**
	 * @param shortDescription  the shortDescription to set
	 * @uml.property  name="shortDescription"
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	/**
	 * @return  the status
	 * @uml.property  name="status"
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status  the status to set
	 * @uml.property  name="status"
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
				+ ((departmentAddress == null) ? 0 : departmentAddress
						.hashCode());
		result = prime
				* result
				+ ((departmentChairName == null) ? 0 : departmentChairName
						.hashCode());
		result = prime * result
				+ ((departmentCode == null) ? 0 : departmentCode.hashCode());
		result = prime
				* result
				+ ((departmentContact == null) ? 0 : departmentContact
						.hashCode());
		result = prime * result
				+ ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime
				* result
				+ ((shortDescription == null) ? 0 : shortDescription.hashCode());
		result = prime * result
				+ ((speedSort == null) ? 0 : speedSort.hashCode());
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
		if (!(obj instanceof UKDepartment)) {
			return false;
		}
		UKDepartment other = (UKDepartment) obj;
		if (departmentAddress == null) {
			if (other.departmentAddress != null) {
				return false;
			}
		} else if (!departmentAddress.equals(other.departmentAddress)) {
			return false;
		}
		if (departmentChairName == null) {
			if (other.departmentChairName != null) {
				return false;
			}
		} else if (!departmentChairName.equals(other.departmentChairName)) {
			return false;
		}
		if (departmentCode == null) {
			if (other.departmentCode != null) {
				return false;
			}
		} else if (!departmentCode.equals(other.departmentCode)) {
			return false;
		}
		if (departmentContact == null) {
			if (other.departmentContact != null) {
				return false;
			}
		} else if (!departmentContact.equals(other.departmentContact)) {
			return false;
		}
		if (departmentName == null) {
			if (other.departmentName != null) {
				return false;
			}
		} else if (!departmentName.equals(other.departmentName)) {
			return false;
		}
		if (shortDescription == null) {
			if (other.shortDescription != null) {
				return false;
			}
		} else if (!shortDescription.equals(other.shortDescription)) {
			return false;
		}
		if (speedSort == null) {
			if (other.speedSort != null) {
				return false;
			}
		} else if (!speedSort.equals(other.speedSort)) {
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return departmentName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(UKDepartment o1, UKDepartment o2) {
		return o1.getDepartmentCode().compareTo(o2.getDepartmentCode());
	}

}
