package edu.uky.cepis.controller;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.apache.myfaces.custom.schedule.HtmlSchedule;
import org.apache.myfaces.custom.schedule.ScheduleMouseEvent;
import org.apache.myfaces.custom.schedule.model.ScheduleEntry;
import org.apache.myfaces.custom.schedule.model.ScheduleModel;
import org.efs.openreports.objects.MailMessage;
import org.efs.openreports.providers.ProviderException;
import org.jfree.util.Log;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.DataProvider;
import org.richfaces.model.ExtendedTableDataModel;
import org.richfaces.model.selection.SimpleSelection;

import edu.uky.cepis.domain.AdvisingSession;
import edu.uky.cepis.domain.AdvisingSessionSlot;
import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.AdvisorGroup;
import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.HoldLift;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserCollegeProfile;
import edu.uky.cepis.domain.UserProgramProfile;
import edu.uky.cepis.domain.WorkingSet;
import edu.uky.cepis.domain.component.UKTerm;
import edu.uky.cepis.util.cron.job.ReminderEmailJob;
import edu.uky.cepis.view.AdvisingManagementView;

/**
 * @author scott
 */

public class AdvisingManagementController extends AbstractController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property name="advisingManagementBean"
	 * @uml.associationEnd
	 */
	private AdvisingManagementView advisingManagementBean;
	private AccountManagementController accountManagementController;
	private String currentView;
	private boolean appointmentSelected;
	private boolean myCalendarMode = false;
	private List<SelectItem> advisorTreeSelectItems = new ArrayList<SelectItem>(
			0);
	private List<AdvisingSession> advisorSessions = new ArrayList<AdvisingSession>(
			0);
	private String userRole;
	// This field is similar to the User field in the User manager object
	private Advisor currentAdvisor = null;
	private HtmlSchedule schedule;

	private HtmlExtendedDataTable agendaTable;
	private HtmlExtendedDataTable schedulerTable;
	private Advisor selectedAdvisor;
	private boolean enableCheckinAction = true;
	private boolean enableAddToWorkingSetAction = true;
	// for creating/editing/displaying an advising session
	private String scannedID;
	private AdvisingSessionSlot selectedAdvisingSessionSlot;
	private String selectedSessionType;
	private String sessionStatus;
	private String preSessionText;
	private String sessionText;
	private String studentNotes;
	private String advisorNotes;
	private String apptReason;
	private UKTerm selectedHoldLiftTerm;
	// for creating an advising session slot
	private Integer selectedSlotNumber;
	private Date selectedSlotDate;
	private String slotStatus;
	// display available slots
	private List<AdvisingSessionSlot> advisingSessionSlotList = new ArrayList<AdvisingSessionSlot>(
			0);
	private List<AdvisingSessionSlot> studentAdvisingSessionSlotList = new ArrayList<AdvisingSessionSlot>(
			0);
	// for an advisor to create a weeks worth of slots at once
	private Boolean selectedCheckboxArray[][] = new Boolean[5][16];
	private Boolean disabledCheckboxArray[][] = new Boolean[5][16];
	private String weekDays[] = { "Monday", "Tuesday", "Wednesday", "Thursday",
			"Friday" };

	// for displaying advising sessions
	private AdvisingSession selectedAdvisingSession;
	private Date selectedSessionDate = new Date();
	private Date selectedStartSessionDate;
	private Date selectedEndSessionDate;
	private boolean notifyChanges;

	// for richfaces extended data table
	private ExtendedTableDataModel<AdvisingSession> dataModel;
	private Object tableState;
	private SimpleSelection selection = new SimpleSelection();
	// for richfaces picklist
	private List<Advisor> selectedAdvisorList = new ArrayList<Advisor>(0);

	// for sending feedback during testing
	private String subject;
	private String message;

	// for displaying advising sessions on calendar
	private ScheduleModel model = null;
	
	private boolean sendConformationEmail = true;
	
	
	/********************************************************** MAGIC VARIABLES ************************************************************/
	
	// Student can have no more then one appointment per day
	private static int MAX_DAILY_APPOINTMENTS = 0;
	
	// Prospective Student UID
	private static String PROSPECTIVE_UID = "STUPX-1101";
	
	// Date for 24 HR rule ( Must schedule appointment more then 24 hours in advance )
	private Date dateRestriction = new Date(new Date().getTime() + (24 * 60 * 60 * 1000));
	
	/***************************************************************************************************************************************/
	
	private List<AdvisingSession> pastAppointments = new ArrayList<AdvisingSession>();
	
	private HtmlExtendedDataTable pastAppointmentsTable;
	
	private AdvisingSession selectedPastAppointment;
	
	public void takePastAppointmentSelection(){
		Log.debug("Entered takePastAppointmentSelection");
		if(!pastAppointmentsTable.getRowData().equals(null)){
			setSelectedPastAppointment((AdvisingSession) pastAppointmentsTable.getRowData());
		}
	}

	public List<AdvisingSession> getPastAppointments() {		
		if(getSelectedAdvisingSession() != null){
		setPastAppointments(getAdvisingManagementBean().getAdvisingSessionList(getSelectedAdvisingSession().getUser()));
		}else{
			setPastAppointments(new ArrayList<AdvisingSession>());
		}
		return pastAppointments;
	}

	public void setPastAppointments(List<AdvisingSession> pastAppointments) {
		this.pastAppointments = pastAppointments;
	}
	
	public HtmlExtendedDataTable getPastAppointmentsTable() {
		return pastAppointmentsTable;
	}

	public void setPastAppointmentsTable(HtmlExtendedDataTable pastAppointmentsTable) {
		this.pastAppointmentsTable = pastAppointmentsTable;
	}

	public AdvisingSession getSelectedPastAppointment() {
		if(selectedPastAppointment == null){
			setSelectedPastAppointment(new AdvisingSession());
		}
		return selectedPastAppointment;
	}

	public void setSelectedPastAppointment(AdvisingSession selectedPastAppointment) {
		this.selectedPastAppointment = selectedPastAppointment;
	}
	/***************************************************************************************************************************************/
	/***************************************************************************************************************************************/
	/***************************************************************************************************************************************/
	/***************************************************************************************************************************************/
	/***************************************************************************************************************************************/
	/***************************************************************************************************************************************/
	/***************************************************************************************************************************************/
	/***************************************************************************************************************************************/
	/**
	 * @return the advisingManagementBean
	 * @uml.property name="advisingManagementBean"
	 */
	public AdvisingManagementView getAdvisingManagementBean() {
		return advisingManagementBean;
	}

	/**
	 * @param advisingManagementBean
	 *            the advisingManagementBean to set
	 * @uml.property name="advisingManagementBean"
	 */
	public void setAdvisingManagementBean(
			AdvisingManagementView advisingManagementBean) {
		this.advisingManagementBean = advisingManagementBean;
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
	 * @return the selectedAdvisingSessionSlot
	 * @uml.property name="selectedAdvisingSessionSlot"
	 */
	public AdvisingSessionSlot getSelectedAdvisingSessionSlot() {
		return selectedAdvisingSessionSlot;
	}

	/**
	 * @return the enableCheckinAction
	 */
	public boolean isEnableCheckinAction() {
		return enableCheckinAction;
	}

	/**
	 * @return the enableAddToWorkingSetAction
	 */
	public boolean isEnableAddToWorkingSetAction() {
		return enableAddToWorkingSetAction;
	}

	/**
	 * @param enableCheckinAction
	 *            the enableCheckinAction to set
	 */
	public void setEnableCheckinAction(boolean enableCheckinAction) {
		this.enableCheckinAction = enableCheckinAction;
	}

	/**
	 * @param enableAddToWorkingSetAction
	 *            the enableAddToWorkingSetAction to set
	 */
	public void setEnableAddToWorkingSetAction(
			boolean enableAddToWorkingSetAction) {
		this.enableAddToWorkingSetAction = enableAddToWorkingSetAction;
	}

	/**
	 * @param selectedAdvisingSessionSlot
	 *            the selectedAdvisingSessionSlot to set
	 * @uml.property name="selectedAdvisingSessionSlot"
	 */
	public void setSelectedAdvisingSessionSlot(
			AdvisingSessionSlot selectedAdvisingSessionSlot) {
		this.selectedAdvisingSessionSlot = selectedAdvisingSessionSlot;
	}

	/**
	 * @return the selectedSessionType
	 * @uml.property name="selectedSessionType"
	 */
	public String getSelectedSessionType() {
		return selectedSessionType;
	}

	/**
	 * @param selectedSessionType
	 *            the selectedSessionType to set
	 * @uml.property name="selectedSessionType"
	 */
	public void setSelectedSessionType(String selectedSessionType) {
		this.selectedSessionType = selectedSessionType;
	}

	/**
	 * @return the sessionStatus
	 * @uml.property name="sessionStatus"
	 */
	public String getSessionStatus() {
		return sessionStatus;
	}

	/**
	 * @param sessionStatus
	 *            the sessionStatus to set
	 * @uml.property name="sessionStatus"
	 */
	public void setSessionStatus(String sessionStatus) {
		this.sessionStatus = sessionStatus;
	}

	/**
	 * @return the preSessionText
	 * @uml.property name="preSessionText"
	 */
	public String getPreSessionText() {
		return preSessionText;
	}

	/**
	 * @param preSessionText
	 *            the preSessionText to set
	 * @uml.property name="preSessionText"
	 */
	public void setPreSessionText(String preSessionText) {
		this.preSessionText = preSessionText;
	}

	/**
	 * @return the sessionText
	 * @uml.property name="sessionText"
	 */
	public String getSessionText() {
		return sessionText;
	}

	/**
	 * @param sessionText
	 *            the sessionText to set
	 * @uml.property name="sessionText"
	 */
	public void setSessionText(String sessionText) {
		this.sessionText = sessionText;
	}

	/**
	 * @return the studentNotes
	 * @uml.property name="studentNotes"
	 */
	public String getStudentNotes() {
		return studentNotes;
	}

	/**
	 * @param studentNotes
	 *            the studentNotes to set
	 * @uml.property name="studentNotes"
	 */
	public void setStudentNotes(String studentNotes) {
		this.studentNotes = studentNotes;
	}

	/**
	 * @return the advisorNotes
	 * @uml.property name="advisorNotes"
	 */
	public String getAdvisorNotes() {
		return advisorNotes;
	}

	/**
	 * @param advisorNotes
	 *            the advisorNotes to set
	 * @uml.property name="advisorNotes"
	 */
	public void setAdvisorNotes(String advisorNotes) {
		this.advisorNotes = advisorNotes;
	}

	/**
	 * @return the selectedSlotNumber
	 * @uml.property name="selectedSlotNumber"
	 */
	public Integer getSelectedSlotNumber() {
		return selectedSlotNumber;
	}

	/**
	 * @param selectedSlotNumber
	 *            the selectedSlotNumber to set
	 * @uml.property name="selectedSlotNumber"
	 */
	public void setSelectedSlotNumber(Integer selectedSlotNumber) {
		this.selectedSlotNumber = selectedSlotNumber;
	}

	/**
	 * @return the selectedSlotDate
	 * @uml.property name="selectedSlotDate"
	 */
	public Date getSelectedSlotDate() {
		return selectedSlotDate;
	}

	/**
	 * @param selectedSlotDate
	 *            the selectedSlotDate to set
	 * @uml.property name="selectedSlotDate"
	 */
	public void setSelectedSlotDate(Date selectedSlotDate) {
		this.selectedSlotDate = selectedSlotDate;
	}

	/**
	 * @return the slotStatus
	 * @uml.property name="slotStatus"
	 */
	public String getSlotStatus() {
		return slotStatus;
	}

	/**
	 * @param slotStatus
	 *            the slotStatus to set
	 * @uml.property name="slotStatus"
	 */
	public void setSlotStatus(String slotStatus) {
		this.slotStatus = slotStatus;
	}

	public List<AdvisingSessionSlot> getAdvisingSessionSlotList() {
		System.out.println("Calling getAdvisingSessionSlotList() ");

		advisingSessionSlotList = new ArrayList<AdvisingSessionSlot>(0);

		if (this.getSelectedAdvisor() == null
				|| this.getSelectedAdvisor().getUserid() == "") {
			this.setSelectedAdvisor(this.getCurrentAdvisor());
		}
		// make sure they have selected an advisor
		if (this.getSelectedAdvisor() != null
				&& this.getSelectedAdvisor().getUserid() != "") {

			// get a list of ALL the advisors slots
			advisingSessionSlotList = (ArrayList<AdvisingSessionSlot>) this
					.getAdvisingManagementBean()
					.getAvailableAdvisingSessionSlotList(
							this.getSelectedAdvisor(), false);
			if (advisingSessionSlotList.size() < 1) {
				return advisingSessionSlotList;
			}
			// an attempt to sort by start time
			Collections.sort(advisingSessionSlotList, new Comparator<Object>() {
				public int compare(Object o1, Object o2) {
					AdvisingSessionSlot a1 = (AdvisingSessionSlot) o1;
					AdvisingSessionSlot a2 = (AdvisingSessionSlot) o2;

					DateFormat formatter;
					Date date1, date2;
					formatter = new SimpleDateFormat("EEEE, MMMM d, yyyy hh:mm aaa");
					try {
						date1 = (Date) formatter.parse(a1.toString());
						date2 = (Date) formatter.parse(a2.toString());

						return date1.compareTo((date2));
					} catch (ParseException e) {
						e.printStackTrace();
					}

					return 0;
				}
			});
		}
		return advisingSessionSlotList;
	}

	public List<AdvisingSessionSlot> getStudentAdvisingSessionSlotList() throws ParseException {
		
		List<AdvisingSessionSlot> studentSlotList = new ArrayList<AdvisingSessionSlot>();
		
		// 24 Hour rule for students -> Student can not schedule an advising appointments less then 24 hours before slot time.
		for(AdvisingSessionSlot advisingSessionSlot : studentAdvisingSessionSlotList){
			Date sessionDate = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm aaa", Locale.ENGLISH).parse(advisingSessionSlot.toString());
			if(sessionDate.after(dateRestriction)){
				studentSlotList.add(advisingSessionSlot);
			}
		}
		
		studentAdvisingSessionSlotList = studentSlotList;
		
		return studentAdvisingSessionSlotList;
	}

	public void setAdvisingSessionSlotList(ArrayList<AdvisingSessionSlot> advisingSessionSlotList) {
		this.advisingSessionSlotList = advisingSessionSlotList;
	}

	public Boolean[][] getSelectedCheckboxArray() {
		return selectedCheckboxArray;
	}

	public void setSelectedCheckboxArray(Boolean[][] selectedCheckboxArray) {
		this.selectedCheckboxArray = selectedCheckboxArray;
	}

	public Boolean[][] getDisabledCheckboxArray() {
		return disabledCheckboxArray;
	}

	public void setDisabledCheckboxArray(Boolean[][] disabledCheckboxArray) {
		this.disabledCheckboxArray = disabledCheckboxArray;
	}

	public String[] getWeekDays() {
		return weekDays;
	}

	public void setScannedID(String scannedID) {
		this.scannedID = scannedID;
	}

	/**
	 * @return the scannedID
	 * @uml.property name="scannedID"
	 */
	public String getScannedID() {
		return scannedID;
	}

	/**
	 * @param weekDays the weekDays to set
	 * @uml.property name="weekDays"
	 */
	public void setWeekDays(String[] weekDays) {
		this.weekDays = weekDays;
	}

	/**
	 * @return the selectedAdvisingSession
	 * @uml.property name="selectedAdvisingSession"
	 */
	public AdvisingSession getSelectedAdvisingSession() {
		return selectedAdvisingSession;
	}

	/**
	 * @param selectedAdvisingSession
	 *            the selectedAdvisingSession to set
	 * @uml.property name="selectedAdvisingSession"
	 */
	public void setSelectedAdvisingSession(
			AdvisingSession selectedAdvisingSession) {
		this.selectedAdvisingSession = selectedAdvisingSession;
	}

	/**
	 * @return the selectedSessionDate
	 * @uml.property name="selectedSessionDate"
	 */
	public Date getSelectedSessionDate() {
		return selectedSessionDate;
	}

	/**
	 * @param selectedSessionDate
	 *            the selectedSessionDate to set
	 * @uml.property name="selectedSessionDate"
	 */
	public void setSelectedSessionDate(Date selectedSessionDate) {
		this.selectedSessionDate = selectedSessionDate;
	}

	/**
	 * @return the selectedStartSessionDate
	 */
	public Date getSelectedStartSessionDate() {
		return selectedStartSessionDate;
	}

	/**
	 * @return the selectedEndSessionDate
	 */
	public Date getSelectedEndSessionDate() {
		return selectedEndSessionDate;
	}

	/**
	 * @param selectedStartSessionDate
	 *            the selectedStartSessionDate to set
	 */
	public void setSelectedStartSessionDate(Date selectedStartSessionDate) {
		this.selectedStartSessionDate = selectedStartSessionDate;
	}

	/**
	 * @param selectedEndSessionDate
	 *            the selectedEndSessionDate to set
	 */
	public void setSelectedEndSessionDate(Date selectedEndSessionDate) {
		this.selectedEndSessionDate = selectedEndSessionDate;
	}

	/**
	 * @return the dataModel
	 * @uml.property name="dataModel"
	 */
	public ExtendedTableDataModel<AdvisingSession> getDataModel() {
		return dataModel;
	}

	/**
	 * @param dataModel
	 *            the dataModel to set
	 * @uml.property name="dataModel"
	 */
	public void setDataModel(ExtendedTableDataModel<AdvisingSession> dataModel) {
		this.dataModel = dataModel;
	}

	/**
	 * @return the tableState
	 * @uml.property name="tableState"
	 */
	public Object getTableState() {
		return tableState;
	}

	/**
	 * @param tableState
	 *            the tableState to set
	 * @uml.property name="tableState"
	 */
	public void setTableState(Object tableState) {
		this.tableState = tableState;
	}

	/**
	 * @return the selection
	 * @uml.property name="selection"
	 */
	public SimpleSelection getSelection() {
		return selection;
	}

	/**
	 * @param selection
	 *            the selection to set
	 * @uml.property name="selection"
	 */
	public void setSelection(SimpleSelection selection) {
		this.selection = selection;
	}

	/**
	 * @return the advisorsOptions
	 */
	public List<SelectItem> getAdvisorsOptions() {
		List<Advisor> advisors = this.getActiveAdvisorList();
		List<SelectItem> sItems = new ArrayList<SelectItem>();
		for (Advisor advisor : advisors) {
			System.out.println(advisor.getUserid() + " " + advisor);			
			SelectItem sItem = new SelectItem(advisor, advisor.getShortDesc());				
			sItems.add(sItem);		
		}
		return sItems;
	}

	/**
	 * @return the activeAdvisorList
	 */
	public ArrayList<Advisor> getActiveAdvisorList() {

		ArrayList<Advisor> activeAdvisorList = new ArrayList<Advisor>(0);
		List<Advisor> fullAdvisorList = this.getAdvisingManagementBean()
				.getAdvisorList();

		for (Advisor advisor : fullAdvisorList) {
			if (advisor.getStatus().equals("ACTIVE")) {
				activeAdvisorList.add(advisor);
			}
		}

		return activeAdvisorList;
	}

	public List<SelectItem> getAdvisorSelectItemList() {
		
		// Check if current user is a student, Set advisorTreeSelectItems to their advisor only if user type == stu
		User currentUser = getConfigurationManager().getUser();		
		for(UserCollegeProfile userCollegeProfile : getAdvisingManagementBean().getUserCollegeProfiles(currentUser)){			
			if(userCollegeProfile.getUserType().getTypeCode().equals("STU")){				
				for(Advisor advisor : getActiveAdvisorList()){					
					for(UserProgramProfile userProgramProfile : getAdvisingManagementBean().getUserProgramProfiles(currentUser)){						
						if(userProgramProfile.getAdvisor().equals(advisor)){					
							advisorTreeSelectItems = new ArrayList<SelectItem>(0);
							advisorTreeSelectItems.add(new SelectItem(advisor, advisor.getShortDesc()));													
						}						
					}					
				}					
			}			
		}			
		
		// Final List
		if (advisorTreeSelectItems != null && advisorTreeSelectItems.size() > 0) {
			return advisorTreeSelectItems;
		}

		SelectItemGroup advisorGroupSelectItem = null;
		
		// Group Level Advisor SelectItems
		List<SelectItem> advisorSelectItems = new ArrayList<SelectItem>(0);
		List<AdvisorGroup> advisorGroups = this.getAdvisingManagementBean()
				.getAdvisorGroupList();
		Set<Advisor> advisors = null;
		List<Advisor> activeAdvisorList = this.getActiveAdvisorList();
		
		// List to maintain Unsorted Advisors
		List<Advisor> advisorList = new ArrayList<Advisor>(0);
		for (int i = 0; i < activeAdvisorList.size(); i++) {
			advisorList.add(activeAdvisorList.get(i));
		}
		
		Advisor advisor = null;
		AdvisorGroup advisorGroup = null;
		Iterator<AdvisorGroup> iter = advisorGroups.iterator();
		Iterator<Advisor> iter1 = null;
		Iterator<Advisor> iter2 = null;
		
		while (iter.hasNext()) {
			
			advisorGroup = iter.next();
			advisorGroupSelectItem = new SelectItemGroup(advisorGroup.getName());
			advisors = advisorGroup.getAdvisors();
			iter1 = advisors.iterator();
			while (iter1.hasNext()) {
				advisor = iter1.next();
				advisorSelectItems.add(new SelectItem(advisor, advisor
						.getShortDesc()));
				advisorList.remove(advisor);
			}
			advisorGroupSelectItem.setSelectItems(advisorSelectItems
					.toArray(new SelectItem[0]));
			advisorTreeSelectItems.add(advisorGroupSelectItem);
			advisorSelectItems.clear();
			
		}
		
		if (advisorList.size() > 0) {
			iter2 = advisorList.iterator();
			advisorGroupSelectItem = new SelectItemGroup("Unsorted");
			while (iter2.hasNext()) {
				advisor = iter2.next();
				advisorSelectItems.add(new SelectItem(advisor, advisor
						.getShortDesc()));
			}
			advisorGroupSelectItem.setSelectItems(advisorSelectItems
					.toArray(new SelectItem[0]));
			advisorTreeSelectItems.add(advisorGroupSelectItem);
		}
		
		return advisorTreeSelectItems;
		
	}

	/**
	 * @return the selectedAdvisorList
	 * @uml.property name="selectedAdvisorList"
	 */
	public List<Advisor> getSelectedAdvisorList() {
		return selectedAdvisorList;
	}

	/**
	 * @param selectedAdvisorList
	 *            the selectedAdvisorList to set
	 * @uml.property name="selectedAdvisorList"
	 */
	public void setSelectedAdvisorList(List<Advisor> selectedAdvisorList) {
		this.selectedAdvisorList = selectedAdvisorList;
	}

	public ExtendedTableDataModel<AdvisingSession> getEMSAdvisingSessionDataModel() {

		System.out.println("Calling getEMSAdvisingSessionDataModel");
		User user = this.getConfigurationManager().getSelectedUser();
		if (user == null) {
			user = this.getUserManager().getUser();
		}
		System.out.println("Current User: " + user.getFullName());
		final List<AdvisingSession> userSessions = this
				.getAdvisingManagementBean().getAdvisingSessionList(user);
		System.out.println("Total Appts: " + userSessions.size());
		// an attempt to sort by start time
		Collections.sort(userSessions, new Comparator<Object>() {

			public int compare(Object o1, Object o2) {
				AdvisingSession a1 = (AdvisingSession) o1;
				AdvisingSession a2 = (AdvisingSession) o2;
				return a1.getStartTime().compareTo((a2.getStartTime()));
			}

		});
		Collections.reverse(userSessions);

		this.setDataModel(new ExtendedTableDataModel<AdvisingSession>(
				new DataProvider<AdvisingSession>() {

					private static final long serialVersionUID = 5054087821033164847L;

					public AdvisingSession getItemByKey(Object key) {
						for (AdvisingSession a : userSessions) {
							if (key.equals(getKey(a))) {
								return a;
							}
						}
						return null;
					}

					public List<AdvisingSession> getItemsByRange(int firstRow,
							int endRow) {
						return userSessions.subList(firstRow, endRow);
					}

					public Object getKey(AdvisingSession item) {
						return item.getAdvisingSessionID();
					}

					public int getRowCount() {
						return userSessions.size();
					}

				}));
		this.getDataModel().setRowIndex(-1);
		System.out.println("Total Appts: " + userSessions.size());
		return this.getDataModel();
	}

	public ExtendedTableDataModel<AdvisingSession> getUserAdvisingSessionDataModel() {
		System.out.println("Calling getUserAdvisingSessionDataModel");
		final List<AdvisingSession> userSessions = this
				.getAdvisingManagementBean().getAdvisingSessionList(
						this.getUserManager().getUser());
		// an attempt to sort by start time
		Collections.sort(userSessions, new Comparator<Object>() {

			public int compare(Object o1, Object o2) {
				AdvisingSession a1 = (AdvisingSession) o1;
				AdvisingSession a2 = (AdvisingSession) o2;
				return a1.getStartTime().compareTo((a2.getStartTime()));
			}

		});
		Collections.reverse(userSessions);

		this.setDataModel(new ExtendedTableDataModel<AdvisingSession>(
				new DataProvider<AdvisingSession>() {

					private static final long serialVersionUID = 5054087821033164847L;

					public AdvisingSession getItemByKey(Object key) {
						for (AdvisingSession a : userSessions) {
							if (key.equals(getKey(a))) {
								return a;
							}
						}
						return null;
					}

					public List<AdvisingSession> getItemsByRange(int firstRow,
							int endRow) {
						return userSessions.subList(firstRow, endRow);
					}

					public Object getKey(AdvisingSession item) {
						return item.getAdvisingSessionID();
					}

					public int getRowCount() {
						System.out.println("Total user session rows: "
								+ userSessions.size());
						return userSessions.size();
					}

				}));
		this.getDataModel().setRowIndex(-1);
		return this.getDataModel();
	}

	public ExtendedTableDataModel<AdvisingSession> getMyCalendarDataModel() {
		System.out.println("Calling MyCalendarDataModel");

		advisorSessions = this.getAdvisingManagementBean()
				.getAdvisingSessionListForDay(currentAdvisor,
						this.getSelectedDate());
		// this.setSelection(new SimpleSelection());
		this.setDataModel(new ExtendedTableDataModel<AdvisingSession>(
				new DataProvider<AdvisingSession>() {

					private static final long serialVersionUID = 5054087821033164847L;

					public AdvisingSession getItemByKey(Object key) {
						for (AdvisingSession a : advisorSessions) {
							if (key.equals(getKey(a))) {
								return a;
							}
						}
						return null;
					}

					public List<AdvisingSession> getItemsByRange(int firstRow,
							int endRow) {
						return advisorSessions.subList(firstRow, endRow);
					}

					public Object getKey(AdvisingSession item) {
						return item.getAdvisingSessionID();
					}

					public int getRowCount() {
						return advisorSessions.size();
					}

				}));

		return this.getDataModel();
	}

	public ExtendedTableDataModel<AdvisingSession> getSelectedAdvisorsAdvisingSessionDataModel() {
		System.out.println("getOtherAdvisorsAdvisingSessionDataModel()");
		final List<AdvisingSession> advisorSessions;

		// display sessions for the selected date and selected advisors
		advisorSessions = this.getAdvisingManagementBean()
				.getAdvisingSessionListForDays(this.getSelectedAdvisorList(),
						this.getSelectedStartSessionDate(),
						this.getSelectedEndSessionDate());

		this.setSelection(new SimpleSelection());
		this.setDataModel(new ExtendedTableDataModel<AdvisingSession>(
				new DataProvider<AdvisingSession>() {

					private static final long serialVersionUID = 5054087821033164847L;

					public AdvisingSession getItemByKey(Object key) {
						for (AdvisingSession a : advisorSessions) {
							if (key.equals(getKey(a))) {
								return a;
							}
						}
						return null;
					}

					public List<AdvisingSession> getItemsByRange(int firstRow,
							int endRow) {
						return advisorSessions.subList(firstRow, endRow);
					}

					public Object getKey(AdvisingSession item) {
						return item.getAdvisingSessionID();
					}

					public int getRowCount() {
						return advisorSessions.size();
					}

				}));

		return this.getDataModel();
	}

	/*
	 * public ExtendedTableDataModel<AdvisingSession>
	 * getSelectedAdvisorsAdvisingSessionDataModel_Backup() {
	 * System.out.println("getOtherAdvisorsAdvisingSessionDataModel()");
	 * 
	 * final List<AdvisingSession> advisorSessions;
	 * 
	 * // display sessions for the selected date and selected advisors
	 * advisorSessions = this.getAdvisingManagementBean()
	 * .getAdvisingSessionListForDay(this.getSelectedAdvisorList(),
	 * this.getSelectedSessionDate());
	 * 
	 * // an attempt to sort by start time Collections.sort(advisorSessions, new
	 * Comparator<Object>() {
	 * 
	 * public int compare(Object o1, Object o2) { AdvisingSession a1 =
	 * (AdvisingSession) o1; AdvisingSession a2 = (AdvisingSession) o2; return
	 * a1.getStartTime().compareTo((a2.getStartTime())); }
	 * 
	 * }); Collections.reverse(advisorSessions);
	 * 
	 * this.setSelection(new SimpleSelection()); this.setDataModel(new
	 * ExtendedTableDataModel<AdvisingSession>( new
	 * DataProvider<AdvisingSession>() {
	 * 
	 * private static final long serialVersionUID = 5054087821033164847L;
	 * 
	 * public AdvisingSession getItemByKey(Object key) { for (AdvisingSession a
	 * : advisorSessions) { if (key.equals(getKey(a))) { return a; } } return
	 * null; }
	 * 
	 * public List<AdvisingSession> getItemsByRange(int firstRow, int endRow) {
	 * return advisorSessions.subList(firstRow, endRow); }
	 * 
	 * public Object getKey(AdvisingSession item) { return
	 * item.getAdvisingSessionID(); }
	 * 
	 * public int getRowCount() { return advisorSessions.size(); }
	 * 
	 * }));
	 * 
	 * return this.getDataModel(); }
	 */

	/**
	 * @return the subject
	 * @uml.property name="subject"
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 * @uml.property name="subject"
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the message
	 * @uml.property name="message"
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 * @uml.property name="message"
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the model
	 * @uml.property name="model"
	 */
	public ScheduleModel getModel() {

		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 * @uml.property name="model"
	 */
	public void setModel(ScheduleModel model) {
		this.model = model;
	}

	public Date getSelectedDate() {
		return this.getModel().getSelectedDate();
	}

	public void setSelectedDate(Date date) {
		System.out.println("Set Selected Date function called. "
				+ date.toString() + " from "
				+ this.getModel().getSelectedDate().toString());

		// Check whether a new month is selected
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		int new_code = calendar.get(Calendar.MONTH)
				+ calendar.get(Calendar.YEAR);
		if (this.getCurrentView().equals("SCHEDULE")) {
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			this.setSelectedStartSessionDate(calendar.getTime());
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			this.setSelectedEndSessionDate(calendar.getTime());
		}
		Calendar currentCalendar = GregorianCalendar.getInstance();
		currentCalendar.setTime(this.getModel().getSelectedDate());
		int current_code = currentCalendar.get(Calendar.MONTH)
				+ currentCalendar.get(Calendar.YEAR);
		// Update the selectedDate in the Calendar model
		this.getModel().setSelectedDate(date);
		// Check whether new month has been selected
		if (new_code != current_code) {
			System.out.println("New month selected");

			// Clear the selected appointment
			this.setSelectedAdvisingSession(null);
			if (this.getModel() != null) {
				this.getModel().setSelectedEntry(null);
			}
			if (this.getAgendaTable() != null) {
				this.getAgendaTable().setActiveRowKey(null);
				this.getSelection().clear();
				this.getAgendaTable().setSelection(getSelection());
			}
			this.setAppointmentSelected(false);
			if (this.getCurrentView().equals("SCHEDULE")
					|| this.getCurrentView().equals("AGENDA")) {
				this.setAppointmentSelected(true);
			}

			// Clear the stale data
			this.setSelectedSessionType(null);
			this.setSessionStatus(null);
			this.setPreSessionText(null);
			this.setSessionText(null);
			this.setStudentNotes(null);
			this.setAdvisorNotes(null);
			this.setNotifyChanges(false);

			this.addExistingAdvisingSessions();
		}
	}

	public String getInitMyCalendar() {
		System.out.println("Initializing myCalendar model: " + this.model);
		if (this.getCurrentAdvisor() != null) {
			System.out.println("Found a valid advisor configuration");
			this.setUserRole("ADVISOR");
		}

		if (this.getUserRole() == "ADVISOR") {
			if (this.getModel() != null) {
				if (this.getModel().getMode() < 0
						|| this.getCurrentView() == null) {
					// TODO: load the user-preferred/user-defined view
					// for the currentView field & mycalendarMode
					this.getModel().setMode(0);
					this.setCurrentView("DAY");
					this.getModel().refresh();
				}
				this.setAppointmentSelected(false);
				if (this.getModel().isEntrySelected()) {
					this.setAppointmentSelected(true);
				}
				addExistingAdvisingSessions();
			}
		} else {
			this.setCurrentView("SCHEDULE");
			this.setAppointmentSelected(true);
		}
		return "";
	}

	public void showAppointmentSlots(ActionEvent event) {
		this.setCurrentView("SLOT");
		this.valueChangeSelectedWeek(null);
		this.setAppointmentSelected(false);
		return;
	}

	/**
	 * @return the displayDay
	 */
	public void showDay(ActionEvent event) {
		this.getModel().setMode(0);
		this.setCurrentView("DAY");
		this.getModel().refresh();
		this.setAppointmentSelected(false);
		if (this.getModel().isEntrySelected()) {
			this.setAppointmentSelected(true);
		}
		return;
	}

	/**
	 * @return the displayWorkWeek
	 */
	public void showWorkWeek(ActionEvent event) {
		this.getModel().setMode(1);
		this.setCurrentView("WORKWEEK");
		this.getModel().refresh();
		this.setAppointmentSelected(false);
		if (this.getModel().isEntrySelected()) {
			this.setAppointmentSelected(true);
		}
		return;
	}

	/**
	 * @return the displayWeek
	 */
	public void showWeek(ActionEvent event) {
		this.getModel().setMode(2);
		this.setCurrentView("WEEK");
		this.getModel().refresh();
		this.setAppointmentSelected(false);
		if (this.getModel().isEntrySelected()) {
			this.setAppointmentSelected(true);
		}
		return;
	}

	/**
	 * @return the displayMonth
	 */
	public void showMonth(ActionEvent event) {
		this.getModel().setMode(3);
		this.setCurrentView("MONTH");
		this.getModel().refresh();
		this.setAppointmentSelected(false);
		if (this.getModel().isEntrySelected()) {
			this.setAppointmentSelected(true);
		}
		return;
	}

	/**
	 * @return the displayAgenda
	 */
	public void showAgenda(ActionEvent event) {
		this.setCurrentView("AGENDA");
		// Required for the datatable view
		// TODO: Datalist View
		this.setAppointmentSelected(true);
		/*
		 * if (this.getTable() != null && this.getTable().getActiveRowKey() !=
		 * null) { this.setAppointmentSelected(true); }
		 */
		return;
	}

	public void showAdvisorSchedules(ActionEvent event) {
		this.setCurrentView("SCHEDULE");
		this.setAppointmentSelected(true);
		return;
	}

	public void initCalendarView(PhaseEvent event) {

	}

	// Loads current month's Advising Sessions for this Advisor to calendar
	public void addExistingAdvisingSessions() {
		System.out.print("Add advising Appointments for the current month: ");
		if (this.getModel() == null) {
			System.out.println("(error) Model is null");
			return;
		}
		System.out.println(this.getModel().getSelectedDate());
		// TODO: Add the fetched AdvisingSessions to a HashTable if its not
		// available
		List<AdvisingSession> advisingsessions = this
				.getAdvisingManagementBean().getAdvisingSessionList(
						this.getCurrentAdvisor(),
						this.getModel().getSelectedDate());
		Iterator<AdvisingSession> iter = advisingsessions.iterator();
		while (iter.hasNext()) {
			AdvisingSession advisingsession = iter.next();
			this.getModel().addEntry(advisingsession);
		}
		this.getModel().refresh();
	}

	public String myCalendarAction() {
		System.out.println("Calling myCalendarAction function");
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();

		if (this.getModel() == null) {
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("[" + new Date() + "] Invalid Calendar Model.");
			context.addMessage("msg", message);
			return null;
		}
		System.out.println("Selected entry: "
				+ this.getModel().getSelectedEntry());

		// Clear the Agenda selections
		this.getSelection().clear();
		if (this.getAgendaTable() != null) {
			this.getAgendaTable().setActiveRowKey(null);
			this.getAgendaTable().setSelection(getSelection());
		}
		// Assign the selected entry to the Selected Appointment and
		// TODO: Open the Edit Appt popup window
		ScheduleEntry selectedEntry = null;
		this.setAppointmentSelected(false);
		if (this.getModel().isEntrySelected()) {
			selectedEntry = this.getModel().getSelectedEntry();
			if (selectedEntry != null) {
				this.setAppointmentSelected(true);
				this.getSelection().addKey(selectedEntry.getId());
				if (this.getAgendaTable() != null) {
					this.getAgendaTable()
							.setActiveRowKey(selectedEntry.getId());
					this.getAgendaTable().setSelection(getSelection());
				}
			}
		}
		return null;
	}

	public void scheduleClicked(ScheduleMouseEvent event) {
		System.out.println("Calling scheduleClicked function");
		if (this.getModel() == null) {
			System.out.println("Error: No calendar/schedule model found");
		}
		switch (event.getEventType()) {
		case ScheduleMouseEvent.SCHEDULE_BODY_CLICKED:
			System.out.println("Schedule Body Clicked");
			break;
		case ScheduleMouseEvent.SCHEDULE_HEADER_CLICKED:
			// Create a new appointment for that date
			System.out.println("Schedule Header Clicked");
			break;
		case ScheduleMouseEvent.SCHEDULE_ENTRY_CLICKED:
			System.out.println("Schedule Entry Clicked");
			break;
		default:
			System.out.println("No registered event found");
		}

	}

	public String cancelAdvisingSession() {
		System.out.println("Calling cancelAdvisingSession");

		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getSelectedAdvisingSession() != null
				&& this.getSelectedAdvisingSession().getAdvisingSessionID() != null) {

			if (this.getSelectedAdvisingSession().getAdvisingSessionSlot() != null) {
				if (apptReason != null && apptReason.trim() != "") {
					this.getSelectedAdvisingSession()
							.setSessionText(
									this.getSelectedAdvisingSession()
											.getSessionText()
											+ "<br/><hr/>Reason (Status: Cancelled):<br/>"
											+ apptReason);
				}
				AdvisingSession advisingSession = this
						.getAdvisingManagementBean().cancelAdvisingSession(
								this.getSelectedAdvisingSession());
				// No extra time constraint imposed
				if (advisingSession == null) {
					message.setSeverity(FacesMessage.SEVERITY_ERROR);
					message.setSummary("[" + new Date()
							+ "] Oops!: Cannot cancel advising appointment.");

					context.addMessage("msg", message);
				} else {
					message.setSeverity(FacesMessage.SEVERITY_INFO);
					message.setSummary("[" + new Date()
							+ "] Advising appointment cancelled successfully.");
					context.addMessage("msg", message);
					this.cancelReminderEmail(advisingSession.getUser(),
							advisingSession.getAdvisingSessionSlot());
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>"
							+ advisingSession.getSessionStatus());
					// Update the calendar model
					if (this.getModel() != null) {
						if (this.getModel().isEntrySelected()) {
							this.getModel().setSelectedEntry(null);
						}
						this.getModel().removeEntry(
								this.getSelectedAdvisingSession());
						this.getModel().addEntry(advisingSession);
						this.getModel().setSelectedEntry(advisingSession);
						this.getModel().refresh();
					}
				}
				this.setSelectedAdvisingSession(advisingSession);

			} else {
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary("["
						+ new Date()
						+ "] The selected advising appointment is already cancelled.");
				context.addMessage("msg", message);
			}
		} else {
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("[" + new Date()
					+ "] No advising appointment selected.");
			context.addMessage("msg", message);
		}
		return null;
	}

	public String cancelAdvisingSessionWithTimeConstraint() {
		System.out.println("Calling cancelAdvisingSessionWithTimeConstraint");

		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();

		if (this.getSelectedAdvisingSession() != null
				&& this.getSelectedAdvisingSession().getAdvisingSessionID() != null) {

			if (this.getSelectedAdvisingSession().getAdvisingSessionSlot() != null) {

				// calcuate the appropriate time constraint
				Calendar cal = new GregorianCalendar();
				cal.setTime(getSelectedAdvisingSession().getSessionDate());
				// 5pm the previous day
				cal.add(Calendar.DAY_OF_MONTH, -1);
				cal.set(Calendar.AM_PM, Calendar.PM);
				cal.set(Calendar.HOUR, 5);
				cal.set(Calendar.MINUTE, 0);
				// two days before that
				// Changed to One day before as per the request (Keerti)
				cal.add(Calendar.DAY_OF_MONTH, -1);

				System.out.println("Today is: " + new Date());
				System.out
						.println("One day before 5pm the day before the session is: "
								+ cal.getTime());

				// is today before the last time allowed to cancel
				if (new Date().compareTo(cal.getTime()) < 0) {
					if (apptReason != null && apptReason.trim() != "") {
						this.getSelectedAdvisingSession()
								.setSessionText(
										this.getSelectedAdvisingSession()
												.getSessionText()
												+ "<br/><hr/>Reason (Status: Cancelled):<br/>"
												+ apptReason);
					}
					AdvisingSession advisingSessionToCancel = this.getSelectedAdvisingSession();
												
					AdvisingSession canceledAdvisingSession = 
							this.getAdvisingManagementBean().cancelAdvisingSession(advisingSessionToCancel);
					if (canceledAdvisingSession == null) {
						message.setSeverity(FacesMessage.SEVERITY_ERROR);
						message.setSummary("["
								+ new Date()
								+ "] Oops!: Cannot cancel advising appointment.");

						context.addMessage("msg", message);
					} else {
						message.setSeverity(FacesMessage.SEVERITY_INFO);
						message.setSummary("["
								+ new Date()
								+ "] Advising appointment cancelled successfully.");
						context.addMessage("msg", message);
												
						this.cancelReminderEmail(advisingSessionToCancel.getUser(),
								advisingSessionToCancel.getAdvisingSessionSlot());
					}
				} else {
					message.setSeverity(FacesMessage.SEVERITY_INFO);
					message.setSummary("["
							+ new Date()
							+ "] This appointment will have to be cancelled by phone. Please call Academic Services at (859) 257-7971.");
					context.addMessage("msg", message);
				}
			} else {
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary("["
						+ new Date()
						+ "] The selected advising appointment is already cancelled.");
				context.addMessage("msg", message);
			}
		} else {
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("[" + new Date()
					+ "] No advising appointment selected.");
			context.addMessage("msg", message);
		}
		return null;
	}

	public String createAdvisingSession() {
		System.out.println("Calling createAdvisingSession");

		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		FacesMessage message1 = new FacesMessage();

		// get the user object of the currently logged in user
		User user = this.getUserManager().getUser();

		// make sure they have selected an advisor and a slot
		if (this.getSelectedAdvisor() != null
		&& this.getSelectedAdvisor().getUserid() != null) {
			if (this.getSelectedAdvisingSessionSlot() != null
			&& this.getSelectedAdvisingSessionSlot().getId() != null) {
				
				List<AdvisingSession> advisingSessions = this.getAdvisingManagementBean().getAdvisingSessionList(user);
				
				// Check if current user is a student, if so then they can only schedule 1 active advising appointment at a time
				for(UserCollegeProfile userCollegeProfile : getAdvisingManagementBean().getUserCollegeProfiles(user)){
					
					if(userCollegeProfile.getUserType().getTypeCode().equals("STU")){
												
						int advisingSessionCount = 0;
					
						// Get the count of active advising sessions
						for(AdvisingSession advisingSession : advisingSessions){
							if(advisingSession.getSessionStatus().equals("Scheduled")){
								advisingSessionCount ++; 
							}						
						}	
						
						// Students are only allowed one active advising session at a time
						if (advisingSessionCount > MAX_DAILY_APPOINTMENTS) {
							message.setSeverity(FacesMessage.SEVERITY_WARN);
							message.setSummary("["
								+ new Date()
								+ "] You Can Only Have One Active Appointment At A Time. " 
								+ "If You Would Like To Schedule A Different Appointment Please " 
								+ "Cancel An Active Appointment First.");
							context.addMessage("msg", message);
							return null;				
						}						
					}
				}
				
				
											
				// attempt to create the advising session
				if (!this.getAdvisingManagementBean().addAdvisingSession(user,
						this.getSelectedAdvisor(),
						this.getSelectedAdvisingSessionSlot(),
						this.getSelectedSessionType(), "Scheduled",
						this.getPreSessionText(), "", "", "")) {
					message.setSeverity(FacesMessage.SEVERITY_ERROR);
					message.setSummary("["
							+ new Date()
							+ "] Oops!: Couldn't schedule advising appointment. Please try a different time.");
					context.addMessage("msg", message);
				} else {
					message.setSeverity(FacesMessage.SEVERITY_INFO);
					message.setSummary("[" + new Date()
							+ "] Advising appointment scheduled successfully.");
					context.addMessage("msg", message);

					// Send confirmation email
					String location = this.getAdvisingManagementBean()
							.getAppointmentLocation(this.getSelectedAdvisor());
					if (this.sendConfirmationEmail(this.getUserManager()
							.getUser(), this.getSelectedAdvisingSessionSlot(),
							this.getSelectedAdvisor(), location)) {
						message1.setSeverity(FacesMessage.SEVERITY_INFO);
						message1.setSummary("["
								+ new Date()
								+ "] You will receive a confirmation mail via your UK email address.");
						context.addMessage("msg", message1);

						// Set Reminder email
						// calcuate the appropriate time constraint
						Calendar cal = new GregorianCalendar();
						cal.setTime(this.getSelectedAdvisingSessionSlot()
								.getSlotDate());
						// 3am the previous day to avoid traffic
						cal.add(Calendar.DAY_OF_MONTH, -1);
						cal.set(Calendar.AM_PM, Calendar.AM);
						cal.set(Calendar.HOUR, 3);
						cal.set(Calendar.MINUTE, 0);
						// one day before that
						cal.add(Calendar.DAY_OF_MONTH, -1);
						Calendar current = new GregorianCalendar();
						if (current.before(cal)) {
							System.out.println("Setting reminder email for "
									+ this.getUserManager().getUser()
											.getFullName());
							this.scheduleReminderEmail(this.getUserManager()
									.getUser(), this
									.getSelectedAdvisingSessionSlot(), this
									.getSelectedAdvisor(), cal, location);
						}
					} else {
						message1.setSeverity(FacesMessage.SEVERITY_WARN);
						message1.setSummary("["
								+ new Date()
								+ "] You do not have a valid UK email address in your account."
								+ " Please go to the account manager to add your UK email address and to "
								+ "receive the confirmation email for your future appointments.");
						context.addMessage("msg", message1);
					}
					// Clear the values
					this.setSelectedAdvisor(null);
					this.setSelectedAdvisingSessionSlot(null);
					this.setSelectedSessionType(null);
					this.setPreSessionText(null);

				}
			} else {
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary("[" + new Date() + "] No timeslot selected.");
				context.addMessage("msg", message);
			}
		} else {
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("[" + new Date() + "] No advisor selected.");
			context.addMessage("msg", message);
		}

		return null;
	}

	public String createAdvisingSessionSelectedUser() {
		System.out.println("Calling createAdvisingSessionSelectedUser");

		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		FacesMessage message1 = new FacesMessage();

		// make sure they have selected a user,advisor and a slot
		if (this.getConfigurationManager().getSelectedUser() != null
				&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			
			User selectedUser = this.getConfigurationManager().getSelectedUser();
			
			if (this.getSelectedAdvisor() != null
					&& this.getSelectedAdvisor().getUserid() != null) {
				if (this.getSelectedAdvisingSessionSlot() != null
						&& this.getSelectedAdvisingSessionSlot().getId() != null) {
					List<AdvisingSession> advisingSessions = this
							.getAdvisingManagementBean()
							.getAdvisingSessionList(
									selectedUser,
									this.getSelectedAdvisingSessionSlot()
											.getSlotDate());
					
					if( ! selectedUser.getUid().equals( PROSPECTIVE_UID ) ){
						
						if (advisingSessions.size() > MAX_DAILY_APPOINTMENTS) {
							message.setSeverity(FacesMessage.SEVERITY_WARN);
							message.setSummary("["
									+ new Date()
									+ "] This user already has an appointment ("
									+ advisingSessions.get(0).getSessionTime()
									+ ") with "
									+ advisingSessions.get(0).getAdvisor()
											.getShortDesc()
									+ " on the same day, please select another date.");
							context.addMessage("msg", message);
							return null;
						}						
					}
					
					
					
					// attempt to create the advising session
					if (!this.getAdvisingManagementBean().addAdvisingSession(
							this.getConfigurationManager().getSelectedUser(), this.getSelectedAdvisor(),
							this.getSelectedAdvisingSessionSlot(),
							this.getSelectedSessionType(), "Scheduled",
							this.getPreSessionText(), "", "", "")) {
						message.setSeverity(FacesMessage.SEVERITY_ERROR);
						message.setSummary("["
								+ new Date()
								+ "] Oops!: Couldn't schedule advising appointment. Please try a different time.");
						context.addMessage("msg", message);
					} else {

						String location = this.getAdvisingManagementBean()
								.getAppointmentLocation(
										this.getSelectedAdvisor());
						
						if(isSendConformationEmail()){
							if (this.sendConfirmationEmail(this.getConfigurationManager().getSelectedUser(),
									this.getSelectedAdvisingSessionSlot(),
									this.getSelectedAdvisor(), location)) {
								message1.setSeverity(FacesMessage.SEVERITY_INFO);
								message1.setSummary("["
										+ new Date()
										+ "] A confirmation email has been sent to the student's UK email address.");
								context.addMessage("msg", message1);
								// Set Reminder email
								// calcuate the appropriate time constraint
								Calendar cal = new GregorianCalendar();
								cal.setTime(this.getSelectedAdvisingSessionSlot()
										.getSlotDate());
								// 3am the previous day to avoid traffic
								cal.add(Calendar.DAY_OF_MONTH, -1);
								cal.set(Calendar.AM_PM, Calendar.AM);
								cal.set(Calendar.HOUR, 3);
								cal.set(Calendar.MINUTE, 0);
								// one day before that
								cal.add(Calendar.DAY_OF_MONTH, -1);
								Calendar current = new GregorianCalendar();
								if (current.before(cal)) {
									System.out
											.println("Setting reminder email for "
													+ this.getUserManager()
															.getUser()
															.getFullName());
									this.scheduleReminderEmail(
											this.getConfigurationManager().getSelectedUser(),
											this.getSelectedAdvisingSessionSlot(),
											this.getSelectedAdvisor(), cal,
											location);
								}
							} else {
								message1.setSeverity(FacesMessage.SEVERITY_WARN);
								message1.setSummary("["
										+ new Date()
										+ "] No valid UK email addresses (@uky.edu) found for "
										+ this.getConfigurationManager().getSelectedUser().getFullName()
										+ ". Please go to the account manager to add a valid UK email address for this user.");
								context.addMessage("msg", message1);
							}
						}
						
						setSendConformationEmail(true);
						
						message.setSeverity(FacesMessage.SEVERITY_INFO);
						message.setSummary("["
								+ new Date()
								+ "] Advising appointment scheduled successfully.");
						context.addMessage("msg", message);

						this.setSelectedAdvisor(null);
						this.setSelectedAdvisingSessionSlot(null);
						this.setSelectedSessionType(null);
						this.setPreSessionText(null);
						this.getConfigurationManager().setSelectedUser(null);

					}
				} else {
					message.setSeverity(FacesMessage.SEVERITY_ERROR);
					message.setSummary("[" + new Date()
							+ "] No timeslot selected.");
					context.addMessage("msg", message);
				}
			} else {
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary("[" + new Date() + "] No advisor selected.");
				context.addMessage("msg", message);
			}
		} else {
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("[" + new Date() + "] No user selected.");
			context.addMessage("msg", message);
		}

		return null;
	}

	public void createAdvisingSessionSlots(ActionEvent event) {

		System.out.println("Calling createAdvisingSessionSlots");

		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getSelectedDate() == null) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] Please select a week.");
			context.addMessage("msg", message);
			return;
		}

		// make sure they have a valid advisor object
		if (currentAdvisor != null && currentAdvisor.getUserid() != null) {

			Boolean existingSlots[][] = new Boolean[5][16];
			
			Arrays.fill(existingSlots[0], false);
			Arrays.fill(existingSlots[1], false);
			Arrays.fill(existingSlots[2], false);
			Arrays.fill(existingSlots[3], false);
			Arrays.fill(existingSlots[4], false);

			Calendar cal = Calendar.getInstance();
			
			cal.setFirstDayOfWeek(Calendar.SUNDAY);

			// get the existing slots for the selected advisor in selected week
			
			List<AdvisingSessionSlot> weekAdvisingSessionSlotList = this
					.getAdvisingManagementBean().getAdvisingSessionSlotList(
							currentAdvisor, this.getSelectedDate());

			Iterator<AdvisingSessionSlot> iter = weekAdvisingSessionSlotList.iterator();

			// delete available slots that are no longer checked
			
			while (iter.hasNext()) {
				AdvisingSessionSlot advisingsessionslot = iter.next();

				if (advisingsessionslot.getStatus().equals("Available")) {
					
					// get the day of the week and the slot number
					
					cal.setTime(advisingsessionslot.getSlotDate());
					
					// Monday is day 2 in Java but we need 0 as index
					
					int weekday = cal.get(Calendar.DAY_OF_WEEK) - 2;
					int slotNumber = advisingsessionslot.getSlotNumber() - 1;

					// remember that this slots exists
					
					existingSlots[weekday][slotNumber] = true;

					// if the slot is no longer checked
					
					if (this.getSelectedCheckboxArray()[weekday][slotNumber] == false) {
						
						System.out.println("REMOVE weekday: " + weekday	+ " slotNum: " + slotNumber);
						
						// delete the slot
						
						this.getAdvisingManagementBean().removeAdvisingSessionSlot(
							currentAdvisor,advisingsessionslot);
					}
				}
			}

			// add selected slots, skipping existing slots
			cal.setTime(this.getSelectedDate());

			// supposed to set the calendar date to the Sunday that started the
			// week
			final int currentDayOfWeek = (cal.get(Calendar.DAY_OF_WEEK) + 7 - cal
					.getFirstDayOfWeek()) % 7;
			cal.add(Calendar.DAY_OF_YEAR, -currentDayOfWeek);

			System.out.println(cal.getTime());

			for (int i = 0; i < 5; i++) { // 5 days
				cal.add(Calendar.DATE, 1);
				for (int j = 0; j < 16; j++) { // 16 slots
					if (this.getSelectedCheckboxArray()[i][j] == true
							&& existingSlots[i][j] == false) {
						int slotNumber = j + 1;
						System.out.println("ADDING weekday: " + cal.getTime()
								+ "slotNum: " + slotNumber);
						// add the slot
						this.getAdvisingManagementBean()
								.addAdvisingSessionSlotToAdvisor(
										currentAdvisor, slotNumber,
										cal.getTime(), "Available");
					}
				}
			}
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("[" + new Date()
					+ "] Slots added/updated successfully.");
			context.addMessage("msg", message);
		} else {
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("[" + new Date()
					+ "] Invalid Advisor Configuration. Contact TEB 166.");
			context.addMessage("msg", message);
		}
		return;
	}

	public String deleteAdvisingSession() {
		System.out.println("Calling deleteAdvisingSession");

		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();

		if (this.getSelectedAdvisingSession() != null
				&& this.getSelectedAdvisingSession().getAdvisingSessionID() != null) {
			if (this.getModel() != null) {
				this.getModel().setSelectedEntry(null);
				this.getModel().removeEntry(this.getSelectedAdvisingSession());
				this.getModel().refresh();
				this.setAppointmentSelected(false);
			}
			if (!this.getAdvisingManagementBean().removeAdvisingSession(
					this.getSelectedAdvisingSession())) {
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary("[" + new Date()
						+ "] Oops!: Cannot delete advising appointment.");
				context.addMessage("msg", message);
			} else {
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary("[" + new Date()
						+ "] Advising appointment deleted successfully.");
				context.addMessage("msg", message);
				
				this.cancelReminderEmail(this.getSelectedAdvisingSession()
						.getUser(), this.getSelectedAdvisingSession()
						.getAdvisingSessionSlot());
				this.setSelectedAdvisingSession(null);
			}
		} else {
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("[" + new Date()
					+ "] No advising appointment selected.");
			context.addMessage("msg", message);
		}
		return null;
	}

	public String editAdvisingSession() {
		System.out.println("Calling editAdvisingSession");

		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();

		// make sure they have selected an advisor
		if (this.getSelectedAdvisingSession() != null
				&& this.getSelectedAdvisingSession().getAdvisingSessionID() != "") {
			if (apptReason != null && apptReason.trim() != "") {
				this.setSessionText(this.getSessionText()
						+ "<br/><hr/>Reason (Status: "
						+ this.getSessionStatus() + "):<br/>" + apptReason);
			}
			AdvisingSession advisingSession = this.getAdvisingManagementBean()
					.updateAdvisingSession(
							this.getSelectedAdvisingSession(),
							this.getSelectedSessionType(),
							this.getSessionStatus(),
							this.getPreSessionText(),
							this.getSessionText(),
							this.getStudentNotes(),
							this.getAdvisorNotes(),
							this.getSelectedAdvisingSession().getAdvisingSessionSlot(),
							getSelectedAdvisingSession().getNoShowEmailSentBoolean());
			// attempt to update the selected advising session
			if (advisingSession == null) {
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary("["
						+ new Date()
						+ "] Unknown error: Cannot update advising appointment information.");
				context.addMessage("msg", message);
			} else {
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary("["
						+ new Date()
						+ "] Advising appointment information updated successfully.");
				context.addMessage("msg", message);
				// Update the calendar model
				if (this.getModel() != null) {
					if (this.getModel().isEntrySelected()) {
						this.getModel().setSelectedEntry(null);
					}
					this.getModel().removeEntry(
							this.getSelectedAdvisingSession());
					this.getModel().addEntry(advisingSession);
					this.getModel().setSelectedEntry(advisingSession);

					this.getModel().refresh();
				}
				this.setSelectedAdvisingSession(advisingSession);

				// Check whether the appointment status has been changed to
				// "Cancelled"
				if (this.getSessionStatus().equals("Cancelled")) {
					this.cancelReminderEmail(this.getSelectedAdvisingSession()
							.getUser(), this.getSelectedAdvisingSession()
							.getAdvisingSessionSlot());
				}
				// Send email to the student to notify recent changes in the
				// appointment
				// Check whether sessionText has been changed
				if (notifyChanges
						&& this.getSelectedAdvisingSession().getSessionText()
								.trim().length() != this.getSessionText()
								.trim().length()) {
					// Send notification to the student
					this.sendApptChangeNotificationEmail(this
							.getSelectedAdvisingSession().getUser(), this
							.getSelectedAdvisingSession().getSessionDate(),
							this.getSelectedAdvisingSession().getAdvisor());
				}
			}
		} else {
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("[" + new Date()
					+ "] No advising appointment selected.");
			context.addMessage("msg", message);
		}
		return null;
	}

	public String addHoldLift() {
		System.out.println("Calling addHoldLift");
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getSelectedAdvisingSession() != null
				&& this.getSelectedAdvisingSession().getAdvisingSessionID() != "") {
			if (this.getSelectedHoldLiftTerm() != null
					&& this.getSelectedHoldLiftTerm().getUkTermCode() != "") {
				User user = this.getAdvisingManagementBean().findUserByUID(
						this.getSelectedAdvisingSession().getAdvisor()
								.getUserid());
				if (user != null) {

					if (this.getAdvisingManagementBean().addHoldLift(
							this.getSelectedAdvisingSession(), user,
							this.getSelectedHoldLiftTerm())) {
						message.setSeverity(FacesMessage.SEVERITY_INFO);
						message.setSummary("[" + new Date()
								+ "] Hold Lift Information added for "
								+ this.getSelectedAdvisingSession().getUser());
						context.addMessage("msg", message);
					} else {
						message.setSeverity(FacesMessage.SEVERITY_ERROR);
						message.setSummary("["
								+ new Date()
								+ "] Unknown Error: Cannot add the hold lift information.");
						context.addMessage("msg", message);
					}
				} else {
					message.setSeverity(FacesMessage.SEVERITY_ERROR);
					message.setSummary("["
							+ new Date()
							+ "] Unknown Error: Cannot read current advisor information.");
					context.addMessage("msg", message);
				}

			} else {
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary("[" + new Date()
						+ "] Please select a valid term.");
				context.addMessage("msg", message);
			}
		}
		return null;
	}

	public List<HoldLift> getRecentHoldLifts() {
		System.out.println("Calling getRecentHoldLifts");
		List<HoldLift> holdLifts = new ArrayList<HoldLift>(0);
		if (this.getSelectedAdvisingSession() != null
				&& this.getSelectedAdvisingSession().getAdvisingSessionID() != "") {
			System.out.println("User: "
					+ this.getSelectedAdvisingSession().getUser());
			holdLifts = this.getAdvisingManagementBean().getHoldLiftsByStudent(
					this.getSelectedAdvisingSession().getUser());
		}
		return holdLifts;
	}

	public List<HoldLift> getAppointmentHoldLifts() {
		System.out.println("Calling getAppointmentHoldLifts");
		List<HoldLift> holdLifts = new ArrayList<HoldLift>(0);
		if (this.getSelectedAdvisingSession() != null
				&& this.getSelectedAdvisingSession().getAdvisingSessionID() != "") {
			System.out.println("User: " + this.getSelectedAdvisingSession());
			holdLifts = this.getAdvisingManagementBean()
					.getAppointmentHoldLifts(this.getSelectedAdvisingSession());
		}
		return holdLifts;
	}

	public boolean sendApptChangeNotificationEmail(User user, Date apptDate,
			Advisor advisor) {
		EmailAddress emailAddress = this.getAdvisingManagementBean()
				.getUKYEmailAddress(user);
		if (emailAddress == null) {
			System.err.println("No email addresses associated with this user: "
					+ user.getUsername());
			return false;
		}

		String body = "Your appointment " + " with "
				+ advisor.getShortDesc()
				+ " on "
				+ apptDate
				+ " has been updated recently. "
				+ "<br/><br/>You can view the changes in the appointment at the "
				+ "<a href=\"https://coesis.coe.uky.edu/cepis/index.cps\">"
				+ "CEPIS Portal</a>. If you have any questions about these changes, "
				+ "please contact your advisor or visit the Academic Services and "
				+ "Teacher Certification office in 166 Taylor Education Building. "
				+ "<br/><br/><hr/> <font color=\"#062E8A\" "
				+ "face=\"Tahoma\">This is an automatically generated email. "
				+ "Please do not respond to this email or send email messages "
				+ "to this account.</font> <br/><br/><font color=\"#808080\" "
				+ "face=\"Tahoma\">This message may contain sensitive or"
				+ " confidential information and is for the exclusive use"
				+ " of the intended recipient(s). If you are not the intended"
				+ " recipient, please note that any form of distribution,"
				+ " copying, forwarding or use of this communication or"
				+ " the information therein is strictly prohibited and may be unlawful."
				+ " If you have received this communication in error, please return it"
				+ " to the sender and send a copy or notify: teb166@uky.edu and then"
				+ " delete the communication and destroy any copies.</font> <br/> <br/>&copy; "
				+ "University of Kentucky.";
		MailMessage mail = new MailMessage();
		mail.setSender("teb166@coe.uky.edu");
		mail.setSubject("CEPIS Appointment Change Notification - " + apptDate);
		mail.setText(body);
		mail.setBounceAddress("noreply@coe.uky.edu");
		// Try to send uky email address

		mail.addRecepient(emailAddress.getAddress());

		this.getAdvisingManagementBean().sendEmail(mail);
		return true;

	}

	public boolean sendConfirmationEmail(User user,
			AdvisingSessionSlot advisingSessionSlot, Advisor advisor,
			String location) {
		EmailAddress emailAddress = this.getAdvisingManagementBean()
				.getUKYEmailAddress(user);
		if (emailAddress == null) {
			System.err.println("No email addresses associated with this user: "
					+ user.getUsername());
			return false;
		}

		String body = "You currently have an appointment scheduled for "
				+ advisingSessionSlot
				+ " with "
				+ advisor.getShortDesc()
				+ " in "
				+ location.trim()
				+ ". <br/><br/>Please bring your College of Education ID badge "
				+ "for the check-in process.  If you don�t have a COE ID badge, "
				+ "you can have one made in TEB 166 at the time of your appointment.  "
				+ "If your appointment is in the Seaton Center, you may stop by "
				+ "TEB 166 weekdays from 8 am - 4:30 pm to have your badge made."
				+ " <br/><br/>If you will be unable to keep this appointment, "
				+ " please log on to the online appointment scheduler at "
				+ "<a href=\"https://coesis.coe.uky.edu/cepis/index.cps\">"
				+ "CEPIS Portal</a> and cancel/reschedule your appointment. "
				+ "To cancel an appointment via the online scheduler, "
				+ "you must cancel the appointment at least two days prior to "
				+ "the appointment date and time. <b>If you need to cancel an "
				+ "appointment within 48 hours of the scheduled date and time, "
				+ "you must call the Academic Services Office at (859) 257-7971. "
				+ "</b><br/><br/>Your advisor is looking forward to seeing you at "
				+ " your appointment!<br/><br/><hr/> <font color=\"#062E8A\" "
				+ "face=\"Tahoma\">This is an automatically generated email. "
				+ "Please do not respond to this email or send email messages "
				+ "to this account.</font> <br/><br/><font color=\"#808080\" "
				+ "face=\"Tahoma\">This message may contain sensitive or"
				+ " confidential information and is for the exclusive use"
				+ " of the intended recipient(s). If you are not the intended"
				+ " recipient, please note that any form of distribution,"
				+ " copying, forwarding or use of this communication or"
				+ " the information therein is strictly prohibited and may be unlawful."
				+ " If you have received this communication in error, please return it"
				+ " to the sender and send a copy or notify: teb166@uky.edu and then"
				+ " delete the communication and destroy any copies.</font> <br/> <br/>&copy; "
				+ "University of Kentucky.";
		MailMessage mail = new MailMessage();
		mail.setSender("teb166@coe.uky.edu");
		mail.setSubject("CEPIS Advising Appointment Confirmation - "
				+ advisingSessionSlot);
		mail.setText(body);
		mail.setBounceAddress("noreply@coe.uky.edu");
		// Try to send uky email address

		mail.addRecepient(emailAddress.getAddress());

		this.getAdvisingManagementBean().sendEmail(mail);
		return true;

	}

	public void scheduleReminderEmail(User user,
			AdvisingSessionSlot advisingSessionSlot, Advisor advisor,
			Calendar cal, String location) {
		Date triggerTime = cal.getTime();
		cal.set(Calendar.AM_PM, Calendar.PM);
		cal.set(Calendar.HOUR, 5);
		String body = "Dear "
				+ user.getFullName()
				+ ", <br/> <br/> This message is to remind you that "
				+ "you currently have an advising appointment scheduled for "
				+ advisingSessionSlot
				+ " with "
				+ advisor.getShortDesc()
				+ " in "
				+ location
				+ ". <br/> <br/> You will need your College of Education ID badge"
				+ " for the check-in process. If you don't have a COE ID badge, "
				+ "please visit the Academic Services and Teacher Certification office "
				+ "in 166 Taylor Education Building to get one. "
				+ " <br/><br/> Your advisor expects you to arrive on time. If you "
				+ " are unable to attend, you must cancel your appointment. "
				+ "You can cancel your appointment through the online scheduler "
				+ "(<a href=\"https://coesis.coe.uky.edu/cepis/index.cps\">"
				+ "CEPIS Portal</a>) until "
				+ cal.getTime()
				+ ". If you miss this deadline, you should call the "
				+ "Academic Services and Teacher Certification office "
				+ "at (859) 257-7971 to cancel your appointment."
				+ " <br/><br/>If you have already cancelled this appointment, "
				+ "please ignore this reminder email. "
				+ "<br/><br/><hr/> <font color=\"#062E8A\" "
				+ "face=\"Tahoma\">This is an automatically generated email. "
				+ "Please do not respond to this email or send email messages "
				+ "to this account.</font> <br/><br/><font color=\"#808080\" "
				+ "face=\"Tahoma\">This message may contain sensitive or"
				+ " confidential information and is for the exclusive use"
				+ " of the intended recipient(s). If you are not the intended"
				+ " recipient, please note that any form of distribution,"
				+ " copying, forwarding or use of this communication or"
				+ " the information therein is strictly prohibited and may be unlawful."
				+ " If you have received this communication in error, please return it"
				+ " to the sender and send a copy or notify: teb166@uky.edu and then"
				+ " delete the communication and destroy any copies.</font> <br/><br/> &copy; "
				+ "University of Kentucky.";

		StringBuilder toAddress = new StringBuilder();
		EmailAddress emailAddress = this.getAdvisingManagementBean()
				.getUKYEmailAddress(user);
		if (emailAddress != null) {
			toAddress.append(emailAddress.getAddress());
			toAddress.append(',');
		} else {
			// Couldn't find a UKY email address, just send to all on file
			List<EmailAddress> userEmails = this.getAdvisingManagementBean()
					.getEmailAddresses(user);
			for (EmailAddress ea : userEmails) {
				toAddress.append(ea.getAddress());
				toAddress.append(',');
			}
		}
		JobDetail jobDetail = new JobDetail(user.getUid() + "-"
				+ advisingSessionSlot, "Reminder", ReminderEmailJob.class);
		jobDetail.getJobDataMap()
				.put("subject",
						"Reminder: CEPIS Advising Appointment - "
								+ advisingSessionSlot);
		jobDetail.getJobDataMap().put("body", body);
		jobDetail.getJobDataMap().put("toAddress",
				toAddress.substring(0, toAddress.length() - 1));
		jobDetail.setDescription("Reminder Email for " + user.getFullName()
				+ " appointment at " + advisingSessionSlot);

		// default to run once...
		SimpleTrigger trigger = new SimpleTrigger(user.getUid() + "-"
				+ advisingSessionSlot, "ReminderTrigger", triggerTime, null, 0, 0L);
		trigger.setPriority(4);
		try {
			this.getAdvisingManagementBean().scheduleReminderEmail(jobDetail,
					trigger);
		} catch (ProviderException e) {
			System.err.println(e);
		}
	}

	public void cancelReminderEmail(User user, AdvisingSessionSlot advisingSessionSlot) {
		try {
			this.getAdvisingManagementBean().deleteReminderEmail(
					user.getUid() + "-" + advisingSessionSlot, "Reminder");
		} catch (ProviderException e) {
			System.err.println(e);
		}
	}

	public String sendFeedbackEmail() {
		try {

			MailMessage mail = new MailMessage();
			mail.setSender("cepis@coe.uky.edu");
			mail.addRecepient("gschr1@uky.edu");
			mail.addRecepient("myrt@uky.edu");
			mail.setSubject("CEPIS Advising Module Feedback ");
			EmailAddress emailAddress = this.getAdvisingManagementBean()
					.getUKYEmailAddress(this.getUserManager().getUser());
			if (emailAddress != null) {
				mail.setBounceAddress(emailAddress.getAddress());
			} else {
				mail.setBounceAddress("noreply@coe.uky.edu");
			}
			String body = "From: "
					+ this.getUserManager().getUser().getFullName()
					+ "("
					+ this.getUserManager().getUser().getUsername()
					+ "), <br/>"
					+ this.getMessage()
					+ "<br/><hr/><br/> This message may contain sensitive or"
					+ " confidential information and is for the exclusive use"
					+ " of the intended recipient(s). If you are not the intended"
					+ " recipient, please note that any form of distribution,"
					+ " copying, forwarding or use of this communication or"
					+ " the information therein is strictly prohibited and may be unlawful."
					+ " If you have received this communication in error, please return it"
					+ " to the sender and send a copy or notify: teb166@uky.edu and then"
					+ " delete the communication and destroy any copies. <br/> &copy; "
					+ "University of Kentucky.";

			mail.setText(body);

			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("["
					+ new Date()
					+ "] Thank you for your feedback. We will get back to you soon.");
			context.addMessage("msg", message);
			this.getAdvisingManagementBean().sendEmail(mail);

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Exception " + ex);

			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("["
					+ new Date()
					+ "] Sending feedback failed. Sorry for the inconvenience. You can send your feedback to teb166@uky.edu, or you can call us at (859) 257-7971, or send fax to (859) 323-3887.");
			context.addMessage("msg", message);
		}

		return null;
	}

	public void addToWS(ActionEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		Object key = null;
		AdvisingSession advisingSession = null;
		boolean status = true;
		if (this.getSelection() != null) {
			if (this.getSelection().size() > 0) {
				Set<User> users = new HashSet<User>(0);
				Iterator<Object> iterator = getSelection().getKeys();
				while (iterator.hasNext()) {
					key = iterator.next();
					advisingSession = this.getAdvisingManagementBean()
							.findAdvisingSessionByID(key.toString());
					if (advisingSession != null) {
						if (advisingSession.getUser() != null) {
							users.add(advisingSession.getUser());
						} else {
							status = false;
						}
					} else {
						status = false;
					}
				}
				// Add the selectedUsers to the current working set
				List<User> selectedUsers = new ArrayList<User>(users);
				if (selectedUsers.size() > 0) {
					if (this.getAdvisingManagementBean().addUsersToWorkingSet(
							this.getConfigurationManager()
									.getSelectedWorkingSet(), selectedUsers)) {
						message.setSeverity(FacesMessage.SEVERITY_INFO);
						message.setSummary("["
								+ new Date()
								+ "] "
								+ selectedUsers.size()
								+ " user(s) added to the current working set \""
								+ this.getConfigurationManager()
										.getSelectedWorkingSet().getName()
								+ "\".");
						context.addMessage("msg", message);
						this.getSelection().clear();
					} else {
						System.out.println("unknown error addusertows");
						message.setSeverity(FacesMessage.SEVERITY_WARN);
						message.setSummary("["
								+ new Date()
								+ "] Unknown Error: Cannot add selected user(s).");
						context.addMessage("msg", message);
					}
				}

				if (!status) {
					FacesMessage message1 = new FacesMessage();
					message1.setSeverity(FacesMessage.SEVERITY_ERROR);
					message1.setSummary("["
							+ new Date()
							+ "] Unknown Error: one or more users of the selected appointments has not been added.");
					context.addMessage("msg", message1);
				}

			} else {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] Select atleast one appointment from the list.");
				context.addMessage("msg", message);
			}
		} else {
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("[" + new Date()
					+ "] Unknown Error: Cannot access selected appointments.");
			context.addMessage("msg", message);
		}
	}

	// Update the selectedAdvisingSession from the richfaces extended data table
	public String takeSelection() {
		System.out.println("Calling takeSelection");
		System.out.println(">>>>>>>>>>>>>>>>>>" + this.getSelection().size());
		setSelectedPastAppointment(new AdvisingSession());
		Object key = null;
		if (this.isMyCalendarMode()) {
			System.out.println("myCalendar mode enabled");
			if (this.currentView.equals("SCHEDULE")
					&& this.getSchedulerTable() != null) {
				key = this.getSchedulerTable().getActiveRowKey();
			} else {
				key = this.getAgendaTable().getActiveRowKey();
			}
		} else {
			Iterator<Object> iterator = getSelection().getKeys();
			if (iterator.hasNext()) {
				key = iterator.next();
			}
		}
		System.out.println("Key: " + key);

		// make sure they have selected something in the table
		if (key != null) {
			AdvisingSession advisingSession = this.getAdvisingManagementBean()
					.findAdvisingSessionByID(key.toString());
			this.setSelectedAdvisingSession(advisingSession);
			if (this.getModel() != null) {
				this.getModel().setSelectedEntry(
						this.getSelectedAdvisingSession());
			}
			this.setAppointmentSelected(true);
			// set display contents to that of the selected session
			this.setSelectedSessionType(this.getSelectedAdvisingSession()
					.getSessionType());
			this.setSessionStatus(this.getSelectedAdvisingSession()
					.getSessionStatus());
			this.setPreSessionText(this.getSelectedAdvisingSession()
					.getPreSessionText());
			this.setSessionText(this.getSelectedAdvisingSession()
					.getSessionText());
			this.setStudentNotes(this.getSelectedAdvisingSession()
					.getStudentNotes());
			this.setAdvisorNotes(this.getSelectedAdvisingSession()
					.getAdvisorNotes());
			this.setNotifyChanges(false);
			this.setApptReason(null);
		} else {

			System.out.println("No advising appointment selected.");
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("[" + new Date()
					+ "] No advising appointment selected.");
			context.addMessage("msg", message);
		}
		return null;
	}

	public String getInitSessionDate() {
		Calendar calendar = GregorianCalendar.getInstance();
		this.setSelectedSessionDate(calendar.getTime());
		calendar.add(Calendar.HOUR_OF_DAY, -1);
		// set the start time to an hour before now
		this.setSelectedStartSessionDate(calendar.getTime());
		// set the end time based on the start time
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(year, month, day, 23, 59, 59);
		this.setSelectedEndSessionDate(calendar.getTime());
		return "";
	}

	public void valueChangeStartSessionDate(ActionEvent event) {
		System.out.println("Start Date: " + this.getSelectedStartSessionDate());
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(this.getSelectedStartSessionDate());
		// set the end time based on the start time
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(year, month, day, 23, 59, 59);
		this.setSelectedEndSessionDate(calendar.getTime());
	}

	public synchronized void valueChangeAdvisor(ActionEvent event) {
		System.out.println("Calling ValueChangeAdvisor");
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		System.out.println(this.getSelectedAdvisor() + "--"
				+ this.getSelectedAdvisor().getUserid());
		// make sure they have selected an advisor
		if (this.getSelectedAdvisor() != null
				&& this.getSelectedAdvisor().getUserid() != "") {

			// get a list of ALL the advisors slots
			studentAdvisingSessionSlotList = this.getAdvisingManagementBean()
					.getAvailableAdvisingSessionSlotList(
							this.getSelectedAdvisor(), true);
			if (studentAdvisingSessionSlotList == null) {
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary("["
						+ new Date()
						+ "] Unknown error: Unable to fetch open slots of the selected advisor.");
				context.addMessage("msg", message);
				return;
			} else if (studentAdvisingSessionSlotList.size() < 1) {
				System.out.println("Empty slot list");
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("["
						+ new Date()
						+ "] We are sorry, all appointments for the selected advisor ('"
						+ this.getSelectedAdvisor().getShortDesc().trim()
						+ "') are booked.  Please check back at another time for upcoming open appointment slots.");
				context.addMessage("msg", message);
				return;
			}
			// an attempt to sort by start time
			Collections.sort(studentAdvisingSessionSlotList,
					new Comparator<Object>() {
						public int compare(Object o1, Object o2) {
							AdvisingSessionSlot a1 = (AdvisingSessionSlot) o1;
							AdvisingSessionSlot a2 = (AdvisingSessionSlot) o2;

							DateFormat formatter;
							Date date1, date2;
							formatter = new SimpleDateFormat(
									"EEEE, MMMM d, yyyy hh:mm aaa");

							try {
								date1 = (Date) formatter.parse(a1.toString());
								date2 = (Date) formatter.parse(a2.toString());

								return date1.compareTo((date2));
							} catch (ParseException e) {
								e.printStackTrace();
							}

							return 0;
						}
					});
		}
	}

	public void valueChangeSelectedWeek(ActionEvent event) {
		System.out.println("Calling valueChangeSelectedWeek");
		if (this.getCurrentView().equals("SLOT")) {
			// make sure they have selected an a week date
			if (currentAdvisor != null && currentAdvisor.getUserid() != ""
					&& this.getSelectedDate() != null) {

				Calendar cal = Calendar.getInstance();
				cal.setFirstDayOfWeek(Calendar.SUNDAY);
				cal.setTime(this.getSelectedDate());
				cal.set(Calendar.DAY_OF_WEEK, 1);
				
				// These Dates and calendars are used to get the make sure the session slots are pulled for the current year.
				Date currentDate = new Date();
				Calendar currentCalendar = Calendar.getInstance();
				Calendar sessionCalendar = Calendar.getInstance();
				currentCalendar.setTime(currentDate);

				System.out.println("this should be sunday: " + cal.getTime());

				for (int i = 0; i < 5; i++) {
					Format formatter = new SimpleDateFormat("EEE, MMM d");
					cal.add(Calendar.DAY_OF_WEEK, 1);
					weekDays[i] = formatter.format(cal.getTime());
				}

				// get the existing slots for the selected advisor in selected
				// week
				List<AdvisingSessionSlot> weekAdvisingSessionSlotList = this
						.getAdvisingManagementBean()
						.getAdvisingSessionSlotList(currentAdvisor,
								this.getSelectedDate());

				// re-initialize the disabled checkbox array to all false
				Arrays.fill(this.getDisabledCheckboxArray()[0], false);
				Arrays.fill(this.getDisabledCheckboxArray()[1], false);
				Arrays.fill(this.getDisabledCheckboxArray()[2], false);
				Arrays.fill(this.getDisabledCheckboxArray()[3], false);
				Arrays.fill(this.getDisabledCheckboxArray()[4], false);

				// re-initialize the selected checkbox array to all false
				Arrays.fill(this.getSelectedCheckboxArray()[0], false);
				Arrays.fill(this.getSelectedCheckboxArray()[1], false);
				Arrays.fill(this.getSelectedCheckboxArray()[2], false);
				Arrays.fill(this.getSelectedCheckboxArray()[3], false);
				Arrays.fill(this.getSelectedCheckboxArray()[4], false);

				// if there exists some previously created slots for this week
				if (!weekAdvisingSessionSlotList.isEmpty()) {
					System.out.println("slots exist for selected week: "
							+ this.getSelectedDate());

					Iterator<AdvisingSessionSlot> iter = weekAdvisingSessionSlotList
							.iterator();

					// for each advising session slot in the selected week
					while (iter.hasNext()) {
						AdvisingSessionSlot advisingsessionslot = iter.next();

						System.out.println(advisingsessionslot.getAdvisor()
								.getShortDesc());

						// determine the weekday and slot number
						cal.setTime(advisingsessionslot.getSlotDate());
						int weekday = cal.get(Calendar.DAY_OF_WEEK) - 2;
						int slotNumber = advisingsessionslot.getSlotNumber() - 1;
												
						// make the appropriate checkbox display as checked
						if(cal.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR)){
							this.getSelectedCheckboxArray()[weekday][slotNumber] = true;
						}

						// if this slot is scheduled, disable the checkbox
						if (advisingsessionslot.getStatus().equals("Scheduled")) {
							sessionCalendar.setTime(advisingsessionslot.getSlotDate());
							// Make sure we are getting session slots for the current year.
							if(sessionCalendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR)){
								this.getDisabledCheckboxArray()[weekday][slotNumber] = true;
							}
						}
					}
				} else {
					FacesContext context = FacesContext.getCurrentInstance();
					FacesMessage message = new FacesMessage();
					message.setSeverity(FacesMessage.SEVERITY_INFO);
					message.setSummary("["
							+ new Date()
							+ "] No slots have been scheduled for the selected week.");
					context.addMessage("msg", message);
				}
			}
		}
	}

	public String addScannedUser() {
		System.out
				.println("Add Scanned User called for " + this.getScannedID());
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message1 = new FacesMessage();
		FacesMessage message2 = new FacesMessage();
		if (!this.getScannedID().isEmpty()) {
			User scannedUser = this.getAdvisingManagementBean().findUserByUID(
					getScannedID());
			if (scannedUser == null) {
				scannedUser = this.getAdvisingManagementBean()
						.findUserByUsername(getScannedID());
			}
			if (scannedUser == null) {
				message1.setSeverity(FacesMessage.SEVERITY_WARN);
				message1.setSummary("[" + new Date()
						+ "] Invalid User ID/Username.");
				context.addMessage("msg", message1);
				this.setScannedID(null);
				return null;
			}
			// Check-in today's appt of the scanned User Action
			if (this.isEnableCheckinAction()) {
				List<AdvisingSession> advisingSessions = this
						.getAdvisingManagementBean().getAdvisingSessionList(
								scannedUser, new Date());
				if (advisingSessions.size() < 1) {
					message1.setSeverity(FacesMessage.SEVERITY_WARN);
					message1.setSummary("["
							+ new Date()
							+ "] Warning: No scheduled appointments available for "
							+ scannedUser.getFullName());
					context.addMessage("msg", message1);

				} else {
					AdvisingSession appt = advisingSessions.get(0);
					if (this.getAdvisingManagementBean().checkIn(scannedUser,
							appt)) {
						message1.setSeverity(FacesMessage.SEVERITY_INFO);
						message1.setSummary("["
								+ new Date()
								+ "] User "
								+ scannedUser.getFullName()
								+ " checked-in successfully for the appointment at "
								+ appt.getSessionTime() + ".");
						context.addMessage("msg", message1);
					}
				}
			}

			// Add User to the Current Working Set Action
			if (this.isEnableAddToWorkingSetAction()) {
				WorkingSet ws = this.getConfigurationManager()
						.getSelectedWorkingSet();
				if (this.getAdvisingManagementBean().addUserToWorkingSet(ws,
						scannedUser)) {
					message2.setSeverity(FacesMessage.SEVERITY_INFO);
					message2.setSummary("[" + new Date() + "] User "
							+ scannedUser.getFullName()
							+ " added successfully to " + ws.getName() + ".");
					context.addMessage("msg", message2);
				} else {
					message2.setSeverity(FacesMessage.SEVERITY_WARN);
					message2.setSummary("[" + new Date()
							+ "] Unknown Error: Cannot add "
							+ this.getScannedID() + " to " + ws.getName()
							+ " or No user found.");
					context.addMessage("msg", message2);

				}
			}

			this.setScannedID(null);
			return null;

		}
		message1.setSeverity(FacesMessage.SEVERITY_WARN);
		message1.setSummary("[" + new Date() + "] Invalid User ID.");
		context.addMessage("msg", message1);
		return null;
	}

	/**
	 * @param accountManagementController
	 *            the accountManagementController to set
	 */
	public void setAccountManagementController(
			AccountManagementController accountManagementController) {
		this.accountManagementController = accountManagementController;
	}

	/**
	 * @return the accountManagementController
	 */
	public AccountManagementController getAccountManagementController() {
		return accountManagementController;
	}

	/**
	 * @param notifyChanges
	 *            the notifyChanges to set
	 */
	public void setNotifyChanges(boolean notifyChanges) {
		this.notifyChanges = notifyChanges;
	}

	/**
	 * @return the notifyChanges
	 */
	public boolean isNotifyChanges() {
		return notifyChanges;
	}

	/**
	 * @param schedule
	 *            the schedule to set
	 */
	public void setSchedule(HtmlSchedule schedule) {
		this.schedule = schedule;
	}

	/**
	 * @return the schedule
	 */
	public HtmlSchedule getSchedule() {
		return schedule;
	}

	/**
	 * @param myCalendarMode
	 *            the myCalendarMode to set
	 */
	public void setMyCalendarMode(boolean myCalendarMode) {
		this.myCalendarMode = myCalendarMode;
	}

	/**
	 * @return the myCalendarMode
	 */
	public boolean isMyCalendarMode() {
		return myCalendarMode;
	}

	/**
	 * @param selectedHoldLiftTerm
	 *            the selectedHoldLiftTerm to set
	 */
	public void setSelectedHoldLiftTerm(UKTerm selectedHoldLiftTerm) {
		this.selectedHoldLiftTerm = selectedHoldLiftTerm;
	}

	/**
	 * @return the selectedHoldLiftTerm
	 */
	public UKTerm getSelectedHoldLiftTerm() {
		return selectedHoldLiftTerm;
	}

	/**
	 * @param apptReason
	 *            the apptReason to set
	 */
	public void setApptReason(String apptReason) {
		this.apptReason = apptReason;
	}

	/**
	 * @return the apptReason
	 */
	public String getApptReason() {
		return apptReason;
	}

	/**
	 * @param currentView
	 *            the currentView to set
	 */
	public void setCurrentView(String currentView) {
		this.currentView = currentView;
	}

	/**
	 * @return the currentView
	 */
	public String getCurrentView() {
		return currentView;
	}

	/**
	 * @param appointmentSelected
	 *            the appointmentSelected to set
	 */
	public void setAppointmentSelected(boolean appointmentSelected) {
		this.appointmentSelected = appointmentSelected;
	}

	/**
	 * @return the appointmentSelected
	 */
	public boolean isAppointmentSelected() {
		return appointmentSelected;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Advisor getCurrentAdvisor() {
		if (currentAdvisor == null) {
			currentAdvisor = this.getAdvisingManagementBean()
					.findAdvisorByUser(this.getUserManager().getUser());
		}
		return currentAdvisor;
	}

	public HtmlExtendedDataTable getAgendaTable() {
		return agendaTable;
	}

	public void setAgendaTable(HtmlExtendedDataTable agendaTable) {
		this.agendaTable = agendaTable;
	}

	public HtmlExtendedDataTable getSchedulerTable() {
		return schedulerTable;
	}

	public void setSchedulerTable(HtmlExtendedDataTable schedulerTable) {
		this.schedulerTable = schedulerTable;
	}

	public boolean isSendConformationEmail() {
		return sendConformationEmail;
	}

	public void setSendConformationEmail(boolean sendConformationEmail) {
		this.sendConformationEmail = sendConformationEmail;
	}

}
