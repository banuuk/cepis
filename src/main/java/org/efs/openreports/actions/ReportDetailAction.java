/*
 * Copyright (C) 2002 Erik Swenson - erik@oreports.com
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 *  
 */

package org.efs.openreports.actions;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;
import org.efs.openreports.ORStatics;
import org.efs.openreports.objects.*;
import org.efs.openreports.providers.*;
import org.efs.openreports.util.LocalStrings;

/**
 * @author  keerthi
 */
public class ReportDetailAction extends ActionSupport implements SessionAware, ParameterAware
{	
	private static final long serialVersionUID = 724821018564650888L;
	
	private Map<Object,Object> session;
	private Map<String,Object> parameters;
	
	/**
	 * @uml.property  name="report"
	 * @uml.associationEnd  
	 */
	private Report report;
	/**
	 * @uml.property  name="reportId"
	 */
	private int reportId = Integer.MIN_VALUE;
	
	/**
	 * @uml.property  name="submitType"
	 */
	private String submitType;

	/**
	 * @uml.property  name="parameterProvider"
	 * @uml.associationEnd  
	 */
	private ParameterProvider parameterProvider;
	/**
	 * @uml.property  name="reportProvider"
	 * @uml.associationEnd  
	 */
	private ReportProvider reportProvider;
	/**
	 * @uml.property  name="dateProvider"
	 * @uml.associationEnd  
	 */
	private DateProvider dateProvider;

	/**
	 * @uml.property  name="reportParameters"
	 */
	private List<ReportParameterMap> reportParameters;
	/**
	 * @uml.property  name="step"
	 */
	private int step = 0;
	
	/**
	 * @uml.property  name="displayInline"
	 */
	private boolean displayInline;	

	@Override
	public String execute()
	{
		try
		{
			ReportUser user = (ReportUser) ActionContext.getContext().getSession().get(
					ORStatics.REPORT_USER);

			report = reportProvider.getReport(new Integer(reportId));			

			if (report == null)
			{
				addActionError(getText(LocalStrings.ERROR_REPORT_INVALID));
				return ERROR;
			}

			if (!user.isValidReport(report))
			{
				addActionError(getText(LocalStrings.ERROR_REPORT_NOTAUTHORIZED));
				return ERROR;
			}			

			report.setDisplayInline(displayInline);
			reportParameters = report.getReportParametersByStep(step);

			if (submitType == null)
			{
				// first time through create new map and add standard report parameters
				HashMap<String,Object> newMap = new HashMap<String,Object>();
				newMap.put(ORStatics.USER_ID, user.getId());
				newMap.put(ORStatics.EXTERNAL_ID, user.getExternalId());
				newMap.put(ORStatics.USER_NAME, user.getName());

				ActionContext.getContext().getSession().remove(ORStatics.REPORT_PARAMETERS);
				session.put(ORStatics.REPORT_PARAMETERS, newMap);
				session.put(ORStatics.REPORT, report);

				if (report.getParameters().size() > 0 && report.getParameters().size() != report.getSubReportParameters().size())
				{					
					parameterProvider.loadReportParameterValues(reportParameters, newMap);

					return INPUT;
				}
				else
				{
					return SUCCESS;
				}
			}
//			for(Map.Entry<String, Object> entry : parameters.entrySet()){
//				if(entry.getValue().getClass() == Date.class){
//					
//					
//					String year = entry.getKey().substring(0, 4);
//					String month = entry.getKey().substring(5, 7);
//					String day = entry.getKey().substring(8, 10);
//					String Date = month + "/" + day  + "/" + year;
//				}
//			}
			
			

			parameterProvider.validateParameters(reportParameters, parameters);

			Map<String,Object> map = getReportParametersFromSession();

			Map<String,Object> currentMap = parameterProvider.getReportParametersMap(reportParameters,parameters);

			map.putAll(currentMap);

			session.put(ORStatics.REPORT_PARAMETERS, map);
			
			step++;

			reportParameters = report.getReportParametersByStep(step);

			if (reportParameters.size() > 0)
			{
				parameterProvider.loadReportParameterValues(reportParameters, map);

				return INPUT;
			}

			return SUCCESS;
		}
		catch (Exception e)
		{			
			Map<String,Object> map = getReportParametersFromSession();

			try
			{
				parameterProvider.loadReportParameterValues(reportParameters, map);
			}
			catch (ProviderException pe)
			{
				addActionError(getText(pe.getMessage()));
			}

			addActionError(getText(e.getMessage()));
			return INPUT;
		}
	}    
   
	@SuppressWarnings("unchecked")
	public void setSession(Map session) 
	{
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	public void setParameters(Map parameters) 
	{
		this.parameters = parameters;
	}

	@SuppressWarnings("unchecked")
	public Map<String,Object> getReportParametersFromSession() 
	{
		return (Map) session.get(ORStatics.REPORT_PARAMETERS);
	}
		
	/**
	 * @return
	 * @uml.property  name="submitType"
	 */
	public String getSubmitType()
	{
		return submitType;
	}

	/**
	 * @param submitType
	 * @uml.property  name="submitType"
	 */
	public void setSubmitType(String submitType)
	{
		this.submitType = submitType;
	}

	/**
	 * @return
	 * @uml.property  name="reportId"
	 */
	public int getReportId()
	{
		return reportId;
	}

	/**
	 * @param reportId
	 * @uml.property  name="reportId"
	 */
	public void setReportId(int reportId)
	{
		this.reportId = reportId;
	}

	/**
	 * @param parameterProvider
	 * @uml.property  name="parameterProvider"
	 */
	public void setParameterProvider(ParameterProvider parameterProvider)
	{
		this.parameterProvider = parameterProvider;
	}

	/**
	 * @param reportProvider
	 * @uml.property  name="reportProvider"
	 */
	public void setReportProvider(ReportProvider reportProvider)
	{
		this.reportProvider = reportProvider;
	}

	/**
	 * @return
	 * @uml.property  name="reportParameters"
	 */
	public List<ReportParameterMap> getReportParameters()
	{
		return reportParameters;
	}

	/**
	 * @return
	 * @uml.property  name="step"
	 */
	public int getStep()
	{
		return step;
	}

	/**
	 * @param step
	 * @uml.property  name="step"
	 */
	public void setStep(int step)
	{
		this.step = step;
	}
	
	/**
	 * @param dateProvider
	 * @uml.property  name="dateProvider"
	 */
	public void setDateProvider(DateProvider dateProvider)
	{
		this.dateProvider = dateProvider;
	}
	
	public String getDateFormat()
	{
		return dateProvider.getDateFormat().toPattern();
	}
	
	public String getDefaultDate()
	{
		return dateProvider.formatDate(new Date());
	}
	
	/**
	 * @return
	 * @uml.property  name="report"
	 */
	public Report getReport()
	{
		return report;
	}
	
	/**
	 * @param report
	 * @uml.property  name="report"
	 */
	public void setReport(Report report)
	{
		this.report = report;
	}

	/**
	 * @return
	 * @uml.property  name="displayInline"
	 */
	public boolean isDisplayInline()
	{
		return displayInline;
	}

	/**
	 * @param displayInline
	 * @uml.property  name="displayInline"
	 */
	public void setDisplayInline(boolean displayInline)
	{
		this.displayInline = displayInline;
	}
}