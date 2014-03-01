/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.CohortTypeDao;
import edu.uky.cepis.domain.CohortType;

/**
 * @author  keerthi
 */
public class CohortTypeServiceImpl implements CohortTypeService {

	/**
	 * @uml.property  name="cohortTypeDao"
	 * @uml.associationEnd  
	 */
	private CohortTypeDao cohortTypeDao;

	/**
	 * @param cohortTypeDao  the cohortTypeDao to set
	 * @uml.property  name="cohortTypeDao"
	 */
	public void setCohortTypeDao(CohortTypeDao cohortTypeDao) {
		this.cohortTypeDao = cohortTypeDao;
	}

	/**
	 * @return  the cohortTypeDao
	 * @uml.property  name="cohortTypeDao"
	 */
	public CohortTypeDao getCohortTypeDao() {
		return cohortTypeDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.CohortTypeService#createCohortType(java.lang.String
	 * , java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public CohortType createCohortType(String typeCode, String shortDesc,
			String desc, String status) {
		return this.getCohortTypeDao().createCohortType(typeCode, shortDesc,
				desc, status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.CohortTypeService#deleteCohortType(edu.uky.cepis
	 * .domain.CohortType)
	 */
	@Override
	public boolean deleteCohortType(CohortType cohortType) {
		return this.getCohortTypeDao().deleteCohortType(cohortType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.CohortTypeService#findCohortTypeByCode(java.lang
	 * .String)
	 */
	@Override
	public CohortType findCohortTypeByCode(String typeCode) {
		return this.getCohortTypeDao().findCohortTypeByCode(typeCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.CohortTypeService#getCohortTypeList()
	 */
	@Override
	public List<CohortType> getCohortTypeList() {
		return this.getCohortTypeDao().getCohortTypeList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.CohortTypeService#saveCohortType(edu.uky.cepis.
	 * domain.CohortType)
	 */
	@Override
	public boolean saveCohortType(CohortType cohortType) {
		return this.getCohortTypeDao().saveCohortType(cohortType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.CohortTypeService#updateCohortType(edu.uky.cepis
	 * .domain.CohortType, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public CohortType updateCohortType(CohortType cohortType, String typeCode,
			String shortDesc, String desc, String status) {
		return this.getCohortTypeDao().updateCohortType(cohortType, typeCode,
				shortDesc, desc, status);
	}

}
