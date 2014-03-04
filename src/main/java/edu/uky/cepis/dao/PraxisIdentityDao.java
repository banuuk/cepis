/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.Date;
import java.util.List;

import edu.uky.cepis.domain.Phone;
import edu.uky.cepis.domain.PhoneType;
import edu.uky.cepis.domain.PraxisITest;
import edu.uky.cepis.domain.PraxisIdentity;
import edu.uky.cepis.domain.User;

/**
 * @author cawalk4
 * 
 */
public interface PraxisIdentityDao {

	
	public abstract PraxisIdentity addPraxisIdentity(String candidateID, String ssn,
			String lName, String fName, String address, String city, String zip, String state, Date dOB);
	
	public abstract PraxisIdentity createPraxisIdentity(String candidateID, String ssn,
			String lName, String fName, String address, String city, String zip, String state, Date dOB);
	
	public abstract User updatePraxisIdentity(String candidateID, String ssn,
			String lName, String fName, String address, String city, String zip, String state, Date dOB);
	
	public abstract boolean removePraxisIdentity(PraxisIdentity praxisIdentity);

	public abstract PraxisIdentity findByCandidateId(String candidateID);
	
	public boolean savePraxisIdentity(PraxisIdentity praxisIdentity);

}
