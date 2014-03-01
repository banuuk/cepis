/**
 * 
 */
package edu.uky.cepis.domain;

/**
 * @author keerthi
 */
public class CohortType implements java.io.Serializable,
		java.util.Comparator<CohortType> {
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
	public CohortType() {
	}

	/**
	 * @param typeCode
	 * @param shortDesc
	 */
	public CohortType(String typeCode, String shortDesc, String description,
			String status) {

		this.setTypeCode(typeCode);
		this.shortDesc = shortDesc;
		this.description = description;
		this.status = status;
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
	 * @param description
	 *            the description to set
	 * @uml.property name="description"
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the description
	 * @uml.property name="description"
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param status
	 *            the status to set
	 * @uml.property name="status"
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the status
	 * @uml.property name="status"
	 */
	public String getStatus() {
		return status;
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
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (!(obj instanceof CohortType)) {
			return false;
		}
		CohortType other = (CohortType) obj;
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
		if (typeCode == null) {
			if (other.typeCode != null) {
				return false;
			}
		} else if (!typeCode.equals(other.typeCode)) {
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

	@Override
	public int compare(CohortType o1, CohortType o2) {
		return o1.getTypeCode().compareTo(o2.getTypeCode());
	}

}
