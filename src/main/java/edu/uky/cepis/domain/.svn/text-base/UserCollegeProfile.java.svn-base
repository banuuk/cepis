/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import edu.uky.cepis.domain.component.UKCollege;
import edu.uky.cepis.domain.component.UKDepartment;
import edu.uky.cepis.domain.component.UKStatus;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * User College Profile for CEPIS user. 
 * NOTE: Student should only have one ACTIVE College Profile
 * NOTE: User who is both Faculty & Student, Staff & Student
 * 
 * @author cawalk4
 */
@Entity
@Table(name="tblCollegeprofile")
@Cache(region="edu.uky.cepis.cache.usercollegeprofile", usage=CacheConcurrencyStrategy.READ_WRITE)
public class UserCollegeProfile implements Comparator<UserCollegeProfile>, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CollegeprofileID")
	private long usercollegeprofileid;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="Collpersontypecode")
	private UserType userType;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="Collclassificationcode")
	private UserClassification userClassification;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="Collegecode")
	private UKCollege ukCollege;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="Deptartmentcode")
	private UKDepartment ukDepartment;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="Statterm")
	private UKTerm startTerm;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="EndTerm")
	private UKTerm endTerm;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="Statuscode")
	private UKStatus status;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="CohortTypeCode")
	private CohortType cohortType;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="CohortTermCode")
	private CohortTerm cohortTerm;

	@Column(name="shortDescription", length = 255)
	private String shortDesc;

	@Column(name="Lastedit")
	private Date lastUpdated;

	public UserCollegeProfile() {
	}

	
	public UserCollegeProfile(UserType userType,
			UserClassification userClassification, UKCollege ukCollege,
			UKDepartment ukDepartment, UKTerm startTerm, UKTerm endTerm,
			UKStatus status, CohortType cohortType, CohortTerm cohortTerm,
			String shortDesc) {
		this.userType = userType;
		this.userClassification = userClassification;
		this.ukCollege = ukCollege;
		this.ukDepartment = ukDepartment;
		this.startTerm = startTerm;
		this.endTerm = endTerm;
		this.status = status;
		this.cohortType = cohortType;
		this.cohortTerm = cohortTerm;
		this.shortDesc = shortDesc;
		this.lastUpdated = new Date();
	}


	public long getUsercollegeprofileid() {
		return usercollegeprofileid;
	}

	public void setUsercollegeprofileid(long usercollegeprofileid) {
		this.usercollegeprofileid = usercollegeprofileid;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public UserClassification getUserClassification() {
		return userClassification;
	}

	public void setUserClassification(UserClassification userClassification) {
		this.userClassification = userClassification;
	}

	public UKCollege getUkCollege() {
		return ukCollege;
	}

	public void setUkCollege(UKCollege ukCollege) {
		this.ukCollege = ukCollege;
	}

	public UKDepartment getUkDepartment() {
		return ukDepartment;
	}

	public void setUkDepartment(UKDepartment ukDepartment) {
		this.ukDepartment = ukDepartment;
	}

	public UKTerm getStartTerm() {
		return startTerm;
	}

	public void setStartTerm(UKTerm startTerm) {
		this.startTerm = startTerm;
	}

	public UKTerm getEndTerm() {
		return endTerm;
	}

	public void setEndTerm(UKTerm endTerm) {
		this.endTerm = endTerm;
	}

	public UKStatus getStatus() {
		return status;
	}

	public void setStatus(UKStatus status) {
		this.status = status;
	}

	public CohortType getCohortType() {
		return cohortType;
	}

	public void setCohortType(CohortType cohortType) {
		this.cohortType = cohortType;
	}

	public CohortTerm getCohortTerm() {
		return cohortTerm;
	}

	public void setCohortTerm(CohortTerm cohortTerm) {
		this.cohortTerm = cohortTerm;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((endTerm == null) ? 0 : endTerm.hashCode());
		result = prime * result
				+ ((cohortTerm == null) ? 0 : cohortTerm.hashCode());
		result = prime * result
				+ ((cohortType == null) ? 0 : cohortType.hashCode());
		result = prime * result
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
		result = prime * result
				+ ((startTerm == null) ? 0 : startTerm.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((ukCollege == null) ? 0 : ukCollege.hashCode());
		result = prime * result
				+ ((ukDepartment == null) ? 0 : ukDepartment.hashCode());
		result = prime
				* result
				+ ((userClassification == null) ? 0 : userClassification
						.hashCode());
		result = prime * result
				+ ((userType == null) ? 0 : userType.hashCode());
		result = prime * result
				+ (int) (usercollegeprofileid ^ (usercollegeprofileid >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserCollegeProfile other = (UserCollegeProfile) obj;
		if (endTerm == null) {
			if (other.endTerm != null)
				return false;
		} else if (!endTerm.equals(other.endTerm))
			return false;
		if (cohortTerm == null) {
			if (other.cohortTerm != null)
				return false;
		} else if (!cohortTerm.equals(other.cohortTerm))
			return false;
		if (cohortType == null) {
			if (other.cohortType != null)
				return false;
		} else if (!cohortType.equals(other.cohortType))
			return false;
		if (shortDesc == null) {
			if (other.shortDesc != null)
				return false;
		} else if (!shortDesc.equals(other.shortDesc))
			return false;
		if (startTerm == null) {
			if (other.startTerm != null)
				return false;
		} else if (!startTerm.equals(other.startTerm))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (ukCollege == null) {
			if (other.ukCollege != null)
				return false;
		} else if (!ukCollege.equals(other.ukCollege))
			return false;
		if (ukDepartment == null) {
			if (other.ukDepartment != null)
				return false;
		} else if (!ukDepartment.equals(other.ukDepartment))
			return false;
		if (userClassification == null) {
			if (other.userClassification != null)
				return false;
		} else if (!userClassification.equals(other.userClassification))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		if (usercollegeprofileid != other.usercollegeprofileid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ukCollege + " - " + ukDepartment + ", " + userClassification;
	}

	@Override
	public int compare(UserCollegeProfile o1, UserCollegeProfile o2) {
		return (int) (o1.getUsercollegeprofileid() - o2
				.getUsercollegeprofileid());
	}

}
