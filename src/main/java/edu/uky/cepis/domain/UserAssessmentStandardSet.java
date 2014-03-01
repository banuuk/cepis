/**
 * 
 */
package edu.uky.cepis.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author keerthi
 */
public class UserAssessmentStandardSet implements java.io.Serializable,
		java.util.Comparator<UserAssessmentStandardSet> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property name="programCode"
	 */
	private long stdSetId;
	/**
	 * @uml.property name="shortDesc"
	 */
	private StandardSet standardSet;
	private List<UserAssessmentStandard> standards = new ArrayList<UserAssessmentStandard>(
			0);
	private int finalScore;

	/**
	 * 
	 */
	public UserAssessmentStandardSet() {
	}

	/**
	 * @param standardSet
	 * @param standards
	 */
	public UserAssessmentStandardSet(StandardSet standardSet, int finalScore) {
		this.standardSet = standardSet;
		this.finalScore = finalScore;
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
		result = prime * result + finalScore;
		result = prime * result
				+ ((standardSet == null) ? 0 : standardSet.hashCode());
		result = prime * result + (int) (stdSetId ^ (stdSetId >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof UserAssessmentStandardSet)) {
			return false;
		}
		UserAssessmentStandardSet other = (UserAssessmentStandardSet) obj;
		if (finalScore != other.finalScore) {
			return false;
		}
		if (standardSet == null) {
			if (other.standardSet != null) {
				return false;
			}
		} else if (!standardSet.equals(other.standardSet)) {
			return false;
		}
		if (stdSetId != other.stdSetId) {
			return false;
		}
		return true;
	}

	/**
	 * @return the stdSetId
	 */
	public long getStdSetId() {
		return stdSetId;
	}

	/**
	 * @return the standardSet
	 */
	public StandardSet getStandardSet() {
		return standardSet;
	}

	/**
	 * @return the standards
	 */
	public List<UserAssessmentStandard> getStandards() {
		return standards;
	}

	/**
	 * @param stdSetId
	 *            the stdSetId to set
	 */
	public void setStdSetId(long stdSetId) {
		this.stdSetId = stdSetId;
	}

	/**
	 * @param standardSet
	 *            the standardSet to set
	 */
	public void setStandardSet(StandardSet standardSet) {
		this.standardSet = standardSet;
	}

	/**
	 * @param standards
	 *            the standards to set
	 */
	public void setStandards(List<UserAssessmentStandard> standards) {
		this.standards = standards;
	}

	@Override
	public int compare(UserAssessmentStandardSet o1,
			UserAssessmentStandardSet o2) {
		return (int) (o1.getStdSetId() - o2.getStdSetId());
	}

	/**
	 * @return the finalScore
	 */
	public double getComputedScore() {
		
		if (standards == null || standards.size() < 1) {
			return 0;
		} else {
			Iterator<UserAssessmentStandard> iter = standards.iterator();
			UserAssessmentStandard std = null;
			int score = 0;
			int count = 0;
			while (iter.hasNext()) {
				std = iter.next();
				if (std.getScore() != 0) {
					count++;
					score += std.getScore();
				}
			}
			if (count < 1) {
				return 0;
			}
			return (double) (score / count);
		}
	}

	/**
	 * @param finalScore
	 *            the finalScore to set
	 */
	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}

	/**
	 * @return the finalScore
	 */
	public int getFinalScore() {
		return finalScore;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return standardSet.toString();
	}
	
	

}
