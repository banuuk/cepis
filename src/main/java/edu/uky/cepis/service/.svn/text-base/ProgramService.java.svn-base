/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;

/**
 * @author keerthi
 *
 */
public interface ProgramService {
	public boolean addProgramToDomain(Program program, ProgramDomain programDomain);
	public boolean deleteProgramFromDomain(Program program, ProgramDomain programDomain);
	public Program createProgram(String programCode,String shortDesc,String description,String status);
	public Program updateProgram(Program program,String programCode,String shortDesc,String description,String status);
	public boolean deleteProgram(Program program);
	public Program findProgramByID(long programid);
	public Program findProgramByCode(String programCode);
	public Program findProgramByID(ProgramDomain programDomain,long programid);
	public Program findProgramByCode(ProgramDomain programDomain,String programCode);
	public List<Program> getProgramList();
	public boolean saveProgram(Program program);
	

}
