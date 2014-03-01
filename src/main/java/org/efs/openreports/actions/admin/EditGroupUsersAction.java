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
public class EditGroupUsersAction	extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = -3762924762519626228L;

	protected static Logger log = Logger.getLogger(EditGroupUsersAction.class);
	
	private Map<Object,Object> session;

	/**
	 * @uml.property  name="id"
	 */
	private int id;
	/**
	 * @uml.property  name="userIds"
	 */
	private int[] userIds = new int[0];

	/**
	 * @uml.property  name="submitType"
	 */
	private String submitType;

	/**
	 * @uml.property  name="group"
	 * @uml.associationEnd  
	 */
	private ReportGroup group;
	
	/**
	 * @uml.property  name="users"
	 */
	private List users;
	/**
	 * @uml.property  name="usersForGroup"
	 */
	private List usersForGroup;

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
			group = groupProvider.getReportGroup(new Integer(id));
			usersForGroup = userProvider.getUsersForGroup(group);
			users = userProvider.getUsers();			

			if (submitType == null) return INPUT;		
			
			Iterator iterator = users.iterator();
			while(iterator.hasNext())
			{
				ReportUser user = (ReportUser) iterator.next();

				boolean userHasGroup = false;
				
				for (int i = 0; i < userIds.length; i++)
				{
					if (user.getId().equals(new Integer(userIds[i])))
					{
						userHasGroup = true;
						
						if (!user.isValidGroup(group))
						{
							user.getGroups().add(group);
							userProvider.updateUser(user);
						}
					}
				}
				
				if (!userHasGroup)
				{					
					for (int i=0; i < user.getGroups().size(); i++)
					{					
						ReportGroup reportGroup = user.getGroups().get(i);
						if (group.getId().equals(reportGroup.getId()))
						{
							user.getGroups().remove(reportGroup);	
							userProvider.updateUser(user);	
							
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
	 * @uml.property  name="usersForGroup"
	 */
	public List getUsersForGroup()
	{
		return usersForGroup;
	}

	/**
	 * @return
	 * @uml.property  name="users"
	 */
	public List getUsers()
	{
		return users;
	}		

	/**
	 * @return
	 * @uml.property  name="group"
	 */
	public ReportGroup getGroup()
	{
		return group;
	}

	/**
	 * @param group
	 * @uml.property  name="group"
	 */
	public void setGroup(ReportGroup group)
	{
		this.group = group;
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
	 * @uml.property  name="userIds"
	 */
	public int[] getUserIds()
	{
		return userIds;
	}

	/**
	 * @param userIds
	 * @uml.property  name="userIds"
	 */
	public void setUserIds(int[] userIds)
	{
		this.userIds = userIds;
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