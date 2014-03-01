/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.List;

import edu.uky.cepis.domain.Ranking;

/**
 * @author scott
 * 
 */
public interface RankingDao {

	public boolean createRanking(String rankingCode, String title,
			String program);

	public boolean updateRanking(Ranking ranking, String rankingCode,
			String title, String program);

	public boolean deleteRanking(Ranking ranking);

	public Ranking findRankingByCode(String rankingCode);

	public List<Ranking> getRankingList();

	public boolean saveRanking(Ranking ranking);
}
