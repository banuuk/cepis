/**
 * 
 */
package edu.uky.cepis.service;

import java.util.Date;
import java.util.List;

import edu.uky.cepis.domain.Certification;
import edu.uky.cepis.domain.Ranking;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserProgramProfile;

/**
 * @author scott
 * 
 */
public interface CertificationService {
	public abstract Certification findById(long id);

	public abstract boolean addCertificationToUser(User user,
			UserProgramProfile programProfile, Ranking ranking, String status,String states,
			Date initialDate,Date completeDate, String memo);

	public abstract boolean removeCertificationFromUser(User user,
			Certification certification);

	public abstract boolean saveCertification(Certification certification);

	public abstract boolean updateCertification(User user,
			Certification certification, UserProgramProfile programProfile,
			Ranking ranking, String status,String states, Date completeDate, String memo);

	public abstract List<Certification> getCertificationList(User user);
	
	public abstract List<Object> getOldCertificates(User user);
}
