/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author keerthi
 * 
 */
public class UKTermDaoImpl implements UKTermDao {

	private static Logger log = Logger.getLogger(UKTermDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKTermDao#createUKTerm(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unused")
	@Override
	public UKTerm createUKTerm(String ukTermCode, String shortDesc,
			String description, String status) {
		UKTerm ukTerm = new UKTerm(ukTermCode, shortDesc, description, status);
		if (ukTerm == null) {
			return ukTerm;
		}
		if (!this.saveUKTerm(ukTerm)) {
			return null;
		}
		return ukTerm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKTermDao#deleteUKTerm(edu.uky.cepis.domain.UKTerm)
	 */
	@Override
	public boolean deleteUKTerm(UKTerm ukTerm) {
		if (ukTerm == null) {
			return false;
		}

		this.sessionFactory.getCurrentSession().delete(ukTerm);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKTermDao#findUKTermByCode(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public UKTerm findUKTermByCode(String ukTermCode) {
		if (ukTermCode.isEmpty()) {
			return null;
		}
		List<UKTerm> ukTerms = null;
		UKTerm ukTerm = null;

		String hql = "select a from UKTerm a where a.ukTermCode ='"
				+ ukTermCode + "'";
		ukTerms = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (ukTerms.size() < 1) {
			return null;
		}
		ukTerm = ukTerms.get(0);

		return ukTerm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKTermDao#findUKTermByID(long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public UKTerm findUKTermByID(long uktermid) {
		if (uktermid < 0) {
			return null;
		}
		List<UKTerm> ukTerms = null;
		UKTerm ukTerm = null;

		String hql = "select a from UKTerm a where a.uktermid =" + uktermid
				+ "";
		ukTerms = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (ukTerms.size() < 1) {
			return null;
		}
		ukTerm = ukTerms.get(0);

		return ukTerm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKTermDao#getUKTermList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UKTerm> getUKTermList() {
		List<UKTerm> ukTerms = new ArrayList<UKTerm>(0);

		String hql = "select a from UKTerm a order by status,ukTermCode desc";
		ukTerms = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();

		return ukTerms;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKTermDao#saveUKTerm(edu.uky.cepis.domain.UKTerm)
	 */
	@Override
	public boolean saveUKTerm(UKTerm ukTerm) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(ukTerm);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKTermDao#updateUKTerm(edu.uky.cepis.domain.UKTerm,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public UKTerm updateUKTerm(UKTerm ukTerm, String ukTermCode,
			String shortDesc, String description, String status) {
		if (ukTerm == null) {
			return null;
		}
		ukTerm.setDescription(description);
		ukTerm.setShortDesc(shortDesc);
		ukTerm.setUkTermCode(ukTermCode);
		ukTerm.setStatus(status);
		this.saveUKTerm(ukTerm);
		return ukTerm;
	}

}
