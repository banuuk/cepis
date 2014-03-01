/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.springframework.web.jsf.FacesContextUtils;

import edu.uky.cepis.domain.UserProgramProfile;
import edu.uky.cepis.service.UserProgramProfileService;

/**
 * @author keerthi
 * 
 */
public class UserProgramProfileDataConverter implements Converter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private static Logger log = Logger
			.getLogger(UserProgramProfileDataConverter.class);

	public UserProgramProfileDataConverter() {

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
			System.out.println(UserProgramProfileDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(UserProgramProfileDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(UserProgramProfileDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(UserProgramProfileDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(UserProgramProfileDataConverter.class
						+ ": Validation Failed");
			}
		}
		UserProgramProfile userProgramProfile = null;
		if (arg2.equals("NA")|| arg2.isEmpty()) {
			userProgramProfile = new UserProgramProfile();
			return userProgramProfile;
		}

		// Get the WorkingSetDao object to load the user object from database
		UserProgramProfileService userProgramProfileService = (UserProgramProfileService) FacesContextUtils
				.getWebApplicationContext(arg0).getBean(
						"userProgramProfileService");
		userProgramProfile = userProgramProfileService
				.findUserProgramProfile(arg2);

		return userProgramProfile;
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
			System.out.println(UserProgramProfileDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(UserProgramProfileDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2 instanceof String) {
			return arg2.toString();
		}
		UserProgramProfile userProgramProfile = (UserProgramProfile) arg2;
		return userProgramProfile.getUserprogramprofileid() + "";

	}

}
