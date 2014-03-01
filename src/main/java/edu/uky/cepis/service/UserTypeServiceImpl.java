/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import java.util.Set;

import edu.uky.cepis.dao.UserTypeDao;
import edu.uky.cepis.domain.UserClassification;
import edu.uky.cepis.domain.UserType;

/**
 * @author keerthi
 */
public class UserTypeServiceImpl implements UserTypeService {

	/**
	 * @uml.property  name="userTypeDao"
	 * @uml.associationEnd  
	 */
	private UserTypeDao userTypeDao;

	/**
	 * @param userTypeDao
	 *            the userTypeDao to set
	 * @uml.property name="userTypeDao"
	 */
	public void setUserTypeDao(UserTypeDao userTypeDao) {
		this.userTypeDao = userTypeDao;
	}

	/**
	 * @return the userTypeDao
	 * @uml.property name="userTypeDao"
	 */
	public UserTypeDao getUserTypeDao() {
		return userTypeDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UserTypeService#addUserClassficationToUserType(
	 * edu.uky.cepis.domain.UserClassification, edu.uky.cepis.domain.UserType)
	 */
	@Override
	public boolean addUserClassficationToUserType(
			UserClassification userClassification, UserType userType) {
		return this.getUserTypeDao().addUserClassficationToUserType(
				userClassification, userType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UserTypeService#createUserType(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public UserType createUserType(String typeCode, String shortDesc) {
		return this.getUserTypeDao().createUserType(typeCode, shortDesc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UserTypeService#deleteUserType(edu.uky.cepis.domain
	 * .UserType)
	 */
	@Override
	public boolean deleteUserType(UserType userType) {
		return this.getUserTypeDao().deleteUserType(userType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UserTypeService#findUserTypeByCode(java.lang.String
	 * )
	 */
	@Override
	public UserType findUserTypeByCode(String typeCode) {
		return this.getUserTypeDao().findUserTypeByCode(typeCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.UserTypeService#getUserTypeList()
	 */
	@Override
	public List<UserType> getUserTypeList() {
		return this.getUserTypeDao().getUserTypeList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UserTypeService#removeUserClassficationFromUserType
	 * (edu.uky.cepis.domain.UserClassification, edu.uky.cepis.domain.UserType)
	 */
	@Override
	public boolean removeUserClassficationFromUserType(
			UserClassification userClassification, UserType userType) {
		return this.getUserTypeDao().removeUserClassficationFromUserType(
				userClassification, userType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UserTypeService#saveUserType(edu.uky.cepis.domain
	 * .UserType)
	 */
	@Override
	public boolean saveUserType(UserType userType) {
		return this.getUserTypeDao().saveUserType(userType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UserTypeService#updateUserType(edu.uky.cepis.domain
	 * .UserType, java.lang.String, java.lang.String)
	 */
	@Override
	public UserType updateUserType(UserType userType, String typeCode,
			String shortDesc) {
		return this.getUserTypeDao().updateUserType(userType, typeCode,
				shortDesc);
	}

	@Override
	public Set<UserClassification> getUserClassificationListFromUserType(
			UserType userType) {

		return this.getUserTypeDao().getUserClassificationListFromUserType(
				userType);
	}

}
