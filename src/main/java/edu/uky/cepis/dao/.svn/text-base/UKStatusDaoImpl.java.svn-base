/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.component.UKMajor;
import edu.uky.cepis.domain.component.UKStatus;

/**
 * @author keerthi
 * 
 */
public class UKStatusDaoImpl implements UKStatusDao {

	private static Logger log = Logger.getLogger(UKStatusDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKStatusDao#createUKStatus(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public UKStatus createUKStatus(String ukStatusCode, String shortDesc,
			String description, String status) {
		UKStatus ukStatus = new UKStatus(ukStatusCode, shortDesc, description,
				status);
		if (ukStatus == null) {
			return ukStatus;
		}
		if (!this.saveUKStatus(ukStatus)) {
			return null;
		}
		return ukStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKStatusDao#deleteUKStatus(edu.uky.cepis.domain.UKStatus
	 * )
	 */
	@Override
	public boolean deleteUKStatus(UKStatus ukStatus) {
		if (ukStatus == null) {
			return false;
		}

		this.sessionFactory.getCurrentSession().delete(ukStatus);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKStatusDao#findUKStatusByCode(java.lang.String)
	 */
	@Override
	public UKStatus findUKStatusByCode(String ukStatusCode) {
		if (ukStatusCode.isEmpty()) {
			return null;
		}
		List<UKStatus> ukStatuss = null;
		UKStatus ukStatus = null;

		String hql = "select a from UKStatus a where a.statusCode ='"
				+ ukStatusCode + "'";
		ukStatuss = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (ukStatuss.size() < 1) {
			return null;
		}
		ukStatus = ukStatuss.get(0);

		return ukStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKStatusDao#findUKStatusByID(long)
	 */
	@Override
	public UKStatus findUKStatusByID(long ukstatusid) {
		if (ukstatusid < 0) {
			return null;
		}
		List<UKStatus> ukStatuss = null;
		UKStatus ukStatus = null;

		/*
		 * Use this for Individual Cache queries
		 * this.sessionFactory.getCurrentSession
		 * ().setQueryCacheRegion("edu.uky.cepis.cache.query.UKStatus");
		 * this.sessionFactory.getCurrentSession().setCacheQueries(true);
		 * this.sessionFactory.getCurrentSession().setCacheQueries(false);
		 */
		String hql = "select a from UKStatus a where a.ukstatusid ="
				+ ukstatusid + "";
		ukStatuss = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (ukStatuss.size() < 1) {
			return null;
		}
		ukStatus = ukStatuss.get(0);

		return ukStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKStatusDao#getUKStatusList()
	 */
	@Override
	public List<UKStatus> getUKStatusList() {
		List<UKStatus> ukStatuss = new ArrayList<UKStatus>(0);

		String hql = "select a from UKStatus a order by shortDesc";
		ukStatuss = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();

		return ukStatuss;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKStatusDao#saveUKStatus(edu.uky.cepis.domain.UKStatus)
	 */
	@Override
	public boolean saveUKStatus(UKStatus ukStatus) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(ukStatus);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKStatusDao#updateUKStatus(edu.uky.cepis.domain.UKStatus
	 * , java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public UKStatus updateUKStatus(UKStatus ukStatus, String ukStatusCode,
			String shortDesc, String description, String status) {
		if (ukStatus == null) {
			return null;
		}
		ukStatus.setDescription(description);
		ukStatus.setShortDesc(shortDesc);
		ukStatus.setStatusCode(ukStatusCode);
		ukStatus.setStatus(status);
		this.saveUKStatus(ukStatus);
		return ukStatus;
	}

}
