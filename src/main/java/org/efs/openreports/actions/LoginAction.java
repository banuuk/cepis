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

package org.efs.openreports.actions;

import java.util.Map;
import javax.servlet.http.HttpSession;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.uky.cepis.manager.UserManager;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.efs.openreports.ORStatics;
import org.efs.openreports.objects.ReportUser;
import org.efs.openreports.providers.ProviderException;
import org.efs.openreports.providers.UserProvider;
import org.efs.openreports.util.LocalStrings;
import org.springframework.security.core.Authentication;

/**
 * @author keerthi
 */
public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;

	private Map<Object, Object> session;

	/**
	 * @uml.property name="userName"
	 */
	protected String userName;

	/**
	 * @uml.property name="userProvider"
	 * @uml.associationEnd
	 */
	protected UserProvider userProvider;

	@Override
	public String execute() {
		System.out.println("Calling Login Action");
		HttpSession cepisSession = ServletActionContext.getRequest()
				.getSession();
		UserManager userManager = (UserManager) cepisSession
				.getAttribute("scopedTarget.cepisUserManager");
		if (userManager == null) {
			addActionError(getText(LocalStrings.ERROR_LOGIN_INCOMPLETE));
			return INPUT;
		}
		System.out.println(userManager.getUser());
		Authentication auth = userManager.getAuth();
		if (auth == null) {
			addActionError(getText(LocalStrings.ERROR_LOGIN_INCOMPLETE));
			return INPUT;
		}
		userName = auth.getName();
		if (userName == null || userName.length() < 1) {
			addActionError(getText(LocalStrings.ERROR_LOGIN_INCOMPLETE));
			return INPUT;
		}

		try {
			ReportUser user = checkCredentials();

			if (user == null) {
				addActionError(getText(LocalStrings.ERROR_LOGIN_INVALID));
				return INPUT;
			}

			session.put("user", user);
			ActionContext.getContext().setLocale(user.getLocale());

			if (user.isDashboardUser()
					&& (user.getDefaultReport() != null || user.getAlerts()
							.size() > 0)) {
				return ORStatics.DASHBOARD_ACTION;
			}

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.toString());
			return INPUT;
		}
	}

	/**
	 * checkCredentials - override this method to customize login authentication
	 * 
	 * @return ReportUser, if credentials in order, null otherwise
	 * @throws ProviderException
	 */
	protected ReportUser checkCredentials() throws ProviderException {
		return userProvider.getUser(userName);
	}

	@SuppressWarnings("unchecked")
	public void setSession(Map session) {
		this.session = session;
	}

	/**
	 * @return
	 * @uml.property name="userName"
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 * @uml.property name="userName"
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @param userProvider
	 * @uml.property name="userProvider"
	 */
	public void setUserProvider(UserProvider userProvider) {
		this.userProvider = userProvider;
	}

}