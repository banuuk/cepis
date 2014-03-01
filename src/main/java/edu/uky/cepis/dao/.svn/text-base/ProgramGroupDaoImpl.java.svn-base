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
import edu.uky.cepis.domain.component.ProgramGroup;

/**
 * @author keerthi
 * 
 */
public class ProgramGroupDaoImpl implements ProgramGroupDao {

	private static Logger log = Logger.getLogger(ProgramGroupDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramGroupDao#createProgramGroup(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ProgramGroup createProgramGroup(String programGroupCode,
			String shortDesc, String description, String status) {
		ProgramGroup programGroup = new ProgramGroup(programGroupCode,
				shortDesc, description, status);
		if (programGroup == null) {
			return programGroup;
		}
		if (!this.saveProgramGroup(programGroup)) {
			return null;
		}
		return programGroup;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramGroupDao#deleteProgramGroup(edu.uky.cepis.domain
	 * .component.ProgramGroup)
	 */
	@Override
	public boolean deleteProgramGroup(ProgramGroup programGroup) {
		if (programGroup == null) {
			return false;
		}

		this.sessionFactory.getCurrentSession().delete(programGroup);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramGroupDao#findProgramGroupByCode(java.lang.String
	 * )
	 */
	@Override
	public ProgramGroup findProgramGroupByCode(String programGroupCode) {
		if (programGroupCode.isEmpty()) {
			return null;
		}
		List<ProgramGroup> programGroups = null;
		ProgramGroup programGroup = null;

		String hql = "select a from ProgramGroup a where a.programGroupCode ='"
				+ programGroupCode + "'";
		programGroups = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (programGroups.size() < 1) {
			return null;
		}
		programGroup = programGroups.get(0);

		return programGroup;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.ProgramGroupDao#findProgramGroupByID(long)
	 */
	@Override
	public ProgramGroup findProgramGroupByID(long programgroupid) {
		if (programgroupid < 0) {
			return null;
		}
		List<ProgramGroup> programGroups = null;
		ProgramGroup programGroup = null;

		String hql = "select a from ProgramGroup a where a.programgroupid ="
				+ programgroupid + "";
		programGroups = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (programGroups.size() < 1) {
			return null;
		}
		programGroup = programGroups.get(0);

		return programGroup;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.ProgramGroupDao#getProgramGroupList()
	 */
	@Override
	public List<ProgramGroup> getProgramGroupList() {
		List<ProgramGroup> programGroups = new ArrayList<ProgramGroup>(0);

		String hql = "select a from ProgramGroup a order by status,shortDesc";
		programGroups = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();

		return programGroups;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramGroupDao#saveProgramGroupDao(edu.uky.cepis.dao
	 * .ProgramGroupDao)
	 */
	@Override
	public boolean saveProgramGroup(ProgramGroup programGroup) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(programGroup);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.ProgramGroupDao#updateProgramGroup(edu.uky.cepis.domain
	 * .component.ProgramGroup, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public ProgramGroup updateProgramGroup(ProgramGroup programGroup,
			String programGroupCode, String shortDesc, String description,
			String status) {
		if (programGroup == null) {
			return null;
		}
		programGroup.setDescription(description);
		programGroup.setShortDesc(shortDesc);
		programGroup.setProgramGroupCode(programGroupCode);
		programGroup.setStatus(status);
		this.saveProgramGroup(programGroup);
		return programGroup;
	}

}
