/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.List;
import edu.uky.cepis.domain.LastLogin;
import edu.uky.cepis.domain.User;



public interface LastLoginDao {
	
	/**
	 * Add the recent Last Login information to the User account<br/>
	 * <br/>
	 * @param lastLogin
	 * @param user
	 * @see User
	 * @see LastLogin
	 */
	public abstract void addLastLoginToUserAccount(LastLogin lastLogin,User user);
	
	/**
	 * Retrieve the recent Login information to the User<br/>
	 * <br/>
	 * @param user
	 * @return LastLogin
	 * @see User
	 * @see LastLogin
	 */
	public abstract LastLogin getRecentUserLastLoginInfo(User user);
	
	/**
	 * Retrieve the List of USer who logged in at a particular time mentioned in LastLogin object<br/>
	 * <br/>
	 * @param lastLogin
	 * @return Set
	 * @see User
	 * @see LastLogin
	 */
	public abstract List<User> getUserLastLoginStatistics(LastLogin lastLogin);
	
	/**
	 * Retrieve the list of Login information of an user<br/>
	 * <br/>
	 * @param user
	 * @return Set
	 * @see User
	 * @see LastLogin
	 */
	public abstract List<LastLogin> getUserLastLoginInfo(User user);
}
