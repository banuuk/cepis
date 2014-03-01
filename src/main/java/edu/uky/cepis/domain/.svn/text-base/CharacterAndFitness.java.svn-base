/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author cawalk4
 *
 */
@Entity
@Table(name = "tblDeclaration")
public class CharacterAndFitness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "DECLARATIONID")
	private long id;
		
	@Column(name = "SIGNATUREDATE")
	private Date signatureDate;
	
	@Column(name = "DATERECEIVED")
	private Date dateReceived;
	
	@Column(name = "Memo")
	private String memo;
		
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = UserProgramProfile.class)
	@JoinColumn(name = "ProgUID")
	private UserProgramProfile programProfile;
	
	public CharacterAndFitness(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	/* ************************ SIGNATURE DATE ************************ */
	public Date getSignatureDate() {
		return signatureDate;
	}

	public void setSignatureDate(Date signatureDate) {
		this.signatureDate = signatureDate;
	}
	
	public String getSignatureDateString() {
		if(getSignatureDate() != null){
			String dateString = new SimpleDateFormat("yyyy-MM-dd").format(getSignatureDate());
			return dateString;
		}else{
			return " ";
		}
	}
	
	/* ************************ DATE RECEIVED ************************ */
	public Date getDateReceived() {
		return dateReceived;
	}
	
	public String getDateReceivedString(){
		if(getDateReceived() != null){
			String dateString = new SimpleDateFormat("yyyy-MM-dd").format(getDateReceived());
			return dateString;
		}else{
			return " ";
		}
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public UserProgramProfile getProgramProfile() {
		return programProfile;
	}

	public void setProgramProfile(UserProgramProfile programProfile) {
		this.programProfile = programProfile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateReceived == null) ? 0 : dateReceived.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((memo == null) ? 0 : memo.hashCode());
		result = prime * result
				+ ((programProfile == null) ? 0 : programProfile.hashCode());
		result = prime * result
				+ ((signatureDate == null) ? 0 : signatureDate.hashCode());
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
		CharacterAndFitness other = (CharacterAndFitness) obj;
		if (dateReceived == null) {
			if (other.dateReceived != null)
				return false;
		} else if (!dateReceived.equals(other.dateReceived))
			return false;
		if (id != other.id)
			return false;
		if (memo == null) {
			if (other.memo != null)
				return false;
		} else if (!memo.equals(other.memo))
			return false;
		if (programProfile == null) {
			if (other.programProfile != null)
				return false;
		} else if (!programProfile.equals(other.programProfile))
			return false;
		if (signatureDate == null) {
			if (other.signatureDate != null)
				return false;
		} else if (!signatureDate.equals(other.signatureDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CharacterAndFitness [id=" + id + ", signatureDate="
				+ signatureDate + ", dateRecieved=" + dateReceived + ", memo="
				+ memo + ", programProfile=" + programProfile + "]";
	}
	
}
	
