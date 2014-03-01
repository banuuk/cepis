/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.Course;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public class UserAcademicProfileDaoImpl implements UserAcademicProfileDao {

	private static Logger log = Logger
			.getLogger(UserAcademicProfileDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getCourseList(User user) {
		List<Course> academicInfoList = new ArrayList<Course>(0);
		log.debug("Calling Dao Academic Profile for " + user);
		if (user == null) {
			return academicInfoList;
		}

		String hql = "select course from  Course course where course.ukID = '"
				+ user.getUkID() + "' order by course.no";
		academicInfoList = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();

		log.debug("Course Size: " + academicInfoList.size());
		return academicInfoList;
	}

}
