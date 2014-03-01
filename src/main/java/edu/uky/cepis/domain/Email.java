package edu.uky.cepis.domain;

// Generated Feb 1, 2010 1:06:04 PM by Hibernate Tools 3.2.4.GA

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Email class to store basic email information sent
 */
public class Email implements java.io.Serializable, java.util.Comparator<Email> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="emailId"
	 */
	private long emailId;
	/**
	 * @uml.property  name="sentAt"
	 */
	private Date sentAt;
	/**
	 * @uml.property  name="subject"
	 */
	private String subject;
	/**
	 * @uml.property  name="body"
	 */
	private String body;
	/**
	 * @uml.property  name="starred"
	 */
	private Boolean starred;
	/**
	 * @uml.property  name="read"
	 */
	private Boolean read;
	/**
	 * @uml.property  name="sent"
	 */
	private Boolean sent;
	/**
	 * @uml.property  name="fromAddress"
	 * @uml.associationEnd  
	 */
	private EmailAddress fromAddress;
	/**
	 * @uml.property  name="toAddresses"
	 */
	private List<EmailAddress> toAddresses = new ArrayList<EmailAddress>(0);
	/**
	 * @uml.property  name="ccAddresses"
	 */
	private List<EmailAddress> ccAddresses = new ArrayList<EmailAddress>(0);
	/**
	 * @uml.property  name="bccAddresses"
	 */
	private List<EmailAddress> bccAddresses = new ArrayList<EmailAddress>(0);
	/**
	 * @uml.property  name="replyEmails"
	 */
	private List<Email> replyEmails = new ArrayList<Email>(0);

	public Email() {
	}

	public Email(Date sentAt, String subject, String body, Boolean starred,
			Boolean read, Boolean sent, EmailAddress fromAddress,
			List<EmailAddress> toAddresses, List<EmailAddress> ccAddresses,
			List<EmailAddress> bccAddresses) {
		this.sentAt = sentAt;
		this.subject = subject;
		this.body = body;
		this.starred = starred;
		this.read = read;
		this.sent = sent;
		this.fromAddress = fromAddress;
		this.toAddresses = toAddresses;
		this.ccAddresses = ccAddresses;
		this.bccAddresses = bccAddresses;
	}

	/**
	 * @return
	 * @uml.property name="emailId"
	 */
	public long getEmailId() {
		return this.emailId;
	}

	/**
	 * @param emailId
	 * @uml.property name="emailId"
	 */
	public void setEmailId(long emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return
	 * @uml.property name="sentAt"
	 */
	public Date getSentAt() {
		return this.sentAt;
	}

	/**
	 * @param sentAt
	 * @uml.property name="sentAt"
	 */
	public void setSentAt(Date sentAt) {
		this.sentAt = sentAt;
	}

	/**
	 * @return
	 * @uml.property name="subject"
	 */
	public String getSubject() {
		return this.subject;
	}

	/**
	 * @param subject
	 * @uml.property name="subject"
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return
	 * @uml.property name="body"
	 */
	public String getBody() {
		return this.body;
	}

	/**
	 * @param body
	 * @uml.property name="body"
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return
	 * @uml.property name="starred"
	 */
	public Boolean getStarred() {
		return this.starred;
	}

	/**
	 * @param starred
	 * @uml.property name="starred"
	 */
	public void setStarred(Boolean starred) {
		this.starred = starred;
	}

	/**
	 * @return
	 * @uml.property name="read"
	 */
	public Boolean getRead() {
		return this.read;
	}

	/**
	 * @param read
	 * @uml.property name="read"
	 */
	public void setRead(Boolean read) {
		this.read = read;
	}

	/**
	 * @param sent
	 *            the sent to set
	 * @uml.property name="sent"
	 */
	public void setSent(Boolean sent) {
		this.sent = sent;
	}

	/**
	 * @return the sent
	 * @uml.property name="sent"
	 */
	public Boolean getSent() {
		return sent;
	}

	/**
	 * @return
	 * @uml.property name="fromAddress"
	 */
	public EmailAddress getFromAddress() {
		return this.fromAddress;
	}

	/**
	 * @param fromAddress
	 * @uml.property name="fromAddress"
	 */
	public void setFromAddress(EmailAddress fromAddress) {
		this.fromAddress = fromAddress;
	}

	/**
	 * @return
	 * @uml.property name="toAddresses"
	 */
	public List<EmailAddress> getToAddresses() {
		return this.toAddresses;
	}

	/**
	 * @param toAddresses
	 * @uml.property name="toAddresses"
	 */
	public void setToAddresses(List<EmailAddress> toAddresses) {
		this.toAddresses = toAddresses;
	}

	/**
	 * @return
	 * @uml.property name="ccAddresses"
	 */
	public List<EmailAddress> getCcAddresses() {
		return this.ccAddresses;
	}

	/**
	 * @param ccAddresses
	 * @uml.property name="ccAddresses"
	 */
	public void setCcAddresses(List<EmailAddress> ccAddresses) {
		this.ccAddresses = ccAddresses;
	}

	/**
	 * @return
	 * @uml.property name="bccAddresses"
	 */
	public List<EmailAddress> getBccAddresses() {
		return this.bccAddresses;
	}

	/**
	 * @param bccAddresses
	 * @uml.property name="bccAddresses"
	 */
	public void setBccAddresses(List<EmailAddress> bccAddresses) {
		this.bccAddresses = bccAddresses;
	}

	/**
	 * @return
	 * @uml.property name="replyEmails"
	 */
	public List<Email> getReplyEmails() {
		return this.replyEmails;
	}

	/**
	 * @param replyEmails
	 * @uml.property name="replyEmails"
	 */
	public void setReplyEmails(List<Email> replyEmails) {
		this.replyEmails = replyEmails;
	}

	@Override
	public int compare(Email o1, Email o2) {
		return o1.getSubject().compareTo(o2.getSubject());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bccAddresses == null) ? 0 : bccAddresses.hashCode());
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result
				+ ((ccAddresses == null) ? 0 : ccAddresses.hashCode());
		result = prime * result + (int) (emailId ^ (emailId >>> 32));
		result = prime * result
				+ ((fromAddress == null) ? 0 : fromAddress.hashCode());
		result = prime * result + ((read == null) ? 0 : read.hashCode());
		result = prime * result + ((sent == null) ? 0 : sent.hashCode());
		result = prime * result + ((sentAt == null) ? 0 : sentAt.hashCode());
		result = prime * result + ((starred == null) ? 0 : starred.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result
				+ ((toAddresses == null) ? 0 : toAddresses.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Email)) {
			return false;
		}
		Email other = (Email) obj;
		if (bccAddresses == null) {
			if (other.bccAddresses != null) {
				return false;
			}
		} else if (!bccAddresses.equals(other.bccAddresses)) {
			return false;
		}
		if (body == null) {
			if (other.body != null) {
				return false;
			}
		} else if (!body.equals(other.body)) {
			return false;
		}
		if (ccAddresses == null) {
			if (other.ccAddresses != null) {
				return false;
			}
		} else if (!ccAddresses.equals(other.ccAddresses)) {
			return false;
		}
		if (emailId != other.emailId) {
			return false;
		}
		if (fromAddress == null) {
			if (other.fromAddress != null) {
				return false;
			}
		} else if (!fromAddress.equals(other.fromAddress)) {
			return false;
		}
		if (read == null) {
			if (other.read != null) {
				return false;
			}
		} else if (!read.equals(other.read)) {
			return false;
		}
		if (sent == null) {
			if (other.sent != null) {
				return false;
			}
		} else if (!sent.equals(other.sent)) {
			return false;
		}
		if (sentAt == null) {
			if (other.sentAt != null) {
				return false;
			}
		} else if (!sentAt.equals(other.sentAt)) {
			return false;
		}
		if (starred == null) {
			if (other.starred != null) {
				return false;
			}
		} else if (!starred.equals(other.starred)) {
			return false;
		}
		if (subject == null) {
			if (other.subject != null) {
				return false;
			}
		} else if (!subject.equals(other.subject)) {
			return false;
		}
		if (toAddresses == null) {
			if (other.toAddresses != null) {
				return false;
			}
		} else if (!toAddresses.equals(other.toAddresses)) {
			return false;
		}
		return true;
	}

}
