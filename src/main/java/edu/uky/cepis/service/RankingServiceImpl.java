/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.RankingDao;
import edu.uky.cepis.domain.Ranking;

/**
 * @author  scott
 */
public class RankingServiceImpl implements RankingService {

	/**
	 * @uml.property  name="rankingDao"
	 * @uml.associationEnd  
	 */
	private RankingDao rankingDao;

	/**
	 * @return  the rankingDao
	 * @uml.property  name="rankingDao"
	 */
	public final RankingDao getRankingDao() {
		return rankingDao;
	}

	/**
	 * @param rankingDao  the rankingDao to set
	 * @uml.property  name="rankingDao"
	 */
	public final void setRankingDao(RankingDao rankingDao) {
		this.rankingDao = rankingDao;
	}

	@Override
	public boolean createRanking(String rankingCode, String title,
			String program) {
		return this.getRankingDao().createRanking(rankingCode, title, program);
	}

	@Override
	public boolean updateRanking(Ranking ranking, String rankingCode,
			String title, String program) {
		return this.getRankingDao().updateRanking(ranking, rankingCode, title, program);
	}

	@Override
	public boolean deleteRanking(Ranking ranking) {
		return this.getRankingDao().deleteRanking(ranking);
	}

	@Override
	public Ranking findRankingByCode(String rankingCode) {
		return this.getRankingDao().findRankingByCode(rankingCode);
	}

	@Override
	public List<Ranking> getRankingList() {
		return this.getRankingDao().getRankingList();
	}

	@Override
	public boolean saveRanking(Ranking ranking) {
		return this.getRankingDao().saveRanking(ranking);
	}

	
	 
}
