/*
 * Copyright (C) 2005 Erik Swenson - erik@oreports.com
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
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.efs.openreports.objects.ORProperty;
import org.efs.openreports.providers.DateProvider;
import org.efs.openreports.providers.DirectoryProvider;
import org.efs.openreports.providers.MailProvider;
import org.efs.openreports.providers.PropertiesProvider;
import org.efs.openreports.util.LocalStrings;

/**
 * @author  keerthi
 */
public class EditPropertiesAction extends ActionSupport 
{	
	private static final long serialVersionUID = -2577286917721890875L;

	protected static Logger log = Logger.getLogger(EditPropertiesAction.class);

	/**
	 * @uml.property  name="submitType"
	 */
	private String submitType;

	/**
	 * @uml.property  name="dateFormat"
	 */
	private String dateFormat;
	/**
	 * @uml.property  name="baseDirectory"
	 */
	private String baseDirectory;
	/**
	 * @uml.property  name="tempDirectory"
	 */
	private String tempDirectory;
	/**
	 * @uml.property  name="mailHost"
	 */
	private String mailHost;
	/**
	 * @uml.property  name="mailAuthenticatorUsed"
	 */
	private boolean mailAuthenticatorUsed;
	/**
	 * @uml.property  name="mailUser"
	 */
	private String mailUser;
	/**
	 * @uml.property  name="mailPassword"
	 */
	private String mailPassword;	
	/**
	 * @uml.property  name="maxRows"
	 */
	private String maxRows;
	/**
	 * @uml.property  name="reportGenerationDirectory"
	 */
	private String reportGenerationDirectory;
	
	/**
	 * @uml.property  name="numberOfFiles"
	 */
	private int numberOfFiles;
	/**
	 * @uml.property  name="directorySize"
	 */
	private String directorySize;
    
    /**
	 * @uml.property  name="xmlaUri"
	 */
    private String xmlaUri;
    /**
	 * @uml.property  name="xmlaDataSource"
	 */
    private String xmlaDataSource;
    /**
	 * @uml.property  name="xmlaCatalog"
	 */
    private String xmlaCatalog;
    
	/**
	 * @uml.property  name="propertiesProvider"
	 * @uml.associationEnd  
	 */
	private PropertiesProvider propertiesProvider;
	/**
	 * @uml.property  name="dateProvider"
	 * @uml.associationEnd  
	 */
	private DateProvider dateProvider;
	/**
	 * @uml.property  name="directoryProvider"
	 * @uml.associationEnd  
	 */
	private DirectoryProvider directoryProvider;
	/**
	 * @uml.property  name="mailProvider"
	 * @uml.associationEnd  
	 */
	private MailProvider mailProvider;
	
	public String execute()
	{
		try
		{
			if (submitType == null)
			{						
				dateFormat = dateProvider.getDateFormat().toPattern();				
				baseDirectory = directoryProvider.getReportDirectory();	
				tempDirectory = directoryProvider.getTempDirectory();
				reportGenerationDirectory = directoryProvider.getReportGenerationDirectory();

				ORProperty property = propertiesProvider.getProperty(ORProperty.MAIL_SMTP_HOST);
				if (property != null) mailHost = property.getValue();

				property = propertiesProvider.getProperty(ORProperty.MAIL_SMTP_AUTH);
				if (property != null) mailAuthenticatorUsed = new Boolean(property.getValue()).booleanValue();

				property = propertiesProvider.getProperty(ORProperty.MAIL_AUTH_USER);
				if (property != null) mailUser = property.getValue();

				property = propertiesProvider.getProperty(ORProperty.MAIL_AUTH_PASSWORD);
				if (property != null) mailPassword = property.getValue();							
				
				property = propertiesProvider.getProperty(ORProperty.QUERYREPORT_MAXROWS);
				if (property != null) maxRows = property.getValue();
                
                property = propertiesProvider.getProperty(ORProperty.XMLA_CATALOG);
                if (property != null) xmlaCatalog = property.getValue();    
                
                property = propertiesProvider.getProperty(ORProperty.XMLA_DATASOURCE);
                if (property != null) xmlaDataSource = property.getValue();    
                
                property = propertiesProvider.getProperty(ORProperty.XMLA_URL);
                if (property != null) xmlaUri = property.getValue();    
				
				//
				File tempDirFile = new File(directoryProvider.getTempDirectory());
								
				long size = FileUtils.sizeOfDirectory(tempDirFile);			
				directorySize = FileUtils.byteCountToDisplaySize(size);	
				
				numberOfFiles = tempDirFile.listFiles().length;				
				//
				
				return INPUT;
			}
			
			// validate maxRows is an integer
			try
			{
				Integer.parseInt(maxRows);
			}
			catch(NumberFormatException nfe)
			{
				addActionError(LocalStrings.ERROR_INVALID_MAXROWS);
				return INPUT;
			}

			propertiesProvider.setProperty(ORProperty.BASE_DIRECTORY, baseDirectory);
			if (baseDirectory != null) directoryProvider.setReportDirectory(baseDirectory);
			
			propertiesProvider.setProperty(ORProperty.TEMP_DIRECTORY, tempDirectory);
			if (tempDirectory != null) directoryProvider.setTempDirectory(tempDirectory);
			
			propertiesProvider.setProperty(ORProperty.REPORT_GENERATION_DIRECTORY, reportGenerationDirectory);
			if (tempDirectory != null) directoryProvider.setReportGenerationDirectory(reportGenerationDirectory);
			
			propertiesProvider.setProperty(ORProperty.DATE_FORMAT, dateFormat);
			if (dateFormat != null) dateProvider.setDateFormat(dateFormat);
			
					
									
			propertiesProvider.setProperty(ORProperty.QUERYREPORT_MAXROWS, maxRows);
            propertiesProvider.setProperty(ORProperty.XMLA_CATALOG, xmlaCatalog);
            propertiesProvider.setProperty(ORProperty.XMLA_DATASOURCE, xmlaDataSource);
            propertiesProvider.setProperty(ORProperty.XMLA_URL, xmlaUri);            

			return SUCCESS;
		}
		catch (Exception e)
		{
			addActionError(e.toString());
			return INPUT;
		}
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
	 * @uml.property  name="baseDirectory"
	 */
	public String getBaseDirectory()
	{
		return baseDirectory;
	}

	/**
	 * @param baseDirectory
	 * @uml.property  name="baseDirectory"
	 */
	public void setBaseDirectory(String baseDirectory)
	{
		this.baseDirectory = baseDirectory;
	}

	/**
	 * @return
	 * @uml.property  name="dateFormat"
	 */
	public String getDateFormat()
	{
		return dateFormat;
	}

	/**
	 * @param dateFormat
	 * @uml.property  name="dateFormat"
	 */
	public void setDateFormat(String dateFormat)
	{
		this.dateFormat = dateFormat;
	}

	/**
	 * @return
	 * @uml.property  name="mailAuthenticatorUsed"
	 */
	public boolean isMailAuthenticatorUsed()
	{
		return mailAuthenticatorUsed;
	}

	/**
	 * @param mailAuthenticatorUsed
	 * @uml.property  name="mailAuthenticatorUsed"
	 */
	public void setMailAuthenticatorUsed(boolean mailAuthenticatorUsed)
	{
		this.mailAuthenticatorUsed = mailAuthenticatorUsed;
	}

	/**
	 * @return
	 * @uml.property  name="mailHost"
	 */
	public String getMailHost()
	{
		return mailHost;
	}

	/**
	 * @param mailHost
	 * @uml.property  name="mailHost"
	 */
	public void setMailHost(String mailHost)
	{
		this.mailHost = mailHost;
	}

	/**
	 * @return
	 * @uml.property  name="mailPassword"
	 */
	public String getMailPassword()
	{
		return mailPassword;
	}

	/**
	 * @param mailPassword
	 * @uml.property  name="mailPassword"
	 */
	public void setMailPassword(String mailPassword)
	{
		this.mailPassword = mailPassword;
	}

	/**
	 * @return
	 * @uml.property  name="mailUser"
	 */
	public String getMailUser()
	{
		return mailUser;
	}

	/**
	 * @param mailUser
	 * @uml.property  name="mailUser"
	 */
	public void setMailUser(String mailUser)
	{
		this.mailUser = mailUser;
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
	 * @param dateProvider
	 * @uml.property  name="dateProvider"
	 */
	public void setDateProvider(DateProvider dateProvider)
	{
		this.dateProvider = dateProvider;
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
	 * @param mailProvider
	 * @uml.property  name="mailProvider"
	 */
	public void setMailProvider(MailProvider mailProvider)
	{
		this.mailProvider = mailProvider;
	}

	/**
	 * @return
	 * @uml.property  name="tempDirectory"
	 */
	public String getTempDirectory()
	{
		return tempDirectory;
	}

	/**
	 * @param tempDirectory
	 * @uml.property  name="tempDirectory"
	 */
	public void setTempDirectory(String tempDirectory)
	{
		this.tempDirectory = tempDirectory;
	}

	/**
	 * @return
	 * @uml.property  name="maxRows"
	 */
	public String getMaxRows()
	{
		return maxRows;
	}

	/**
	 * @param maxRows
	 * @uml.property  name="maxRows"
	 */
	public void setMaxRows(String maxRows)
	{
		this.maxRows = maxRows;
	}

	/**
	 * @return
	 * @uml.property  name="directorySize"
	 */
	public String getDirectorySize()
	{
		return directorySize;
	}

	/**
	 * @return
	 * @uml.property  name="numberOfFiles"
	 */
	public int getNumberOfFiles()
	{
		return numberOfFiles;
	}

	/**
	 * @return
	 * @uml.property  name="reportGenerationDirectory"
	 */
	public String getReportGenerationDirectory()
	{
		return reportGenerationDirectory;
	}

	/**
	 * @param reportGenerationDirectory
	 * @uml.property  name="reportGenerationDirectory"
	 */
	public void setReportGenerationDirectory(String reportGenerationDirectory)
	{
		this.reportGenerationDirectory = reportGenerationDirectory;
	}
    
    /**
	 * @return
	 * @uml.property  name="xmlaCatalog"
	 */
    public String getXmlaCatalog() 
    {
        return xmlaCatalog;
    }
    
    /**
	 * @param xmlaCatalog
	 * @uml.property  name="xmlaCatalog"
	 */
    public void setXmlaCatalog(String xmlaCatalog) 
    {
        this.xmlaCatalog = xmlaCatalog;
    }
    
    /**
	 * @return
	 * @uml.property  name="xmlaDataSource"
	 */
    public String getXmlaDataSource() 
    {
        return xmlaDataSource;
    }
    
    /**
	 * @param xmlaDataSource
	 * @uml.property  name="xmlaDataSource"
	 */
    public void setXmlaDataSource(String xmlaDataSource) 
    {
        this.xmlaDataSource = xmlaDataSource;
    }
    
    /**
	 * @return
	 * @uml.property  name="xmlaUri"
	 */
    public String getXmlaUri() 
    {
        return xmlaUri;
    }
    
    /**
	 * @param xmlaUri
	 * @uml.property  name="xmlaUri"
	 */
    public void setXmlaUri(String xmlaUri)
    {
        this.xmlaUri = xmlaUri;
    }
}