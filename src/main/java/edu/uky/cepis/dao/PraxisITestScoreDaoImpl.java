/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.mytutorial.praxis.PraxisTestScore;

import edu.uky.cepis.domain.PraxisITest;
import edu.uky.cepis.domain.PraxisITestScore;
import edu.uky.cepis.domain.User;

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
public class PraxisITestScoreDaoImpl implements PraxisITestScoreDao {

	private static Logger log = Logger.getLogger(PraxisITestScoreDaoImpl.class);
	private SessionFactory sessionFactory;

	@Override
	public boolean addPraxisITestScoreToUser(User user, PraxisITestScore praxisITestScore) {
		if (user == null || praxisITestScore == null) {
			log.debug("user or praxisIITestScore object is null.");
			return false;
		}
		this.savePraxisTestScore(praxisITestScore);
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return false;
		}
		newuser.getPraxisITestScores().add(praxisITestScore);
		return true;
	}

	private void savePraxisTestScore(PraxisITestScore praxisITestScore) {
		if (praxisITestScore != null) {
			this.sessionFactory.getCurrentSession().saveOrUpdate(praxisITestScore);
		}
	}

	@Override
	public boolean addPraxisITestScoreToUser(User user, Date testDate,
			PraxisITest praxisITest, double score, int primary) {
		if (user == null || praxisITest == null || score < 0 || testDate == null) {
			log.debug("one of the parameters is null.");
			return false;
		}
		PraxisITestScore praxisTestScore = new PraxisITestScore();
		this.savePraxisTestScore(praxisTestScore);
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return false;
		}
		newuser.getPraxisITestScores().add(praxisTestScore);
		return true;
	}
	
	@Override
	public PraxisITestScore findPraxisITestScoreById(long id) {

		PraxisITestScore result = 
			(PraxisITestScore)this.sessionFactory.getCurrentSession().load(PraxisITestScore.class,id);
		if(result != null){
			Hibernate.initialize(result);
			return result;
		}else{
			return null;
		}
	}
	
	@Override
	public List<PraxisITestScore> getPraxisITestScores(User user) {
		Criteria searchCriteria = 
			this.sessionFactory.getCurrentSession().createCriteria(PraxisITestScore.class);
		
		if (user == null) {
			log.debug("user object is null.");
			return new ArrayList<PraxisITestScore>();
		}else{
			searchCriteria.createAlias("user","user");
			searchCriteria.add(Restrictions.eq("user.uid", user.getUid()));
			searchCriteria.addOrder(Order.desc("id"));
			return searchCriteria.list();
		}
	}

	

	@Override
	public boolean removePraxisITestScoreFromUser(User user, PraxisITestScore praxisITestScore) {
		if (user == null || praxisITestScore == null) {
			return false;
		}
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return false;
		}

		PraxisITestScore newPraxisTestScore = (PraxisITestScore) this.sessionFactory
				.getCurrentSession().load(PraxisITestScore.class,
						praxisITestScore.getId());
		if (newPraxisTestScore == null) {
			return false;
		}

		if (newuser.getPraxisITestScores().contains(newPraxisTestScore)) {
			newuser.getPraxisITestScores().remove(newPraxisTestScore);
			this.sessionFactory.getCurrentSession().saveOrUpdate(newuser);
			this.sessionFactory.getCurrentSession().delete(newPraxisTestScore);
			return true;
		}
		log.debug("PraxisITestScore is not found in the given user object.");
		return false;
	}

	@Override
	public PraxisITestScore updatePraxisITestScore(User user,
			PraxisITestScore praxisITestScore, Date testDate,
			PraxisITest praxisITest,String candidateId, double score, int primary) {
		if (user == null || praxisITestScore == null || praxisITest == null) {
			return null;
		}
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return null;
		}
		PraxisITestScore newPraxisTestScore = (PraxisITestScore) this.sessionFactory
				.getCurrentSession().load(PraxisITestScore.class, praxisITestScore.getId());
		if (newPraxisTestScore == null) {
			return null;
		}
		if (!newuser.getPraxisITestScores().contains(newPraxisTestScore)) {
			log.debug("PraxisITestScore is not found in the given user object.");
			return null;
		}
		newPraxisTestScore.setTestDate(testDate);
		newPraxisTestScore.setPraxisITest(praxisITest);
		newPraxisTestScore.setScore(score);
		newPraxisTestScore.setCandidateId(candidateId);
		newPraxisTestScore.setPrimary(primary);

		this.savePraxisTestScore(newPraxisTestScore);
		return newPraxisTestScore;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
