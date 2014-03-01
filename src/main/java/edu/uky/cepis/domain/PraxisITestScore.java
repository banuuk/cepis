/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


/**
 * @author cawalk4
 *
 */
@Entity
@Table(name="tblPraxisI")
public class PraxisITestScore implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRAXIS1ID")
	private long id;
	
	@Column(name = "TESTDATE")
	private Date testDate;
	
	@Column(name = "SCORE")
	private double score;
	
	@Column(name = "CUTOFF", length = 4)
	private int cutOff;
	
	@Column(name = "PRIMARYX", length = 4)
	private int primary;
	
	@Column(name = "DATERECEIVED")
	private Date dateRecieved;
		
	@Column(name = "PRAXISSTUDENTID")
	private String candidateId;
		
	@Column(name = "PRAXIS1CODE", length = 50)
	private String praxisICode;
	
	@ManyToOne(targetEntity = User.class)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "UID")
	private User user;
	
	@Transient
	private PraxisITest praxisITest;
	
	public PraxisITestScore(){
		
	}

	/* ************************ ID ************************ */
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/* ************************ TESTDATE ************************ */
	
	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	/* ************************ SCORE ************************ */
	
	public double getScore() {
		return score;
	}
	
	public int getScoreInt(){
		return (int) score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	/* ************************ CUTOFF ************************ */
	
	public int getCutOff() {
		return cutOff;
	}

	public void setCutOff(int cutOff) {
		this.cutOff = cutOff;
	}
	
	public String getCutOffString(){
		if (getCutOff() == 0){
			return "No";
		}else if(getCutOff() == 1 || getCutOff() == -1){
			return "Yes";
		}else
			return " ";
	}

	/* ************************ PRIMARY ************************ */
	
	public int getPrimary() {
		return primary;
	}

	public void setPrimary(int primary) {
		this.primary = primary;
	}
	
	public String getPrimaryString(){
		if(getPrimary() == 0){
			return "No";
		}else if(getPrimary() == 1 || getPrimary() != -1){
			return "Yes";
		}else
			return " ";
	}	
	
	/* ************************ DATERECIEVED ************************ */
	
	public Date getDateRecieved() {
		return dateRecieved;
	}

	public void setDateRecieved(Date dateRecieved) {
		this.dateRecieved = dateRecieved;
	}
	
	/* ************************ STUDENTID ************************ */

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	
		
	/* ************************ PRAXISITEST ************************ */

	public String getPraxisICode() {
		return praxisICode;
	}

	public void setPraxisICode(String praxisICode) {
		this.praxisICode = praxisICode;
	}
	
	/* ************************ UID ************************ */

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public PraxisITest getPraxisITest() {
		return praxisITest;
	}

	public void setPraxisITest(PraxisITest praxisITest) {
		this.praxisITest = praxisITest;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cutOff;
		result = prime * result
				+ ((dateRecieved == null) ? 0 : dateRecieved.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((praxisICode == null) ? 0 : praxisICode.hashCode());
		result = prime * result
				+ ((praxisITest == null) ? 0 : praxisITest.hashCode());
		result = prime * result
				+ ((candidateId == null) ? 0 : candidateId.hashCode());
		result = prime * result + primary;
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((testDate == null) ? 0 : testDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		PraxisITestScore other = (PraxisITestScore) obj;
		if (cutOff != other.cutOff)
			return false;
		if (dateRecieved == null) {
			if (other.dateRecieved != null)
				return false;
		} else if (!dateRecieved.equals(other.dateRecieved))
			return false;
		if (id != other.id)
			return false;
		if (praxisICode == null) {
			if (other.praxisICode != null)
				return false;
		} else if (!praxisICode.equals(other.praxisICode))
			return false;
		if (praxisITest == null) {
			if (other.praxisITest != null)
				return false;
		} else if (!praxisITest.equals(other.praxisITest))
			return false;
		if (candidateId == null) {
			if (other.candidateId != null)
				return false;
		} else if (!candidateId.equals(other.candidateId))
			return false;
		if (primary != other.primary)
			return false;
		if (Double.doubleToLongBits(score) != Double
				.doubleToLongBits(other.score))
			return false;
		if (testDate == null) {
			if (other.testDate != null)
				return false;
		} else if (!testDate.equals(other.testDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PraxisITestScore [id=" + id + ", testDate=" + testDate
				+ ", score=" + score + ", cutOff=" + cutOff + ", primary="
				+ primary + ", dateRecieved=" + dateRecieved
				+ ", praxisStudentId=" + candidateId + ", praxisICode="
				+ praxisICode + ", uid=" + user + ", praxisITest=" + praxisITest
				+ "]";
	}


	
}
	
