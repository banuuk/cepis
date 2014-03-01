/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.EmailAddressType;

/**
 * @author keerthi
 * 
 */
public class EmailAddressTypeDaoImpl implements EmailAddressTypeDao {

	private static Logger log = Logger.getLogger(EmailAddressTypeDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailAddressTypeDao#createEmailAddressType(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public EmailAddressType createEmailAddressType(String code, String desc) {
		EmailAddressType emailAddressType = new EmailAddressType(code, desc);
		if (emailAddressType == null) {
			return null;
		}
		if (!this.saveEmailAddressType(emailAddressType)) {
			return null;
		}
		return emailAddressType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailAddressTypeDao#deleteEmailAddressType(edu.uky.
	 * cepis.domain .EmailAddressType)
	 */
	@Override
	public boolean deleteEmailAddressType(EmailAddressType emailAddressType) {
		if (emailAddressType == null) {
			return false;
		}

		this.sessionFactory.getCurrentSession().delete(emailAddressType);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailAddressTypeDao#findEmailAddressTypeByCode(java
	 * .lang.String)
	 */
	@Override
	public EmailAddressType findEmailAddressTypeByCode(String code) {
		if (code == null || code.equals("")) {
			return null;
		}
		List<EmailAddressType> emailAddressTypes = new ArrayList<EmailAddressType>(
				0);

		String hql = "select a from EmailAddressType a where a.code ='" + code
				+ "'";
		emailAddressTypes = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (emailAddressTypes.size() > 0) {
			return emailAddressTypes.get(0);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.EmailAddressTypeDao#getEmailAddressTypeList()
	 */
	@Override
	public List<EmailAddressType> getEmailAddressTypeList() {
		List<EmailAddressType> emailAddressTypes = new ArrayList<EmailAddressType>(
				0);

		String hql = "select a from EmailAddressType a";
		emailAddressTypes = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		return emailAddressTypes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailAddressTypeDao#saveEmailAddressType(edu.uky.cepis
	 * .domain .EmailAddressType)
	 */
	@Override
	public boolean saveEmailAddressType(EmailAddressType emailAddressType) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(emailAddressType);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailAddressTypeDao#updateEmailAddressType(edu.uky.
	 * cepis.domain .EmailAddressType, java.lang.String, java.lang.String)
	 */
	@Override
	public EmailAddressType updateEmailAddressType(
			EmailAddressType emailAddressType, String code, String desc) {
		if (emailAddressType == null) {
			return null;
		}
		emailAddressType.setCode(code);
		emailAddressType.setDesc(desc);
		this.saveEmailAddressType(emailAddressType);
		return emailAddressType;
	}

}
