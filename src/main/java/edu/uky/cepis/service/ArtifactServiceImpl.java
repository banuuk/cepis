/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.ArtifactDao;
import edu.uky.cepis.domain.Artifact;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserAssessmentProfile;

/**
 * @author keerthi
 */
public class ArtifactServiceImpl implements ArtifactService {

	private ArtifactDao artifactDao;

	@Override
	public int addArtifactToUserAssessmentProfile(
			UserAssessmentProfile userAssessmentProfile,
			List<Artifact> artifacts) {
		return this.getArtifactDao().addArtifactToUserAssessmentProfile(
				userAssessmentProfile, artifacts);
	}

	@Override
	public int removeArtifactFromUserAssessmentProfile(
			UserAssessmentProfile userAssessmentProfile,
			List<Artifact> artifacts) {
		return this.getArtifactDao().removeArtifactFromUserAssessmentProfile(
				userAssessmentProfile, artifacts);
	}

	@Override
	public List<Artifact> getArtifactList(
			UserAssessmentProfile userAssessmentProfile) {
		return this.getArtifactDao().getArtifactList(userAssessmentProfile);
	}

	@Override
	public Artifact findById(long id) {
		return this.getArtifactDao().findById(id);
	}

	/**
	 * @return the artifactDao
	 */
	public ArtifactDao getArtifactDao() {
		return artifactDao;
	}

	/**
	 * @param artifactDao
	 *            the artifactDao to set
	 */
	public void setArtifactDao(ArtifactDao artifactDao) {
		this.artifactDao = artifactDao;
	}

	@Override
	public List<Artifact> getArtifactList(User user) {
		return this.getArtifactDao().getArtifactList(user);
	}

}
