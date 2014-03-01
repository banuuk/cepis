/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import java.util.Set;

import edu.uky.cepis.domain.StandardSet;
import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;

/**
 * @author keerthi
 *
 */
public interface ProgramDomainService {

	public ProgramDomain createProgramDomain(String programDomainCode,String shortDesc,String description,String status);
	public ProgramDomain updateProgramDomain(ProgramDomain programDomain, String programDomainCode,String shortDesc,String description,String status);
	public boolean deleteProgramDomain(ProgramDomain programDomain);
	public ProgramDomain findProgramDomainByID(long programdomainid);
	public ProgramDomain findProgramDomainByCode(String programDomainCode);
	public List<ProgramDomain> getProgramDomainList();
	public List<Program> getProgramListFromDomain(ProgramDomain programDomain);
	public boolean saveProgramDomain(ProgramDomain programDomain);
	public List<StandardSet> getStandardSets(ProgramDomain programDomain);

}
