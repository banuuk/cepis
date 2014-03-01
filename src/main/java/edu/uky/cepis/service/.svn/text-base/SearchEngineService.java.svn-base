/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

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
 * 
 */
public interface SearchEngineService {
	
	/*******************************************USER CONSTRAINTS*******************************************/
	public DetachedCriteria addUkIDConstraint(DetachedCriteria query, String ukID);
	
	public DetachedCriteria addMaidenNameConstraint(DetachedCriteria query, String maidenName);

	public DetachedCriteria addMiddleNameConstraint(DetachedCriteria query, String middleName);

	public DetachedCriteria addLastNameConstraint(DetachedCriteria query, String lastName);

	public DetachedCriteria addFirstNameConstraint(DetachedCriteria query, String firstName);

	public DetachedCriteria addUsernameConstraint(DetachedCriteria query, String username);

	public DetachedCriteria addSSNConstraint(DetachedCriteria query, String ssn);

	public DetachedCriteria addGenderConstraint(DetachedCriteria query, String gender);
	
	/*******************************************PROGRAM CONSTRAINTS*******************************************/

	public DetachedCriteria addProgramConstraint(DetachedCriteria query, Program program);

	public DetachedCriteria addProgramDomainConstraint(DetachedCriteria query, ProgramDomain programDomain);

	public DetachedCriteria addProgramTrackConstraint(DetachedCriteria query, ProgramTrack programTrack);

	public DetachedCriteria addProgramGroupConstraint(DetachedCriteria query, ProgramGroup programGroup);

	public DetachedCriteria addUKMajorConstraint(DetachedCriteria query, UKMajor ukMajor);
	
	public DetachedCriteria addProgramStatusConstraint(DetachedCriteria query, UKStatus programStatus);
	
	public DetachedCriteria addProgramStartTermConstraint(DetachedCriteria query, UKTerm programStartTerm);

	public DetachedCriteria addProgramCompleteTermConstraint(DetachedCriteria query, UKTerm programCompleteTerm);
	
	public DetachedCriteria addAnticipatedCompleteTermConstraint(DetachedCriteria query, UKTerm anticipatedCompleteTerm);

	public DetachedCriteria addAdvisorConstraint(DetachedCriteria query, Advisor advisor);
	
	public DetachedCriteria addFacultyAdvisorConstraint(DetachedCriteria query, FacultyAdvisor facultyAdvisor);
	
	public DetachedCriteria createProgramProfileAlias(DetachedCriteria query);
	
	/*******************************************COLLEGE CONSTRAINTS*******************************************/
	public DetachedCriteria addUserTypeConstraint(DetachedCriteria query, UserType userType);
	
	public DetachedCriteria addUserClassificationConstraint(DetachedCriteria query, UserClassification userClassification);
	
	public DetachedCriteria addUKCollegeConstraint(DetachedCriteria query, UKCollege ukCollege);
	
	public DetachedCriteria addUKDepartmentConstraint(DetachedCriteria query, UKDepartment ukDepartment);
	
	public DetachedCriteria addCollegeStartTermConstraint(DetachedCriteria query, UKTerm collegeStartTerm);
	
	public DetachedCriteria addCollegeEndTermConstraint(DetachedCriteria query, UKTerm collegeEndTerm);
	
	public DetachedCriteria addCollegeStatusConstraint(DetachedCriteria query, UKStatus collegeStatus);
	
	public DetachedCriteria addCohortTypeConstraint(DetachedCriteria query, CohortType cohortType);
	
	public DetachedCriteria addCohortTermConstraint(DetachedCriteria query, CohortTerm cohortTerm);
	
	public DetachedCriteria createCollegeAlias(DetachedCriteria query);
	
	/*******************************************QUERY OPTION CONSTRAINTS*******************************************/
	public DetachedCriteria addOrder(DetachedCriteria query, String propertyName, boolean order);
	
	public DetachedCriteria addSearchInWS(DetachedCriteria query, WorkingSet ws);
	
	/******************************************* *******************************************/
		
	
	public DetachedCriteria addUserProgramProfileConstraint(DetachedCriteria query, UserProgramProfile userProgramProfile);

	public DetachedCriteria addGlobalSearchConstraint(DetachedCriteria query, String globalQuery);

	public DetachedCriteria startQuery(Class<User> clazz);

	public List<User> executeQuery(DetachedCriteria query);

	
		
	public abstract void initializeSearchEngineIndex();

	public abstract List<User> executeLuceneQuery(String queryString);

}
