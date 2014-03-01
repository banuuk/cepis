/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.springframework.web.jsf.FacesContextUtils;

import edu.uky.cepis.domain.Attendee;
import edu.uky.cepis.domain.Conference;
import edu.uky.cepis.service.AttendeeService;
import edu.uky.cepis.service.ConferenceService;

/**
 * @author keerthi
 * 
 */
public class AttendeeDataConverter implements Converter {

	/**
	 * 
	 */
	private static Logger log = Logger.getLogger(AttendeeDataConverter.class);

	public AttendeeDataConverter() {

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
			log.info(AttendeeDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		// Get the ConferenceDao object to load the user object from database
		AttendeeService us = (AttendeeService) FacesContextUtils
				.getWebApplicationContext(arg0).getBean("attendeeService");
		if (arg0 == null) {
			if (log.isDebugEnabled())
				log.debug(AttendeeDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				log.debug(AttendeeDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				log.debug(AttendeeDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				log.warn(AttendeeDataConverter.class
						+ ": Validation Failed");
			}
		}
		if (arg2.equals("NA")|| arg2.isEmpty()) {
			Attendee tempAttendee = new Attendee();
			return tempAttendee;
		}
		Attendee user = us.findAttendeeByID(new Long(arg2));
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
			System.out.println(AttendeeDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 instanceof String) {
			return arg2.toString();
		}
		if (arg2 == null) {
			if (log.isDebugEnabled()) {
				log.warn(AttendeeDataConverter.class
						+ ": Attendee not found");
			}
			return "";
		}
		Attendee attendee = (Attendee) arg2;
		return attendee.getId()+"";
	}
}
