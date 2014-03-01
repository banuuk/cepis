/**
 * 
 */
package edu.uky.cepis.domain.component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.uky.cepis.domain.StandardSet;

/**
 * @author keerthi
 */
public class ProgramDomain implements java.io.Serializable,
		java.util.Comparator<ProgramDomain> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property name="programDomainCode"
	 */
	String programDomainCode;
	/**
	 * @uml.property name="shortDesc"
	 */
	String shortDesc;
	/**
	 * @uml.property name="description"
	 */
	String description;
	/**
	 * @uml.property name="status"
	 */
	String status;
	/**
	 * @uml.property name="programs"
	 */
	Set<Program> programs = new HashSet<Program>(0);
	List<StandardSet> standardSets = new ArrayList<StandardSet>(0);

	/**
	 * 
	 */
	public ProgramDomain() {
	}

	/**
	 * @param programdomainid
	 * @param programDomainCode
	 * @param shortDesc
	 * @param description
	 * @param status
	 * @param programs
	 */
	public ProgramDomain(String programDomainCode, String shortDesc,
			String description, String status, Set<Program> programs) {
		this.programDomainCode = programDomainCode;
		this.shortDesc = shortDesc;
		this.description = description;
		this.status = status;
		this.programs = programs;
	}

	/**
	 * @param programdomainid
	 * @param programDomainCode
	 * @param shortDesc
	 * @param description
	 * @param status
	 */
	public ProgramDomain(String programDomainCode, String shortDesc,
			String description, String status) {

		this.programDomainCode = programDomainCode;
		this.shortDesc = shortDesc;
		this.description = description;
		this.status = status;
	}

	/**
	 * @return the programDomainCode
	 * @uml.property name="programDomainCode"
	 */
	public String getProgramDomainCode() {
		return programDomainCode;
	}

	/**
	 * @param programDomainCode
	 *            the programDomainCode to set
	 * @uml.property name="programDomainCode"
	 */
	public void setProgramDomainCode(String programDomainCode) {
		this.programDomainCode = programDomainCode;
	}

	/**
	 * @return the shortDesc
	 * @uml.property name="shortDesc"
	 */
	public String getShortDesc() {
		return shortDesc;
	}

	/**
	 * @param shortDesc
	 *            the shortDesc to set
	 * @uml.property name="shortDesc"
	 */
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	/**
	 * @return the description
	 * @uml.property name="description"
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 * @uml.property name="description"
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the status
	 * @uml.property name="status"
	 */
	public String getStatus() {
		return status;
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
	 * @return the programs
	 * @uml.property name="programs"
	 */
	public Set<Program> getPrograms() {
		return programs;
	}

	/**
	 * @param programs
	 *            the programs to set
	 * @uml.property name="programs"
	 */
	public void setPrograms(Set<Program> programs) {
		this.programs = programs;
	}
	
	

	/**
	 * @return the standardSets
	 */
	public List<StandardSet> getStandardSets() {
		return standardSets;
	}

	/**
	 * @param standardSets the standardSets to set
	 */
	public void setStandardSets(List<StandardSet> standardSets) {
		this.standardSets = standardSets;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return shortDesc;
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
				+ ((description == null) ? 0 : description.hashCode());
		result = prime
				* result
				+ ((programDomainCode == null) ? 0 : programDomainCode
						.hashCode());
		result = prime * result
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ProgramDomain)) {
			return false;
		}
		ProgramDomain other = (ProgramDomain) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (programDomainCode == null) {
			if (other.programDomainCode != null) {
				return false;
			}
		} else if (!programDomainCode.equals(other.programDomainCode)) {
			return false;
		}
		if (shortDesc == null) {
			if (other.shortDesc != null) {
				return false;
			}
		} else if (!shortDesc.equals(other.shortDesc)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		return true;
	}

	@Override
	public int compare(ProgramDomain o1, ProgramDomain o2) {
		return o1.getProgramDomainCode().compareTo(o2.getProgramDomainCode());
	}

}
