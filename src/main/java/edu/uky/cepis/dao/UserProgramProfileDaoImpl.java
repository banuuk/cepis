/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.sql.JoinType;

import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.FacultyAdvisor;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserProgramProfile;
import edu.uky.cepis.domain.component.Program;
import edu.uky.cepis.domain.component.ProgramDomain;
import edu.uky.cepis.domain.component.ProgramGroup;
import edu.uky.cepis.domain.component.ProgramTrack;
import edu.uky.cepis.domain.component.UKMajor;
import edu.uky.cepis.domain.component.UKStatus;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author cawalk4
 * 
 */

@SuppressWarnings("unchecked")
public class UserProgramProfileDaoImpl implements UserProgramProfileDao {
	private static Logger log = Logger.getLogger(UserProgramProfileDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UserProgramProfileDao#updateUserProgramProfile(edu.
	 * uky.cepis.domain.User, edu.uky.cepis.domain.component.Program,
	 * edu.uky.cepis.domain.component.ProgramDomain,
	 * edu.uky.cepis.domain.component.ProgramTrack,
	 * edu.uky.cepis.domain.component.ProgramGroup,
	 * edu.uky.cepis.domain.Advisor, edu.uky.cepis.domain.UKMajor,
	 * edu.uky.cepis.domain.UKStatus, edu.uky.cepis.domain.UKTerm,
	 * edu.uky.cepis.domain.UKTerm, edu.uky.cepis.domain.UKTerm)
	 */
	@Override
	public UserProgramProfile updateUserProgramProfile(User user,
			UserProgramProfile userProgramProfile, Program program,
			ProgramDomain programDomain, ProgramTrack programTrack,
			ProgramGroup programGroup, Advisor advisor,FacultyAdvisor facultyAdvisor, UKMajor ukMajor,
			UKStatus ukStatus, UKTerm ukStartTerm, 
			UKTerm ukAnticipatedCompleteTerm, UKTerm ukCompleteTerm,
			String finalGPA, Integer degreeAwarded, boolean hiddenToStudent,
			boolean recommendCertification, String shortDesc) {
	
		if (user == null) {
			return null;
		}
		
		log.debug("Entered UserProgramProfileDaoImpl updateUserProgramProfile for USER:" + user.getUid());
			
		if (userProgramProfile == null
				|| userProgramProfile.getUserprogramprofileid() == null) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		UserProgramProfile newUserProgramProfile = (UserProgramProfile) this.sessionFactory
				.getCurrentSession().load(UserProgramProfile.class,
						userProgramProfile.getUserprogramprofileid());
		if (!newuser.getUserProgramProfiles().contains(newUserProgramProfile)) {
			return null;
		}
		newUserProgramProfile.setProgram(program);
		newUserProgramProfile.setProgramDomain(programDomain);
		newUserProgramProfile.setProgramTrack(programTrack);
		newUserProgramProfile.setProgramGroup(programGroup);
		newUserProgramProfile.setAdvisor(advisor);
		newUserProgramProfile.setFacultyAdvisor(facultyAdvisor);
		newUserProgramProfile.setUkMajor(ukMajor);
		newUserProgramProfile.setUkStatus(ukStatus);
		newUserProgramProfile.setUkStartTerm(ukStartTerm);		
		newUserProgramProfile.setUkAnticipatedCompleteTerm(ukAnticipatedCompleteTerm);
		newUserProgramProfile.setUkCompleteTerm(ukCompleteTerm);
		newUserProgramProfile.setFinalGPA(finalGPA);
		newUserProgramProfile.setDegreeAwarded(degreeAwarded);
		newUserProgramProfile.setHiddenToStudent(hiddenToStudent);
		newUserProgramProfile.setRecommendCertification(recommendCertification);
		newUserProgramProfile.setShortDesc(shortDesc);
		newUserProgramProfile.setLastUpdated(new Date());
		if (!this.saveUserProgramProfile(newUserProgramProfile)) {
			return null;
		}
		return newUserProgramProfile;

	}

	@Override
	public boolean addUserProgramProfileToUser(User user, Program program,
			ProgramDomain programDomain, ProgramTrack programTrack,
			ProgramGroup programGroup, Advisor advisor,FacultyAdvisor facultyAdvisor, UKMajor ukMajor,
			UKStatus ukStatus, UKTerm ukStartTerm, 
			UKTerm ukAnticipatedCompleteTerm, UKTerm ukCompleteTerm,
			String finalGPA, Integer degreeAwarded, boolean hiddenToStudent,
			boolean recommendCertification, String shortDesc) {
		if (user == null) {
			return false;
		}
		if (program == null || programDomain == null || programTrack == null
				|| programGroup == null || ukMajor == null) {
			return false;
		}

		if (this.findUserProgramProfile(user, program, programDomain,
				programTrack, programGroup, advisor, facultyAdvisor, ukMajor, ukStatus,
				ukStartTerm, ukCompleteTerm, degreeAwarded,	shortDesc)) {
			System.out
					.println("Duplicate User Program profile available for this user");
			return false;
		}
		String ppid = this.generateUserProgramProfileId(user);
		UserProgramProfile userProgramProfile = new UserProgramProfile(ppid,
				program, programDomain, programTrack, programGroup, advisor,
				facultyAdvisor,	ukMajor, ukStatus, ukStartTerm,
				ukAnticipatedCompleteTerm, ukCompleteTerm, finalGPA,
				degreeAwarded, hiddenToStudent, recommendCertification,
				shortDesc);
		System.out.println("Saving Prog Prof :" + ppid);
		this.sessionFactory.getCurrentSession().save(userProgramProfile);
		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return false;
		}
		newuser.getUserProgramProfiles().add(userProgramProfile);
		return true;

	}

	private String generateUserProgramProfileId(User user) {
		// Generate Program Profile UID
		String ppid = "P-" + user.getUid() + "-";

		List<UserProgramProfile> userProgramProfiles = this
				.findUserProgramProfiles(ppid);
		if (userProgramProfiles.size() < 1) {
			ppid += "1";
			return ppid;
		}
		int max = 0;
		Iterator<UserProgramProfile> iter = userProgramProfiles.iterator();
		UserProgramProfile duplicateUserProgramProfile = null;
		String temp = null;
		int num = 0;
		int len = 0;
		while (iter.hasNext()) {
			duplicateUserProgramProfile = iter.next();
			// Get last two characters of the id
			len = duplicateUserProgramProfile.getUserprogramprofileid()
					.length();
			temp = duplicateUserProgramProfile.getUserprogramprofileid()
					.substring(len - 1);
			System.out.println(temp);
			// convert it to number
			num = Integer.parseInt(temp);
			// find the maximum value
			if (num > max) {
				max = num;
			}
		}
		// Add 1 to the max value
		max++;
		ppid += max + "";
		return ppid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.UserProgramProfileDao#findUserProgramProfile(long)
	 */
	@Override
	public UserProgramProfile findUserProgramProfile(String userprogramprofileid) {

		List<UserProgramProfile> userProgramProfiles = new ArrayList<UserProgramProfile>(
				0);
		String hql = "select a from UserProgramProfile a where a.userprogramprofileid='"
				+ userprogramprofileid + "'";
		userProgramProfiles = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		UserProgramProfile userProgramProfile = null;
		if (userProgramProfiles.size() > 0) {
			userProgramProfile = userProgramProfiles.get(0);
		}
		return userProgramProfile;
	}

	
	public List<UserProgramProfile> findUserProgramProfiles(
			String userprogramprofileid) {

		List<UserProgramProfile> userProgramProfiles = new ArrayList<UserProgramProfile>(
				0);
		String hql = "select a from UserProgramProfile a where a.userprogramprofileid like '"
				+ userprogramprofileid + "%'";
		userProgramProfiles = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		return userProgramProfiles;
	}

	@Override
	public boolean findUserProgramProfile(User user, Program program,
			ProgramDomain programDomain, ProgramTrack programTrack,
			ProgramGroup programGroup, Advisor advisor,FacultyAdvisor facultyAdvisor, UKMajor ukMajor,
			UKStatus ukStatus, UKTerm ukStartTerm, 
			UKTerm ukCompleteTerm, Integer degreeAwarded, String shortDesc) {

		List<User> users = new ArrayList<User>(0);

		DetachedCriteria dc = DetachedCriteria.forClass(User.class, "user");
		dc.add(Property.forName("user.uid").eq(user.getUid()));
		dc = dc.createAlias("user.userProgramProfiles", "a",
				JoinType.LEFT_OUTER_JOIN);
		if (program != null) {
			dc.add(Property.forName("a.program.programCode").eq(
					program.getProgramCode()));
		}
		if (programDomain != null) {
			dc.add(Property.forName("a.programDomain.programDomainCode").eq(
					programDomain.getProgramDomainCode()));
		}
		if (programGroup != null) {
			dc.add(Property.forName("a.programGroup.programGroupCode").eq(
					programGroup.getProgramGroupCode()));
		}
		if (programTrack != null) {
			dc.add(Property.forName("a.programTrack.programTrackCode").eq(
					programTrack.getProgramTrackCode()));
		}
		if (ukStartTerm != null) {
			dc.add(Property.forName("a.ukStartTerm.ukTermCode").eq(
					ukStartTerm.getUkTermCode()));
		}		
		if (ukCompleteTerm != null) {
			dc.add(Property.forName("a.ukCompleteTerm.ukTermCode").eq(
					ukCompleteTerm.getUkTermCode()));
		}
		if (advisor != null) {
			dc.add(Property.forName("a.advisor.userid").eq(advisor.getUserid()));
		}
		if (facultyAdvisor != null) {
			dc.add(Property.forName("a.facultyAdvisor.userid").eq(facultyAdvisor.getUserid()));
		}
		if (degreeAwarded != null) {
			dc.add(Property.forName("a.degreeAwarded").eq(degreeAwarded));
		}

		if (ukStatus != null) {
			dc.add(Property.forName("a.ukStatus.statusCode").eq(
					ukStatus.getStatusCode()));
		}
		Criteria criteria = dc.getExecutableCriteria(this.sessionFactory
				.getCurrentSession());
		users = criteria.list();
		if (users.size() > 0) {
			return true;
		}
		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UserProgramProfileDao#removeUserProgramProfileFromUser
	 * (edu.uky.cepis.domain.User, edu.uky.cepis.domain.UserProgramProfile)
	 */
	@Override
	public boolean removeUserProgramProfileFromUser(User user,
			UserProgramProfile userProgramProfile) {
		if (user == null) {
			return false;
		}
		if (userProgramProfile == null) {
			return false;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return false;
		}
		UserProgramProfile newUserProgramProfile = (UserProgramProfile) this.sessionFactory
				.getCurrentSession().load(UserProgramProfile.class,
						userProgramProfile.getUserprogramprofileid());
		if (newuser.getUserProgramProfiles().contains(newUserProgramProfile)) {
			newuser.getUserProgramProfiles().remove(newUserProgramProfile);
			this.sessionFactory.getCurrentSession().delete(
					newUserProgramProfile);
			return true;
		}
		return false;
	}

	@Override
	public Advisor getStudentAdvisor(User user) {
		if (user == null) {
			return null;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return null;
		}
		Iterator<UserProgramProfile> iter = newuser.getUserProgramProfiles()
				.iterator();
		UserProgramProfile upp = null;
		while (iter.hasNext()) {
			upp = iter.next();
			if (upp.getAdvisor() != null) {
				return upp.getAdvisor();
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.UserProgramProfileDao#saveUserProgramProfile(edu.uky
	 * .cepis.domain.UserProgramProfile)
	 */
	@Override
	public boolean saveUserProgramProfile(UserProgramProfile userProgramprofile) {

		this.sessionFactory.getCurrentSession()
				.saveOrUpdate(userProgramprofile);
		return true;
	}

	@Override
	public List<UserProgramProfile> getUserProgramProfiles(User user) {

		List<UserProgramProfile> userProgramProfiles = new ArrayList<UserProgramProfile>(
				0);
		String hql = "select b from  edu.uky.cepis.domain.User a join a.userProgramProfiles b  where a.uid like '"
				+ user.getUid() + "%' order by b.userprogramprofileid";
		userProgramProfiles = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		return userProgramProfiles;
	}

	@Override
	public List<UserProgramProfile> getVisibleUserProgramProfiles(User user) {

		List<UserProgramProfile> userProgramProfiles = new ArrayList<UserProgramProfile>(
				0);
		String hql = "select b from  edu.uky.cepis.domain.User a join a.userProgramProfiles b  where a.uid like '"
				+ user.getUid()
				+ "' and b.hiddenToStudent='N' order by b.userprogramprofileid";
		userProgramProfiles = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		return userProgramProfiles;
	}

}
