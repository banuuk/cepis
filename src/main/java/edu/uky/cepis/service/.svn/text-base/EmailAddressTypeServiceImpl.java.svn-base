/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.EmailAddressTypeDao;
import edu.uky.cepis.domain.EmailAddressType;

/**
 * @author  keerthi
 */
public class EmailAddressTypeServiceImpl implements EmailAddressTypeService {

	/**
	 * @uml.property  name="emailAddressTypeDao"
	 * @uml.associationEnd  
	 */
	private EmailAddressTypeDao emailAddressTypeDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailAddressTypeService#createEmailAddressType(
	 * java.lang.String, java.lang.String)
	 */
	/**
	 * @return  the emaiLAddressTypeDao
	 * @uml.property  name="emailAddressTypeDao"
	 */
	public EmailAddressTypeDao getEmailAddressTypeDao() {
		return emailAddressTypeDao;
	}

	/**
	 * @param emaiLAddressTypeDao  the emaiLAddressTypeDao to set
	 * @uml.property  name="emailAddressTypeDao"
	 */
	public void setEmailAddressTypeDao(EmailAddressTypeDao emaiLAddressTypeDao) {
		this.emailAddressTypeDao = emaiLAddressTypeDao;
	}

	@Override
	public EmailAddressType createEmailAddressType(String code, String desc) {
		return this.getEmailAddressTypeDao().createEmailAddressType(code, desc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailAddressTypeService#deleteEmailAddressType(
	 * edu.uky.cepis.domain.EmailAddressType)
	 */
	@Override
	public boolean deleteEmailAddressType(EmailAddressType emailAddressType) {
		return this.getEmailAddressTypeDao().deleteEmailAddressType(
				emailAddressType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailAddressTypeService#findEmailAddressTypeByCode
	 * (java.lang.String)
	 */
	@Override
	public EmailAddressType findEmailAddressTypeByCode(String code) {
		return this.getEmailAddressTypeDao().findEmailAddressTypeByCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailAddressTypeService#getEmailAddressTypeList()
	 */
	@Override
	public List<EmailAddressType> getEmailAddressTypeList() {
		return this.getEmailAddressTypeDao().getEmailAddressTypeList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailAddressTypeService#updateEmailAddressType(
	 * edu.uky.cepis.domain.EmailAddressType, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public EmailAddressType updateEmailAddressType(
			EmailAddressType emailAddressType, String code, String desc) {
		return this.getEmailAddressTypeDao().updateEmailAddressType(
				emailAddressType, code, desc);
	}

}
