package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import edu.uky.cepis.domain.CharacterAndFitness;
import edu.uky.cepis.domain.Letter;
import edu.uky.cepis.domain.User;

/**
 * @author cawalk4
 *
 */
public class CharacterAndFitnessDaoImpl implements CharacterAndFitnessDao{
	
	private static Logger log = Logger.getLogger(CharacterAndFitnessDaoImpl.class.getName());
	private SessionFactory sessionFactory;

	@Override
	public CharacterAndFitness findCharacterAndFitnessById(long id) {
		log.info("Entered CharacterAndFitnessDaoImpl findCharacterAndFitnessById(" + id +")");
		CharacterAndFitness result = 
				(CharacterAndFitness) getSessionFactory().getCurrentSession().load(CharacterAndFitness.class, id);
		if(result != null){
			Hibernate.initialize(result);
			return result;
		}else{ 
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CharacterAndFitness> findCharacterAndFitnessByExample(CharacterAndFitness characterAndFitness) {
		log.info("Entered CharacterAndFitnessDaoImpl findCharacterAndFitnessByExample()");
		Criteria searchCriteria = 
				getSessionFactory().getCurrentSession().createCriteria(CharacterAndFitness.class);
		
		if(characterAndFitness != null){
			searchCriteria.createAlias("programProfile", "programProfile");
			searchCriteria.add(Restrictions.eq("programProfile.programProfileId", characterAndFitness.getProgramProfile().getUserprogramprofileid()));
		}
		
		if(searchCriteria != null){
			 return	(List<CharacterAndFitness>)searchCriteria.list();
		}else{
			return new ArrayList<CharacterAndFitness>();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CharacterAndFitness> getCharacterAndFitnessForUser(User user){
		log.info("Entered CharacterAndFitnessDaoImpl getCharacterAndFitnessForUser()");
		Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(CharacterAndFitness.class);
		if(user != null){
			searchCriteria.createAlias("programProfile", "programProfile");
			searchCriteria.add(Restrictions.ilike("programProfile.userprogramprofileid", "P-" + user.getUid() + "%"));
		}
		if(searchCriteria != null){
			 return	(List<CharacterAndFitness>)searchCriteria.list();
		}else{
			return new ArrayList<CharacterAndFitness>();
		}
	}

	@Override
	public boolean saveOrUpdateCharacterAndFitness(CharacterAndFitness characterAndFitness) {
		log.info("Entered CharacterAndFitnessDaoImpl saveOrUpdateCharacterAndFitness()");
		if(characterAndFitness == null){
			return false;
		}else{
			getSessionFactory().getCurrentSession().saveOrUpdate(characterAndFitness);
			return true;
		}
	}

	@Override
	public boolean deleteCharacterAndFitness(CharacterAndFitness characterAndFitness) {
		log.info("Entered CharacterAndFitnessDaoImpl deleteCharacterAndFitness()");
		if(characterAndFitness == null){
			return false;
		}else{
			getSessionFactory().getCurrentSession().delete(characterAndFitness);
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