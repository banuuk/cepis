/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.EmailAddressDao;
import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.EmailAddressType;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 */
public class EmailAddressServiceImpl implements EmailAddressService {

	/**
	 * @uml.property  name="emailAddressDao"
	 * @uml.associationEnd  
	 */
	private EmailAddressDao emailAddressDao;

	/**
	 * @param emailAddressDao
	 *            the emailAddressDao to set
	 * @uml.property name="emailAddressDao"
	 */
	public void setEmailAddressDao(EmailAddressDao emailAddressDao) {
		this.emailAddressDao = emailAddressDao;
	}

	/**
	 * @return the emailAddressDao
	 * @uml.property name="emailAddressDao"
	 */
	public EmailAddressDao getEmailAddressDao() {
		return emailAddressDao;
	}

	@Override
	public boolean removeEmailAddressFromUser(User user,
			EmailAddress emailAddress) {
		return this.getEmailAddressDao().removeEmailAddressFromUser(user,
				emailAddress);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.EmailAddressService#findEmailAddressByID(long)
	 */
	@Override
	public EmailAddress findEmailAddressByID(long id) {

		return this.getEmailAddressDao().findEmailAddressByID(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailAddressService#findEmailAddressByID(edu.uky
	 * .cepis.domain.User, long)
	 */
	@Override
	public EmailAddress findEmailAddressByID(User user, long id) {

		return this.getEmailAddressDao().findEmailAddressByID(user, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailAddressService#findEmailAddressByName(java
	 * .lang.String)
	 */
	@Override
	public EmailAddress findEmailAddressByName(String name) {

		return this.getEmailAddressDao().findEmailAddressByName(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailAddressService#findEmailAddressByName(edu.
	 * uky.cepis.domain.User, java.lang.String)
	 */
	@Override
	public EmailAddress findEmailAddressByName(User user, String name) {

		return this.getEmailAddressDao().findEmailAddressByName(user, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailAddressService#getUKYEmailAddress(edu.uky.
	 * cepis.domain.User)
	 */
	@Override
	public EmailAddress getUKYEmailAddress(User user) {

		return this.getEmailAddressDao().getUKYEmailAddress(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailAddressService#isUKYEmailAddress(edu.uky.cepis
	 * .domain.EmailAddress)
	 */
	@Override
	public boolean isUKYEmailAddress(EmailAddress emailAddress) {
		return this.getEmailAddressDao().isUKYEmailAddress(emailAddress);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailAddressService#saveEmailAddress(edu.uky.cepis
	 * .domain.EmailAddress)
	 */
	@Override
	public boolean saveEmailAddress(EmailAddress emailAddress) {
		return this.getEmailAddressDao().saveEmailAddress(emailAddress);
	}

	@Override
	public boolean addEmailAddressToUser(User user, String address,
			EmailAddressType emailAddressType) {
		return this.getEmailAddressDao().addEmailAddressToUser(user, address,
				emailAddressType);
	}

	@Override
	public List<EmailAddress> getEmailAddresses(User user) {
		return this.getEmailAddressDao().getEmailAddresses(user);
	}

	@Override
	public EmailAddress updateEmailAddress(User user,
			EmailAddress emailAddress, String address, EmailAddressType type) {
		return this.getEmailAddressDao().updateEmailAddress(user, emailAddress,
				address, type);
	}

	@Override
	public boolean setPrimaryEmailAddress(User user, String address,
			EmailAddressType emailAddressType) {
		return this.getEmailAddressDao().setPrimaryEmailAddress(user, address,
				emailAddressType);
	}

}
