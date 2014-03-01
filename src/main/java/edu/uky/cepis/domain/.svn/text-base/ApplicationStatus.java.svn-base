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
@Table(name = "lstApplicationstatus")
public class ApplicationStatus implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id	
	@Column(name = "APPLICATIONSTATUSCODE")
	private String applicationStatusCode;
	
	@Column(name = "DESCAPPLICATIONSTATUS")
	private String applicationStatusDescription;

	public String getApplicationStatusCode() {
		return applicationStatusCode;
	}

	public void setApplicationStatusCode(String applicationStatusCode) {
		this.applicationStatusCode = applicationStatusCode;
	}

	public String getApplicationStatusDescription() {
		return applicationStatusDescription;
	}

	public void setApplicationStatusDescription(String applicationStatusDescription) {
		this.applicationStatusDescription = applicationStatusDescription;
	}
	
	public ApplicationStatus(){
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((applicationStatusCode == null) ? 0 : applicationStatusCode
						.hashCode());
		result = prime
				* result
				+ ((applicationStatusDescription == null) ? 0
						: applicationStatusDescription.hashCode());
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
		ApplicationStatus other = (ApplicationStatus) obj;
		if (applicationStatusCode == null) {
			if (other.applicationStatusCode != null)
				return false;
		} else if (!applicationStatusCode.equals(other.applicationStatusCode))
			return false;
		if (applicationStatusDescription == null) {
			if (other.applicationStatusDescription != null)
				return false;
		} else if (!applicationStatusDescription
				.equals(other.applicationStatusDescription))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApplicationStatus [applicationStatusCode="
				+ applicationStatusCode + ", applicationStatusDescription="
				+ applicationStatusDescription + "]";
	}

}
	
