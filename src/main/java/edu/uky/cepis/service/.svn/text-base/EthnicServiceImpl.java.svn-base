/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import java.util.Set;

import edu.uky.cepis.dao.EthnicDao;
import edu.uky.cepis.domain.Ethnic;

/**
 * @author  keerthi
 */
public class EthnicServiceImpl implements EthnicService {

	/**
	 * @uml.property  name="ethnicDao"
	 * @uml.associationEnd  
	 */
	private EthnicDao ethnicDao;

	/**
	 * @return  the ethnicDao
	 * @uml.property  name="ethnicDao"
	 */
	public EthnicDao getEthnicDao() {
		return ethnicDao;
	}

	/**
	 * @param ethnicDao  the ethnicDao to set
	 * @uml.property  name="ethnicDao"
	 */
	public void setEthnicDao(EthnicDao ethnicDao) {
		this.ethnicDao = ethnicDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.EthnicService#createEthnic(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public Ethnic createEthnic(String code, String ethnicity,
			String kyEthnicCode) {
		return this.getEthnicDao().createEthnic(code, ethnicity, kyEthnicCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EthnicService#deleteEthnic(edu.uky.cepis.domain
	 * .Ethnic)
	 */
	@Override
	public boolean deleteEthnic(Ethnic ethnic) {
		return this.getEthnicDao().deleteEthnic(ethnic);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EthnicService#findByEthnicCode(java.lang.String)
	 */
	@Override
	public Ethnic findByEthnicCode(String code) {
		return this.getEthnicDao().findByEthnicCode(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.EthnicService#getEthnicList()
	 */
	@Override
	public List<Ethnic> getEthnicList() {
		return this.getEthnicDao().getEthnicList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EthnicService#saveEthnic(edu.uky.cepis.domain.Ethnic
	 * )
	 */
	@Override
	public boolean saveEthnic(Ethnic ethnic) {
		return this.getEthnicDao().saveEthnic(ethnic);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EthnicService#updateEthnic(edu.uky.cepis.domain
	 * .Ethnic, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Ethnic updateEthnic(Ethnic ethnic, String code, String ethnicity,
			String kyEthnicCode) {
		return this.getEthnicDao().updateEthnic(ethnic, code, ethnicity,
				kyEthnicCode);
	}

}
