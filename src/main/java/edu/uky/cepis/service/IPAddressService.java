/**
 * 
 */
package edu.uky.cepis.service;


import java.util.List;

import edu.uky.cepis.domain.IPAddress;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 *
 */
public interface IPAddressService {
	
	public abstract IPAddress getRecentUserIPAddressInfo(User user);
	public abstract void addIPAddressToUserAccount(IPAddress ipAddr, User user);
	public abstract List<User> getUserIPAddressStatistics(IPAddress ipAddr);
	public abstract List<IPAddress> getUserIPAddressInfo(User user);
}
