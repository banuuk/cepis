/**
 * 
 */
package com.mytutorial;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author keerthi
 * 
 */
public class CourseDaoImpl extends HibernateDaoSupport implements CourseDao {
	
	



	/*private static final SessionFactory sessionFactory;
	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mytutorial.CourseDao#create(java.util.List)
	 */
	@Override
	public void create(List<Course> listCourses) {
		HibernateTemplate ht = getHibernateTemplate();
		for (Course course : listCourses) {
		ht.save(course);
		}
		ht.flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mytutorial.CourseDao#findAll()
	 */
	@Override
	public List findAll() {
		HibernateTemplate ht = getHibernateTemplate();
		return ht.find("From Course");
	}

}
