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


/**
 * @author cawalk4
 *
 */
@Entity
@Table(name="lstPraxis1")
public class PraxisITest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@Column(name="PRAXIS1CODE", length=50)
	private String praxisICode;
	
	@Column(name="TITLE", length=100)
	private String title;
	
	@Column(name="CUTOFF", length=11)
	private int cutoff;
	
	@Column(name="CURRENCY", length=15)
	private String status;
	
	@Column(name="BEGINDATE")
	private Date beginDate;
	
	@Column(name="ENDDATE")
	private Date endDate;
	
	public PraxisITest(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPraxisICode() {
		return praxisICode;
	}

	public void setPraxisICode(String praxisICode) {
		this.praxisICode = praxisICode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCutoff() {
		return cutoff;
	}

	public void setCutoff(int cutoff) {
		this.cutoff = cutoff;
	}
	
	/* ******************STATUS****************** */

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	/* ******************BEGIN DATE****************** */

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
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
	
	/* ******************END DATE****************** */

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cutoff;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((praxisICode == null) ? 0 : praxisICode.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		PraxisITest other = (PraxisITest) obj;
		if (cutoff != other.cutoff)
			return false;
		if (id != other.id)
			return false;
		if (praxisICode == null) {
			if (other.praxisICode != null)
				return false;
		} else if (!praxisICode.equals(other.praxisICode))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Praxis1Test [id=" + id + ", praxis1Code=" + praxisICode
				+ ", title=" + title + ", cutoff=" + cutoff + "]";
	}
	
	
}
	
