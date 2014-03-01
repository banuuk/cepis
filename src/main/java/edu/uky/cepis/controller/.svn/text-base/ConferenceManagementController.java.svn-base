/**
 * 
 */
package edu.uky.cepis.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.apache.log4j.Logger;
import edu.uky.cepis.domain.Attendee;
import edu.uky.cepis.domain.Conference;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.view.ConferenceManagementView;

/**
 * View controller for conference management system. <br/>
 * 
 * @author keerthi
 */

public class ConferenceManagementController extends AbstractController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger
			.getLogger(ConferenceManagementController.class);
	private String name;
	private String type;
	private Date conferenceDate;
	private String shortDesc;
	private String admissionType;
	private String ukClassification;
	private String ukmajor;
	private boolean attended;
	private Conference selectedConference;
	private ConferenceManagementView conferenceBean;
	private Attendee selectedAttendee;
	private String scannedID;
	private List<User> selectedUsers = new ArrayList<User>(0);
	private List<Attendee> selectedAttendees = new ArrayList<Attendee>(0);

	/**
	 * 
	 */
	public ConferenceManagementController() {
	}

	/**
	 * @return the name
	 * @uml.property name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the conferenceDate
	 * @uml.property name="conferenceDate"
	 */
	public Date getConferenceDate() {
		return conferenceDate;
	}

	/**
	 * @return the shortDesc
	 * @uml.property name="shortDesc"
	 */
	public String getShortDesc() {
		return shortDesc;
	}

	/**
	 * @return the selectedConference
	 * @uml.property name="selectedConference"
	 */
	public Conference getSelectedConference() {
		return selectedConference;
	}

	/**
	 * @param name
	 *            the name to set
	 * @uml.property name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param conferenceDate
	 *            the conferenceDate to set
	 * @uml.property name="conferenceDate"
	 */
	public void setConferenceDate(Date conferenceDate) {
		this.conferenceDate = conferenceDate;
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
	 * @param selectedConference
	 *            the selectedConference to set
	 * @uml.property name="selectedConference"
	 */
	public void setSelectedConference(Conference selectedConference) {
		this.selectedConference = selectedConference;
	}

	/**
	 * @return the admissionType
	 * @uml.property name="admissionType"
	 */
	public String getAdmissionType() {
		return admissionType;
	}

	/**
	 * @return the ukClassification
	 * @uml.property name="ukClassification"
	 */
	public String getUkClassification() {
		return ukClassification;
	}

	/**
	 * @return the ukmajor
	 * @uml.property name="ukmajor"
	 */
	public String getUkmajor() {
		return ukmajor;
	}

	/**
	 * @return the attended
	 * @uml.property name="attended"
	 */
	public boolean isAttended() {
		return attended;
	}

	/**
	 * @param admissionType
	 *            the admissionType to set
	 * @uml.property name="admissionType"
	 */
	public void setAdmissionType(String admissionType) {
		this.admissionType = admissionType;
	}

	/**
	 * @param ukClassification
	 *            the ukClassification to set
	 * @uml.property name="ukClassification"
	 */
	public void setUkClassification(String ukClassification) {
		this.ukClassification = ukClassification;
	}

	/**
	 * @param ukmajor
	 *            the ukmajor to set
	 * @uml.property name="ukmajor"
	 */
	public void setUkmajor(String ukmajor) {
		this.ukmajor = ukmajor;
	}

	/**
	 * @param attended
	 *            the attended to set
	 * @uml.property name="attended"
	 */
	public void setAttended(boolean attended) {
		this.attended = attended;
	}

	/**
	 * @return the selectedAttendee
	 * @uml.property name="selectedAttendee"
	 */
	public Attendee getSelectedAttendee() {
		return selectedAttendee;
	}

	/**
	 * @param selectedAttendee
	 *            the selectedAttendee to set
	 * @uml.property name="selectedAttendee"
	 */
	public void setSelectedAttendee(Attendee selectedAttendee) {
		this.selectedAttendee = selectedAttendee;
	}

	public List<Conference> getConferenceList() {
		return this.getConferenceBean().getConferenceList();
	}

	public List<Conference> getUserConferenceList() {
		System.out.println("Calling getUserConferenceList");
		if (this.getConfigurationManager().getSelectedUser() == null)
			System.out.println("No user selected");
		return this.getConferenceBean().getUserConferenceList(
				this.getConfigurationManager().getSelectedUser());
	}

	public List<Attendee> getAttendeeList() {
		List<Attendee> attendees = new ArrayList<Attendee>(0);
		if (this.getSelectedConference() == null
				|| this.getSelectedConference().getId() < 1) {
			return attendees;
		}
		attendees = new ArrayList<Attendee>(this.getConferenceBean()
				.getConferenceAttendeesList(selectedConference));
		Collections.sort(attendees, new Attendee());
		return attendees;
	}

	public void createConference() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		this.setSelectedConference(this.getConferenceBean().createConference(
				name, type, conferenceDate, shortDesc));
		if (this.getSelectedConference() != null) {
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("[" + new Date() + "] Conference '"
					+ this.getSelectedConference().getName() + "'"
					+ " created successfully.");
			context.addMessage("msg", message);
			return;
		}
		message.setSeverity(FacesMessage.SEVERITY_WARN);
		message.setSummary("[" + new Date()
				+ "] Unknown error: Cannot create the conference.");
		context.addMessage("msg", message);
	}

	public void updateConference() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getSelectedConference() == null) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date()
					+ "] Error: No conference selected.");
			context.addMessage("msg", message);
			return;
		}
		if (this.getConferenceBean().updateConference(selectedConference, name,
				type, conferenceDate, shortDesc) != null) {
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("[" + new Date() + "] Conference '"
					+ this.getSelectedConference().getName() + "'"
					+ " updated successfully.");
			context.addMessage("msg", message);
			return;
		}
		message.setSeverity(FacesMessage.SEVERITY_WARN);
		message.setSummary("[" + new Date()
				+ "] Unknown error: Cannot update the conference '"
				+ this.getSelectedConference().getName() + "'.");
		context.addMessage("msg", message);
	}

	public void deleteConference() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getSelectedConference() == null) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date()
					+ "] Error: No conference selected.");
			context.addMessage("msg", message);
			return;
		}
		if (this.getConferenceBean().deleteConference(selectedConference)) {
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("[" + new Date()
					+ "] Conference deleted successfully.");
			context.addMessage("msg", message);
			this.setSelectedConference(null);
			return;
		}
		message.setSeverity(FacesMessage.SEVERITY_WARN);
		message.setSummary("[" + new Date()
				+ "] Unknown error: Cannot delete the conference '"
				+ this.getSelectedConference().getName() + "'.");
		context.addMessage("msg", message);
	}

	public void addAttendees() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getSelectedConference() == null) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date()
					+ "] Error: No conference selected.");
			context.addMessage("msg", message);
			return;
		}
		if (selectedUsers == null || selectedUsers.size() < 1) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] Error: No user selected.");
			context.addMessage("msg", message);
			return;
		}
		int total = this.getConferenceBean().addAttendeesToConference(
				selectedConference, new HashSet<User>(selectedUsers));
		if (total == selectedUsers.size()) {

			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("[" + new Date()
					+ "] Attendees added successfully to the conference '"
					+ this.getSelectedConference().getName() + "'.");
			context.addMessage("msg", message);
			return;
		} else {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("["
					+ new Date()
					+ "] Unknown error: Cannot add some attendees to the conference '"
					+ this.getSelectedConference().getName() + "'.");
			context.addMessage("msg", message);
		}
	}

	public void updateAttendee() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (selectedConference == null) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date()
					+ "] Error: No Conference selected.");
			context.addMessage("msg", message);
			return;
		}
		if (selectedAttendee == null) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date()
					+ "] Error: No attendee selected.");
			context.addMessage("msg", message);
			return;
		}
		Attendee attendee = this.getConferenceBean().updateAttendee(
				selectedAttendee, selectedAttendee.getUser(), attended,
				shortDesc);
		if (attendee != null) {

			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("["
					+ new Date()
					+ "] Attendee "
					+ this.getConfigurationManager().getSelectedUser()
							.getFullName()
					+ " updated successfully for the conference '"
					+ this.getSelectedConference().getName() + "'.");
			context.addMessage("msg", message);
			return;

		}
		message.setSeverity(FacesMessage.SEVERITY_WARN);
		message.setSummary("["
				+ new Date()
				+ "] Unknown error: Cannot edit the attendee details for the conference '"
				+ this.getSelectedConference().getName() + "'.");
		context.addMessage("msg", message);
	}

	public void removeAttendees() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getSelectedConference() == null) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date()
					+ "] Error: No conference selected.");
			context.addMessage("msg", message);
			return;
		}
		System.out.println(selectedAttendees);
		if (selectedAttendees == null || selectedAttendees.size() < 1) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] Error: No user selected.");
			context.addMessage("msg", message);
			return;
		}
		boolean status = this.getConferenceBean()
				.removeAttendeesFromConference(selectedConference,
						new HashSet<Attendee>(selectedAttendees));
		if (status) {
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("[" + new Date()
					+ "] Attendees removed successfully from the conference '"
					+ this.getSelectedConference().getName() + "'.");
			context.addMessage("msg", message);
			return;
		} else {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("["
					+ new Date()
					+ "] Unknown error: Cannot remove some attendees from the conference '"
					+ this.getSelectedConference().getName() + "'.");
			context.addMessage("msg", message);
		}
	}

	public String checkInScannedUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (selectedConference == null) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date()
					+ "] Error: No Conference selected.");
			context.addMessage("msg", message);
			return null;
		}
		if (scannedID == null || scannedID.trim().isEmpty()) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] Error: No user scanned.");
			context.addMessage("msg", message);
			return null;
		}
		if (this.getConferenceBean().checkInAttendee(selectedConference,
				scannedID)) {
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("[" + new Date() + "] Attendee " + scannedID
					+ " checked-in successfully.");
			context.addMessage("msg", message);
			this.scannedID = null;
			return null;
		}
		message.setSeverity(FacesMessage.SEVERITY_WARN);
		message.setSummary("["
				+ new Date()
				+ "] Unknown error: Cannot check-in the attendee "
				+ scannedID
				+ " to the conference '"
				+ this.getSelectedConference().getName()
				+ "'. Please check whether the attendee is registered for this conference before check-in.");
		context.addMessage("msg", message);
		return null;
	}

	public String registerScannedUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (selectedConference == null) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date()
					+ "] Error: No Conference selected.");
			context.addMessage("msg", message);
			return null;
		}
		if (scannedID == null || scannedID.trim().isEmpty()) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] Error: No user scanned.");
			context.addMessage("msg", message);
			return null;
		}
		if (this.getConferenceBean().registerAttendee(selectedConference,
				scannedID)) {
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("[" + new Date() + "] Attendee " + scannedID
					+ " registered successfully.");
			context.addMessage("msg", message);
			this.scannedID = null;
			return null;
		}
		message.setSeverity(FacesMessage.SEVERITY_WARN);
		message.setSummary("["
				+ new Date()
				+ "] Unknown error: Cannot register the attendee "
				+ scannedID
				+ " to the conference '"
				+ this.getSelectedConference().getName()
				+ "'. Please check whether the attendee is in the CEPIS system.");
		context.addMessage("msg", message);
		return null;
	}

	@SuppressWarnings("unchecked")
	public void syncOldConferenceData(ActionEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();

		List<Object> oldConferences = this.getConferenceBean()
				.getOldConferenceList();
		if (oldConferences.size() > 0) {

			Iterator iter = oldConferences.iterator();
			Object values[] = null;
			String conferenceName = null;
			String uid = null;
			boolean attended = false;
			StringBuffer desc = null;
			Attendee attendee = null;
			while (iter.hasNext()) {
				values = (Object[]) iter.next();
				Date confDate = (Date) values[5];
				SimpleDateFormat dateFormatter = new SimpleDateFormat(
						"MMM dd, yyyy 'Advising Conference'");
				conferenceName = dateFormatter.format(confDate);
				System.out.println("Conference Name: " + conferenceName);
				Conference conference = this.getConferenceBean()
						.findConferenceByName(conferenceName);
				if (conference == null) {
					// Create new conference
					conference = this
							.getConferenceBean()
							.createConference(
									conferenceName,
									"Advising Conference for new students transfer, readmit, or freshman starting in COE.",
									confDate, "Advising Conference");
					System.out.println("Creating new conference "
							+ conference.getName());
					if (conference == null) {
						System.out.println("Cannot create conference "
								+ conferenceName);
						continue;
					}
				}
				// Add attendees to the selected conference

				if (values[6] != null && values[6].equals("Yes")) {
					attended = true;
				} else {
					attended = false;
				}
				desc = new StringBuffer(" ");
				if (values[8] != null) {
					desc.append(values[8].toString());
				}
				if (values[4] != null) {
					desc.append('\n');
					desc.append("Major: " + values[4]);
				}
				if (values[2] != null) {
					desc.append('\n');
					desc.append("Admission Type: " + values[2]);
				}
				if (values[3] != null) {
					desc.append('\n');
					desc.append("Classification: " + values[3]);
				}
				if (values[7] != null) {
					desc.append('\n');
					desc.append("Letter: " + values[7]);
				}
				uid = values[1].toString();
				User user = this.getConferenceBean().findUserByUID(uid);
				if (user != null) {
					attendee = this.getConferenceBean().createAttendee(
							conference, user, attended, desc.toString());
					if (attendee != null) {

						System.out.println("Adding new attendee "
								+ user.getFullName()
								+ " to the conference "
								+ conference.getName()
								+ ". Status: "
								+ this.getConferenceBean()
										.addAttendeeToConference(conference,
												attendee));
					}
				}
			}

			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("[" + new Date() + "] Old Conference data"
					+ " synced successfully.");
			context.addMessage("msg", message);
			return;
		}
	}

	/**
	 * @param conferenceBean
	 *            the conferenceBean to set
	 * @uml.property name="conferenceBean"
	 */
	public void setConferenceBean(ConferenceManagementView conferenceBean) {
		this.conferenceBean = conferenceBean;
	}

	/**
	 * @return the conferenceBean
	 * @uml.property name="conferenceBean"
	 */
	public ConferenceManagementView getConferenceBean() {
		return conferenceBean;
	}

	/**
	 * @param scannedID
	 *            the scannedID to set
	 * @uml.property name="scannedID"
	 */
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
	 * @param type
	 *            the type to set
	 * @uml.property name="type"
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the type
	 * @uml.property name="type"
	 */
	public String getType() {
		return type;
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
	 * @return the selectedAttendees
	 * @uml.property name="selectedAttendees"
	 */
	public List<Attendee> getSelectedAttendees() {
		return selectedAttendees;
	}

	/**
	 * @param selectedAttendees
	 *            the selectedAttendees to set
	 * @uml.property name="selectedAttendees"
	 */
	public void setSelectedAttendees(List<Attendee> selectedAttendees) {
		this.selectedAttendees = selectedAttendees;
	}

}
