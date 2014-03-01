/**
 * 
 */
package edu.uky.cepis.view;


import edu.uky.cepis.service.IPAddressService;
import edu.uky.cepis.service.LastLoginService;
import edu.uky.cepis.service.UserService;
import edu.uky.cepis.service.WorkingSetService;

/**
 * @author keerthi
 */
public interface CepisView {

	void setLastLoginService(LastLoginService lastLoginService);

	LastLoginService getLastLoginService();

	void setWorkingSetService(WorkingSetService workingSetService);

	WorkingSetService getWorkingSetService();

	void setIpAddressService(IPAddressService ipAddressService);

	IPAddressService getIpAddressService();

	void setUserService(UserService userService);

	UserService getUserService();

}
