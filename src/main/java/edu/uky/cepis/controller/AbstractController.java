/**
 * 
 */
package edu.uky.cepis.controller;

import java.io.Serializable;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.manager.ConfigurationManager;
import edu.uky.cepis.manager.UserManager;

/**
 * @author keerthi
 */
public class AbstractController implements Serializable,Controller {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property name="userManager"
	 * @uml.associationEnd
	 */
	protected static UserManager userManager;
	/**
	 * @uml.property name="configurationManager"
	 * @uml.associationEnd
	 */
	protected static ConfigurationManager configurationManager;


	
	
	
	/**
	 * @return the userManager
	 * @uml.property name="userManager"
	 */
	@Override
	public UserManager getUserManager() {
		return userManager;
	}

	/**
	 * @param userManager
	 *            the userManager to set
	 * @uml.property name="userManager"
	 */
	@Override
	public void setUserManager(UserManager userManager) {
		AbstractController.userManager = userManager;
	}

	/**
	 * @return the configurationManager
	 * @uml.property name="configurationManager"
	 */
	@Override
	public ConfigurationManager getConfigurationManager() {
		return configurationManager;
	}

	/**
	 * @param configurationManager
	 *            the configurationManager to set
	 * @uml.property name="configurationManager"
	 */
	@Override
	public void setConfigurationManager(
			ConfigurationManager configurationManager) {
		AbstractController.configurationManager = configurationManager;
	}


}
