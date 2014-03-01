/**
 * 
 */
package edu.uky.cepis.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.ajax4jsf.event.AjaxEvent;

import edu.uky.cepis.domain.AdvisorGroup;
import edu.uky.cepis.domain.CohortTerm;
import edu.uky.cepis.domain.CohortType;
import edu.uky.cepis.domain.Ethnic;
import edu.uky.cepis.domain.Ranking;
import edu.uky.cepis.domain.UserClassification;
import edu.uky.cepis.domain.UserType;
import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.ProgramGroup;
import edu.uky.cepis.domain.component.ProgramTrack;
import edu.uky.cepis.domain.component.UKCollege;
import edu.uky.cepis.domain.component.UKDepartment;
import edu.uky.cepis.view.ApplicationComponentView;

/**
 * @author keerthi
 */
public class ApplicationComponentController extends AbstractController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property name="appComponentBean"
	 * @uml.associationEnd
	 */
	private ApplicationComponentView appComponentBean;

	/**
	 * @uml.property name="appComponentStatusMessage"
	 */
	private String appComponentStatusMessage;

	/**
	 * @uml.property name="appComponentWarnStatus"
	 */
	private boolean appComponentWarnStatus;

	/**
	 * @uml.property name="code"
	 */
	private String name;
	private String code;
	private String collegeAddress;
	private String collegeDeanName;

	private String collegeName;

	private String departmentAddress;

	private String departmentChairName;

	private String departmentName;

	/**
	 * @uml.property name="description"
	 */
	private String description;

	private String kyEthnicCode;

	private String phone;

	/**
	 * @uml.property name="programDomain_ProgramList"
	 */
	private List<Program> programDomain_ProgramList = new ArrayList<Program>(0);

	/**
	 * @uml.property name="selectedCohortTerm"
	 * @uml.associationEnd
	 */
	private CohortTerm selectedCohortTerm;
	/**
	 * @uml.property name="selectedCohortType"
	 * @uml.associationEnd
	 */
	private CohortType selectedCohortType;
	/**
	 * @uml.property name="selectedRanking"
	 * @uml.associationEnd
	 */
	private Ranking selectedRanking;

	/**
	 * @uml.property name="selectedEthnic"
	 * @uml.associationEnd
	 */
	private Ethnic selectedEthnic;

	/**
	 * @uml.property name="selectedProgram"
	 * @uml.associationEnd
	 */
	private Program selectedProgram;
	
	private AdvisorGroup selectedAdvisorGroup;

	/**
	 * @uml.property name="selectedProgramDomain"
	 * @uml.associationEnd
	 */
	private ProgramDomain selectedProgramDomain;

	/**
	 * @uml.property name="selectedProgramGroup"
	 * @uml.associationEnd
	 */
	private ProgramGroup selectedProgramGroup;

	/**
	 * @uml.property name="selectedProgramTrack"
	 * @uml.associationEnd
	 */
	private ProgramTrack selectedProgramTrack;
	/**
	 * @uml.property name="selectedUKCollege"
	 * @uml.associationEnd
	 */
	private UKCollege selectedUKCollege;
	/**
	 * @uml.property name="selectedUKDepartment"
	 * @uml.associationEnd
	 */
	private UKDepartment selectedUKDepartment;

	/**
	 * @uml.property name="selectedUserClassification"
	 * @uml.associationEnd
	 */
	private UserClassification selectedUserClassification;
	/**
	 * @uml.property name="selectedUserType"
	 * @uml.associationEnd
	 */
	private UserType selectedUserType;

	/**
	 * @uml.property name="shortDesc"
	 */
	private String shortDesc;
	private String speedSort;

	/**
	 * @uml.property name="status"
	 */
	private String status;
	private int termCode;
	private String title;
	private String program;

	private List<UserClassification> userType_UserClassificationList = new ArrayList<UserClassification>(
			0);

	public ApplicationComponentController() {

	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the selectedAdvisorGroup
	 */
	public AdvisorGroup getSelectedAdvisorGroup() {
		return selectedAdvisorGroup;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param selectedAdvisorGroup the selectedAdvisorGroup to set
	 */
	public void setSelectedAdvisorGroup(AdvisorGroup selectedAdvisorGroup) {
		this.selectedAdvisorGroup = selectedAdvisorGroup;
	}

	public String addProgramToProgramDomain() {
		if (this.getSelectedProgramDomain() == null
				|| this.getSelectedProgramDomain().getProgramDomainCode() == null) {
			this.setAppComponentWarnStatus(true);
			this.setAppComponentStatusMessage("No Program Domain selected");
			return "reload";
		}
		if (this.getSelectedProgram() == null
				|| this.getSelectedProgram().getProgramCode() == null) {
			this.setAppComponentWarnStatus(true);
			this.setAppComponentStatusMessage("No Program selected");
			return "reload";
		}
		if (!this.getAppComponentBean().addProgramToProgramDomain(
				this.getSelectedProgramDomain(), this.getSelectedProgram())) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown error: Cannot add Program to Program Domain");

		}
		this.setAppComponentWarnStatus(false);
		this
				.setAppComponentStatusMessage("Program added successfully to program domain");
		return "reload";

	}

	public String addUserClassificationToUserType() {
		if (this.getSelectedUserType() == null
				|| this.getSelectedUserType().getTypeCode() == null) {
			this.setAppComponentWarnStatus(true);
			this.setAppComponentStatusMessage("No c selected");
			return null;
		}
		if (this.getSelectedUserClassification() == null
				|| this.getSelectedUserClassification().getClassificationCode() == null) {
			this.setAppComponentWarnStatus(true);
			this.setAppComponentStatusMessage("No UserClassification selected");
			return null;
		}
		if (!this.getAppComponentBean().addUserClassificationToUserType(
				this.getSelectedUserType(),
				this.getSelectedUserClassification())) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown error: Cannot add UserClassification to UserType ");

		}
		this.setAppComponentWarnStatus(false);
		this
				.setAppComponentStatusMessage("UserClassification added successfully to UserType");
		return null;

	}

	public String createCohortTerm() {
		if (this.getAppComponentBean().createCohortTerm(termCode, shortDesc,
				description)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("New CohortTerm Information Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - CohortTerm Information cannot be created");
		}
		return null;
	}

	public String createCohortType() {
		if (this.getAppComponentBean().createCohortType(code, shortDesc,
				description, status)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("New CohortType Information Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - CohortType Information cannot be created");
		}
		return null;
	}

	public String createRanking() {
		if (this.getAppComponentBean().createRanking(code, title, program)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("New Ranking Information Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Ranking Information cannot be created");
		}
		return null;
	}

	public String createEthnic() {
		if (this.getAppComponentBean().createEthnic(code, shortDesc,
				kyEthnicCode)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("New Ethnic Information Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Ethnic Information cannot be created");
		}
		return null;
	}

	public String createProgram() {
		if (this.getAppComponentBean().createProgram(code, shortDesc,
				description, status)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("New Program Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - New program cannot be created");
		}
		return "reload";
	}

	public String createProgramDomain() {
		if (this.getAppComponentBean().createProgramDomain(code, shortDesc,
				description, status)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("New ProgramDomain Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - New ProgramDomain cannot be created");
		}
		return "reload";
	}

	public String createProgramGroup() {
		if (this.getAppComponentBean().createProgramGroup(code, shortDesc,
				description, status)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("New Program Group Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - New program group cannot be created");
		}
		return "reload";
	}

	public String createProgramTrack() {
		if (this.getAppComponentBean().createProgramTrack(code, shortDesc,
				description, status)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("New ProgramTrack Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - New programTrack cannot be created");
		}
		return "reload";
	}

	public String createUKCollege() {
		if (this.getAppComponentBean().createUKCollege(code, collegeName,
				collegeAddress, speedSort, phone, collegeDeanName)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("New UKCollege Information Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - UKCollege Information cannot be created");
		}
		return null;
	}

	public String createUKDepartment() {
		if (this.getAppComponentBean().createUKDepartment(code, departmentName,
				departmentAddress, speedSort, departmentChairName, phone,
				shortDesc, status)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("New UKDepartment Information Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - UKDepartment Information cannot be created");
		}
		return null;
	}

	public String createUserClassification() {
		if (this.getAppComponentBean().createUserClassification(code,
				shortDesc, description, status)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("New UserClassification Information Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - UserClassification Information cannot be created");
		}
		return null;
	}

	public String createUserType() {
		if (this.getAppComponentBean().createUserType(code, shortDesc)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("New UserType Information Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - UserType Information cannot be created");
		}
		return null;
	}

	public String createAdvisorGroup() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getAppComponentBean().createAdvisorGroup(name, shortDesc) != null) {
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("[" + new Date() + "] Advisor Group " + name
					+ " created successfully.");
			context.addMessage("msg", message);
		} else {
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("[" + new Date()
					+ "] Unknown error: Cannot create advisor group.");
			context.addMessage("msg", message);
		}
		return null;
	}

	public String deleteCohortTerm() {

		if (this.getSelectedCohortTerm() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot delete CohortTerm information");
			return null;
		}

		if (this.getAppComponentBean().deleteCohortTerm(
				this.getSelectedCohortTerm())) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("CohortTerm Information deleted successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error -  CohortTerm information cannot be deleted");
		}
		return null;
	}

	public String deleteRanking() {

		if (this.getSelectedRanking() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot delete Ranking information");
			return null;
		}

		if (this.getAppComponentBean().deleteRanking(this.getSelectedRanking())) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("Ranking Information deleted successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error -  Ranking information cannot be deleted");
		}
		return null;
	}

	public String deleteCohortType() {

		if (this.getSelectedCohortType() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot delete CohortType information");
			return null;
		}

		if (this.getAppComponentBean().deleteCohortType(
				this.getSelectedCohortType())) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("CohortType Information deleted successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error -  CohortType information cannot be deleted");
		}
		return null;
	}

	public String deleteEthnic() {

		if (this.getSelectedEthnic() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot delete ethnic information");
			return null;
		}

		if (this.getAppComponentBean().deleteEthnic(this.getSelectedEthnic())) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("Ethnic Information deleted successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error -  ethnic information cannot be deleted");
		}
		return null;
	}

	public String deleteProgram() {

		if (this.getSelectedProgram() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot delete program");
			return "reload";
		}

		if (this.getAppComponentBean().deleteProgram(this.getSelectedProgram())) {
			this.setAppComponentWarnStatus(false);
			this.setAppComponentStatusMessage("Program delete successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error -  program cannot be deleted");
		}
		return "reload";
	}

	public String deleteProgramDomain() {

		if (this.getSelectedProgramDomain() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot delete ProgramDomain");
			return "reload";
		}

		if (this.getAppComponentBean().deleteProgramDomain(
				this.getSelectedProgramDomain())) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("ProgramDomain deleted successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error -  ProgramDomain cannot be deleted");
		}
		return "reload";
	}

	public String deleteProgramGroup() {

		if (this.getSelectedProgramGroup() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot delete program Group");
			return "reload";
		}
		if (this.getAppComponentBean().deleteProgramGroup(
				this.getSelectedProgramGroup())) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("ProgramGroup deleted successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error -  program group cannot be deleted");
		}
		return "reload";
	}

	public String deleteProgramTrack() {

		if (this.getSelectedProgramTrack() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot delete ProgramTrack");
			return "reload";
		}
		if (this.getAppComponentBean().deleteProgramTrack(
				this.getSelectedProgramTrack())) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("ProgramTrack deleted successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error -  ProgramTrack cannot be deleted");
		}
		return "reload";
	}

	public String deleteUKCollege() {

		if (this.getSelectedUKCollege() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot delete UKCollege information");
			return null;
		}

		if (this.getAppComponentBean().deleteUKCollege(
				this.getSelectedUKCollege())) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("UKCollege Information deleted successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error -  UKCollege information cannot be deleted");
		}
		return null;
	}

	public String deleteUKDepartment() {

		if (this.getSelectedUKDepartment() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot delete UKDepartment information");
			return null;
		}

		if (this.getAppComponentBean().deleteUKDepartment(
				this.getSelectedUKDepartment())) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("UKDepartment Information deleted successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error -  UKDepartment information cannot be deleted");
		}
		return null;
	}

	public String deleteUserClassification() {

		if (this.getSelectedUserClassification() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot delete UserClassification information");
			return null;
		}

		if (this.getAppComponentBean().deleteUserClassification(
				this.getSelectedUserClassification())) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("UserClassification Information deleted successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error -  UserClassification information cannot be deleted");
		}
		return null;
	}

	public String deleteUserType() {

		if (this.getSelectedUserType() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot delete UserType information");
			return null;
		}

		if (this.getAppComponentBean().deleteUserType(
				this.getSelectedUserType())) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("UserType Information deleted successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error -  UserType information cannot be deleted");
		}
		return null;
	}
	
	public String deleteAdvisorGroup() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getAppComponentBean().deleteAdvisorGroup(selectedAdvisorGroup)) {
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("[" + new Date() + "] Advisor Group deleted successfully.");
			context.addMessage("msg", message);
		} else {
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("[" + new Date()
					+ "] Unknown error: Cannot delete advisor group.");
			context.addMessage("msg", message);
		}
		return null;
	}

	public String editCohortTerm() {

		if (this.getSelectedCohortTerm() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit CohortTerm information");
			return null;
		}

		if (this.getAppComponentBean().editCohortTerm(
				this.getSelectedCohortTerm(), termCode, shortDesc, description)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("CohortTerm Information updated Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit CohortTerm information");
		}
		return null;
	}

	public String editRanking() {

		if (this.getSelectedRanking() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit Ranking information");
			return null;
		}

		if (this.getAppComponentBean().editRanking(this.getSelectedRanking(),
				code, title, program)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("Ranking Information updated successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit Ranking information");
		}
		return null;
	}

	public String editCohortType() {

		if (this.getSelectedCohortType() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit CohortType information");
			return null;
		}

		if (this.getAppComponentBean().editCohortType(
				this.getSelectedCohortType(), code, shortDesc, description,
				status)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("CohortType Information updated Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit CohortType information");
		}
		return null;
	}

	public String editEthnic() {

		if (this.getSelectedEthnic() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit ethnic information");
			return null;
		}

		if (this.getAppComponentBean().editEthnic(this.getSelectedEthnic(),
				code, shortDesc, kyEthnicCode)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("Ethnic Information updated Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit ethnic information");
		}
		return null;
	}

	public String editProgram() {

		if (this.getSelectedProgram() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit program");
			return "reload";
		}

		if (this.getAppComponentBean().editProgram(this.getSelectedProgram(),
				code, shortDesc, description, status)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("Program updated Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit program");
		}
		return "reload";
	}

	public String editProgramDomain() {

		if (this.getSelectedProgramDomain() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit ProgramDomain");
			return "reload";
		}

		if (this.getAppComponentBean().editProgramDomain(
				this.getSelectedProgramDomain(), code, shortDesc, description,
				status)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("ProgramDomain updated Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit ProgramDomain");
		}
		return "reload";
	}

	public String editProgramGroup() {

		if (this.getSelectedProgramGroup() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit program group");
			return "reload";
		}
		if (this.getAppComponentBean().editProgramGroup(
				this.getSelectedProgramGroup(), code, shortDesc, description,
				status)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("Program Group updated Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit program Group");
		}
		return "reload";
	}

	public String editProgramTrack() {

		if (this.getSelectedProgramTrack() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit ProgramTrack");
			return "reload";
		}

		if (this.getAppComponentBean().editProgramTrack(
				this.getSelectedProgramTrack(), code, shortDesc, description,
				status)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("ProgramTrack updated Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit ProgramTrack");
		}
		return "reload";
	}

	public String editUKCollege() {

		if (this.getSelectedUKCollege() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit UKCollege information");
			return null;
		}

		if (this.getAppComponentBean().editUKCollege(
				this.getSelectedUKCollege(), code, collegeName, collegeAddress,
				speedSort, phone, collegeDeanName)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("UKCollege Information updated Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit UKCollege information");
		}
		return null;
	}

	public String editUKDepartment() {

		if (this.getSelectedUKDepartment() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit UKDepartment information");
			return null;
		}

		if (this.getAppComponentBean().editUKDepartment(
				this.getSelectedUKDepartment(), code, departmentName,
				departmentAddress, speedSort, departmentChairName, phone,
				shortDesc, status)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("UKDepartment Information updated Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit UKDepartment information");
		}
		return null;
	}

	public String editUserClassification() {

		if (this.getSelectedUserClassification() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit UserClassification information");
			return null;
		}

		if (this.getAppComponentBean().editUserClassification(
				this.getSelectedUserClassification(), code, shortDesc,
				description, status)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("UserClassification Information updated Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit UserClassification information");
		}
		return null;
	}

	public String editUserType() {

		if (this.getSelectedUserType() == null) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit UserType information");
			return null;
		}

		if (this.getAppComponentBean().editUserType(this.getSelectedUserType(),
				code, shortDesc)) {
			this.setAppComponentWarnStatus(false);
			this
					.setAppComponentStatusMessage("UserType Information updated Created successfully");
		} else {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown Error - Cannot edit UserType information");
		}
		return null;
	}
	
	public String editAdvisorGroup() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getAppComponentBean().updateAdvisorGroup(selectedAdvisorGroup, name, shortDesc)!=null) {
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("[" + new Date() + "] Advisor Group updated successfully.");
			context.addMessage("msg", message);
		} else {
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("[" + new Date()
					+ "] Unknown error: Cannot update advisor group.");
			context.addMessage("msg", message);
		}
		return null;
	}

	/**
	 * @return the appComponentBean
	 * @uml.property name="appComponentBean"
	 */
	public ApplicationComponentView getAppComponentBean() {
		return appComponentBean;
	}

	/**
	 * @return the appComponentStatusMessage
	 * @uml.property name="appComponentStatusMessage"
	 */
	public String getAppComponentStatusMessage() {
		return appComponentStatusMessage;
	}

	/**
	 * @return the appComponentWarnStatus
	 * @uml.property name="appComponentWarnStatus"
	 */
	public String getAppComponentWarnStatus() {
		if (this.appComponentWarnStatus) {
			return "Warning: ";
		}
		return "Info: ";
	}

	/**
	 * @return the code
	 * @uml.property name="code"
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the collegeAddress
	 * @uml.property name="collegeAddress"
	 */
	public String getCollegeAddress() {
		return collegeAddress;
	}

	/**
	 * @return the collegeDeanName
	 * @uml.property name="collegeDeanName"
	 */
	public String getCollegeDeanName() {
		return collegeDeanName;
	}

	/**
	 * @return the collegeName
	 * @uml.property name="collegeName"
	 */
	public String getCollegeName() {
		return collegeName;
	}

	/**
	 * @return the departmentAddress
	 * @uml.property name="departmentAddress"
	 */
	public String getDepartmentAddress() {
		return departmentAddress;
	}

	/**
	 * @return the departmentChairName
	 * @uml.property name="departmentChairName"
	 */
	public String getDepartmentChairName() {
		return departmentChairName;
	}

	/**
	 * @return the departmentName
	 * @uml.property name="departmentName"
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @return the description
	 * @uml.property name="description"
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the kyEthnicCode
	 * @uml.property name="kyEthnicCode"
	 */
	public String getKyEthnicCode() {
		return kyEthnicCode;
	}

	/**
	 * @return the phone
	 * @uml.property name="phone"
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the programDomain_ProgramList
	 * @uml.property name="programDomain_ProgramList"
	 */
	public List<Program> getProgramDomain_ProgramList() {
		List<Program> programs = new ArrayList<Program>(0);
		if (this.getSelectedProgramDomain() != null
				&& this.getSelectedProgramDomain().getProgramDomainCode() == null) {
			this.setAppComponentWarnStatus(false);
			this.setAppComponentStatusMessage("No Program Domain Selected");
			return programs;
		}
		if (this.getSelectedProgramDomain() != null) {
			programs = this.getAppComponentBean().getProgramDomainProgramList(
					this.getSelectedProgramDomain());
		}
		return programs;
	}

	/**
	 * @return the selectedCohortTerm
	 * @uml.property name="selectedCohortTerm"
	 */
	public CohortTerm getSelectedCohortTerm() {
		return selectedCohortTerm;
	}

	/**
	 * @return the selectedCohortType
	 * @uml.property name="selectedCohortType"
	 */
	public CohortType getSelectedCohortType() {
		return selectedCohortType;
	}

	/**
	 * @return the selectedEthnic
	 * @uml.property name="selectedEthnic"
	 */
	public Ethnic getSelectedEthnic() {
		return selectedEthnic;
	}

	/**
	 * @return the selectedProgram
	 * @uml.property name="selectedProgram"
	 */
	public Program getSelectedProgram() {
		return selectedProgram;
	}

	/**
	 * @return the selectedProgramDomain
	 * @uml.property name="selectedProgramDomain"
	 */
	public ProgramDomain getSelectedProgramDomain() {
		return selectedProgramDomain;
	}

	/**
	 * @return the selectedProgramGroup
	 * @uml.property name="selectedProgramGroup"
	 */
	public ProgramGroup getSelectedProgramGroup() {
		return selectedProgramGroup;
	}

	/**
	 * @return the selectedProgramTrack
	 * @uml.property name="selectedProgramTrack"
	 */
	public ProgramTrack getSelectedProgramTrack() {
		return selectedProgramTrack;
	}

	/**
	 * @return the selectedUKCollege
	 * @uml.property name="selectedUKCollege"
	 */
	public UKCollege getSelectedUKCollege() {
		return selectedUKCollege;
	}

	/**
	 * @return the selectedUKDepartment
	 * @uml.property name="selectedUKDepartment"
	 */
	public UKDepartment getSelectedUKDepartment() {
		return selectedUKDepartment;
	}

	/**
	 * @return the selectedUserClassification
	 * @uml.property name="selectedUserClassification"
	 */
	public UserClassification getSelectedUserClassification() {
		return selectedUserClassification;
	}

	/**
	 * @return the selectedUserType
	 * @uml.property name="selectedUserType"
	 */
	public UserType getSelectedUserType() {
		return selectedUserType;
	}

	/**
	 * @return the shortDesc
	 * @uml.property name="shortDesc"
	 */
	public String getShortDesc() {
		return shortDesc;
	}

	/**
	 * @return the speedSort
	 * @uml.property name="speedSort"
	 */
	public String getSpeedSort() {
		return speedSort;
	}

	/**
	 * @return the status
	 * @uml.property name="status"
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the termCode
	 * @uml.property name="termCode"
	 */
	public int getTermCode() {
		return termCode;
	}

	/**
	 * @return the userType_UserClassificationList
	 * @uml.property name="userType_UserClassificationList"
	 */
	public Set<UserClassification> getUserType_UserClassificationList() {
		Set<UserClassification> userClassifications = new HashSet<UserClassification>(
				0);
		if (this.getSelectedUserType() != null
				&& this.getSelectedUserType().getTypeCode() == null) {
			this.setAppComponentWarnStatus(false);
			this.setAppComponentStatusMessage("No User Type Selected");
			return userClassifications;
		}
		if (this.getSelectedUserType() != null) {
			userClassifications = this.getAppComponentBean()
					.getUserClassificationFromUserTypeList(
							this.getSelectedUserType());
		}
		return userClassifications;
	}

	public void initApplicationComponent(PhaseEvent event) {

	}

	public String removeProgramFromProgramDomain() {
		if (this.getSelectedProgramDomain() == null
				|| this.getSelectedProgramDomain().getProgramDomainCode() == null) {
			this.setAppComponentWarnStatus(true);
			this.setAppComponentStatusMessage("No Program Domain selected");
			return "reload";
		}
		if (this.getSelectedProgram() == null
				|| this.getSelectedProgram().getProgramCode() == null) {
			this.setAppComponentWarnStatus(true);
			this.setAppComponentStatusMessage("No Program selected");
			return "reload";
		}
		if (!this.getAppComponentBean().removeProgramFromProgramDomain(
				this.getSelectedProgramDomain(), this.getSelectedProgram())) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown error: Cannot remove Program from Program Domain");

		}
		this.setAppComponentWarnStatus(false);
		this
				.setAppComponentStatusMessage("Program removed successfully from program domain");
		return null;

	}

	public String removeUserClassificationFromUserType() {
		if (this.getSelectedUserType() == null
				|| this.getSelectedUserType().getTypeCode() == null) {
			this.setAppComponentWarnStatus(true);
			this.setAppComponentStatusMessage("No UserType selected");
			return null;
		}
		if (this.getSelectedUserClassification() == null
				|| this.getSelectedUserClassification().getClassificationCode() == null) {
			this.setAppComponentWarnStatus(true);
			this.setAppComponentStatusMessage("No UserClassification selected");
			return null;
		}
		if (!this.getAppComponentBean().removeUserClassificationFromUserType(
				this.getSelectedUserClassification(),
				this.getSelectedUserType())) {
			this.setAppComponentWarnStatus(true);
			this
					.setAppComponentStatusMessage("Unknown error: Cannot remove UserClassification from UserType");

		}
		this.setAppComponentWarnStatus(false);
		this
				.setAppComponentStatusMessage("UserClassification removed successfully from UserType");
		return null;

	}

	/**
	 * @param appComponentBean
	 *            the appComponentBean to set
	 * @uml.property name="appComponentBean"
	 */
	public void setAppComponentBean(ApplicationComponentView appComponentBean) {
		this.appComponentBean = appComponentBean;
	}

	/*
	 * Program Controller Operations
	 */

	/**
	 * @param appComponentStatusMessage
	 *            the appComponentStatusMessage to set
	 * @uml.property name="appComponentStatusMessage"
	 */
	public void setAppComponentStatusMessage(String appComponentStatusMessage) {
		this.appComponentStatusMessage = appComponentStatusMessage;
	}

	/**
	 * @param appComponentWarnStatus
	 *            the appComponentWarnStatus to set
	 * @uml.property name="appComponentWarnStatus"
	 */
	public void setAppComponentWarnStatus(boolean appComponentWarnStatus) {
		this.appComponentWarnStatus = appComponentWarnStatus;
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
	 * @param collegeAddress
	 *            the collegeAddress to set
	 * @uml.property name="collegeAddress"
	 */
	public void setCollegeAddress(String collegeAddress) {
		this.collegeAddress = collegeAddress;
	}

	/*
	 * ProgramDomain Controller Operations
	 */

	/**
	 * @param collegeDeanName
	 *            the collegeDeanName to set
	 * @uml.property name="collegeDeanName"
	 */
	public void setCollegeDeanName(String collegeDeanName) {
		this.collegeDeanName = collegeDeanName;
	}

	/**
	 * @param collegeName
	 *            the collegeName to set
	 * @uml.property name="collegeName"
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	/**
	 * @param departmentAddress
	 *            the departmentAddress to set
	 * @uml.property name="departmentAddress"
	 */
	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}

	/**
	 * @param departmentChairName
	 *            the departmentChairName to set
	 * @uml.property name="departmentChairName"
	 */
	public void setDepartmentChairName(String departmentChairName) {
		this.departmentChairName = departmentChairName;
	}

	/*
	 * ProgramTrack Controller Operations
	 */

	/**
	 * @param departmentName
	 *            the departmentName to set
	 * @uml.property name="departmentName"
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the selectedRanking
	 * @uml.property name="selectedRanking"
	 */
	public Ranking getSelectedRanking() {
		return selectedRanking;
	}

	/**
	 * @param selectedRanking
	 *            the selectedRanking to set
	 * @uml.property name="selectedRanking"
	 */
	public void setSelectedRanking(Ranking selectedRanking) {
		this.selectedRanking = selectedRanking;
	}

	/**
	 * @param description
	 *            the description to set
	 * @uml.property name="description"
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * ProgramGroup Controller Operations
	 */

	/**
	 * @param kyEthnicCode
	 *            the kyEthnicCode to set
	 * @uml.property name="kyEthnicCode"
	 */
	public void setKyEthnicCode(String kyEthnicCode) {
		this.kyEthnicCode = kyEthnicCode;
	}

	/**
	 * @param phone
	 *            the phone to set
	 * @uml.property name="phone"
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @param programDomainProgramList
	 *            the programDomain_ProgramList to set
	 * @uml.property name="programDomain_ProgramList"
	 */
	public void setProgramDomain_ProgramList(
			List<Program> programDomainProgramList) {
		programDomain_ProgramList = programDomainProgramList;
	}

	/**
	 * @param selectedCohortTerm
	 *            the selectedCohortTerm to set
	 * @uml.property name="selectedCohortTerm"
	 */
	public void setSelectedCohortTerm(CohortTerm selectedCohortTerm) {
		this.selectedCohortTerm = selectedCohortTerm;
	}

	/**
	 * @param selectedCohortType
	 *            the selectedCohortType to set
	 * @uml.property name="selectedCohortType"
	 */
	public void setSelectedCohortType(CohortType selectedCohortType) {
		this.selectedCohortType = selectedCohortType;
	}

	/*
	 * Ethnic Controller Operations
	 */

	/**
	 * @param selectedEthnic
	 *            the selectedEthnic to set
	 * @uml.property name="selectedEthnic"
	 */
	public void setSelectedEthnic(Ethnic selectedEthnic) {
		this.selectedEthnic = selectedEthnic;
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
	 * @param selectedProgramDomain
	 *            the selectedProgramDomain to set
	 * @uml.property name="selectedProgramDomain"
	 */
	public void setSelectedProgramDomain(ProgramDomain selectedProgramDomain) {
		this.selectedProgramDomain = selectedProgramDomain;
	}

	/**
	 * @param selectedProgramGroup
	 *            the selectedProgramGroup to set
	 * @uml.property name="selectedProgramGroup"
	 */
	public void setSelectedProgramGroup(ProgramGroup selectedProgramGroup) {
		this.selectedProgramGroup = selectedProgramGroup;
	}

	/*
	 * UKCollege Controller Operations
	 */

	/**
	 * @param selectedProgramTrack
	 *            the selectedProgramTrack to set
	 * @uml.property name="selectedProgramTrack"
	 */
	public void setSelectedProgramTrack(ProgramTrack selectedProgramTrack) {
		this.selectedProgramTrack = selectedProgramTrack;
	}

	/**
	 * @param selectedUKCollege
	 *            the selectedUKCollege to set
	 * @uml.property name="selectedUKCollege"
	 */
	public void setSelectedUKCollege(UKCollege selectedUKCollege) {
		this.selectedUKCollege = selectedUKCollege;
	}

	/**
	 * @param selectedUKDepartment
	 *            the selectedUKDepartment to set
	 * @uml.property name="selectedUKDepartment"
	 */
	public void setSelectedUKDepartment(UKDepartment selectedUKDepartment) {
		this.selectedUKDepartment = selectedUKDepartment;
	}

	/**
	 * @param selectedUserClassification
	 *            the selectedUserClassification to set
	 * @uml.property name="selectedUserClassification"
	 */
	public void setSelectedUserClassification(
			UserClassification selectedUserClassification) {
		this.selectedUserClassification = selectedUserClassification;
	}

	/*
	 * UKDepartment Controller Operations
	 */

	/**
	 * @param selectedUserType
	 *            the selectedUserType to set
	 * @uml.property name="selectedUserType"
	 */
	public void setSelectedUserType(UserType selectedUserType) {
		this.selectedUserType = selectedUserType;
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
	 * @param speedSort
	 *            the speedSort to set
	 * @uml.property name="speedSort"
	 */
	public void setSpeedSort(String speedSort) {
		this.speedSort = speedSort;
	}

	/**
	 * @param status
	 *            the status to set
	 * @uml.property name="status"
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * UserType Controller Operations
	 */

	/**
	 * @param termCode
	 *            the termCode to set
	 * @uml.property name="termCode"
	 */
	public void setTermCode(int termCode) {
		this.termCode = termCode;
	}

	/**
	 * @return the title
	 * @uml.property name="title"
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 * @uml.property name="title"
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the program
	 * @uml.property name="program"
	 */
	public String getProgram() {
		return program;
	}

	/**
	 * @param program
	 *            the program to set
	 * @uml.property name="program"
	 */
	public void setProgram(String program) {
		this.program = program;
	}

	/**
	 * @param userTypeUserClassificationList
	 *            the userType_UserClassificationList to set
	 * @uml.property name="userType_UserClassificationList"
	 */
	public void setUserType_UserClassificationList(
			List<UserClassification> userTypeUserClassificationList) {
		userType_UserClassificationList = userTypeUserClassificationList;
	}

	public void valueChangeEditCohortTerm(AjaxEvent event) {
		System.out.println("Calling valueChangeEditCohortTerm");

		if (this.getSelectedCohortTerm() != null) {

			this.setTermCode(this.getSelectedCohortTerm().getTermCode());
			this.setShortDesc(this.getSelectedCohortTerm().getShortDesc());
			this.setDescription(this.getSelectedCohortTerm().getDescription());

		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}

	public void valueChangeEditRanking(AjaxEvent event) {
		System.out.println("Calling valueChangeEditRanking");

		if (this.getSelectedRanking() != null) {

			this.setCode(this.getSelectedRanking().getRankingCode());
			this.setTitle(this.getSelectedRanking().getTitle());
			this.setProgram(this.getSelectedRanking().getProgram());

		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}

	public void valueChangeEditCohortType(AjaxEvent event) {
		System.out.println("Calling valueChangeEditCohortType");

		if (this.getSelectedCohortType() != null) {

			this.setCode(this.getSelectedCohortType().getTypeCode());
			this.setShortDesc(this.getSelectedCohortType().getShortDesc());
			this.setDescription(this.getSelectedCohortType().getDescription());
			this.setStatus(this.getSelectedCohortType().getStatus());

		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}

	/*
	 * UserClassification Controller Operations
	 */

	public void valueChangeEditEthnic(AjaxEvent event) {
		System.out.println("Calling valueChangeEditEthnic");

		if (this.getSelectedEthnic() != null) {

			this.setCode(this.getSelectedEthnic().getCode());
			this.setShortDesc(this.getSelectedEthnic().getShortDesc());
			this.setKyEthnicCode(this.getSelectedEthnic().getKyEthnicCode());
		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}

	public void valueChangeEditProgram(AjaxEvent event) {
		System.out.println("Calling valueChangeEditProgram");

		if (this.getSelectedProgram() != null) {

			this.setCode(this.getSelectedProgram().getProgramCode());
			this.setShortDesc(this.getSelectedProgram().getShortDesc());
			this.setDescription(this.getSelectedProgram().getDescription());
			this.setStatus(this.getSelectedProgram().getStatus());
		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}
	
	public void valueChangeEditAdvisorGroup(AjaxEvent event){
		System.out.println("Calling valueChangeEditAdvisorGroup");
		if(this.getSelectedAdvisorGroup()!=null){
			this.setName(this.getSelectedAdvisorGroup().getName());
			this.setShortDesc(this.getSelectedAdvisorGroup().getShortDesc());
		}else {
			// Raise global error
			System.out.println("empty or many selection");
		}
	}

	public void valueChangeEditProgramDomain(AjaxEvent event) {
		System.out.println("Calling valueChangeEditProgramDomain");

		if (this.getSelectedProgramDomain() != null) {

			this
					.setCode(this.getSelectedProgramDomain()
							.getProgramDomainCode());
			this.setShortDesc(this.getSelectedProgramDomain().getShortDesc());
			this.setDescription(this.getSelectedProgramDomain()
					.getDescription());
			this.setStatus(this.getSelectedProgramDomain().getStatus());

		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}

	public void valueChangeEditProgramGroup(AjaxEvent event) {
		System.out.println("Calling valueChangeEditProgramGroup");

		if (this.getSelectedProgramGroup() != null) {
			this.setCode(this.getSelectedProgramGroup().getProgramGroupCode());
			this.setShortDesc(this.getSelectedProgramGroup().getShortDesc());
			this
					.setDescription(this.getSelectedProgramGroup()
							.getDescription());
			this.setStatus(this.getSelectedProgramGroup().getStatus());
		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}

	public void valueChangeEditProgramTrack(AjaxEvent event) {
		System.out.println("Calling valueChangeEditProgramTrack");

		if (this.getSelectedProgramTrack() != null) {
			this.setCode(this.getSelectedProgramTrack().getProgramTrackCode());
			this.setShortDesc(this.getSelectedProgramTrack().getShortDesc());
			this
					.setDescription(this.getSelectedProgramTrack()
							.getDescription());
			this.setStatus(this.getSelectedProgramTrack().getStatus());
		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}

	public void valueChangeEditUKCollege(AjaxEvent event) {
		System.out.println("Calling valueChangeEditUKCollege");

		if (this.getSelectedUKCollege() != null) {

			this.setCode(this.getSelectedUKCollege().getUkCollegeCode());
			this.setCollegeName(this.getSelectedUKCollege().getCollegeName());
			this.setCollegeAddress(this.getSelectedUKCollege()
					.getCollegeAddress());
			this.setPhone(this.getSelectedUKCollege().getCollegePhone());
			this.setCollegeDeanName(this.getSelectedUKCollege()
					.getCollegeDeanName());
			this
					.setSpeedSort(this.getSelectedUKCollege()
							.getCollegeSpeedSort());
		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}

	/*
	 * CohortType Controller Operations
	 */

	public void valueChangeEditUKDepartment(AjaxEvent event) {
		System.out.println("Calling valueChangeEditUKDepartment");

		if (this.getSelectedUKDepartment() != null) {

			this.setCode(this.getSelectedUKDepartment().getDepartmentCode());
			this.setDepartmentName(this.getSelectedUKDepartment()
					.getDepartmentName());
			this.setDepartmentAddress(this.getSelectedUKDepartment()
					.getDepartmentAddress());
			this.setDepartmentChairName(this.getSelectedUKDepartment()
					.getDepartmentChairName());
			this
					.setPhone(this.getSelectedUKDepartment()
							.getDepartmentContact());
			this.setSpeedSort(this.getSelectedUKDepartment().getSpeedSort());
			this.setShortDesc(this.getSelectedUKDepartment()
					.getShortDescription());
			this.setStatus(this.getSelectedUKDepartment().getStatus());

		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}

	public void valueChangeEditUserClassification(AjaxEvent event) {
		System.out.println("Calling valueChangeEditUserClassification");

		if (this.getSelectedUserClassification() != null) {

			this.setCode(this.getSelectedUserClassification()
					.getClassificationCode());
			this.setShortDesc(this.getSelectedUserClassification()
					.getShortDesc());
			this.setDescription(this.getSelectedUserClassification()
					.getDescription());
			this.setStatus(this.getSelectedUserClassification().getStatus());

		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}

	public void valueChangeEditUserType(AjaxEvent event) {
		System.out.println("Calling valueChangeEditUserType");

		if (this.getSelectedUserType() != null) {

			this.setCode(this.getSelectedUserType().getTypeCode());
			this.setShortDesc(this.getSelectedUserType().getShortDesc());

		} else {
			// Raise global error
			System.out.println("empty or many selection");
		}

	}

	public void valueChangeProgramDomainProgramList(ActionEvent event) {
		System.out.println("Calling valueChangeProgramDomainProgramList");
	}

	public void valueChangeUserTypeUserClassificationList(AjaxEvent event) {
		System.out.println("Calling valueChangeUserTypeUserClassificationList");
	}
	
	

}
