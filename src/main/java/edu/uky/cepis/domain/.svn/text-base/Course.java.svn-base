/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;

/**
 * @author keerthi
 */
public class Course implements Serializable, java.util.Comparator<Course> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Identifiers or composite keys
	private String stuMasterNo;
	private String sourceID;
	private String sourceCD;
	private String cdpMask;
	private String ukID;
	private String no;

	private String section;

	private String title;

	private String term;

	private String gpa;

	private int gpaHours;

	private int gpaPoints;
	
	private String rTitle;

	/**
	 * 
	 */
	public Course() {
	}

	/**
	 * @param id
	 * @param no
	 * @param section
	 * @param title
	 * @param term
	 * @param gpa
	 * @param gpaHours
	 * @param gpaPoints
	 */
	public Course(String no, String section, String title, String term,
			String gpa, int gpaHours, int gpaPoints) {
		this.no = no;
		this.section = section;
		this.title = title;
		this.term = term;
		this.gpa = gpa;
		this.gpaHours = gpaHours;
		this.gpaPoints = gpaPoints;
	}

	/**
	 * @return the stuMasterNo
	 */
	public String getStuMasterNo() {
		return stuMasterNo;
	}

	/**
	 * @param stuMasterNo
	 *            the stuMasterNo to set
	 */
	public void setStuMasterNo(String stuMasterNo) {
		this.stuMasterNo = stuMasterNo;
	}

	/**
	 * @return the sourceID
	 */
	public String getSourceID() {
		return sourceID;
	}

	/**
	 * @param sourceID
	 *            the sourceID to set
	 */
	public void setSourceID(String sourceID) {
		this.sourceID = sourceID;
	}

	/**
	 * @return the sourceCD
	 */
	public String getSourceCD() {
		return sourceCD;
	}

	/**
	 * @param sourceCD
	 *            the sourceCD to set
	 */
	public void setSourceCD(String sourceCD) {
		this.sourceCD = sourceCD;
	}

	/**
	 * @return the cdpMask
	 */
	public String getCdpMask() {
		return cdpMask;
	}

	/**
	 * @param cdpMask
	 *            the cdpMask to set
	 */
	public void setCdpMask(String cdpMask) {
		this.cdpMask = cdpMask;
	}

	/**
	 * @return the no
	 */
	public String getNo() {
		return no;
	}

	/**
	 * @return the section
	 */
	public String getSection() {
		return section;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}
	

	/**
	 * @return the ukID
	 */
	public String getUkID() {
		return ukID;
	}

	/**
	 * @param ukID the ukID to set
	 */
	public void setUkID(String ukID) {
		this.ukID = ukID;
	}

	/**
	 * @return the gpa
	 */
	public String getGpa() {
		return gpa;
	}

	/**
	 * @param no
	 *            the no to set
	 */
	public void setNo(String no) {
		this.no = no;
	}

	/**
	 * @param section
	 *            the section to set
	 */
	public void setSection(String section) {
		this.section = section;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param term
	 *            the term to set
	 */
	public void setTerm(String term) {
		this.term = term;
	}

	/**
	 * @param gpa
	 *            the gpa to set
	 */
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	/**
	 * @return the gpaHours
	 */
	public int getGpaHours() {
		return gpaHours;
	}

	/**
	 * @param gpaHours
	 *            the gpaHours to set
	 */
	public void setGpaHours(int gpaHours) {
		this.gpaHours = gpaHours;
	}

	/**
	 * @return the gpaPoints
	 */
	public int getGpaPoints() {
		return gpaPoints;
	}

	/**
	 * @param gpaPoints
	 *            the gpaPoints to set
	 */
	public void setGpaPoints(int gpaPoints) {
		this.gpaPoints = gpaPoints;
	}

	public String getrTitle() {
		return rTitle;
	}

	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
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
		result = prime * result + ((cdpMask == null) ? 0 : cdpMask.hashCode());
		result = prime * result + ((gpa == null) ? 0 : gpa.hashCode());
		result = prime * result + gpaHours;
		result = prime * result + gpaPoints;
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		result = prime * result
				+ ((sourceCD == null) ? 0 : sourceCD.hashCode());
		result = prime * result
				+ ((sourceID == null) ? 0 : sourceID.hashCode());
		result = prime * result
				+ ((stuMasterNo == null) ? 0 : stuMasterNo.hashCode());
		result = prime * result + ((term == null) ? 0 : term.hashCode());
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
		Course other = (Course) obj;
		if (cdpMask == null) {
			if (other.cdpMask != null)
				return false;
		} else if (!cdpMask.equals(other.cdpMask))
			return false;
		if (gpa == null) {
			if (other.gpa != null)
				return false;
		} else if (!gpa.equals(other.gpa))
			return false;
		if (gpaHours != other.gpaHours)
			return false;
		if (gpaPoints != other.gpaPoints)
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		if (sourceCD == null) {
			if (other.sourceCD != null)
				return false;
		} else if (!sourceCD.equals(other.sourceCD))
			return false;
		if (sourceID == null) {
			if (other.sourceID != null)
				return false;
		} else if (!sourceID.equals(other.sourceID))
			return false;
		if (stuMasterNo == null) {
			if (other.stuMasterNo != null)
				return false;
		} else if (!stuMasterNo.equals(other.stuMasterNo))
			return false;
		if (term == null) {
			if (other.term != null)
				return false;
		} else if (!term.equals(other.term))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public int compare(Course o1, Course o2) {
		return (o1.getStuMasterNo() + o1.getSourceID() + o1.getSourceCD()
				+ o1.getCdpMask() + o1.getNo() + o1.getSection() + o1.getTerm())
				.compareTo(o2.getStuMasterNo() + o2.getSourceID()
						+ o2.getSourceCD() + o2.getCdpMask() + o2.getNo()
						+ o2.getSection() + o2.getTerm());
	}

}
