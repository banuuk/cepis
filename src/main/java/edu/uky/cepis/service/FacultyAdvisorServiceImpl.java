package edu.uky.cepis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uky.cepis.dao.FacultyAdvisorDao;
import edu.uky.cepis.domain.FacultyAdvisor;

@Service("facultyAdvisorService")
public class FacultyAdvisorServiceImpl implements FacultyAdvisorService {

	@Autowired
	private FacultyAdvisorDao facultyAdvisorDao;
	
	@Override
	public FacultyAdvisor findAdvisorByUid(String uid) {
		return getFacultyAdvisorDao().findAdvisorByUid(uid);
	}
	
	@Override
	public List<FacultyAdvisor> getFacultyAdvisorList() {
		return getFacultyAdvisorDao().getFacultyAdvisorList();
	}

	public FacultyAdvisorDao getFacultyAdvisorDao() {
		return facultyAdvisorDao;
	}

	public void setFacultyAdvisorDao(FacultyAdvisorDao facultyAdvisorDao) {
		this.facultyAdvisorDao = facultyAdvisorDao;
	}
}
