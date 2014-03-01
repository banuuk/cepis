/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.springframework.web.jsf.FacesContextUtils;

import edu.uky.cepis.domain.TepAdmission;
import edu.uky.cepis.service.TepAdmissionService;

/**
 * @author cawalk4
 * 
 */
public class TepAdmissionDataConverter implements Converter {

	/**
	 * 
	 */
	private static Logger log = Logger.getLogger(TepAdmissionDataConverter.class);

	public TepAdmissionDataConverter() {

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
			System.out.println(TepAdmissionDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(TepAdmissionDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(TepAdmissionDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(TepAdmissionDataConverter.class
						+ ": String argument is empty");
			return new TepAdmission();
		}
		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(TepAdmissionDataConverter.class
						+ ": Validation Failed");
			}
		}
		TepAdmission tepAdmission = null;
		if (arg2.equals("NA") || arg2.isEmpty()) {
			tepAdmission = new TepAdmission();
			return tepAdmission;
		}

		// Get the WorkingSetDao object to load the user object from database
		TepAdmissionService tepAdmissionService = (TepAdmissionService) FacesContextUtils
				.getWebApplicationContext(arg0).getBean("tepAdmissionService");
		tepAdmission = tepAdmissionService.findTepAdmissionById(new Long(arg2));
		System.out.println("TepAdmission : " + tepAdmission.getId());

		return tepAdmission;
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
			System.out.println(TepAdmissionDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(TepAdmissionDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2 instanceof String) {
			return arg2.toString();
		}
		TepAdmission tepAdmission = (TepAdmission) arg2;
		return tepAdmission.getId() + "";

	}

}
