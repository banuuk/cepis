/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.UserAssessmentProfileDao;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserAssessmentProfile;
import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author keerthi
 */
public class UserAssessmentProfileServiceImpl implements
		UserAssessmentProfileService {

	private UserAssessmentProfileDao userAssessmentProfileDao;

	@Override
	public int addUserAssessmentProfiles(
			List<UserAssessmentProfile> userAssessmentProfiles,
			ProgramDomain progDomain, UKTerm ukTerm, int assessmentType) {
		return this.getUserAssessmentProfileDao().addUserAssessmentProfiles(
				userAssessmentProfiles, progDomain, ukTerm, assessmentType);
	}

	@Override
	public List<UserAssessmentProfile> getUserAssessmentProfiles(User user) {
		return this.getUserAssessmentProfileDao().getUserAssessmentProfiles(
				user);
	}

	@Override
	public boolean deleteUserAssessmentProfile(
			UserAssessmentProfile userAssessmentProfile) {
		return this.getUserAssessmentProfileDao().deleteUserAssessmentProfile(
				userAssessmentProfile);
	}

	/**
	 * @return the userAssessmentProfileDao
	 */
	public UserAssessmentProfileDao getUserAssessmentProfileDao() {
		return userAssessmentProfileDao;
	}

	/**
	 * @param userAssessmentProfileDao
	 *            the userAssessmentProfileDao to set
	 */
	public void setUserAssessmentProfileDao(
			UserAssessmentProfileDao userAssessmentProfileDao) {
		this.userAssessmentProfileDao = userAssessmentProfileDao;
	}

	@Override
	public boolean updateUserAssessmentProfiles(
			UserAssessmentProfile userAssessmentProfile) {
		return this.getUserAssessmentProfileDao().updateUserAssessmentProfile(
				userAssessmentProfile);
	}

}
