/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.UKTermDao;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author  keerthi
 */
public class UKTermServiceImpl implements UKTermService {

	/**
	 * @uml.property  name="ukTermDao"
	 * @uml.associationEnd  
	 */
	private UKTermDao ukTermDao;

	/**
	 * @param ukTermDao  the ukTermDao to set
	 * @uml.property  name="ukTermDao"
	 */
	public void setUkTermDao(UKTermDao ukTermDao) {
		this.ukTermDao = ukTermDao;
	}

	/**
	 * @return  the ukTermDao
	 * @uml.property  name="ukTermDao"
	 */
	public UKTermDao getUkTermDao() {
		return ukTermDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.UKTermService#createUKTerm(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public UKTerm createUKTerm(String ukTermCode, String shortDesc,
			String description, String status) {

		return this.getUkTermDao().createUKTerm(ukTermCode, shortDesc,
				description, status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKTermService#deleteUKTerm(edu.uky.cepis.domain
	 * .UKTerm)
	 */
	@Override
	public boolean deleteUKTerm(UKTerm UKTerm) {
		return this.getUkTermDao().deleteUKTerm(UKTerm);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKTermService#findUKTermByCode(java.lang.String)
	 */
	@Override
	public UKTerm findUKTermByCode(String ukTermCode) {

		return this.getUkTermDao().findUKTermByCode(ukTermCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.UKTermService#findUKTermByID(long)
	 */
	@Override
	public UKTerm findUKTermByID(long uktermid) {

		return this.getUkTermDao().findUKTermByID(uktermid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.UKTermService#getUKTermList()
	 */
	@Override
	public List<UKTerm> getUKTermList() {

		return this.getUkTermDao().getUKTermList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKTermService#saveUKTerm(edu.uky.cepis.domain.UKTerm
	 * )
	 */
	@Override
	public boolean saveUKTerm(UKTerm ukTerm) {

		return this.getUkTermDao().saveUKTerm(ukTerm);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.UKTermService#updateUKTerm(edu.uky.cepis.domain
	 * .UKTerm, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public UKTerm updateUKTerm(UKTerm ukTerm, String ukTermCode,
			String shortDesc, String description, String status) {
		return this.getUkTermDao().updateUKTerm(ukTerm, ukTermCode, shortDesc,
				description, status);
	}

}
