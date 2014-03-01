/**
 * 
 */
package edu.uky.cepis.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.criterion.DetachedCriteria;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.CohortTerm;
import edu.uky.cepis.domain.CohortType;
import edu.uky.cepis.domain.Course;
import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.FacultyAdvisor;
import edu.uky.cepis.domain.Query;
import edu.uky.cepis.domain.Role;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserClassification;
import edu.uky.cepis.domain.UserCollegeProfile;
import edu.uky.cepis.domain.UserProgramProfile;
import edu.uky.cepis.domain.UserType;
import edu.uky.cepis.domain.WorkingSet;
import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.ProgramGroup;
import edu.uky.cepis.domain.component.UKCollege;
import edu.uky.cepis.domain.component.UKDepartment;
import edu.uky.cepis.domain.component.UKMajor;
import edu.uky.cepis.domain.component.UKStatus;
import edu.uky.cepis.domain.component.UKTerm;
import edu.uky.cepis.view.SearchEngineView;


/**
 * @author cawalk4
 *
 */
@Component
@Scope("session")
public class SearchEngineController extends AbstractController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(SearchEngineController.class);
	
	@Resource(name="searchEngineBean")
	private SearchEngineView searchEngineBean;
		
	/* **********************************REPORT COLUMN OPTIONS********************************** */
	private boolean showUkIdCol;
	
	private boolean showUkyEmailCol;
	
	private boolean showEthnicityCol;
	
	private boolean showFirstNameCol;
	
	private boolean showProgramStatusCol;
	
	private boolean showUkMajorCol;
	
	private boolean showLastNameCol;
	
	private boolean showGenderCol;
	
	private boolean reportSearch;
	
	private boolean showGpaCol;
		
	private boolean showQualityHoursCol;
	
	private boolean showQualityPointsCol;
	
	private boolean showProgramGroupCol;

	private boolean showProgramStartTermCol;
	
	private boolean showProgramCompleteTermCol;
	
	private boolean showCollegeCol;
	
	private boolean showCollegeStartTermCol;
	
	private boolean showCollegeStatusCol;
	
	private boolean showProgramCol;
	
	private boolean showProgramDomainCol;
	
	private boolean showDepartmentCol;
	
	private boolean showMiddleNameCol;
	
	private boolean showLinkBlueIdCol;
	
	private boolean showProfessionalAdvisorCol;
	
	private boolean showFacultyAdvisorCol;
	
	private boolean showAnticipatedCompleteTermCol;
	
	/* **********************************STATISTICS VARIABLES********************************** */	
	private double percentMale;
	
	private double percentFemale;
	
	private double averageGpa;
	
	/* **********************************USER OPTIONS********************************** */
	private String username;
	
	private String ukID;
	
	private String firstName;
	
	private String lastName;
	
	private String middleName;
	
	private String maidenName;
	
	private String ssn;
	
	private String gender;
	
	/* **********************************PROGRAM OPTIONS********************************** */
	private ProgramDomain selectedProgramDomain;
	
	private Program selectedProgram;
	
	private ProgramGroup selectedProgramGroup;
	
	private UKMajor selectedUKMajor;
	
	private UKStatus selectedProgramStatus;
	
	private UKTerm selectedAnticipatedCompleteTerm;
	
	private UKTerm selectedProgramStartTerm;
	
	private UKTerm selectedProgramCompleteTerm;
	
	private Advisor selectedProfessionalAdvisor;
	
	private FacultyAdvisor selectedFacultyAdvisor;
	
	/* **********************************COLLEGE OPTIONS********************************** */
	private UserType selectedUserType;
	
	private UserClassification selectedUserClassification;

	private UKCollege selectedUkCollege;
	
	private UKDepartment selectedUkDepartment;
	
	private UKTerm selectedCollegeStartTerm;
	
	private UKTerm selectedCollegeEndTerm;
	
	private UKStatus selectedCollegeStatus;
	
	private CohortType selectedCohortType;
	
	private CohortTerm selectedCohortTerm;
	
	/* **********************************CONDITIONAL RENDERING BOOLEANS********************************** */
	private boolean showSearchBox;
	
	private boolean showSearchButton;
		
	private boolean showSearchResults;
	
	private boolean showReportColumnOptions;
	
	private boolean showReportButton;
	
	private boolean showReportResults;
			
	private String queryName;

	private String queryDescription;

	private boolean showSaveQueryModalWindow;
	
	private UKTerm selectedUKEndTerm;
	
	/* **********************************SAVED SEARCH BOOLEANS********************************** */
	
	// User Options
	private boolean check_globalQuery;
	
	private boolean check_username;
	
	private boolean check_firstName;

	private boolean check_lastName;
	
	private boolean check_middleName;
	
	private boolean check_maidenName;
	
	private boolean check_ukID;
	
	private boolean check_ssn;
	
	private boolean check_gender;
	
	//Program Options	
	private boolean check_selectedProgram;
	
	private boolean check_selectedProgramDomain;
	
	private boolean check_selectedProgramGroup;
	
	private boolean check_selectedUKMajor;
	
	private boolean check_selectedProgramStatus;
	
	private boolean check_selectedAnticipatedCompleteTerm;

	private boolean check_selectedProgramStartTerm;
		
	private boolean check_selectedProgramCompleteTerm;
	
	private boolean check_selectedProfessionalAdvisor;
	
	private boolean check_selectedFacultyAdvisor;
	
	//College Options
	private boolean check_selectedUserType;
	
	private boolean check_selectedUserClassification;
	
	private boolean check_selectedCollege;
	
	private boolean check_selectedDepartment;
	
	private boolean check_selectedCollegeStartTerm;
	
	private boolean check_selectedCollegeEndTerm;
	
	private boolean check_selectedCollegeStatus;
	
	private boolean check_selectedCohortType;
	
	private boolean check_selectedCohortTerm;
	
	private UKTerm selectedUKTerm;
	
	private Role selectedRole;

	private String displayQuery;
	
	private DetachedCriteria query;

	private Query selectedQuery;
	
	private String globalQuery;

	private Integer selectedOrder;
	
	private List<String> selectedSearchOptions = new ArrayList<String>(0);
	
	private boolean selectedSearchWithin;
	
	private WorkingSet selectedWS;
	
	private List<User> selectedUsers = new ArrayList<User>(0);
	
	private User selectedUser;
	
	private Map<String, Boolean> selectedUserIds = new HashMap<String, Boolean>();

	private List<User> resultList = new ArrayList<User>(0);
		
	private boolean check_selectedRole;

	private boolean allowSearchOperation;

	private String filterLastNameValue;
	
	private String filterFirstNameValue;
	
	private String filterMiddleNameValue;
	
	private int pageValue;
	
	private String sortOrderLastNameValue;
	
	private String sortOrderFirstNameValue;
	
	private String sortOrderMiddleNameValue;
	
	private Boolean allUsers;

	private Integer rowCount = new Integer(10);
	
	private HtmlExtendedDataTable reportTable;

	/* ******************************************* MAGIC VARIABLES ****************************************** */
	private static String COL_OPT_1 = "UK ID";
	private static String COL_OPT_2 = "Link Blue";
	private static String COL_OPT_3 = "Last Name";
	private static String COL_OPT_4 = "Middle Name";
	private static String COL_OPT_5 = "First Name";
	private static String COL_OPT_6 = "UK Email";
	private static String COL_OPT_7 = "Gender";
	private static String COL_OPT_8 = "Ethnicity";
	private static String COL_OPT_9 = "UK Major";
	private static String COL_OPT_10 = "Program";	
	private static String COL_OPT_11 = "Program Start Term";	
	private static String COL_OPT_12 = "Program Complete Term";
	private static String COL_OPT_13 = "Program Group";
	private static String COL_OPT_14 = "Anticipated Complete Term";
	private static String COL_OPT_15 = "Program Status";
	private static String COL_OPT_16 = "Program Domain";
	private static String COL_OPT_17 = "College";
	private static String COL_OPT_18 = "College Start Term";
	private static String COL_OPT_19 = "College Status";
	private static String COL_OPT_20 = "Department";
	private static String COL_OPT_21 = "GPA";
	private static String COL_OPT_22 = "Quality Hours";
	private static String COL_OPT_23 = "Quality Points";
	private static String COL_OPT_24 = "Professional Advisor";
	private static String COL_OPT_25 = "Faculty Advisor";

	
	public SearchEngineController() {
		setShowSearchBox(true);
		setShowSearchButton(true);		
	}
	
	
	public void toggleReportSearch(){
		setShowSearchResults(false);
		setShowReportResults(false);
		setAllowSearchOperation(false);
		
		setShowSearchBox(!isReportSearch());
		setShowSearchButton(!isReportSearch());
		setShowReportButton(isReportSearch());
		setShowReportColumnOptions(isReportSearch());
		setAllowSearchOperation(!isReportSearch());
		clear();
	}
	
	 public void exportHtmlTableToExcel() throws IOException{ 
		 
		 Workbook workbook =  new HSSFWorkbook();
		 Sheet sheet = workbook.createSheet("CEPIS Report");
		
		 CellStyle headerCellStyle = workbook.createCellStyle();

		 headerCellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		 headerCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		 headerCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		 int colCount = 0;
		 int colIndex = 0;
		 int rowIndex = 1;
		 
		 // Get a count of the number of columns
		 if(isShowUkIdCol()){
			 colCount ++;}
		 if(isShowLinkBlueIdCol()){
			 colCount ++;}
		 if(isShowLastNameCol()){
			 colCount ++;}
		 if(isShowMiddleNameCol()){
			 colCount ++;}
		 if(isShowFirstNameCol()){
			 colCount ++;}		 
		 if(isShowUkyEmailCol()){
			 colCount ++;}
		 if(isShowGenderCol()){
			 colCount ++;}
		 if(isShowEthnicityCol()){
			 colCount ++;}		 
		 if(isShowUkMajorCol()){
			 colCount ++;}
		 if(isShowProgramCol()){
			 colCount ++;}
		 if(isShowProgramStartTermCol()){
			 colCount ++;}
		 if(isShowProgramCompleteTermCol()){
			 colCount ++;}	
		 if(isShowAnticipatedCompleteTermCol()){
			 colCount ++;}
		 if(isShowProgramGroupCol()){
			 colCount ++;}		 
		 if(isShowProgramStatusCol()){
			 colCount ++;}		
		 if(isShowProgramDomainCol()){
		 	 colCount ++;}
		 if(isShowCollegeCol()){
			 colCount ++;}
		 if(isShowCollegeStartTermCol()){
			 colCount ++;}
		 if(isShowCollegeStatusCol()){
			 colCount ++;}		 
		 if(isShowDepartmentCol()){
			 colCount ++;}
		 if(isShowGpaCol()){
			 colCount ++;}
		 if(isShowQualityHoursCol()){
			 colCount ++;}
		 if(isShowQualityPointsCol()){
			 colCount ++;}
		 if(isShowProfessionalAdvisorCol()){
			 colCount ++;}
		 if(isShowFacultyAdvisorCol()){
			 colCount ++;}
		 
		//Create the first row aka the header row for the excel spreadsheet
		 Row headerRow = sheet.createRow(0);
		 
		 if(isShowUkIdCol()){
			headerRow.createCell(colIndex).setCellValue(COL_OPT_1);
			headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowLinkBlueIdCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_2);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowLastNameCol()){
			headerRow.createCell(colIndex).setCellValue(COL_OPT_3);
			headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowMiddleNameCol()){
			headerRow.createCell(colIndex).setCellValue(COL_OPT_4);
			headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowFirstNameCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_5);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}			 		 
		 if(isShowUkyEmailCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_6);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowGenderCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_7);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowEthnicityCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_8);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowUkMajorCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_9);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowProgramCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_10);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowProgramStartTermCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_11);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowProgramCompleteTermCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_12);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowProgramGroupCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_13);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}
		 if(isShowAnticipatedCompleteTermCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_14);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowProgramStatusCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_15);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowProgramDomainCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_16);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 		 
		 if(isShowCollegeCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_17);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowCollegeStartTermCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_18);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowCollegeStatusCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_19);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowDepartmentCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_20);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowGpaCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_21);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowQualityHoursCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_22);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowQualityPointsCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_23);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}		 
		 if(isShowProfessionalAdvisorCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_24);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}
		 if(isShowFacultyAdvisorCol()){
			 headerRow.createCell(colIndex).setCellValue(COL_OPT_25);
			 headerRow.getCell(colIndex ++).setCellStyle(headerCellStyle);}
		 		 
		 //Loop through each user in the result list, and create a cell for each value
		 for (User user : getResultList()) {
			 
			 //Increase the row index with each iteration
			 Row row = sheet.createRow(rowIndex++);
			 
			 //Set the col index back to zero
			 colIndex = 0;
			 
			 if(isShowUkIdCol()){			
				 if(user.getUkID() != null){
					 row.createCell(colIndex ++).setCellValue(user.getUkID());
				 }else{
					 colIndex ++;}
			 }			 
			 if(isShowLinkBlueIdCol()){				
				 if(user.getUsername() != null){
				 row.createCell(colIndex ++).setCellValue(user.getUsername());
				 }else{
					 colIndex ++;}
			 }			 
			 if(isShowLastNameCol()){
				 if(user.getlName() != null){
					 row.createCell(colIndex ++).setCellValue(user.getlName());
				 }else{
					 colIndex ++;}
			 }			 
			 if(isShowMiddleNameCol()){
				 if(user.getmName() != null){
					 row.createCell(colIndex ++).setCellValue(user.getmName());
				 }else{
					 colIndex ++;}
			 }			
			 if(isShowFirstNameCol()){
				 if(user.getfName() != null){
					row.createCell(colIndex ++).setCellValue(user.getfName());
				 }else{
					 colIndex ++;}
			 }			 			 
			 if(isShowUkyEmailCol()){
				 if(user.getUkyEmailAddress() != null){
					 row.createCell(colIndex ++).setCellValue(user.getUkyEmailAddress());
				 }else{
					 colIndex ++;}
			 }			 
			 if(isShowGenderCol()){
				 if(user.getGender() != null){
					 row.createCell(colIndex ++).setCellValue(user.getGender());
				 }else{
					 colIndex ++;}
			 }			 
			 if(isShowEthnicityCol()){
				 if(user.getUserPersonalProfile() != null){
					 if(user.getUserPersonalProfile().getEthnic() != null){
						 row.createCell(colIndex ++).setCellValue(user.getUserPersonalProfile().getEthnic().getShortDesc());
					 }else{
						 colIndex ++;}
				 }else{
					 colIndex ++;}
			 }			 
			 if(isShowUkMajorCol()){
				 if(user.getUserProgramProfile().getUkMajor() != null){
					 row.createCell(colIndex ++).setCellValue(user.getUserProgramProfile().getUkMajor().getShortDesc());
				 }else{
					 colIndex ++;}
			 }	
			 if(isShowProgramCol()){
				 if(user.getUserProgramProfile().getProgram() != null){
					 row.createCell(colIndex ++).setCellValue(user.getUserProgramProfile().getProgram().getShortDesc());
				 }else{
					 colIndex ++;}
			 }	
			 if(isShowProgramStartTermCol()){
				 if(user.getUserProgramProfile().getUkStartTerm() != null){
					 row.createCell(colIndex ++).setCellValue(user.getUserProgramProfile().getUkStartTerm().getShortDesc());
				 }else{
					 colIndex ++;}
			 }			 
			 if(isShowProgramCompleteTermCol()){
				 if(user.getUserProgramProfile().getUkCompleteTerm() != null){
					 row.createCell(colIndex ++).setCellValue(user.getUserProgramProfile().getUkCompleteTerm().getShortDesc());
				 }else{
					 colIndex ++;}
			 }			 
			 if(isShowProgramGroupCol()){
				 if(user.getUserProgramProfile().getProgramGroup() != null){
					 row.createCell(colIndex ++).setCellValue(user.getUserProgramProfile().getProgramGroup().getShortDesc());
				 }else{
					 colIndex ++;}
			 }		 
			 if(isShowAnticipatedCompleteTermCol()){
				 if(user.getUserProgramProfile().getUkAnticipatedCompleteTerm() != null){
					 row.createCell(colIndex ++).setCellValue(user.getUserProgramProfile().getUkAnticipatedCompleteTerm().getShortDesc());
				 }else{
					 colIndex ++;}
			 }	
			 if(isShowProgramStatusCol()){
				 if(user.getUserProgramProfile().getUkStatus() != null){
					 row.createCell(colIndex ++).setCellValue(user.getUserProgramProfile().getUkStatus().getShortDesc());
				 }else{
					 colIndex ++;}
			 }
			 if(isShowProgramDomainCol()){
				 if(user.getUserProgramProfile().getProgramDomain() != null){
					 row.createCell(colIndex ++).setCellValue(user.getUserProgramProfile().getProgramDomain().getShortDesc());
				 }else{
					 colIndex ++;}
			 }
			 if(isShowCollegeCol()){
				 if(user.getUserCollegeProfile().getUkCollege() != null){
					 row.createCell(colIndex ++).setCellValue(user.getUserCollegeProfile().getUkCollege().getCollegeName());
				 }else{
					 colIndex ++;}
			 }
			 if(isShowCollegeStartTermCol()){
				 if(user.getUserCollegeProfile().getStartTerm() != null){
					 row.createCell(colIndex ++).setCellValue(user.getUserCollegeProfile().getStartTerm().getShortDesc());
				 }else{
					 colIndex ++;}
			 }
			 if(isShowCollegeStatusCol()){
				 if(user.getUserCollegeProfile().getStatus() != null){
					 row.createCell(colIndex ++).setCellValue(user.getUserCollegeProfile().getStatus().getShortDesc());
				 }else{
					 colIndex ++;}
			 }
			 if(isShowDepartmentCol()){
				 if(user.getUserCollegeProfile().getUkDepartment() != null){
					 row.createCell(colIndex ++).setCellValue(user.getUserCollegeProfile().getUkDepartment().getShortDescription());
				 }else{
					 colIndex ++;}
			 }
				
			 if(isShowGpaCol()){
				 row.createCell(colIndex ++).setCellValue(user.getCumulativeGpa());}
			 
			 if(isShowQualityHoursCol()){
				 row.createCell(colIndex ++).setCellValue(user.getTotalQualityHours());}
			 
			 if(isShowQualityPointsCol()){
				 row.createCell(colIndex ++).setCellValue(user.getTotalQualityPoints());}
			 
			 if(isShowProfessionalAdvisorCol()){
				 if(user.getUserProgramProfile().getAdvisor() != null){
					 row.createCell(colIndex ++).setCellValue(user.getUserProgramProfile().getAdvisor().getShortDesc());
				 }else{
					 colIndex ++;}
			 }
			 
			 if(isShowFacultyAdvisorCol()){
				 if(user.getUserProgramProfile().getFacultyAdvisor() != null){
					 row.createCell(colIndex ++).setCellValue(user.getUserProgramProfile().getFacultyAdvisor().getShortDesc());
				 }else{
					 colIndex ++;}
			 }
		 }
		 
		 //Autosize the width of each column
		 for(int i=0; i<=colCount; i++){					 
			 sheet.autoSizeColumn(i);
		 }
		 
		//Create the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
        String filename = "CEPIS_Report_" + dt.toString(fmt) + ".xls";
	 
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		externalContext.setResponseContentType("application/vnd.ms-excel");
		externalContext.setResponseHeader("Content-Disposition", "attachment;filename=" + filename);
		workbook.write(externalContext.getResponseOutputStream());
		// Prevent JSF from performing navigation.
		context.responseComplete(); 
	 }
	

	public String getDefaultSearchOptions() {
		this.setSelectedOrder(0);
		this.setRowCount(200);
		if (!this.getSelectedSearchOptions().contains("lName")) {
			this.getSelectedSearchOptions().add("lName");
		}
		if (!this.getSelectedSearchOptions().contains("fName")) {
			this.getSelectedSearchOptions().add("fName");
		}
		if (!this.getSelectedSearchOptions().contains("mName")) {
			this.getSelectedSearchOptions().add("mName");
		}

		return "";
	}

	public void initSearchEngineView(PhaseEvent event) {
		HttpServletRequest req = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		String query = req.getParameter("q");
		if (query != null && !query.equals("")) {
			this.setGlobalQuery(query);
			this.getDefaultSearchOptions();
			this.searchGlobal();
			this.setShowSearchResults(true);
		}
	}
	
	/********************************************REMOVED SAVED QUERIE OPTION********************************************/
	
	public void removeGlobalQueryOption(ActionEvent event) {
		this.setCheck_globalQuery(false);
		this.setGlobalQuery(null);
	}
	public void removeUsernameOption(ActionEvent event) {
		this.setCheck_username(false);
		this.setUsername(null);
	}
	public void removeFirstNameOption(ActionEvent event) {
		this.setCheck_firstName(false);
		this.setFirstName(null);
	}
	public void removeLastNameOption(ActionEvent event) {
		this.setCheck_lastName(false);
		this.setLastName(null);
	}
	public void removeMiddleNameOption(ActionEvent event) {
		this.setCheck_middleName(false);
		this.setMiddleName(null);
	}
	public void removeMaidenNameOption(ActionEvent event) {
		this.setCheck_maidenName(false);
		this.setMaidenName(null);
	}
	public void removeUkIDOption(ActionEvent event) {
		this.setCheck_ukID(false);
		this.setUkID(null);
	}
	public void removeSsnOption(ActionEvent event) {
		this.setCheck_ssn(false);
		this.setSsn(null);
	}
	public void removeGenderOption(ActionEvent event) {
		this.setCheck_gender(false);
		this.setGender(null);
	}
	public void removeProgramOption(ActionEvent event) {
		this.setCheck_selectedProgram(false);
		this.setSelectedProgram(null);
	}
	public void removeProgramDomainOption(ActionEvent event) {
		this.setCheck_selectedProgramDomain(false);
		this.setSelectedProgramDomain(null);
	}
	public void removeProgramGroupOption(ActionEvent event) {
		this.setCheck_selectedProgramGroup(false);
		this.setSelectedProgramGroup(null);
	}
	public void removeUKMajorOption(ActionEvent event) {
		this.setCheck_selectedUKMajor(false);
		this.setSelectedUKMajor(null);
	}
	public void removeProgramStatusOption(ActionEvent event) {
		this.setCheck_selectedProgramStatus(false);
		this.setSelectedProgramStatus(null);
	}
	public void removeAnticipatedCompleteTermOption(ActionEvent event) {
		this.setCheck_selectedAnticipatedCompleteTerm(false);
		this.setSelectedAnticipatedCompleteTerm(null);
	}
	public void removeProgramStartTermOption(ActionEvent event) {
		this.setCheck_selectedProgramStartTerm(false);
		this.setSelectedProgramStartTerm(null);
	}
	public void removeProgramCompleteTermOption(ActionEvent event) {
		this.setCheck_selectedProgramCompleteTerm(false);
		this.setSelectedProgramCompleteTerm(null);
	}
	public void removeProfessionalAdvisorOption(ActionEvent event) {
		this.setCheck_selectedProfessionalAdvisor(false);
		this.setSelectedProfessionalAdvisor(null);
	}
	public void removeFacultyAdvisorOption(ActionEvent event) {
		this.setCheck_selectedFacultyAdvisor(false);
		this.setSelectedFacultyAdvisor(null);
	}
	
	/************************************************REMOVE College SAVED QUERIES************************************************/
	
	public void removeUserTypeOption(ActionEvent event) {
		this.setCheck_selectedUserType(false);
		this.setSelectedUserType(null);
	}
	public void removeUserClassificationOption(ActionEvent event) {
		this.setCheck_selectedUserClassification(false);
		this.setSelectedUserClassification(null);
	}
	public void removeCollegeOption(ActionEvent event) {
		this.setCheck_selectedCollege(false);
		this.setSelectedUkCollege(null);
	}
	public void removeDepartmentOption(ActionEvent event) {
		this.setCheck_selectedDepartment(false);
		this.setSelectedUkDepartment(null);
	}
	public void removeCollegeStartTermOption(ActionEvent event) {
		this.setCheck_selectedCollegeStartTerm(false);
		this.setSelectedCollegeStartTerm(null);
	}
	public void removeCollegeEndTermOption(ActionEvent event) {
		this.setCheck_selectedCollegeEndTerm(false);
		this.setSelectedCollegeEndTerm(null);
	}
	public void removeCollegeStatusOption(ActionEvent event) {
		this.setCheck_selectedCollegeStatus(false);
		this.setSelectedCollegeStatus(null);
	}
	public void removeCohortTypeOption(ActionEvent event) {
		this.setCheck_selectedCohortType(false);
		this.setSelectedCohortType(null);
	}
	public void removeCohortTermOption(ActionEvent event) {
		this.setCheck_selectedCohortTerm(false);
		this.setSelectedCohortTerm(null);
	}
		
	private int countWords(String sentence) {
		int no_of_words = 0;
		if (sentence.equals("")) {
			return 0;
		}
		String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals("")) {
				continue;
			} else {
				no_of_words++;
			}
		}
		return no_of_words;
	}

	public List<Query> getSavedQueryList() {
		return this.getSearchEngineBean().getSavedQueryList(
				this.getUserManager().getUser());
	}

	public String searchNone() {
		 log.debug("Searching Global Query" + globalQuery);
		if (countWords(this.globalQuery) > 1) {
			log.debug(countWords(this.globalQuery));
			// this.setSearchEngineWarnStatus(false);
			// this.setSearchEngineStatusMessage("Note: One word searches only!!");
			return "reload";
		}
		// log.debug(countWords (this.globalQuery));
		// this.setResultList(this.getSearchEngineBean().searchGlobal(query,globalQuery));
		/*
		 * log.debug("End of Search function for" + globalQuery + ":" +
		 * this.getResultList().get(0).getfName());
		 */
		return null;
	}
	
	public void prepStatistics(){
		int count = 0;
		
		if(isShowGpaCol()){					
			for(User user : getResultList()){
				if(user.getCumulativeGpa() != 0){
					count ++;
					setAverageGpa(getAverageGpa() + user.getCumulativeGpa());
				}				
			}	
			setAverageGpa(getAverageGpa() / count);
		}		
	}

	public void search() {
		// TODO Separate the Result List into Three parts based on
		// GenerationalQualifier??
		log.debug("Searching Global Query: " + globalQuery);
				
		setShowSearchResults(true);	
		
		boolean createAlias = true;
		
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		
		int no_of_words = 0;
		
		this.setAllowSearchOperation(false);
		boolean order = true;
		
		String propertyName = "uid";
		
		boolean customSearch = false;
		
		boolean studentSearch = true;
		User currentUser = getConfigurationManager().getUser();
		
		currentUser.setRoles(getSearchEngineBean().getUserRoles(currentUser));
	
		//Check if user has the ability to search for Faculty, Staff, and Other
		for(Role role : currentUser.getRoles()){
			if(role.getRolename().equals("ROLE_ADMINISTRATOR") ||
		       role.getRolename().equals("ROLE_DEVELOPER")){
				studentSearch = false;
			}
		}
		
		if (!this.isSelectedSearchWithin()) {
			if (this.getSelectedQuery() != null 
			&& this.getSelectedQuery().getSid() > 0){
				this.setQuery(this.getSelectedQuery().getQuery());
				createAlias = false;
				this.setAllowSearchOperation(true);
			} else {
				if (this.getSelectedQuery() != null
				&& this.getSelectedQuery().getSid() < 0) {
					customSearch = true;
				}
				this.setQuery(this.getSearchEngineBean().createQuery());
			}

			if (this.getSelectedWS() != null
			&& this.getSelectedWS().getWid() > 0) {
				log.debug("Selected a different working set");
				this.getSearchEngineBean().addSearchInWS(query,
				this.getSelectedWS());
			} else {
				if (this.getSelectedWS() != null
				&& this.getSelectedWS().getWid() < 0 && customSearch) {
					message.setSeverity(FacesMessage.SEVERITY_WARN);
					message.setSummary("[" + new Date()
					+ "] Error: You should select atleast "
					+ "one of the custom search options.");
					context.addMessage("msg", message);
					return;
				}
			}
		} else {
			log.debug("Search Within Option is Selected");
			createAlias = false;
		}
		if (this.getQuery() == null) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date()
			+ "] Unknown Error: Cannot create the query.");
			context.addMessage("msg", message);
			return;
		}

		no_of_words = countWords(this.globalQuery);
		
		log.debug(no_of_words);
		if (no_of_words == 0) {
			this.setCheck_globalQuery(false);
			log.debug("Search for Program Component then");
		} else if (no_of_words != 0 && globalQuery != "") {
			if (no_of_words == 1 && globalQuery.length() < 3) {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
				+ "] Query term should have atleast 3 letters.");
				context.addMessage("msg", message);
				return;
			}
			this.setCheck_globalQuery(true);
			this.setAllowSearchOperation(true);
			query = this.getSearchEngineBean().addGlobalParam(query, globalQuery);
		}

		/************************************************User Constraints************************************************/

		if (this.getUsername() != "") {
			this.setCheck_username(true);
			this.setAllowSearchOperation(true);
			query = this.getSearchEngineBean().addUsernameConstraint(query,	username);
		} else {
			this.setCheck_username(false);
		}
		if (this.getFirstName() != "") {
			this.setCheck_firstName(true);
			this.setAllowSearchOperation(true);
			query = this.getSearchEngineBean().addFirstNameConstraint(query, firstName);
		} else {
			this.setCheck_firstName(false);
		}
		if (this.getLastName() != "") {
			this.setCheck_lastName(true);
			this.setAllowSearchOperation(true);
			query = this.getSearchEngineBean().addLastNameConstraint(query, lastName);
		} else {
			this.setCheck_lastName(false);
		}
		if (this.getMiddleName() != "") {
			this.setCheck_middleName(true);
			this.setAllowSearchOperation(true);
			query = this.getSearchEngineBean().addMiddleNameConstraint(query, middleName);
		} else {
			this.setCheck_middleName(false);
		}
		if (this.getMaidenName() != "") {
			this.setCheck_maidenName(true);
			this.setAllowSearchOperation(true);
			query = this.getSearchEngineBean().addMaidenNameConstraint(query, maidenName);
		} else {
			this.setCheck_maidenName(false);
		}
		if (this.getUkID() != "") {
			this.setCheck_ukID(true);
			this.setAllowSearchOperation(true);
			query = this.getSearchEngineBean().addUkIDConstraint(query, ukID);
		} else {
			this.setCheck_ukID(false);
		}
		if (this.getSsn() != "") {
			this.setCheck_ssn(true);
			this.setAllowSearchOperation(true);
			query = this.getSearchEngineBean().addSSNConstraint(query, ssn);
		} else {
			this.setCheck_ssn(false);
		}
		if (!this.getGender().equals("NA")) {
			this.setCheck_gender(true);
			this.setAllowSearchOperation(true);
			query = this.getSearchEngineBean().addGenderConstraint(query, gender);
		} else {
			this.setCheck_gender(false);
		}

		log.debug("Next Constraint: Program");
		
		/*******************************************************************************************************************/
		/************************************************Program Constraints************************************************/
		/*******************************************************************************************************************/
		// Check whether Other options is selected
		// Add Other Options Constraints

		// Check whether Advanced Search Option is selected
		// Add ProgramProfile Constraints
		// Add Program Profile Alias Variable to Query
		
		if (createAlias) {
			query = this.getSearchEngineBean().createProgramProfileAlias(query);
		}
		
		// Add Program Constraints
		if (this.getSelectedProgram() != null
		&& this.getSelectedProgram().getProgramCode() != null) {
			this.setCheck_selectedProgram(true);
			this.setAllowSearchOperation(true);
			log.debug("ProgramCODE Selected: "
				+ this.getSelectedProgram().getProgramCode() 
				+ ":"
				+ this.getSelectedProgram().getProgramCode().length());
			log.debug("Got in the Program Contraint");
			query = this.getSearchEngineBean().addProgramConstraint(query, this.getSelectedProgram());
			log.debug("Got out of the Program Constraint");
		} else {
			this.setCheck_selectedProgram(false);
		}

		// Add Program Domain Constraints
		if (this.getSelectedProgramDomain() != null
		&& this.getSelectedProgramDomain().getProgramDomainCode() != null) {
			this.setCheck_selectedProgramDomain(true);
			this.setAllowSearchOperation(true);
			log.debug("ProgramCODE Selected: "
				+ this.getSelectedProgramDomain().getProgramDomainCode()
				+ ":"
				+ this.getSelectedProgramDomain().getProgramDomainCode().length());
			log.debug("Got in the Program Contraint");
			query = this.getSearchEngineBean().addProgramDomainConstraint(query, this.getSelectedProgramDomain());
			log.debug("Got out of the Program Constraint");
		} else {
			this.setCheck_selectedProgramDomain(false);
		}

		// Add Program Group Constraints
		if (this.getSelectedProgramGroup() != null
		&& this.getSelectedProgramGroup().getProgramGroupCode() != null) {
			this.setCheck_selectedProgramGroup(true);
			this.setAllowSearchOperation(true);
			log.debug("ProgramCODE Selected: "
					+ this.getSelectedProgramGroup().getProgramGroupCode()
					+ ":"
					+ this.getSelectedProgramGroup().getProgramGroupCode().length());
			log.debug("Got in the Program Contraint");
			query = this.getSearchEngineBean().addProgramGroupConstraint(query, this.getSelectedProgramGroup());
			log.debug("Got out of the Program Constraint");
		} else {
			this.setCheck_selectedProgramGroup(false);
		}

		// Add Professional Advisor Constraints
		if (this.getSelectedProfessionalAdvisor() != null
		&& this.getSelectedProfessionalAdvisor().getUserid() != null) {
			this.setCheck_selectedProfessionalAdvisor(true);
			this.setAllowSearchOperation(true);
			log.debug("Professional Advisor Selected: "
					+ this.getSelectedProfessionalAdvisor().getUserid());
			log.debug("Got in the Professional Advisor Contraint");
			query = this.getSearchEngineBean().addAdvisorConstraint(query,
					this.getSelectedProfessionalAdvisor());
			log.debug("Got out of the Professional Advisor Constraint");
		} else {
			this.setCheck_selectedProfessionalAdvisor(false);
		}
		
		// Add Faculty Advisor Constraints
		if (this.getSelectedFacultyAdvisor() != null
		&& this.getSelectedFacultyAdvisor().getUserid() != null) {
			this.setCheck_selectedFacultyAdvisor(true);
			this.setAllowSearchOperation(true);
			log.debug("Faculty Advisor Selected: "
					+ this.getSelectedFacultyAdvisor().getUserid());
			log.debug("Got in the Faculty Advisor Contraint");
			query = this.getSearchEngineBean().addFacultyAdvisorConstraint(query,
					this.getSelectedFacultyAdvisor());
			log.debug("Got out of the Faculty Advisor Constraint");
		} else {
			this.setCheck_selectedFacultyAdvisor(false);
		}

		// Add UKMajor Constraints
		if (this.getSelectedUKMajor() != null
		&& this.getSelectedUKMajor().getUkMajorCode() != null) {
			this.setCheck_selectedUKMajor(true);
			this.setAllowSearchOperation(true);
			log.debug("ProgramCODE Selected: "
					+ this.getSelectedUKMajor().getUkMajorCode() 
					+ ":"
					+ this.getSelectedUKMajor().getUkMajorCode().length());
			log.debug("Got in the Program Contraint");
			query = this.getSearchEngineBean().addUKMajorConstraint(query,
					this.getSelectedUKMajor());
			log.debug("Got out of the Program Constraint");
		} else {
			this.setCheck_selectedUKMajor(false);
		}

		// Add ProgramStatus Constraints
		if (this.getSelectedProgramStatus() != null
		&& this.getSelectedProgramStatus().getStatusCode() != null) {
			this.setCheck_selectedProgramStatus(true);
			this.setAllowSearchOperation(true);
			log.debug("ProgramStatus Selected: "
					+ this.getSelectedProgramStatus().getStatusCode() 
					+ ":"
					+ this.getSelectedProgramStatus().getStatusCode().length());
			log.debug("Got in the ProgramStatus Contraint");
			query = this.getSearchEngineBean().addProgramStatusConstraint(query,
					this.getSelectedProgramStatus());
			log.debug("Got out of the ProgramStatus Constraint");
		} else {
			this.setCheck_selectedProgramStatus(false);
		}
		
		// Add Anticipated Complete Term Constraints
		if (this.getSelectedAnticipatedCompleteTerm() != null
		&& this.getSelectedAnticipatedCompleteTerm().getUkTermCode() != null) {
			this.setCheck_selectedAnticipatedCompleteTerm(true);
			this.setAllowSearchOperation(true);
			log.debug("AnticipatedCompleteTerm Selected: "
					+ this.getSelectedAnticipatedCompleteTerm().getUkTermCode() 
					+ ":"
					+ this.getSelectedAnticipatedCompleteTerm().getUkTermCode().length());
			log.debug("Got in the AnticipatedCompleteTerm Contraint");
			query = this.getSearchEngineBean().addAnticipatedCompleteTermConstraint(query,
					this.getSelectedAnticipatedCompleteTerm());
			log.debug("Got out of the AnticipatedCompleteTerm Constraint");
		} else {
			this.setCheck_selectedAnticipatedCompleteTerm(false);
		}

		// Add ProgramStartTerm Constraints
		if (this.getSelectedProgramStartTerm() != null
		&& this.getSelectedProgramStartTerm().getUkTermCode() != null) {
			this.setCheck_selectedProgramStartTerm(true);
			this.setAllowSearchOperation(true);
			log.debug("ProgramStartTerm Selected: "
					+ this.getSelectedProgramStartTerm().getUkTermCode() 
					+ ":"
					+ this.getSelectedProgramStartTerm().getUkTermCode().length());
			log.debug("Got in the ProgramStartTerm Contraint");
			query = this.getSearchEngineBean().addProgramStartTermConstraint(query,
					this.getSelectedProgramStartTerm());
			log.debug("Got out of the ProgramStartTerm Constraint");
		} else {
			this.setCheck_selectedProgramStartTerm(false);
		}

		// Add Program Complete Term Constraints		
		if (this.getSelectedProgramCompleteTerm() != null
		&& this.getSelectedProgramCompleteTerm().getUkTermCode() != null) {
			this.setCheck_selectedProgramCompleteTerm(true);
			this.setAllowSearchOperation(true);
			log.debug("ProgramCODE Selected: "
					+ this.getSelectedProgramCompleteTerm().getUkTermCode()
					+ ":"
					+ this.getSelectedProgramCompleteTerm().getUkTermCode().length());
			log.debug("Got in the Program Contraint");
			query = this.getSearchEngineBean().addProgramCompleteTermConstraint(
					query, this.getSelectedProgramCompleteTerm());
			log.debug("Got out of the Program Constraint");
		} else {
			this.setCheck_selectedProgramCompleteTerm(false);
		}		
		/*******************************************************************************************************************/
		/************************************************COLLEGE CONSTRAINTS************************************************/
		/*******************************************************************************************************************/
		if (createAlias) {
			query = this.getSearchEngineBean().createCollegeAlias(query);
		}
		
		// Add User Type Constraints
		if (this.getSelectedUserType() != null
		&& this.getSelectedUserType().getTypeCode() != null) {
			this.setCheck_selectedUserType(true);
			this.setAllowSearchOperation(true);
			log.debug("User Type Selected: "
					+ this.getSelectedUserType().getTypeCode()
					+ ":"
					+ this.getSelectedUserType().getTypeCode().length());
			log.debug("Got in the User Type Contraint");
			query = this.getSearchEngineBean().addUserTypeConstraint(
					query, this.getSelectedUserType());
			log.debug("Got out of the User Type Constraint");
		} else {
			this.setCheck_selectedUserType(false);
		}
		
		// Add User Classification Constraints
		if (this.getSelectedUserClassification() != null
		&& this.getSelectedUserClassification().getClassificationCode() != null) {
			this.setCheck_selectedUserClassification(true);
			this.setAllowSearchOperation(true);
			log.debug("User Classification Selected: "
					+ this.getSelectedUserClassification().getClassificationCode()
					+ ":"
					+ this.getSelectedUserClassification().getClassificationCode().length());
			log.debug("Got in the User Classification Contraint");
			query = this.getSearchEngineBean().addUserClassificationConstraint(
					query, this.getSelectedUserClassification());
			log.debug("Got out of the User Classification Constraint");
		} else {
			this.setCheck_selectedUserClassification(false);
		}
		
		// Add College Constraints
		if (this.getSelectedUkCollege() != null
		&& this.getSelectedUkCollege().getUkCollegeCode() != null) {
			this.setCheck_selectedCollege(true);
			this.setAllowSearchOperation(true);
			log.debug("UK College Selected: "
					+ this.getSelectedUkCollege().getUkCollegeCode()
					+ ":"
					+ this.getSelectedUkCollege().getUkCollegeCode().length());
			log.debug("Got in the UK College Contraint");
			query = this.getSearchEngineBean().addUKCollegeConstraint(
					query, this.getSelectedUkCollege());
			log.debug("Got out of the UK College Constraint");
		} else {
			this.setCheck_selectedCollege(false);
		}
		
		// Add Department Constraints
		if (this.getSelectedUkDepartment() != null
		&& this.getSelectedUkDepartment().getDepartmentCode() != null) {
			this.setCheck_selectedDepartment(true);
			this.setAllowSearchOperation(true);
			log.debug("UK Department Selected: "
					+ this.getSelectedUkDepartment().getDepartmentCode()
					+ ":"
					+ this.getSelectedUkDepartment().getDepartmentCode().length());
			log.debug("Got in the UK Department Contraint");
			query = this.getSearchEngineBean().addUKDepartmentConstraint(
					query, this.getSelectedUkDepartment());
			log.debug("Got out of the UK Department Constraint");
		} else {
			this.setCheck_selectedDepartment(false);
		}
		
		// Add College Start Term Constraints
		if (this.getSelectedCollegeStartTerm() != null
		&& this.getSelectedCollegeStartTerm().getUkTermCode() != null) {
			this.setCheck_selectedCollegeStartTerm(true);
			this.setAllowSearchOperation(true);
			log.debug("College Start Term Selected: "
					+ this.getSelectedCollegeStartTerm().getUkTermCode()
					+ ":"
					+ this.getSelectedCollegeStartTerm().getUkTermCode().length());
			log.debug("Got in the College Start Term Contraint");
			query = this.getSearchEngineBean().addCollegeStartTermConstraint(
					query, this.getSelectedCollegeStartTerm());
			log.debug("Got out of the College Start Term Constraint");
		} else {
			this.setCheck_selectedCollegeStartTerm(false);
		}
		
		// Add College Change Term Constraints
		if (this.getSelectedCollegeEndTerm() != null
		&& this.getSelectedCollegeEndTerm().getUkTermCode() != null) {
			this.setCheck_selectedCollegeEndTerm(true);
			this.setAllowSearchOperation(true);
			log.debug("College Change Term Selected: "
					+ this.getSelectedCollegeEndTerm().getUkTermCode()
					+ ":"
					+ this.getSelectedCollegeEndTerm().getUkTermCode().length());
			log.debug("Got in the College Change Term Contraint");
			query = this.getSearchEngineBean().addCollegeEndTermConstraint(
					query, this.getSelectedCollegeEndTerm());
			log.debug("Got out of the College Change Term Constraint");
		} else {
			this.setCheck_selectedCollegeEndTerm(false);
		}
				
		// Add College College Status Constraints
		if (this.getSelectedCollegeStatus() != null
		&& this.getSelectedCollegeStatus().getStatusCode() != null) {
			this.setCheck_selectedCollegeStatus(true);
			this.setAllowSearchOperation(true);
			log.debug("College Status Selected: "
					+ this.getSelectedCollegeStatus().getStatusCode()
					+ ":"
					+ this.getSelectedCollegeStatus().getStatusCode().length());
			log.debug("Got in the College Status Contraint");
			query = this.getSearchEngineBean().addCollegeStatusConstraint(
					query, this.getSelectedCollegeStatus());
			log.debug("Got out of the College Status Constraint");
		} else {
			this.setCheck_selectedCollegeStatus(false);
		}
		
		// Add Cohort Type Constraints
		if (this.getSelectedCohortType() != null
		&& this.getSelectedCohortType().getTypeCode() != null) {
			this.setCheck_selectedCohortType(true);
			this.setAllowSearchOperation(true);
			log.debug("Cohort Type Selected: "
					+ this.getSelectedCohortType().getTypeCode()
					+ ":"
					+ this.getSelectedCohortType().getTypeCode().length());
			log.debug("Got in the Cohort Type Contraint");
			query = this.getSearchEngineBean().addCohortTypeConstraint(
					query, this.getSelectedCohortType());
			log.debug("Got out of the Cohort Type Constraint");
		} else {
			this.setCheck_selectedCohortType(false);
		}
		
		// Add Cohort Term Constraints
		if (this.getSelectedCohortTerm() != null
		&& this.getSelectedCohortTerm().getTermCode() != 0) {
			this.setCheck_selectedCollegeStartTerm(true);
			this.setAllowSearchOperation(true);
			log.debug("Cohort Term Selected: "
					+ String.valueOf(this.getSelectedCohortTerm().getTermCode()));
			log.debug("Got in the Cohort Term Contraint");
			query = this.getSearchEngineBean().addCohortTermConstraint(
					query, this.getSelectedCohortTerm());
			log.debug("Got out of the Cohort Term Constraint");

		} else {
			this.setCheck_selectedCollegeStartTerm(false);
		} 
		
		/*******************************************************************************************************************/
		/*******************************************************************************************************************/
		/*******************************************************************************************************************/				
		log.debug("Done with Constraints");
		this.sortOrderLastNameValue = "UNSORTED";
		this.sortOrderFirstNameValue = "UNSORTED";
		this.sortOrderMiddleNameValue = "UNSORTED";
		// Customize your search here
		if (this.getSelectedOrder() != null) {
			if (this.getSelectedOrder() == 0) {
				order = true;
			} else {
				order = false;
			}
		}
		Iterator<String> iter = this.getSelectedSearchOptions().iterator();
		while (iter.hasNext()) {
			propertyName = iter.next();
			if (propertyName.equals("lName")) {
				if (order) {
					this.sortOrderLastNameValue = "ASCENDING";
				} else {
					this.sortOrderLastNameValue = "DESCENDING";
				}
			} else if (propertyName.equals("fName")) {
				if (order) {
					this.sortOrderFirstNameValue = "ASCENDING";
				} else {
					this.sortOrderFirstNameValue = "DESCENDING";
				}
			} else if (propertyName.equals("mName")) {
				if (order) {
					this.sortOrderMiddleNameValue = "ASCENDING";
				} else {
					this.sortOrderMiddleNameValue = "DESCENDING";
				}
			}
			this.getSearchEngineBean().addOrder(query, propertyName, order);
		}		
		
		// Final Check
		if(this.getQuery() == null) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date()
					+ "] Unknown Error: Cannot create the query.");
			context.addMessage("msg", message);
			return;
		}
		if(this.isAllowSearchOperation()) {
			this.setResultList(this.getSearchEngineBean().search(query));
			this.filterLastNameValue = "";
			this.filterFirstNameValue = "";
			this.filterMiddleNameValue = "";
			if (this.getResultList().size() > 0) {
				this.pageValue = 1;
			} else {
				this.pageValue = 0;
			}
			this.selectedUserIds.clear();
		}else{
			this.sortOrderLastNameValue = "UNSORTED";
			this.sortOrderFirstNameValue = "UNSORTED";
			this.sortOrderMiddleNameValue = "UNSORTED";
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] No options entered.");
			context.addMessage("msg", message);
		}
					
		if(isReportSearch()){
			
			//Handle the rendering of elements based on whether it is a Report Search or CEPIS Search
			setAllowSearchOperation(!isReportSearch());
			setShowSearchResults(!isReportSearch());
			setShowReportResults(isReportSearch());
			
			//Set the UKY Email Address for users in report if option is selected
			if(isShowUkyEmailCol()){
				for(User setEmailUser : getResultList()){
					if(setEmailUser.getEmailAddresses() != null){
						for(EmailAddress emailAddress : setEmailUser.getEmailAddresses()){
							if(emailAddress.getType() != null){
								if(emailAddress.getType().getCode().equals("UKY")){
									setEmailUser.setUkyEmailAddress(emailAddress.getAddress());
								}
							}
						}
					}else{
						setEmailUser.setUkyEmailAddress(" ");
					}
				}
			}
			
			if(isShowUkMajorCol() 
		    || isShowProgramCol()
			|| isShowProgramStatusCol()
			|| isShowProgramCompleteTermCol()
			|| isShowProgramStartTermCol()
			|| isShowAnticipatedCompleteTermCol()
			|| isShowProgramGroupCol()
			|| isShowProfessionalAdvisorCol()
			|| isShowFacultyAdvisorCol()){
				
				List<User> newUserList = new ArrayList<User>();
				
				for(User programUser : getResultList()){					
					if(!programUser.getUserProgramProfiles().isEmpty()){						
						for(UserProgramProfile userProgramProfile : programUser.getUserProgramProfiles()){							
							User tempUser = programUser;
							tempUser.setUserProgramProfile(userProgramProfile);							
							newUserList.add(tempUser);							
						}						
					}
				}
				setResultList(newUserList);
			}			
						
			if(isShowCollegeCol()
			|| isShowCollegeStartTermCol()
			|| isShowCollegeStatusCol()
			|| isShowDepartmentCol()){
						
				List<User> newUserList = new ArrayList<User>();
						
				for(User collegeUser : getResultList()){							
					if(!collegeUser.getUserCollegeProfiles().isEmpty()){								
						for(UserCollegeProfile userCollegeProfile : collegeUser.getUserCollegeProfiles()){									
							User tempUser = collegeUser;									
							tempUser.setUserCollegeProfile(userCollegeProfile);								
							newUserList.add(tempUser);									
						}							
					}
				}
				setResultList(newUserList);
			}
			
			if(isShowGpaCol()){
				
				for(User gpaUser : getResultList()){
					
					List<Course> courses = new ArrayList<Course>();
					
					float totalQualityPoints = 0;
					float totalQualityHours = 0;
					
					DecimalFormat df = new DecimalFormat();
					df.setMinimumFractionDigits(3);
					df.setMaximumFractionDigits(3);
					
					courses = getSearchEngineBean().getAcademicProfile(gpaUser);
					
					if (!courses.isEmpty()){
						for(Course course: courses){
							if(course.getGpa().contains("T")
							|| course.getGpa().contains("R")
							|| course.getrTitle() != null){
								totalQualityHours = totalQualityHours + 0;
								totalQualityPoints = totalQualityPoints + 0;
							} else if(course.getGpa().contains("A") 
							|| course.getGpa().contains("B")
							|| course.getGpa().contains("C")
							|| course.getGpa().contains("D")
							|| course.getGpa().contains("E")){
									totalQualityPoints = totalQualityPoints + course.getGpaPoints();
									totalQualityHours = totalQualityHours + course.getGpaHours();
							}
						}						
						gpaUser.setTotalQualityHours((int)totalQualityHours);
						gpaUser.setTotalQualityPoints((int)totalQualityPoints);
						if(gpaUser.getTotalQualityHours() != 0){
							String decimalFormatted = df.format(totalQualityPoints / totalQualityHours);
							gpaUser.setCumulativeGpa(new Float(decimalFormatted));	
						}else{
							gpaUser.setCumulativeGpa(0);
						}						
					}
				}	
			}
		}
				
		/********************************************************************************************************* */
		/********************************** SET STUDENT ONLY SEARCH RESTRICTIONS ********************************* */
		/********************************************************************************************************* */		
		
		//Set up college profile
		if(studentSearch && !isReportSearch()){			
			List<User> newUserList = new ArrayList<User>();				
			for(User collegeUser : getResultList()){					
				if(!collegeUser.getUserCollegeProfiles().isEmpty()){						
					for(UserCollegeProfile userCollegeProfile : collegeUser.getUserCollegeProfiles()){							
						User tempUser = collegeUser;							
						tempUser.setUserCollegeProfile(userCollegeProfile);						
						newUserList.add(tempUser);	
						break;
					}							
				}
			}		
			setResultList(newUserList);
		}
		
		if(studentSearch && isReportSearch()){			
			List<User> newUserList = new ArrayList<User>();				
			for(User collegeUser : getResultList()){					
				if(!collegeUser.getUserCollegeProfiles().isEmpty()){						
					for(UserCollegeProfile userCollegeProfile : collegeUser.getUserCollegeProfiles()){							
						User tempUser = collegeUser;							
						tempUser.setUserCollegeProfile(userCollegeProfile);						
						newUserList.add(tempUser);	
					}							
				}
			}		
			setResultList(newUserList);
		}
		
		//If the user Logged In does not have the ROLE of ADMINISTRATOR or DEVELOPER ONLY add STUDENTS to the result list. 		
		
		if(studentSearch){
			List<User> studentResultList = new ArrayList<User>();
			for(User studentUser : getResultList()){
				if(studentUser.getUserCollegeProfile().getUserType().getTypeCode().equals("STU")){
					studentResultList.add(studentUser);
				}
			}
			setResultList(studentResultList);
		}
		
		/********************************************************************************************************* */
		/********************************************************************************************************* */
		/********************************************************************************************************* */
		
		this.setAllUsers(new Boolean(false));
		// this.selectAll(event);
		return;
	}
	
	public String searchGlobal() {
		log.debug("Searching Global Query: " + globalQuery);
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		int no_of_words = 0;
		boolean order = false;
		String propertyName = null;
		this.setAllowSearchOperation(false);
		this.setQuery(this.getSearchEngineBean().createQuery());
		this.setAllUsers(new Boolean(false));
		if (this.getQuery() == null) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date()
					+ "] Unknown Error: Cannot create the query.");
			context.addMessage("msg", message);
			return null;
		}

		no_of_words = countWords(this.globalQuery);
		log.debug(no_of_words);
		if (no_of_words == 0) {
			return null;
		} else if (no_of_words != 0 && globalQuery != "") {
			if (no_of_words == 1 && globalQuery.length() < 3) {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] Query term should have atleast 3 letters.");
				context.addMessage("msg", message);
				return null;
			}
			this.setCheck_globalQuery(true);
			this.setAllowSearchOperation(true);
			query = this.getSearchEngineBean().addGlobalParam(query,
					globalQuery);
		}
		
		// Customize your search here
		if (this.getSelectedOrder() != null) {
			if (this.getSelectedOrder() == 0) {
				order = true;
			} else {
				order = false;
			}
		}
		Iterator<String> iter = this.getSelectedSearchOptions().iterator();
		while (iter.hasNext()) {
			propertyName = iter.next();
			if (propertyName.equals("lName")) {
				if (order) {
					this.sortOrderLastNameValue = "ASCENDING";
				} else {
					this.sortOrderLastNameValue = "DESCENDING";
				}
			} else if (propertyName.equals("fName")) {
				if (order) {
					this.sortOrderFirstNameValue = "ASCENDING";
				} else {
					this.sortOrderFirstNameValue = "DESCENDING";
				}
			} else if (propertyName.equals("mName")) {
				if (order) {
					this.sortOrderMiddleNameValue = "ASCENDING";
				} else {
					this.sortOrderMiddleNameValue = "DESCENDING";
				}
			}
			this.getSearchEngineBean().addOrder(query, propertyName, order);
		}
		this.setResultList(this.getSearchEngineBean().search(query));
		return null;
	}

	public String clear() {
		this.selectedProfessionalAdvisor = null;
		this.setSelectedFacultyAdvisor(null);
		this.selectedProgram = null;
		this.selectedProgramDomain = null;
		this.selectedProgramGroup = null;
		this.selectedRole = null;
		this.selectedUKEndTerm = null;
		this.selectedProgramCompleteTerm = null;
		this.selectedUKMajor = null;
		this.selectedProgramStartTerm = null;
		this.selectedProgramStatus = null;
		this.selectedAnticipatedCompleteTerm = null;
		
		this.setGlobalQuery("");
		this.setUsername("");
		this.setFirstName("");
		this.setLastName("");
		this.setMiddleName("");
		this.setMaidenName("");
		this.setUkID("");
		this.setSsn("");
		this.setGender("NA");
		this.getSelectedSearchOptions().clear();
		this.getDefaultSearchOptions();
		this.setSelectedOrder(0);
		this.setSelectedSearchWithin(false);
		this.setSelectedWS(null);
		this.setSelectedQuery(null);
		this.setQuery(null);
		this.clearResults(null);
		
		this.setSelectedUserType(null);
		this.setSelectedUserClassification(null);
		this.setSelectedUkCollege(null);
		this.setSelectedUkCollege(null);
		this.setSelectedCollegeStartTerm(null);
		this.setSelectedCollegeEndTerm(null);
		this.setSelectedCollegeStatus(null);
		this.setSelectedCohortType(null);
		this.setSelectedCohortTerm(null);

		this.setCheck_globalQuery(false);
		this.setCheck_username(false);
		this.setCheck_firstName(false);
		this.setCheck_lastName(false);
		this.setCheck_middleName(false);
		this.setCheck_maidenName(false);
		this.setCheck_ukID(false);
		this.setCheck_ssn(false);
		this.setCheck_selectedProgram(false);
		this.setCheck_selectedProgramDomain(false);
		this.setCheck_selectedProgramGroup(false);
		this.setCheck_selectedUKMajor(false);
		this.setCheck_selectedProgramStatus(false);
		this.setCheck_selectedProgramStartTerm(false);
		this.setCheck_selectedProgramCompleteTerm(false);
		this.setCheck_selectedAnticipatedCompleteTerm(false);
		this.setCheck_selectedUserType(false);
		this.setCheck_selectedUserClassification(false);
		this.setCheck_selectedCollege(false);
		this.setCheck_selectedDepartment(false);
		this.setCheck_selectedCollegeStartTerm(false);
		this.setCheck_selectedCollegeEndTerm(false);
		this.setCheck_selectedCollegeStatus(false);
		this.setCheck_selectedCohortType(false);
		this.setCheck_selectedCohortTerm(false);
		
		this.setAllowSearchOperation(false);
		

		return null;
	}
	
	public void clearResults(ActionEvent event) {
		log.debug("Calling clear Search Result function");
		this.resultList = new ArrayList<User>(0);
		this.setAllUsers(new Boolean(false));
		this.selectedUserIds.clear();
		/*
		 * this.filterLastNameValue = ""; this.filterFirstNameValue = "";
		 * this.filterMiddleNameValue = ""; this.sortOrderLastNameValue =
		 * "UNSORTED"; this.sortOrderFirstNameValue = "UNSORTED";
		 * this.sortOrderMiddleNameValue = "UNSORTED";
		 */

	}

	public String getResultCount() {
		return this.getResultList().size() + "";
	}

	public void selectAll(ActionEvent event) {
		log.debug("Select All function called");
		if (this.resultList.size() > 0) {
			Iterator<User> iter = this.resultList.iterator();
			User user = null;
			while (iter.hasNext()) {
				user = iter.next();
				this.selectedUserIds.put(((String) user.getUid()), allUsers);
			}
		}
	}

	public void userSelected(ActionEvent event) {
		log.debug("UserSelected function called");
		String uid = (String) event.getComponent().getAttributes().get("uid");
		log.debug(uid);
		if (uid == null)
			return;
		if (this.selectedUserIds.containsKey(uid)) {
			log.debug("Inside Condition");
			if (!this.selectedUserIds.get(uid).booleanValue()) {
				this.setAllUsers(new Boolean(false));
			}
		}
	}

	public void addUsersToActiveWorkingSet(ActionEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();

		log.debug("Calling Add selected users function");
		if (!this
				.getUserManager()
				.getUser()
				.getUid()
				.equals(this.getConfigurationManager().getSelectedWorkingSet()
						.getCreatedBy())
				&& this.getConfigurationManager().isActiveWSPublic()) {
			if (!this.getConfigurationManager().isAllowPublicWSAdd()) {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] You do not have sufficient permissions to "
						+ "add users to this public working set.");
				context.addMessage("msg", message);
				return;
			}
		}

		if (allUsers.booleanValue()) {
			this.getSelectedUsers().clear();
			this.getSelectedUsers().addAll(this.resultList);
		} else {

			Object[] values = null;
			Object[] keys = null;
			values = this.selectedUserIds.values().toArray();
			keys = this.selectedUserIds.keySet().toArray();

			int selectSize = values.length;

			for (int i = 0; i < selectSize; i++) {
				// Retrive the selected List from selectedUserIds variable

				System.out.print(values[i] + ":" + keys[i]);
				if (((Boolean) values[i]).booleanValue()) {
					log.debug(":selected");
					this.getSelectedUsers().add(
							this.getSearchEngineBean().findUserByUID(
									(String) keys[i]));

				}
			}
		}
		log.debug(this.getSelectedUsers().size() + " Users selected");
		if (this.getSelectedUsers().size() > 0) {
			log.debug("Current WS: "
					+ this.getConfigurationManager().getSelectedWorkingSet()
							.getName());
			if (this.getSearchEngineBean().addUsersToWorkingSet(
					this.getConfigurationManager().getSelectedWorkingSet(),
					this.getSelectedUsers())) {
				log.debug("Users added successfully");
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary("[" + new Date()
						+ "] Selected user(s) added successfully.");
				context.addMessage("msg", message);
				this.getSelectedUsers().clear();
				this.getSelectedUserIds().clear();

			} else {
				log.debug("unknown error addusertows");
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] Unknown Error: Cannot add selected user(s).");
				context.addMessage("msg", message);
			}
		} else {
			log.debug("No user selected");
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] No user selected.");
			context.addMessage("msg", message);
		}
	}

	public String showProfile() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		log.debug("Calling show EMS profile function");
		if (this.getSelectedUser() == null) {
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("[" + new Date()
					+ "] Error: Current User is empty. Please try again later.");
			context.addMessage("msg", message);
			return null;
		} else {
			if (!this.getSearchEngineBean().addUserToWorkingSet(
					this.getConfigurationManager().getSelectedWorkingSet(),
					this.getSelectedUser())) {
				log.debug("unknown error addusertows");
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] Unknown Error: Cannot add the user ("
						+ selectedUser.getFullName() + ") to the working set.");
				context.addMessage("msg", message);
				return null;
			}
			this.getConfigurationManager().setSelectedUser(this.selectedUser);
			return "profile";

		}
	}

	public String addUserToActiveWorkingSet() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		log.debug("Calling Add selected user shortcut function");
		if ((!this
				.getUserManager()
				.getUser()
				.getUid()
				.equals(this.getConfigurationManager().getSelectedWorkingSet()
						.getCreatedBy()))
				&& this.getConfigurationManager().isActiveWSPublic()) {
			if (!this.getConfigurationManager().isAllowPublicWSAdd()) {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] You do not have sufficient permissions to "
						+ "add users to this public working set.");
				context.addMessage("msg", message);
				return null;
			}
		}

		if (this.getSelectedUser() == null) {
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("[" + new Date()
					+ "] Error: Current User is empty. Please try again later.");
			context.addMessage("msg", message);
		} else {
			if (this.getSearchEngineBean().addUserToWorkingSet(
					this.getConfigurationManager().getSelectedWorkingSet(),
					this.getSelectedUser())) {
				log.debug("SelectedUser added successfully");
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary("[" + new Date() + "] User ("
						+ selectedUser.getFullName() + ") added successfully.");
				context.addMessage("msg", message);
				this.getSelectedUsers().clear();
				this.getSelectedUserIds().clear();

			} else {
				log.debug("unknown error addusertows");
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] Unknown Error: Cannot add the user ("
						+ selectedUser.getFullName() + ") to the working set.");
				context.addMessage("msg", message);
			}
		}
		return null;
	}

	public void saveSearchQuery() {
		log.debug("Calling Add selected users function");
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();

		if (query == null) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date()
					+ "] No query available to save.");
			context.addMessage("msg", message);
			return;
		}
		if (queryName == null) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] Invalid query name.");
			context.addMessage("msg", message);
			return;
		}

		if (this.getSearchEngineBean().saveQuery(
				this.getUserManager().getUser(), queryName, queryDescription,
				query) != null) {
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("[" + new Date() + "] Query " + queryName
					+ " saved successfully.");
			context.addMessage("msg", message);
			return;
		}
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		message.setSummary("[" + new Date()
				+ "] Unknown Error: Cannot save query.");
		context.addMessage("msg", message);
		return;
	}
	
	/* ******************************************* NAVIGATION ****************************************** */
	
	public String goToAdvising(){
		return "advising";
	}

	/* **********************************GETTERS AND SETTERS********************************** */



	public boolean isShowUkIdCol() {
		return showUkIdCol;
	}

	public void setShowUkIdCol(boolean showUkIdCol) {
		this.showUkIdCol = showUkIdCol;
	}

	public boolean isShowUkyEmailCol() {
		return showUkyEmailCol;
	}

	public void setShowUkyEmailCol(boolean showUkyEmailCol) {
		this.showUkyEmailCol = showUkyEmailCol;
	}

	public boolean isShowEthnicityCol() {
		return showEthnicityCol;
	}

	public void setShowEthnicityCol(boolean showEthnicityCol) {
		this.showEthnicityCol = showEthnicityCol;
	}

	public boolean isShowFirstNameCol() {
		return showFirstNameCol;
	}

	public void setShowFirstNameCol(boolean showFirstNameCol) {
		this.showFirstNameCol = showFirstNameCol;
	}

	public boolean isShowProgramStatusCol() {
		return showProgramStatusCol;
	}

	public void setShowProgramStatusCol(boolean showProgramStatusCol) {
		this.showProgramStatusCol = showProgramStatusCol;
	}

	public boolean isShowUkMajorCol() {
		return showUkMajorCol;
	}

	public void setShowUkMajorCol(boolean showUkMajorCol) {
		this.showUkMajorCol = showUkMajorCol;
	}

	public boolean isShowLastNameCol() {
		return showLastNameCol;
	}

	public void setShowLastNameCol(boolean showLastNameCol) {
		this.showLastNameCol = showLastNameCol;
	}

	public boolean isShowGenderCol() {
		return showGenderCol;
	}

	public void setShowGenderCol(boolean showGenderCol) {
		this.showGenderCol = showGenderCol;
	}

	public boolean isReportSearch() {
		return reportSearch;
	}

	public void setReportSearch(boolean reportSearch) {
		this.reportSearch = reportSearch;
	}

	public boolean isShowGpaCol() {
		return showGpaCol;
	}

	public void setShowGpaCol(boolean showGpaCol) {
		this.showGpaCol = showGpaCol;
	}

	public boolean isShowQualityHoursCol() {
		return showQualityHoursCol;
	}

	public void setShowQualityHoursCol(boolean showQualityHoursCol) {
		this.showQualityHoursCol = showQualityHoursCol;
	}

	public boolean isShowQualityPointsCol() {
		return showQualityPointsCol;
	}

	public void setShowQualityPointsCol(boolean showQualityPointsCol) {
		this.showQualityPointsCol = showQualityPointsCol;
	}

	public boolean isShowProgramGroupCol() {
		return showProgramGroupCol;
	}

	public void setShowProgramGroupCol(boolean showProgramGroupCol) {
		this.showProgramGroupCol = showProgramGroupCol;
	}

	public boolean isShowProgramStartTermCol() {
		return showProgramStartTermCol;
	}

	public void setShowProgramStartTermCol(boolean showProgramStartTermCol) {
		this.showProgramStartTermCol = showProgramStartTermCol;
	}

	public boolean isShowProgramCompleteTermCol() {
		return showProgramCompleteTermCol;
	}

	public void setShowProgramCompleteTermCol(boolean showProgramCompleteTermCol) {
		this.showProgramCompleteTermCol = showProgramCompleteTermCol;
	}

	public boolean isShowCollegeCol() {
		return showCollegeCol;
	}

	public void setShowCollegeCol(boolean showCollegeCol) {
		this.showCollegeCol = showCollegeCol;
	}

	public boolean isShowCollegeStartTermCol() {
		return showCollegeStartTermCol;
	}

	public void setShowCollegeStartTermCol(boolean showCollegeStartTermCol) {
		this.showCollegeStartTermCol = showCollegeStartTermCol;
	}

	public boolean isShowCollegeStatusCol() {
		return showCollegeStatusCol;
	}

	public void setShowCollegeStatusCol(boolean showCollegeStatusCol) {
		this.showCollegeStatusCol = showCollegeStatusCol;
	}

	public boolean isShowProgramCol() {
		return showProgramCol;
	}

	public void setShowProgramCol(boolean showProgramCol) {
		this.showProgramCol = showProgramCol;
	}

	public boolean isShowProgramDomainCol() {
		return showProgramDomainCol;
	}

	public void setShowProgramDomainCol(boolean showProgramDomainCol) {
		this.showProgramDomainCol = showProgramDomainCol;
	}

	public boolean isShowDepartmentCol() {
		return showDepartmentCol;
	}

	public void setShowDepartmentCol(boolean showDepartmentCol) {
		this.showDepartmentCol = showDepartmentCol;
	}

	public boolean isShowMiddleNameCol() {
		return showMiddleNameCol;
	}

	public void setShowMiddleNameCol(boolean showMiddleNameCol) {
		this.showMiddleNameCol = showMiddleNameCol;
	}

	public boolean isShowLinkBlueIdCol() {
		return showLinkBlueIdCol;
	}

	public void setShowLinkBlueIdCol(boolean showLinkBlueIdCol) {
		this.showLinkBlueIdCol = showLinkBlueIdCol;
	}

	public boolean isShowProfessionalAdvisorCol() {
		return showProfessionalAdvisorCol;
	}

	public void setShowProfessionalAdvisorCol(boolean showProfessionalAdvisorCol) {
		this.showProfessionalAdvisorCol = showProfessionalAdvisorCol;
	}

	public boolean isShowFacultyAdvisorCol() {
		return showFacultyAdvisorCol;
	}


	public void setShowFacultyAdvisorCol(boolean showFacultyAdvisorCol) {
		this.showFacultyAdvisorCol = showFacultyAdvisorCol;
	}


	public boolean isShowAnticipatedCompleteTermCol() {
		return showAnticipatedCompleteTermCol;
	}


	public void setShowAnticipatedCompleteTermCol(
			boolean showAnticipatedCompleteTermCol) {
		this.showAnticipatedCompleteTermCol = showAnticipatedCompleteTermCol;
	}


	public double getPercentMale() {
		return percentMale;
	}

	public void setPercentMale(double percentMale) {
		this.percentMale = percentMale;
	}

	public double getPercentFemale() {
		return percentFemale;
	}

	public void setPercentFemale(double percentFemale) {
		this.percentFemale = percentFemale;
	}

	public double getAverageGpa() {		
		return averageGpa;
	}

	public void setAverageGpa(double averageGpa) {
		this.averageGpa = averageGpa;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUkID() {
		return ukID;
	}

	public void setUkID(String ukID) {
		this.ukID = ukID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMaidenName() {
		return maidenName;
	}

	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ProgramDomain getSelectedProgramDomain() {
		return selectedProgramDomain;
	}

	public void setSelectedProgramDomain(ProgramDomain selectedProgramDomain) {
		this.selectedProgramDomain = selectedProgramDomain;
	}

	public Program getSelectedProgram() {
		return selectedProgram;
	}

	public void setSelectedProgram(Program selectedProgram) {
		this.selectedProgram = selectedProgram;
	}

	public ProgramGroup getSelectedProgramGroup() {
		return selectedProgramGroup;
	}

	public void setSelectedProgramGroup(ProgramGroup selectedProgramGroup) {
		this.selectedProgramGroup = selectedProgramGroup;
	}

	public UKMajor getSelectedUKMajor() {
		return selectedUKMajor;
	}

	public void setSelectedUKMajor(UKMajor selectedUKMajor) {
		this.selectedUKMajor = selectedUKMajor;
	}

	public UKStatus getSelectedProgramStatus() {
		return selectedProgramStatus;
	}

	public void setSelectedProgramStatus(UKStatus selectedProgramStatus) {
		this.selectedProgramStatus = selectedProgramStatus;
	}

	public boolean isCheck_selectedAnticipatedCompleteTerm() {
		return check_selectedAnticipatedCompleteTerm;
	}


	public void setCheck_selectedAnticipatedCompleteTerm(
			boolean check_selectedAnticipatedCompleteTerm) {
		this.check_selectedAnticipatedCompleteTerm = check_selectedAnticipatedCompleteTerm;
	}


	public UKTerm getSelectedProgramStartTerm() {
		return selectedProgramStartTerm;
	}

	public void setSelectedProgramStartTerm(UKTerm selectedProgramStartTerm) {
		this.selectedProgramStartTerm = selectedProgramStartTerm;
	}

	public UKTerm getSelectedProgramCompleteTerm() {
		return selectedProgramCompleteTerm;
	}

	public void setSelectedProgramCompleteTerm(UKTerm selectedProgramCompleteTerm) {
		this.selectedProgramCompleteTerm = selectedProgramCompleteTerm;
	}

	public Advisor getSelectedProfessionalAdvisor() {
		return selectedProfessionalAdvisor;
	}

	public void setSelectedProfessionalAdvisor(Advisor selectedProfessionalAdvisor) {
		this.selectedProfessionalAdvisor = selectedProfessionalAdvisor;
	}

	public FacultyAdvisor getSelectedFacultyAdvisor() {
		return selectedFacultyAdvisor;
	}


	public void setSelectedFacultyAdvisor(FacultyAdvisor selectedFacultyAdvisor) {
		this.selectedFacultyAdvisor = selectedFacultyAdvisor;
	}


	public UserType getSelectedUserType() {
		return selectedUserType;
	}

	public void setSelectedUserType(UserType selectedUserType) {
		this.selectedUserType = selectedUserType;
	}

	public UserClassification getSelectedUserClassification() {
		return selectedUserClassification;
	}

	public void setSelectedUserClassification(
			UserClassification selectedUserClassification) {
		this.selectedUserClassification = selectedUserClassification;
	}

	public UKCollege getSelectedUkCollege() {
		return selectedUkCollege;
	}

	public void setSelectedUkCollege(UKCollege selectedUkCollege) {
		this.selectedUkCollege = selectedUkCollege;
	}

	public UKDepartment getSelectedUkDepartment() {
		return selectedUkDepartment;
	}

	public void setSelectedUkDepartment(UKDepartment selectedUkDepartment) {
		this.selectedUkDepartment = selectedUkDepartment;
	}

	public UKTerm getSelectedCollegeStartTerm() {
		return selectedCollegeStartTerm;
	}

	public void setSelectedCollegeStartTerm(UKTerm selectedCollegeStartTerm) {
		this.selectedCollegeStartTerm = selectedCollegeStartTerm;
	}

	public UKTerm getSelectedCollegeEndTerm() {
		return selectedCollegeEndTerm;
	}

	public void setSelectedCollegeEndTerm(UKTerm selectedCollegeEndTerm) {
		this.selectedCollegeEndTerm = selectedCollegeEndTerm;
	}

	public UKStatus getSelectedCollegeStatus() {
		return selectedCollegeStatus;
	}

	public void setSelectedCollegeStatus(UKStatus selectedCollegeStatus) {
		this.selectedCollegeStatus = selectedCollegeStatus;
	}

	public CohortType getSelectedCohortType() {
		return selectedCohortType;
	}

	public void setSelectedCohortType(CohortType selectedCohortType) {
		this.selectedCohortType = selectedCohortType;
	}

	public CohortTerm getSelectedCohortTerm() {
		return selectedCohortTerm;
	}

	public void setSelectedCohortTerm(CohortTerm selectedCohortTerm) {
		this.selectedCohortTerm = selectedCohortTerm;
	}

	public boolean isShowSearchBox() {
		return showSearchBox;
	}

	public void setShowSearchBox(boolean showSearchBox) {
		this.showSearchBox = showSearchBox;
	}

	public boolean isShowSearchButton() {
		return showSearchButton;
	}

	public void setShowSearchButton(boolean showSearchButton) {
		this.showSearchButton = showSearchButton;
	}

	public boolean isShowSearchResults() {
		return showSearchResults;
	}

	public void setShowSearchResults(boolean showSearchResults) {
		this.showSearchResults = showSearchResults;
	}

	public boolean isShowReportColumnOptions() {
		return showReportColumnOptions;
	}

	public void setShowReportColumnOptions(boolean showReportColumnOptions) {
		this.showReportColumnOptions = showReportColumnOptions;
	}

	public boolean isShowReportButton() {
		return showReportButton;
	}

	public void setShowReportButton(boolean showReportButton) {
		this.showReportButton = showReportButton;
	}

	public boolean isShowReportResults() {
		return showReportResults;
	}

	public void setShowReportResults(boolean showReportResults) {
		this.showReportResults = showReportResults;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getQueryDescription() {
		return queryDescription;
	}

	public void setQueryDescription(String queryDescription) {
		this.queryDescription = queryDescription;
	}

	public boolean isShowSaveQueryModalWindow() {
		return showSaveQueryModalWindow;
	}

	public void setShowSaveQueryModalWindow(boolean showSaveQueryModalWindow) {
		this.showSaveQueryModalWindow = showSaveQueryModalWindow;
	}

	public UKTerm getSelectedUKEndTerm() {
		return selectedUKEndTerm;
	}

	public void setSelectedUKEndTerm(UKTerm selectedUKEndTerm) {
		this.selectedUKEndTerm = selectedUKEndTerm;
	}

	public UKTerm getSelectedUKTerm() {
		return selectedUKTerm;
	}

	public void setSelectedUKTerm(UKTerm selectedUKTerm) {
		this.selectedUKTerm = selectedUKTerm;
	}

	public Role getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(Role selectedRole) {
		this.selectedRole = selectedRole;
	}

	public String getDisplayQuery() {
		return displayQuery;
	}

	public void setDisplayQuery(String displayQuery) {
		this.displayQuery = displayQuery;
	}

	public DetachedCriteria getQuery() {
		return query;
	}

	public void setQuery(DetachedCriteria query) {
		this.query = query;
	}

	public Query getSelectedQuery() {
		return selectedQuery;
	}

	public void setSelectedQuery(Query selectedQuery) {
		this.selectedQuery = selectedQuery;
	}

	public String getGlobalQuery() {
		return globalQuery;
	}

	public void setGlobalQuery(String globalQuery) {
		this.globalQuery = globalQuery;
	}

	public Integer getSelectedOrder() {
		return selectedOrder;
	}

	public void setSelectedOrder(Integer selectedOrder) {
		this.selectedOrder = selectedOrder;
	}

	public List<String> getSelectedSearchOptions() {
		return selectedSearchOptions;
	}

	public void setSelectedSearchOptions(List<String> selectedSearchOptions) {
		this.selectedSearchOptions = selectedSearchOptions;
	}

	public boolean isSelectedSearchWithin() {
		return selectedSearchWithin;
	}

	public void setSelectedSearchWithin(boolean selectedSearchWithin) {
		this.selectedSearchWithin = selectedSearchWithin;
	}

	public WorkingSet getSelectedWS() {
		return selectedWS;
	}

	public void setSelectedWS(WorkingSet selectedWS) {
		this.selectedWS = selectedWS;
	}

	public List<User> getSelectedUsers() {
		return selectedUsers;
	}

	public void setSelectedUsers(List<User> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public Map<String, Boolean> getSelectedUserIds() {
		return selectedUserIds;
	}

	public void setSelectedUserIds(Map<String, Boolean> selectedUserIds) {
		this.selectedUserIds = selectedUserIds;
	}

	public SearchEngineView getSearchEngineBean() {
		return searchEngineBean;
	}

	public void setSearchEngineBean(SearchEngineView searchEngineBean) {
		this.searchEngineBean = searchEngineBean;
	}

	public List<User> getResultList() {
		return resultList;
	}

	public void setResultList(List<User> resultList) {
		this.resultList = resultList;
	}

	public boolean isCheck_globalQuery() {
		return check_globalQuery;
	}

	public void setCheck_globalQuery(boolean check_globalQuery) {
		this.check_globalQuery = check_globalQuery;
	}

	public boolean isCheck_username() {
		return check_username;
	}

	public void setCheck_username(boolean check_username) {
		this.check_username = check_username;
	}

	public boolean isCheck_firstName() {
		return check_firstName;
	}

	public void setCheck_firstName(boolean check_firstName) {
		this.check_firstName = check_firstName;
	}

	public boolean isCheck_lastName() {
		return check_lastName;
	}

	public void setCheck_lastName(boolean check_lastName) {
		this.check_lastName = check_lastName;
	}

	public boolean isCheck_middleName() {
		return check_middleName;
	}

	public void setCheck_middleName(boolean check_middleName) {
		this.check_middleName = check_middleName;
	}

	public boolean isCheck_maidenName() {
		return check_maidenName;
	}

	public void setCheck_maidenName(boolean check_maidenName) {
		this.check_maidenName = check_maidenName;
	}

	public boolean isCheck_ukID() {
		return check_ukID;
	}

	public void setCheck_ukID(boolean check_ukID) {
		this.check_ukID = check_ukID;
	}

	public boolean isCheck_ssn() {
		return check_ssn;
	}

	public void setCheck_ssn(boolean check_ssn) {
		this.check_ssn = check_ssn;
	}

	public boolean isCheck_gender() {
		return check_gender;
	}

	public void setCheck_gender(boolean check_gender) {
		this.check_gender = check_gender;
	}

	public boolean isCheck_selectedProgram() {
		return check_selectedProgram;
	}

	public void setCheck_selectedProgram(boolean check_selectedProgram) {
		this.check_selectedProgram = check_selectedProgram;
	}

	public boolean isCheck_selectedProgramDomain() {
		return check_selectedProgramDomain;
	}

	public void setCheck_selectedProgramDomain(boolean check_selectedProgramDomain) {
		this.check_selectedProgramDomain = check_selectedProgramDomain;
	}

	public boolean isCheck_selectedProgramGroup() {
		return check_selectedProgramGroup;
	}

	public void setCheck_selectedProgramGroup(boolean check_selectedProgramGroup) {
		this.check_selectedProgramGroup = check_selectedProgramGroup;
	}

	public boolean isCheck_selectedProgramStartTerm() {
		return check_selectedProgramStartTerm;
	}

	public void setCheck_selectedProgramStartTerm(boolean check_selectedProgramStartTerm) {
		this.check_selectedProgramStartTerm = check_selectedProgramStartTerm;
	}

	public boolean isCheck_selectedProgramCompleteTerm() {
		return check_selectedProgramCompleteTerm;
	}

	public void setCheck_selectedProgramCompleteTerm(boolean check_selectedProgramCompleteTerm) {
		this.check_selectedProgramCompleteTerm = check_selectedProgramCompleteTerm;
	}

	public boolean isCheck_selectedUKMajor() {
		return check_selectedUKMajor;
	}

	public void setCheck_selectedUKMajor(boolean check_selectedUKMajor) {
		this.check_selectedUKMajor = check_selectedUKMajor;
	}

	public boolean isCheck_selectedProgramStatus() {
		return check_selectedProgramStatus;
	}

	public void setCheck_selectedProgramStatus(boolean check_selectedProgramStatus) {
		this.check_selectedProgramStatus = check_selectedProgramStatus;
	}

	public UKTerm getSelectedAnticipatedCompleteTerm() {
		return selectedAnticipatedCompleteTerm;
	}


	public void setSelectedAnticipatedCompleteTerm(
			UKTerm selectedAnticipatedCompleteTerm) {
		this.selectedAnticipatedCompleteTerm = selectedAnticipatedCompleteTerm;
	}


	public boolean isCheck_selectedProfessionalAdvisor() {
		return check_selectedProfessionalAdvisor;
	}

	public void setCheck_selectedProfessionalAdvisor(boolean check_selectedProfessionalAdvisor) {
		this.check_selectedProfessionalAdvisor = check_selectedProfessionalAdvisor;
	}

	public boolean isCheck_selectedFacultyAdvisor() {
		return check_selectedFacultyAdvisor;
	}


	public void setCheck_selectedFacultyAdvisor(boolean check_selectedFacultyAdvisor) {
		this.check_selectedFacultyAdvisor = check_selectedFacultyAdvisor;
	}


	public boolean isCheck_selectedRole() {
		return check_selectedRole;
	}

	public void setCheck_selectedRole(boolean check_selectedRole) {
		this.check_selectedRole = check_selectedRole;
	}

	public boolean isAllowSearchOperation() {
		return allowSearchOperation;
	}

	public void setAllowSearchOperation(boolean allowSearchOperation) {
		this.allowSearchOperation = allowSearchOperation;
	}

	public String getFilterLastNameValue() {
		return filterLastNameValue;
	}

	public void setFilterLastNameValue(String filterLastNameValue) {
		this.filterLastNameValue = filterLastNameValue;
	}

	public String getFilterFirstNameValue() {
		return filterFirstNameValue;
	}

	public void setFilterFirstNameValue(String filterFirstNameValue) {
		this.filterFirstNameValue = filterFirstNameValue;
	}

	public String getFilterMiddleNameValue() {
		return filterMiddleNameValue;
	}

	public void setFilterMiddleNameValue(String filterMiddleNameValue) {
		this.filterMiddleNameValue = filterMiddleNameValue;
	}

	public int getPageValue() {
		return pageValue;
	}

	public void setPageValue(int pageValue) {
		this.pageValue = pageValue;
	}

	public String getSortOrderLastNameValue() {
		return sortOrderLastNameValue;
	}

	public void setSortOrderLastNameValue(String sortOrderLastNameValue) {
		this.sortOrderLastNameValue = sortOrderLastNameValue;
	}

	public String getSortOrderFirstNameValue() {
		return sortOrderFirstNameValue;
	}

	public void setSortOrderFirstNameValue(String sortOrderFirstNameValue) {
		this.sortOrderFirstNameValue = sortOrderFirstNameValue;
	}

	public String getSortOrderMiddleNameValue() {
		return sortOrderMiddleNameValue;
	}

	public void setSortOrderMiddleNameValue(String sortOrderMiddleNameValue) {
		this.sortOrderMiddleNameValue = sortOrderMiddleNameValue;
	}

	public Boolean getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(Boolean allUsers) {
		this.allUsers = allUsers;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public HtmlExtendedDataTable getReportTable() {
		return reportTable;
	}

	public void setReportTable(HtmlExtendedDataTable reportTable) {
		this.reportTable = reportTable;
	}

	public boolean isCheck_selectedUserType() {
		return check_selectedUserType;
	}

	public void setCheck_selectedUserType(boolean check_selectedUserType) {
		this.check_selectedUserType = check_selectedUserType;
	}

	public boolean isCheck_selectedUserClassification() {
		return check_selectedUserClassification;
	}

	public void setCheck_selectedUserClassification(
			boolean check_selectedUserClassification) {
		this.check_selectedUserClassification = check_selectedUserClassification;
	}

	public boolean isCheck_selectedCollege() {
		return check_selectedCollege;
	}

	public void setCheck_selectedCollege(boolean check_selectedCollege) {
		this.check_selectedCollege = check_selectedCollege;
	}

	public boolean isCheck_selectedDepartment() {
		return check_selectedDepartment;
	}

	public void setCheck_selectedDepartment(boolean check_selectedDepartment) {
		this.check_selectedDepartment = check_selectedDepartment;
	}

	public boolean isCheck_selectedCollegeStartTerm() {
		return check_selectedCollegeStartTerm;
	}

	public void setCheck_selectedCollegeStartTerm(
			boolean check_selectedCollegeStartTerm) {
		this.check_selectedCollegeStartTerm = check_selectedCollegeStartTerm;
	}

	public boolean isCheck_selectedCollegeEndTerm() {
		return check_selectedCollegeEndTerm;
	}

	public void setCheck_selectedCollegeEndTerm(
			boolean check_selectedCollegeEndTerm) {
		this.check_selectedCollegeEndTerm = check_selectedCollegeEndTerm;
	}

	public boolean isCheck_selectedCollegeStatus() {
		return check_selectedCollegeStatus;
	}

	public void setCheck_selectedCollegeStatus(boolean check_selectedCollegeStatus) {
		this.check_selectedCollegeStatus = check_selectedCollegeStatus;
	}

	public boolean isCheck_selectedCohortType() {
		return check_selectedCohortType;
	}

	public void setCheck_selectedCohortType(boolean check_selectedCohortType) {
		this.check_selectedCohortType = check_selectedCohortType;
	}

	public boolean isCheck_selectedCohortTerm() {
		return check_selectedCohortTerm;
	}

	public void setCheck_selectedCohortTerm(boolean check_selectedCohortTerm) {
		this.check_selectedCohortTerm = check_selectedCohortTerm;
	}	
}
