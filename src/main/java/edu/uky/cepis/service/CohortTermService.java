/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import edu.uky.cepis.domain.CohortTerm;

/**
 * @author keerthi
 *
 */
public interface CohortTermService {
	public CohortTerm createCohortTerm(int termCode,String shortDesc,String description);
	public CohortTerm updateCohortTerm(CohortTerm cohortTerm,int termCode,String shortDesc,String descriptiont);
	public boolean deleteCohortTerm(CohortTerm cohortTerm);
	public CohortTerm findCohortTermByCode(int termCode);
	public List<CohortTerm> getCohortTermList();
	public boolean saveCohortTerm(CohortTerm cohortTerm);

}
