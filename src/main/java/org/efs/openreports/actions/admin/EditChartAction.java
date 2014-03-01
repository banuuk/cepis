/*
 * Copyright (C) 2003 Erik Swenson - erik@oreports.com
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
import org.efs.openreports.engine.ChartReportEngine;
import org.efs.openreports.objects.Report;
import org.efs.openreports.objects.ReportChart;
import org.efs.openreports.objects.ReportDataSource;
import org.efs.openreports.objects.ReportParameter;
import org.efs.openreports.objects.ReportUser;
import org.efs.openreports.objects.chart.ChartValue;
import org.efs.openreports.providers.*;
import org.efs.openreports.util.LocalStrings;
import org.efs.openreports.util.ORUtil;

/**
 * @author  keerthi
 */
public class EditChartAction extends ActionSupport
{
	private static final long serialVersionUID = 2722493118904482540L;

	protected static Logger log = Logger.getLogger(EditChartAction.class);

	/**
	 * @uml.property  name="command"
	 */
	private String command;
	
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
	 * @uml.property  name="query"
	 */
	private String query;	
	/**
	 * @uml.property  name="dataSourceId"
	 */
	private int dataSourceId = Integer.MIN_VALUE;	
	/**
	 * @uml.property  name="reportId"
	 */
	private int reportId = Integer.MIN_VALUE;
	/**
	 * @uml.property  name="chartType"
	 */
	private int chartType;
	/**
	 * @uml.property  name="width"
	 */
	private int width = 600;
	/**
	 * @uml.property  name="height"
	 */
	private int height = 400;
	private String xAxisLabel;
	private String yAxisLabel;	
	/**
	 * @uml.property  name="orientation"
	 */
	private int orientation;	
	/**
	 * @uml.property  name="showLegend"
	 */
	private boolean showLegend;
	/**
	 * @uml.property  name="showTitle"
	 */
	private boolean showTitle;
	/**
	 * @uml.property  name="showValues"
	 */
	private boolean showValues;	

	/**
	 * @uml.property  name="reportChart"
	 * @uml.associationEnd  
	 */
	private ReportChart reportChart;		
	/**
	 * @uml.property  name="chartValues"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private ChartValue[] chartValues;
	/**
	 * @uml.property  name="overlayChartId"
	 */
	private int overlayChartId = Integer.MIN_VALUE;

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
	 * @uml.property  name="reportProvider"
	 * @uml.associationEnd  
	 */
	private ReportProvider reportProvider;	
	/**
	 * @uml.property  name="propertiesProvider"
	 * @uml.associationEnd  
	 */
	private PropertiesProvider propertiesProvider;
	/**
	 * @uml.property  name="directoryProvider"
	 * @uml.associationEnd  
	 */
	private DirectoryProvider directoryProvider;

	@Override
	public String execute()
	{
		try
		{
			if (command.equals("edit"))
			{
				reportChart =
					chartProvider.getReportChart(new Integer(id));
			}
			else
			{
				reportChart = new ReportChart();
			}

			if (command.equals("edit") && !submitOk && !submitValidate && !submitDuplicate)
			{
				name = reportChart.getName();
				description = reportChart.getDescription();
				query = reportChart.getQuery();						
				chartType = reportChart.getChartType();
				width = reportChart.getWidth();
				height = reportChart.getHeight();
				xAxisLabel = reportChart.getXAxisLabel();
				yAxisLabel = reportChart.getYAxisLabel();				
				orientation = reportChart.getPlotOrientation();				
				showLegend = reportChart.isShowLegend();
				showTitle = reportChart.isShowTitle();
				showValues = reportChart.isShowValues();				
				id = reportChart.getId().intValue();
				
				if (reportChart.getDataSource() != null)
				{
					dataSourceId =
						reportChart.getDataSource().getId().intValue();
				}	
				
				if (reportChart.getDrillDownReport() != null)
				{
					reportId = reportChart.getDrillDownReport().getId().intValue();
				}
				
				if (reportChart.getOverlayChart() != null)
				{
					overlayChartId = reportChart.getOverlayChart().getId();
				}
				
			}

			if (!submitOk && !submitValidate && !submitDuplicate) return INPUT;            
			
            if (name == null || name.trim().length() < 1 || 
                description == null || description.trim().length() < 1 ||
                query == null || query.trim().length() < 1 )
            {
                addActionError(getText(LocalStrings.ERROR_CHART_INVALID));
                return INPUT;
            }
            
            if (submitDuplicate)
            {
            	command = "add";
            	reportChart.setId(null);
            	
            	if (reportChart.getName().equals(name))
            	{
            		name = "Copy of ".concat(name);
            	}
            }
                        
			reportChart.setName(name);
			reportChart.setDescription(description);
			reportChart.setQuery(query);				
			reportChart.setChartType(chartType);			
			reportChart.setWidth(width);
			reportChart.setHeight(height);
			reportChart.setXAxisLabel(xAxisLabel);
			reportChart.setYAxisLabel(yAxisLabel);			
			reportChart.setShowLegend(new Boolean(showLegend));
			reportChart.setShowTitle(new Boolean(showTitle));
			reportChart.setShowValues(new Boolean(showValues));
			reportChart.setPlotOrientation(new Integer(orientation));			
			
			if (dataSourceId != -1) reportChart.setDataSource(dataSourceProvider
					.getDataSource(new Integer(dataSourceId)));
			
			if (reportId != -1)
			{
				reportChart.setDrillDownReport(reportProvider.getReport(new Integer(reportId)));	
			}
			else
			{
				reportChart.setDrillDownReport(null);
			}	
			
			if (overlayChartId != -1)
			{
				reportChart.setOverlayChart(chartProvider.getReportChart(overlayChartId));
			}
			else
			{
				reportChart.setOverlayChart(null);
			}			
			
			if (submitValidate)
			{
				Map<String,Object> map = new HashMap<String,Object>();
				if (query.toUpperCase().indexOf("$P") > -1)
				{
					ReportUser reportUser = (ReportUser) ActionContext.getContext().getSession().get(ORStatics.REPORT_USER);
					map = ORUtil.buildQueryParameterMap(reportUser, query, parameterProvider);
				}
				
				ChartReportEngine chartReportEngine = new ChartReportEngine(
						dataSourceProvider, directoryProvider, propertiesProvider);				
				
				chartValues = chartReportEngine.getChartValues(reportChart, map);

				return INPUT;
			}			

			if (command.equals("edit"))
			{				
				chartProvider.updateReportChart(reportChart);
			}

			if (command.equals("add"))
			{
				reportChart  = chartProvider.insertReportChart(reportChart);
                id = reportChart.getId().intValue();
			}

			return SUCCESS;
		}
		catch (Exception e)
		{
			addActionError(getText(e.getMessage()));
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
	 * @return
	 * @uml.property  name="dataSourceId"
	 */
	public int getDataSourceId()
	{
		return dataSourceId;
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
			addActionError(getText(e.getMessage()));
			return null;
		}
	}
	
	public List<Report> getReports()
	{	
		try
		{
			return reportProvider.getReports();		
		}
		catch (Exception e)
		{
			addActionError(getText(e.getMessage()));
			return null;
		}		
	}
	
	public List<ReportChart> getReportCharts()
	{	
		try
		{
			return chartProvider.getReportCharts();		
		}
		catch (Exception e)
		{
			addActionError(getText(e.getMessage()));
			return null;
		}		
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

	/**
	 * @param dataSourceProvider
	 * @uml.property  name="dataSourceProvider"
	 */
	public void setDataSourceProvider(DataSourceProvider dataSourceProvider)
	{
		this.dataSourceProvider = dataSourceProvider;
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
	 * @param description
	 * @uml.property  name="description"
	 */
	public void setDescription(String description)
	{
		this.description = description;
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
	
	/**
	 * @return
	 * @uml.property  name="chartType"
	 */
	public int getChartType()
	{
		return chartType;
	}

	/**
	 * @param chartType
	 * @uml.property  name="chartType"
	 */
	public void setChartType(int chartType)
	{
		this.chartType = chartType;
	}
		
	/**
	 * @return
	 * @uml.property  name="height"
	 */
	public int getHeight()
	{
		return height;
	}

	/**
	 * @param height
	 * @uml.property  name="height"
	 */
	public void setHeight(int height)
	{
		this.height = height;
	}

	/**
	 * @return
	 * @uml.property  name="width"
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * @param width
	 * @uml.property  name="width"
	 */
	public void setWidth(int width)
	{
		this.width = width;
	}

	/**
	 * @return
	 * @uml.property  name="chartValues"
	 */
	public ChartValue[] getChartValues()
	{
		return chartValues;
	}

	public String getXAxisLabel()
	{
		return xAxisLabel;
	}

	public void setXAxisLabel(String axisLabel)
	{
		xAxisLabel = axisLabel;
	}

	public String getYAxisLabel()
	{
		return yAxisLabel;
	}

	public void setYAxisLabel(String axisLabel)
	{
		yAxisLabel = axisLabel;
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
	 * @uml.property  name="orientation"
	 */
	public int getOrientation()
	{
		return orientation;
	}

	/**
	 * @param orientation
	 * @uml.property  name="orientation"
	 */
	public void setOrientation(int orientation)
	{
		this.orientation = orientation;
	}

	/**
	 * @return
	 * @uml.property  name="showLegend"
	 */
	public boolean isShowLegend()
	{
		return showLegend;
	}	

	/**
	 * @param showLegend
	 * @uml.property  name="showLegend"
	 */
	public void setShowLegend(boolean showLegend)
	{
		this.showLegend = showLegend;
	}

	/**
	 * @return
	 * @uml.property  name="showTitle"
	 */
	public boolean isShowTitle()
	{
		return showTitle;
	}

	/**
	 * @param showTitle
	 * @uml.property  name="showTitle"
	 */
	public void setShowTitle(boolean showTitle)
	{
		this.showTitle = showTitle;
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
	 * @param reportProvider
	 * @uml.property  name="reportProvider"
	 */
	public void setReportProvider(ReportProvider reportProvider)
	{
		this.reportProvider = reportProvider;
	}

	/**
	 * @return
	 * @uml.property  name="showValues"
	 */
	public boolean isShowValues()
	{
		return showValues;
	}

	/**
	 * @param showValues
	 * @uml.property  name="showValues"
	 */
	public void setShowValues(boolean showValues)
	{
		this.showValues = showValues;
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
	 * @param propertiesProvider
	 * @uml.property  name="propertiesProvider"
	 */
	public void setPropertiesProvider(PropertiesProvider propertiesProvider)
	{
		this.propertiesProvider = propertiesProvider;
	}
	
	/**
	 * @return
	 * @uml.property  name="overlayChartId"
	 */
	public int getOverlayChartId()
	{
		return overlayChartId;
	}
	
	/**
	 * @param overlayChartId
	 * @uml.property  name="overlayChartId"
	 */
	public void setOverlayChartId(int overlayChartId)
	{
		this.overlayChartId = overlayChartId;
	}
}
