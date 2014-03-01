/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.List;

import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author keerthi
 *
 */
public interface UKTermDao {
	public UKTerm createUKTerm(String ukTermCode,String shortDesc,String description,String status);
	public UKTerm updateUKTerm(UKTerm ukTerm,String ukTermCode,String shortDesc,String description,String status);
	public boolean deleteUKTerm(UKTerm UKTerm);
	public UKTerm findUKTermByID(long uktermid);
	public UKTerm findUKTermByCode(String ukTermCode);
	public List<UKTerm> getUKTermList();
	public boolean saveUKTerm(UKTerm ukTerm);

}
