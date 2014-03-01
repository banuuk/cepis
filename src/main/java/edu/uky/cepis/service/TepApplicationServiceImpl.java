

package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.TepApplicationDao;
import edu.uky.cepis.domain.TepApplication;
import edu.uky.cepis.domain.User;

public class TepApplicationServiceImpl implements TepApplicationService{
	
	private TepApplicationDao tepApplicationDao;
		
	@Override
	public TepApplication findTepApplicationById(long id) {	
		return getTepApplicationDao().findTepApplicationById(id);
	}

	@Override
	public boolean saveOrUpdateTepApplication(TepApplication tepApplication) {
		return getTepApplicationDao().saveOrUpdateTepApplication(tepApplication);
	}

	@Override
	public boolean deleteTepApplication(TepApplication tepAdmission) {		
		return getTepApplicationDao().deleteTepApplication(tepAdmission);
	}

	@Override
	public List<TepApplication> getTepApplicationByExample(TepApplication tepApplication) {
		return getTepApplicationDao().getTepApplicationByExample(tepApplication);
	}
	
	@Override
	public List<TepApplication> getTepApplicationForUser(User user) {
		return getTepApplicationDao().getTepApplicationForUser(user);
	}

	public TepApplicationDao getTepApplicationDao() {
		return tepApplicationDao;
	}

	public void setTepApplicationDao(TepApplicationDao tepApplicationDao) {
		this.tepApplicationDao = tepApplicationDao;
	}
}