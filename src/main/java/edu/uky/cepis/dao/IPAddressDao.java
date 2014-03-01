/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.List;
import java.util.Set;

import edu.uky.cepis.domain.IPAddress;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 *
 */
public interface IPAddressDao {
	

	/**
	 * 
	 * Get the recent IP Address information from which the user logged in.<br/>
	 * It includes other client information for log.<br/>
	 * <br/>
	 * 
	 * @param user
	 * @return IPAddress object
	 * @see IPAddress
	 * @see User
	 */
	public abstract IPAddress getRecentUserIPAddressInfo(User user);
	/**
	 * Add recent login information of an user to the database.<br/>
	 * <br/>
	 * @param ipAddr
	 * @param user
	 * @see IPAddress
	 * @see User
	 */
	public abstract void addIPAddressToUserAccount(IPAddress ipAddr, User user);
	/**
	 * Get the list of User logged in from a particular IP Address<br/>
	 * Created for ROLE_ADMINISTRATOR<br/>
	 * 
	 * <br/>
	 * @param ipAddr
	 * @return Set
	 * @see IPAddress
	 * @see User
	 */
	public abstract List<User> getUserIPAddressStatistics(IPAddress ipAddr);
	
	/**
	 * Get the list pf IP Address from which an user logged in.<br/>
	 * <br/>
	 * @param user
	 * @return Set
	 * @see IPAddress
	 * @see User
	 */
	public abstract List<IPAddress> getUserIPAddressInfo(User user);
	
}
