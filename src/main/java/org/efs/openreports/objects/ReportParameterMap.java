/*
 * Copyright (C) 2004 Erik Swenson - erik@oreports.com
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
public class ReportParameterMap implements Comparable<ReportParameterMap>, Serializable
{	
	private static final long serialVersionUID = -1062909233052733241L;
	
	/**
	 * @uml.property  name="report"
	 * @uml.associationEnd  
	 */
	private Report report;
	/**
	 * @uml.property  name="reportParameter"
	 * @uml.associationEnd  
	 */
	private ReportParameter reportParameter;
	/**
	 * @uml.property  name="required"
	 */
	private boolean required;
	/**
	 * @uml.property  name="sortOrder"
	 */
	private int sortOrder;
	/**
	 * @uml.property  name="step"
	 */
	private int step;

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
	 * @uml.property  name="reportParameter"
	 */
	public ReportParameter getReportParameter()
	{
		return reportParameter;
	}

	/**
	 * @param reportParameter
	 * @uml.property  name="reportParameter"
	 */
	public void setReportParameter(ReportParameter reportParameter)
	{
		this.reportParameter = reportParameter;
	}

	/**
	 * @return
	 * @uml.property  name="required"
	 */
	public boolean isRequired()
	{
		return required;
	}

	/**
	 * @param required
	 * @uml.property  name="required"
	 */
	public void setRequired(boolean required)
	{
		this.required = required;
	}

	/**
	 * @return
	 * @uml.property  name="sortOrder"
	 */
	public int getSortOrder()
	{
		return sortOrder;
	}

	/**
	 * @param sortOrder
	 * @uml.property  name="sortOrder"
	 */
	public void setSortOrder(int sortOrder)
	{
		this.sortOrder = sortOrder;
	}	
	
	public int compareTo(ReportParameterMap rpMap)
	{		
		// sort by step and then sortOrder
		
		int compare = new Integer(step).compareTo(new Integer(rpMap.getStep()));
		
		if (compare == 0)
		{
			compare = new Integer(sortOrder).compareTo(new Integer(rpMap.getSortOrder()));
		}
		
		return compare;
	}
	
	/**
	 * @return
	 * @uml.property  name="step"
	 */
	public int getStep()
	{
		return step;
	}

	/**
	 * @param step
	 * @uml.property  name="step"
	 */
	public void setStep(int step)
	{
		this.step = step;
	}

}