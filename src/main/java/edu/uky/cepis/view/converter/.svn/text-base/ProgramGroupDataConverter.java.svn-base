/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;

import edu.uky.cepis.domain.component.ProgramGroup;
import edu.uky.cepis.util.global.CEPISGlobalComponentConfigurator;

/**
 * @author  keerthi
 */
public class ProgramGroupDataConverter  implements
		Converter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private static Logger log = Logger
			.getLogger(ProgramGroupDataConverter.class);
	/**
	 * @uml.property  name="cepisGlobalComponentConfigurator"
	 * @uml.associationEnd  
	 */
	private CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator;

	public ProgramGroupDataConverter() {

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
			System.out.println(ProgramGroupDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(ProgramGroupDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(ProgramGroupDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(ProgramGroupDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2.equals("NA")|| arg2.isEmpty()) {
			ProgramGroup tempProgramGroup = new ProgramGroup();
			return tempProgramGroup;
		}

		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(ProgramGroupDataConverter.class
						+ ": Validation Failed");
			}
		}

		ProgramGroup programGroup = null;
		programGroup = this.getCepisGlobalComponentConfigurator()
				.findProgramGroupByCode(arg2);
		return programGroup;
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
			System.out.println(ProgramGroupDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(ProgramGroupDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2 instanceof String) {
			return arg2.toString();
		}
		ProgramGroup programGroup = (ProgramGroup) arg2;
		return programGroup.getProgramGroupCode();

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
