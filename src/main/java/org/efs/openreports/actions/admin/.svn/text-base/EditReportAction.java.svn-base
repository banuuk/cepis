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

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;
import org.efs.openreports.ORStatics;
import org.efs.openreports.objects.*;
import org.efs.openreports.providers.*;
import org.efs.openreports.util.LocalStrings;
import org.efs.openreports.util.ORUtil;

/**
 * @author  keerthi
 */
public class EditReportAction extends ActionSupport
{	
	private static final long serialVersionUID = 6851899249540541143L;

	protected static Logger log = Logger.getLogger(EditReportAction.class);

	/**
	 * @uml.property  name="command"
	 */
	private String command;
    /**
	 * @uml.property  name="selectedTab"
	 */
    private int selectedTab = 1;
	private boolean submitOk;
	private boolean submitValidate;
	private boolean submitDuplicate;

	/**
	 * @uml.property  name="id"
	 */
	private int id;
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	/**
	 * @uml.property  name="description"
	 */
	private String description;
    /**
	 * @uml.property  name="tags"
	 */
    private String tags;
	/**
	 * @uml.property  name="file"
	 */
	private String file;
	/**
	 * @uml.property  name="query"
	 */
	private String query;
	/**
	 * @uml.property  name="dataSourceId"
	 */
	private int dataSourceId;
	/**
	 * @uml.property  name="reportChartId"
	 */
	private int reportChartId;

	/**
	 * @uml.property  name="pdfExportEnabled"
	 */
	private boolean pdfExportEnabled;
	/**
	 * @uml.property  name="htmlExportEnabled"
	 */
	private boolean htmlExportEnabled;
	/**
	 * @uml.property  name="csvExportEnabled"
	 */
	private boolean csvExportEnabled;
	/**
	 * @uml.property  name="xlsExportEnabled"
	 */
	private boolean xlsExportEnabled;
	/**
	 * @uml.property  name="rtfExportEnabled"
	 */
	private boolean rtfExportEnabled;
	/**
	 * @uml.property  name="textExportEnabled"
	 */
	private boolean textExportEnabled;
	/**
	 * @uml.property  name="excelExportEnabled"
	 */
	private boolean excelExportEnabled;
	/**
	 * @uml.property  name="imageExportEnabled"
	 */
	private boolean imageExportEnabled;
	/**
	 * @uml.property  name="virtual"
	 */
	private boolean virtual;
	/**
	 * @uml.property  name="hidden"
	 */
	private boolean hidden;
	
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
	 * @uml.property  name="dataSourceProvider"
	 * @uml.associationEnd  
	 */
	private DataSourceProvider dataSourceProvider;
	/**
	 * @uml.property  name="chartProvider"
	 * @uml.associationEnd  
	 */
	private ChartProvider chartProvider;
	/**
	 * @uml.property  name="parameterProvider"
	 * @uml.associationEnd  
	 */
	private ParameterProvider parameterProvider;
    /**
	 * @uml.property  name="tagProvider"
	 * @uml.associationEnd  
	 */
    private TagProvider tagProvider;
	
	/**
	 * @uml.property  name="parameterValues"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private ReportParameterValue[] parameterValues;    
    
	@Override
	public String execute()
	{
		try
		{
			if (command.equals("edit"))
			{
				report = reportProvider.getReport(new Integer(id));
			}
			else
			{
				report = new Report();
			}

			if (command.equals("edit") && !submitOk && !submitValidate && !submitDuplicate)
			{
				name = report.getName();
				description = report.getDescription();
                tags = tagProvider.getTagsForObject(report.getId(), Report.class, ORTag.TAG_TYPE_UI);
				file = report.getFile();
				query = report.getQuery();
				id = report.getId().intValue();
				pdfExportEnabled = report.isPdfExportEnabled();
				csvExportEnabled = report.isCsvExportEnabled();
				htmlExportEnabled = report.isHtmlExportEnabled();
				xlsExportEnabled = report.isXlsExportEnabled();
				rtfExportEnabled = report.isRtfExportEnabled();
				textExportEnabled = report.isTextExportEnabled();
				excelExportEnabled = report.isExcelExportEnabled();
				imageExportEnabled = report.isImageExportEnabled();
				virtual = report.isVirtualizationEnabled();
				hidden = report.isHidden();
				if (report.getDataSource() != null)
				{
					dataSourceId = report.getDataSource().getId().intValue();
				}
				if (report.getReportChart() != null)
				{
					reportChartId = report.getReportChart().getId().intValue();
				}
			}

			if (!submitOk && !submitValidate && !submitDuplicate)
				return INPUT;
			
			if (name == null || name.trim().length() < 1)
			{
				addActionError(LocalStrings.ERROR_REPORT_INVALID);
				return INPUT;
			}

			if (submitDuplicate)
            {
            	command = "add";
            	report.setId(null);
            	report.getReportExportOption().setId(null);    	
            	
            	if (report.getName().equals(name))
            	{
            		name = "Copy of ".concat(name);
            	}
            }
			
			report.setName(name);
			report.setDescription(description);
			report.setFile(file);
			report.setQuery(query);
			report.setCsvExportEnabled(csvExportEnabled);
			report.setHtmlExportEnabled(htmlExportEnabled);
			report.setPdfExportEnabled(pdfExportEnabled);
			report.setXlsExportEnabled(xlsExportEnabled);
			report.setRtfExportEnabled(new Boolean(rtfExportEnabled));
			report.setTextExportEnabled(new Boolean(textExportEnabled));
			report.setExcelExportEnabled(new Boolean(excelExportEnabled));
			report.setImageExportEnabled(new Boolean(imageExportEnabled));
			report.setVirtualizationEnabled(new Boolean(virtual));
			report.setHidden(new Boolean(hidden));
			
			if ((query == null || query.trim().length() < 1)
				&& !csvExportEnabled
				&& !htmlExportEnabled
				&& !pdfExportEnabled
				&& !xlsExportEnabled
				&& !rtfExportEnabled
				&& !textExportEnabled
				&& !excelExportEnabled)
			{
				report.setPdfExportEnabled(true);
			}

			if (dataSourceId != -1)
			{
				report.setDataSource(
					dataSourceProvider.getDataSource(
						new Integer(dataSourceId)));
			}
			else
			{
				report.setDataSource(null);
			}

			if (reportChartId != -1)
			{
				report.setReportChart(
					chartProvider.getReportChart(new Integer(reportChartId)));
			}
			else
			{
				report.setReportChart(null);
			}			

			if (submitValidate)
			{
				if (report.getQuery() == null || report.getQuery().length() < 1) return INPUT;
				
				Map<String,Object> map = new HashMap<String,Object>();
				if (query.toUpperCase().indexOf("$P") > -1)
				{
					ReportUser reportUser = (ReportUser) ActionContext.getContext().getSession().get(ORStatics.REPORT_USER);						
					map = ORUtil.buildQueryParameterMap(reportUser, query, parameterProvider);
				}
				
				//FIXME validate query as parameter...
				ReportParameter reportParameter = new ReportParameter();
				reportParameter.setData(query);
				reportParameter.setType(ReportParameter.QUERY_PARAM);
				reportParameter.setDataSource(report.getDataSource());
				reportParameter.setClassName("java.lang.String");
				
				parameterValues = parameterProvider.getParamValues(reportParameter, map);

				return INPUT;
			}			

			if (command.equals("edit"))
			{
				reportProvider.updateReport(report);				
			}

			if (command.equals("add"))
			{
				/* 
				 * This code is required because Report is part of the primary key for ReportParameterMap.
				 * If the list of parameters is not a new list, Hibernate will update the parameters
				 * of the original report instead of creating new ones. 
				 */
				if (submitDuplicate && report.getParameters() != null && report.getParameters().size() > 0)
				{
					ArrayList<ReportParameterMap> duplicateParameters = new ArrayList<ReportParameterMap>();
					List<ReportParameterMap> parameters = report.getParameters();
					
					report.setParameters(null);					
					report = reportProvider.insertReport(report);	
					
            		for (int index =0; index < parameters.size(); index++)
            		{
            			ReportParameterMap map = parameters.get(index);
            			map.setReport(report);     	
            			
            			duplicateParameters.add(map);
            		}		
            		
            		report.setParameters(duplicateParameters);        		
            		reportProvider.updateReport(report);
				}
				else
				{	
					report = reportProvider.insertReport(report);
				}
			}
            
            // save tags
            tagProvider.setTags(report.getId(), Report.class, tags, ORTag.TAG_TYPE_UI);            
			
			return SUCCESS;
		}
		catch (Exception e)
		{            
			addActionError(e.getMessage());
			return INPUT;
		}
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
	 * @uml.property  name="dataSourceId"
	 */
	public int getDataSourceId()
	{
		return dataSourceId;
	}

	/**
	 * @return
	 * @uml.property  name="description"
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @return
	 * @uml.property  name="file"
	 */
	public String getFile()
	{
		return file;
	}

	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param dataSourceId
	 * @uml.property  name="dataSourceId"
	 */
	public void setDataSourceId(int dataSourceId)
	{
		this.dataSourceId = dataSourceId;
	}

	/**
	 * @param description
	 * @uml.property  name="description"
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @param file
	 * @uml.property  name="file"
	 */
	public void setFile(String file)
	{
		this.file = file;
	}

	/**
	 * @param name
	 * @uml.property  name="name"
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	public List<ReportDataSource> getDataSources()
	{
		try
		{
			return dataSourceProvider.getDataSources();
		}
		catch (Exception e)
		{
			addActionError(e.toString());
			return null;
		}
	}

	public List<String> getReportFileNames()
	{
		try
		{
			return reportProvider.getReportFileNames();
		}
		catch (Exception e)
		{
			addActionError(e.toString());
			return null;
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

	public List<ReportParameterMap> getParametersInReport()
	{
		if (report == null || report.getParameters() == null)
			return null;

		List<ReportParameterMap> list = report.getParameters();
		Collections.sort(list);

		return list;
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
	
	/**
	 * @return
	 * @uml.property  name="report"
	 */
	public Report getReport()
	{
		return report;
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
	 * @param reportProvider
	 * @uml.property  name="reportProvider"
	 */
	public void setReportProvider(ReportProvider reportProvider)
	{
		this.reportProvider = reportProvider;
	}

	/**
	 * @return
	 * @uml.property  name="reportChartId"
	 */
	public int getReportChartId()
	{
		return reportChartId;
	}

	/**
	 * @param reportChartId
	 * @uml.property  name="reportChartId"
	 */
	public void setReportChartId(int reportChartId)
	{
		this.reportChartId = reportChartId;
	}

	public List<ReportChart> getReportCharts()
	{
		try
		{
			return chartProvider.getReportCharts();
		}
		catch (Exception e)
		{
			addActionError(e.toString());
			return null;
		}
	}

	/**
	 * @param chartProvider
	 * @uml.property  name="chartProvider"
	 */
	public void setChartProvider(ChartProvider chartProvider)
	{
		this.chartProvider = chartProvider;
	}

	/**
	 * @return
	 * @uml.property  name="csvExportEnabled"
	 */
	public boolean isCsvExportEnabled()
	{
		return csvExportEnabled;
	}

	/**
	 * @param csvExportEnabled
	 * @uml.property  name="csvExportEnabled"
	 */
	public void setCsvExportEnabled(boolean csvExportEnabled)
	{
		this.csvExportEnabled = csvExportEnabled;
	}

	/**
	 * @return
	 * @uml.property  name="htmlExportEnabled"
	 */
	public boolean isHtmlExportEnabled()
	{
		return htmlExportEnabled;
	}

	/**
	 * @param htmlExportEnabled
	 * @uml.property  name="htmlExportEnabled"
	 */
	public void setHtmlExportEnabled(boolean htmlExportEnabled)
	{
		this.htmlExportEnabled = htmlExportEnabled;
	}

	/**
	 * @return
	 * @uml.property  name="pdfExportEnabled"
	 */
	public boolean isPdfExportEnabled()
	{
		return pdfExportEnabled;
	}

	/**
	 * @param pdfExportEnabled
	 * @uml.property  name="pdfExportEnabled"
	 */
	public void setPdfExportEnabled(boolean pdfExportEnabled)
	{
		this.pdfExportEnabled = pdfExportEnabled;
	}

	/**
	 * @return
	 * @uml.property  name="xlsExportEnabled"
	 */
	public boolean isXlsExportEnabled()
	{
		return xlsExportEnabled;
	}

	/**
	 * @param xlsExportEnabled
	 * @uml.property  name="xlsExportEnabled"
	 */
	public void setXlsExportEnabled(boolean xlsExportEnabled)
	{
		this.xlsExportEnabled = xlsExportEnabled;
	}

	/**
	 * @return
	 * @uml.property  name="query"
	 */
	public String getQuery()
	{
		return query;
	}

	/**
	 * @param query
	 * @uml.property  name="query"
	 */
	public void setQuery(String query)
	{
		this.query = query;
	}
	
	public void setSubmitOk(String submitOk)
	{
		if (submitOk != null) this.submitOk = true;
	}
	
	public void setSubmitValidate(String submitValidate)
	{
		if (submitValidate != null) this.submitValidate = true;
	}
	
	public void setSubmitDuplicate(String submitDuplicate)
	{
		if (submitDuplicate != null) this.submitDuplicate = true;
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
	 * @uml.property  name="parameterValues"
	 */
	public ReportParameterValue[] getParameterValues()
	{
		return parameterValues;
	}

	/**
	 * @return
	 * @uml.property  name="excelExportEnabled"
	 */
	public boolean isExcelExportEnabled()
	{
		return excelExportEnabled;
	}

	/**
	 * @param excelExportEnabled
	 * @uml.property  name="excelExportEnabled"
	 */
	public void setExcelExportEnabled(boolean excelExportEnabled)
	{
		this.excelExportEnabled = excelExportEnabled;
	}

	/**
	 * @return
	 * @uml.property  name="rtfExportEnabled"
	 */
	public boolean isRtfExportEnabled()
	{
		return rtfExportEnabled;
	}

	/**
	 * @param rtfExportEnabled
	 * @uml.property  name="rtfExportEnabled"
	 */
	public void setRtfExportEnabled(boolean rtfExportEnabled)
	{
		this.rtfExportEnabled = rtfExportEnabled;
	}

	/**
	 * @return
	 * @uml.property  name="imageExportEnabled"
	 */
	public boolean isImageExportEnabled()
	{
		return imageExportEnabled;
	}

	/**
	 * @param imageExportEnabled
	 * @uml.property  name="imageExportEnabled"
	 */
	public void setImageExportEnabled(boolean imageExportEnabled)
	{
		this.imageExportEnabled = imageExportEnabled;
	}
	
	/**
	 * @return
	 * @uml.property  name="textExportEnabled"
	 */
	public boolean isTextExportEnabled()
	{
		return textExportEnabled;
	}

	/**
	 * @param textExportEnabled
	 * @uml.property  name="textExportEnabled"
	 */
	public void setTextExportEnabled(boolean textExportEnabled)
	{
		this.textExportEnabled = textExportEnabled;
	}
	
	/**
	 * @return
	 * @uml.property  name="hidden"
	 */
	public boolean isHidden()
	{
		return hidden;
	}

	/**
	 * @param hidden
	 * @uml.property  name="hidden"
	 */
	public void setHidden(boolean hidden)
	{
		this.hidden = hidden;
	}	

	/**
	 * @return
	 * @uml.property  name="virtual"
	 */
	public boolean isVirtual()
	{
		return virtual;
	}

	/**
	 * @param virtual
	 * @uml.property  name="virtual"
	 */
	public void setVirtual(boolean virtual)
	{
		this.virtual = virtual;
	}
    
    public String[] getTypes()
    {
        return ReportParameter.TYPES;
    }

    public String[] getClassNames()
    {
        return ReportParameter.CLASS_NAMES;
    }
    
    /**
	 * @return
	 * @uml.property  name="selectedTab"
	 */
    public int getSelectedTab() 
    {
        return selectedTab;
    }
    
    /**
	 * @param selectedTab
	 * @uml.property  name="selectedTab"
	 */
    public void setSelectedTab(int selectedTab)
    {
        this.selectedTab = selectedTab;
    }
    
    /**
	 * @return
	 * @uml.property  name="tags"
	 */
    public String getTags() 
    {
        return tags;
    }
    
    /**
	 * @param tags
	 * @uml.property  name="tags"
	 */
    public void setTags(String tags)     
    {
        this.tags = tags;
    }
    
    /**
	 * @param tagProvider
	 * @uml.property  name="tagProvider"
	 */
    public void setTagProvider(TagProvider tagProvider) 
    {
        this.tagProvider = tagProvider;
    }
}