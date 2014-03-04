/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.Date;
import java.util.List;

import org.apache.cxf.service.invoker.SessionFactory;
import org.apache.log4j.Logger;

import edu.uky.cepis.domain.Phone;
import edu.uky.cepis.domain.PhoneType;
import edu.uky.cepis.domain.PraxisITest;
import edu.uky.cepis.domain.PraxisIdentity;
import edu.uky.cepis.domain.Role;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.component.Program;

/**
 * @author cawalk4
 * 
 */
public class PraxisIdentityDaoImpl implements PraxisIdentityDao {
	
	private static Logger log = Logger.getLogger(UserDaoImpl.class);
	private SessionFactory sessionFactory;
	private Role reportUserRole = null;

	
	public PraxisIdentity addPraxisIdentity(String candidateID, String ssn,
	String lName, String fName, String address, String city, String zip, String state, Date dOB){
		PraxisIdentity identity = new PraxisIdentity(
				(candidateID == null) ? null : candidateID.trim(),
				(ssn == null || ssn.isEmpty()
						|| ssn.equalsIgnoreCase("123456789") || ssn
						.equalsIgnoreCase("999999999")) ? "000000000" : ssn
						.trim(),
				(lName == null) ? null : lName.trim(),
				(fName == null) ? null : fName.trim(),
				(address == null) ? null : address.trim(),
				(city == null) ? null : city.trim(),
				(zip == null) ? null : zip.trim(),
				(state == null) ? null : state.trim(), dOB);
		if (identity == null) {
			log.debug("cannot create user object. user object is null.");
			return null;
		}
		if (!this.savePraxisIdentity(identity)) {
			log.debug("Error in saving identity object.");
			return null;
		}
		return identity;
	}
	
	public PraxisIdentity createPraxisIdentity(String candidateID, String ssn,
			String lName, String fName, String address, String city, String zip, String state, Date dOB){
		PraxisIdentity praxisIdentity = new PraxisIdentity(candidateID, ssn, lName, fName, address, city, zip, state, dOB);
		if (praxisIdentity == null) {
			return praxisIdentity;
		}
		if (!this.savePraxisIdentity(praxisIdentity)) {
			return null;
		}
		return praxisIdentity;
	}
	
	public PraxisIdentity createPraxisIdentity(PraxisIdentity identity){
		if (identity == null) {
			return identity;
		}
		if (!this.savePraxisIdentity(identity)) {
			return null;
		}
		return identity;
	}
	
	public User updatePraxisIdentity(String candidateID, String ssn,
			String lName, String fName, String address, String city, String zip, String state, Date dOB){
		;
		return null;
	}
	
	public boolean removePraxisIdentity(PraxisIdentity praxisIdentity){
		;
		return false;
	}

	public PraxisIdentity findByCandidateId(String candidateID){
		;
		return null;
	}

	@Override
	public boolean savePraxisIdentity(PraxisIdentity praxisIdentity) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(praxisIdentity);
		return true;
	}
	
	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
