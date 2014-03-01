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

package org.efs.openreports.actions.schedule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import org.efs.openreports.ORStatics;
import org.efs.openreports.delivery.FileSystemDeliveryMethod;
import org.efs.openreports.objects.DeliveredReport;
import org.efs.openreports.objects.ReportSchedule;
import org.efs.openreports.objects.ReportUser;
import org.efs.openreports.providers.SchedulerProvider;

/**
 * @author  keerthi
 */
public class ListScheduledReportsAction	extends ActionSupport
{	
	private static final long serialVersionUID = 3842653664544858888L;

	/**
	 * @uml.property  name="scheduledReports"
	 */
	private List<ReportSchedule> scheduledReports;
	/**
	 * @uml.property  name="deliveredReports"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private DeliveredReport[] deliveredReports;
    
    /**
	 * @uml.property  name="refresh"
	 */
    private int refresh;
    
	/**
	 * @uml.property  name="schedulerProvider"
	 * @uml.associationEnd  
	 */
	private SchedulerProvider schedulerProvider;    
    /**
	 * @uml.property  name="fileSystemDeliveryMethod"
	 * @uml.associationEnd  
	 */
    private FileSystemDeliveryMethod fileSystemDeliveryMethod;
    
	@Override
	public String execute()
	{
		try
		{
			ReportUser reportUser =
				(ReportUser) ActionContext.getContext().getSession().get(
					ORStatics.REPORT_USER);
			scheduledReports = schedulerProvider.getScheduledReports(reportUser); 
            deliveredReports = fileSystemDeliveryMethod.getDeliveredReports(reportUser);		
		}
		catch(NullPointerException npe)
		{
			addActionError(getText("error.settings.directories"));
		}
		catch (Exception e)
		{
			addActionError(getText(e.getMessage()));
			return ERROR;
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
	
    /**
	 * @param fileSystemDeliveryMethod
	 * @uml.property  name="fileSystemDeliveryMethod"
	 */
    public void setFileSystemDeliveryMethod(FileSystemDeliveryMethod fileSystemDeliveryMethod) 
    {
        this.fileSystemDeliveryMethod = fileSystemDeliveryMethod;
    }

    /**
	 * @return
	 * @uml.property  name="scheduledReports"
	 */
    public List<ReportSchedule> getScheduledReports()
	{
		return scheduledReports;
	}
    
    /**
	 * @return
	 * @uml.property  name="deliveredReports"
	 */
    public DeliveredReport[] getDeliveredReports()
    {
        return deliveredReports;
    }

    /**
	 * @return
	 * @uml.property  name="refresh"
	 */
    public int getRefresh()
    {
        return refresh;
    }

    /**
	 * @param refresh
	 * @uml.property  name="refresh"
	 */
    public void setRefresh(int refresh)
    {
        this.refresh = refresh;
    }

}