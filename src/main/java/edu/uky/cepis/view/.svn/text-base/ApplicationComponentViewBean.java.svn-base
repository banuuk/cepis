/**
 * 
 */
package edu.uky.cepis.view;

import java.util.List;
import java.util.Set;

import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.ProgramGroup;
import edu.uky.cepis.domain.component.ProgramTrack;
import edu.uky.cepis.domain.component.UKCollege;
import edu.uky.cepis.domain.component.UKDepartment;
import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.AdvisorGroup;
import edu.uky.cepis.domain.CohortTerm;
import edu.uky.cepis.domain.CohortType;
import edu.uky.cepis.domain.Ethnic;
import edu.uky.cepis.domain.Ranking;
import edu.uky.cepis.domain.UserClassification;
import edu.uky.cepis.domain.UserType;

/**
 * @author keerthi
 * 
 */
public class ApplicationComponentViewBean extends CepisWebView implements
		ApplicationComponentView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.view.ApplicationComponentView#createprogram(java.lang.String
	 * , java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean createProgram(String programCode, String shortDesc,
			String description, String status) {

		if (this.getProgramService().createProgram(programCode, shortDesc,
				description, status) == null) {
			return false;
		}

		return true;
	}

	@Override
	public boolean createProgramDomain(String programCode, String shortDesc,
			String description, String status) {

		if (this.getProgramDomainService().createProgramDomain(programCode,
				shortDesc, description, status) == null) {
			return false;
		}

		return true;
	}

	@Override
	public boolean createProgramTrack(String programCode, String shortDesc,
			String description, String status) {

		if (this.getProgramTrackService().createProgramTrack(programCode,
				shortDesc, description, status) == null) {
			return false;
		}

		return true;
	}

	@Override
	public boolean createProgramGroup(String programCode, String shortDesc,
			String description, String status) {

		if (this.getProgramGroupService().createProgramGroup(programCode,
				shortDesc, description, status) == null) {
			return false;
		}

		return true;
	}

	@Override
	public boolean createEthnic(String code, String shortDesc,
			String kyEthnicCode) {

		if (this.getEthnicService().createEthnic(code, shortDesc, kyEthnicCode) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean addProgramToProgramDomain(ProgramDomain programDomain,
			Program program) {
		return this.getProgramService().addProgramToDomain(program,
				programDomain);
	}

	@Override
	public boolean removeProgramFromProgramDomain(ProgramDomain programDomain,
			Program program) {
		return this.getProgramService().deleteProgramFromDomain(program,
				programDomain);
	}

	@Override
	public boolean editProgram(Program selectedProgram, String programCode,
			String shortDesc, String description, String status) {
		if (this.getProgramService().updateProgram(selectedProgram,
				programCode, shortDesc, description, status) == null) {
			return false;
		}

		return true;
	}

	@Override
	public boolean editProgramDomain(ProgramDomain selectedProgramDomain,
			String programCode, String shortDesc, String description,
			String status) {
		if (this.getProgramDomainService().updateProgramDomain(
				selectedProgramDomain, programCode, shortDesc, description,
				status) == null) {
			return false;
		}

		return true;
	}

	@Override
	public boolean editProgramTrack(ProgramTrack selectedProgramTrack,
			String programCode, String shortDesc, String description,
			String status) {
		if (this.getProgramTrackService().updateProgramTrack(
				selectedProgramTrack, programCode, shortDesc, description,
				status) == null) {
			return false;
		}

		return true;
	}

	@Override
	public boolean editProgramGroup(ProgramGroup selectedProgramGroup,
			String programCode, String shortDesc, String description,
			String status) {
		if (this.getProgramGroupService().updateProgramGroup(
				selectedProgramGroup, programCode, shortDesc, description,
				status) == null) {
			return false;
		}

		return true;
	}

	@Override
	public boolean editEthnic(Ethnic selectedEthnic, String code,
			String shortDesc, String kyEthnicCode) {
		if (this.getEthnicService().updateEthnic(selectedEthnic, code,
				shortDesc, kyEthnicCode) == null) {
			return false;
		}

		return true;
	}

	@Override
	public boolean deleteProgram(Program selectedProgram) {
		return this.getProgramService().deleteProgram(selectedProgram);
	}

	@Override
	public boolean deleteProgramDomain(ProgramDomain selectedProgramDomain) {
		return this.getProgramDomainService().deleteProgramDomain(
				selectedProgramDomain);
	}

	@Override
	public boolean deleteProgramTrack(ProgramTrack selectedProgramTrack) {
		return this.getProgramTrackService().deleteProgramTrack(
				selectedProgramTrack);
	}

	@Override
	public boolean deleteProgramGroup(ProgramGroup selectedProgramGroup) {
		return this.getProgramGroupService().deleteProgramGroup(
				selectedProgramGroup);
	}

	@Override
	public boolean deleteProgramFromProgramDomain(ProgramDomain programDomain,
			Program program) {
		return this.getProgramService().deleteProgramFromDomain(program,
				programDomain);
	}

	@Override
	public boolean deleteEthnic(Ethnic selectedEthnic) {
		return this.getEthnicService().deleteEthnic(selectedEthnic);
	}

	@Override
	public List<Program> getProgramList() {
		return this.getProgramService().getProgramList();
	}

	@Override
	public List<ProgramDomain> getProgramDomainList() {
		return this.getProgramDomainService().getProgramDomainList();
	}

	@Override
	public List<ProgramTrack> getProgramTrackList() {
		return this.getProgramTrackService().getProgramTrackList();
	}

	@Override
	public List<ProgramGroup> getProgramGroupList() {
		return this.getProgramGroupService().getProgramGroupList();
	}

	@Override
	public List<Program> getProgramDomainProgramList(ProgramDomain programDomain) {
		return this.getProgramDomainService().getProgramListFromDomain(
				programDomain);
	}

	@Override
	public boolean addUserClassificationToUserType(UserType selectedUserType,
			UserClassification selectedUserClassification) {

		return this.getUserTypeService().addUserClassficationToUserType(
				selectedUserClassification, selectedUserType);
	}

	@Override
	public boolean createCohortType(String code, String shortDesc,
			String description, String status) {
		if (this.getCohortTypeService().createCohortType(code, shortDesc,
				description, status) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean createUKCollege(String ukCollegeCode, String collegeName,
			String collegeAddress, String collegeSpeedSort,
			String collegePhone, String collegeDeanName) {
		if (this.getUkCollegeService().createUKCollege(ukCollegeCode,
				collegeName, collegeAddress, collegeSpeedSort, collegePhone,
				collegeDeanName) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean createUKDepartment(String departmentCode,
			String departmentName, String departmentAddress, String speedSort,
			String departmentChairName, String departmentContact,
			String shortDesc, String status) {
		if (this.getUkDepartmentService().createUKDepartment(departmentCode,
				departmentName, departmentAddress, speedSort,
				departmentChairName, departmentContact, shortDesc, status) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean createUserClassification(String code, String shortDesc,
			String description, String status) {
		if (this.getUserClassificationService().createUserClassification(code,
				shortDesc, description, status) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean createUserType(String typeCode, String shortDesc) {
		if (this.getUserTypeService().createUserType(typeCode, shortDesc) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCohortType(CohortType selectedCohortType) {
		return this.getCohortTypeService().deleteCohortType(selectedCohortType);
	}

	@Override
	public boolean deleteUKCollege(UKCollege selectedUKCollege) {
		return this.getUkCollegeService().deleteUKCollege(selectedUKCollege);
	}

	@Override
	public boolean deleteUKDepartment(UKDepartment selectedUKDepartment) {
		return this.getUkDepartmentService().deleteUKDepartment(
				selectedUKDepartment);
	}

	@Override
	public boolean deleteUserClassification(
			UserClassification selectedUserClassification) {
		return this.getUserClassificationService().deleteUserClassification(
				selectedUserClassification);
	}

	@Override
	public boolean deleteUserType(UserType selectedUserType) {
		return this.getUserTypeService().deleteUserType(selectedUserType);
	}

	@Override
	public boolean editCohortType(CohortType selectedCohortType, String code,
			String shortDesc, String description, String status) {
		if (this.getCohortTypeService().updateCohortType(selectedCohortType,
				code, shortDesc, description, status) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean editUKCollege(UKCollege selectedUKCollege,
			String ukCollegeCode, String collegeName, String collegeAddress,
			String collegeSpeedSort, String collegePhone, String collegeDeanName) {

		if (this.getUkCollegeService().updateUKCollege(selectedUKCollege,
				ukCollegeCode, collegeName, collegeAddress, collegeSpeedSort,
				collegePhone, collegeDeanName) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean editUKDepartment(UKDepartment selectedUKDepartment,
			String departmentCode, String departmentName,
			String departmentAddress, String speedSort,
			String departmentChairName, String departmentContact,
			String shortDesc, String status) {

		if (this.getUkDepartmentService().updateUKDepartment(
				selectedUKDepartment, departmentCode, departmentName,
				departmentAddress, speedSort, departmentChairName,
				departmentContact, shortDesc, status) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean editUserClassification(
			UserClassification selectedUserClassification, String code,
			String shortDesc, String description, String status) {

		if (this.getUserClassificationService().updateUserClassification(
				selectedUserClassification, code, shortDesc, description,
				status) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean editUserType(UserType selectedUserType, String code,
			String shortDesc) {

		if (this.getUserTypeService().updateUserType(selectedUserType, code,
				shortDesc) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean removeUserClassificationFromUserType(
			UserClassification selectedUserClassification,
			UserType selectedUserType) {
		return this.getUserTypeService().removeUserClassficationFromUserType(
				selectedUserClassification, selectedUserType);

	}

	@Override
	public Set<UserClassification> getUserClassificationFromUserTypeList(
			UserType userType) {
		return this.getUserTypeService().getUserClassificationListFromUserType(
				userType);
	}

	@Override
	public boolean createCohortTerm(int code, String shortDesc,
			String description) {
		if (this.getCohortTermService().createCohortTerm(code, shortDesc,
				description) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCohortTerm(CohortTerm selectedCohortTerm) {

		return this.getCohortTermService().deleteCohortTerm(selectedCohortTerm);
	}

	@Override
	public boolean editCohortTerm(CohortTerm selectedCohortTerm, int code,
			String shortDesc, String description) {

		if (this.getCohortTermService().updateCohortTerm(selectedCohortTerm,
				code, shortDesc, description) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean createRanking(String rankingCode, String title,
			String program) {
		if (!this.getRankingService()
				.createRanking(rankingCode, title, program)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteRanking(Ranking ranking) {
		return this.getRankingService().deleteRanking(ranking);
	}

	@Override
	public boolean editRanking(Ranking ranking, String rankingCode,
			String title, String program) {
		if (!this.getRankingService().updateRanking(ranking, rankingCode,
				title, program)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean addAdvisorToGroup(AdvisorGroup advisorGroup, Advisor advisor) {
		return this.getAdvisorService()
				.addAdvisorToGroup(advisorGroup, advisor);
	}

	@Override
	public AdvisorGroup createAdvisorGroup(String name, String shortDesc) {
		return this.getAdvisorService().createAdvisorGroup(name, shortDesc);
	}

	@Override
	public boolean deleteAdvisorGroup(AdvisorGroup advisorGroup) {
		return this.getAdvisorService().deleteAdvisorGroup(advisorGroup);
	}

	@Override
	public boolean removeAdvisorFromGroup(AdvisorGroup advisorGroup,
			Advisor advisor) {
		return this.getAdvisorService().removeAdvisorFromGroup(advisorGroup,
				advisor);
	}

	@Override
	public AdvisorGroup updateAdvisorGroup(AdvisorGroup advisorGroup,
			String name, String shortDesc) {
		return this.getAdvisorService().updateAdvisorGroup(advisorGroup, name,
				shortDesc);
	}
}
