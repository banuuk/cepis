/**
 * 
 */
package edu.uky.cepis.view;

import java.util.Date;
import java.util.List;

import org.efs.openreports.objects.ReportUser;

import edu.uky.cepis.domain.Address;
import edu.uky.cepis.domain.AddressType;
import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.Artifact;
import edu.uky.cepis.domain.CohortTerm;
import edu.uky.cepis.domain.CohortType;
import edu.uky.cepis.domain.Course;
import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.EmailAddressType;
import edu.uky.cepis.domain.FacultyAdvisor;
import edu.uky.cepis.domain.HoldLift;
import edu.uky.cepis.domain.Phone;
import edu.uky.cepis.domain.PhoneType;
import edu.uky.cepis.domain.Role;
import edu.uky.cepis.domain.StandardSet;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserAssessmentProfile;
import edu.uky.cepis.domain.UserClassification;
import edu.uky.cepis.domain.UserCollegeProfile;
import edu.uky.cepis.domain.UserConfiguration;
import edu.uky.cepis.domain.UserPersonalProfile;
import edu.uky.cepis.domain.UserProgramProfile;
import edu.uky.cepis.domain.UserType;
import edu.uky.cepis.domain.WorkingSet;
import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.ProgramGroup;
import edu.uky.cepis.domain.component.ProgramTrack;
import edu.uky.cepis.domain.component.UKCollege;
import edu.uky.cepis.domain.component.UKDepartment;
import edu.uky.cepis.domain.component.UKMajor;
import edu.uky.cepis.domain.component.UKStatus;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author keerthi
 * 
 */
public interface AccountManagementView {

	/**
	 * Add Set of Roles to an User Account<br/>
	 * <br/>
	 * 
	 * @param user
	 * @param userRoles
	 * @return boolean
	 * @see User
	 * @see Role
	 */
	public abstract boolean addRolesToUserAccount(User user,
			List<Role> userRoles);

	public abstract boolean addPhoneToUserAccount(User user, String phoneNo,
			String ext, String memo, PhoneType phoneType);

	/**
	 * Revoke Set of Roles from an User Account<br/>
	 * <br/>
	 * 
	 * @param user
	 * @param userRoles
	 * @return boolean
	 * @see User
	 * @see Role
	 */
	public abstract boolean revokeRolesFromUserAccount(User user,
			List<Role> userRoles);

	public abstract List<Role> getRoleList();

	public abstract List<Role> getUserRoleList(User user);

	public abstract List<Phone> getPhoneList(User user);

	public boolean removePhoneFromUserAccount(User user, Phone phone);

	public boolean updatePhoneDetails(User user, Phone phone, String phoneNo,
			String ext, String memo, PhoneType phoneType);

	public List<Address> getAddressList(User user);

	public boolean addAddressToUserAccount(User user, String street1,
			String street2, String city, String state, String zip,
			String country, AddressType addressType);

	public boolean removeAddressFromUserAccount(User user, Address address);

	public boolean updateAddressDetails(User user, Address address,
			String street1, String street2, String city, String state,
			String zip, String country, AddressType addressType);

	public boolean addEmailAddressToUserAccount(User user, String address,
			EmailAddressType type);

	public List<EmailAddress> getEmailAddressList(User user);

	public boolean removeEmailAddressFromUserAccount(User user,
			EmailAddress emailAddress);

	public boolean updateEmailAddressDetails(User user,
			EmailAddress emailAddress, String address, EmailAddressType type);

	public abstract User updateUser(User user, String uid, String ukID,
			String ssn, String username, String lName, String mName,
			String fName, String maidenName, String fullName, String suffix,
			String gender, String title, Date dOB, int badgeHolder);

	public abstract User updateUser(User user, String uid, String ukID,
			String ssn, String username, String lName, String lName1,
			String lName2, String lName3, String lName4, String preferredName,
			String mName, String fName, String maidenName, String fullName,
			String suffix, String gender, String title, Date dOB,
			int badgeHolder);

	public abstract User addUser(String uid, String ukID, String ssn,
			String username, String lName, String lName1, String lName2,
			String lName3, String lName4, String preferredName, String mName,
			String fName, String maidenName, String fullName, String suffix,
			String gender, String title, Date dOB, int badgeHolder);

	public List<UserProgramProfile> getUserProgramProfiles(User user);

	public boolean addUserProgramProfileToUserAccount(User user,
			Program program, ProgramDomain programDomain,
			ProgramTrack programTrack, ProgramGroup programGroup,
			Advisor advisor, FacultyAdvisor facultyAdvisor, UKMajor ukMajor, 
			UKStatus ukStatus, UKTerm ukStartTerm,
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

	public abstract List<UserProgramProfile> getStudentUserProgramProfiles(
			User user);

	public boolean removeUserProgramProfileFromUserAccount(User user,
			UserProgramProfile userProgramProfile);

	public abstract boolean addUserCollegeProfileToUserAccount(User user,
			UserType selectedUserType,
			UserClassification selectedUserClassification,
			UKCollege selectedUkCollege, UKDepartment selectedUkDepartment,
			UKTerm selectedUKStartTerm, UKTerm selectedUKEndTerm,
			UKStatus selectedUKStatus, CohortType selectedCohortType,
			CohortTerm selectedCohortTerm, String shortDesc);

	public abstract Object updateUserCollegeProfile(User user,
			UserCollegeProfile selectedUserCollegeProfile,
			UserType selectedUserType,
			UserClassification selectedUserClassification,
			UKCollege selectedUkCollege, UKDepartment selectedUkDepartment,
			UKTerm selectedUKStartTerm, UKTerm selectedUKEndTerm,
			UKStatus selectedUKStatus, CohortType selectedCohortType,
			CohortTerm selectedCohortTerm, String shortDesc);

	public abstract List<UserCollegeProfile> getUserCollegeProfiles(User user);

	public abstract boolean removeUserCollegeProfileFromUserAccount(User user,
			UserCollegeProfile selectedUserCollegeProfile);

	public Role getCustomRole();

	public abstract boolean addRolesToUserAccount(User selectedUser,
			List<Role> selectedRoles, WorkingSet selectedWorkingSet);

	public abstract User addRogueUser(String uid, String ukID, String ssn,
			String username, String lName, String mName, String fName,
			String maidenName, String fullName, String suffix, String gender,
			String title, Date dOB, int badgeHolder);

	public abstract ReportUser createReportUser(User user, String email,
			int pdfExportType);

	public abstract List<Role> getUserRoles(User user);

	public boolean setPrimaryEmailAddress(User user, String address);

	public abstract boolean removeUser(User user);

	public abstract UserConfiguration updateUserConfiguration(User user,
			EmailAddress emailAddress, Phone phone);

	public abstract Phone getPrimaryPhone(User user);

	public abstract EmailAddress getPrimaryEmailAddress(User user);

	public abstract boolean addUsersToWorkingSet(WorkingSet ws, List<User> users);

	public abstract boolean checkDuplicacy(String username, String ukID);

	public abstract User addCEPISUser(User user,
			UserCollegeProfile userCollegeProfile,
			UserProgramProfile userProgramProfile,
			UserPersonalProfile userPersonalProfile, Phone phone,
			Address address, EmailAddress emailAddress, List<Role> roles,
			ReportUser reportUser);

	public List<Course> getAcademicProfile(User user);

	public List<StandardSet> getStandardSets(ProgramDomain programDomain);

	public abstract int addUserAssessmentProfiles(
			List<UserAssessmentProfile> userAssessmentProfiles,
			ProgramDomain progDomain, UKTerm ukTerm, int assessmentType);

	public abstract boolean updateUserAssessmentProfile(
			UserAssessmentProfile userAssessmentProfile);

	public abstract List<UserAssessmentProfile> getUserAssessmentProfiles(
			User user);

	public abstract boolean deleteUserAssessmentProfile(
			UserAssessmentProfile userAssessmentProfile);
	
	public abstract int addArtifactToUserAssessmentProfile(
			UserAssessmentProfile userAssessmentProfile,
			List<Artifact> artifacts);

	public abstract int removeArtifactFromUserAssessmentProfile(
			UserAssessmentProfile userAssessmentProfile,
			List<Artifact> artifacts);

	public abstract List<Artifact> getArtifactList(
			UserAssessmentProfile userAssessmentProfile);
	public abstract List<Artifact> getArtifactList(User user);

	public abstract Artifact findById(long id);

	public abstract List<HoldLift> getHoldLiftsByStudent(User user);

	public abstract UKCollege findUKCollegeByCode(String ukCollegeCode);

	public abstract UKDepartment findUKDepartmenteByCode(String ukDepartmentCode);

	public abstract UserType findUserTypeByCode(String userTypeCode);

	public abstract UserClassification findUserClassificationByCode(
			String userClassificationCode);

	public abstract boolean checkDuplicacy(String username);

	public abstract Role findRoleByName(String roleName);

	public abstract User updatePassword(User user, String password);

	public abstract boolean disableUser(User user);

	public abstract boolean enableUser(User user);
	
	/*********************************USER PERSONAL PROFILE*********************************/
	public abstract boolean saveOrUpdateUserPersonalProfile(UserPersonalProfile userPersonalprofile);
	
	public abstract UserPersonalProfile getUserPersonalProfile(User user);
	
	public abstract boolean deleteUserPersonalProfile(UserPersonalProfile userPersonalProfile);
	
	
}
