/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.List;
import edu.uky.cepis.domain.Role;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public interface RoleDao {

	/**
	 * Add a Role to an User account<br/>
	 * <br/>
	 * 
	 * @param user
	 * @param userRole
	 * @return boolean
	 * @see User
	 * @see Role
	 */
	public abstract boolean addRoleToUserAccount(User user, Role userRole);

	/**
	 * Add Set of Roles to an User Account<br/>
	 * <br/>
	 * 
	 * @param user
	 * @param userRoles
	 * @return boolean
	 * @see User
	 * @see Role
	 */
	public abstract boolean addRolesToUserAccount(User user, List<Role> userRoles);

	/**
	 * Revoke a Role from an User account<br/>
	 * <br/>
	 * 
	 * @param user
	 * @param userRole
	 * @return boolean
	 * @see User
	 * @see Role
	 */
	public abstract boolean revokeRoleFromUserAccount(User user, Role userRole);

	/**
	 * Revoke Set of Roles from an User Account<br/>
	 * <br/>
	 * 
	 * @param user
	 * @param userRoles
	 * @return boolean
	 * @see User
	 * @see Role
	 */
	public abstract boolean revokeRolesFromUserAccount(User user,
			List<Role> userRoles);

	/**
	 * List the set of Users that belongs to a Role<br/>
	 * <br/>
	 * 
	 * @param userRole
	 * @return Set
	 * @see User
	 * @see Role
	 */
	public abstract List<User> getUserRoleStatistics(Role userRole);

	/**
	 * Create a new Role for CEPIS System<br/>
	 * <br/>
	 * 
	 * @param roleName
	 * @param roleDescription
	 * @return Role
	 * @see User
	 * @see Role
	 */
	public abstract Role createRole(String roleName, String roleDescription);

	/**
	 * Create a new Role for CEPIS System<br/>
	 * <br/>
	 * 
	 * @param roleName
	 * @param roleDescription
	 * @param otherInformation
	 * @return Role
	 * @see User
	 * @see Role
	 */
	public abstract Role createRole(String roleName, String roleDescription,
			String otherInformation);
	
	public abstract Role updateRole(Role role, String roleName, String roleDescription,
			String otherInformation);

	/**
	 * Delete a role from CEPIS System<br/>
	 * <br/>
	 * 
	 * @param role
	 * @return boolean
	 * @see User
	 * @see Role
	 */
	public abstract boolean deleteRole(Role role);

	/**
	 * Delete a role from CEPIS System<br/>
	 * <br/>
	 * 
	 * @param roleName
	 * @return boolean
	 * @see User
	 * @see Role
	 */
	public abstract boolean deleteRole(String roleName);

	/**
	 * Find a role by its id.<br/>
	 * <br/>
	 * 
	 * @param id
	 * @return Role
	 * @see User
	 * @see Role
	 */
	public abstract Role findRole(long id);

	/**
	 * Find the List of Roles by its name<br/>
	 * <br/>
	 * 
	 * @param roleName
	 * @return List
	 * @see User
	 * @see Role
	 */
	public abstract Role findByName(String roleName);

	/**
	 * Get the list of Roles of an user<br/>
	 * <br/>
	 * 
	 * @param user
	 * @return Set
	 * @see User
	 * @see Role
	 */
	public abstract List<Role> getUserRoles(User user);

	public abstract List<Role> getRoleList();


}
