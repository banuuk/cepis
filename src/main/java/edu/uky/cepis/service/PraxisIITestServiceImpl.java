/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.PraxisIITestDao;
import edu.uky.cepis.domain.PraxisIITest;

/**
 * @author keerthi
 */
public class PraxisIITestServiceImpl implements PraxisIITestService {

	/**
	 * @uml.property name="addressDao"
	 * @uml.associationEnd
	 */
	private PraxisIITestDao praxisIITestDao;

	@Override
	public List<PraxisIITest> getPraxisIITests() {
		return this.getPraxisIITestDao().getPraxisIITests();
	}

	@Override
	public List<PraxisIITest> getPraxisIITestByCode(String testCode) {
		return this.getPraxisIITestDao().getPraxisIITestByCode(testCode);
	}
	
	@Override
	public PraxisIITest findPraxisIITestById(long id){
		return this.getPraxisIITestDao().findPraxisIITestById(id);
	}

	/**
	 * @return the praxisTestDao
	 */
	public PraxisIITestDao getPraxisIITestDao() {
		return praxisIITestDao;
	}

	/**
	 * @param praxisTestDao
	 *            the praxisTestDao to set
	 */
	public void setPraxisIITestDao(PraxisIITestDao praxisIITestDao) {
		this.praxisIITestDao = praxisIITestDao;
	}

}
