/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.springframework.web.jsf.FacesContextUtils;

import edu.uky.cepis.domain.Certification;
import edu.uky.cepis.service.CertificationService;
import edu.uky.cepis.util.global.CEPISGlobalComponentConfigurator;

/**
 * @author scott
 */
public class CertificationDataConverter implements Converter {

	/**
	 * 
	 */
	private static Logger log = Logger
			.getLogger(CertificationDataConverter.class);
	/**
	 * @uml.property name="cepisGlobalComponentConfigurator"
	 * @uml.associationEnd
	 */
	private CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator;

	public CertificationDataConverter() {

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
			System.out.println(CertificationDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(CertificationDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(CertificationDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(CertificationDataConverter.class
						+ ": String argument is empty");
			return null;
		}

		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(CertificationDataConverter.class
						+ ": Validation Failed");
			}
		}

		Certification certification = null;
		if (arg2.equals("NA") || arg2.isEmpty()) {
			System.out.println("Argument is null or empty: " + arg2);
			certification = new Certification();
			return certification;
		}

		CertificationService certificationService = (CertificationService) FacesContextUtils
				.getWebApplicationContext(arg0).getBean("certificationService");
		certification = certificationService.findById(new Long(arg2));
		System.out
				.println(certification
						+ ":"
						+ ((certification == null) ? "Null" : certification
								.getProgramProfile()
								+ ""
								+ certification.getRanking()));

		return certification;
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
			System.out.println(CertificationDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(CertificationDataConverter.class
						+ ": String argument is empty");
			return null;
		}

		if (arg2 instanceof String) {
			return arg2.toString();
		}
		Certification certification = (Certification) arg2;
		return certification.getId() + "";
	}

	/**
	 * @param cepisGlobalComponentConfigurator
	 *            the cepisGlobalComponentConfigurator to set
	 * @uml.property name="cepisGlobalComponentConfigurator"
	 */
	public void setCepisGlobalComponentConfigurator(
			CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator) {
		this.cepisGlobalComponentConfigurator = cepisGlobalComponentConfigurator;
	}

	/**
	 * @return the cepisGlobalComponentConfigurator
	 * @uml.property name="cepisGlobalComponentConfigurator"
	 */
	public CEPISGlobalComponentConfigurator getCepisGlobalComponentConfigurator() {
		return cepisGlobalComponentConfigurator;
	}

}
