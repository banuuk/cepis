/**
 * 
 */
package edu.uky.cepis.view;

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
public interface UserDetailView {
	public boolean addAdvisorWrapToUser(User user);

	public AddressType createAddressType(String code, String shortDesc);

	public boolean createAdvisor(User user, String shortDesc);

	public EmailAddressType createEmailAddressType(String code, String shortDesc);

	public PhoneType createPhoneType(String code, String shortDesc);

	public Role createRole(String rolename, String roledesc, String otherInfo);

	public boolean createUKMajor(String ukMajorCode, String shortDesc,
			String description, String status, String degreeLevel);

	public boolean createUKStatus(String statusCode, String shortDesc,
			String description, String status);

	public boolean createUKTerm(String ukTermCode, String shortDesc,
			String description, String status);

	boolean deleteAddressType(AddressType addressType);

	public boolean deleteAdvisor(Advisor selectedAdvisor);

	boolean deleteEmailAddressType(EmailAddressType emailAddressType);

	boolean deletePhoneType(PhoneType phoneType);

	public boolean deleteRole(Role role);

	public boolean deleteUKMajor(UKMajor selectedUKMajor);

	public boolean deleteUKStatus(UKStatus selectedUKStatus);

	public boolean deleteUKTerm(UKTerm selectedUKTerm);

	public boolean editAddressType(AddressType selectedAddressType,
			String code, String shortDesc);

	public boolean editAdvisorDetails(Advisor advisor, String shortDesc);


	public boolean editEmailAddressType(
			EmailAddressType selectedEmailAddressType, String code,
			String shortDesc);

	public boolean editPhoneType(PhoneType selectedPhoneType, String code,
			String shortDesc);

	public boolean editUKMajor(UKMajor selectedUKMajor, String ukMajorCode,
			String shortDesc, String description, String status,
			String degreeLevel);

	public boolean editUKStatus(UKStatus selectedUKStatus, String statusCode,
			String shortDesc, String description, String status);

	public boolean editUKTerm(UKTerm selectedUKTerm, String ukTermCode,
			String shortDesc, String description, String status);

	public List<Advisor> getAdvisorList();

	public List<UKMajor> getUKMajorList();

	public List<UKStatus> getUKStatusList();

	public List<UKTerm> getUKTermList();

	public Role updateRole(Role newRole, String rolename, String roledesc,
			String otherInfo);

	boolean editAdvisorStatus(Advisor advisor, String status,
			Address officeLocation);
	public abstract List<Address> getAddressList(Advisor advisor);
	public boolean removeAdvisorFromGroup(AdvisorGroup advisorGroup, Advisor advisor);
	public boolean addAdvisorToGroup(AdvisorGroup advisorGroup, Advisor advisor);
}
