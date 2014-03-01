/**
 * 
 */
package edu.uky.cepis.domain;

/**
 * @author keerthi
 */
public class Standard implements java.io.Serializable,
		java.util.Comparator<Standard> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property name="programCode"
	 */
	String stdCode;
	/**
	 * @uml.property name="shortDesc"
	 */
	String shortDesc;

	/**
	 * 
	 */
	public Standard() {
	}

	/**
	 * @param stdCode
	 * @param shortDesc
	 */
	public Standard(String stdCode, String shortDesc) {

		this.stdCode = stdCode;
		this.shortDesc = shortDesc;
	}

	

	/**
	 * @return the stdCode
	 */
	public String getStdCode() {
		return stdCode;
	}

	/**
	 * @param stdCode the stdCode to set
	 */
	public void setStdCode(String stdCode) {
		this.stdCode = stdCode;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return stdCode;
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
		result = prime * result + ((stdCode == null) ? 0 : stdCode.hashCode());
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
		if (!(obj instanceof Standard)) {
			return false;
		}
		Standard other = (Standard) obj;
		if (shortDesc == null) {
			if (other.shortDesc != null) {
				return false;
			}
		} else if (!shortDesc.equals(other.shortDesc)) {
			return false;
		}
		if (stdCode == null) {
			if (other.stdCode != null) {
				return false;
			}
		} else if (!stdCode.equals(other.stdCode)) {
			return false;
		}
		return true;
	}

	@Override
	public int compare(Standard o1, Standard o2) {
		return o1.getStdCode().compareTo(o2.getStdCode());
	}

}
