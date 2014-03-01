/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.LastLogin;
import edu.uky.cepis.domain.User;

/**
 * 
 * Dao Class that store the Last Login information to the database <br/>
 * <br/>
 * <br/>
 * 
 * @author keerthi
 * @see HibernateDaoSupport
 * @see HibernateTemplate
 * @see LastLogin
 * 
 */
public class LastLoginDaoImpl implements LastLoginDao {

	private static Logger log = Logger.getLogger(LastLoginDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.LastLoginDao#getUserLastLoginStatistics(edu.uky.cepis
	 * .domain.LastLogin)
	 */
	@Override
	public List<User> getUserLastLoginStatistics(LastLogin lastLogin) {

		if (lastLogin != null) {

			LastLogin newLastLogin = (LastLogin) this.sessionFactory
					.getCurrentSession().load(LastLogin.class,
							lastLogin.getLastloginId());
			List<User> users = newLastLogin.getUsers();
			return users;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.LastLoginDao#addLastLoginToUserAccount(edu.uky.cepis
	 * .domain.LastLogin, edu.uky.cepis.domain.User)
	 */
	@Override
	public void addLastLoginToUserAccount(LastLogin lastLogin, User user) {
		if (user != null && lastLogin != null) {

			List<LastLogin> lastLogins = new ArrayList<LastLogin>(0);
			int size = 0;
			User newuser = (User) this.sessionFactory.getCurrentSession().load(User.class, user.getUid());
			if (newuser == null) {
				System.out.println("Invalid user object");
				return;
			}
			this.sessionFactory.getCurrentSession().saveOrUpdate(lastLogin);
			lastLogins = newuser.getLastlogins();
			size = lastLogins.size();

			if (size < 10) {
				lastLogins.add(lastLogin);
			} else if (size == 10) {
				LastLogin lLogin = lastLogins.get(0);
				lastLogins.remove(0);
				this.sessionFactory.getCurrentSession().delete(lLogin);
				lastLogins.add(lastLogin);
			}
			this.sessionFactory.getCurrentSession().saveOrUpdate(newuser);

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.LastLoginDao#getRecentUserLastLoginInfo(edu.uky.cepis
	 * .domain.User)
	 */
	@Override
	public LastLogin getRecentUserLastLoginInfo(User user) {

		if (user == null) {
			return null;
		}
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return null;
		}
		List<LastLogin> set = newuser.getLastlogins();

		if (set == null) {
			return null;
		}
		int totalLoginRecord = set.size();

		System.out.println(totalLoginRecord);
		if (totalLoginRecord > 1) {
			LastLogin lastLogin = (LastLogin) set.toArray()[totalLoginRecord - 2];
			return lastLogin;
		}

		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.LastLoginDao#getUserLastLoginInfo(edu.uky.cepis.domain
	 * .User)
	 */
	@Override
	public List<LastLogin> getUserLastLoginInfo(User user) {

		if (user == null) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		List<LastLogin> set = newuser.getLastlogins();
		List<LastLogin> lastloginList = new ArrayList<LastLogin>(0);

		if (set == null) {
			return null;
		}
		int lastLoginSize = set.size();

		ListIterator<LastLogin> iter = set.listIterator(lastLoginSize);
		LastLogin lastLogin = null;
		int i = 0;
		while (iter.hasPrevious() && i < 10) {
			i++;
			lastLogin = iter.previous();
			lastloginList.add(lastLogin);
		}

		return lastloginList;

	}

}
