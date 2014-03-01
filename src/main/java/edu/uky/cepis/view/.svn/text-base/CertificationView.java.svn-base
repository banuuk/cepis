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

public interface CertificationView{
	

	/***************************Certification***************************/
	public abstract boolean addCertificationToUser(User user,
	UserProgramProfile programProfile, Ranking ranking, String status,
	String states, Date initialDate, Date completeDate, String memo);

	public abstract boolean removeCertificationFromUser(User user,
	Certification certification);

	public abstract boolean updateCertification(User user,
	Certification certification, UserProgramProfile programProfile,
	Ranking ranking, String status, String states, Date completeDate,
	String memo);

	public abstract List<Certification> getCertificationList(User user);
	
	public abstract List<Object> getOldCertificates(User user);
		
	/***************************PraxisII***************************/
	public abstract List<PraxisIITestScore> getPraxisIITestScoreList(User user);

	public abstract PraxisIITestScore findPraxisIITestScoreById(long id);

	/***************************FEES***************************/	
	public abstract Fee findFeeById(FeePK id);
	
	public abstract List<Fee> findFeeByExample(Fee fee);
	
	public abstract boolean saveOrUpdateFee(Fee fee);
	
	public abstract boolean deleteFee(Fee fee);

	/***************************USER PROGRAM PROFILE***************************/	
	public List<UserProgramProfile> getUserProgramProfiles(User user);
	
	/***************************EMAIL ADDRESS***************************/	
	public boolean addEmailAddressToUserAccount(User user, String address, EmailAddressType type);
	
	public List<EmailAddress> getEmailAddressList(User user);
	
	public boolean removeEmailAddressFromUserAccount(User user,	EmailAddress emailAddress);
	
	public boolean updateEmailAddressDetails(User user,
	EmailAddress emailAddress, String address, EmailAddressType type);
	
	/***************************ADDRESS***************************/	
	public List<Address> getAddressList(User user);
	
	public boolean updateAddressDetails(User user, Address address,
	String street1, String street2, String city, String state,
	String zip, String country, AddressType addressType);
	
	public boolean removeAddressFromUserAccount(User user, Address address);
	
	public boolean addAddressToUserAccount(User user, String street1,
	String street2, String city, String state, String zip,
	String country, AddressType addressType);

	/***************************PHONE***************************/
	public boolean updatePhoneDetails(User user, Phone phone, String phoneNo,
	String ext, String memo, PhoneType phoneType);
	
	public abstract List<Phone> getPhoneList(User user);
	
	public boolean removePhoneFromUserAccount(User user, Phone phone);

	public abstract boolean addPhoneToUserAccount(User user, String phoneNo,
	String ext, String memo, PhoneType phoneType);

}