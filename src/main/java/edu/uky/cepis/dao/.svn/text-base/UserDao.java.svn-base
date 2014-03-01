/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.Date;
import java.util.List;

import org.efs.openreports.objects.ReportUser;

import edu.uky.cepis.domain.Address;
import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.Phone;
import edu.uky.cepis.domain.Role;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserCollegeProfile;
import edu.uky.cepis.domain.UserConfiguration;
import edu.uky.cepis.domain.UserPersonalProfile;
import edu.uky.cepis.domain.UserProgramProfile;
import edu.uky.cepis.domain.UserType;
import edu.uky.cepis.domain.WorkingSet;

/**
 * @author keerthi
 * 
 */
public interface UserDao {

	/**
	 * Find User by Username<br/>
	 * <br/>
	 * 
	 * @param username
	 * @return User
	 * @see User
	 * 
	 */
	public abstract User findByUsername(String username);


	/**
	 * Find User by CEPIS UID<br/>
	 * <br/>
	 * 
	 * @param uid
	 * @return User
	 * @see User
	 */
	public abstract User findByUid(String uid);

	public abstract List<User> getAll(int firstResult,int maxResults);

	public abstract void manualFlush();

	public abstract User addUser(String uid, String ukID, String ssn, String username,
			String lName, String mName, String fName, String maidenName,
			String fullName, String suffix, String gender, String title,
			Date dOB,int badgeHolder);

	public abstract ReportUser createReportUser(User user, String email, int pdfExportType);

	public UserConfiguration createUserConfiguration(User user,
			WorkingSet activeWorkingSet, Address primaryAddress,
			Phone primaryPhone, EmailAddress primaryEmail,
			UserType primaryUserType, boolean rememberLastWorkingSet);

	public abstract User updateUser(User user, String uid, String ukID, String ssn,
			String username, String lName, String mName, String fName,
			String maidenName, String fullName, String suffix, String gender,
			String title, Date dOB, int badgeHolder);
	
	public abstract boolean removeUser(User user);


	public abstract UserConfiguration updateUserConfiguration(User user,
			EmailAddress emailAddress, Phone phone);


	public abstract Phone getPrimaryPhone(User user);


	public abstract EmailAddress getPrimaryEmailAddress(User user);


	public abstract boolean checkDuplicacy(String username, String ukID);


	public abstract User addCEPISUser(User user, UserCollegeProfile userCollegeProfile,
			UserProgramProfile userProgramProfile,
			UserPersonalProfile userPersonalProfile, Phone phone,
			Address address, EmailAddress emailAddress, List<Role> roles,
			ReportUser reportUser);


	public abstract User updateBadgeInfo(User user, int badgeHolder);


	

	public abstract User updateUser(User user, String uid, String ukID, String ssn,
			String username, String lName, String lName1, String lName2,
			String lName3, String lName4,String preferredName, String mName, String fName,
			String maidenName, String fullName, String suffix, String gender,
			String title, Date dOB, int badgeHolder);


	public abstract User addUser(String uid, String ukID, String ssn, String username,
			String lName, String lName1, String lName2, String lName3,
			String lName4,String preferredName, String mName, String fName, String maidenName,
			String fullName, String suffix, String gender, String title,
			Date dOB, int badgeHolder);


	public abstract ReportUser getReportUser(User user);


	public abstract User findBySSN(String ssn);


	public abstract List<User> findByGenderAndBirthDate(String gender, Date birthDate);


	public abstract List<User> findByNames(String firstname, String lastname, String lastname1,
			String lastname2, String lastname3, String lastname4,
			String middlename);


	public abstract boolean checkDuplicacy(String username);


	public abstract User updatePassword(User user, String password);


	public abstract boolean disableUser(User user);
	public abstract boolean enableUser(User user);
}
