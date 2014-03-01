/**
 * 
 */
package edu.uky.cepis.util.global;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import edu.uky.cepis.domain.EmailAddress;

/**
 * CEPISConfigurator defines the application-level attributes such as release
 * date, copyright information. This class is specifically created to support
 * the usage of CEPIS application by universities other than University of
 * Kentucky. <br>
 * This fields can be initialized using the cepis.properties file in the
 * classpath.
 * 
 * @author keerthi
 */
public class CEPISConfigurator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String version;
	public Date releaseDate;
	public List<String> authorNames = new ArrayList<String>(0);
	public List<EmailAddress> authorEmails = new ArrayList<EmailAddress>(0);
	public URL bugReportLink;
	public String copyRightTo;
	public int year;
	public String applicationName;
	protected String baseLocation;
	protected String profileBaseLocation;
	protected String etsScorelinkBaseLocation;

	/**
	 * @return the version
	 * @uml.property name="version"
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 * @uml.property name="version"
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the releaseDate
	 * @uml.property name="releaseDate"
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate
	 *            the releaseDate to set
	 * @uml.property name="releaseDate"
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @return the authorNames
	 * @uml.property name="authorNames"
	 */
	public List<String> getAuthorNames() {
		return authorNames;
	}

	/**
	 * @param authorNames
	 *            the authorNames to set
	 * @uml.property name="authorNames"
	 */
	public void setAuthorNames(List<String> authorNames) {
		this.authorNames = authorNames;
	}

	/**
	 * @return the authorEmails
	 * @uml.property name="authorEmails"
	 */
	public List<EmailAddress> getAuthorEmails() {
		return authorEmails;
	}

	/**
	 * @param authorEmails
	 *            the authorEmails to set
	 * @uml.property name="authorEmails"
	 */
	public void setAuthorEmails(List<EmailAddress> authorEmails) {
		this.authorEmails = authorEmails;
	}

	/**
	 * @return the bugReportLink
	 * @uml.property name="bugReportLink"
	 */
	public URL getBugReportLink() {
		return bugReportLink;
	}

	/**
	 * @param bugReportLink
	 *            the bugReportLink to set
	 * @uml.property name="bugReportLink"
	 */
	public void setBugReportLink(URL bugReportLink) {
		this.bugReportLink = bugReportLink;
	}

	/**
	 * @return the copyRightTo
	 * @uml.property name="copyRightTo"
	 */
	public String getCopyRightTo() {
		return copyRightTo;
	}

	/**
	 * @param copyRightTo
	 *            the copyRightTo to set
	 * @uml.property name="copyRightTo"
	 */
	public void setCopyRightTo(String copyRightTo) {
		this.copyRightTo = copyRightTo;
	}

	/**
	 * @param year
	 *            the year to set
	 * @uml.property name="year"
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the year
	 * @uml.property name="year"
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the applicationName
	 * @uml.property name="applicationName"
	 */
	public String getApplicationName() {
		return applicationName;
	}

	/**
	 * @param applicationName
	 *            the applicationName to set
	 * @uml.property name="applicationName"
	 */
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	/**
	 * @param baseLocation
	 *            the baseLocation to set
	 * @uml.property name="baseLocation"
	 */
	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}

	/**
	 * @return the baseLocation
	 * @uml.property name="baseLocation"
	 */
	public String getBaseLocation() {
		return baseLocation;
	}

	/**
	 * @param profileBaseLocation
	 *            the profileBaseLocation to set
	 * @uml.property name="profileBaseLocation"
	 */
	public void setProfileBaseLocation(String profileBaseLocation) {
		this.profileBaseLocation = profileBaseLocation;
	}

	/**
	 * @return the profileBaseLocation
	 * @uml.property name="profileBaseLocation"
	 */
	public String getProfileBaseLocation() {
		return profileBaseLocation;
	}

	/**
	 * @return the etsScorelinkBaseLocation
	 */
	public String getEtsScorelinkBaseLocation() {
		return etsScorelinkBaseLocation;
	}

	/**
	 * @param etsScorelinkBaseLocation
	 *            the etsScorelinkBaseLocation to set
	 */
	public void setEtsScorelinkBaseLocation(String etsScorelinkBaseLocation) {
		this.etsScorelinkBaseLocation = etsScorelinkBaseLocation;
	}

}
