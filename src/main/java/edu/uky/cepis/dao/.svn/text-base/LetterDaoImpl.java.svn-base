package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import edu.uky.cepis.domain.Letter;
import edu.uky.cepis.domain.User;

/**
 * @author cawalk4
 *
 */
public class LetterDaoImpl implements LetterDao{
	
	private static Logger log = Logger.getLogger(LetterDaoImpl.class.getName());
	private SessionFactory sessionFactory;
	
	@Override
	public Letter findLetterById(long id) {
		log.info("Entered LetterDaoImpl findLetterById(" + id +")");
		Letter result = (Letter) getSessionFactory().getCurrentSession().load(Letter.class, id);
		if(result != null){
			Hibernate.initialize(result);
			return result;
		}else{ 
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Letter> getLettersByExample(Letter letter) {
		log.info("Entered LetterDaoImpl getLettersByExample()");
		Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(Letter.class);
		
		if(letter != null){
			searchCriteria.createAlias("programProfile", "programProfile");
			searchCriteria.add(Restrictions.eq("programProfile.userprogramprofileid", letter.getProgramProfile().getUserprogramprofileid()));
		}
		
		if(searchCriteria != null){
			 return	(List<Letter>)searchCriteria.list();
		}else{
			return new ArrayList<Letter>();
		}
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Letter> getLettersForUser(User user) {
		log.info("Entered LetterDaoImpl getLettersForUser()");
		Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(Letter.class);
		
		if(user != null){
			searchCriteria.createAlias("programProfile", "programProfile");
			searchCriteria.add(Restrictions.ilike("programProfile.userprogramprofileid", "P-" + user.getUid() + "%"));
		}
		
		if(searchCriteria != null){
			 return	(List<Letter>)searchCriteria.list();
		}else{
			return new ArrayList<Letter>();
		}
	}

	@Override
	public boolean saveOrUpdateLetter(Letter letter) {
		log.info("Entered LetterDaoImpl saveOrUpdateLetter()");
		if(letter == null){
			return false;
		}else{
			getSessionFactory().getCurrentSession().saveOrUpdate(letter);
			return true;
		}
	}

	@Override
	public boolean deleteLetter(Letter letter) {
		log.info("Entered LetterDaoImpl deleteLetter()");
		if(letter == null){
			return false;
		}else{
			getSessionFactory().getCurrentSession().delete(letter);
			return true;
		}
	}	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}