/**
 * 
 */
package edu.uky.cepis.domain;

/**
 * @author  keerthi
 */
public class CohortTerm implements java.io.Serializable,
		java.util.Comparator<CohortTerm> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int termCode;

	/**
	 * @uml.property  name="shortDesc"
	 */
	String shortDesc;

	/**
	 * @uml.property  name="description"
	 */
	String description;

	/**
	 * 
	 */
	public CohortTerm() {
	}

	/**
	 * @param termCode
	 * @param shortDesc
	 * @param description
	 */
	public CohortTerm(int termCode, String shortDesc, String description) {

		this.termCode = termCode;
		this.shortDesc = shortDesc;
		this.description = description;

	}

	/**
	 * @return  the termCode
	 * @uml.property  name="termCode"
	 */
	public int getTermCode() {
		return termCode;
	}

	/**
	 * @param termCode  the termCode to set
	 * @uml.property  name="termCode"
	 */
	public void setTermCode(int termCode) {
		this.termCode = termCode;
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
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
		result = prime * result + termCode;
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
		if (!(obj instanceof CohortTerm)) {
			return false;
		}
		CohortTerm other = (CohortTerm) obj;
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
		if (termCode != other.termCode) {
			return false;
		}
		return true;
	}

	@Override
	public int compare(CohortTerm o1, CohortTerm o2) {
		return o1.getShortDesc().compareTo(o2.getShortDesc());
	}

}
