/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import java.util.Set;

import edu.uky.cepis.domain.Address;
import edu.uky.cepis.domain.AddressType;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public interface AddressService {
	public abstract Address updateAddress(User user, Address address,
			String street1, String street2, String city, String state,
			String zip, String country, AddressType addressType);

	public abstract Address findById(long id);

	public boolean removeAddressFromUser(User user, Address address);

	public abstract List<Address> findByStreet(String street, boolean concat);

	public abstract List<Address> findByCity(String city);

	public abstract List<Address> findByState(String state);

	public abstract List<Address> findByZip(String zip);

	public abstract List<Address> findByCountry(String country);

	public abstract boolean addAddressToUser(User user, String street1,
			String street2, String city, String state, String zip,
			String country, AddressType addressType);

	public abstract List<Address> getAddressList(User user);
}
