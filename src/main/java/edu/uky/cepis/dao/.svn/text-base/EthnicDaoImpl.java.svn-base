/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.Ethnic;
import edu.uky.cepis.domain.component.ProgramDomain;

/**
 * @author keerthi
 * 
 */
public class EthnicDaoImpl implements EthnicDao {

	private static Logger log = Logger.getLogger(EthnicDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.EthnicDao#createEthnic(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public Ethnic createEthnic(String code, String ethnicity,
			String kyEthnicCode) {
		Ethnic ethnic = new Ethnic(code, ethnicity, kyEthnicCode);
		if (ethnic == null) {
			return null;
		}
		if (!this.saveEthnic(ethnic)) {
			return null;
		}
		return ethnic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EthnicDao#deleteEthnic(edu.uky.cepis.domain.Ethnic)
	 */
	@Override
	public boolean deleteEthnic(Ethnic ethnic) {
		if (ethnic == null) {
			return false;
		}

		this.sessionFactory.getCurrentSession().delete(ethnic);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.EthnicDao#findByEthnicCode(java.lang.String)
	 */
	@Override
	public Ethnic findByEthnicCode(String code) {
		if (code == null) {
			return null;
		}
		List<Ethnic> ethnicList = new ArrayList<Ethnic>(0);
		Ethnic ethnic = null;

		String hql = "select a from Ethnic a where a.code like '" + code + "'";
		ethnicList = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (ethnicList.size() < 1) {
			return null;
		}
		ethnic = ethnicList.get(0);
		return ethnic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.EthnicDao#getEthnicList()
	 */
	@Override
	public List<Ethnic> getEthnicList() {
		List<Ethnic> ethnicList = new ArrayList<Ethnic>(0);

		String hql = "select a from Ethnic a order by a.status, a.shortDesc";
		ethnicList = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return ethnicList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.EthnicDao#saveEthnic(edu.uky.cepis.domain.Ethnic)
	 */
	@Override
	public boolean saveEthnic(Ethnic ethnic) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(ethnic);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EthnicDao#updateEthnic(edu.uky.cepis.domain.Ethnic,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Ethnic updateEthnic(Ethnic ethnic, String code, String ethnicity,
			String kyEthnicCode) {
		if (ethnic == null) {
			return null;
		}

		Ethnic newEthnic = (Ethnic) this.sessionFactory.getCurrentSession()
				.load(Ethnic.class, ethnic.getCode());
		if (newEthnic == null) {
			return null;
		}
		newEthnic.setCode(code);
		newEthnic.setShortDesc(ethnicity);
		newEthnic.setKyEthnicCode(kyEthnicCode);
		this.saveEthnic(newEthnic);
		return newEthnic;

	}

}
