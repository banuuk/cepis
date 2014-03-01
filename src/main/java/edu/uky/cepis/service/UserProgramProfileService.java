/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.FacultyAdvisor;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserProgramProfile;
import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.ProgramGroup;
import edu.uky.cepis.domain.component.ProgramTrack;
import edu.uky.cepis.domain.component.UKMajor;
import edu.uky.cepis.domain.component.UKStatus;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author keerthi
 * 
 */
public interface UserProgramProfileService {
	public boolean removeUserProgramProfileFromUser(User user,
			UserProgramProfile userProgramProfile);

	public boolean findUserProgramProfile(User user, Program program,
			ProgramDomain programDomain, ProgramTrack programTrack,
			ProgramGroup programGroup, Advisor advisor, FacultyAdvisor facultyAdvisor,
			UKMajor ukMajor, UKStatus ukStatus, UKTerm ukStartTerm, 
			UKTerm ukCompleteTerm, Integer degreeAwarded, String shortDesc);

	public UserProgramProfile findUserProgramProfile(String userprogramprofileid);

	public boolean saveUserProgramProfile(UserProgramProfile userProgramprofile);

	public List<UserProgramProfile> getUserProgramProfiles(User user);

	public boolean addUserProgramProfileToUser(User user, Program program,
			ProgramDomain programDomain, ProgramTrack programTrack,
			ProgramGroup programGroup, Advisor advisor, FacultyAdvisor facultyAdvisor,
			UKMajor ukMajor, UKStatus ukStatus, UKTerm ukStartTerm, 
			UKTerm ukAnticipatedCompleteTerm, UKTerm ukCompleteTerm,
			String finalGPA, Integer degreeAwarded, boolean hiddenToStudent,
			boolean recommendCertification, String shortDesc);

	public UserProgramProfile updateUserProgramProfile(User user,
			UserProgramProfile userProgramProfile, Program program,
			ProgramDomain programDomain, ProgramTrack programTrack,
			ProgramGroup programGroup, Advisor advisor, FacultyAdvisor facultyAdvisor,
			UKMajor ukMajor, UKStatus ukStatus, UKTerm ukStartTerm,
			UKTerm ukAnticipatedCompleteTerm, UKTerm ukCompleteTerm,
			String finalGPA, Integer degreeAwarded, boolean hiddenToStudent,
			boolean recommendCertification, String shortDesc);

	public abstract Advisor getStudentAdvisor(User user);

	public abstract List<UserProgramProfile> getVisibleUserProgramProfiles(
			User user);
}
