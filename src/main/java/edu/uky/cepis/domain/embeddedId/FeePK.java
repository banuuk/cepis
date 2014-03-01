package edu.uky.cepis.domain.embeddedId;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.uky.cepis.domain.User;

@Embeddable
public class FeePK implements Serializable {
	
	private static final long serialVersionUID = 1L;
			
	@Column(name = "Date_Received", nullable=false)
	private Date dateReceived;
	
	@Column(name = "Cheque_Number", nullable=false, length=25)
	private String checkNumber;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name = "UID", nullable = false)
	private User user;
	
	public FeePK(){
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((checkNumber == null) ? 0 : checkNumber.hashCode());
		result = prime * result
				+ ((dateReceived == null) ? 0 : dateReceived.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		FeePK other = (FeePK) obj;
		if (checkNumber == null) {
			if (other.checkNumber != null)
				return false;
		} else if (!checkNumber.equals(other.checkNumber))
			return false;
		if (dateReceived == null) {
			if (other.dateReceived != null)
				return false;
		} else if (!dateReceived.equals(other.dateReceived))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}