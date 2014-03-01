package edu.uky.cepis.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import edu.uky.cepis.domain.StudentScholarship;
import edu.uky.cepis.domain.User;

/**
 * @author cawalk4
 *
 */
public class StudentScholarshipDaoImpl implements StudentScholarshipDao{
	
	private static Logger log = Logger.getLogger(StudentScholarshipDaoImpl.class.getName());
	
	private SessionFactory sessionFactory;

	@Override
	public StudentScholarship findStudentScholarshipById(long id) {
		log.info("Entered findStudentScholarshipById()");
		StudentScholarship result = (StudentScholarship) getSessionFactory().getCurrentSession().load(StudentScholarship.class, id);
		if(result != null){
			return result;
		}else{
			return null;
		}
	}

	@Override
	public boolean saveOrUpdateStudentScholarship(StudentScholarship studentScholarship) {
		log.info("Entered saveOrUpdateStudentScholarship()");
		if(studentScholarship != null){
			getSessionFactory().getCurrentSession().saveOrUpdate(studentScholarship);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteStudentScholarship(StudentScholarship studentScholarship) {
		log.info("Entered deleteStudentScholarship()");
		if(studentScholarship != null){
			getSessionFactory().getCurrentSession().delete(studentScholarship);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<StudentScholarship> getStudentScholarshipByExample(StudentScholarship studentScholarship) {
		log.info("Entered getStudentScholarshipByExample()");
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentScholarship> getStudentScholarshipForUser(User user) {
		log.info("Entered getStudentScholarshipForUser()");
		if(user != null){
			Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(StudentScholarship.class);
			
				
			searchCriteria.add(Restrictions.eq("user.uid", user.getUid()));
			
			return (List<StudentScholarship>)searchCriteria.list();
			
		}else{
			return null;
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
