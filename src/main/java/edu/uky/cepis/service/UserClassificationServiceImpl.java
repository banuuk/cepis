/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.UserClassificationDao;
import edu.uky.cepis.domain.UserClassification;

/**
 * 
 * @author  keerthi
 * @author  cawalk4
 * 
 */
public class UserClassificationServiceImpl implements UserClassificationService {

	private UserClassificationDao userClassificationDao;


	@Override
	public UserClassification createUserClassification(
	String classificationCode, String shortDesc, String desc,String status) {
		return this.getUserClassificationDao().createUserClassification(
				classificationCode, shortDesc, desc, status);
	}

	@Override
	public boolean deleteUserClassification(
			UserClassification userClassification) {
		return this.getUserClassificationDao().deleteUserClassification(
				userClassification);
	}

	@Override
	public UserClassification findUserClassificationByCode(
			String classificationCode) {
		return this.getUserClassificationDao().findUserClassificationByCode(
				classificationCode);
	}

	@Override
	public List<UserClassification> getUserClassificationList() {
		return this.getUserClassificationDao().getUserClassificationList();
	}

	@Override
	public boolean saveUserClassification(UserClassification userClassification) {
		return this.getUserClassificationDao().saveUserClassification(
				userClassification);
	}

	@Override
	public UserClassification updateUserClassification(
			UserClassification userClassification, String classificationCode,
			String shortDesc, String desc, String status) {
		return this.getUserClassificationDao()
				.updateUserClassification(userClassification,
						classificationCode, shortDesc, desc, status);
	}
	
	public void setUserClassificationDao(
			UserClassificationDao userClassificationDao) {
		this.userClassificationDao = userClassificationDao;
	}

	
	public UserClassificationDao getUserClassificationDao() {
		return userClassificationDao;
	}

}
