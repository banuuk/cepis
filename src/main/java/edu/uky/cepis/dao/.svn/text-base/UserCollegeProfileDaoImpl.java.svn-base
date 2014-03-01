/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.efs.openreports.providers.DataSourceProvider;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.sql.JoinType;

import edu.uky.cepis.domain.CohortTerm;
import edu.uky.cepis.domain.CohortType;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserClassification;
import edu.uky.cepis.domain.UserCollegeProfile;
import edu.uky.cepis.domain.UserType;
import edu.uky.cepis.domain.component.UKCollege;
import edu.uky.cepis.domain.component.UKDepartment;
import edu.uky.cepis.domain.component.UKStatus;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author keerthi
 * @author cawalk4
 */
public class UserCollegeProfileDaoImpl implements UserCollegeProfileDao {

	private static Logger log = Logger.getLogger(UserCollegeProfileDaoImpl.class);
	
	private DataSourceProvider dataSourceProvider;
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return the dataSourceProvider
	 */
	public DataSourceProvider getDataSourceProvider() {
		return dataSourceProvider;
	}

	/**
	 * @param dataSourceProvider
	 *            the dataSourceProvider to set
	 */
	public void setDataSourceProvider(DataSourceProvider dataSourceProvider) {
		this.dataSourceProvider = dataSourceProvider;
	}

	@Override
	public boolean addUserCollegeProfileToUser(User user, UserType userType,
			UserClassification userClassification, UKCollege ukCollege,
			UKDepartment ukDepartment, UKTerm startTerm, UKTerm endTerm,
			UKStatus status, CohortType cohortType, CohortTerm cohortTerm,
			String shortDesc) {

		if (user == null) {
			return false;
		}

		if (userType == null || userClassification == null || ukCollege == null
				|| ukDepartment == null) {
			return false;
		}

		if (this.findUserCollegeProfile(user, userType, userClassification,
				ukCollege, ukDepartment, startTerm, endTerm, status,
				cohortType, cohortTerm)) {
			System.out
					.println("Duplicate User College profile available for this user");
			return false;
		}
		UserCollegeProfile userCollegeProfile = new UserCollegeProfile(
				userType, userClassification, ukCollege, ukDepartment,
				startTerm, endTerm, status, cohortType, cohortTerm,
				shortDesc);

		if (!this.saveUserCollegeProfile(userCollegeProfile)) {
			return false;
		}
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return false;
		}
		newuser.getUserCollegeProfiles().add(userCollegeProfile);
		return true;
	}

	@SuppressWarnings("unchecked")
	private boolean findUserCollegeProfile(User user, UserType userType,
			UserClassification userClassification, UKCollege ukCollege,
			UKDepartment ukDepartment, UKTerm startTerm, UKTerm endTerm,
			UKStatus status, CohortType cohortType, CohortTerm cohortTerm) {

		log.debug("Entered UserCollegeProfileDaoImpl.findUsercollegeProfile");
		
		List<User> users = new ArrayList<User>(0);

		DetachedCriteria dc = DetachedCriteria.forClass(User.class, "user");
		dc.add(Property.forName("user.uid").eq(user.getUid()));
		dc = dc.createAlias("user.userCollegeProfiles", "a",
				JoinType.LEFT_OUTER_JOIN);
		if (userType != null) {
			dc.add(Property.forName("a.userType.typeCode").eq(
					userType.getTypeCode()));
		}
		if (userClassification != null) {
			dc.add(Property.forName("a.userClassification.classificationCode")
					.eq(userClassification.getClassificationCode()));
		}
		if (ukCollege != null) {
			dc.add(Property.forName("a.ukCollege.ukCollegeCode").eq(
					ukCollege.getUkCollegeCode()));
		}
		if (ukDepartment != null) {
			dc.add(Property.forName("a.ukDepartment.departmentCode").eq(
					ukDepartment.getDepartmentCode()));
		}
		if (startTerm != null) {
			dc.add(Property.forName("a.startTerm.ukTermCode").eq(
					startTerm.getUkTermCode()));
		}
		if (endTerm != null) {
			dc.add(Property.forName("a.endTerm.ukTermCode").eq(
					endTerm.getUkTermCode()));
		}
		if (status != null) {
			dc.add(Property.forName("a.status.statusCode").eq(
					status.getStatusCode()));
		}
		if (cohortType != null) {
			dc.add(Property.forName("a.cohortType.typeCode").eq(
					cohortType.getTypeCode()));
		}
		if (cohortTerm != null) {
			dc.add(Property.forName("a.cohortTerm.termCode").eq(
					cohortTerm.getTermCode()));
		}
		Criteria criteria = dc.getExecutableCriteria(this.sessionFactory
				.getCurrentSession());
		users = criteria.list();
		if (users.size() > 0) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserCollegeProfile findUserCollegeProfile(long usercollegeprofileid) {

		List<UserCollegeProfile> userCollegeProfiles = new ArrayList<UserCollegeProfile>(0);
		String hql = "select a from UserCollegeProfile a where a.usercollegeprofileid="	+ usercollegeprofileid;
		
		userCollegeProfiles = this.sessionFactory.getCurrentSession().createQuery(hql).list();
		
		UserCollegeProfile userCollegeProfile = null;
		
		if (userCollegeProfiles.size() > 0) {
			userCollegeProfile = userCollegeProfiles.get(0);
		}
		
		return userCollegeProfile;
	}

	@Override
	public boolean removeUserCollegeProfileFromUser(User user,
			UserCollegeProfile userCollegeProfile) {
		if (user == null) {
			return false;
		}
		if (userCollegeProfile == null) {
			return false;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return false;
		}
		Set<UserCollegeProfile> userCollegeProfiles = newuser
				.getUserCollegeProfiles();
		UserCollegeProfile newUserCollegeProfile = (UserCollegeProfile) this.sessionFactory
				.getCurrentSession().load(UserCollegeProfile.class,
						userCollegeProfile.getUsercollegeprofileid());
		if (userCollegeProfiles.contains(newUserCollegeProfile)) {
			newuser.getUserCollegeProfiles().remove(newUserCollegeProfile);
			this.sessionFactory.getCurrentSession().delete(
					newUserCollegeProfile);
			return true;
		}

		return false;

	}

	@Override
	public boolean saveUserCollegeProfile(UserCollegeProfile userCollegeProfile) {
		this.sessionFactory.getCurrentSession()
				.saveOrUpdate(userCollegeProfile);
		return true;
	}

	@Override
	public UserCollegeProfile updateUserCollegeProfile(User user,
			UserCollegeProfile userCollegeProfile, UserType userType,
			UserClassification userClassification, UKCollege ukCollege,
			UKDepartment ukDepartment, UKTerm startTerm, UKTerm endTerm,
			UKStatus status, CohortType cohortType, CohortTerm cohortTerm,
			String shortDesc) {

		if (user == null) {
			return null;
		}
		if (userCollegeProfile == null) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		UserCollegeProfile newUserCollegeProfile = (UserCollegeProfile) this.sessionFactory
				.getCurrentSession().load(UserCollegeProfile.class,
						userCollegeProfile.getUsercollegeprofileid());
		if (!newuser.getUserCollegeProfiles().contains(newUserCollegeProfile)) {
			return null;
		}
		newUserCollegeProfile.setUserType(userType);
		newUserCollegeProfile.setUserClassification(userClassification);
		newUserCollegeProfile.setUkCollege(ukCollege);
		newUserCollegeProfile.setUkDepartment(ukDepartment);
		newUserCollegeProfile.setStartTerm(startTerm);
		newUserCollegeProfile.setEndTerm(endTerm);
		newUserCollegeProfile.setStatus(status);
		newUserCollegeProfile.setCohortType(cohortType);
		newUserCollegeProfile.setCohortTerm(cohortTerm);
		newUserCollegeProfile.setShortDesc(shortDesc);
		newUserCollegeProfile.setLastUpdated(new Date());
		if (!this.saveUserCollegeProfile(newUserCollegeProfile)) {
			return null;
		}
		return newUserCollegeProfile;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserCollegeProfile> getUserCollegeProfiles(User user) {

		List<UserCollegeProfile> userCollegeProfiles = new ArrayList<UserCollegeProfile>(0);
		
		String hql = "select b from  edu.uky.cepis.domain.User a join a.userCollegeProfiles b  where a.uid like '"
		+ user.getUid() + "' order by b.usercollegeprofileid";
		
		userCollegeProfiles = this.sessionFactory.getCurrentSession().createQuery(hql).list();
		
		return userCollegeProfiles;
		
	}


}
