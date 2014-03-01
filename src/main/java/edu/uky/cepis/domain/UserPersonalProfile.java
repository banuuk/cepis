/**
 * 
 */
package edu.uky.cepis.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author cawalk4
 */
@Entity
@Table(name = "tblPersonal")
public class UserPersonalProfile implements java.io.Serializable, java.util.Comparator<UserPersonalProfile> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PersonalID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userpersonalprofileid;
			
	@Column(name = "Citizen", length = 50)
	private String citizen;
	
	@Column(name = "Diploma", length = 50)
	private String diplomaType;
	
	@Column(name = "DipState", length = 50)
	private String diplomaState;
	
	@Column(name = "DipYear", length = 4)
	private String diplomaYear;
	
	@Column(name = "High", length = 50)
	private String highSchool;
	
	@Column(name = "HSCity", length = 50)
	private String highSchoolCity;
	
	@Column(name = "HSCounty", length = 50)
	private String highSchoolCounty;
	
	@Column(name = "Lastedit")
	private Date lastUpdated;
	
	@ManyToOne(targetEntity = Ethnic.class)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "Ethniccode")
	private Ethnic ethnic;
	
	@OneToOne
	@JoinColumn(name = "uid")
	private User user;

	
	public UserPersonalProfile() {
	}

	/**
	 * @param ethnic
	 * @param citizen
	 * @param diplomaType
	 * @param diplomaState
	 * @param diplomaYear
	 * @param highSchool
	 * @param highSchoolCity
	 * @param highSchoolCounty
	 */
	public UserPersonalProfile(Ethnic ethnic, String citizen,
			String diplomaType, String diplomaState, String diplomaYear,
			String highSchool, String highSchoolCity, String highSchoolCounty) {
		this.ethnic = ethnic;
		this.citizen = citizen;
		this.diplomaType = diplomaType;
		this.diplomaState = diplomaState;
		this.diplomaYear = diplomaYear;
		this.highSchool = highSchool;
		this.highSchoolCity = highSchoolCity;
		this.highSchoolCounty = highSchoolCounty;
		this.lastUpdated = new Date();
	}
	
	public long getUserpersonalprofileid() {
		return userpersonalprofileid;
	}

	public void setUserpersonalprofileid(long userpersonalprofileid) {
		this.userpersonalprofileid = userpersonalprofileid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Ethnic getEthnic() {				
		return ethnic;
	}

	public void setEthnic(Ethnic ethnic) {
		this.ethnic = ethnic;
	}

	public String getCitizen() {
		return citizen;
	}

	public void setCitizen(String citizen) {
		this.citizen = citizen;
	}

	public String getDiplomaType() {
		return diplomaType;
	}

	public void setDiplomaType(String diplomaType) {
		this.diplomaType = diplomaType;
	}

	public String getDiplomaState() {
		return diplomaState;
	}

	public void setDiplomaState(String diplomaState) {
		this.diplomaState = diplomaState;
	}

	public String getDiplomaYear() {
		return diplomaYear;
	}

	public void setDiplomaYear(String diplomaYear) {
		this.diplomaYear = diplomaYear;
	}

	public String getHighSchool() {
		return highSchool;
	}

	public void setHighSchool(String highSchool) {
		this.highSchool = highSchool;
	}

	public String getHighSchoolCity() {
		return highSchoolCity;
	}

	public void setHighSchoolCity(String highSchoolCity) {
		this.highSchoolCity = highSchoolCity;
	}

	public String getHighSchoolCounty() {
		return highSchoolCounty;
	}

	public void setHighSchoolCounty(String highSchoolCounty) {
		this.highSchoolCounty = highSchoolCounty;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citizen == null) ? 0 : citizen.hashCode());
		result = prime * result
				+ ((diplomaState == null) ? 0 : diplomaState.hashCode());
		result = prime * result
				+ ((diplomaType == null) ? 0 : diplomaType.hashCode());
		result = prime * result
				+ ((diplomaYear == null) ? 0 : diplomaYear.hashCode());
		result = prime * result + ((ethnic == null) ? 0 : ethnic.hashCode());
		result = prime * result
				+ ((highSchool == null) ? 0 : highSchool.hashCode());
		result = prime * result
				+ ((highSchoolCity == null) ? 0 : highSchoolCity.hashCode());
		result = prime
				* result
				+ ((highSchoolCounty == null) ? 0 : highSchoolCounty.hashCode());
		result = prime
				* result
				+ (int) (userpersonalprofileid ^ (userpersonalprofileid >>> 32));
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
		UserPersonalProfile other = (UserPersonalProfile) obj;
		if (citizen == null) {
			if (other.citizen != null)
				return false;
		} else if (!citizen.equals(other.citizen))
			return false;
		if (diplomaState == null) {
			if (other.diplomaState != null)
				return false;
		} else if (!diplomaState.equals(other.diplomaState))
			return false;
		if (diplomaType == null) {
			if (other.diplomaType != null)
				return false;
		} else if (!diplomaType.equals(other.diplomaType))
			return false;
		if (diplomaYear == null) {
			if (other.diplomaYear != null)
				return false;
		} else if (!diplomaYear.equals(other.diplomaYear))
			return false;
		if (ethnic == null) {
			if (other.ethnic != null)
				return false;
		} else if (!ethnic.equals(other.ethnic))
			return false;
		if (highSchool == null) {
			if (other.highSchool != null)
				return false;
		} else if (!highSchool.equals(other.highSchool))
			return false;
		if (highSchoolCity == null) {
			if (other.highSchoolCity != null)
				return false;
		} else if (!highSchoolCity.equals(other.highSchoolCity))
			return false;
		if (highSchoolCounty == null) {
			if (other.highSchoolCounty != null)
				return false;
		} else if (!highSchoolCounty.equals(other.highSchoolCounty))
			return false;
		if (userpersonalprofileid != other.userpersonalprofileid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ethnic + ", " + citizen;
	}

	@Override
	public int compare(UserPersonalProfile o1, UserPersonalProfile o2) {

		return o1.getEthnic().compare(o1.getEthnic(), o2.getEthnic())
				| o1.getCitizen().compareTo(o1.getCitizen())
				| o1.getDiplomaType().compareTo(o1.getDiplomaType())
				| o1.getDiplomaState().compareTo(o1.getDiplomaState())
				| o1.getDiplomaYear().compareTo(o1.getDiplomaYear())
				| o1.getHighSchool().compareTo(o1.getHighSchool())
				| o1.getHighSchoolCity().compareTo(o1.getHighSchoolCity())
				| o1.getHighSchoolCounty().compareTo(o1.getHighSchoolCounty());
	}
}
