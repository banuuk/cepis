package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.StudentScholarshipDao;
import edu.uky.cepis.domain.StudentScholarship;
import edu.uky.cepis.domain.User;

/**
 * @author cawalk4
 */
public class StudentScholarshipServiceImpl implements StudentScholarshipService {

	private StudentScholarshipDao studentScholarshipDao;
	
	
	@Override
	public StudentScholarship findStudentScholarshipById(long id) {
		return getStudentScholarshipDao().findStudentScholarshipById(id);
	}

	@Override
	public boolean saveOrUpdateStudentScholarship(StudentScholarship studentScholarship) {
		return getStudentScholarshipDao().saveOrUpdateStudentScholarship(studentScholarship);
	}

	@Override
	public boolean deleteStudentScholarship(StudentScholarship studentScholarship) {
		return getStudentScholarshipDao().deleteStudentScholarship(studentScholarship);
	}

	@Override
	public List<StudentScholarship> getStudentScholarshipByExample(StudentScholarship studentScholarship) {
		return getStudentScholarshipDao().getStudentScholarshipByExample(studentScholarship);
	}

	@Override
	public List<StudentScholarship> getStudentScholarshipForUser(User user) {
		return getStudentScholarshipDao().getStudentScholarshipForUser(user);
	}
	

	public StudentScholarshipDao getStudentScholarshipDao() {
		return studentScholarshipDao;
	}

	public void setStudentScholarshipDao(StudentScholarshipDao studentScholarshipDao) {
		this.studentScholarshipDao = studentScholarshipDao;
	}

}
