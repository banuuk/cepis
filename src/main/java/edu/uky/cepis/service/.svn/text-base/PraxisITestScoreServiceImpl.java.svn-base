/**
 * 
 */
package edu.uky.cepis.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.uky.cepis.dao.PraxisITestDao;
import edu.uky.cepis.dao.PraxisITestScoreDao;
import edu.uky.cepis.domain.PraxisITest;
import edu.uky.cepis.domain.PraxisITestScore;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 */
public class PraxisITestScoreServiceImpl implements PraxisITestScoreService {

	/**
	 * @uml.property name="addressDao"
	 * @uml.associationEnd
	 */
	private PraxisITestScoreDao praxisITestScoreDao;
	
	private PraxisITestDao praxisITestDao;

	@Override
	public boolean addPraxisITestScoreToUser(User user,
			PraxisITestScore praxisITestScore) {
		return this.getPraxisITestScoreDao().addPraxisITestScoreToUser(user,
				praxisITestScore);
	}

	@Override
	public boolean addPraxisITestScoreToUser(User user, Date testDate,
			PraxisITest praxisITest, double score,
			int primary) {
		return this.getPraxisITestScoreDao().addPraxisITestScoreToUser(user, testDate,
				praxisITest,score, primary);
	}

	@Override
	public PraxisITestScore findPraxisITestScoreById(long id) {
		return this.getPraxisITestScoreDao().findPraxisITestScoreById(id);
	}

	
	@Override
	public List<PraxisITestScore> getPraxisITestScores(User user) {
		List<PraxisITestScore> praxisITestScore = new ArrayList<PraxisITestScore>();
		
		//Get Tests for user and set praxisIITest
		for(PraxisITestScore pts :  this.getPraxisITestScoreDao().getPraxisITestScores(user)){
			if(pts != null){
			//Create a list of all Praxis I Tests with that test code (Tests from different years still have same test code)
			List<PraxisITest> praxisITest = this.getPraxisITestDao().getPraxisITestByCode(pts.getPraxisICode());
				for(PraxisITest pt : praxisITest){
					//Check the test date to match with Praxis I Test
					if( (pts.getTestDate().before(pt.getEndDate()) && pts.getTestDate().after(pt.getBeginDate())) || 
							pts.getTestDate().equals(pt.getEndDate()) || pts.getTestDate().equals(pt.getBeginDate())){
							pts.setPraxisITest(pt);
							praxisITestScore.add(pts);
					}
				}
			}
		}
		return praxisITestScore;
	}


	@Override
	public boolean removePraxisITestScoreFromUser(User user,
			PraxisITestScore praxisITestScore) {
		return this.getPraxisITestScoreDao().removePraxisITestScoreFromUser(user,
				praxisITestScore);
	}

	@Override
	public PraxisITestScore updatePraxisITestScore(User user,
			PraxisITestScore praxisTestScore, Date testDate,
			PraxisITest praxisITest,String candidateId, double score, int primary) {
		return this.getPraxisITestScoreDao().updatePraxisITestScore(user,
				praxisTestScore, testDate, praxisITest, candidateId, score, primary);
	}

	public PraxisITestScoreDao getPraxisITestScoreDao() {
		return praxisITestScoreDao;
	}

	public void setPraxisITestScoreDao(PraxisITestScoreDao praxisITestScoreDao) {
		this.praxisITestScoreDao = praxisITestScoreDao;
	}

	public PraxisITestDao getPraxisITestDao() {
		return praxisITestDao;
	}

	public void setPraxisITestDao(PraxisITestDao praxisITestDao) {
		this.praxisITestDao = praxisITestDao;
	}

}
