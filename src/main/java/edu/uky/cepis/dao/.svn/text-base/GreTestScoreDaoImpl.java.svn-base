package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import edu.uky.cepis.domain.GreTestScore;
import edu.uky.cepis.domain.User;


/**
 * @author cawalk4
 *
 */
public class GreTestScoreDaoImpl implements GreTestScoreDao{
	
	private static Logger log = Logger.getLogger(GreTestScoreDaoImpl.class);
	private SessionFactory sessionFactory;
		
	
	@Override
	public GreTestScore findById(long id) {
		log.info("Entered GreReviewCodeDaoImpl findById(" + id + ")");
		GreTestScore result = (GreTestScore) getSessionFactory().getCurrentSession().load(GreTestScore.class, id);
		
		if(result != null){
			Hibernate.initialize(result);
			return result;
		}else{ 
			return null;
		}
	}
	
	@Override
	public boolean addGreTestScoreToUser(User user, GreTestScore greTestScore){
		if (user == null || greTestScore == null) {
			log.debug("user or greTestScore object is null.");
			return false;
		}
		this.saveOrUpdateGreTestScore(greTestScore);
		User newuser = (User) getSessionFactory().getCurrentSession().load(User.class,user.getUid());
		if(newuser == null){
			return false;
		}
		newuser.getGreTestScores().add(greTestScore);
		return true;
	}
	
	@Override
	public boolean removeGreTestScoreFromUser(User user, GreTestScore greTestScore) {
		if (user == null || greTestScore == null) {
			return false;
		}
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return false;
		}

		GreTestScore newGreTestScore = (GreTestScore) this.sessionFactory
				.getCurrentSession().load(GreTestScore.class,greTestScore.getGreId());
		if (newGreTestScore == null) {
			return false;
		}

		if (newuser.getGreTestScores().contains(newGreTestScore)) {
			newuser.getGreTestScores().remove(newGreTestScore);
			this.sessionFactory.getCurrentSession().saveOrUpdate(newuser);
			this.sessionFactory.getCurrentSession().delete(newGreTestScore);
			return true;
		}
		log.debug("GreTestScore is not found in the given user object.");
		return false;
	}
	
	@Override
	public GreTestScore updateGreTestScore(User user, GreTestScore greTestScore) {
		if (user == null) {
			return null;
		}
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return null;
		}
		GreTestScore newGreTestScore = (GreTestScore) this.sessionFactory
			.getCurrentSession().load(GreTestScore.class, greTestScore.getGreId());
		if (newGreTestScore == null) {
			return null;
		}
		if (!newuser.getGreTestScores().contains(newGreTestScore)) {
			log.debug("GreTestScore is not found in the given user object.");
			return null;
		}
		newGreTestScore.setTestDate(greTestScore.getTestDate());
		newGreTestScore.setAnalytic(greTestScore.getAnalytic());
		newGreTestScore.setQuantitative(greTestScore.getQuantitative());
		newGreTestScore.setVerbal(greTestScore.getVerbal());
		newGreTestScore.setPrimary(greTestScore.getPrimary());
		newGreTestScore.setCutOff(greTestScore.getCutOff());

		this.saveOrUpdateGreTestScore(newGreTestScore);
		return newGreTestScore;
	}
	
	@Override
	public boolean saveOrUpdateGreTestScore(GreTestScore greTestScore) {
		log.info("Entered GreReviewCodeDaoImpl saveOrUpdateGreReviewCode()");
		if(greTestScore == null){
			return false;
		}
		getSessionFactory().getCurrentSession().saveOrUpdate(greTestScore);
		return true;	
	}
	
	@Override
	public boolean deleteGreTestScore(GreTestScore greTestScoreDao) {
		log.info("Entered GreReviewCodeDaoImpl deleteGreReviewCode()");
		if(greTestScoreDao == null){
			return false;
		}
		getSessionFactory().getCurrentSession().delete(greTestScoreDao);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GreTestScore> findGreTestScoreByExample(GreTestScore greTestScore) {
		log.info("Entered GreReviewCodeDaoImpl findGreReviewCodeByExample()");
		Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(GreTestScore.class);
		
		if(greTestScore != null){
			if(greTestScore.getUser() != null){
				searchCriteria.createAlias("user", "user");
				searchCriteria.add(Restrictions.eq("user.uid", greTestScore.getUser().getUid()));
			}
		}
		
		if(!searchCriteria.list().isEmpty()){
		 return	(List<GreTestScore>)searchCriteria.list();
		}else{
			return new ArrayList<GreTestScore>();
		}
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}