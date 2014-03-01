/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * 
 * @author cawalk4
 */
@Entity
@Table(name="tblCertification")
@Cache(region="edu.uky.cepis.cache.certification", usage=CacheConcurrencyStrategy.READ_WRITE)
public class Certification implements java.util.Comparator<Certification>,
		Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "incrementGen", strategy = "increment")  
    @GeneratedValue(generator = "incrementGen")  
	@Column(name="CertificationID")
	private long id;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="InitialDate")
	private Date initialDate;
	
	@Column(name="CompleteDate")
	private Date completeDate;
	
	@Column(name="Memo")
	private String memo;
	
	@Column(name="LastEdit")
	private Date lastEdit;
	
	@Column(name="State")
	private String state;
	
	@ManyToOne(targetEntity = Ranking.class)
	@NotFound(action=NotFoundAction.IGNORE)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="rankingCode", nullable = false)
	private Ranking ranking;
	
	@ManyToOne(targetEntity = UserProgramProfile.class)
	@NotFound(action=NotFoundAction.IGNORE)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="ProgUID", nullable = false, unique = true)
	private UserProgramProfile programProfile;
	
	/**
	 * 
	 */
	public Certification() {

	}

	/**
	 * @param id
	 * @param status
	 * @param initialDate
	 * @param completeDate
	 * @param ranking
	 * @param memo
	 * @param programProfile
	 */
	public Certification(String status, Date initialDate, Ranking ranking,
			String memo, UserProgramProfile programProfile, String state) {
		this.status = status;
		this.initialDate = initialDate;
		this.ranking = ranking;
		this.memo = memo;
		this.programProfile = programProfile;
		this.state = state;
		this.lastEdit = new Date();
	}

	/**
	 * @return the id
	 * @uml.property name="id"
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 * @uml.property name="id"
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the status
	 * @uml.property name="status"
	 */
	public String getStatus() {
		return status;
	}

	public String getStatusDescription() {
		if (status.equals("0")) {
			return "NOT REQUIRED";
		} else if (status.equals("1")) {
			return "NOT PRESENT";
		} else if (status.equals("2")) {
			return "COMPLETE";
		} else if (status.equals("3")) {
			return "INCOMPLETE";
		} else if (status.equals("4")) {
			return "NEEDS REVIEW";
		} else if (status.equals("5")) {
			return "COMPLETE INFORMAL";
		} else if (status.equals("6")) {
			return "NOT CURRENTLY REVIEWABLE";
		}
		return "";
	}

	/**
	 * @param status
	 *            the status to set
	 * @uml.property name="status"
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the initialDate
	 * @uml.property name="initialDate"
	 */
	public Date getInitialDate() {
		return initialDate;
	}

	/**
	 * @param initialDate
	 *            the initialDate to set
	 * @uml.property name="initialDate"
	 */
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	/**
	 * @return the completeDate
	 * @uml.property name="completeDate"
	 */
	public Date getCompleteDate() {
		return completeDate;
	}

	/**
	 * @param completeDate
	 *            the completeDate to set
	 * @uml.property name="completeDate"
	 */
	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	/**
	 * @return the ranking
	 * @uml.property name="ranking"
	 */
	public Ranking getRanking() {
		return ranking;
	}

	/**
	 * @param ranking
	 *            the ranking to set
	 * @uml.property name="ranking"
	 */
	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}

	/**
	 * @return the memo
	 * @uml.property name="memo"
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo
	 *            the memo to set
	 * @uml.property name="memo"
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return the lastEdit
	 * @uml.property name="lastEdit"
	 */
	public Date getLastEdit() {
		return lastEdit;
	}

	/**
	 * @param lastEdit
	 *            the lastEdit to set
	 * @uml.property name="lastEdit"
	 */
	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}

	/**
	 * @return the programProfile
	 * @uml.property name="programProfile"
	 */
	public UserProgramProfile getProgramProfile() {
		return programProfile;
	}

	/**
	 * @param programProfile
	 *            the programProfile to set
	 * @uml.property name="programProfile"
	 */
	public void setProgramProfile(UserProgramProfile programProfile) {
		this.programProfile = programProfile;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	/* (non-Javadoc)
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
		Certification other = (Certification) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int compare(Certification o1, Certification o2) {
		return o1.getProgramProfile().compare(o1.getProgramProfile(),
				o2.getProgramProfile())
				& o1.getRanking().compare(o1.getRanking(), o2.getRanking())
				| o1.getStatus().compareTo(o2.getStatus());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if (this.getProgramProfile() != null) {
			sb.append(this.getProgramProfile().getProgramDomain());
			sb.append(" - ");
			sb.append(this.getProgramProfile().getProgram());

		}
		if (this.getRanking() != null) {
			sb.append(": ");
			sb.append(this.getRanking().getTitle());
		}

		return sb.toString();
	}

}
