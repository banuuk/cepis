/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.List;
import java.util.Set;

import edu.uky.cepis.domain.Ethnic;
import edu.uky.cepis.domain.Phone;
import edu.uky.cepis.domain.PhoneType;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public interface EthnicDao {

	public abstract Ethnic updateEthnic(Ethnic ethnic, String code,
			String ethnicity, String kyEthnicCode);

	public abstract Ethnic createEthnic(String code, String ethnicity,
			String kyEthnicCode);

	public abstract boolean deleteEthnic(Ethnic ethnic);

	public abstract Ethnic findByEthnicCode(String code);

	public boolean saveEthnic(Ethnic ethnic);

	public List<Ethnic> getEthnicList();

}
