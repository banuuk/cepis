/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.domain.PraxisIITest;

/**
 * @author cawalk4
 * 
 */
public interface PraxisIITestService {

	public abstract List<PraxisIITest> getPraxisIITests();
	
	public abstract List<PraxisIITest> getPraxisIITestByCode(String testCode);
	
	public abstract PraxisIITest findPraxisIITestById(long id);
}