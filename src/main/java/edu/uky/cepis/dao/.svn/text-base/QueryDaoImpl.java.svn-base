/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;

import edu.uky.cepis.domain.Query;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.WorkingSet;

/**
 * @author keerthi
 * 
 */
public class QueryDaoImpl implements QueryDao {

	private static Logger log = Logger.getLogger(QueryDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.QueryDao#addQueryToUser(edu.uky.cepis.domain
	 * .User, edu.uky.cepis.domain.Query)
	 */
	@Override
	public boolean addQueryToUser(User user, Query ss) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean saveQuery(Query ss) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(ss);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.QueryDao#createQuery(edu.uky.cepis.domain .User,
	 * java.lang.String, java.lang.String, java.lang.String,
	 * org.hibernate.criterion.DetachedCriteria)
	 */
	@Override
	public Query createQuery(User user, String name, String desc,
			DetachedCriteria query) {
		if (name == null || query == null || user == null || name.isEmpty()) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		Query ss = new Query(name, desc, user.getUid());
		ss.setQuery(query);
		this.saveQuery(ss);
		if (newuser.getSavedQueries().add(ss)) {
			return ss;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.QueryDao#deleteQuery(edu.uky.cepis.domain .User,
	 * edu.uky.cepis.domain.Query)
	 */
	@Override
	public boolean deleteQuery(User user, Query ss) {
		if (user == null || ss == null) {
			return false;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		Query newss = (Query) this.sessionFactory.getCurrentSession().load(
				Query.class, ss.getSid());
		if (newss == null) {
			return false;
		}
		this.sessionFactory.getCurrentSession().delete(newss);
		if (newuser.getSavedQueries().contains(newss)) {
			if (newuser.getSavedQueries().remove(newss)) {
				this.sessionFactory.getCurrentSession().saveOrUpdate(newuser);
				System.out.println("Saved Search removed from user list");
			} else {
				return false;
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.QueryDao#findQuery(java.lang.String, long)
	 */
	@Override
	public Query findQuery(String createdBy, long sid) {
		Query ss = null;
		List<Query> savedSearches = null;
		String hql = "select a from Query a  where a.createdBy ='" + createdBy
				+ "' AND a.sid=" + sid;
		savedSearches = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (savedSearches.size() > 0) {
			ss = savedSearches.get(0);
		}
		return ss;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.QueryDao#getQueryList(edu.uky.cepis.domain .User)
	 */
	@Override
	public List<Query> getQueryList(User user) {
		Query ss = null;
		List<Query> savedSearches = null;

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		String hql = "select a from Query a  where a.createdBy ='"
				+ newuser.getUid() + "' order by a.name";
		savedSearches = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		return savedSearches;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.QueryDao#updateQuery(edu.uky.cepis.domain .Query,
	 * edu.uky.cepis.domain.User, java.lang.String, java.lang.String,
	 * java.lang.String, org.hibernate.criterion.DetachedCriteria)
	 */
	@Override
	public Query updateQuery(Query ss, User user, String name, String desc,
			DetachedCriteria query) {
		if (name == null || ss == null || query == null || user == null
				|| name.isEmpty()) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		Query newss = (Query) this.sessionFactory.getCurrentSession().load(
				Query.class, ss.getSid());
		if (!newuser.getSavedQueries().contains(newss)) {
			return null;
		}
		newss.setName(name);
		newss.setDesc(desc);
		newss.setCreatedBy(newuser.getUid());
		newss.setQuery(query);
		newss.setDateModified(new Date());
		this.saveQuery(newss);
		return newss;
	}

}
