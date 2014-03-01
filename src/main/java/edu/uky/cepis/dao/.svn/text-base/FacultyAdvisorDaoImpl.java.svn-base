package edu.uky.cepis.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.uky.cepis.domain.FacultyAdvisor;

@Repository
public class FacultyAdvisorDaoImpl implements FacultyAdvisorDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public FacultyAdvisor findAdvisorByUid(String uid) {		
		if(uid == null){
			return null;
		}else if(uid.isEmpty()){
			return null;
		}else{
			Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(FacultyAdvisor.class);
			
			searchCriteria.add(Restrictions.eq("userid", uid));
			
			if(!searchCriteria.list().isEmpty()){
				return (FacultyAdvisor) searchCriteria.list().get(0);
			}else{
				return null;
			}
		}		
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<FacultyAdvisor> getFacultyAdvisorList() {
		Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(FacultyAdvisor.class);
		
		if(!searchCriteria.list().isEmpty()){
			searchCriteria.addOrder(Order.asc("userid"));
			return searchCriteria.list();
		}else{
			return null;
		}
	}
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
