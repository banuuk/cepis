/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import edu.uky.cepis.domain.component.UKTerm;


/**
 * @author cawalk4
 *
 */
@Entity
@Table(name = "tblTepadmission")
public class TepAdmission implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "TepadmissionID")
	private long id;
				
	@Column(name = "ApplicationLevel", length = 50)
	private String applicationLevel;
	
	@Column(name = "OverallGPA")
	private double overallGPA;
	
	@Column(name = "TotalHours")
	private double totalHours;
	
	@Column(name = "OralCommunication", length = 50)
	private String oralCommunication;
	
	@Column(name = "WrittenCommunication", length = 50)
	private String writtenCommunication;
	
	@Column(name = "PortfolioReview", length = 50)
	private String portfolioreview;
	
	@Column(name = "TepAdmissionDate")
	private Date tepAdmissionDate;
				
	@Column(name = "TestType", length = 50)
	private String testType;
	
	@Column(name = "TestId", length = 11)
	private int testID;
	
	@Column(name = "DeclarationID", length = 11)
	private int declarationId;
	
	@Column(name = "Primaryx", length = 4)
	private int primary;
	
	@Column(name = "AdmissionMemo")
	private String admissionMemo;
	
	@Column(name = "LastEdit")
	private Date lastEdit;
		
	@Column(name = "Tepadmissioncode")
	private String tepAdmissionCode;
	
	@ManyToOne(targetEntity = UserProgramProfile.class)
	@NotFound(action=NotFoundAction.IGNORE)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "ProgUID")
	private UserProgramProfile programProfile;
	
	@ManyToOne(targetEntity = User.class)
	@NotFound(action=NotFoundAction.IGNORE)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "UID")
	private User user;	
	
	@ManyToOne(targetEntity = ReportYear.class)
	@NotFound(action=NotFoundAction.IGNORE)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "Reportyearcode", nullable = false)
	private ReportYear reportYear;
	
	@ManyToOne(targetEntity = UKTerm.class)
	@NotFound(action=NotFoundAction.IGNORE)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "TermCode", nullable = false)
	private UKTerm cohortTerm;

	public TepAdmission(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApplicationLevel() {
		return applicationLevel;
	}

	public void setApplicationLevel(String applicationLevel) {
		this.applicationLevel = applicationLevel;
	}

	public double getOverallGPA() {
		return overallGPA;
	}

	public void setOverallGPA(double overallGPA) {
		this.overallGPA = overallGPA;
	}

	public double getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(double totalHours) {
		this.totalHours = totalHours;
	}

	public String getOralCommunication() {
		return oralCommunication;
	}

	public void setOralCommunication(String oralCommunication) {
		this.oralCommunication = oralCommunication;
	}

	public String getWrittenCommunication() {
		return writtenCommunication;
	}

	public void setWrittenCommunication(String writtenCommunication) {
		this.writtenCommunication = writtenCommunication;
	}

	public String getPortfolioreview() {
		return portfolioreview;
	}

	public void setPortfolioreview(String portfolioreview) {
		this.portfolioreview = portfolioreview;
	}

	/* ************************ TEP ADMISSION DATE ************************ */
	public Date getTepAdmissionDate() {
		return tepAdmissionDate;
	}
	
	public String getTepAdmissionDateString(){
		if(getTepAdmissionDate() != null){
			String dateString = new SimpleDateFormat("yyyy-MM-dd").format(getTepAdmissionDate());
			return dateString;
		}else{
			return " ";
		}
	}

	public void setTepAdmissionDate(Date tepAdmissionDate) {
		this.tepAdmissionDate = tepAdmissionDate;
	}
	
	
	public String getTestType() {
		if(testType.equals("Praxis1")){
			return "Praxis I";
		}else if(testType.equals("Praxis")){
			return "Praxis II";
		}else{
			return testType;
		}
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public int getTestID() {
		return testID;
	}

	public void setTestID(int testID) {
		this.testID = testID;
	}

	public int getDeclarationId() {
		return declarationId;
	}

	public void setDeclarationId(int declarationId) {
		this.declarationId = declarationId;
	}
	
	/* ************************ PRIMARY ************************ */
	public int getPrimary() {
		return primary;
	}

	public String getPrimaryString(){
		if(getPrimary() == 0){
			return "No";
		}else if(getPrimary() == 1 || getPrimary() == -1){
			return "Yes";
		}else
			return " ";
	}	

	public void setPrimary(int primary){
		this.primary = primary;
	}
	
	public void setPrimaryString(String primary){
		if(primary.equals("Yes")){
			setPrimary(1);
		}else{
			setPrimary(0);
		}
	}

	public String getAdmissionMemo() {
		return admissionMemo;
	}

	public void setAdmissionMemo(String admissionMemo) {
		this.admissionMemo = admissionMemo;
	}

	public Date getLastEdit() {
		return lastEdit;
	}

	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}

	public String getTepAdmissionCode() {
		return tepAdmissionCode;
	}

	public void setTepAdmissionCode(String tepAdmissionCode) {
		this.tepAdmissionCode = tepAdmissionCode;
	}

	/* ************************ PROGRAM PROFILE ************************ */

	public UserProgramProfile getProgramProfile() {
		return programProfile;
	}
	
	public String getProgramProfileCodeString(){
		return getProgramProfile().getProgram().getProgramCode();
	}

	public void setProgramProfile(UserProgramProfile programProfile) {
		this.programProfile = programProfile;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ReportYear getReportYear() {
		return reportYear;
	}

	public void setReportYear(ReportYear reportYear) {
		this.reportYear = reportYear;
	}

	/* ************************ COHORT TERM ************************ */
	public UKTerm getCohortTerm() {
		return cohortTerm;
	}
	
	public String getCohortTermShortDesc(){
		return cohortTerm.getShortDesc();
	}


	public void setCohortTerm(UKTerm cohortTerm) {
		this.cohortTerm = cohortTerm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((admissionMemo == null) ? 0 : admissionMemo.hashCode());
		result = prime
				* result
				+ ((applicationLevel == null) ? 0 : applicationLevel.hashCode());
		result = prime * result
				+ ((cohortTerm == null) ? 0 : cohortTerm.hashCode());
		result = prime * result + declarationId;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((lastEdit == null) ? 0 : lastEdit.hashCode());
		long temp;
		temp = Double.doubleToLongBits(overallGPA);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((portfolioreview == null) ? 0 : portfolioreview.hashCode());
		result = prime * result + primary;
		result = prime * result
				+ ((programProfile == null) ? 0 : programProfile.hashCode());
		result = prime * result
				+ ((reportYear == null) ? 0 : reportYear.hashCode());
		result = prime
				* result
				+ ((tepAdmissionCode == null) ? 0 : tepAdmissionCode.hashCode());
		result = prime
				* result
				+ ((tepAdmissionDate == null) ? 0 : tepAdmissionDate.hashCode());
		result = prime * result + testID;
		result = prime * result
				+ ((testType == null) ? 0 : testType.hashCode());
		temp = Double.doubleToLongBits(totalHours);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		TepAdmission other = (TepAdmission) obj;
		if (admissionMemo == null) {
			if (other.admissionMemo != null)
				return false;
		} else if (!admissionMemo.equals(other.admissionMemo))
			return false;
		if (applicationLevel == null) {
			if (other.applicationLevel != null)
				return false;
		} else if (!applicationLevel.equals(other.applicationLevel))
			return false;
		if (cohortTerm == null) {
			if (other.cohortTerm != null)
				return false;
		} else if (!cohortTerm.equals(other.cohortTerm))
			return false;
		if (declarationId != other.declarationId)
			return false;
		if (id != other.id)
			return false;
		if (lastEdit == null) {
			if (other.lastEdit != null)
				return false;
		} else if (!lastEdit.equals(other.lastEdit))
			return false;
		if (Double.doubleToLongBits(overallGPA) != Double
				.doubleToLongBits(other.overallGPA))
			return false;
		if (portfolioreview == null) {
			if (other.portfolioreview != null)
				return false;
		} else if (!portfolioreview.equals(other.portfolioreview))
			return false;
		if (primary != other.primary)
			return false;
		if (programProfile == null) {
			if (other.programProfile != null)
				return false;
		} else if (!programProfile.equals(other.programProfile))
			return false;
		if (reportYear == null) {
			if (other.reportYear != null)
				return false;
		} else if (!reportYear.equals(other.reportYear))
			return false;
		if (tepAdmissionCode == null) {
			if (other.tepAdmissionCode != null)
				return false;
		} else if (!tepAdmissionCode.equals(other.tepAdmissionCode))
			return false;
		if (tepAdmissionDate == null) {
			if (other.tepAdmissionDate != null)
				return false;
		} else if (!tepAdmissionDate.equals(other.tepAdmissionDate))
			return false;
		if (testID != other.testID)
			return false;
		if (testType == null) {
			if (other.testType != null)
				return false;
		} else if (!testType.equals(other.testType))
			return false;
		if (Double.doubleToLongBits(totalHours) != Double
				.doubleToLongBits(other.totalHours))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TepAdmission [id=" + id + "]";
	}
}
	
