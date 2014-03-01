package edu.uky.cepis.view;

import java.util.Date;
import java.util.List;

import edu.uky.cepis.domain.GreTestScore;
import edu.uky.cepis.domain.PraxisIITest;
import edu.uky.cepis.domain.PraxisIITestScore;
import edu.uky.cepis.domain.PraxisITest;
import edu.uky.cepis.domain.PraxisITestScore;
import edu.uky.cepis.domain.User;



/**
 * @author cawalk4
 *
 */
public class TestScoreViewBean extends CepisWebView implements  TestScoreView {
	
	private static final long serialVersionUID = 1L;


	@Override
	public GreTestScore findById(long id){
		return this.getGreTestScoreService().findById(id);
	}
	
	@Override
	public boolean saveOrUpdateGreTestScore(GreTestScore greTestScore){
		return this.getGreTestScoreService().saveOrUpdateGreTestScore(greTestScore);
	}
	
	@Override
	public boolean deleteGreTestScore(GreTestScore greTestScore){
		return this.getGreTestScoreService().deleteGreTestScore(greTestScore);
	}

	@Override
	public List<GreTestScore> findGreTestScoreByExample(GreTestScore greTestScore){
		return this.getGreTestScoreService().findGreTestScoreByExample(greTestScore);
	}
	

	@Override
	public List<PraxisIITestScore> getPraxisIITestScoreList(User user) {
		return this.getPraxisIITestScoreService().getPraxisIITestScoreList(user);
	}

	@Override
	public List<PraxisIITestScore> getArchivedPraxisIITestScoresForUser(User user) {
		return this.getPraxisIITestScoreService().getArchivedPraxisIITestScoresForUser(
				user);
	}

	@Override
	public boolean addPraxisIITestScoreToUser(User user, Date testDate,
			PraxisIITest praxisIITest, String candidateId, double score,
			int primary, int nonStandardAdministration,
			int revisedScoreIndicator, int excellenceIndicator) {
		return this.getPraxisIITestScoreService().addPraxisIITestScoreToUser(user,
				testDate, praxisIITest, candidateId, score, primary,
				nonStandardAdministration, revisedScoreIndicator,
				excellenceIndicator);
	}

	@Override
	public boolean removePraxisIITestScoreFromUser(User user,
			PraxisIITestScore praxisIITestScore) {
		return this.getPraxisIITestScoreService().removePraxisIITestScoreFromUser(user,
				praxisIITestScore);
	}

	@Override
	public PraxisIITestScore updatePraxisTestScore(User user,
			PraxisIITestScore praxisIITestScore,Date receivedDate, Date testDate,
			PraxisIITest praxisIITest, String candidateId, double score,
			int primary,int nonStandardAdministration,
			int revisedScoreIndicator, int excellenceIndicator) {
		return this.getPraxisIITestScoreService().updatePraxisIITestScore(user,
				praxisIITestScore, receivedDate, testDate, praxisIITest, candidateId, score,
				primary, nonStandardAdministration,
				revisedScoreIndicator, excellenceIndicator);
	}

	@Override
	public boolean addPraxisIITestScoreToUser(User user,
			PraxisIITestScore praxisIITestScore) {
		return this.getPraxisIITestScoreService().addPraxisIITestScoreToUser(user,
				praxisIITestScore);
	}
	
	@Override
	public PraxisIITestScore findPraxisIITestScoreById(long id){
		return this.getPraxisIITestScoreService().findPraxisIITestScoreById(id);
	}
	
	@Override
	public List<PraxisIITest> getPraxisIITestByCode(String testCode){
		return this.getPraxisIITestService().getPraxisIITestByCode(testCode);
	}
	
	@Override
	public List<PraxisIITest> getPraxisIITests(){
		return this.getPraxisIITestService().getPraxisIITests();
	}
	
	@Override
	public List<PraxisITest> getPraxisITests(){
		return this.getPraxisITestService().getPraxisITests();
	}
	
	@Override
	public List<PraxisITest> getPraxisITestByCode(String testCode){
		return this.getPraxisITestService().getPraxisITestByCode(testCode);
	}
	
	@Override
	public PraxisITest findPraxisITestById(long id){
		return this.getPraxisITestService().findPraxisITestById(id);
	}
	
	@Override
	public boolean addPraxisITestScoreToUser(User user, PraxisITestScore praxisTestScore){
		return this.getPraxisITestScoreService().addPraxisITestScoreToUser(user, praxisTestScore);
	}

	@Override
	public boolean addPraxisITestScoreToUser(User user, Date testDate,
			PraxisITest praxisTest, double score,int primary){
		return this.getPraxisITestScoreService().addPraxisITestScoreToUser(
				user, testDate, praxisTest, score, primary);
	}

	@Override
	public PraxisITestScore findPraxisITestScoreById(long id){
		return this.getPraxisITestScoreService().findPraxisITestScoreById(id);
	}

	@Override
	public List<PraxisITestScore> getPraxisITestScores(User user){
		return this.getPraxisITestScoreService().getPraxisITestScores(user);
	}

	@Override
	public boolean removePraxisITestScoreFromUser(User user, PraxisITestScore praxisTestScore){
		return this.getPraxisITestScoreService().removePraxisITestScoreFromUser(user, praxisTestScore);
	}

	@Override
	public PraxisITestScore updatePraxisITestScore(User user, PraxisITestScore praxisTestScore, 
			Date testDate,PraxisITest praxisTest,String candidateId, double score, int primary){
		return this.getPraxisITestScoreService().updatePraxisITestScore(
				user, praxisTestScore, testDate, praxisTest, candidateId, score, primary);
	}

	@Override
	public boolean addGreTestScoreToUser(User user, GreTestScore greTestScore) {
		return this.getGreTestScoreService().addGreTestScoreToUser(user, greTestScore);
	}

	@Override
	public boolean removeGreTestScoreFromUser(User user, GreTestScore greTestScore) {
		return this.getGreTestScoreService().removeGreTestScoreFromUser(user, greTestScore);
	}

	@Override
	public GreTestScore updateGreTestScore(User user, GreTestScore greTestScore) {
		return this.getGreTestScoreService().updateGreTestScore(user, greTestScore);
	}

}