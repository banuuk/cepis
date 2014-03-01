/**
 * 
 */
package edu.uky.cepis.domain;

/**
 * @author keerthi
 */
public class UserAssessmentStandard implements java.io.Serializable,
		java.util.Comparator<UserAssessmentStandard> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property name="programCode"
	 */
	private long stdId;
	/**
	 * @uml.property name="shortDesc"
	 */
	private Standard standard;
	private int score;

	/**
	 * 
	 */
	public UserAssessmentStandard() {
	}

	/**
	 * @param standard
	 * @param score
	 */
	public UserAssessmentStandard(Standard standard, int score) {
		this.standard = standard;
		this.score = score;
	}

	/**
	 * @return the stdId
	 */
	public long getStdId() {
		return stdId;
	}

	/**
	 * @param stdId
	 *            the stdId to set
	 */
	public void setStdId(long stdId) {
		this.stdId = stdId;
	}

	/**
	 * @return the standard
	 */
	public Standard getStandard() {
		return standard;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param standard
	 *            the standard to set
	 */
	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score = score;
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
		result = prime * result + score;
		result = prime * result
				+ ((standard == null) ? 0 : standard.hashCode());
		result = prime * result + (int) (stdId ^ (stdId >>> 32));
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
		if (!(obj instanceof UserAssessmentStandard)) {
			return false;
		}
		UserAssessmentStandard other = (UserAssessmentStandard) obj;
		if (score != other.score) {
			return false;
		}
		if (standard == null) {
			if (other.standard != null) {
				return false;
			}
		} else if (!standard.equals(other.standard)) {
			return false;
		}
		if (stdId != other.stdId) {
			return false;
		}
		return true;
	}

	@Override
	public int compare(UserAssessmentStandard o1, UserAssessmentStandard o2) {
		return (int) (o1.getStdId() - o2.getStdId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getStandard().toString();
	}

}
