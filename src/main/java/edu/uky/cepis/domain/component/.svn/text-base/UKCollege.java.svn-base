/**
 * 
 */
package edu.uky.cepis.domain.component;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author  keerthi
 */
public class UKCollege implements Comparator<UKCollege>, Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @uml.property  name="ukCollegeCode"
	 */
	private String ukCollegeCode;

	/**
	 * @uml.property  name="collegeName"
	 */
	private String collegeName;

	/**
	 * @uml.property  name="collegeAddress"
	 */
	private String collegeAddress;
	
	/**
	 * @uml.property  name="collegeSpeedSort"
	 */
	private String collegeSpeedSort;

	/**
	 * @uml.property  name="collegePhone"
	 */
	private String collegePhone;

	/**
	 * @uml.property  name="collegeDeanName"
	 */
	private String collegeDeanName;
	
	/**
	 * @uml.property  name="departments"
	 */
	private Set<UKDepartment> departments = new HashSet<UKDepartment>(0);

	public UKCollege() {

	}

	/**
	 * @param ukCollegeCode
	 * @param collegeName
	 * @param collegeAddress
	 * @param collegeSpeedSort
	 * @param collegePhone
	 * @param collegeDeanName
	 */
	public UKCollege(String ukCollegeCode, String collegeName,
			String collegeAddress, String collegeSpeedSort,
			String collegePhone, String collegeDeanName) {
		this.ukCollegeCode = ukCollegeCode;
		this.collegeName = collegeName;
		this.collegeAddress = collegeAddress;
		this.collegeSpeedSort = collegeSpeedSort;
		this.collegePhone = collegePhone;
		this.collegeDeanName = collegeDeanName;
	}

	/**
	 * @return  the ukCollegeCode
	 * @uml.property  name="ukCollegeCode"
	 */
	public String getUkCollegeCode() {
		return ukCollegeCode;
	}

	/**
	 * @param ukCollegeCode  the ukCollegeCode to set
	 * @uml.property  name="ukCollegeCode"
	 */
	public void setUkCollegeCode(String ukCollegeCode) {
		this.ukCollegeCode = ukCollegeCode;
	}

	/**
	 * @return  the collegeName
	 * @uml.property  name="collegeName"
	 */
	public String getCollegeName() {
		return collegeName;
	}

	/**
	 * @param collegeName  the collegeName to set
	 * @uml.property  name="collegeName"
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	/**
	 * @return  the collegeAddress
	 * @uml.property  name="collegeAddress"
	 */
	public String getCollegeAddress() {
		return collegeAddress;
	}

	/**
	 * @param collegeAddress  the collegeAddress to set
	 * @uml.property  name="collegeAddress"
	 */
	public void setCollegeAddress(String collegeAddress) {
		this.collegeAddress = collegeAddress;
	}

	/**
	 * @return  the collegeSpeedSort
	 * @uml.property  name="collegeSpeedSort"
	 */
	public String getCollegeSpeedSort() {
		return collegeSpeedSort;
	}

	/**
	 * @param collegeSpeedSort  the collegeSpeedSort to set
	 * @uml.property  name="collegeSpeedSort"
	 */
	public void setCollegeSpeedSort(String collegeSpeedSort) {
		this.collegeSpeedSort = collegeSpeedSort;
	}

	/**
	 * @return  the collegePhone
	 * @uml.property  name="collegePhone"
	 */
	public String getCollegePhone() {
		return collegePhone;
	}

	/**
	 * @param collegePhone  the collegePhone to set
	 * @uml.property  name="collegePhone"
	 */
	public void setCollegePhone(String collegePhone) {
		this.collegePhone = collegePhone;
	}

	/**
	 * @return  the collegeDeanName
	 * @uml.property  name="collegeDeanName"
	 */
	public String getCollegeDeanName() {
		return collegeDeanName;
	}

	/**
	 * @param collegeDeanName  the collegeDeanName to set
	 * @uml.property  name="collegeDeanName"
	 */
	public void setCollegeDeanName(String collegeDeanName) {
		this.collegeDeanName = collegeDeanName;
	}

	/**
	 * @param departments  the departments to set
	 * @uml.property  name="departments"
	 */
	public void setDepartments(Set<UKDepartment> departments) {
		this.departments = departments;
	}

	/**
	 * @return  the departments
	 * @uml.property  name="departments"
	 */
	public Set<UKDepartment> getDepartments() {
		return departments;
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
				+ ((collegeAddress == null) ? 0 : collegeAddress.hashCode());
		result = prime * result
				+ ((collegeDeanName == null) ? 0 : collegeDeanName.hashCode());
		result = prime * result
				+ ((collegeName == null) ? 0 : collegeName.hashCode());
		result = prime * result
				+ ((collegePhone == null) ? 0 : collegePhone.hashCode());
		result = prime
				* result
				+ ((collegeSpeedSort == null) ? 0 : collegeSpeedSort.hashCode());
		result = prime * result
				+ ((ukCollegeCode == null) ? 0 : ukCollegeCode.hashCode());
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
		if (!(obj instanceof UKCollege)) {
			return false;
		}
		UKCollege other = (UKCollege) obj;
		if (collegeAddress == null) {
			if (other.collegeAddress != null) {
				return false;
			}
		} else if (!collegeAddress.equals(other.collegeAddress)) {
			return false;
		}
		if (collegeDeanName == null) {
			if (other.collegeDeanName != null) {
				return false;
			}
		} else if (!collegeDeanName.equals(other.collegeDeanName)) {
			return false;
		}
		if (collegeName == null) {
			if (other.collegeName != null) {
				return false;
			}
		} else if (!collegeName.equals(other.collegeName)) {
			return false;
		}
		if (collegePhone == null) {
			if (other.collegePhone != null) {
				return false;
			}
		} else if (!collegePhone.equals(other.collegePhone)) {
			return false;
		}
		if (collegeSpeedSort == null) {
			if (other.collegeSpeedSort != null) {
				return false;
			}
		} else if (!collegeSpeedSort.equals(other.collegeSpeedSort)) {
			return false;
		}
		if (ukCollegeCode == null) {
			if (other.ukCollegeCode != null) {
				return false;
			}
		} else if (!ukCollegeCode.equals(other.ukCollegeCode)) {
			return false;
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return collegeName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(UKCollege o1, UKCollege o2) {
		return o1.getUkCollegeCode().compareTo(o2.getUkCollegeCode());
	}

}
