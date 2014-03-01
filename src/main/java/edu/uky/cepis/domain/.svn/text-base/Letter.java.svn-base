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
@Table(name = "tblLetters")
public class Letter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "LetterId")
	private long id;
	
	@Column(name = "Name", length = 50)
	private String name;
	
	@Column(name = "Organization", length = 50)
	private String organization;
	
	@Column(name = "LetterReferCode", length = 50)
	private String relation;
	
	@Column(name = "Phone", length = 50)
	private String phone;
	
	@Column(name = "SignatureDate")
	private Date signatureDate;
	
	@Column(name = "DateReceived")
	private Date dateReceived;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = UserProgramProfile.class)
	@JoinColumn(name = "ProgUID")
	private UserProgramProfile programProfile;
	
	public Letter(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/* ************************ SIGNATURE DATE ************************ */
	public Date getSignatureDate() {
		return signatureDate;
	}
	
	public String getSignatureDateString() {
		if(getSignatureDate() != null){
			String dateString = new SimpleDateFormat("yyyy-MM-dd").format(getSignatureDate());
			return dateString;
		}else{
			return " ";
		}
	}

	public void setSignatureDate(Date signatureDate) {
		this.signatureDate = signatureDate;
	}

	/* ************************ DATE RECIEVED ************************ */
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
		result = prime
				* result
				+ ((relation == null) ? 0 : relation
						.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((organization == null) ? 0 : organization.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		Letter other = (Letter) obj;
		if (dateReceived == null) {
			if (other.dateReceived != null)
				return false;
		} else if (!dateReceived.equals(other.dateReceived))
			return false;
		if (id != other.id)
			return false;
		if (relation == null) {
			if (other.relation != null)
				return false;
		} else if (!relation.equals(other.relation))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
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
		return "Letter [letterId=" + id + ", name=" + name
				+ ", organization=" + organization + ", letterReferenceCode="
				+ relation + ", phone=" + phone + ", signatureDate="
				+ signatureDate + ", dateRecieved=" + dateReceived
				+ ", programProfile=" + programProfile + "]";
	}

}
	
