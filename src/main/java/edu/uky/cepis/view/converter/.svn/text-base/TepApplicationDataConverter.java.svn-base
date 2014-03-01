/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.springframework.web.jsf.FacesContextUtils;

import edu.uky.cepis.domain.TepApplication;
import edu.uky.cepis.service.TepApplicationService;

/**
 * @author cawalk4
 * 
 */
public class TepApplicationDataConverter implements Converter {

	/**
	 * 
	 */
	private static Logger log = Logger.getLogger(TepApplicationDataConverter.class);

	public TepApplicationDataConverter() {

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
			System.out.println(TepApplicationDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(TepApplicationDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(TepApplicationDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(TepApplicationDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(TepApplicationDataConverter.class
						+ ": Validation Failed");
			}
		}
		TepApplication tepApplication = null;
		if (arg2.equals("NA") || arg2.isEmpty()) {
			tepApplication = new TepApplication();
			return tepApplication;
		}

		// Get the WorkingSetDao object to load the user object from database
		TepApplicationService tepApplicationService = (TepApplicationService) FacesContextUtils
				.getWebApplicationContext(arg0).getBean("tepApplicationService");
		tepApplication = tepApplicationService.findTepApplicationById(new Long(arg2));
		System.out.println("TepApplication : " + tepApplication);

		return tepApplication;
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
			System.out.println(TepApplicationDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(TepApplicationDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2 instanceof String) {
			return arg2.toString();
		}
		TepApplication tepApplication = (TepApplication) arg2;
		return tepApplication.getId() + "";

	}

}
