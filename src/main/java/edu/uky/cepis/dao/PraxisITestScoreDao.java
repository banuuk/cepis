/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.Date;
import java.util.List;

import edu.uky.cepis.domain.PraxisITest;
import edu.uky.cepis.domain.PraxisITestScore;
import edu.uky.cepis.domain.User;

/**
 * @author cawalk4
 * 
 */
public interface PraxisITestScoreDao {

	public abstract boolean addPraxisITestScoreToUser(User user,
			PraxisITestScore praxisTestScore);

	public abstract boolean addPraxisITestScoreToUser(User user, Date testDate,
			PraxisITest praxisTest, double score,
			int primary);

	public abstract PraxisITestScore findPraxisITestScoreById(long id);

	public abstract List<PraxisITestScore> getPraxisITestScores(User user);

	public boolean removePraxisITestScoreFromUser(User user,
			PraxisITestScore praxisTestScore);

	public abstract PraxisITestScore updatePraxisITestScore(User user,
			PraxisITestScore praxisTestScore, Date testDate,
			PraxisITest praxisTest,String candidateId, double score, int primary);

}
