/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.UKStatusDao;
import edu.uky.cepis.domain.component.UKStatus;

/**
 * @author  keerthi
 */
public class UKStatusServiceImpl implements UKStatusService {

	/**
	 * @uml.property  name="ukStatusDao"
	 * @uml.associationEnd  
	 */
	private UKStatusDao ukStatusDao;

	/**
	 * @param ukStatusDao  the ukStatusDao to set
	 * @uml.property  name="ukStatusDao"
	 */
	public void setUkStatusDao(UKStatusDao ukStatusDao) {
		this.ukStatusDao = ukStatusDao;
	}

	/**
	 * @return  the ukStatusDao
	 * @uml.property  name="ukStatusDao"
	 */
	public UKStatusDao getUkStatusDao() {
		return ukStatusDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKStatusService#createUKStatus(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public UKStatus createUKStatus(String ukStatusCode, String shortDesc,
			String description, String status) {

		return this.getUkStatusDao().createUKStatus(ukStatusCode, shortDesc,
				description, status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKStatusService#deleteUKStatus(edu.uky.cepis.domain
	 * .UKStatus)
	 */
	@Override
	public boolean deleteUKStatus(UKStatus UKStatus) {

		return this.getUkStatusDao().deleteUKStatus(UKStatus);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKStatusService#findUKStatusByCode(java.lang.String
	 * )
	 */
	@Override
	public UKStatus findUKStatusByCode(String ukStatusCode) {

		return this.getUkStatusDao().findUKStatusByCode(ukStatusCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.UKStatusService#findUKStatusByID(long)
	 */
	@Override
	public UKStatus findUKStatusByID(long ukstatusid) {

		return this.getUkStatusDao().findUKStatusByID(ukstatusid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.UKStatusService#getUKStatusList()
	 */
	@Override
	public List<UKStatus> getUKStatusList() {

		return this.getUkStatusDao().getUKStatusList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKStatusService#saveUKStatus(edu.uky.cepis.domain
	 * .UKStatus)
	 */
	@Override
	public boolean saveUKStatus(UKStatus ukStatus) {

		return this.getUkStatusDao().saveUKStatus(ukStatus);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKStatusService#updateUKStatus(edu.uky.cepis.domain
	 * .UKStatus, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public UKStatus updateUKStatus(UKStatus ukStatus, String ukStatusCode,
			String shortDesc, String description, String status) {
		return this.getUkStatusDao().updateUKStatus(ukStatus, ukStatusCode,
				shortDesc, description, status);
	}

}
