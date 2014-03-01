package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.ScholarshipDao;
import edu.uky.cepis.domain.Scholarship;

public class ScholarshipServiceImpl implements ScholarshipService {
	
	private ScholarshipDao scholarshipDao;

	@Override
	public Scholarship findScholarshipById(long id) {
		return getScholarshipDao().findScholarshipById(id);
	}

	@Override
	public boolean saveOrUpdateScholarship(Scholarship scholarship) {
		return getScholarshipDao().saveOrUpdateScholarship(scholarship);
	}

	@Override
	public boolean deleteScholarship(Scholarship scholarship) {
		return getScholarshipDao().deleteScholarship(scholarship);
	}

	@Override
	public List<Scholarship> getScholarshipByExample(Scholarship scholarship) {
		return getScholarshipDao().getScholarshipByExample(scholarship);
	}

	public ScholarshipDao getScholarshipDao() {
		return scholarshipDao;
	}

	public void setScholarshipDao(ScholarshipDao scholarshipDao) {
		this.scholarshipDao = scholarshipDao;
	}

}
