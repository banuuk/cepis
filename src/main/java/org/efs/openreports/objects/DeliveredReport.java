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

package org.efs.openreports.objects;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * @author  keerthi
 */
public class DeliveredReport implements Serializable
{	
	private static final long serialVersionUID = 9134829141030371147L;
	
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
	 * @uml.property  name="parameters"
	 */
	private Map parameters;		
    
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
	 * @uml.property  name="parameters"
	 */
	public Map getParameters()
	{
		return parameters;
	}
	
	/**
	 * @param parameters
	 * @uml.property  name="parameters"
	 */
	public void setParameters(Map parameters)
	{
		this.parameters = parameters;
	}
	
	public String getParameterList()
	{
		if (parameters == null || parameters.size() < 1) return "";
		
		StringBuffer buffer = new StringBuffer();
		
		Iterator iterator = parameters.keySet().iterator();
		while (iterator.hasNext())
		{
			String key = (String) iterator.next();
			if (key.indexOf("OPENREPORTS_") == -1)
			{			
				buffer.append(key + "=" + parameters.get(key) + " ");
			}
		}
		
		return buffer.toString();
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