/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;

import edu.uky.cepis.domain.EmailAddressType;
import edu.uky.cepis.util.global.CEPISGlobalComponentConfigurator;

/**
 * @author  keerthi
 */
public class EmailAddressTypeDataConverter implements Converter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private static Logger log = Logger
			.getLogger(EmailAddressTypeDataConverter.class);
	/**
	 * @uml.property  name="cepisGlobalComponentConfigurator"
	 * @uml.associationEnd  
	 */
	private CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator;

	public EmailAddressTypeDataConverter() {

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
			System.out.println(EmailAddressTypeDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(EmailAddressTypeDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(EmailAddressTypeDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(EmailAddressTypeDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2.equals("NA")|| arg2.isEmpty()) {
			EmailAddressType tempEmailAddressType = new EmailAddressType();
			return tempEmailAddressType;
		}

		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(EmailAddressTypeDataConverter.class
						+ ": Validation Failed");
			}
		}

		EmailAddressType emailAddressType = null;
		emailAddressType = this.getCepisGlobalComponentConfigurator()
				.findEmailAddressTypeByCode(arg2);
		return emailAddressType;
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
			System.out.println(EmailAddressTypeDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(EmailAddressTypeDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2 instanceof String) {
			return arg2.toString();
		}
		EmailAddressType emailAddressType = (EmailAddressType) arg2;
		return emailAddressType.getCode();

	}

	/**
	 * @param cepisGlobalComponentConfigurator  the cepisGlobalComponentConfigurator to set
	 * @uml.property  name="cepisGlobalComponentConfigurator"
	 */
	public void setCepisGlobalComponentConfigurator(
			CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator) {
		this.cepisGlobalComponentConfigurator = cepisGlobalComponentConfigurator;
	}

	/**
	 * @return  the cepisGlobalComponentConfigurator
	 * @uml.property  name="cepisGlobalComponentConfigurator"
	 */
	public CEPISGlobalComponentConfigurator getCepisGlobalComponentConfigurator() {
		return cepisGlobalComponentConfigurator;
	}

}
