/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.springframework.web.jsf.FacesContextUtils;

import edu.uky.cepis.domain.AdvisingSessionSlot;
import edu.uky.cepis.service.AdvisingSessionSlotService;


/**
 * @author scott
 * 
 */
public class AdvisingSessionSlotDataConverter implements Converter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private static Logger log = Logger.getLogger(AdvisingSessionSlotDataConverter.class);

	public AdvisingSessionSlotDataConverter() {

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
			System.out.println(AdvisingSessionSlotDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(AdvisingSessionSlotDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(AdvisingSessionSlotDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(AdvisingSessionSlotDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(AdvisingSessionSlotDataConverter.class
						+ ": Validation Failed");
			}
		}
		
		AdvisingSessionSlot advisingSessionSlot = null;
		if (arg2.equals("NA") || arg2.isEmpty()) {
			advisingSessionSlot = new AdvisingSessionSlot();
			return advisingSessionSlot;
		}

		AdvisingSessionSlotService advisingSessionSlotService = (AdvisingSessionSlotService) FacesContextUtils
				.getWebApplicationContext(arg0).getBean("advisingSessionSlotService");
		advisingSessionSlot = advisingSessionSlotService.findById(new String(arg2));
		System.out.println(advisingSessionSlot);
		return advisingSessionSlot;
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
			System.out.println(AdvisingSessionSlotDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(AdvisingSessionSlotDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2 instanceof String) {
			return arg2.toString();
		}
		AdvisingSessionSlot advisingSessionSlot = (AdvisingSessionSlot) arg2;
		return advisingSessionSlot.getId() + "";

	}

}
