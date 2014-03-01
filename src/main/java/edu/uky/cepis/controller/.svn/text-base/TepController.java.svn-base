package edu.uky.cepis.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.ApplicationStatus;
import edu.uky.cepis.domain.CharacterAndFitness;
import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.Fee;
import edu.uky.cepis.domain.GreTestScore;
import edu.uky.cepis.domain.Letter;
import edu.uky.cepis.domain.PraxisIITestScore;
import edu.uky.cepis.domain.PraxisITestScore;
import edu.uky.cepis.domain.ReportYear;
import edu.uky.cepis.domain.TepAdmission;
import edu.uky.cepis.domain.TepApplication;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserProgramProfile;
import edu.uky.cepis.domain.component.ProgramGroup;
import edu.uky.cepis.domain.component.ProgramTrack;
import edu.uky.cepis.domain.component.UKMajor;
import edu.uky.cepis.domain.component.UKStatus;
import edu.uky.cepis.domain.component.UKTerm;
import edu.uky.cepis.domain.embeddedId.FeePK;
import edu.uky.cepis.util.global.CEPISGlobalComponentConfigurator;
import edu.uky.cepis.view.TepView;

/**
 * @author cawalk4
 *
 */
@Component
@Scope("session")
public class TepController extends AbstractController {
	
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(TepController.class);
	
	
	@Resource(name="tepBean")
	private TepView tepBean;
	
	private CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator;
	
	private List<User> selectedWSUsersList = new ArrayList<User>(0);

	/***************************ENTRY VALUES***************************/	
	private ReportYear selectedReportYear;
	
	private List<ReportYear> reportYearList = new ArrayList<ReportYear>();
	
	private UKTerm selectedCohortTerm;
	
	private String selectedApplicationLevel;
	
	private double overallGpa;
	
	private double totalHours;
	
	private String portfolioReview;
	
	private Date admissionDate;
	
	private String selectedAdmissionStatus;
	
	private String testType;
	
	private long testId;
	
	private String tepAdmissionMemo;
	
	private List<UserProgramProfile> programProfileList;
	
	private UserProgramProfile selectedProgramProfile;
	
	private User selectedUser;
	
	private boolean showEdit;
	
	/***************************REPORT***************************/	
	private UKMajor selectedUkMajor;
	
	private UKStatus selectedUkStatus;
	
	private ReportYear selectedReportYearCode;
	
	private HtmlExtendedDataTable reportTepAdmissionTable;
		
	private List<TepAdmission> reportTepAdmissionList;
	
	private List<UKTerm> termList;
	
	private UKTerm selectedReportTerm;
	
	private boolean renderReportUKTerm;
	
	/***************************PraxisI***************************/		
	private List<PraxisITestScore> praxisITestScoreList;
	
	private HtmlExtendedDataTable praxisITable;
	
	private PraxisITestScore selectedPraxisITestScore;
	
	/***************************PraxisII***************************/	
	private List<PraxisIITestScore> praxisIITestScoreList;
	
	private HtmlExtendedDataTable praxisIITable;
	
	private PraxisIITestScore selectedPraxisIITestScore;
	
	/***************************GRE***************************/		
	private List<GreTestScore> greTestScoreList;
	
	private HtmlExtendedDataTable greTable;
	
	private GreTestScore selectedGreTestScore;
	
	/***************************TEP ADMISSION***************************/		
	private List<TepAdmission> tepAdmissionList;
	
	private TepAdmission selectedTepAdmission;
	
	private HtmlExtendedDataTable tepAdmissionTable;	
	
	private int characterAndFitnessId;
	
	private String primary;
	
	// If a user has more then one program profile, they may have multiple TEP Admissions -> Must manualy set the primary one
	private boolean manualPrimary;
		
	/***************************TEP APPLICATION***************************/		
	private List<TepApplication> tepApplicationList;
	
	private List<ApplicationStatus> applicationStatusList;
	
	private HtmlExtendedDataTable tepApplicationTable;
	
	private TepApplication selectedTepApplication;
		
	private Date applicationDate;
	
	private ApplicationStatus selectedFacultyRecommendationCode;
	
	private ApplicationStatus selectedApplicationStatus;
	
	private Date facultyRecommendationDate;
	
	private Date followUpDate;
	
	private Date changeStatusDate;
	
	private String processMemo;
	
	private String facultyMemo;
	
	private String studentMemo;
	
	/****************************REFERENCE LETTERS****************************/	
	private List<Letter> letterList;
	
	private HtmlExtendedDataTable letterTable;
	
	private Letter selectedLetter;
	
	private String letterName;
	
	private String letterOrganization;
	
	private String letterRelation;
	
	private String letterPhone;
	
	private Date letterSignatureDate;
	
	private Date letterDateReceived;
	
	/****************************CHARACTER & FITNESS****************************/
	private List<CharacterAndFitness> characterAndFitnessList;
	
	private HtmlExtendedDataTable characterAndFitnessTable;
	
	private CharacterAndFitness selectedCharacterAndFitness;
	
	private Date characterAndFitnessSignatureDate;
	
	private Date characterAndFitnessDateReceived;
	
	private String characterAndFitnessMemo;
	
	/****************************FEE****************************/
	private List<Fee> feeList;
	
	private HtmlExtendedDataTable feeTable;
	
	private Fee selectedFee;
			
	private Date feeCheckDate;
	
	private String feeCheckType;
	
	private String feeType;
	
	private float feeAmountReceived;
	
	private String feeMemo;
		
	private Date feeDateReceived;
	
	private String feeCheckNumber;
	
	/****************************PROGRAM PROFILE****************************/	
	private String userprogramprofileid;
		
	private ProgramGroup selectedProgramGroup;
			
	private ProgramTrack selectedProgramTrack;
	
	private Advisor selectedAdvisor;
	
	private UKTerm selectedUkAnticipatedCompleteTerm;
	
	/************************************CONDITIONAL LOAD BOOLEANS************************************/
	private boolean loadReferenceLetters;
	
	private boolean loadFees;
	
	private boolean loadCharacterAndFitness;
	
	private boolean loadPraxisITestScores;
	
	private boolean loadPraxisIITestScores;
	
	private boolean loadGreTestScores;
	
	private boolean loadTepAdmission;
	
	private boolean loadTepApplication;

	
	private static String LETTER_ADD_SUCCESS = "Reference Letter Added Successfully.";
	private static String LETTER_ADD_FAIL = "Reference Letter Add Failed: PLEASE CONTACT AN ADMINISTRATOR";
	private static String LETTER_DELETE_FAIL = "Reference Letter Delete Failed: PLEASE CONTACT AN ADMINISTRATOR";	
	private static String LETTER_DELETE_SUCCESS = "Reference Letter Deleted Successfully";	
	private static String LETTER_EDIT_SUCCESS = "Reference Letter Successfully Edited .";
	private static String LETTER_EDIT_FAIL = "Reference Letter Edit Failed: PLEASE CONTACT AN ADMINISTRATOR";
	private static String ERROR_SELECT_LETTER = "Please select a letter from the list.";	
	private static String ERROR_SIGNATURE_DATE_REQUIRED = "Signature Date: Value is required.";	
	private static String ERROR_DATE_RECEIVED_REQUIRED = "Date Received: Value is required.";
	
	private static String CHARACTER_AND_FITNESS_ADD_SUCCESS = "Character And Fitness Added Successfully.";
	private static String CHARACTER_AND_FITNESS_ADD_FAIL = "Character And Fitness Add Failed: PLEASE CONTACT AN ADMINISTRATOR";
	private static String CHARACTER_AND_FITNESS_DELETE_SUCCESS = "Character And Fitness Deleted Successfully.";
	private static String CHARACTER_AND_FITNESS_DELETE_FAIL = "Character And Fitness Delete Failed: PLEASE CONTACT AN ADMINISTRATOR";
	private static String CHARACTER_AND_FITNESS_EDIT_SUCCESS = "Character And Fitness Edited Successfully.";
	private static String CHARACTER_AND_FITNESS_EDIT_FAIL = "Character And Fitness Edit Failed: PLEASE CONTACT AN ADMINISTRATOR";
	private static String ERROR_SELECT_CHARACTER_AND_FITNESS = "Please select a Character And Fitness from the list";
	
	private static String FEE_ADD_SUCCESS = "Fee Added Successfully.";
	private static String FEE_ADD_FAIL = "Fee Add Failed: PLEASE CONTACT AN ADMINISTRATOR";
	private static String FEE_DELETE_SUCCESS = "Fee Deleted Successfully.";
	private static String FEE_DELETE_FAIL = "Fee Delete Failed: PLEASE CONTACT AN ADMINISTRATOR";
	private static String FEE_EDIT_SUCCESS = "Fee Edited Successfully.";
	private static String FEE_EDIT_FAIL = "Fee Edit Failed: PLEASE CONTACT AN ADMINISTRATOR.";
	private static String ERROR_SELECT_FEE = "Please select a Fee from the list.";
	
	private static String TEP_SUCCESS = "TEP Admission And Application Successfully Submitted.";
	private static String TEP_FAIL = "TEP Admission And Application Submitted Faild: PLEASE CONTACT AN ADMINISTRATOR.";
	private static String TEP_APPLICATION_UPDATE_SUCCESS = "TEP Application Updated Successfully";
	private static String TEP_APPLICATION_UPDATE_FAIL = "TEP Application Update Failed: PLEASE CONTACT AN ADMINISTRATOR.";
	private static String TEP_APPLICATION_DELETE_SUCCESS = "TEP Application Deleted Successfully."; 
	private static String TEP_APPLICATION_DELETE_FAIL = "TEP Application Delete Faild: PLEASE CONTACT AN ADMINISTRATOR.";
	private static String TEP_ADMISSION_UPDATE_SUCCESS = "TEP Admission Updated Successfully";
	private static String TEP_ADMISSION_UPDATE_FAIL = "TEP Admission Updated Faild: PLEASE CONTACT AN ADMINISTRATOR.";
	private static String TEP_ADMISSION_DELETE_SUCCESS = "TEP Admission Deleted Successfully.";
	private static String TEP_ADMISSION_DELETE_FAIL = "TEP Admission Delete Faild: PLEASE CONTACT AN ADMINISTRATOR.";

	private static String DEFAULT_FEE_MEMO_STRING = "Fees received without any problem.";
	
	private static String NO_TEP_ADMISSIONS_FOUND = "No TEP Admissions found for selected criteria.";
	
	private static String PROGRAM_PROFILE_UPDATE_SUCCESS = "Program Profile Updated Successfully";
	private static String PROGRAM_PROFILE_UPDATE_FAIL = "Program Profile Update Failed: PLEASE CONTACT AN ADMINISTRATOR";
	
	private static String COL_1 = "TEP ID";
	private static String COL_2 = "UK ID";
	private static String COL_3 = "LAST NAME";
	private static String COL_4 = "FIRST NAME";
	private static String COL_5 = "UK Major";
	private static String COL_6 = "Report Year Code";
	private static String COL_7 = "Term Code";
	private static String COL_8 = "Admission Status";
	private static String COL_9 = "UK Email";
	private static String COL_10 = "Admission Memo";
	
	private TepController(){
		setLoadTepAdmission(true);
		setLoadTepApplication(true);
	}

	@PostConstruct
	public void initTep() {
		//These objects only need to be loaded once and are handled @ Post Construct.	
		setReportYearList(getTepBean().getReportYears());	
		setApplicationStatusList(getTepBean().getApplicationStatusList());
	}
	
	public String getSetUpViewTab(){
		setLoadTepAdmission(true);
		setLoadTepApplication(true);
		return "";
	}
	
	public String getSetUpAddTab(){
		setLoadTepAdmission(false);
		setLoadTepApplication(false);
		setLoadReferenceLetters(true);
		setLoadFees(true);
		setLoadCharacterAndFitness(true);
		setLoadPraxisITestScores(true);
		clearTepApplication();
		clearTepAdmission();
		
		// NOTE: Check if the student has one program profile (Used to check for special case -> primary set manually otherwise)
		if(getProgramProfileList().size() > 1){	
			setManualPrimary(true);
		}else{
			setManualPrimary(false);
		}
				
		return "";
	}
	
	public String getSetUpEditTab(){
		setLoadTepAdmission(true);
		setLoadTepApplication(true);
		return "";
	}
	
	public String getSetUpDeleteTab(){
		setLoadTepAdmission(true);
		setLoadTepApplication(true);
		setSelectedTepAdmission(null);
		setSelectedTepApplication(null);
		return "";
	}
	
	public String getSetUpReport(){
		setLoadTepAdmission(false);
		setLoadTepApplication(false);
		return "";
	}
	
	public String getSetUpPraxisIITab(){
		setLoadPraxisIITestScores(true);
		return "";
	}
	
	public String getSetUpGreTab(){
		setLoadGreTestScores(true);
		return "";
	}
	
	public void updateSelectedUser(){
		setSelectedTepAdmission(null);
		setSelectedTepApplication(null);
		setAdmissionDate(null);
		setOverallGpa(0);
		setTotalHours(0);
		setSelectedReportYear(null);
		setSelectedCohortTerm(null);
		setSelectedApplicationLevel(null);
		setSelectedAdmissionStatus(null);
		setSelectedApplicationStatus(null);
		setPortfolioReview(null);
		setTepAdmissionMemo(null);
		setUserprogramprofileid(null);
		setSelectedProgramGroup(null);
		setSelectedProgramTrack(null);
		setSelectedAdvisor(null);
		setSelectedUkAnticipatedCompleteTerm(null);
		setApplicationDate(null);
		setSelectedFacultyRecommendationCode(null);
		setFacultyRecommendationDate(null);
		setSelectedApplicationStatus(null);
		setFollowUpDate(null);
		setChangeStatusDate(null);
		setProcessMemo(null);
		setFacultyMemo(null);
		setStudentMemo(null);
		setPrimary(null);
		
		setSelectedUser(getConfigurationManager().getSelectedUser());
		
		// NOTE: Check if the student has one program profile (Used to check for special case -> primary set manually otherwise)
		if(getProgramProfileList().size() > 1){	
			setManualPrimary(true);
		}else{
			setManualPrimary(false);
		}
	}
	
	
	
	/* ***************************************** PRAXIS I ***************************************** */

	public void takePraxisISelection() {		
		if(this.getPraxisITable() != null){
			PraxisITestScore praxisITestScore = (PraxisITestScore) this.getPraxisITable().getRowData();
			if (praxisITestScore != null) {
				setSelectedPraxisITestScore(praxisITestScore);
			}	
		}					
		setTestType("Praxis1");
		setTestId(getSelectedPraxisITestScore().getId());
	}

	/* ***************************************** PRAXIS II ***************************************** */
	public void takePraxisIISelection() {		
		if(this.getPraxisIITable() != null){
			PraxisIITestScore praxisIITestScore = (PraxisIITestScore) this.getPraxisIITable().getRowData();
			if (praxisIITestScore != null) {
				setSelectedPraxisIITestScore(praxisIITestScore);			
			}	
		}			
		setTestType("Praxis");
		setTestId(getSelectedPraxisIITestScore().getId());
	}
	
	/* ***************************************** GRE ***************************************** */	
	public void takeGreSelection() {		
		if(this.getGreTable() != null){
			GreTestScore greTestScore = (GreTestScore) this.getGreTable().getRowData();
			if (greTestScore != null) {
				setSelectedGreTestScore(greTestScore);			
			}	
		}					
		setTestType("GRE");
		setTestId(getSelectedGreTestScore().getGreId());
	}
	
	/* ***************************************** TEP APPLICATION ***************************************** */
	public void takeTepApplicationSelection() {		
		if(this.getTepApplicationTable() != null){
			TepApplication tepApplication = (TepApplication) this.getTepApplicationTable().getRowData();
			if (tepApplication != null) {
				setSelectedTepApplication(tepApplication);			
			}
		}
	}
	
	public void prepTepApplicationEdit(){
		if(getSelectedTepApplication() != null){
			setApplicationDate(getSelectedTepApplication().getApplicationDate());
			setSelectedFacultyRecommendationCode(getSelectedTepApplication().getFacultyRecommendation());
			setFacultyRecommendationDate(getSelectedTepApplication().getFacultyRecommendationDate());
			setSelectedApplicationStatus(getSelectedTepApplication().getApplicationStatus());
			setFollowUpDate(getSelectedTepApplication().getFollowUpDate());
			setChangeStatusDate(getSelectedTepApplication().getChangeStatusDate());
			setProcessMemo(getSelectedTepApplication().getProcessMemo());
			setFacultyMemo(getSelectedTepApplication().getFacultyMemo());
			setStudentMemo(getSelectedTepApplication().getStudentMemo());
		}
	}
	
	public void updateTepApplication(){
		FacesContext context = FacesContext.getCurrentInstance();	
		FacesMessage message = new FacesMessage();
		
		if(getSelectedTepApplication() != null){
			TepApplication tepApplicationUpdate = getSelectedTepApplication();
			
			tepApplicationUpdate.setApplicationDate(getApplicationDate());
			tepApplicationUpdate.setFacultyRecommendation(getSelectedFacultyRecommendationCode());
			tepApplicationUpdate.setFacultyRecommendationDate(getFacultyRecommendationDate());
			tepApplicationUpdate.setApplicationStatus(getSelectedApplicationStatus());
			tepApplicationUpdate.setFollowUpDate(getFollowUpDate());
			tepApplicationUpdate.setChangeStatusDate(getChangeStatusDate());
			tepApplicationUpdate.setProcessMemo(getProcessMemo());
			tepApplicationUpdate.setFacultyMemo(getFacultyMemo());
			tepApplicationUpdate.setStudentMemo(getStudentMemo());
			
			if(getTepBean().saveOrUpdateTepApplication(tepApplicationUpdate)){			
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary(TEP_APPLICATION_UPDATE_SUCCESS + " On: " + new Date());
				context.addMessage("msg", message);
			}else{
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary(TEP_APPLICATION_UPDATE_FAIL + " On: " + new Date());
				context.addMessage("msg", message);
			}
		}
	}
	
	/* ***************************************** TEP ADMISSION ***************************************** */
	public void takeTepAdmissionSelection() {		
		if(this.getTepAdmissionTable() != null){
			TepAdmission tepAdmission = (TepAdmission) this.getTepAdmissionTable().getRowData();
			if (tepAdmission != null) {
				setSelectedTepAdmission(tepAdmission);			
			}
		}		
	}
	
		
	public void prepTepAdmissionEdit(ActionEvent event) {
		if (getSelectedTepAdmission() != new TepAdmission()) {		

			setUserprogramprofileid(getSelectedTepAdmission().getProgramProfile().getUserprogramprofileid());
			setSelectedProgramGroup(getSelectedTepAdmission().getProgramProfile().getProgramGroup());
			setSelectedProgramTrack(getSelectedTepAdmission().getProgramProfile().getProgramTrack());			
			setSelectedAdvisor(getSelectedTepAdmission().getProgramProfile().getAdvisor());
			setSelectedUkAnticipatedCompleteTerm(getSelectedTepAdmission().getProgramProfile().getUkAnticipatedCompleteTerm());
			
			setAdmissionDate(getSelectedTepAdmission().getTepAdmissionDate());
			setOverallGpa(getSelectedTepAdmission().getOverallGPA());
			setTotalHours(getSelectedTepAdmission().getTotalHours());
			setTepAdmissionMemo(getSelectedTepAdmission().getAdmissionMemo());
			setSelectedReportYear(getSelectedTepAdmission().getReportYear());
			setSelectedCohortTerm(getSelectedTepAdmission().getCohortTerm());
			setSelectedApplicationLevel(getSelectedTepAdmission().getApplicationLevel());
			setSelectedAdmissionStatus(getSelectedTepAdmission().getTepAdmissionCode());
			setPortfolioReview(getSelectedTepAdmission().getPortfolioreview());
			setPrimary(getSelectedTepAdmission().getPrimaryString());
		}else{
			setUserprogramprofileid(null);
			setSelectedProgramGroup(null);
			setSelectedProgramTrack(null);			
			setSelectedAdvisor(null);
			setSelectedUkAnticipatedCompleteTerm(null);
			
			setAdmissionDate(null);
			setOverallGpa(0.0);
			setTotalHours(0.0);
			setTepAdmissionMemo(null);
			setSelectedReportYear(null);
			setSelectedCohortTerm(null);
			setSelectedApplicationLevel(null);
			setSelectedAdmissionStatus(null);
			setPortfolioReview(null);
			setPrimary(null);
		}
		
		
	}
	
	public void updateTepAdmission(){
		
		if(getSelectedTepAdmission() != null && getSelectedTepAdmission().getProgramProfile() != null){
			UserProgramProfile programProfileUpdate = getSelectedTepAdmission().getProgramProfile();
			TepAdmission tepAdmissionUpdate = getSelectedTepAdmission();
			
			programProfileUpdate.setProgramGroup(getSelectedProgramGroup());
			programProfileUpdate.setProgramTrack(getSelectedProgramTrack());
			programProfileUpdate.setAdvisor(getSelectedAdvisor());
			programProfileUpdate.setUkAnticipatedCompleteTerm(getSelectedUkAnticipatedCompleteTerm());
			
			if(getTepBean().saveUserProgramProfile(programProfileUpdate)){	
				FacesContext context = FacesContext.getCurrentInstance();	
				FacesMessage message = new FacesMessage();
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary(PROGRAM_PROFILE_UPDATE_SUCCESS + " On: " + new Date());
				context.addMessage("msg", message);
			}else{
				FacesContext context = FacesContext.getCurrentInstance();	
				FacesMessage message = new FacesMessage();
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary(PROGRAM_PROFILE_UPDATE_FAIL + " On: " + new Date());
				context.addMessage("msg", message);
			}
			
			tepAdmissionUpdate.setTepAdmissionDate(getAdmissionDate());
			tepAdmissionUpdate.setOverallGPA(getOverallGpa());
			tepAdmissionUpdate.setTotalHours(getTotalHours());
			tepAdmissionUpdate.setReportYear(getSelectedReportYear());
			tepAdmissionUpdate.setCohortTerm(getSelectedCohortTerm());
			tepAdmissionUpdate.setApplicationLevel(getSelectedApplicationLevel());
			tepAdmissionUpdate.setTepAdmissionCode(getSelectedAdmissionStatus());
			tepAdmissionUpdate.setPortfolioreview(getPortfolioReview());
			tepAdmissionUpdate.setAdmissionMemo(getTepAdmissionMemo());
			tepAdmissionUpdate.setPrimaryString(getPrimary());
			
			if(getTepBean().saveOrUpdateTepAdmission(tepAdmissionUpdate)){
				
				clearTepAdmission();
				clearTepApplication();
				clearProgram();
				
				FacesContext context = FacesContext.getCurrentInstance();	
				FacesMessage message = new FacesMessage();
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary(TEP_ADMISSION_UPDATE_SUCCESS + " On: " + new Date());
				context.addMessage("msg", message);						
			}else{
				FacesContext context = FacesContext.getCurrentInstance();	
				FacesMessage message = new FacesMessage();
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary(TEP_ADMISSION_UPDATE_FAIL + " On: " + new Date());
				context.addMessage("msg", message);
			}
		}
	}
	
	/* *************************************** TEP APPLICATION & ADMISSION ***************************************  */

	public void deleteSelectedTep(){
		
		if(getSelectedTepAdmission() != null){
			if(getTepBean().deleteTepAdmission(getSelectedTepAdmission())){
				FacesContext context = FacesContext.getCurrentInstance();
				FacesMessage message = new FacesMessage();
				clearTepAdmission();
				clearProgram();
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary(TEP_ADMISSION_DELETE_SUCCESS + " On: " + new Date());
				context.addMessage("msg", message);	
			}else{
				FacesContext context = FacesContext.getCurrentInstance();
				FacesMessage message = new FacesMessage();
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary(TEP_ADMISSION_DELETE_FAIL + " On: " + new Date());
				context.addMessage("msg", message);	
			}
		}
		if (getSelectedTepApplication() != null){
			if(getTepBean().deleteTepApplication(getSelectedTepApplication())){
				FacesContext context = FacesContext.getCurrentInstance();
				FacesMessage message = new FacesMessage();
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary(TEP_APPLICATION_DELETE_SUCCESS + " On: " + new Date());
				context.addMessage("msg", message);	
			}else{
				FacesContext context = FacesContext.getCurrentInstance();
				FacesMessage message = new FacesMessage();
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary(TEP_APPLICATION_DELETE_FAIL + " On: " + new Date());
				context.addMessage("msg", message);	
			}
		}
	}
	
	public void addNewTepAdmissionAndApplication(){
		

			FacesContext context = FacesContext.getCurrentInstance();	
			FacesMessage message = new FacesMessage();
			
			TepAdmission newTepAdmission = new TepAdmission();
			TepAdmission primaryTepAdmission = new TepAdmission();
			int counter = 0;
			
			newTepAdmission.setAdmissionMemo(getTepAdmissionMemo());
			newTepAdmission.setTestType(getTestType());
			newTepAdmission.setTestID((int)getTestId());
			newTepAdmission.setOverallGPA(getOverallGpa());
			newTepAdmission.setTotalHours(getTotalHours());
			newTepAdmission.setProgramProfile(getSelectedProgramProfile());
			newTepAdmission.setPortfolioreview(getPortfolioReview());
			newTepAdmission.setReportYear(getSelectedReportYear());
			newTepAdmission.setCohortTerm(getSelectedCohortTerm());
			newTepAdmission.setApplicationLevel(getSelectedApplicationLevel());
			newTepAdmission.setTepAdmissionDate(getAdmissionDate());
			newTepAdmission.setTepAdmissionCode(getSelectedAdmissionStatus());
			newTepAdmission.setUser(getConfigurationManager().getSelectedUser());	
			newTepAdmission.setDeclarationId(getCharacterAndFitnessId());
			
			
			TepApplication newTepApplication = new TepApplication();
			
			newTepApplication.setApplicationDate(getApplicationDate());
			newTepApplication.setApplicationStatus(getSelectedApplicationStatus());
			newTepApplication.setCohortTerm(getSelectedCohortTerm());
			newTepApplication.setFacultyMemo(getFacultyMemo());
			newTepApplication.setFacultyRecommendation(getSelectedFacultyRecommendationCode());
			newTepApplication.setFacultyRecommendationDate(getFacultyRecommendationDate());
			newTepApplication.setFollowUpDate(getFollowUpDate());
			newTepApplication.setChangeStatusDate(getChangeStatusDate());
			newTepApplication.setProcessMemo(getProcessMemo());
			newTepApplication.setProgramProfile(getSelectedProgramProfile());
			newTepApplication.setStudentMemo(getStudentMemo());
				
			if(! getTepBean().saveOrUpdateTepApplication(newTepApplication)){
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary(TEP_FAIL + " On: " + new Date());
				context.addMessage("msg", message);
			}			
			
			// NOTE: Check if not manual primary (Student only has one program profile)
			if(! isManualPrimary()){	
				
				if(!getTepBean().saveOrUpdateTepAdmission(newTepAdmission)){
					message.setSeverity(FacesMessage.SEVERITY_ERROR);
					message.setSummary(TEP_FAIL + " On: " + new Date());
					context.addMessage("msg", message);
				}
			
				setLoadTepAdmission(true);
					
				/**************************** SET THE PRIMARY ****************************/		
			
				// NOTE: First set all primary values to false
				for(TepAdmission tepAdmission : getTepAdmissionList()){
					tepAdmission.setPrimary(0);
					getTepBean().saveOrUpdateTepAdmission(tepAdmission);
				}			
				// NOTE: Loop through to get TEP admission with the most recent Admission Date
				for(TepAdmission tepAdmission : getTepAdmissionList()){
					if(counter == 0){
						if(tepAdmission.getTepAdmissionDate() != null){
							primaryTepAdmission = tepAdmission;
							counter ++;
						}
					}else{
						if(tepAdmission.getTepAdmissionDate() != null){
							if(tepAdmission.getTepAdmissionDate().after(primaryTepAdmission.getTepAdmissionDate())){
								primaryTepAdmission = tepAdmission;
								counter ++;
							}
						}
					}			
				}			
			//NOTE: Now set the primary value to true
			primaryTepAdmission.setPrimary(1);		
			
			if(getTepBean().saveOrUpdateTepAdmission(primaryTepAdmission)){
				clearTepAdmission();
				clearTepApplication();
				clearProgram();
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary(TEP_SUCCESS + " On: " + new Date());
				context.addMessage("msg", message);
			}
			
		}else{
			if(getPrimary().equals("Yes")){
				
				// NOTE: First set all primary values to false
				for(TepAdmission tepAdmission : getTepAdmissionList()){
					tepAdmission.setPrimary(0);
					getTepBean().saveOrUpdateTepAdmission(tepAdmission);
				}				
				newTepAdmission.setPrimary(1);
								
				if(!getTepBean().saveOrUpdateTepAdmission(newTepAdmission)){
					message.setSeverity(FacesMessage.SEVERITY_ERROR);
					message.setSummary(TEP_FAIL + " On: " + new Date());
					context.addMessage("msg", message);
				}
			}else{
				newTepAdmission.setPrimary(0);
				
				if(!getTepBean().saveOrUpdateTepAdmission(newTepAdmission)){
					message.setSeverity(FacesMessage.SEVERITY_ERROR);
					message.setSummary(TEP_FAIL + " On: " + new Date());
					context.addMessage("msg", message);
				}
			}
		}			
	}	
		
	/* ***************************************** REFERENCE LETTER ***************************************** */
	public void takeReferenceLetterSelection(){
		if(this.getLetterTable() != null){
			Letter referenceLetter = (Letter) this.getLetterTable().getRowData();
			if (referenceLetter != null) {
				setSelectedLetter(referenceLetter);
			}	
		}				
	}
	
	public void addNewLetter(){
		FacesContext context = FacesContext.getCurrentInstance();	
		FacesMessage message = new FacesMessage();
		Letter newLetter = new Letter();
		UserProgramProfile programProfile = new UserProgramProfile();
		//Program profile will always be set to the users "1st" program profile
		try{
			programProfile = getTepBean().getVisibleUserProgramProfiles(getConfigurationManager().getSelectedUser()).get(0);
		}catch(NullPointerException e){
			 System.out.println(e.getMessage());
		}
		//Check if signature date is null
		if(getLetterSignatureDate() == null){
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(ERROR_SIGNATURE_DATE_REQUIRED);
			context.addMessage("msg", message);	
			return;
		}
		// Check if date received is null
		if(getLetterDateReceived() == null){
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(ERROR_DATE_RECEIVED_REQUIRED);
			context.addMessage("msg", message);	
			return;
		}
		
		newLetter.setDateReceived(getLetterDateReceived());
		newLetter.setSignatureDate(getLetterSignatureDate());
		newLetter.setName(getLetterName());
		newLetter.setOrganization(getLetterOrganization());
		newLetter.setPhone(getLetterPhone());
		newLetter.setRelation(getLetterRelation());
		newLetter.setProgramProfile(programProfile);
		
		if(getTepBean().saveOrUpdateLetter(newLetter)){			
			setLoadReferenceLetters(true);
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary(LETTER_ADD_SUCCESS + " On: " + new Date());
			context.addMessage("msg", message);
		}else{			
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(LETTER_ADD_FAIL + " On: " + new Date());
			context.addMessage("msg", message);
		}
	}
	
	public void prepEditLetter(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if(getSelectedLetter() == null){	
			//No Letter Selected
			setShowEdit(false);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(ERROR_SELECT_LETTER + " On: " + new Date());
			context.addMessage("msg", message);
		}else{
			setShowEdit(true);
		}
	}
	
	public void editLetter(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		
		if(getTepBean().saveOrUpdateLetter(getSelectedLetter())){
			setLoadReferenceLetters(true);
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary(LETTER_EDIT_SUCCESS + " On: " + new Date());
			context.addMessage("msg", message);
		}else{
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(LETTER_EDIT_FAIL + " On: " + new Date());
			context.addMessage("msg", message);
		}
	}
	
	public void deleteLetter(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if(getSelectedLetter() != null){
			if(getTepBean().deleteLetter(getSelectedLetter())){
				//Letter Deleted Succesfully				
				setLoadReferenceLetters(true);
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary(LETTER_DELETE_SUCCESS + " On: " + new Date());
				context.addMessage("msg", message);
			}else{
				//Error
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary(LETTER_DELETE_FAIL + " On: " + new Date());
				context.addMessage("msg", message);
			}
		}else{			
			//No Letter Selected
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(ERROR_SELECT_LETTER + " On: " + new Date());
			context.addMessage("msg", message);
		}
	}
	
	/* ***************************************** CHARACTER AND FITNESS ***************************************** */
	public void takeCharacterAndfitnessSelection(){
		if(this.getCharacterAndFitnessTable() != null){
			CharacterAndFitness characterAndFitness = (CharacterAndFitness) this.getCharacterAndFitnessTable().getRowData();
			if (characterAndFitness != null) {
				setSelectedCharacterAndFitness(characterAndFitness);
			}	
		}				
	}
	
	public void addNewCharacterAndFitness(){
		FacesContext context = FacesContext.getCurrentInstance();	
		FacesMessage message = new FacesMessage();
		CharacterAndFitness newCharacterAndfitness = new CharacterAndFitness();
		UserProgramProfile programProfile = new UserProgramProfile();
		//Program profile will always be set to the users "1st" program profile
		try{
			programProfile = getTepBean().getVisibleUserProgramProfiles(getConfigurationManager().getSelectedUser()).get(0);
		}catch(NullPointerException e){
			 System.out.println(e.getMessage());
		}
		//Check if signature date is null
		if(getCharacterAndFitnessDateReceived() == null){
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(ERROR_SIGNATURE_DATE_REQUIRED);
			context.addMessage("msg", message);	
			return;
		}
		// Check if date received is null
		if(getCharacterAndFitnessSignatureDate() == null){
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(ERROR_DATE_RECEIVED_REQUIRED);
			context.addMessage("msg", message);		
			return;
		}
		
		newCharacterAndfitness.setDateReceived(getCharacterAndFitnessDateReceived());
		newCharacterAndfitness.setMemo(getCharacterAndFitnessMemo());
		newCharacterAndfitness.setSignatureDate(getCharacterAndFitnessSignatureDate());
		newCharacterAndfitness.setProgramProfile(programProfile);
		
		if(getTepBean().saveOrUpdateCharacterAndFitness(newCharacterAndfitness)){			
			setLoadCharacterAndFitness(true);
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary(CHARACTER_AND_FITNESS_ADD_SUCCESS + " On: " + new Date());
			context.addMessage("msg", message);
		}else{			
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(CHARACTER_AND_FITNESS_ADD_FAIL + " On: " + new Date());
			context.addMessage("msg", message);
		}
	}
	
	public void prepEditCharacterAndFitness(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if(getSelectedCharacterAndFitness() == null){	
			//No Letter Selected
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(ERROR_SELECT_CHARACTER_AND_FITNESS);
			context.addMessage("msg", message);
		}
	}
	
	public void deleteCharacterAndFitness(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if(getSelectedCharacterAndFitness() != null){
			if(getTepBean().deleteCharacterAndFitness(getSelectedCharacterAndFitness())){
				//Character And Fitness Deleted Succesfully				
				setLoadCharacterAndFitness(true);
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary(CHARACTER_AND_FITNESS_DELETE_SUCCESS + " On: " + new Date());
				context.addMessage("msg", message);
			}else{
				//Error
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary(CHARACTER_AND_FITNESS_DELETE_FAIL + " On: " + new Date());
				context.addMessage("msg", message);
			}
		}else{			
			//No Character And Fitness Selected
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary(ERROR_SELECT_CHARACTER_AND_FITNESS);
			context.addMessage("msg", message);
		}
	}
	
	public void editCharacterAndFitness(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		
		if(getTepBean().saveOrUpdateCharacterAndFitness(getSelectedCharacterAndFitness())){
			setLoadCharacterAndFitness(true);
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary(CHARACTER_AND_FITNESS_EDIT_SUCCESS + " On: " + new Date());
			context.addMessage("msg", message);
		}else{
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary(CHARACTER_AND_FITNESS_EDIT_FAIL + " On: " + new Date());
			context.addMessage("msg", message);
		}
	}	
	
	/* ***************************************** FEES ***************************************** */
	public void takeFeeSelection(){
		if(this.getFeeTable() != null){
			Fee fee = (Fee) this.getFeeTable().getRowData();
			if (fee != null) {
				setSelectedFee(fee);
			}	
		}				
	}
	
	public void addNewFee(){
		FacesContext context = FacesContext.getCurrentInstance();	
		FacesMessage message = new FacesMessage();
		Fee newFee = new Fee();
		FeePK newFeePK = new FeePK();
		
		newFeePK.setCheckNumber(getFeeCheckNumber());
		newFeePK.setDateReceived(getFeeDateReceived());
		newFeePK.setUser(getConfigurationManager().getSelectedUser());
		
		newFee.setFeePk(newFeePK);
		newFee.setCheckDate(getFeeCheckDate());
		newFee.setCheckType(getFeeCheckType());
		newFee.setFeeType(getFeeType());
		newFee.setMemo(getFeeMemo());
		newFee.setAmountReceived(getFeeAmountReceived());
		newFee.setNameOnCheck(" ");
		
		if(getTepBean().saveOrUpdateFee(newFee)){
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			setLoadFees(true);
			message.setSummary(FEE_ADD_SUCCESS + " On: " + new Date());
			context.addMessage("msg", message);
		}else{
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(FEE_ADD_FAIL + " On: " + new Date());
			context.addMessage("msg", message);
		}
		
	}
	
	public void prepEditFee(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		//Check if a Fee is selected
		if(getSelectedFee() == null){				
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(ERROR_SELECT_FEE );
			context.addMessage("msg", message);
		}
	}
	
	public void editFee(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		
		if(getTepBean().saveOrUpdateFee(getSelectedFee())){
			setLoadFees(true);
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary(FEE_EDIT_SUCCESS + " On: " + new Date());
			context.addMessage("msg", message);
		}else{
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(FEE_EDIT_FAIL + " On: " + new Date());
			context.addMessage("msg", message);
		}
	}
	
	public void deleteFee(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		
		if(getSelectedFee() == null){
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(ERROR_SELECT_FEE);
			context.addMessage("msg", message);			
		}
		
		if(getTepBean().deleteFee(getSelectedFee())){
			setLoadFees(true);
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary(FEE_DELETE_SUCCESS + " On: " + new Date());
			context.addMessage("msg", message);			
		}else{
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(FEE_DELETE_FAIL + " On: " + new Date());
			context.addMessage("msg", message);			
		}
	}
	
	/* ******************************************* TEP ADMISSION REPORT ******************************************* */
	
	//Action Even to set term list to only terms for selected ReportYear
	public void valueChangeReportYear(ActionEvent event) {
		// Full UKTerm List
		List<UKTerm> termList = getTepBean().getUKTermList();
		
		// UKTerm List for ReportYear
		List<UKTerm> reportYearTermList = new ArrayList<UKTerm>();
		
		// ReportYearCode Example: 200607 --> START YEAR 06 --> END YEAR: 07
		String startYear = selectedReportYearCode.getReportYearCode().substring(2,4);
		String endYear = selectedReportYearCode.getReportYearCode().substring(4,6);
		
		// UKTerm NOTES:
		// TERM: 1 --> First Summer Session
		// TERM: 3 --> Second Summer Session
		// TERM: 5 --> Fall Semester
		// TERM: 7 --> Spring Semester
		for(UKTerm ukTerm : termList){
			String year = ukTerm.getUkTermCode().substring(2, 4);
			String term = ukTerm.getUkTermCode().substring(4,5);
			
			if(startYear.equals(year)){
				if(term.equals("5") ||
				term.equals("7")){
					reportYearTermList.add(ukTerm);
				}
			}
			if(endYear.equals(year)){
				if(term.equals("1") ||
				term.equals("3")){
					reportYearTermList.add(ukTerm);
				}
			}
		}
		setRenderReportUKTerm(true);
		setTermList(reportYearTermList);
	}
	
	public void search(){
		List<TepAdmission> tepAdmissionReportListTemp = new ArrayList<TepAdmission>();
		
		TepAdmission critExampleTepAdmission = new TepAdmission();
		
		if(getSelectedUkMajor() != null){
			critExampleTepAdmission.setProgramProfile(new UserProgramProfile());
			critExampleTepAdmission.getProgramProfile().setUkMajor(getSelectedUkMajor());
		}		
		if(getSelectedUkStatus() != null){
			if(critExampleTepAdmission.getProgramProfile() == null){
				critExampleTepAdmission.setProgramProfile(new UserProgramProfile());
			}
			critExampleTepAdmission.getProgramProfile().setUkStatus(getSelectedUkStatus());
		}
		if(getSelectedAdmissionStatus() != null){
			critExampleTepAdmission.setTepAdmissionCode(getSelectedAdmissionStatus());
		}
		if(getSelectedReportYearCode() != null){
			critExampleTepAdmission.setReportYear(getSelectedReportYearCode());
		}
		if(getSelectedReportTerm() != null){
			critExampleTepAdmission.setCohortTerm(getSelectedReportTerm());
		}
		
		tepAdmissionReportListTemp = getTepBean().getTepAdmissionByExample(critExampleTepAdmission);
		if(!tepAdmissionReportListTemp.isEmpty()){
			setReportTepAdmissionList(tepAdmissionReportListTemp);			
			//Set UKY Email address for each user in report list
			for(TepAdmission tepAdmission : getReportTepAdmissionList()){
				if(tepAdmission.getUser() != null){
					if(tepAdmission.getUser().getEmailAddresses() != null){
						if(!tepAdmission.getUser().getEmailAddresses().isEmpty()){
							for(EmailAddress emailAddress : tepAdmission.getUser().getEmailAddresses()){
								if(emailAddress.getType().getCode().equals("UKY")){
									tepAdmission.getUser().setUkyEmailAddress(emailAddress.getAddress());
								}
							}
						}
					}
					if(tepAdmission.getUser().getUkyEmailAddress() == null){
						tepAdmission.getUser().setUkyEmailAddress(" ");
					}
				}				
			}			
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage();			
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary(NO_TEP_ADMISSIONS_FOUND + " On: " + new Date());
			context.addMessage("msg", message);		
			
			setReportTepAdmissionList(new ArrayList<TepAdmission>());
			
		}
	}
	
	 public void exportHtmlTableToExcel() throws IOException{ 
	 
		 Workbook workbook =  new HSSFWorkbook();
		 Sheet sheet = workbook.createSheet("TEP Admission Report");
		 
		 //Create the first row aka the header row for the excel spreadsheet
		 Row headerRow = sheet.createRow(0);
		 
		 headerRow.createCell(0).setCellValue(COL_1);
		 headerRow.createCell(1).setCellValue(COL_2);
		 headerRow.createCell(2).setCellValue(COL_3);
		 headerRow.createCell(3).setCellValue(COL_4);
		 headerRow.createCell(4).setCellValue(COL_5);
		 headerRow.createCell(5).setCellValue(COL_6);
		 headerRow.createCell(6).setCellValue(COL_7);
		 headerRow.createCell(7).setCellValue(COL_8);
		 headerRow.createCell(8).setCellValue(COL_9);
		 headerRow.createCell(9).setCellValue(COL_10);
		 
		 //Start row index at 1 (index 0 = header)
		 int rowIndex = 1;

		 for (TepAdmission tepAdmission : getReportTepAdmissionList()) {
		     Row row = sheet.createRow(rowIndex++);
		     int columnIndex = 0;
		     //Create cells in each column
		     row.createCell(columnIndex++).setCellValue(tepAdmission.getId());
		     row.createCell(columnIndex++).setCellValue(tepAdmission.getUser().getUkID());
		     row.createCell(columnIndex++).setCellValue(tepAdmission.getUser().getlName());
		     row.createCell(columnIndex++).setCellValue(tepAdmission.getUser().getfName());
		     row.createCell(columnIndex++).setCellValue(tepAdmission.getProgramProfile().getUkMajor().getUkMajorCode());
		     row.createCell(columnIndex++).setCellValue(tepAdmission.getReportYear().getReportYearCode());
		     row.createCell(columnIndex++).setCellValue(tepAdmission.getCohortTerm().getUkTermCode());
		     row.createCell(columnIndex++).setCellValue(tepAdmission.getTepAdmissionCode());
		     row.createCell(columnIndex++).setCellValue(tepAdmission.getUser().getUkyEmailAddress());
		     row.createCell(columnIndex++).setCellValue(tepAdmission.getAdmissionMemo());
		 }
		 
		 //Autosize the width of each column
		 sheet.autoSizeColumn(0);
		 sheet.autoSizeColumn(1);
		 sheet.autoSizeColumn(2);
		 sheet.autoSizeColumn(3);
		 sheet.autoSizeColumn(4);
		 sheet.autoSizeColumn(5);
		 sheet.autoSizeColumn(6);
		 sheet.autoSizeColumn(7);
		 sheet.autoSizeColumn(8);
		 sheet.autoSizeColumn(9);
		 
		//Create the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
        String filename = "TEP_Admission_Report_" + dt.toString(fmt) + ".xls";
	 
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		externalContext.setResponseContentType("application/vnd.ms-excel");
		externalContext.setResponseHeader("Content-Disposition", "attachment;filename=" + filename);
		workbook.write(externalContext.getResponseOutputStream());
		// Prevent JSF from performing navigation.
		context.responseComplete(); 
			        
	 }
	
	/* ******************************************* CLEAR FORMS ******************************************* */
	
	private void clearTepAdmission(){
		setSelectedTepAdmission(null);
		setSelectedReportYear(null);
		setSelectedReportYearCode(null);
		setSelectedCohortTerm(null);
		setSelectedApplicationLevel(null);
		setSelectedAdmissionStatus(null);
		setPortfolioReview(null);
		setTepAdmissionMemo("");
		setAdmissionDate(null);
		setSelectedProgramProfile(null);
		setCharacterAndFitnessId(0);
		setTestId(0);
		setTestType(null);
		setOverallGpa(0.0);
		setTotalHours(0.0);
	}
	
	private void clearTepApplication(){
		setSelectedTepApplication(null);
		setApplicationDate(null);
		setSelectedFacultyRecommendationCode(null);
		setFacultyRecommendationDate(null);
		setSelectedApplicationStatus(null);
		setFollowUpDate(null);
		setChangeStatusDate(null);
		setProcessMemo("");
		setFacultyMemo("");
		setStudentMemo("");
	}
	
	private void clearProgram(){
		setSelectedProgramGroup(null);
		setSelectedProgramTrack(null);
		setSelectedAdvisor(null);
		setSelectedUkAnticipatedCompleteTerm(null);
	}
	
		
	/* ******************************************************************** Getters And Setters ******************************************************************** */
	
	public TepView getTepBean() {
		return tepBean;
	}

	public void setTepBean(TepView tepBean) {
		this.tepBean = tepBean;
	}

	public CEPISGlobalComponentConfigurator getCepisGlobalComponentConfigurator() {
		return cepisGlobalComponentConfigurator;
	}

	public void setCepisGlobalComponentConfigurator(CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator) {
		this.cepisGlobalComponentConfigurator = cepisGlobalComponentConfigurator;
	}

	public List<User> getSelectedWSUsersList() {
		return selectedWSUsersList;
	}

	public void setSelectedWSUsersList(List<User> selectedWSUsersList) {
		this.selectedWSUsersList = selectedWSUsersList;
	}

	public ReportYear getSelectedReportYear() {
		return selectedReportYear;
	}

	public void setSelectedReportYear(ReportYear selectedReportYear) {
		this.selectedReportYear = selectedReportYear;
	}

	public List<ReportYear> getReportYearList() {
		return reportYearList;
	}

	public void setReportYearList(List<ReportYear> reportYearList) {
		this.reportYearList = reportYearList;
	}

	public UKTerm getSelectedCohortTerm() {
		return selectedCohortTerm;
	}

	public void setSelectedCohortTerm(UKTerm selectedCohortTerm) {
		this.selectedCohortTerm = selectedCohortTerm;
	}

	public String getSelectedApplicationLevel() {
		return selectedApplicationLevel;
	}

	public void setSelectedApplicationLevel(String selectedApplicationLevel) {
		this.selectedApplicationLevel = selectedApplicationLevel;
	}

	public double getOverallGpa() {
		return overallGpa;
	}

	public void setOverallGpa(double overallGpa) {
		this.overallGpa = overallGpa;
	}

	public double getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(double totalHours) {
		this.totalHours = totalHours;
	}

	public String getPortfolioReview() {
		return portfolioReview;
	}

	public void setPortfolioReview(String portfolioReview) {
		this.portfolioReview = portfolioReview;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getSelectedAdmissionStatus() {
		return selectedAdmissionStatus;
	}

	public void setSelectedAdmissionStatus(String selectedAdmissionStatus) {
		this.selectedAdmissionStatus = selectedAdmissionStatus;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public long getTestId() {
		return testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}

	public String getTepAdmissionMemo() {
		return tepAdmissionMemo;
	}

	public void setTepAdmissionMemo(String tepAdmissionMemo) {
		this.tepAdmissionMemo = tepAdmissionMemo;
	}

	public List<UserProgramProfile> getProgramProfileList() {
		System.out.print("Calling getProgramProfileList ");
		if (this.getConfigurationManager().getSelectedUser() != null
				&& this.getConfigurationManager().getSelectedUser().getUid() != null){
			log.debug("loaded");
			this.setProgramProfileList(this.getTepBean().getVisibleUserProgramProfiles(this.getConfigurationManager().getSelectedUser()));
		}else{
			log.debug("skipped");
		}
		return this.programProfileList;
	}

	public void setProgramProfileList(List<UserProgramProfile> programProfileList) {
		this.programProfileList = programProfileList;
	}

	public UserProgramProfile getSelectedProgramProfile() {
		return selectedProgramProfile;
	}

	public void setSelectedProgramProfile(UserProgramProfile selectedProgramProfile) {
		this.selectedProgramProfile = selectedProgramProfile;
	}

	public User getSelectedUser() {		
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public boolean isShowEdit() {
		return showEdit;
	}

	public void setShowEdit(boolean showEdit) {
		this.showEdit = showEdit;
	}

	public UKMajor getSelectedUkMajor() {
		return selectedUkMajor;
	}


	public void setSelectedUkMajor(UKMajor selectedUkMajor) {
		this.selectedUkMajor = selectedUkMajor;
	}


	public UKStatus getSelectedUkStatus() {
		return selectedUkStatus;
	}


	public void setSelectedUkStatus(UKStatus selectedUkStatus) {
		this.selectedUkStatus = selectedUkStatus;
	}

	public ReportYear getSelectedReportYearCode() {
		return selectedReportYearCode;
	}

	public void setSelectedReportYearCode(ReportYear selectedReportYearCode) {
		this.selectedReportYearCode = selectedReportYearCode;
	}

	public HtmlExtendedDataTable getReportTepAdmissionTable() {
		return reportTepAdmissionTable;
	}


	public void setReportTepAdmissionTable(HtmlExtendedDataTable reportTepAdmissionTable) {
		this.reportTepAdmissionTable = reportTepAdmissionTable;
	}


	public List<TepAdmission> getReportTepAdmissionList() {
		return reportTepAdmissionList;
	}


	public void setReportTepAdmissionList(List<TepAdmission> reportTepAdmissionList) {
		this.reportTepAdmissionList = reportTepAdmissionList;
	}


	public List<UKTerm> getTermList() {
		if(termList == null){
			setTermList(new ArrayList<UKTerm>());
		}
		return termList;
	}

	public void setTermList(List<UKTerm> termList) {
		this.termList = termList;
	}

	public UKTerm getSelectedReportTerm() {
		return selectedReportTerm;
	}

	public void setSelectedReportTerm(UKTerm selectedReportTerm) {
		this.selectedReportTerm = selectedReportTerm;
	}

	public boolean isRenderReportUKTerm() {
		return renderReportUKTerm;
	}

	public void setRenderReportUKTerm(boolean renderReportUKTerm) {
		this.renderReportUKTerm = renderReportUKTerm;
	}

	public List<PraxisITestScore> getPraxisITestScoreList() {
		System.out.print("Calling Get PraxisITestScoreList ");		
		if (isLoadPraxisITestScores()
		&& this.getConfigurationManager().getSelectedUser() != null
		&& this.getConfigurationManager().getSelectedUser().getUid() != null){
			log.debug("loaded");
			this.setPraxisITestScoreList(this.getTepBean().getPraxisITestScores(this.getConfigurationManager().getSelectedUser()));
			setLoadPraxisITestScores(false);
		}else {
			log.debug("skipped");
		}
		return this.praxisITestScoreList;
	}

	public void setPraxisITestScoreList(List<PraxisITestScore> praxisITestScoreList) {
		this.praxisITestScoreList = praxisITestScoreList;
	}

	public HtmlExtendedDataTable getPraxisITable() {
		return praxisITable;
	}

	public void setPraxisITable(HtmlExtendedDataTable praxisITable) {
		this.praxisITable = praxisITable;
	}

	public List<PraxisIITestScore> getPraxisIITestScoreList() {
		System.out.print("Calling Get PraxisIITestScore List: ");
		if (isLoadPraxisIITestScores()
		&& this.getConfigurationManager().getSelectedUser() != null
		&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			log.debug("loaded PraxisIITestScore List");
			setLoadPraxisIITestScores(false);
			this.setPraxisIITestScoreList(this.getTepBean().getPraxisIITestScoreList(this.getConfigurationManager().getSelectedUser()));
		} else {
			log.debug("skipped PraxisIITestScore");
		}
		return this.praxisIITestScoreList;
	}

	public void setPraxisIITestScoreList(
			List<PraxisIITestScore> praxisIITestScoreList) {
		this.praxisIITestScoreList = praxisIITestScoreList;
	}

	public HtmlExtendedDataTable getPraxisIITable() {
		return praxisIITable;
	}

	public void setPraxisIITable(HtmlExtendedDataTable praxisIITable) {
		this.praxisIITable = praxisIITable;
	}

	public PraxisIITestScore getSelectedPraxisIITestScore() {
		return selectedPraxisIITestScore;
	}

	public void setSelectedPraxisIITestScore(
			PraxisIITestScore selectedPraxisIITestScore) {
		this.selectedPraxisIITestScore = selectedPraxisIITestScore;
	}

	public PraxisITestScore getSelectedPraxisITestScore() {
		return selectedPraxisITestScore;
	}

	public void setSelectedPraxisITestScore(
			PraxisITestScore selectedPraxisITestScore) {
		this.selectedPraxisITestScore = selectedPraxisITestScore;
	}

	public List<GreTestScore> getGreTestScoreList() {			
		if(isLoadGreTestScores()
		&& this.getConfigurationManager().getSelectedUser() != null
		&& this.getConfigurationManager().getSelectedUser().getUid() != null){
			GreTestScore greTestScoreExample = new GreTestScore();
			greTestScoreExample.setUser(this.getConfigurationManager().getSelectedUser());
			setGreTestScoreList(getTepBean().findGreTestScoreByExample(greTestScoreExample));
			setLoadGreTestScores(false);
		}				
		if(this.greTestScoreList == null){
			setGreTestScoreList(new ArrayList<GreTestScore>());
		}
		return this.greTestScoreList;
	}

	public void setGreTestScoreList(List<GreTestScore> greTestScoreList) {
		this.greTestScoreList = greTestScoreList;
	}

	public HtmlExtendedDataTable getGreTable() {
		return greTable;
	}

	public void setGreTable(HtmlExtendedDataTable greTable) {
		this.greTable = greTable;
	}

	public GreTestScore getSelectedGreTestScore() {
		return selectedGreTestScore;
	}

	public void setSelectedGreTestScore(GreTestScore selectedGreTestScore) {
		this.selectedGreTestScore = selectedGreTestScore;
	}

	public List<TepAdmission> getTepAdmissionList() {				
		if(isLoadTepAdmission()
		&& this.getConfigurationManager().getSelectedUser() != null
		&& this.getConfigurationManager().getSelectedUser().getUid() != null){
			setTepAdmissionList(getTepBean().getTepAdmissionForUser(this.getConfigurationManager().getSelectedUser()));			
			if(this.tepAdmissionList == null){
				setTepAdmissionList(new ArrayList<TepAdmission>());
			}
		}
		return this.tepAdmissionList;
	}

	public void setTepAdmissionList(List<TepAdmission> tepAdmissionList) {
		this.tepAdmissionList = tepAdmissionList;
	}

	public TepAdmission getSelectedTepAdmission() {
		return selectedTepAdmission;
	}

	public void setSelectedTepAdmission(TepAdmission selectedTepAdmission) {
		this.selectedTepAdmission = selectedTepAdmission;
	}

	public HtmlExtendedDataTable getTepAdmissionTable() {
		return tepAdmissionTable;
	}

	public void setTepAdmissionTable(HtmlExtendedDataTable tepAdmissionTable) {
		this.tepAdmissionTable = tepAdmissionTable;
	}

	public int getCharacterAndFitnessId() {
		return characterAndFitnessId;
	}

	public void setCharacterAndFitnessId(int characterAndFitnessId) {
		this.characterAndFitnessId = characterAndFitnessId;
	}

	public String getPrimary() {
		return primary;
	}

	public void setPrimary(String primary) {
		this.primary = primary;
	}

	public boolean isManualPrimary() {
		return manualPrimary;
	}

	public void setManualPrimary(boolean manualPrimary) {
		this.manualPrimary = manualPrimary;
	}

	public List<TepApplication> getTepApplicationList() {			
		if(isLoadTepApplication()
		&& this.getConfigurationManager().getSelectedUser() != null
		&& this.getConfigurationManager().getSelectedUser().getUid() != null){
			setTepApplicationList(getTepBean().getTepApplicationForUser(this.getConfigurationManager().getSelectedUser()));			
			if(this.tepApplicationList == null){
				setTepApplicationList(new ArrayList<TepApplication>());
			}
		}
		return this.tepApplicationList;
	}

	public void setTepApplicationList(List<TepApplication> tepApplicationList) {
		this.tepApplicationList = tepApplicationList;
	}

	public List<ApplicationStatus> getApplicationStatusList() {
		return applicationStatusList;
	}

	public void setApplicationStatusList(
			List<ApplicationStatus> applicationStatusList) {
		this.applicationStatusList = applicationStatusList;
	}

	public HtmlExtendedDataTable getTepApplicationTable() {
		return tepApplicationTable;
	}

	public void setTepApplicationTable(HtmlExtendedDataTable tepApplicationTable) {
		this.tepApplicationTable = tepApplicationTable;
	}

	public TepApplication getSelectedTepApplication() {
		return selectedTepApplication;
	}

	public void setSelectedTepApplication(TepApplication selectedTepApplication) {
		this.selectedTepApplication = selectedTepApplication;
	}
	
	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public ApplicationStatus getSelectedFacultyRecommendationCode() {
		return selectedFacultyRecommendationCode;
	}

	public void setSelectedFacultyRecommendationCode(
			ApplicationStatus selectedFacultyRecommendationCode) {
		this.selectedFacultyRecommendationCode = selectedFacultyRecommendationCode;
	}

	public ApplicationStatus getSelectedApplicationStatus() {
		return selectedApplicationStatus;
	}

	public void setSelectedApplicationStatus(
			ApplicationStatus selectedApplicationStatus) {
		this.selectedApplicationStatus = selectedApplicationStatus;
	}

	public Date getFacultyRecommendationDate() {
		return facultyRecommendationDate;
	}

	public void setFacultyRecommendationDate(Date facultyRecommendationDate) {
		this.facultyRecommendationDate = facultyRecommendationDate;
	}

	public Date getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(Date followUpDate) {
		this.followUpDate = followUpDate;
	}

	public Date getChangeStatusDate() {
		return changeStatusDate;
	}

	public void setChangeStatusDate(Date changeStatusDate) {
		this.changeStatusDate = changeStatusDate;
	}

	public String getProcessMemo() {
		return processMemo;
	}

	public void setProcessMemo(String processMemo) {
		this.processMemo = processMemo;
	}

	public String getFacultyMemo() {
		return facultyMemo;
	}

	public void setFacultyMemo(String facultyMemo) {
		this.facultyMemo = facultyMemo;
	}

	public String getStudentMemo() {
		return studentMemo;
	}

	public void setStudentMemo(String studentMemo) {
		this.studentMemo = studentMemo;
	}

	public List<Letter> getLetterList() {			
		if(isLoadReferenceLetters()
		&& this.getConfigurationManager().getSelectedUser() != null
		&& this.getConfigurationManager().getSelectedUser().getUid() != null){			
			List<Letter> referenceLetterList = new ArrayList<Letter>();
			referenceLetterList = getTepBean().getLettersForUser(this.getConfigurationManager().getSelectedUser());
			setLoadReferenceLetters(false);
			if(referenceLetterList != null){
				setLetterList(referenceLetterList);
			}else{
				setLetterList(new ArrayList<Letter>());
			}			
		}		
		return this.letterList;
	}

	public void setLetterList(List<Letter> letterList) {
		this.letterList = letterList;
	}

	public HtmlExtendedDataTable getLetterTable() {
		return letterTable;
	}

	public void setLetterTable(HtmlExtendedDataTable letterTable) {
		this.letterTable = letterTable;
	}

	public Letter getSelectedLetter() {
		return selectedLetter;
	}

	public void setSelectedLetter(Letter selectedLetter) {
		this.selectedLetter = selectedLetter;
	}

	public String getLetterName() {
		return letterName;
	}

	public void setLetterName(String letterName) {
		this.letterName = letterName;
	}

	public String getLetterOrganization() {
		return letterOrganization;
	}

	public void setLetterOrganization(String letterOrganization) {
		this.letterOrganization = letterOrganization;
	}

	public String getLetterRelation() {
		return letterRelation;
	}

	public void setLetterRelation(String letterRelation) {
		this.letterRelation = letterRelation;
	}

	public String getLetterPhone() {
		return letterPhone;
	}

	public void setLetterPhone(String letterPhone) {
		this.letterPhone = letterPhone;
	}

	public Date getLetterSignatureDate() {
		return letterSignatureDate;
	}

	public void setLetterSignatureDate(Date letterSignatureDate) {
		this.letterSignatureDate = letterSignatureDate;
	}

	public Date getLetterDateReceived() {
		return letterDateReceived;
	}

	public void setLetterDateReceived(Date letterDateReceived) {
		this.letterDateReceived = letterDateReceived;
	}

	public List<CharacterAndFitness> getCharacterAndFitnessList() {		
		if(isLoadCharacterAndFitness()
		&& this.getConfigurationManager().getSelectedUser() != null
		&& this.getConfigurationManager().getSelectedUser().getUid() != null){	
			List<CharacterAndFitness> characterAndFitnessList = new ArrayList<CharacterAndFitness>();
			characterAndFitnessList = getTepBean().getCharacterAndFitnessForUser(this.getConfigurationManager().getSelectedUser());
			setLoadCharacterAndFitness(false);
			if(characterAndFitnessList != null){
				setCharacterAndFitnessList(characterAndFitnessList);
			}else{
				setCharacterAndFitnessList(new ArrayList<CharacterAndFitness>());
			}		
		}		
		return this.characterAndFitnessList;
	}

	public void setCharacterAndFitnessList(
			List<CharacterAndFitness> characterAndFitnessList) {
		this.characterAndFitnessList = characterAndFitnessList;
	}

	public HtmlExtendedDataTable getCharacterAndFitnessTable() {
		return characterAndFitnessTable;
	}

	public void setCharacterAndFitnessTable(
			HtmlExtendedDataTable characterAndFitnessTable) {
		this.characterAndFitnessTable = characterAndFitnessTable;
	}

	public CharacterAndFitness getSelectedCharacterAndFitness() {
		return selectedCharacterAndFitness;
	}

	public void setSelectedCharacterAndFitness(
			CharacterAndFitness selectedCharacterAndFitness) {
		this.selectedCharacterAndFitness = selectedCharacterAndFitness;
	}

	public Date getCharacterAndFitnessSignatureDate() {
		return characterAndFitnessSignatureDate;
	}

	public void setCharacterAndFitnessSignatureDate(
			Date characterAndFitnessSignatureDate) {
		this.characterAndFitnessSignatureDate = characterAndFitnessSignatureDate;
	}

	public Date getCharacterAndFitnessDateReceived() {
		return characterAndFitnessDateReceived;
	}

	public void setCharacterAndFitnessDateReceived(	Date characterAndFitnessDateReceived) {
		this.characterAndFitnessDateReceived = characterAndFitnessDateReceived;
	}

	public String getCharacterAndFitnessMemo() {
		return characterAndFitnessMemo;
	}

	public void setCharacterAndFitnessMemo(String characterAndFitnessMemo) {
		this.characterAndFitnessMemo = characterAndFitnessMemo;
	}

	public List<Fee> getFeeList() {		
		if(isLoadFees()
		&& this.getConfigurationManager().getSelectedUser() != null
		&& this.getConfigurationManager().getSelectedUser().getUid() != null){	
			List<Fee> feeList = new ArrayList<Fee>();
			Fee example = new Fee();
			example.setFeePk(new FeePK());
			example.getFeePk().setUser(this.getConfigurationManager().getSelectedUser());
			feeList = getTepBean().findFeeByExample(example);
			setLoadFees(false);
			if(feeList != null){
				setFeeList(feeList);
			}else{
				setFeeList(new ArrayList<Fee>());
			}		
		}
		return this.feeList;
	}

	public void setFeeList(List<Fee> feeList) {
		this.feeList = feeList;
	}

	public HtmlExtendedDataTable getFeeTable() {
		return feeTable;
	}

	public void setFeeTable(HtmlExtendedDataTable feeTable) {
		this.feeTable = feeTable;
	}

	public Fee getSelectedFee() {
		if(selectedFee == null){
			setSelectedFee(new Fee());
		}
		return selectedFee;
	}

	public void setSelectedFee(Fee selectedFee) {
		this.selectedFee = selectedFee;
	}

	public Date getFeeCheckDate() {
		return feeCheckDate;
	}

	public void setFeeCheckDate(Date feeCheckDate) {
		this.feeCheckDate = feeCheckDate;
	}

	public String getFeeCheckType() {
		return feeCheckType;
	}

	public void setFeeCheckType(String feeCheckType) {
		this.feeCheckType = feeCheckType;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public float getFeeAmountReceived() {
		return feeAmountReceived;
	}

	public void setFeeAmountReceived(float feeAmountReceived) {
		this.feeAmountReceived = feeAmountReceived;
	}

	public String getFeeMemo() {
		if(this.feeMemo == null){
			return DEFAULT_FEE_MEMO_STRING;
		}else{
			return feeMemo;
		}
	}

	public void setFeeMemo(String feeMemo) {
		this.feeMemo = feeMemo;
	}

	public Date getFeeDateReceived() {
		return feeDateReceived;
	}

	public void setFeeDateReceived(Date feeDateReceived) {
		this.feeDateReceived = feeDateReceived;
	}

	public String getFeeCheckNumber() {
		return feeCheckNumber;
	}

	public void setFeeCheckNumber(String feeCheckNumber) {
		this.feeCheckNumber = feeCheckNumber;
	}

	public ProgramGroup getSelectedProgramGroup() {
		return selectedProgramGroup;
	}

	public void setSelectedProgramGroup(ProgramGroup selectedProgramGroup) {
		this.selectedProgramGroup = selectedProgramGroup;
	}

	public ProgramTrack getSelectedProgramTrack() {
		return selectedProgramTrack;
	}

	public void setSelectedProgramTrack(ProgramTrack selectedProgramTrack) {
		this.selectedProgramTrack = selectedProgramTrack;
	}

	public Advisor getSelectedAdvisor() {
		return selectedAdvisor;
	}

	public void setSelectedAdvisor(Advisor selectedAdvisor) {
		this.selectedAdvisor = selectedAdvisor;
	}

	public UKTerm getSelectedUkAnticipatedCompleteTerm() {
		return selectedUkAnticipatedCompleteTerm;
	}

	public void setSelectedUkAnticipatedCompleteTerm(UKTerm selectedUkAnticipatedCompleteTerm) {
		this.selectedUkAnticipatedCompleteTerm = selectedUkAnticipatedCompleteTerm;
	}

	public String getUserprogramprofileid() {
		return userprogramprofileid;
	}

	public void setUserprogramprofileid(String userprogramprofileid) {
		this.userprogramprofileid = userprogramprofileid;
	}

	public boolean isLoadReferenceLetters() {
		return loadReferenceLetters;
	}

	public void setLoadReferenceLetters(boolean loadReferenceLetters) {
		this.loadReferenceLetters = loadReferenceLetters;
	}

	public boolean isLoadFees() {
		return loadFees;
	}

	public void setLoadFees(boolean loadFees) {
		this.loadFees = loadFees;
	}

	public boolean isLoadCharacterAndFitness() {
		return loadCharacterAndFitness;
	}

	public void setLoadCharacterAndFitness(boolean loadCharacterAndFitness) {
		this.loadCharacterAndFitness = loadCharacterAndFitness;
	}

	public boolean isLoadPraxisITestScores() {
		return loadPraxisITestScores;
	}

	public void setLoadPraxisITestScores(boolean loadPraxisITestScores) {
		this.loadPraxisITestScores = loadPraxisITestScores;
	}

	public boolean isLoadPraxisIITestScores() {
		return loadPraxisIITestScores;
	}

	public void setLoadPraxisIITestScores(boolean loadPraxisIITestScores) {
		this.loadPraxisIITestScores = loadPraxisIITestScores;
	}

	public boolean isLoadGreTestScores() {
		return loadGreTestScores;
	}

	public void setLoadGreTestScores(boolean loadGreTestScores) {
		this.loadGreTestScores = loadGreTestScores;
	}

	public boolean isLoadTepAdmission() {
		return loadTepAdmission;
	}

	public void setLoadTepAdmission(boolean loadTepAdmission) {
		this.loadTepAdmission = loadTepAdmission;
	}

	public boolean isLoadTepApplication() {
		return loadTepApplication;
	}

	public void setLoadTepApplication(boolean loadTepApplication) {
		this.loadTepApplication = loadTepApplication;
	}	
}