package edu.uky.cepis.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.uky.cepis.domain.StudentScholarship;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.util.global.CEPISGlobalComponentConfigurator;
import edu.uky.cepis.view.ScholarshipView;

/**
 * @author cawalk4
 *
 */
@Component
@Scope("session")
public class ScholarshipController extends AbstractController {
	
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(ScholarshipController.class);
	
	@Resource(name="scholarshipBean")
	private ScholarshipView scholarshipBean;
	
	private CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator;
	
	private User selectedUser;
	
	private List<StudentScholarship> studentScholarshipList;
	
	private HtmlExtendedDataTable scholarshipTable;
	
	private StudentScholarship selectedStudentScholarship;
	
	private boolean loadStudentScholarship;

	public void updateSelectedUser(){
		setLoadStudentScholarship(true);
		setSelectedUser(getConfigurationManager().getSelectedUser());
	}
	
	/* *************************************** UPDATE TABS *************************************** */
	
	public String getSetUpViewTab(){
		return "";
	}
	
	public String getSetUpAddTab(){
		
		return "";
	}
	
	public String getSetUpEditTab(){
		
		return "";
	}
	
	public String getSetUpDeleteTab(){
		
		return "";
	}
	
	public String getSetUpReport(){
		
		return "";
	}
	
	/* *************************************** TAKE TABLE SELECTION ****************************************** */
	
	public void takeScholarshipSelection() {		
		if(this.getScholarshipTable() != null){
			StudentScholarship studentScholarship = (StudentScholarship) this.getScholarshipTable().getRowData();
			if (studentScholarship != null) {
				setSelectedStudentScholarship(studentScholarship);			
			}
		}			
	}

	/* *************************************** GETTERS AND SETTERS ****************************************** */
	
	public ScholarshipView getScholarshipBean() {
		return scholarshipBean;
	}

	public void setScholarshipBean(ScholarshipView scholarshipBean) {
		this.scholarshipBean = scholarshipBean;
	}

	public CEPISGlobalComponentConfigurator getCepisGlobalComponentConfigurator() {
		return cepisGlobalComponentConfigurator;
	}

	public void setCepisGlobalComponentConfigurator(
			CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator) {
		this.cepisGlobalComponentConfigurator = cepisGlobalComponentConfigurator;
	}

	public User getSelectedUser() {
		if(selectedUser == null){
			setSelectedUser(getConfigurationManager().getSelectedUser());
			setLoadStudentScholarship(true);
		}
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public List<StudentScholarship> getStudentScholarshipList() {
		if(isLoadStudentScholarship()
		&& this.getConfigurationManager().getSelectedUser() != null
		&& this.getConfigurationManager().getSelectedUser().getUid() != null){
			setStudentScholarshipList(getScholarshipBean().getStudentScholarshipForUser(this.getConfigurationManager().getSelectedUser()));
			setLoadStudentScholarship(false);
		}
		return studentScholarshipList;
	}

	public void setStudentScholarshipList(List<StudentScholarship> studentScholarshipList) {
		this.studentScholarshipList = studentScholarshipList;
	}

	public HtmlExtendedDataTable getScholarshipTable() {
		return scholarshipTable;
	}

	public void setScholarshipTable(HtmlExtendedDataTable scholarshipTable) {
		this.scholarshipTable = scholarshipTable;
	}

	public StudentScholarship getSelectedStudentScholarship() {
		return selectedStudentScholarship;
	}

	public void setSelectedStudentScholarship(StudentScholarship selectedStudentScholarship) {
		this.selectedStudentScholarship = selectedStudentScholarship;
	}

	public boolean isLoadStudentScholarship() {
		return loadStudentScholarship;
	}

	public void setLoadStudentScholarship(boolean loadStudentScholarship) {
		this.loadStudentScholarship = loadStudentScholarship;
	}
	
}