package edu.uky.cepis.view;

import java.util.List;

import edu.uky.cepis.domain.Scholarship;
import edu.uky.cepis.domain.StudentScholarship;
import edu.uky.cepis.domain.User;

/**
 * @author cawalk4
 *
 */
public interface ScholarshipView {

	public abstract Scholarship findScholarshipById(long id);
	
	public abstract boolean saveOrUpdateScholarship(Scholarship scholarship);
	
	public abstract boolean deleteScholarship(Scholarship scholarship);
	
	public abstract List<Scholarship> getScholarshipByExample(Scholarship scholarship);
	
	public abstract StudentScholarship findStudentScholarshipById(long id);
	
	public abstract boolean saveOrUpdateStudentScholarship(StudentScholarship studentScholarship);
	
	public abstract boolean deleteStudentScholarship(StudentScholarship studentScholarship);
	
	public abstract List<StudentScholarship> getStudentScholarshipByExample(StudentScholarship studentScholarship);
	
	public abstract List<StudentScholarship> getStudentScholarshipForUser(User user);

}
