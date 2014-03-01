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

package org.efs.openreports.engine.input;

import java.util.Locale;
import java.util.Map;

import org.efs.openreports.ReportConstants.ExportType;
import org.efs.openreports.objects.Report;

/**
 * ReportEngineInput contains information needed to generate a report by the ReportEngine. Report, parameters, and exportType are required.
 * @author  Erik Swenson
 */

public class ReportEngineInput
{		
	/**
	 * @uml.property  name="report"
	 * @uml.associationEnd  
	 */
	private Report report;
	/**
	 * @uml.property  name="parameters"
	 */
	private Map<String,Object> parameters;
	/**
	 * @uml.property  name="exportType"
	 * @uml.associationEnd  
	 */
	private ExportType exportType;	
	/**
	 * @uml.property  name="locale"
	 */
	private Locale locale;
    
    /**
	 * @uml.property  name="xmlInput"
	 */
    private String xmlInput;  
	
	// JasperReports only
	/**
	 * @uml.property  name="images"
	 */
	private Map imagesMap;	
	/**
	 * @uml.property  name="inlineImages"
	 */
	private boolean inlineImages;
	//
	
	public ReportEngineInput(Report report, Map<String,Object> parameters)
	{
		this.report = report;
		this.parameters = parameters;
	}

	/**
	 * @return
	 * @uml.property  name="parameters"
	 */
	public Map<String,Object> getParameters()
	{
		return parameters;
	}

	/**
	 * @param parameters
	 * @uml.property  name="parameters"
	 */
	public void setParameters(Map<String,Object> parameters)
	{
		this.parameters = parameters;
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
	 * @uml.property  name="exportType"
	 */
	public ExportType getExportType()
	{
		return exportType;
	}

	/**
	 * @param exportType
	 * @uml.property  name="exportType"
	 */
	public void setExportType(ExportType exportType)
	{
		this.exportType = exportType;
	}

	/**
	 * @return
	 * @uml.property  name="images"
	 */
	public Map getImagesMap()
	{
		return imagesMap;
	}

	/**
	 * @param imagesMap
	 * @uml.property  name="images"
	 */
	public void setImagesMap(Map imagesMap)
	{
		this.imagesMap = imagesMap;
	}

	/**
	 * @return
	 * @uml.property  name="inlineImages"
	 */
	public boolean isInlineImages()
	{
		return inlineImages;
	}

	/**
	 * @param inlineImages
	 * @uml.property  name="inlineImages"
	 */
	public void setInlineImages(boolean inlineImages)
	{
		this.inlineImages = inlineImages;
	}
    
    /**
	 * @return
	 * @uml.property  name="xmlInput"
	 */
    public String getXmlInput() 
    {
        return xmlInput;
    }
    
    /**
	 * @param xmlInput
	 * @uml.property  name="xmlInput"
	 */
    public void setXmlInput(String xmlInput) 
    {
        this.xmlInput = xmlInput;
    }

	/**
	 * @return
	 * @uml.property  name="locale"
	 */
	public Locale getLocale() 
	{
		return locale;
	}

	/**
	 * @param locale
	 * @uml.property  name="locale"
	 */
	public void setLocale(Locale locale) 
	{
		this.locale = locale;
	}	
}
