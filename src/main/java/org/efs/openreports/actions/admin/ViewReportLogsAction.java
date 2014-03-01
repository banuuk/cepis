/*
 * Copyright (C) 2002 Erik Swenson - erik@oreports.com
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 *  
 */

package org.efs.openreports.actions.admin;

import java.util.List;

import org.efs.openreports.actions.DisplayTagAction;
import org.efs.openreports.objects.Report;
import org.efs.openreports.objects.ReportAlert;
import org.efs.openreports.objects.ReportLog;
import org.efs.openreports.objects.ReportUser;
import org.efs.openreports.providers.*;

/**
 * @author  keerthi
 */
public class ViewReportLogsAction extends DisplayTagAction
{	
	private static final long serialVersionUID = 1524361082711124253L;
	
	/**
	 * @uml.property  name="reportLogs"
	 */
	private List<ReportLog> reportLogs;
	/**
	 * @uml.property  name="users"
	 */
	private List<ReportUser> users;
	/**
	 * @uml.property  name="reports"
	 */
	private List<Report> reports;
	/**
	 * @uml.property  name="alerts"
	 */
	private List<ReportAlert> alerts;
	/**
	 * @uml.property  name="status"
	 */
	private String status;
	/**
	 * @uml.property  name="userId"
	 */
	private Integer userId;
	/**
	 * @uml.property  name="reportId"
	 */
	private Integer reportId;
	/**
	 * @uml.property  name="alertId"
	 */
	private Integer alertId;

	private boolean submitOk = false;

	/**
	 * @uml.property  name="statuses"
	 */
	private String[] statuses = new String[] { ReportLog.STATUS_SUCCESS,
			ReportLog.STATUS_EMPTY, ReportLog.STATUS_FAILURE, ReportLog.STATUS_TRIGGERED,
			ReportLog.STATUS_NOT_TRIGGERED };

	/**
	 * @uml.property  name="reportLogProvider"
	 * @uml.associationEnd  
	 */
	private ReportLogProvider reportLogProvider;
	/**
	 * @uml.property  name="reportProvider"
	 * @uml.associationEnd  
	 */
	private ReportProvider reportProvider;
	/**
	 * @uml.property  name="userProvider"
	 * @uml.associationEnd  
	 */
	private UserProvider userProvider;
	/**
	 * @uml.property  name="alertProvider"
	 * @uml.associationEnd  
	 */
	private AlertProvider alertProvider;

	/**
	 * @return
	 * @uml.property  name="reportLogs"
	 */
	public List<ReportLog> getReportLogs()
	{
		return reportLogs;
	}

	@Override
	public String execute()
	{
		try
		{
			reports = reportProvider.getReports();			
			users = userProvider.getUsers();
			alerts = alertProvider.getReportAlerts();

			if (submitOk)
			{
				if (status != null && status.length() < 1) status = null;

				reportLogs = reportLogProvider.getReportLogs(status, userId, reportId, alertId, 500);
			}
		}
		catch (ProviderException pe)
		{
			addActionError(pe.getMessage());
			return ERROR;
		}

		return SUCCESS;
	}

	public void setSubmitOk(String submitOk)
	{
		if (submitOk != null) this.submitOk = true;
	}

	public boolean isResultAvailable()
	{
		return submitOk;
	}
	
	/**
	 * @return
	 * @uml.property  name="reports"
	 */
	public List<Report> getReports()
	{
		return reports;
	}

	/**
	 * @return
	 * @uml.property  name="statuses"
	 */
	public String[] getStatuses()
	{
		return statuses;
	}

	/**
	 * @return
	 * @uml.property  name="users"
	 */
	public List<ReportUser> getUsers()
	{
		return users;
	}

	/**
	 * @return
	 * @uml.property  name="reportId"
	 */
	public Integer getReportId()
	{
		return reportId;
	}

	/**
	 * @param reportId
	 * @uml.property  name="reportId"
	 */
	public void setReportId(Integer reportId)
	{
		this.reportId = reportId;
	}

	/**
	 * @return
	 * @uml.property  name="status"
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * @param status
	 * @uml.property  name="status"
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}

	/**
	 * @return
	 * @uml.property  name="userId"
	 */
	public Integer getUserId()
	{
		return userId;
	}

	/**
	 * @param userId
	 * @uml.property  name="userId"
	 */
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	/**
	 * @return
	 * @uml.property  name="alertId"
	 */
	public Integer getAlertId()
	{
		return alertId;
	}

	/**
	 * @param alertId
	 * @uml.property  name="alertId"
	 */
	public void setAlertId(Integer alertId)
	{
		this.alertId = alertId;
	}

	/**
	 * @param reportLogProvider
	 * @uml.property  name="reportLogProvider"
	 */
	public void setReportLogProvider(ReportLogProvider reportLogProvider)
	{
		this.reportLogProvider = reportLogProvider;
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
	 * @param userProvider
	 * @uml.property  name="userProvider"
	 */
	public void setUserProvider(UserProvider userProvider)
	{
		this.userProvider = userProvider;
	}

	/**
	 * @param alertProvider
	 * @uml.property  name="alertProvider"
	 */
	public void setAlertProvider(AlertProvider alertProvider)
	{
		this.alertProvider = alertProvider;
	}

	/**
	 * @return
	 * @uml.property  name="alerts"
	 */
	public List<ReportAlert> getAlerts()
	{
		return alerts;
	}	
}