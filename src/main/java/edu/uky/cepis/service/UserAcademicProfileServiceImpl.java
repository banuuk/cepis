/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.UserAcademicProfileDao;
import edu.uky.cepis.domain.Course;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 */
public class UserAcademicProfileServiceImpl implements
		UserAcademicProfileService {

	/**
	 * @uml.property name="userCollegeProfileDao"
	 * @uml.associationEnd
	 */
	private UserAcademicProfileDao userAcademicProfileDao;

	/**
	 * @return the userAcademicProfileDao
	 */
	public UserAcademicProfileDao getUserAcademicProfileDao() {
		return userAcademicProfileDao;
	}

	/**
	 * @param userAcademicProfileDao
	 *            the userAcademicProfileDao to set
	 */
	public void setUserAcademicProfileDao(
			UserAcademicProfileDao userAcademicProfileDao) {
		this.userAcademicProfileDao = userAcademicProfileDao;
	}

	@Override
	public List<Course> getCourseList(User user) {
		return this.getUserAcademicProfileDao().getCourseList(user);
	}

}
