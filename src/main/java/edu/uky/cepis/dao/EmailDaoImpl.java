/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.efs.openreports.objects.MailMessage;
import org.efs.openreports.providers.MailProvider;
import org.efs.openreports.providers.ProviderException;
import org.hibernate.SessionFactory;
import org.springframework.security.core.Authentication;

import edu.uky.cepis.domain.Email;
import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 */
public class EmailDaoImpl implements EmailDao {

	private static final Log log = LogFactory.getLog(EmailDaoImpl.class);
	private MailProvider mailProvider;
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailDao#addEmailToMyEmailAddress(edu.uky.cepis.domain
	 * .User, edu.uky.cepis.domain.Email)
	 */
	@Override
	public boolean addEmailToMyEmailAddress(User user, Email email) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.EmailDao#deleteEmail(edu.uky.cepis.domain.Email)
	 */
	@Override
	public boolean deleteEmail(Email email) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailDao#deleteEmailFromThisEmailAddress(edu.uky.cepis
	 * .domain.User, edu.uky.cepis.domain.Email)
	 */
	@Override
	public boolean deleteEmailFromThisEmailAddress(User user, Email email) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.EmailDao#findEmailByID(long)
	 */
	@Override
	public Email findEmailByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.EmailDao#findEmailByID(edu.uky.cepis.domain.User,
	 * long)
	 */
	@Override
	public Email findEmailByID(User user, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailDao#findEmailByName(edu.uky.cepis.domain.User,
	 * java.lang.String)
	 */
	@Override
	public List<Email> findEmailByName(User user, String subject) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailDao#findEmailsByAddress(edu.uky.cepis.domain.User,
	 * edu.uky.cepis.domain.EmailAddress)
	 */
	@Override
	public List<Email> findEmailsByAddress(User user, EmailAddress emailAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailDao#findEmailsByBccAddress(edu.uky.cepis.domain
	 * .User, edu.uky.cepis.domain.EmailAddress)
	 */
	@Override
	public List<Email> findEmailsByBccAddress(User user,
			EmailAddress bccEmailAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailDao#findEmailsByCcAddress(edu.uky.cepis.domain
	 * .User, edu.uky.cepis.domain.EmailAddress)
	 */
	@Override
	public List<Email> findEmailsByCcAddress(User user,
			EmailAddress ccEmailAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailDao#findEmailsByFromAddress(edu.uky.cepis.domain
	 * .User, edu.uky.cepis.domain.EmailAddress)
	 */
	@Override
	public List<Email> findEmailsByFromAddress(User user,
			EmailAddress fromEmailAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailDao#findEmailsByQuery(edu.uky.cepis.domain.User,
	 * java.lang.String)
	 */
	@Override
	public List<Email> findEmailsByQuery(User user, String content) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailDao#findEmailsByToAddress(edu.uky.cepis.domain
	 * .User, edu.uky.cepis.domain.EmailAddress)
	 */
	@Override
	public List<Email> findEmailsByToAddress(User user,
			EmailAddress toEmailAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.EmailDao#forwardEmail(edu.uky.cepis.domain.User,
	 * edu.uky.cepis.domain.Email)
	 */
	@Override
	public Email forwardEmail(User user, Email email) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailDao#getEmailsFromEmailAddress(edu.uky.cepis.domain
	 * .User, edu.uky.cepis.domain.EmailAddress)
	 */
	@Override
	public List<Email> getEmailsFromEmailAddress(User user,
			EmailAddress emailAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailDao#isEmailAddressOfUser(edu.uky.cepis.domain.
	 * User, edu.uky.cepis.domain.EmailAddress)
	 */
	@Override
	public boolean isEmailAddressOfUser(User user, EmailAddress emailAddress) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.EmailDao#replyToEmail(edu.uky.cepis.domain.User,
	 * edu.uky.cepis.domain.Email)
	 */
	@Override
	public Email replyToEmail(User user, Email email) {
		if (user == null) {
			return null;
		}
		if (email == null) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		EmailAddress emailAddress = null;
		Set<EmailAddress> emailAddresses = newuser.getEmailAddresses();
		if (!(emailAddresses.size() > 0)) {
			// No email address found
			return null;
		}
		emailAddress = this.getUKYEmailAddress(emailAddresses);
		if (emailAddress == null) {
			// no UKY Email Address available. Warning !!!!!
			// pick the first email address in the list
			// emailAddress = emailAddresses.get(0);
			return null;
		}
		Email replyEmail = null;
		List<EmailAddress> replyToEmailAddresses = new ArrayList<EmailAddress>(
				0);
		replyToEmailAddresses.add(email.getFromAddress());
		// Creating Reply HTML email
		replyEmail = new Email(new Date(), "RE: " + email.getSubject(),
				"<br/>From:" + email.getFromAddress() + "To:"
						+ email.getToAddresses().size() + "users" + "Subject:"
						+ email.getSubject() + "SentAt:" + email.getSentAt()
						+ "<br/><hr>" + email.getBody(), email.getStarred(),
				true, false, emailAddress, replyToEmailAddresses,
				new ArrayList<EmailAddress>(0), new ArrayList<EmailAddress>(0));
		return replyEmail;
	}

	public Email replyAll(User user, Email email) {
		if (user == null) {
			return null;
		}
		if (email == null) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		EmailAddress emailAddress = null;
		Set<EmailAddress> emailAddresses = newuser.getEmailAddresses();
		if (!(emailAddresses.size() > 0)) {
			// No email address found
			return null;
		}
		emailAddress = this.getUKYEmailAddress(emailAddresses);
		if (emailAddress == null) {
			// no UKY Email Address available. Warning !!!!!
			// pick the first email address in the list
			// emailAddress = emailAddresses.get(0);
			return null;
		}
		Email replyEmail = null;
		List<EmailAddress> replyToEmailAddresses = new ArrayList<EmailAddress>(
				0);
		replyToEmailAddresses.add(email.getFromAddress());
		// Creating Reply HTML email
		replyEmail = new Email(new Date(), "RE: " + email.getSubject(),
				"<br/>From:" + email.getFromAddress() + "To:"
						+ email.getToAddresses().size() + "users" + "Subject:"
						+ email.getSubject() + "SentAt:" + email.getSentAt()
						+ "<br/><hr>" + email.getBody(), email.getStarred(),
				true, false, emailAddress, replyToEmailAddresses,
				new ArrayList<EmailAddress>(0), new ArrayList<EmailAddress>(0));
		return replyEmail;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailAddressDao#getUKYEmailAddress(edu.uky.cepis.domain
	 * .User)
	 */
	@Override
	public EmailAddress getUKYEmailAddress(Set<EmailAddress> emailAddresses) {

		Iterator<EmailAddress> iter = emailAddresses.iterator();
		EmailAddress UKYEmailAddress = null;
		while (iter.hasNext()) {
			UKYEmailAddress = iter.next();
			if (UKYEmailAddress.getType().equals("UKY")) {
				break;
			}
		}
		return UKYEmailAddress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.EmailDao#saveEmail(edu.uky.cepis.domain.Email)
	 */
	@Override
	public boolean saveEmail(Email email) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(email);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.EmailDao#sendAndSaveEmail(edu.uky.cepis.domain.User,
	 * edu.uky.cepis.domain.Email)
	 */
	@Override
	public boolean sendAndSaveEmail(User user, Authentication auth, Email email) {

		if (!this.addEmailToMyEmailAddress(user, email)) {
			return false;
		}
		if (!this.saveEmail(email)) {
			return false;
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.EmailDao#readEmail(edu.uky.cepis.domain.User,
	 * edu.uky.cepis.domain.Email)
	 */
	@Override
	public Email readEmail(User user, Email email) {
		if (user == null) {
			return null;
		}
		if (email == null) {
			return null;
		}
		email.setRead(true);
		this.saveEmail(email);
		return email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.EmailDao#sendEmail(edu.uky.cepis.domain.User,
	 * edu.uky.cepis.domain.Email)
	 */
	@Override
	public boolean sendEmail(MailMessage mail) {
		log.debug("Entered EmailDaoImpl.sendEmail()");
		try {
			StringBuffer msg = new StringBuffer("Sending email '"
					+ mail.getSubject() + "' to ");
			Iterator<String> iter = mail.getRecipients().iterator();
			int count = 0;
			while (iter.hasNext()) {
				count++;
				msg.append(count + ": " + iter.next() + "\t");
			}
			log.debug(msg);
			this.getMailProvider().sendMail(mail);
			return true;
		} catch (ProviderException e) {
			System.err.println(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.EmailDao#trashEmail(edu.uky.cepis.domain.Email)
	 */
	@Override
	public boolean trashEmail(Email email) {
		if (email == null) {
			return false;
		}
		return true;
	}

	/**
	 * @param mailProvider
	 *            the mailProvider to set
	 */
	public void setMailProvider(MailProvider mailProvider) {
		this.mailProvider = mailProvider;
	}

	/**
	 * @return the mailProvider
	 */
	public MailProvider getMailProvider() {
		return mailProvider;
	}

}
