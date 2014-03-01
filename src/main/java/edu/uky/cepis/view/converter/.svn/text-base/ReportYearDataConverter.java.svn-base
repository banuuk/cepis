/**
 * 
 */
package edu.uky.cepis.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.springframework.web.jsf.FacesContextUtils;

import edu.uky.cepis.domain.ReportYear;
import edu.uky.cepis.service.ReportYearService;

/**
 * @author cawalk4
 * 
 */
public class ReportYearDataConverter implements Converter {

	/**
	 * 
	 */
	private static Logger log = Logger.getLogger(ReportYearDataConverter.class);

	public ReportYearDataConverter() {

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
			System.out.println(ReportYearDataConverter.class
					+ ": Calling getAsObject Function with argument " + arg2);
		}
		if (arg0 == null) {
			if (log.isDebugEnabled())
				System.out.println(ReportYearDataConverter.class
						+ ": FacesContext Empty");
		}
		if (arg1 == null) {
			if (log.isDebugEnabled())
				System.out.println(ReportYearDataConverter.class
						+ ": UIComponent is empty");
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(ReportYearDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (log.isDebugEnabled()) {
			if (arg0.isValidationFailed()) {
				System.out.println(ReportYearDataConverter.class
						+ ": Validation Failed");
			}
		}
		ReportYear reportYear = null;
		if (arg2.equals("NA") || arg2.isEmpty()) {
			reportYear = new ReportYear();
			return reportYear;
		}

		// Get the WorkingSetDao object to load the user object from database
		ReportYearService reportYearService = (ReportYearService) FacesContextUtils
				.getWebApplicationContext(arg0).getBean("reportYearService");
		reportYear = reportYearService.findReportYearByCode(new String(arg2));
		System.out.println("ReportYear : " + reportYear);

		return reportYear;
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
			System.out.println(ReportYearDataConverter.class
					+ ": Calling getAsString Function with argument " + arg2);
		}
		if (arg2 == null) {
			if (log.isDebugEnabled())
				System.out.println(ReportYearDataConverter.class
						+ ": String argument is empty");
			return null;
		}
		if (arg2 instanceof String) {
			return arg2.toString();
		}
		ReportYear reportYear = (ReportYear) arg2;
		return reportYear.getReportYearCode() + "";

	}

}
