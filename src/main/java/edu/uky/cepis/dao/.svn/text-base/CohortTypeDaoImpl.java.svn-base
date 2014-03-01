/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.CohortType;

/**
 * @author keerthi
 * 
 */
public class CohortTypeDaoImpl implements CohortTypeDao {
	private static Logger log = Logger.getLogger(CohortTypeDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.CohortTypeDao#createCohortType(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public CohortType createCohortType(String typeCode, String shortDesc,
			String desc, String status) {
		CohortType cohortType = new CohortType(typeCode, shortDesc, desc,
				status);
		if (cohortType == null) {
			return null;
		}
		if (this.saveCohortType(cohortType)) {
			return cohortType;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.CohortTypeDao#deleteCohortType(edu.uky.cepis.domain
	 * .CohortType)
	 */
	@Override
	public boolean deleteCohortType(CohortType cohortType) {
		if (cohortType == null) {
			return false;
		}

		this.sessionFactory.getCurrentSession().delete(cohortType);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.CohortTypeDao#findCohortTypeByCode(java.lang.String)
	 */
	@Override
	public CohortType findCohortTypeByCode(String typeCode) {
		CohortType cohortType = null;
		List<CohortType> cohortTypes = new ArrayList<CohortType>(0);

		String hql = "select a from CohortType a where a.typeCode ='"
				+ typeCode + "'";
		cohortTypes = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (cohortTypes.isEmpty())
			return null;
		cohortType = cohortTypes.get(0);

		return cohortType;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.CohortTypeDao#getCohortTypeList()
	 */
	@Override
	public List<CohortType> getCohortTypeList() {
		List<CohortType> cohortTypes = new ArrayList<CohortType>(0);

		String hql = "select a from CohortType a ";
		cohortTypes = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (cohortTypes.isEmpty())
			return null;
		return cohortTypes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeedu.uky.cepis.dao.CohortTypeDao#saveCohortType(edu.uky.cepis.domain.
	 * CohortType)
	 */
	@Override
	public boolean saveCohortType(CohortType cohortType) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(cohortType);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.CohortTypeDao#updateCohortType(edu.uky.cepis.domain
	 * .CohortType, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public CohortType updateCohortType(CohortType cohortType, String typeCode,
			String shortDesc, String desc, String status) {
		if (cohortType == null)
			return null;
		cohortType.setTypeCode(typeCode);
		cohortType.setDescription(desc);
		cohortType.setShortDesc(shortDesc);
		cohortType.setStatus(status);
		this.saveCohortType(cohortType);
		return cohortType;

	}

}
