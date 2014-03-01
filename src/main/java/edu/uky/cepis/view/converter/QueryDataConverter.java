/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.springframework.web.jsf.FacesContextUtils;

import edu.uky.cepis.domain.Query;
import edu.uky.cepis.domain.WorkingSet;
import edu.uky.cepis.manager.UserManager;
import edu.uky.cepis.service.QueryService;
import edu.uky.cepis.service.WorkingSetService;

/**
 * @author keerthi
 * 
 */
public class QueryDataConverter implements Converter {

	/**
	 * 
	 */
	private static Logger log = Logger.getLogger(QueryDataConverter.class);

	public QueryDataConverter() {

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
			System.out.println(QueryDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		// Get the QueryDao object to load the user object from database
		QueryService queryService = (QueryService) FacesContextUtils
				.getWebApplicationContext(arg0).getBean("queryService");
		UserManager userManager = (UserManager) FacesContextUtils
				.getWebApplicationContext(arg0).getBean("cepisUserManager");
		;
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(QueryDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(QueryDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(QueryDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(QueryDataConverter.class
						+ ": Validation Failed");
			}
		}
		if (arg2.equals("ALL")) {
			Query tempQuery = new Query();
			tempQuery.setSid(0);
			return tempQuery;
		}
		else if (arg2.equals("NA")|| arg2.isEmpty()) {
			Query tempQuery = new Query();
			tempQuery.setSid(-1);
			return tempQuery;
		}
		Query query = null;
		query = queryService.findQuery(userManager.getUser().getUid(),new Long(arg2));
		
			return query;

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
			System.out.println(QueryDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}

		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(QueryDataConverter.class
						+ ": String argument is empty");
			return null;
		}

		if (arg2 instanceof String) {
			return arg2.toString();
		}
		Query query = (Query) arg2;
		return query.getSid() + "";

	}

}
