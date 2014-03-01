package edu.uky.cepis.domain;

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
 * EmailAddress Domain to store the email addresses of an user
 * 
 * 
  * @author cawalk4
 */
@Entity
@Table(name="tblComputer")
@Cache(region="edu.uky.cepis.cache.emailaddress", usage=CacheConcurrencyStrategy.READ_WRITE)
public class EmailAddress implements java.io.Serializable, java.util.Comparator<EmailAddress> {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ComputerID")
	private long id;

	@Column(name="Computeraddress", nullable = false, length = 100, unique = true)
	private String address;
	
	@Column(name="Lastedit")
	private Date lastEdit;
	
	@ManyToOne
	@NotFound(action=NotFoundAction.IGNORE)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="Computertypecode")
	private EmailAddressType type;

	/*
	 * private List<Email> sentEmails = new ArrayList<Email>(0); private
	 * List<Email> receivedEmails = new ArrayList<Email>(0); private List<Email>
	 * toEmails = new ArrayList<Email>(0); private List<Email> ccEmails = new
	 * ArrayList<Email>(0); private List<Email> bccEmails = new
	 * ArrayList<Email>(0);
	 */

	public EmailAddress() {

	}

	public EmailAddress(long id, String address, EmailAddressType type) {
		this.address = address;
		this.type = type;
		this.id = id;
	}

	public EmailAddress(String address, EmailAddressType type) {
		this.address = address;
		this.type = type;
		this.lastEdit = new Date();
	}

	/**
	 * @return
	 * @uml.property name="id"
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * @param id
	 * @uml.property name="id"
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return
	 * @uml.property name="address"
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * @param address
	 * @uml.property name="address"
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return
	 * @uml.property name="type"
	 */
	public EmailAddressType getType() {
		return this.type;
	}

	/**
	 * @param type
	 * @uml.property name="type"
	 */
	public void setType(EmailAddressType type) {
		this.type = type;
	}

	/**
	 * @param lastEdit
	 *            the lastEdit to set
	 * @uml.property name="lastEdit"
	 */
	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}

	/**
	 * @return the lastEdit
	 * @uml.property name="lastEdit"
	 */
	public Date getLastEdit() {
		return lastEdit;
	}


	@Override
	public int compare(EmailAddress o1, EmailAddress o2) {
		return o1.getAddress().compareToIgnoreCase(o2.getAddress());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getAddress();
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
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (!(obj instanceof EmailAddress)) {
			return false;
		}
		EmailAddress other = (EmailAddress) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}

}
