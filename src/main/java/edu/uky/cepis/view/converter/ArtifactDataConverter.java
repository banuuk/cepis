/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.springframework.web.jsf.FacesContextUtils;

import edu.uky.cepis.domain.Artifact;
import edu.uky.cepis.service.ArtifactService;

/**
 * @author keerthi
 */
public class ArtifactDataConverter implements Converter {

	/**
	 * 
	 */
	private static Logger log = Logger.getLogger(ArtifactDataConverter.class);

	public ArtifactDataConverter() {

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
			System.out.println(ArtifactDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		// Get the ArtifactDao object to load the user object from database
		ArtifactService artifactService = (ArtifactService) FacesContextUtils
				.getWebApplicationContext(arg0).getBean("artifactService");
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(ArtifactDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(ArtifactDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(ArtifactDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2.equals("NA") || arg2.isEmpty()) {
			Artifact tempArtifact = new Artifact();
			return tempArtifact;
		}

		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(ArtifactDataConverter.class
						+ ": Validation Failed");
			}
		}

		Artifact artifact = artifactService.findById(new Long(arg2));
		System.out.println("Gen Value: " + artifact);
		return artifact;
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
			System.out.println(ArtifactDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(ArtifactDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2 instanceof String) {
			return arg2.toString();
		}
		Artifact artifact = (Artifact) arg2;
		return artifact.getId() + "";

	}

}
