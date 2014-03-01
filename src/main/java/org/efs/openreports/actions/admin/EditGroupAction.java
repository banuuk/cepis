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

package org.efs.openreports.actions.admin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;
import org.efs.openreports.ORStatics;
import org.efs.openreports.objects.ORTag;
import org.efs.openreports.objects.Report;
import org.efs.openreports.objects.ReportGroup;
import org.efs.openreports.objects.ReportUser;
import org.efs.openreports.providers.*;

/**
 * @author  keerthi
 */
public class EditGroupAction extends ActionSupport  implements SessionAware
{	
	private static final long serialVersionUID = 139626346269860245L;
	
	/**
	 * @uml.property  name="command"
	 */
	private String command;
	private boolean submitOk;	
	private boolean submitDuplicate;

	private Map<Object, Object> session;
	
	/**
	 * @uml.property  name="id"
	 */
	private int id;
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	/**
	 * @uml.property  name="description"
	 */
	private String description;
    /**
	 * @uml.property  name="tags"
	 */
    private String tags;
    /**
	 * @uml.property  name="tagList"
	 */
    private String tagList;

	/**
	 * @uml.property  name="reportGroup"
	 * @uml.associationEnd  
	 */
	private ReportGroup reportGroup;
	/**
	 * @uml.property  name="reportIds"
	 */
	private int[] reportIds;

	/**
	 * @uml.property  name="groupProvider"
	 * @uml.associationEnd  
	 */
	private GroupProvider groupProvider;
	/**
	 * @uml.property  name="reportProvider"
	 * @uml.associationEnd  
	 */
	private ReportProvider reportProvider;
	/**
	 * @uml.property  name="userProvider"
	 * @uml.associationEnd  
	 */
	private UserProvider userProvider;
    /**
	 * @uml.property  name="tagProvider"
	 * @uml.associationEnd  
	 */
    private TagProvider tagProvider;

	public String execute()
	{
		try
		{
			if (command.equals("edit"))
			{
				reportGroup = groupProvider.getReportGroup(new Integer(id));
			}
			else
			{
				reportGroup = new ReportGroup();
			}

			if (command.equals("edit") && !submitOk && !submitDuplicate)
			{
				name = reportGroup.getName();
				description = reportGroup.getDescription();
                tags = tagProvider.getTagsForObject(reportGroup.getId(), ReportGroup.class, ORTag.TAG_TYPE_UI);                
                reportIds = null;                  
			}

            tagList = tagProvider.getTagList(ReportGroup.class, ORTag.TAG_TYPE_UI);
            
			if (!submitOk && !submitDuplicate)	return INPUT;
			
			 if (submitDuplicate)
	            {
	            	command = "add";
	            	reportGroup.setId(null);
	            	
	            	if (reportGroup.getName().equals(name))
	            	{
	            		name = "Copy of ".concat(name);
	            	}
	            }

			reportGroup.setName(name);
			reportGroup.setDescription(description);
			reportGroup.setReports(convertIdsToReports(reportIds));
            
			if (command.equals("edit"))
			{
				groupProvider.updateReportGroup(reportGroup);               
			}

			if (command.equals("add"))
			{
				reportGroup = groupProvider.insertReportGroup(reportGroup);
			}
            
            // save tags
            tagProvider.setTags(reportGroup.getId(), ReportGroup.class, tags, ORTag.TAG_TYPE_UI);
			
			// refresh current user 
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
			addActionError(e.toString());
			return INPUT;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void setSession(Map session) 
	{
		this.session = session;
	}
    
    /**
	 * @return
	 * @uml.property  name="tagList"
	 */
    public String getTagList()
    {
        return tagList;
    }
    
    public String getTags(Integer reportId)
    {
        try
        {
            return tagProvider.getTagsForObject(reportId, Report.class, ORTag.TAG_TYPE_UI);           
        }
        catch(Exception e)
        {
            addActionError(e.toString());
            return null;
        }
    }

	/**
	 * @return
	 * @uml.property  name="command"
	 */
	public String getCommand()
	{
		return command;
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
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param command
	 * @uml.property  name="command"
	 */
	public void setCommand(String command)
	{
		this.command = command;
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
	 * @param name
	 * @uml.property  name="name"
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	public void setSubmitOk(String submitOk)
	{
		if (submitOk != null) this.submitOk = true;
	}	
	
	public void setSubmitDuplicate(String submitDuplicate)
	{
		if (submitDuplicate != null) this.submitDuplicate = true;
	}

	public List getReports()
	{
		try
		{
			return reportProvider.getReports();
		}
		catch (Exception e)
		{
			addActionError(e.getMessage());
			return null;
		}
	}

	public List getReportsInGroup()
	{  
        if (reportGroup.getReports() != null)
        {
            Collections.sort(reportGroup.getReports());
        }
        return reportGroup.getReports();
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
	 * @uml.property  name="reportIds"
	 */
	public int[] getReportIds()
	{
		return reportIds;
	}

	/**
	 * @param reportIds
	 * @uml.property  name="reportIds"
	 */
	public void setReportIds(int[] reportIds)
	{
		this.reportIds = reportIds;
	}

	private List<Report> convertIdsToReports(int[] ids)
	{
		if (ids == null)
			return null;

		List<Report> reports = new ArrayList<Report>();

		try
		{
			for (int i = 0; i < ids.length; i++)
			{
				Report report = reportProvider.getReport(new Integer(ids[i]));
				reports.add(report);
			}
		}
		catch (Exception e)
		{
			addActionError(e.toString());
		}

		return reports;
	}
    
	/**
	 * @return
	 * @uml.property  name="tags"
	 */
	public String getTags() 
    {
	    return tags;
    }
        
	/**
	 * @param tags
	 * @uml.property  name="tags"
	 */
	public void setTags(String tags)
    {
	    this.tags = tags;
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
	 * @param reportProvider
	 * @uml.property  name="reportProvider"
	 */
	public void setReportProvider(ReportProvider reportProvider)
	{
		this.reportProvider = reportProvider;
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
	 * @param tagProvider
	 * @uml.property  name="tagProvider"
	 */
    public void setTagProvider(TagProvider tagProvider) 
    {
        this.tagProvider = tagProvider;
    }

}