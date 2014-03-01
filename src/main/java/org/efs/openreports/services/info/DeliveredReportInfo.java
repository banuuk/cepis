/*
 * Copyright (C) 2007 Erik Swenson - erik@oreports.com
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
import java.util.Date;

/**
 * @author  keerthi
 */
public class DeliveredReportInfo implements Serializable
{		
	private static final long serialVersionUID = 4367765215724788357L;
	
    /**
	 * @uml.property  name="requestId"
	 */
    private String requestId;
	/**
	 * @uml.property  name="userName"
	 */
	private String userName;
	/**
	 * @uml.property  name="reportName"
	 */
	private String reportName;
	/**
	 * @uml.property  name="reportDescription"
	 */
	private String reportDescription;
	/**
	 * @uml.property  name="reportFileName"
	 */
	private String reportFileName;
    /**
	 * @uml.property  name="deliveryMethod"
	 */
    private String deliveryMethod;
	/**
	 * @uml.property  name="runDate"
	 */
	private Date runDate;	
	
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
	 * @uml.property  name="userName"
	 */
    public String getUserName()
	{
		return userName;
	}

	/**
	 * @param userName
	 * @uml.property  name="userName"
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	/**
	 * @return
	 * @uml.property  name="reportDescription"
	 */
	public String getReportDescription()
	{
		return reportDescription;
	}
	
	/**
	 * @param reportDescription
	 * @uml.property  name="reportDescription"
	 */
	public void setReportDescription(String reportDescription)
	{
		this.reportDescription = reportDescription;
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
	 * @uml.property  name="runDate"
	 */
	public Date getRunDate()
	{
		return runDate;
	}
	
	/**
	 * @param runDate
	 * @uml.property  name="runDate"
	 */
	public void setRunDate(Date runDate)
	{
		this.runDate = runDate;
	}

	/**
	 * @return
	 * @uml.property  name="reportFileName"
	 */
	public String getReportFileName()
	{
		return reportFileName;
	}

	/**
	 * @param reportFileName
	 * @uml.property  name="reportFileName"
	 */
	public void setReportFileName(String reportFileName)
	{
		this.reportFileName = reportFileName;
	}
    
    /**
	 * @return
	 * @uml.property  name="deliveryMethod"
	 */
    public String getDeliveryMethod() 
    {
        return deliveryMethod;
    }
    
    /**
	 * @param deliveryMethod
	 * @uml.property  name="deliveryMethod"
	 */
    public void setDeliveryMethod(String deliveryMethod) 
    {
        this.deliveryMethod = deliveryMethod;
    }
}