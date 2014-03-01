/**
 * 
 */
package edu.uky.cepis.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.uky.cepis.dao.PraxisIITestDao;
import edu.uky.cepis.dao.PraxisIITestScoreDao;
import edu.uky.cepis.domain.PraxisIITest;
import edu.uky.cepis.domain.PraxisIITestScore;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 */
public class PraxisIITestScoreServiceImpl implements PraxisIITestScoreService {

	/**
	 * @uml.property name="addressDao"
	 * @uml.associationEnd
	 */
	private PraxisIITestScoreDao praxisIITestScoreDao;
	
	private PraxisIITestDao praxisIITestDao;

	@Override
	public boolean addPraxisIITestScoreToUser(User user,
			PraxisIITestScore praxisIITestScore) {
		return this.getPraxisIITestScoreDao().addPraxisIITestScoreToUser(user,
				praxisIITestScore);
	}

	@Override
	public boolean addPraxisIITestScoreToUser(User user, Date testDate,
			PraxisIITest praxisIITest, String candidateId, double score,
			int primary, int nonStandardAdministration,
			int revisedScoreIndicator, int excellenceIndicator) {
		return this.getPraxisIITestScoreDao().addPraxisIITestScoreToUser(user, testDate,
				praxisIITest, candidateId, score, primary, 
				nonStandardAdministration, revisedScoreIndicator,
				excellenceIndicator);
	}

	@Override
	public List<PraxisIITestScore> findByTestDate(User user, Date testDate) {
		return this.getPraxisIITestScoreDao().findByTestDate(user, testDate);
	}

	@Override
	public PraxisIITestScore findPraxisIITestScoreById(long id) {
		return this.getPraxisIITestScoreDao().findPraxisIITestScoreById(id);
	}

	@Override
	public List<PraxisIITestScore> findByCandidateId(String candidateId) {
		return this.getPraxisIITestScoreDao().findByCandidateId(candidateId);
	}

	@Override
	public List<PraxisIITestScore> findByTestCode(User user, PraxisIITest praxisIITest) {
		return this.getPraxisIITestScoreDao().findByTestCode(user, praxisIITest);
	}

	@Override
	public User findUserByCandidateId(String candidateId) {
		return this.getPraxisIITestScoreDao().findUserByCandidateId(candidateId);
	}
	
	@Override
	public List<PraxisIITestScore> getPraxisIITestScoreList(User user) {
		List<PraxisIITestScore> praxisIITestScore = new ArrayList<PraxisIITestScore>();
		
		//Get Tests for user and set praxisIITest
		for(PraxisIITestScore pts :  this.getPraxisIITestScoreDao().getPraxisIITestScoreList(user)){
			if(pts != null){
			List<PraxisIITest> praxisIITest = this.getPraxisIITestDao().getPraxisIITestByCode(pts.getPraxisIICode());
				for(PraxisIITest pt : praxisIITest){
					if( (pts.getTestDate().before(pt.getEndDate()) && pts.getTestDate().after(pt.getBeginDate())) || 
							pts.getTestDate().equals(pt.getEndDate()) || pts.getTestDate().equals(pt.getBeginDate())){
							pts.setPraxisIITest(pt);
							praxisIITestScore.add(pts);
					}
				}
			}
		}
		return praxisIITestScore;
	}

	@Override
	public PraxisIITestScore getPrimaryPraxisIITestScore(User user, String testCode) {
		return this.getPraxisIITestScoreDao().getPrimaryPraxisIITestScore(user, testCode);
	}

	@Override
	public List<PraxisIITest> getPraxisIITestsTakenByUser(User user) {
		return this.getPraxisIITestScoreDao().getPraxisIITestsTakenByUser(user);
	}

	@Override
	public List<PraxisIITestScore> getPraxisIITestScoreListByTestCode(User user,
			String testCode) {
		return this.getPraxisIITestScoreDao().getPraxisIITestScoreListByTestCode(user,
				testCode);
	}

	@Override
	public boolean removePraxisIITestScoreFromUser(User user,
			PraxisIITestScore praxisIITestScore) {
		return this.getPraxisIITestScoreDao().removePraxisIITestScoreFromUser(user,
				praxisIITestScore);
	}

	@Override
	public PraxisIITestScore updatePraxisIITestScore(User user,
			PraxisIITestScore praxisTestScore, Date receivedDate, Date testDate,
			PraxisIITest praxisIITest, String candidateId, double score,
			int primary, int nonStandardAdministration,
			int revisedScoreIndicator, int excellenceIndicator) {
		return this.getPraxisIITestScoreDao().updatePraxisIITestScore(user,
				praxisTestScore, receivedDate, testDate, praxisIITest, candidateId, score,
				primary, nonStandardAdministration,
				revisedScoreIndicator, excellenceIndicator);
	}

	@Override
	public List<PraxisIITestScore> getArchivedPraxisIITestScoresForUser(User user) {
		return this.getPraxisIITestScoreDao().getArchivedPraxisIITestScoresForUser(user);
	}

	@Override
	public int addArchivedPraxisIITestScoreToUser(User user,
			PraxisIITestScore archivedPraxisIITestScore) {
		return this.getPraxisIITestScoreDao().addArchivedPraxisIITestScoreToUser(user,
				archivedPraxisIITestScore);
	}

	public PraxisIITestScoreDao getPraxisIITestScoreDao() {
		return praxisIITestScoreDao;
	}

	public void setPraxisIITestScoreDao(PraxisIITestScoreDao praxisIITestScoreDao) {
		this.praxisIITestScoreDao = praxisIITestScoreDao;
	}

	public PraxisIITestDao getPraxisIITestDao() {
		return praxisIITestDao;
	}

	public void setPraxisIITestDao(PraxisIITestDao praxisIITestDao) {
		this.praxisIITestDao = praxisIITestDao;
	}

}
