package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import edu.uky.cepis.domain.TepAdmission;
import edu.uky.cepis.domain.User;

/**
 * @author cawalk4
 *
 */
public class TepAdmissionDaoImpl implements TepAdmissionDao{
	
	private static Logger log = Logger.getLogger(TepAdmissionDaoImpl.class.getName());
	private SessionFactory sessionFactory;
	
	@Override
	public TepAdmission findTepAdmissionById(long id){
		log.info("Entered TepAdmissionDaoImpl findTepAdmissionById(" + id +")");
		TepAdmission result = (TepAdmission) getSessionFactory().getCurrentSession().load(TepAdmission.class, id);
		if(result != null){
			return result;
		}else{ 
			return null;
		}
	}
	
	@Override
	public boolean saveOrUpdateTepAdmission(TepAdmission tepAdmission){
		log.info("Entered TepAdmissionDaoImpl saveOrUpdateTepAdmission()");
		if(tepAdmission == null){
			return false;
		}else{
			tepAdmission.setLastEdit(new Date());
			getSessionFactory().getCurrentSession().saveOrUpdate(tepAdmission);
			return true;
		}
	}
	
	@Override
	public boolean deleteTepAdmission(TepAdmission tepAdmission){
		log.info("Entered TepAdmissionDaoImpl deleteTepAdmission()");
		if(tepAdmission == null){
			return false;
		}else{
			getSessionFactory().getCurrentSession().delete(tepAdmission);
			return true;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TepAdmission> getTepAdmissionByExample(TepAdmission tepAdmission){
		log.info("Entered TepAdmissionDaoImpl getTepAdmissionByExample()");
		Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(TepAdmission.class);
		
		searchCriteria.createAlias("programProfile", "programProfile");
		searchCriteria.createAlias("programProfile.ukMajor","ukMajor");
		searchCriteria.createAlias("programProfile.ukStatus","ukStatus");
		searchCriteria.createAlias("user", "user", JoinType.LEFT_OUTER_JOIN);
		
		if(tepAdmission.getProgramProfile() != null){
			if(tepAdmission.getProgramProfile().getUserprogramprofileid() != null){
				searchCriteria.add(Restrictions.eq("programProfile.userprogramprofileid", tepAdmission.getProgramProfile().getUserprogramprofileid()));
			}
			if(tepAdmission.getProgramProfile().getUkMajor() != null){
				searchCriteria.add(Restrictions.eq("ukMajor.ukMajorCode", tepAdmission.getProgramProfile().getUkMajor().getUkMajorCode()));
			}
			if(tepAdmission.getProgramProfile().getUkStatus() != null){
				searchCriteria.add(Restrictions.eq("ukStatus.statusCode", tepAdmission.getProgramProfile().getUkStatus().getStatusCode()));
			}
		}
		if(tepAdmission.getReportYear() != null){
			searchCriteria.add(Restrictions.eq("reportYear.reportYearCode", tepAdmission.getReportYear().getReportYearCode()));
		}
		if(tepAdmission.getCohortTerm() != null){
			searchCriteria.add(Restrictions.eq("cohortTerm.ukTermCode", tepAdmission.getCohortTerm().getUkTermCode()));
		}
		if(tepAdmission.getTepAdmissionCode() != null && !tepAdmission.getTepAdmissionCode().isEmpty()){
			searchCriteria.add(Restrictions.eq("tepAdmissionCode", tepAdmission.getTepAdmissionCode()));
		}
		
		if(!searchCriteria.list().isEmpty()){
			searchCriteria.addOrder(Order.asc("user.lName")).addOrder(Order.asc("user.fName"));
			return (List<TepAdmission>)searchCriteria.list();
		}else{
			return new ArrayList<TepAdmission>();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TepAdmission> getTepAdmissionForUser(User user){
		log.info("Entered TepAdmissionDaoImpl getTepAdmissionForUser()");
		
		if(user != null){
			Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(TepAdmission.class);
			
			searchCriteria.createAlias("programProfile", "programProfile");
			searchCriteria.add(Restrictions.ilike("programProfile.userprogramprofileid", "P-" + user.getUid() + "-%"));
		
			if(!searchCriteria.list().isEmpty()){
				return	(List<TepAdmission>)searchCriteria.list();
			}else{
				return new ArrayList<TepAdmission>();
			}
		}else{
			return new ArrayList<TepAdmission>();
		}				
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}