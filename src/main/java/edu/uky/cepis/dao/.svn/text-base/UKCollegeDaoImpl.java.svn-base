/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.CohortType;
import edu.uky.cepis.domain.component.UKCollege;
import edu.uky.cepis.domain.component.UKDepartment;

/**
 * @author keerthi
 * 
 */
public class UKCollegeDaoImpl implements UKCollegeDao {

	private static Logger log = Logger.getLogger(UKCollegeDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKCollegeDao#addUKDepartmentToUKCollege(edu.uky.cepis
	 * .domain.component.UKDepartment, edu.uky.cepis.domain.component.UKCollege)
	 */
	@Override
	public boolean addUKDepartmentToUKCollege(UKDepartment uKDepartment,
			UKCollege ukCollege) {
		if (ukCollege == null)
			return false;
		if (uKDepartment == null)
			return false;
		UKCollege newUKCollege = null;

		newUKCollege = (UKCollege) this.sessionFactory.getCurrentSession()
				.load(UKCollege.class, ukCollege.getUkCollegeCode());
		if (newUKCollege == null) {
			return false;
		}
		newUKCollege.getDepartments().add(uKDepartment);
		this.saveUKCollege(newUKCollege);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKCollegeDao#createUKCollege(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public UKCollege createUKCollege(String ukCollegeCode, String collegeName,
			String collegeAddress, String collegeSpeedSort,
			String collegePhone, String collegeDeanName) {
		UKCollege ukCollege = new UKCollege(ukCollegeCode, collegeName,
				collegeAddress, collegeSpeedSort, collegePhone, collegeDeanName);

		this.saveUKCollege(ukCollege);
		return ukCollege;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKCollegeDao#deleteUKCollege(edu.uky.cepis.domain.component
	 * .UKCollege)
	 */
	@Override
	public boolean deleteUKCollege(UKCollege ukCollege) {
		if (ukCollege == null) {
			return false;
		}

		this.sessionFactory.getCurrentSession().delete(ukCollege);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKCollegeDao#findUKCollegeByCode(java.lang.String)
	 */
	@Override
	public UKCollege findUKCollegeByCode(String ukCollegeCode) {
		UKCollege ukCollege = null;
		List<UKCollege> ukColleges = new ArrayList<UKCollege>(0);
		String hql = "select a from UKCollege a where a.ukCollegeCode = '"
				+ ukCollegeCode + "'";
		ukColleges = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (ukColleges.isEmpty())
			return null;
		ukCollege = ukColleges.get(0);
		return ukCollege;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKCollegeDao#findUKCollegeByDean(java.lang.String)
	 */
	@Override
	public UKCollege findUKCollegeByDean(String deanName) {
		UKCollege ukCollege = null;
		List<UKCollege> ukColleges = new ArrayList<UKCollege>(0);
		String hql = "select a from UKCollege a where a.collegeDeanName like '"
				+ deanName + "'";
		ukColleges = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (ukColleges.isEmpty())
			return null;
		ukCollege = ukColleges.get(0);
		return ukCollege;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKCollegeDao#findUKCollegeByName(java.lang.String)
	 */
	@Override
	public UKCollege findUKCollegeByName(String collegeName) {
		UKCollege ukCollege = null;
		List<UKCollege> ukColleges = new ArrayList<UKCollege>(0);
		String hql = "select a from UKCollege a where a.collegeName like '"
				+ collegeName + "'";
		ukColleges = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (ukColleges.isEmpty())
			return null;
		ukCollege = ukColleges.get(0);
		return ukCollege;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKCollegeDao#getUKCollegeList()
	 */
	@Override
	public List<UKCollege> getUKCollegeList() {
		List<UKCollege> ukColleges = new ArrayList<UKCollege>(0);

		String hql = "select a from UKCollege a order by collegeName";
		ukColleges = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (ukColleges.isEmpty())
			return null;

		return ukColleges;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKCollegeDao#removeUKDepartmentFromUKCollege(edu.uky
	 * .cepis.domain.component.UKDepartment,
	 * edu.uky.cepis.domain.component.UKCollege)
	 */
	@Override
	public boolean removeUKDepartmentFromUKCollege(UKDepartment uKDepartment,
			UKCollege ukCollege) {
		if (ukCollege == null)
			return false;
		if (uKDepartment == null)
			return false;
		UKCollege newUKCollege = null;

		newUKCollege = (UKCollege) this.sessionFactory.getCurrentSession()
				.load(UKCollege.class, ukCollege.getUkCollegeCode());
		if (newUKCollege == null) {
			return false;
		}
		newUKCollege.getDepartments().remove(uKDepartment);
		this.saveUKCollege(newUKCollege);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKCollegeDao#saveUKCollege(edu.uky.cepis.domain.component
	 * .UKCollege)
	 */
	@Override
	public boolean saveUKCollege(UKCollege ukCollege) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(ukCollege);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKCollegeDao#updateUKCollege(edu.uky.cepis.domain.component
	 * .UKCollege, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public UKCollege updateUKCollege(UKCollege ukCollege, String ukCollegeCode,
			String collegeName, String collegeAddress, String collegeSpeedSort,
			String collegePhone, String collegeDeanName) {
		if (ukCollege == null)
			return null;
		ukCollege.setCollegeAddress(collegeAddress);
		ukCollege.setCollegeDeanName(collegeDeanName);
		ukCollege.setCollegeName(collegeName);
		ukCollege.setCollegePhone(collegePhone);
		ukCollege.setCollegeSpeedSort(collegeSpeedSort);
		ukCollege.setUkCollegeCode(ukCollegeCode);
		this.saveUKCollege(ukCollege);
		return ukCollege;
	}

}
