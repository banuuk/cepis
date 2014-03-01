package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.domain.GreTestScore;
import edu.uky.cepis.domain.User;



/**
 * @author cawalk4
 *
 */
public interface GreTestScoreService {
	
	public GreTestScore findById(long id);
	
	public boolean addGreTestScoreToUser(User user, GreTestScore greTestScore);
	
	public boolean removeGreTestScoreFromUser(User user, GreTestScore greTestScore);
	
	public GreTestScore updateGreTestScore(User user, GreTestScore greTestScore);
	
	public boolean saveOrUpdateGreTestScore(GreTestScore greTestScore);
	
	public boolean deleteGreTestScore(GreTestScore greTestScore);

	public List<GreTestScore> findGreTestScoreByExample(GreTestScore greTestScore);
}