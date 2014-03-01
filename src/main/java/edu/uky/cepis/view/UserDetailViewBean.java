/**
 * 
 */
package edu.uky.cepis.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.uky.cepis.domain.Address;
import edu.uky.cepis.domain.AddressType;
import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.AdvisorGroup;
import edu.uky.cepis.domain.EmailAddressType;
import edu.uky.cepis.domain.PhoneType;
import edu.uky.cepis.domain.Role;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.component.UKMajor;
import edu.uky.cepis.domain.component.UKStatus;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author keerthi
 * 
 */
public class UserDetailViewBean extends CepisWebView implements UserDetailView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDetailViewBean() {

	}

	@Override
	public boolean addAdvisorWrapToUser(User user) {
		return this.getAdvisorService().addAdvisorWrapToUser(user);
	}

	@Override
	public AddressType createAddressType(String code, String shortDesc) {
		return this.getAddressTypeService().createAddressType(code, shortDesc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.view.UserDetailView#createAdvisor(edu.uky.cepis.domain.
	 * User, java.lang.String)
	 */
	@Override
	public boolean createAdvisor(User user, String shortDesc) {
		return this.getAdvisorService().addAdvisorWrapToUser(user);

	}

	@Override
	public EmailAddressType createEmailAddressType(String code, String shortDesc) {
		return this.getEmailAddressTypeService().createEmailAddressType(code,
				shortDesc);
	}

	@Override
	public PhoneType createPhoneType(String code, String shortDesc) {
		return this.getPhoneTypeService().createPhoneType(code, shortDesc);
	}

	@Override
	public Role createRole(String rolename, String roledesc, String otherInfo) {
		return this.getRoleservice().createRole(rolename, roledesc, otherInfo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.view.UserDetailView#createUKMajor(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean createUKMajor(String ukMajorCode, String shortDesc,
			String description, String status, String degreeLevel) {
		if (this.getUkMajorService().createUKMajor(ukMajorCode, shortDesc,
				description, status, degreeLevel) == null) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.view.UserDetailView#createUKStatus(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean createUKStatus(String statusCode, String shortDesc,
			String description, String status) {
		if (this.getUkStatusService().createUKStatus(statusCode, shortDesc,
				description, status) == null) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.view.UserDetailView#createUKTerm(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean createUKTerm(String ukTermCode, String shortDesc,
			String description, String status) {
		if (this.getUkTermService().createUKTerm(ukTermCode, shortDesc,
				description, status) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteAddressType(AddressType addressType) {
		return this.getAddressTypeService().deleteAddressType(addressType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.view.UserDetailView#deleteAdvisor(edu.uky.cepis.domain.
	 * Advisor)
	 */
	@Override
	public boolean deleteAdvisor(Advisor selectedAdvisor) {
		return this.getAdvisorService().removeAdvisorWrapFromUser(
				selectedAdvisor);
	}

	@Override
	public boolean deleteEmailAddressType(EmailAddressType emailAddressType) {
		return this.getEmailAddressTypeService().deleteEmailAddressType(
				emailAddressType);
	}

	@Override
	public boolean deletePhoneType(PhoneType phoneType) {
		return this.getPhoneTypeService().deletePhoneType(phoneType);
	}

	@Override
	public boolean deleteRole(Role role) {
		return this.getRoleservice().deleteRole(role);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.view.UserDetailView#deleteUKMajor(edu.uky.cepis.domain.
	 * UKMajor)
	 */
	@Override
	public boolean deleteUKMajor(UKMajor selectedUKMajor) {
		return this.getUkMajorService().deleteUKMajor(selectedUKMajor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.view.UserDetailView#deleteUKStatus(edu.uky.cepis.domain
	 * .UKStatus)
	 */
	@Override
	public boolean deleteUKStatus(UKStatus selectedUKStatus) {
		return this.getUkStatusService().deleteUKStatus(selectedUKStatus);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.view.UserDetailView#deleteUKTerm(edu.uky.cepis.domain.UKTerm
	 * )
	 */
	@Override
	public boolean deleteUKTerm(UKTerm selectedUKTerm) {
		return this.getUkTermService().deleteUKTerm(selectedUKTerm);
	}

	@Override
	public boolean editAddressType(AddressType selectedAddressType,
			String code, String shortDesc) {

		if (this.getAddressTypeService().updateAddressType(selectedAddressType,
				code, shortDesc) != null) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.view.UserDetailView#editAdvisorDetails(edu.uky.cepis.domain
	 * .User, java.lang.String)
	 */
	@Override
	public boolean editAdvisorDetails(Advisor advisor, String shortDesc) {
		return this.getAdvisorService().updateAdvisor(advisor, shortDesc);
	}

	@Override
	public boolean editAdvisorStatus(Advisor advisor, String status, Address officeLocation) {
		return this.getAdvisorService().updateAdvisorStatus(advisor, status, officeLocation);
	}

	@Override
	public boolean editEmailAddressType(
			EmailAddressType selectedEmailAddressType, String code,
			String shortDesc) {
		if (this.getEmailAddressTypeService().updateEmailAddressType(
				selectedEmailAddressType, code, shortDesc) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean editPhoneType(PhoneType selectedPhoneType, String code,
			String shortDesc) {
		if (this.getPhoneTypeService().updatePhoneType(selectedPhoneType, code,
				shortDesc) != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public List<Address> getAddressList(Advisor advisor) {
		User user = this.getAdvisorService().getUser(advisor);
		if(user == null){
			return new ArrayList<Address>(0);
		}
		return this.getAddressService().getAddressList(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.view.UserDetailView#editUKMajor(edu.uky.cepis.domain.UKMajor
	 * , java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean editUKMajor(UKMajor selectedUKMajor, String ukMajorCode,
			String shortDesc, String description, String status,
			String degreeLevel) {
		if (this.getUkMajorService().updateUKMajor(selectedUKMajor,
				ukMajorCode, shortDesc, description, status, degreeLevel) == null) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.view.UserDetailView#editUKStatus(edu.uky.cepis.domain.UKStatus
	 * , java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean editUKStatus(UKStatus selectedUKStatus, String statusCode,
			String shortDesc, String description, String status) {
		if (this.getUkStatusService().updateUKStatus(selectedUKStatus,
				statusCode, shortDesc, description, status) == null) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.view.UserDetailView#editUKTerm(edu.uky.cepis.domain.UKTerm,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean editUKTerm(UKTerm selectedUKTerm, String ukTermCode,
			String shortDesc, String description, String status) {
		if (this.getUkTermService().updateUKTerm(selectedUKTerm, ukTermCode,
				shortDesc, description, status) == null) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.view.UserDetailView#getAdvisorList()
	 */
	@Override
	public List<Advisor> getAdvisorList() {

		return this.getAdvisorService().getAdvisorList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.view.UserDetailView#getUKMajorList()
	 */
	@Override
	public List<UKMajor> getUKMajorList() {

		return this.getUkMajorService().getUKMajorList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.view.UserDetailView#getUKStatusList()
	 */
	@Override
	public List<UKStatus> getUKStatusList() {

		return this.getUkStatusService().getUKStatusList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.view.UserDetailView#getUKTermList()
	 */
	@Override
	public List<UKTerm> getUKTermList() {

		return this.getUkTermService().getUKTermList();
	}

	@Override
	public Role updateRole(Role newRole, String rolename, String roledesc,
			String otherInfo) {
		return this.getRoleservice().updateRole(newRole, rolename, roledesc,
				otherInfo);
	}
	
	@Override
	public boolean addAdvisorToGroup(AdvisorGroup advisorGroup, Advisor advisor) {
		return this.getAdvisorService()
				.addAdvisorToGroup(advisorGroup, advisor);
	}
	
	@Override
	public boolean removeAdvisorFromGroup(AdvisorGroup advisorGroup,
			Advisor advisor) {
		return this.getAdvisorService().removeAdvisorFromGroup(advisorGroup,
				advisor);
	}

}
