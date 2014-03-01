/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.AddressType;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * Hibernate DAO class for CRUD operations on {@link AddressType} object.
 * 
 * @author keerthi
 * 
 */
public class AddressTypeDaoImpl implements AddressTypeDao {
	private static Logger log = Logger.getLogger(AddressDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.AddressTypeDao#createAddressType(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public AddressType createAddressType(String code, String desc) {
		AddressType addressType = new AddressType(code, desc);
		if (addressType == null) {
			return null;
		}
		if (!this.saveAddressType(addressType)) {
			return null;
		}
		return addressType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.AddressTypeDao#deleteAddressType(edu.uky.cepis.domain
	 * .AddressType)
	 */
	@Override
	public boolean deleteAddressType(AddressType addressType) {
		if (addressType == null) {
			return false;
		}
		this.sessionFactory.getCurrentSession().delete(addressType);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.AddressTypeDao#findAddressTypeByCode(java.lang.String)
	 */
	@Override
	public AddressType findAddressTypeByCode(String code) {
		if (code == null || code.equals("")) {
			return null;
		}
		List<AddressType> addressTypes = new ArrayList<AddressType>(0);
		String hql = "select a from AddressType a where a.code ='" + code + "'";
		addressTypes = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (addressTypes.size() > 0) {
			return addressTypes.get(0);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.AddressTypeDao#getAddressTypeList()
	 */
	@Override
	public List<AddressType> getAddressTypeList() {
		List<AddressType> addressTypes = new ArrayList<AddressType>(0);
		String hql = "select a from AddressType a";
		addressTypes = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return addressTypes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.AddressTypeDao#saveAddressType(edu.uky.cepis.domain
	 * .AddressType)
	 */
	@Override
	public boolean saveAddressType(AddressType addressType) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(addressType);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.AddressTypeDao#updateAddressType(edu.uky.cepis.domain
	 * .AddressType, java.lang.String, java.lang.String)
	 */
	@Override
	public AddressType updateAddressType(AddressType addressType, String code,
			String desc) {
		if (addressType == null) {
			return null;
		}
		addressType.setCode(code);
		addressType.setDesc(desc);
		this.saveAddressType(addressType);
		return addressType;
	}

}
