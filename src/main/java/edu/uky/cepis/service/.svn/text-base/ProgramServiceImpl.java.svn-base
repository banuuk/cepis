/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.ProgramDao;
import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;

/**
 * @author  keerthi
 */
public class ProgramServiceImpl implements ProgramService {

	/**
	 * @uml.property  name="programDao"
	 * @uml.associationEnd  
	 */
	private ProgramDao programDao;

	/**
	 * @param programDao  the programDao to set
	 * @uml.property  name="programDao"
	 */
	public void setProgramDao(ProgramDao programDao) {
		this.programDao = programDao;
	}

	/**
	 * @return  the programDao
	 * @uml.property  name="programDao"
	 */
	public ProgramDao getProgramDao() {
		return programDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramService#addProgramToDomain(edu.uky.cepis
	 * .domain.component.Program, edu.uky.cepis.domain.component.ProgramDomain)
	 */
	@Override
	public boolean addProgramToDomain(Program program,
			ProgramDomain programDomain) {

		return this.getProgramDao().addProgramToDomain(program, programDomain);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.ProgramService#createProgram(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Program createProgram(String programCode, String shortDesc,
			String description, String status) {

		return this.getProgramDao().createProgram(programCode, shortDesc,
				description, status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramService#deleteProgram(edu.uky.cepis.domain
	 * .component.Program)
	 */
	@Override
	public boolean deleteProgram(Program program) {

		return this.getProgramDao().deleteProgram(program);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramService#deleteProgramFromDomain(edu.uky.
	 * cepis.domain.component.Program,
	 * edu.uky.cepis.domain.component.ProgramDomain)
	 */
	@Override
	public boolean deleteProgramFromDomain(Program program,
			ProgramDomain programDomain) {

		return this.getProgramDao().deleteProgramFromDomain(program,
				programDomain);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramService#findProgramByCode(java.lang.String)
	 */
	@Override
	public Program findProgramByCode(String programCode) {

		return this.getProgramDao().findProgramByCode(programCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramService#findProgramByCode(edu.uky.cepis.
	 * domain.component.ProgramDomain, java.lang.String)
	 */
	@Override
	public Program findProgramByCode(ProgramDomain programDomain,
			String programCode) {

		return this.getProgramDao().findProgramByCode(programDomain,
				programCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.ProgramService#findProgramByID(long)
	 */
	@Override
	public Program findProgramByID(long programid) {

		return this.getProgramDao().findProgramByID(programid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramService#findProgramByID(edu.uky.cepis.domain
	 * .component.ProgramDomain, long)
	 */
	@Override
	public Program findProgramByID(ProgramDomain programDomain, long programid) {

		return this.getProgramDao().findProgramByID(programDomain, programid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.ProgramService#getProgramList()
	 */
	@Override
	public List<Program> getProgramList() {

		return this.getProgramDao().getProgramList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramService#saveProgram(edu.uky.cepis.domain
	 * .component.Program)
	 */
	@Override
	public boolean saveProgram(Program program) {

		return this.getProgramDao().saveProgram(program);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramService#updateProgram(edu.uky.cepis.domain
	 * .component.Program, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Program updateProgram(Program program, String programCode,
			String shortDesc, String description, String status) {

		return this.getProgramDao().updateProgram(program, programCode,
				shortDesc, description, status);
	}

}
