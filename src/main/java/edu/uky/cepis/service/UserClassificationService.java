/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.domain.UserClassification;

/**
 * @author keerthi
 * 
 */
public interface UserClassificationService {
	public UserClassification createUserClassification(
			String classificationCode, String shortDesc, String desc,
			String status);

	public UserClassification updateUserClassification(
			UserClassification userClassification, String classificationCode,
			String shortDesc, String desc, String status);

	public boolean deleteUserClassification(
			UserClassification userClassification);

	public UserClassification findUserClassificationByCode(
			String classificationCode);

	public List<UserClassification> getUserClassificationList();

	public boolean saveUserClassification(UserClassification userClassification);
}
