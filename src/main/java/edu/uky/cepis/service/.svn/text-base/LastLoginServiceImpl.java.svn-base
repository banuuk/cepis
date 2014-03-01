/**
 * 
 */
package edu.uky.cepis.service;




import java.util.List;

import edu.uky.cepis.dao.LastLoginDao;
import edu.uky.cepis.domain.LastLogin;
import edu.uky.cepis.domain.User;


/**
 * @author  keerthi
 */
public class LastLoginServiceImpl implements LastLoginService {

	/**
	 * @uml.property  name="lastLoginDao"
	 * @uml.associationEnd  
	 */
	private LastLoginDao lastLoginDao = null;

	/**
	 * @return  the lastLoginDao
	 * @uml.property  name="lastLoginDao"
	 */
	public LastLoginDao getLastLoginDao() {
		return lastLoginDao;
	}

	/**
	 * @param lastLoginDao  the lastLoginDao to set
	 * @uml.property  name="lastLoginDao"
	 */
	public void setLastLoginDao(LastLoginDao lastLoginDao) {
		this.lastLoginDao = lastLoginDao;
	}

	@Override
	public void addLastLoginToUserAccount(LastLogin lastLogin,User user) {
		lastLoginDao.addLastLoginToUserAccount(lastLogin,user);

	}

	@Override
	public LastLogin getRecentUserLastLoginInfo(User user) {
		return lastLoginDao.getRecentUserLastLoginInfo(user);

	}
	@Override
	public List<User> getUserLastLoginStatistics(LastLogin lastLogin){
		return lastLoginDao.getUserLastLoginStatistics(lastLogin);
	}

	@Override
	public List<LastLogin> getUserLastLoginInfo(User user) {
		return lastLoginDao.getUserLastLoginInfo(user);
	}

}
