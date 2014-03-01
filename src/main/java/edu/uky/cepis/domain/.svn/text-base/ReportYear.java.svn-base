/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author cawalk4
 *
 */
@Entity
@Table(name="lstReportyear")
public class ReportYear implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id	
	@Column(name="ReportYearCode", length = 50)
	private String reportYearCode;
	
	@Column(name = "DescreportYear", length = 50)
	private String description;
	
	@Column(name = "TermStart", length = 50)
	private String termStart;
	
	@Column(name = "TermEnd")
	private String termEnd;
	
	@Column(name = "DateStart")
	private Date dateStart;
	
	@Column(name = "DateEnd")
	private Date dateEnd;
	
	public ReportYear(){
		
	}
	

	public String getReportYearCode() {
		return reportYearCode;
	}

	public void setReportYearCode(String reportYearCode) {
		this.reportYearCode = reportYearCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTermStart() {
		return termStart;
	}

	public void setTermStart(String termStart) {
		this.termStart = termStart;
	}

	public String getTermEnd() {
		return termEnd;
	}

	public void setTermEnd(String termEnd) {
		this.termEnd = termEnd;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateEnd == null) ? 0 : dateEnd.hashCode());
		result = prime * result
				+ ((dateStart == null) ? 0 : dateStart.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((reportYearCode == null) ? 0 : reportYearCode.hashCode());
		result = prime * result + ((termEnd == null) ? 0 : termEnd.hashCode());
		result = prime * result
				+ ((termStart == null) ? 0 : termStart.hashCode());
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
		ReportYear other = (ReportYear) obj;
		if (dateEnd == null) {
			if (other.dateEnd != null)
				return false;
		} else if (!dateEnd.equals(other.dateEnd))
			return false;
		if (dateStart == null) {
			if (other.dateStart != null)
				return false;
		} else if (!dateStart.equals(other.dateStart))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (reportYearCode == null) {
			if (other.reportYearCode != null)
				return false;
		} else if (!reportYearCode.equals(other.reportYearCode))
			return false;
		if (termEnd == null) {
			if (other.termEnd != null)
				return false;
		} else if (!termEnd.equals(other.termEnd))
			return false;
		if (termStart == null) {
			if (other.termStart != null)
				return false;
		} else if (!termStart.equals(other.termStart))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ReportYear [reportYearCode=" + reportYearCode
				+ ", description=" + description + ", termStart=" + termStart
				+ ", termEnd=" + termEnd + ", dateStart=" + dateStart
				+ ", dateEnd=" + dateEnd + "]";
	}
	
	

}
	
