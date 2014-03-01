/**
 * 
 */
package edu.uky.cepis.view.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;

import edu.uky.cepis.domain.Role;
import edu.uky.cepis.util.global.CEPISGlobalComponentConfigurator;


/**
 * @author  keerthi
 */
public class RoleDataConverter implements Converter {

	/**
	 * 
	 */
	private static Logger log = Logger.getLogger(RoleDataConverter.class);
	
	/**
	 * @uml.property  name="cepisGlobalComponentConfigurator"
	 * @uml.associationEnd  
	 */
	private CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator;

	public RoleDataConverter() {

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
			System.out.println(RoleDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(RoleDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(RoleDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(RoleDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if(arg2.equals("NA")|| arg2.isEmpty()){
			Role tempRole = new Role();
			return tempRole;
		}
	
		
		
		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(RoleDataConverter.class
						+ ": Validation Failed");
			}
		}
		
		Role role = null;
		role = this.getCepisGlobalComponentConfigurator().findRoleByID(
				new Long(arg2));
			
		return role;
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
		System.out.println(RoleDataConverter.class
				+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(RoleDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if(arg2 instanceof String){
			return arg2.toString();
		}
		Role role = (Role) arg2;
		return role.getRoleid()+"";
		
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
