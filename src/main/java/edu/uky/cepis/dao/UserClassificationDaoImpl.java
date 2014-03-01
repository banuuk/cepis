/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.UserClassification;

/**
 * @author keerthi
 * 
 */
public class UserClassificationDaoImpl implements UserClassificationDao {

	private static Logger log = Logger
			.getLogger(UserClassificationDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UserClassificationDao#createUserClassification(java
	 * .lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public UserClassification createUserClassification(
			String classificationCode, String shortDesc, String desc,
			String status) {
		UserClassification userClassification = new UserClassification(
				classificationCode, shortDesc, desc, status);
		this.saveUserClassification(userClassification);
		return userClassification;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UserClassificationDao#deleteUserClassification(edu.
	 * uky.cepis.domain.UserClassification)
	 */
	@Override
	public boolean deleteUserClassification(
			UserClassification userClassification) {
		if (userClassification == null)
			return false;

		this.sessionFactory.getCurrentSession().delete(userClassification);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UserClassificationDao#findUserClassificationByCode(
	 * java.lang.String)
	 */
	@Override
	public UserClassification findUserClassificationByCode(
			String classificationCode) {
		UserClassification userClassification = null;
		List<UserClassification> userClassifications = new ArrayList<UserClassification>(
				0);

		String hql = "select a from UserClassification a where a.classificationCode = '"
				+ classificationCode + "'";
		userClassifications = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (userClassifications.isEmpty())
			return null;
		userClassification = userClassifications.get(0);
		if (userClassification == null)
			return null;
		return userClassification;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UserClassificationDao#getUserClassificationList()
	 */
	@Override
	public List<UserClassification> getUserClassificationList() {
		List<UserClassification> userClassifications = new ArrayList<UserClassification>(
				0);

		String hql = "select a from UserClassification a order by status,shortDesc";
		userClassifications = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();

		return userClassifications;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UserClassificationDao#saveUserClassification(edu.uky
	 * .cepis.domain.UserClassification)
	 */
	@Override
	public boolean saveUserClassification(UserClassification userClassification) {
		if (userClassification == null)
			return false;

		this.sessionFactory.getCurrentSession()
				.saveOrUpdate(userClassification);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UserClassificationDao#updateUserClassification(edu.
	 * uky.cepis.domain.UserClassification, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public UserClassification updateUserClassification(
			UserClassification userClassification, String classificationCode,
			String shortDesc, String desc, String status) {
		if (userClassification == null) {
			return null;
		}
		userClassification.setClassificationCode(classificationCode);
		userClassification.setDescription(desc);
		userClassification.setShortDesc(shortDesc);
		userClassification.setStatus(status);
		this.saveUserClassification(userClassification);
		return userClassification;
	}

}
