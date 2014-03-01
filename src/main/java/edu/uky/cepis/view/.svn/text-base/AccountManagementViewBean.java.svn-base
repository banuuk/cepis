/**
 * 
 */
package edu.uky.cepis.view;

import java.util.ArrayList;
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
public class AccountManagementViewBean extends CepisWebView implements
		AccountManagementView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean addAddressToUserAccount(User user, String street1,
			String street2, String city, String state, String zip,
			String country, AddressType addressType) {
		return this.getAddressService().addAddressToUser(user, street1,
				street2, city, state, zip, country, addressType);
	}

	@Override
	public boolean addEmailAddressToUserAccount(User user, String address,
			EmailAddressType type) {
		return this.getEmailAddressService().addEmailAddressToUser(user,
				address, type);
	}

	@Override
	public boolean addPhoneToUserAccount(User user, String phoneNo, String ext,
			String memo, PhoneType phoneType) {
		return this.getPhoneService().addPhoneToUser(user, phoneNo, ext, memo,
				phoneType);
	}

	@Override
	public User addRogueUser(String uid, String ukID, String ssn,
			String username, String lName, String mName, String fName,
			String maidenName, String fullName, String suffix, String gender,
			String title, Date dOB, int badgeHolder) {
		return this.getUserService().addUser(uid, ukID, ssn, username, lName,
				mName, fName, maidenName, fullName, suffix, gender, title, dOB,
				badgeHolder);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.view.AccountManagementView#addRolesToUserAccount(edu.uky
	 * .cepis.domain.User, java.util.List)
	 */
	@Override
	public boolean addRolesToUserAccount(User user, List<Role> userRoles) {
		return this.getRoleservice().addRolesToUserAccount(user, userRoles);

	}

	@Override
	public Role findRoleByName(String roleName) {
		return this.getRoleservice().findByName(roleName);
	}

	@Override
	public boolean addRolesToUserAccount(User selectedUser,
			List<Role> selectedRoles, WorkingSet selectedWorkingSet) {
		boolean result = this.getRoleservice().addRolesToUserAccount(
				selectedUser, selectedRoles);
		if (!result) {
			return false;
		}
		if (selectedWorkingSet != null) {
			this.getWorkingSetService().setCustomWorkingSetToUser(
					selectedWorkingSet, selectedUser);
		}
		return true;
	}

	@Override
	public boolean addUserCollegeProfileToUserAccount(User user,
			UserType selectedUserType,
			UserClassification selectedUserClassification,
			UKCollege selectedUkCollege, UKDepartment selectedUkDepartment,
			UKTerm selectedUKStartTerm, UKTerm selectedUKEndTerm,
			UKStatus selectedUKStatus, CohortType selectedCohortType,
			CohortTerm selectedCohortTerm, String shortDesc) {
		return this.getUserCollegeProfileService().addUserCollegeProfileToUser(
				user, selectedUserType, selectedUserClassification,
				selectedUkCollege, selectedUkDepartment, selectedUKStartTerm,
				selectedUKEndTerm, selectedUKStatus, selectedCohortType,
				selectedCohortTerm, shortDesc);
	}


	@Override
	public boolean addUserProgramProfileToUserAccount(User user,
			Program program, ProgramDomain programDomain,
			ProgramTrack programTrack, ProgramGroup programGroup,
			Advisor advisor, FacultyAdvisor facultyAdvisor, UKMajor ukMajor, 
			UKStatus ukStatus, UKTerm ukStartTerm,
			UKTerm ukAnticipatedCompleteTerm, UKTerm ukCompleteTerm,
			String finalGPA, Integer degreeAwarded, boolean hiddenToStudent,
			boolean recommendCertification, String shortDesc) {
		return this.getUserProgramProfileService().addUserProgramProfileToUser(
				user, program, programDomain, programTrack, programGroup,
				advisor, facultyAdvisor, ukMajor, ukStatus, ukStartTerm,
				ukAnticipatedCompleteTerm, ukCompleteTerm, finalGPA,
				degreeAwarded, hiddenToStudent, recommendCertification,
				shortDesc);
	}

	@Override
	public ReportUser createReportUser(User user, String email,
			int pdfExportType) {
		Role reportUserRole = this.getRoleservice().findByName(
				"ROLE_REPORT_USER");
		if (reportUserRole == null) {
			System.out.println("Cannot Add ROLE_REPORT_USER role to the user");
		}
		List<Role> userRoles = new ArrayList<Role>(1);
		userRoles.add(reportUserRole);
		this.addRolesToUserAccount(user, userRoles);
		return this.getUserService().createReportUser(user, email,
				pdfExportType);
	}

	@Override
	public List<Address> getAddressList(User user) {
		return this.getAddressService().getAddressList(user);
	}

	@Override
	public Role getCustomRole() {
		return this.getRoleservice().getCustomRole();
	}

	@Override
	public List<Role> getUserRoles(User user) {
		List<Role> roles = new ArrayList<Role>(0);
		if (user == null) {
			return roles;
		}
		return this.getRoleservice().getUserRoles(user);
	}

	@Override
	public List<EmailAddress> getEmailAddressList(User user) {
		return this.getEmailAddressService().getEmailAddresses(user);
	}

	@Override
	public List<Phone> getPhoneList(User user) {
		return this.getPhoneService().getPhoneList(user);
	}

	@Override
	public List<Role> getRoleList() {
		return this.getRoleservice().getRoleList();
	}

	@Override
	public List<UserCollegeProfile> getUserCollegeProfiles(User user) {

		return this.getUserCollegeProfileService().getUserCollegeProfiles(user);
	}

	@Override
	public List<UserProgramProfile> getUserProgramProfiles(User user) {
		return this.getUserProgramProfileService().getUserProgramProfiles(user);
	}

	@Override
	public List<Role> getUserRoleList(User user) {
		return this.getRoleservice().getUserRoles(user);
	}

	@Override
	public boolean removeAddressFromUserAccount(User user, Address address) {
		return this.getAddressService().removeAddressFromUser(user, address);
	}

	@Override
	public boolean removeEmailAddressFromUserAccount(User user,
			EmailAddress emailAddress) {
		return this.getEmailAddressService().removeEmailAddressFromUser(user,
				emailAddress);
	}

	@Override
	public boolean removePhoneFromUserAccount(User user, Phone phone) {
		return this.getPhoneService().removePhoneFromUser(user, phone);
	}

	@Override
	public boolean removeUserCollegeProfileFromUserAccount(User user,
			UserCollegeProfile selectedUserCollegeProfile) {

		return this.getUserCollegeProfileService()
				.removeUserCollegeProfileFromUser(user,
						selectedUserCollegeProfile);
	}


	@Override
	public boolean removeUserProgramProfileFromUserAccount(User user,
			UserProgramProfile userProgramProfile) {
		return this.getUserProgramProfileService()
				.removeUserProgramProfileFromUser(user, userProgramProfile);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.view.AccountManagementView#revokeRolesFromUserAccount(edu
	 * .uky.cepis.domain.User, java.util.List)
	 */
	@Override
	public boolean revokeRolesFromUserAccount(User user, List<Role> userRoles) {
		if (this.getRoleservice().revokeRolesFromUserAccount(user, userRoles)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAddressDetails(User user, Address address,
			String street1, String street2, String city, String state,
			String zip, String country, AddressType addressType) {
		if (this.getAddressService().updateAddress(user, address, street1,
				street2, city, state, zip, country, addressType) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateEmailAddressDetails(User user,
			EmailAddress emailAddress, String address, EmailAddressType type) {
		if (this.getEmailAddressService().updateEmailAddress(user,
				emailAddress, address, type) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePhoneDetails(User user, Phone phone, String phoneNo,
			String ext, String memo, PhoneType phoneType) {
		if (this.getPhoneService().updatePhone(user, phone, phoneNo, ext, memo,
				phoneType) != null) {
			return true;
		}
		return false;
	}

	@Override
	public Object updateUserCollegeProfile(User user,
			UserCollegeProfile selectedUserCollegeProfile,
			UserType selectedUserType,
			UserClassification selectedUserClassification,
			UKCollege selectedUkCollege, UKDepartment selectedUkDepartment,
			UKTerm selectedUKStartTerm, UKTerm selectedUKEndTerm,
			UKStatus selectedUKStatus, CohortType selectedCohortType,
			CohortTerm selectedCohortTerm, String shortDesc) {
		return this.getUserCollegeProfileService().updateUserCollegeProfile(
				user, selectedUserCollegeProfile, selectedUserType,
				selectedUserClassification, selectedUkCollege,
				selectedUkDepartment, selectedUKStartTerm,
				selectedUKEndTerm, selectedUKStatus, selectedCohortType,
				selectedCohortTerm, shortDesc);
	}
	
	@Override
	public UserProgramProfile updateUserProgramProfile(User user,
			UserProgramProfile userProgramProfile, Program program,
			ProgramDomain programDomain, ProgramTrack programTrack,
			ProgramGroup programGroup, Advisor advisor, FacultyAdvisor facultyAdvisor,
			UKMajor ukMajor, UKStatus ukStatus, UKTerm ukStartTerm,
			UKTerm ukAnticipatedCompleteTerm, UKTerm ukCompleteTerm,
			String finalGPA, Integer degreeAwarded, boolean hiddenToStudent,
			boolean recommendCertification, String shortDesc) {
		return this.getUserProgramProfileService().updateUserProgramProfile(
				user, userProgramProfile, program, programDomain, programTrack,
				programGroup, advisor, facultyAdvisor, ukMajor, ukStatus, ukStartTerm,
				ukAnticipatedCompleteTerm, ukCompleteTerm,
				finalGPA, degreeAwarded, hiddenToStudent,
				recommendCertification, shortDesc);
	}

	@Override
	public boolean setPrimaryEmailAddress(User user, String address) {
		EmailAddressType emailAddressType = this.getEmailAddressTypeService()
				.findEmailAddressTypeByCode("WEB");
		return this.getEmailAddressService().setPrimaryEmailAddress(user,
				address, emailAddressType);
	}

	@Override
	public User updateUser(User user, String uid, String ukID, String ssn,
			String username, String lName, String mName, String fName,
			String maidenName, String fullName, String suffix, String gender,
			String title, Date dOB, int badgeHolder) {

		return this.getUserService().updateUser(user, uid, ukID, ssn, username,
				lName, mName, fName, maidenName, fullName, suffix, gender,
				title, dOB, badgeHolder);
	}

	@Override
	public boolean removeUser(User user) {
		return this.getUserService().removeUser(user);
	}

	@Override
	public UserConfiguration updateUserConfiguration(User user,
			EmailAddress emailAddress, Phone phone) {
		return this.getUserService().updateUserConfiguration(user,
				emailAddress, phone);
	}

	@Override
	public EmailAddress getPrimaryEmailAddress(User user) {
		return this.getUserService().getPrimaryEmailAddress(user);
	}

	@Override
	public Phone getPrimaryPhone(User user) {
		return this.getUserService().getPrimaryPhone(user);
	}

	@Override
	public boolean addUsersToWorkingSet(WorkingSet ws, List<User> users) {
		return this.getWorkingSetService().addUsersToWorkingSet(ws, users);
	}

	@Override
	public boolean checkDuplicacy(String username, String ukID) {
		return this.getUserService().checkDuplicacy(username, ukID);
	}

	@Override
	public User addCEPISUser(User user, UserCollegeProfile userCollegeProfile,
			UserProgramProfile userProgramProfile,
			UserPersonalProfile userPersonalProfile, Phone phone,
			Address address, EmailAddress emailAddress, List<Role> roles,
			ReportUser reportUser) {
		return this.getUserService().addCEPISUser(user, userCollegeProfile,
				userProgramProfile, userPersonalProfile, phone, address,
				emailAddress, roles, reportUser);
	}
	
	@Override
	public List<Course> getAcademicProfile(User user) {
		return this.getUserAcademicProfileService().getCourseList(user);
	}

	@Override
	public List<StandardSet> getStandardSets(ProgramDomain programDomain) {
		return this.getProgramDomainService().getStandardSets(programDomain);
	}

	@Override
	public int addUserAssessmentProfiles(
			List<UserAssessmentProfile> userAssessmentProfiles,
			ProgramDomain progDomain, UKTerm ukTerm, int assessmentType) {
		return this.getUserAssessmentProfileService()
				.addUserAssessmentProfiles(userAssessmentProfiles, progDomain,
						ukTerm, assessmentType);
	}

	@Override
	public List<UserAssessmentProfile> getUserAssessmentProfiles(User user) {
		return this.getUserAssessmentProfileService()
				.getUserAssessmentProfiles(user);
	}

	@Override
	public boolean deleteUserAssessmentProfile(
			UserAssessmentProfile userAssessmentProfile) {
		return this.getUserAssessmentProfileService()
				.deleteUserAssessmentProfile(userAssessmentProfile);
	}

	@Override
	public List<UserProgramProfile> getStudentUserProgramProfiles(User user) {

		return this.getUserProgramProfileService()
				.getVisibleUserProgramProfiles(user);
	}

	@Override
	public List<HoldLift> getHoldLiftsByStudent(User user) {
		return this.getHoldLiftService().getHoldLiftsByStudent(user);
	}

	@Override
	public User updateUser(User user, String uid, String ukID, String ssn,
			String username, String lName, String lName1, String lName2,
			String lName3, String lName4, String preferredName, String mName,
			String fName, String maidenName, String fullName, String suffix,
			String gender, String title, Date dOB, int badgeHolder) {
		return this.getUserService().updateUser(user, uid, ukID, ssn, username,
				lName, lName1, lName2, lName3, lName4, preferredName, mName,
				fName, maidenName, fullName, suffix, gender, title, dOB,
				badgeHolder);
	}

	@Override
	public User addUser(String uid, String ukID, String ssn, String username,
			String lName, String lName1, String lName2, String lName3,
			String lName4, String preferredName, String mName, String fName,
			String maidenName, String fullName, String suffix, String gender,
			String title, Date dOB, int badgeHolder) {
		return this.getUserService().addUser(uid, ukID, ssn, username, lName,
				lName1, lName2, lName3, lName4, preferredName, mName, fName,
				maidenName, fullName, suffix, gender, title, dOB, badgeHolder);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.view.AccountManagementView#findUKCollegeByCode(java.lang
	 * .String)
	 */
	@Override
	public UKCollege findUKCollegeByCode(String ukCollegeCode) {
		return this.getUkCollegeService().findUKCollegeByCode(ukCollegeCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.view.AccountManagementView#findUKDepartmenteByCode(java
	 * .lang.String)
	 */
	@Override
	public UKDepartment findUKDepartmenteByCode(String uKDepartmentCode) {
		return this.getUkDepartmentService().findUKDepartmentByCode(
				uKDepartmentCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.view.AccountManagementView#findUserTypeByCode(java.lang
	 * .String)
	 */
	@Override
	public UserType findUserTypeByCode(String userTypeCode) {
		return this.getUserTypeService().findUserTypeByCode(userTypeCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.view.AccountManagementView#findUserClassificationByCode
	 * (java.lang.String)
	 */
	@Override
	public UserClassification findUserClassificationByCode(
			String userClassificationCode) {
		return this.getUserClassificationService()
				.findUserClassificationByCode(userClassificationCode);
	}

	@Override
	public boolean checkDuplicacy(String username) {
		return this.getUserService().checkDuplicacy(username);
	}

	@Override
	public User updatePassword(User user, String password) {
		return this.getUserService().updatePassword(user, password);
	}

	@Override
	public boolean disableUser(User user) {
		return this.getUserService().disableUser(user);
	}

	@Override
	public boolean enableUser(User user) {
		return this.getUserService().enableUser(user);
	}

	@Override
	public boolean updateUserAssessmentProfile(
			UserAssessmentProfile userAssessmentProfile) {
		return this.getUserAssessmentProfileService()
				.updateUserAssessmentProfiles(userAssessmentProfile);
	}

	@Override
	public int addArtifactToUserAssessmentProfile(
			UserAssessmentProfile userAssessmentProfile,
			List<Artifact> artifacts) {
		return this.getArtifactService().addArtifactToUserAssessmentProfile(
				userAssessmentProfile, artifacts);
	}

	@Override
	public int removeArtifactFromUserAssessmentProfile(
			UserAssessmentProfile userAssessmentProfile,
			List<Artifact> artifacts) {
		return this.getArtifactService()
				.removeArtifactFromUserAssessmentProfile(userAssessmentProfile,
						artifacts);
	}

	@Override
	public List<Artifact> getArtifactList(
			UserAssessmentProfile userAssessmentProfile) {
		return this.getArtifactService().getArtifactList(userAssessmentProfile);
	}

	@Override
	public Artifact findById(long id) {
		return this.getArtifactService().findById(id);
	}

	@Override
	public List<Artifact> getArtifactList(User user) {
		return this.getArtifactService().getArtifactList(user);
	}
	
	/*********************************USER PERSONAL PROFILE*********************************/
	@Override
	public boolean saveOrUpdateUserPersonalProfile(UserPersonalProfile userPersonalprofile) {
		return getUserPersonalProfileService().saveOrUpdateUserPersonalProfile(userPersonalprofile);
	}

	@Override
	public UserPersonalProfile getUserPersonalProfile(User user) {
		return getUserPersonalProfileService().getUserPersonalProfile(user);
	}

	@Override
	public boolean deleteUserPersonalProfile(UserPersonalProfile userPersonalProfile) {
		return getUserPersonalProfileService().deleteUserPersonalProfile(userPersonalProfile);
	}
	
	
}
