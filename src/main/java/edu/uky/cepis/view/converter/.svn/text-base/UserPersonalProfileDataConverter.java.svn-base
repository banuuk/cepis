/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.springframework.web.jsf.FacesContextUtils;

import edu.uky.cepis.domain.UserPersonalProfile;
import edu.uky.cepis.service.UserPersonalProfileService;

/**
 * @author keerthi
 * 
 */
public class UserPersonalProfileDataConverter implements Converter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private static Logger log = Logger
			.getLogger(UserPersonalProfileDataConverter.class);

	public UserPersonalProfileDataConverter() {

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
			System.out.println(UserPersonalProfileDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(UserPersonalProfileDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(UserPersonalProfileDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(UserPersonalProfileDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(UserPersonalProfileDataConverter.class
						+ ": Validation Failed");
			}
		}
		UserPersonalProfile userPersonalProfile = null;
		if (arg2.equals("NA")|| arg2.isEmpty()) {
			userPersonalProfile = new UserPersonalProfile();
			return userPersonalProfile;
		}

		// Get the WorkingSetDao object to load the user object from database
		UserPersonalProfileService userPersonalProfileService = (UserPersonalProfileService) FacesContextUtils
				.getWebApplicationContext(arg0).getBean(
						"userPersonalProfileService");
		userPersonalProfile = userPersonalProfileService
				.findUserPersonalProfileById(arg2);

		return userPersonalProfile;
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
			System.out.println(UserPersonalProfileDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(UserPersonalProfileDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2 instanceof String) {
			return arg2.toString();
		}
		UserPersonalProfile userPersonalProfile = (UserPersonalProfile) arg2;
		return userPersonalProfile.getUserpersonalprofileid() + "";

	}

}
