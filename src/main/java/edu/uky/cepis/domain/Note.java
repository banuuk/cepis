/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;


/**
 * 
 * @author cawalk4
 *
 */
@Entity
@Table(name="tblNotes")
@Cache(region="edu.uky.cepis.cache.note", usage=CacheConcurrencyStrategy.READ_WRITE)
public class Note implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="NOTEID")
	private long id;
	
	@Column(name="CATEGORY", length=50)
	private String category;
		
	@Column(name="ENTEREDBY", nullable = false, length=50)
	private String enteredBy;
	
	@Column(name="EMAILSUBJECT", length = 50)
	private String emailSubject;
	
	@Column(name="EMAILCONTENT")
	private String emailContent;
	
	@Column(name="NOTECONTENT")
	private String noteContent;	
	
	@Column(name="CREATIONDATE", nullable = false)
	private Date creationDate;

	@Column(name="EMAILSENTFLG")
	@Type(type="yes_no")
	private Boolean emailSent;
	
	@Column(name="EMAILSAVEDFLG")
	@Type(type="yes_no")
	private Boolean emailSaved;
	
	@Column(name="ALERTCREATEDFLG")
	@Type(type="yes_no")
	private Boolean alertCreated;
	
	@Column(name="NOTESAVEDFLG")
	@Type(type="yes_no")
	private Boolean noteSaved;
	
	@Column(name="HIDDENFLG")
	@Type(type="yes_no")
	private Boolean noteHidden;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "tblStudentNotes", joinColumns={ 
	@JoinColumn(name = "NOTEID")}, inverseJoinColumns={
	@JoinColumn(name = "UID")})
	private Set<User> students = new HashSet<User>();	
	
	public Note(){
		super();
		this.alertCreated = null;
		this.category = "";
		this.emailSaved = null;
		this.emailSent = null;
		this.noteContent = "";
		this.emailContent = "";
		this.emailSubject = "";
		this.noteHidden = null;
	}
	
	public Object clone() {
        
        Note obj = new Note();
        obj.setAlertCreated(this.alertCreated);
        obj.setCategory(this.category);
        obj.setNoteSaved(this.noteSaved);
        obj.setEmailSent(this.emailSent);
        obj.setEnteredBy(this.enteredBy);
        obj.setNoteContent(this.noteContent);
        obj.setEmailContent(this.emailContent);
        obj.setEmailSubject(this.emailSubject);
        obj.setNoteHidden(this.noteHidden);
        
        return obj;
    }

	/* ************ID************ */
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	/* ************************ CATEGORY ************************ */
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	/* ************************ ENTERED BY ************************ */
	public String getEnteredBy() {
		return enteredBy;
	}
	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	/* ************************ EMAIL SUBJECT ************************ */
	public String getEmailSubject() {
		return emailSubject;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	/* ************************ EMAIL CONTENT ************************ */
	public String getEmailContent() {
		return emailContent;
	}
	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	/* ************************ NOTE CONTENT ************************ */
	public String getNoteContent() {
		if(noteContent == null){
			setNoteContent(" ");
		}
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	/* ************************ CREATION DATE ************************ */
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/* ************************ EMAIL SENT ************************ */
	public String getEmailSentString(){
		if(getEmailSent() != null){
			if (getEmailSent()){
				return "Yes";
			}else {
				return "No";
			}
		}else {
			return " ";
		}
	}
	public Boolean getEmailSent() {
		return emailSent;
	}
	public void setEmailSent(Boolean emailSent) {
		this.emailSent = emailSent;
	}
	
	/* ************************ EMAIL SAVED ************************ */
	public String getEmailSavedString(){
		if(getEmailSaved() != null){
			if (getEmailSaved()){
				return "Yes";
			}else {
				return "No";
			}
		}else {
			return " ";
		}		
	}
	public Boolean getEmailSaved() {
		return emailSaved;
	}
	public void setEmailSaved(Boolean emailSaved) {
		this.emailSaved = emailSaved;
	}

	/* ************************ ALERT CREATED ************************ */
	public Boolean isAlertCreated() {
		return alertCreated;
	}
	public void setAlertCreated(Boolean alertCreated) {
		this.alertCreated = alertCreated;
	}
	
	/* ************************ NOTE SAVED ************************ */
	public String getNoteSavedString(){
		if(getNoteSaved() != null){
			if (getNoteSaved()){
				return "Yes";
			}else {
				return "No";
			}
		}else {
			return " ";
		}
	}
	public Boolean getNoteSaved() {
		return noteSaved;
	}
	public void setNoteSaved(Boolean noteSaved) {
		this.noteSaved = noteSaved;
	}
	
	/* ************************ HIDE NOTE ************************ */
	public String getNoteHiddenString(){
		if(getNoteHidden() != null){
			if (getNoteHidden()){
				return "Yes";
			}else {
				return "No";
			}
		}else {
			return " ";
		}
	}
	public Boolean getNoteHidden() {
		return noteHidden;
	}
	public void setNoteHidden(Boolean noteHidden) {
		this.noteHidden = noteHidden;
	}

	/* ************************ STUDENTS ************************ */
	public Set<User> getStudents() {
		return students;
	}
	public void setStudents(Set<User> students) {
		this.students = students;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alertCreated == null) ? 0 : alertCreated.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result
				+ ((emailContent == null) ? 0 : emailContent.hashCode());
		result = prime * result
				+ ((emailSaved == null) ? 0 : emailSaved.hashCode());
		result = prime * result
				+ ((emailSent == null) ? 0 : emailSent.hashCode());
		result = prime * result
				+ ((emailSubject == null) ? 0 : emailSubject.hashCode());
		result = prime * result
				+ ((enteredBy == null) ? 0 : enteredBy.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((noteContent == null) ? 0 : noteContent.hashCode());
		result = prime * result
				+ ((noteHidden == null) ? 0 : noteHidden.hashCode());
		result = prime * result
				+ ((noteSaved == null) ? 0 : noteSaved.hashCode());
		result = prime * result
				+ ((students == null) ? 0 : students.hashCode());
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
		Note other = (Note) obj;
		if (alertCreated == null) {
			if (other.alertCreated != null)
				return false;
		} else if (!alertCreated.equals(other.alertCreated))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (emailContent == null) {
			if (other.emailContent != null)
				return false;
		} else if (!emailContent.equals(other.emailContent))
			return false;
		if (emailSaved == null) {
			if (other.emailSaved != null)
				return false;
		} else if (!emailSaved.equals(other.emailSaved))
			return false;
		if (emailSent == null) {
			if (other.emailSent != null)
				return false;
		} else if (!emailSent.equals(other.emailSent))
			return false;
		if (emailSubject == null) {
			if (other.emailSubject != null)
				return false;
		} else if (!emailSubject.equals(other.emailSubject))
			return false;
		if (enteredBy == null) {
			if (other.enteredBy != null)
				return false;
		} else if (!enteredBy.equals(other.enteredBy))
			return false;
		if (id != other.id)
			return false;
		if (noteContent == null) {
			if (other.noteContent != null)
				return false;
		} else if (!noteContent.equals(other.noteContent))
			return false;
		if (noteHidden == null) {
			if (other.noteHidden != null)
				return false;
		} else if (!noteHidden.equals(other.noteHidden))
			return false;
		if (noteSaved == null) {
			if (other.noteSaved != null)
				return false;
		} else if (!noteSaved.equals(other.noteSaved))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", category=" + category + ", enteredBy="
				+ enteredBy + ", emailSubject=" + emailSubject
				+ ", emailContent=" + emailContent + ", noteContent="
				+ noteContent + ", creationDate=" + creationDate
				+ ", emailSent=" + emailSent + ", alertCreated=" + alertCreated
				+ ", noteSaved=" + noteSaved + ", noteHidden=" + noteHidden
				+ ", students=" + students + "]";
	}
}
	
