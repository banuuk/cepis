/*
 * Copyright (C) 2006 Erik Swenson - erik@oreports.com
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

package org.efs.openreports.services.info;

import java.io.Serializable;

import org.efs.openreports.ReportConstants.ExportType;

/**
 * ReportInfo object. 
 * @author  Erik Swenson
 * @see  ParameterInfo
 */

public class ReportInfo implements Serializable
{	
	private static final long serialVersionUID = -529487598274539409L;
	
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
	 * @uml.property  name="parameters"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private ParameterInfo[] parameters;
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
	 * @uml.property  name="hidden"
	 */
	private boolean hidden;
	/**
	 * @uml.property  name="defaultExportType"
	 * @uml.associationEnd  
	 */
	private ExportType defaultExportType;

	public ReportInfo()
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

	/**
	 * @return
	 * @uml.property  name="parameters"
	 */
	public ParameterInfo[] getParameters()
	{
		return parameters;
	}	

	/**
	 * @param parameters
	 * @uml.property  name="parameters"
	 */
	public void setParameters(ParameterInfo[] parameters)
	{
		this.parameters = parameters;
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
	 * @uml.property  name="defaultExportType"
	 */
	public ExportType getDefaultExportType()
	{
		return defaultExportType;
	}

	/**
	 * @param defaultExportType
	 * @uml.property  name="defaultExportType"
	 */
	public void setDefaultExportType(ExportType defaultExportType)
	{
		this.defaultExportType = defaultExportType;
	}
}