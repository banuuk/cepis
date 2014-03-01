/**
 * 
 */
package edu.uky.cepis.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keerthi
 */
public class StandardSet implements java.io.Serializable,
		java.util.Comparator<StandardSet> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property name="programCode"
	 */
	String stdSetCode;
	/**
	 * @uml.property name="shortDesc"
	 */
	String shortDesc;

	List<Standard> standards = new ArrayList<Standard>(0);

	/**
	 * 
	 */
	public StandardSet() {
	}

	/**
	 * @param stdSetCode
	 * @param shortDesc
	 */
	public StandardSet(String stdSetCode, String shortDesc) {

		this.stdSetCode = stdSetCode;
		this.shortDesc = shortDesc;
	}

	/**
	 * @return the stdSetCode
	 */
	public String getStdSetCode() {
		return stdSetCode;
	}

	/**
	 * @param stdSetCode
	 *            the stdSetCode to set
	 */
	public void setStdSetCode(String stdSetCode) {
		this.stdSetCode = stdSetCode;
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
	 * @return the standards
	 */
	public List<Standard> getStandards() {
		return standards;
	}

	/**
	 * @param standards
	 *            the standards to set
	 */
	public void setStandards(List<Standard> standards) {
		this.standards = standards;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return stdSetCode;
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
				+ ((stdSetCode == null) ? 0 : stdSetCode.hashCode());
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
		if (!(obj instanceof StandardSet)) {
			return false;
		}
		StandardSet other = (StandardSet) obj;
		if (shortDesc == null) {
			if (other.shortDesc != null) {
				return false;
			}
		} else if (!shortDesc.equals(other.shortDesc)) {
			return false;
		}
		if (stdSetCode == null) {
			if (other.stdSetCode != null) {
				return false;
			}
		} else if (!stdSetCode.equals(other.stdSetCode)) {
			return false;
		}
		return true;
	}

	@Override
	public int compare(StandardSet o1, StandardSet o2) {
		return o1.getStdSetCode().compareTo(o2.getStdSetCode());
	}

}
