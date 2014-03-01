/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.List;

import edu.uky.cepis.domain.CohortTerm;

/**
 * @author keerthi
 *
 */
public interface CohortTermDao {
	public CohortTerm createCohortTerm(int termCode,String shortDesc,String description);
	public CohortTerm updateCohortTerm(CohortTerm cohortTerm,int termCode,String shortDesc,String descriptiont);
	public boolean deleteCohortTerm(CohortTerm cohortTerm);
	public CohortTerm findCohortTermByCode(int termCode);
	public List<CohortTerm> getCohortTermList();
	public boolean saveCohortTerm(CohortTerm cohortTerm);

}
