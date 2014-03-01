package edu.uky.cepis.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.efs.openreports.objects.ReportUser;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * 
 * User class contains CEPIS User basic information
 * 
 * @author cawalk4
 * 
 */

@Entity
@Table(name="tblIdentity")
@Cache(region="edu.uky.cepis.cache.user", usage=CacheConcurrencyStrategy.READ_WRITE)
public class User implements java.util.Comparator<User>, java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "user_id_generator", strategy = "edu.uky.cepis.util.database.idgenerator.CEPISIdentifierGenerator")
	@GeneratedValue(generator = "user_id_generator")
	@Column(name = "UID")
	private String uid; //CEPIS ID
	
	
	@Column(name = "SID", length = 25)
	private String ssn;// TODO: Encrypt this field in Hibernate. Conflicts with EPSB Webservice. Try MySQL Default Encryption functions DES/AES.
		
	@Column(name = "ADUserId", length = 50)
	private String username; //Link Blue
	
	@Column(name = "ADPassword", length = 100)
	private String password;
	
	@Column(name = "UKId", length = 25)
	private String ukID; //Badge ID
	
	@Column(name = "LName", length = 255)
	private String lName; //Last Name

	@Column(name = "LName1", length = 255)
	private String lName1;

	@Column(name = "LName2", length = 255)
	private String lName2;

	@Column(name = "LName3", length = 255)
	private String lName3;

	@Column(name = "LName4", length = 255)
	private String lName4;
	
	@Column(name = "MName", length = 255)
	private String mName; //Middle Name
	
	@Column(name = "FName", length = 255)
	private String fName; //First Name
	
	@Column(name="PreferredName", length=50)
	private String preferredName;
	
	@Column(name="MaName", length=255)
	private String maidenName;
	
	@Formula(value = "concat_ws(' ',lName, ' ',fName,' ',mName)")
	private String fullName;
	
	@Column(name="Suffix", length=25)
	private String suffix;
	
	@Column(name="Gender", length=25)
	private String gender;
	
	@Column(name="Title", length=25)
	private String title;
	
	@Column(name="Dob")
	private Date dOB;
	
	@Column(name="enabled")
	private int enabled;
	
	@Column(name="Badge")
	private int badgeHolder;
	
	@Column(name="EntryDate")
	private Date createdOn;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = UserConfiguration.class)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "userConfiguration")
	private UserConfiguration userConfiguration;
	
	@OneToOne(mappedBy="user", cascade = CascadeType.ALL)
	private UserPersonalProfile userPersonalProfile = new UserPersonalProfile();
		
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = ReportUser.class)	
	@JoinColumn(name = "EXTERNAL_ID", nullable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.reportuser")
	private Set<ReportUser> reportUser = new HashSet<ReportUser>(0);
		
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Phone.class)	
	@JoinColumn(name = "UID", nullable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.phone")
	private Set<Phone> phoneNumbers = new HashSet<Phone>(0);
		
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Address.class)	
	@JoinColumn(name = "UID", nullable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.address")
	private Set<Address> addresses = new HashSet<Address>(0);
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = EmailAddress.class)	
	@JoinColumn(name = "UID", nullable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.emailaddress")
	private Set<EmailAddress> emailAddresses = new HashSet<EmailAddress>(0);
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "createdBy", targetEntity = WorkingSet.class)
	@NotFound(action = NotFoundAction.IGNORE)
	@BatchSize(size = 10)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.workingset")
	private Set<WorkingSet> workingSets = new HashSet<WorkingSet>(0);
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "createdBy", targetEntity = Query.class)
	@NotFound(action = NotFoundAction.IGNORE)
	@BatchSize(size = 10)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.query")
	private Set<Query> savedQueries = new HashSet<Query>(0);
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = UserProgramProfile.class)
	@JoinColumn(name = "UID", nullable = false)
	@NotFound(action = NotFoundAction.IGNORE)	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.userprogramprofile")
	private Set<UserProgramProfile> userProgramProfiles = new HashSet<UserProgramProfile>(0);
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = UserCollegeProfile.class)
	@JoinColumn(name = "UID", nullable = false)
	@NotFound(action = NotFoundAction.IGNORE)	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.usercollegeprofile")
	private Set<UserCollegeProfile> userCollegeProfiles = new HashSet<UserCollegeProfile>(0);
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user", targetEntity = UserAssessmentProfile.class)
	@NotFound(action = NotFoundAction.IGNORE)	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.userassessmentprofile")
	private Set<UserAssessmentProfile> userAssessmentProfiles = new HashSet<UserAssessmentProfile>(0);
		
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user", targetEntity = AdvisingSession.class)	
	@NotFound(action = NotFoundAction.IGNORE)	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.advisingsession")
	private Set<AdvisingSession> advisingSessions = new HashSet<AdvisingSession>(0);
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Certification.class)
	@JoinColumn(name = "UID", nullable = false)
	@NotFound(action = NotFoundAction.IGNORE)	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.certification")
	private Set<Certification> certifications = new HashSet<Certification>(0);
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user", targetEntity = PraxisIITestScore.class)
	@NotFound(action = NotFoundAction.IGNORE)	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.praxisIItestscore")
	private Set<PraxisIITestScore> praxisIITestScores = new HashSet<PraxisIITestScore>(0);
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user", targetEntity = PraxisITestScore.class)
	@NotFound(action = NotFoundAction.IGNORE)	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.praxisItestscore")
	private Set<PraxisITestScore> praxisITestScores = new HashSet<PraxisITestScore>(0);
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user", targetEntity = GreTestScore.class)
	@NotFound(action = NotFoundAction.IGNORE)	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.gretestscore")
	private Set<GreTestScore> greTestScores = new HashSet<GreTestScore>(0);
		
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.note")
	@ManyToMany(fetch=FetchType.LAZY, targetEntity = Note.class)	
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinTable(name = "tblStudentNotes", joinColumns={ 
	@JoinColumn(name = "UID")}, inverseJoinColumns={
	@JoinColumn(name = "NoteId", nullable = false)})
	private Set<Note> notes = new HashSet<Note>(0);
		
	@ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, targetEntity = Role.class)
	@IndexColumn(name = "role_index", base = 0)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinTable(name = "tbl20User_Role", joinColumns={
	@JoinColumn(name = "UID")}, inverseJoinColumns={
	@JoinColumn(name = "roleid", nullable = false)})
	private List<Role> roles = new ArrayList<Role>(0);
		
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.event")
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Event.class)	
	@IndexColumn(name = "event_index", base = 0)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinTable(name = "tblUser_Event", joinColumns={ 
	@JoinColumn(name = "UID")}, inverseJoinColumns={
	@JoinColumn(name = "EventId", nullable = false)})
	private List<Event> events = new ArrayList<Event>(0);
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.lastlogin")
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@IndexColumn(name = "lastlogin_index", base = 0)
	@NotFound(action = NotFoundAction.IGNORE)	
	@JoinTable(name = "tbl20User_LastLogin", joinColumns={ 
	@JoinColumn(name = "UID")}, inverseJoinColumns={
	@JoinColumn(name = "lastLoginId", nullable = false)})
	private List<LastLogin> lastlogins = new ArrayList<LastLogin>(0);
		
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.ipaddress")
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = IPAddress.class)
	@IndexColumn(name = "ipaddress_index", base = 0)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinTable(name = "tbl20User_IPAddress", joinColumns={ 
	@JoinColumn(name = "UID")}, inverseJoinColumns={
	@JoinColumn(name = "ID", nullable = false)})
	private List<IPAddress> ipAddresses = new ArrayList<IPAddress>(0);
	
	
	// TODO: Allow user to change this field for internationalization.
	@Transient
 	private Locale locale = Locale.getDefault();

	@Transient
	private List<String> personType = new ArrayList<String>(0);

	// TODO: Allow user to change the timezone to change the time in modules
	// such as Advising & Appointments
	@Transient
	private TimeZone timeZone = TimeZone.getDefault();
	
	@Transient
	private String ukyEmailAddress;
	
	@Transient
	private UserProgramProfile userProgramProfile;
	
	@Transient
	private UserCollegeProfile userCollegeProfile;
	
	@Transient
	private float cumulativeGpa;
	
	@Transient
	private int totalQualityHours;	
	
	@Transient
	private int totalQualityPoints;
	

	/**
	 * 
	 */
	public User() {

	}

	/**
	 * @param uid
	 */
	public User(String uid) {
		this.uid = uid;
	}

	/**
	 * @param uid
	 * @param username
	 */
	public User(String uid, String username) {
		this.uid = uid;
		this.username = username;
	}

	/**
	 * @param ukID
	 * @param ssn
	 * @param username
	 * @param lName
	 * @param mName
	 * @param fName
	 * @param maidenName
	 * @param suffix
	 * @param gender
	 * @param title
	 * @param dOB
	 * @param badgeHolder
	 */
	public User(String ukID, String ssn, String username, String lName,
			String mName, String fName, String maidenName, String suffix,
			String gender, String title, Date dOB, int badgeHolder) {
		this.ukID = ukID;
		this.ssn = ssn;
		this.username = username;
		this.lName = lName;
		this.mName = mName;
		this.fName = fName;
		this.maidenName = maidenName;
		this.suffix = suffix;
		this.gender = gender;
		this.title = title;
		this.dOB = dOB;
		this.createdOn = new Date();
		this.badgeHolder = badgeHolder;
	}

	/**
	 * @param ukID
	 * @param ssn
	 * @param username
	 * @param lName
	 * @param lName1
	 * @param lName2
	 * @param lName3
	 * @param lName4
	 * @param preferredName
	 * @param mName
	 * @param fName
	 * @param maidenName
	 * @param suffix
	 * @param gender
	 * @param title
	 * @param dOB
	 * @param badgeHolder
	 */
	public User(String ukID, String ssn, String username, String lName,
			String lName1, String lName2, String lName3, String lName4,
			String preferredName, String mName, String fName,
			String maidenName, String suffix, String gender, String title,
			Date dOB, int badgeHolder) {
		this.ukID = ukID;
		this.ssn = ssn;
		this.username = username;
		this.lName = lName;
		this.lName1 = lName1;
		this.lName2 = lName2;
		this.lName3 = lName3;
		this.lName4 = lName4;
		this.preferredName = preferredName;
		this.mName = mName;
		this.fName = fName;
		this.maidenName = maidenName;
		this.suffix = suffix;
		this.gender = gender;
		this.title = title;
		this.dOB = dOB;
		this.createdOn = new Date();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
		
	@Override
	public int compare(User o1, User o2) {
		return o1.getFullName().compareTo(o2.getFullName());
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
		User other = (User) obj;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (dOB == null) {
			if (other.dOB != null)
				return false;
		} else if (!dOB.equals(other.dOB))
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (lName1 == null) {
			if (other.lName1 != null)
				return false;
		} else if (!lName1.equals(other.lName1))
			return false;
		if (lName2 == null) {
			if (other.lName2 != null)
				return false;
		} else if (!lName2.equals(other.lName2))
			return false;
		if (lName3 == null) {
			if (other.lName3 != null)
				return false;
		} else if (!lName3.equals(other.lName3))
			return false;
		if (lName4 == null) {
			if (other.lName4 != null)
				return false;
		} else if (!lName4.equals(other.lName4))
			return false;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		if (maidenName == null) {
			if (other.maidenName != null)
				return false;
		} else if (!maidenName.equals(other.maidenName))
			return false;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		if (suffix == null) {
			if (other.suffix != null)
				return false;
		} else if (!suffix.equals(other.suffix))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		if (ukID == null) {
			if (other.ukID != null)
				return false;
		} else if (!ukID.equals(other.ukID))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	/**
	 * @return the addresses
	 * @uml.property name="addresses"
	 */
	public Set<Address> getAddresses() {
		return addresses;
	}

	/**
	 * @return the advisingSessions
	 * @uml.property name="advisingSessions"
	 */
	public Set<AdvisingSession> getAdvisingSessions() {
		return advisingSessions;
	}

	/**
	 * @return the badgeHolder
	 * @uml.property name="badgeHolder"
	 */
	public int getBadgeHolder() {
		return badgeHolder;
	}

	/**
	 * @return the certifications
	 * @uml.property name="certifications"
	 */
	public Set<Certification> getCertifications() {
		return certifications;
	}

	/**
	 * @return the createdOn
	 * @uml.property name="createdOn"
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @return the dOB
	 * @uml.property name="dOB"
	 */
	public Date getdOB() {
		return dOB;
	}

	/**
	 * @return
	 * @uml.property name="emailAddresses"
	 */
	public Set<EmailAddress> getEmailAddresses() {
		return this.emailAddresses;
	}

	/**
	 * @return the events
	 * @uml.property name="events"
	 */
	public List<Event> getEvents() {
		return events;
	}

	/**
	 * @return the fName
	 * @uml.property name="fName"
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @return the fullName
	 * @uml.property name="fullName"
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @return the gender
	 * @uml.property name="gender"
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @return
	 * @uml.property name="ipAddresses"
	 */
	public List<IPAddress> getIpAddresses() {
		return this.ipAddresses;
	}

	/**
	 * @return
	 * @uml.property name="lastlogins"
	 */
	public List<LastLogin> getLastlogins() {
		return this.lastlogins;
	}

	/**
	 * @return the lName
	 * @uml.property name="lName"
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @return the lName1
	 */
	public String getlName1() {
		return lName1;
	}

	/**
	 * @return the lName2
	 */
	public String getlName2() {
		return lName2;
	}

	/**
	 * @return the lName3
	 */
	public String getlName3() {
		return lName3;
	}

	/**
	 * @return the lName4
	 */
	public String getlName4() {
		return lName4;
	}

	/**
	 * @return
	 * @uml.property name="locale"
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @return the maidenName
	 * @uml.property name="maidenName"
	 */
	public String getMaidenName() {
		return maidenName;
	}

	/**
	 * @return the mName
	 * @uml.property name="mName"
	 */
	public String getmName() {
		return mName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the enabled
	 */
	public int getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the personType
	 * @uml.property name="personType"
	 */
	public List<String> getPersonType() {
		return personType;
	}

	/**
	 * @return the phoneNumbers
	 * @uml.property name="phoneNumbers"
	 */
	public Set<Phone> getPhoneNumbers() {
		return phoneNumbers;
	}

	public String getPreferredName() {
		return preferredName;
	}

	/**
	 * @return the reportUser
	 * @uml.property name="reportUser"
	 */
	public Set<ReportUser> getReportUser() {
		return reportUser;
	}

	/**
	 * @return
	 * @uml.property name="roles"
	 */
	public List<Role> getRoles() {
		return this.roles;
	}

	/**
	 * @return the savedSearches
	 */
	public Set<Query> getSavedQueries() {
		return savedQueries;
	}

	/**
	 * @return the ssn
	 * @uml.property name="ssn"
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * @return the suffix
	 * @uml.property name="suffix"
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * @return
	 * @uml.property name="timeZone"
	 */
	public TimeZone getTimeZone() {
		return timeZone;
	}

	/**
	 * @return the title
	 * @uml.property name="title"
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return
	 * @uml.property name="uid"
	 */
	public String getUid() {
		return this.uid;
	}

	/**
	 * @return the ukID
	 * @uml.property name="ukID"
	 */
	public String getUkID() {
		return ukID;
	}

	/**
	 * @return the userAssessmentProfiles
	 */
	public Set<UserAssessmentProfile> getUserAssessmentProfiles() {
		return userAssessmentProfiles;
	}

	/**
	 * @return the userCollegeProfiles
	 * @uml.property name="userCollegeProfiles"
	 */
	public Set<UserCollegeProfile> getUserCollegeProfiles() {
		return userCollegeProfiles;
	}

	/**
	 * @return the userConfiguration
	 * @uml.property name="userConfiguration"
	 */
	public UserConfiguration getUserConfiguration() {
		return userConfiguration;
	}

	/**
	 * @return
	 * @uml.property name="username"
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * @return the userPersonalProfiles
	 * @uml.property name="userPersonalProfiles"
	 */
	public UserPersonalProfile getUserPersonalProfile() {
		return userPersonalProfile;
	}

	/**
	 * @return the userProgramProfiles
	 * @uml.property name="userProgramProfiles"
	 */
	public Set<UserProgramProfile> getUserProgramProfiles() {
		return userProgramProfiles;
	}

	/**
	 * @return
	 * @uml.property name="workingSets"
	 */
	public Set<WorkingSet> getWorkingSets() {
		return this.workingSets;
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
		result = prime * result
				+ ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result + ((dOB == null) ? 0 : dOB.hashCode());
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + ((lName1 == null) ? 0 : lName1.hashCode());
		result = prime * result + ((lName2 == null) ? 0 : lName2.hashCode());
		result = prime * result + ((lName3 == null) ? 0 : lName3.hashCode());
		result = prime * result + ((lName4 == null) ? 0 : lName4.hashCode());
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		result = prime * result
				+ ((maidenName == null) ? 0 : maidenName.hashCode());
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		result = prime * result + ((suffix == null) ? 0 : suffix.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		result = prime * result + ((ukID == null) ? 0 : ukID.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/**
	 * @param addresses
	 *            the addresses to set
	 * @uml.property name="addresses"
	 */
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	/**
	 * @param advisingSessions
	 *            the advisingSessions to set
	 * @uml.property name="advisingSessions"
	 */
	public void setAdvisingSessions(Set<AdvisingSession> advisingSessions) {
		this.advisingSessions = advisingSessions;
	}

	/**
	 * @param badgeHolder
	 *            the badgeHolder to set
	 * @uml.property name="badgeHolder"
	 */
	public void setBadgeHolder(int badgeHolder) {
		this.badgeHolder = badgeHolder;
	}

	/**
	 * @param certifications
	 *            the certifications to set
	 * @uml.property name="certifications"
	 */
	public void setCertifications(Set<Certification> certifications) {
		this.certifications = certifications;
	}

	/**
	 * @param createdOn
	 *            the createdOn to set
	 * @uml.property name="createdOn"
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @param dOB
	 *            the dOB to set
	 * @uml.property name="dOB"
	 */
	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}

	/**
	 * @param emailaddresses
	 * @uml.property name="emailAddresses"
	 */
	public void setEmailAddresses(Set<EmailAddress> emailaddresses) {
		this.emailAddresses = emailaddresses;
	}

	/**
	 * @param events
	 *            the events to set
	 * @uml.property name="events"
	 */
	public void setEvents(List<Event> events) {
		this.events = events;
	}

	/**
	 * @param fName
	 *            the fName to set
	 * @uml.property name="fName"
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 * @uml.property name="fullName"
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @param gender
	 *            the gender to set
	 * @uml.property name="gender"
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @param ipAddresses
	 * @uml.property name="ipAddresses"
	 */
	public void setIpAddresses(List<IPAddress> ipAddresses) {
		this.ipAddresses = ipAddresses;
	}

	/**
	 * @param lastlogins
	 * @uml.property name="lastlogins"
	 */
	public void setLastlogins(List<LastLogin> lastlogins) {
		this.lastlogins = lastlogins;
	}

	/**
	 * @param lName
	 *            the lName to set
	 * @uml.property name="lName"
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * @param lName1
	 *            the lName1 to set
	 */
	public void setlName1(String lName1) {
		this.lName1 = lName1;
	}

	/**
	 * @param lName2
	 *            the lName2 to set
	 */
	public void setlName2(String lName2) {
		this.lName2 = lName2;
	}

	/**
	 * @param lName3
	 *            the lName3 to set
	 */
	public void setlName3(String lName3) {
		this.lName3 = lName3;
	}

	/**
	 * @param lName4
	 *            the lName4 to set
	 */
	public void setlName4(String lName4) {
		this.lName4 = lName4;
	}

	/**
	 * @param locale
	 * @uml.property name="locale"
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * @param maidenName
	 *            the maidenName to set
	 * @uml.property name="maidenName"
	 */
	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}

	/**
	 * @param mName
	 *            the mName to set
	 * @uml.property name="mName"
	 */
	public void setmName(String mName) {
		this.mName = mName;
	}

	/**
	 * @param personType
	 *            the personType to set
	 * @uml.property name="personType"
	 */
	public void setPersonType(List<String> personType) {
		this.personType = personType;
	}

	/**
	 * @param phoneNumbers
	 *            the phoneNumbers to set
	 * @uml.property name="phoneNumbers"
	 */
	public void setPhoneNumbers(Set<Phone> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}

	public Set<PraxisIITestScore> getPraxisIITestScores() {
		return praxisIITestScores;
	}

	public void setPraxisIITestScores(Set<PraxisIITestScore> praxisIITestScores) {
		this.praxisIITestScores = praxisIITestScores;
	}

	public Set<PraxisITestScore> getPraxisITestScores() {
		return praxisITestScores;
	}

	public void setPraxisITestScores(Set<PraxisITestScore> praxisITestScores) {
		this.praxisITestScores = praxisITestScores;
	}

	public Set<GreTestScore> getGreTestScores() {
		return greTestScores;
	}

	public void setGreTestScores(Set<GreTestScore> greTestScores) {
		this.greTestScores = greTestScores;
	}

	/**
	 * @param reportUser
	 *            the reportUser to set
	 * @uml.property name="reportUser"
	 */
	public void setReportUser(Set<ReportUser> reportUser) {
		this.reportUser = reportUser;
	}

	/**
	 * @param roles
	 * @uml.property name="roles"
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @param savedSearches
	 *            the savedSearches to set
	 */
	public void setSavedQueries(Set<Query> savedQueries) {
		this.savedQueries = savedQueries;
	}

	/**
	 * @param ssn
	 *            the ssn to set
	 * @uml.property name="ssn"
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/**
	 * @param suffix
	 *            the suffix to set
	 * @uml.property name="suffix"
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	/**
	 * @param timeZone
	 * @uml.property name="timeZone"
	 */
	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

	/**
	 * @param title
	 *            the title to set
	 * @uml.property name="title"
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param uid
	 * @uml.property name="uid"
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @param ukID
	 *            the ukID to set
	 * @uml.property name="ukID"
	 */
	public void setUkID(String ukID) {
		this.ukID = ukID;
	}

	/**
	 * @param userAssessmentProfiles
	 *            the userAssessmentProfiles to set
	 */
	public void setUserAssessmentProfiles(
			Set<UserAssessmentProfile> userAssessmentProfiles) {
		this.userAssessmentProfiles = userAssessmentProfiles;
	}

	/**
	 * @param userCollegeProfiles
	 *            the userCollegeProfiles to set
	 * @uml.property name="userCollegeProfiles"
	 */
	public void setUserCollegeProfiles(
			Set<UserCollegeProfile> userCollegeProfiles) {
		this.userCollegeProfiles = userCollegeProfiles;
	}

	/**
	 * @param userConfiguration
	 *            the userConfiguration to set
	 * @uml.property name="userConfiguration"
	 */
	public void setUserConfiguration(UserConfiguration userConfiguration) {
		this.userConfiguration = userConfiguration;
	}

	/**
	 * @param username
	 * @uml.property name="username"
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param userPersonalProfiles
	 *            the userPersonalProfiles to set
	 * @uml.property name="userPersonalProfiles"
	 */
	public void setUserPersonalProfile(UserPersonalProfile userPersonalProfile) {
		this.userPersonalProfile = userPersonalProfile;
	}

	/**
	 * @param userProgramProfiles
	 *            the userProgramProfiles to set
	 * @uml.property name="userProgramProfiles"
	 */
	public void setUserProgramProfiles(Set<UserProgramProfile> userProgramProfiles) {
		this.userProgramProfiles = userProgramProfiles;
	}

	/**
	 * @param workingSets
	 * @uml.property name="workingSets"
	 */
	public void setWorkingSets(Set<WorkingSet> workingSets) {
		this.workingSets = workingSets;
	}

	public Set<Note> getNotes() {
		return notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}
	
	public String getUkyEmailAddress() {
		return ukyEmailAddress;
	}

	public void setUkyEmailAddress(String ukyEmailAddress) {
		this.ukyEmailAddress = ukyEmailAddress;
	}

	public UserProgramProfile getUserProgramProfile() {
		return userProgramProfile;
	}

	public void setUserProgramProfile(UserProgramProfile userProgramProfile) {
		this.userProgramProfile = userProgramProfile;
	}

	public UserCollegeProfile getUserCollegeProfile() {
		return userCollegeProfile;
	}

	public void setUserCollegeProfile(UserCollegeProfile userCollegeProfile) {
		this.userCollegeProfile = userCollegeProfile;
	}

	public float getCumulativeGpa() {
		return cumulativeGpa;
	}

	public void setCumulativeGpa(float cumulativeGpa) {
		this.cumulativeGpa = cumulativeGpa;
	}

	public int getTotalQualityHours() {
		return totalQualityHours;
	}

	public void setTotalQualityHours(int totalQualityHours) {
		this.totalQualityHours = totalQualityHours;
	}

	public int getTotalQualityPoints() {
		return totalQualityPoints;
	}

	public void setTotalQualityPoints(int totalQualityPoints) {
		this.totalQualityPoints = totalQualityPoints;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.fullName;
	}

}
