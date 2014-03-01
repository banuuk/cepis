/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import java.util.Set;

import edu.uky.cepis.domain.Email;
import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.EmailAddressType;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public interface EmailAddressService {
	public List<EmailAddress> getEmailAddresses(User user);

	public EmailAddress getUKYEmailAddress(User user);

	public boolean removeEmailAddressFromUser(User user,
			EmailAddress emailAddress);

	public EmailAddress findEmailAddressByID(long id);

	public EmailAddress findEmailAddressByName(String name);

	public EmailAddress findEmailAddressByID(User user, long id);

	public EmailAddress findEmailAddressByName(User user, String name);

	public boolean saveEmailAddress(EmailAddress emailAddress);

	public boolean isUKYEmailAddress(EmailAddress emailAddress);

	public EmailAddress updateEmailAddress(User user,
			EmailAddress emailAddress, String address, EmailAddressType type);

	public boolean addEmailAddressToUser(User user, String address,
			EmailAddressType emailAddressType);
	public boolean setPrimaryEmailAddress(User user, String address,
			EmailAddressType emailAddressType);
}
