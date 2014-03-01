/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.List;

import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramGroup;

/**
 * @author keerthi
 *
 */
public interface ProgramGroupDao {

	public ProgramGroup createProgramGroup(String programGroupCode,String shortDesc,String description,String status);
	public ProgramGroup updateProgramGroup(ProgramGroup programGroup,String programGroupCode,String shortDesc,String description,String status);
	public boolean deleteProgramGroup(ProgramGroup programGroup);
	public ProgramGroup findProgramGroupByID(long programgroupid);
	public ProgramGroup findProgramGroupByCode(String programGroupCode);
	public List<ProgramGroup> getProgramGroupList();
	public boolean saveProgramGroup(ProgramGroup programGroup);

}
