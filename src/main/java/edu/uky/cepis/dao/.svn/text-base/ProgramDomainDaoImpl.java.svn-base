/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.StandardSet;
import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;

/**
 * @author keerthi
 * 
 */
public class ProgramDomainDaoImpl implements ProgramDomainDao {

	private static Logger log = Logger.getLogger(ProgramDomainDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramDomainDao#createProgramDomain(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ProgramDomain createProgramDomain(String programDomainCode,
			String shortDesc, String description, String status) {
		ProgramDomain programDomain = new ProgramDomain(programDomainCode,
				shortDesc, description, status);
		if (programDomain == null) {
			return programDomain;
		}
		if (!this.saveProgramDomain(programDomain)) {
			return null;
		}
		return programDomain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramDomainDao#deleteProgramDomain(edu.uky.cepis.
	 * domain.component.ProgramDomain)
	 */
	@Override
	public boolean deleteProgramDomain(ProgramDomain programDomain) {
		if (programDomain == null) {
			return false;
		}

		this.sessionFactory.getCurrentSession().delete(programDomain);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramDomainDao#findProgramDomainByCode(java.lang.
	 * String)
	 */
	@Override
	public ProgramDomain findProgramDomainByCode(String programDomainCode) {
		if (programDomainCode.isEmpty()) {
			return null;
		}
		List<ProgramDomain> programDomains = null;
		ProgramDomain programDomain = null;

		String hql = "select a from ProgramDomain a where a.programDomainCode ='"
				+ programDomainCode + "'";
		programDomains = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (programDomains.size() < 1) {
			return null;
		}
		programDomain = programDomains.get(0);

		return programDomain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.ProgramDomainDao#findProgramDomainByID(long)
	 */
	@Override
	public ProgramDomain findProgramDomainByID(long programdomainid) {
		if (programdomainid < 1) {
			return null;
		}
		List<ProgramDomain> programDomains = null;
		ProgramDomain programDomain = null;

		String hql = "select a from ProgramDomain a where a.programdomainid ="
				+ programdomainid + "";
		programDomains = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (programDomains.size() < 1) {
			return null;
		}
		programDomain = programDomains.get(0);

		return programDomain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.ProgramDomainDao#getProgramDomainList()
	 */
	@Override
	public List<ProgramDomain> getProgramDomainList() {
		List<ProgramDomain> programDomains = new ArrayList<ProgramDomain>(0);

		String hql = "select a from ProgramDomain a order by status,shortDesc";
		programDomains = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		return programDomains;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramDomainDao#getProgramListFromDomain(edu.uky.cepis
	 * .domain.component.ProgramDomain)
	 */
	@Override
	public List<Program> getProgramListFromDomain(ProgramDomain programDomain) {
		List<Program> programs = new ArrayList<Program>(0);
		if (programDomain == null) {
			return programs;
		}

		String hql = "select program from ProgramDomain as programDomain join programDomain.programs program where programDomain.programDomainCode='"
				+ programDomain.getProgramDomainCode()
				+ "' order by program.status,program.shortDesc";

		programs = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return programs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramDomainDao#saveProgramDomainDao(edu.uky.cepis
	 * .dao.ProgramDomainDao)
	 */
	@Override
	public boolean saveProgramDomain(ProgramDomain programDomain) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(programDomain);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramDomainDao#updateProgramDomain(edu.uky.cepis.
	 * domain.component.ProgramDomain, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public ProgramDomain updateProgramDomain(ProgramDomain programDomain,
			String programDomainCode, String shortDesc, String description,
			String status) {
		if (programDomain == null) {
			return null;
		}
		programDomain.setDescription(description);
		programDomain.setShortDesc(shortDesc);
		programDomain.setProgramDomainCode(programDomainCode);
		programDomain.setStatus(status);
		this.saveProgramDomain(programDomain);
		return programDomain;
	}

	@Override
	public List<StandardSet> getStandardSets(ProgramDomain programDomain) {
		System.out.println("Calling getStandardSets");
		List<StandardSet> standardSets = new ArrayList<StandardSet>(0);
		if (programDomain == null) {
			System.out.println("empty progdomain");
			return standardSets;
		}
		String hql = "select stdSet from ProgramDomain as programdomain join programdomain.standardSets stdSet where programdomain.programDomainCode='"
				+ programDomain.getProgramDomainCode() + "'";

		standardSets = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (standardSets != null) {
			return standardSets;
		} else {
			return new ArrayList<StandardSet>(0);
		}

	}

}
