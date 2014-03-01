/**
 * 
 */
package edu.uky.cepis.view;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.CohortTerm;
import edu.uky.cepis.domain.CohortType;
import edu.uky.cepis.domain.Course;
import edu.uky.cepis.domain.FacultyAdvisor;
import edu.uky.cepis.domain.Query;
import edu.uky.cepis.domain.Role;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserClassification;
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
 * 
 */
public class SearchEngineViewBean extends CepisWebView implements SearchEngineView {
	
	private static final long serialVersionUID = 1L;

	public SearchEngineViewBean() {
		
	}	
	
	/*******************************************USER CONSTRAINTS*******************************************/
	@Override
	public DetachedCriteria addUkIDConstraint(DetachedCriteria query, String ukID) {
		return this.getSearchEngineService().addUkIDConstraint(query, ukID);
	}
	
	@Override
	public DetachedCriteria addMaidenNameConstraint(DetachedCriteria query,	String maidenName) {
		return this.getSearchEngineService().addMaidenNameConstraint(query,	maidenName);
	}

	@Override
	public DetachedCriteria addMiddleNameConstraint(DetachedCriteria query, String middleName) {
		return this.getSearchEngineService().addMiddleNameConstraint(query,	middleName);
	}
	
	@Override
	public DetachedCriteria addLastNameConstraint(DetachedCriteria query, String lastName) {
		return this.getSearchEngineService().addLastNameConstraint(query, lastName);
	}
	
	@Override
	public DetachedCriteria addFirstNameConstraint(DetachedCriteria query, String firstName) {
		return this.getSearchEngineService().addFirstNameConstraint(query, firstName);
	}
	
	@Override
	public DetachedCriteria addUsernameConstraint(DetachedCriteria query, String username) {
		return this.getSearchEngineService().addUsernameConstraint(query, username);
	}
	
	@Override
	public DetachedCriteria addSSNConstraint(DetachedCriteria query, String ssn) {
		return this.getSearchEngineService().addSSNConstraint(query, ssn);
	}
	
	@Override
	public DetachedCriteria addGenderConstraint(DetachedCriteria query, String gender) {
		return this.getSearchEngineService().addGenderConstraint(query,	gender);
	}
	
	/*******************************************PROGRAM CONSTRAINTS*******************************************/
	
	@Override
	public DetachedCriteria addProgramConstraint(DetachedCriteria query, Program program) {
		if (query == null) {
			query = this.createQuery();
		}		
		query = this.getSearchEngineService().addProgramConstraint(query, program);		
		return query;
	}
	
	@Override
	public DetachedCriteria addProgramDomainConstraint(DetachedCriteria query, ProgramDomain programDomain) {
		if (query == null) {
			query = this.createQuery();
		}
		query = this.getSearchEngineService().addProgramDomainConstraint(query,	programDomain);
		return query;
	}

	
	@Override
	public DetachedCriteria addProgramTrackConstraint(DetachedCriteria query, ProgramTrack programTrack) {
		if (query == null) {
			query = this.createQuery();
		}
		query = this.getSearchEngineService().addProgramTrackConstraint(query, programTrack);
		return query;
	}
	
	@Override
	public DetachedCriteria addProgramGroupConstraint(DetachedCriteria query, ProgramGroup programGroup) {
		if (query == null) {
			query = this.createQuery();
		}
		query = this.getSearchEngineService().addProgramGroupConstraint(query, programGroup);
		return query;
	}
	
	@Override
	public DetachedCriteria addUKMajorConstraint(DetachedCriteria query, UKMajor ukMajor) {
		return this.getSearchEngineService().addUKMajorConstraint(query, ukMajor);
	}
	
	@Override
	public DetachedCriteria addProgramStatusConstraint(DetachedCriteria query, UKStatus programStatus) {
		return this.getSearchEngineService().addProgramStatusConstraint(query, programStatus);
	}
	
	@Override
	public DetachedCriteria addProgramStartTermConstraint(DetachedCriteria query, UKTerm programStartTerm) {
		return this.getSearchEngineService().addProgramStartTermConstraint(query, programStartTerm);
	}

	@Override
	public DetachedCriteria addProgramCompleteTermConstraint(DetachedCriteria query, UKTerm programCompleteTerm) {
		return this.getSearchEngineService().addProgramCompleteTermConstraint(query, programCompleteTerm);
	}
	
	public DetachedCriteria addAnticipatedCompleteTermConstraint(DetachedCriteria query, UKTerm anticipatedCompleteTerm) {
		return this.getSearchEngineService().addAnticipatedCompleteTermConstraint(query, anticipatedCompleteTerm);
	}
	
	@Override
	public DetachedCriteria createProgramProfileAlias(DetachedCriteria query) {
		query = this.getSearchEngineService().createProgramProfileAlias(query);
		return query;
	}
	
	@Override
	public DetachedCriteria addAdvisorConstraint(DetachedCriteria query, Advisor selectedAdvisor) {
		query = this.getSearchEngineService().addAdvisorConstraint(query, selectedAdvisor);
		return query;
	}
	
	@Override
	public DetachedCriteria addFacultyAdvisorConstraint(DetachedCriteria query, FacultyAdvisor facultyAdvisor){
		query = this.getSearchEngineService().addFacultyAdvisorConstraint(query, facultyAdvisor);
		return query;
	}
	
	
	/*******************************************COLLEGE CONSTRAINTS*******************************************/
	@Override
	public DetachedCriteria addUserTypeConstraint(DetachedCriteria query, UserType userType) {
		return this.getSearchEngineService().addUserTypeConstraint(query, userType);
	}

	@Override
	public DetachedCriteria addUserClassificationConstraint(DetachedCriteria query, UserClassification userClassification) {
		return this.getSearchEngineService().addUserClassificationConstraint(query, userClassification);
	}

	@Override
	public DetachedCriteria addUKCollegeConstraint(DetachedCriteria query, UKCollege ukCollege) {
		return this.getSearchEngineService().addUKCollegeConstraint(query, ukCollege);
	}

	@Override
	public DetachedCriteria addUKDepartmentConstraint(DetachedCriteria query, UKDepartment ukDepartment) {
		return this.getSearchEngineService().addUKDepartmentConstraint(query, ukDepartment);
	}

	@Override
	public DetachedCriteria addCollegeStartTermConstraint(DetachedCriteria query, UKTerm collegeStartTerm) {
		return this.getSearchEngineService().addCollegeStartTermConstraint(query, collegeStartTerm);
	}

	@Override
	public DetachedCriteria addCollegeEndTermConstraint(DetachedCriteria query, UKTerm collegeEndTerm) {
		return this.getSearchEngineService().addCollegeEndTermConstraint(query, collegeEndTerm);
	}

	@Override
	public DetachedCriteria addCollegeStatusConstraint(DetachedCriteria query,	UKStatus collegeStatus) {
		return this.getSearchEngineService().addCollegeStatusConstraint(query, collegeStatus);
	}

	@Override
	public DetachedCriteria addCohortTypeConstraint(DetachedCriteria query,	CohortType cohortType) {
		return this.getSearchEngineService().addCohortTypeConstraint(query, cohortType);
	}

	@Override
	public DetachedCriteria addCohortTermConstraint(DetachedCriteria query,	CohortTerm cohortTerm) {
		return this.getSearchEngineService().addCohortTermConstraint(query, cohortTerm);
	}

	@Override
	public DetachedCriteria createCollegeAlias(DetachedCriteria query) {
		return this.getSearchEngineService().createCollegeAlias(query);
	}

	/*******************************************QUERY OPTION CONSTRAINTS*******************************************/
	@Override
	public DetachedCriteria addOrder(DetachedCriteria query, String propertyName, boolean order) {
		return this.getSearchEngineService().addOrder(query, propertyName, order);
	}
	
	@Override
	public DetachedCriteria addSearchInWS(DetachedCriteria query, WorkingSet ws) {
		return this.getSearchEngineService().addSearchInWS(query, ws);
	}
	
	/******************************************* *******************************************/
	@Override
	public List<Role> getUserRoles(User user) {
		return this.getRoleservice().getUserRoles(user);
	}	
	
	@Override
	public DetachedCriteria createQuery() {
		DetachedCriteria myquery = this.getSearchEngineService().startQuery(User.class);
		return myquery;
	}
	
	@Override
	public DetachedCriteria addGlobalParam(DetachedCriteria query, String globalQuery) {
		if (query == null) {
			query = this.createQuery();
		}
		query = this.getSearchEngineService().addGlobalSearchConstraint(query, globalQuery);
		return query;
	}

	@Override
	public List<User> search(DetachedCriteria query) {
		List<User> users = new ArrayList<User>(0);
		if (query != null) {
			users = this.getSearchEngineService().executeQuery(query);
		}
		return users;
	}

	@Override
	public boolean addUsersToWorkingSet(WorkingSet ws, List<User> users) {
		return this.getWorkingSetService().addUsersToWorkingSet(ws, users);
	}
	
	@Override
	public boolean addUserToWorkingSet(WorkingSet ws, User selectedUser) {
		return this.getWorkingSetService().addUserToWorkingSet(ws, selectedUser);
	}
	
	@Override
	public User findUserByUID(String uid){
		return this.getUserService().findByUid(uid);
	}
	
	@Override
	public List<Query> getSavedQueryList(User user){
		return this.getQueryService().getQueryList(user);
	}
	@Override
	public Query saveQuery(User user, String name, String desc, DetachedCriteria query){
		return this.getQueryService().createQuery(user, name, desc, query);
	}

	@Override
	public List<Course> getAcademicProfile(User user) {
		return this.getUserAcademicProfileService().getCourseList(user);
	}

}
