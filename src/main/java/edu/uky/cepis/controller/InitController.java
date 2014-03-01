/**
 * 
 */
package edu.uky.cepis.controller;

import javax.faces.event.ActionEvent;
import edu.uky.cepis.init.InitCEPIS;

/**
 * View Controller to initialize the CEPIS user profile information using InitCEPIS<br/> It is checked in the Filter for each HTTP request<br/>
 * @author  keerthi
 */
public class InitController extends AbstractController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="init"
	 * @uml.associationEnd  
	 */
	private InitCEPIS init;

	public InitController() {
	
	}

	public void initialize(ActionEvent e) {
		boolean status = false;
		status = init.initializeUserProfile(userManager,configurationManager);
		if (status) {
			System.out.println("Initialization of CEPIS User Successfull");
		} else {
			System.out.println("Initialization Failed !!!!!!");
		}
	}

	/*
	 * public String initialize(HttpServletRequest request) {
	 * 
	 * boolean status = false;
	 * 
	 * status = init.initializeUserProfile(request); if (status) {
	 * 
	 * String[] configLocation = { "WEB-INF/config/spring/managerContext.xml" };
	 * 
	 * XmlWebApplicationContext ctx = new XmlWebApplicationContext();
	 * ctx.setServletContext(request.getSession().getServletContext());
	 * ctx.setConfigLocations(configLocation); ctx.refresh();
	 * 
	 * UserManager userManager = (UserManager) ctx.getBean("cepisUserManager");
	 * System.out.println(userManager.isValid());
	 * this.setUserManager(userManager); ConfigurationManager
	 * configurationManager = (ConfigurationManager) ctx
	 * .getBean("cepisConfigurationManager");
	 * System.out.println(configurationManager.getRecentOperation());
	 * this.setConfigurationManager(configurationManager);
	 * System.out.println("Initialization of CEPIS User Successfull");
	 * 
	 * return "home"; } else {
	 * System.out.println("Initialization Failed !!!!!!"); return "error"; } }
	 */

	/**
	 * @param init  the init to set
	 * @uml.property  name="init"
	 */
	public void setInit(InitCEPIS init) {
		this.init = init;
	}

	/**
	 * @return  the init
	 * @uml.property  name="init"
	 */
	public InitCEPIS getInit() {
		return init;
	}

}
