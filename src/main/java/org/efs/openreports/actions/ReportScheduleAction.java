/*
 * Copyright (C) 2002 Erik Swenson - erik@oreports.com
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See
 * the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; if
 * not, write to the Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *  
 */

package org.efs.openreports.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.efs.openreports.ORStatics;
import org.efs.openreports.ReportConstants.DeliveryMethod;
import org.efs.openreports.objects.Report;
import org.efs.openreports.objects.ReportAlert;
import org.efs.openreports.objects.ReportSchedule;
import org.efs.openreports.objects.ReportUser;
import org.efs.openreports.objects.ReportUserAlert;
import org.efs.openreports.providers.AlertProvider;
import org.efs.openreports.providers.DateProvider;
import org.efs.openreports.providers.SchedulerProvider;
import org.efs.openreports.providers.UserProvider;
import org.efs.openreports.util.LocalStrings;

/**
 * @author  keerthi
 */
public class ReportScheduleAction extends ActionSupport 
{	
	private static final long serialVersionUID = 4669274401576512976L;

	protected static Logger log = Logger.getLogger(ReportScheduleAction.class);

	private boolean submitScheduledReport;
	/**
	 * @uml.property  name="report"
	 * @uml.associationEnd  
	 */
	private Report report;

	/**
	 * @uml.property  name="scheduleName"
	 */
	private String scheduleName;
	/**
	 * @uml.property  name="description"
	 */
	private String description;
	/**
	 * @uml.property  name="userId"
	 */
	private int userId = Integer.MIN_VALUE;

	/**
	 * @uml.property  name="scheduleType"
	 */
	private int scheduleType;
	/**
	 * @uml.property  name="startDate"
	 */
	private String startDate;
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
	 * @uml.property  name="recipients"
	 */
	private String recipients;
	/**
	 * @uml.property  name="hours"
	 */
	private int hours;
	/**
	 * @uml.property  name="cron"
	 */
	private String cron;
	
	/**
	 * @uml.property  name="alertId"
	 */
	private int alertId = Integer.MIN_VALUE;	
	/**
	 * @uml.property  name="alertLimit"
	 */
	private int alertLimit;
	/**
	 * @uml.property  name="alertOperator"
	 */
	private String alertOperator;

    /**
	 * @uml.property  name="runToFile"
	 */
    private boolean runToFile;
    
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
	 * @uml.property  name="alertProvider"
	 * @uml.associationEnd  
	 */
	private AlertProvider alertProvider;
	/**
	 * @uml.property  name="userProvider"
	 * @uml.associationEnd  
	 */
	private UserProvider userProvider;

	public String execute()
	{
		ReportUser user = null;
		
		if (userId >= 0)
		{
			try
			{
				user = userProvider.getUser(new Integer(userId));
			}
			catch (Exception e)
			{
				addActionError(e.getMessage());
				return INPUT;
			}
		}
		else
		{
			user = (ReportUser) ActionContext.getContext().getSession().get(
				ORStatics.REPORT_USER);
		}
		
		if (user.getEmail() == null || user.getEmail().length() < 1)
		{
			addActionError(LocalStrings.ERROR_EMAILADDRESS_REQUIRED);
			return INPUT;
		}

		if (recipients == null || recipients.length() < 1)
		{
			recipients = user.getEmail();
		}
		
		if (!submitScheduledReport)
		{
			if (scheduleName != null && scheduleName.length() > 0)
			{
				try
				{
					ReportSchedule reportSchedule = schedulerProvider.getScheduledReport(user, scheduleName);

					report = reportSchedule.getReport();
					scheduleType = reportSchedule.getScheduleType();
					startDate = dateProvider.formatDate(reportSchedule.getStartDate());
					startHour = reportSchedule.getStartHour();
					startMinute = reportSchedule.getStartMinute();
					startAmPm = reportSchedule.getStartAmPm();
					recipients = reportSchedule.getRecipients();
					description = reportSchedule.getScheduleDescription();
					hours = reportSchedule.getHours();
					cron = reportSchedule.getCronExpression();
					runToFile = reportSchedule.isDeliveryMethodSelected(DeliveryMethod.FILE.getName());
                    
					if (reportSchedule.getAlert() != null)
					{				
						ReportUserAlert userAlert = reportSchedule.getAlert();
						
						alertId = userAlert.getAlert().getId().intValue();
						alertLimit = userAlert.getLimit();
						alertOperator = userAlert.getOperator();
					}	                    
				}
				catch (Exception e)
				{
					addActionError(e.getMessage());
					return INPUT;
				}
			}
			else
			{
				report = (Report) ActionContext.getContext().getSession().get(ORStatics.REPORT);
				
				Calendar calendar = Calendar.getInstance();
				
				startDate = dateProvider.formatDate(calendar.getTime());
				startHour = String.valueOf(calendar.get(Calendar.HOUR));
				startMinute = String.valueOf(calendar.get(Calendar.MINUTE));
				
				if (calendar.get(Calendar.AM_PM) == Calendar.PM) startAmPm = "PM";
			}

			return INPUT;
		}

		if (startDate == null || startDate.length() < 1 || startHour == null || startHour.length() < 1
				|| startMinute == null || startMinute.length() < 1 || startAmPm == null
				|| startAmPm.length() < 1)
		{
			addActionError(LocalStrings.ERROR_DATEANDTIME_REQUIRED);
			return INPUT;
		}		
		
		int hour = Integer.parseInt(startHour);
		int minute = Integer.parseInt(startMinute);
		if (hour > 12 || hour < 1 || minute < 0 || minute > 59)
		{
			addActionError(LocalStrings.ERROR_DATEANDTIME_INVALID);
			return INPUT;
		}

		ReportSchedule reportSchedule = new ReportSchedule();
		
		try
		{			
			if (scheduleName != null && scheduleName.length() > 0)
			{
				reportSchedule = schedulerProvider.getScheduledReport(user, scheduleName);
			}
			else
			{
				report = (Report) ActionContext.getContext().getSession().get(ORStatics.REPORT);
			
				int exportType = Integer.parseInt((String) ActionContext.getContext().getSession().get(
						ORStatics.EXPORT_TYPE));

				reportSchedule.setReport(report);
				reportSchedule.setUser(user);
				reportSchedule.setReportParameters(getReportParameters());
				reportSchedule.setExportType(exportType);
				reportSchedule.setScheduleName(report.getId() + "|" + new Date().getTime());				
			}

			reportSchedule.setScheduleType(scheduleType);
			reportSchedule.setStartDate(dateProvider.parseDate(startDate));
			reportSchedule.setStartHour(startHour);
			reportSchedule.setStartMinute(startMinute);
			reportSchedule.setStartAmPm(startAmPm);
			reportSchedule.setRecipients(recipients);
			reportSchedule.setScheduleDescription(description);
			reportSchedule.setHours(hours);
			reportSchedule.setCronExpression(cron);
            
            if (runToFile)
            {
                reportSchedule.setDeliveryMethods(new String[]{DeliveryMethod.FILE.getName()});               
            }
            else
            {
                reportSchedule.setDeliveryMethods(new String[]{DeliveryMethod.EMAIL.getName()});  
            }
			
			if (alertId != -1)
			{
				ReportAlert alert = alertProvider.getReportAlert(new Integer(alertId));
				
				ReportUserAlert userAlert = new ReportUserAlert();
				userAlert.setAlert(alert);
				userAlert.setUser(user);			
				userAlert.setLimit(alertLimit);
				userAlert.setOperator(alertOperator);
											
				reportSchedule.setAlert(userAlert);
			}
			else
			{
				reportSchedule.setAlert(null);
			}  

			if (scheduleName != null && scheduleName.length() > 0)
			{
				// in order to update a schedule report, original reportSchedule
				// is deleted and new a one is created.			
				schedulerProvider.deleteScheduledReport(user, scheduleName);
			}

			schedulerProvider.scheduleReport(reportSchedule);
		}
		catch (Exception e)
		{
			addActionError(e.getMessage());
			return INPUT;
		}

		addActionError(LocalStrings.MESSAGE_SCHEDULE_SUCCESSFUL);

		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	private Map<String,Object> getReportParameters()
	{
		return (Map) ActionContext.getContext().getSession().get(ORStatics.REPORT_PARAMETERS);
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
	 * @param schedulerProvider
	 * @uml.property  name="schedulerProvider"
	 */
	public void setSchedulerProvider(SchedulerProvider schedulerProvider)
	{
		this.schedulerProvider = schedulerProvider;
	}

	public void setSubmitScheduledReport(String submitScheduledReport)
	{
		if (submitScheduledReport != null) this.submitScheduledReport = true;
	}

	/**
	 * @return
	 * @uml.property  name="scheduleType"
	 */
	public int getScheduleType()
	{
		return scheduleType;
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
	 * @param dateProvider
	 * @uml.property  name="dateProvider"
	 */
	public void setDateProvider(DateProvider dateProvider)
	{
		this.dateProvider = dateProvider;
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
	
	public String getDateFormat()
	{
		return dateProvider.getDateFormat().toPattern();
	}
	
	/**
	 * @return
	 * @uml.property  name="alertId"
	 */
	public int getAlertId()
	{
		return alertId;
	}

	/**
	 * @param alertId
	 * @uml.property  name="alertId"
	 */
	public void setAlertId(int alertId)
	{
		this.alertId = alertId;
	}

	public List getAlerts()
	{
		try
		{
			return alertProvider.getReportAlerts();
		}
		catch (Exception e)
		{
			addActionError(e.getMessage());
			return null;
		}
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
	 * @uml.property  name="alertLimit"
	 */
	public int getAlertLimit()
	{
		return alertLimit;
	}

	/**
	 * @param alertLimit
	 * @uml.property  name="alertLimit"
	 */
	public void setAlertLimit(int alertLimit)
	{
		this.alertLimit = alertLimit;
	}

	/**
	 * @return
	 * @uml.property  name="alertOperator"
	 */
	public String getAlertOperator()
	{
		return alertOperator;
	}

	/**
	 * @param alertOperator
	 * @uml.property  name="alertOperator"
	 */
	public void setAlertOperator(String alertOperator)
	{
		this.alertOperator = alertOperator;
	}
	
	public String[] getOperators()
	{
		return new String[] {ReportAlert.OPERATOR_EQUAL, ReportAlert.OPERATOR_GREATER, ReportAlert.OPERATOR_LESS};
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
	 * @param userProvider
	 * @uml.property  name="userProvider"
	 */
	public void setUserProvider(UserProvider userProvider)
	{
		this.userProvider = userProvider;
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
	 * @return
	 * @uml.property  name="cron"
	 */
	public String getCron()
	{
		return cron;
	}

	/**
	 * @param cron
	 * @uml.property  name="cron"
	 */
	public void setCron(String cron)
	{
		this.cron = cron;
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
	 * @uml.property  name="runToFile"
	 */
    public boolean isRunToFile()
    {
        return runToFile;
    }

    /**
	 * @param runToFile
	 * @uml.property  name="runToFile"
	 */
    public void setRunToFile(boolean runToFile)
    {
        this.runToFile = runToFile;
    }   
}