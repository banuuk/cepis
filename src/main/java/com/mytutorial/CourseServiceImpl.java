/**
 * 
 */
package com.mytutorial;

import java.util.List;

/**
 * @author  keerthi
 */
public class CourseServiceImpl implements CourseService {

	/**
	 * @uml.property  name="courseDao"
	 * @uml.associationEnd  
	 */
	private CourseDao courseDao;
	/**
	 * @return  the courseDao
	 * @uml.property  name="courseDao"
	 */
	public CourseDao getCourseDao() {
		return courseDao;
	}
	/**
	 * @param courseDao  the courseDao to set
	 * @uml.property  name="courseDao"
	 */
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	/* (non-Javadoc)
	 * @see com.mytutorial.CourseService#processCourse(java.util.List)
	 */
	@Override
	public void processCourse(List<Course> courses) {
		//CourseDao dao = new CourseDaoImpl(); // tightly coupled
		System.out.println("The saved courses are --> " + courses);
		courseDao.create(courses);
		List<Course> list = courseDao.findAll();
		System.out.println("The saved courses are --> " + list);

	}

}
