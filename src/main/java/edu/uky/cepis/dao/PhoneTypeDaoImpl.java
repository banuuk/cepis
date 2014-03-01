/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.PhoneType;

/**
 * @author keerthi
 * 
 */
public class PhoneTypeDaoImpl implements PhoneTypeDao {

	private static Logger log = Logger.getLogger(PhoneTypeDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.PhoneTypeDao#createPhoneType(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public PhoneType createPhoneType(String code, String desc) {
		PhoneType phoneType = new PhoneType(code, desc);
		if (phoneType == null) {
			return null;
		}
		if (!this.savePhoneType(phoneType)) {
			return null;
		}
		return phoneType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.PhoneTypeDao#deletePhoneType(edu.uky.cepis.domain
	 * .PhoneType)
	 */
	@Override
	public boolean deletePhoneType(PhoneType phoneType) {
		if (phoneType == null) {
			return false;
		}

		this.sessionFactory.getCurrentSession().delete(phoneType);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.PhoneTypeDao#findPhoneTypeByCode(java.lang.String)
	 */
	@Override
	public PhoneType findPhoneTypeByCode(String code) {
		if (code == null || code.equals("")) {
			return null;
		}
		List<PhoneType> phoneTypes = new ArrayList<PhoneType>(0);

		String hql = "select a from PhoneType a where a.code ='" + code + "'";
		phoneTypes = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (phoneTypes.size() > 0) {
			return phoneTypes.get(0);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.PhoneTypeDao#getPhoneTypeList()
	 */
	@Override
	public List<PhoneType> getPhoneTypeList() {
		List<PhoneType> phoneTypes = new ArrayList<PhoneType>(0);

		String hql = "select a from PhoneType a";
		phoneTypes = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return phoneTypes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.PhoneTypeDao#savePhoneType(edu.uky.cepis.domain
	 * .PhoneType)
	 */
	@Override
	public boolean savePhoneType(PhoneType phoneType) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(phoneType);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.PhoneTypeDao#updatePhoneType(edu.uky.cepis.domain
	 * .PhoneType, java.lang.String, java.lang.String)
	 */
	@Override
	public PhoneType updatePhoneType(PhoneType phoneType, String code,
			String desc) {
		if (phoneType == null) {
			return null;
		}
		phoneType.setCode(code);
		phoneType.setDesc(desc);
		this.savePhoneType(phoneType);
		return phoneType;
	}

}
