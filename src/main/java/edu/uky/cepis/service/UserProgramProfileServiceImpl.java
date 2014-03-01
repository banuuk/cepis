/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.UserProgramProfileDao;
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
 */
public class UserProgramProfileServiceImpl implements UserProgramProfileService {

	/**
	 * @uml.property name="userProgramProfileDao"
	 * @uml.associationEnd
	 */
	private UserProgramProfileDao userProgramProfileDao;

	/**
	 * @param userProgramProfileDao
	 *            the userProgramProfileDao to set
	 * @uml.property name="userProgramProfileDao"
	 */
	public void setUserProgramProfileDao(
			UserProgramProfileDao userProgramProfileDao) {
		this.userProgramProfileDao = userProgramProfileDao;
	}

	/**
	 * @return the userProgramProfileDao
	 * @uml.property name="userProgramProfileDao"
	 */
	public UserProgramProfileDao getUserProgramProfileDao() {
		return userProgramProfileDao;
	}

	@Override
	public boolean addUserProgramProfileToUser(User user, Program program,
			ProgramDomain programDomain, ProgramTrack programTrack,
			ProgramGroup programGroup, Advisor advisor, FacultyAdvisor facultyAdvisor, UKMajor ukMajor,
			UKStatus ukStatus, UKTerm ukStartTerm, 
			UKTerm ukAnticipatedCompleteTerm, UKTerm ukCompleteTerm,
			String finalGPA, Integer degreeAwarded, boolean hiddenToStudent,
			boolean recommendCertification, String shortDesc) {
		return this.getUserProgramProfileDao().addUserProgramProfileToUser(
				user, program, programDomain, programTrack,
				programGroup, advisor, facultyAdvisor, ukMajor, ukStatus, ukStartTerm,
				ukAnticipatedCompleteTerm, ukCompleteTerm,
				finalGPA, degreeAwarded, hiddenToStudent,
				recommendCertification, shortDesc);
	}

	@Override
	public UserProgramProfile findUserProgramProfile(String userprogramprofileid) {
		return this.getUserProgramProfileDao().findUserProgramProfile(
				userprogramprofileid);
	}

	@Override
	public List<UserProgramProfile> getUserProgramProfiles(User user) {
		return this.getUserProgramProfileDao().getUserProgramProfiles(user);
	}

	@Override
	public boolean removeUserProgramProfileFromUser(User user,
			UserProgramProfile userProgramProfile) {
		return this.getUserProgramProfileDao()
				.removeUserProgramProfileFromUser(user, userProgramProfile);
	}

	@Override
	public boolean saveUserProgramProfile(UserProgramProfile userProgramprofile) {
		return this.getUserProgramProfileDao().saveUserProgramProfile(
				userProgramprofile);
	}

	@Override
	public UserProgramProfile updateUserProgramProfile(User user,
			UserProgramProfile userProgramProfile, Program program,
			ProgramDomain programDomain, ProgramTrack programTrack,
			ProgramGroup programGroup, Advisor advisor, FacultyAdvisor facultyAdvisor, UKMajor ukMajor,
			UKStatus ukStatus, UKTerm ukStartTerm,
			UKTerm ukAnticipatedCompleteTerm, UKTerm ukCompleteTerm,
			String finalGPA, Integer degreeAwarded, boolean hiddenToStudent,
			boolean recommendCertification, String shortDesc) {
		return this.getUserProgramProfileDao().updateUserProgramProfile(
				user, userProgramProfile, program, programDomain, programTrack,
				programGroup, advisor, facultyAdvisor, ukMajor, ukStatus, ukStartTerm,
				ukAnticipatedCompleteTerm, ukCompleteTerm,
				finalGPA, degreeAwarded, hiddenToStudent,
				recommendCertification, shortDesc);
	}

	@Override
	public boolean findUserProgramProfile(User user, Program program,
			ProgramDomain programDomain, ProgramTrack programTrack,
			ProgramGroup programGroup, Advisor advisor, FacultyAdvisor facultyAdvisor,
			UKMajor ukMajor, UKStatus ukStatus, UKTerm ukStartTerm, 
			UKTerm ukCompleteTerm, Integer degreeAwarded, String shortDesc) {
		return this.getUserProgramProfileDao().findUserProgramProfile(user,
				program, programDomain, programTrack, programGroup, advisor,
				facultyAdvisor, ukMajor, ukStatus, ukStartTerm, ukCompleteTerm,
				degreeAwarded, shortDesc);
	}

	@Override
	public Advisor getStudentAdvisor(User user) {
		return this.getUserProgramProfileDao().getStudentAdvisor(user);
	}

	@Override
	public List<UserProgramProfile> getVisibleUserProgramProfiles(User user) {
		return this.getUserProgramProfileDao().getVisibleUserProgramProfiles(
				user);
	}

}
