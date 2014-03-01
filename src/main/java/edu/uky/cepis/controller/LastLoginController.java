/**
 * 
 */
package edu.uky.cepis.controller;

import org.apache.log4j.Logger;

import edu.uky.cepis.domain.IPAddress;
import edu.uky.cepis.domain.LastLogin;
import edu.uky.cepis.view.LastLoginView;

/**
 * View Controller used to display the Last Login History information in the browser<br/>
 * @see LastLoginLognone
 * @author  keerthi
 */
public class LastLoginController extends AbstractController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="lastLoginBean"
	 * @uml.associationEnd  
	 */
	private LastLoginView lastLoginBean;
	private static Logger log = Logger.getLogger(LastLoginController.class);

	public LastLoginController() {

	}

	/**
	 * @param lastLoginBean  the lastLoginBean to set
	 * @uml.property  name="lastLoginBean"
	 */
	public void setLastLoginBean(LastLoginView lastLoginBean) {
		this.lastLoginBean = lastLoginBean;
	}

	/**
	 * @return  the lastLoginBean
	 * @uml.property  name="lastLoginBean"
	 */
	public LastLoginView getLastLoginBean() {
		return lastLoginBean;
	}

	
	/**
	 * @return IPAddress array
	 * @see IPAddress
	 */
	public IPAddress[] getUserIpAddresses() {
		if(this.getUserManager()==null)
			return null;
		return this.getLastLoginBean().getIpAddress(
				this.getUserManager().getUser());
	}

	/**
	 * @return LastLogin
	 * @see LastLogin
	 */
	public LastLogin[] getUserLastLogins() {
		if(this.getUserManager()==null)
			return null;
		return this.getLastLoginBean().getLastLogin(
				this.getUserManager().getUser());
	}

}
