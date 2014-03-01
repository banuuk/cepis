/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import edu.uky.cepis.dao.SearchEngineDao;
import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.CohortTerm;
import edu.uky.cepis.domain.CohortType;
import edu.uky.cepis.domain.FacultyAdvisor;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserClassification;
import edu.uky.cepis.domain.UserProgramProfile;
import edu.uky.cepis.domain.UserType;
import edu.uky.cepis.domain.WorkingSet;
import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.ProgramGroup;
import edu.uky.cepis.domain.component.ProgramTrack;
import edu.uky.cepis.domain.component.UKCollege;
import edu.uky.cepis.domain.component.UKDepartment;
import edu.uky.cepis.domain.component.UKMajor;
import edu.uky.cepis.domain.component.UKStatus;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author cawalk4
 */
public class SearchEngineServiceImpl implements SearchEngineService {

	
	private SearchEngineDao searchEngineDao;
	
		
	/*******************************************USER CONSTRAINTS*******************************************/
	@Override
	public DetachedCriteria addUkIDConstraint(DetachedCriteria query, String ukID) {
		return this.getSearchEngineDao().addUkIDConstraint(query, ukID);
	}

	@Override
	public DetachedCriteria addMaidenNameConstraint(DetachedCriteria query,	String maidenName) {
		return this.getSearchEngineDao().addMaidenNameConstraint(query,	maidenName);
	}

	@Override
	public DetachedCriteria addMiddleNameConstraint(DetachedCriteria query,	String middleName) {
		return this.getSearchEngineDao().addMiddleNameConstraint(query,	middleName);
	}

	@Override
	public DetachedCriteria addLastNameConstraint(DetachedCriteria query, String lastName) {
		return this.getSearchEngineDao().addLastNameConstraint(query, lastName);
	}
	
	@Override
	public DetachedCriteria addFirstNameConstraint(DetachedCriteria query, String firstName) {
		return this.getSearchEngineDao().addFirstNameConstraint(query, firstName);
	}
	
	@Override
	public DetachedCriteria addUsernameConstraint(DetachedCriteria query, String username) {
		return this.getSearchEngineDao().addUsernameConstraint(query, username);
	}
	
	@Override
	public DetachedCriteria addSSNConstraint(DetachedCriteria query, String ssn) {
		return this.getSearchEngineDao().addSSNConstraint(query, ssn);
	}

	@Override
	public DetachedCriteria addGenderConstraint(DetachedCriteria query,	String gender) {
		return this.getSearchEngineDao().addGenderConstraint(query, gender);
	}

	/*******************************************PROGRAM CONSTRAINTS*******************************************/	
	@Override
	public DetachedCriteria addProgramConstraint(DetachedCriteria query, Program program) {
		return this.getSearchEngineDao().addProgramConstraint(query, program);
	}
	
	@Override
	public DetachedCriteria addProgramDomainConstraint(DetachedCriteria query, ProgramDomain programDomain) {
		return this.getSearchEngineDao().addProgramDomainConstraint(query, programDomain);
	}
	
	@Override
	public DetachedCriteria addProgramTrackConstraint(DetachedCriteria query, ProgramTrack programTrack) {
		return this.getSearchEngineDao().addProgramTrackConstraint(query, programTrack);
	}
	
	@Override
	public DetachedCriteria addProgramGroupConstraint(DetachedCriteria query, ProgramGroup programGroup) {
		return this.getSearchEngineDao().addProgramGroupConstraint(query, programGroup);
	}
	
	@Override
	public DetachedCriteria addUKMajorConstraint(DetachedCriteria query, UKMajor ukMajor) {
		return this.getSearchEngineDao().addUKMajorConstraint(query, ukMajor);
	}

	@Override
	public DetachedCriteria addProgramStatusConstraint(DetachedCriteria query, UKStatus programStatus) {
		return this.getSearchEngineDao().addProgramStatusConstraint(query, programStatus);
	}

	@Override
	public DetachedCriteria addProgramStartTermConstraint(DetachedCriteria query, UKTerm programStartTerm) {
		return this.getSearchEngineDao().addProgramStartTermConstraint(query, programStartTerm);
	}
	
	@Override
	public DetachedCriteria addProgramCompleteTermConstraint(DetachedCriteria query, UKTerm programCompleteTerm) {
		return this.getSearchEngineDao().addProgramCompleteTermConstraint(query,programCompleteTerm);
	}
	
	@Override
	public DetachedCriteria addAnticipatedCompleteTermConstraint(DetachedCriteria query, UKTerm anticipatedCompleteTerm) {
		return this.getSearchEngineDao().addAnticipatedCompleteTermConstraint(query, anticipatedCompleteTerm);
	}

	@Override
	public DetachedCriteria addAdvisorConstraint(DetachedCriteria query, Advisor advisor) {
		return this.getSearchEngineDao().addAdvisorConstraint(query, advisor);
	}
	
	@Override
	public DetachedCriteria addFacultyAdvisorConstraint(DetachedCriteria query, FacultyAdvisor facultyAdvisor) {
		return this.getSearchEngineDao().addFacultyAdvisorConstraint(query, facultyAdvisor);
	}
	
	/*******************************************COLLEGE CONSTRAINTS*******************************************/
	@Override
	public DetachedCriteria addUserTypeConstraint(DetachedCriteria query, UserType userType) {
		return this.getSearchEngineDao().addUserTypeConstraint(query, userType);
	}

	@Override
	public DetachedCriteria addUserClassificationConstraint(DetachedCriteria query, UserClassification userClassification) {
		return this.getSearchEngineDao().addUserClassificationConstraint(query, userClassification);
	}

	@Override
	public DetachedCriteria addUKCollegeConstraint(DetachedCriteria query, UKCollege ukCollege) {
		return this.getSearchEngineDao().addUKCollegeConstraint(query, ukCollege);
	}

	@Override
	public DetachedCriteria addUKDepartmentConstraint(DetachedCriteria query, UKDepartment ukDepartment) {
		return this.getSearchEngineDao().addUKDepartmentConstraint(query, ukDepartment);
	}

	@Override
	public DetachedCriteria addCollegeStartTermConstraint(DetachedCriteria query, UKTerm collegeStartTerm) {
		return this.getSearchEngineDao().addCollegeStartTermConstraint(query, collegeStartTerm);
	}

	@Override
	public DetachedCriteria addCollegeEndTermConstraint(DetachedCriteria query, UKTerm collegeEndTerm) {
		return this.getSearchEngineDao().addCollegeEndTermConstraint(query, collegeEndTerm);
	}

	@Override
	public DetachedCriteria addCollegeStatusConstraint(DetachedCriteria query,	UKStatus collegeStatus) {
		return this.getSearchEngineDao().addCollegeStatusConstraint(query, collegeStatus);
	}

	@Override
	public DetachedCriteria addCohortTypeConstraint(DetachedCriteria query,	CohortType cohortType) {
		return this.getSearchEngineDao().addCohortTypeConstraint(query, cohortType);
	}

	@Override
	public DetachedCriteria addCohortTermConstraint(DetachedCriteria query,	CohortTerm cohortTerm) {
		return this.getSearchEngineDao().addCohortTermConstraint(query, cohortTerm);
	}

	@Override
	public DetachedCriteria createCollegeAlias(DetachedCriteria query) {
		return this.getSearchEngineDao().createCollegeAlias(query);
	}
	
	/*******************************************QUERY OPTION CONSTRAINTS*******************************************/
	@Override
	public DetachedCriteria addOrder(DetachedCriteria query, String propertyName, boolean order) {
		return this.getSearchEngineDao().addOrder(query, propertyName, order);
	}

	@Override
	public DetachedCriteria addSearchInWS(DetachedCriteria query, WorkingSet ws) {
		return this.getSearchEngineDao().addSearchInWS(query, ws);
	}

	/******************************************* *******************************************/
	
	
	@Override
	public DetachedCriteria addGlobalSearchConstraint(DetachedCriteria query, String globalQuery) {
		return this.getSearchEngineDao().addGlobalSearchConstraint(query, globalQuery);
	}
	
	@Override
	public DetachedCriteria addUserProgramProfileConstraint(DetachedCriteria query, UserProgramProfile userProgramProfile) {
		return this.getSearchEngineDao().addUserProgramProfileConstraint(query,	userProgramProfile);
	}

	@Override
	public List<User> executeQuery(DetachedCriteria query) {
		return this.getSearchEngineDao().executeQuery(query);
	}

	@Override
	public DetachedCriteria startQuery(Class<User> clazz) {
		return this.getSearchEngineDao().startQuery(clazz);
	}

	@Override
	public DetachedCriteria createProgramProfileAlias(DetachedCriteria query) {
		return this.getSearchEngineDao().createProgramProfileAlias(query);
	}

	@Override
	public void initializeSearchEngineIndex() {
		this.getSearchEngineDao().initializeSearchEngineIndex();
	}

	@Override
	public List<User> executeLuceneQuery(String queryString) {
		return this.getSearchEngineDao().executeLuceneQuery(queryString);
	}
	
	public void setSearchEngineDao(SearchEngineDao searchEngineDao) {
		this.searchEngineDao = searchEngineDao;
	}

	public SearchEngineDao getSearchEngineDao() {
		return searchEngineDao;
	}
}
