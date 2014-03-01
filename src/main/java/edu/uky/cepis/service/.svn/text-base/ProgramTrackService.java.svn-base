/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.ProgramTrack;

/**
 * @author keerthi
 *
 */
public interface ProgramTrackService {

	public ProgramTrack createProgramTrack(String programTrackCode,String shortDesc,String description,String status);
	public ProgramTrack updateProgramTrack(ProgramTrack programTrack, String programTrackCode,String shortDesc,String description,String status);
	public boolean deleteProgramTrack(ProgramTrack programTrack);
	public ProgramTrack findProgramTrackByID(long programtrackid);
	public ProgramTrack findProgramTrackByCode(String programTrackCode);
	public List<ProgramTrack> getProgramTrackList();
	public boolean saveProgramTrack(ProgramTrack programTrack);

}
