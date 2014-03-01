/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.UserCollegeProfileDao;
import edu.uky.cepis.domain.CohortTerm;
import edu.uky.cepis.domain.CohortType;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserClassification;
import edu.uky.cepis.domain.UserCollegeProfile;
import edu.uky.cepis.domain.UserType;
import edu.uky.cepis.domain.component.UKCollege;
import edu.uky.cepis.domain.component.UKDepartment;
import edu.uky.cepis.domain.component.UKStatus;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * 
 * @author  keerthi
 * @author  cawalk4
 * 
 */
public class UserCollegeProfileServiceImpl implements UserCollegeProfileService {

	private UserCollegeProfileDao userCollegeProfileDao;


	@Override
	public boolean addUserCollegeProfileToUser(User user, UserType userType,
			UserClassification userClassification, UKCollege ukCollege,
			UKDepartment ukDepartment, UKTerm startTerm, UKTerm endTerm,
			UKStatus status, CohortType cohortType, CohortTerm cohortTerm,
			String shortDesc) {
		return this.getUserCollegeProfileDao().addUserCollegeProfileToUser(
				user, userType, userClassification, ukCollege, ukDepartment,
				startTerm, endTerm, status, cohortType, cohortTerm,
				shortDesc);
	}

	@Override
	public UserCollegeProfile findUserCollegeProfile(long usercollegeprofileid) {
		return this.getUserCollegeProfileDao().findUserCollegeProfile(
				usercollegeprofileid);
	}

	@Override
	public List<UserCollegeProfile> getUserCollegeProfiles(User user) {
		return this.getUserCollegeProfileDao().getUserCollegeProfiles(user);
	}

	@Override
	public boolean removeUserCollegeProfileFromUser(User user,
			UserCollegeProfile userCollegeProfile) {
		return this.getUserCollegeProfileDao()
				.removeUserCollegeProfileFromUser(user, userCollegeProfile);
	}

	@Override
	public boolean saveUserCollegeProfile(UserCollegeProfile userCollegeProfile) {
		return this.getUserCollegeProfileDao().saveUserCollegeProfile(
				userCollegeProfile);
	}

	@Override
	public UserCollegeProfile updateUserCollegeProfile(User user,
			UserCollegeProfile UserCollegeProfile, UserType userType,
			UserClassification userClassification, UKCollege ukCollege,
			UKDepartment ukDepartment, UKTerm startTerm, UKTerm endTerm,
			UKStatus status, CohortType cohortType, CohortTerm cohortTerm,
			String shortDesc) {
		return this.getUserCollegeProfileDao().updateUserCollegeProfile(user,
				UserCollegeProfile, userType, userClassification, ukCollege,
				ukDepartment, startTerm, endTerm, status, cohortType,
				cohortTerm, shortDesc);
	}

	public UserCollegeProfileDao getUserCollegeProfileDao() {
		return userCollegeProfileDao;
	}

	public void setUserCollegeProfileDao(
			UserCollegeProfileDao userCollegeProfileDao) {
		this.userCollegeProfileDao = userCollegeProfileDao;
	}

}
