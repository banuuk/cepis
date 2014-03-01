/**
 * 
 */
package edu.uky.cepis.service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import edu.uky.cepis.domain.Ethnic;
import edu.uky.cepis.domain.Event;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public interface EthnicService {

	public abstract Ethnic updateEthnic(Ethnic ethnic, String code,
			String ethnicity, String kyEthnicCode);

	public abstract Ethnic createEthnic(String code, String ethnicity,
			String kyEthnicCode);

	public abstract boolean deleteEthnic(Ethnic ethnic);

	public abstract Ethnic findByEthnicCode(String code);

	public boolean saveEthnic(Ethnic ethnic);

	public List<Ethnic> getEthnicList();

}
