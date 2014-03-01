/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import edu.uky.cepis.domain.Query;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 *
 */
public interface QueryService {
	public abstract Query createQuery(User user, String name,
			String desc, DetachedCriteria query);

	public abstract boolean deleteQuery(User user, Query ss);

	public abstract boolean addQueryToUser(User user, Query ss);

	public abstract Query updateQuery(Query ss, User user,
			String name, String desc, DetachedCriteria query);
	public abstract Query findQuery(String createdBy, long sid);
	
	public abstract List<Query> getQueryList(User user);

}
