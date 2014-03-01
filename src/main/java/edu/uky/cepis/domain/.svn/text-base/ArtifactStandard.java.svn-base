/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * ArtifactStandard class for the {@link Artifact} object is used to store the
 * standard metric assigned to an artifact.
 * 
 * @see UserAssessmentStandard
 * 
 * @author keerthi
 */
public class ArtifactStandard implements Serializable,
		java.util.Comparator<ArtifactStandard> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int score;
	private String standard;
	private long id;

	/**
	 * 
	 */
	public ArtifactStandard() {
	}

	public ArtifactStandard(int score, String standard) {
		this.score = score;
		this.standard = standard;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the standard
	 */
	public String getStandard() {
		return standard;
	}

	/**
	 * @param standard
	 *            the standard to set
	 */
	public void setStandard(String standard) {
		this.standard = standard;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + score;
		result = prime * result
				+ ((standard == null) ? 0 : standard.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtifactStandard other = (ArtifactStandard) obj;
		if (id != other.id)
			return false;
		if (score != other.score)
			return false;
		if (standard == null) {
			if (other.standard != null)
				return false;
		} else if (!standard.equals(other.standard))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getStandard() + "(" + this.getScore() + ")";
	}

	@Override
	public int compare(ArtifactStandard o1, ArtifactStandard o2) {
		return (int) (o1.getId() - o2.getId())
				& o1.getStandard().compareTo(o2.standard);
	}

}
