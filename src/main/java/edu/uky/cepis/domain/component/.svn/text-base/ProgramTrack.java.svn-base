/**
 * 
 */
package edu.uky.cepis.domain.component;


/**
 * @author  keerthi
 */
public class ProgramTrack implements java.io.Serializable,
		java.util.Comparator<ProgramTrack> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="programTrackCode"
	 */
	String programTrackCode;
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
	public ProgramTrack() {
	}

	/**
	 * @param programtrackid
	 * @param programTrackCode
	 * @param shortDesc
	 * @param description
	 * @param status
	 */
	public ProgramTrack( String programTrackCode,
			String shortDesc, String description, String status) {
		this.programTrackCode = programTrackCode;
		this.shortDesc = shortDesc;
		this.description = description;
		this.status = status;
	}

	

	/**
	 * @return  the programTrackCode
	 * @uml.property  name="programTrackCode"
	 */
	public String getProgramTrackCode() {
		return programTrackCode;
	}

	/**
	 * @param programTrackCode  the programTrackCode to set
	 * @uml.property  name="programTrackCode"
	 */
	public void setProgramTrackCode(String programTrackCode) {
		this.programTrackCode = programTrackCode;
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
		return shortDesc ;
	}
	
	

	
	/* (non-Javadoc)
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
				+ ((programTrackCode == null) ? 0 : programTrackCode.hashCode());
		result = prime * result
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		if (!(obj instanceof ProgramTrack)) {
			return false;
		}
		ProgramTrack other = (ProgramTrack) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (programTrackCode == null) {
			if (other.programTrackCode != null) {
				return false;
			}
		} else if (!programTrackCode.equals(other.programTrackCode)) {
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
	public int compare(ProgramTrack o1, ProgramTrack o2) {
		return o1.getProgramTrackCode().compareTo(o2.getProgramTrackCode());
	}

}
