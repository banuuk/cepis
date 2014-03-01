

package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.ApplicationStatusDao;
import edu.uky.cepis.domain.ApplicationStatus;

/**
 * @author cawalk4
 *
 */
public class ApplicationStatusServiceImpl implements ApplicationStatusService{
	
	private ApplicationStatusDao applicationStatusDao;
	
	@Override
	public ApplicationStatus findApplicationStatusByCode(String code) {
		return getApplicationStatusDao().findApplicationStatusByCode(code);
	}

	@Override
	public List<ApplicationStatus> getApplicationStatusList() {
		return getApplicationStatusDao().getApplicationStatusList();
	}

	public ApplicationStatusDao getApplicationStatusDao() {
		return applicationStatusDao;
	}

	public void setApplicationStatusDao(ApplicationStatusDao applicationStatusDao) {
		this.applicationStatusDao = applicationStatusDao;
	}		
}