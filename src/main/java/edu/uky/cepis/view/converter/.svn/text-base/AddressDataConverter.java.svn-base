/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.log4j.Logger;
import org.springframework.web.jsf.FacesContextUtils;
import edu.uky.cepis.domain.Address;
import edu.uky.cepis.service.AddressService;

/**
 * @author keerthi
 * 
 */
public class AddressDataConverter implements Converter {

	/**
	 * 
	 */
	private static Logger log = Logger.getLogger(AddressDataConverter.class);

	public AddressDataConverter() {

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
			System.out.println(AddressDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(AddressDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(AddressDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(AddressDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(AddressDataConverter.class
						+ ": Validation Failed");
			}
		}
		Address address = null;
		if (arg2.equals("NA") || arg2.isEmpty()) {
			address = new Address();
			return address;
		}

		// Get the WorkingSetDao object to load the user object from database
		AddressService addressservice = (AddressService) FacesContextUtils
				.getWebApplicationContext(arg0).getBean("addressService");
		address = addressservice.findById(new Long(arg2));
		System.out.println("Address : " + address);

		return address;
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
			System.out.println(AddressDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(AddressDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2 instanceof String) {
			return arg2.toString();
		}
		Address address = (Address) arg2;
		return address.getId() + "";

	}

}
