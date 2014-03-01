/**
 * 
 */
package edu.uky.cepis.util.batch;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;

import edu.uky.cepis.dao.PraxisIITestScoreDaoImpl;
import edu.uky.cepis.domain.PraxisIITestScore;
import edu.uky.cepis.service.PraxisIITestScoreService;


/**
 * @author cawalk4
 * 
 */
public class PraxisTestScoresBatchWriter implements
		ItemWriter<List<PraxisIITestScore>> {

	private static Logger log = Logger.getLogger(PraxisIITestScoreDaoImpl.class);
	private PraxisIITestScoreService praxisIITestScoreService;

	public PraxisTestScoresBatchWriter() {
	}

	@Override
	public void write(List<? extends List<PraxisIITestScore>> praxisIITestScoreLists)
			throws Exception {
		log.debug("Calling PraxisTestScore ItemWriter ...");
		for (List<PraxisIITestScore> praxisIITestScores : praxisIITestScoreLists) {
			for (PraxisIITestScore praxisIITestScore : praxisIITestScores) {
				if (praxisIITestScore.getUser() == null) {
					log.debug("Orphan PraxisTestScore Record found, No valid user object associated with this record: "
							+ praxisIITestScore.getCandidateId());
				}
				if (praxisIITestScore.isArchived()) {
					log.debug("Adding PraxisTestScore: "
							+ praxisIITestScore.getCandidateId()
							+ " to Archived PraxisTestScore table ...");
					// Add to tblPraxisArchive
					this.getPraxisIITestScoreService()
							.addArchivedPraxisIITestScoreToUser(
									praxisIITestScore.getUser(), praxisIITestScore);
				} else {
					log.debug("Adding PraxisTestScore: "
							+ praxisIITestScore.getCandidateId()
							+ " to PraxisTestScore table ...");
					// Add to tblPraxis
					this.getPraxisIITestScoreService().addPraxisIITestScoreToUser(
							praxisIITestScore.getUser(), praxisIITestScore);
				}
				log.debug(praxisIITestScore.getCandidateId() + ", "
						+ praxisIITestScore.getScore());
			}
		}
	}


	/**
	 * @return the testScoreService
	 */
	public PraxisIITestScoreService getPraxisIITestScoreService() {
		return praxisIITestScoreService;
	}

	/**
	 * @param testScoreService
	 *            the testScoreService to set
	 */
	public void setPraxisIITestScoreService(PraxisIITestScoreService praxisIITestScoreService) {
		this.praxisIITestScoreService = praxisIITestScoreService;
	}

}
