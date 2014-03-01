/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import java.util.Set;
import org.efs.openreports.objects.MailMessage;
import org.springframework.security.core.Authentication;

import edu.uky.cepis.domain.Email;
import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 *
 */
public interface EmailService {
	public boolean saveEmail(Email email);
	public boolean sendAndSaveEmail(User user,Authentication auth,Email email);
	public Email replyToEmail(User user,Email email);
	public Email forwardEmail(User user,Email email);
	public boolean trashEmail(Email email);
	public boolean deleteEmail(Email email);
	public boolean addEmailToMyEmailAddress(User user, Email email);
	public boolean deleteEmailFromThisEmailAddress(User user, Email email);
	public List<Email> getEmailsFromEmailAddress(User user,EmailAddress emailAddress);
	public boolean isEmailAddressOfUser(User user,EmailAddress emailAddress);
	public Email findEmailByID(long id);
	public Email findEmailByID(User user, long id);
	public List<Email> findEmailByName(User user,String subject);
	public List<Email> findEmailsByQuery(User user,String content);
	public List<Email> findEmailsByAddress(User user,EmailAddress emailAddress);
	public List<Email> findEmailsByFromAddress(User user,EmailAddress fromEmailAddress);
	public List<Email> findEmailsByToAddress(User user,EmailAddress toEmailAddress);
	public List<Email> findEmailsByCcAddress(User user,EmailAddress ccEmailAddress);
	public List<Email> findEmailsByBccAddress(User user,EmailAddress bccEmailAddress);
	public Email readEmail(User user, Email email);
	public boolean sendEmail(MailMessage mail);
	EmailAddress getUKYEmailAddress(Set<EmailAddress> emailAddresses);
	
	
}
