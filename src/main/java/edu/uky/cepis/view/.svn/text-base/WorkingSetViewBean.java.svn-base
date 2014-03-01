package edu.uky.cepis.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.struts2.spring.StrutsSpringObjectFactory;

import edu.uky.cepis.domain.SharedUser;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.WorkingSet;

public class WorkingSetViewBean extends CepisWebView implements WorkingSetView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(WorkingSetViewBean.class);

	public WorkingSetViewBean() {

	}

	@Override
	public List<WorkingSet> findByName(User user, String name) {
		return this.getWorkingSetService().findByName(user.getUid(), name);
	}

	@Override
	public WorkingSet createWS(String name, String description, User user) {

		WorkingSet ws = this.getWorkingSetService().createWorkingSet(user,
				name, description, false, false);
		return ws;
		/*
		 * if (this.isSaveAs()) { System.out.println("Save As is set"); if
		 * (workingsetservice.addUsersToWorkingSet(ws, this
		 * .getCurrentWorkingSetUsers(false))) { if (log.isDebugEnabled()) {
		 * log.debug("Working set " + ws.getName() + " created with " +
		 * this.getCurrentWorkingSetUsers(false).size() + " users"); } // Reset
		 * the create workingset for users in current_workingset // flag.
		 * this.setSaveAs(false); } } else if (this.isMergeAs()) {
		 * System.out.println("Merge As is set");
		 * this.MergeWorkingSets(this.getActiveViewWSList(), false);
		 * this.setMergeAs(false); }
		 */

	}

	@Override
	public WorkingSet createWS(String name, String description, User user,
			boolean publicmode, boolean sharedmode) {

		WorkingSet ws = this.getWorkingSetService().createWorkingSet(user,
				name, description, publicmode, sharedmode);
		return ws;
	}

	@Override
	public boolean addUsersToWorkingSet(WorkingSet ws, List<User> users) {
		return this.getWorkingSetService().addUsersToWorkingSet(ws, users);
	}

	@Override
	public Set<User> getWorkingSetUsers(WorkingSet ws) {
		return this.getWorkingSetService().getWorkingSetUsersList(ws);
	}

	@Override
	public boolean setWorkingSetUsers(WorkingSet ws, Set<User> users) {
		return this.getWorkingSetService().setWorkingSetUsersList(ws, users);
	}

	@Override
	public boolean switchWS(String name, String description) {
		/*
		 * WorkingSet ws =
		 * workingsetservice.createWorkingSet(this.getCepisUser(), name,
		 * description, false, false); if (this.isSaveAs()) {
		 * System.out.println("Save As is set"); if
		 * (workingsetservice.addUsersToWorkingSet(ws, this
		 * .getCurrentWorkingSetUsers(false))) { if (log.isDebugEnabled()) {
		 * log.debug("Working set " + ws.getName() + " created with " +
		 * this.getCurrentWorkingSetUsers(false).size() + " users"); } // Reset
		 * the create workingset for users in current_workingset // flag.
		 * this.setSaveAs(false); } } else if (this.isMergeAs()) {
		 * System.out.println("Merge As is set");
		 * this.MergeWorkingSets(this.getActiveViewWSList(), false);
		 * this.setMergeAs(false); }
		 */
		return true;
	}

	@Override
	public List<WorkingSet> getWorkingSetList(User user) {
		return this.getWorkingSetService().getWorkingSetList(user);
	}

	@Override
	public boolean deleteWSUsers(WorkingSet activeWorkingSet,
			List<User> selectedUsers) {
		if (activeWorkingSet == null) {
			if (log.isDebugEnabled()) {
				log.debug("Active Working Set is null");
			}
			return false;
		}

		if (selectedUsers == null) {
			if (log.isDebugEnabled()) {
				log.debug("Selected Users List is null");
			}
			return false;
		}
		System.out.println("Selected WS Users count: " + selectedUsers.size());

		this.getWorkingSetService().deleteUsersFromWorkingSet(activeWorkingSet,
				selectedUsers);
		return true;
	}

	@Override
	public WorkingSet getActiveWorkingSetPtr(User user,
			Long activeWorkingSetPtrID) {
		WorkingSet activeWorkingSetPtr = null;
		activeWorkingSetPtr = this.getWorkingSetService().findWorkingSet(
				user.getUsername(), activeWorkingSetPtrID);
		return activeWorkingSetPtr;
	}


	@Override
	public boolean deleteWSs(User user, List<WorkingSet> wss) {
		return this.getWorkingSetService().deleteWorkingSets(user, wss);
	}

	@Override
	public boolean deleteWS(User user, WorkingSet ws) {
		return this.getWorkingSetService().deleteWorkingSet(user, ws);
	}

	@Override
	public boolean MergeWorkingSets(User user, WorkingSet firstWorkingSet,
			List<WorkingSet> wss, boolean deleteRemains) {

		return this.getWorkingSetService().mergeWorkingSets(user,
				firstWorkingSet, wss, deleteRemains);

	}

	@Override
	public boolean updateLastOpenedWorkingSetInUserConfiguration(User user,
			WorkingSet ws) {
		return this.getWorkingSetService()
				.updateLastOpenedWorkingSetInUserConfiguration(user, ws);
	}

	@Override
	public WorkingSet getLastOpenedWorkingSetInUserConfiguration(User user) {
		return this.getWorkingSetService()
				.getLastOpenedWorkingSetInUserConfiguration(user);
	}

	@Override
	public boolean clearWorkingSet(WorkingSet ws, User user) {

		return this.getWorkingSetService().clearWorkingSet(ws, user);
	}

	@Override
	public List<User> getSortedWorkingSetUsersList(WorkingSet ws) {
		return this.getWorkingSetService().getSortedWorkingSetUsersList(ws);
	}

	@Override
	public List<WorkingSet> getPublicWorkingSetList(User user) {
		return this.getWorkingSetService().getPublicWorkingSetList(user);
	}

	@Override
	public List<WorkingSet> getSharedWorkingSetList(User user) {
		return this.getWorkingSetService().getSharedWorkingSetList(user);
	}

	@Override
	public boolean addUserToWorkingSet(WorkingSet ws, String userid) {

		return this.getWorkingSetService().addUserToWorkingSet(ws, userid);
	}

	@Override
	public SharedUser getPublicSetting(WorkingSet workingSet, User user) {
		return this.getWorkingSetService().getPublicSetting(workingSet, user);
	}

	@Override
	public WorkingSet updateWorkingSet(WorkingSet workingSet, User user,
			String name, String desc, boolean publicStatus,
			boolean allowPublicAdd, boolean allowPublicRemove,
			boolean sharedMode) {
		return this.getWorkingSetService().updateWorkingSet(workingSet, user,
				name, desc, publicStatus, allowPublicAdd, allowPublicRemove,
				sharedMode);
	}
}
