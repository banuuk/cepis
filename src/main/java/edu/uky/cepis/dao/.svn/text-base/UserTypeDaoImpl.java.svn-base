/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.UserClassification;
import edu.uky.cepis.domain.UserType;
import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;

/**
 * @author keerthi
 * 
 */
public class UserTypeDaoImpl implements UserTypeDao {

	private static Logger log = Logger.getLogger(UserTypeDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UserTypeDao#addUserClassficationToUserType(edu.uky.
	 * cepis.domain.UserClassification, edu.uky.cepis.domain.UserType)
	 */
	@Override
	public boolean addUserClassficationToUserType(
			UserClassification userClassification, UserType userType) {
		if (userType == null)
			return false;
		if (userClassification == null)
			return false;
		UserType newUserType = (UserType) this.sessionFactory
				.getCurrentSession().load(UserType.class,
						userType.getTypeCode());
		newUserType.getUserClassifications().add(userClassification);
		this.saveUserType(newUserType);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UserTypeDao#createUserType(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public UserType createUserType(String typeCode, String shortDesc) {
		UserType userType = new UserType(typeCode, shortDesc);
		this.saveUserType(userType);
		return userType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UserTypeDao#deleteUserType(edu.uky.cepis.domain.UserType
	 * )
	 */
	@Override
	public boolean deleteUserType(UserType userType) {
		if (userType == null)
			return false;

		this.sessionFactory.getCurrentSession().delete(userType);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UserTypeDao#findUserTypeByCode(java.lang.String)
	 */
	@Override
	public UserType findUserTypeByCode(String typeCode) {
		UserType userType = null;
		List<UserType> userTypes = new ArrayList<UserType>(0);

		String hql = "select a from UserType a where a.typeCode = '" + typeCode
				+ "'";
		userTypes = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (userTypes.isEmpty())
			return null;
		userType = userTypes.get(0);
		if (userType == null)
			return null;
		return userType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UserTypeDao#getUserTypeList()
	 */
	@Override
	public List<UserType> getUserTypeList() {
		List<UserType> userTypes = new ArrayList<UserType>(0);

		String hql = "select a from UserType a ";
		userTypes = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (userTypes.isEmpty())
			return null;

		return userTypes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UserTypeDao#removeUserClassficationFromUserType(edu
	 * .uky.cepis.domain.UserClassification, edu.uky.cepis.domain.UserType)
	 */
	@Override
	public boolean removeUserClassficationFromUserType(
			UserClassification userClassification, UserType userType) {
		if (userType == null)
			return false;
		if (userClassification == null)
			return false;
		UserType newUserType = (UserType) this.sessionFactory
				.getCurrentSession().load(UserType.class,
						userType.getTypeCode());
		newUserType.getUserClassifications().remove(userClassification);
		this.saveUserType(newUserType);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UserTypeDao#saveUserType(edu.uky.cepis.domain.UserType)
	 */
	@Override
	public boolean saveUserType(UserType userType) {
		if (userType == null) {
			return false;
		}

		this.sessionFactory.getCurrentSession().saveOrUpdate(userType);
		return true;
	}

	@Override
	public Set<UserClassification> getUserClassificationListFromUserType(
			UserType userType) {
		Set<UserClassification> userClassifications = new HashSet<UserClassification>(
				0);
		if (userType == null) {
			return userClassifications;
		}

		UserType newUserType = (UserType) this.sessionFactory
				.getCurrentSession().load(UserType.class,
						userType.getTypeCode());
		if (newUserType == null) {
			return userClassifications;
		}
		userClassifications = newUserType.getUserClassifications();
		return userClassifications;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UserTypeDao#updateUserType(edu.uky.cepis.domain.UserType
	 * , java.lang.String, java.lang.String)
	 */
	@Override
	public UserType updateUserType(UserType userType, String typeCode,
			String shortDesc) {
		if (userType == null) {
			return null;
		}
		userType.setShortDesc(shortDesc);
		userType.setTypeCode(typeCode);
		this.saveUserType(userType);
		return userType;
	}

}
