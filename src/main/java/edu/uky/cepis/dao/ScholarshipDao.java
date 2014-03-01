package edu.uky.cepis.dao;

import java.util.List;

import edu.uky.cepis.domain.Scholarship;

/**
 * @author cawalk4
 *
 */
public interface ScholarshipDao {

	public abstract Scholarship findScholarshipById(long id);
	
	public abstract boolean saveOrUpdateScholarship(Scholarship scholarship);
	
	public abstract boolean deleteScholarship(Scholarship scholarship);
	
	public abstract List<Scholarship> getScholarshipByExample(Scholarship scholarship);
	
}
