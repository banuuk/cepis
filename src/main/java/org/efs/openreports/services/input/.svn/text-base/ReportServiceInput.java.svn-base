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

package org.efs.openreports.services.input;

import java.io.Serializable;
import java.util.Date;

import org.efs.openreports.ReportConstants;
import org.efs.openreports.ReportConstants.DeliveryMethod;
import org.efs.openreports.ReportConstants.ExportType;
import org.efs.openreports.ReportConstants.ScheduleAmPm;
import org.efs.openreports.ReportConstants.ScheduleType;

/**
 * ReportService input object contains information used to identify the user, report, delivery method, and export type of the request along with optional xml input,  parameter and scheduling information. 
 * @author  Erik Swenson
 * @see  ReportConstants
 */

public class ReportServiceInput implements Serializable
{	
	private static final long serialVersionUID = -3094443722330870862L;		
	
	/**
	 * unique id of request
	 * @uml.property  name="requestId"
	 */
	private String requestId;
	
    /**
	 * identifies the user making the request
	 * @uml.property  name="user"
	 * @uml.associationEnd  
	 */
	private UserInput user;  
    
    /**
	 * name of report
	 * @uml.property  name="reportName"
	 */
	private String reportName;	
	
    /**
	 * exportType for the report. defaults to PDF
	 * @uml.property  name="exportType"
	 * @uml.associationEnd  
	 */
	private ExportType exportType = ExportType.PDF;
    
    /**
	 * list of delivery methods for the report
	 * @uml.property  name="deliveryMethods"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private DeliveryMethod[] deliveryMethods;	
    
    /**
	 * delivery address for report
	 * @uml.property  name="deliveryAddress"
	 */
    private String deliveryAddress;
    
    /**
	 * return or bounce address for the report
	 * @uml.property  name="deliveryReturnAddress"
	 */
    private String deliveryReturnAddress;
    
    /**
	 * parameters passed to the report
	 * @uml.property  name="parameters"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private ParameterInput[] parameters;  
    
    /**
	 * xml data for report generation
	 * @uml.property  name="xmlInput"
	 */
    private String xmlInput;
   	
    /**
	 * start date for scheduled report
	 * @uml.property  name="startDate"
	 */
	private Date startDate;		
    
    /**
	 * start hour for scheduled report
	 * @uml.property  name="startHour"
	 */
	private String startHour;
    
    /**
	 * start minute for scheduled report
	 * @uml.property  name="startMinute"
	 */
	private String startMinute;
    
    /**
	 * am/pm indicator for scheduled report
	 * @uml.property  name="startAmPm"
	 * @uml.associationEnd  
	 */
	private ScheduleAmPm startAmPm;
    
    /**
	 * schedule type (once, daily, weekly, etc.). defaulted to once
	 * @uml.property  name="scheduleType"
	 * @uml.associationEnd  
	 */
	private ScheduleType scheduleType = ScheduleType.ONCE;
    
    /**
	 * sets priority of scheduled report. defaulted to five
	 * @uml.property  name="schedulePriority"
	 */
    private int schedulePriority = 5;
    
    /**
	 * description of scheduled report
	 * @uml.property  name="scheduleDescription"
	 */
	private String scheduleDescription;
    
    /**
	 * number of hours to run hourly schedule report
	 * @uml.property  name="hours"
	 */
	private int hours;	
    
    /**
	 * cron expression for cron schedule report
	 * @uml.property  name="cronExpression"
	 */
	private String cronExpression;	
	
	/**
	 * locale for the report in standard format, for example: "en_US"
	 * @uml.property  name="locale"
	 */
	private String locale;
			
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

	/**
	 * @return
	 * @uml.property  name="user"
	 */
	public UserInput getUser()
	{
		return user;
	}

	/**
	 * @param user
	 * @uml.property  name="user"
	 */
	public void setUser(UserInput user)
	{
		this.user = user;
	}

	/**
	 * @return
	 * @uml.property  name="deliveryMethods"
	 */
	public DeliveryMethod[] getDeliveryMethods()
	{
		return deliveryMethods;
	}
	
	/**
	 * @param deliveryMethods
	 * @uml.property  name="deliveryMethods"
	 */
	public void setDeliveryMethods(DeliveryMethod... deliveryMethods)
	{
		this.deliveryMethods = deliveryMethods;
	}	
    
    public boolean isDeliveryMethodSelected(String deliveryMethod)
    {
        if (deliveryMethods == null) return false;
        
        for (int i=0; i < deliveryMethods.length; i++)
        {
            if (deliveryMethods[i].equals(deliveryMethod)) return true;
        }
            
        return false;
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
	 * @uml.property  name="parameters"
	 */
    public ParameterInput[] getParameters()
    {
        return parameters;
    }

    /**
	 * @param parameters
	 * @uml.property  name="parameters"
	 */
    public void setParameters(ParameterInput... parameters)
    {
        this.parameters = parameters;
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
	 * @uml.property  name="scheduleType"
	 */
    public ScheduleType getScheduleType()
	{
		return scheduleType;
	}

	/**
	 * @param scheduleType
	 * @uml.property  name="scheduleType"
	 */
	public void setScheduleType(ScheduleType scheduleType)
	{
		this.scheduleType = scheduleType;
	}

	/**
	 * @return
	 * @uml.property  name="startAmPm"
	 */
	public ScheduleAmPm getStartAmPm()
	{
		return startAmPm;
	}

	/**
	 * @param startAmPm
	 * @uml.property  name="startAmPm"
	 */
	public void setStartAmPm(ScheduleAmPm startAmPm)
	{
		this.startAmPm = startAmPm;
	}

	/**
	 * @return
	 * @uml.property  name="startDate"
	 */
	public Date getStartDate()
	{
		return startDate;
	}

	/**
	 * @param startDate
	 * @uml.property  name="startDate"
	 */
	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	/**
	 * @return
	 * @uml.property  name="startHour"
	 */
	public String getStartHour()
	{
		return startHour;
	}

	/**
	 * @param startHour
	 * @uml.property  name="startHour"
	 */
	public void setStartHour(String startHour)
	{
		this.startHour = startHour;
	}

	/**
	 * @return
	 * @uml.property  name="startMinute"
	 */
	public String getStartMinute()
	{
		return startMinute;
	}

	/**
	 * @param startMinute
	 * @uml.property  name="startMinute"
	 */
	public void setStartMinute(String startMinute)
	{
		this.startMinute = startMinute;
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

	/**
	 * @return
	 * @uml.property  name="cronExpression"
	 */
	public String getCronExpression()
	{
		return cronExpression;
	}

	/**
	 * @param cronExpression
	 * @uml.property  name="cronExpression"
	 */
	public void setCronExpression(String cronExpression)
	{
		this.cronExpression = cronExpression;
	}

	/**
	 * @return
	 * @uml.property  name="hours"
	 */
	public int getHours()
	{
		return hours;
	}

	/**
	 * @param hours
	 * @uml.property  name="hours"
	 */
	public void setHours(int hours)
	{
		this.hours = hours;
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
	 * @uml.property  name="deliveryAddress"
	 */
    public String getDeliveryAddress() 
    {
        return deliveryAddress;
    }
    
    /**
	 * @param deliveryAddress
	 * @uml.property  name="deliveryAddress"
	 */
    public void setDeliveryAddress(String deliveryAddress) 
    {
        this.deliveryAddress = deliveryAddress;
    }
    
    /**
	 * @return
	 * @uml.property  name="deliveryReturnAddress"
	 */
    public String getDeliveryReturnAddress()
    {
        return deliveryReturnAddress;
    }
    
    /**
	 * @param deliveryReturnAddress
	 * @uml.property  name="deliveryReturnAddress"
	 */
    public void setDeliveryReturnAddress(String deliveryReturnAddress)
    {
        this.deliveryReturnAddress = deliveryReturnAddress;
    }
    
    /**
	 * @return
	 * @uml.property  name="schedulePriority"
	 */
    public int getSchedulePriority() 
    {
        return schedulePriority;
    }
    
    /**
	 * @param schedulePriority
	 * @uml.property  name="schedulePriority"
	 */
    public void setSchedulePriority(int schedulePriority) 
    {
        this.schedulePriority = schedulePriority;
    }

	/**
	 * @return
	 * @uml.property  name="locale"
	 */
	public String getLocale()
	{
		return locale;
	}

	/**
	 * @param locale
	 * @uml.property  name="locale"
	 */
	public void setLocale(String locale) 
	{
		this.locale = locale;
	}	    
}
