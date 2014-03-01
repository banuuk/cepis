/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.ProgramTrackDao;
import edu.uky.cepis.domain.component.ProgramTrack;

/**
 * @author  keerthi
 */
public class ProgramTrackServiceImpl implements ProgramTrackService {

	/**
	 * @uml.property  name="programTrackDao"
	 * @uml.associationEnd  
	 */
	private ProgramTrackDao programTrackDao;

	/**
	 * @param programTrackDao  the programTrackDao to set
	 * @uml.property  name="programTrackDao"
	 */
	public void setProgramTrackDao(ProgramTrackDao programTrackDao) {
		this.programTrackDao = programTrackDao;
	}

	/**
	 * @return  the programTrackDao
	 * @uml.property  name="programTrackDao"
	 */
	public ProgramTrackDao getProgramTrackDao() {
		return programTrackDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramTrackService#createProgramTrack(java.lang
	 * .String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ProgramTrack createProgramTrack(String programTrackCode,
			String shortDesc, String description, String status) {

		return this.getProgramTrackDao().createProgramTrack(programTrackCode,
				shortDesc, description, status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramTrackService#deleteProgramTrack(edu.uky.
	 * cepis.domain.component.ProgramTrack)
	 */
	@Override
	public boolean deleteProgramTrack(ProgramTrack programTrack) {

		return this.getProgramTrackDao().deleteProgramTrack(programTrack);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramTrackService#findProgramTrackByCode(java
	 * .lang.String)
	 */
	@Override
	public ProgramTrack findProgramTrackByCode(String programTrackCode) {

		return this.getProgramTrackDao().findProgramTrackByCode(
				programTrackCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.ProgramTrackService#findProgramTrackByID(long)
	 */
	@Override
	public ProgramTrack findProgramTrackByID(long programtrackid) {

		return this.getProgramTrackDao().findProgramTrackByID(programtrackid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.ProgramTrackService#getProgramTrackList()
	 */
	@Override
	public List<ProgramTrack> getProgramTrackList() {

		return this.getProgramTrackDao().getProgramTrackList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramTrackService#saveProgramTrack(edu.uky.cepis
	 * .domain.component.ProgramTrack)
	 */
	@Override
	public boolean saveProgramTrack(ProgramTrack programTrack) {

		return this.getProgramTrackDao().saveProgramTrack(programTrack);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.ProgramTrackService#updateProgramTrack(edu.uky.
	 * cepis.domain.component.ProgramTrack, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public ProgramTrack updateProgramTrack(ProgramTrack programTrack,
			String programTrackCode, String shortDesc, String description,
			String status) {

		return this.getProgramTrackDao().updateProgramTrack(programTrack,
				programTrackCode, shortDesc, description, status);
	}

}
