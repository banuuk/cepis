/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.util.Comparator;
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
 * Address class for the {@link User} object is used to store the history of
 * physical locations given by the user.
 * 
 * @author cawalk4
 */
@Entity
@Table(name="tblAddress")
@Cache(region="edu.uky.cepis.cache.address", usage=CacheConcurrencyStrategy.READ_WRITE)
public class Address implements Serializable, Comparator<Address> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AddressID")
	private long id;
	
	@Column(name="StrLine1", length = 255)
	private String street1;
	
	@Column(name="StrLine2", length = 255)
	private String street2;
	
	@Column(name="City", length = 50)
	private String city;
	
	@Column(name="State", length = 20)
	private String state;
	
	@Column(name="Zip", length = 10)
	private String zip;
	
	@Column(name="Country", length = 50)
	private String country;
	
	@Column(name="Lastedit")
	private Date lastEdit;
	
	@ManyToOne (targetEntity = AddressType.class)
	@NotFound(action=NotFoundAction.IGNORE)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="Addresstypecode", nullable = false)
	private AddressType addressType;
		
	
	public Address() {
	}

	/**
	 * @param street1
	 * @param street2
	 * @param city
	 * @param state
	 * @param zip
	 * @param country
	 * @param addressType
	 */
	public Address(String street1, String street2, String city, String state,
			String zip, String country, AddressType addressType) {
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.addressType = addressType;
		this.lastEdit = new Date();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Address o1, Address o2) {
		return o1.getStreet1().compareTo(o1.getStreet1())
				& o1.getStreet2().compareTo(o2.getStreet2())
				& o1.getZip().compareTo(o2.getZip());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (addressType == null) {
			if (other.addressType != null)
				return false;
		} else if (!addressType.equals(other.addressType))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id != other.id)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street1 == null) {
			if (other.street1 != null)
				return false;
		} else if (!street1.equals(other.street1))
			return false;
		if (street2 == null) {
			if (other.street2 != null)
				return false;
		} else if (!street2.equals(other.street2))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	/**
	 * @return the addressType
	 * @uml.property name="addressType"
	 */
	public AddressType getAddressType() {
		return addressType;
	}

	/**
	 * @return the city
	 * @uml.property name="city"
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the country
	 * @uml.property name="country"
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the id
	 * @uml.property name="id"
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the lastEdit
	 * @uml.property name="lastEdit"
	 */
	public Date getLastEdit() {
		return lastEdit;
	}

	/**
	 * @return the state
	 * @uml.property name="state"
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the street1
	 * @uml.property name="street1"
	 */
	public String getStreet1() {
		return street1;
	}

	/**
	 * @return the street2
	 * @uml.property name="street2"
	 */
	public String getStreet2() {
		return street2;
	}

	/**
	 * @return the zip
	 * @uml.property name="zip"
	 */
	public String getZip() {
		return zip;
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
				+ ((addressType == null) ? 0 : addressType.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street1 == null) ? 0 : street1.hashCode());
		result = prime * result + ((street2 == null) ? 0 : street2.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}

	/**
	 * @param addressType
	 *            the addressType to set
	 * @uml.property name="addressType"
	 */
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	/**
	 * @param city
	 *            the city to set
	 * @uml.property name="city"
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @param country
	 *            the country to set
	 * @uml.property name="country"
	 */
	public void setCountry(String country) {
		this.country = country;
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
	 * @param lastEdit
	 *            the lastEdit to set
	 * @uml.property name="lastEdit"
	 */
	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}

	/**
	 * @param state
	 *            the state to set
	 * @uml.property name="state"
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param street1
	 *            the street1 to set
	 * @uml.property name="street1"
	 */
	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	/**
	 * @param street2
	 *            the street2 to set
	 * @uml.property name="street2"
	 */
	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	/**
	 * @param zip
	 *            the zip to set
	 * @uml.property name="zip"
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}


}
