/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.Collection;
import edu.uky.cepis.domain.IPAddress;
import edu.uky.cepis.domain.LastLogin;
import edu.uky.cepis.domain.User;

/**
 * DAO Class that get the IPAddress information from the database <br/>
 * Implements IPAddressDao<br/>
 * 
 * @author keerthi
 * @see HibernateDaoSupport
 * @see HibernateTemplate
 * @see IPAddress
 * 
 */
public class IPAddressDaoImpl implements IPAddressDao {

	private static Logger log = Logger.getLogger(IPAddressDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.IPAddressDao#getUserIPAddressStatistics(edu.uky.cepis
	 * .domain.IPAddress)
	 */
	@Override
	public List<User> getUserIPAddressStatistics(IPAddress ipAddr) {

		if (ipAddr == null) {
			return null;
		}
		IPAddress newIPAddr = (IPAddress) this.sessionFactory
				.getCurrentSession().load(IPAddress.class, ipAddr.getId());
		if (newIPAddr != null) {
			List<User> users = newIPAddr.getUsers();
			/*
			 * Iterator<User> iter = users.iterator(); User tempuser = null;
			 * List<User> _users = null; Set<User> newusers = new
			 * HashSet<User>(0); while (iter.hasNext()) { tempuser =
			 * iter.next(); _users =
			 * this.sessionFactory.getCurrentSession().findByExample(tempuser);
			 * if (_users.size() > 0) { newusers.add(_users.get(0)); }
			 * 
			 * }
			 */
			return users;
		} else
			return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.IPAddressDao#addIPAddressToUserAccount(edu.uky.cepis
	 * .domain.IPAddress, edu.uky.cepis.domain.User)
	 */
	@Override
	public void addIPAddressToUserAccount(IPAddress ipAddr, User user) {
		if (user != null && ipAddr != null) {

			List<IPAddress> ipAddresses = new ArrayList<IPAddress>(0);
			int size = 0;
			User newuser = (User) this.sessionFactory.getCurrentSession().load(
					User.class, user.getUid());
			this.sessionFactory.getCurrentSession().saveOrUpdate(ipAddr);
			ipAddresses = newuser.getIpAddresses();
			size = ipAddresses.size();

			if (size < 10) {
				ipAddresses.add(ipAddr);
			} else if (size == 10) {
				IPAddress iaddr = ipAddresses.get(0);
				ipAddresses.remove(0);
				this.sessionFactory.getCurrentSession().delete(iaddr);
				ipAddresses.add(ipAddr);
			}

			this.sessionFactory.getCurrentSession().saveOrUpdate(newuser);

		}

	}

	/*
	 * public void addIPAddressToUserAccount(IPAddress ipAddr, User user) { if
	 * (user != null) { this.sessionFactory.getCurrentSession().refresh(user);
	 * if (ipAddr != null) { IPAddress ipAddress = null; if
	 * (this.sessionFactory.getCurrentSession().contains(ipAddr)) { List
	 * ipAddresses =
	 * this.sessionFactory.getCurrentSession().findByExample(ipAddr); int size =
	 * ipAddresses.size(); if (size > 0) { ipAddress = (IPAddress)
	 * ipAddresses.get(0); } } else { ipAddress = ipAddr; }
	 * 
	 * User newuser = (User)
	 * this.sessionFactory.getCurrentSession().findByExample(user).get(0);
	 * newuser.getIpAddresses().add(ipAddress);
	 * this.sessionFactory.getCurrentSession().saveOrUpdate(newuser); } }
	 * 
	 * }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.IPAddressDao#getRecentUserIPAddressInfo(edu.uky.cepis
	 * .domain.User)
	 */
	@Override
	public IPAddress getRecentUserIPAddressInfo(User user) {

		if (user == null) {
			return null;
		}
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null)
			return null;

		List<IPAddress> set = newuser.getIpAddresses();

		if (set == null) {
			return null;
		}
		int totalLoginRecord = set.size();

		System.out.println(totalLoginRecord);
		if (totalLoginRecord > 1) {
			IPAddress ipAddr = (IPAddress) set.toArray()[totalLoginRecord - 2];
			return ipAddr;
		}
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.IPAddressDao#getUserIPAddressInfo(edu.uky.cepis.domain
	 * .User)
	 */
	@Override
	public List<IPAddress> getUserIPAddressInfo(User user) {

		if (user == null) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		// this.sessionFactory.getCurrentSession().refresh(user);
		List<IPAddress> set = newuser.getIpAddresses();
		List<IPAddress> ipList = new ArrayList<IPAddress>(0);
		if (set == null) {
			return null;
		}
		int ipAddressSize = set.size();

		ListIterator<IPAddress> iter = set.listIterator(ipAddressSize);
		IPAddress ipaddress = null;

		int i = 0;
		// Display the last 10 ipaddress information of the user
		while (iter.hasPrevious() && i < 10) {
			i++;
			ipaddress = iter.previous();
			ipList.add(ipaddress);
		}
		return ipList;

	}

}
