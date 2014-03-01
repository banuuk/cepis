/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * 
 * @author cawalk4
 * 
 */
@Entity
@Table(name="tblPhone")
@Cache(region="edu.uky.cepis.cache.phone", usage=CacheConcurrencyStrategy.READ_WRITE)
public class Phone implements Serializable, java.util.Comparator<Phone> {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PhoneID")
	private long id;

	@Column(name="Phone", length = 50)
	private String phoneNo;

	@Column(name="Extension", length = 50)
	private String ext;

	@Column(name="Memo", length = 255)
	private String memo;

	@Column(name="Lastedit")
	private Date lastEdit;
	
	@ManyToOne
	@NotFound(action=NotFoundAction.IGNORE)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="Phonetypecode")
	private PhoneType phoneType;
	
	public Phone() {
	}

	/**
	 * @param phoneNo
	 * @param ext
	 * @param memo
	 * @param phoneType
	 * @param lastEdit
	 */
	public Phone(String phoneNo, String ext, String memo, PhoneType phoneType) {
		this.phoneNo = phoneNo;
		this.ext = ext;
		this.memo = memo;
		this.phoneType = phoneType;
		this.lastEdit = new Date();
	}

	/**
	 * @return the id
	 * @uml.property name="id"
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 * @uml.property name="id"
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the phoneNo
	 * @uml.property name="phoneNo"
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo
	 *            the phoneNo to set
	 * @uml.property name="phoneNo"
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the ext
	 * @uml.property name="ext"
	 */
	public String getExt() {
		return ext;
	}

	/**
	 * @param ext
	 *            the ext to set
	 * @uml.property name="ext"
	 */
	public void setExt(String ext) {
		this.ext = ext;
	}

	/**
	 * @return the memo
	 * @uml.property name="memo"
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo
	 *            the memo to set
	 * @uml.property name="memo"
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return the phoneType
	 * @uml.property name="phoneType"
	 */
	public PhoneType getPhoneType() {
		return phoneType;
	}

	/**
	 * @param phoneType
	 *            the phoneType to set
	 * @uml.property name="phoneType"
	 */
	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	/**
	 * @return the lastEdit
	 * @uml.property name="lastEdit"
	 */
	public Date getLastEdit() {
		return lastEdit;
	}

	/**
	 * @param lastEdit
	 *            the lastEdit to set
	 * @uml.property name="lastEdit"
	 */
	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
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
		result = prime * result + ((ext == null) ? 0 : ext.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((memo == null) ? 0 : memo.hashCode());
		result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
		result = prime * result
				+ ((phoneType == null) ? 0 : phoneType.hashCode());
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
		if (!(obj instanceof Phone)) {
			return false;
		}
		Phone other = (Phone) obj;
		if (ext == null) {
			if (other.ext != null) {
				return false;
			}
		} else if (!ext.equals(other.ext)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (memo == null) {
			if (other.memo != null) {
				return false;
			}
		} else if (!memo.equals(other.memo)) {
			return false;
		}
		if (phoneNo == null) {
			if (other.phoneNo != null) {
				return false;
			}
		} else if (!phoneNo.equals(other.phoneNo)) {
			return false;
		}
		if (phoneType == null) {
			if (other.phoneType != null) {
				return false;
			}
		} else if (!phoneType.equals(other.phoneType)) {
			return false;
		}
		return true;
	}

	@Override
	public int compare(Phone o1, Phone o2) {
		return o1.getPhoneNo().compareTo(o2.getPhoneNo())
				& o1.getExt().compareTo(o2.getExt());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.phoneNo;
	}

}
