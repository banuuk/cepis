package edu.uky.cepis.dao;

import java.util.List;

import edu.uky.cepis.domain.FacultyAdvisor;

public interface FacultyAdvisorDao {
	
	public FacultyAdvisor findAdvisorByUid(String uid);
	
	public List<FacultyAdvisor> getFacultyAdvisorList();
	

}