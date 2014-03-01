/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author cawalk4
 *
 */
@Entity
@Table(name="lstPraxis")
@Cache(region="edu.uky.cepis.cache.praxisIItest", usage=CacheConcurrencyStrategy.READ_WRITE)
public class PraxisIITest implements java.util.Comparator<PraxisIITest>, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@Column(name="BEGINDATE")
	private Date beginDate;
	
	@Column(name="ENDDATE")
	private Date endDate;
	
	@Column(name="PRAXISCODE", length=50)
	private String testCode;
	
	@Column(name="TITLE", length=100)
	private String title;
	
	@Column(name="CURRENCY", length=15)
	private String status;
	
	@Column(name="CUTOFF")
	private int cutoffScore;

	/**
	 * 
	 */
	public PraxisIITest() {

	}
	
	/* ******************ID****************** */
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	/* ******************BEGIN DATE****************** */

	public Date getBeginDate() {
		return beginDate;
	}
	
	public String getBeginDateFormatted(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		if(getBeginDate() != null){
			String beginDateFormatted = dateFormat.format(getBeginDate());
			return beginDateFormatted;
		}else{
			return " ";
		}
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
	/* ******************END DATE****************** */

	public Date getEndDate() {
		return endDate;
	}
	
	public String getEndDateFormatted(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		if(getEndDate() != null){
			String endDateFormatted = dateFormat.format(getEndDate());
			return endDateFormatted;
		}else{
			return " ";
		}
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/* ******************TEST CODE****************** */

	public String getTestCode() {
		return testCode;
	}

	public void setTestCode(String testCode) {
		this.testCode = testCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCutoffScore() {
		return cutoffScore;
	}

	public void setCutoffScore(int cutoffScore) {
		this.cutoffScore = cutoffScore;
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
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((testCode == null) ? 0 : testCode.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		PraxisIITest other = (PraxisIITest) obj;
		if (id != other.id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (testCode == null) {
			if (other.testCode != null)
				return false;
		} else if (!testCode.equals(other.testCode))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public int compare(PraxisIITest o1, PraxisIITest o2) {
		return (int) (o1.getId() - o2.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getTestCode() + "-" + this.getTitle() + "("
				+ this.getStatus() + ")";
	}

}
