/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author cawalk4
 */
@Entity
@Table(name="tblScholarship")
@Cache(region="edu.uky.cepis.cache.studentScholarship", usage=CacheConcurrencyStrategy.READ_WRITE)
public class StudentScholarship implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ScholarID")
	private long id;
	
	@Column(name = "ApplicationDate")
	private Date applicationDate;
	
	@Column(name = "ReviewCode", length = 50)
	private String reviewCode;
	
	@Column(name = "ReviewDate")
	private Date reviewDate;
	
	@Column(name = "Recommend")
	private String recommend;
	
	@Column(name = "Amount")
	private Double amount;
	
	@Column(name = "Promissory")
	private int promissoryNote;
	
	@Column(name = "PNoteDate")
	private Date promissoryNoteDate;
	
	@Column(name = "StarForm")
	private int starForm;
	
	@Column(name = "starFormDate")
	private Date starFormDate;
	
	@Column(name = "Memo")
	private String memo;
	
	@Column(name = "StudentLevel", length = 50)
	private String studentLevel;
	
	@Column(name = "Eligibility")
	private String eligibility;
	
	@ManyToOne(targetEntity = Scholarship.class)
	@NotFound(action=NotFoundAction.IGNORE)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "ScholarTerm", nullable = false)
	private Scholarship scholarshipCode;
	
	@ManyToOne(targetEntity = UKTerm.class)
	@NotFound(action=NotFoundAction.IGNORE)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "Scholarterm", nullable = false)
	private UKTerm scholarshipTerm;
	
	@ManyToOne(targetEntity = User.class)
	@NotFound(action=NotFoundAction.IGNORE)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "UID")
	private User user;
	
	private StudentScholarship(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getReviewCode() {
		return reviewCode;
	}

	public void setReviewCode(String reviewCode) {
		this.reviewCode = reviewCode;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public int getPromissoryNote() {
		return promissoryNote;
	}

	public void setPromissoryNote(int promissoryNote) {
		this.promissoryNote = promissoryNote;
	}

	public Date getPromissoryNoteDate() {
		return promissoryNoteDate;
	}

	public void setPromissoryNoteDate(Date promissoryNoteDate) {
		this.promissoryNoteDate = promissoryNoteDate;
	}

	public int getStarForm() {
		return starForm;
	}

	public void setStarForm(int starForm) {
		this.starForm = starForm;
	}

	public Date getStarFormDate() {
		return starFormDate;
	}

	public void setStarFormDate(Date starFormDate) {
		this.starFormDate = starFormDate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getStudentLevel() {
		return studentLevel;
	}

	public void setStudentLevel(String studentLevel) {
		this.studentLevel = studentLevel;
	}

	public String getEligibility() {
		return eligibility;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

	public Scholarship getScholarshipCode() {
		return scholarshipCode;
	}

	public void setScholarshipCode(Scholarship scholarshipCode) {
		this.scholarshipCode = scholarshipCode;
	}

	public UKTerm getScholarshipTerm() {
		return scholarshipTerm;
	}

	public void setScholarshipTerm(UKTerm scholarshipTerm) {
		this.scholarshipTerm = scholarshipTerm;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result
				+ ((applicationDate == null) ? 0 : applicationDate.hashCode());
		result = prime * result
				+ ((eligibility == null) ? 0 : eligibility.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((recommend == null) ? 0 : recommend.hashCode());
		result = prime * result
				+ ((reviewCode == null) ? 0 : reviewCode.hashCode());
		result = prime * result
				+ ((reviewDate == null) ? 0 : reviewDate.hashCode());
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
		StudentScholarship other = (StudentScholarship) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (applicationDate == null) {
			if (other.applicationDate != null)
				return false;
		} else if (!applicationDate.equals(other.applicationDate))
			return false;
		if (eligibility == null) {
			if (other.eligibility != null)
				return false;
		} else if (!eligibility.equals(other.eligibility))
			return false;
		if (id != other.id)
			return false;
		if (recommend == null) {
			if (other.recommend != null)
				return false;
		} else if (!recommend.equals(other.recommend))
			return false;
		if (reviewCode == null) {
			if (other.reviewCode != null)
				return false;
		} else if (!reviewCode.equals(other.reviewCode))
			return false;
		if (reviewDate == null) {
			if (other.reviewDate != null)
				return false;
		} else if (!reviewDate.equals(other.reviewDate))
			return false;
		return true;
	}
	
	
}
