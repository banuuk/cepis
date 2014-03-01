/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import edu.uky.cepis.dao.RoleDao;
import edu.uky.cepis.domain.Role;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 */
public class RoleServiceImpl implements RoleService {

	/**
	 * @uml.property  name="roleDao"
	 * @uml.associationEnd  
	 */
	private RoleDao roleDao = null;

	/**
	 * @return the roleDao
	 * @uml.property name="roleDao"
	 */
	public RoleDao getRoleDao() {
		return roleDao;
	}

	/**
	 * @param roleDao
	 *            the roleDao to set
	 * @uml.property name="roleDao"
	 */
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public boolean addRoleToUserAccount(User user, Role userRole) {
		return roleDao.addRoleToUserAccount(user, userRole);

	}

	@Override
	public boolean addRolesToUserAccount(User user, List<Role> userRoles) {
		return roleDao.addRolesToUserAccount(user, userRoles);

	}

	@Override
	public Role createRole(String roleName, String roleDescription) {
		return roleDao.createRole(roleName, roleDescription);
	}

	@Override
	public Role createRole(String roleName, String roleDescription,
			String otherInformation) {
		return roleDao.createRole(roleName, roleDescription, otherInformation);
	}

	@Override
	public boolean deleteRole(Role role) {
		return roleDao.deleteRole(role);
	}

	@Override
	public boolean deleteRole(String roleName) {
		return roleDao.deleteRole(roleName);
	}

	@Override
	public Role findByName(String roleName) {
		return roleDao.findByName(roleName);
	}

	@Override
	public Role findRole(long id) {
		return roleDao.findRole(id);
	}

	@Override
	public List<User> getUserRoleStatistics(Role userRole) {
		return roleDao.getUserRoleStatistics(userRole);
	}

	@Override
	public boolean revokeRoleFromUserAccount(User user, Role userRole) {
		return roleDao.revokeRoleFromUserAccount(user, userRole);

	}

	@Override
	public boolean revokeRolesFromUserAccount(User user, List<Role> userRoles) {
		return roleDao.revokeRolesFromUserAccount(user, userRoles);

	}

	@Override
	public List<Role> getUserRoles(User user) {
		return roleDao.getUserRoles(user);
	}

	@Override
	public Role updateRole(Role role, String roleName, String roleDescription,
			String otherInformation) {

		return this.getRoleDao().updateRole(role, roleName, roleDescription,
				otherInformation);
	}

	@Override
	public List<Role> getRoleList() {

		return this.getRoleDao().getRoleList();
	}

	@Override
	public Role getCustomRole() {
		Role role = this.getRoleDao().findByName("CUSTOM");
		if (role != null) {
			return role;
		}
		return null;
	}

}
