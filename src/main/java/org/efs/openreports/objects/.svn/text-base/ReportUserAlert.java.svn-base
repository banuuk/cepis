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

/**
 * @author  keerthi
 */
public class ReportUserAlert implements Comparable<ReportUserAlert>, Serializable
{		
	private static final long serialVersionUID = 6833718935442336961L;
	
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
	 * @uml.property  name="report"
	 * @uml.associationEnd  
	 */
	private Report report;
	/**
	 * @uml.property  name="limit"
	 */
	private int limit;
	/**
	 * @uml.property  name="operator"
	 */
	private String operator;	
	
	/**
	 * @uml.property  name="count"
	 */
	private int count;	
	
	public String getCondition()
	{
		return getOperator() + " " + limit;
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
	 * @uml.property  name="limit"
	 */
	public int getLimit()
	{
		return limit;
	}

	/**
	 * @param limit
	 * @uml.property  name="limit"
	 */
	public void setLimit(int limit)
	{
		this.limit = limit;
	}

	/**
	 * @return
	 * @uml.property  name="operator"
	 */
	public String getOperator()
	{
		if (operator == null || operator.trim().length() < 1) return ReportAlert.OPERATOR_EQUAL;		
		return operator;
	}

	/**
	 * @param operator
	 * @uml.property  name="operator"
	 */
	public void setOperator(String operator)
	{
		this.operator = operator;
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

	public int compareTo(ReportUserAlert reportUserAlert)
	{			
		return alert.getName().compareTo(reportUserAlert.getAlert().getName());
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

	public boolean isTriggered()
	{
		if ("=".equals(operator))
		{
			if (limit == count) return true;
		}
		else if (">".equals(operator))
		{
			if (count > limit) return true;
		}
		else if ("<".equals(operator))
		{
			if (count < limit) return true;
		}
		
		return false;
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
}