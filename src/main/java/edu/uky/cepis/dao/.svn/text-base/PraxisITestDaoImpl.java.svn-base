/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.mytutorial.praxis.PraxisTestScore;

import edu.uky.cepis.domain.PraxisITest;

/**
 * Hibernate-based DAO class for CRUD operation on test scores such as
 * {@link PraxisTestScore} object.<br>
 * 
 * {@link SessionFactory} object injected via Spring IoC.
 * 
 * @see PraxisTestScore
 * @see PraxisTest
 * 
 * @author keerthi
 * 
 */
@SuppressWarnings("unchecked")
public class PraxisITestDaoImpl implements PraxisITestDao {

	private static Logger log = Logger.getLogger(PraxisITestDaoImpl.class);
	private SessionFactory sessionFactory;

	

	@Override
	public List<PraxisITest> getPraxisITestByCode(String testCode) {		
		Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(PraxisITest.class);
		
		if(testCode != null){
			searchCriteria.add(Restrictions.eq("praxisICode", testCode));
		}		
		if(searchCriteria != null){
			searchCriteria.addOrder(Order.desc("praxisICode"));			
			return searchCriteria.list();
		}else{
			return null;
		}		
	}
	
	
	@Override
	public List<PraxisITest> getPraxisITests() {		
		Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(PraxisITest.class);
		searchCriteria.addOrder(Order.desc("praxisICode"));	
		return searchCriteria.list();		
	}
	
	@Override
	public PraxisITest findPraxisITestById(long id) {
		log.info("Entered PraxisITestDaoImpl findPraxisITestById(" + id +")");
		PraxisITest result = (PraxisITest) getSessionFactory().getCurrentSession().load(PraxisITest.class, id);
		if(result != null){
			Hibernate.initialize(result);
			return result;
		}else{ 
			return null;
		}
	}	

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
