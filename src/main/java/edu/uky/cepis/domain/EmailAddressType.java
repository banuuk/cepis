/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;

/**
 * @author keerthi
 */
public class EmailAddressType implements Serializable,
		java.util.Comparator<EmailAddressType> {

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
	public EmailAddressType() {
	}

	/**
	 * @param code
	 * @param desc
	 */
	public EmailAddressType(String code, String desc) {
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
		if (!(obj instanceof EmailAddressType)) {
			return false;
		}
		EmailAddressType other = (EmailAddressType) obj;
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
	public int compare(EmailAddressType o1, EmailAddressType o2) {
		return o1.getCode().compareTo(o2.getCode());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return code;
	}

}
