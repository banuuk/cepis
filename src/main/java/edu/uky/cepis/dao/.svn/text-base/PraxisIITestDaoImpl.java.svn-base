/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.mytutorial.praxis.PraxisTestScore;

import edu.uky.cepis.domain.PraxisIITest;

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
public class PraxisIITestDaoImpl implements PraxisIITestDao {

	private static Logger log = Logger.getLogger(PraxisIITestDaoImpl.class);
	private SessionFactory sessionFactory;

	

	@Override
	public List<PraxisIITest> getPraxisIITestByCode(String testCode) {
		List<PraxisIITest> praxisTests = new ArrayList<PraxisIITest>(0);
		if (testCode == null || testCode.isEmpty()) {
			log.debug("testCode is null or empty");
		}
		String hql = "select distinct t from PraxisIITest t where  t.testCode = :testCode order by t.testCode";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("testCode", testCode);
		praxisTests = query.list();

		return praxisTests;
	}
	
	@Override
	public List<PraxisIITest> getPraxisIITests() {
		List<PraxisIITest> praxisTests = new ArrayList<PraxisIITest>(0);
		String hql = "select distinct t from PraxisIITest t order by t.testCode";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		praxisTests = query.list();
		return praxisTests;
	}
	
	@Override
	public PraxisIITest findPraxisIITestById(long id) {
		log.info("Entered PraxisIITestDaoImpl findPraxisIITestById(" + id +")");
		PraxisIITest result = (PraxisIITest) this.sessionFactory.getCurrentSession().load(PraxisIITest.class, id);
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

}
