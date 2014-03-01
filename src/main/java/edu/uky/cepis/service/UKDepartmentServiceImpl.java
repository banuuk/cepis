/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.UKDepartmentDao;
import edu.uky.cepis.domain.component.UKDepartment;

/**
 * @author  keerthi
 */
public class UKDepartmentServiceImpl implements UKDepartmentService {

	/**
	 * @uml.property  name="ukDepartmentDao"
	 * @uml.associationEnd  
	 */
	private UKDepartmentDao ukDepartmentDao;

	/**
	 * @param ukDepartmentDao  the ukDepartmentDao to set
	 * @uml.property  name="ukDepartmentDao"
	 */
	public void setUkDepartmentDao(UKDepartmentDao ukDepartmentDao) {
		this.ukDepartmentDao = ukDepartmentDao;
	}

	/**
	 * @return  the ukDepartmentDao
	 * @uml.property  name="ukDepartmentDao"
	 */
	public UKDepartmentDao getUkDepartmentDao() {
		return ukDepartmentDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKDepartmentService#createUKDepartment(java.lang
	 * .String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public UKDepartment createUKDepartment(String departmentCode,
			String departmentName, String departmentAddress, String speedSort,
			String departmentChairName, String departmentContact,
			String shortDescription, String status) {
		return this.getUkDepartmentDao().createUKDepartment(departmentCode,
				departmentName, departmentAddress, speedSort,
				departmentChairName, departmentContact, shortDescription,
				status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKDepartmentService#deleteUKDepartment(edu.uky.
	 * cepis.domain.component.UKDepartment)
	 */
	@Override
	public boolean deleteUKDepartment(UKDepartment uKDepartment) {
		return this.getUkDepartmentDao().deleteUKDepartment(uKDepartment);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKDepartmentService#findUKDepartmentByChair(java
	 * .lang.String)
	 */
	@Override
	public UKDepartment findUKDepartmentByChair(String chairName) {
		return this.getUkDepartmentDao().findUKDepartmentByChair(chairName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKDepartmentService#findUKDepartmentByCode(java
	 * .lang.String)
	 */
	@Override
	public UKDepartment findUKDepartmentByCode(String uKDepartmentCode) {
		return this.getUkDepartmentDao().findUKDepartmentByCode(
				uKDepartmentCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKDepartmentService#findUKDepartmentByName(java
	 * .lang.String)
	 */
	@Override
	public UKDepartment findUKDepartmentByName(String departmentName) {
		return this.getUkDepartmentDao().findUKDepartmentByName(departmentName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.UKDepartmentService#getUKDepartmentList()
	 */
	@Override
	public List<UKDepartment> getUKDepartmentList() {
		return this.getUkDepartmentDao().getUKDepartmentList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKDepartmentService#saveUKDepartment(edu.uky.cepis
	 * .domain.component.UKDepartment)
	 */
	@Override
	public boolean saveUKDepartment(UKDepartment uKDepartment) {
		return this.getUkDepartmentDao().saveUKDepartment(uKDepartment);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKDepartmentService#updateUKDepartment(edu.uky.
	 * cepis.domain.component.UKDepartment, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public UKDepartment updateUKDepartment(UKDepartment UKDepartment,
			String departmentCode, String departmentName,
			String departmentAddress, String speedSort,
			String departmentChairName, String departmentContact,
			String shortDescription, String status) {
		return this.getUkDepartmentDao().updateUKDepartment(UKDepartment,
				departmentCode, departmentName, departmentAddress, speedSort,
				departmentChairName, departmentContact, shortDescription,
				status);
	}

}
