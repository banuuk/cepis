/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.List;

import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.EmailAddressType;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 * 
 */
public interface EmailAddressDao {

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
