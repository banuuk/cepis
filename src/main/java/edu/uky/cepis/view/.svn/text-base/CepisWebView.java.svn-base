/**
 * 
 */
package edu.uky.cepis.view;

import java.io.Serializable;

import edu.uky.cepis.service.AddressService;
import edu.uky.cepis.service.AddressTypeService;
import edu.uky.cepis.service.AdvisingSessionService;
import edu.uky.cepis.service.AdvisingSessionSlotService;
import edu.uky.cepis.service.AdvisorService;
import edu.uky.cepis.service.ApplicationStatusService;
import edu.uky.cepis.service.ArtifactService;
import edu.uky.cepis.service.AttendeeService;
import edu.uky.cepis.service.CertificationService;
import edu.uky.cepis.service.CharacterAndFitnessService;
import edu.uky.cepis.service.CohortTermService;
import edu.uky.cepis.service.CohortTypeService;
import edu.uky.cepis.service.ConferenceService;
import edu.uky.cepis.service.EmailAddressService;
import edu.uky.cepis.service.EmailAddressTypeService;
import edu.uky.cepis.service.EmailService;
import edu.uky.cepis.service.EthnicService;
import edu.uky.cepis.service.EventService;
import edu.uky.cepis.service.FacultyAdvisorService;
import edu.uky.cepis.service.FeeService;
import edu.uky.cepis.service.GreTestScoreService;
import edu.uky.cepis.service.HoldLiftService;
import edu.uky.cepis.service.IPAddressService;
import edu.uky.cepis.service.LastLoginService;
import edu.uky.cepis.service.LetterService;
import edu.uky.cepis.service.NoteService;
import edu.uky.cepis.service.PhoneService;
import edu.uky.cepis.service.PhoneTypeService;
import edu.uky.cepis.service.PraxisIITestScoreService;
import edu.uky.cepis.service.PraxisIITestService;
import edu.uky.cepis.service.PraxisITestScoreService;
import edu.uky.cepis.service.PraxisITestService;
import edu.uky.cepis.service.ProgramDomainService;
import edu.uky.cepis.service.ProgramGroupService;
import edu.uky.cepis.service.ProgramService;
import edu.uky.cepis.service.ProgramTrackService;
import edu.uky.cepis.service.QueryService;
import edu.uky.cepis.service.RankingService;
import edu.uky.cepis.service.ReportYearService;
import edu.uky.cepis.service.RoleService;
import edu.uky.cepis.service.ScholarshipService;
import edu.uky.cepis.service.SearchEngineService;
import edu.uky.cepis.service.StudentScholarshipService;
import edu.uky.cepis.service.TepAdmissionService;
import edu.uky.cepis.service.TepApplicationService;
import edu.uky.cepis.service.UKCollegeService;
import edu.uky.cepis.service.UKDepartmentService;
import edu.uky.cepis.service.UKMajorService;
import edu.uky.cepis.service.UKStatusService;
import edu.uky.cepis.service.UKTermService;
import edu.uky.cepis.service.UserAcademicProfileService;
import edu.uky.cepis.service.UserAssessmentProfileService;
import edu.uky.cepis.service.UserClassificationService;
import edu.uky.cepis.service.UserCollegeProfileService;
import edu.uky.cepis.service.UserPersonalProfileService;
import edu.uky.cepis.service.UserProgramProfileService;
import edu.uky.cepis.service.UserService;
import edu.uky.cepis.service.UserTypeService;
import edu.uky.cepis.service.WorkingSetService;

/**
 * 
 * @author keerthi
 * @author cawalk4
 *  
 */
public abstract class CepisWebView implements Serializable, CepisView {

	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	/**
	 * @uml.property name="userService"
	 * @uml.associationEnd
	 */
	protected static UserService userService;
	/**
	 * @uml.property name="ipAddressService"
	 * @uml.associationEnd
	 */
	protected static IPAddressService ipAddressService;
	/**
	 * @uml.property name="workingSetService"
	 * @uml.associationEnd
	 */
	protected static WorkingSetService workingSetService;

	protected static QueryService queryService;
	/**
	 * @uml.property name="lastLoginService"
	 * @uml.associationEnd
	 */
	protected static LastLoginService lastLoginService;
	/**
	 * @uml.property name="roleservice"
	 * @uml.associationEnd
	 */
	protected static RoleService roleservice;
	/**
	 * @uml.property name="addressTypeService"
	 * @uml.associationEnd
	 */
	protected static AddressTypeService addressTypeService;
	/**
	 * @uml.property name="emailAddressTypeService"
	 * @uml.associationEnd
	 */
	protected static EmailAddressTypeService emailAddressTypeService;
	/**
	 * @uml.property name="phoneTypeService"
	 * @uml.associationEnd
	 */
	protected static PhoneTypeService phoneTypeService;
	/**
	 * @uml.property name="programService"
	 * @uml.associationEnd
	 */
	protected static ProgramService programService;
	/**
	 * @uml.property name="programDomainService"
	 * @uml.associationEnd
	 */
	protected static ProgramDomainService programDomainService;
	/**
	 * @uml.property name="programTrackService"
	 * @uml.associationEnd
	 */
	protected static ProgramTrackService programTrackService;
	/**
	 * @uml.property name="programGroupService"
	 * @uml.associationEnd
	 */
	protected static ProgramGroupService programGroupService;
	/**
	 * @uml.property name="ukMajorService"
	 * @uml.associationEnd
	 */
	protected static UKMajorService ukMajorService;
	/**
	 * @uml.property name="ukTermService"
	 * @uml.associationEnd
	 */
	protected static UKTermService ukTermService;
	/**
	 * @uml.property name="ukStatusService"
	 * @uml.associationEnd
	 */
	protected static UKStatusService ukStatusService;
	/**
	 * @uml.property name="advisorService"
	 * @uml.associationEnd
	 */
	protected static AdvisorService advisorService;
	/**
	 * @uml.property name="userProgramProfileService"
	 * @uml.associationEnd
	 */
	protected static UserProgramProfileService userProgramProfileService;

	protected static UserAssessmentProfileService userAssessmentProfileService;
	/**
	 * @uml.property name="userPersonalProfileService"
	 * @uml.associationEnd
	 */
	protected static UserPersonalProfileService userPersonalProfileService;
	/**
	 * @uml.property name="userCollegeProfileService"
	 * @uml.associationEnd
	 */
	protected static UserCollegeProfileService userCollegeProfileService;
	/**
	 * @uml.property name="searchEngineService"
	 * @uml.associationEnd
	 */
	protected static SearchEngineService searchEngineService;
	/**
	 * @uml.property name="addressService"
	 * @uml.associationEnd
	 */
	protected static AddressService addressService;
	/**
	 * @uml.property name="phoneService"
	 * @uml.associationEnd
	 */
	protected static PhoneService phoneService;
	/**
	 * @uml.property name="emailAddressService"
	 * @uml.associationEnd
	 */
	protected static EmailAddressService emailAddressService;
	
	protected static EmailService emailService;
	/**
	 * @uml.property name="eventService"
	 * @uml.associationEnd
	 */
	protected static EventService eventService;

	/**
	 * @uml.property name="ethnicService"
	 * @uml.associationEnd
	 */
	protected static EthnicService ethnicService;

	/**
	 * @uml.property name="ukCollegeService"
	 * @uml.associationEnd
	 */
	protected static UKCollegeService ukCollegeService;
	/**
	 * @uml.property name="ukDepartmentService"
	 * @uml.associationEnd
	 */
	protected static UKDepartmentService ukDepartmentService;
	/**
	 * @uml.property name="userTypeService"
	 * @uml.associationEnd
	 */
	protected static UserTypeService userTypeService;
	/**
	 * @uml.property name="userClassificationService"
	 * @uml.associationEnd
	 */
	protected static UserClassificationService userClassificationService;
	/**
	 * @uml.property name="cohortTypeService"
	 * @uml.associationEnd
	 */
	protected static CohortTypeService cohortTypeService;

	/**
	 * @uml.property name="cohortTermService"
	 * @uml.associationEnd
	 */
	protected static CohortTermService cohortTermService;
	/**
	 * @uml.property name="conferenceService"
	 * @uml.associationEnd
	 */
	protected static ConferenceService conferenceService;
	
	protected static AttendeeService attendeeService;
	
	protected static AdvisingSessionService advisingSessionService;
	
	protected static AdvisingSessionSlotService advisingSessionSlotService;
	
	protected static RankingService rankingService;

	protected static CertificationService certificationService;

	protected static HoldLiftService holdLiftService;

	protected static UserAcademicProfileService userAcademicProfileService;
	
	protected static NoteService noteService;

	protected static PraxisITestScoreService praxisITestScoreService;
	
	protected static PraxisITestService praxisITestService;
	
	protected static PraxisIITestScoreService praxisIITestScoreService;
	
	protected static PraxisIITestService praxisIITestService;
	
	protected static ArtifactService artifactService;
	
	protected static GreTestScoreService greTestScoreService;
	
	protected static ReportYearService reportYearService;
	
	protected static TepAdmissionService tepAdmissionService;
		
	protected static TepApplicationService  tepApplicationService;
	
	protected static ApplicationStatusService applicationStatusService;

	protected static LetterService letterService;
	
	protected static CharacterAndFitnessService characterAndFitnessService;
	
	protected static FeeService feeService;
	
	protected static FacultyAdvisorService facultyAdvisorService;
	
	protected static ScholarshipService scholarshipService;
	
	protected static StudentScholarshipService studentScholarshipService;
	
	/**
	 * @return the searchEngineService
	 * @uml.property name="searchEngineService"
	 */
	public SearchEngineService getSearchEngineService() {
		return searchEngineService;
	}

	/**
	 * @param searchEngineService
	 *            the searchEngineService to set
	 * @uml.property name="searchEngineService"
	 */
	public void setSearchEngineService(SearchEngineService searchEngineService) {
		CepisWebView.searchEngineService = searchEngineService;
	}

	/**
	 * @return the userAcademicProfileService
	 */
	public UserAcademicProfileService getUserAcademicProfileService() {
		return userAcademicProfileService;
	}

	/**
	 * @param userAcademicProfileService
	 *            the userAcademicProfileService to set
	 */
	public void setUserAcademicProfileService(
			UserAcademicProfileService userAcademicProfileService) {
		CepisWebView.userAcademicProfileService = userAcademicProfileService;
	}

	/**
	 * @return the userService
	 * @uml.property name="userService"
	 */
	@Override
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService
	 *            the userService to set
	 * @uml.property name="userService"
	 */
	@Override
	public void setUserService(UserService userService) {
		CepisWebView.userService = userService;
	}

	/**
	 * @return the ipAddressService
	 * @uml.property name="ipAddressService"
	 */
	@Override
	public IPAddressService getIpAddressService() {
		return ipAddressService;
	}

	/**
	 * @param ipAddressService
	 *            the ipAddressService to set
	 * @uml.property name="ipAddressService"
	 */
	@Override
	public void setIpAddressService(IPAddressService ipAddressService) {
		CepisWebView.ipAddressService = ipAddressService;
	}

	/**
	 * @return the workingSetService
	 * @uml.property name="workingSetService"
	 */
	@Override
	public WorkingSetService getWorkingSetService() {
		return workingSetService;
	}

	/**
	 * @param workingSetService
	 *            the workingSetService to set
	 * @uml.property name="workingSetService"
	 */
	@Override
	public void setWorkingSetService(WorkingSetService workingSetService) {
		CepisWebView.workingSetService = workingSetService;
	}

	/**
	 * @return the lastLoginService
	 * @uml.property name="lastLoginService"
	 */
	@Override
	public LastLoginService getLastLoginService() {
		return lastLoginService;
	}

	/**
	 * @param lastLoginService
	 *            the lastLoginService to set
	 * @uml.property name="lastLoginService"
	 */
	@Override
	public void setLastLoginService(LastLoginService lastLoginService) {
		CepisWebView.lastLoginService = lastLoginService;
	}

	/**
	 * @return the roleservice
	 * @uml.property name="roleservice"
	 */
	public RoleService getRoleservice() {
		return roleservice;
	}

	/**
	 * @param roleservice
	 *            the roleservice to set
	 * @uml.property name="roleservice"
	 */
	public void setRoleservice(RoleService roleservice) {
		CepisWebView.roleservice = roleservice;
	}

	/**
	 * @return the programService
	 * @uml.property name="programService"
	 */
	public ProgramService getProgramService() {
		return programService;
	}

	/**
	 * @param programService
	 *            the programService to set
	 * @uml.property name="programService"
	 */
	public void setProgramService(ProgramService programService) {
		CepisWebView.programService = programService;
	}

	/**
	 * @return the programDomainService
	 * @uml.property name="programDomainService"
	 */
	public ProgramDomainService getProgramDomainService() {
		return programDomainService;
	}

	/**
	 * @param programDomainService
	 *            the programDomainService to set
	 * @uml.property name="programDomainService"
	 */
	public void setProgramDomainService(
			ProgramDomainService programDomainService) {
		CepisWebView.programDomainService = programDomainService;
	}

	/**
	 * @return the programTrackService
	 * @uml.property name="programTrackService"
	 */
	public ProgramTrackService getProgramTrackService() {
		return programTrackService;
	}

	/**
	 * @param programTrackService
	 *            the programTrackService to set
	 * @uml.property name="programTrackService"
	 */
	public void setProgramTrackService(ProgramTrackService programTrackService) {
		CepisWebView.programTrackService = programTrackService;
	}

	/**
	 * @return the programGroupService
	 * @uml.property name="programGroupService"
	 */
	public ProgramGroupService getProgramGroupService() {
		return programGroupService;
	}

	/**
	 * @param programGroupService
	 *            the programGroupService to set
	 * @uml.property name="programGroupService"
	 */
	public void setProgramGroupService(ProgramGroupService programGroupService) {
		CepisWebView.programGroupService = programGroupService;
	}

	/**
	 * @return the ukMajorService
	 * @uml.property name="ukMajorService"
	 */
	public UKMajorService getUkMajorService() {
		return ukMajorService;
	}

	/**
	 * @param ukMajorService
	 *            the ukMajorService to set
	 * @uml.property name="ukMajorService"
	 */
	public void setUkMajorService(UKMajorService ukMajorService) {
		CepisWebView.ukMajorService = ukMajorService;
	}

	/**
	 * @return the ukTermService
	 * @uml.property name="ukTermService"
	 */
	public UKTermService getUkTermService() {
		return ukTermService;
	}

	/**
	 * @param ukTermService
	 *            the ukTermService to set
	 * @uml.property name="ukTermService"
	 */
	public void setUkTermService(UKTermService ukTermService) {
		CepisWebView.ukTermService = ukTermService;
	}

	/**
	 * @return the ukStatusService
	 * @uml.property name="ukStatusService"
	 */
	public UKStatusService getUkStatusService() {
		return ukStatusService;
	}

	/**
	 * @param ukStatusService
	 *            the ukStatusService to set
	 * @uml.property name="ukStatusService"
	 */
	public void setUkStatusService(UKStatusService ukStatusService) {
		CepisWebView.ukStatusService = ukStatusService;
	}

	/**
	 * @return the advisorService
	 * @uml.property name="advisorService"
	 */
	public AdvisorService getAdvisorService() {
		return advisorService;
	}

	/**
	 * @param advisorService
	 *            the advisorService to set
	 * @uml.property name="advisorService"
	 */
	public void setAdvisorService(AdvisorService advisorService) {
		CepisWebView.advisorService = advisorService;
	}

	/**
	 * @return the userProgramProfileService
	 * @uml.property name="userProgramProfileService"
	 */
	public UserProgramProfileService getUserProgramProfileService() {
		return userProgramProfileService;
	}

	/**
	 * @param userProgramProfileService
	 *            the userProgramProfileService to set
	 * @uml.property name="userProgramProfileService"
	 */
	public void setUserProgramProfileService(
			UserProgramProfileService userProgramProfileService) {
		CepisWebView.userProgramProfileService = userProgramProfileService;
	}

	/**
	 * @return the userCollegeProfileService
	 * @uml.property name="userCollegeProfileService"
	 */
	public UserCollegeProfileService getUserCollegeProfileService() {
		return userCollegeProfileService;
	}

	/**
	 * @param userCollegeProfileService
	 *            the userCollegeProfileService to set
	 * @uml.property name="userCollegeProfileService"
	 */
	public void setUserCollegeProfileService(
			UserCollegeProfileService userCollegeProfileService) {
		CepisWebView.userCollegeProfileService = userCollegeProfileService;
	}

	/**
	 * @return the userAssessmentProfileService
	 */
	public UserAssessmentProfileService getUserAssessmentProfileService() {
		return userAssessmentProfileService;
	}

	/**
	 * @param userAssessmentProfileService
	 *            the userAssessmentProfileService to set
	 */
	public void setUserAssessmentProfileService(
			UserAssessmentProfileService userAssessmentProfileService) {
		CepisWebView.userAssessmentProfileService = userAssessmentProfileService;
	}

	/**
	 * @return the userPersonalProfileService
	 * @uml.property name="userPersonalProfileService"
	 */
	public UserPersonalProfileService getUserPersonalProfileService() {
		return userPersonalProfileService;
	}

	/**
	 * @param userPersonalProfileService
	 *            the userPersonalProfileService to set
	 * @uml.property name="userPersonalProfileService"
	 */
	public void setUserPersonalProfileService(
			UserPersonalProfileService userPersonalProfileService) {
		CepisWebView.userPersonalProfileService = userPersonalProfileService;
	}

	/**
	 * @return the addressTypeService
	 * @uml.property name="addressTypeService"
	 */
	public AddressTypeService getAddressTypeService() {
		return addressTypeService;
	}

	/**
	 * @param addressTypeService
	 *            the addressTypeService to set
	 * @uml.property name="addressTypeService"
	 */
	public void setAddressTypeService(AddressTypeService addressTypeService) {
		CepisWebView.addressTypeService = addressTypeService;
	}

	/**
	 * @return the emailAddressTypeService
	 * @uml.property name="emailAddressTypeService"
	 */
	public EmailAddressTypeService getEmailAddressTypeService() {
		return emailAddressTypeService;
	}

	/**
	 * @param emailAddressTypeService
	 *            the emailAddressTypeService to set
	 * @uml.property name="emailAddressTypeService"
	 */
	public void setEmailAddressTypeService(
			EmailAddressTypeService emailAddressTypeService) {
		CepisWebView.emailAddressTypeService = emailAddressTypeService;
	}

	/**
	 * @return the phoneTypeService
	 * @uml.property name="phoneTypeService"
	 */
	public PhoneTypeService getPhoneTypeService() {
		return phoneTypeService;
	}

	/**
	 * @param phoneTypeService
	 *            the phoneTypeService to set
	 * @uml.property name="phoneTypeService"
	 */
	public void setPhoneTypeService(PhoneTypeService phoneTypeService) {
		CepisWebView.phoneTypeService = phoneTypeService;
	}

	/**
	 * @return the addressService
	 * @uml.property name="addressService"
	 */
	public AddressService getAddressService() {
		return addressService;
	}

	/**
	 * @param addressService
	 *            the addressService to set
	 * @uml.property name="addressService"
	 */
	public void setAddressService(AddressService addressService) {
		CepisWebView.addressService = addressService;
	}

	/**
	 * @return the eventService
	 * @uml.property name="eventService"
	 */
	public EventService getEventService() {
		return eventService;
	}

	/**
	 * @param eventService
	 *            the eventService to set
	 * @uml.property name="eventService"
	 */
	public void setEventService(EventService eventService) {
		CepisWebView.eventService = eventService;
	}

	/**
	 * @return the phoneService
	 * @uml.property name="phoneService"
	 */
	public PhoneService getPhoneService() {
		return phoneService;
	}

	/**
	 * @param phoneService
	 *            the phoneService to set
	 * @uml.property name="phoneService"
	 */
	public void setPhoneService(PhoneService phoneService) {
		CepisWebView.phoneService = phoneService;
	}

	/**
	 * @return the emailAddressService
	 * @uml.property name="emailAddressService"
	 */
	public EmailAddressService getEmailAddressService() {
		return emailAddressService;
	}

	/**
	 * @param emailAddressService
	 *            the emailAddressService to set
	 * @uml.property name="emailAddressService"
	 */
	public void setEmailAddressService(EmailAddressService emailAddressService) {
		CepisWebView.emailAddressService = emailAddressService;
	}

	/**
	 * @return the ethnicService
	 * @uml.property name="ethnicService"
	 */
	public EthnicService getEthnicService() {
		return ethnicService;
	}

	/**
	 * @param ethnicService
	 *            the ethnicService to set
	 * @uml.property name="ethnicService"
	 */
	public void setEthnicService(EthnicService ethnicService) {
		CepisWebView.ethnicService = ethnicService;
	}

	/**
	 * @return the ukCollegeService
	 * @uml.property name="ukCollegeService"
	 */
	public UKCollegeService getUkCollegeService() {
		return ukCollegeService;
	}

	/**
	 * @param ukCollegeService
	 *            the ukCollegeService to set
	 * @uml.property name="ukCollegeService"
	 */
	public void setUkCollegeService(UKCollegeService ukCollegeService) {
		CepisWebView.ukCollegeService = ukCollegeService;
	}

	/**
	 * @return the ukDepartmentService
	 * @uml.property name="ukDepartmentService"
	 */
	public UKDepartmentService getUkDepartmentService() {
		return ukDepartmentService;
	}

	/**
	 * @param ukDepartmentService
	 *            the ukDepartmentService to set
	 * @uml.property name="ukDepartmentService"
	 */
	public void setUkDepartmentService(UKDepartmentService ukDepartmentService) {
		CepisWebView.ukDepartmentService = ukDepartmentService;
	}

	/**
	 * @return the userTypeService
	 * @uml.property name="userTypeService"
	 */
	public UserTypeService getUserTypeService() {
		return userTypeService;
	}

	/**
	 * @param userTypeService
	 *            the userTypeService to set
	 * @uml.property name="userTypeService"
	 */
	public void setUserTypeService(UserTypeService userTypeService) {
		CepisWebView.userTypeService = userTypeService;
	}

	/**
	 * @return the userClassificationService
	 * @uml.property name="userClassificationService"
	 */
	public UserClassificationService getUserClassificationService() {
		return userClassificationService;
	}

	/**
	 * @param userClassificationService
	 *            the userClassificationService to set
	 * @uml.property name="userClassificationService"
	 */
	public static void setUserClassificationService(
			UserClassificationService userClassificationService) {
		CepisWebView.userClassificationService = userClassificationService;
	}

	/**
	 * @return the cohortTypeService
	 * @uml.property name="cohortTypeService"
	 */
	public CohortTypeService getCohortTypeService() {
		return cohortTypeService;
	}

	/**
	 * @param cohortTypeService
	 *            the cohortTypeService to set
	 * @uml.property name="cohortTypeService"
	 */
	public void setCohortTypeService(CohortTypeService cohortTypeService) {
		CepisWebView.cohortTypeService = cohortTypeService;
	}

	/**
	 * @return the cohortTermService
	 * @uml.property name="cohortTermService"
	 */
	public CohortTermService getCohortTermService() {
		return cohortTermService;
	}

	/**
	 * @param cohortTermService
	 *            the cohortTermService to set
	 * @uml.property name="cohortTermService"
	 */
	public void setCohortTermService(CohortTermService cohortTermService) {
		CepisWebView.cohortTermService = cohortTermService;
	}

	/**
	 * @return the advisingSessionService
	 * @uml.property name="advisingSessionService"
	 */
	public AdvisingSessionService getAdvisingSessionService() {
		return advisingSessionService;
	}

	/**
	 * @param advisingSessionService
	 *            the advisingSessionService to set
	 * @uml.property name="advisingSessionService"
	 */
	public void setAdvisingSessionService(
			AdvisingSessionService advisingSessionService) {
		CepisWebView.advisingSessionService = advisingSessionService;
	}

	/**
	 * @return the advisingSessionSlotService
	 * @uml.property name="advisingSessionSlotService"
	 */
	public AdvisingSessionSlotService getAdvisingSessionSlotService() {
		return advisingSessionSlotService;
	}

	/**
	 * @param advisingSessionSlotService
	 *            the advisingSessionSlotService to set
	 * @uml.property name="advisingSessionSlotService"
	 */
	public void setAdvisingSessionSlotService(
			AdvisingSessionSlotService advisingSessionSlotService) {
		CepisWebView.advisingSessionSlotService = advisingSessionSlotService;
	}

	/**
	 * @return the conferenceService
	 * @uml.property name="conferenceService"
	 */
	public ConferenceService getConferenceService() {
		return conferenceService;
	}

	/**
	 * @return the attendeeService
	 * @uml.property name="attendeeService"
	 */
	public AttendeeService getAttendeeService() {
		return attendeeService;
	}

	/**
	 * @param conferenceService
	 *            the conferenceService to set
	 * @uml.property name="conferenceService"
	 */
	public void setConferenceService(ConferenceService conferenceService) {
		CepisWebView.conferenceService = conferenceService;
	}

	/**
	 * @param attendeeService
	 *            the attendeeService to set
	 * @uml.property name="attendeeService"
	 */
	public void setAttendeeService(AttendeeService attendeeService) {
		CepisWebView.attendeeService = attendeeService;
	}

	/**
	 * @return the rankingService
	 * @uml.property name="rankingService"
	 */
	public RankingService getRankingService() {
		return rankingService;
	}

	/**
	 * @param rankingService
	 *            the rankingService to set
	 * @uml.property name="rankingService"
	 */
	public void setRankingService(RankingService rankingService) {
		CepisWebView.rankingService = rankingService;
	}

	/**
	 * @return the certificationService
	 * @uml.property name="certificationService"
	 */
	public CertificationService getCertificationService() {
		return certificationService;
	}

	/**
	 * @param certificationService
	 *            the certificationService to set
	 * @uml.property name="certificationService"
	 */
	public void setCertificationService(
			CertificationService certificationService) {
		CepisWebView.certificationService = certificationService;
	}

	/**
	 * @return the emailService
	 */
	public EmailService getEmailService() {
		return emailService;
	}

	/**
	 * @param emailService
	 *            the emailService to set
	 */
	public void setEmailService(EmailService emailService) {
		CepisWebView.emailService = emailService;
	}

	/**
	 * @return the queryService
	 */
	public QueryService getQueryService() {
		return queryService;
	}

	/**
	 * @param queryService
	 *            the queryService to set
	 */
	public void setQueryService(QueryService queryService) {
		CepisWebView.queryService = queryService;
	}

	/**
	 * @return the holdLiftService
	 */
	public HoldLiftService getHoldLiftService() {
		return holdLiftService;
	}

	/**
	 * @param holdLiftService
	 *            the holdLiftService to set
	 */
	public void setHoldLiftService(HoldLiftService holdLiftService) {
		CepisWebView.holdLiftService = holdLiftService;
	}
	
	public NoteService getNoteService() {
		return noteService;
	}

	public void setNoteService(NoteService noteService) {
		CepisWebView.noteService = noteService;
	}

	public PraxisITestScoreService getPraxisITestScoreService() {
		return praxisITestScoreService;
	}

	public void setPraxisITestScoreService(
			PraxisITestScoreService praxisITestScoreService) {
		CepisWebView.praxisITestScoreService = praxisITestScoreService;
	}

	public PraxisITestService getPraxisITestService() {
		return praxisITestService;
	}

	public static void setPraxisITestService(PraxisITestService praxisITestService) {
		CepisWebView.praxisITestService = praxisITestService;
	}

	/**
	 * @return the testScoreService
	 */
	public PraxisIITestScoreService getPraxisIITestScoreService() {
		return praxisIITestScoreService;
	}

	/**
	 * @param testScoreService
	 *            the testScoreService to set
	 */
	public void setPraxisIITestScoreService(PraxisIITestScoreService praxisIITestScoreService) {
		CepisWebView.praxisIITestScoreService = praxisIITestScoreService;
	}

	public PraxisIITestService getPraxisIITestService() {
		return praxisIITestService;
	}

	public void setPraxisIITestService(PraxisIITestService praxisIITestService) {
		CepisWebView.praxisIITestService = praxisIITestService;
	}

	/**
	 * @return the artifactService
	 */
	public ArtifactService getArtifactService() {
		return artifactService;
	}

	/**
	 * @param artifactService
	 *            the artifactService to set
	 */
	public void setArtifactService(ArtifactService artifactService) {
		CepisWebView.artifactService = artifactService;
	}

	public GreTestScoreService getGreTestScoreService() {
		return greTestScoreService;
	}

	public void setGreTestScoreService(
			GreTestScoreService greTestScoreService) {
		CepisWebView.greTestScoreService = greTestScoreService;
	}

	public ReportYearService getReportYearService() {
		return reportYearService;
	}

	public void setReportYearService(ReportYearService reportYearService) {
		CepisWebView.reportYearService = reportYearService;
	}

	public TepAdmissionService getTepAdmissionService() {
		return tepAdmissionService;
	}

	public void setTepAdmissionService(TepAdmissionService tepAdmissionService) {
		CepisWebView.tepAdmissionService = tepAdmissionService;
	}

	public  TepApplicationService getTepApplicationService() {
		return tepApplicationService;
	}

	public void setTepApplicationService(TepApplicationService tepApplicationService) {
		CepisWebView.tepApplicationService = tepApplicationService;
	}

	public ApplicationStatusService getApplicationStatusService() {
		return applicationStatusService;
	}

	public void setApplicationStatusService(ApplicationStatusService applicationStatusService) {
		CepisWebView.applicationStatusService = applicationStatusService;
	}

	public LetterService getLetterService() {
		return letterService;
	}

	public void setLetterService(LetterService letterService) {
		CepisWebView.letterService = letterService;
	}

	public CharacterAndFitnessService getCharacterAndFitnessService() {
		return characterAndFitnessService;
	}

	public void setCharacterAndFitnessService(CharacterAndFitnessService characterAndFitnessService) {
		CepisWebView.characterAndFitnessService = characterAndFitnessService;
	}

	public FeeService getFeeService() {
		return feeService;
	}

	public void setFeeService(FeeService feeService) {
		CepisWebView.feeService = feeService;
	}

	public FacultyAdvisorService getFacultyAdvisorService() {
		return facultyAdvisorService;
	}

	public void setFacultyAdvisorService(
			FacultyAdvisorService facultyAdvisorService) {
		CepisWebView.facultyAdvisorService = facultyAdvisorService;
	}

	public ScholarshipService getScholarshipService() {
		return scholarshipService;
	}

	public void setScholarshipService(ScholarshipService scholarshipService) {
		CepisWebView.scholarshipService = scholarshipService;
	}

	public StudentScholarshipService getStudentScholarshipService() {
		return studentScholarshipService;
	}

	public void setStudentScholarshipService(
			StudentScholarshipService studentScholarshipService) {
		CepisWebView.studentScholarshipService = studentScholarshipService;
	}

}
