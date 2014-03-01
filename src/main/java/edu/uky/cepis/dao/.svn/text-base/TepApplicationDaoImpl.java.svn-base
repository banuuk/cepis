package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import edu.uky.cepis.domain.TepApplication;
import edu.uky.cepis.domain.User;

/**
 * @author cawalk4
 *
 */
public class TepApplicationDaoImpl implements TepApplicationDao{
	
	private static Logger log = Logger.getLogger(TepApplicationDaoImpl.class.getName());
	private SessionFactory sessionFactory;
	
	@Override
	public TepApplication findTepApplicationById(long id){
		log.info("Entered TepApplicationDaoImpl findTepApplicationById(" + id +")");
		TepApplication result = (TepApplication) getSessionFactory().getCurrentSession().load(TepApplication.class, id);
		if(result != null){
			return result;
		}else{ 
			return null;
		}
	}
	
	@Override
	public boolean saveOrUpdateTepApplication(TepApplication tepApplication){
		log.info("Entered TepApplicationDaoImpl saveOrUpdateTepApplication()");
		if(tepApplication == null){
			return false;
		}else{
			getSessionFactory().getCurrentSession().saveOrUpdate(tepApplication);
			return true;
		}
	}
	
	@Override
	public boolean deleteTepApplication(TepApplication tepApplication){
		log.info("Entered TepApplicationDaoImpl deleteTepApplication()");
		if(tepApplication == null){
			return false;
		}else{
			getSessionFactory().getCurrentSession().delete(tepApplication);
			return true;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TepApplication> getTepApplicationByExample(TepApplication tepApplication){
		log.info("Entered TepApplicationDaoImpl getTepApplicationByExample()");
		Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(TepApplication.class);
		
		if(tepApplication.getProgramProfile() != null){
			searchCriteria.createAlias("programProfile", "programProfile");
			searchCriteria.add(Restrictions.eq("programProfile.userprogramprofileid", tepApplication.getProgramProfile().getUserprogramprofileid()));
		}
		
		if(searchCriteria != null){
			 return	(List<TepApplication>)searchCriteria.list();
		}else{
			return new ArrayList<TepApplication>();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TepApplication> getTepApplicationForUser(User user){
		log.info("Entered TepApplicationDaoImpl getTepApplicationForUser()");
		Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(TepApplication.class);
		
		if(user != null){
			searchCriteria.createAlias("programProfile", "programProfile");
			searchCriteria.add(Restrictions.ilike("programProfile.userprogramprofileid", "P-" + user.getUid() + "%"));
		}
		
		if(searchCriteria != null){
			 return	(List<TepApplication>)searchCriteria.list();
		}else{
			return new ArrayList<TepApplication>();
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}