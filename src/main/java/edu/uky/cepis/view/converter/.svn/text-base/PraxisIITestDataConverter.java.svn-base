/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.springframework.web.jsf.FacesContextUtils;

import edu.uky.cepis.domain.PraxisIITest;
import edu.uky.cepis.service.PraxisIITestService;

/**
 * @author cawalk4
 * 
 */
public class PraxisIITestDataConverter implements Converter {

	/**
	 * 
	 */
	private static Logger log = Logger.getLogger(PraxisIITestDataConverter.class);

	public PraxisIITestDataConverter() {

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
			System.out.println(PraxisIITestDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(PraxisIITestDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(PraxisIITestDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(PraxisIITestDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(PraxisIITestDataConverter.class
						+ ": Validation Failed");
			}
		}
		PraxisIITest praxisIITest = null;
		if (arg2.equals("NA") || arg2.isEmpty()) {
			praxisIITest = new PraxisIITest();
			return praxisIITest;
		}

		// Get the WorkingSetDao object to load the user object from database
		PraxisIITestService praxisIITestService = (PraxisIITestService) FacesContextUtils
				.getWebApplicationContext(arg0).getBean("praxisIITestService");
		praxisIITest = praxisIITestService.findPraxisIITestById(new Long(arg2));
		System.out.println("PraxisIITest : " + praxisIITest);

		return praxisIITest;
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
			System.out.println(PraxisIITestDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(PraxisIITestDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2 instanceof String) {
			return arg2.toString();
		}
		PraxisIITest praxisIITest = (PraxisIITest) arg2;
		return praxisIITest.getId() + "";

	}

}
