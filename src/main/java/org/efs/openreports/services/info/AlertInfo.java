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

/**
 * AlertInfo object. 
 * @author  Erik Swenson
 */

public class AlertInfo implements Serializable
{	
	private static final long serialVersionUID = 7015514094862252982L;
	
	/**
	 * @uml.property  name="alertName"
	 */
	private String alertName;
	/**
	 * @uml.property  name="condition"
	 */
	private String condition;
	/**
	 * @uml.property  name="count"
	 */
	private int count;
	/**
	 * @uml.property  name="triggered"
	 */
	private boolean triggered;
	/**
	 * @uml.property  name="reportName"
	 */
	private String reportName;
	/**
	 * @uml.property  name="message"
	 */
	private String message;
	
	/**
	 * @return
	 * @uml.property  name="alertName"
	 */
	public String getAlertName()
	{
		return alertName;
	}
	
	/**
	 * @param alertName
	 * @uml.property  name="alertName"
	 */
	public void setAlertName(String alertName)
	{
		this.alertName = alertName;
	}
	
	/**
	 * @return
	 * @uml.property  name="condition"
	 */
	public String getCondition()
	{
		return condition;
	}
	
	/**
	 * @param condition
	 * @uml.property  name="condition"
	 */
	public void setCondition(String condition)
	{
		this.condition = condition;
	}
	
	/**
	 * @return
	 * @uml.property  name="count"
	 */
	public int getCount()
	{
		return count;
	}
	
	/**
	 * @param count
	 * @uml.property  name="count"
	 */
	public void setCount(int count)
	{
		this.count = count;
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
	 * @uml.property  name="triggered"
	 */
	public boolean isTriggered()
	{
		return triggered;
	}

	/**
	 * @param triggered
	 * @uml.property  name="triggered"
	 */
	public void setTriggered(boolean triggered)
	{
		this.triggered = triggered;
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
}
