/**
 * 
 */
package edu.uky.cepis.populator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.util.StringUtils;
import edu.uky.cepis.authenticator.CepisAuthenticator;
import edu.uky.cepis.domain.Role;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserCollegeProfile;
import edu.uky.cepis.service.UserService;
import edu.uky.cepis.view.AccountManagementView;

/**
 * @author Keerthi
 * 
 */
public final class CepisAuthoritiesPopulator implements	LdapAuthoritiesPopulator {

	private static final Log log = LogFactory.getLog(CepisAuthenticator.class);
	private UserService service;
	private AccountManagementView accountManagementBean;

	public CepisAuthoritiesPopulator() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator
	 * #getGrantedAuthorities
	 * (org.springframework.ldap.core.DirContextOperations, java.lang.String)
	 */
	@Override
	public Collection<? extends GrantedAuthority> getGrantedAuthorities(
			DirContextOperations userData, String username) {

		if (!StringUtils.hasLength(username)) {
			log.debug("Rejecting empty username for user.");
			return AuthorityUtils.NO_AUTHORITIES;
		}

		if (log.isDebugEnabled()) {
			log.debug("Fetching User Roles ....");
		}

		User cepis_user = service.findByUsername(username.trim());
		if (cepis_user == null) {
			log.debug("Username " + username
					+ " is not available in CEPIS Database. ");
			return AuthorityUtils.NO_AUTHORITIES;
		}

		if (log.isDebugEnabled()) {
			log.debug("Fetching roles ....");
		}
		List<Role> cepis_roles = this.getAccountManagementBean()
				.getUserRoleList(cepis_user);

		if (cepis_roles == null) {
			if (log.isDebugEnabled()) {
				log.debug("No roles associated with the username " + username);
			}
			return AuthorityUtils.NO_AUTHORITIES;

		}
		int no_of_roles = cepis_roles.size();
		if (no_of_roles <= 0) {
			if (log.isDebugEnabled()) {
				log.debug("No roles associated with the username "
						+ username
						+ ". Looking for Virtual roles from User College Profiles.");
			}
		}
		List<GrantedAuthority> userRoles = new ArrayList<GrantedAuthority>(0);

		Iterator<Role> iter = cepis_roles.iterator();
		while (iter.hasNext()) {
			userRoles
					.add(new SimpleGrantedAuthority(iter.next().getRolename()));

		}
		// Adding Virtual roles
		List<UserCollegeProfile> userCollegeProfiles = this
				.getAccountManagementBean().getUserCollegeProfiles(cepis_user);
		int activeProfiles = 0;
		if (userCollegeProfiles.size() <= 0) {
			if (log.isDebugEnabled()) {
				log.debug("No college profile associated with this username "
						+ username);
			}
		} else {
			if (log.isDebugEnabled()) {
				log.debug("Searching associated college profiles for "
						+ username + ". " + userCollegeProfiles.size()
						+ " UserCollegeProfile found.");
			}
			UserCollegeProfile userCollegeProfile = null;
			String code = null;
			Iterator<UserCollegeProfile> iterator = userCollegeProfiles
					.iterator();
			while (iterator.hasNext()) {
				userCollegeProfile = iterator.next();
				if (userCollegeProfile.getStatus() != null)
					if (userCollegeProfile.getStatus().getStatusCode().equals("ACTIVE")) {
						activeProfiles++;
						code = userCollegeProfile.getUserType().getTypeCode();
						if (code.equalsIgnoreCase("STU")) {
							userRoles.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
						} else if (code.equalsIgnoreCase("STA")) {
							userRoles.add(new SimpleGrantedAuthority("ROLE_STAFF"));
						} else if (code.equalsIgnoreCase("FAC")) {
							userRoles.add(new SimpleGrantedAuthority("ROLE_FACULTY"));
						}
					}

			}
		}
		if (activeProfiles < 1) {
			if (log.isDebugEnabled()) {
				log.debug("No active college profile associated with this username "
						+ username);
			}
			// FIXME: Add this in the next server update.
			// userRoles.clear();
		}
		if (userRoles.size() < 1) {
			if (log.isDebugEnabled()) {
				log.debug("No roles associated with the username " + username
						+ ".");
			}
			return AuthorityUtils.NO_AUTHORITIES;
		}

		return userRoles;
	}

	/**
	 * @return the service {@link edu.uky.cepis.service.UserService}
	 * @uml.property name="service"
	 */
	public UserService getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set {@link edu.uky.cepis.service.UserService}
	 * @uml.property name="service"
	 */
	public void setService(UserService service) {
		this.service = service;
	}

	/**
	 * @return the accountManagementBean
	 * @uml.property name="accountManagementBean"
	 */
	public AccountManagementView getAccountManagementBean() {
		return accountManagementBean;
	}

	/**
	 * @param accountManagementBean
	 *            the accountManagementBean to set
	 * @uml.property name="accountManagementBean"
	 */
	public void setAccountManagementBean(
			AccountManagementView accountManagementBean) {
		this.accountManagementBean = accountManagementBean;
	}

}
