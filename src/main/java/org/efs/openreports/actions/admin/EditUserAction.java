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

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.uky.cepis.controller.WorkingSetController;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.manager.UserManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.efs.openreports.ORStatics;
import org.efs.openreports.objects.ORTag;
import org.efs.openreports.objects.ReportAlert;
import org.efs.openreports.objects.ReportGroup;
import org.efs.openreports.objects.ReportUser;
import org.efs.openreports.providers.AlertProvider;
import org.efs.openreports.providers.GroupProvider;
import org.efs.openreports.providers.ReportProvider;
import org.efs.openreports.providers.TagProvider;
import org.efs.openreports.providers.UserProvider;
import org.efs.openreports.util.LocalStrings;

/**
 * @author  keerthi
 */
public class EditUserAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 8834872433225007194L;

	protected static Logger log = Logger.getLogger(EditUserAction.class);

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
	 * @uml.property  name="externalId"
	 */
	private String externalId;
	/**
	 * @uml.property  name="email"
	 */
	private String email;
	/**
	 * @uml.property  name="tags"
	 */
	private String tags;

	/**
	 * @uml.property  name="reportId"
	 */
	private int reportId;
	/**
	 * @uml.property  name="reports"
	 */
	private Set reports;
	/**
	 * @uml.property  name="userAlerts"
	 */
	private List userAlerts;
	/**
	 * @uml.property  name="reportGroups"
	 */
	private List<ReportGroup> reportGroups;
	/**
	 * @uml.property  name="groupIds"
	 */
	private int[] groupIds;

	/**
	 * @uml.property  name="scheduler"
	 */
	private boolean scheduler;
	/**
	 * @uml.property  name="logViewer"
	 */
	private boolean logViewer;
	/**
	 * @uml.property  name="rootAdmin"
	 */
	private boolean rootAdmin;
	/**
	 * @uml.property  name="reportAdmin"
	 */
	private boolean reportAdmin;
	/**
	 * @uml.property  name="dataSourceAdmin"
	 */
	private boolean dataSourceAdmin;
	/**
	 * @uml.property  name="parameterAdmin"
	 */
	private boolean parameterAdmin;
	/**
	 * @uml.property  name="chartAdmin"
	 */
	private boolean chartAdmin;
	/**
	 * @uml.property  name="userAdmin"
	 */
	private boolean userAdmin;
	/**
	 * @uml.property  name="groupAdmin"
	 */
	private boolean groupAdmin;
	/**
	 * @uml.property  name="alertAdmin"
	 */
	private boolean alertAdmin;
	/**
	 * @uml.property  name="dashboard"
	 */
	private boolean dashboard;
	/**
	 * @uml.property  name="alerts"
	 */
	private boolean alerts;
	/**
	 * @uml.property  name="uploader"
	 */
	private boolean uploader;
	/**
	 * @uml.property  name="schedulerAdmin"
	 */
	private boolean schedulerAdmin;
	/**
	 * @uml.property  name="advancedScheduler"
	 */
	private boolean advancedScheduler;

	/**
	 * @uml.property  name="userProvider"
	 * @uml.associationEnd  
	 */
	private UserProvider userProvider;
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
	 * @uml.property  name="alertProvider"
	 * @uml.associationEnd  
	 */
	private AlertProvider alertProvider;
	/**
	 * @uml.property  name="tagProvider"
	 * @uml.associationEnd  
	 */
	private TagProvider tagProvider;

	public String execute() {
		ReportUser user = null;

		try {
			if (command.equals("edit")) {
				user = userProvider.getUser(new Integer(id));
			} else {
				user = new ReportUser();
			}

			reports = user.getReports();
			userAlerts = user.getAlerts();

			if (command.equals("edit") && !submitOk && !submitDuplicate) {
				id = user.getId().intValue();
				name = user.getName();
				System.out.println("Editing ID: "+id+" Name: "+name);
				externalId = user.getExternalId();
				email = user.getEmail();
				reportGroups = user.getGroups();
				scheduler = user.isScheduler();
				advancedScheduler = user.isAdvancedScheduler();
				logViewer = user.isLogViewer();
				rootAdmin = user.isRootAdmin();
				reportAdmin = user.isReportAdmin();
				dataSourceAdmin = user.isDataSourceAdmin();
				parameterAdmin = user.isParameterAdmin();
				userAdmin = user.isUserAdmin();
				groupAdmin = user.isGroupAdmin();
				chartAdmin = user.isChartAdmin();
				alertAdmin = user.isAlertAdmin();
				dashboard = user.isDashboardUser();
				alerts = user.isAlertUser();
				uploader = user.isUploader();
				schedulerAdmin = user.isSchedulerAdmin();
				tags = tagProvider.getTagsForObject(user.getId(),
						ReportUser.class, ORTag.TAG_TYPE_UI);

				if (reportGroups != null)
					Collections.sort(reportGroups);

				if (user.getDefaultReport() != null) {
					reportId = user.getDefaultReport().getId().intValue();
				}

				groupIds = null;
			}

			if (!submitOk && !submitDuplicate)
				return INPUT;

			if (submitDuplicate) {
				command = "add";
				user.setId(null);
				user.setRoles(new TreeSet<String>());

				if (user.getName().equals(name)) {
					name = "Copy of ".concat(name);
				}
			}

			user.setName(name);
			user.setExternalId(externalId);
			user.setEmail(email);
			user.setGroups(convertIdsToGroups(groupIds));
			user.setAlertAdmin(alertAdmin);
			user.setChartAdmin(chartAdmin);
			user.setDataSourceAdmin(dataSourceAdmin);
			user.setGroupAdmin(groupAdmin);
			user.setLogViewer(logViewer);
			user.setParameterAdmin(parameterAdmin);
			user.setReportAdmin(reportAdmin);
			user.setRootAdmin(rootAdmin);
			user.setScheduler(scheduler);
			user.setAdvancedScheduler(advancedScheduler);
			user.setUserAdmin(userAdmin);
			user.setDashboardUser(dashboard);
			user.setAlertUser(alerts);
			user.setUploader(uploader);
			user.setSchedulerAdmin(schedulerAdmin);

			if (reportId > 0) {
				user.setDefaultReport(reportProvider.getReport(new Integer(
						reportId)));
			} else {
				user.setDefaultReport(null);
			}

			if (command.equals("edit")) {
				userProvider.updateUser(user);

				ReportUser currentUser = (ReportUser) ActionContext
						.getContext().getSession().get(ORStatics.REPORT_USER);
				if ((currentUser != null)
						&& (currentUser.getId().equals(user.getId()))) {
					session.put(ORStatics.REPORT_USER, user);
				}
			}

			if (command.equals("add")) {
				System.out.println("Changing Username");
				HttpSession cepisSession = ServletActionContext.getRequest()
						.getSession();
				WorkingSetController workingSetController = (WorkingSetController) cepisSession
						.getAttribute("scopedTarget.workingSetController");
				if(workingSetController == null){
					System.out.println("workingSetController is null");
				}
				if(workingSetController.getSelectedWSUsersList().isEmpty()){
					System.out.println("None selected");
				}
				User cepisUser = workingSetController.getSelectedWSUsersList().get(0);
				name = cepisUser.getUsername();
				user.setName(name);
				user = userProvider.insertUser(user);
			}

			tagProvider.setTags(user.getId(), ReportUser.class, tags,
					ORTag.TAG_TYPE_UI);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.toString());
			return INPUT;
		}
	}

	@SuppressWarnings("unchecked")
	public void setSession(Map session) {
		this.session = session;
	}

	public String getTags(Integer groupId) {
		try {
			return tagProvider.getTagsForObject(groupId, ReportGroup.class,
					ORTag.TAG_TYPE_UI);
		} catch (Exception e) {
			addActionError(e.toString());
			return null;
		}
	}

	/**
	 * @return
	 * @uml.property  name="command"
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * @param command
	 * @uml.property  name="command"
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	public void setSubmitOk(String submitOk) {
		if (submitOk != null)
			this.submitOk = true;
	}

	public void setSubmitDuplicate(String submitDuplicate) {
		if (submitDuplicate != null)
			this.submitDuplicate = true;
	}

	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	private List<ReportGroup> convertIdsToGroups(int[] ids) {
		if (ids == null)
			return new ArrayList<ReportGroup>();

		List<ReportGroup> groups = new ArrayList<ReportGroup>();

		try {
			for (int i = 0; i < ids.length; i++) {
				ReportGroup group = groupProvider.getReportGroup(new Integer(
						ids[i]));
				groups.add(group);
			}
		} catch (Exception e) {
			addActionError(e.toString());
		}

		return groups;
	}

	/**
	 * @return
	 * @uml.property  name="groupIds"
	 */
	public int[] getGroupIds() {
		return groupIds;
	}

	/**
	 * @param groupIds
	 * @uml.property  name="groupIds"
	 */
	public void setGroupIds(int[] groupIds) {
		this.groupIds = groupIds;
	}

	/**
	 * @return
	 * @uml.property  name="reportGroups"
	 */
	public List getReportGroups() {
		try {
			return groupProvider.getReportGroups();
		} catch (Exception e) {
			addActionError(e.getMessage());
			return null;
		}
	}

	public List getReportGroupsForUser() {
		return reportGroups;
	}

	/**
	 * @return
	 * @uml.property  name="id"
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 * @uml.property  name="id"
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param groupProvider
	 * @uml.property  name="groupProvider"
	 */
	public void setGroupProvider(GroupProvider groupProvider) {
		this.groupProvider = groupProvider;
	}

	/**
	 * @param userProvider
	 * @uml.property  name="userProvider"
	 */
	public void setUserProvider(UserProvider userProvider) {
		this.userProvider = userProvider;
	}

	/**
	 * @return
	 * @uml.property  name="email"
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 * @uml.property  name="email"
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 * @uml.property  name="externalId"
	 */
	public String getExternalId() {
		return externalId;
	}

	/**
	 * @param externalId
	 * @uml.property  name="externalId"
	 */
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	/**
	 * @return
	 * @uml.property  name="tags"
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * @param tags
	 * @uml.property  name="tags"
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * @return
	 * @uml.property  name="reportId"
	 */
	public int getReportId() {
		return reportId;
	}

	/**
	 * @param reportId
	 * @uml.property  name="reportId"
	 */
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	/**
	 * @return
	 * @uml.property  name="reports"
	 */
	public Set getReports() {
		return reports;
	}

	/**
	 * @param reportProvider
	 * @uml.property  name="reportProvider"
	 */
	public void setReportProvider(ReportProvider reportProvider) {
		this.reportProvider = reportProvider;
	}

	/**
	 * @return
	 * @uml.property  name="chartAdmin"
	 */
	public boolean isChartAdmin() {
		return chartAdmin;
	}

	/**
	 * @param chartAdmin
	 * @uml.property  name="chartAdmin"
	 */
	public void setChartAdmin(boolean chartAdmin) {
		this.chartAdmin = chartAdmin;
	}

	/**
	 * @return
	 * @uml.property  name="dataSourceAdmin"
	 */
	public boolean isDataSourceAdmin() {
		return dataSourceAdmin;
	}

	/**
	 * @param dataSourceAdmin
	 * @uml.property  name="dataSourceAdmin"
	 */
	public void setDataSourceAdmin(boolean dataSourceAdmin) {
		this.dataSourceAdmin = dataSourceAdmin;
	}

	/**
	 * @return
	 * @uml.property  name="groupAdmin"
	 */
	public boolean isGroupAdmin() {
		return groupAdmin;
	}

	/**
	 * @param groupAdmin
	 * @uml.property  name="groupAdmin"
	 */
	public void setGroupAdmin(boolean groupAdmin) {
		this.groupAdmin = groupAdmin;
	}

	/**
	 * @return
	 * @uml.property  name="logViewer"
	 */
	public boolean isLogViewer() {
		return logViewer;
	}

	/**
	 * @param logViewer
	 * @uml.property  name="logViewer"
	 */
	public void setLogViewer(boolean logViewer) {
		this.logViewer = logViewer;
	}

	/**
	 * @return
	 * @uml.property  name="parameterAdmin"
	 */
	public boolean isParameterAdmin() {
		return parameterAdmin;
	}

	/**
	 * @param parameterAdmin
	 * @uml.property  name="parameterAdmin"
	 */
	public void setParameterAdmin(boolean parameterAdmin) {
		this.parameterAdmin = parameterAdmin;
	}

	/**
	 * @return
	 * @uml.property  name="reportAdmin"
	 */
	public boolean isReportAdmin() {
		return reportAdmin;
	}

	/**
	 * @param reportAdmin
	 * @uml.property  name="reportAdmin"
	 */
	public void setReportAdmin(boolean reportAdmin) {
		this.reportAdmin = reportAdmin;
	}

	/**
	 * @return
	 * @uml.property  name="rootAdmin"
	 */
	public boolean isRootAdmin() {
		return rootAdmin;
	}

	/**
	 * @param rootAdmin
	 * @uml.property  name="rootAdmin"
	 */
	public void setRootAdmin(boolean rootAdmin) {
		this.rootAdmin = rootAdmin;
	}

	/**
	 * @return
	 * @uml.property  name="scheduler"
	 */
	public boolean isScheduler() {
		return scheduler;
	}

	/**
	 * @param scheduler
	 * @uml.property  name="scheduler"
	 */
	public void setScheduler(boolean scheduler) {
		this.scheduler = scheduler;
	}

	/**
	 * @return
	 * @uml.property  name="advancedScheduler"
	 */
	public boolean isAdvancedScheduler() {
		return advancedScheduler;
	}

	/**
	 * @param advancedScheduler
	 * @uml.property  name="advancedScheduler"
	 */
	public void setAdvancedScheduler(boolean advancedScheduler) {
		this.advancedScheduler = advancedScheduler;
	}

	/**
	 * @return
	 * @uml.property  name="userAdmin"
	 */
	public boolean isUserAdmin() {
		return userAdmin;
	}

	/**
	 * @param userAdmin
	 * @uml.property  name="userAdmin"
	 */
	public void setUserAdmin(boolean userAdmin) {
		this.userAdmin = userAdmin;
	}

	/**
	 * @return
	 * @uml.property  name="alertAdmin"
	 */
	public boolean isAlertAdmin() {
		return alertAdmin;
	}

	/**
	 * @param alertAdmin
	 * @uml.property  name="alertAdmin"
	 */
	public void setAlertAdmin(boolean alertAdmin) {
		this.alertAdmin = alertAdmin;
	}

	/**
	 * @return
	 * @uml.property  name="dashboard"
	 */
	public boolean isDashboard() {
		return dashboard;
	}

	/**
	 * @param dashboard
	 * @uml.property  name="dashboard"
	 */
	public void setDashboard(boolean dashboard) {
		this.dashboard = dashboard;
	}

	/**
	 * @return
	 * @uml.property  name="alerts"
	 */
	public boolean isAlerts() {
		return alerts;
	}

	/**
	 * @param alerts
	 * @uml.property  name="alerts"
	 */
	public void setAlerts(boolean alerts) {
		this.alerts = alerts;
	}

	/**
	 * @return
	 * @uml.property  name="uploader"
	 */
	public boolean isUploader() {
		return uploader;
	}

	/**
	 * @param uploader
	 * @uml.property  name="uploader"
	 */
	public void setUploader(boolean uploader) {
		this.uploader = uploader;
	}

	/**
	 * @return
	 * @uml.property  name="schedulerAdmin"
	 */
	public boolean isSchedulerAdmin() {
		return schedulerAdmin;
	}

	/**
	 * @param schedulerAdmin
	 * @uml.property  name="schedulerAdmin"
	 */
	public void setSchedulerAdmin(boolean schedulerAdmin) {
		this.schedulerAdmin = schedulerAdmin;
	}

	public String[] getOperators() {
		return new String[] { ReportAlert.OPERATOR_EQUAL,
				ReportAlert.OPERATOR_GREATER, ReportAlert.OPERATOR_LESS };
	}

	public List getAllAlerts() {
		try {
			return alertProvider.getReportAlerts();
		} catch (Exception e) {
			addActionError(e.toString());
			return null;
		}
	}

	/**
	 * @return
	 * @uml.property  name="userAlerts"
	 */
	public List getUserAlerts() {
		return userAlerts;
	}

	/**
	 * @param alertProvider
	 * @uml.property  name="alertProvider"
	 */
	public void setAlertProvider(AlertProvider alertProvider) {
		this.alertProvider = alertProvider;
	}

	/**
	 * @param tagProvider
	 * @uml.property  name="tagProvider"
	 */
	public void setTagProvider(TagProvider tagProvider) {
		this.tagProvider = tagProvider;
	}
}