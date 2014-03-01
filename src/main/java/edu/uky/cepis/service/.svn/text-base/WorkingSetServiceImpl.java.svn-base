/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.uky.cepis.dao.WorkingSetDao;
import edu.uky.cepis.domain.SharedUser;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.WorkingSet;

/**
 * @author keerthi
 */
public class WorkingSetServiceImpl implements WorkingSetService {

	/**
	 * @uml.property name="workingSetDao"
	 * @uml.associationEnd
	 */
	private WorkingSetDao workingSetDao = null;

	/**
	 * @return the userDao
	 * @uml.property name="workingSetDao"
	 */
	public WorkingSetDao getWorkingSetDao() {
		return workingSetDao;
	}

	/**
	 * @param userDao
	 *            the userDao to set
	 * @uml.property name="workingSetDao"
	 */
	public void setWorkingSetDao(WorkingSetDao workingSetDao) {
		this.workingSetDao = workingSetDao;
	}

	@Override
	public WorkingSet createWorkingSet(User user, String name) {
		return workingSetDao.createWorkingSet(user, name);
	}

	@Override
	public WorkingSet createWorkingSet(User user, String name,
			boolean public_status, boolean shared_mode) {
		return workingSetDao.createWorkingSet(user, name, public_status,
				shared_mode);
	}

	@Override
	public WorkingSet createWorkingSet(User user, String name, String desc) {
		return workingSetDao.createWorkingSet(user, name, desc);
	}

	@Override
	public WorkingSet createWorkingSet(User user, String name, String desc,
			boolean public_status, boolean shared_mode) {
		return workingSetDao.createWorkingSet(user, name, desc, public_status,
				shared_mode);
	}

	@Override
	public boolean addUserToWorkingSet(WorkingSet ws, User user) {
		return workingSetDao.addUserToWorkingSet(ws, user);
	}

	@Override
	public boolean addUsersToWorkingSet(WorkingSet ws, List<User> users) {
		return workingSetDao.addUsersToWorkingSet(ws, users);
	}

	@Override
	public boolean deleteUserFromWorkingSet(WorkingSet ws, User user) {
		return workingSetDao.deleteUserFromWorkingSet(ws, user);
	}

	@Override
	public boolean deleteUsersFromWorkingSet(WorkingSet ws, List<User> users) {
		return workingSetDao.deleteUsersFromWorkingSet(ws, users);
	}

	@Override
	public boolean deleteWorkingSet(User user, WorkingSet ws) {
		return workingSetDao.deleteWorkingSet(user, ws);
	}

	@Override
	public boolean deleteWorkingSets(User user, List<WorkingSet> wss) {
		return workingSetDao.deleteWorkingSets(user, wss);
	}

	@Override
	public boolean mergeWorkingSets(User user, WorkingSet ws1, WorkingSet ws2) {
		return workingSetDao.mergeWorkingSets(user, ws1, ws2);
	}

	@Override
	public List<WorkingSet> findByName(String createdBy, String workingsetName) {
		return workingSetDao.findByName(createdBy, workingsetName);
	}

	@Override
	public WorkingSet findWorkingSet(String createdBy, long wid) {
		return workingSetDao.findWorkingSet(createdBy, wid);
	}

	@Override
	public WorkingSet switchToWorkingSet(User user, WorkingSet ws) {
		return workingSetDao.switchToWorkingSet(user, ws);
	}

	@Override
	public Map<Long, String> getWorkingSetMap(User user) {
		return workingSetDao.getWorkingSetMap(user);
	}

	@Override
	public List<WorkingSet> getWorkingSetList(User user) {
		return this.workingSetDao.getWorkingSetList(user);
	}

	@Override
	public boolean mergeWorkingSets(User user, WorkingSet firstWorkingSet,
			List<WorkingSet> wss, boolean deleteRemains) {
		return this.workingSetDao.mergeWorkingSets(user, firstWorkingSet, wss,
				deleteRemains);
	}

	@Override
	public Set<User> getWorkingSetUsersList(WorkingSet ws) {
		return this.workingSetDao.getWorkingSetUsersList(ws);
	}

	@Override
	public WorkingSet retrieveMyWorkingSet(String createdBy) {

		return this.workingSetDao.retrieveMyWorkingSet(createdBy);
	}

	@Override
	public boolean setWorkingSetUsersList(WorkingSet ws, Set<User> users) {
		return this.getWorkingSetDao().setWorkingSetUsersList(ws, users);
	}

	@Override
	public WorkingSet shareWorkingSet(WorkingSet ws, User user) {
		return this.getWorkingSetDao().shareWorkingSet(ws, user);
	}

	@Override
	public WorkingSet setCustomWorkingSetToUser(WorkingSet ws, User user) {
		return this.getWorkingSetDao().setCustomWorkingSetToUser(ws, user);
	}

	@Override
	public boolean updateLastOpenedWorkingSetInUserConfiguration(User user,
			WorkingSet ws) {
		return this.getWorkingSetDao()
				.updateLastOpenedWorkingSetInUserConfiguration(user, ws);
	}

	@Override
	public WorkingSet getLastOpenedWorkingSetInUserConfiguration(User user) {
		return this.getWorkingSetDao()
				.getLastOpenedWorkingSetInUserConfiguration(user);
	}

	@Override
	public boolean clearWorkingSet(WorkingSet ws, User user) {
		return this.getWorkingSetDao().clearWorkingSet(ws, user);
	}

	@Override
	public List<User> getSortedWorkingSetUsersList(WorkingSet ws) {
		return this.getWorkingSetDao().getSortedWorkingSetUsersList(ws);
	}

	@Override
	public List<WorkingSet> getPublicWorkingSetList(User user) {
		return this.getWorkingSetDao().getPublicWorkingSetList(user);
	}

	@Override
	public List<WorkingSet> getSharedWorkingSetList(User user) {
		return this.getWorkingSetDao().getSharedWorkingSetList(user);
	}

	@Override
	public boolean addUserToWorkingSet(WorkingSet ws, String userid) {
		return this.getWorkingSetDao().addUserToWorkingSet(ws, userid);
	}

	@Override
	public WorkingSet findWorkingSet(long wid) {
		return this.getWorkingSetDao().findWorkingSet(wid);
	}

	@Override
	public SharedUser getPublicSetting(WorkingSet workingSet, User user) {

		return this.getWorkingSetDao().getPublicSetting(workingSet, user);
	}

	@Override
	public WorkingSet updateWorkingSet(WorkingSet workingSet, User user,
			String name, String desc, boolean publicStatus,
			boolean allowPublicAdd, boolean allowPublicRemove,
			boolean sharedMode) {
		return this.getWorkingSetDao().updateWorkingSet(workingSet, user, name,
				desc, publicStatus, allowPublicAdd, allowPublicRemove,
				sharedMode);
	}

}
