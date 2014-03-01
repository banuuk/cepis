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


/**
 * @author cawalk4
 *
 */
@Entity
@Table(name="tblGre")
public class GreTestScore implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="GreID", length = 11)
	private int greId;
	
	@Column(name = "Verbal", length = 6)
	private int verbal;
	
	@Column(name = "Quantitative", length = 6)
	private int quantitative;
	
	@Column(name = "Analytic")
	private float analytic;
	
	@Column(name = "Date")
	private Date testDate;
	
	@Column(name = "Cutoff", length = 4)
	private int cutOff;
	
	@Column(name = "Primaryx", length = 4)
	private int primary;
	
	@Column(name = "DateReceived")
	private Date dateRecieved;
			
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "UID", nullable = false)
	private User user;	
		
				
	public GreTestScore(){
		
	}


	public int getGreId() {
		return greId;
	}


	public void setGreId(int greId) {
		this.greId = greId;
	}


	public int getVerbal() {
		return verbal;
	}


	public void setVerbal(int verbal) {
		this.verbal = verbal;
	}


	public int getQuantitative() {
		return quantitative;
	}


	public void setQuantitative(int quantitative) {
		this.quantitative = quantitative;
	}


	public float getAnalytic() {
		return analytic;
	}


	public void setAnalytic(float analytic) {
		this.analytic = analytic;
	}


	public Date getTestDate() {
		return testDate;
	}


	public void setTestDate(Date testDate) {
		this.testDate = testDate;
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
		}else if(getPrimary() == 1 || getPrimary() == -1){
			return "Yes";
		}else
			return " ";
	}	
	
	public boolean getPrimaryBoolean(){
		if(getPrimary() == 1 || getPrimary() == -1){
			return true;
		}else
			return false;
	}
	
	public void setPrimaryBoolean(boolean primary){
		if(primary){
			setPrimary(1);
		}else{
			setPrimary(0);
		}
	}
	
	/* ************************ DATE RECIEVED ************************ */

	public Date getDateRecieved() {
		return dateRecieved;
	}

	public void setDateRecieved(Date dateRecieved) {
		this.dateRecieved = dateRecieved;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(analytic);
		result = prime * result + cutOff;
		result = prime * result
				+ ((dateRecieved == null) ? 0 : dateRecieved.hashCode());
		result = prime * result + greId;
		result = prime * result + primary;
		result = prime * result + quantitative;
		result = prime * result
				+ ((testDate == null) ? 0 : testDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + verbal;
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
		GreTestScore other = (GreTestScore) obj;
		if (Float.floatToIntBits(analytic) != Float
				.floatToIntBits(other.analytic))
			return false;
		if (cutOff != other.cutOff)
			return false;
		if (dateRecieved == null) {
			if (other.dateRecieved != null)
				return false;
		} else if (!dateRecieved.equals(other.dateRecieved))
			return false;
		if (greId != other.greId)
			return false;
		if (primary != other.primary)
			return false;
		if (quantitative != other.quantitative)
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
		if (verbal != other.verbal)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GreTestScore [greId=" + greId + ", verbal=" + verbal
				+ ", quantitative=" + quantitative + ", analytic=" + analytic
				+ ", testDate=" + testDate + ", cutOff=" + cutOff
				+ ", primary=" + primary + ", dateRecieved=" + dateRecieved
				+ ", user=" + user + "]";
	}

	

}
	
