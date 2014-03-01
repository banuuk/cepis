/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import edu.uky.cepis.domain.Role;
import edu.uky.cepis.domain.User;

/**
 * Dao class that performs operation on the CEPIS User Roles.<br/>
 * <br/>
 * 
 * @author keerthi
 * @see HibernateDaoSupport
 * @see HibernateTemplate
 * @see Role
 * 
 */
public class RoleDaoImpl implements RoleDao {
	private static Logger log = Logger.getLogger(RoleDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.RoleDao#addRoleToUserAccount(edu.uky.cepis.domain.User,
	 * edu.uky.cepis.domain.Role)
	 */
	@Override
	public boolean addRoleToUserAccount(User user, Role userRole) {
		if (log.isInfoEnabled()) {
			log.info("Role " + userRole.getRolename() + " added to the User "
					+ user.getUsername());
		}
		if (user == null) {
			return false;
		}
		if (userRole == null) {
			return false;
		}

		Role newrole = null;
		newrole = (Role) this.sessionFactory.getCurrentSession().load(
				Role.class, userRole.getRoleid());
		User newuser = null;
		newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());

		if (!newuser.getRoles().contains(newrole)) {
			newuser.getRoles().add(newrole);
			this.sessionFactory.getCurrentSession().saveOrUpdate(newuser);
		}
		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.RoleDao#addRolesToUserAccount(edu.uky.cepis.domain.
	 * User, java.util.Set)
	 */
	@Override
	public boolean addRolesToUserAccount(User user, List<Role> userRoles) {

		if (user == null) {
			return false;
		}
		if (userRoles == null) {
			return false;
		}

		User newuser = null;
		newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());

		Iterator<Role> iter = userRoles.iterator();
		List<Role> newroles = new ArrayList<Role>(0);
		Role role = null;
		while (iter.hasNext()) {
			role = iter.next();
			if (!newuser.getRoles().contains(role)) {
				newroles.add(role);
			}
		}

		if (newuser.getRoles().addAll(newroles)) {
			this.sessionFactory.getCurrentSession().saveOrUpdate(newuser);
			if (log.isInfoEnabled()) {
				log.info("Roles added to the User " + user.getUsername());
			}
			return true;
		}
		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.RoleDao#createRole(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Role createRole(String roleName, String roleDescription) {
		if (roleName == null)
			return null;

		Role role = new Role(roleName, roleDescription);
		if (role == null)
			return null;
		this.sessionFactory.getCurrentSession().saveOrUpdate(role);
		return role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.RoleDao#createRole(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public Role createRole(String roleName, String roleDescription,
			String otherInformation) {
		if (roleName == null)
			return null;

		Role role = new Role(roleName, roleDescription, otherInformation);
		if (role == null)
			return null;
		this.sessionFactory.getCurrentSession().saveOrUpdate(role);
		return role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.RoleDao#deleteRole(edu.uky.cepis.domain.Role)
	 */
	@Override
	public boolean deleteRole(Role role) {
		if (role == null)
			return false;

		Role deleteRole = (Role) this.sessionFactory.getCurrentSession().load(
				Role.class, role.getRoleid());
		if (deleteRole != null) {
			this.sessionFactory.getCurrentSession().delete(deleteRole);
			return true;
		} else
			return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.RoleDao#deleteRole(java.lang.String)
	 */
	@Override
	public boolean deleteRole(String roleName) {
		if (roleName == null)
			return false;

		Role deleteRole = this.findByName(roleName);
		if (deleteRole == null) {
			return false;
		}
		this.sessionFactory.getCurrentSession().delete(deleteRole);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.RoleDao#findByName(java.lang.String)
	 */
	@Override
	public Role findByName(String roleName) {
		List<Role> roles = null;
		Role role = null;

		String hql = "select a from Role a where a.rolename = '" + roleName
				+ "'";
		roles = this.sessionFactory.getCurrentSession().createQuery(hql).list();
		if (roles.size() > 0) {
			role = roles.get(0);
		}
		return role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.RoleDao#findRole(long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Role findRole(long id) {
		Role role = null;
		List<Role> roles = null;

		String hql = "select a from Role a where a.roleid =" + id;
		roles = this.sessionFactory.getCurrentSession().createQuery(hql).list();
		if (roles.size() > 0) {
			role = roles.get(0);
		}
		return role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.RoleDao#getUserRoleStatistics(edu.uky.cepis.domain.
	 * Role)
	 */
	@Override
	public List<User> getUserRoleStatistics(Role userRole) {
		if (userRole == null) {
			return null;
		}

		Role role = (Role) this.sessionFactory.getCurrentSession().load(
				Role.class, userRole.getRoleid());
		if (role != null) {
			List<User> users = role.getUsers();
			Iterator<User> iter = users.iterator();
			return users;
		} else
			return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.RoleDao#revokeRoleFromUserAccount(edu.uky.cepis.domain
	 * .User, edu.uky.cepis.domain.Role)
	 */
	@Override
	public boolean revokeRoleFromUserAccount(User user, Role userRole) {
		if (log.isInfoEnabled()) {
			log.info("Role " + userRole.getRolename()
					+ " revoked from the User " + user.getUsername());
		}
		if (user == null) {
			return false;
		}
		if (userRole == null) {
			return false;
		}

		Role newrole = null;
		newrole = (Role) this.sessionFactory.getCurrentSession().load(
				Role.class, userRole.getRoleid());

		User newuser = null;
		newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());

		if (!newuser.getRoles().contains(newrole)) {
			
		}	
		newuser.getRoles().remove(newrole);
		this.sessionFactory.getCurrentSession().saveOrUpdate(newuser);
		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.RoleDao#revokeRolesFromUserAccount(edu.uky.cepis.domain
	 * .User, java.util.Set)
	 */
	@Override
	@Transactional
	public boolean revokeRolesFromUserAccount(User user, List<Role> userRoles) {	
		if (log.isInfoEnabled()) {
			log.info("Roles revoked from the User " + user.getUsername());
		}
		if (user == null) {
			return false;
		}
		if (userRoles == null) {
			return false;
		}	
												
		User newUser = null;
		newUser = (User) this.sessionFactory.getCurrentSession().load(User.class, user.getUid());	
		
		List<Role> newRoleList = newUser.getRoles();
		
		newRoleList.removeAll(userRoles);
			
		newUser.getRoles().retainAll(newRoleList);
			
		this.sessionFactory.getCurrentSession().saveOrUpdate(newUser);			
		return true;
		
	}
	
		


	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.RoleDao#getUserRoles(edu.uky.cepis.domain.User)
	 */
	@Override
	public List<Role> getUserRoles(User user) {

		if (user == null)
			return null;
		List<Role> roles = new ArrayList<Role>(0);

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());

		if (newuser != null) {
			// this.sessionFactory.getCurrentSession().enableFilter("myFilter").setParameter("myFilterParam",
			// true);
			roles = newuser.getRoles();
			Iterator<Role> iter = roles.iterator();
			Role role = null;
			while (iter.hasNext()) {
				role = iter.next();
				System.out.println(" Role Detail:  " + role);
			}
			return roles;
		}
		return null;
	}

	@Override
	public Role updateRole(Role role, String roleName, String roleDescription,
			String otherInformation) {
		if (role == null) {
			return role;
		}

		Role newrole = (Role) this.sessionFactory.getCurrentSession().load(
				Role.class, role.getRoleid());
		newrole.setRolename(roleName);
		newrole.setRoledesc(roleDescription);
		newrole.setOtherInfo(otherInformation);
		this.sessionFactory.getCurrentSession().saveOrUpdate(newrole);
		return newrole;
	}

	@Override
	public List<Role> getRoleList() {
		List<Role> roles = new ArrayList<Role>(0);

		String hql = "select a from Role a order by a.roleid";
		roles = this.sessionFactory.getCurrentSession().createQuery(hql).list();
		return roles;
	}

}
