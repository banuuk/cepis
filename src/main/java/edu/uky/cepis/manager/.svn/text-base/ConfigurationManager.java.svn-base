/**
 * 
 */
package edu.uky.cepis.manager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import edu.uky.cepis.domain.IPAddress;
import edu.uky.cepis.domain.LastLogin;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.WorkingSet;
import edu.uky.cepis.service.IPAddressService;
import edu.uky.cepis.service.LastLoginService;
import edu.uky.cepis.service.UserService;
import edu.uky.cepis.service.WorkingSetService;

/**
 * ConfigurationManager for CEPIS system - maintain a session wide User
 * configuration information.<br/>
 * This session bean can be accessed using
 * scopedTarget.cepisConfigurationManager from Httpsession<br/>
 * 
 * @author keerthi
 */
public class ConfigurationManager extends CEPISManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WorkingSet myWorkingSet;
	private WorkingSet selectedWorkingSet;
	private User selectedUser;
	private boolean isActiveWSPublic;
	private boolean isActiveWSShared;
	private boolean allowPublicWSAdd;
	private boolean allowPublicWSRemove;
	private LastLogin lastLogin;
	private LastLogin currentLogin;
	private String recentOperation;
	private Date recentOperationTime;
	private IPAddress ipAddress;
	private int rowCount = 25;
	private int searchCount = 200;
	private static Logger logger = Logger.getLogger(ConfigurationManager.class);
	private PropertyChangeSupport changes = new PropertyChangeSupport(this);

	/**
	 * @return the isActiveWSPublic
	 */
	public boolean isActiveWSPublic() {
		return isActiveWSPublic;
	}

	/**
	 * @return the isActiveWSShared
	 */
	public boolean isActiveWSShared() {
		return isActiveWSShared;
	}

	/**
	 * @return the allowPublicWSAdd
	 */
	public boolean isAllowPublicWSAdd() {
		return allowPublicWSAdd;
	}

	/**
	 * @return the allowPublicWSRemove
	 */
	public boolean isAllowPublicWSRemove() {
		return allowPublicWSRemove;
	}

	/**
	 * @param isActiveWSPublic
	 *            the isActiveWSPublic to set
	 */
	public void setActiveWSPublic(boolean isActiveWSPublic) {
		this.isActiveWSPublic = isActiveWSPublic;
	}

	/**
	 * @param isActiveWSShared
	 *            the isActiveWSShared to set
	 */
	public void setActiveWSShared(boolean isActiveWSShared) {
		this.isActiveWSShared = isActiveWSShared;
	}

	/**
	 * @param allowPublicWSAdd
	 *            the allowPublicWSAdd to set
	 */
	public void setAllowPublicWSAdd(boolean allowPublicWSAdd) {
		this.allowPublicWSAdd = allowPublicWSAdd;
	}

	/**
	 * @param allowPublicWSRemove
	 *            the allowPublicWSRemove to set
	 */
	public void setAllowPublicWSRemove(boolean allowPublicWSRemove) {
		this.allowPublicWSRemove = allowPublicWSRemove;
	}

	public ConfigurationManager() {
		if (logger.isDebugEnabled()) {
			logger.debug("Creating ConfigurationManager object ...");
		}
	}

	public boolean init(Properties properties) {
		LastLoginService lastLoginService = (LastLoginService) properties
				.get("LastLoginService");
		IPAddressService ipAddressService = (IPAddressService) properties
				.get("IPAddressService");
		WorkingSetService workingSetService = (WorkingSetService) properties
				.get("WorkingSetService");
		UserService userService = (UserService) properties.get("UserService");
		User currentUser = (User) properties.get("User");
		if (logger.isDebugEnabled()) {
			logger.debug("Initializing ConfigurationManager object ...");
		}
		return this.initConfigurationManager(currentUser, userService,
				lastLoginService, ipAddressService, workingSetService);
	}

	public boolean initConfigurationManager(User user, UserService userService,
			LastLoginService lastLoginService,
			IPAddressService ipAddressService,
			WorkingSetService workingSetService) {
		if (this.getUser() == null) {
			this.setUser(user);
			this.setSelectedUser(user);
		}
		if (this.getUser() == null) {
			if (logger.isDebugEnabled()) {
				logger.debug("Illegal Access: User not initialized properly. Please check whether the UserManger object is initialized properly in the previous step.");

			}
			return false;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Initializing My Working Set for "
					+ this.getUser().getUsername() + " ...");

		}
		WorkingSet myWS = workingSetService.retrieveMyWorkingSet(this.getUser()
				.getUid());
		this.setMyWorkingSet(myWS);
		if (logger.isDebugEnabled()) {
			logger.debug("Loading default configuration for "
					+ this.getUser().getUsername() + " ...");

		}
		if (this.getUser().getUserConfiguration() == null) {
			if (logger.isDebugEnabled()) {
				logger.debug("No default configuration found for "
						+ this.getUser().getUsername()
						+ ". Creating a default configuration profile ...");

			}
			// Create new user configuration for this user
			this.getUser().setUserConfiguration(
					userService.createUserConfiguration(this.getUser(),
							this.getMyWorkingSet(), null, null, null, null,
							false));
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Recording recent account activities for "
					+ this.getUser().getUsername() + " ...");

		}
		this.setLastLogin(lastLoginService.getRecentUserLastLoginInfo(this
				.getUser()));
		this.setCurrentLogin(new LastLogin(new Date()));
		// Set the Last login information
		WebAuthenticationDetails auth_details = (WebAuthenticationDetails) SecurityContextHolder
				.getContext().getAuthentication().getDetails();
		if (auth_details == null) {
			return false;
		}
		InetAddress inet = null;
		try {
			inet = InetAddress.getByName(auth_details.getRemoteAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return false;
		}
		if (inet == null) {
			return false;
		}
		// Add Recent login info
		lastLoginService.addLastLoginToUserAccount(this.getCurrentLogin(),
				this.getUser());
		IPAddress ipAddr = new IPAddress(auth_details.getRemoteAddress() + ":"
				+ inet.getHostName(),
				((HttpServletRequest) FacesContext.getCurrentInstance()
						.getExternalContext().getRequest())
						.getHeader("User-Agent"));
		// Add Recent IPAddress info
		ipAddressService.addIPAddressToUserAccount(ipAddr, this.getUser());

		// User-defined Properties
		if (logger.isDebugEnabled()) {
			logger.debug("Loading default/user-defined properties ...");
		}
		// Initialize the active working set or create new one
		// Active Working Set is a buffer working set to store temporary users
		if (this.getUser().getUserConfiguration().isRememberLastWorkingSet()) {
			// recover the last opened working set
			this.setSelectedWorkingSet(workingSetService
					.getLastOpenedWorkingSetInUserConfiguration(this.getUser()));
		} else {
			workingSetService.setWorkingSetUsersList(myWorkingSet,
					new HashSet<User>(0));
			this.setSelectedWorkingSet(this.getMyWorkingSet());
			this.isActiveWSPublic = false;
			this.isActiveWSShared = false;
			System.out.println(this.getSelectedWorkingSet().getName());
		}
		int count = this.getUser().getUserConfiguration().getRowCount();
		if (count > 0) {
			this.rowCount = count;
		}

		count = this.getUser().getUserConfiguration().getSearchCount();
		if (count > 0) {
			this.searchCount = count;
		}

		this.setRecentOperation(new String("User "
				+ this.getUser().getUsername() + " logged in"));
		return true;
	}

	/**
	 * @return the activeWorkingSet
	 * @uml.property name="myWorkingSet"
	 */
	public WorkingSet getMyWorkingSet() {
		return myWorkingSet;
	}

	/**
	 * @param activeWorkingSet
	 *            the activeWorkingSet to set
	 * @uml.property name="myWorkingSet"
	 */
	protected void setMyWorkingSet(WorkingSet myWorkingSet) {
		this.myWorkingSet = myWorkingSet;
	}

	/**
	 * @return the lastLogin
	 * @uml.property name="lastLogin"
	 */
	public LastLogin getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin
	 *            the lastLogin to set
	 * @uml.property name="lastLogin"
	 */
	private void setLastLogin(LastLogin lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * @param currentLogin
	 *            the currentLogin to set
	 * @uml.property name="currentLogin"
	 */
	public void setCurrentLogin(LastLogin currentLogin) {
		this.currentLogin = currentLogin;
	}

	/**
	 * @return the currentLogin
	 * @uml.property name="currentLogin"
	 */
	public LastLogin getCurrentLogin() {
		return currentLogin;
	}

	/**
	 * @return the recentOperation
	 * @uml.property name="recentOperation"
	 */
	public String getRecentOperation() {
		return recentOperation;
	}

	/**
	 * @param recentOperation
	 *            the recentOperation to set
	 * @uml.property name="recentOperation"
	 */
	public void setRecentOperation(String recentOperation) {
		this.setRecentOperationTime(new Date());
		this.recentOperation = recentOperation;
	}

	/**
	 * @return the recentOperationTime
	 * @uml.property name="recentOperationTime"
	 */
	public Date getRecentOperationTime() {
		return recentOperationTime;
	}

	/**
	 * @param recentOperationTime
	 *            the recentOperationTime to set
	 * @uml.property name="recentOperationTime"
	 */
	protected void setRecentOperationTime(Date recentOperationTime) {
		this.recentOperationTime = recentOperationTime;
	}

	/**
	 * @return the ipAddress
	 * @uml.property name="ipAddress"
	 */
	public IPAddress getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress
	 *            the ipAddress to set
	 * @uml.property name="ipAddress"
	 */
	protected void setIpAddress(IPAddress ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getMessageSummary() {
		FacesContext context = FacesContext.getCurrentInstance();
		List<FacesMessage> messages = context.getMessageList();
		return messages.size();
	}

	public WorkingSet getSelectedWorkingSet() {
		return selectedWorkingSet;
	}

	public void setSelectedWorkingSet(WorkingSet selectedWorkingSet) {
		this.selectedWorkingSet = selectedWorkingSet;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.setRecentOperationTime(new Date());
		changes.firePropertyChange("selectedUser", this.selectedUser,
				selectedUser);
		this.selectedUser = selectedUser;
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		changes.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		changes.removePropertyChangeListener(l);
	}

	public boolean hasPropertyChangeListener(String propertyName) {
		return changes.hasListeners(propertyName);
	}

	public String getSelectedUserFullName() {
		return this.getSelectedUser().getFullName();
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getSearchCount() {
		return searchCount;
	}

	public void setSearchCount(int searchCount) {
		this.searchCount = searchCount;
	}

}
