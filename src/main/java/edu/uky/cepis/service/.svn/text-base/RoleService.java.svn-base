/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import edu.uky.cepis.domain.Role;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public interface RoleService {
	public abstract boolean addRoleToUserAccount(User user, Role userRole);

	public abstract boolean addRolesToUserAccount(User user,
			List<Role> userRoles);

	public abstract boolean revokeRoleFromUserAccount(User user, Role userRole);

	public abstract boolean revokeRolesFromUserAccount(User user,
			List<Role> userRoles);

	public abstract List<User> getUserRoleStatistics(Role userRole);

	public abstract Role createRole(String roleName, String roleDescription);

	public abstract Role createRole(String roleName, String roleDescription,
			String otherInformation);

	public abstract boolean deleteRole(Role role);

	public abstract boolean deleteRole(String roleName);

	public abstract Role findRole(long id);

	public abstract Role findByName(String roleName);

	public abstract List<Role> getUserRoles(User user);

	public abstract Role updateRole(Role role, String roleName,
			String roleDescription, String otherInformation);
	
	public abstract List<Role> getRoleList();

	public abstract Role getCustomRole();
}
