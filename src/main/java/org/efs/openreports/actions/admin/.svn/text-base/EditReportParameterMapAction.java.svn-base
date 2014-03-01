/*
 * Copyright (C) 2002 Erik Swenson - erik@oreports.com
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 *  
 */

package org.efs.openreports.actions.admin;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;
import org.efs.openreports.engine.ReportEngine;
import org.efs.openreports.engine.ReportEngineHelper;
import org.efs.openreports.objects.*;
import org.efs.openreports.providers.*;

/**
 * @author  keerthi
 */
public class EditReportParameterMapAction extends ActionSupport
{	
	private static final long serialVersionUID = -5228104770995110195L;

	protected static Logger log = Logger.getLogger(EditReportParameterMapAction.class);

	/**
	 * @uml.property  name="id"
	 */
	private int id;
	/**
	 * @uml.property  name="reportParameterId"
	 */
	private int reportParameterId;

	/**
	 * @uml.property  name="sortOrder"
	 */
	private int sortOrder;
	/**
	 * @uml.property  name="step"
	 */
	private int step;
	/**
	 * @uml.property  name="required"
	 */
	private boolean required;

	/**
	 * @uml.property  name="submitAdd"
	 */
	private String submitAdd;
	/**
	 * @uml.property  name="submitUpdate"
	 */
	private String submitUpdate;
	/**
	 * @uml.property  name="submitDelete"
	 */
	private String submitDelete;
    /**
	 * @uml.property  name="submitLoad"
	 */
    private String submitLoad;
    /**
	 * @uml.property  name="submitLoadAndCreate"
	 */
    private String submitLoadAndCreate;

	/**
	 * @uml.property  name="command"
	 */
	private String command;

	/**
	 * @uml.property  name="report"
	 * @uml.associationEnd  
	 */
	private Report report;

	/**
	 * @uml.property  name="reportProvider"
	 * @uml.associationEnd  
	 */
	private ReportProvider reportProvider;
	/**
	 * @uml.property  name="parameterProvider"
	 * @uml.associationEnd  
	 */
	private ParameterProvider parameterProvider;
    /**
	 * @uml.property  name="directoryProvider"
	 * @uml.associationEnd  
	 */
    private DirectoryProvider directoryProvider;
    /**
	 * @uml.property  name="dataSourceProvider"
	 * @uml.associationEnd  
	 */
    private DataSourceProvider dataSourceProvider;
    /**
	 * @uml.property  name="propertiesProvider"
	 * @uml.associationEnd  
	 */
    private PropertiesProvider propertiesProvider;

	@Override
	public String execute()
	{
		try
		{
			report = reportProvider.getReport(new Integer(id));		

			if (submitAdd != null)
			{
				ReportParameter param =
					parameterProvider.getReportParameter(
						new Integer(reportParameterId));

				ReportParameterMap rpMap = new ReportParameterMap();
				rpMap.setReport(report);
				rpMap.setReportParameter(param);
				rpMap.setRequired(param.isRequired());
				rpMap.setSortOrder(0);
				rpMap.setStep(0);
				
				report.getParameters().add(rpMap);

				reportProvider.updateReport(report);
			}

			if (submitUpdate != null)
			{
				ReportParameterMap rpMap =
					report.getReportParameterMap(
						new Integer(reportParameterId));

				rpMap.setRequired(required);
				rpMap.setSortOrder(sortOrder);
				rpMap.setStep(step);

				reportProvider.updateReport(report);
			}

			if (submitDelete != null)
			{
				ReportParameterMap rpMap =
					report.getReportParameterMap(
						new Integer(reportParameterId));			

				report.getParameters().remove(rpMap);

				reportProvider.updateReport(report);
			}
            
            if (submitLoad != null || submitLoadAndCreate != null)
            {
                ReportEngine engine = ReportEngineHelper.getReportEngine(report,
                        dataSourceProvider, directoryProvider, propertiesProvider);     
                                
                List<ReportParameter> parameters = engine.buildParameterList(report);                    
                for (int i=0; i < parameters.size(); i++)
                {
                    ReportParameter designParameter = parameters.get(i);
                    
                    ReportParameter param =
                        parameterProvider.getReportParameter(designParameter.getName());

                    // if null, create and assign a new parameter
                    if (param == null && submitLoadAndCreate != null)
                    {
                        param = parameterProvider.insertReportParameter(designParameter);                       
                        log.info("Parameter Created: " + param.getName());
                    }                   
                    
                    if (param != null)
                    {
                        ReportParameterMap rpMap = new ReportParameterMap();
                        rpMap.setReport(report);
                        rpMap.setReportParameter(param);
                        rpMap.setRequired(param.isRequired());
                        rpMap.setSortOrder(0);
                        rpMap.setStep(0);
                    
                        report.getParameters().add(rpMap);
                    }
                }
                
                reportProvider.updateReport(report);
            }

			return INPUT;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			addActionError(e.toString());
			return INPUT;
		}
	}

	/**
	 * @return
	 * @uml.property  name="id"
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id
	 * @uml.property  name="id"
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	public List<ReportParameter> getReportParameters()
	{
		try
		{
			return parameterProvider.getAvailableParameters(report);
		}
		catch (Exception e)
		{
			addActionError(e.toString());
			return null;
		}
	}

	public List<ReportParameterMap> getParametersInReport()
	{
		List<ReportParameterMap> list = report.getParameters();
		Collections.sort(list);
		
		return list;
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
	 * @param parameterProvider
	 * @uml.property  name="parameterProvider"
	 */
	public void setParameterProvider(ParameterProvider parameterProvider)
	{
		this.parameterProvider = parameterProvider;
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
	 * @uml.property  name="reportParameterId"
	 */
	public int getReportParameterId()
	{
		return reportParameterId;
	}

	/**
	 * @param reportParameterId
	 * @uml.property  name="reportParameterId"
	 */
	public void setReportParameterId(int reportParameterId)
	{
		this.reportParameterId = reportParameterId;
	}

	/**
	 * @return
	 * @uml.property  name="command"
	 */
	public String getCommand()
	{
		return command;
	}

	/**
	 * @param command
	 * @uml.property  name="command"
	 */
	public void setCommand(String command)
	{
		this.command = command;
	}

	/**
	 * @return
	 * @uml.property  name="submitAdd"
	 */
	public String getSubmitAdd()
	{
		return submitAdd;
	}

	/**
	 * @param submitAdd
	 * @uml.property  name="submitAdd"
	 */
	public void setSubmitAdd(String submitAdd)
	{
		this.submitAdd = submitAdd;
	}

	/**
	 * @return
	 * @uml.property  name="submitUpdate"
	 */
	public String getSubmitUpdate()
	{
		return submitUpdate;
	}

	/**
	 * @param submitUpdate
	 * @uml.property  name="submitUpdate"
	 */
	public void setSubmitUpdate(String submitUpdate)
	{
		this.submitUpdate = submitUpdate;
	}

	/**
	 * @return
	 * @uml.property  name="submitDelete"
	 */
	public String getSubmitDelete()
	{
		return submitDelete;
	}

	/**
	 * @param submitDelete
	 * @uml.property  name="submitDelete"
	 */
	public void setSubmitDelete(String submitDelete)
	{
		this.submitDelete = submitDelete;
	}

    /**
	 * @return
	 * @uml.property  name="submitLoad"
	 */
    public String getSubmitLoad()
    {
        return submitLoad;
    }

    /**
	 * @param submitLoad
	 * @uml.property  name="submitLoad"
	 */
    public void setSubmitLoad(String submitLoad)
    {
        this.submitLoad = submitLoad;
    }
    
    /**
	 * @return
	 * @uml.property  name="submitLoadAndCreate"
	 */
    public String getSubmitLoadAndCreate()
    {
        return submitLoadAndCreate;
    }

    /**
	 * @param submitLoadAndCreate
	 * @uml.property  name="submitLoadAndCreate"
	 */
    public void setSubmitLoadAndCreate(String submitLoadAndCreate)
    {
        this.submitLoadAndCreate = submitLoadAndCreate;
    }
    
	/**
	 * @return
	 * @uml.property  name="required"
	 */
	public boolean isRequired()
	{
		return required;
	}

	/**
	 * @param required
	 * @uml.property  name="required"
	 */
	public void setRequired(boolean required)
	{
		this.required = required;
	}

	/**
	 * @return
	 * @uml.property  name="sortOrder"
	 */
	public int getSortOrder()
	{
		return sortOrder;
	}

	/**
	 * @param sortOrder
	 * @uml.property  name="sortOrder"
	 */
	public void setSortOrder(int sortOrder)
	{
		this.sortOrder = sortOrder;
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
	 * @param directoryProvider
	 * @uml.property  name="directoryProvider"
	 */
    public void setDirectoryProvider(DirectoryProvider directoryProvider)
    {
        this.directoryProvider = directoryProvider;
    }

    /**
	 * @param dataSourceProvider
	 * @uml.property  name="dataSourceProvider"
	 */
    public void setDataSourceProvider(DataSourceProvider dataSourceProvider)
    {
        this.dataSourceProvider = dataSourceProvider;
    }

    /**
	 * @param propertiesProvider
	 * @uml.property  name="propertiesProvider"
	 */
    public void setPropertiesProvider(PropertiesProvider propertiesProvider)
    {
        this.propertiesProvider = propertiesProvider;
    }

}