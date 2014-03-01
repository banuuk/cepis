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

package org.efs.openreports.objects;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author  keerthi
 */
public class ReportLog implements Serializable
{	
	private static final long serialVersionUID = -7260204621599035553L;
	
	public static final String STATUS_SUCCESS = "success";
	public static final String STATUS_FAILURE = "failure";
	public static final String STATUS_EMPTY = "empty";
	public static final String STATUS_TRIGGERED = "triggered";
	public static final String STATUS_NOT_TRIGGERED = "not triggered";
	public static final String STATUS_DELIVERY_FAILURE = "delivery failure";
	
	/**
	 * @uml.property  name="id"
	 */
	private Integer id;
	/**
	 * @uml.property  name="report"
	 * @uml.associationEnd  
	 */
	private Report report;
	/**
	 * @uml.property  name="startTime"
	 */
	private Date startTime;
	/**
	 * @uml.property  name="endTime"
	 */
	private Date endTime;
	/**
	 * @uml.property  name="status"
	 */
	private String status;
	/**
	 * @uml.property  name="message"
	 */
	private String message;
	/**
	 * @uml.property  name="user"
	 * @uml.associationEnd  
	 */
	private ReportUser user;
	/**
	 * @uml.property  name="alert"
	 * @uml.associationEnd  
	 */
	private ReportAlert alert;
    /**
	 * @uml.property  name="exportType"
	 */
    private Integer exportType; 
    /**
	 * @uml.property  name="requestId"
	 */
    private String requestId;
    
    /**
	 * @uml.property  name="deliveryLogs"
	 */
    private List<ReportDeliveryLog> deliveryLogs;   

	public ReportLog()
	{
	}	

	public ReportLog(ReportUser user, Report report, Date startTime)
	{
		this.user = user;
		this.report = report;
		this.startTime = startTime;
	}		
	
	public ReportLog(ReportUser user, ReportAlert alert, Date startTime)
	{
		this.user = user;
		this.alert = alert;
		this.startTime = startTime;
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
	 * @param id
	 * @uml.property  name="id"
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}

	/**
	 * @return
	 * @uml.property  name="message"
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * @param message
	 * @uml.property  name="message"
	 */
	public void setMessage(String message)
	{
		this.message = message;
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
	 * @uml.property  name="startTime"
	 */
	public Date getStartTime()
	{
		return startTime;
	}

	/**
	 * @param startTime
	 * @uml.property  name="startTime"
	 */
	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
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
	 * @uml.property  name="endTime"
	 */
	public Date getEndTime()
	{
		return endTime;
	}

	/**
	 * @param endTime
	 * @uml.property  name="endTime"
	 */
	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}
	
	public long getElapsedTime()
	{
		if (endTime != null && startTime != null)
		{
			long elapsedTime = endTime.getTime() -	startTime.getTime();
			return elapsedTime / 1000;
		}
		else
		{
			return 0;
		}
		
		
	}

	/**
	 * @return
	 * @uml.property  name="user"
	 */
	public ReportUser getUser()
	{
		return user;
	}

	/**
	 * @param user
	 * @uml.property  name="user"
	 */
	public void setUser(ReportUser user)
	{
		this.user = user;
	}

	/**
	 * @return
	 * @uml.property  name="alert"
	 */
	public ReportAlert getAlert()
	{
		return alert;
	}

	/**
	 * @param alert
	 * @uml.property  name="alert"
	 */
	public void setAlert(ReportAlert alert)
	{
		this.alert = alert;
	}       
    
    /**
	 * @return
	 * @uml.property  name="deliveryLogs"
	 */
    public List<ReportDeliveryLog> getDeliveryLogs()
    {
        return deliveryLogs;
    }
    
    /**
	 * @param deliveryLogs
	 * @uml.property  name="deliveryLogs"
	 */
    public void setDeliveryLogs(List<ReportDeliveryLog> deliveryLogs) 
    {
        this.deliveryLogs = deliveryLogs;
    }

    /**
	 * @return
	 * @uml.property  name="exportType"
	 */
    public Integer getExportType() 
    {
        return exportType;
    }
    
    /**
	 * @param exportType
	 * @uml.property  name="exportType"
	 */
    public void setExportType(Integer exportType) 
    {
        this.exportType = exportType;
    }

	/**
	 * @return
	 * @uml.property  name="requestId"
	 */
	public String getRequestId() 
	{
		return requestId;
	}

	/**
	 * @param requestId
	 * @uml.property  name="requestId"
	 */
	public void setRequestId(String requestId)
	{
		this.requestId = requestId;
	}    
}