/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Artifact class for the {@link UserAssessmentProfile} object is used to store
 * the artifact of physical locations given by the user.
 * 
 * @author keerthi
 */
public class Artifact implements Serializable, java.util.Comparator<Artifact> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private long assessmentProfile;
	private String user;
	private String faculty;
	private String course;
	private String type;
	private String status;
	private String assignment;
	private String comment;
	private int portfolio;
	private Date date;
	private String semester;
	private String year;
	private int sctn;
	private String domain;
	private String pacategory;
	private String pacategory2;
	private int usview;
	private int ciview;
	private int approve;
	private String approvedBy;
	private String score;
	private Set<ArtifactStandard> standards = new HashSet<ArtifactStandard>(0);

	/**
	 * 
	 */
	public Artifact() {
	}

	public Artifact(String user, String faculty, String course, String type,
			String status, String assignment, String comment, int portfolio,
			Date date, String semester, String year, int approve,
			String approvedBy, String score) {
		this.user = user;
		this.faculty = faculty;
		this.course = course;
		this.type = type;
		this.status = status;
		this.assignment = assignment;
		this.comment = comment;
		this.portfolio = portfolio;
		this.date = date;
		this.semester = semester;
		this.year = year;
		this.approve = approve;
		this.approvedBy = approvedBy;
		this.score = score;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Artifact o1, Artifact o2) {
		return (int) (o1.id - o2.id) & o1.user.compareTo(o2.user)
				& o1.assignment.compareTo(o2.assignment);
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

	/**
	 * @return the assessmentProfile
	 */
	public long getAssessmentProfile() {
		return assessmentProfile;
	}

	/**
	 * @param assessmentProfile
	 *            the assessmentProfile to set
	 */
	public void setAssessmentProfile(long assessmentProfile) {
		this.assessmentProfile = assessmentProfile;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the faculty
	 */
	public String getFaculty() {
		return faculty;
	}

	/**
	 * @param faculty
	 *            the faculty to set
	 */
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @param course
	 *            the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the assignment
	 */
	public String getAssignment() {
		return assignment;
	}

	/**
	 * @param assignment
	 *            the assignment to set
	 */
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the portfolio
	 */
	public int getPortfolio() {
		return portfolio;
	}

	/**
	 * @param portfolio
	 *            the portfolio to set
	 */
	public void setPortfolio(int portfolio) {
		this.portfolio = portfolio;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}

	/**
	 * @param semester
	 *            the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the approve
	 */
	public int getApprove() {
		return approve;
	}

	/**
	 * @param approve
	 *            the approve to set
	 */
	public void setApprove(int approve) {
		this.approve = approve;
	}

	/**
	 * @return the approvedBy
	 */
	public String getApprovedBy() {
		return approvedBy;
	}

	/**
	 * @param approvedBy
	 *            the approvedBy to set
	 */
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	/**
	 * @return the score
	 */
	public String getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(String score) {
		this.score = score;
	}

	/**
	 * @return the standards
	 */
	public Set<ArtifactStandard> getStandards() {
		return standards;
	}

	/**
	 * @param standards
	 *            the standards to set
	 */
	public void setStandards(Set<ArtifactStandard> standards) {
		this.standards = standards;
	}

	/**
	 * @return the sctn
	 */
	public int getSctn() {
		return sctn;
	}

	/**
	 * @param sctn
	 *            the sctn to set
	 */
	public void setSctn(int sctn) {
		this.sctn = sctn;
	}

	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * @param domain
	 *            the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * @return the pacategory
	 */
	public String getPacategory() {
		return pacategory;
	}

	/**
	 * @param pacategory
	 *            the pacategory to set
	 */
	public void setPacategory(String pacategory) {
		this.pacategory = pacategory;
	}

	/**
	 * @return the pacategory2
	 */
	public String getPacategory2() {
		return pacategory2;
	}

	/**
	 * @param pacategory2
	 *            the pacategory2 to set
	 */
	public void setPacategory2(String pacategory2) {
		this.pacategory2 = pacategory2;
	}

	/**
	 * @return the usview
	 */
	public int getUsview() {
		return usview;
	}

	/**
	 * @param usview
	 *            the usview to set
	 */
	public void setUsview(int usview) {
		this.usview = usview;
	}

	/**
	 * @return the ciview
	 */
	public int getCiview() {
		return ciview;
	}

	/**
	 * @param ciview
	 *            the ciview to set
	 */
	public void setCiview(int ciview) {
		this.ciview = ciview;
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
		result = prime * result + approve;
		result = prime * result
				+ ((approvedBy == null) ? 0 : approvedBy.hashCode());
		result = prime * result
				+ (int) (assessmentProfile ^ (assessmentProfile >>> 32));
		result = prime * result
				+ ((assignment == null) ? 0 : assignment.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + portfolio;
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result
				+ ((semester == null) ? 0 : semester.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		Artifact other = (Artifact) obj;
		if (approve != other.approve)
			return false;
		if (approvedBy == null) {
			if (other.approvedBy != null)
				return false;
		} else if (!approvedBy.equals(other.approvedBy))
			return false;
		if (assessmentProfile != other.assessmentProfile)
			return false;
		if (assignment == null) {
			if (other.assignment != null)
				return false;
		} else if (!assignment.equals(other.assignment))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (faculty == null) {
			if (other.faculty != null)
				return false;
		} else if (!faculty.equals(other.faculty))
			return false;
		if (id != other.id)
			return false;
		if (portfolio != other.portfolio)
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (semester == null) {
			if (other.semester != null)
				return false;
		} else if (!semester.equals(other.semester))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Artifact: " + assignment + " (" + status + ")[createdBy="
				+ user + ", approvedBy=" + approvedBy + ", score=" + score
				+ "]";
	}

}
