/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import edu.uky.cepis.domain.Phone;
import edu.uky.cepis.domain.PhoneType;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public interface PhoneService {
	public abstract Phone updatePhone(User user, Phone phone, String phoneNo,
			String ext, String memo, PhoneType phoneType);

	public abstract Phone findById(long id);

	public abstract Phone findByPhoneNo(String phoneNo);

	public abstract Phone findByPhoneNoAndExt(String phoneNo, String ext);

	public boolean savePhone(Phone phone);

	public boolean addPhoneToUser(User user, String phoneNo, String ext,
			String memo, PhoneType phoneType);

	public boolean removePhoneFromUser(User user, Phone phone);

	public List<Phone> getPhoneList(User user);
	
}
