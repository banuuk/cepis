/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.apache.myfaces.custom.schedule.model.DefaultScheduleEntry;

/**
 * @author scott
 */
public class AdvisingSession extends DefaultScheduleEntry implements
		java.util.Comparator<AdvisingSession>, Serializable {

	private static final long serialVersionUID = 1L;

	private String advisingSessionID;
	// Even though we can get date and time of the
	// session from the slot, we duplicate it here
	// so that we can cancel the appointment, reuse
	// the slot, and still know what time the
	// appointment was
	private Date sessionDate;
	private String sessionType;
	private String sessionStatus;
	private String preSessionText;
	private String sessionText;
	private String studentNotes;
	private String advisorNotes;
	private int noShowEmailSent;
	/**
	 * @uml.property name="advisingSessionSlot"
	 * @uml.associationEnd
	 */
	private AdvisingSessionSlot advisingSessionSlot;

	private Date lastEdit;

	/**
	 * @uml.property name="advisor"
	 * @uml.associationEnd
	 */
	private Advisor advisor;
	/**
	 * @uml.property name="user"
	 * @uml.associationEnd
	 */
	private User user;
	private Set<HoldLift> holdLifts = new HashSet<HoldLift>(0);

	/**
	 * 
	 */
	public AdvisingSession() {
	}

	/**
	 * @param advisingSessionID
	 * @param sessionType
	 * @param sessionStatus
	 * @param preSessionText
	 * @param sessionText
	 * @param studentNotes
	 * @param advisorNotes
	 * @param studentFollowup
	 * @param advisorFollowup
	 * @param advisingSessionSlot
	 */
	public AdvisingSession(String advisingSessionID, Date sessionDate,
			String sessionType, String sessionStatus, String preSessionText,
			String sessionText, String studentNotes, String advisorNotes,
			AdvisingSessionSlot advisingSessionSlot, User user, Advisor advisor) {
		super();
		this.advisingSessionID = advisingSessionID;
		this.sessionDate = sessionDate;
		this.sessionType = sessionType;
		this.sessionStatus = sessionStatus;
		this.preSessionText = preSessionText;
		this.sessionText = sessionText;
		this.studentNotes = studentNotes;
		this.advisorNotes = advisorNotes;
		this.lastEdit = new Date();

		this.advisingSessionSlot = advisingSessionSlot;
		this.user = user;
		this.advisor = advisor;
	}

	/**
	 * @return the advisingSessionID
	 * @uml.property name="advisingSessionID"
	 */
	public String getAdvisingSessionID() {
		return advisingSessionID;
	}

	/**
	 * @param advisingSessionID
	 *            the advisingSessionID to set
	 * @uml.property name="advisingSessionID"
	 */
	public void setAdvisingSessionID(String advisingSessionID) {
		this.advisingSessionID = advisingSessionID;
	}

	/**
	 * @return the sessionDate
	 * @uml.property name="sessionDate"
	 */
	public Date getSessionDate() {
		return sessionDate;
	}

	/**
	 * @param sessionDate
	 *            the sessionDate to set
	 * @uml.property name="sessionDate"
	 */
	public void setSessionDate(Date sessionDate) {
		this.sessionDate = sessionDate;
	}

	/**
	 * @return the sessionType
	 * @uml.property name="sessionType"
	 */
	public String getSessionType() {
		return sessionType;
	}

	/**
	 * @param sessionType
	 *            the sessionType to set
	 * @uml.property name="sessionType"
	 */
	public void setSessionType(String sessionType) {
		this.sessionType = sessionType;
	}

	/**
	 * @return the sessionStatus
	 * @uml.property name="sessionStatus"
	 */
	public String getSessionStatus() {
		return sessionStatus;
	}

	/**
	 * @param sessionStatus
	 *            the sessionStatus to set
	 * @uml.property name="sessionStatus"
	 */
	public void setSessionStatus(String sessionStatus) {
		this.sessionStatus = sessionStatus;
	}

	/**
	 * @return the preSessionText
	 * @uml.property name="preSessionText"
	 */
	public String getPreSessionText() {
		return preSessionText;
	}

	/**
	 * @param preSessionText
	 *            the preSessionText to set
	 * @uml.property name="preSessionText"
	 */
	public void setPreSessionText(String preSessionText) {
		this.preSessionText = preSessionText;
	}

	/**
	 * @return the sessionText
	 * @uml.property name="sessionText"
	 */
	public String getSessionText() {
		return sessionText;
	}

	/**
	 * @param sessionText
	 *            the sessionText to set
	 * @uml.property name="sessionText"
	 */
	public void setSessionText(String sessionText) {
		this.sessionText = sessionText;
	}

	/**
	 * @return the studentNotes
	 * @uml.property name="studentNotes"
	 */
	public String getStudentNotes() {
		return studentNotes;
	}

	/**
	 * @param studentNotes
	 *            the studentNotes to set
	 * @uml.property name="studentNotes"
	 */
	public void setStudentNotes(String studentNotes) {
		this.studentNotes = studentNotes;
	}

	/**
	 * @return the advisorNotes
	 * @uml.property name="advisorNotes"
	 */
	public String getAdvisorNotes() {
		return advisorNotes;
	}

	/**
	 * @param advisorNotes
	 *            the advisorNotes to set
	 * @uml.property name="advisorNotes"
	 */
	public void setAdvisorNotes(String advisorNotes) {
		this.advisorNotes = advisorNotes;
	}

	/**
	 * @return the advisingSessionSlot
	 * @uml.property name="advisingSessionSlot"
	 */
	public AdvisingSessionSlot getAdvisingSessionSlot() {
		return advisingSessionSlot;
	}

	/**
	 * @param advisingSessionSlot
	 *            the advisingSessionSlot to set
	 * @uml.property name="advisingSessionSlot"
	 */
	public void setAdvisingSessionSlot(AdvisingSessionSlot advisingSessionSlot) {
		this.advisingSessionSlot = advisingSessionSlot;
	}

	/**
	 * @return the lastEdit
	 * @uml.property name="lastEdit"
	 */
	public Date getLastEdit() {
		return lastEdit;
	}

	/**
	 * @param lastEdit
	 *            the lastEdit to set
	 * @uml.property name="lastEdit"
	 */
	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}

	/**
	 * @return the advisor
	 * @uml.property name="advisor"
	 */
	public Advisor getAdvisor() {
		return advisor;
	}

	/**
	 * @param advisor
	 *            the advisor to set
	 * @uml.property name="advisor"
	 */
	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	/**
	 * @return the user
	 * @uml.property name="user"
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 * @uml.property name="user"
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @param holdLifts the holdLifts to set
	 */
	public void setHoldLifts(Set<HoldLift> holdLifts) {
		this.holdLifts = holdLifts;
	}

	/**
	 * @return the holdLifts
	 */
	public Set<HoldLift> getHoldLifts() {
		return holdLifts;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		super.setId(advisingSessionID);
		return advisingSessionID;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return user.toString()+ " (" + sessionStatus + ")";
	}

	/**
	 * @return the subtitle
	 */
	public String getSubtitle() {
		return sessionType ;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		if (preSessionText != null || preSessionText.trim().length() > 0) {
			return preSessionText;
		}
		return " ";
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return "TEB 166";
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return this.getSessionDate();
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(this.getSessionDate());
		cal.add(Calendar.MINUTE, 30);

		return cal.getTime();
	}

	public String getSessionTime() {
		Format formatter;
		formatter = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm aaa");
		String s = formatter.format(this.getSessionDate());

		return s;
	}
	
	/************************************** NO SHOW EMAIL BOOLEAN **************************************/

	public int getNoShowEmailSent() {
		return noShowEmailSent;
	}

	public void setNoShowEmailSent(int noShowEmailSent) {
		this.noShowEmailSent = noShowEmailSent;
	}
	
	public boolean getNoShowEmailSentBoolean(){
		if(getNoShowEmailSent() == 0){
			return false;
		}else{
			return true;
		}
	}
	
	public void setNoShowEmailSentBoolean(boolean noShowEmailSentBoolean){
		if(noShowEmailSentBoolean){
			setNoShowEmailSent(1);
		}else{
			setNoShowEmailSent(0);
		}
	}

	/**
	 * @return the allDay
	 */
	public boolean isAllDay() {
		return false;
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
		result = prime
				* result
				+ ((advisingSessionID == null) ? 0 : advisingSessionID
						.hashCode());
		result = prime
				* result
				+ ((advisingSessionSlot == null) ? 0 : advisingSessionSlot
						.hashCode());
		result = prime * result + ((advisor == null) ? 0 : advisor.hashCode());
		result = prime * result
				+ ((advisorNotes == null) ? 0 : advisorNotes.hashCode());
		result = prime * result
				+ ((lastEdit == null) ? 0 : lastEdit.hashCode());
		result = prime * result
				+ ((preSessionText == null) ? 0 : preSessionText.hashCode());
		result = prime * result
				+ ((sessionStatus == null) ? 0 : sessionStatus.hashCode());
		result = prime * result
				+ ((sessionText == null) ? 0 : sessionText.hashCode());
		result = prime * result
				+ ((sessionType == null) ? 0 : sessionType.hashCode());
		result = prime * result
				+ ((studentNotes == null) ? 0 : studentNotes.hashCode());
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
		AdvisingSession other = (AdvisingSession) obj;
		if (advisingSessionID == null) {
			if (other.advisingSessionID != null)
				return false;
		} else if (!advisingSessionID.equals(other.advisingSessionID))
			return false;
		if (advisingSessionSlot == null) {
			if (other.advisingSessionSlot != null)
				return false;
		} else if (!advisingSessionSlot.equals(other.advisingSessionSlot))
			return false;
		if (advisor == null) {
			if (other.advisor != null)
				return false;
		} else if (!advisor.equals(other.advisor))
			return false;
		if (advisorNotes == null) {
			if (other.advisorNotes != null)
				return false;
		} else if (!advisorNotes.equals(other.advisorNotes))
			return false;
		if (lastEdit == null) {
			if (other.lastEdit != null)
				return false;
		} else if (!lastEdit.equals(other.lastEdit))
			return false;
		if (preSessionText == null) {
			if (other.preSessionText != null)
				return false;
		} else if (!preSessionText.equals(other.preSessionText))
			return false;
		if (sessionStatus == null) {
			if (other.sessionStatus != null)
				return false;
		} else if (!sessionStatus.equals(other.sessionStatus))
			return false;
		if (sessionText == null) {
			if (other.sessionText != null)
				return false;
		} else if (!sessionText.equals(other.sessionText))
			return false;
		if (sessionType == null) {
			if (other.sessionType != null)
				return false;
		} else if (!sessionType.equals(other.sessionType))
			return false;
		if (studentNotes == null) {
			if (other.studentNotes != null)
				return false;
		} else if (!studentNotes.equals(other.studentNotes))
			return false;
		return true;
	}

	@Override
	public int compare(AdvisingSession o1, AdvisingSession o2) {
		return o1.getAdvisingSessionID().compareTo(o2.getAdvisingSessionID());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return user.getfName() + " " + user.getlName() + ": "
				+ this.getSessionTime() + " (" + this.getSessionStatus() + ")";
	}
}
