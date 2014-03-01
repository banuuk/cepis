/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.SharedUser;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.WorkingSet;

/**
 * Hibernate Dao class for CRUD operations on {@link WorkingSet} object
 * 
 * @author keerthi
 * 
 */
@SuppressWarnings({ "unchecked", "unused" })
public class WorkingSetDaoImpl implements WorkingSetDao {

	private static Logger log = Logger.getLogger(WorkingSetDaoImpl.class);
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#addUsersToWorkingSet(edu.uky.cepis.domain
	 * .WorkingSet, java.util.Set)
	 */
	@Override
	public boolean addUsersToWorkingSet(WorkingSet ws, List<User> users) {
		if (users == null || users.size() <= 0) {
			System.out.println("None selected");
			return false;
		}
		if (ws == null) {
			System.out.println("ws is null");
			return false;
		}
		System.out.println("Got in");

		WorkingSet newws = (WorkingSet) this.sessionFactory.getCurrentSession()
				.load(WorkingSet.class, ws.getWid());
		if (newws == null) {
			System.out.println("newws is null");
			return false;
		}
		Iterator<User> iter = users.iterator();
		User user = null;
		while (iter.hasNext()) {
			user = (User) this.sessionFactory.getCurrentSession().load(
					User.class, iter.next().getUid());
			newws.getUsers().add(user);
		}

		newws.setDateModified(new Date());
		this.saveWorkingSet(newws);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#addUserToWorkingSet(edu.uky.cepis.domain
	 * .WorkingSet, java.lang.String)
	 */
	@Override
	public boolean addUserToWorkingSet(WorkingSet ws, String userid) {
		if (userid == null || userid.isEmpty()) {
			return false;
		}
		List<User> users = null;

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, userid);
		if (newuser == null)
			return false;
		WorkingSet newws = (WorkingSet) this.sessionFactory.getCurrentSession()
				.load(WorkingSet.class, ws.getWid());
		if (newws == null)
			return false;
		newws.getUsers().add(newuser);
		newws.setDateModified(new Date());
		this.saveWorkingSet(newws);

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#addUserToWorkingSet(edu.uky.cepis.domain
	 * .WorkingSet, edu.uky.cepis.domain.User)
	 */
	@Override
	public boolean addUserToWorkingSet(WorkingSet ws, User user) {
		if (user == null) {
			return false;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null)
			return false;
		WorkingSet newws = (WorkingSet) this.sessionFactory.getCurrentSession()
				.load(WorkingSet.class, ws.getWid());
		if (newws == null)
			return false;

		newws.getUsers().add(newuser);
		newws.setDateModified(new Date());
		saveWorkingSet(newws);

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#clearWorkingSet(edu.uky.cepis.domain.
	 * WorkingSet, edu.uky.cepis.domain.User)
	 */
	@Override
	public boolean clearWorkingSet(WorkingSet ws, User user) {
		if (user == null || ws == null) {
			return false;
		}

		WorkingSet newws = (WorkingSet) this.sessionFactory.getCurrentSession()
				.load(WorkingSet.class, ws.getWid());
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null)
			return false;
		if (newws == null)
			return false;
		newws.getUsers().clear();
		newws.setDateModified(new Date());
		this.saveWorkingSet(newws);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#createWorkingSet(edu.uky.cepis.domain
	 * .User, java.lang.String)
	 */
	@Override
	public WorkingSet createWorkingSet(User user, String name) {
		if (user == null) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null)
			return null;
		WorkingSet ws = new WorkingSet(name, "", user.getUid(), false, false);
		if (ws == null)
			return null;
		newuser.getWorkingSets().add(ws);
		this.sessionFactory.getCurrentSession().saveOrUpdate(newuser);
		return ws;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#createWorkingSet(edu.uky.cepis.domain
	 * .User, java.lang.String, boolean, boolean)
	 */
	@Override
	public WorkingSet createWorkingSet(User user, String name,
			boolean public_status, boolean shared_mode) {
		if (user == null) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null)
			return null;
		WorkingSet ws = new WorkingSet(name, "", user.getUid(), public_status,
				shared_mode);

		if (ws == null)
			return null;
		newuser.getWorkingSets().add(ws);
		this.sessionFactory.getCurrentSession().saveOrUpdate(newuser);
		return ws;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#createWorkingSet(edu.uky.cepis.domain
	 * .User, java.lang.String, java.lang.String)
	 */
	@Override
	public WorkingSet createWorkingSet(User user, String name, String desc) {
		if (user == null) {
			return null;
		}
		if (log.isDebugEnabled()) {
			log.debug("Creating Working Set: " + name);
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null)
			return null;
		WorkingSet ws = new WorkingSet(name, desc, user.getUid(), false, false);
		if (ws == null)
			return null;
		// newuser.getWorkingSets().add(ws);
		this.sessionFactory.getCurrentSession().saveOrUpdate(ws);
		if (log.isDebugEnabled()) {
			log.debug("Working Set " + ws.getName() + "created Successfully.");
		}
		return ws;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#createWorkingSet(edu.uky.cepis.domain
	 * .User, java.lang.String, java.lang.String, boolean, boolean)
	 */
	@Override
	public WorkingSet createWorkingSet(User user, String name, String desc,
			boolean public_status, boolean shared_mode) {
		if (user == null) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null)
			return null;

		WorkingSet ws = new WorkingSet(name, desc, user.getUid(),
				public_status, shared_mode);

		if (ws == null)
			return null;
		newuser.getWorkingSets().add(ws);
		this.sessionFactory.getCurrentSession().saveOrUpdate(newuser);
		return ws;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#deleteUserFromWorkingSet(edu.uky.cepis
	 * .domain.WorkingSet, edu.uky.cepis.domain.User)
	 */
	@Override
	public boolean deleteUserFromWorkingSet(WorkingSet ws, User user) {
		if (user == null) {
			return false;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null)
			return false;

		WorkingSet newws = (WorkingSet) this.sessionFactory.getCurrentSession()
				.load(WorkingSet.class, ws.getWid());
		if (newws == null)
			return false;
		if (newws.getUsers().contains(newuser)) {
			newws.getUsers().remove(newuser);
			newws.setDateModified(new Date());
			saveWorkingSet(newws);
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#deleteUsersFromWorkingSet(edu.uky.cepis
	 * .domain.WorkingSet, java.util.Set)
	 */
	@Override
	public boolean deleteUsersFromWorkingSet(WorkingSet ws, List<User> users) {
		if (users == null) {
			return false;
		}
		if (ws == null) {
			return false;
		}

		WorkingSet newws = (WorkingSet) this.sessionFactory.getCurrentSession()
				.load(WorkingSet.class, ws.getWid());
		if (newws == null)
			return false;
		Set<User> userList = newws.getUsers();
		// FIXME: Work around for the Working Set User deletion
		if (users.size() == userList.size()) {
			newws.getUsers().clear();
		} else if (users.size() * 3 > userList.size()) {
			HashSet<User> hashSet = new HashSet<User>(userList);
			hashSet.removeAll(users);
			newws.getUsers().clear();
			newws.setUsers(hashSet);
		} else {
			newws.getUsers().removeAll(users);
		}
		newws.setDateModified(new Date());
		this.saveWorkingSet(newws);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#deleteWorkingSet(edu.uky.cepis.domain
	 * .User, edu.uky.cepis.domain.WorkingSet)
	 */
	@Override
	public boolean deleteWorkingSet(User user, WorkingSet ws) {
		if (user == null) {
			return false;
		}
		if (ws == null) {
			return false;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null)
			return false;
		WorkingSet newws = (WorkingSet) this.sessionFactory.getCurrentSession()
				.load(WorkingSet.class, ws.getWid());
		if (newws == null)
			return false;
		this.sessionFactory.getCurrentSession().delete(newws);
		if (newuser.getWorkingSets().contains(newws)) {
			if (newuser.getWorkingSets().remove(newws)) {
				System.out.println("Working Set removed from user list");

				this.sessionFactory.getCurrentSession().saveOrUpdate(newuser);
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#deleteWorkingSets(edu.uky.cepis.domain
	 * .User, java.util.List)
	 */
	@Override
	public boolean deleteWorkingSets(User user, List<WorkingSet> wss) {
		if (user == null) {
			return false;
		}
		if (wss == null) {
			return false;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null)
			return false;
		Iterator<WorkingSet> iter = wss.iterator();
		List<WorkingSet> deletewss = new ArrayList<WorkingSet>(0);
		WorkingSet ws = null;
		while (iter.hasNext()) {
			ws = (WorkingSet) this.sessionFactory.getCurrentSession().load(
					WorkingSet.class, iter.next().getWid());
			deletewss.add(ws);
		}
		if (deletewss != null) {
			newuser.getWorkingSets().removeAll(deletewss);
			iter = deletewss.iterator();
			while (iter.hasNext()) {
				this.sessionFactory.getCurrentSession().delete(iter.next());
			}
			this.sessionFactory.getCurrentSession().saveOrUpdate(newuser);
			return true;
		}
		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.WorkingSetDao#findByName(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<WorkingSet> findByName(String createdBy, String workingset_name) {

		List<WorkingSet> wss = null;

		String hql = "select a from WorkingSet a where a.name LIKE '"
				+ workingset_name + "' AND a.createdBy='" + createdBy + "'";
		wss = this.sessionFactory.getCurrentSession().createQuery(hql).list();
		return wss;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.WorkingSetDao#findWorkingSet(long)
	 */
	@Override
	public WorkingSet findWorkingSet(long wid) {
		WorkingSet ws = null;
		List<WorkingSet> wss = null;

		String hql = "select a from WorkingSet a  where a.wid=" + wid;
		wss = this.sessionFactory.getCurrentSession().createQuery(hql).list();
		if (wss.size() > 0) {
			ws = wss.get(0);
		}
		return ws;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.WorkingSetDao#findWorkingSet(java.lang.String,
	 * long)
	 */
	@Override
	public WorkingSet findWorkingSet(String createdBy, long wid) {
		WorkingSet ws = null;
		List<WorkingSet> wss = null;
		String hql = "select a from WorkingSet a  where a.createdBy ='"
				+ createdBy + "' AND a.wid=" + wid;
		wss = this.sessionFactory.getCurrentSession().createQuery(hql).list();
		if (wss.size() > 0) {
			ws = wss.get(0);
		}
		return ws;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#getLastOpenedWorkingSetInUserConfiguration
	 * (edu.uky.cepis.domain.User)
	 */
	@Override
	public WorkingSet getLastOpenedWorkingSetInUserConfiguration(User user) {

		if (user == null) {
			return null;
		}
		WorkingSet ws = null;

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null)
			return null;
		if (newuser.getUserConfiguration() != null) {
			ws = newuser.getUserConfiguration().getActiveWorkingSet();
		}
		return ws;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#getPublicSetting(edu.uky.cepis.domain
	 * .WorkingSet, edu.uky.cepis.domain.User)
	 */
	@Override
	public SharedUser getPublicSetting(WorkingSet workingSet, User user) {
		// TODO: Add Shared WorkingSet Concept
		if (user == null) {
			return null;
		}
		if (workingSet == null) {
			return null;
		}

		String hql = "select su from WorkingSet a join a.sharedUsers su where a.wid ="
				+ workingSet.getWid()
				+ " AND su.user.uid ='AMODS-0401' AND a.createdBy='"
				+ user.getUid() + "'";
		List<SharedUser> sharedUsers = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (sharedUsers.size() <= 0) {
			return null;
		}
		return sharedUsers.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#getPublicWorkingSetList(edu.uky.cepis
	 * .domain.User)
	 */
	@Override
	public List<WorkingSet> getPublicWorkingSetList(User user) {

		if (user == null)
			return null;
		List<WorkingSet> wssList = null;
		String workingset_name = "New Working Set* (" + user.getUid() + ")";

		String hql = "select distinct a from WorkingSet a  where a.public_status=true and a.name !='"
				+ workingset_name + "' order by a.name asc";
		wssList = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return wssList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#getSharedWorkingSetList(edu.uky.cepis
	 * .domain.User)
	 */
	@Override
	public List<WorkingSet> getSharedWorkingSetList(User user) {
		// TODO: Add shared workingset concept.
		if (user == null)
			return null;
		List<WorkingSet> wssList = null;
		String workingset_name = "New Working Set* (" + user.getUid() + ")";

		String hql = "select distinct a from WorkingSet a  where a.shared_mode=true and a.name !='"
				+ workingset_name + "' order by a.name asc";
		wssList = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return wssList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#getSortedWorkingSetUsersList(edu.uky.
	 * cepis.domain.WorkingSet)
	 */
	@Override
	public List<User> getSortedWorkingSetUsersList(WorkingSet ws) {

		if (ws == null)
			return null;

		List<User> users = new ArrayList<User>(0);
		WorkingSet newws = (WorkingSet) this.sessionFactory.getCurrentSession()
				.load(WorkingSet.class, ws.getWid());
		if (newws == null)
			return users;
		users = new ArrayList<User>(newws.getUsers());
		if (users.size() > 1) {
			Collections.sort(users, new User());
		}
		return users;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#getWorkingSetList(edu.uky.cepis.domain
	 * .User)
	 */
	@Override
	public List<WorkingSet> getWorkingSetList(User user) {

		if (user == null)
			return null;
		List<WorkingSet> wssList = null;
		String workingset_name = "New Working Set* (" + user.getUid() + ")";

		String hql = "select distinct a from WorkingSet a  where a.createdBy='"
				+ user.getUid() + "' and a.name !='" + workingset_name
				+ "' order by a.name asc";
		wssList = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return wssList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#getWorkingSetMap(edu.uky.cepis.domain
	 * .User)
	 */
	@Override
	public Map<Long, String> getWorkingSetMap(User user) {

		if (user == null)
			return null;
		Map<Long, String> wsmap = new HashMap<Long, String>(0);
		List<WorkingSet> wss = null;

		String hql = "select a from WorkingSet a  where a.createdBy='"
				+ user.getUid() + "'";
		wss = this.sessionFactory.getCurrentSession().createQuery(hql).list();
		Iterator<WorkingSet> iter = wss.iterator();
		WorkingSet newws = null;
		while (iter.hasNext()) {
			newws = iter.next();
			wsmap.put(newws.getWid(), newws.getName());
		}
		return wsmap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#getWorkingSetUsersList(edu.uky.cepis.
	 * domain.WorkingSet)
	 */
	@Override
	public Set<User> getWorkingSetUsersList(WorkingSet ws) {

		if (ws == null)
			return null;

		Set<User> users = new HashSet<User>(0);
		WorkingSet newws = (WorkingSet) this.sessionFactory.getCurrentSession()
				.load(WorkingSet.class, ws.getWid());
		if (newws == null)
			return users;
		users = newws.getUsers();
		return users;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#mergeWorkingSets(edu.uky.cepis.domain
	 * .User, java.util.Set, boolean, boolean)
	 */
	@Override
	public boolean mergeWorkingSets(User user, WorkingSet firstWorkingSet,
			List<WorkingSet> wss, boolean deleteRemains) {
		if (user == null) {
			return false;
		}
		if (firstWorkingSet == null) {
			return false;
		}
		if (wss == null) {
			return false;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null)
			return false;

		WorkingSet mergeToWS = (WorkingSet) this.sessionFactory
				.getCurrentSession().load(WorkingSet.class,
						firstWorkingSet.getWid());
		WorkingSet activeMergeWS = null;
		List<WorkingSet> deleteSet = new ArrayList<WorkingSet>(0);
		Iterator<WorkingSet> iter = wss.iterator();

		while (iter.hasNext()) {
			activeMergeWS = (WorkingSet) this.sessionFactory
					.getCurrentSession().load(WorkingSet.class,
							iter.next().getWid());
			mergeToWS.getUsers().addAll(activeMergeWS.getUsers());
			if (deleteRemains) {
				deleteSet.add(activeMergeWS);
			}
		}
		// To avoid duplicate entries
		HashSet<User> hashSet = new HashSet<User>(mergeToWS.getUsers());
		mergeToWS.getUsers().clear();
		mergeToWS.getUsers().addAll(hashSet);

		if (deleteRemains) {
			deleteWorkingSets(newuser, deleteSet);
		}
		mergeToWS.setDateModified(new Date());
		this.sessionFactory.getCurrentSession().saveOrUpdate(mergeToWS);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#mergeWorkingSets(edu.uky.cepis.domain
	 * .User, edu.uky.cepis.domain.WorkingSet, edu.uky.cepis.domain.WorkingSet)
	 */
	@Override
	public boolean mergeWorkingSets(User user, WorkingSet ws1, WorkingSet ws2) {
		if (user == null) {
			return false;
		}
		if (ws1 == null && ws2 == null) {
			return false;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null)
			return false;
		WorkingSet newws1 = (WorkingSet) this.sessionFactory
				.getCurrentSession().load(WorkingSet.class, ws1.getWid());
		if (newws1 == null)
			return false;
		WorkingSet newws2 = (WorkingSet) this.sessionFactory
				.getCurrentSession().load(WorkingSet.class, ws2.getWid());
		if (newws2 == null)
			return false;
		newws1.getUsers().addAll(newws2.getUsers());
		deleteWorkingSet(newuser, newws2);
		newws1.setDateModified(new Date());
		this.sessionFactory.getCurrentSession().saveOrUpdate(newws1);
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#retrieveMyWorkingSet(java.lang.String)
	 */
	@Override
	public WorkingSet retrieveMyWorkingSet(String createdBy) {
		String workingsetName = "New Working Set* (" + createdBy + ")";
		List<WorkingSet> wss = null;
		wss = this.findByName(createdBy, workingsetName);
		if (wss.size() > 0) {
			if (log.isDebugEnabled()) {
				log.debug(createdBy + " Working Set found");
			}
			return wss.get(0);
		}

		// Create new active Working Set for the CEPIS 1.0 User. It may be a bug
		// too.

		else {
			if (log.isDebugEnabled()) {
				log.debug(createdBy + " Working Set not found. Creating "
						+ workingsetName);
			}

			String hql = "select a from User a where a.uid ='" + createdBy
					+ "'";
			List<User> users = this.sessionFactory.getCurrentSession()
					.createQuery(hql).list();
			User user = null;
			if (users.isEmpty()) {
				if (log.isDebugEnabled()) {
					log.debug("Error: User " + createdBy + " not found.");
				}
				return null;
			} else {
				if (log.isDebugEnabled()) {
					log.debug("User " + createdBy + "found.");
				}
				user = users.get(0);
			}
			String desc = "MyWorkingSet for " + createdBy;
			WorkingSet ws = this.createWorkingSet(user, workingsetName, desc);
			return ws;
		}
	}

	/**
	 * Hibernate Save or Update {@link WorkingSet}.
	 * 
	 * @param ws
	 * @return
	 */
	public WorkingSet saveWorkingSet(WorkingSet ws) {

		if (ws == null) {
			return null;
		}

		this.sessionFactory.getCurrentSession().saveOrUpdate(ws);
		return ws;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#setCustomWorkingSetToUser(edu.uky.cepis
	 * .domain.WorkingSet, edu.uky.cepis.domain.User)
	 */
	@Override
	public WorkingSet setCustomWorkingSetToUser(WorkingSet ws, User user) {
		System.out.println("Sharing workingset: " + ws.getName() + " to User: "
				+ user.getFullName());
		if (user == null) {
			System.out.println("null user");
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			System.out.println("no user");
			return null;
		}
		WorkingSet newws = (WorkingSet) this.sessionFactory.getCurrentSession()
				.load(WorkingSet.class, ws.getWid());
		if (newws == null) {
			System.out.println("no ws");
			return null;
		}

		Set<WorkingSet> wss = newuser.getWorkingSets();
		Iterator<WorkingSet> iter = wss.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().getName());
		}
		System.out.println("--------------------------------------");
		boolean result = newuser.getWorkingSets().add(newws);
		if (!result) {
			System.out.println("Cannot add");
		}
		System.out.println("Saving user");
		this.sessionFactory.getCurrentSession().saveOrUpdate(newws);
		this.sessionFactory.getCurrentSession().saveOrUpdate(newuser);
		wss = newuser.getWorkingSets();
		iter = wss.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().getName());
		}
		System.out.println("--------------------------------------");
		System.out.println("End workingset");
		return newws;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#setWorkingSetUsersList(edu.uky.cepis.
	 * domain.WorkingSet, java.util.Set)
	 */
	@Override
	public boolean setWorkingSetUsersList(WorkingSet ws, Set<User> users) {

		if (ws == null)
			return false;

		WorkingSet newws = (WorkingSet) this.sessionFactory.getCurrentSession()
				.load(WorkingSet.class, ws.getWid());
		if (newws == null)
			return false;
		newws.setUsers(users);
		this.saveWorkingSet(newws);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#shareWorkingSet(edu.uky.cepis.domain.
	 * WorkingSet, edu.uky.cepis.domain.User)
	 */
	@Override
	public WorkingSet shareWorkingSet(WorkingSet ws, User user) {
		// TODO Shared Working Set Concept
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#switchToWorkingSet(edu.uky.cepis.domain
	 * .WorkingSet)
	 */
	@Override
	public WorkingSet switchToWorkingSet(User user, WorkingSet ws) {

		if (ws == null) {
			return null;
		}

		WorkingSet newws = this.findWorkingSet(user.getUid(), ws.getWid());
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null)
			return null;
		if (newws == null)
			return null;
		newws.getUsers();
		return newws;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#updateLastOpenedWorkingSetInUserConfiguration
	 * (edu.uky.cepis.domain.User, edu.uky.cepis.domain.WorkingSet)
	 */
	@Override
	public boolean updateLastOpenedWorkingSetInUserConfiguration(User user,
			WorkingSet ws) {

		if (user == null || ws == null) {
			return false;
		}

		WorkingSet newws = (WorkingSet) this.sessionFactory.getCurrentSession()
				.load(WorkingSet.class, ws.getWid());
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null)
			return false;
		if (newws == null)
			return false;
		if (newuser.getUserConfiguration() != null
				&& newuser.getUserConfiguration().isRememberLastWorkingSet()) {
			newuser.getUserConfiguration().setActiveWorkingSet(newws);
			this.sessionFactory.getCurrentSession().saveOrUpdate(newuser);
			return true;
		}

		// this.updateActiveWorkingSet(newws.getCreatedBy(), newws.getWid());
		// this.setCurrentWorkingSet(newws);
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.WorkingSetDao#updateWorkingSet(edu.uky.cepis.domain
	 * .WorkingSet, edu.uky.cepis.domain.User, java.lang.String,
	 * java.lang.String, boolean, boolean, boolean, boolean)
	 */
	@Override
	public WorkingSet updateWorkingSet(WorkingSet workingSet, User user,
			String name, String desc, boolean publicStatus,
			boolean allowPublicAdd, boolean allowPublicRemove,
			boolean sharedMode) {
		if (user == null) {
			return null;
		}
		if (workingSet == null) {
			return workingSet;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		WorkingSet newws = (WorkingSet) this.sessionFactory.getCurrentSession()
				.load(WorkingSet.class, workingSet.getWid());
		Set<WorkingSet> wss = newuser.getWorkingSets();
		if (!wss.contains(newws)) {
			return null;
		}
		newws.setName(name);
		newws.setDesc(desc);
		newws.setPublic_status(publicStatus);
		// If public working set is enabled
		if (publicStatus) {
			if (allowPublicAdd || allowPublicRemove) {
				// Check whether the shareduser list already has a model student
				// entry
				SharedUser publicSetting = this
						.getPublicSetting(newws, newuser);
				if (publicSetting != null) {
					publicSetting.setAllowAddOperation(allowPublicAdd);
					publicSetting.setAllowRemoveOperation(allowPublicRemove);
				} else {

					User modelUser = (User) this.sessionFactory
							.getCurrentSession().load(User.class, "AMODS-0401");
					publicSetting = new SharedUser(modelUser, allowPublicAdd,
							allowPublicRemove);
					this.sessionFactory.getCurrentSession().saveOrUpdate(
							publicSetting);
				}
				newws.getSharedUsers().add(publicSetting);
			}
		}
		newws.setShared_mode(sharedMode);
		newws.setDateModified(new Date());
		this.sessionFactory.getCurrentSession().saveOrUpdate(newws);
		return newws;
	}

}
