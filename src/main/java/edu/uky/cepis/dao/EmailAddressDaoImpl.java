/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.EmailAddressType;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public class EmailAddressDaoImpl implements EmailAddressDao {
	private static final Log log = LogFactory.getLog(EmailAddressDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public EmailAddress updateEmailAddress(User user,
			EmailAddress emailAddress, String address, EmailAddressType type) {
		if (user == null) {
			return null;
		}
		if (emailAddress == null || type == null) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		EmailAddress newemailAddress = (EmailAddress) this.sessionFactory
				.getCurrentSession().load(EmailAddress.class,
						emailAddress.getId());
		if (!newuser.getEmailAddresses().contains(newemailAddress)) {
			return null;
		}
		newemailAddress.setAddress(address);
		newemailAddress.setType(type);
		newemailAddress.setLastEdit(new Date());
		this.saveEmailAddress(emailAddress);
		return newemailAddress;
	}

	@Override
	public boolean setPrimaryEmailAddress(User user, String address,
			EmailAddressType emailAddressType) {
		if (user == null || address == null || address.equals("")) {
			return false;
		}

		EmailAddress emailAddress = new EmailAddress(address, emailAddressType);
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		newuser.getUserConfiguration().setPrimaryEmail(emailAddress);
		this.sessionFactory.getCurrentSession().saveOrUpdate(newuser);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailAddressDao#addEmailAddressToUser(edu.uky.cepis
	 * .domain.User, edu.uky.cepis.domain.EmailAddress)
	 */
	@Override
	public boolean addEmailAddressToUser(User user, String address,
			EmailAddressType emailAddressType) {
		if (user == null) {
			return false;
		}

		if (emailAddressType == null) {
			return false;
		}

		if (this.findEmailAddressByName(user, address,
				emailAddressType.getCode()) != null) {
			// Duplicate Email Address exist
			System.out
					.println("Duplicate Email Address available for this user");
			return false;
		}

		EmailAddress emailAddress = new EmailAddress(address, emailAddressType);

		if (emailAddress == null) {
			return false;
		}
		if (!this.saveEmailAddress(emailAddress)) {
			return false;
		}
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return false;
		}
		newuser.getEmailAddresses().add(emailAddress);

		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailAddressDao#deleteEmailAddressFromUser(edu.uky.
	 * cepis.domain.User, edu.uky.cepis.domain.EmailAddress)
	 */
	@Override
	public boolean removeEmailAddressFromUser(User user,
			EmailAddress emailAddress) {
		if (user == null) {
			return false;
		}
		if (emailAddress == null) {
			return false;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		EmailAddress newemailaddress = (EmailAddress) this.sessionFactory
				.getCurrentSession().load(EmailAddress.class,
						emailAddress.getId());
		if (newuser == null || newemailaddress == null) {
			return false;
		}
		if (newuser.getEmailAddresses().contains(newemailaddress)) {
			newuser.getEmailAddresses().remove(newemailaddress);
			this.sessionFactory.getCurrentSession().delete(newemailaddress);
			return true;
		}
		return false;
	}

	/*
	 * s (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.EmailAddressDao#findEmailAddressByID(long)
	 */
	@Override
	public EmailAddress findEmailAddressByID(long id) {

		List<EmailAddress> emailAddresses = new ArrayList<EmailAddress>(0);
		String hql = "select a from EmailAddress a where a.id=" + id;
		emailAddresses = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		EmailAddress emailAddress = null;
		if (emailAddresses.size() > 0) {
			emailAddress = emailAddresses.get(0);
		}
		return emailAddress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailAddressDao#findEmailAddressByID(edu.uky.cepis.
	 * domain.User, long)
	 */
	@Override
	public EmailAddress findEmailAddressByID(User user, long id) {
		if (user == null) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		Set<EmailAddress> emailAddresses = newuser.getEmailAddresses();
		EmailAddress emailAddress = null;
		if (emailAddresses.size() > 0) {
			Iterator<EmailAddress> iter = emailAddresses.iterator();
			while (iter.hasNext()) {
				emailAddress = iter.next();
				if ((emailAddress.getId() == id)) {
					break;
				}

			}
		}
		return emailAddress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailAddressDao#findEmailAddressByName(java.lang.String
	 * )
	 */
	@Override
	public EmailAddress findEmailAddressByName(String address) {

		List<EmailAddress> emailAddresses = new ArrayList<EmailAddress>(0);
		String hql = "select a from EmailAddress a where a.address like '%"
				+ address + "%'";
		emailAddresses = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		EmailAddress emailAddress = null;
		if (emailAddresses.size() > 0) {
			emailAddress = emailAddresses.get(0);
		}
		return emailAddress;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailAddressDao#findEmailAddressByName(edu.uky.cepis
	 * .domain.User, java.lang.String)
	 */
	@Override
	public EmailAddress findEmailAddressByName(User user, String address) {
		if (user == null) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		Set<EmailAddress> emailAddresses = newuser.getEmailAddresses();
		EmailAddress emailAddress = null;

		Iterator<EmailAddress> iter = emailAddresses.iterator();
		while (iter.hasNext()) {
			emailAddress = iter.next();
			if ((emailAddress.getAddress().equals(address))) {

				return emailAddress;
			}
		}

		return null;

	}

	public EmailAddress findEmailAddressByName(User user, String address,
			String addressTypeCode) {
		if (user == null) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		Set<EmailAddress> emailAddresses = newuser.getEmailAddresses();
		EmailAddress emailAddress = null;

		Iterator<EmailAddress> iter = emailAddresses.iterator();
		while (iter.hasNext()) {
			emailAddress = iter.next();
			if (emailAddress == null || emailAddress.getAddress() == null
					|| emailAddress.getType() == null) {
				continue;
			}
			if (emailAddress.getAddress().trim().equals(address.trim())
					&& emailAddress.getType().getCode().equals(addressTypeCode)) {
				return emailAddress;
			}
		}

		return null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmailAddress> getEmailAddresses(User user) {
		List<EmailAddress> emailAddresses = new ArrayList<EmailAddress>(0);
		if (user == null) {
			return emailAddresses;
		}

		String hql = "select b from  edu.uky.cepis.domain.User a join a.emailAddresses b  where a.uid like '"
				+ user.getUid() + "' order by b.id";
		emailAddresses = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		return emailAddresses;
	}

	@SuppressWarnings("unchecked")
	@Override
	public EmailAddress getUKYEmailAddress(User user) {		
		if (user == null) {
			return null;
		}		
		log.debug("Entered EmailAddressDaoIml.getUKYEmailAddress(User user) for User:" + user.getUid());		

		List<EmailAddress> emailAddresses = new ArrayList<EmailAddress>(0);
		String hql = "select emailaddress from User user join user.emailAddresses as emailaddress where user.uid ='"
				+ user.getUid() + "' and emailaddress.type ='UKY'";
		emailAddresses = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (emailAddresses != null && emailAddresses.size() > 0) {
			return emailAddresses.get(0);
		}
		return null;
	}

	@Override
	public boolean isUKYEmailAddress(EmailAddress emailAddress) {
		if (emailAddress == null) {
			return false;
		}

		EmailAddress newEmailAddress = (EmailAddress) this.sessionFactory
				.getCurrentSession().load(EmailAddress.class,
						emailAddress.getId());
		if (newEmailAddress == null) {
			return false;
		}
		if (newEmailAddress.getType().equals("UKY")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean saveEmailAddress(EmailAddress emailAddress) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(emailAddress);
		return true;
	}
}
