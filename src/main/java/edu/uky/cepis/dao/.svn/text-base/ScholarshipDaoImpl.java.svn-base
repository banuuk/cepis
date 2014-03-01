package edu.uky.cepis.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.Scholarship;

/**
 * @author cawalk4
 *
 */
public class ScholarshipDaoImpl implements ScholarshipDao{
	
	private static Logger log = Logger.getLogger(ScholarshipDaoImpl.class.getName());
	
	private SessionFactory sessionFactory;

	@Override
	public Scholarship findScholarshipById(long id) {
		log.info("Entered findScholarshipById()");
		Scholarship result = (Scholarship) getSessionFactory().getCurrentSession().load(Scholarship.class, id);
		if(result != null){
			return result;
		}else{
			return null;
		}
	}

	@Override
	public boolean saveOrUpdateScholarship(Scholarship scholarship) {
		log.info("Entered saveOrUpdateScholarship()");
		if(scholarship != null){
			getSessionFactory().getCurrentSession().saveOrUpdate(scholarship);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteScholarship(Scholarship scholarship) {
		log.info("Entered deleteScholarship()");
		if(scholarship != null){
			getSessionFactory().getCurrentSession().delete(scholarship);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<Scholarship> getScholarshipByExample(Scholarship scholarship) {
		log.info("Entered getScholarshipByExample()");
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
