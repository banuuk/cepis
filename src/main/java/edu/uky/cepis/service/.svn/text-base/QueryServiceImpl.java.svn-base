/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import edu.uky.cepis.dao.QueryDao;
import edu.uky.cepis.domain.Query;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 *
 */
public class QueryServiceImpl implements QueryService {

	private QueryDao queryDao;
	/* (non-Javadoc)
	 * @see edu.uky.cepis.service.QueryService#addQueryToUser(edu.uky.cepis.domain.User, edu.uky.cepis.domain.Query)
	 */
	@Override
	public boolean addQueryToUser(User user, Query ss) {

		return this.getQueryDao().addQueryToUser(user, ss);
	}

	/* (non-Javadoc)
	 * @see edu.uky.cepis.service.QueryService#createQuery(edu.uky.cepis.domain.User, java.lang.String, java.lang.String, org.hibernate.criterion.DetachedCriteria)
	 */
	@Override
	public Query createQuery(User user, String name, String desc,
			DetachedCriteria query) {
		return this.getQueryDao().createQuery(user, name, desc, query);
	}

	/* (non-Javadoc)
	 * @see edu.uky.cepis.service.QueryService#deleteQuery(edu.uky.cepis.domain.User, edu.uky.cepis.domain.Query)
	 */
	@Override
	public boolean deleteQuery(User user, Query ss) {
		return this.getQueryDao().deleteQuery(user, ss);
	}

	/* (non-Javadoc)
	 * @see edu.uky.cepis.service.QueryService#findQuery(java.lang.String, long)
	 */
	@Override
	public Query findQuery(String createdBy, long sid) {
		return this.getQueryDao().findQuery(createdBy, sid);
	}

	/* (non-Javadoc)
	 * @see edu.uky.cepis.service.QueryService#getQueryList(edu.uky.cepis.domain.User)
	 */
	@Override
	public List<Query> getQueryList(User user) {

		return this.getQueryDao().getQueryList(user);
	}

	/* (non-Javadoc)
	 * @see edu.uky.cepis.service.QueryService#updateQuery(edu.uky.cepis.domain.Query, edu.uky.cepis.domain.User, java.lang.String, java.lang.String, org.hibernate.criterion.DetachedCriteria)
	 */
	@Override
	public Query updateQuery(Query ss, User user, String name, String desc,
			DetachedCriteria query) {
		return this.getQueryDao().updateQuery(ss, user, name, desc, query);
	}

	/**
	 * @param queryDao the queryDao to set
	 */
	public void setQueryDao(QueryDao queryDao) {
		this.queryDao = queryDao;
	}

	/**
	 * @return the queryDao
	 */
	public QueryDao getQueryDao() {
		return queryDao;
	}

}
