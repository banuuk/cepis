/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.List;

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
 * @author keerthi
 * 
 */
public interface UserCollegeProfileDao {
	public boolean addUserCollegeProfileToUser(User user, UserType userType,
			UserClassification userClassification, UKCollege ukCollege,
			UKDepartment ukDepartment, UKTerm startTerm, UKTerm endTerm,
			UKStatus status, CohortType cohortType, CohortTerm cohortTerm,
			String shortDesc);

	public boolean removeUserCollegeProfileFromUser(User user,
			UserCollegeProfile userCollegeProfile);

	public UserCollegeProfile updateUserCollegeProfile(User user,
			UserCollegeProfile UserCollegeProfile, UserType userType,
			UserClassification userClassification, UKCollege ukCollege,
			UKDepartment ukDepartment, UKTerm startTerm, UKTerm endTerm,
			UKStatus status, CohortType cohortType, CohortTerm cohortTerm,
			String shortDesc);

	public UserCollegeProfile findUserCollegeProfile(long usercollegeprofileid);

	public boolean saveUserCollegeProfile(UserCollegeProfile userCollegeProfile);

	public List<UserCollegeProfile> getUserCollegeProfiles(User user);


}
