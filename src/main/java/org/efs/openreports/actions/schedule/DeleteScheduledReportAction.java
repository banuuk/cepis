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

package org.efs.openreports.actions.schedule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.efs.openreports.ORStatics;
import org.efs.openreports.objects.ReportSchedule;
import org.efs.openreports.objects.ReportUser;
import org.efs.openreports.providers.*;

/**
 * @author  keerthi
 */
public class DeleteScheduledReportAction extends ActionSupport
{
	private static final long serialVersionUID = 7656385297335699125L;
	
	/**
	 * @uml.property  name="schedulerProvider"
	 * @uml.associationEnd  
	 */
	private SchedulerProvider schedulerProvider;
	/**
	 * @uml.property  name="dateProvider"
	 * @uml.associationEnd  
	 */
	private DateProvider dateProvider;
	/**
	 * @uml.property  name="userProvider"
	 * @uml.associationEnd  
	 */
	private UserProvider userProvider;

	protected boolean submitDelete;
	protected boolean submitCancel;
	
	/**
	 * @uml.property  name="scheduleName"
	 */
	private String scheduleName;
	/**
	 * @uml.property  name="userId"
	 */
	private int userId = Integer.MIN_VALUE;
	
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	/**
	 * @uml.property  name="description"
	 */
	private String description;
	/**
	 * @uml.property  name="startDate"
	 */
	private String startDate;
	/**
	 * @uml.property  name="scheduleTypeName"
	 */
	private String scheduleTypeName;	

	public String execute()
	{
		try
		{
			ReportUser reportUser = null;
			
			if (userId >= 0)
			{
				reportUser = userProvider.getUser(new Integer(userId));
			}
			else
			{
				reportUser = (ReportUser) ActionContext.getContext().getSession().get(
					ORStatics.REPORT_USER);
			}

			ReportSchedule reportSchedule =
				schedulerProvider.getScheduledReport(reportUser, scheduleName);

			name = reportSchedule.getReport().getName();
			description = reportSchedule.getScheduleDescription();
			startDate = dateProvider.formatDate(reportSchedule.getStartDate());
			scheduleTypeName = reportSchedule.getScheduleTypeName();

			if (!submitDelete && !submitCancel)
			{
				return INPUT;
			}

			if (submitDelete)
			{
				schedulerProvider.deleteScheduledReport(
					reportUser,
					scheduleName);
			}
		}
		catch (Exception e)
		{			
			addActionError(e.getMessage());
			return INPUT;
		}

		return SUCCESS;
	}

	/**
	 * @param schedulerProvider
	 * @uml.property  name="schedulerProvider"
	 */
	public void setSchedulerProvider(SchedulerProvider schedulerProvider)
	{
		this.schedulerProvider = schedulerProvider;
	}	
	
	public void setSubmitDelete(String submitDelete)
	{
		if (submitDelete != null) this.submitDelete = true;
	}
	
	public void setSubmitCancel(String submitCancel)
	{
		if (submitCancel != null) this.submitCancel = true;
	}

	/**
	 * @return
	 * @uml.property  name="scheduleName"
	 */
	public String getScheduleName()
	{
		return scheduleName;
	}

	/**
	 * @param scheduleName
	 * @uml.property  name="scheduleName"
	 */
	public void setScheduleName(String scheduleName)
	{
		this.scheduleName = scheduleName;
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
	 * @param name
	 * @uml.property  name="name"
	 */
	public void setName(String name)
	{
		this.name = name;
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
	 * @uml.property  name="startDate"
	 */
	public String getStartDate()
	{
		return startDate;
	}

	/**
	 * @param startDate
	 * @uml.property  name="startDate"
	 */
	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
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
	 * @return
	 * @uml.property  name="userId"
	 */
	public int getUserId()
	{
		return userId;
	}

	/**
	 * @param userId
	 * @uml.property  name="userId"
	 */
	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	/**
	 * @param userProvider
	 * @uml.property  name="userProvider"
	 */
	public void setUserProvider(UserProvider userProvider)
	{
		this.userProvider = userProvider;
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

}