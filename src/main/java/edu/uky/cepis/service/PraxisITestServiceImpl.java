/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.PraxisITestDao;
import edu.uky.cepis.domain.PraxisITest;

/**
 * @author cawalk4
 */
public class PraxisITestServiceImpl implements PraxisITestService {

	/**
	 * @uml.property name="addressDao"
	 * @uml.associationEnd
	 */
	private PraxisITestDao praxisITestDao;

	@Override
	public List<PraxisITest> getPraxisITests() {
		return this.getPraxisITestDao().getPraxisITests();
	}

	@Override
	public List<PraxisITest> getPraxisITestByCode(String testCode) {
		return this.getPraxisITestDao().getPraxisITestByCode(testCode);
	}
	
	@Override
	public PraxisITest findPraxisITestById(long id){
		return this.getPraxisITestDao().findPraxisITestById(id);
	}

	/**
	 * @return the praxisTestDao
	 */
	public PraxisITestDao getPraxisITestDao() {
		return praxisITestDao;
	}

	/**
	 * @param praxisTestDao
	 *            the praxisTestDao to set
	 */
	public void setPraxisITestDao(PraxisITestDao praxisITestDao) {
		this.praxisITestDao = praxisITestDao;
	}

}
