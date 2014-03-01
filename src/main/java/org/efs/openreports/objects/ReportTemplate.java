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
package org.efs.openreports.objects;

/**
 * @author  keerthi
 */
public class ReportTemplate 
{
	/**
	 * @uml.property  name="templateName"
	 */
	private String templateName;
	/**
	 * @uml.property  name="revisions"
	 */
	private String[] revisions;
	
	public ReportTemplate(String templateName)
	{
		this.templateName = templateName;
	}
	
	/**
	 * @return
	 * @uml.property  name="templateName"
	 */
	public String getTemplateName() 
	{
		return templateName;
	}
	
	/**
	 * @param templateName
	 * @uml.property  name="templateName"
	 */
	public void setTemplateName(String templateName) 
	{
		this.templateName = templateName;
	}
	
	/**
	 * @return
	 * @uml.property  name="revisions"
	 */
	public String[] getRevisions() 
	{
		return revisions;
	}
	
	/**
	 * @param revisions
	 * @uml.property  name="revisions"
	 */
	public void setRevisions(String[] revisions) 
	{
		this.revisions = revisions;
	}		
	
	public int getRevisionCount()
	{
		if (revisions == null) return 0;
		return revisions.length;
	}	
}
