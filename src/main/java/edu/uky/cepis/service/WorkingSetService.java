/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.uky.cepis.domain.SharedUser;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.WorkingSet;

/**
 * @author keerthi
 * 
 */
public interface WorkingSetService {

	public abstract WorkingSet createWorkingSet(User user, String name);

	public abstract WorkingSet createWorkingSet(User user, String name,
			boolean public_status, boolean shared_mode);

	public abstract WorkingSet createWorkingSet(User user, String name,
			String desc);

	public abstract WorkingSet createWorkingSet(User user, String name,
			String desc, boolean public_status, boolean shared_mode);

	public abstract boolean deleteWorkingSet(User user, WorkingSet ws);

	public abstract boolean deleteWorkingSets(User user, List<WorkingSet> wss);

	public abstract boolean addUserToWorkingSet(WorkingSet ws, User user);

	public abstract boolean addUsersToWorkingSet(WorkingSet ws, List<User> users);

	public abstract boolean deleteUserFromWorkingSet(WorkingSet ws, User user);

	public abstract boolean deleteUsersFromWorkingSet(WorkingSet ws,
			List<User> users);

	public abstract boolean mergeWorkingSets(User user, WorkingSet ws1,
			WorkingSet ws2);

	public abstract WorkingSet findWorkingSet(String createdBy, long wid);

	public abstract List<WorkingSet> findByName(String createdBy,
			String workingsetName);

	public abstract WorkingSet switchToWorkingSet(User user, WorkingSet ws);

	public abstract Map<Long, String> getWorkingSetMap(User user);

	/**
	 * Get the List of WorkingSet created by the current user <br/>
	 * 
	 * @param user
	 * @return Set
	 */
	public abstract List<WorkingSet> getWorkingSetList(User user);

	/**
	 * Merge two or more working sets into first working set if mergeToFirst is
	 * set to true.<br/>
	 * If Set of WSs are merged, then content of WSs will be added to WS1.<br/>
	 * If mergeToFirst is set to false, the Wss will be merged to the current
	 * working set<br/>
	 * Set {WSs - WS1} will be deleted if deleteRemains is set to true<br/>
	 * <br/>
	 * 
	 * @param user
	 * @param wss
	 * @param boolean
	 * @param boolean
	 * @return boolean
	 * @see User
	 * @see WorkingSet
	 */
	public abstract boolean mergeWorkingSets(User user,
			WorkingSet firstWorkingSet, List<WorkingSet> wss,
			boolean deleteRemains);

	/**
	 * Get the List of users in a working set
	 * 
	 * @param ws
	 * @return Set
	 */
	public abstract Set<User> getWorkingSetUsersList(WorkingSet activeWorkingSet);

	/**
	 * Get the Active Working Set object from databse<br/>
	 * This object is created while login to the system<br/>
	 * 
	 * 
	 * @author keerthi
	 * @param createdBy
	 * @return boolean
	 */
	public abstract WorkingSet retrieveMyWorkingSet(String createdBy);

	/**
	 * Set the List of users in a working set
	 * 
	 * @param ws
	 * @param users
	 * @return boolean
	 */
	public abstract boolean setWorkingSetUsersList(WorkingSet ws,
			Set<User> users);

	public abstract SharedUser getPublicSetting(WorkingSet workingSet, User user);

	public abstract WorkingSet updateWorkingSet(WorkingSet workingSet,
			User user, String name, String desc, boolean public_status,
			boolean allowPublicAdd, boolean allowPublicRemove,
			boolean shared_mode);

	public abstract WorkingSet shareWorkingSet(WorkingSet ws, User user);

	public abstract WorkingSet setCustomWorkingSetToUser(WorkingSet ws,
			User user);

	public boolean updateLastOpenedWorkingSetInUserConfiguration(User user,
			WorkingSet ws);

	public WorkingSet getLastOpenedWorkingSetInUserConfiguration(User user);

	public boolean clearWorkingSet(WorkingSet ws, User user);

	public List<User> getSortedWorkingSetUsersList(WorkingSet ws);

	public abstract List<WorkingSet> getPublicWorkingSetList(User user);

	public abstract List<WorkingSet> getSharedWorkingSetList(User user);

	public abstract boolean addUserToWorkingSet(WorkingSet ws, String userid);

	public abstract WorkingSet findWorkingSet(long wid);
}
