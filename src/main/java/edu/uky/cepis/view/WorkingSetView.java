/**
 * 
 */
package edu.uky.cepis.view;

import java.util.List;
import java.util.Set;

import edu.uky.cepis.domain.SharedUser;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.WorkingSet;

/**
 * @author keerthi
 * 
 */
public interface WorkingSetView {

	public abstract WorkingSet createWS(String name, String description,
			User user);

	public abstract boolean deleteWSUsers(WorkingSet activeWorkingSet,
			List<User> selectedUser);

	public abstract WorkingSet getActiveWorkingSetPtr(User user,
			Long activeWorkingSetPtrID);

	public abstract List<WorkingSet> getWorkingSetList(User user);

	public abstract boolean switchWS(String name, String description);

	public abstract boolean setWorkingSetUsers(WorkingSet ws, Set<User> users);

	public abstract Set<User> getWorkingSetUsers(WorkingSet ws);

	public List<User> getSortedWorkingSetUsersList(WorkingSet ws);

	public abstract boolean addUsersToWorkingSet(WorkingSet ws, List<User> users);

	public abstract List<WorkingSet> findByName(User user, String name);

	public abstract boolean deleteWSs(User user, List<WorkingSet> wss);

	public abstract boolean MergeWorkingSets(User user,
			WorkingSet firstworkingSet, List<WorkingSet> wss,
			boolean deleteRemains);

	public abstract WorkingSet createWS(String name, String description,
			User user, boolean publicmode, boolean sharedmode);

	public abstract boolean deleteWS(User user, WorkingSet ws);

	public abstract SharedUser getPublicSetting(WorkingSet workingSet, User user);

	public abstract WorkingSet updateWorkingSet(WorkingSet workingSet,
			User user, String name, String desc, boolean public_status,
			boolean allowPublicAdd, boolean allowPublicRemove,
			boolean shared_mode);

	public boolean updateLastOpenedWorkingSetInUserConfiguration(User user,
			WorkingSet ws);

	public WorkingSet getLastOpenedWorkingSetInUserConfiguration(User user);

	public boolean clearWorkingSet(WorkingSet ws, User user);

	public abstract List<WorkingSet> getPublicWorkingSetList(User user);

	public abstract List<WorkingSet> getSharedWorkingSetList(User user);

	public abstract boolean addUserToWorkingSet(WorkingSet ws, String userid);

}
