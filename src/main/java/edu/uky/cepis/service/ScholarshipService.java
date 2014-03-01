package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.domain.Scholarship;

/**
 * @author cawalk4
 *
 */
public interface ScholarshipService {

	public abstract Scholarship findScholarshipById(long id);
	
	public abstract boolean saveOrUpdateScholarship(Scholarship scholarship);
	
	public abstract boolean deleteScholarship(Scholarship scholarship);
	
	public abstract List<Scholarship> getScholarshipByExample(Scholarship scholarship);
	
}
