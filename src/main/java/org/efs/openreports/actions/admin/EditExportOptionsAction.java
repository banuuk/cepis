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

package org.efs.openreports.actions.admin;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;

import org.efs.openreports.objects.Report;
import org.efs.openreports.objects.ReportExportOption;
import org.efs.openreports.providers.ReportProvider;

/**
 * @author  keerthi
 */
public class EditExportOptionsAction extends ActionSupport  
{	
	private static final long serialVersionUID = 8085217825617019729L;

	protected static Logger log = Logger.getLogger(EditExportOptionsAction.class);
	
	/**
	 * @uml.property  name="command"
	 */
	private String command;
	/**
	 * @uml.property  name="submitType"
	 */
	private String submitType;

	/**
	 * @uml.property  name="id"
	 */
	private int id;
	
	/**
	 * @uml.property  name="xlsRemoveEmptySpaceBetweenRows"
	 */
	private boolean xlsRemoveEmptySpaceBetweenRows;
	/**
	 * @uml.property  name="xlsOnePagePerSheet"
	 */
	private boolean xlsOnePagePerSheet;	
	/**
	 * @uml.property  name="xlsAutoDetectCellType"
	 */
	private boolean xlsAutoDetectCellType;
	/**
	 * @uml.property  name="xlsWhitePageBackground"
	 */
	private boolean xlsWhitePageBackground;	
	 
	/**
	 * @uml.property  name="htmlRemoveEmptySpaceBetweenRows"
	 */
	private boolean htmlRemoveEmptySpaceBetweenRows;	
	/**
	 * @uml.property  name="htmlWhitePageBackground"
	 */
	private boolean htmlWhitePageBackground;
	/**
	 * @uml.property  name="htmlUsingImagesToAlign"
	 */
	private boolean htmlUsingImagesToAlign;
	/**
	 * @uml.property  name="htmlWrapBreakWord"
	 */
	private boolean htmlWrapBreakWord; 
	
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

	public String execute()
	{
		try
		{
			report = reportProvider.getReport(new Integer(id));				
			ReportExportOption exportOption = report.getReportExportOption();			

			if (command.equals("edit") && submitType == null)
			{
				id = report.getId().intValue();
				
				xlsRemoveEmptySpaceBetweenRows = exportOption.isXlsRemoveEmptySpaceBetweenRows();
				xlsOnePagePerSheet = exportOption.isXlsOnePagePerSheet();
				xlsAutoDetectCellType = exportOption.isXlsAutoDetectCellType();
				xlsWhitePageBackground = exportOption.isXlsWhitePageBackground();
				
				htmlRemoveEmptySpaceBetweenRows = exportOption.isHtmlRemoveEmptySpaceBetweenRows();
				htmlUsingImagesToAlign = exportOption.isHtmlUsingImagesToAlign();
				htmlWhitePageBackground = exportOption.isHtmlWhitePageBackground();
				htmlWrapBreakWord = exportOption.isHtmlWrapBreakWord();
			}

			if (submitType == null)
				return INPUT;

			
			exportOption.setXlsOnePagePerSheet(xlsOnePagePerSheet);
			exportOption.setXlsRemoveEmptySpaceBetweenRows(xlsRemoveEmptySpaceBetweenRows);
			exportOption.setXlsAutoDetectCellType(xlsAutoDetectCellType);
			exportOption.setXlsWhitePageBackground(xlsWhitePageBackground);
			
			exportOption.setHtmlRemoveEmptySpaceBetweenRows(htmlRemoveEmptySpaceBetweenRows);
			exportOption.setHtmlUsingImagesToAlign(htmlUsingImagesToAlign);
			exportOption.setHtmlWhitePageBackground(htmlWhitePageBackground);
			exportOption.setHtmlWrapBreakWord(htmlWrapBreakWord);
			
			report.setReportExportOption(exportOption);

			reportProvider.updateReport(report);		

			return SUCCESS;
		}
		catch (Exception e)
		{
			log.error(e.toString());
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
	 * @param reportProvider
	 * @uml.property  name="reportProvider"
	 */
	public void setReportProvider(ReportProvider reportProvider)
	{
		this.reportProvider = reportProvider;
	}	

	/**
	 * @return
	 * @uml.property  name="reportProvider"
	 */
	public ReportProvider getReportProvider()
	{
		return reportProvider;
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
	 * @uml.property  name="htmlRemoveEmptySpaceBetweenRows"
	 */
	public boolean isHtmlRemoveEmptySpaceBetweenRows()
	{
		return htmlRemoveEmptySpaceBetweenRows;
	}

	/**
	 * @param htmlRemoveEmptySpaceBetweenRows
	 * @uml.property  name="htmlRemoveEmptySpaceBetweenRows"
	 */
	public void setHtmlRemoveEmptySpaceBetweenRows(boolean htmlRemoveEmptySpaceBetweenRows)
	{
		this.htmlRemoveEmptySpaceBetweenRows = htmlRemoveEmptySpaceBetweenRows;
	}

	/**
	 * @return
	 * @uml.property  name="htmlUsingImagesToAlign"
	 */
	public boolean isHtmlUsingImagesToAlign()
	{
		return htmlUsingImagesToAlign;
	}

	/**
	 * @param htmlUsingImagesToAlign
	 * @uml.property  name="htmlUsingImagesToAlign"
	 */
	public void setHtmlUsingImagesToAlign(boolean htmlUsingImagesToAlign)
	{
		this.htmlUsingImagesToAlign = htmlUsingImagesToAlign;
	}

	/**
	 * @return
	 * @uml.property  name="htmlWhitePageBackground"
	 */
	public boolean isHtmlWhitePageBackground()
	{
		return htmlWhitePageBackground;
	}

	/**
	 * @param htmlWhitePageBackground
	 * @uml.property  name="htmlWhitePageBackground"
	 */
	public void setHtmlWhitePageBackground(boolean htmlWhitePageBackground)
	{
		this.htmlWhitePageBackground = htmlWhitePageBackground;
	}

	/**
	 * @return
	 * @uml.property  name="htmlWrapBreakWord"
	 */
	public boolean isHtmlWrapBreakWord()
	{
		return htmlWrapBreakWord;
	}

	/**
	 * @param htmlWrapBreakWord
	 * @uml.property  name="htmlWrapBreakWord"
	 */
	public void setHtmlWrapBreakWord(boolean htmlWrapBreakWord)
	{
		this.htmlWrapBreakWord = htmlWrapBreakWord;
	}

	/**
	 * @return
	 * @uml.property  name="xlsAutoDetectCellType"
	 */
	public boolean isXlsAutoDetectCellType()
	{
		return xlsAutoDetectCellType;
	}

	/**
	 * @param xlsAutoDetectCellType
	 * @uml.property  name="xlsAutoDetectCellType"
	 */
	public void setXlsAutoDetectCellType(boolean xlsAutoDetectCellType)
	{
		this.xlsAutoDetectCellType = xlsAutoDetectCellType;
	}

	/**
	 * @return
	 * @uml.property  name="xlsOnePagePerSheet"
	 */
	public boolean isXlsOnePagePerSheet()
	{
		return xlsOnePagePerSheet;
	}

	/**
	 * @param xlsOnePagePerSheet
	 * @uml.property  name="xlsOnePagePerSheet"
	 */
	public void setXlsOnePagePerSheet(boolean xlsOnePagePerSheet)
	{
		this.xlsOnePagePerSheet = xlsOnePagePerSheet;
	}

	/**
	 * @return
	 * @uml.property  name="xlsRemoveEmptySpaceBetweenRows"
	 */
	public boolean isXlsRemoveEmptySpaceBetweenRows()
	{
		return xlsRemoveEmptySpaceBetweenRows;
	}

	/**
	 * @param xlsRemoveEmptySpaceBetweenRows
	 * @uml.property  name="xlsRemoveEmptySpaceBetweenRows"
	 */
	public void setXlsRemoveEmptySpaceBetweenRows(boolean xlsRemoveEmptySpaceBetweenRows)
	{
		this.xlsRemoveEmptySpaceBetweenRows = xlsRemoveEmptySpaceBetweenRows;
	}

	/**
	 * @return
	 * @uml.property  name="xlsWhitePageBackground"
	 */
	public boolean isXlsWhitePageBackground()
	{
		return xlsWhitePageBackground;
	}

	/**
	 * @param xlsWhitePageBackground
	 * @uml.property  name="xlsWhitePageBackground"
	 */
	public void setXlsWhitePageBackground(boolean xlsWhitePageBackground)
	{
		this.xlsWhitePageBackground = xlsWhitePageBackground;
	}

}