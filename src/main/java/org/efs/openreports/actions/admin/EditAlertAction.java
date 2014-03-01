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

import java.util.List;

import org.apache.log4j.Logger;
import org.efs.openreports.objects.ReportAlert;
import org.efs.openreports.objects.ReportParameter;
import org.efs.openreports.providers.AlertProvider;
import org.efs.openreports.providers.DataSourceProvider;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author  keerthi
 */
public class EditAlertAction extends ActionSupport
{	
    private static final long serialVersionUID = 1322652952771381074L;

    protected static Logger log = Logger.getLogger(EditAlertAction.class);

	/**
	 * @uml.property  name="command"
	 */
	private String command;
	
	private boolean submitOk;

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
	 * @uml.property  name="reportAlert"
	 * @uml.associationEnd  
	 */
	private ReportAlert reportAlert;		

	/**
	 * @uml.property  name="dataSourceProvider"
	 * @uml.associationEnd  
	 */
	private DataSourceProvider dataSourceProvider;
	/**
	 * @uml.property  name="alertProvider"
	 * @uml.associationEnd  
	 */
	private AlertProvider alertProvider;
	
	public String execute()
	{
		try
		{
			if (command.equals("edit"))
			{
				reportAlert =
					alertProvider.getReportAlert(new Integer(id));
			}
			else
			{
				reportAlert = new ReportAlert();
			}

			if (command.equals("edit") && !submitOk)
			{
				name = reportAlert.getName();
				description = reportAlert.getDescription();
				query = reportAlert.getQuery();				
				id = reportAlert.getId().intValue();
				if (reportAlert.getDataSource() != null)
				{
					dataSourceId =
						reportAlert.getDataSource().getId().intValue();
				}			
			}

			if (!submitOk) return INPUT;

			reportAlert.setName(name);
			reportAlert.setDescription(description);
			reportAlert.setQuery(query);				
			if (dataSourceId != -1)
			{
				reportAlert.setDataSource(dataSourceProvider.getDataSource(
						new Integer(dataSourceId)));	
			}				

			if (command.equals("edit"))
			{
				alertProvider.updateReportAlert(reportAlert);
			}

			if (command.equals("add"))
			{
				alertProvider.insertReportAlert(reportAlert);
			}

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
	
	public void setSubmitOk(String submitOk)
	{
		if (submitOk != null) this.submitOk = true;
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

	public List getDataSources()
	{
		try
		{
			return dataSourceProvider.getDataSources();
		}
		catch (Exception e)
		{
			addActionError(e.getMessage());
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
	 * @param alertProvider
	 * @uml.property  name="alertProvider"
	 */
	public void setAlertProvider(AlertProvider alertProvider)
	{
		this.alertProvider = alertProvider;
	}
}