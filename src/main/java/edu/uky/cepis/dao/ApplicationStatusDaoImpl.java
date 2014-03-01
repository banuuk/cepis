package edu.uky.cepis.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import edu.uky.cepis.domain.ApplicationStatus;

/**
 * @author cawalk4
 *
 */
public class ApplicationStatusDaoImpl implements ApplicationStatusDao{
	
	private static Logger log = Logger.getLogger(ApplicationStatusDaoImpl.class.getName());
	private SessionFactory sessionFactory;
	
	@Override
	public ApplicationStatus findApplicationStatusByCode(String code) {
		log.info("Entered ApplicationStatusDaoImpl findApplicationStatusByCode(" + code +")");
		ApplicationStatus result = (ApplicationStatus) getSessionFactory().getCurrentSession().load(ApplicationStatus.class, code);
		if(result != null){
			Hibernate.initialize(result);
			return result;
		}else{ 
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicationStatus> getApplicationStatusList() {
		log.info("Entered ApplicationStatusDaoImpl getApplicationStatusList");
		
		Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(ApplicationStatus.class);
		searchCriteria.addOrder(Order.desc("applicationStatusCode"));	
		if(searchCriteria.list().isEmpty()){
			return null;
		}else{
			return searchCriteria.list();
		}
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}