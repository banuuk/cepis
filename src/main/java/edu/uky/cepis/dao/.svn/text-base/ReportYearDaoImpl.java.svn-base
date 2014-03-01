/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import edu.uky.cepis.domain.ReportYear;

/**
 * @author cawalk4
 * 
 */
public class ReportYearDaoImpl implements ReportYearDao {
	
	private static Logger log = Logger.getLogger(ReportYearDaoImpl.class);
	private SessionFactory sessionFactory;
	
	@Override
	public ReportYear findReportYearByCode(String reportYearCode){
		log.info("Entered ReportYearDaoImpl findReportYearByCode(" + reportYearCode +")");
		
		ReportYear result = (ReportYear) getSessionFactory().getCurrentSession().load(ReportYear.class, reportYearCode);
		
		if(result != null){
			return result;
		}else{
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReportYear> getReportYears(){
		log.info("Entered ReportYearDaoImpl getReportYears");
		
		Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(ReportYear.class);
		searchCriteria.addOrder(Order.desc("reportYearCode"));
		return searchCriteria.list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
