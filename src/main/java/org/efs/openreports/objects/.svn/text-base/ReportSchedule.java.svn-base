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
import java.util.*;

/**
 * @author  keerthi
 */
public class ReportSchedule implements Serializable
{
	private static final long serialVersionUID = -679355847466582944l;
	
	public static final int ONCE = 0;
	public static final int DAILY = 1;
	public static final int WEEKLY = 2;
	public static final int MONTHLY = 3;
	public static final int WEEKDAYS = 4;
	public static final int HOURLY = 5;
	public static final int CRON = 6;
	
	/**
	 * @uml.property  name="user"
	 * @uml.associationEnd  
	 */
	private ReportUser user;
	/**
	 * @uml.property  name="report"
	 * @uml.associationEnd  
	 */
	private Report report;
	/**
	 * @uml.property  name="alert"
	 * @uml.associationEnd  
	 */
	private ReportUserAlert alert;
	/**
	 * @uml.property  name="reportParameters"
	 */
	private Map<String,Object> reportParameters;
	/**
	 * @uml.property  name="startDate"
	 */
	private Date startDate;		
	/**
	 * @uml.property  name="startHour"
	 */
	private String startHour;
	/**
	 * @uml.property  name="startMinute"
	 */
	private String startMinute;
	/**
	 * @uml.property  name="startAmPm"
	 */
	private String startAmPm;
	/**
	 * @uml.property  name="scheduleType"
	 */
	private int scheduleType;	
	/**
	 * @uml.property  name="exportType"
	 */
	private int exportType;
	/**
	 * @uml.property  name="hours"
	 */
	private int hours;
	/**
	 * @uml.property  name="cronExpression"
	 */
	private String cronExpression;
	
	/**
	 * @uml.property  name="recipients"
	 */
	private String recipients;
	
	/**
	 * @uml.property  name="scheduleName"
	 */
	private String scheduleName;
    
    /**
	 * @uml.property  name="xmlInput"
	 */
    private String xmlInput;
    /**
	 * @uml.property  name="deliveryMethods"
	 */
    private String[] deliveryMethods;
    /**
	 * @uml.property  name="deliveryReturnAddress"
	 */
    private String deliveryReturnAddress;
    /**
	 * @uml.property  name="requestId"
	 */
    private String requestId;
    /**
	 * @uml.property  name="schedulePriority"
	 */
    private int schedulePriority = 5;
    
    /**
	 * @uml.property  name="locale"
	 */
    private Locale locale;
	
	/**
	 * @uml.property  name="scheduleDescription"
	 */
	private transient String scheduleDescription;
	/**
	 * @uml.property  name="nextFireDate"
	 */
	private transient Date nextFireDate;
	/**
	 * @uml.property  name="scheduleState"
	 */
	private transient String scheduleState;
	
	public ReportSchedule()
	{
		
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
	 * @uml.property  name="reportParameters"
	 */
	public Map<String,Object> getReportParameters()
	{
		return reportParameters;
	}

	/**
	 * @param reportParameters
	 * @uml.property  name="reportParameters"
	 */
	public void setReportParameters(Map<String,Object> reportParameters)
	{
		this.reportParameters = reportParameters;
	}

	/**
	 * @return
	 * @uml.property  name="scheduleType"
	 */
	public int getScheduleType()
	{
		return scheduleType;
	}
	
	public String getScheduleTypeName()
	{
		switch (scheduleType)
		{
			case ONCE:
				return "Once";
			case DAILY:
				return "Daily";
			case WEEKLY:
				return "Weekly";
			case MONTHLY:
				return "Monthly";
			case WEEKDAYS:
				return "Weekdays";
			case HOURLY:
				return "Hourly";
			case CRON:
				return "Cron";
			default:
				return "Unknown";
		}		
	}	

	/**
	 * @param scheduleType
	 * @uml.property  name="scheduleType"
	 */
	public void setScheduleType(int scheduleType)
	{
		this.scheduleType = scheduleType;
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
	 * @uml.property  name="startAmPm"
	 */
	public String getStartAmPm()
	{
		return startAmPm;
	}

	/**
	 * @param startAmPm
	 * @uml.property  name="startAmPm"
	 */
	public void setStartAmPm(String startAmPm)
	{
		this.startAmPm = startAmPm;
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
	
	public int getAbsoluteStartHour()
	{
		int hour = Integer.parseInt(startHour);
		
		if (startAmPm.equalsIgnoreCase("PM") && hour != 12)
			hour += 12;
		
		if (startAmPm.equalsIgnoreCase("AM") && hour == 12)
			hour -= 12;
		
		return hour;
	}
	
	public int getAbsoluteEndHour()
	{		
		return getAbsoluteStartHour() + hours;
	}
	
	public int getDayOfWeek()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	public int getDayOfMonth()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		
		return calendar.get(Calendar.DAY_OF_MONTH);
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
	
	public String getScheduleGroup()
	{
		return String.valueOf(user.getId());
	}
	
	public Date getStartDateTime()
	{
		Calendar calendar = Calendar.getInstance();
		
		if (startDate != null)
		{
			calendar.setTime(startDate);
			calendar.set(Calendar.HOUR_OF_DAY, getAbsoluteStartHour());
			calendar.set(Calendar.MINUTE, Integer.parseInt(startMinute));
		}
		
		return calendar.getTime();
	}

	/**
	 * @return
	 * @uml.property  name="recipients"
	 */
	public String getRecipients()
	{
		return recipients;
	}

	/**
	 * @param recipients
	 * @uml.property  name="recipients"
	 */
	public void setRecipients(String recipients)
	{
		this.recipients = recipients;
	}
	
	/**
	 * @return
	 * @uml.property  name="exportType"
	 */
	public int getExportType()
	{
		return exportType;
	}

	/**
	 * @param exportType
	 * @uml.property  name="exportType"
	 */
	public void setExportType(int exportType)
	{
		this.exportType = exportType;
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
	 * @uml.property  name="alert"
	 */
	public ReportUserAlert getAlert()
	{
		return alert;
	}

	/**
	 * @param alert
	 * @uml.property  name="alert"
	 */
	public void setAlert(ReportUserAlert alert)
	{
		this.alert = alert;
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
	 * @uml.property  name="scheduleState"
	 */
	public String getScheduleState()
	{
		return scheduleState;
	}

	/**
	 * @param scheduleState
	 * @uml.property  name="scheduleState"
	 */
	public void setScheduleState(String scheduleState)
	{
		this.scheduleState = scheduleState;
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
	 * @uml.property  name="deliveryMethods"
	 */
    public String[] getDeliveryMethods() 
    {
        return deliveryMethods;
    }
    
    /**
	 * @param deliveryMethods
	 * @uml.property  name="deliveryMethods"
	 */
    public void setDeliveryMethods(String[] deliveryMethods) 
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
	public Locale getLocale() 
	{
		return locale;
	}

	/**
	 * @param locale
	 * @uml.property  name="locale"
	 */
	public void setLocale(Locale locale) 
	{
		this.locale = locale;
	}       
}