/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.UKCollegeDao;
import edu.uky.cepis.domain.component.UKCollege;
import edu.uky.cepis.domain.component.UKDepartment;

/**
 * @author  keerthi
 */
public class UKCollegeServiceImpl implements UKCollegeService {

	/**
	 * @uml.property  name="ukCollegeDao"
	 * @uml.associationEnd  
	 */
	private UKCollegeDao ukCollegeDao;

	/**
	 * @param ukCollegeDao  the ukCollegeDao to set
	 * @uml.property  name="ukCollegeDao"
	 */
	public void setUkCollegeDao(UKCollegeDao ukCollegeDao) {
		this.ukCollegeDao = ukCollegeDao;
	}

	/**
	 * @return  the ukCollegeDao
	 * @uml.property  name="ukCollegeDao"
	 */
	public UKCollegeDao getUkCollegeDao() {
		return ukCollegeDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKCollegeService#addUKDepartmentToUKCollege(edu
	 * .uky.cepis.domain.component.UKDepartment,
	 * edu.uky.cepis.domain.component.UKCollege)
	 */
	@Override
	public boolean addUKDepartmentToUKCollege(UKDepartment uKDepartment,
			UKCollege UKCollege) {
		return this.getUkCollegeDao().addUKDepartmentToUKCollege(uKDepartment,
				UKCollege);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKCollegeService#createUKCollege(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public UKCollege createUKCollege(String ukCollegeCode, String collegeName,
			String collegeAddress, String collegeSpeedSort,
			String collegePhone, String collegeDeanName) {
		return this.getUkCollegeDao().createUKCollege(ukCollegeCode,
				collegeName, collegeAddress, collegeSpeedSort, collegePhone,
				collegeDeanName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKCollegeService#deleteUKCollege(edu.uky.cepis.
	 * domain.component.UKCollege)
	 */
	@Override
	public boolean deleteUKCollege(UKCollege UKCollege) {
		return this.getUkCollegeDao().deleteUKCollege(UKCollege);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKCollegeService#findUKCollegeByCode(java.lang.
	 * String)
	 */
	@Override
	public UKCollege findUKCollegeByCode(String ukCollegeCode) {
		return this.getUkCollegeDao().findUKCollegeByCode(ukCollegeCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKCollegeService#findUKCollegeByDean(java.lang.
	 * String)
	 */
	@Override
	public UKCollege findUKCollegeByDean(String deanName) {
		return this.getUkCollegeDao().findUKCollegeByDean(deanName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKCollegeService#findUKCollegeByName(java.lang.
	 * String)
	 */
	@Override
	public UKCollege findUKCollegeByName(String collegeName) {
		return this.getUkCollegeDao().findUKCollegeByName(collegeName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.UKCollegeService#getUKCollegeList()
	 */
	@Override
	public List<UKCollege> getUKCollegeList() {
		return this.getUkCollegeDao().getUKCollegeList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKCollegeService#removeUKDepartmentFromUKCollege
	 * (edu.uky.cepis.domain.component.UKDepartment,
	 * edu.uky.cepis.domain.component.UKCollege)
	 */
	@Override
	public boolean removeUKDepartmentFromUKCollege(UKDepartment uKDepartment,
			UKCollege UKCollege) {
		return this.getUkCollegeDao().removeUKDepartmentFromUKCollege(
				uKDepartment, UKCollege);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKCollegeService#saveUKCollege(edu.uky.cepis.domain
	 * .component.UKCollege)
	 */
	@Override
	public boolean saveUKCollege(UKCollege UKCollege) {
		return this.getUkCollegeDao().saveUKCollege(UKCollege);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKCollegeService#updateUKCollege(edu.uky.cepis.
	 * domain.component.UKCollege, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public UKCollege updateUKCollege(UKCollege UKCollege, String ukCollegeCode,
			String collegeName, String collegeAddress, String collegeSpeedSort,
			String collegePhone, String collegeDeanName) {
		return this.getUkCollegeDao().updateUKCollege(UKCollege, ukCollegeCode,
				collegeName, collegeAddress, collegeSpeedSort, collegePhone,
				collegeDeanName);
	}

}
