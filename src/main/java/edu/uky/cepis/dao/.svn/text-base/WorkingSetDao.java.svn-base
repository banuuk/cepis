/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.uky.cepis.domain.Role;
import edu.uky.cepis.domain.SharedUser;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserConfiguration;
import edu.uky.cepis.domain.WorkingSet;

/**
 * @author keerthi
 * 
 */
public interface WorkingSetDao {

	/**
	 * Add a set of {@link User} objects to the given {@link WorkingSet}.<br/>
	 * <br/>
	 * 
	 * @param ws
	 * @param users
	 * @return boolean
	 * 
	 */
	public abstract boolean addUsersToWorkingSet(WorkingSet ws, List<User> users);

	/**
	 * Add a {@link User} object to the given {@link WorkingSet} object.
	 * 
	 * @param ws
	 * @param userid
	 * @return boolean
	 */
	public abstract boolean addUserToWorkingSet(WorkingSet ws, String userid);

	/**
	 * Add a {@link User} object to the given {@link WorkingSet}.<br/>
	 * <br/>
	 * 
	 * @param ws
	 * @param user
	 * @return boolean
	 * 
	 */
	public abstract boolean addUserToWorkingSet(WorkingSet ws, User user);

	/**
	 * 
	 * Remove all the {@link User} objects in the given {@link WorkingSet}
	 * object.
	 * 
	 * @param ws
	 * @param user
	 * @return boolean
	 */
	public boolean clearWorkingSet(WorkingSet ws, User user);

	/**
	 * Create a new {@link WorkingSet} for a {@link User} with the given Working
	 * Set name<br/>
	 * Working set name should be unique<br/>
	 * <br/>
	 * 
	 * @param user
	 * @param name
	 * @return {@link WorkingSet}
	 */
	public abstract WorkingSet createWorkingSet(User user, String name);

	/**
	 * Create a new {@link WorkingSet} for a {@link User} with given Working Set
	 * name<br/>
	 * Working set name should be unique<br/>
	 * Working Set Sharing mode and Public mode should be included. <br/>
	 * <br/>
	 * 
	 * @param user
	 *            - User
	 * @param name
	 *            - Working Set name
	 * @param public_status
	 *            - Share this working set to public.
	 * @param shared_mode
	 *            - Share this working set with other users
	 * @return {@link WorkingSet}
	 */
	public abstract WorkingSet createWorkingSet(User user, String name,
			boolean public_status, boolean shared_mode);

	/**
	 * Create a new {@link WorkingSet} object for a {@link User} object with
	 * given Working Set name and description<br/>
	 * Working set name should be unique.<br/>
	 * <br/>
	 * 
	 * @param user
	 * @param name
	 * @param desc
	 * @return {@link WorkingSet}
	 */
	public abstract WorkingSet createWorkingSet(User user, String name,
			String desc);

	/**
	 * Create a new {@link WorkingSet} object for a {@link User} object with
	 * given Working Set name<br/>
	 * Working set name should be unique<br/>
	 * Working Set Sharing mode and Public mode should be mentioned. <br/>
	 * <br/>
	 * 
	 * @param user
	 *            - User
	 * @param name
	 *            - Working Set name
	 * @param desc
	 *            - Description
	 * @param public_status
	 *            - Share this working set to public.
	 * @param shared_mode
	 *            - Share this working set with other users
	 * @return {@link WorkingSet}
	 */
	public abstract WorkingSet createWorkingSet(User user, String name,
			String desc, boolean public_status, boolean shared_mode);

	/**
	 * Remove a {@link User} object from the given {@link WorkingSet} object.<br/>
	 * <br/>
	 * 
	 * @param ws
	 * @param user
	 * @return boolean
	 * 
	 */
	public abstract boolean deleteUserFromWorkingSet(WorkingSet ws, User user);

	/**
	 * Delete a set of {@link User} objects from the given {@link WorkingSet}
	 * object.<br/>
	 * <br/>
	 * 
	 * @param ws
	 * @param users
	 * @return boolean
	 * 
	 */
	public abstract boolean deleteUsersFromWorkingSet(WorkingSet ws,
			List<User> users);

	/**
	 * Delete the given {@link WorkingSet} object from the given {@link User}
	 * object. object.
	 * 
	 * @param user
	 * @param ws
	 * @return boolean
	 */
	public abstract boolean deleteWorkingSet(User user, WorkingSet ws);

	/**
	 * Delete {@link WorkingSet} objects from the given {@link User} object.<br/>
	 * <br/>
	 * 
	 * @param user
	 * @param wss
	 * @return boolean
	 */
	public abstract boolean deleteWorkingSets(User user, List<WorkingSet> wss);

	/**
	 * Find the List of {@link WorkingSet} objects by its owner and working set
	 * name<br/>
	 * <br/>
	 * 
	 * @param createdBy
	 * @param workingsetName
	 * @return {@link List}
	 */
	public abstract List<WorkingSet> findByName(String createdBy,
			String workingsetName);

	/**
	 * Find a {@link WorkingSet} object by working set id of type long.
	 * 
	 * @param wid
	 * @return {@link WorkingSet}
	 */
	public abstract WorkingSet findWorkingSet(long wid);

	/**
	 * Find {@link WorkingSet} object by its owner name and working set id<br/>
	 * <br/>
	 * 
	 * @param createdBy
	 * @param wid
	 * @return {@link WorkingSet}
	 */
	public abstract WorkingSet findWorkingSet(String createdBy, long wid);

	/**
	 * *Get the last opened {@link WorkingSet} object information from the
	 * {@link UserConfiguration} object. This function checks the
	 * isRememberLastWorkingSet() function in the {@link UserConfiguration}
	 * object to perform this action.
	 * 
	 * @param user
	 * @return {@link WorkingSet}
	 */
	public WorkingSet getLastOpenedWorkingSetInUserConfiguration(User user);

	/**
	 * Get the list of {@link User} objects to whom the given {@link WorkingSet}
	 * object is shared with.
	 * 
	 * @param workingSet
	 * @param user
	 * @return {@link SharedUser}
	 */
	public abstract SharedUser getPublicSetting(WorkingSet workingSet, User user);

	/**
	 * 
	 * Get the list of public {@link WorkingSet} objects. This can be acheived
	 * by searching for {@link WorkingSet} objects with the function
	 * {@link WorkingSet#isPublic_status()} returning true.
	 * 
	 * @param user
	 * @return {@link List}
	 */
	public abstract List<WorkingSet> getPublicWorkingSetList(User user);

	/**
	 * 
	 * Get the list of shared {@link WorkingSet} objects. For each
	 * {@link WorkingSet#isPublic_status()} object, It looks for
	 * {@link WorkingSet#isShared_mode()} = true and the given {@link User}
	 * object in the {@link WorkingSet#isPublic_status()} {@link User} object
	 * list.
	 * 
	 * @param user
	 * @return {@link List}
	 */
	public abstract List<WorkingSet> getSharedWorkingSetList(User user);

	/**
	 * Get sorted {@link User} objects of the given {@link WorkingSet} object.
	 * 
	 * @param ws
	 * @return {@link List}
	 */
	public List<User> getSortedWorkingSetUsersList(WorkingSet ws);

	/**
	 * Get the List of {@link WorkingSet} created by the given {@link User}
	 * object. <br/>
	 * 
	 * @param user
	 * @return {@link Set}
	 */
	public abstract List<WorkingSet> getWorkingSetList(User user);

	/**
	 * Get the list of {@link WorkingSet} name of a {@link User} object.<br/>
	 * <br/>
	 * 
	 * @param user
	 * @return {@link Map}
	 * @see Map
	 */
	public abstract Map<Long, String> getWorkingSetMap(User user);

	/**
	 * Get the set of {@link User} objects in the given {@link WorkingSet}
	 * object.
	 * 
	 * @author keerthi
	 * @param activeWorkingSet
	 * @return {@link Set}
	 */
	public abstract Set<User> getWorkingSetUsersList(WorkingSet activeWorkingSet);

	/**
	 * Merge two or more {@link WorkingSet} objects into {@link WorkingSet}
	 * firstWorkingSet. Usually the {@link WorkingSet} firstWorkingSet will be
	 * the currently opened {@link WorkingSet} object.<br/>
	 * <br/>
	 * If a set of {@link WorkingSet} objects are merged, then content of
	 * {@link WorkingSet} objects will be added to the {@link WorkingSet}
	 * firstWorkingSet.<br/>
	 * <br/>
	 * If mergeToFirst is set to false, the {@link WorkingSet} objects will be
	 * merged to the current working set.<br/>
	 * <br/>
	 * Set {{@link WorkingSet} objects - {@link WorkingSet} firstWorkingSet}
	 * will be deleted if deleteRemains is set to true<br/>
	 * <br/>
	 * 
	 * @param user
	 * @param firstWorkingSet
	 * @param wss
	 * @param boolean
	 * @param boolean
	 * @return boolean
	 */
	public abstract boolean mergeWorkingSets(User user,
			WorkingSet firstWorkingSet, List<WorkingSet> wss,
			boolean deleteRemains);

	/**
	 * Merge two {@link WorkingSet} objects into one.<br/>
	 * If {@link WorkingSet} WS1 and {@link WorkingSet} WS2 are merged, then
	 * content of {@link WorkingSet} WS2 will be added to {@link WorkingSet} WS1
	 * and WS2 will be deleted<br/>
	 * <br/>
	 * 
	 * @param user
	 * @param ws1
	 * @param ws2
	 * @return boolean
	 */
	public abstract boolean mergeWorkingSets(User user, WorkingSet ws1,
			WorkingSet ws2);

	/**
	 * Get the Default {@link WorkingSet} object for the gieven {@link User}
	 * object. Usually, the name of this {@link WorkingSet} object will have the
	 * following format: <code>New Working Set* (MURKX-0801) </code> <br/>
	 * This object is created when the {@link User} logs into the portal for the
	 * first time.<br/>
	 * 
	 * 
	 * @param createdBy
	 * @return {@link WorkingSet}
	 */
	public abstract WorkingSet retrieveMyWorkingSet(String createdBy);

	/**
	 * 
	 * Assign the given {@link WorkingSet} to the given {@link User} object for
	 * the custom roles (ROLE_CUSTOM).
	 * 
	 * @param ws
	 * @param user
	 * @return {@link WorkingSet}
	 * @see Role
	 */
	public abstract WorkingSet setCustomWorkingSetToUser(WorkingSet ws,
			User user);

	/**
	 * Set the {@link User} objects for the given {@link WorkingSet} object.
	 * 
	 * @param ws
	 * @param users
	 * @return boolean
	 */
	public abstract boolean setWorkingSetUsersList(WorkingSet ws,
			Set<User> users);

	/**
	 * Enable Share option for the given {@link WorkingSet} object.
	 * 
	 * @param ws
	 * @param user
	 * @return {@link WorkingSet}
	 */
	public abstract WorkingSet shareWorkingSet(WorkingSet ws, User user);

	/**
	 * Switch to/Open the given {@link WorkingSet} from the {@link User} 
	 * object's {@link WorkingSet} object list.<br/>
	 * <br/>
	 * 
	 * @param ws
	 * @return {@link WorkingSet}
	 */
	public abstract WorkingSet switchToWorkingSet(User user, WorkingSet ws);

	/**
	 * 
	 * Update the last opened {@link WorkingSet} object information in the
	 * {@link UserConfiguration} object. This function checks the
	 * isRememberLastWorkingSet() function in the {@link UserConfiguration}
	 * object to perform this action.
	 * 
	 * @param user
	 * @param ws
	 * @return boolean
	 * @see UserConfiguration#isRememberLastWorkingSet()
	 */
	public boolean updateLastOpenedWorkingSetInUserConfiguration(User user,
			WorkingSet ws);

	/**
	 * Update the given {@link WorkingSet} object.
	 * 
	 * @param workingSet
	 * @param user
	 * @param name
	 * @param desc
	 * @param public_status
	 * @param allowPublicAdd
	 * @param allowPublicRemove
	 * @param shared_mode
	 * @return {@link WorkingSet}
	 */
	public abstract WorkingSet updateWorkingSet(WorkingSet workingSet,
			User user, String name, String desc, boolean public_status,
			boolean allowPublicAdd, boolean allowPublicRemove,
			boolean shared_mode);

}
