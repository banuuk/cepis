/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.PhoneTypeDao;
import edu.uky.cepis.domain.PhoneType;

/**
 * @author  keerthi
 */
public class PhoneTypeServiceImpl implements PhoneTypeService {

	/**
	 * @uml.property  name="phoneTypeDao"
	 * @uml.associationEnd  
	 */
	private PhoneTypeDao phoneTypeDao;

	/**
	 * @param phoneTypeDao  the phoneTypeDao to set
	 * @uml.property  name="phoneTypeDao"
	 */
	public void setPhoneTypeDao(PhoneTypeDao phoneTypeDao) {
		this.phoneTypeDao = phoneTypeDao;
	}

	/**
	 * @return  the phoneTypeDao
	 * @uml.property  name="phoneTypeDao"
	 */
	public PhoneTypeDao getPhoneTypeDao() {
		return phoneTypeDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.PhoneTypeService#createPhoneType(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public PhoneType createPhoneType(String code, String desc) {
		return this.getPhoneTypeDao().createPhoneType(code, desc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.PhoneTypeService#deletePhoneType(edu.uky.cepis.
	 * domain.PhoneType)
	 */
	@Override
	public boolean deletePhoneType(PhoneType phoneType) {
		return this.getPhoneTypeDao().deletePhoneType(phoneType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.PhoneTypeService#findPhoneTypeByCode(java.lang.
	 * String)
	 */
	@Override
	public PhoneType findPhoneTypeByCode(String code) {
		return this.getPhoneTypeDao().findPhoneTypeByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.PhoneTypeService#getPhoneTypeList()
	 */
	@Override
	public List<PhoneType> getPhoneTypeList() {
		return this.getPhoneTypeDao().getPhoneTypeList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.PhoneTypeService#updatePhoneType(edu.uky.cepis.
	 * domain.PhoneType, java.lang.String, java.lang.String)
	 */
	@Override
	public PhoneType updatePhoneType(PhoneType phoneType, String code,
			String desc) {
		return this.getPhoneTypeDao().updatePhoneType(phoneType, code, desc);
	}

}
