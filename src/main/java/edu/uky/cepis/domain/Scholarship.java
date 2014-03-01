/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author cawalk4
 */
@Entity
@Table(name="lstScholarship")
@Cache(region="edu.uky.cepis.cache.scholarship", usage=CacheConcurrencyStrategy.READ_WRITE)
public class Scholarship implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Scholarshipcode", length = 50)
	private String scholarshipCode;
	
	@Column(name="ScholarName", length = 100)
	private String scholarshipName;
	
	public Scholarship(){
		
	}

	public String getScholarshipCode() {
		return scholarshipCode;
	}

	public void setScholarshipCode(String scholarshipCode) {
		this.scholarshipCode = scholarshipCode;
	}

	public String getScholarshipName() {
		return scholarshipName;
	}

	public void setScholarshipName(String scholarshipName) {
		this.scholarshipName = scholarshipName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((scholarshipCode == null) ? 0 : scholarshipCode.hashCode());
		result = prime * result
				+ ((scholarshipName == null) ? 0 : scholarshipName.hashCode());
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
		Scholarship other = (Scholarship) obj;
		if (scholarshipCode == null) {
			if (other.scholarshipCode != null)
				return false;
		} else if (!scholarshipCode.equals(other.scholarshipCode))
			return false;
		if (scholarshipName == null) {
			if (other.scholarshipName != null)
				return false;
		} else if (!scholarshipName.equals(other.scholarshipName))
			return false;
		return true;
	}
	
	
	
}
