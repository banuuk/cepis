/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.ProgramTrack;

/**
 * @author keerthi
 * 
 */
public class ProgramTrackDaoImpl implements ProgramTrackDao {

	private static Logger log = Logger.getLogger(ProgramTrackDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramTrackDao#createProgramTrack(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ProgramTrack createProgramTrack(String programTrackCode,
			String shortDesc, String description, String status) {
		ProgramTrack programTrack = new ProgramTrack(programTrackCode,
				shortDesc, description, status);
		if (programTrack == null) {
			return programTrack;
		}
		if (!this.saveProgramTrack(programTrack)) {
			return null;
		}
		return programTrack;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramTrackDao#deleteProgramTrack(edu.uky.cepis.domain
	 * .component.ProgramTrack)
	 */
	@Override
	public boolean deleteProgramTrack(ProgramTrack programTrack) {
		if (programTrack == null) {
			return false;
		}

		this.sessionFactory.getCurrentSession().delete(programTrack);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramTrackDao#findProgramTrackByCode(java.lang.String
	 * )
	 */
	@Override
	public ProgramTrack findProgramTrackByCode(String programTrackCode) {
		if (programTrackCode.isEmpty()) {
			return null;
		}
		List<ProgramTrack> programTracks = null;
		ProgramTrack programTrack = null;

		String hql = "select a from ProgramTrack a where a.programTrackCode ='"
				+ programTrackCode + "'";
		programTracks = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (programTracks.size() < 1) {
			return null;
		}
		programTrack = programTracks.get(0);

		return programTrack;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.ProgramTrackDao#findProgramTrackByID(long)
	 */
	@Override
	public ProgramTrack findProgramTrackByID(long programtrackid) {
		if (programtrackid < 0) {
			return null;
		}
		List<ProgramTrack> programTracks = null;
		ProgramTrack programTrack = null;

		String hql = "select a from ProgramTrack a where a.programtrackid ="
				+ programtrackid + "";
		programTracks = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (programTracks.size() < 1) {
			return null;
		}
		programTrack = programTracks.get(0);

		return programTrack;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.ProgramTrackDao#getProgramTrackList()
	 */
	@Override
	public List<ProgramTrack> getProgramTrackList() {
		List<ProgramTrack> programTracks = new ArrayList<ProgramTrack>(0);

		String hql = "select a from ProgramTrack a order by status,shortDesc";
		programTracks = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();

		return programTracks;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramTrackDao#saveProgramTrackDao(edu.uky.cepis.dao
	 * .ProgramTrackDao)
	 */
	@Override
	public boolean saveProgramTrack(ProgramTrack programTrack) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(programTrack);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramTrackDao#updateProgramTrack(edu.uky.cepis.domain
	 * .component.ProgramTrack, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public ProgramTrack updateProgramTrack(ProgramTrack programTrack,
			String programTrackCode, String shortDesc, String description,
			String status) {
		if (programTrack == null) {
			return null;
		}
		programTrack.setDescription(description);
		programTrack.setShortDesc(shortDesc);
		programTrack.setProgramTrackCode(programTrackCode);
		programTrack.setStatus(status);
		this.saveProgramTrack(programTrack);
		return programTrack;
	}

}
