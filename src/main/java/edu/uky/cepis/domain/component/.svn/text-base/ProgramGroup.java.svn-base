/**
 * 
 */
package edu.uky.cepis.domain.component;

/**
 * @author  keerthi
 */
public class ProgramGroup implements java.io.Serializable,
		java.util.Comparator<ProgramGroup> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="programGroupCode"
	 */
	String programGroupCode;
	/**
	 * @uml.property  name="shortDesc"
	 */
	String shortDesc;
	/**
	 * @uml.property  name="description"
	 */
	String description;
	/**
	 * @uml.property  name="status"
	 */
	String status;

	/**
	 * 
	 */
	public ProgramGroup() {
	}

	/**
	 * @param programgroupid
	 * @param programGroupCode
	 * @param shortDesc
	 * @param description
	 * @param status
	 */
	public ProgramGroup(String programGroupCode, String shortDesc,
			String description, String status) {
		this.programGroupCode = programGroupCode;
		this.shortDesc = shortDesc;
		this.description = description;
		this.status = status;
	}

	/**
	 * @return  the programGroupCode
	 * @uml.property  name="programGroupCode"
	 */
	public String getProgramGroupCode() {
		return programGroupCode;
	}

	/**
	 * @param programGroupCode  the programGroupCode to set
	 * @uml.property  name="programGroupCode"
	 */
	public void setProgramGroupCode(String programGroupCode) {
		this.programGroupCode = programGroupCode;
	}

	/**
	 * @return  the shortDesc
	 * @uml.property  name="shortDesc"
	 */
	public String getShortDesc() {
		return shortDesc;
	}

	/**
	 * @param shortDesc  the shortDesc to set
	 * @uml.property  name="shortDesc"
	 */
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	/**
	 * @return  the description
	 * @uml.property  name="description"
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description  the description to set
	 * @uml.property  name="description"
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return  the status
	 * @uml.property  name="status"
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status  the status to set
	 * @uml.property  name="status"
	 */
	public void setStatus(String status) {
		this.status = status;
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
				+ ((programGroupCode == null) ? 0 : programGroupCode.hashCode());
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
		if (!(obj instanceof ProgramGroup)) {
			return false;
		}
		ProgramGroup other = (ProgramGroup) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (programGroupCode == null) {
			if (other.programGroupCode != null) {
				return false;
			}
		} else if (!programGroupCode.equals(other.programGroupCode)) {
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
	public int compare(ProgramGroup o1, ProgramGroup o2) {
		return o1.getProgramGroupCode().compareTo(o2.getProgramGroupCode());
	}

}
