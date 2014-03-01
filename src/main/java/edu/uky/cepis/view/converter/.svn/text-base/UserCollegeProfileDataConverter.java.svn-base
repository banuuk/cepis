/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.springframework.web.jsf.FacesContextUtils;

import edu.uky.cepis.domain.UserCollegeProfile;
import edu.uky.cepis.service.UserCollegeProfileService;

/**
 * @author keerthi
 * 
 */
public class UserCollegeProfileDataConverter implements Converter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private static Logger log = Logger
			.getLogger(UserCollegeProfileDataConverter.class);

	public UserCollegeProfileDataConverter() {

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
			System.out.println(UserCollegeProfileDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(UserCollegeProfileDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(UserCollegeProfileDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(UserCollegeProfileDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(UserCollegeProfileDataConverter.class
						+ ": Validation Failed");
			}
		}
		UserCollegeProfile userCollegeProfile = null;
		if (arg2.equals("NA")|| arg2.isEmpty()) {
			userCollegeProfile = new UserCollegeProfile();
			return userCollegeProfile;
		}

		// Get the WorkingSetDao object to load the user object from database
		UserCollegeProfileService userCollegeProfileService = (UserCollegeProfileService) FacesContextUtils
				.getWebApplicationContext(arg0).getBean(
						"userCollegeProfileService");
		userCollegeProfile = userCollegeProfileService
				.findUserCollegeProfile(Long.parseLong(arg2));

		return userCollegeProfile;
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
			System.out.println(UserCollegeProfileDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(UserCollegeProfileDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2 instanceof String) {
			return arg2.toString();
		}
		UserCollegeProfile userCollegeProfile = (UserCollegeProfile) arg2;
		return userCollegeProfile.getUsercollegeprofileid() + "";

	}

}
