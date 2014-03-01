/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.Certification;
import edu.uky.cepis.domain.Ranking;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserProgramProfile;

/**
 * @author scott
 * @author Keerthi
 * 
 */
public class CertificationDaoImpl implements CertificationDao {
	private static Logger log = Logger.getLogger(CertificationDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Certification findById(long id) {

		List<Certification> certifications = new ArrayList<Certification>(0);
		String hql = "select a from Certification a where a.id=" + id;
		certifications = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		Certification certification = null;
		if (certifications.size() > 0) {
			certification = certifications.get(0);
		}
		return certification;
	}

	@Override
	public boolean addCertificationToUser(User user,
			UserProgramProfile programProfile, Ranking ranking, String status,
			String states, Date initialDate, Date completeDate, String memo) {

		if (user == null || programProfile == null || ranking == null) {
			return false;
		}

		Certification certification = new Certification(status, initialDate,
				ranking, memo, programProfile, states);
		certification.setCompleteDate(completeDate);
		this.sessionFactory.getCurrentSession().save(certification);

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return false;
		}
		newuser.getCertifications().add(certification);
		this.sessionFactory.getCurrentSession().saveOrUpdate(newuser);

		return true;
	}

	@Override
	public boolean removeCertificationFromUser(User user,
			Certification certification) {
		System.out.println("Got in the remove certification dao");

		if (user == null || certification == null) {
			return false;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		Certification newcertification = (Certification) this.sessionFactory
				.getCurrentSession().load(Certification.class,
						certification.getId());
		if (newuser == null || newcertification == null) {
			return false;
		}
		if (newuser.getCertifications().contains(newcertification)) {
			newuser.getCertifications().remove(newcertification);
			this.sessionFactory.getCurrentSession().delete(newcertification);
			return true;
		}
		return false;
	}

	@Override
	public boolean saveCertification(Certification certification) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(certification);
		return true;
	}

	@Override
	public boolean updateCertification(User user, Certification certification,
			UserProgramProfile programProfile, Ranking ranking, String status,
			String states, Date completeDate, String memo) {
		if (user == null || certification == null) {
			return false;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		Certification newcertification = (Certification) this.sessionFactory
				.getCurrentSession().load(Certification.class,
						certification.getId());
		if (!newuser.getCertifications().contains(newcertification)) {
			return false;
		}
		newcertification.setProgramProfile(programProfile);
		newcertification.setRanking(ranking);
		newcertification.setStatus(status);
		newcertification.setCompleteDate(completeDate);
		newcertification.setMemo(memo);
		newcertification.setState(states);
		newcertification.setLastEdit(new Date());

		this.saveCertification(newcertification);
		return true;
	}

	@Override
	public List<Certification> getCertificationList(User user) {
		List<Certification> certifications = new ArrayList<Certification>(0);
		if (user == null) {
			return certifications;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return certifications;
		}

		certifications = new ArrayList<Certification>(
				newuser.getCertifications());
		return certifications;
	}

	@Override
	public List<Object> getOldCertificates(User user) {

		List<Object> oldCertificationInfo = new ArrayList<Object>(0);
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return oldCertificationInfo;
		}
		final String sQryToFind = "SELECT DISTINCT  tblCertificates.Certificatecode,"
				+ " lstCertificate.Title CertificateTitle, tblEndorsement.Endorsementcode, "
				+ "lstEndorsement.Title EndorsementTitle, tblRanking.Rankingcode, "
				+ "lstRanking.Title RankingTitle,tblCertificationprofile.Statuscode, "
				+ "tblCertificationprofile.Statuschangeterm, tblCerttransaction."
				+ "Reportyearcode FROM (((( tblCertificationprofile  INNER JOIN "
				+ "((tblCerttransaction INNER JOIN tblCertificates ON "
				+ "tblCerttransaction.CerttransactionID = tblCertificates."
				+ "CerttransactionID) INNER JOIN tblRanking ON tblCerttransaction."
				+ "CerttransactionID = tblRanking.CerttransactionID) ON "
				+ "tblCertificationprofile.CertUID = tblCerttransaction.CertUID) "
				+ "INNER JOIN lstCertificate ON tblCertificates.Certificatecode "
				+ "= lstCertificate.Certificatecode) INNER JOIN tblEndorsement "
				+ "ON tblCerttransaction.CerttransactionID = tblEndorsement.CerttransactionID)"
				+ " INNER JOIN lstEndorsement ON tblEndorsement.Endorsementcode = lstEndorsement.Endorsementcode)"
				+ " INNER JOIN lstRanking ON tblRanking.Rankingcode = lstRanking.Rankingcode "
				+ "WHERE (((tblCertificationprofile.UID)='"
				+ newuser.getUid()
				+ "'))";
		oldCertificationInfo = (List<Object>) this.sessionFactory
				.getCurrentSession().createSQLQuery(sQryToFind).list();
		return oldCertificationInfo;
	}
}
