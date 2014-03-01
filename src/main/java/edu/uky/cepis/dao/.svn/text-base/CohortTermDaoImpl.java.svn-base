/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.CohortTerm;

/**
 * @author keerthi
 * 
 */
public class CohortTermDaoImpl implements CohortTermDao {
	private static Logger log = Logger.getLogger(CohortTermDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.CohortTermDao#createCohortTerm(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public CohortTerm createCohortTerm(int termCode, String shortDesc,
			String description) {
		CohortTerm cohortTerm = new CohortTerm(termCode, shortDesc, description);
		if (cohortTerm == null) {
			return cohortTerm;
		}
		if (!this.saveCohortTerm(cohortTerm)) {
			return null;
		}
		return cohortTerm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.CohortTermDao#deleteCohortTerm(edu.uky.cepis.domain
	 * .CohortTerm)
	 */
	@Override
	public boolean deleteCohortTerm(CohortTerm cohortTerm) {
		if (cohortTerm == null) {
			return false;
		}

		this.sessionFactory.getCurrentSession().delete(cohortTerm);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.CohortTermDao#findCohortTermByCode(java.lang.String)
	 */
	@Override
	public CohortTerm findCohortTermByCode(int termCode) {
		if (termCode < 0) {
			return null;
		}
		List<CohortTerm> cohortTerms = null;
		CohortTerm cohortTerm = null;

		String hql = "select a from CohortTerm a where a.termCode =" + termCode;
		cohortTerms = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (cohortTerms.size() < 1) {
			return null;
		}
		cohortTerm = cohortTerms.get(0);

		return cohortTerm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.CohortTermDao#getCohortTermList()
	 */
	@Override
	public List<CohortTerm> getCohortTermList() {
		List<CohortTerm> cohortTerms = new ArrayList<CohortTerm>(0);

		String hql = "select a from CohortTerm a order by termCode desc";
		cohortTerms = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();

		return cohortTerms;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeedu.uky.cepis.dao.CohortTermDao#saveCohortTerm(edu.uky.cepis.domain.
	 * CohortTerm)
	 */
	@Override
	public boolean saveCohortTerm(CohortTerm cohortTerm) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(cohortTerm);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.CohortTermDao#updateCohortTerm(edu.uky.cepis.domain
	 * .CohortTerm, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public CohortTerm updateCohortTerm(CohortTerm cohortTerm, int termCode,
			String shortDesc, String description) {
		if (cohortTerm == null) {
			return null;
		}
		cohortTerm.setDescription(description);
		cohortTerm.setShortDesc(shortDesc);
		cohortTerm.setTermCode(termCode);
		this.saveCohortTerm(cohortTerm);
		return cohortTerm;
	}

}
