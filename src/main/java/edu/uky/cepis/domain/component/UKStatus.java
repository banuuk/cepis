/**
 * 
 */
package edu.uky.cepis.domain.component;

/**
 * @author  keerthi
 */
public class UKStatus implements java.io.Serializable,java.util.Comparator<UKStatus> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="statusCode"
	 */
	String statusCode;
	/**
	 * @uml.property  name="shortDesc"
	 */
	String shortDesc;
	/**
	 * @uml.property  name="description"
	 */
	String description;
	/**
	 * @uml.property  name="status"
	 */
	String status;
	
	
	
	/**
	 * 
	 */
	public UKStatus() {
	}
	/**
	 * @param ukstatusid
	 * @param statusCode
	 * @param shortDesc
	 * @param description
	 * @param status
	 */
	public UKStatus(String statusCode, String shortDesc,
			String description, String status) {
	
		this.statusCode = statusCode;
		this.shortDesc = shortDesc;
		this.description = description;
		this.status = status;
	}

	/**
	 * @return  the statusCode
	 * @uml.property  name="statusCode"
	 */
	public String getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode  the statusCode to set
	 * @uml.property  name="statusCode"
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
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
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((statusCode == null) ? 0 : statusCode.hashCode());
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
		if (!(obj instanceof UKStatus)) {
			return false;
		}
		UKStatus other = (UKStatus) obj;
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
		if (statusCode == null) {
			if (other.statusCode != null) {
				return false;
			}
		} else if (!statusCode.equals(other.statusCode)) {
			return false;
		}
		return true;
	}
	@Override
	public int compare(UKStatus o1, UKStatus o2) {
		return o1.getShortDesc().compareTo(o2.getShortDesc());
	}
	
}
