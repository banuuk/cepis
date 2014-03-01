/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserPersonalProfile;

/**
 * @author cawalk4
 * 
 */
public class UserPersonalProfileDaoImpl implements UserPersonalProfileDao {

	private static Logger log = Logger.getLogger(UserPersonalProfileDaoImpl.class);
	private SessionFactory sessionFactory;
	
	@Override
	public boolean deleteUserPersonalProfile(UserPersonalProfile userPersonalProfile) {
		log.info("Entered UserPersonalProfileDaoImpl deleteUserPersonalProfile");
		
		if (userPersonalProfile == null) {
			return false;
		}else{
			getSessionFactory().getCurrentSession().delete(userPersonalProfile);
			return true;
		}		
	}
	
	@Override
	public boolean saveOrUpdateUserPersonalProfile(UserPersonalProfile userPersonalprofile) {
		log.info("Entered UserPersonalProfileDaoImpl saveOrUpdateUserPersonalProfile");
		
		if(userPersonalprofile == null){
			return false;
		}else{
			this.sessionFactory.getCurrentSession().saveOrUpdate(userPersonalprofile);
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserPersonalProfile findUserPersonalProfileById(String userpersonalprofileid) {

		List<UserPersonalProfile> userPersonalProfiles = new ArrayList<UserPersonalProfile>(0);
		String hql = "select a from UserPersonalProfile a where a.userpersonalprofileid="
			+ userpersonalprofileid;
		
		userPersonalProfiles = this.sessionFactory.getCurrentSession().createQuery(hql).list();
		
		UserPersonalProfile userPersonalProfile = null;
		
		if (userPersonalProfiles.size() > 0) {
			userPersonalProfile = userPersonalProfiles.get(0);
		}
		return userPersonalProfile;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserPersonalProfile> findUserPersonalProfileByExample(User user, UserPersonalProfile userPersonalProfile) {
		
		Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(User.class, "user");
		
		searchCriteria.add(Property.forName("user.uid").eq(user.getUid()));
		
		searchCriteria = searchCriteria.createAlias("user.userPersonalProfiles", "upp", JoinType.LEFT_OUTER_JOIN);
		
		
		if (userPersonalProfile.getEthnic() != null) {
			searchCriteria.add(Property.forName("upp.ethnic.code").eq(userPersonalProfile.getEthnic().getCode()));
		}
		if (userPersonalProfile.getCitizen() != null) {
			searchCriteria.add(Property.forName("upp.citizen").eq(userPersonalProfile.getCitizen()));
		}
		if (userPersonalProfile.getDiplomaType() != null) {
			searchCriteria.add(Property.forName("upp.diplomaType").eq(userPersonalProfile.getDiplomaType()));
		}
		if (userPersonalProfile.getDiplomaState() != null) {
			searchCriteria.add(Property.forName("upp.diplomaState").eq(userPersonalProfile.getDiplomaState()));
		}
		if (userPersonalProfile.getDiplomaYear() != null) {
			searchCriteria.add(Property.forName("upp.diplomaYear").eq(userPersonalProfile.getDiplomaYear()));
		}
		if (userPersonalProfile.getHighSchool() != null) {
			searchCriteria.add(Property.forName("upp.highSchool").eq(userPersonalProfile.getHighSchool()));
		}
		if (userPersonalProfile.getHighSchoolCity() != null) {
			searchCriteria.add(Property.forName("upp.highSchoolCity").eq(userPersonalProfile.getHighSchoolCity()));
		}
		if (userPersonalProfile.getHighSchoolCounty() != null) {
			searchCriteria.add(Property.forName("upp.highSchoolCounty").eq(userPersonalProfile.getHighSchoolCounty()));
		}

		if(!searchCriteria.list().isEmpty()){
			return (List<UserPersonalProfile>)searchCriteria.list();
		}else{
			return new ArrayList<UserPersonalProfile>();
		}
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public UserPersonalProfile getUserPersonalProfile(User user) {

		if(user != null){
			Criteria searchCriteria = getSessionFactory().getCurrentSession().createCriteria(UserPersonalProfile.class);
			
			searchCriteria.createAlias("user", "user");
			searchCriteria.add(Restrictions.like("user.uid", user.getUid()));
			
			if(!searchCriteria.list().isEmpty()){				
				List<UserPersonalProfile> userProgramProfile = searchCriteria.list();
				return userProgramProfile.get(0);
			}else{
				return new UserPersonalProfile();
			}
		}else{
			return new UserPersonalProfile();
		}		
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
