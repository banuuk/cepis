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

package org.efs.openreports.objects;

import java.io.Serializable;

/**
 * @author  keerthi
 */
public class ReportChart implements Serializable
{	
	private static final long serialVersionUID = 7406441909199255551L;
	
	public static final int BAR_CHART = 0;
	public static final int PIE_CHART = 1;
	public static final int XY_CHART = 2;
	public static final int TIME_CHART = 3;
	public static final int RING_CHART = 4;	
	public static final int AREA_CHART = 5;
	public static final int XY_AREA_CHART = 6;	
	public static final int TIME_AREA_CHART = 7;
	public static final int STACKED_BAR_CHART = 8;
	public static final int DIAL_CHART = 9;
	public static final int THERMOMETER_CHART = 10;
	public static final int BUBBLE_CHART = 11;	
	public static final int XY_BAR_CHART = 13;
	public static final int STACKED_XY_BAR_CHART = 14;
	public static final int TIME_BAR_CHART = 15;
	public static final int STACKED_TIME_BAR_CHART = 16;
	
	public static final int HORIZONTAL = 1;
	public static final int VERTICAL = 2;
	
	public static final String DRILLDOWN_PARAMETER = "DrillDown";
	
	/**
	 * @uml.property  name="id"
	 */
	private Integer id;
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
	 * @uml.property  name="chartType"
	 */
	private int chartType;
	
	/**
	 * @uml.property  name="width"
	 */
	private int width = 400;
	/**
	 * @uml.property  name="height"
	 */
	private int height = 400;
	
	private String xAxisLabel;
	private String yAxisLabel;
	
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
	 * @uml.property  name="plotOrientation"
	 */
	private int plotOrientation;

	/**
	 * @uml.property  name="dataSource"
	 * @uml.associationEnd  
	 */
	private ReportDataSource dataSource;
	
	/**
	 * @uml.property  name="drillDownReport"
	 * @uml.associationEnd  
	 */
	private Report drillDownReport;
	
	/**
	 * @uml.property  name="overlayChart"
	 * @uml.associationEnd  
	 */
	private ReportChart overlayChart;

	public ReportChart()
	{
	}

	/**
	 * @param id
	 * @uml.property  name="id"
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}

	public String toString()
	{
		return name;
	}

	/**
	 * @return
	 * @uml.property  name="description"
	 */
	public String getDescription()
	{
		return description;
	}

	public String getTitle()
	{
		if (showTitle) return description;
		return null;
	}
	
	/**
	 * @return
	 * @uml.property  name="id"
	 */
	public Integer getId()
	{
		return id;
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
	 * @param description
	 * @uml.property  name="description"
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @param name
	 * @uml.property  name="name"
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	public int compareTo(Object object)
	{
		ReportChart reportChart = (ReportChart) object;
		return name.compareTo(reportChart.getName());
	}

	/**
	 * @return
	 * @uml.property  name="dataSource"
	 */
	public ReportDataSource getDataSource()
	{
		return dataSource;
	}

	/**
	 * @param dataSource
	 * @uml.property  name="dataSource"
	 */
	public void setDataSource(ReportDataSource dataSource)
	{
		this.dataSource = dataSource;
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
	 * @return
	 * @uml.property  name="showLegend"
	 */
	public boolean isShowLegend()
	{
		return showLegend;
	}

	public void setShowLegend(Boolean showLegend)
	{
		if (showLegend == null) showLegend = new Boolean(false);
		this.showLegend = showLegend.booleanValue();
	}
	
	/**
	 * @return
	 * @uml.property  name="showTitle"
	 */
	public boolean isShowTitle()
	{
		return showTitle;
	}

	public void setShowTitle(Boolean showTitle)
	{
		if (showTitle == null) showTitle = new Boolean(false);
		this.showTitle = showTitle.booleanValue();
	}		

	/**
	 * @return
	 * @uml.property  name="plotOrientation"
	 */
	public int getPlotOrientation()
	{
		return plotOrientation;
	}

	public void setPlotOrientation(Integer plotOrientation)
	{
		if (plotOrientation == null) plotOrientation = new Integer(VERTICAL);
		this.plotOrientation = plotOrientation.intValue();
	}	

	/**
	 * @return
	 * @uml.property  name="drillDownReport"
	 */
	public Report getDrillDownReport()
	{
		return drillDownReport;
	}

	/**
	 * @param drillDownReport
	 * @uml.property  name="drillDownReport"
	 */
	public void setDrillDownReport(Report drillDownReport)
	{
		this.drillDownReport = drillDownReport;
	}

	/**
	 * @return
	 * @uml.property  name="showValues"
	 */
	public boolean isShowValues()
	{
		return showValues;
	}

	public void setShowValues(Boolean showValues)
	{
		if (showValues == null) showValues = new Boolean(false);
		this.showValues = showValues.booleanValue();
	}	
	
	/**
	 * @return
	 * @uml.property  name="overlayChart"
	 */
	public ReportChart getOverlayChart()
	{
		return overlayChart;
	}
	
	/**
	 * @param overlayChart
	 * @uml.property  name="overlayChart"
	 */
	public void setOverlayChart(ReportChart overlayChart)
	{
		this.overlayChart = overlayChart;
	}
}
