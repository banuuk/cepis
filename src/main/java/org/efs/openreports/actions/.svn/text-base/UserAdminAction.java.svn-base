/*
 * Copyright (C) 2003 Erik Swenson - erik@oreports.com
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

package org.efs.openreports.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.efs.openreports.ORStatics;
import org.efs.openreports.objects.ReportAlert;
import org.efs.openreports.objects.ReportUser;
import org.efs.openreports.providers.AlertProvider;
import org.efs.openreports.providers.ReportProvider;
import org.efs.openreports.providers.UserProvider;
import org.efs.openreports.util.LocalStrings;

/**
 * @author  keerthi
 */
public class UserAdminAction extends ActionSupport 
{	
	private static final long serialVersionUID = -742374952000952147L;

	protected static Logger log = Logger.getLogger(UserAdminAction.class);
	
	/**
	 * @uml.property  name="submitType"
	 */
	private String submitType;
	
	/**
	 * @uml.property  name="id"
	 */
	private int id;
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	/**
	 * @uml.property  name="password"
	 */
	private String password;
	/**
	 * @uml.property  name="passwordConfirm"
	 */
	private String passwordConfirm;
	/**
	 * @uml.property  name="email"
	 */
	private String email;
	/**
	 * @uml.property  name="reportId"
	 */
	private int reportId;
	/**
	 * @uml.property  name="reports"
	 */
	private Set reports;
		
	/**
	 * @uml.property  name="userProvider"
	 * @uml.associationEnd  
	 */
	private UserProvider userProvider;
	/**
	 * @uml.property  name="reportProvider"
	 * @uml.associationEnd  
	 */
	private ReportProvider reportProvider;
	/**
	 * @uml.property  name="alertProvider"
	 * @uml.associationEnd  
	 */
	private AlertProvider alertProvider;
	
	public String execute()
	{
		ReportUser user =
		(ReportUser) ActionContext.getContext().getSession().get(
				ORStatics.REPORT_USER);
		
		reports = user.getReports();

		try
		{
			if (submitType == null)
			{		
				id = user.getId().intValue();
				name = user.getName();
				password = user.getPassword();
				passwordConfirm = user.getPassword();				
				email = user.getEmail();
				
				if (user.getDefaultReport() != null)
				{
					reportId = user.getDefaultReport().getId().intValue();
				}
											
				return INPUT;
			}			
			
			if (!password.equals(passwordConfirm))
			{
				addActionError(LocalStrings.ERROR_INVALID_PASSWORD);
				return INPUT;
			}

			user.setName(name);
			user.setPassword(password);	
			user.setEmail(email);	
			
			if (reportId > 0)
			{
				user.setDefaultReport(reportProvider.getReport(new Integer(reportId)));
			}
			else
			{
				user.setDefaultReport(null);
			}
									
			userProvider.updateUser(user);
			
			if (user.isDashboardUser()) return ORStatics.DASHBOARD_ACTION;
			
			return SUCCESS;
		}
		catch (Exception e)
		{
			addActionError(e.toString());
			return INPUT;
		}
	}

	/**
	 * @return
	 * @uml.property  name="password"
	 */
	public String getPassword()
	{
		return password;
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
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param password
	 * @uml.property  name="password"
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * @param submitType
	 * @uml.property  name="submitType"
	 */
	public void setSubmitType(String submitType)
	{
		this.submitType = submitType;
	}

	/**
	 * @param name
	 * @uml.property  name="name"
	 */
	public void setName(String name)
	{
		this.name = name;
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
	 * @uml.property  name="email"
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email
	 * @uml.property  name="email"
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * @return
	 * @uml.property  name="passwordConfirm"
	 */
	public String getPasswordConfirm()
	{
		return passwordConfirm;
	}

	/**
	 * @param passwordConfirm
	 * @uml.property  name="passwordConfirm"
	 */
	public void setPasswordConfirm(String passwordConfirm)
	{
		this.passwordConfirm = passwordConfirm;
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
	 * @uml.property  name="reportId"
	 */
	public int getReportId()
	{
		return reportId;
	}

	/**
	 * @param reportId
	 * @uml.property  name="reportId"
	 */
	public void setReportId(int reportId)
	{
		this.reportId = reportId;
	}

	/**
	 * @return
	 * @uml.property  name="reports"
	 */
	public Set getReports()
	{
		return reports;
	}
	
	public List getAlerts()
	{
		try
		{
			return alertProvider.getReportAlerts();
		}
		catch (Exception e)
		{
			addActionError(e.toString());
			return null;
		}
	}
	
	public String[] getOperators()
	{
		return new String[] {ReportAlert.OPERATOR_EQUAL, ReportAlert.OPERATOR_GREATER, ReportAlert.OPERATOR_LESS};
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
	 * @param alertProvider
	 * @uml.property  name="alertProvider"
	 */
	public void setAlertProvider(AlertProvider alertProvider)
	{
		this.alertProvider = alertProvider;
	}
}