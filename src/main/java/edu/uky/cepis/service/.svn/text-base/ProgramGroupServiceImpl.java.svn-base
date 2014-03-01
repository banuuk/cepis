/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.ProgramGroupDao;
import edu.uky.cepis.domain.component.ProgramGroup;

/**
 * @author  keerthi
 */
public class ProgramGroupServiceImpl implements ProgramGroupService {

	/**
	 * @uml.property  name="programGroupDao"
	 * @uml.associationEnd  
	 */
	private ProgramGroupDao programGroupDao;

	/**
	 * @param programGroupDao  the programGroupDao to set
	 * @uml.property  name="programGroupDao"
	 */
	public void setProgramGroupDao(ProgramGroupDao programGroupDao) {
		this.programGroupDao = programGroupDao;
	}

	/**
	 * @return  the programGroupDao
	 * @uml.property  name="programGroupDao"
	 */
	public ProgramGroupDao getProgramGroupDao() {
		return programGroupDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramGroupService#createProgramGroup(java.lang
	 * .String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ProgramGroup createProgramGroup(String programGroupCode,
			String shortDesc, String description, String status) {

		return this.getProgramGroupDao().createProgramGroup(programGroupCode,
				shortDesc, description, status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramGroupService#deleteProgramGroup(edu.uky.
	 * cepis.domain.component.ProgramGroup)
	 */
	@Override
	public boolean deleteProgramGroup(ProgramGroup programGroup) {

		return this.getProgramGroupDao().deleteProgramGroup(programGroup);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramGroupService#findProgramGroupByCode(java
	 * .lang.String)
	 */
	@Override
	public ProgramGroup findProgramGroupByCode(String programGroupCode) {

		return this.getProgramGroupDao().findProgramGroupByCode(
				programGroupCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.ProgramGroupService#findProgramGroupByID(long)
	 */
	@Override
	public ProgramGroup findProgramGroupByID(long programgroupid) {

		return this.getProgramGroupDao().findProgramGroupByID(programgroupid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.ProgramGroupService#getProgramGroupList()
	 */
	@Override
	public List<ProgramGroup> getProgramGroupList() {

		return this.getProgramGroupDao().getProgramGroupList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramGroupService#saveProgramGroup(edu.uky.cepis
	 * .domain.component.ProgramGroup)
	 */
	@Override
	public boolean saveProgramGroup(ProgramGroup programGroup) {

		return this.getProgramGroupDao().saveProgramGroup(programGroup);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramGroupService#updateProgramGroup(edu.uky.
	 * cepis.domain.component.ProgramGroup, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public ProgramGroup updateProgramGroup(ProgramGroup programGroup,
			String programGroupCode, String shortDesc, String description,
			String status) {

		return this.getProgramGroupDao().updateProgramGroup(programGroup,
				programGroupCode, shortDesc, description, status);
	}

}
