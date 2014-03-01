/**
 * 
 */
package edu.uky.cepis.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import edu.uky.cepis.domain.LastLogin;
import edu.uky.cepis.domain.Role;
import edu.uky.cepis.view.WhoAmIView;

/**
 * View controller for display User information<br/>
 * This class will be extended in future release to hold further user
 * information<br/>
 * This class will also be used in Enrollment Management System<br/>
 * 
 * @see WhoAmIView
 * @author keerthi
 */

public class WhoAmIController extends AbstractController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(WhoAmIController.class);
	private String username;
	private WhoAmIView whoAmIBean;
	private List<Boolean> selectedItems = new ArrayList<Boolean>(0);

	public WhoAmIController() {

	}

	/**
	 * @param whoAmIBean
	 *            the whoAmIBean to set
	 * @uml.property name="whoAmIBean"
	 */
	public void setWhoAmIBean(WhoAmIView whoAmIBean) {
		this.whoAmIBean = whoAmIBean;
	}

	/**
	 * @return the whoAmIBean
	 * @uml.property name="whoAmIBean"
	 */
	public WhoAmIView getWhoAmIBean() {
		return whoAmIBean;
	}

	/**
	 * @return the userName
	 * @uml.property name="userName"
	 */
	public String getUserName() {
		if (this.getUserManager() == null)
			return null;
		return this.getUserManager().getUser().getUsername();
	}

	/**
	 * @return Role array {@link Role}
	 */
	public String[] getUserRoles() {
		Iterator<? extends GrantedAuthority> roles = SecurityContextHolder
				.getContext().getAuthentication().getAuthorities().iterator();
		Set<String> userRoles = new HashSet<String>(0);
		while (roles.hasNext()) {
			userRoles.add(roles.next().getAuthority());
		}
		return userRoles.toArray(new String[userRoles.size()]);
	}

	/**
	 * @param selectedItems
	 *            the selectedItems to set
	 * @uml.property name="selectedItems"
	 */
	public void setSelectedItems(List<Boolean> selectedItems) {
		this.selectedItems = selectedItems;
	}

	/**
	 * @return the selectedItems
	 * @uml.property name="selectedItems"
	 */
	public List<Boolean> getSelectedItems() {
		return selectedItems;
	}

	public String getClientInfo() {
		WebAuthenticationDetails checkme = (WebAuthenticationDetails) SecurityContextHolder
				.getContext().getAuthentication().getDetails();
		StringBuffer sysInfo = new StringBuffer();
		sysInfo.append("Your IP Address: " + checkme.getRemoteAddress());
		InetAddress inet;
		try {
			inet = InetAddress.getByName(checkme.getRemoteAddress());
			sysInfo.append("<br/>");
			sysInfo.append("Your Host name: " + inet.getHostName());
		} catch (UnknownHostException e) {
			System.err.println(e);
		}
		sysInfo.append("<br/>");
		sysInfo.append("Your Browser info: "
				+ ((HttpServletRequest) FacesContext.getCurrentInstance()
						.getExternalContext().getRequest())
						.getHeader("User-Agent"));
		return sysInfo.toString();
	}

	public String logOut() {
		log.debug("User " + this.getUserName() + " - logged out" + " on "
				+ new Date());
		HttpServletResponse response = ((HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse());
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.invalidate();
		Cookie terminate = new Cookie(
				TokenBasedRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY,
				null);
		terminate.setMaxAge(0);
		response.addCookie(terminate);
		return "login";
	}

	public String getPreferredName() {
		if (this.getUserManager() == null
				|| this.getUserManager().getUser() == null)
			return null;
		return this.getUserManager().getUser().getPreferredName();
	}

	public String getLastLogin() {
		LastLogin lastLoginObject = this.getConfigurationManager()
				.getLastLogin();
		if (lastLoginObject == null) {
			return "Not Available";
		}
		Date lastLogin = lastLoginObject.getLastLogin();
		return lastLogin.toString();
	}

	public String getCurrentLogin() {
		LastLogin lastLogin = this.getConfigurationManager().getCurrentLogin();
		if (lastLogin != null) {
			return lastLogin.getLastLogin().toString();
		}
		return "Not Available";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getQueryLDAPResultForUser() {
		System.out.println("Calling getQueryLDAPResultForUser");
		StringBuilder logMsg = new StringBuilder();
		if (this.getUsername() == null || this.getUsername().trim().equals("")) {
			this.setUsername(this.getUserName());
		}
		logMsg.append("Querying UK LDAP Authentication Server for "
				+ this.getUsername() + " ...");
		logMsg.append("<br/>");
		logMsg.append("------------------------------------------------");
		logMsg.append("<br/>");
		// Fetch information from uky ldap server
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://128.163.16.252:389/o=uky");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, "ou=users,o=uky");
		DirContext ctx = null;
		NamingEnumeration results = null;
		SearchResult searchResult = null;
		Attributes attrs = null;
		Attribute attr = null;
		try {
			ctx = new InitialDirContext(env);
			SearchControls controls = new SearchControls();
			controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			results = ctx.search("", "(cn=" + this.username + ")", controls);
			if (results.hasMore()) {
				logMsg.append("<br/>");
				logMsg.append("Found a matching record for the query: "
						+ this.username + ".");
				searchResult = (SearchResult) results.next();
				attrs = searchResult.getAttributes();
				// Fullname
				attr = attrs.get("displayname");
				if (attr != null) {
					logMsg.append("<br/>");
					logMsg.append("Display Name : " + attr.get(0).toString()
							+ ".");
				}
				// Username
				attr = attrs.get("userid");
				if (attr != null) {
					logMsg.append("<br/>");
					logMsg.append("Username : " + attr.get(0).toString() + ".");
				}
				// UKID
				attr = attrs.get("workforceID");
				if (attr != null) {
					logMsg.append("<br/>");
					logMsg.append("UK ID# : " + attr.get(0).toString() + ".");
				}
				// Last name
				attr = attrs.get("sn");
				if (attr != null) {
					logMsg.append("<br/>");
					logMsg.append("Last Name : " + attr.get(0).toString() + ".");
				}

				// First Name
				attr = attrs.get("givenname");
				if (attr != null) {
					logMsg.append("<br/>");
					logMsg.append("First Name : " + attr.get(0).toString()
							+ ".");
				}
				// Middle Name
				attr = attrs.get("initials");
				if (attr != null) {
					logMsg.append("<br/>");
					logMsg.append("Middle Name : " + attr.get(0).toString()
							+ ".");
				}

				// User Type
				attr = attrs.get("generationalQualifier");
				if (attr != null) {
					String gq = attr.get(0).toString();
					String code = "";
					if (gq.equalsIgnoreCase("S")) {
						code = "STU";
					} else if (gq.equalsIgnoreCase("ST")) {
						code = "STA";
					} else if (gq.equalsIgnoreCase("F")) {
						code = "FAC";
					}
					logMsg.append("<br/>");
					logMsg.append("User Type : " + code + ".");
				}

				// Primary email
				attr = attrs.get("mail");
				if (attr != null) {
					logMsg.append("<br/>");
					logMsg.append("Email Address : " + attr.get(0).toString()
							+ ".");
				}

				// Telephone No
				attr = attrs.get("telephonenumber");
				if (attr != null) {
					logMsg.append("<br/>");
					logMsg.append("Phone : " + attr.get(0).toString() + ".");
				}

				// Last login
				attr = attrs.get("logintime");
				if (attr != null) {
					logMsg.append("<br/>");
					logMsg.append("Last Login : " + attr.get(0).toString()
							+ ".");
				}
			} else {
				logMsg.append("<br/>");
				logMsg.append("------------------------------------------------");
				logMsg.append("No matching records found.");
			}
		} catch (NamingException e) {
			System.err.println(e);
			e.printStackTrace();
		} finally {
			if (ctx != null) {
				try {
					ctx.close();
				} catch (NamingException e) {
					System.err.println(e);
				}
			}
		}

		return logMsg.toString();
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}
