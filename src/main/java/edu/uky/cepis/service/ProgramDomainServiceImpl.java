/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import java.util.Set;

import edu.uky.cepis.dao.ProgramDomainDao;
import edu.uky.cepis.domain.StandardSet;
import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;

/**
 * @author keerthi
 */
public class ProgramDomainServiceImpl implements ProgramDomainService {

	/**
	 * @uml.property name="programDomainDao"
	 * @uml.associationEnd
	 */
	private ProgramDomainDao programDomainDao;

	/**
	 * @param programDomainDao
	 *            the programDomainDao to set
	 * @uml.property name="programDomainDao"
	 */
	public void setProgramDomainDao(ProgramDomainDao programDomainDao) {
		this.programDomainDao = programDomainDao;
	}

	/**
	 * @return the programDomainDao
	 * @uml.property name="programDomainDao"
	 */
	public ProgramDomainDao getProgramDomainDao() {
		return programDomainDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramDomainService#createProgramDomain(java.lang
	 * .String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ProgramDomain createProgramDomain(String programDomainCode,
			String shortDesc, String description, String status) {

		return this.getProgramDomainDao().createProgramDomain(
				programDomainCode, shortDesc, description, status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramDomainService#deleteProgramDomain(edu.uky
	 * .cepis.domain.component.ProgramDomain)
	 */
	@Override
	public boolean deleteProgramDomain(ProgramDomain programDomain) {

		return this.getProgramDomainDao().deleteProgramDomain(programDomain);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramDomainService#findProgramDomainByCode(java
	 * .lang.String)
	 */
	@Override
	public ProgramDomain findProgramDomainByCode(String programDomainCode) {

		return this.getProgramDomainDao().findProgramDomainByCode(
				programDomainCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramDomainService#findProgramDomainByID(long)
	 */
	@Override
	public ProgramDomain findProgramDomainByID(long programdomainid) {

		return this.getProgramDomainDao()
				.findProgramDomainByID(programdomainid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.ProgramDomainService#getProgramDomainList()
	 */
	@Override
	public List<ProgramDomain> getProgramDomainList() {

		return this.getProgramDomainDao().getProgramDomainList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramDomainService#getProgramListFromDomain(edu
	 * .uky.cepis.domain.component.ProgramDomain)
	 */
	@Override
	public List<Program> getProgramListFromDomain(ProgramDomain programDomain) {

		return this.getProgramDomainDao().getProgramListFromDomain(
				programDomain);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramDomainService#saveProgramDomain(edu.uky.
	 * cepis.domain.component.ProgramDomain)
	 */
	@Override
	public boolean saveProgramDomain(ProgramDomain programDomain) {

		return this.getProgramDomainDao().saveProgramDomain(programDomain);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramDomainService#updateProgramDomain(edu.uky
	 * .cepis.domain.component.ProgramDomain, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ProgramDomain updateProgramDomain(ProgramDomain programDomain,
			String programDomainCode, String shortDesc, String description,
			String status) {

		return this.getProgramDomainDao().updateProgramDomain(programDomain,
				programDomainCode, shortDesc, description, status);
	}

	@Override
	public List<StandardSet> getStandardSets(ProgramDomain programDomain) {
		return this.getProgramDomainDao().getStandardSets(programDomain);
	}

}
