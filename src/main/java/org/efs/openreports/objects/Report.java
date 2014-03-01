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

package org.efs.openreports.objects;

import java.io.Serializable;
import java.util.*;

/**
 * @author  keerthi
 */
public class Report implements Comparable<Report>, Serializable
{
	private static final long serialVersionUID = 4068258161793785996l;

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
	 * @uml.property  name="file"
	 */
	private String file;

	/**
	 * @uml.property  name="query"
	 */
	private String query;

	/**
	 * @uml.property  name="dataSource"
	 * @uml.associationEnd  
	 */
	private ReportDataSource dataSource;

	/**
	 * @uml.property  name="reportChart"
	 * @uml.associationEnd  
	 */
	private ReportChart reportChart;

	/**
	 * @uml.property  name="parameters"
	 */
	private List<ReportParameterMap> parameters;

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
	 * @uml.property  name="virtualizationEnabled"
	 */
	private boolean virtualizationEnabled;
	
	/**
	 * @uml.property  name="hidden"
	 */
	private boolean hidden;

	/**
	 * @uml.property  name="reportExportOption"
	 * @uml.associationEnd  
	 */
	private ReportExportOption reportExportOption;
	
	/**
	 * @uml.property  name="displayInline"
	 */
	private transient boolean displayInline;

	public Report()
	{
	}

	public boolean isBirtReport()
	{
		if (file != null && file.endsWith("rptdesign")) return true;
		
		return false;
	}

	public boolean isJasperReport()
	{
		if (file != null && file.endsWith("jasper")) return true;
		
		return false;
	}
	
	public boolean isQueryReport()
	{
		if (query != null && query.length() > 0 && !file.endsWith("xls") && !file.endsWith("xml") && !file.endsWith("vm"))
		{
			return true;
		}

		return false;
	}

	public boolean isChartReport()
	{
		if ((query == null || query.trim().length() < 1)
				&& (file == null || file.equals("-1")) && reportChart != null)
		{
			return true;
		}

		return false;
	}
	
	public boolean isJFreeReport()
	{
		if (query != null && query.length() > 0 && file != null && file.endsWith("xml") && !isJPivotReport())
		{
			return true;
		}

		return false;
	}
	
	public boolean isJXLSReport()
	{
		if (file != null && file.endsWith("xls"))
		{
			return true;
		}

		return false;
	}

    public boolean isJPivotReport()
    {
        if (file != null && file.equalsIgnoreCase("datasources.xml")) return true;
        
        return false;
    }
    
    public boolean isVelocityReport()
    {
        if (file != null && file.endsWith("vm")) return true;
        
        return false;
    }
	/**
	 * @param id
	 * @uml.property  name="id"
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}

	@Override
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

	/**
	 * @return
	 * @uml.property  name="parameters"
	 */
	public List<ReportParameterMap> getParameters()
	{
		return parameters;
	}

	public List<ReportParameterMap> getSubReportParameters()
	{
		ArrayList<ReportParameterMap> subReportParameters = new ArrayList<ReportParameterMap>();

		if (parameters != null)
		{
			Iterator<ReportParameterMap> iterator = parameters.iterator();
			while (iterator.hasNext())
			{
				ReportParameterMap rpMap = iterator.next();

				if (rpMap.getReportParameter().getType().equals(
						ReportParameter.SUBREPORT_PARAM))
				{
					subReportParameters.add(rpMap);
				}
			}
		}

		return subReportParameters;
	}

	/**
	 * @param parameters
	 * @uml.property  name="parameters"
	 */
	public void setParameters(List<ReportParameterMap> parameters)
	{
		this.parameters = parameters;
	}

	public ReportParameterMap getReportParameterMap(Integer parameterId)
	{
		Iterator<ReportParameterMap> iterator = parameters.iterator();
		while (iterator.hasNext())
		{
			ReportParameterMap rpMap = iterator.next();

			if (rpMap.getReportParameter().getId().equals(parameterId))
			{
				return rpMap;
			}
		}

		return null;
	}

	public List<ReportParameterMap> getReportParametersByStep(int step)
	{
		List<ReportParameterMap> list = new ArrayList<ReportParameterMap>();

		Iterator<ReportParameterMap> iterator = parameters.iterator();
		while (iterator.hasNext())
		{
			ReportParameterMap rpMap = iterator.next();

			if (rpMap.getStep() == step)
			{
				list.add(rpMap);
			}
		}

		Collections.sort(list);

		return list;
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

	public int compareTo(Report report)
	{		
		return name.compareTo(report.getName());
	}

	/**
	 * @return
	 * @uml.property  name="reportChart"
	 */
	public ReportChart getReportChart()
	{
		return reportChart;
	}

	/**
	 * @param reportChart
	 * @uml.property  name="reportChart"
	 */
	public void setReportChart(ReportChart reportChart)
	{
		this.reportChart = reportChart;
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

	/**
	 * @return
	 * @uml.property  name="excelExportEnabled"
	 */
	public boolean isExcelExportEnabled()
	{
		return excelExportEnabled;
	}

	public void setExcelExportEnabled(Boolean excelExportEnabled)
	{
		if (excelExportEnabled == null) excelExportEnabled = new Boolean(false);
		this.excelExportEnabled = excelExportEnabled.booleanValue();
	}

	/**
	 * @return
	 * @uml.property  name="rtfExportEnabled"
	 */
	public boolean isRtfExportEnabled()
	{
		return rtfExportEnabled;
	}

	public void setRtfExportEnabled(Boolean rtfExportEnabled)
	{
		if (rtfExportEnabled == null) rtfExportEnabled = new Boolean(false);
		this.rtfExportEnabled = rtfExportEnabled.booleanValue();
	}

	/**
	 * @return
	 * @uml.property  name="textExportEnabled"
	 */
	public boolean isTextExportEnabled()
	{
		return textExportEnabled;
	}

	public void setTextExportEnabled(Boolean textExportEnabled)
	{
		if (textExportEnabled == null) textExportEnabled = new Boolean(false);
		this.textExportEnabled = textExportEnabled.booleanValue();
	}
	
	/**
	 * @return
	 * @uml.property  name="imageExportEnabled"
	 */
	public boolean isImageExportEnabled()
	{
		return imageExportEnabled;
	}

	public void setImageExportEnabled(Boolean imageExportEnabled)
	{
		if (imageExportEnabled == null) imageExportEnabled = new Boolean(false);
		this.imageExportEnabled = imageExportEnabled.booleanValue();
	}

	/**
	 * @return
	 * @uml.property  name="reportExportOption"
	 */
	public ReportExportOption getReportExportOption()
	{
		if (reportExportOption == null) reportExportOption = new ReportExportOption();
		return reportExportOption;
	}

	/**
	 * @param reportExportOption
	 * @uml.property  name="reportExportOption"
	 */
	public void setReportExportOption(ReportExportOption reportExportOption)
	{
		this.reportExportOption = reportExportOption;
	}

	/**
	 * @return
	 * @uml.property  name="virtualizationEnabled"
	 */
	public boolean isVirtualizationEnabled()
	{
		return virtualizationEnabled;
	}

	public void setVirtualizationEnabled(Boolean virtualizationEnabled)
	{
		if (virtualizationEnabled == null) virtualizationEnabled = new Boolean(false);
		this.virtualizationEnabled = virtualizationEnabled.booleanValue();
	}
	
	/**
	 * @return
	 * @uml.property  name="hidden"
	 */
	public boolean isHidden()
	{
		return hidden;
	}

	public void setHidden(Boolean hidden)
	{
		if (hidden == null) hidden = new Boolean(false);
		this.hidden = hidden.booleanValue();
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