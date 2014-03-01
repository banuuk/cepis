/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.AddressTypeDao;
import edu.uky.cepis.domain.AddressType;

/**
 * @author  keerthi
 */
public class AddressTypeServiceImpl implements AddressTypeService {

	/**
	 * @uml.property  name="addressTypeDao"
	 * @uml.associationEnd  
	 */
	private AddressTypeDao addressTypeDao;

	/**
	 * @param addressTypeDao  the addressTypeDao to set
	 * @uml.property  name="addressTypeDao"
	 */
	public void setAddressTypeDao(AddressTypeDao addressTypeDao) {
		this.addressTypeDao = addressTypeDao;
	}

	/**
	 * @return  the addressTypeDao
	 * @uml.property  name="addressTypeDao"
	 */
	public AddressTypeDao getAddressTypeDao() {
		return addressTypeDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.AddressTypeService#createAddressType(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public AddressType createAddressType(String code, String desc) {

		return this.getAddressTypeDao().createAddressType(code, desc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.AddressTypeService#deleteAddressType(edu.uky.cepis
	 * .domain.AddressType)
	 */
	@Override
	public boolean deleteAddressType(AddressType addressType) {
		return this.getAddressTypeDao().deleteAddressType(addressType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.AddressTypeService#findAddressTypeByCode(java.lang
	 * .String)
	 */
	@Override
	public AddressType findAddressTypeByCode(String code) {
		return this.getAddressTypeDao().findAddressTypeByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.AddressTypeService#getAddressTypeList()
	 */
	@Override
	public List<AddressType> getAddressTypeList() {
		return this.getAddressTypeDao().getAddressTypeList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.AddressTypeService#updateAddressType(edu.uky.cepis
	 * .domain.AddressType, java.lang.String, java.lang.String)
	 */
	@Override
	public AddressType updateAddressType(AddressType addressType, String code,
			String desc) {
		return this.getAddressTypeDao().updateAddressType(addressType, code,
				desc);
	}

}
