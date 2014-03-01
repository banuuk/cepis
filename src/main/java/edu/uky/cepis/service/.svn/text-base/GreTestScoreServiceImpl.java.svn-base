

package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.GreTestScoreDao;
import edu.uky.cepis.domain.GreTestScore;
import edu.uky.cepis.domain.User;

/**
 * @author cawalk4
 *
 */
public class GreTestScoreServiceImpl implements GreTestScoreService{
	
	private GreTestScoreDao greTestScoreDao;
	
	@Override
	public GreTestScore findById(long id){
		return this.getGreTestScoreDao().findById(id);
	}
	
	@Override
	public boolean saveOrUpdateGreTestScore(GreTestScore greTestScore){
		return this.getGreTestScoreDao().saveOrUpdateGreTestScore(greTestScore);
	}
	
	@Override
	public boolean deleteGreTestScore(GreTestScore greTestScore){
		return this.getGreTestScoreDao().deleteGreTestScore(greTestScore);
	}

	@Override
	public List<GreTestScore> findGreTestScoreByExample(GreTestScore greTestScore){
		return this.getGreTestScoreDao().findGreTestScoreByExample(greTestScore);
	}
	
	@Override
	public boolean addGreTestScoreToUser(User user, GreTestScore greTestScore){
		return this.getGreTestScoreDao().addGreTestScoreToUser(user, greTestScore);
	}
	
	@Override
	public boolean removeGreTestScoreFromUser(User user, GreTestScore greTestScore){
		return this.getGreTestScoreDao().removeGreTestScoreFromUser(user, greTestScore);
	}
	
	@Override
	public GreTestScore updateGreTestScore(User user, GreTestScore greTestScore) {
		return this.getGreTestScoreDao().updateGreTestScore(user, greTestScore);
	}

	public GreTestScoreDao getGreTestScoreDao() {
		return greTestScoreDao;
	}

	public void setGreTestScoreDao(GreTestScoreDao greTestScoreDao) {
		this.greTestScoreDao = greTestScoreDao;
	}
	
}