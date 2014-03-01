/**
 * 
 */
package edu.uky.cepis.service;

import java.util.Date;
import java.util.List;

import edu.uky.cepis.domain.PraxisIITest;
import edu.uky.cepis.domain.PraxisIITestScore;
import edu.uky.cepis.domain.User;

/**
 * @author cawalk4
 * 
 */
public interface PraxisIITestScoreService {
	public abstract boolean addPraxisIITestScoreToUser(User user,
			PraxisIITestScore praxisIITestScore);

	public abstract boolean addPraxisIITestScoreToUser(User user, Date testDate,
			PraxisIITest praxisIITest, String candidateId, double score,
			int primary, int nonStandardAdministration,
			int revisedScoreIndicator, int excellenceIndicator);

	public abstract List<PraxisIITestScore> findByTestDate(User user,
			Date testDate);

	public abstract PraxisIITestScore findPraxisIITestScoreById(long id);

	public abstract List<PraxisIITestScore> findByCandidateId(String candidateId);

	public abstract List<PraxisIITestScore> findByTestCode(User user,
			PraxisIITest praxisTest);

	public abstract User findUserByCandidateId(String candidateId);

	public abstract List<PraxisIITestScore> getPraxisIITestScoreList(User user);

	public abstract PraxisIITestScore getPrimaryPraxisIITestScore(User user,
			String testCode);

	public abstract List<PraxisIITest> getPraxisIITestsTakenByUser(User user);

	public abstract List<PraxisIITestScore> getPraxisIITestScoreListByTestCode(
			User user, String testCode);

	public boolean removePraxisIITestScoreFromUser(User user,
			PraxisIITestScore praxisIITestScore);

	public abstract PraxisIITestScore updatePraxisIITestScore(User user,
			PraxisIITestScore praxisIITestScore, Date receivedDate, Date testDate,
			PraxisIITest praxisIITest, String candidateId, double score,
			int primary, int nonStandardAdministration,
			int revisedScoreIndicator, int excellenceIndicator);

	public abstract List<PraxisIITestScore> getArchivedPraxisIITestScoresForUser(
			User user);

	public abstract int addArchivedPraxisIITestScoreToUser(User user,
			PraxisIITestScore archivedPraxisIITestScore);

}
