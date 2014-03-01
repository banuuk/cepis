/**
 * 
 */
package edu.uky.cepis.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author keerthi
 */
public class UserAssessmentProfile implements java.io.Serializable,
		java.util.Comparator<UserAssessmentProfile> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property name="programCode"
	 */
	private long id;
	/**
	 * @uml.property name="shortDesc"
	 */
	private ProgramDomain programDomain;
	private UKTerm ukTerm;
	private int assessmentType;
	private List<UserAssessmentStandardSet> standardSets = new ArrayList<UserAssessmentStandardSet>(
			0);
	private Set<Artifact> artifacts = new HashSet<Artifact>(0);
	private int score;
	private int decision;
	private String shortDesc;
	private User user;
	private Date lastModified;

	/**
	 * 
	 */
	public UserAssessmentProfile() {
	}

	/**
	 * @param programDomain
	 * @param ukTerm
	 * @param assessmentType
	 * @param score
	 * @param shortDesc
	 */
	public UserAssessmentProfile(ProgramDomain programDomain, UKTerm ukTerm,
			int assessmentType, int score, int decision, String shortDesc,
			User user) {
		this.programDomain = programDomain;
		this.ukTerm = ukTerm;
		this.assessmentType = assessmentType;
		this.score = score;
		this.decision = decision;
		this.shortDesc = shortDesc;
		this.user = user;
		this.lastModified = new Date();
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the programDomain
	 */
	public ProgramDomain getProgramDomain() {
		return programDomain;
	}

	/**
	 * @return the ukTerm
	 */
	public UKTerm getUkTerm() {
		return ukTerm;
	}

	/**
	 * @return the assessmentType
	 */
	public int getAssessmentType() {
		return assessmentType;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @return the finalScore
	 */
	public int getComputedScore() {
		System.out.println("Calling Get computed score ");
		if (standardSets == null || standardSets.size() < 1) {
			return 0;
		} else {
			Iterator<UserAssessmentStandardSet> iter = standardSets.iterator();
			UserAssessmentStandardSet stdSet = null;
			int score = 0;
			int count = 0;
			while (iter.hasNext()) {
				stdSet = iter.next();
				if (stdSet.getFinalScore() != 0) {
					count++;
					score += stdSet.getFinalScore();
				}
			}
			if (count < 1 || score < 1) {
				return 0;
			}
			return (score / count);
		}
	}

	/**
	 * @return the shortDesc
	 */
	public String getShortDesc() {
		return shortDesc;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param programDomain
	 *            the programDomain to set
	 */
	public void setProgramDomain(ProgramDomain programDomain) {
		this.programDomain = programDomain;
	}

	/**
	 * @param ukTerm
	 *            the ukTerm to set
	 */
	public void setUkTerm(UKTerm ukTerm) {
		this.ukTerm = ukTerm;
	}

	/**
	 * @param assessmentType
	 *            the assessmentType to set
	 */
	public void setAssessmentType(int assessmentType) {
		this.assessmentType = assessmentType;
	}

	/**
	 * @return the standardSets
	 */
	public List<UserAssessmentStandardSet> getStandardSets() {
		return standardSets;
	}

	/**
	 * @param standardSets
	 *            the standardSets to set
	 */
	public void setStandardSets(List<UserAssessmentStandardSet> standardSets) {
		this.standardSets = standardSets;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @param shortDesc
	 *            the shortDesc to set
	 */
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	/**
	 * @return the artifacts
	 */
	public Set<Artifact> getArtifacts() {
		return artifacts;
	}

	/**
	 * @param artifacts
	 *            the artifacts to set
	 */
	public void setArtifacts(Set<Artifact> artifacts) {
		this.artifacts = artifacts;
	}

	@Override
	public int compare(UserAssessmentProfile o1, UserAssessmentProfile o2) {
		return (int) (o1.getId() - o2.getId())
				& o1.getUser().compare(o1.getUser(), o2.getUser());
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param lastModified
	 *            the lastModified to set
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * @return the lastModified
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * @param decision
	 *            the decision to set
	 */
	public void setDecision(int decision) {
		this.decision = decision;
	}

	/**
	 * @return the decision
	 */
	public int getDecision() {
		return decision;
	}

}
