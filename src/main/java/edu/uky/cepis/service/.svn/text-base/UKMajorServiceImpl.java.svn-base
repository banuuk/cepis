/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.UKMajorDao;
import edu.uky.cepis.domain.component.UKMajor;

/**
 * @author  keerthi
 */
public class UKMajorServiceImpl implements UKMajorService {

	/**
	 * @uml.property  name="ukMajorDao"
	 * @uml.associationEnd  
	 */
	private UKMajorDao ukMajorDao;

	/**
	 * @param ukMajorDao  the ukMajorDao to set
	 * @uml.property  name="ukMajorDao"
	 */
	public void setUkMajorDao(UKMajorDao ukMajorDao) {
		this.ukMajorDao = ukMajorDao;
	}

	/**
	 * @return  the ukMajorDao
	 * @uml.property  name="ukMajorDao"
	 */
	public UKMajorDao getUkMajorDao() {
		return ukMajorDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.UKMajorService#createUKMajor(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public UKMajor createUKMajor(String ukMajorCode, String shortDesc,
			String description, String status, String degreeLevel) {

		return this.getUkMajorDao().createUKMajor(ukMajorCode, shortDesc,
				description, status, degreeLevel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKMajorService#deleteUKMajor(edu.uky.cepis.domain
	 * .UKMajor)
	 */
	@Override
	public boolean deleteUKMajor(UKMajor UKMajor) {

		return this.getUkMajorDao().deleteUKMajor(UKMajor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKMajorService#findUKMajorByCode(java.lang.String)
	 */
	@Override
	public UKMajor findUKMajorByCode(String UKMajorCode) {

		return this.getUkMajorDao().findUKMajorByCode(UKMajorCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.UKMajorService#findUKMajorByID(long)
	 */
	@Override
	public UKMajor findUKMajorByID(long UKMajorid) {

		return this.getUkMajorDao().findUKMajorByID(UKMajorid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.UKMajorService#getUKMajorList()
	 */
	@Override
	public List<UKMajor> getUKMajorList() {

		return this.getUkMajorDao().getUKMajorList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKMajorService#saveUKMajor(edu.uky.cepis.domain
	 * .UKMajor)
	 */
	@Override
	public boolean saveUKMajor(UKMajor ukMajor) {

		return this.getUkMajorDao().saveUKMajor(ukMajor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKMajorService#updateUKMajor(edu.uky.cepis.domain
	 * .UKMajor, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public UKMajor updateUKMajor(UKMajor ukMajor, String ukMajorCode,
			String shortDesc, String description, String status,
			String degreeLevel) {

		return this.getUkMajorDao().updateUKMajor(ukMajor, ukMajorCode,
				shortDesc, description, status, degreeLevel);
	}

}
