/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.CohortTermDao;
import edu.uky.cepis.dao.UKTermDao;
import edu.uky.cepis.domain.CohortTerm;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author  keerthi
 */
public class CohortTermServiceImpl implements CohortTermService {

	/**
	 * @uml.property  name="cohortTermDao"
	 * @uml.associationEnd  
	 */
	private CohortTermDao cohortTermDao;

	/**
	 * @return  the cohortTermDao
	 * @uml.property  name="cohortTermDao"
	 */
	public CohortTermDao getCohortTermDao() {
		return cohortTermDao;
	}

	/**
	 * @param cohortTermDao  the cohortTermDao to set
	 * @uml.property  name="cohortTermDao"
	 */
	public void setCohortTermDao(CohortTermDao cohortTermDao) {
		this.cohortTermDao = cohortTermDao;
	}

	@Override
	public CohortTerm createCohortTerm(int termCode, String shortDesc,
			String description) {

		return this.getCohortTermDao().createCohortTerm(termCode, shortDesc,
				description);
	}

	@Override
	public boolean deleteCohortTerm(CohortTerm cohortTerm) {

		return this.getCohortTermDao().deleteCohortTerm(cohortTerm);
	}

	@Override
	public CohortTerm findCohortTermByCode(int termCode) {

		return this.getCohortTermDao().findCohortTermByCode(termCode);
	}

	@Override
	public List<CohortTerm> getCohortTermList() {

		return this.getCohortTermDao().getCohortTermList();
	}

	@Override
	public boolean saveCohortTerm(CohortTerm cohortTerm) {

		return this.getCohortTermDao().saveCohortTerm(cohortTerm);
	}

	@Override
	public CohortTerm updateCohortTerm(CohortTerm cohortTerm, int termCode,
			String shortDesc, String descriptiont) {

		return this.getCohortTermDao().updateCohortTerm(cohortTerm, termCode,
				shortDesc, descriptiont);
	}

}
