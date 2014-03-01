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

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.design.JRJdtCompiler;
import net.sf.jasperreports.engine.util.JRProperties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.efs.openreports.objects.ReportTemplate;
import org.efs.openreports.providers.DirectoryProvider;
import org.efs.openreports.providers.ReportProvider;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author  keerthi
 */
public class ReportUploadAction extends ActionSupport  
{	
	private static final long serialVersionUID = 3832737720793888800L;

	protected static Logger log = Logger.getLogger(ReportUploadAction.class);

	/**
	 * @uml.property  name="reportProvider"
	 * @uml.associationEnd  
	 */
	private ReportProvider reportProvider;

	/**
	 * @uml.property  name="reportTemplates"
	 */
	private List<ReportTemplate> reportTemplates;
   
    /**
	 * @uml.property  name="reportFile"
	 */
    private File reportFile;
    /**
	 * @uml.property  name="reportFileContentType"
	 */
    private String reportFileContentType;
    /**
	 * @uml.property  name="reportFileFileName"
	 */
    private String reportFileFileName;
    /**
	 * @uml.property  name="revision"
	 */
    private String revision;
    
	/**
	 * @uml.property  name="command"
	 */
	private String command;
    
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
			if ("upload".equals(command))
			{				
				if (reportFile != null)
				{			
                    File destinationFile = new File(directoryProvider.getReportDirectory() + reportFileFileName);
                    
                    try
                    {
                    	if (destinationFile.exists())
                    	{
                    		int revisionCount = reportProvider.getReportTemplate(reportFileFileName).getRevisionCount();
                    		File versionedFile = new File(directoryProvider.getReportDirectory() + reportFileFileName + "." + revisionCount);
                    		FileUtils.copyFile(destinationFile, versionedFile);                    		
                    	}
                    	
                        FileUtils.copyFile(reportFile, destinationFile);
                    }
                    catch(IOException ioe)
                    {
                        addActionError(ioe.toString());
                        return SUCCESS;
                    }
					
                    if ((reportFileFileName.endsWith(".xml")) || (reportFileFileName.endsWith(".jrxml")))
					{
						try
						{
							System.setProperty(JRProperties.COMPILER_CLASS, JRJdtCompiler.class.getName());
							JRProperties.setProperty(JRProperties.COMPILER_CLASS, JRJdtCompiler.class.getName());
								
							JasperCompileManager.compileReportToFile(destinationFile.getAbsolutePath());
						}
						catch (Exception e)
						{
							if (e.toString().indexOf("groovy") > -1)
							{
							    try
								{
									System.setProperty(JRProperties.COMPILER_CLASS,"net.sf.jasperreports.compilers.JRGroovyCompiler" );
									JRProperties.setProperty(JRProperties.COMPILER_CLASS,"net.sf.jasperreports.compilers.JRGroovyCompiler");
					                   
					                JasperCompileManager.compileReportToFile(destinationFile.getAbsolutePath());
								}
								catch(Exception ex)
								{
									log.error("Failed to compile report: " + reportFileFileName, e);
									addActionError("Failed to compile report: " + e.toString());
								}
							}
							else
							{								
								log.error("Failed to compile report: " + reportFileFileName, e);
								addActionError("Failed to compile report: " + e.toString());
							}
						}
					}
				}
                else
                {
                    addActionError("Invalid File.");
                }
			}
			
			if ("download".equals(command))
			{
				String templateFileName = revision;
				
				// if there is a revision at the end of the file name, strip it off
				if (StringUtils.countMatches(templateFileName, ".") > 1)
				{
					templateFileName = revision.substring(0, revision.lastIndexOf("."));
				}
				
				File templateFile = new File(directoryProvider.getReportDirectory() + revision);
				byte[] template = FileUtils.readFileToByteArray(templateFile);				
				
				HttpServletResponse response = ServletActionContext.getResponse();		
				response.setHeader("Content-disposition", "inline; filename=" + templateFileName);
				response.setContentType("application/octet-stream");
				response.setContentLength(template.length);
				
				ServletOutputStream out = response.getOutputStream();
				out.write(template, 0, template.length);
				out.flush();
				out.close();				
			}
			
			if ("revert".equals(command))
			{
				String templateFileName = revision.substring(0, revision.lastIndexOf("."));
				
				File revisionFile = new File(directoryProvider.getReportDirectory() + revision);
				File currentFile = new File(directoryProvider.getReportDirectory() + templateFileName);
				
				// create a new revision from the current version
				int revisionCount = reportProvider.getReportTemplate(templateFileName).getRevisionCount();
        		File versionedFile = new File(directoryProvider.getReportDirectory() + templateFileName + "." + revisionCount);
        		FileUtils.copyFile(currentFile, versionedFile);
        		
        		// copy the selected revision to the current version
        		FileUtils.copyFile(revisionFile, currentFile);						
			}

			reportTemplates = reportProvider.getReportTemplates();
		}
		catch (Exception pe)
		{
			addActionError(pe.getMessage());
		}       

		return SUCCESS;
	}		
   
    /**
	 * @return
	 * @uml.property  name="reportTemplates"
	 */
    public List<ReportTemplate> getReportTemplates()
	{
		return reportTemplates;
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
	 * @uml.property  name="reportFile"
	 */
    public File getReportFile() 
    {
        return reportFile;
    }
    
    /**
	 * @param reportFile
	 * @uml.property  name="reportFile"
	 */
    public void setReportFile(File reportFile)
    {
        this.reportFile = reportFile;
    }
    
    /**
	 * @return
	 * @uml.property  name="reportFileContentType"
	 */
    public String getReportFileContentType() 
    {
        return reportFileContentType;
    }
    
    /**
	 * @param reportFileContentType
	 * @uml.property  name="reportFileContentType"
	 */
    public void setReportFileContentType(String reportFileContentType) 
    {
        this.reportFileContentType = reportFileContentType;
    }
    
    /**
	 * @return
	 * @uml.property  name="reportFileFileName"
	 */
    public String getReportFileFileName() 
    {
        return reportFileFileName;
    }
    
    /**
	 * @param reportFileFileName
	 * @uml.property  name="reportFileFileName"
	 */
    public void setReportFileFileName(String reportFileFileName) 
    {
        this.reportFileFileName = reportFileFileName;
    }
        
    /**
	 * @return
	 * @uml.property  name="revision"
	 */
    public String getRevision() 
    {
		return revision;
	}

	/**
	 * @param revision
	 * @uml.property  name="revision"
	 */
	public void setRevision(String revision) 
	{
		this.revision = revision;
	}

	/**
	 * @param directoryProvider
	 * @uml.property  name="directoryProvider"
	 */
	public void setDirectoryProvider(DirectoryProvider directoryProvider) 
    {
        this.directoryProvider = directoryProvider;
    }

}