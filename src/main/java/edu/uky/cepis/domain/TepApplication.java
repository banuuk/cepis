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

import edu.uky.cepis.domain.component.UKTerm;


/**
 * @author cawalk4
 *
 */
@Entity
@Table(name = "tblUgtepapplicaiton")
public class TepApplication implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "UGTEPAPPLICATIONID")
	private long id;

	@Column(name = "APPLICATIONDATE")
	private Date applicationDate;
	
	@Column(name = "FACRECOMMENDDATE")
	private Date facultyRecommendationDate;
		
	@Column(name = "FOLLOWUPDATE")
	private Date followUpDate;
	
	@Column(name = "CHANGESTATUSDATE")
	private Date changeStatusDate;
	
	@Column(name = "PROCESSMEMO")
	private String processMemo;

	@Column(name = "FACULTYMEMO")
	private String facultyMemo;
		
	@Column(name = "STUDENTMEMO")
	private String studentMemo;	
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = UserProgramProfile.class)
	@JoinColumn(name = "ProgUID")
	private UserProgramProfile programProfile;
		
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = UKTerm.class)
	@JoinColumn(name = "TermCode", nullable = false)
	private UKTerm cohortTerm;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = ApplicationStatus.class)
	@JoinColumn(name = "ApplicationStatusCode", nullable = false)
	private ApplicationStatus applicationStatus;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = ApplicationStatus.class)
	@JoinColumn(name = "FacRecommendCode", nullable = false)
	private ApplicationStatus facultyRecommendation;
		
	public TepApplication(){
		
	}
	
	public long getId() {
		return id;
	}
		
	public void setId(long id) {
		this.id = id;
	}
	
	/* ************************ APPLICATION DATE ************************ */	
	public Date getApplicationDate() {
		return applicationDate;
	}
	
	public String getApplicationDateString(){
		if(getApplicationDate() != null){
			String dateString = new SimpleDateFormat("yyyy-MM-dd").format(getApplicationDate());
			return dateString;
		}else{
			return " ";
		}
	}
		
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	/* ************************ FACULTY RECOMMENDATION DATE ************************ */
	public Date getFacultyRecommendationDate() {
		return facultyRecommendationDate;
	}
	
	public String getFacultyRecommendationDateString(){
		if(getFacultyRecommendationDate() != null){
			String dateString = new SimpleDateFormat("yyyy-MM-dd").format(getFacultyRecommendationDate());
			return dateString;
		}else{
			return " ";
		}
	}

	public void setFacultyRecommendationDate(Date facultyRecommendationDate) {
		this.facultyRecommendationDate = facultyRecommendationDate;
	}

	/* ************************ FOLLOW UP DATE ************************ */
	public Date getFollowUpDate() {
		return followUpDate;
	}
	
	public String getFollowUpDateString(){
		if(getFollowUpDate() != null){
			String dateString = new SimpleDateFormat("yyyy-MM-dd").format(getFollowUpDate());
			return dateString;
		}else{
			return " ";
		}
	}

	public void setFollowUpDate(Date followUpDate) {
		this.followUpDate = followUpDate;
	}

	/* ************************ CHANGE STATUS DATE ************************ */
	public Date getChangeStatusDate() {
		return changeStatusDate;
	}	
	
	public String getChangeStatusDateString(){
		if(getChangeStatusDate() != null){
			String dateString = new SimpleDateFormat("yyyy-MM-dd").format(getChangeStatusDate());
			return dateString;
		}else{
			return " ";
		}
	}

	public void setChangeStatusDate(Date changeStatusDate) {
		this.changeStatusDate = changeStatusDate;
	}

	public String getProcessMemo() {
		return processMemo;
	}

	public void setProcessMemo(String processMemo) {
		this.processMemo = processMemo;
	}

	public String getFacultyMemo() {
		return facultyMemo;
	}

	public void setFacultyMemo(String facultyMemo) {
		this.facultyMemo = facultyMemo;
	}

	public String getStudentMemo() {
		return studentMemo;
	}

	public void setStudentMemo(String studentMemo) {
		this.studentMemo = studentMemo;
	}

	public UserProgramProfile getProgramProfile() {
		return programProfile;
	}

	public void setProgramProfile(UserProgramProfile programProfile) {
		this.programProfile = programProfile;
	}

	public UKTerm getCohortTerm() {
		return cohortTerm;
	}

	public void setCohortTerm(UKTerm cohortTerm) {
		this.cohortTerm = cohortTerm;
	}

	public ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public ApplicationStatus getFacultyRecommendation() {
		return facultyRecommendation;
	}

	public void setFacultyRecommendation(ApplicationStatus facultyRecommendation) {
		this.facultyRecommendation = facultyRecommendation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		TepApplication other = (TepApplication) obj;
		if (id != other.id)
			return false;
		return true;
	}


}
	
