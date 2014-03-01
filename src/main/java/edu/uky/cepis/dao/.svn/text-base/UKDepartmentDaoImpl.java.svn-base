/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.component.UKCollege;
import edu.uky.cepis.domain.component.UKDepartment;

/**
 * @author keerthi
 * 
 */
public class UKDepartmentDaoImpl implements UKDepartmentDao {

	private static Logger log = Logger.getLogger(UKDepartmentDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKDepartmentDao#createUKDepartment(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public UKDepartment createUKDepartment(String departmentCode,
			String departmentName, String departmentAddress, String speedSort,
			String departmentChairName, String departmentContact,
			String shortDescription, String status) {
		UKDepartment ukDepartment = new UKDepartment(departmentCode,
				departmentName, departmentAddress, speedSort,
				departmentChairName, departmentContact, shortDescription,
				status);
		if (ukDepartment == null) {
			return null;
		}
		if (!this.saveUKDepartment(ukDepartment)) {
			return null;
		}
		return ukDepartment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKDepartmentDao#deleteUKDepartment(edu.uky.cepis.domain
	 * .component.UKDepartment)
	 */
	@Override
	public boolean deleteUKDepartment(UKDepartment uKDepartment) {
		if (uKDepartment == null) {
			return false;
		}

		this.sessionFactory.getCurrentSession().delete(uKDepartment);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKDepartmentDao#findUKDepartmentByChair(java.lang.String
	 * )
	 */
	@Override
	public UKDepartment findUKDepartmentByChair(String chairName) {
		UKDepartment ukDepartment = null;
		List<UKDepartment> ukDepartments = new ArrayList<UKDepartment>(0);

		String hql = "select a from UKDepartment a where a.departmentChairName like '"
				+ chairName + "'";
		ukDepartments = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (ukDepartments.isEmpty())
			return null;
		ukDepartment = ukDepartments.get(0);
		if (ukDepartment == null) {
			return null;
		}
		return ukDepartment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKDepartmentDao#findUKDepartmentByCode(java.lang.String
	 * )
	 */
	@Override
	public UKDepartment findUKDepartmentByCode(String uKDepartmentCode) {
		UKDepartment ukDepartment = null;
		List<UKDepartment> ukDepartments = new ArrayList<UKDepartment>(0);

		String hql = "select a from UKDepartment a where a.departmentCode = '"
				+ uKDepartmentCode + "'";
		ukDepartments = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();

		if (ukDepartments.isEmpty())
			return null;
		ukDepartment = ukDepartments.get(0);
		if (ukDepartment == null) {
			return null;
		}
		return ukDepartment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKDepartmentDao#findUKDepartmentByName(java.lang.String
	 * )
	 */
	@Override
	public UKDepartment findUKDepartmentByName(String departmentName) {
		UKDepartment ukDepartment = null;
		List<UKDepartment> ukDepartments = new ArrayList<UKDepartment>(0);

		String hql = "select a from UKDepartment a where a.departmentName like '"
				+ departmentName + "'";
		ukDepartments = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (ukDepartments.isEmpty())
			return null;
		ukDepartment = ukDepartments.get(0);
		if (ukDepartment == null) {
			return null;
		}
		return ukDepartment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UKDepartmentDao#getUKDepartmentList()
	 */
	@Override
	public List<UKDepartment> getUKDepartmentList() {
		List<UKDepartment> ukDepartments = new ArrayList<UKDepartment>(0);

		String hql = "select a from UKDepartment a order by departmentName";
		ukDepartments = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (ukDepartments.isEmpty())
			return null;

		return ukDepartments;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKDepartmentDao#saveUKDepartment(edu.uky.cepis.domain
	 * .component.UKDepartment)
	 */
	@Override
	public boolean saveUKDepartment(UKDepartment uKDepartment) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(uKDepartment);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UKDepartmentDao#updateUKDepartment(edu.uky.cepis.domain
	 * .component.UKDepartment, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public UKDepartment updateUKDepartment(UKDepartment ukDepartment,
			String departmentCode, String departmentName,
			String departmentAddress, String speedSort,
			String departmentChairName, String departmentContact,
			String shortDescription, String status) {
		if (ukDepartment == null)
			return null;

		ukDepartment.setDepartmentAddress(departmentAddress);
		ukDepartment.setDepartmentChairName(departmentChairName);
		ukDepartment.setDepartmentCode(departmentCode);
		ukDepartment.setDepartmentContact(departmentContact);
		ukDepartment.setDepartmentName(departmentName);
		ukDepartment.setShortDescription(shortDescription);
		ukDepartment.setSpeedSort(speedSort);
		ukDepartment.setStatus(status);
		this.saveUKDepartment(ukDepartment);
		return ukDepartment;
	}

}
