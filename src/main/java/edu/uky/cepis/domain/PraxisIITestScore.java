/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author cawalk4
 *
 */

@Entity
@Table(name="tblPraxis")
@Cache(region="edu.uky.cepis.cache.praxisIItestscore", usage=CacheConcurrencyStrategy.READ_WRITE)
public class PraxisIITestScore implements java.util.Comparator<PraxisIITestScore>,
		Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRAXISID")
	private long id;
	
	@Column(name = "TESTDATE")
	private Date testDate;
	
	@Column(name = "DATERECEIVED")
	private Date receivedDate;	
	
	@Column(name = "LASTEDIT")
	private Date lastEdit;
	
	@Column(name = "PRAXISSTUDENTID", length = 50)
	private String candidateId;
	
	@Column(name = "SCORE")
	private double score;
	
	@Column(name = "CUTOFF", length = 6)
	private int cutoff;
	
	@Column(name = "PRIMARYX", length = 6)
	private int primary;
		
	@Column(name = "NAI", length = 6)
	private int nonStandardAdministration;
	
	@Column(name = "RSI", length = 6)
	private int revisedScoreIndicator;
	
	@Column(name = "REI", length = 6)
	private int excellenceIndicator;
	
	@Column(name="PRAXISCODE", length = 50)
	private String praxisIICode;
		
	@ManyToOne(targetEntity = User.class)
	@Fetch(FetchMode.JOIN)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "UID")
	private User user;
	
	@Transient
	private PraxisIITest praxisIITest;
	
	@Transient
	private boolean archived;
	

	/**
	 * 
	 */
	public PraxisIITestScore() {

	}

	/**
	 * @param testDate
	 * @param praxisTest
	 * @param candidateId
	 * @param score
	 * @param cutoff
	 * @param primary
	 * @param reviewStatus
	 * @param nonStandardAdministration
	 * @param revisedScoreIndicator
	 * @param excellenceIndicator
	 */
	public PraxisIITestScore(Date testDate, PraxisIITest praxisIITest,
			String candidateId, double score, int primary,
			int nonStandardAdministration,
			int revisedScoreIndicator, int excellenceIndicator) {
		this.testDate = testDate;
		this.praxisIITest = praxisIITest;
		this.candidateId = candidateId;
		this.score = score;
		this.primary = primary;
		this.nonStandardAdministration = nonStandardAdministration;
		this.revisedScoreIndicator = revisedScoreIndicator;
		this.excellenceIndicator = excellenceIndicator;
		this.lastEdit = new Date();
		this.receivedDate = new Date();
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public PraxisIITest getPraxisIITest() {
		return praxisIITest;
	}

	public void setPraxisIITest(PraxisIITest praxisIITest) {
		this.praxisIITest = praxisIITest;
	}

	public Date getLastEdit() {
		return lastEdit;
	}

	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public double getScore() {
		DecimalFormat df = new DecimalFormat("#");
		df.format(score);
		return score;
	}
	
	public int getScoreInt(){
		int score = (int) this.score;
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public void setCutoff(int cutoff) {
		this.cutoff = cutoff;
	}

	public String getCutoff() {
		
		if(this.cutoff == 1 || this.cutoff == -1){
			return "Yes";
		}else{
			return "No";
		}
	}

	public int isPrimary() {
		return primary;
	}
	
	public String getPrimaryString(){
		if(primary == 1 || primary == -1){
			return "Yes";
		}else{
			return "No";
		}
	}

	public void setPrimary(int primary) {
		this.primary = primary;
	}

	public int getNonStandardAdministration() {
		return nonStandardAdministration;
	}

	public void setNonStandardAdministration(int nonStandardAdministration) {
		this.nonStandardAdministration = nonStandardAdministration;
	}

	public int getRevisedScoreIndicator() {
		return revisedScoreIndicator;
	}
	
	public void setRevisedScoreIndicator(int revisedScoreIndicator) {
		this.revisedScoreIndicator = revisedScoreIndicator;
	}

	public int getExcellenceIndicator() {
		return excellenceIndicator;
	}

	public void setExcellenceIndicator(int excellenceIndicator) {
		this.excellenceIndicator = excellenceIndicator;
	}

	public String getPraxisIICode() {
		return praxisIICode;
	}

	public void setPraxisIICode(String praxisIICode) {
		this.praxisIICode = praxisIICode;
	}

	public int getPrimary() {
		return primary;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
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
		result = prime * result
				+ ((candidateId == null) ? 0 : candidateId.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((praxisIITest == null) ? 0 : praxisIITest.hashCode());
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		PraxisIITestScore other = (PraxisIITestScore) obj;
		if (candidateId == null) {
			if (other.candidateId != null)
				return false;
		} else if (!candidateId.equals(other.candidateId))
			return false;
		if (id != other.id)
			return false;
		if (praxisIITest == null) {
			if (other.praxisIITest != null)
				return false;
		} else if (!praxisIITest.equals(other.praxisIITest))
			return false;
		if (Double.doubleToLongBits(score) != Double
				.doubleToLongBits(other.score))
			return false;
		return true;
	}

	@Override
	public int compare(PraxisIITestScore o1, PraxisIITestScore o2) {
		return (int) (o1.getId() - o2.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getPraxisIITest().toString() + this.getScore();
	}

}
