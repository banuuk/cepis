/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.Address;
import edu.uky.cepis.domain.AddressType;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.util.operations.StringOperation;

/**
 * Hibernate-based DAO class for CRUD operation on {@link Address} object.<br>
 * 
 * {@link SessionFactory} object injected via Spring IoC.
 * 
 * @author keerthi
 * 
 */
@SuppressWarnings("unchecked")
public class AddressDaoImpl implements AddressDao {

	private static Logger log = Logger.getLogger(AddressDaoImpl.class);
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.AddressDao#addAddressToUser(edu.uky.cepis.domain.User,
	 * edu.uky.cepis.domain.Address)
	 */
	@SuppressWarnings("unused")
	@Override
	public boolean addAddressToUser(User user, String street1, String street2,
			String city, String state, String zip, String country,
			AddressType addressType) {
		if (user == null || addressType == null) {
			return false;
		}
		/*
		 * if (findByAddress(user, street1, street2, city, state, zip, country,
		 * addressType.getCode()) != null) { // Duplicate Address exist
		 * System.out.println("Duplicate Address available for this user");
		 * return false; }
		 */

		Address address = new Address(street1, street2, city, state, zip,
				country, addressType);
		if (address == null) {
			return false;
		}
		if (!this.saveAddress(address)) {
			return false;
		}
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return false;
		}
		newuser.getAddresses().add(address);
		return true;

	}

	/**
	 * @param user
	 * @param street1
	 * @param street2
	 * @param city
	 * @param state
	 * @param zip
	 * @param country
	 * @param addressTypeCode
	 * @return
	 */
	public Address findByAddress(User user, String street1, String street2,
			String city, String state, String zip, String country,
			String addressTypeCode) {
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return null;
		}
		Set<Address> addresses = newuser.getAddresses();
		Iterator<Address> iter = addresses.iterator();
		while (iter.hasNext()) {
			Address newaddress = iter.next();
			if (newaddress.getCity().equals(city)
					&& newaddress.getState().equals(state)
					&& newaddress.getZip().equals(zip)
					&& newaddress.getAddressType().getCode()
							.equals(addressTypeCode)
					&& newaddress.getStreet1().equals(street1)
					&& newaddress.getStreet2().equals(street2)) {
				return newaddress;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.AddressDao#findByCity(java.lang.String)
	 */
	@Override
	public List<Address> findByCity(String city) {
		if (city == null || city.equals("")) {
			return null;
		}
		List<Address> addresses = new ArrayList<Address>(0);
		addresses = this.sessionFactory.getCurrentSession()
				.createQuery("from Address a where a.city like '%?%'")
				.setParameter(0, city).list();
		return addresses;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.AddressDao#findByCountry(java.lang.String)
	 */
	@Override
	public List<Address> findByCountry(String country) {
		if (country == null || country.equals("")) {
			return null;
		}
		List<Address> addresses = new ArrayList<Address>(0);
		String hql = "select a from Address a where a.country like '%"
				+ country + "%'";
		addresses = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return addresses;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.AddressDao#findById(long)
	 */
	@Override
	public Address findById(long id) {

		List<Address> addresses = new ArrayList<Address>(0);
		addresses = this.sessionFactory.getCurrentSession()
				.createQuery("from Address a where a.id = ?")
				.setParameter(0, id).list();
		if (addresses.size() > 0)
			return addresses.get(0);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.AddressDao#findByState(java.lang.String)
	 */
	@Override
	public List<Address> findByState(String state) {
		if (state == null || state.equals("")) {
			return null;
		}
		List<Address> addresses = new ArrayList<Address>(0);
		String hql = "select a from Address a where a.state like '%" + state
				+ "%'";
		addresses = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return addresses;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.AddressDao#findByStreet(java.lang.String, boolean)
	 */
	@Override
	public List<Address> findByStreet(String street, boolean concat) {
		if (street == null || street.equals("")) {
			return null;
		}
		List<Address> addresses = new ArrayList<Address>(0);
		String replacement = StringOperation.getConcatOperationString(concat);
		String formatStreet = StringOperation
				.appendStartEndWithString(StringOperation.replaceWSByString(
						street, replacement));
		addresses = this.sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Address a where a.street1 rlike ? OR a.street2 rlike ?")
				.setParameter(0, formatStreet).setParameter(1, formatStreet)
				.list();
		return addresses;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.AddressDao#findByZip(java.lang.String)
	 */
	@Override
	public List<Address> findByZip(String zip) {
		if (zip == null || zip.equals("")) {
			return null;
		}
		List<Address> addresses = new ArrayList<Address>(0);
		String hql = "select a from Address a where a.zip like '%" + zip + "%'";
		addresses = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return addresses;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.AddressDao#getAddressList(edu.uky.cepis.domain.User)
	 */
	@Override
	public List<Address> getAddressList(User user) {
		List<Address> addresses = new ArrayList<Address>(0);
		if (user == null) {
			return addresses;
		}
		String hql = "select b from  edu.uky.cepis.domain.User a join a.addresses b  where a.uid like '"
				+ user.getUid() + "' order by b.id";
		addresses = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return addresses;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.AddressDao#removeAddressFromUser(edu.uky.cepis.domain
	 * .User, edu.uky.cepis.domain.Address)
	 */
	@Override
	public boolean removeAddressFromUser(User user, Address address) {
		if (user == null) {
			return false;
		}
		if (address == null) {
			return false;
		}
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		Address newaddress = (Address) this.sessionFactory.getCurrentSession()
				.load(Address.class, address.getId());
		if (newaddress == null) {
			return false;
		}
		Set<Address> addresses = newuser.getAddresses();
		if (addresses.contains(newaddress)) {
			addresses.remove(newaddress);
			this.sessionFactory.getCurrentSession().delete(newaddress);
			return true;
		}
		return false;
	}

	/**
	 * Hibernate Save or Update {@link Address} object.
	 * 
	 * @param address
	 * @return
	 */
	public boolean saveAddress(Address address) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(address);
		return true;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.AddressDao#updateAddress(edu.uky.cepis.domain.Address,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, edu.uky.cepis.domain.AddressType)
	 */
	@Override
	public Address updateAddress(User user, Address address, String street1,
			String street2, String city, String state, String zip,
			String country, AddressType addressType) {
		if (user == null) {
			return null;
		}
		if (address == null || addressType == null) {
			return null;
		}
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		Address newaddress = (Address) this.sessionFactory.getCurrentSession()
				.load(Address.class, address.getId());
		if (newaddress == null || newuser == null) {
			return null;
		}
		if (!newuser.getAddresses().contains(newaddress)) {
			return null;
		}
		newaddress.setStreet1(street1);
		newaddress.setStreet2(street2);
		newaddress.setCity(city);
		newaddress.setState(state);
		newaddress.setZip(zip);
		newaddress.setCountry(country);
		newaddress.setAddressType(addressType);
		newaddress.setLastEdit(new Date());
		this.saveAddress(newaddress);
		return newaddress;

	}

}
