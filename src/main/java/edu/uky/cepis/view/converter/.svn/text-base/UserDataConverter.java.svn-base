/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.springframework.web.jsf.FacesContextUtils;

import edu.uky.cepis.domain.User;
import edu.uky.cepis.service.UserService;

/**
 * @author keerthi
 * 
 */
public class UserDataConverter implements Converter {

	/**
	 * 
	 */
	private static Logger log = Logger.getLogger(UserDataConverter.class);

	public UserDataConverter() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext
	 * , javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (log.isDebugEnabled()) {
			log.info(UserDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		// Get the UserDao object to load the user object from database
		UserService us = (UserService) FacesContextUtils
				.getWebApplicationContext(arg0).getBean("cepisUserService");
		if (arg0 == null) {
			if (log.isDebugEnabled())
				log.debug(UserDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				log.debug(UserDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				log.debug(UserDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				log.warn(UserDataConverter.class
						+ ": Validation Failed");
			}
		}
		if (arg2.equals("NA")|| arg2.isEmpty()) {
			User tempUser = new User();
			return tempUser;
		}
		User user = us.findByUid(arg2);
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext
	 * , javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (log.isDebugEnabled()) {
			System.out.println(UserDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 instanceof String) {
			return arg2.toString();
		}
		if (arg2 == null) {
			if (log.isDebugEnabled()) {
				log.warn(UserDataConverter.class
						+ ": User not found");
			}
			return "";
		}
		if (arg2 instanceof User) {
		User user = (User) arg2;
		return user.getUid();
		}
		System.out.println(UserDataConverter.class
				+ ": Invalid Argument " + arg2);
		return null;
	}
}
