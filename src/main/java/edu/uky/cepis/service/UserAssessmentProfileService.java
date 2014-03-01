/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserAssessmentProfile;
import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author keerthi
 * 
 */
public interface UserAssessmentProfileService {

	public abstract List<UserAssessmentProfile> getUserAssessmentProfiles(
			User user);

	public abstract int addUserAssessmentProfiles(
			List<UserAssessmentProfile> userAssessmentProfiles,
			ProgramDomain progDomain, UKTerm ukTerm, int assessmentType);

	public abstract boolean deleteUserAssessmentProfile(
			UserAssessmentProfile userAssessmentProfile);
	
	public abstract boolean updateUserAssessmentProfiles(
			UserAssessmentProfile userAssessmentProfile);

}
