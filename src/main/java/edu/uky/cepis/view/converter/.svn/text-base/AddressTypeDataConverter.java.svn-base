/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;

import edu.uky.cepis.domain.AddressType;
import edu.uky.cepis.util.global.CEPISGlobalComponentConfigurator;

/**
 * @author  keerthi
 */
public class AddressTypeDataConverter implements Converter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private static Logger log = Logger
			.getLogger(AddressTypeDataConverter.class);
	/**
	 * @uml.property  name="cepisGlobalComponentConfigurator"
	 * @uml.associationEnd  
	 */
	private CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator;

	public AddressTypeDataConverter() {

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
			System.out.println(AdvisorDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(AdvisorDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(AdvisorDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(AdvisorDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2.equals("NA")|| arg2.isEmpty()) {
			AddressType tempAddressType = new AddressType();
			return tempAddressType;
		}

		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(AdvisorDataConverter.class
						+ ": Validation Failed");
			}
		}

		AddressType addressType = null;
		addressType = this.getCepisGlobalComponentConfigurator()
				.findAddressTypeByCode(arg2);
		return addressType;
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
			System.out.println(AdvisorDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(AdvisorDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2 instanceof String) {
			return arg2.toString();
		}
		AddressType addressType = (AddressType) arg2;
		return addressType.getCode();

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
