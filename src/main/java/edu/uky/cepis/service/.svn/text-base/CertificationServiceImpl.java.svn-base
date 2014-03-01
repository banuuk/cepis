/**
 * 
 */
package edu.uky.cepis.service;

import java.util.Date;
import java.util.List;

import edu.uky.cepis.dao.CertificationDao;
import edu.uky.cepis.domain.Certification;
import edu.uky.cepis.domain.Ranking;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserProgramProfile;

/**
 * @author scott
 */
public class CertificationServiceImpl implements CertificationService {

	/**
	 * @uml.property name="certificationDao"
	 * @uml.associationEnd
	 */
	private CertificationDao certificationDao;

	/**
	 * @return the certificationDao
	 * @uml.property name="certificationDao"
	 */
	public CertificationDao getCertificationDao() {
		return certificationDao;
	}

	/**
	 * @param certificationDao
	 *            the certificationDao to set
	 * @uml.property name="certificationDao"
	 */
	public void setCertificationDao(CertificationDao certificationDao) {
		this.certificationDao = certificationDao;
	}

	@Override
	public Certification findById(long id) {
		return this.getCertificationDao().findById(id);
	}

	@Override
	public boolean addCertificationToUser(User user,
			UserProgramProfile programProfile, Ranking ranking, String status,
			String states, Date initialDate, Date completeDate, String memo) {
		return this.getCertificationDao().addCertificationToUser(user,
				programProfile, ranking, status, states, initialDate,
				completeDate, memo);
	}

	@Override
	public boolean removeCertificationFromUser(User user,
			Certification certification) {
		return this.getCertificationDao().removeCertificationFromUser(user,
				certification);
	}

	@Override
	public boolean saveCertification(Certification certification) {
		return this.getCertificationDao().saveCertification(certification);
	}

	@Override
	public boolean updateCertification(User user, Certification certification,
			UserProgramProfile programProfile, Ranking ranking, String status,
			String states, Date completeDate, String memo) {
		return this.getCertificationDao().updateCertification(user,
				certification, programProfile, ranking, status, states,
				completeDate, memo);
	}

	@Override
	public List<Certification> getCertificationList(User user) {
		return this.getCertificationDao().getCertificationList(user);
	}

	@Override
	public List<Object> getOldCertificates(User user) {

		return this.getCertificationDao().getOldCertificates(user);
	}

}
