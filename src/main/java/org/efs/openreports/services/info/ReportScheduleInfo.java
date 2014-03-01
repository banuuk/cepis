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
import java.util.*;

/**
 * ReportScheduleInfo object. 
 * @author  Erik Swenson
 * @see  AlertInfo
 */

public class ReportScheduleInfo implements Serializable
{		
	private static final long serialVersionUID = 2130467571173388494L;
	
	/**
	 * @uml.property  name="reportName"
	 */
	private String reportName;
	/**
	 * @uml.property  name="alert"
	 * @uml.associationEnd  
	 */
	private AlertInfo alert;	
	/**
	 * @uml.property  name="scheduleTypeName"
	 */
	private String scheduleTypeName;			
	/**
	 * @uml.property  name="scheduleDescription"
	 */
	private String scheduleDescription;
	/**
	 * @uml.property  name="nextFireDate"
	 */
	private Date nextFireDate;
	
	public ReportScheduleInfo()
	{
		
	}	
	
	/**
	 * @return
	 * @uml.property  name="alert"
	 */
	public AlertInfo getAlert()
	{
		return alert;
	}

	/**
	 * @param alert
	 * @uml.property  name="alert"
	 */
	public void setAlert(AlertInfo alert)
	{
		this.alert = alert;
	}

	/**
	 * @return
	 * @uml.property  name="reportName"
	 */
	public String getReportName()
	{
		return reportName;
	}

	/**
	 * @param reportName
	 * @uml.property  name="reportName"
	 */
	public void setReportName(String reportName)
	{
		this.reportName = reportName;
	}

	/**
	 * @return
	 * @uml.property  name="scheduleTypeName"
	 */
	public String getScheduleTypeName()
	{
		return scheduleTypeName;
	}

	/**
	 * @param scheduleTypeName
	 * @uml.property  name="scheduleTypeName"
	 */
	public void setScheduleTypeName(String scheduleTypeName)
	{
		this.scheduleTypeName = scheduleTypeName;
	}

	/**
	 * @return
	 * @uml.property  name="nextFireDate"
	 */
	public Date getNextFireDate()
	{
		return nextFireDate;
	}
	
	/**
	 * @param nextFireDate
	 * @uml.property  name="nextFireDate"
	 */
	public void setNextFireDate(Date nextFireDate)
	{
		this.nextFireDate = nextFireDate;
	}	

	/**
	 * @return
	 * @uml.property  name="scheduleDescription"
	 */
	public String getScheduleDescription()
	{
		return scheduleDescription;
	}

	/**
	 * @param scheduleDescription
	 * @uml.property  name="scheduleDescription"
	 */
	public void setScheduleDescription(String scheduleDescription)
	{
		this.scheduleDescription = scheduleDescription;
	}	
}