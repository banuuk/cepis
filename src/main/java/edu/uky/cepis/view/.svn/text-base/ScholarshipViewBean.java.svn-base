package edu.uky.cepis.view;

import java.util.List;

import edu.uky.cepis.domain.Scholarship;
import edu.uky.cepis.domain.StudentScholarship;
import edu.uky.cepis.domain.User;

/**
 * @author cawalk4
 *
 */
public class ScholarshipViewBean extends CepisWebView implements ScholarshipView {

	private static final long serialVersionUID = 1L;

	@Override
	public Scholarship findScholarshipById(long id) {
		return this.getScholarshipService().findScholarshipById(id);
	}

	@Override
	public boolean saveOrUpdateScholarship(Scholarship scholarship) {
		return this.getScholarshipService().saveOrUpdateScholarship(scholarship);
	}

	@Override
	public boolean deleteScholarship(Scholarship scholarship) {
		return this.getScholarshipService().deleteScholarship(scholarship);
	}

	@Override
	public List<Scholarship> getScholarshipByExample(Scholarship scholarship) {
		return this.getScholarshipService().getScholarshipByExample(scholarship);
	}

	@Override
	public StudentScholarship findStudentScholarshipById(long id) {
		return this.getStudentScholarshipService().findStudentScholarshipById(id);
	}

	@Override
	public boolean saveOrUpdateStudentScholarship(StudentScholarship studentScholarship) {
		return this.getStudentScholarshipService().saveOrUpdateStudentScholarship(studentScholarship);
	}

	@Override
	public boolean deleteStudentScholarship(StudentScholarship studentScholarship) {
		return this.getStudentScholarshipService().deleteStudentScholarship(studentScholarship);
	}

	@Override
	public List<StudentScholarship> getStudentScholarshipByExample(StudentScholarship studentScholarship) {
		return this.getStudentScholarshipService().getStudentScholarshipByExample(studentScholarship);
	}

	@Override
	public List<StudentScholarship> getStudentScholarshipForUser(User user) {
		return this.getStudentScholarshipService().getStudentScholarshipForUser(user);
	}

}
