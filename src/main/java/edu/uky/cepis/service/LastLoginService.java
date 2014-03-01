/**
 * 
 */
package edu.uky.cepis.service;



import java.util.List;
import edu.uky.cepis.domain.LastLogin;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 *
 */
public interface LastLoginService {
	

	public abstract LastLogin getRecentUserLastLoginInfo(User user);
	public abstract void addLastLoginToUserAccount(LastLogin lastLogin, User user);
	public abstract List<User> getUserLastLoginStatistics(LastLogin lastLogin);
	public abstract List<LastLogin> getUserLastLoginInfo(User user);

}
