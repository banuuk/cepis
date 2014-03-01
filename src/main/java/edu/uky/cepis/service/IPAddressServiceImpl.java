/**
 * 
 */
package edu.uky.cepis.service;



import java.util.List;

import edu.uky.cepis.dao.IPAddressDao;
import edu.uky.cepis.domain.IPAddress;
import edu.uky.cepis.domain.User;

/**
 * @author  keerthi
 */
public class IPAddressServiceImpl implements IPAddressService {

	/**
	 * @uml.property  name="ipAddressDao"
	 * @uml.associationEnd  
	 */
	private IPAddressDao ipAddressDao = null;

	/**
	 * @return  the userDao
	 * @uml.property  name="ipAddressDao"
	 */
	public IPAddressDao getIpAddressDao() {
		return ipAddressDao;
	}

	/**
	 * @param userDao  the userDao to set
	 * @uml.property  name="ipAddressDao"
	 */
	public void setIpAddressDao(IPAddressDao ipAddressDao) {
		this.ipAddressDao = ipAddressDao;
	}

	@Override
	public void addIPAddressToUserAccount(IPAddress ipAddr, User user) {
		ipAddressDao.addIPAddressToUserAccount(ipAddr, user);
		
	}

	@Override
	public IPAddress getRecentUserIPAddressInfo(User user) {
		
		return ipAddressDao.getRecentUserIPAddressInfo(user);
	}

	@Override
	public List<User> getUserIPAddressStatistics(IPAddress ipAddr) {
		
		return ipAddressDao.getUserIPAddressStatistics(ipAddr);
	}

	@Override
	public List<IPAddress> getUserIPAddressInfo(User user) {
		return ipAddressDao.getUserIPAddressInfo(user);
	}

}
