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

import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;

import org.efs.openreports.objects.ReportDataSource;
import org.efs.openreports.providers.DataSourceProvider;

/**
 * @author  keerthi
 */
public class EditDataSourceAction extends ActionSupport  
{	
	private static final long serialVersionUID = 688082544181279177L;

	protected static Logger log = Logger.getLogger(EditDataSourceAction.class);
	
	/**
	 * @uml.property  name="command"
	 */
	private String command;
	/**
	 * @uml.property  name="dataSource"
	 */
	private String dataSource;

	private boolean submitOk;	
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
	 * @uml.property  name="driver"
	 */
	private String driver;
	/**
	 * @uml.property  name="url"
	 */
	private String url;
	/**
	 * @uml.property  name="userName"
	 */
	private String userName;
	/**
	 * @uml.property  name="password"
	 */
	private String password;
	/**
	 * @uml.property  name="maxIdle"
	 */
	private int maxIdle;
	/**
	 * @uml.property  name="maxActive"
	 */
	private int maxActive;
	/**
	 * @uml.property  name="maxWait"
	 */
	private long maxWait;
	/**
	 * @uml.property  name="validationQuery"
	 */
	private String validationQuery;
	/**
	 * @uml.property  name="jndi"
	 */
	private boolean jndi;	
	
	/**
	 * @uml.property  name="dataSourceProvider"
	 * @uml.associationEnd  
	 */
	private DataSourceProvider dataSourceProvider;	

	@Override
	public String execute()
	{
		try
		{
			ReportDataSource reportDataSource = null;

			if (command.equals("edit"))
			{
				reportDataSource =
					dataSourceProvider.getDataSource(new Integer(id));
			}
			else
			{
				reportDataSource = new ReportDataSource();
			}

			if (command.equals("edit") && !submitOk && !submitDuplicate)
			{
				id = reportDataSource.getId().intValue();
				name = reportDataSource.getName();
				driver = reportDataSource.getDriverClassName();
				url = reportDataSource.getUrl();
				userName = reportDataSource.getUsername();
				password = reportDataSource.getPassword();
				maxIdle = reportDataSource.getMaxIdle();
				maxActive = reportDataSource.getMaxActive();
				validationQuery = reportDataSource.getValidationQuery();
				jndi = reportDataSource.isJndi();
				maxWait = reportDataSource.getMaxWait();
			}

			if (!submitOk && !submitDuplicate) return INPUT;
			
			   if (submitDuplicate)
	            {
	            	command = "add";
	            	reportDataSource.setId(null);
	            	
	            	if (reportDataSource.getName().equals(name))
	            	{
	            		name = "Copy of ".concat(name);
	            	}
	            }

			reportDataSource.setName(name);
			reportDataSource.setDriverClassName(driver);
			reportDataSource.setUrl(url);
			reportDataSource.setUsername(userName);
			reportDataSource.setPassword(password);
			reportDataSource.setMaxIdle(maxIdle);
			reportDataSource.setMaxActive(maxActive);
			reportDataSource.setJndi(jndi);
			reportDataSource.setMaxWait(maxWait);			
			
			if (validationQuery == null || validationQuery.length() < 1)
			{
				reportDataSource.setValidationQuery(null);
			}
			else
			{
				reportDataSource.setValidationQuery(validationQuery);
			}

			if (command.equals("edit"))
			{
				dataSourceProvider.updateDataSource(reportDataSource);
			}

			if (command.equals("add"))
			{
				reportDataSource =
					dataSourceProvider.insertDataSource(reportDataSource);
                
                id = reportDataSource.getId().intValue();
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
	 * @return
	 * @uml.property  name="dataSource"
	 */
	public String getDataSource()
	{
		return dataSource;
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
	 * @param dataSource
	 * @uml.property  name="dataSource"
	 */
	public void setDataSource(String dataSource)
	{
		this.dataSource = dataSource;
	}

	/**
	 * @return
	 * @uml.property  name="driver"
	 */
	public String getDriver()
	{
		return driver;
	}

	/**
	 * @return
	 * @uml.property  name="maxActive"
	 */
	public int getMaxActive()
	{
		return maxActive;
	}

	/**
	 * @return
	 * @uml.property  name="maxIdle"
	 */
	public int getMaxIdle()
	{
		return maxIdle;
	}

	/**
	 * @return
	 * @uml.property  name="password"
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @return
	 * @uml.property  name="url"
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * @return
	 * @uml.property  name="userName"
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * @param driver
	 * @uml.property  name="driver"
	 */
	public void setDriver(String driver)
	{
		this.driver = driver;
	}

	/**
	 * @param maxActive
	 * @uml.property  name="maxActive"
	 */
	public void setMaxActive(int maxActive)
	{
		this.maxActive = maxActive;
	}

	/**
	 * @param maxIdle
	 * @uml.property  name="maxIdle"
	 */
	public void setMaxIdle(int maxIdle)
	{
		this.maxIdle = maxIdle;
	}

	/**
	 * @param password
	 * @uml.property  name="password"
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * @param url
	 * @uml.property  name="url"
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}

	/**
	 * @param userName
	 * @uml.property  name="userName"
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public void setSubmitOk(String submitOk)
	{
		if (submitOk != null) this.submitOk = true;
	}	
		
	public void setSubmitDuplicate(String submitDuplicate)
	{
		if (submitDuplicate != null) this.submitDuplicate = true;
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
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName()
	{
		return name;
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
	 * @param name
	 * @uml.property  name="name"
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return
	 * @uml.property  name="validationQuery"
	 */
	public String getValidationQuery()
	{
		return validationQuery;
	}

	/**
	 * @param validationQuery
	 * @uml.property  name="validationQuery"
	 */
	public void setValidationQuery(String validationQuery)
	{
		this.validationQuery = validationQuery;
	}

	/**
	 * @return
	 * @uml.property  name="jndi"
	 */
	public boolean isJndi()
	{
		return jndi;
	}

	/**
	 * @param jndi
	 * @uml.property  name="jndi"
	 */
	public void setJndi(boolean jndi)
	{
		this.jndi = jndi;
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
	 * @uml.property  name="maxWait"
	 */
	public long getMaxWait()
	{
		return maxWait;
	}

	/**
	 * @param maxWait
	 * @uml.property  name="maxWait"
	 */
	public void setMaxWait(long maxWait)
	{
		this.maxWait = maxWait;
	}

}