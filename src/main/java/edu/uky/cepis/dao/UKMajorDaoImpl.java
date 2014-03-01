/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.UKMajor;

/**
 * @author keerthi
 * 
 */
public class UKMajorDaoImpl implements UKMajorDao {

	private static Logger log = Logger.getLogger(UKMajorDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKMajorDao#createUKMajor(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public UKMajor createUKMajor(String ukMajorCode, String shortDesc,
			String description, String status, String degreeLevel) {
		UKMajor ukMajor = new UKMajor(ukMajorCode, shortDesc, description,
				status, degreeLevel);
		if (ukMajor == null) {
			return ukMajor;
		}
		if (!this.saveUKMajor(ukMajor)) {
			return null;
		}
		return ukMajor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKMajorDao#deleteUKMajor(edu.uky.cepis.domain.UKMajor)
	 */
	@Override
	public boolean deleteUKMajor(UKMajor ukMajor) {
		if (ukMajor == null) {
			return false;
		}

		this.sessionFactory.getCurrentSession().delete(ukMajor);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKMajorDao#findUKMajorByCode(java.lang.String)
	 */
	@Override
	public UKMajor findUKMajorByCode(String ukMajorCode) {
		if (ukMajorCode.isEmpty()) {
			return null;
		}
		List<UKMajor> ukMajors = null;
		UKMajor ukMajor = null;

		String hql = "select a from UKMajor a where a.ukMajorCode ='"
				+ ukMajorCode + "'";
		ukMajors = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (ukMajors.size() < 1) {
			return null;
		}
		ukMajor = ukMajors.get(0);

		return ukMajor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKMajorDao#findUKMajorByID(long)
	 */
	@Override
	public UKMajor findUKMajorByID(long ukMajorid) {
		if (ukMajorid < 0) {
			return null;
		}
		List<UKMajor> ukMajors = null;
		UKMajor ukMajor = null;

		String hql = "select a from UKMajor a where a.ukmajorid =" + ukMajorid
				+ "";
		ukMajors = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (ukMajors.size() < 1) {
			return null;
		}
		ukMajor = ukMajors.get(0);

		return ukMajor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKMajorDao#getUKMajorList()
	 */
	@Override
	public List<UKMajor> getUKMajorList() {
		List<UKMajor> ukMajors = new ArrayList<UKMajor>(0);

		String hql = "select a from UKMajor a order by a.status,a.shortDesc";
		ukMajors = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();

		return ukMajors;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKMajorDao#saveUKMajor(edu.uky.cepis.domain.UKMajor)
	 */
	@Override
	public boolean saveUKMajor(UKMajor ukMajor) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(ukMajor);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKMajorDao#updateUKMajor(edu.uky.cepis.domain.UKMajor,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public UKMajor updateUKMajor(UKMajor ukMajor, String ukMajorCode,
			String shortDesc, String description, String status,
			String degreeLevel) {
		if (ukMajor == null) {
			return null;
		}
		ukMajor.setDescription(description);
		ukMajor.setShortDesc(shortDesc);
		ukMajor.setUkMajorCode(ukMajorCode);
		ukMajor.setStatus(status);
		ukMajor.setDegreeLevel(degreeLevel);
		this.saveUKMajor(ukMajor);
		return ukMajor;
	}

}
