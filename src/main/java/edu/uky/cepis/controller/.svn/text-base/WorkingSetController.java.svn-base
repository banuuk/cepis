/**
 * 
 */
package edu.uky.cepis.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;

import org.ajax4jsf.event.AjaxEvent;

import edu.uky.cepis.domain.SharedUser;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.WorkingSet;
import edu.uky.cepis.view.WorkingSetView;

/**
 * @author keerthi
 */
public class WorkingSetController extends AbstractController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property name="workingSetBean"
	 * @uml.associationEnd
	 */
	private WorkingSetView workingSetBean;

	private boolean showSaveWSModalWindow;
	// mergeToWorkingSet also called as First Working Set
	/**
	 * @uml.property name="mergeToWorkingSet"
	 */
	private static String mergeToWorkingSet = "activeWorkingSet";
	/**
	 * @uml.property name="mergeToWorkingSetLock"
	 */
	private static boolean mergeToWorkingSetLock = false;
	/**
	 * @uml.property name="activeWSUsersList"
	 */
	private List<User> activeWSUsersList = new ArrayList<User>(0);
	/**
	 * @uml.property name="activeWSList"
	 */
	private List<WorkingSet> activeWSList = new ArrayList<WorkingSet>(0);
	/**
	 * @uml.property name="selectedWSUsersList"
	 */
	private List<User> selectedWSUsersList = new ArrayList<User>(0);
	/**
	 * @uml.property name="selectedWSList"
	 */
	private List<WorkingSet> selectedWSList = new ArrayList<WorkingSet>(0);
	/**
	 * @uml.property name="selectedWS"
	 * @uml.associationEnd
	 */
	private WorkingSet selectedWS;
	/**
	 * @uml.property name="name"
	 */
	private String name;

	/**
	 * @uml.property name="description"
	 */
	private String description;
	/**
	 * @uml.property name="publicmode"
	 */
	private boolean publicmode;
	/**
	 * @uml.property name="sharedmode"
	 */
	private boolean sharedmode;
	/**
	 * @uml.property name="overwrite"
	 */
	private boolean saveAndOpenNewWS;
	private boolean allWS = true;
	private boolean publicWS = false;
	private boolean sharedWS = false;
	private boolean allowPublicToAdd = false;
	private boolean allowPublicToRemove = false;
	private Object wsPanelStatus;
	/**
	 * @uml.property name="overwriteResult"
	 */
	private int overwriteResult;

	/**
	 * @return the allowPublicToAdd
	 */
	public boolean isAllowPublicToAdd() {
		return allowPublicToAdd;
	}

	/**
	 * @return the allowPublicToRemove
	 */
	public boolean isAllowPublicToRemove() {
		return allowPublicToRemove;
	}

	/**
	 * @param allowPublicToAdd
	 *            the allowPublicToAdd to set
	 */
	public void setAllowPublicToAdd(boolean allowPublicToAdd) {
		this.allowPublicToAdd = allowPublicToAdd;
	}

	/**
	 * @param allowPublicToRemove
	 *            the allowPublicToRemove to set
	 */
	public void setAllowPublicToRemove(boolean allowPublicToRemove) {
		this.allowPublicToRemove = allowPublicToRemove;
	}

	/**
	 * @param activeWSList
	 *            the activeWSList to set
	 * @uml.property name="activeWSList"
	 */
	public void setActiveWSList(List<WorkingSet> activeWSList) {
		this.activeWSList = activeWSList;
	}

	/**
	 * @param activeWSUsersList
	 *            the activeWSUsersList to set
	 * @uml.property name="activeWSUsersList"
	 */
	public void setActiveWSUsersList(List<User> activeWSUsersList) {
		this.activeWSUsersList = activeWSUsersList;
	}

	/**
	 * @return the activeWSUsersList
	 * @uml.property name="activeWSUsersList"
	 */
	public List<User> getActiveWSUsersList() {
		List<User> set = new ArrayList<User>(0);
		WorkingSet activeWorkingSet = this.getConfigurationManager()
				.getSelectedWorkingSet();
		if (activeWorkingSet != null) {
			set = this.getWorkingSetBean().getSortedWorkingSetUsersList(activeWorkingSet);
		}
		return set;
	}

	/**
	 * @return the activeWSList
	 * @uml.property name="activeWSList"
	 */
	public List<WorkingSet> getActiveWSList() {
		List<WorkingSet> set = new ArrayList<WorkingSet>(0);
		if (this.isAllWS()) {
			set = this.getWorkingSetBean().getWorkingSetList(
					this.getUserManager().getUser());
		} else if (this.isPublicWS()) {
			set = this.getWorkingSetBean().getPublicWorkingSetList(
					this.getUserManager().getUser());
		} else {
			set = this.getWorkingSetBean().getSharedWorkingSetList(
					this.getUserManager().getUser());
		}
		return set;
	}

	/**
	 * @return the selectedWSUsersList
	 * @uml.property name="selectedWSUsersList"
	 */
	public List<User> getSelectedWSUsersList() {
		return selectedWSUsersList;
	}

	/**
	 * @param selectedWSList
	 *            the selectedWSList to set
	 * @uml.property name="selectedWSList"
	 */
	public void setSelectedWSList(List<WorkingSet> selectedWSList) {
		this.selectedWSList = selectedWSList;
	}

	/**
	 * @return the selectedWSList
	 * @uml.property name="selectedWSList"
	 */
	public List<WorkingSet> getSelectedWSList() {
		return selectedWSList;
	}

	/**
	 * @param selectedWSUsersList
	 *            the selectedWSUsersList to set
	 * @uml.property name="selectedWSUsersList"
	 */
	public void setSelectedWSUsersList(List<User> selectedWSUsersList) {
		this.selectedWSUsersList = selectedWSUsersList;
	}

	/**
	 * @param selectedWS
	 *            the selectedWS to set
	 * @uml.property name="selectedWS"
	 */
	public void setSelectedWS(WorkingSet selectedWS) {
		this.selectedWS = selectedWS;
	}

	/**
	 * @return the selectedWS
	 * @uml.property name="selectedWS"
	 */
	public WorkingSet getSelectedWS() {
		return selectedWS;
	}

	/**
	 * @param workingSetBean
	 *            the workingSetBean to set
	 * @uml.property name="workingSetBean"
	 */
	public void setWorkingSetBean(WorkingSetView workingSetBean) {
		this.workingSetBean = workingSetBean;
	}

	/**
	 * @return the workingSetBean
	 * @uml.property name="workingSetBean"
	 */
	public WorkingSetView getWorkingSetBean() {
		return workingSetBean;
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
	 * @return the name
	 * @uml.property name="name"
	 */
	public String getName() {
		return name;
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
	 * @return the description
	 * @uml.property name="description"
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param publicmode
	 *            the publicmode to set
	 * @uml.property name="publicmode"
	 */
	public void setPublicmode(boolean publicmode) {
		this.publicmode = publicmode;
	}

	/**
	 * @return the publicmode
	 * @uml.property name="publicmode"
	 */
	public boolean isPublicmode() {
		return publicmode;
	}

	/**
	 * @param sharedmode
	 *            the sharedmode to set
	 * @uml.property name="sharedmode"
	 */
	public void setSharedmode(boolean sharedmode) {
		this.sharedmode = sharedmode;
	}

	/**
	 * @return the sharedmode
	 * @uml.property name="sharedmode"
	 */
	public boolean isSharedmode() {
		return sharedmode;
	}

	/**
	 * @param overwrite
	 *            the overwrite to set
	 * @uml.property name="overwrite"
	 */
	public void setSaveAndOpenNewWS(boolean saveAndOpenNewWS) {
		this.saveAndOpenNewWS = saveAndOpenNewWS;
	}

	/**
	 * @return the overwrite
	 * @uml.property name="overwrite"
	 */
	public boolean isSaveAndOpenNewWS() {
		return saveAndOpenNewWS;
	}

	/**
	 * @param allWS
	 *            the allWS to set
	 * @uml.property name="allWS"
	 */
	public void setAllWS(boolean allWS) {
		this.allWS = allWS;
	}

	/**
	 * @return the allWS
	 * @uml.property name="allWS"
	 */
	public boolean isAllWS() {
		return allWS;
	}

	/**
	 * @param publicWS
	 *            the publicWS to set
	 * @uml.property name="publicWS"
	 */
	public void setPublicWS(boolean publicWS) {
		this.publicWS = publicWS;
	}

	/**
	 * @return the publicWS
	 * @uml.property name="publicWS"
	 */
	public boolean isPublicWS() {
		return publicWS;
	}

	/**
	 * @param sharedWS
	 *            the sharedWS to set
	 * @uml.property name="sharedWS"
	 */
	public void setSharedWS(boolean sharedWS) {
		this.sharedWS = sharedWS;
	}

	/**
	 * @return the sharedWS
	 * @uml.property name="sharedWS"
	 */
	public boolean isSharedWS() {
		return sharedWS;
	}

	/**
	 * @param overwriteResult
	 *            the overwriteResult to set
	 * @uml.property name="overwriteResult"
	 */
	public void setOverwriteResult(int overwriteResult) {
		this.overwriteResult = overwriteResult;
	}

	/**
	 * @return the overwriteResult
	 * @uml.property name="overwriteResult"
	 */
	public int getOverwriteResult() {
		return overwriteResult;
	}

	/**
	 * @param mergeToWorkingSet
	 *            the mergeToWorkingSet to set
	 * @uml.property name="mergeToWorkingSet"
	 */
	public void setMergeToWorkingSet(String mergeToWorkingSet) {
		WorkingSetController.mergeToWorkingSet = mergeToWorkingSet;
	}

	/**
	 * @return the mergeToWorkingSet
	 * @uml.property name="mergeToWorkingSet"
	 */
	public String getMergeToWorkingSet() {
		return mergeToWorkingSet;
	}

	/**
	 * @param mergeToWorkingSetLock
	 *            the mergeToWorkingSetLock to set
	 * @uml.property name="mergeToWorkingSetLock"
	 */
	public void setMergeToWorkingSetLock(boolean mergeToWorkingSetLock) {
		WorkingSetController.mergeToWorkingSetLock = mergeToWorkingSetLock;
	}

	/**
	 * @return the mergeToWorkingSetLock
	 * @uml.property name="mergeToWorkingSetLock"
	 */
	public boolean isMergeToWorkingSetLock() {
		return mergeToWorkingSetLock;
	}

	public String enableAllWS() {
		this.setAllWS(true);
		this.setPublicWS(false);
		this.setSharedWS(false);
		// Update the WS LIST
		return null;
	}

	public String enablePublicWS() {
		this.setAllWS(false);
		this.setPublicWS(true);
		this.setSharedWS(false);
		// Update the WS LIST
		return null;
	}

	public String enableSharedWS() {
		this.setAllWS(false);
		this.setPublicWS(false);
		this.setSharedWS(true);
		return null;
	}

	/**
	 * Finds component with the given id
	 */
	private UIComponent findComponent(UIComponent c, String id) {
		if (id.equals(c.getId())) {
			return c;
		}
		Iterator<UIComponent> kids = c.getFacetsAndChildren();
		while (kids.hasNext()) {
			UIComponent found = findComponent(kids.next(), id);
			if (found != null) {
				return found;
			}
		}
		return null;
	}

	public void setInfoMessage(UIComponent component, String summary,
			String description,
			javax.faces.application.FacesMessage.Severity severityInfo) {

		FacesContext.getCurrentInstance().addMessage(
				component.getClientId(FacesContext.getCurrentInstance()),
				new FacesMessage(severityInfo, summary, description));

	}

	public void afterPhase(PhaseEvent event) {

		System.out.println("Calling afterPhase function " + event.getPhaseId());
	}

	public void initMergeToWS(PhaseEvent event) {

	}

	public void initSwitchToWS(PhaseEvent event) {

	}

	public void initWS(PhaseEvent event) {

	}

	public void initCreateWS(PhaseEvent event) {

	}

	public void valueChangeMergeToWS(AjaxEvent event) {
		WorkingSet ws = null;
		if (!WorkingSetController.mergeToWorkingSetLock) {
			if (this.getSelectedWS() != null) {
				ws = this.getSelectedWS();
				this.setSelectedWS(null);
				WorkingSetController.mergeToWorkingSet = ws.getName();
				System.out.println("valueChangeMergeToWS called for: "
						+ ws.getName());
			} else {
				// Set global error as "Invalid selection"
			}
		}

	}

	public void valueChangeSaveAsWS(ActionEvent event) {
		WorkingSet ws = null;

		if (this.getSelectedWS() != null) {
			ws = this.getSelectedWS();
			this.setSelectedWS(null);
			this.setName(ws.getName());
			this.setDescription(ws.getDesc());
			this.setPublicmode(ws.isPublic_status());
			this.setSharedmode(ws.isShared_mode());

		}

	}

	public void valueChangeEditWS(ActionEvent event) {
		System.out.println("Calling ValueChangeEditWS function");
		WorkingSet ws = null;
		ws = this.getSelectedWS();
		System.out.println("Working Set name:" + ws.getName());
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (ws != null && (ws.getWid() > 0)) {
			this.setName(ws.getName());
			this.setDescription(ws.getDesc());
			this.setPublicmode(ws.isPublic_status());
			this.setSharedmode(ws.isShared_mode());
			if (this.isPublicmode()) {
				SharedUser publicSetting = this.getWorkingSetBean()
						.getPublicSetting(ws, this.getUserManager().getUser());
				if (publicSetting == null) {
					this.setAllowPublicToAdd(false);
					this.setAllowPublicToRemove(false);
				} else {
					this.setAllowPublicToAdd(publicSetting
							.isAllowAddOperation());
					this.setAllowPublicToRemove(publicSetting
							.isAllowRemoveOperation());
				}
			} else {
				this.setAllowPublicToAdd(false);
				this.setAllowPublicToRemove(false);
			}

		} else {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] No working set selected.");
			context.addMessage("msg", message);
		}

	}

	public boolean checkWSNameDuplicacy(String name) {
		List<WorkingSet> dupList = this.getWorkingSetBean().findByName(
				this.getUserManager().getUser(), name);
		if (dupList.size() > 0) {
			return true;
		}
		return false;
	}

	public void newWS(ActionEvent event) {
		WorkingSet myWS = this.getConfigurationManager().getMyWorkingSet();
		User user = this.getUserManager().getUser();
		if (user.getUserConfiguration() != null
				&& user.getUserConfiguration().isRememberLastWorkingSet()) {
			this.getWorkingSetBean()
					.updateLastOpenedWorkingSetInUserConfiguration(user, myWS);
		} else {
			if (!this.getWorkingSetBean().clearWorkingSet(myWS, user)) {
				System.out.println("Error in processing");
			}
		}

		this.getConfigurationManager().setSelectedWorkingSet(myWS);
		this.getConfigurationManager().setActiveWSPublic(false);
		this.getConfigurationManager().setActiveWSShared(false);
	}

	public String getActiveWorkingSetName() {
		return this.getConfigurationManager().getSelectedWorkingSet().getName();
	}

	public String getActiveWorkingSetDescription() {
		return this.getConfigurationManager().getSelectedWorkingSet().getDesc();
	}

	public String editWS() {
		WorkingSet ws = this.getSelectedWS();
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (ws != null && (ws.getWid() != 0)) {
			this.getWorkingSetBean().updateWorkingSet(this.getSelectedWS(),
					this.getUserManager().getUser(), this.getName(),
					this.getDescription(), this.isPublicmode(),
					this.isAllowPublicToAdd(), this.isAllowPublicToRemove(),
					this.isSharedmode());
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("[" + new Date()
					+ "] Working Set saved successfully.");
			context.addMessage("msg", message);
		} else {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] No working set selected.");
			context.addMessage("msg", message);
		}
		return null;
	}

	public String createWorkingSet() {
		System.out.println("Description:" + this.getDescription());
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		User user = this.getUserManager().getUser();
		if (this.checkWSNameDuplicacy(this.getName())) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] Working set name \'"
					+ this.getName() + "\' already exists.");
			context.addMessage("msg", message);
			return null;

		}
		WorkingSet ws = this.getWorkingSetBean().createWS(this.getName(),
				this.getDescription(), user);
		if (ws == null) {

			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("[" + new Date()
					+ "] Unknown Error: Cannot create working set \'"
					+ this.getName() + "\'.");
			context.addMessage("msg", message);
			return null;
		} else {
			// load the list of users in old active working set into the new
			// active working set
			this.getWorkingSetBean().addUsersToWorkingSet(
					ws,
					new ArrayList<User>(this.getWorkingSetBean()
							.getWorkingSetUsers(
									this.getConfigurationManager()
											.getSelectedWorkingSet())));
			// update the active working set with the newly created working
			// set if option is selected
			if (this.isSaveAndOpenNewWS()) {
				this.getConfigurationManager().setSelectedWorkingSet(ws);
				if (user.getUserConfiguration() != null
						&& user.getUserConfiguration()
								.isRememberLastWorkingSet()) {
					this.getWorkingSetBean()
							.updateLastOpenedWorkingSetInUserConfiguration(
									user, ws);
				}
			}
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("[" + new Date() + "] Working set \'"
					+ this.getName() + "\' created successfully.");
			context.addMessage("msg", message);
		}

		return null;
	}

	public List<SelectItem> getWorkingSetUsers() {
		List<User> users = this.getActiveWSUsersList();
		List<SelectItem> sItems = new ArrayList<SelectItem>();
		SelectItem sItem = null;
		for (User user : users) {
			sItem = new SelectItem(user, user.getFullName());
			sItems.add(sItem);
		}
		return sItems;
	}

	public String openWS() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		System.out.println("Calling Open Working Set function.");
		WorkingSet ws = this.getSelectedWS();
		System.out.println("Working Set name:" + ws.getName());
		User user = this.getUserManager().getUser();
		System.out.println("User name:" + user.getFullName());
		if (ws != null) {
			this.getConfigurationManager().setSelectedWorkingSet(ws);
			if (!ws.isPublic_status()) {
				this.getConfigurationManager().setActiveWSPublic(false);
			} else {
				this.getConfigurationManager().setActiveWSPublic(true);
				SharedUser publicSetting = this.getWorkingSetBean()
						.getPublicSetting(ws, this.getUserManager().getUser());
				if (publicSetting == null) {
					this.getConfigurationManager().setAllowPublicWSAdd(false);
					this.getConfigurationManager()
							.setAllowPublicWSRemove(false);
				} else {
					this.getConfigurationManager().setAllowPublicWSAdd(
							publicSetting.isAllowAddOperation());
					this.getConfigurationManager().setAllowPublicWSRemove(
							publicSetting.isAllowRemoveOperation());
				}
			}
			if (user.getUserConfiguration() != null
					&& user.getUserConfiguration().isRememberLastWorkingSet()) {
				this
						.getWorkingSetBean()
						.updateLastOpenedWorkingSetInUserConfiguration(user, ws);
			}
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary("[" + new Date() + "]" + ws.getName()
					+ " opened successfully");
			context.addMessage("msg", message);

		} else {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date()
					+ "] Please select a working set");
			context.addMessage("msg", message);

		}
		return null;

	}

	public void clearWS(ActionEvent event) {
		WorkingSet ws = this.getConfigurationManager().getSelectedWorkingSet();
		User user = this.getUserManager().getUser();
		if (!this.getWorkingSetBean().clearWorkingSet(ws, user)) {
			System.out.println("Error in processing");
		}
	}

	public void deleteWSUsers(ActionEvent event) {
		System.out.println("Calling Delete Function");
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		WorkingSet ws = null;
		if (this.getSelectedWSUsersList().isEmpty()) {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] None selected");
			context.addMessage("msg", message);
			return;
		}
		ws = this.getConfigurationManager().getSelectedWorkingSet();
		if (!this.getUserManager().getUser().getUid().equals(
				this.getConfigurationManager().getSelectedWorkingSet()
						.getCreatedBy())
				&& this.getConfigurationManager().isActiveWSPublic()) {
			if (!this.getConfigurationManager().isAllowPublicWSRemove()) {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] You do not sufficient permissions to "
						+ "remove users from this public working set.");
				context.addMessage("msg", message);
				return;
			}
		}
		if (ws != null) {
			if (this.getWorkingSetBean().deleteWSUsers(ws,
					this.getSelectedWSUsersList())) {
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary("[" + new Date()
						+ "] User(s) deleted from working set.");
				context.addMessage("msg", message);

			} else {
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary("[" + new Date()
						+ "] Unknown error: Selected user(s) not deleted.");
				context.addMessage("msg", message);
			}
			return;
		} else {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date()
					+ "] Error: No working set selected.");
			context.addMessage("msg", message);
			return;
		}

	}

	public String deleteWS() {
		System.out.println("Calling Delete Function - delete ws");
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		WorkingSet ws = this.getSelectedWS();
		WorkingSet activeWS = this.getConfigurationManager()
				.getSelectedWorkingSet();
		if (ws == null) {
			
			message.setSummary("[" + new Date() + "] None selected");
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			context.addMessage("msg", message);
			return null;
		} else {
			if (!activeWS.equals(ws)) {
				if (this.getWorkingSetBean().deleteWS(
						this.getConfigurationManager().getUser(), ws)) {
					message.setSummary("[" + new Date() + "] Working set deleted successfully");
					message.setSeverity(FacesMessage.SEVERITY_INFO);
					context.addMessage("msg", message);
				} else {
					message.setSummary("[" + new Date() + "] Unknown error! - Cannot delete Working set");
					message.setSeverity(FacesMessage.SEVERITY_ERROR);
					context.addMessage("msg", message);
				}
			} else {
				message.setSummary("[" + new Date() + "] Cannot delete currently opened Working set");
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				context.addMessage("msg", message);
			}

			return null;

		}

	}

	/**
	 * Update the Active Working set with the selected working set
	 * 
	 * @author keerthi
	 * @param workingsetService
	 * @return boolean
	 */
	public boolean updateActiveWorkingSet(WorkingSet activeWorkingSetPtr) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (activeWorkingSetPtr == null) {
			message.setSummary("[" + new Date() + "] Unknown error! - Cannot update active working set with new working set");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage("msg", message);
			return false;
		}
		WorkingSet ws = activeWorkingSetPtr;
		if (ws != null) {
			Set<User> users = new HashSet<User>(0);
			users = this.getWorkingSetBean().getWorkingSetUsers(ws);
			this.getWorkingSetBean()
					.setWorkingSetUsers(
							this.getConfigurationManager()
									.getSelectedWorkingSet(), users);

			return true;
		}
		return false;
	}

	/*
	 * public String disconnectLink() { long activeWorkingSetPtrID = -1;
	 * this.getConfigurationManager().setActiveWorkingSetPtr(-1, "X");
	 * activeWorkingSetPtrID = this.getConfigurationManager()
	 * .getActiveWorkingSetPtrID(); if (activeWorkingSetPtrID == -1) {
	 * message.setSummary("[" + new Date() + "] true,
	 * "Please select a working set !"); return null; } else { this
	 * .getConfigurationManager() .setActiveWorkingSetStatusMessage( true, new
	 * String( "Unknown error! - Cannot unsync the active working set "));
	 * return null; }
	 * 
	 * }
	 */

	/**
	 * Save the Active Working Set content or users list to the actual Working
	 * Set<br/>
	 * The content of the actual Working Set will be replaced with the content
	 * of the Active Working Set <br/>
	 * Actual Working Set - Set of Working Sets created by the CEPIS USer <br/>
	 * 
	 * @author keerthi
	 * @param activeWorkingSetPtr
	 * @return boolean
	 */
	/*
	 * public boolean saveActiveWorkingSet(WorkingSet activeWorkingSetPtr) {
	 * 
	 * if (activeWorkingSetPtr == null) { return false; } WorkingSet ws =
	 * activeWorkingSetPtr; if (ws != null) { List<User> users = new
	 * ArrayList<User>(0); ws.setUsers(new ArrayList<User>(0)); users =
	 * this.getWorkingSetBean().getWorkingSetUsers(
	 * this.getConfigurationManager().getSelectedWorkingSet());
	 * this.getWorkingSetBean().setWorkingSetUsers(ws, users);
	 * this.getConfigurationManager().setActiveWorkingSetSaved(true); return
	 * true; } return false; }
	 * 
	 * public String saveActiveWorkingSet() { WorkingSet activeWorkingSetPtr =
	 * null; long activeWorkingSetPtrID = -1; activeWorkingSetPtrID =
	 * this.getConfigurationManager() .getActiveWorkingSetPtrID(); if
	 * (activeWorkingSetPtrID == -1) {
	 * message.setSummary("[" + new Date() + "] true,
	 * "Please select a working set!"); return null; } activeWorkingSetPtr =
	 * this.getWorkingSetBean().getActiveWorkingSetPtr(
	 * this.getUserManager().getUser(), activeWorkingSetPtrID); if
	 * (this.saveActiveWorkingSet(activeWorkingSetPtr)) {
	 * this.getWorkingSetBean().saveWorkingSet(activeWorkingSetPtr);
	 * message.setSummary("[" + new Date() + "] false,
	 * new String("The Active Working Set is insync with " +
	 * activeWorkingSetPtr.getName())); return null; } else {
	 * message.setSummary("[" + new Date() + "] true,
	 * new String( "Unknown error! - Cannot save the active working set to " +
	 * activeWorkingSetPtr.getName())); return null; }
	 * 
	 * }
	 * 
	 * public List<User> getSampleData() {
	 * 
	 * if (this.getWorkingSetBean().addUsersToWorkingSet(
	 * this.getConfigurationManager().getSelectedWorkingSet(),
	 * this.getWorkingSetBean().getSampleData())) {
	 * 
	 * message.setSummary("[" + new Date() + "] false,
	 * new String("User(s) added to the active working set"));
	 * this.getConfigurationManager().setActiveWorkingSetSaved(false);
	 * 
	 * } else { this .getConfigurationManager()
	 * .setActiveWorkingSetStatusMessage( true, new String(
	 * "Unknown error! - User(s) not added to the active working set")); }
	 * return this.getActiveWSUsersList(); }
	 */

	public String merge() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		WorkingSet activeWorkingSet = this.getConfigurationManager()
				.getSelectedWorkingSet();

		if (activeWorkingSet == null) {
			// invalid first working set
			message.setSummary("[" + new Date() + "] Unknown error - Cannot access working set");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage("msg", message);
			return null;
		}
		if (this.getWorkingSetBean().MergeWorkingSets(
				this.getUserManager().getUser(), activeWorkingSet,
				this.getSelectedWSList(), false)) {
			message.setSummary("[" + new Date() + "] Working sets were merged to "
							+ activeWorkingSet.getName() + " successfully");
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			context.addMessage("msg", message);

			return null;
		} else {
			message.setSummary("[" + new Date() + "] Unknown error! - Cannot merge Working Set(s)");
			return null;
		}

	}

	public String mergeAndDelete() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		WorkingSet activeWorkingSet = this.getConfigurationManager()
				.getSelectedWorkingSet();

		if (activeWorkingSet == null) {
			// invalid first working set
			message.setSummary("[" + new Date() + "] Unknown error - Cannot access working set");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage("msg", message);
			return null;
		}

		if (this.getSelectedWSList().contains(activeWorkingSet)) {
			// Final selection should not have activeWorkingSet
			message.setSummary("[" + new Date() + "] Selected Working Sets should not contain opened working set ("
									+ activeWorkingSet.getName() + ")");
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			context.addMessage("msg", message);
			return null;
		}
		if (this.getWorkingSetBean().MergeWorkingSets(
				this.getUserManager().getUser(), activeWorkingSet,
				this.getSelectedWSList(), true)) {
			message.setSummary("[" + new Date() + "] Working sets were merged to "
							+ activeWorkingSet.getName() + " successfully");
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			context.addMessage("msg", message);

			return null;
		} else {
			message.setSummary("[" + new Date() + "] Unknown error! - Cannot merge Working Set(s)");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage("msg", message);
			return null;
		}
	}

	/**
	 * @param showSaveWSModalWindow
	 *            the showSaveWSModalWindow to set
	 */
	public void setShowSaveWSModalWindow(boolean showSaveWSModalWindow) {
		this.showSaveWSModalWindow = showSaveWSModalWindow;
	}

	/**
	 * @return the showSaveWSModalWindow
	 */
	public boolean isShowSaveWSModalWindow() {
		return showSaveWSModalWindow;
	}

	/**
	 * @return the publicSummary
	 */
	public String getPublicSummary() {
		StringBuffer summary = new StringBuffer();
		summary.append("Allowed operations: View");
		if (isAllowPublicToAdd()) {
			summary.append(", Add");
		}
		if (isAllowPublicToRemove()) {
			summary.append(", Remove");
		}
		summary.append(".");
		return summary.toString();
	}

	/**
	 * @param wsPanelStatus
	 *            the wsPanelStatus to set
	 */
	public void setWsPanelStatus(Object wsPanelStatus) {
		System.out
				.println("Setting wsPanelStatus: " + wsPanelStatus.toString());
		this.wsPanelStatus = wsPanelStatus;
	}

	/**
	 * @return the wsPanelStatus
	 */
	public Object getWsPanelStatus() {
		System.out.println("Getting wsPanelStatus: " + wsPanelStatus);
		return wsPanelStatus;
	}
}
