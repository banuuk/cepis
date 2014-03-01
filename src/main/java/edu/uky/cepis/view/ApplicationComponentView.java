/**
 * 
 */
package edu.uky.cepis.view;

import java.util.List;
import java.util.Set;

import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.AdvisorGroup;
import edu.uky.cepis.domain.CohortTerm;
import edu.uky.cepis.domain.CohortType;
import edu.uky.cepis.domain.Ethnic;
import edu.uky.cepis.domain.Ranking;
import edu.uky.cepis.domain.UserClassification;
import edu.uky.cepis.domain.UserType;
import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.ProgramGroup;
import edu.uky.cepis.domain.component.ProgramTrack;
import edu.uky.cepis.domain.component.UKCollege;
import edu.uky.cepis.domain.component.UKDepartment;

/**
 * @author keerthi
 * 
 */
public interface ApplicationComponentView {
	public boolean createProgram(String programCode, String shortDesc,
			String description, String status);

	public boolean editProgram(Program selectedProgram, String programCode,
			String shortDesc, String description, String status);

	public List<Program> getProgramList();

	public boolean deleteProgram(Program selectedProgram);

	public boolean createProgramDomain(String programCode, String shortDesc,
			String description, String status);

	public boolean createProgramTrack(String programCode, String shortDesc,
			String description, String status);

	public boolean createProgramGroup(String programCode, String shortDesc,
			String description, String status);

	public boolean createEthnic(String code, String shortDesc,
			String kyEthnicCode);

	public boolean editProgramDomain(ProgramDomain selectedProgramDomain,
			String programCode, String shortDesc, String description,
			String status);

	public boolean editProgramTrack(ProgramTrack selectedProgramTrack,
			String programCode, String shortDesc, String description,
			String status);

	public boolean editProgramGroup(ProgramGroup selectedProgramGroup,
			String programCode, String shortDesc, String description,
			String status);

	public boolean editEthnic(Ethnic ethnic, String code, String shortDesc,
			String kyEthnicCode);

	public boolean deleteProgramDomain(ProgramDomain selectedProgramDomain);

	public boolean deleteProgramTrack(ProgramTrack selectedProgramTrack);

	public boolean deleteProgramGroup(ProgramGroup selectedProgramGroup);

	public boolean deleteEthnic(Ethnic ethnic);

	public List<ProgramDomain> getProgramDomainList();

	public List<ProgramTrack> getProgramTrackList();

	public List<ProgramGroup> getProgramGroupList();

	public List<Program> getProgramDomainProgramList(ProgramDomain programDomain);
	
	public Set<UserClassification> getUserClassificationFromUserTypeList(UserType userType);

	public boolean addProgramToProgramDomain(ProgramDomain programDomain,
			Program program);

	public boolean deleteProgramFromProgramDomain(ProgramDomain programDomain,
			Program program);

	public boolean removeProgramFromProgramDomain(ProgramDomain programDomain,
			Program program);

	public boolean createUKCollege(String ukCollegeCode, String collegeName,
			String collegeAddress, String collegeSpeedSort,
			String collegePhone, String collegeDeanName);

	public boolean editUKCollege(UKCollege selectedUKCollege,
			String ukCollegeCode, String collegeName, String collegeAddress,
			String collegeSpeedSort, String collegePhone, String collegeDeanName);

	public boolean deleteUKCollege(UKCollege selectedUKCollege);

	public boolean createUKDepartment(String departmentCode,
			String departmentName, String departmentAddress, String speedSort,
			String departmentChairName, String departmentContact,
			String shortDesc, String status);

	public boolean editUKDepartment(UKDepartment selectedUKDepartment,
			String departmentCode, String departmentName,
			String departmentAddress, String speedSort,
			String departmentChairName, String departmentContact,
			String shortDesc, String status);

	public boolean deleteUKDepartment(UKDepartment selectedUKDepartment);

	public boolean createUserType(String code, String shortDesc);

	public boolean editUserType(UserType selectedUserType, String code,
			String shortDesc);

	public boolean deleteUserType(UserType selectedUserType);

	public boolean createUserClassification(String code, String shortDesc,
			String description, String status);

	public boolean editUserClassification(
			UserClassification selectedUserClassification, String code,
			String shortDesc, String description, String status);

	public boolean deleteUserClassification(
			UserClassification selectedUserClassification);

	public boolean addUserClassificationToUserType(UserType selectedUserType,
			UserClassification selectedUserClassification);

	public boolean removeUserClassificationFromUserType(
			UserClassification selectedUserClassification,
			UserType selectedUserType);

	public boolean createCohortType(String code, String shortDesc,
			String description, String status);

	public boolean editCohortType(CohortType selectedCohortType, String code,
			String shortDesc, String description, String status);

	public boolean deleteCohortType(CohortType selectedCohortType);

	public boolean createCohortTerm(int code, String shortDesc,
			String description);

	public boolean deleteCohortTerm(CohortTerm selectedCohortTerm);

	public boolean editCohortTerm(CohortTerm selectedCohortTerm, int code,
			String shortDesc, String description);
	
	public boolean createRanking(String rankingCode, String title,
			String program);
	
	public boolean deleteRanking(Ranking ranking);
	
	public boolean editRanking(Ranking ranking, String rankingCode,
			String title, String program);

	public boolean removeAdvisorFromGroup(AdvisorGroup advisorGroup, Advisor advisor);
	public boolean addAdvisorToGroup(AdvisorGroup advisorGroup, Advisor advisor);
	public boolean deleteAdvisorGroup(AdvisorGroup advisorGroup);
	public AdvisorGroup updateAdvisorGroup(AdvisorGroup advisorGroup, String name,
			String shortDesc);
	public AdvisorGroup createAdvisorGroup(String name, String shortDesc);
}
