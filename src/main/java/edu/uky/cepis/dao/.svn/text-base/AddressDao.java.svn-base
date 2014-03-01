/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.List;

import edu.uky.cepis.domain.Address;
import edu.uky.cepis.domain.AddressType;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public interface AddressDao {

	/**
	 * 
	 * Add a new {@link Address} object to the given {@link User} object.
	 * 
	 * @param user
	 * @param street1
	 * @param street2
	 * @param city
	 * @param state
	 * @param zip
	 * @param country
	 * @param addressType
	 * @return
	 */
	public abstract boolean addAddressToUser(User user, String street1,
			String street2, String city, String state, String zip,
			String country, AddressType addressType);

	/**
	 * Find an {@link Address} object by city.
	 * 
	 * @param city
	 * @return
	 */
	public abstract List<Address> findByCity(String city);

	/**
	 * Find an {@link Address} object by country.
	 * 
	 * @param country
	 * @return
	 */
	public abstract List<Address> findByCountry(String country);

	/**
	 * Find a user's {@link Address} by id of type long.
	 * 
	 * @param id
	 * @return
	 */
	public abstract Address findById(long id);

	/**
	 * Find an {@link Address} object by state.
	 * 
	 * @param state
	 * @return
	 */
	public abstract List<Address> findByState(String state);

	/**
	 * Find an {@link Address} object by Street name concatenated by AND or OR
	 * SQL logical operators.
	 * 
	 * @param street
	 * @param concat
	 *            false(default value) for AND operation; true for OR operation.
	 * @return
	 */
	public abstract List<Address> findByStreet(String street, boolean concat);

	/**
	 * Find an {@link Address} object by zipcode.
	 * 
	 * @param zip
	 * @return
	 */
	public abstract List<Address> findByZip(String zip);

	/**
	 * 
	 * Get the {@link Address} object list of the given {@link User} object.
	 * 
	 * @param user
	 * @return
	 */
	public abstract List<Address> getAddressList(User user);

	/**
	 * Remove the give {@link Address} object from the {@link User}.
	 * 
	 * @param user
	 * @param address
	 * @return
	 */
	public boolean removeAddressFromUser(User user, Address address);

	/**
	 * Update user {@link Address} object.
	 * 
	 * @param user
	 * @param address
	 * @param street1
	 * @param street2
	 * @param city
	 * @param state
	 * @param zip
	 * @param country
	 * @param addressType
	 * @return
	 */
	public abstract Address updateAddress(User user, Address address,
			String street1, String street2, String city, String state,
			String zip, String country, AddressType addressType);
}
