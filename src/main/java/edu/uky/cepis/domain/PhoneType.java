/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;

/**
 * @author keerthi
 */
public class PhoneType implements Serializable, java.util.Comparator<PhoneType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="code"
	 */
	private String code;
	/**
	 * @uml.property  name="desc"
	 */
	private String desc;

	/**
	 * 
	 */
	public PhoneType() {
	}

	/**
	 * @param code
	 * @param desc
	 */
	public PhoneType(String code, String desc) {
		this.code = code;
		this.desc = desc;
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
	 * @param desc
	 *            the desc to set
	 * @uml.property name="desc"
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the desc
	 * @uml.property name="desc"
	 */
	public String getDesc() {
		return desc;
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
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
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
		if (!(obj instanceof PhoneType)) {
			return false;
		}
		PhoneType other = (PhoneType) obj;
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		if (desc == null) {
			if (other.desc != null) {
				return false;
			}
		} else if (!desc.equals(other.desc)) {
			return false;
		}
		return true;
	}

	@Override
	public int compare(PhoneType o1, PhoneType o2) {
		return o1.getCode().compareTo(o2.getCode());
	}

	@Override
	public String toString() {
		return this.code;
	}

}
