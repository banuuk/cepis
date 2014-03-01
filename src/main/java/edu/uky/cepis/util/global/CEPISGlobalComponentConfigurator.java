/**
 * 
 */
package edu.uky.cepis.util.global;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.uky.cepis.domain.AddressType;
import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.AdvisorGroup;
import edu.uky.cepis.domain.CohortTerm;
import edu.uky.cepis.domain.CohortType;
import edu.uky.cepis.domain.EmailAddressType;
import edu.uky.cepis.domain.Ethnic;
import edu.uky.cepis.domain.FacultyAdvisor;
import edu.uky.cepis.domain.PhoneType;
import edu.uky.cepis.domain.PraxisIITest;
import edu.uky.cepis.domain.Ranking;
import edu.uky.cepis.domain.Role;
import edu.uky.cepis.domain.UserClassification;
import edu.uky.cepis.domain.UserType;
import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.ProgramGroup;
import edu.uky.cepis.domain.component.ProgramTrack;
import edu.uky.cepis.domain.component.UKCollege;
import edu.uky.cepis.domain.component.UKDepartment;
import edu.uky.cepis.domain.component.UKMajor;
import edu.uky.cepis.domain.component.UKStatus;
import edu.uky.cepis.domain.component.UKTerm;
import edu.uky.cepis.service.AddressTypeService;
import edu.uky.cepis.service.AdvisorService;
import edu.uky.cepis.service.CohortTermService;
import edu.uky.cepis.service.CohortTypeService;
import edu.uky.cepis.service.EmailAddressTypeService;
import edu.uky.cepis.service.EthnicService;
import edu.uky.cepis.service.FacultyAdvisorService;
import edu.uky.cepis.service.PhoneTypeService;
import edu.uky.cepis.service.PraxisIITestService;
import edu.uky.cepis.service.ProgramDomainService;
import edu.uky.cepis.service.ProgramGroupService;
import edu.uky.cepis.service.ProgramService;
import edu.uky.cepis.service.ProgramTrackService;
import edu.uky.cepis.service.RankingService;
import edu.uky.cepis.service.RoleService;
import edu.uky.cepis.service.UKCollegeService;
import edu.uky.cepis.service.UKDepartmentService;
import edu.uky.cepis.service.UKMajorService;
import edu.uky.cepis.service.UKStatusService;
import edu.uky.cepis.service.UKTermService;
import edu.uky.cepis.service.UserClassificationService;
import edu.uky.cepis.service.UserTypeService;

/**
 * CEPISGlobalComponentConfigurator preloads the default CEPIS list fields such
 * as AddressType, PhoneType, etc to avoid repeated database queries. <br>
 * This class uses the business/service layer objects to perform one-time fetch. <br>
 * This class extends {@link CEPISConfigurator}
 * 
 * @author keerthi
 */
public class CEPISGlobalComponentConfigurator extends CEPISConfigurator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean refreshGlobalComponent;
	private ProgramService programService;
	private ProgramDomainService programDomainService;
	private ProgramTrackService programTrackService;
	private ProgramGroupService programGroupService;
	private UKMajorService ukMajorService;
	private UKTermService ukTermService;
	private UKStatusService ukStatusService;
	private AdvisorService advisorService;
	private FacultyAdvisorService facultyAdvisorService;
	private RoleService roleService;
	private AddressTypeService addressTypeService;
	private PhoneTypeService phoneTypeService;
	private EmailAddressTypeService emailAddressTypeService;
	private EthnicService ethnicService;
	private UKCollegeService ukCollegeService;
	private UKDepartmentService ukDepartmentService;
	private UserTypeService userTypeService;
	private UserClassificationService userClassificationService;
	private CohortTypeService cohortTypeService;
	private CohortTermService cohortTermService;
	private RankingService rankingService;
	private PraxisIITestService praxisIITestService;
	private List<Program> programList = new ArrayList<Program>(0);
	private List<ProgramDomain> programDomainList = new ArrayList<ProgramDomain>(0);
	private List<ProgramTrack> programTrackList = new ArrayList<ProgramTrack>(0);
	private List<ProgramGroup> programGroupList = new ArrayList<ProgramGroup>(0);
	private List<UKMajor> ukMajorList = new ArrayList<UKMajor>(0);
	private List<UKStatus> ukStatusList = new ArrayList<UKStatus>(0);
	private List<UKTerm> ukTermList = new ArrayList<UKTerm>(0);
	private List<Advisor> advisorList = new ArrayList<Advisor>(0);
	private List<FacultyAdvisor> facultyAdvisorList = new ArrayList<FacultyAdvisor>(0);
	private List<Role> roleList = new ArrayList<Role>(0);
	private List<AddressType> addressTypeList = new ArrayList<AddressType>(0);
	private List<PhoneType> phoneTypeList = new ArrayList<PhoneType>(0);
	private List<EmailAddressType> emailAddressTypeList = new ArrayList<EmailAddressType>(0);
	private List<Ethnic> ethnicList = new ArrayList<Ethnic>(0);
	private List<UKCollege> ukCollegeList = new ArrayList<UKCollege>(0);
	private List<UKDepartment> ukDepartmentList = new ArrayList<UKDepartment>(0);
	private List<UserType> userTypeList = new ArrayList<UserType>(0);
	private List<UserClassification> userClassificationList = new ArrayList<UserClassification>(0);
	private List<CohortType> cohortTypeList = new ArrayList<CohortType>(0);
	private List<CohortTerm> cohortTermList = new ArrayList<CohortTerm>(0);
	private List<Ranking> rankingList = new ArrayList<Ranking>(0);
	private List<SelectItem> formattedRankingList = new ArrayList<SelectItem>(0);
	private List<AdvisorGroup> advisorGroupList = new ArrayList<AdvisorGroup>(0);
	private List<String> countries = new ArrayList<String>(0);
	private List<String> states = new ArrayList<String>(0);
	private List<PraxisIITest> praxisIITestList = new ArrayList<PraxisIITest>(0);
	private ProgramDomain activeProgramDomain;

	/**
	 * 
	 */
	public CEPISGlobalComponentConfigurator() {
		this.refreshGlobalComponent = false;
	}

	private void loadCountryList() {
		System.out.println("Loading Countries List (from XML)...");
		if (this.countries.size() > 0) {
			return;
		}
		Resource countryXML = new ClassPathResource(
				"edu/uky/cepis/data/countries.xml");
		try {
			if (countryXML == null || countryXML.getFile() == null) {
				System.out.println("CountryXML or file is null." + countryXML);
				return;
			}
			File fXmlFile = countryXML.getFile();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("country");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				NodeList countryList = nNode.getChildNodes();
				Node nNode1 = countryList.item(0);
				countries.add(nNode1.getNodeValue());
				// System.out.println(countries.get(temp));
			}
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	private void loadStatesList() {
		System.out.println("Loading States List (from XML)...");
		if (this.states.size() > 0) {
			return;
		}
		Resource statesXML = new ClassPathResource(
				"edu/uky/cepis/data/states.xml");
		try {
			if (statesXML == null || statesXML.getFile() == null) {
				System.out.println("StatesXML or file is null." + statesXML);
				return;
			}
			File fXmlFile = statesXML.getFile();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("state");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				// System.out.println(nNode.getAttributes().item(0).getNodeValue());
				states.add(nNode.getAttributes().item(0).getNodeValue());
			}
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	/**
	 * @param programService
	 * @param programDomainService
	 * @param programTrackService
	 * @param programGroupService
	 * @param ukMajorService
	 * @param ukTermService
	 * @param ukStatusService
	 * @param advisorService
	 * @param roleService
	 */
	public CEPISGlobalComponentConfigurator(ProgramService programService,
			ProgramDomainService programDomainService,
			ProgramTrackService programTrackService,
			ProgramGroupService programGroupService,
			UKMajorService ukMajorService, 
			UKTermService ukTermService,
			UKStatusService ukStatusService, 
			AdvisorService advisorService,
			FacultyAdvisorService facultyAdvisorService,
			RoleService roleService, 
			AddressTypeService addressTypeService,
			PhoneTypeService phoneTypeService,
			EmailAddressTypeService emailAddressTypeService,
			EthnicService ethnicService, 
			UKCollegeService ukCollegeService,
			UKDepartmentService ukDepartmentService,
			UserTypeService userTypeService,
			UserClassificationService userClassificationService,
			CohortTypeService cohortTypeService,
			CohortTermService cohortTermService, RankingService rankingService,
			PraxisIITestService praxisIITestService) {
		this.programService = programService;
		this.programDomainService = programDomainService;
		this.programTrackService = programTrackService;
		this.programGroupService = programGroupService;
		this.ukMajorService = ukMajorService;
		this.ukTermService = ukTermService;
		this.ukStatusService = ukStatusService;
		this.advisorService = advisorService;
		this.facultyAdvisorService = facultyAdvisorService;
		this.roleService = roleService;
		this.addressTypeService = addressTypeService;
		this.phoneTypeService = phoneTypeService;
		this.emailAddressTypeService = emailAddressTypeService;
		this.ethnicService = ethnicService;
		this.ukCollegeService = ukCollegeService;
		this.ukDepartmentService = ukDepartmentService;
		this.userTypeService = userTypeService;
		this.userClassificationService = userClassificationService;
		this.cohortTypeService = cohortTypeService;
		this.cohortTermService = cohortTermService;
		this.rankingService = rankingService;
		this.praxisIITestService = praxisIITestService;
		this.loadGlobalComponent();
	}

	/**
	 * 
	 */
	public String loadGlobalComponent() {
		this.refreshGlobalComponent = true;
		this.getAdvisorList();
		this.getFacultyAdvisorList();
		this.getProgramList();
		this.getProgramDomainList();
		this.getProgramGroupList();
		this.getProgramTrackList();
		this.getUkMajorList();
		this.getUkStatusList();
		this.getUkTermList();
		this.getAddressTypeList();
		this.getAdvisorGroupList();		
		this.getCohortTermList();
		this.getCohortTypeList();
		this.getEmailAddressTypeList();
		this.getEthnicList();
		this.getPhoneTypeList();
		this.getRankingList();
		this.getFormattedRankingList();
		this.getRoleList();
		this.getUkCollegeList();
		this.getUkDepartmentList();
		this.getUserClassificationList();
		this.getUserTypeList();
		this.getPraxisIITestList();
		loadCountryList();
		loadStatesList();
		this.refreshGlobalComponent = false;
		return null;
	}

	/**
	 * @param refreshGlobalComponent
	 *            the refreshGlobalComponent to set
	 * @uml.property name="refreshGlobalComponent"
	 */
	public void setRefreshGlobalComponent(boolean refreshGlobalComponent) {
		this.refreshGlobalComponent = refreshGlobalComponent;
	}

	/**
	 * @return the refreshGlobalComponent
	 * @uml.property name="refreshGlobalComponent"
	 */
	public boolean isRefreshGlobalComponent() {
		return refreshGlobalComponent;
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
		this.programService = programService;
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
		this.programDomainService = programDomainService;
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
		this.programTrackService = programTrackService;
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
		this.programGroupService = programGroupService;
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
		this.ukMajorService = ukMajorService;
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
		this.ukTermService = ukTermService;
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
		this.ukStatusService = ukStatusService;
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
		this.advisorService = advisorService;
	}

	public FacultyAdvisorService getFacultyAdvisorService() {
		return facultyAdvisorService;
	}

	public void setFacultyAdvisorService(FacultyAdvisorService facultyAdvisorService) {
		this.facultyAdvisorService = facultyAdvisorService;
	}

	/**
	 * @param roleService
	 *            the roleService to set
	 * @uml.property name="roleService"
	 */
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * @return the roleService
	 * @uml.property name="roleService"
	 */
	public RoleService getRoleService() {
		return roleService;
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
		this.addressTypeService = addressTypeService;
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
		this.phoneTypeService = phoneTypeService;
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
		this.emailAddressTypeService = emailAddressTypeService;
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
		this.ethnicService = ethnicService;
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
		this.ukCollegeService = ukCollegeService;
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
		this.ukDepartmentService = ukDepartmentService;
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
		this.userTypeService = userTypeService;
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
	public void setUserClassificationService(
			UserClassificationService userClassificationService) {
		this.userClassificationService = userClassificationService;
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
		this.cohortTypeService = cohortTypeService;
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
		this.cohortTermService = cohortTermService;
	}

	/**
	 * @return the rankingService
	 * @uml.property name="rankingService"
	 */
	public final RankingService getRankingService() {
		return rankingService;
	}

	/**
	 * @param rankingService
	 *            the rankingService to set
	 * @uml.property name="rankingService"
	 */
	public final void setRankingService(RankingService rankingService) {
		this.rankingService = rankingService;
	}

	/**
	 * @param programCode
	 * @return
	 */
	public Program findProgramByCode(String programCode) {
		Program program = null;
		List<Program> programs = this.getProgramList();
		for (int i = 0; i < programs.size(); i++) {
			program = programs.get(i);
			if (program.getProgramCode().equals(programCode)) {
				return program;
			}
		}
		return null;
	}

	/**
	 * @param programDomainCode
	 * @return
	 */
	public ProgramDomain findProgramDomainByCode(String programDomainCode) {
		ProgramDomain programDomain = null;
		List<ProgramDomain> programDomains = this.getProgramDomainList();
		for (int i = 0; i < programDomains.size(); i++) {
			programDomain = programDomains.get(i);
			if (programDomain.getProgramDomainCode().equals(programDomainCode)) {
				return programDomain;
			}
		}
		return null;
	}

	/**
	 * @param programTrackCode
	 * @return
	 */
	public ProgramTrack findProgramTrackByCode(String programTrackCode) {
		ProgramTrack programTrack = null;
		List<ProgramTrack> programTracks = this.getProgramTrackList();
		for (int i = 0; i < programTracks.size(); i++) {
			programTrack = programTracks.get(i);
			if (programTrack.getProgramTrackCode().equals(programTrackCode)) {
				return programTrack;
			}
		}
		return null;
	}

	/**
	 * @param programGroupCode
	 * @return
	 */
	public ProgramGroup findProgramGroupByCode(String programGroupCode) {
		ProgramGroup programGroup = null;
		List<ProgramGroup> programGroups = this.getProgramGroupList();
		for (int i = 0; i < programGroups.size(); i++) {
			programGroup = programGroups.get(i);
			if (programGroup.getProgramGroupCode().equals(programGroupCode)) {
				return programGroup;
			}
		}
		return null;
	}

	/**
	 * @param uKMajorCode
	 * @return
	 */
	public UKMajor findUKMajorByCode(String uKMajorCode) {
		UKMajor uKMajor = null;
		List<UKMajor> uKMajors = this.getUkMajorList();
		for (int i = 0; i < uKMajors.size(); i++) {
			uKMajor = uKMajors.get(i);
			if (uKMajor.getUkMajorCode().equals(uKMajorCode)) {
				return uKMajor;
			}
		}
		return null;
	}

	/**
	 * @param uKTermCode
	 * @return
	 */
	public UKTerm findUKTermByCode(String uKTermCode) {
		UKTerm uKTerm = null;
		List<UKTerm> uKTerms = this.getUkTermList();
		for (int i = 0; i < uKTerms.size(); i++) {
			uKTerm = uKTerms.get(i);
			if (uKTerm.getUkTermCode().equals(uKTermCode)) {
				return uKTerm;
			}
		}
		return null;
	}

	/**
	 * @param uKStatusCode
	 * @return
	 */
	public UKStatus findUKStatusByCode(String uKStatusCode) {
		UKStatus uKStatus = null;
		List<UKStatus> uKStatuss = this.getUkStatusList();
		for (int i = 0; i < uKStatuss.size(); i++) {
			uKStatus = uKStatuss.get(i);
			if (uKStatus.getStatusCode().equals(uKStatusCode)) {
				return uKStatus;
			}
		}
		return null;
	}

	/**
	 * @param userid
	 * @return
	 */
	public Advisor findAdvisorByUser(String userid) {
		Advisor advisor = null;
		List<Advisor> advisors = this.getAdvisorList();
		for (int i = 0; i < advisors.size(); i++) {
			advisor = advisors.get(i);
			if (advisor.getUserid().equals(userid)) {
				return advisor;
			}
		}
		return null;
	}
	
	public FacultyAdvisor findFacultyAdvisorByUser(String userId){		
		List<FacultyAdvisor> facultyAdvisors = this.getFacultyAdvisorList();
		for(FacultyAdvisor fa : facultyAdvisors){
			if(fa.getUserid().equals(userId)){
				return fa;
			}
		}
		return null;
	}

	public AdvisorGroup findAdvisorGroup(long id) {
		AdvisorGroup advisorGroup = null;
		List<AdvisorGroup> advisorGroups = this.getAdvisorGroupList();
		for (int i = 0; i < advisorGroups.size(); i++) {
			advisorGroup = advisorGroups.get(i);
			if (advisorGroup.getId() == id) {
				return advisorGroup;
			}
		}
		return null;
	}

	public AdvisorGroup findAdvisorGroup(Advisor advisor) {
		AdvisorGroup advisorGroup = null;
		List<AdvisorGroup> advisorGroups = this.getAdvisorGroupList();
		for (int i = 0; i < advisorGroups.size(); i++) {
			advisorGroup = advisorGroups.get(i);
			if (advisorGroup.getAdvisors().contains(advisor)) {
				return advisorGroup;
			}
		}
		return null;
	}

	/**
	 * @param code
	 * @return
	 */
	public AddressType findAddressTypeByCode(String code) {
		AddressType addressType = null;
		List<AddressType> addressTypes = this.getAddressTypeList();
		for (int i = 0; i < addressTypes.size(); i++) {
			addressType = addressTypes.get(i);
			if (addressType.getCode().equals(code)) {
				return addressType;
			}
		}
		return null;
	}

	/**
	 * @param code
	 * @return
	 */
	public PhoneType findPhoneTypeByCode(String code) {
		PhoneType phoneType = null;
		List<PhoneType> phoneTypes = this.getPhoneTypeList();
		for (int i = 0; i < phoneTypes.size(); i++) {
			phoneType = phoneTypes.get(i);
			if (phoneType.getCode().equals(code)) {
				return phoneType;
			}
		}
		return null;
	}

	/**
	 * @param code
	 * @return
	 */
	public EmailAddressType findEmailAddressTypeByCode(String code) {
		EmailAddressType emailAddressType = null;
		List<EmailAddressType> emailAddressTypes = this
				.getEmailAddressTypeList();
		for (int i = 0; i < emailAddressTypes.size(); i++) {
			emailAddressType = emailAddressTypes.get(i);
			if (emailAddressType.getCode().equals(code)) {
				return emailAddressType;
			}
		}
		return null;
	}

	public Ethnic findEthnicByCode(String code) {
		Ethnic ethnic = null;
		List<Ethnic> ethnicList = this.getEthnicList();
		for (int i = 0; i < ethnicList.size(); i++) {
			ethnic = ethnicList.get(i);
			if (ethnic.getCode().equals(code)) {
				return ethnic;
			}
		}
		return null;
	}

	public UKCollege findUKCollegeByCode(String code) {
		UKCollege ukCollege = null;
		List<UKCollege> ukCollegeList = this.getUkCollegeList();
		for (int i = 0; i < ukCollegeList.size(); i++) {
			ukCollege = ukCollegeList.get(i);
			if (ukCollege.getUkCollegeCode().equals(code)) {
				return ukCollege;
			}
		}
		return null;
	}

	public UKDepartment findUKDepartmentByCode(String code) {
		UKDepartment ukDepartment = null;
		List<UKDepartment> ukDepartmentList = this.getUkDepartmentList();
		for (int i = 0; i < ukDepartmentList.size(); i++) {
			ukDepartment = ukDepartmentList.get(i);
			if (ukDepartment.getDepartmentCode().equals(code)) {
				return ukDepartment;
			}
		}
		return null;
	}

	public UserType findUserTypeByCode(String code) {
		UserType userType = null;
		List<UserType> userTypeList = this.getUserTypeList();
		for (int i = 0; i < userTypeList.size(); i++) {
			userType = userTypeList.get(i);
			if (userType.getTypeCode().equals(code)) {
				return userType;
			}
		}
		return null;
	}

	public UserClassification findUserClassificationByCode(String code) {
		UserClassification userClassification = null;
		List<UserClassification> userClassificationList = this
				.getUserClassificationList();
		for (int i = 0; i < userClassificationList.size(); i++) {
			userClassification = userClassificationList.get(i);
			if (userClassification.getClassificationCode().equals(code)) {
				return userClassification;
			}
		}
		return null;
	}

	public CohortType findCohortTypeByCode(String code) {
		CohortType cohortType = null;
		List<CohortType> cohortTypeList = this.getCohortTypeList();
		for (int i = 0; i < cohortTypeList.size(); i++) {
			cohortType = cohortTypeList.get(i);
			if (cohortType.getTypeCode().equals(code)) {
				return cohortType;
			}
		}
		return null;
	}

	public CohortTerm findCohortTermByCode(String code) {
		CohortTerm cohortTerm = null;
		List<CohortTerm> cohortTermList = this.getCohortTermList();
		for (int i = 0; i < cohortTermList.size(); i++) {
			cohortTerm = cohortTermList.get(i);
			if ((cohortTerm.getTermCode() + "").equals(code)) {
				return cohortTerm;
			}
		}
		return null;
	}

	public Ranking findRankingByCode(String code) {
		Ranking ranking = null;
		List<Ranking> rankingList = this.getRankingList();
		for (int i = 0; i < rankingList.size(); i++) {
			ranking = rankingList.get(i);
			if ((ranking.getRankingCode() + "").equals(code)) {
				return ranking;
			}
		}
		return null;
	}

	public PraxisIITest findPraxisIITestByCode(String code) {
		PraxisIITest praxisTest = null;
		List<PraxisIITest> praxisTestList = this.getPraxisIITestList();
		for (int i = 0; i < praxisTestList.size(); i++) {
			praxisTest = praxisTestList.get(i);
			if (praxisTest.getTestCode().equals(code)) {
				return praxisTest;
			}
		}
		return null;
	}

	/*
	 * Preloaded Data Lists
	 */
	/**
	 * @return the programList
	 * @uml.property name="programList"
	 */
	public List<Program> getProgramList() {
		if (this.programList.size() == 0 || this.isRefreshGlobalComponent()) {
			System.out.println("Loading Program  List ...");
			this.programList = this.getProgramService().getProgramList();
		}
		return this.programList;
	}

	/**
	 * @return the programDomainList
	 * @uml.property name="programDomainList"
	 */
	public List<ProgramDomain> getProgramDomainList() {
		if (this.programDomainList.size() == 0
				|| this.isRefreshGlobalComponent()) {
			System.out.println("Loading Program Domain List ...");
			this.programDomainList = this.getProgramDomainService()
					.getProgramDomainList();
		}
		return this.programDomainList;
	}

	/**
	 * @return the programTrackList
	 * @uml.property name="programTrackList"
	 */
	public List<ProgramTrack> getProgramTrackList() {
		if (this.programTrackList.size() == 0
				|| this.isRefreshGlobalComponent()) {
			System.out.println("Loading Program Track List ...");
			this.programTrackList = this.getProgramTrackService()
					.getProgramTrackList();
		}
		return this.programTrackList;
	}

	/**
	 * @return the programGroupList
	 * @uml.property name="programGroupList"
	 */
	public List<ProgramGroup> getProgramGroupList() {
		if (this.programGroupList.size() == 0
				|| this.isRefreshGlobalComponent()) {
			System.out.println("Loading Program Group List ...");
			this.programGroupList = this.getProgramGroupService()
					.getProgramGroupList();
		}
		return this.programGroupList;
	}

	/**
	 * @return the ukMajorList
	 * @uml.property name="ukMajorList"
	 */
	public List<UKMajor> getUkMajorList() {
		if (this.ukMajorList.size() == 0 || this.isRefreshGlobalComponent()) {
			System.out.println("Loading Major List ...");
			this.ukMajorList = this.getUkMajorService().getUKMajorList();
		}
		return this.ukMajorList;
	}

	/**
	 * @return the ukStatusList
	 * @uml.property name="ukStatusList"
	 */
	public List<UKStatus> getUkStatusList() {
		if (this.ukStatusList.size() == 0 || this.isRefreshGlobalComponent()) {
			System.out.println("Loading Status List ...");
			this.ukStatusList = this.getUkStatusService().getUKStatusList();
		}
		return this.ukStatusList;
	}

	/**
	 * @return the ukTermList
	 * @uml.property name="ukTermList"
	 */
	public List<UKTerm> getUkTermList() {
		if (this.ukTermList.size() == 0 || this.isRefreshGlobalComponent()) {
			System.out.println("Loading Term List ...");
			this.ukTermList = this.getUkTermService().getUKTermList();
		}
		return this.ukTermList;
	}

	/**
	 * @return the advisorList
	 * @uml.property name="advisorList"
	 */
	public List<Advisor> getAdvisorList() {
		if (this.advisorList.size() == 0 || this.isRefreshGlobalComponent()) {
			System.out.println("Loading Advisor List ...");
			this.advisorList = this.getAdvisorService().getAdvisorList();
		}
		return this.advisorList;
	}

	public List<FacultyAdvisor> getFacultyAdvisorList() {
		if (this.facultyAdvisorList.size() == 0 || this.isRefreshGlobalComponent()) {
			System.out.println("Loading FacultyAdvisor List ...");
			this.facultyAdvisorList = this.getFacultyAdvisorService().getFacultyAdvisorList();
		}
		return this.facultyAdvisorList;
	}

	public List<AdvisorGroup> getAdvisorGroupList() {
		if (this.advisorGroupList.size() == 0
				|| this.isRefreshGlobalComponent()) {
			System.out.println("Loading Advisor Group List ...");
			this.advisorGroupList = this.getAdvisorService()
					.getAdvisorGroupList();
		}
		return this.advisorGroupList;
	}

	/**
	 * @return the roleList
	 * @uml.property name="roleList"
	 */
	public List<Role> getRoleList() {
		if (this.roleList.size() == 0 || this.isRefreshGlobalComponent()) {
			System.out.println("Loading Role List ...");
			this.roleList = this.getRoleService().getRoleList();
		}
		return this.roleList;
	}

	/**
	 * @return the addressTypeList
	 * @uml.property name="addressTypeList"
	 */
	public List<AddressType> getAddressTypeList() {
		if (this.addressTypeList.size() == 0 || this.isRefreshGlobalComponent()) {
			System.out.println("Loading Address Type List ...");
			this.addressTypeList = this.getAddressTypeService()
					.getAddressTypeList();
		}
		return addressTypeList;
	}

	/**
	 * @return the phoneTypeList
	 * @uml.property name="phoneTypeList"
	 */
	public List<PhoneType> getPhoneTypeList() {
		if (this.phoneTypeList.size() == 0 || this.isRefreshGlobalComponent()) {
			System.out.println("Loading Phone Type List ...");
			this.phoneTypeList = this.getPhoneTypeService().getPhoneTypeList();
		}
		return phoneTypeList;
	}

	/**
	 * @return the emailAddressTypeList
	 * @uml.property name="emailAddressTypeList"
	 */
	public List<EmailAddressType> getEmailAddressTypeList() {
		if (this.emailAddressTypeList.size() == 0
				|| this.isRefreshGlobalComponent()) {
			System.out.println("Loading Email Addrsss Type List ...");
			this.emailAddressTypeList = this.getEmailAddressTypeService()
					.getEmailAddressTypeList();
		}
		return emailAddressTypeList;
	}

	/**
	 * @return
	 * @uml.property name="ethnicList"
	 */
	public List<Ethnic> getEthnicList() {
		if (this.ethnicList.size() == 0 || this.isRefreshGlobalComponent()) {
			System.out.println("Loading Ethnic List ...");
			this.ethnicList = this.getEthnicService().getEthnicList();
		}
		return ethnicList;
	}

	/**
	 * @return
	 * @uml.property name="ukCollegeList"
	 */
	public List<UKCollege> getUkCollegeList() {
		if (this.ukCollegeList.size() == 0 || this.isRefreshGlobalComponent()) {
			System.out.println("Loading College List ...");
			this.ukCollegeList = this.getUkCollegeService().getUKCollegeList();
		}
		return ukCollegeList;
	}

	/**
	 * @return
	 * @uml.property name="ukDepartmentList"
	 */
	public List<UKDepartment> getUkDepartmentList() {
		if (this.ukDepartmentList.size() == 0
				|| this.isRefreshGlobalComponent()) {
			System.out.println("Loading Department List ...");
			this.ukDepartmentList = this.getUkDepartmentService()
					.getUKDepartmentList();
		}
		return ukDepartmentList;
	}

	/**
	 * @return
	 * @uml.property name="userTypeList"
	 */
	public List<UserType> getUserTypeList() {
		if (this.userTypeList.size() == 0 || this.isRefreshGlobalComponent()) {
			System.out.println("Loading User Type List ...");
			this.userTypeList = this.getUserTypeService().getUserTypeList();
		}
		return userTypeList;
	}

	/**
	 * @return
	 * @uml.property name="userClassificationList"
	 */
	public List<UserClassification> getUserClassificationList() {
		if (this.userClassificationList.size() == 0
				|| this.isRefreshGlobalComponent()) {
			System.out.println("Loading User Classification List ...");
			this.userClassificationList = this.getUserClassificationService()
					.getUserClassificationList();
		}
		return userClassificationList;
	}

	/**
	 * @return
	 * @uml.property name="cohortTypeList"
	 */
	public List<CohortType> getCohortTypeList() {
		if (this.cohortTypeList.size() == 0 || this.isRefreshGlobalComponent()) {
			System.out.println("Loading Cohort Type List ...");
			this.cohortTypeList = this.getCohortTypeService()
					.getCohortTypeList();
		}
		return cohortTypeList;
	}

	/**
	 * @return
	 * @uml.property name="cohortTermList"
	 */
	public List<CohortTerm> getCohortTermList() {
		if (this.cohortTermList.size() == 0 || this.isRefreshGlobalComponent()) {
			System.out.println("Loading Cohort Term List ...");
			this.cohortTermList = this.getCohortTermService()
					.getCohortTermList();
		}
		return cohortTermList;
	}

	/**
	 * @return
	 * @uml.property name="rankingList"
	 */
	public List<Ranking> getRankingList() {
		if (this.rankingList.size() == 0 || this.isRefreshGlobalComponent()) {
			System.out.println("Loading Ranking List ...");
			this.rankingList = this.getRankingService().getRankingList();
		}
		return rankingList;
	}

	/**
	 * @return the praxisTestList
	 */
	public List<PraxisIITest> getPraxisIITestList() {
		if (this.praxisIITestList.size() == 0 || this.isRefreshGlobalComponent()) {
			System.out.println("Loading PraxisTest List ...");
			this.praxisIITestList = this.getPraxisIITestService().getPraxisIITests();
		}
		return praxisIITestList;
	}

	/**
	 * @return
	 * @uml.property name="rankingList"
	 */
	public List<SelectItem> getFormattedRankingList() {
		if (this.formattedRankingList.size() == 0
				|| this.isRefreshGlobalComponent()) {
			System.out.println("Loading formatted Ranking List  ...");
			for (Ranking ranking : this.getRankingList()) {
				formattedRankingList.add(new SelectItem(ranking, String.format(
						"(%-5s) %-50s - %-50s", ranking.getRankingCode(),
						ranking.getTitle(), ranking.getProgram()), String
						.format("(%-5s) %-50s - %-50s",
								ranking.getRankingCode(), ranking.getTitle(),
								ranking.getProgram()), false, false));
			}
		}
		return formattedRankingList;
	}

	public Role findRoleByID(Long long1) {
		Role role = null;
		List<Role> roles = this.getRoleList();
		for (int i = 0; i < roles.size(); i++) {
			role = roles.get(i);
			if (role.getRoleid() == long1.longValue()) {
				return role;
			}
		}
		return null;
	}

	/**
	 * @return the countries
	 */
	public List<String> getCountries() {
		return countries;
	}

	/**
	 * @param countries
	 *            the countries to set
	 */
	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	/**
	 * @param states
	 *            the states to set
	 */
	public void setStates(List<String> states) {
		this.states = states;
	}

	/**
	 * @return the states
	 */
	public List<String> getStates() {
		return states;
	}

	/**
	 * @param activeProgramDomain
	 *            the activeProgramDomain to set
	 */
	public void setActiveProgramDomain(ProgramDomain activeProgramDomain) {
		this.activeProgramDomain = activeProgramDomain;
	}

	/**
	 * @return the activeProgramDomain
	 */
	public ProgramDomain getActiveProgramDomain() {
		return activeProgramDomain;
	}

	/**
	 * @return the programsInProgramDomainList
	 */
	public List<Program> getProgramListInProgramDomain() {
		if (activeProgramDomain != null) {
			return this.getProgramDomainService().getProgramListFromDomain(
					activeProgramDomain);
		}
		return new ArrayList<Program>(0);
	}
	
	public PraxisIITestService getPraxisIITestService() {
		return praxisIITestService;
	}
	
	public void setPraxisIITestList(List<PraxisIITest> praxisIITestList) {
		this.praxisIITestList = praxisIITestList;
	}

}
