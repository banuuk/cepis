/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.domain.Course;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public interface UserAcademicProfileService {

	public List<Course> getCourseList(User user);

}
