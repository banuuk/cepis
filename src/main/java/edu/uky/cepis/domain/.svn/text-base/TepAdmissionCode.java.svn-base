/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author cawalk4
 *
 */
@Entity
@Table(name = "lstTepadmission")
public class TepAdmissionCode implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id	
	@Column(name = "TepAdmissionCode", length = 50)
	private String termCode;
	
	@Column(name = "DescTepAdmission", length = 50)
	private String description;
					
	public TepAdmissionCode(){
		
	}

	public String getTermCode() {
		return termCode;
	}


	public void setTermCode(String termCode) {
		this.termCode = termCode;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((termCode == null) ? 0 : termCode.hashCode());
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
		TepAdmissionCode other = (TepAdmissionCode) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (termCode == null) {
			if (other.termCode != null)
				return false;
		} else if (!termCode.equals(other.termCode))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "TepAdmissionCode [termCode=" + termCode + ", description="
				+ description + "]";
	}

		
	

}
	
