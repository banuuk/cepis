/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.domain.Artifact;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserAssessmentProfile;

/**
 * @author keerthi
 * 
 */
public interface ArtifactService {
	public abstract int addArtifactToUserAssessmentProfile(
			UserAssessmentProfile userAssessmentProfile,
			List<Artifact> artifacts);

	public abstract int removeArtifactFromUserAssessmentProfile(
			UserAssessmentProfile userAssessmentProfile,
			List<Artifact> artifacts);

	public abstract List<Artifact> getArtifactList(
			UserAssessmentProfile userAssessmentProfile);

	public abstract Artifact findById(long id);
	
	public abstract List<Artifact> getArtifactList(User user);
}
