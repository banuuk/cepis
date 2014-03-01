/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.List;
import java.util.Set;

import edu.uky.cepis.domain.UserClassification;
import edu.uky.cepis.domain.UserType;

/**
 * @author keerthi
 * 
 */
public interface UserTypeDao {

	public UserType createUserType(String typeCode, String shortDesc);

	public UserType updateUserType(UserType userType, String typeCode,
			String shortDesc);

	public boolean deleteUserType(UserType userType);

	public UserType findUserTypeByCode(String typeCode);

	public List<UserType> getUserTypeList();

	public boolean saveUserType(UserType userType);

	public boolean addUserClassficationToUserType(
			UserClassification userClassification, UserType userType);

	public boolean removeUserClassficationFromUserType(
			UserClassification userClassification, UserType userType);

	public Set<UserClassification> getUserClassificationListFromUserType(
			UserType userType);

}
