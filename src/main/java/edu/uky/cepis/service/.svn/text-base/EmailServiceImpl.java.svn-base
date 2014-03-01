/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import java.util.Set;
import org.efs.openreports.objects.MailMessage;
import org.springframework.security.core.Authentication;

import edu.uky.cepis.dao.EmailDao;
import edu.uky.cepis.domain.Email;
import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 */
public class EmailServiceImpl implements EmailService {

	/**
	 * @uml.property name="emailDao"
	 * @uml.associationEnd
	 */
	private EmailDao emailDao;

	/**
	 * @param emailDao
	 *            the emailDao to set
	 * @uml.property name="emailDao"
	 */
	public void setEmailDao(EmailDao emailDao) {
		this.emailDao = emailDao;
	}

	/**
	 * @return the emailDao
	 * @uml.property name="emailDao"
	 */
	public EmailDao getEmailDao() {
		return emailDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#addEmailToMyEmailAddress(edu.uky.cepis
	 * .domain.User, edu.uky.cepis.domain.Email)
	 */
	@Override
	public boolean addEmailToMyEmailAddress(User user, Email email) {

		return this.getEmailDao().addEmailToMyEmailAddress(user, email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#deleteEmail(edu.uky.cepis.domain.Email
	 * )
	 */
	@Override
	public boolean deleteEmail(Email email) {

		return this.getEmailDao().deleteEmail(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#deleteEmailFromThisEmailAddress(edu
	 * .uky.cepis.domain.User, edu.uky.cepis.domain.Email)
	 */
	@Override
	public boolean deleteEmailFromThisEmailAddress(User user, Email email) {

		return this.getEmailDao().deleteEmailFromThisEmailAddress(user, email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.EmailService#findEmailByID(long)
	 */
	@Override
	public Email findEmailByID(long id) {

		return this.getEmailDao().findEmailByID(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#findEmailByID(edu.uky.cepis.domain
	 * .User, long)
	 */
	@Override
	public Email findEmailByID(User user, long id) {

		return this.getEmailDao().findEmailByID(user, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#findEmailByName(edu.uky.cepis.domain
	 * .User, java.lang.String)
	 */
	@Override
	public List<Email> findEmailByName(User user, String subject) {

		return this.getEmailDao().findEmailByName(user, subject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#findEmailsByAddress(edu.uky.cepis.
	 * domain.User, edu.uky.cepis.domain.EmailAddress)
	 */
	@Override
	public List<Email> findEmailsByAddress(User user, EmailAddress emailAddress) {

		return this.getEmailDao().findEmailsByAddress(user, emailAddress);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#findEmailsByBccAddress(edu.uky.cepis
	 * .domain.User, edu.uky.cepis.domain.EmailAddress)
	 */
	@Override
	public List<Email> findEmailsByBccAddress(User user,
			EmailAddress bccEmailAddress) {

		return this.getEmailDao().findEmailsByBccAddress(user, bccEmailAddress);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#findEmailsByCcAddress(edu.uky.cepis
	 * .domain.User, edu.uky.cepis.domain.EmailAddress)
	 */
	@Override
	public List<Email> findEmailsByCcAddress(User user,
			EmailAddress ccEmailAddress) {

		return this.getEmailDao().findEmailsByCcAddress(user, ccEmailAddress);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#findEmailsByFromAddress(edu.uky.cepis
	 * .domain.User, edu.uky.cepis.domain.EmailAddress)
	 */
	@Override
	public List<Email> findEmailsByFromAddress(User user,
			EmailAddress fromEmailAddress) {

		return this.getEmailDao().findEmailsByFromAddress(user,
				fromEmailAddress);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#findEmailsByQuery(edu.uky.cepis.domain
	 * .User, java.lang.String)
	 */
	@Override
	public List<Email> findEmailsByQuery(User user, String content) {

		return this.getEmailDao().findEmailsByQuery(user, content);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#findEmailsByToAddress(edu.uky.cepis
	 * .domain.User, edu.uky.cepis.domain.EmailAddress)
	 */
	@Override
	public List<Email> findEmailsByToAddress(User user,
			EmailAddress toEmailAddress) {

		return this.getEmailDao().findEmailsByToAddress(user, toEmailAddress);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#forwardEmail(edu.uky.cepis.domain.
	 * User, edu.uky.cepis.domain.Email)
	 */
	@Override
	public Email forwardEmail(User user, Email email) {

		return this.getEmailDao().forwardEmail(user, email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#getEmailsFromEmailAddress(edu.uky.
	 * cepis.domain.User, edu.uky.cepis.domain.EmailAddress)
	 */
	@Override
	public List<Email> getEmailsFromEmailAddress(User user,
			EmailAddress emailAddress) {

		return this.getEmailDao().getEmailsFromEmailAddress(user, emailAddress);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#isEmailAddressOfUser(edu.uky.cepis
	 * .domain.User, edu.uky.cepis.domain.EmailAddress)
	 */
	@Override
	public boolean isEmailAddressOfUser(User user, EmailAddress emailAddress) {

		return this.getEmailDao().isEmailAddressOfUser(user, emailAddress);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#readEmail(edu.uky.cepis.domain.User,
	 * edu.uky.cepis.domain.Email)
	 */
	@Override
	public Email readEmail(User user, Email email) {

		return this.getEmailDao().readEmail(user, email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#replyToEmail(edu.uky.cepis.domain.
	 * User, edu.uky.cepis.domain.Email)
	 */
	@Override
	public Email replyToEmail(User user, Email email) {

		return this.getEmailDao().replyToEmail(user, email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#saveEmail(edu.uky.cepis.domain.Email)
	 */
	@Override
	public boolean saveEmail(Email email) {

		return this.getEmailDao().saveEmail(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#sendAndSaveEmail(edu.uky.cepis.domain
	 * .User, org.acegisecurity.Authentication, edu.uky.cepis.domain.Email)
	 */
	@Override
	public boolean sendAndSaveEmail(User user, Authentication auth, Email email) {
		return this.getEmailDao().sendAndSaveEmail(user, auth, email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.EmailService#trashEmail(edu.uky.cepis.domain.Email)
	 */
	@Override
	public boolean trashEmail(Email email) {

		return this.getEmailDao().trashEmail(email);
	}

	@Override
	public EmailAddress getUKYEmailAddress(Set<EmailAddress> emailAddresses) {
		return this.getEmailDao().getUKYEmailAddress(emailAddresses);
	}

	@Override
	public boolean sendEmail(MailMessage mail) {
		return this.getEmailDao().sendEmail(mail);
	}

}
