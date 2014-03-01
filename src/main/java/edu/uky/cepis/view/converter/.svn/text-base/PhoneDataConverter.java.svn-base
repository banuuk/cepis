/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.springframework.web.jsf.FacesContextUtils;

import edu.uky.cepis.domain.Phone;
import edu.uky.cepis.service.PhoneService;

/**
 * @author keerthi
 * 
 */
public class PhoneDataConverter implements Converter {

	/**
	 * 
	 */
	private static Logger log = Logger.getLogger(PhoneDataConverter.class);

	public PhoneDataConverter() {

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
			System.out.println(PhoneDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(PhoneDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(PhoneDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(PhoneDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(PhoneDataConverter.class
						+ ": Validation Failed");
			}
		}
		Phone phone = null;
		if (arg2.equals("NA")|| arg2.isEmpty()) {
			phone = new Phone();
			return phone;
		}

		// Get the WorkingSetDao object to load the user object from database
		PhoneService phoneservice = (PhoneService) FacesContextUtils
				.getWebApplicationContext(arg0).getBean("phoneService");
		phone = phoneservice.findById(new Long(arg2));
		System.out.println("PhoneDataConverter: Retrieved Phone details:"
				+ phone.getPhoneNo() + phone.getPhoneType().getDesc());

		return phone;
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
			System.out.println(PhoneDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(PhoneDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2 instanceof String) {
			return arg2.toString();
		}
		Phone phone = (Phone) arg2;
		return phone.getId() + "";

	}

}
