/**
 * 
 */
package edu.uky.cepis.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.ajax4jsf.event.AjaxEvent;

import edu.uky.cepis.domain.Address;
import edu.uky.cepis.domain.AddressType;
import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.AdvisorGroup;
import edu.uky.cepis.domain.EmailAddressType;
import edu.uky.cepis.domain.PhoneType;
import edu.uky.cepis.domain.Role;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.ProgramGroup;
import edu.uky.cepis.domain.component.ProgramTrack;
import edu.uky.cepis.domain.component.UKMajor;
import edu.uky.cepis.domain.component.UKStatus;
import edu.uky.cepis.domain.component.UKTerm;
import edu.uky.cepis.util.global.CEPISGlobalComponentConfigurator;
import edu.uky.cepis.view.UserDetailView;

/**
 * @author keerthi
 */
public class UserDetailController extends AbstractController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property name="userDetailBean"
	 * @uml.associationEnd
	 */
	private UserDetailView userDetailBean;
	/**
	 * @uml.property name="code"
	 */
	private String code;
	/**
	 * @uml.property name="shortDesc"
	 */
	private String shortDesc;
	/**
	 * @uml.property name="description"
	 */
	private String description;
	/**
	 * @uml.property name="status"
	 */
	private String status;

	private Address officeLocation;
	/**
	 * @uml.property name="degreeLevel"
	 */
	private String degreeLevel;
	/**
	 * @uml.property name="degreeAwarded"
	 */
	private int degreeAwarded;
	/**
	 * @uml.property name="rolename"
	 */
	private String rolename;
	/**
	 * @uml.property name="roledesc"
	 */
	private String roledesc;

	private AdvisorGroup selectedAdvisorGroup;
	/**
	 * @uml.property name="otherInfo"
	 */
	private String otherInfo;

	/**
	 * @uml.property name="userDetailWarnStatus"
	 */
	private boolean userDetailWarnStatus;
	/**
	 * @uml.property name="userDetailStatusMessage"
	 */
	private String userDetailStatusMessage;
	/**
	 * @uml.property name="selectedUKMajor"
	 * @uml.associationEnd
	 */
	private UKMajor selectedUKMajor;
	/**
	 * @uml.property name="selectedUKStatus"
	 * @uml.associationEnd
	 */
	private UKStatus selectedUKStatus;
	/**
	 * @uml.property name="selectedUKTerm"
	 * @uml.associationEnd
	 */
	private UKTerm selectedUKTerm;
	/**
	 * @uml.property name="selectedAdvisor"
	 * @uml.associationEnd
	 */
	private Advisor selectedAdvisor;
	/**
	 * @uml.property name="selectedRole"
	 * @uml.associationEnd
	 */
	private Role selectedRole;
	/**
	 * @uml.property name="selectedRoles"
	 */
	private List<Role> selectedRoles = new ArrayList<Role>(0);

	private CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator;

	/**
	 * @uml.property name="selectedUsers"
	 */
	private List<User> selectedUsers = new ArrayList<User>(0);
	/**
	 * @uml.property name="userRoles"
	 */
	private List<Role> userRoles = new ArrayList<Role>(0);
	/**
	 * @uml.property name="selectedUKStartTerm"
	 * @uml.associationEnd
	 */
	private UKTerm selectedUKStartTerm;	
	/**
	 * @uml.property name="selectedUKCompleteTerm"
	 * @uml.associationEnd
	 */
	private UKTerm selectedUKCompleteTerm;
	/**
	 * @uml.property name="selectedProgram"
	 * @uml.associationEnd
	 */
	private Program selectedProgram;
	/**
	 * @uml.property name="selectedProgramDomain"
	 * @uml.associationEnd
	 */
	private ProgramDomain selectedProgramDomain;
	/**
	 * @uml.property name="selectedProgramTrack"
	 * @uml.associationEnd
	 */
	private ProgramTrack selectedProgramTrack;
	/**
	 * @uml.property name="selectedProgramGroup"
	 * @uml.associationEnd
	 */
	private ProgramGroup selectedProgramGroup;
	/**
	 * @uml.property name="selectedAddressType"
	 * @uml.associationEnd
	 */
	private AddressType selectedAddressType;
	/**
	 * @uml.property name="selectedEmailAddressType"
	 * @uml.associationEnd
	 */
	private EmailAddressType selectedEmailAddressType;
	/**
	 * @uml.property name="selectedPhoneType"
	 * @uml.associationEnd
	 */
	private PhoneType selectedPhoneType;
	private List<Address> addressList = new ArrayList<Address>(0);

	public UserDetailController() {

	}

	/**
	 * @return the userDetailBean
	 * @uml.property name="userDetailBean"
	 */
	public UserDetailView getUserDetailBean() {
		return userDetailBean;
	}

	/**
	 * @param userDetailBean
	 *            the userDetailBean to set
	 * @uml.property name="userDetailBean"
	 */
	public void setUserDetailBean(UserDetailView userDetailBean) {
		this.userDetailBean = userDetailBean;
	}

	/**
	 * @return the code
	 * @uml.property name="code"
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 * @uml.property name="code"
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the shortDesc
	 * @uml.property name="shortDesc"
	 */
	public String getShortDesc() {
		return shortDesc;
	}

	/**
	 * @param shortDesc
	 *            the shortDesc to set
	 * @uml.property name="shortDesc"
	 */
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	/**
	 * @return the description
	 * @uml.property name="description"
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 * @uml.property name="description"
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the status
	 * @uml.property name="status"
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 * @uml.property name="status"
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the degreeLevel
	 * @uml.property name="degreeLevel"
	 */
	public String getDegreeLevel() {
		return degreeLevel;
	}

	/**
	 * @param degreeLevel
	 *            the degreeLevel to set
	 * @uml.property name="degreeLevel"
	 */
	public void setDegreeLevel(String degreeLevel) {
		this.degreeLevel = degreeLevel;
	}

	/**
	 * @return the degreeAwarded
	 * @uml.property name="degreeAwarded"
	 */
	public int getDegreeAwarded() {
		return degreeAwarded;
	}

	/**
	 * @param degreeAwarded
	 *            the degreeAwarded to set
	 * @uml.property name="degreeAwarded"
	 */
	public void setDegreeAwarded(int degreeAwarded) {
		this.degreeAwarded = degreeAwarded;
	}

	/**
	 * @return the rolename
	 * @uml.property name="rolename"
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * @param rolename
	 *            the rolename to set
	 * @uml.property name="rolename"
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * @return the roledesc
	 * @uml.property name="roledesc"
	 */
	public String getRoledesc() {
		return roledesc;
	}

	/**
	 * @param roledesc
	 *            the roledesc to set
	 * @uml.property name="roledesc"
	 */
	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	/**
	 * @return the otherInfo
	 * @uml.property name="otherInfo"
	 */
	public String getOtherInfo() {
		return otherInfo;
	}

	/**
	 * @param otherInfo
	 *            the otherInfo to set
	 * @uml.property name="otherInfo"
	 */
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	/**
	 * @return the userDetailWarnStatus
	 * @uml.property name="userDetailWarnStatus"
	 */
	public boolean isUserDetailWarnStatus() {
		return userDetailWarnStatus;
	}

	/**
	 * @param userDetailWarnStatus
	 *            the userDetailWarnStatus to set
	 * @uml.property name="userDetailWarnStatus"
	 */
	public void setUserDetailWarnStatus(boolean userDetailWarnStatus) {
		this.userDetailWarnStatus = userDetailWarnStatus;
	}

	/**
	 * @return the userDetailStatusMessage
	 * @uml.property name="userDetailStatusMessage"
	 */
	public String getUserDetailStatusMessage() {
		return userDetailStatusMessage;
	}

	/**
	 * @param userDetailStatusMessage
	 *            the userDetailStatusMessage to set
	 * @uml.property name="userDetailStatusMessage"
	 */
	public void setUserDetailStatusMessage(String userDetailStatusMessage) {
		this.userDetailStatusMessage = userDetailStatusMessage;
	}

	/**
	 * @return the selectedUKMajor
	 * @uml.property name="selectedUKMajor"
	 */
	public UKMajor getSelectedUKMajor() {
		return selectedUKMajor;
	}

	/**
	 * @param selectedUKMajor
	 *            the selectedUKMajor to set
	 * @uml.property name="selectedUKMajor"
	 */
	public void setSelectedUKMajor(UKMajor selectedUKMajor) {
		this.selectedUKMajor = selectedUKMajor;
	}

	/**
	 * @return the selectedUKStatus
	 * @uml.property name="selectedUKStatus"
	 */
	public UKStatus getSelectedUKStatus() {
		return selectedUKStatus;
	}

	/**
	 * @param selectedUKStatus
	 *            the selectedUKStatus to set
	 * @uml.property name="selectedUKStatus"
	 */
	public void setSelectedUKStatus(UKStatus selectedUKStatus) {
		this.selectedUKStatus = selectedUKStatus;
	}

	/**
	 * @return the selectedUKTerm
	 * @uml.property name="selectedUKTerm"
	 */
	public UKTerm getSelectedUKTerm() {
		return selectedUKTerm;
	}

	/**
	 * @param selectedUKTerm
	 *            the selectedUKTerm to set
	 * @uml.property name="selectedUKTerm"
	 */
	public void setSelectedUKTerm(UKTerm selectedUKTerm) {
		this.selectedUKTerm = selectedUKTerm;
	}

	/**
	 * @return the selectedAdvisor
	 * @uml.property name="selectedAdvisor"
	 */
	public Advisor getSelectedAdvisor() {
		return selectedAdvisor;
	}

	/**
	 * @param selectedAdvisor
	 *            the selectedAdvisor to set
	 * @uml.property name="selectedAdvisor"
	 */
	public void setSelectedAdvisor(Advisor selectedAdvisor) {
		this.selectedAdvisor = selectedAdvisor;
	}

	/**
	 * @return the selectedRole
	 * @uml.property name="selectedRole"
	 */
	public Role getSelectedRole() {
		return selectedRole;
	}

	/**
	 * @param selectedRole
	 *            the selectedRole to set
	 * @uml.property name="selectedRole"
	 */
	public void setSelectedRole(Role selectedRole) {
		this.selectedRole = selectedRole;
	}

	/**
	 * @return the selectedRoles
	 * @uml.property name="selectedRoles"
	 */
	public List<Role> getSelectedRoles() {
		return selectedRoles;
	}

	/**
	 * @param selectedRoles
	 *            the selectedRoles to set
	 * @uml.property name="selectedRoles"
	 */
	public void setSelectedRoles(List<Role> selectedRoles) {
		this.selectedRoles = selectedRoles;
	}

	/**
	 * @return the selectedUsers
	 * @uml.property name="selectedUsers"
	 */
	public List<User> getSelectedUsers() {
		return selectedUsers;
	}

	/**
	 * @param selectedUsers
	 *            the selectedUsers to set
	 * @uml.property name="selectedUsers"
	 */
	public void setSelectedUsers(List<User> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}

	/**
	 * @return the userRoles
	 * @uml.property name="userRoles"
	 */
	public List<Role> getUserRoles() {
		return userRoles;
	}

	/**
	 * @param userRoles
	 *            the userRoles to set
	 * @uml.property name="userRoles"
	 */
	public void setUserRoles(List<Role> userRoles) {
		this.userRoles = userRoles;
	}

	/**
	 * @return the selectedUKStartTerm
	 * @uml.property name="selectedUKStartTerm"
	 */
	public UKTerm getSelectedUKStartTerm() {
		return selectedUKStartTerm;
	}

	/**
	 * @param selectedUKStartTerm
	 *            the selectedUKStartTerm to set
	 * @uml.property name="selectedUKStartTerm"
	 */
	public void setSelectedUKStartTerm(UKTerm selectedUKStartTerm) {
		this.selectedUKStartTerm = selectedUKStartTerm;
	}
	/**
	 * @return the selectedUKCompleteTerm
	 * @uml.property name="selectedUKCompleteTerm"
	 */
	public UKTerm getSelectedUKCompleteTerm() {
		return selectedUKCompleteTerm;
	}

	/**
	 * @param selectedUKCompleteTerm
	 *            the selectedUKCompleteTerm to set
	 * @uml.property name="selectedUKCompleteTerm"
	 */
	public void setSelectedUKCompleteTerm(UKTerm selectedUKCompleteTerm) {
		this.selectedUKCompleteTerm = selectedUKCompleteTerm;
	}

	/**
	 * @return the selectedProgram
	 * @uml.property name="selectedProgram"
	 */
	public Program getSelectedProgram() {
		return selectedProgram;
	}

	/**
	 * @param selectedProgram
	 *            the selectedProgram to set
	 * @uml.property name="selectedProgram"
	 */
	public void setSelectedProgram(Program selectedProgram) {
		this.selectedProgram = selectedProgram;
	}

	/**
	 * @return the selectedProgramDomain
	 * @uml.property name="selectedProgramDomain"
	 */
	public ProgramDomain getSelectedProgramDomain() {
		return selectedProgramDomain;
	}

	/**
	 * @param selectedProgramDomain
	 *            the selectedProgramDomain to set
	 * @uml.property name="selectedProgramDomain"
	 */
	public void setSelectedProgramDomain(ProgramDomain selectedProgramDomain) {
		this.selectedProgramDomain = selectedProgramDomain;
	}

	/**
	 * @return the selectedProgramTrack
	 * @uml.property name="selectedProgramTrack"
	 */
	public ProgramTrack getSelectedProgramTrack() {
		return selectedProgramTrack;
	}

	/**
	 * @param selectedProgramTrack
	 *            the selectedProgramTrack to set
	 * @uml.property name="selectedProgramTrack"
	 */
	public void setSelectedProgramTrack(ProgramTrack selectedProgramTrack) {
		this.selectedProgramTrack = selectedProgramTrack;
	}

	/**
	 * @return the selectedProgramGroup
	 * @uml.property name="selectedProgramGroup"
	 */
	public ProgramGroup getSelectedProgramGroup() {
		return selectedProgramGroup;
	}

	/**
	 * @param selectedProgramGroup
	 *            the selectedProgramGroup to set
	 * @uml.property name="selectedProgramGroup"
	 */
	public void setSelectedProgramGroup(ProgramGroup selectedProgramGroup) {
		this.selectedProgramGroup = selectedProgramGroup;
	}

	/**
	 * @return the selectedAddressType
	 * @uml.property name="selectedAddressType"
	 */
	public AddressType getSelectedAddressType() {
		return selectedAddressType;
	}

	/**
	 * @param selectedAddressType
	 *            the selectedAddressType to set
	 * @uml.property name="selectedAddressType"
	 */
	public void setSelectedAddressType(AddressType selectedAddressType) {
		this.selectedAddressType = selectedAddressType;
	}

	/**
	 * @return the selectedEmailAddressType
	 * @uml.property name="selectedEmailAddressType"
	 */
	public EmailAddressType getSelectedEmailAddressType() {
		return selectedEmailAddressType;
	}

	/**
	 * @param selectedEmailAddressType
	 *            the selectedEmailAddressType to set
	 * @uml.property name="selectedEmailAddressType"
	 */
	public void setSelectedEmailAddressType(
			EmailAddressType selectedEmailAddressType) {
		this.selectedEmailAddressType = selectedEmailAddressType;
	}

	/**
	 * @return the selectedPhoneType
	 * @uml.property name="selectedPhoneType"
	 */
	public PhoneType getSelectedPhoneType() {
		return selectedPhoneType;
	}

	/**
	 * @param selectedPhoneType
	 *            the selectedPhoneType to set
	 * @uml.property name="selectedPhoneType"
	 */
	public void setSelectedPhoneType(PhoneType selectedPhoneType) {
		this.selectedPhoneType = selectedPhoneType;
	}

	public void initApplicationComponent(PhaseEvent event) {

	}

	/*
	 * UKMajor Operation
	 */
	public String createUKMajor() {
		if (!this.getUserDetailBean().createUKMajor(code, shortDesc,
				description, status, degreeLevel)) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot create UKMajor");
		} else {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("UKMajor created Successfully");
		}
		return "reload";
	}

	public String deleteUKMajor() {
		if (this.getSelectedUKMajor() == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot delete UKMajor");
			return "reload";
		}
		if (this.getUserDetailBean().deleteUKMajor(this.getSelectedUKMajor())) {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("UKMajor Deleted successfuly");
		} else {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot delete UKMajor");
		}
		return "reload";
	}

	public void valueChangeEditUKMajor(AjaxEvent event) {
		System.out.println("Calling valueChangeEditUKMajor");

		if (this.getSelectedUKMajor() != null) {
			this.setCode(this.getSelectedUKMajor().getUkMajorCode());
			this.setShortDesc(this.getSelectedUKMajor().getShortDesc());
			this.setDescription(this.getSelectedUKMajor().getDescription());
			this.setStatus(this.getSelectedUKMajor().getStatus());
			this.setDegreeLevel(this.getSelectedUKMajor().getDegreeLevel());

		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}

	public String editUKMajor() {
		if (this.getSelectedUKMajor() == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot edit UKMajor");
			return "reload";
		}

		if (this.getUserDetailBean().editUKMajor(this.getSelectedUKMajor(),
				code, shortDesc, description, status, degreeLevel)) {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("UKMajor editted successfully");
		} else {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot edit UKMajor");
		}
		return "reload";
	}

	/*
	 * UKStatus Operation
	 */
	public String createUKStatus() {
		if (!this.getUserDetailBean().createUKStatus(code, shortDesc,
				description, status)) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot create UKStatus");
		} else {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("UKStatus created Successfully");
		}
		return "reload";
	}

	public String deleteUKStatus() {
		if (this.getSelectedUKStatus() == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot delete UKStatus");
			return "reload";
		}
		if (this.getUserDetailBean().deleteUKStatus(this.getSelectedUKStatus())) {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("UKStatus Deleted successfuly");
		} else {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot delete UKStatus");
		}
		return "reload";
	}

	public void valueChangeEditUKStatus(AjaxEvent event) {
		System.out.println("Calling valueChangeEditUKStatus");

		if (this.getSelectedUKStatus() != null) {
			this.setCode(this.getSelectedUKStatus().getStatusCode());
			this.setShortDesc(this.getSelectedUKStatus().getShortDesc());
			this.setDescription(this.getSelectedUKStatus().getDescription());
			this.setStatus(this.getSelectedUKStatus().getStatus());

		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}

	public String editUKStatus() {
		if (this.getSelectedUKStatus() == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot edit UKStatus");
			return "reload";
		}

		if (this.getUserDetailBean().editUKStatus(this.getSelectedUKStatus(),
				code, shortDesc, description, status)) {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("UKStatus editted successfully");
		} else {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot edit UKStatus");
		}
		return "reload";
	}

	/*
	 * UKTerm Operation
	 */
	public String createUKTerm() {
		if (!this.getUserDetailBean().createUKTerm(code, shortDesc,
				description, status)) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot create UKTerm");
		} else {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("UKTerm created Successfully");
		}
		return "reload";
	}

	public String deleteUKTerm() {
		if (this.getSelectedUKTerm() == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot delete UKTerm");
			return "reload";
		}
		if (this.getUserDetailBean().deleteUKTerm(this.getSelectedUKTerm())) {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("UKTerm Deleted successfuly");
		} else {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot delete UKTerm");
		}
		return "reload";
	}

	public void valueChangeEditUKTerm(AjaxEvent event) {
		System.out.println("Calling valueChangeEditUKTerm");

		if (this.getSelectedUKTerm() != null) {
			this.setCode(this.getSelectedUKTerm().getUkTermCode());
			this.setShortDesc(this.getSelectedUKTerm().getShortDesc());
			this.setDescription(this.getSelectedUKTerm().getDescription());
			this.setStatus(this.getSelectedUKTerm().getStatus());

		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}

	public String editUKTerm() {
		if (this.getSelectedUKTerm() == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot edit UKTerm");
			return "reload";
		}

		if (this.getUserDetailBean().editUKTerm(this.getSelectedUKTerm(), code,
				shortDesc, description, status)) {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("UKTerm editted successfully");
		} else {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot edit UKTerm");
		}
		return "reload";
	}

	public String createRole() {
		if (this.getUserDetailBean().createRole(rolename, roledesc, otherInfo) == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot create Role");
		} else {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("Role created successfully");
		}
		return "reload";
	}

	public String editRole() {
		if (this.getSelectedRole() == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot edit Role");
			return "reload";
		}

		if (this.getUserDetailBean().updateRole(this.getSelectedRole(),
				rolename, roledesc, otherInfo) == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot edit Role");

		} else {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("Role editted successfully");
		}
		return "reload";
	}

	public void valueChangeEditRole(AjaxEvent event) {
		System.out.println("Calling valueChangeEditROle");

		if (this.getSelectedRole() != null) {
			System.out.println("Role info" + this.getSelectedRole());
			this.setRolename(this.getSelectedRole().getRolename());
			this.setRoledesc(this.getSelectedRole().getRoledesc());
			this.setOtherInfo(this.getSelectedRole().getOtherInfo());
		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}

	public String deleteRole() {
		if (this.getSelectedRole() == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot delete Role");
			return "reload";
		}
		if (this.getUserDetailBean().deleteRole(this.getSelectedRole())) {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("Role Deleted successfuly");
		} else {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot delete Role");
		}
		return "reload";
	}

	/*
	 * AddressType Operation
	 */
	public String createAddressType() {
		if (this.getUserDetailBean().createAddressType(code, shortDesc) == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot create specified Address Type");
		} else {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("Address Type created Successfully");
		}
		return null;
	}

	public String editAddressType() {
		if (this.getSelectedAddressType() == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot edit AddressType");
			return null;
		}

		if (this.getUserDetailBean().editAddressType(
				this.getSelectedAddressType(), code, shortDesc)) {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("AddressType editted successfully");
		} else {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot edit AddressType");
		}
		return null;
	}

	public void valueChangeEditAddressType(AjaxEvent event) {
		System.out.println("Calling valueChangeEditAddressType");

		if (this.getSelectedAddressType() != null) {
			this.setCode(this.getSelectedAddressType().getCode());
			this.setShortDesc(this.getSelectedAddressType().getDesc());
		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}

	public String deleteAddressType() {
		if (this.getSelectedAddressType() == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot delete AddressType");
			return null;
		}
		if (this.getUserDetailBean().deleteAddressType(
				this.getSelectedAddressType())) {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("AddressType Deleted successfuly");
		} else {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot delete AddressType");
		}
		return null;
	}

	/*
	 * EmailAddressType Operation
	 */
	public String createEmailAddressType() {
		if (this.getUserDetailBean().createEmailAddressType(code, shortDesc) == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot create specified Email AddressType");
		} else {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("Email AddressType created Successfully");
		}
		return null;
	}

	public String editEmailAddressType() {
		if (this.getSelectedEmailAddressType() == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot edit EmailAddressType");
			return null;
		}

		if (this.getUserDetailBean().editEmailAddressType(
				this.getSelectedEmailAddressType(), code, shortDesc)) {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("EmailAddressType editted successfully");
		} else {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot edit EmailAddressType");
		}
		return null;
	}

	public void valueChangeEditEmailAddressType(AjaxEvent event) {
		System.out.println("Calling valueChangeEditEmailAddressType");

		if (this.getSelectedEmailAddressType() != null) {
			this.setCode(this.getSelectedEmailAddressType().getCode());
			this.setShortDesc(this.getSelectedEmailAddressType().getDesc());
		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}

	public String deleteEmailAddressType() {
		if (this.getSelectedEmailAddressType() == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot delete Email AddressType");
			return null;
		}
		if (this.getUserDetailBean().deleteEmailAddressType(
				this.getSelectedEmailAddressType())) {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("Email AddressType Deleted successfuly");
		} else {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot delete Email AddressType");
		}
		return null;
	}

	/*
	 * PhoneType Operation
	 */
	public String createPhoneType() {
		if (this.getUserDetailBean().createPhoneType(code, shortDesc) == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot create specified Phone Type");
		} else {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("Phone Type created Successfully");
		}
		return null;
	}

	public String editPhoneType() {
		if (this.getSelectedPhoneType() == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot edit PhoneType");
			return null;
		}

		if (this.getUserDetailBean().editPhoneType(this.getSelectedPhoneType(),
				code, shortDesc)) {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("PhoneType editted successfully");
		} else {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot edit PhoneType");
		}
		return null;
	}

	public void valueChangeEditPhoneType(AjaxEvent event) {
		System.out.println("Calling valueChangeEditPhoneType");

		if (this.getSelectedPhoneType() != null) {
			this.setCode(this.getSelectedPhoneType().getCode());
			this.setShortDesc(this.getSelectedPhoneType().getDesc());
		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}

	public String deletePhoneType() {
		if (this.getSelectedPhoneType() == null) {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot delete PhoneType");
			return null;
		}
		if (this.getUserDetailBean().deletePhoneType(
				this.getSelectedPhoneType())) {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("PhoneType Deleted successfuly");
		} else {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: Cannot delete AddressType");
		}
		return null;
	}

	public String addAdvisorWrapToUser() {

		if (this.getConfigurationManager().getSelectedUser() == null) {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("No user selected");
			return null;
		}
		if (this.getUserDetailBean().addAdvisorWrapToUser(
				this.getConfigurationManager().getSelectedUser())) {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("Advisor created successfully successfully");
		} else {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: cannot create Advisor");

		}
		return null;
	}

	public String editAdvisorStatus() {

		if (this.getSelectedAdvisor() == null) {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("No advisor selected");
			return null;
		}

		if (this.getUserDetailBean().editAdvisorStatus(
				this.getSelectedAdvisor(), status, this.getOfficeLocation())) {
			this.setUserDetailWarnStatus(false);
			this.setUserDetailStatusMessage("Advisor status updated successfully");
		} else {
			this.setUserDetailWarnStatus(true);
			this.setUserDetailStatusMessage("Unknown error: cannot update Advisor status");

		}
		if (this.getSelectedAdvisorGroup() != null
				|| this.getSelectedAdvisorGroup().getId() < 1) {
			AdvisorGroup advisorGroup = this
					.getCepisGlobalComponentConfigurator().findAdvisorGroup(
							this.getSelectedAdvisor());
			if (this.getSelectedAdvisorGroup() == advisorGroup) {
				return null;
			} else {
				if (this.getSelectedAdvisorGroup() != null
						&& this.getSelectedAdvisorGroup().getId() > 0) {

					if (advisorGroup != null) {
						this.getUserDetailBean()
								.removeAdvisorFromGroup(
										getSelectedAdvisorGroup(),
										getSelectedAdvisor());
					}
					if (!this.getUserDetailBean().addAdvisorToGroup(
							getSelectedAdvisorGroup(), getSelectedAdvisor())) {
						this.setUserDetailWarnStatus(true);
						this.setUserDetailStatusMessage("Unknown error: cannot update Advisor Group information");

					}
				} else {
					if (advisorGroup != null)
						if (!this.getUserDetailBean().removeAdvisorFromGroup(
								advisorGroup, getSelectedAdvisor())) {
							this.setUserDetailWarnStatus(true);
							this.setUserDetailStatusMessage("Unknown error: cannot update Advisor Group information");

						}
				}
			}
		}
		return null;
	}

	public List<Address> getAddressList() {
		System.out.println("Calling Get Address List");
		if (this.getSelectedAdvisor() != null
				&& this.getSelectedAdvisor().getUserid() != null) {
			this.setAddressList(this.getUserDetailBean().getAddressList(
					this.getSelectedAdvisor()));
		}
		return this.addressList;
	}

	private void setAddressList(List<Address> addressList2) {
		this.addressList = addressList2;

	}

	public void valueChangeEditAdvisor(ActionEvent event) {
		System.out.println("Calling valueChangeEditAdvisor");
		if (this.selectedAdvisor != null
				&& this.getSelectedAdvisor().getUserid() != null) {
			this.setStatus(this.getSelectedAdvisor().getStatus());
			this.setOfficeLocation(this.getSelectedAdvisor()
					.getOfficeLocation());
			this.setSelectedAdvisorGroup(this
					.getCepisGlobalComponentConfigurator().findAdvisorGroup(
							this.getSelectedAdvisor()));
		}
	}

	/**
	 * @return the cepisGlobalComponentConfigurator
	 */
	public CEPISGlobalComponentConfigurator getCepisGlobalComponentConfigurator() {
		return cepisGlobalComponentConfigurator;
	}

	/**
	 * @param cepisGlobalComponentConfigurator
	 *            the cepisGlobalComponentConfigurator to set
	 */
	public void setCepisGlobalComponentConfigurator(
			CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator) {
		this.cepisGlobalComponentConfigurator = cepisGlobalComponentConfigurator;
	}

	/**
	 * @return the selectedAdvisorGroup
	 */
	public AdvisorGroup getSelectedAdvisorGroup() {
		return selectedAdvisorGroup;
	}

	/**
	 * @param selectedAdvisorGroup
	 *            the selectedAdvisorGroup to set
	 */
	public void setSelectedAdvisorGroup(AdvisorGroup selectedAdvisorGroup) {
		this.selectedAdvisorGroup = selectedAdvisorGroup;
	}

	/**
	 * @param officeLocation
	 *            the officeLocation to set
	 */
	public void setOfficeLocation(Address officeLocation) {
		this.officeLocation = officeLocation;
	}

	/**
	 * @return the officeLocation
	 */
	public Address getOfficeLocation() {
		return officeLocation;
	}
}
