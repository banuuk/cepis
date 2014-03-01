/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.springframework.web.jsf.FacesContextUtils;

import edu.uky.cepis.domain.PraxisITest;
import edu.uky.cepis.service.PraxisITestService;

/**
 * @author cawalk4
 * 
 */
public class PraxisITestDataConverter implements Converter {

	/**
	 * 
	 */
	private static Logger log = Logger.getLogger(PraxisITestDataConverter.class);

	public PraxisITestDataConverter() {

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
			System.out.println(PraxisITestDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(PraxisITestDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(PraxisITestDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(PraxisITestDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(PraxisITestDataConverter.class
						+ ": Validation Failed");
			}
		}
		PraxisITest praxisITest = null;
		if (arg2.equals("NA") || arg2.isEmpty()) {
			praxisITest = new PraxisITest();
			return praxisITest;
		}

		// Get the WorkingSetDao object to load the user object from database
		PraxisITestService praxisITestService = (PraxisITestService) FacesContextUtils
				.getWebApplicationContext(arg0).getBean("praxisITestService");
		praxisITest = praxisITestService.findPraxisITestById(new Long(arg2));
		System.out.println("PraxisITest : " + praxisITest);

		return praxisITest;
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
			System.out.println(PraxisITestDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(PraxisITestDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2 instanceof String) {
			return arg2.toString();
		}
		PraxisITest praxisITest = (PraxisITest) arg2;
		return praxisITest.getId() + "";

	}

}
