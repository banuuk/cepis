

package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.TepAdmissionDao;
import edu.uky.cepis.domain.TepAdmission;
import edu.uky.cepis.domain.User;

public class TepAdmissionServiceImpl implements TepAdmissionService{
	
	private TepAdmissionDao tepAdmissionDao;
		
	@Override
	public TepAdmission findTepAdmissionById(long id) {	
		return getTepAdmissionDao().findTepAdmissionById(id);
	}

	@Override
	public boolean saveOrUpdateTepAdmission(TepAdmission tepAdmission) {
		return getTepAdmissionDao().saveOrUpdateTepAdmission(tepAdmission);
	}

	@Override
	public boolean deleteTepAdmission(TepAdmission tepAdmission) {		
		return getTepAdmissionDao().deleteTepAdmission(tepAdmission);
	}

	@Override
	public List<TepAdmission> getTepAdmissionByExample(TepAdmission tepAdmission) {
		return getTepAdmissionDao().getTepAdmissionByExample(tepAdmission);
	}
	
	@Override
	public List<TepAdmission> getTepAdmissionForUser(User user){
		return getTepAdmissionDao().getTepAdmissionForUser(user);
	}

	public TepAdmissionDao getTepAdmissionDao() {
		return tepAdmissionDao;
	}

	public void setTepAdmissionDao(TepAdmissionDao tepAdmissionDao) {
		this.tepAdmissionDao = tepAdmissionDao;
	}

	
	
		
}