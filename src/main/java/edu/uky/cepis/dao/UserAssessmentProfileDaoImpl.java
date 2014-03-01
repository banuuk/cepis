/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.Standard;
import edu.uky.cepis.domain.StandardSet;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserAssessmentProfile;
import edu.uky.cepis.domain.UserAssessmentStandard;
import edu.uky.cepis.domain.UserAssessmentStandardSet;
import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author keerthi
 * 
 */
public class UserAssessmentProfileDaoImpl implements UserAssessmentProfileDao {

	private static Logger log = Logger
			.getLogger(UserAssessmentProfileDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public synchronized int addUserAssessmentProfiles(
			List<UserAssessmentProfile> userAssessmentProfiles,
			ProgramDomain progDomain, UKTerm ukTerm, int assessmentType) {
		if (userAssessmentProfiles == null || progDomain == null
				|| ukTerm == null) {
			return -1;
		}
		if (userAssessmentProfiles.size() < 1) {
			return 0;
		}

		Iterator<UserAssessmentProfile> iterAssessment = userAssessmentProfiles
				.iterator();

		while (iterAssessment.hasNext()) {
			this.sessionFactory.getCurrentSession().saveOrUpdate(
					iterAssessment.next());
		}

		return userAssessmentProfiles.size();
	}

	@Override
	public synchronized boolean updateUserAssessmentProfile(
			UserAssessmentProfile userAssessmentProfile) {
		if (userAssessmentProfile == null) {
			return false;
		}

		Iterator<UserAssessmentStandardSet> iterStandardSet = null;
		Iterator<UserAssessmentStandard> iterStandard = null;
		UserAssessmentProfile newUserAssessmentProfile = null;
		UserAssessmentStandardSet userAssessmentStandardSet = null;
		UserAssessmentStandardSet newUserAssessmentStandardSet = null;
		UserAssessmentStandard userAssessmentStandard = null;
		UserAssessmentStandard newUserAssessmentStandard = null;
		newUserAssessmentProfile = (UserAssessmentProfile) this.sessionFactory
				.getCurrentSession().load(UserAssessmentProfile.class,
						userAssessmentProfile.getId());
		newUserAssessmentProfile.setAssessmentType(userAssessmentProfile
				.getAssessmentType());
		newUserAssessmentProfile.setUkTerm(userAssessmentProfile.getUkTerm());
		newUserAssessmentProfile.setScore(userAssessmentProfile.getScore());
		newUserAssessmentProfile.setDecision(userAssessmentProfile
				.getDecision());
		newUserAssessmentProfile.setShortDesc(userAssessmentProfile
				.getShortDesc());
		newUserAssessmentProfile.setLastModified(new Date());
		newUserAssessmentProfile.getStandardSets().clear();

		iterStandardSet = userAssessmentProfile.getStandardSets().iterator();
		while (iterStandardSet.hasNext()) {
			userAssessmentStandardSet = iterStandardSet.next();
			newUserAssessmentStandardSet = (UserAssessmentStandardSet) this.sessionFactory
					.getCurrentSession().load(UserAssessmentStandardSet.class,
							userAssessmentStandardSet.getStdSetId());
			newUserAssessmentStandardSet
					.setFinalScore(userAssessmentStandardSet.getFinalScore());
			newUserAssessmentStandardSet
					.setStandardSet(userAssessmentStandardSet.getStandardSet());
			newUserAssessmentStandardSet.getStandards().clear();

			iterStandard = userAssessmentStandardSet.getStandards().iterator();
			while (iterStandard.hasNext()) {
				userAssessmentStandard = iterStandard.next();
				newUserAssessmentStandard = (UserAssessmentStandard) this.sessionFactory
						.getCurrentSession().load(UserAssessmentStandard.class,
								userAssessmentStandard.getStdId());
				newUserAssessmentStandard.setStandard(userAssessmentStandard
						.getStandard());
				newUserAssessmentStandard.setScore(userAssessmentStandard
						.getScore());

				newUserAssessmentStandardSet.getStandards().add(
						newUserAssessmentStandard);
			}

			newUserAssessmentProfile.getStandardSets().add(
					newUserAssessmentStandardSet);
		}
		this.sessionFactory.getCurrentSession().saveOrUpdate(
				newUserAssessmentProfile);
		return true;
	}

	@Override
	public boolean deleteUserAssessmentProfile(
			UserAssessmentProfile userAssessmentProfile) {
		if (userAssessmentProfile == null) {
			return false;
		}
		this.sessionFactory.getCurrentSession().delete(userAssessmentProfile);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAssessmentProfile> getUserAssessmentProfiles(User user) {
		List<UserAssessmentProfile> userAssessmentProfiles = new ArrayList<UserAssessmentProfile>(
				0);
		if (user == null) {
			return userAssessmentProfiles;
		}

		String hql = "select userAssessmentProfile from User user join user.userAssessmentProfiles userAssessmentProfile where user.uid='"
				+ user.getUid() + "'";
		userAssessmentProfiles = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		return userAssessmentProfiles;
	}

}
