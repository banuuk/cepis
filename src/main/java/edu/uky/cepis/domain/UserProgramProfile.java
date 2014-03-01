/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;

import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.ProgramGroup;
import edu.uky.cepis.domain.component.ProgramTrack;
import edu.uky.cepis.domain.component.UKMajor;
import edu.uky.cepis.domain.component.UKStatus;
import edu.uky.cepis.domain.component.UKTerm;


/**
 * @author cawalk4
 *
 */
@Entity
@Table(name="tblProgramprofile")
@Cache(region="edu.uky.cepis.cache.userprogramprofile", usage=CacheConcurrencyStrategy.READ_WRITE)
public class UserProgramProfile implements Serializable, Comparator<UserProgramProfile> {
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name = "prog_id_generator", strategy = "edu.uky.cepis.util.database.idgenerator.UserProgramProfileIdentifierGenerator")
	@GeneratedValue(generator = "prog_id_generator")
	@Column(name="ProgUID")
	private String userprogramprofileid;
	
	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="Programcode")
	private Program program;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="Progdomaincode")
	private ProgramDomain programDomain;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="Progtrackingcode")
	private ProgramTrack programTrack;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="Proggroupingcode")
	private ProgramGroup programGroup;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="AdvisorUID")
	private Advisor advisor;
	
	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="FacultyAdvisorUID")
	private FacultyAdvisor facultyAdvisor;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="Ukmajorcode")
	private UKMajor ukMajor;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="Statuscode")
	private UKStatus ukStatus;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="Startterm")
	private UKTerm ukStartTerm;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="Completionterm")
	private UKTerm ukCompleteTerm;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="Anticipatedcompletionterm")
	private UKTerm ukAnticipatedCompleteTerm;

	@Column(name="DegreeAwarded", nullable = false)
	private Integer degreeAwarded;
	
	@Column(name="FinalGPA", length=10, nullable = false)
	private String finalGPA;
	
	@Type(type = "yes_no")
	@Column(name="RecommendCertification")
	private boolean recommendCertification;

	@Column(name="shortDescription", length=255)
	private String shortDesc;
	
	@Type(type = "yes_no")
	@Column(name="hiddenToStudent")
	private boolean hiddenToStudent;

	@Column(name="Lastedit")
	private Date lastUpdated;
	
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "programProfile", targetEntity = TepAdmission.class)
//	private Set<TepAdmission> tepAdmissions = new HashSet<TepAdmission>(0);

	/**
	 * 
	 */
	public UserProgramProfile() {
	}

	/**
	 * 
	 * @param userprogramprofileid
	 * @param program
	 * @param programDomain
	 * @param programTrack
	 * @param programGroup
	 * @param advisor
	 * @param ukMajor
	 * @param ukStatus
	 * @param ukStartTerm
	 * @param ukCompleteTerm
	 * @param hiddenToStudent
	 */
	public UserProgramProfile(String userProgramProfileid, Program program,
			ProgramDomain programDomain, ProgramTrack programTrack,
			ProgramGroup programGroup, Advisor advisor,FacultyAdvisor facultyAdvisor, UKMajor ukMajor,
			UKStatus ukStatus, UKTerm ukStartTerm, 
			UKTerm ukAnticipatedCompleteTerm, UKTerm ukCompleteTerm,
			String finalGPA, Integer degreeAwarded, boolean hiddenToStudent,
			boolean recommendCertification, String shortDesc) {
		this.userprogramprofileid = userProgramProfileid;
		this.program = program;
		this.programDomain = programDomain;
		this.programTrack = programTrack;
		this.programGroup = programGroup;
		this.advisor = advisor;
		this.facultyAdvisor = facultyAdvisor;
		this.ukMajor = ukMajor;
		this.ukStatus = ukStatus;
		this.ukStartTerm = ukStartTerm;
		this.ukCompleteTerm = ukCompleteTerm;
		this.ukAnticipatedCompleteTerm = ukAnticipatedCompleteTerm;
		this.degreeAwarded = degreeAwarded;
		this.hiddenToStudent = hiddenToStudent;
		this.finalGPA = finalGPA;
		this.recommendCertification = recommendCertification;
		this.lastUpdated = new Date();
		this.shortDesc = shortDesc;
	}

	
	public String getUserprogramprofileid() {
		return userprogramprofileid;
	}

	public void setUserprogramprofileid(String userprogramprofileid) {
		this.userprogramprofileid = userprogramprofileid;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public ProgramDomain getProgramDomain() {
		return programDomain;
	}
	
	public void setProgramDomain(ProgramDomain programDomain) {
		this.programDomain = programDomain;
	}

	public ProgramTrack getProgramTrack() {
		return programTrack;
	}

	public void setProgramTrack(ProgramTrack programTrack) {
		this.programTrack = programTrack;
	}
	
	public ProgramGroup getProgramGroup() {
		return programGroup;
	}

	public void setProgramGroup(ProgramGroup programGroup) {
		this.programGroup = programGroup;
	}

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	public FacultyAdvisor getFacultyAdvisor() {
		return facultyAdvisor;
	}

	public void setFacultyAdvisor(FacultyAdvisor facultyAdvisor) {
		this.facultyAdvisor = facultyAdvisor;
	}

	public UKMajor getUkMajor() {
		return ukMajor;
	}

	public void setUkMajor(UKMajor ukMajor) {
		this.ukMajor = ukMajor;
	}

	public UKStatus getUkStatus() {
		return ukStatus;
	}

	public void setUkStatus(UKStatus ukStatus) {
		this.ukStatus = ukStatus;
	}

	public UKTerm getUkStartTerm() {
		return ukStartTerm;
	}

	public void setUkStartTerm(UKTerm ukStartTerm) {
		this.ukStartTerm = ukStartTerm;
	}

	public UKTerm getUkCompleteTerm() {
		return ukCompleteTerm;
	}

	public void setUkCompleteTerm(UKTerm ukCompleteTerm) {
		this.ukCompleteTerm = ukCompleteTerm;
	}

	public UKTerm getUkAnticipatedCompleteTerm() {
		return ukAnticipatedCompleteTerm;
	}

	public void setUkAnticipatedCompleteTerm(UKTerm ukAnticipatedCompleteTerm) {
		this.ukAnticipatedCompleteTerm = ukAnticipatedCompleteTerm;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setDegreeAwarded(Integer degreeAwarded) {
		this.degreeAwarded = degreeAwarded;
	}

	public Integer getDegreeAwarded() {
		return degreeAwarded;
	}

	public String getFinalGPA() {
		return finalGPA;
	}

	public void setFinalGPA(String finalGPA) {
		this.finalGPA = finalGPA;
	}

	public boolean isRecommendCertification() {
		return recommendCertification;
	}

	public void setRecommendCertification(boolean recommendCertification) {
		this.recommendCertification = recommendCertification;
	}

	public void setHiddenToStudent(boolean hiddenToStudent) {
		this.hiddenToStudent = hiddenToStudent;
	}

	public boolean isHiddenToStudent() {
		return hiddenToStudent;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	/**
	 * @return the lastUpdated
	 * @uml.property name="lastUpdated"
	 */
	public Date getLastUpdated() {
		return lastUpdated;
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
		result = prime * result + ((advisor == null) ? 0 : advisor.hashCode());
		result = prime * result
				+ ((degreeAwarded == null) ? 0 : degreeAwarded.hashCode());
		result = prime * result
				+ ((finalGPA == null) ? 0 : finalGPA.hashCode());
		result = prime * result + (hiddenToStudent ? 1231 : 1237);
		result = prime * result + ((program == null) ? 0 : program.hashCode());
		result = prime * result
				+ ((programDomain == null) ? 0 : programDomain.hashCode());
		result = prime * result
				+ ((programGroup == null) ? 0 : programGroup.hashCode());
		result = prime * result
				+ ((programTrack == null) ? 0 : programTrack.hashCode());
		result = prime * result + (recommendCertification ? 1231 : 1237);
		result = prime * result
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
		result = prime
				* result
				+ ((ukAnticipatedCompleteTerm == null) ? 0
						: ukAnticipatedCompleteTerm.hashCode());
		result = prime * result
				+ ((ukCompleteTerm == null) ? 0 : ukCompleteTerm.hashCode());
		result = prime * result + ((ukMajor == null) ? 0 : ukMajor.hashCode());
		result = prime * result
				+ ((ukStartTerm == null) ? 0 : ukStartTerm.hashCode());
		result = prime * result
				+ ((ukStatus == null) ? 0 : ukStatus.hashCode());
		result = prime
				* result
				+ ((userprogramprofileid == null) ? 0 : userprogramprofileid
						.hashCode());
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
		UserProgramProfile other = (UserProgramProfile) obj;
		if (advisor == null) {
			if (other.advisor != null)
				return false;
		} else if (!advisor.equals(other.advisor))
			return false;
		if (degreeAwarded == null) {
			if (other.degreeAwarded != null)
				return false;
		} else if (!degreeAwarded.equals(other.degreeAwarded))
			return false;
		if (finalGPA == null) {
			if (other.finalGPA != null)
				return false;
		} else if (!finalGPA.equals(other.finalGPA))
			return false;
		if (hiddenToStudent != other.hiddenToStudent)
			return false;
		if (program == null) {
			if (other.program != null)
				return false;
		} else if (!program.equals(other.program))
			return false;
		if (programDomain == null) {
			if (other.programDomain != null)
				return false;
		} else if (!programDomain.equals(other.programDomain))
			return false;
		if (programGroup == null) {
			if (other.programGroup != null)
				return false;
		} else if (!programGroup.equals(other.programGroup))
			return false;
		if (programTrack == null) {
			if (other.programTrack != null)
				return false;
		} else if (!programTrack.equals(other.programTrack))
			return false;
		if (recommendCertification != other.recommendCertification)
			return false;
		if (shortDesc == null) {
			if (other.shortDesc != null)
				return false;
		} else if (!shortDesc.equals(other.shortDesc))
			return false;
		if (ukAnticipatedCompleteTerm == null) {
			if (other.ukAnticipatedCompleteTerm != null)
				return false;
		} else if (!ukAnticipatedCompleteTerm
				.equals(other.ukAnticipatedCompleteTerm))
			return false;		
		if (ukCompleteTerm == null) {
			if (other.ukCompleteTerm != null)
				return false;
		} else if (!ukCompleteTerm.equals(other.ukCompleteTerm))
			return false;
		if (ukMajor == null) {
			if (other.ukMajor != null)
				return false;
		} else if (!ukMajor.equals(other.ukMajor))
			return false;
		if (ukStartTerm == null) {
			if (other.ukStartTerm != null)
				return false;
		} else if (!ukStartTerm.equals(other.ukStartTerm))
			return false;
		if (ukStatus == null) {
			if (other.ukStatus != null)
				return false;
		} else if (!ukStatus.equals(other.ukStatus))
			return false;
		if (userprogramprofileid == null) {
			if (other.userprogramprofileid != null)
				return false;
		} else if (!userprogramprofileid.equals(other.userprogramprofileid))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return program + " - " + programDomain + ", " + this.getDegreeAwarded();
	}

	@Override
	public int compare(UserProgramProfile o1, UserProgramProfile o2) {
		return o1.getUserprogramprofileid().compareTo(
				o2.getUserprogramprofileid());
	}

}
