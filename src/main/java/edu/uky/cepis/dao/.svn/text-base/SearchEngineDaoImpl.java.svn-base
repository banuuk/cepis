/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.lucene.search.Query;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.sql.JoinType;

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
import edu.uky.cepis.util.operations.StringOperation;

/**
 * @author cawalk4
 * 
 */
public class SearchEngineDaoImpl implements SearchEngineDao {

	private static Logger log = Logger.getLogger(SearchEngineDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**************************************************************************************************************/
	/***********************************************USER CONSTRAINTS***********************************************/
	/**************************************************************************************************************/
	@Override
	public DetachedCriteria addUkIDConstraint(DetachedCriteria query, String ukID) {
		return query.add(Property.forName("user.ukID").like(ukID, MatchMode.ANYWHERE));
	}
	
	@Override
	public DetachedCriteria addMaidenNameConstraint(DetachedCriteria query, String maidenName) {
		return query.add(Property.forName("user.maidenName").like(maidenName, MatchMode.ANYWHERE));
	}
	
	@Override
	public DetachedCriteria addMiddleNameConstraint(DetachedCriteria query,	String middleName) {
		return query.add(Property.forName("user.mName").like(middleName, MatchMode.ANYWHERE));
	}
	
	@Override
	public DetachedCriteria addLastNameConstraint(DetachedCriteria query, String lastName) {
		return query.add(Property.forName("user.lName").like(lastName, MatchMode.ANYWHERE));
	}
	
	@Override
	public DetachedCriteria addFirstNameConstraint(DetachedCriteria query, String firstName) {
		return query.add(Property.forName("user.fName").like(firstName,	MatchMode.ANYWHERE));
	}
	
	@Override
	public DetachedCriteria addUsernameConstraint(DetachedCriteria query, String username) {
		return query.add(Property.forName("user.username").like(username, MatchMode.ANYWHERE));
	}
	
	@Override
	public DetachedCriteria addSSNConstraint(DetachedCriteria query, String ssn) {
		return query.add(Property.forName("user.ssn").like("_____" + ssn, MatchMode.EXACT));
	}

	@Override
	public DetachedCriteria addGenderConstraint(DetachedCriteria query,	String gender) {
		return query.add(Property.forName("user.gender").like(gender, MatchMode.EXACT));
	}
	
	/*******************************************PROGRAM CONSTRAINTS*******************************************/
	
	@Override
	public DetachedCriteria addProgramConstraint(DetachedCriteria query, Program program) {
		return query.add(Restrictions.ilike("p.programCode", program.getProgramCode(), MatchMode.EXACT));
	}

	@Override
	public DetachedCriteria addProgramDomainConstraint(DetachedCriteria query, ProgramDomain programDomain) {
		return query.add(Restrictions.ilike("pD.programDomainCode", programDomain.getProgramDomainCode(), MatchMode.EXACT));
	}

	@Override
	public DetachedCriteria addProgramTrackConstraint(DetachedCriteria query, ProgramTrack programTrack) {
		return query.add(Restrictions.ilike("pT.programTrackCode", programTrack.getProgramTrackCode(), MatchMode.EXACT));
	}
	
	@Override
	public DetachedCriteria addAnticipatedCompleteTermConstraint(DetachedCriteria query, UKTerm anticipatedCompleteTerm) {
		return query.add(Restrictions.ilike("aC.ukTermCode", anticipatedCompleteTerm.getUkTermCode(), MatchMode.EXACT));
	}

	@Override
	public DetachedCriteria addProgramGroupConstraint(DetachedCriteria query, ProgramGroup programGroup) {
		return query.add(Restrictions.ilike("pG.programGroupCode", programGroup.getProgramGroupCode(), MatchMode.EXACT));
	}
	
	@Override
	public DetachedCriteria addUKMajorConstraint(DetachedCriteria query, UKMajor ukMajor) {
		return query.add(Restrictions.ilike("uM.ukMajorCode", ukMajor.getUkMajorCode(), MatchMode.EXACT));
	}

	@Override
	public DetachedCriteria addProgramStatusConstraint(DetachedCriteria query, UKStatus programStatus) {
		return query.add(Restrictions.ilike("uS.statusCode", programStatus.getStatusCode(), MatchMode.EXACT));
	}
	
	@Override
	public DetachedCriteria addProgramStartTermConstraint(DetachedCriteria query, UKTerm programStartTerm) {
		return query.add(Restrictions.ilike("uST.ukTermCode", programStartTerm.getUkTermCode(), MatchMode.EXACT));
	}

	@Override
	public DetachedCriteria addProgramCompleteTermConstraint(DetachedCriteria query, UKTerm programCompleteTerm) {
		return query.add(Restrictions.ilike("uCompT.ukTermCode", programCompleteTerm.getUkTermCode(), MatchMode.EXACT));
	}
	
	@Override
	public DetachedCriteria addAdvisorConstraint(DetachedCriteria query, Advisor advisor) {
		return query.add(Restrictions.ilike("ad.userid", advisor.getUserid(), MatchMode.EXACT));
	}
	
	public DetachedCriteria addFacultyAdvisorConstraint(DetachedCriteria query, FacultyAdvisor facultyAdvisor){
		return query.add(Restrictions.ilike("fA.userid", facultyAdvisor.getUserid(), MatchMode.EXACT));
	}

	@Override
	public DetachedCriteria createProgramProfileAlias(DetachedCriteria query) {

		DetachedCriteria aliasQuery = query.createAlias("userProgramProfiles", "pp", 
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("pp.program", "p",
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("pp.programDomain", "pD",
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("pp.programGroup", "pG",
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("pp.programTrack", "pT",
			JoinType.LEFT_OUTER_JOIN);	
		aliasQuery = aliasQuery.createAlias("pp.ukCompleteTerm", "uCompT",
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("pp.ukAnticipatedCompleteTerm", "aC",
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("pp.ukMajor", "uM",
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("pp.ukStartTerm", "uST",
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("pp.ukStatus", "uS",
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("pp.advisor", "ad",
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("pp.facultyAdvisor", "fA",
			JoinType.LEFT_OUTER_JOIN);
		
		return aliasQuery;		
	}
	/**************************************************************************************************************/
	/**********************************************COLLEGE CONSTRAINTS*********************************************/
	/**************************************************************************************************************/
	@Override
	public DetachedCriteria addUserTypeConstraint(DetachedCriteria query, UserType userType) {
		return query.add(Restrictions.ilike("ut.typeCode",
		userType.getTypeCode(), MatchMode.EXACT));
	}

	@Override
	public DetachedCriteria addUserClassificationConstraint(DetachedCriteria query, UserClassification userClassification) {
		return query.add(Restrictions.ilike("uc.classificationCode",
		userClassification.getClassificationCode(), MatchMode.EXACT));
	}

	@Override
	public DetachedCriteria addUKCollegeConstraint(DetachedCriteria query, UKCollege ukCollege) {
		return query.add(Restrictions.ilike("ukC.ukCollegeCode",
		ukCollege.getUkCollegeCode(), MatchMode.EXACT));
	}

	@Override
	public DetachedCriteria addUKDepartmentConstraint(DetachedCriteria query,UKDepartment ukDepartment) {
		return query.add(Restrictions.ilike("ukD.departmentCode",
		ukDepartment.getDepartmentCode(), MatchMode.EXACT));
	}

	@Override
	public DetachedCriteria addCollegeStartTermConstraint( DetachedCriteria query, UKTerm collegeStartTerm) {
		return query.add(Restrictions.ilike("ukCST.ukTermCode",
		collegeStartTerm.getUkTermCode(), MatchMode.EXACT));
	}

	@Override
	public DetachedCriteria addCollegeEndTermConstraint( DetachedCriteria query, UKTerm collegeEndTerm) {
		return query.add(Restrictions.ilike("ukCET.ukTermCode", collegeEndTerm.getUkTermCode(), MatchMode.EXACT));
	}

	@Override
	public DetachedCriteria addCollegeStatusConstraint(DetachedCriteria query, UKStatus collegeStatus) {
		return query.add(Restrictions.ilike("ukCS.statusCode",
		collegeStatus.getStatusCode(), MatchMode.EXACT));
	}

	@Override
	public DetachedCriteria addCohortTypeConstraint(DetachedCriteria query, CohortType cohortType) {
		return query.add(Restrictions.ilike("ccType.typeCode",
		cohortType.getTypeCode(), MatchMode.EXACT));
	}

	@Override
	public DetachedCriteria addCohortTermConstraint(DetachedCriteria query, CohortTerm cohortTerm) {
		return query.add(Restrictions.ilike("ccTerm.termCode",
		String.valueOf(cohortTerm.getTermCode()), MatchMode.EXACT));
	}
	
	@Override
	public DetachedCriteria createCollegeAlias(DetachedCriteria query) {

		DetachedCriteria aliasQuery = query.createAlias("userCollegeProfiles", "cp", 
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("cp.userType", "ut",
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("cp.userClassification", "uc",
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("cp.ukCollege", "ukC",
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("cp.ukDepartment", "ukD",
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("cp.startTerm", "ukCST",
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("cp.endTerm", "ukCET",
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("cp.status", "ukCS",
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("cp.cohortType", "ccType",
			JoinType.LEFT_OUTER_JOIN);
		aliasQuery = aliasQuery.createAlias("cp.cohortTerm", "ccTerm",
			JoinType.LEFT_OUTER_JOIN);	
		
		return aliasQuery;		
	}
	
	/**************************************************************************************************************/
	/*******************************************QUERY OPTION CONSTRAINTS*******************************************/
	/**************************************************************************************************************/
	// Boolean Order represents the Asc - True or Desc - False
	@Override
	public DetachedCriteria addOrder(DetachedCriteria query, String propertyName, boolean order) {		
		if (order) {
			return query.addOrder(Order.asc(propertyName));
		}
		return query.addOrder(Order.desc(propertyName));
	}
	
	@Override
	public DetachedCriteria addSearchInWS(DetachedCriteria query, WorkingSet ws) {
		return query.add(Property.forName("uid").in(convertUserToUIDString(ws.getUsers())));
	}	
	/**************************************************************************************************************/
	/**************************************************************************************************************/
	/**************************************************************************************************************/
	
	@Override
	public DetachedCriteria addGlobalSearchConstraint(DetachedCriteria query, String globalQuery) {
		System.out.println("addGlobalSearchConstraint function called"
				+ globalQuery);
		String[] formatQueries = StringOperation.formatStringQuery(globalQuery);
		
		Disjunction dis = Restrictions.disjunction();
		Conjunction con = Restrictions.conjunction();
		for (int i = 0; i < formatQueries.length; i++) {
			dis.add(Property.forName("user.username").like(formatQueries[i],
					MatchMode.ANYWHERE))
					.add(Property.forName("user.fName").like(formatQueries[i],
							MatchMode.ANYWHERE))
					.add(Property.forName("user.mName").like(formatQueries[i],
							MatchMode.ANYWHERE))
					.add(Property.forName("user.lName").like(formatQueries[i],
							MatchMode.ANYWHERE))
					.add(Property.forName("user.lName1").like(formatQueries[i],
							MatchMode.ANYWHERE))
					.add(Property.forName("user.lName2").like(formatQueries[i],
							MatchMode.ANYWHERE))
					.add(Property.forName("user.lName3").like(formatQueries[i],
							MatchMode.ANYWHERE))
					.add(Property.forName("user.lName4").like(formatQueries[i],
							MatchMode.ANYWHERE))
					.add(Property.forName("user.uid").like(formatQueries[i],
							MatchMode.ANYWHERE))
					.add(Property.forName("user.ukID").like(formatQueries[i],
							MatchMode.ANYWHERE));
			con.add(dis);
			dis = Restrictions.disjunction();
		}
		return query.add(con);
	}

 
	@Override
	public DetachedCriteria addUserProgramProfileConstraint(DetachedCriteria query, UserProgramProfile userProgramProfile) {
		return query.add(Property.forName(
			"user.userProgramProfiles.userprogramprofileid").eq(
			userProgramProfile.getUserprogramprofileid()));
	}
 
	@SuppressWarnings("unchecked")
	@Override
	public List<User> executeQuery(DetachedCriteria query) {
		System.out.println("executeQuery function called");

		System.out.println("Running HQL query");
	
		Criteria criteria = query.getExecutableCriteria(this.sessionFactory.getCurrentSession());
		System.out.println("Done retrieving");
		return criteria.list();
	}

	private List<String> convertUserToUIDString(Set<User> set) {
		List<String> uids = new ArrayList<String>(0);
		Iterator<User> iter = set.iterator();
		while (iter.hasNext()) {
			uids.add(iter.next().getUid());
		}
		return uids;
	}

 
	@Override
	public DetachedCriteria startQuery(Class<User> clazz) {
		DetachedCriteria dc = DetachedCriteria.forClass(clazz, "user")
			.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
		return dc;
	}

	@Override
	public void initializeSearchEngineIndex() {
		FullTextSession fullTextSession = Search
			.getFullTextSession(this.sessionFactory.getCurrentSession());
		try {
			fullTextSession.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> executeLuceneQuery(String queryString) {
		log.debug("Querying CEPIS Search index for '" + queryString + "'");
		FullTextSession fullTextSession = Search
				.getFullTextSession(this.sessionFactory.getCurrentSession());

		// create native Lucene query using the query DSL
		QueryBuilder cepisQB = fullTextSession.getSearchFactory()
				.buildQueryBuilder().forEntity(User.class).get();

		Query luceneQuery = cepisQB
				.keyword()
				.onFields("dOB", "fName", "fullName", "gender", "lName",
						"lName1", "lName2", "lName3", "lName4", "maidenName",
						"mName", "preferredName", "suffix", "title", "ukID",
						"username", "addresses.city", "addresses.country",
						"addresses.state", "addresses.street1",
						"addresses.street2", "addresses.zip")
				.matching(queryString).createQuery();

		// wrap Lucene query in a org.hibernate.Query
		org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(
				luceneQuery, User.class);

		// execute search
		List<User> result = hibQuery.list();
		if (result != null) {
			log.debug(result.size() + " matching users found for the query "
					+ queryString);
			return result;
		}
		log.debug("SearchResults returned null value");
		return new ArrayList<User>(0);
	}
}
