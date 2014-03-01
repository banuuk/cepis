package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.Fee;
import edu.uky.cepis.domain.embeddedId.FeePK;

/**
 * @author cawalk4
 *
 */
public class FeeDaoImpl implements FeeDao{
	
	private static Logger log = Logger.getLogger(CharacterAndFitnessDaoImpl.class.getName());
	private SessionFactory sessionFactory;

	@Override
	public Fee findFeeById(FeePK id) {
		log.info("Entered FeeDaoImpl findFeeById(" + id.toString() +")");
		Fee result = 
				(Fee) getSessionFactory().getCurrentSession().load(Fee.class, id);
		if(result != null){
			Hibernate.initialize(result);
			return result;
		}else{ 
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fee> findFeeByExample(Fee fee) {
		log.info("Entered FeeDaoImpl findFeeByExample()");
		
		Query query = getSessionFactory().getCurrentSession().createQuery("from Fee where feePk.user =:user");			
		query.setParameter("user", fee.getFeePk().getUser());
		
		if(!query.list().isEmpty()){
			return query.list();
		}else{
			return new ArrayList<Fee>();
		}
	}

	@Override
	public boolean saveOrUpdateFee(Fee fee) {
		log.info("Entered FeeDaoImpl saveOrUpdateFee()");
		if(fee == null){
			return false;
		}else{
			getSessionFactory().getCurrentSession().saveOrUpdate(fee);
			return true;
		}
	}

	@Override
	public boolean deleteFee(Fee fee) {
		log.info("Entered FeeDaoImpl deleteFee()");
		if(fee == null){
			return false;
		}else{			
			getSessionFactory().getCurrentSession().delete(fee);
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