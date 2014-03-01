/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;

/**
 * @author keerthi
 */
public class Ethnic implements Serializable, java.util.Comparator<Ethnic> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="code"
	 */
	private String code;
	/**
	 * @uml.property  name="shortDesc"
	 */
	private String shortDesc;
	/**
	 * @uml.property  name="kyEthnicCode"
	 */
	private String kyEthnicCode;
	
	private String status;

	/**
	 * 
	 */
	public Ethnic() {
	}

	/**
	 * @param code
	 * @param ethnicity
	 */
	public Ethnic(String code, String shortDesc) {
		this.code = code;
		this.shortDesc = shortDesc;
	}

	/**
	 * @param code
	 * @param ethnicity
	 * @param kyEthnicCode
	 */
	public Ethnic(String code, String shortDesc, String kyEthnicCode) {
		this.code = code;
		this.shortDesc = shortDesc;
		this.kyEthnicCode = kyEthnicCode;
	}

	/**
	 * @param code
	 *            the code to set
	 * @uml.property name="code"
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the code
	 * @uml.property name="code"
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param ethnicity
	 *            the shortDesc to set
	 * @uml.property name="shortDesc"
	 */
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	/**
	 * @return the shortDesc
	 * @uml.property name="shortDesc"
	 */
	public String getShortDesc() {
		return shortDesc;
	}

	/**
	 * @param kyEthnicCode
	 *            the kyEthnicCode to set
	 * @uml.property name="kyEthnicCode"
	 */
	public void setKyEthnicCode(String kyEthnicCode) {
		this.kyEthnicCode = kyEthnicCode;
	}

	/**
	 * @return the kyEthnicCode
	 * @uml.property name="kyEthnicCode"
	 */
	public String getKyEthnicCode() {
		return kyEthnicCode;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((kyEthnicCode == null) ? 0 : kyEthnicCode.hashCode());
		result = prime * result
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (!(obj instanceof Ethnic)) {
			return false;
		}
		Ethnic other = (Ethnic) obj;
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		if (kyEthnicCode == null) {
			if (other.kyEthnicCode != null) {
				return false;
			}
		} else if (!kyEthnicCode.equals(other.kyEthnicCode)) {
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
		return shortDesc +" ("+status+")";
	}

	@Override
	public int compare(Ethnic o1, Ethnic o2) {
		return o1.getCode().compareTo(o2.getCode());
	}

}
