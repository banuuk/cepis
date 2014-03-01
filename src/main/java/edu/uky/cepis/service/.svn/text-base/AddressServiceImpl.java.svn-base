/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import java.util.Set;

import edu.uky.cepis.dao.AddressDao;
import edu.uky.cepis.domain.Address;
import edu.uky.cepis.domain.AddressType;
import edu.uky.cepis.domain.User;

/**
 * @author  keerthi
 */
public class AddressServiceImpl implements AddressService {

	/**
	 * @uml.property  name="addressDao"
	 * @uml.associationEnd  
	 */
	private AddressDao addressDao;

	/**
	 * @param addressDao  the addressDao to set
	 * @uml.property  name="addressDao"
	 */
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	/**
	 * @return  the addressDao
	 * @uml.property  name="addressDao"
	 */
	public AddressDao getAddressDao() {
		return addressDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.AddressService#findByCity(java.lang.String)
	 */
	@Override
	public List<Address> findByCity(String city) {
		return this.getAddressDao().findByCity(city);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.AddressService#findByCountry(java.lang.String)
	 */
	@Override
	public List<Address> findByCountry(String country) {
		return this.getAddressDao().findByCountry(country);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.AddressService#findById(long)
	 */
	@Override
	public Address findById(long id) {
		return this.getAddressDao().findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.AddressService#findByState(java.lang.String)
	 */
	@Override
	public List<Address> findByState(String state) {
		return this.getAddressDao().findByState(state);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.AddressService#findByStreet(java.lang.String,
	 * boolean)
	 */
	@Override
	public List<Address> findByStreet(String street, boolean concat) {
		return this.getAddressDao().findByStreet(street, concat);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.AddressService#findByZip(java.lang.String)
	 */
	@Override
	public List<Address> findByZip(String zip) {
		return this.getAddressDao().findByZip(zip);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.AddressService#removeAddressFromUser(edu.uky.cepis
	 * .domain.User, edu.uky.cepis.domain.Address)
	 */
	@Override
	public boolean removeAddressFromUser(User user, Address address) {
		return this.getAddressDao().removeAddressFromUser(user, address);
	}


	@Override
	public boolean addAddressToUser(User user, String street1, String street2,
			String city, String state, String zip, String country,
			AddressType addressType) {
		this.getAddressDao().addAddressToUser(user, street1, street2, city,
				state, zip, country, addressType);
		return true;
	}

	@Override
	public List<Address> getAddressList(User user) {
		return this.getAddressDao().getAddressList(user);
	}

	@Override
	public Address updateAddress(User user, Address address, String street1,
			String street2, String city, String state, String zip,
			String country, AddressType addressType) {
		return this.getAddressDao().updateAddress(user, address, street1,
				street2, city, state, zip, country, addressType);
	}

}
