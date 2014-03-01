/**
 * 
 */
package edu.uky.cepis.service;

import java.util.Date;
import java.util.List;

import org.efs.openreports.objects.ReportUser;

import edu.uky.cepis.dao.UserDao;
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
 */
public class UserServiceImpl implements UserService {

	/**
	 * @uml.property name="userDao"
	 * @uml.associationEnd
	 */
	private UserDao userDao = null;

	/**
	 * @return the userDao
	 * @uml.property name="userDao"
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao
	 *            the userDao to set
	 * @uml.property name="userDao"
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.UserService#findByUsername(java.lang.String)
	 */
	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);

	}

	@Override
	public User findByUid(String uid) {
		return userDao.findByUid(uid);
	}

	@Override
	public List<User> getAll(int firstResult, int maxResults) {
		return this.userDao.getAll(firstResult, maxResults);
	}

	@Override
	public void manualFlush() {
		this.userDao.manualFlush();
	}

	@Override
	public User addUser(String uid, String ukID, String ssn, String username,
			String lName, String mName, String fName, String maidenName,
			String fullName, String suffix, String gender, String title,
			Date dOB, int badgeHolder) {

		return this.userDao.addUser(uid, ukID, ssn, username, lName, mName,
				fName, maidenName, fullName, suffix, gender, title, dOB,
				badgeHolder);
	}

	@Override
	public ReportUser createReportUser(User user, String email,
			int pdfExportType) {
		return this.getUserDao().createReportUser(user, email, pdfExportType);
	}

	@Override
	public UserConfiguration createUserConfiguration(User user,
			WorkingSet activeWorkingSet, Address primaryAddress,
			Phone primaryPhone, EmailAddress primaryEmail,
			UserType primaryUserType, boolean rememberLastWorkingSet) {
		return this.getUserDao().createUserConfiguration(user,
				activeWorkingSet, primaryAddress, primaryPhone, primaryEmail,
				primaryUserType, rememberLastWorkingSet);
	}

	@Override
	public User updateUser(User user, String uid, String ukID, String ssn,
			String username, String lName, String mName, String fName,
			String maidenName, String fullName, String suffix, String gender,
			String title, Date dOB, int badgeHolder) {
		return this.getUserDao().updateUser(user, uid, ukID, ssn, username,
				lName, mName, fName, maidenName, fullName, suffix, gender,
				title, dOB, badgeHolder);
	}

	@Override
	public boolean removeUser(User user) {

		return this.getUserDao().removeUser(user);
	}

	@Override
	public UserConfiguration updateUserConfiguration(User user,
			EmailAddress emailAddress, Phone phone) {
		return this.getUserDao().updateUserConfiguration(user, emailAddress,
				phone);
	}

	@Override
	public EmailAddress getPrimaryEmailAddress(User user) {
		return this.getUserDao().getPrimaryEmailAddress(user);
	}

	@Override
	public Phone getPrimaryPhone(User user) {
		return this.getUserDao().getPrimaryPhone(user);
	}

	@Override
	public boolean checkDuplicacy(String username, String ukID) {
		return this.getUserDao().checkDuplicacy(username, ukID);
	}

	@Override
	public User addCEPISUser(User user, UserCollegeProfile userCollegeProfile,
			UserProgramProfile userProgramProfile,
			UserPersonalProfile userPersonalProfile, Phone phone,
			Address address, EmailAddress emailAddress, List<Role> roles,
			ReportUser reportUser) {

		return this.getUserDao().addCEPISUser(user, userCollegeProfile,
				userProgramProfile, userPersonalProfile, phone, address,
				emailAddress, roles, reportUser);
	}

	@Override
	public User updateBadgeInfo(User user, int badgeHolder) {
		return this.getUserDao().updateBadgeInfo(user, badgeHolder);
	}

	@Override
	public User updateUser(User user, String uid, String ukID, String ssn,
			String username, String lName, String lName1, String lName2,
			String lName3, String lName4, String preferredName, String mName,
			String fName, String maidenName, String fullName, String suffix,
			String gender, String title, Date dOB, int badgeHolder) {
		return this.getUserDao().updateUser(user, uid, ukID, ssn, username,
				lName, lName1, lName2, lName3, lName4, preferredName, mName,
				fName, maidenName, fullName, suffix, gender, title, dOB,
				badgeHolder);
	}

	@Override
	public User addUser(String uid, String ukID, String ssn, String username,
			String lName, String lName1, String lName2, String lName3,
			String lName4, String preferredName, String mName, String fName,
			String maidenName, String fullName, String suffix, String gender,
			String title, Date dOB, int badgeHolder) {
		return this.getUserDao().addUser(uid, ukID, ssn, username, lName,
				lName1, lName2, lName3, lName4, preferredName, mName, fName,
				maidenName, fullName, suffix, gender, title, dOB, badgeHolder);
	}

	@Override
	public ReportUser getReportUser(User user) {
		return this.getUserDao().getReportUser(user);
	}

	@Override
	public User findBySSN(String ssn) {
		return this.getUserDao().findBySSN(ssn);
	}

	@Override
	public List<User> findByGenderAndBirthDate(String gender, Date birthDate) {
		return this.getUserDao().findByGenderAndBirthDate(gender, birthDate);
	}

	@Override
	public List<User> findByNames(String firstname, String lastname,
			String lastname1, String lastname2, String lastname3,
			String lastname4, String middlename) {
		return this.getUserDao().findByNames(firstname, lastname, lastname1,
				lastname2, lastname3, lastname4, middlename);
	}

	@Override
	public boolean checkDuplicacy(String username) {
		return this.getUserDao().checkDuplicacy(username);
	}

	@Override
	public User updatePassword(User user, String password) {
		return this.getUserDao().updatePassword(user, password);
	}

	@Override
	public boolean disableUser(User user) {
		return this.getUserDao().disableUser(user);
	}

	@Override
	public boolean enableUser(User user) {
		return this.getUserDao().enableUser(user);
	}

}
