/**
 * 
 */
package edu.uky.cepis.domain.component;

/**
 * @author  keerthi
 */
public class UKMajor implements java.io.Serializable,java.util.Comparator<UKMajor> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="ukMajorCode"
	 */
	private String ukMajorCode;
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
	 * @uml.property  name="degreeLevel"
	 */
	private String degreeLevel;
	
	
	
	
	/**
	 * 
	 */
	public UKMajor() {
	}
	/**
	 * @param ukmajorid
	 * @param ukMajorCode
	 * @param shortDesc
	 * @param description
	 * @param status
	 * @param degreeLevel
	 */
	public UKMajor(String ukMajorCode, String shortDesc,
			String description, String status, String degreeLevel) {

		this.ukMajorCode = ukMajorCode;
		this.shortDesc = shortDesc;
		this.description = description;
		this.status = status;
		this.degreeLevel = degreeLevel;
	}
	/**
	 * @return  the ukMajorCode
	 * @uml.property  name="ukMajorCode"
	 */
	public String getUkMajorCode() {
		return ukMajorCode;
	}
	/**
	 * @param ukMajorCode  the ukMajorCode to set
	 * @uml.property  name="ukMajorCode"
	 */
	public void setUkMajorCode(String ukMajorCode) {
		this.ukMajorCode = ukMajorCode;
	}
	/**
	 * @return  the shortDesc
	 * @uml.property  name="shortDesc"
	 */
	public String getShortDesc() {
		return shortDesc;
	}
	/**
	 * @param shortDesc  the shortDesc to set
	 * @uml.property  name="shortDesc"
	 */
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	/**
	 * @return  the description
	 * @uml.property  name="description"
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description  the description to set
	 * @uml.property  name="description"
	 */
	public void setDescription(String description) {
		this.description = description;
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
	/**
	 * @return  the degreeLevel
	 * @uml.property  name="degreeLevel"
	 */
	public String getDegreeLevel() {
		return degreeLevel;
	}
	/**
	 * @param degreeLevel  the degreeLevel to set
	 * @uml.property  name="degreeLevel"
	 */
	public void setDegreeLevel(String degreeLevel) {
		this.degreeLevel = degreeLevel;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return shortDesc ;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((degreeLevel == null) ? 0 : degreeLevel.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((ukMajorCode == null) ? 0 : ukMajorCode.hashCode());
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
		if (!(obj instanceof UKMajor)) {
			return false;
		}
		UKMajor other = (UKMajor) obj;
		if (degreeLevel == null) {
			if (other.degreeLevel != null) {
				return false;
			}
		} else if (!degreeLevel.equals(other.degreeLevel)) {
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
		if (ukMajorCode == null) {
			if (other.ukMajorCode != null) {
				return false;
			}
		} else if (!ukMajorCode.equals(other.ukMajorCode)) {
			return false;
		}
		return true;
	}
	@Override
	public int compare(UKMajor o1, UKMajor o2) {
		return o1.getShortDesc().compareTo(o2.getShortDesc());
	}
	
}
