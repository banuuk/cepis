/**
 * 
 */
package edu.uky.cepis.authenticator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ldap.NamingException;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.ldap.authentication.AbstractLdapAuthenticator;
import org.springframework.security.ldap.ppolicy.PasswordPolicyControl;
import org.springframework.security.ldap.ppolicy.PasswordPolicyControlExtractor;
import org.springframework.util.StringUtils;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.service.UserService;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;

/**
 * Authenticator class used by LDAP+CEPIS_Database authentication module or CAS
 * (Central authentication Service) + LDAP + CEPIS_Database authentication
 * module.<br/>
 * <br/>
 * If LDAP + CEPIS_Database is used, this class is configured in
 * applicationContext-backup.xml<br/>
 * If CAS + LDAP + CEPIS_Database is used, this class is configured in
 * applicationContext.xml<br/>
 * <br/>
 * By default, CAS module is enabled for production releases.<br/>
 * LDAP + CEPIS_Database module is created for development and testing purpose
 * only.<br/>
 * It's no harm to use LDAP + CEPIS_Database in production, but CAS can be used
 * as an central authentication for all future modules to be integrated to the
 * portal.<br/>
 * <br/>
 * <br/>
 * This class is configured with other Spring security configurations.<br/>
 * <br/>
 * STEP 1: Perform the UKY LDAP Authentication<br/>
 * STEP 2: Perform CEPIS Local Database Authentication<br/>
 * There may be a initial step for CAS configuration.<br/>
 * 
 * @author keerthi <br/>
 */

public class CepisAuthenticator extends AbstractLdapAuthenticator {

	private static final Log log = LogFactory.getLog(CepisAuthenticator.class);
	private UserService service;

	// ~ Constructors
	// ===================================================================================================

	/**
	 * Create an initialized instance using the
	 * {@link BaseLdapPathContextSource} provided.
	 * 
	 * @param contextSource
	 *            the BaseLdapPathContextSource instance against which bind
	 *            operations will be performed.
	 * 
	 */
	public CepisAuthenticator(BaseLdapPathContextSource contextSource) {
		super(contextSource);
	}

	// ~ Methods
	// ========================================================================================================

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

	public DirContextOperations authenticate(Authentication authentication) {
		DirContextOperations user = null;
		if (authentication == null) {
			if (log.isDebugEnabled()) {
				log.debug("Authentication object is null. "
						+ messages.getMessage("cepis.portal.msg.internalError"));
			}
			throw new BadCredentialsException(messages.getMessage(
					"cepis.portal.msg.internalError",
					"Internal Error: Contact TEB 166."));
		}
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();

		if (!StringUtils.hasLength(username)
				|| !StringUtils.hasLength(password)) {
			log.debug(messages
					.getMessage("cepis.portal.msg.emptyUsernamePassword"));
			throw new BadCredentialsException(messages.getMessage(
					"cepis.portal.msg.emptyUsernamePassword",
					"Empty Username/Password"));
		}

		if (log.isDebugEnabled()) {
			log.debug("Step 1: Performing CEPIS Local Authenrication.");
		}
		// STEP 1: Perform UK CEPIS Authentication to avoid unnecessary LDAP
		// Check if the user name is not in the CEPIS Database
		User cepis_user = service.findByUsername(username.trim());
		if (cepis_user == null) {
			log.debug((messages.getMessage(
					"cepis.portal.msg.step1BadCredentials", "Bad credentials.")));
			throw new BadCredentialsException(messages.getMessage(
					"cepis.portal.msg.step1BadCredentials", "Bad credentials."));
		}
		if (cepis_user.getEnabled() == 0) {
			log.debug((messages.getMessage("cepis.portal.msg.disabledAccount",
					"Account Disabled.")));
			throw new BadCredentialsException(messages.getMessage(
					"cepis.portal.msg.disabledAccount", "Account Disabled."));
		}
		if (log.isDebugEnabled()) {
			log.debug("CEPIS Local Authentication is successfull. Input Username: "
					+ username
					+ ", CEPIS Username: "
					+ cepis_user.getUsername()
					+ ", Fullname: "
					+ cepis_user.getFullName());
		}

		if (log.isDebugEnabled()) {
			log.debug("Step 2: Performing CEPIS UKY LDAP Authenrication.");
		}
		// STEP2: Perform the UKY LDAP Authentication
		// If DN patterns are configured, try authenticating with them directly
		for (String dn : getUserDns(username)) {
			user = bindWithDn(dn, username, password);

			if (user != null) {
				break;
			}
		}

		// Otherwise use the configured search object to find the user and
		// authenticate with the returned DN.
		if (user == null && getUserSearch() != null) {
			DirContextOperations userFromSearch = getUserSearch()
					.searchForUser(username);
			user = bindWithDn(userFromSearch.getDn().toString(), username,
					password);
		}

		if (user == null) {
			log.debug((messages.getMessage(
					"cepis.portal.msg.step2BadCredentials", "Bad credentials.")));
			throw new BadCredentialsException(messages.getMessage(
					"cepis.portal.msg.step2BadCredentials", "Bad credentials."));
		}

		log.debug("CEPIS UKY LDAP Authentication is successfull. Input Username: "
				+ username);

		return user;
	}

	private DirContextOperations bindWithDn(String userDnStr, String username,
			String password) {
		BaseLdapPathContextSource ctxSource = (BaseLdapPathContextSource) getContextSource();
		DistinguishedName userDn = new DistinguishedName(userDnStr);
		DistinguishedName fullDn = new DistinguishedName(userDn);
		fullDn.prepend(ctxSource.getBaseLdapPath());

		log.debug("Attempting to bind as " + fullDn);

		DirContext ctx = null;
		try {
			ctx = getContextSource().getContext(fullDn.toString(), password);
			// Check for password policy control
			PasswordPolicyControl ppolicy = PasswordPolicyControlExtractor
					.extractControl(ctx);

			log.debug("Retrieving attributes...");

			Attributes attrs = ctx.getAttributes(userDn, getUserAttributes());

			DirContextAdapter result = new DirContextAdapter(attrs, userDn,
					ctxSource.getBaseLdapPath());

			if (ppolicy != null) {
				result.setAttributeValue(ppolicy.getID(), ppolicy);
			}

			return result;
		} catch (NamingException e) {
			// This will be thrown if an invalid user name is used and the
			// method may
			// be called multiple times to try different names, so we trap the
			// exception
			// unless a subclass wishes to implement more specialized behaviour.
			if ((e instanceof org.springframework.ldap.AuthenticationException)
					|| (e instanceof org.springframework.ldap.OperationNotSupportedException)) {
				handleBindException(userDnStr, username, e);
			} else {
				throw e;
			}
		} catch (javax.naming.NamingException e) {
			throw LdapUtils.convertLdapException(e);
		} finally {
			LdapUtils.closeContext(ctx);
		}

		return null;
	}

	/**
	 * Allows subclasses to inspect the exception thrown by an attempt to bind
	 * with a particular DN. The default implementation just reports the failure
	 * to the debug log.
	 */
	protected void handleBindException(String userDn, String username,
			Throwable cause) {
		if (log.isDebugEnabled()) {
			log.debug("Failed to bind as " + userDn + ": " + cause);
		}
	}

}
