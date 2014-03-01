/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.List;
import edu.uky.cepis.domain.Course;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public interface UserAcademicProfileDao {
	public List<Course> getCourseList(User user);

}
