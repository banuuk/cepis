/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.domain.component.UKStatus;

/**
 * @author keerthi
 *
 */
public interface UKStatusService {
	public UKStatus createUKStatus(String ukStatusCode,String shortDesc,String description,String status);
	public UKStatus updateUKStatus(UKStatus ukStatus,String ukStatusCode,String shortDesc,String description,String status);
	public boolean deleteUKStatus(UKStatus UKStatus);
	public UKStatus findUKStatusByID(long ukstatusid);
	public UKStatus findUKStatusByCode(String ukStatusCode);
	public List<UKStatus> getUKStatusList();
	public boolean saveUKStatus(UKStatus ukStatus);
}
