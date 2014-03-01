/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;

/**
 * @author keerthi
 * 
 */
public class ProgramDaoImpl implements ProgramDao {

	private static Logger log = Logger.getLogger(ProgramDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramDao#addProgramToDomain(edu.uky.cepis.domain.
	 * component.Program, edu.uky.cepis.domain.component.ProgramDomain)
	 */
	@Override
	public boolean addProgramToDomain(Program program,
			ProgramDomain programDomain) {
		if (programDomain == null) {
			return false;
		}
		if (program == null) {
			return false;
		}

		ProgramDomain newprogramdomain = (ProgramDomain) this.sessionFactory
				.getCurrentSession().load(ProgramDomain.class,
						programDomain.getProgramDomainCode());
		if (newprogramdomain == null) {
			return false;
		}
		if (!newprogramdomain.getPrograms().contains(program)) {
			newprogramdomain.getPrograms().add(program);
		}
		this.sessionFactory.getCurrentSession().saveOrUpdate(newprogramdomain);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.ProgramDao#createProgram(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Program createProgram(String programCode, String shortDesc,
			String description, String status) {
		Program program = new Program(programCode, shortDesc, description,
				status);
		if (program == null) {
			return program;
		}
		if (!this.saveProgram(program)) {
			return null;
		}
		return program;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramDao#deleteProgram(edu.uky.cepis.domain.component
	 * .Program)
	 */
	@Override
	public boolean deleteProgram(Program program) {
		if (program == null) {
			return false;
		}

		this.sessionFactory.getCurrentSession().delete(program);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramDao#deleteProgramFromDomain(edu.uky.cepis.domain
	 * .component.Program, edu.uky.cepis.domain.component.ProgramDomain)
	 */
	@Override
	public boolean deleteProgramFromDomain(Program program,
			ProgramDomain programDomain) {
		if (programDomain == null) {
			return false;
		}
		if (program == null) {
			return false;
		}

		ProgramDomain newprogramdomain = (ProgramDomain) this.sessionFactory
				.getCurrentSession().load(ProgramDomain.class,
						programDomain.getProgramDomainCode());
		if (!newprogramdomain.getPrograms().contains(program)) {
			return false;
		}
		if (!newprogramdomain.getPrograms().remove(program)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.ProgramDao#findProgramByCode(java.lang.String)
	 */
	@Override
	public Program findProgramByCode(String programCode) {
		if (programCode.isEmpty()) {
			return null;
		}
		List<Program> programs = null;
		Program program = null;
		String hql = "select a from Program a where a.programCode ='"
				+ programCode + "'";
		programs = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (programs.size() < 1) {
			return null;
		}
		program = programs.get(0);

		return program;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramDao#findProgramByCode(edu.uky.cepis.domain.component
	 * .ProgramDomain, java.lang.String)
	 */
	@Override
	public Program findProgramByCode(ProgramDomain programDomain,
			String programCode) {
		Set<Program> programs = null;
		Program program = null;
		Program temp = null;

		ProgramDomain newprogramdomain = (ProgramDomain) this.sessionFactory
				.getCurrentSession().load(ProgramDomain.class,
						programDomain.getProgramDomainCode());
		programs = newprogramdomain.getPrograms();
		Iterator<Program> iter = programs.iterator();
		while (iter.hasNext()) {
			temp = iter.next();
			if (temp.getProgramCode().equals(programCode)) {
				program = temp;
				break;
			}
		}
		return program;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.ProgramDao#findProgramByID(long)
	 */
	@Override
	public Program findProgramByID(long programid) {
		if (programid < 0) {
			return null;
		}
		List<Program> programs = null;
		Program program = null;
		String hql = "select a from Program a where a.programid =" + programid
				+ "";
		programs = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (programs.size() < 1) {
			return null;
		}
		program = programs.get(0);

		return program;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramDao#findProgramByID(edu.uky.cepis.domain.component
	 * .ProgramDomain, long)
	 */
	@Override
	public Program findProgramByID(ProgramDomain programDomain, long programid) {
		Set<Program> programs = null;
		Program program = null;
		Program temp = null;

		ProgramDomain newprogramdomain = (ProgramDomain) this.sessionFactory
				.getCurrentSession().load(ProgramDomain.class,
						programDomain.getProgramDomainCode());
		programs = newprogramdomain.getPrograms();
		Iterator<Program> iter = programs.iterator();
		while (iter.hasNext()) {
			temp = iter.next();
			program = temp;
			break;

		}
		return program;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.ProgramDao#getProgramList()
	 */
	@Override
	public List<Program> getProgramList() {
		List<Program> programs = new ArrayList<Program>(0);

		String hql = "select a from Program a order by status,shortDesc";
		programs = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return programs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramDao#saveProgramDao(edu.uky.cepis.dao.ProgramDao)
	 */
	@Override
	public boolean saveProgram(Program program) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(program);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramDao#updateProgram(edu.uky.cepis.domain.component
	 * .Program, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Program updateProgram(Program program, String programCode,
			String shortDesc, String description, String status) {
		if (program == null) {
			return null;
		}

		Program newprogram = (Program) this.sessionFactory.getCurrentSession()
				.load(Program.class, program.getProgramCode());
		newprogram.setDescription(description);
		newprogram.setProgramCode(programCode);
		newprogram.setShortDesc(shortDesc);
		newprogram.setStatus(status);
		this.saveProgram(newprogram);
		return newprogram;
	}

}
