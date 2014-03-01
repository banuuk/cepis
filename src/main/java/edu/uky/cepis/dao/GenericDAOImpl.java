package edu.uky.cepis.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;


public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {
	
	private static Logger log = Logger.getLogger(GenericDAOImpl.class.getName());
	
	private SessionFactory sessionFactory;
		
	
	@SuppressWarnings("unchecked")
	public T findById(long id, Class<T> objectClass) {
		log.info("Entered GenericDAOImpl findById(" + id +")");
		T result = (T) getSessionFactory().getCurrentSession().load(objectClass, id);
		if(result != null){
			Hibernate.initialize(result);
			return result;
		}else{ 
			return null;
		}
	}
		
	public boolean create(T newInstance) {
		log.info("Entered GenericDAOImpl create()");
		if(newInstance == null){
			return false;
		}
		getSessionFactory().getCurrentSession().saveOrUpdate(newInstance);
		return true;		
	}
	
	
	public boolean updpate(T updateInstance) {
		log.info("Entered GenericDAOImpl updpate()");
		if(updateInstance == null){
			return false;
		}
		getSessionFactory().getCurrentSession().update(updateInstance);	
		return true;
	}
	
	public boolean delete(T entity) {
		log.info("Entered GenericDAOImpl delete()");
		if(entity == null){
			return false;
		}
		getSessionFactory().getCurrentSession().delete(entity);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(T exampleInstance, Class<T> objectClass){
		log.info("Entered GenericDAOImpl findByExample()");
		Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(objectClass);
		
		searchCriteria.add(Example.create(exampleInstance));
				
		return (List<T>)searchCriteria.list();			
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}		
}