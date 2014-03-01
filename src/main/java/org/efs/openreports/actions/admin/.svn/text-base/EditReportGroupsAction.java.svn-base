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

package org.efs.openreports.actions.admin;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.efs.openreports.ORStatics;
import org.efs.openreports.objects.*;
import org.efs.openreports.providers.*;

/**
 * @author  keerthi
 */
public class EditReportGroupsAction	extends ActionSupport implements SessionAware
{	
	private static final long serialVersionUID = 949119678219163746L;

	protected static Logger log = Logger.getLogger(EditReportGroupsAction.class);
	
	private Map<Object,Object> session;

	/**
	 * @uml.property  name="id"
	 */
	private int id;
	/**
	 * @uml.property  name="groupIds"
	 */
	private int[] groupIds = new int[0];

	/**
	 * @uml.property  name="submitType"
	 */
	private String submitType;

	/**
	 * @uml.property  name="report"
	 * @uml.associationEnd  
	 */
	private Report report;
	
	/**
	 * @uml.property  name="groups"
	 */
	private List groups;
	/**
	 * @uml.property  name="groupsForReport"
	 */
	private List groupsForReport;

	/**
	 * @uml.property  name="reportProvider"
	 * @uml.associationEnd  
	 */
	private ReportProvider reportProvider;
	/**
	 * @uml.property  name="groupProvider"
	 * @uml.associationEnd  
	 */
	private GroupProvider groupProvider;
	/**
	 * @uml.property  name="userProvider"
	 * @uml.associationEnd  
	 */
	private UserProvider userProvider;

	public String execute()
	{
		try
		{
			report = reportProvider.getReport(new Integer(id));
			groupsForReport = groupProvider.getGroupsForReport(report);
			groups = groupProvider.getReportGroups();			

			if (submitType == null) return INPUT;		
			
			Iterator iterator = groups.iterator();
			while(iterator.hasNext())
			{
				ReportGroup group = (ReportGroup) iterator.next();

				boolean reportInGroup = false;
				
				for (int i = 0; i < groupIds.length; i++)
				{
					if (group.getId().equals(new Integer(groupIds[i])))
					{
						reportInGroup = true;
						
						if (!group.isValidReport(report))
						{
							group.getReports().add(report);
							groupProvider.updateReportGroup(group);
						}
					}
				}
				
				if (!reportInGroup)
				{					
					for (int i=0; i < group.getReports().size(); i++)
					{					
						Report groupReport = (Report) group.getReports().get(i);
						if (groupReport.getId().equals(report.getId()))
						{
							group.getReports().remove(groupReport);	
							groupProvider.updateReportGroup(group);	
							
							i=0;
						}
					}						
				}
			}	
			
			//refresh current user
			ReportUser user = (ReportUser) ActionContext.getContext().getSession().get(ORStatics.REPORT_USER);		
			if (user != null)
			{
				user = userProvider.getUser(user.getId());
				session.put(ORStatics.REPORT_USER, user);
			}

			return SUCCESS;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			addActionError(e.toString());
			return INPUT;
		}
	}

	/**
	 * @return
	 * @uml.property  name="id"
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id
	 * @uml.property  name="id"
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return
	 * @uml.property  name="groupsForReport"
	 */
	public List getGroupsForReport()
	{
		return groupsForReport;
	}

	/**
	 * @return
	 * @uml.property  name="groups"
	 */
	public List getGroups()
	{
		return groups;
	}		

	/**
	 * @param reportProvider
	 * @uml.property  name="reportProvider"
	 */
	public void setReportProvider(ReportProvider reportProvider)
	{
		this.reportProvider = reportProvider;
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
	 * @param groupProvider
	 * @uml.property  name="groupProvider"
	 */
	public void setGroupProvider(GroupProvider groupProvider)
	{
		this.groupProvider = groupProvider;		
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
	 * @uml.property  name="groupIds"
	 */
	public int[] getGroupIds()
	{
		return groupIds;
	}

	/**
	 * @param groupIds
	 * @uml.property  name="groupIds"
	 */
	public void setGroupIds(int[] groupIds)
	{
		this.groupIds = groupIds;
	}

	/**
	 * @return
	 * @uml.property  name="submitType"
	 */
	public String getSubmitType()
	{
		return submitType;
	}

	/**
	 * @param submitType
	 * @uml.property  name="submitType"
	 */
	public void setSubmitType(String submitType)
	{
		this.submitType = submitType;
	}

	@SuppressWarnings("unchecked")
	public void setSession(Map session)
	{
		this.session = session;
	}
	
}