/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.Artifact;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserAssessmentProfile;

/**
 * Hibernate-based DAO class for CRUD operation on {@link Artifact} object.<br>
 * 
 * {@link SessionFactory} object injected via Spring IoC. {@link SessionFactory}
 * references the apexSessionFactory object.
 * 
 * @author keerthi
 * 
 */
@SuppressWarnings("unchecked")
public class ArtifactDaoImpl implements ArtifactDao {

	private static Logger log = Logger.getLogger(ArtifactDaoImpl.class);
	private SessionFactory sessionFactory;

	@Override
	public int addArtifactToUserAssessmentProfile(
			UserAssessmentProfile userAssessmentProfile,
			List<Artifact> artifacts) {
		if (userAssessmentProfile == null || artifacts == null) {
			return -1;
		}

		if (artifacts.size() < 1) {
			return 0;
		}

		Iterator<Artifact> iter = artifacts.iterator();
		StringBuffer sb = new StringBuffer(
				"insert into assessment_link (assessmentId,ID) values ");

		while (iter.hasNext()) {
			sb.append("(" + userAssessmentProfile.getId() + ","
					+ iter.next().getId() + ")");
			if (iter.hasNext()) {
				sb.append(", ");
			}
		}
		log.debug("SQL Query: " + sb.toString());
		SQLQuery query = this.sessionFactory.getCurrentSession()
				.createSQLQuery(sb.toString());
		return query.executeUpdate();

	}

	@Override
	public int removeArtifactFromUserAssessmentProfile(
			UserAssessmentProfile userAssessmentProfile,
			List<Artifact> artifacts) {
		if (userAssessmentProfile == null || artifacts == null) {
			return -1;
		}

		if (artifacts.size() < 1) {
			return 0;
		}

		Iterator<Artifact> iter = artifacts.iterator();
		StringBuffer sb = new StringBuffer("DELETE FROM assessment_link where ");

		while (iter.hasNext()) {
			sb.append("(assessmentId=" + userAssessmentProfile.getId()
					+ " and ID=" + iter.next().getId() + ")");
			if (iter.hasNext()) {
				sb.append(" or ");
			}
		}
		log.debug("SQL Query: " + sb.toString());
		SQLQuery query = this.sessionFactory.getCurrentSession()
				.createSQLQuery(sb.toString());
		return query.executeUpdate();

	}

	@Override
	public Artifact findById(long id) {

		List<Artifact> artifacts = new ArrayList<Artifact>(0);
		artifacts = this.sessionFactory
				.getCurrentSession()
				.createQuery("select distinct a from Artifact a where a.id = ?")
				.setParameter(0, id).list();
		if (artifacts.size() > 0)
			return artifacts.get(0);
		return null;
	}

	@Override
	public List<Artifact> getArtifactList(
			UserAssessmentProfile userAssessmentProfile) {
		List<Artifact> artifacts = new ArrayList<Artifact>(0);
		if (userAssessmentProfile == null) {
			return artifacts;
		}
		String hql = "select a from  Artifact a where a.assessmentProfile = "
				+ userAssessmentProfile.getId()
				+ " order by a.semester,a.year desc";
		artifacts = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return artifacts;

	}

	@Override
	public List<Artifact> getArtifactList(User user) {
		List<Artifact> artifacts = new ArrayList<Artifact>(0);
		if (user == null) {
			return artifacts;
		}
		String hql = "select a from  Artifact a where a.user = '"
				+ user.getUsername()
				+ "' and a.status='complete' order by a.semester,a.year desc";
		artifacts = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return artifacts;

	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
