/**
 * 
 */
package edu.uky.cepis.manager;

import java.io.Serializable;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.apache.log4j.Logger;

import edu.uky.cepis.domain.User;
import edu.uky.cepis.service.UserService;

/**
 * User Manager for CEPIS system - maintains user information and role details<br/>
 * This session bean can be accessed using scopedTarget.userManager from
 * HttpSession<br/>
 * 
 * @author keerthi
 */
public class UserManager extends CEPISManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property name="auth"
	 */
	private Authentication auth;
	/**
	 * @uml.property name="isValid"
	 */
	private boolean isValid;
	private static Logger logger = Logger.getLogger(UserManager.class);

	public UserManager() {
		this.isValid = false;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating UserManager object ...");
		}
	}

	public boolean init(Properties properties) {
		UserService userservice = (UserService) properties.get("UserService");
		if (logger.isDebugEnabled()) {
			logger.debug("Initializing UserManager object ...");
		}
		return this.initUserManager(userservice);
	}

	public boolean initUserManager(UserService userservice) {
		auth = (Authentication) SecurityContextHolder.getContext()
				.getAuthentication();
		User currentuser = null;
		if (auth != null) {
			if (userservice != null) {
				currentuser = (User) userservice.findByUsername(auth.getName());
			} else {
				if (logger.isDebugEnabled()) {
					logger.debug("User Service is null. Please initialize Service object properly.");
				}
				return false;
			}

			if (currentuser != null) {
				this.setUser(currentuser);
				super.setUser(currentuser);
				this.isValid = auth.isAuthenticated();
				if (isValid) {
					if (logger.isDebugEnabled()) {
						logger.debug("User " + this.getUser().getUsername()
								+ " is authenticated");
					}
				} else {
					if (logger.isDebugEnabled()) {
						logger.debug("User is not authenticated");
					}
				}
				return true;
			} else {
				if (logger.isDebugEnabled()) {
					logger.debug("No valid User found with the username "
							+ auth.getName());
				}
				return false;
			}
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("Invalid Authentication - No Acegi Authentication Object Found");
			}
			return false;
		}

	}

	/**
	 * @return the auth
	 * @uml.property name="auth"
	 */
	public Authentication getAuth() {
		return auth;
	}

	/**
	 * @param isValid
	 *            the isValid to set
	 * @uml.property name="isValid"
	 */
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	/**
	 * @return the isValid
	 * @uml.property name="isValid"
	 */
	public boolean isValid() {
		return isValid;
	}

}
