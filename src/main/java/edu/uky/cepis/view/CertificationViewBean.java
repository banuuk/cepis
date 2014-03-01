package edu.uky.cepis.view;

import java.util.Date;
import java.util.List;

import edu.uky.cepis.domain.Address;
import edu.uky.cepis.domain.AddressType;
import edu.uky.cepis.domain.Certification;
import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.EmailAddressType;
import edu.uky.cepis.domain.Fee;
import edu.uky.cepis.domain.Phone;
import edu.uky.cepis.domain.PhoneType;
import edu.uky.cepis.domain.PraxisIITestScore;
import edu.uky.cepis.domain.Ranking;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserProgramProfile;
import edu.uky.cepis.domain.embeddedId.FeePK;



/**
 * @author cawalk4
 *
 */
public class CertificationViewBean extends CepisWebView implements  CertificationView {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public boolean addCertificationToUser(User user,
			UserProgramProfile programProfile, Ranking ranking, String status,
			String states, Date initialDate, Date completeDate, String memo) {
		return this.getCertificationService().addCertificationToUser(user,
				programProfile, ranking, status, states, initialDate,
				completeDate, memo);
	}

	@Override
	public boolean removeCertificationFromUser(User user,
			Certification certification) {
		return this.getCertificationService().removeCertificationFromUser(user,
				certification);
	}

	@Override
	public boolean updateCertification(User user, Certification certification,
			UserProgramProfile programProfile, Ranking ranking, String status,
			String states, Date completeDate, String memo) {
		return this.getCertificationService().updateCertification(user,
				certification, programProfile, ranking, status, states,
				completeDate, memo);
	}

	@Override
	public List<Certification> getCertificationList(User user) {
		return this.getCertificationService().getCertificationList(user);
	}
	
	@Override
	public List<Object> getOldCertificates(User user) {
		return this.getCertificationService().getOldCertificates(user);
	}

	@Override
	public List<PraxisIITestScore> getPraxisIITestScoreList(User user) {
		return getPraxisIITestScoreService().getPraxisIITestScoreList(user);
	}

	@Override
	public PraxisIITestScore findPraxisIITestScoreById(long id) {
		return getPraxisIITestScoreService().findPraxisIITestScoreById(id);
	}

	@Override
	public Fee findFeeById(FeePK id) {
		return getFeeService().findFeeById(id);
	}

	@Override
	public List<Fee> findFeeByExample(Fee fee) {
		return getFeeService().findFeeByExample(fee);
	}

	@Override
	public boolean saveOrUpdateFee(Fee fee) {
		return getFeeService().saveOrUpdateFee(fee);
	}

	@Override
	public boolean deleteFee(Fee fee) {
		return getFeeService().deleteFee(fee);
	}
	
	@Override
	public List<UserProgramProfile> getUserProgramProfiles(User user) {
		return this.getUserProgramProfileService().getUserProgramProfiles(user);
	}
	
	@Override
	public boolean addEmailAddressToUserAccount(User user, String address, EmailAddressType type) {
		return this.getEmailAddressService().addEmailAddressToUser(user, address, type);
	}
	
	@Override
	public List<EmailAddress> getEmailAddressList(User user) {
		return this.getEmailAddressService().getEmailAddresses(user);
	}
	
	@Override
	public boolean removeEmailAddressFromUserAccount(User user,
			EmailAddress emailAddress) {
		return this.getEmailAddressService().removeEmailAddressFromUser(user,
				emailAddress);
	}
	
	@Override
	public boolean updateEmailAddressDetails(User user,
			EmailAddress emailAddress, String address, EmailAddressType type) {
		if (this.getEmailAddressService().updateEmailAddress(user,
				emailAddress, address, type) != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Address> getAddressList(User user) {
		return this.getAddressService().getAddressList(user);
	}

	@Override
	public boolean updateAddressDetails(User user, Address address,
			String street1, String street2, String city, String state,
			String zip, String country, AddressType addressType) {
		if (this.getAddressService().updateAddress(user, address, street1,
				street2, city, state, zip, country, addressType) != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean removeAddressFromUserAccount(User user, Address address) {
		return this.getAddressService().removeAddressFromUser(user, address);
	}
	
	@Override
	public boolean addAddressToUserAccount(User user, String street1,
			String street2, String city, String state, String zip,
			String country, AddressType addressType) {
		return this.getAddressService().addAddressToUser(user, street1,
				street2, city, state, zip, country, addressType);
	}
	
	@Override
	public boolean updatePhoneDetails(User user, Phone phone, String phoneNo,
			String ext, String memo, PhoneType phoneType) {
		if (this.getPhoneService().updatePhone(user, phone, phoneNo, ext, memo,
				phoneType) != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public List<Phone> getPhoneList(User user) {
		return this.getPhoneService().getPhoneList(user);
	}
	
	@Override
	public boolean removePhoneFromUserAccount(User user, Phone phone) {
		return this.getPhoneService().removePhoneFromUser(user, phone);
	}
	
	@Override
	public boolean addPhoneToUserAccount(User user, String phoneNo, String ext,
			String memo, PhoneType phoneType) {
		return this.getPhoneService().addPhoneToUser(user, phoneNo, ext, memo,
				phoneType);
	}

}