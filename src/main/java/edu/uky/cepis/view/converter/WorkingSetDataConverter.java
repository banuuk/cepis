/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.springframework.web.jsf.FacesContextUtils;

import edu.uky.cepis.domain.WorkingSet;
import edu.uky.cepis.manager.UserManager;
import edu.uky.cepis.service.WorkingSetService;

/**
 * @author keerthi
 * 
 */
public class WorkingSetDataConverter implements Converter {

	/**
	 * 
	 */
	private static Logger log = Logger.getLogger(WorkingSetDataConverter.class);

	public WorkingSetDataConverter() {

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
			System.out.println(WorkingSetDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		// Get the WorkingSetDao object to load the user object from database
		WorkingSetService wsservice = (WorkingSetService) FacesContextUtils
				.getWebApplicationContext(arg0).getBean("workingSetService");
		UserManager userManager = (UserManager) FacesContextUtils
				.getWebApplicationContext(arg0).getBean("cepisUserManager");
		;
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(WorkingSetDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(WorkingSetDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(WorkingSetDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(WorkingSetDataConverter.class
						+ ": Validation Failed");
			}
		}
		if (arg2.equals("ALL")) {
			WorkingSet tempWorkingSet = new WorkingSet();
			tempWorkingSet.setWid(0);
			return tempWorkingSet;
		}
		else if (arg2.equals("NA")|| arg2.isEmpty()) {
			WorkingSet tempWorkingSet = new WorkingSet();
			tempWorkingSet.setWid(-1);
			return tempWorkingSet;
		}
		WorkingSet ws = null;
		ws = wsservice.findWorkingSet(new Long(arg2));
		if (ws.getCreatedBy().equals(userManager.getUser().getUid())
				|| ws.isPublic_status() || ws.isShared_mode())
			return ws;
		else
			return new WorkingSet();

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
			System.out.println(WorkingSetDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}

		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(WorkingSetDataConverter.class
						+ ": String argument is empty");
			return null;
		}

		if (arg2 instanceof String) {
			return arg2.toString();
		}
		WorkingSet ws = (WorkingSet) arg2;
		return ws.getWid() + "";

	}

}
