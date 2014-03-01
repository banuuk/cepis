/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import java.util.Set;
import edu.uky.cepis.dao.PhoneDao;
import edu.uky.cepis.domain.Phone;
import edu.uky.cepis.domain.PhoneType;
import edu.uky.cepis.domain.User;

/**
 * @author  keerthi
 */
public class PhoneServiceImpl implements PhoneService {

	/**
	 * @uml.property  name="phoneDao"
	 * @uml.associationEnd  
	 */
	private PhoneDao phoneDao;

	/**
	 * @param phoneDao  the phoneDao to set
	 * @uml.property  name="phoneDao"
	 */
	public void setPhoneDao(PhoneDao phoneDao) {
		this.phoneDao = phoneDao;
	}

	/**
	 * @return  the phoneDao
	 * @uml.property  name="phoneDao"
	 */
	public PhoneDao getPhoneDao() {
		return phoneDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.PhoneService#findById(long)
	 */
	@Override
	public Phone findById(long id) {
		return this.getPhoneDao().findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.PhoneService#findByPhoneNo(java.lang.String)
	 */
	@Override
	public Phone findByPhoneNo(String phoneNo) {
		return this.getPhoneDao().findByPhoneNo(phoneNo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.PhoneService#findByPhoneNoAndExt(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Phone findByPhoneNoAndExt(String phoneNo, String ext) {
		return this.getPhoneDao().findByPhoneNoAndExt(phoneNo, ext);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.PhoneService#removePhoneFromUser(edu.uky.cepis.
	 * domain.User, edu.uky.cepis.domain.Phone)
	 */
	@Override
	public boolean removePhoneFromUser(User user, Phone phone) {
		return this.getPhoneDao().removePhoneFromUser(user, phone);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.PhoneService#savePhone(edu.uky.cepis.domain.Phone)
	 */
	@Override
	public boolean savePhone(Phone phone) {
		return this.getPhoneDao().savePhone(phone);
	}

	@Override
	public boolean addPhoneToUser(User user, String phoneNo, String ext,
			String memo, PhoneType phoneType) {

		return this.getPhoneDao().addPhoneToUser(user, phoneNo, ext, memo,
				phoneType);
	}

	@Override
	public Phone updatePhone(User user, Phone phone, String phoneNo,
			String ext, String memo, PhoneType phoneType) {

		return this.getPhoneDao().updatePhone(user, phone, phoneNo, ext, memo,
				phoneType);
	}

	@Override
	public List<Phone> getPhoneList(User user) {
		return this.getPhoneDao().getPhoneList(user);
	}

}
