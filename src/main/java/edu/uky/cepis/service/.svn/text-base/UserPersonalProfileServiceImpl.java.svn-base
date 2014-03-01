/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.UserPersonalProfileDao;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserPersonalProfile;

/**
 * @author  cawalk4
 */
public class UserPersonalProfileServiceImpl implements UserPersonalProfileService {

	
	private UserPersonalProfileDao userPersonalProfileDao;

	
	@Override
	public boolean deleteUserPersonalProfile(UserPersonalProfile userPersonalProfile) {
		return getUserPersonalProfileDao().deleteUserPersonalProfile(userPersonalProfile);
	}

	@Override
	public boolean saveOrUpdateUserPersonalProfile(UserPersonalProfile userPersonalprofile) {
		return getUserPersonalProfileDao().saveOrUpdateUserPersonalProfile(userPersonalprofile);
	}

	@Override
	public UserPersonalProfile findUserPersonalProfileById(String userpersonalprofileid) {
		return getUserPersonalProfileDao().findUserPersonalProfileById(userpersonalprofileid);
	}

	@Override
	public List<UserPersonalProfile> findUserPersonalProfileByExample(User user, UserPersonalProfile userPersonalProfile) {
		return getUserPersonalProfileDao().findUserPersonalProfileByExample(user, userPersonalProfile);
	}

	@Override
	public UserPersonalProfile getUserPersonalProfile(User user) {
		return getUserPersonalProfileDao().getUserPersonalProfile(user);
	}
	
	public UserPersonalProfileDao getUserPersonalProfileDao() {
		return userPersonalProfileDao;
	}

	public void setUserPersonalProfileDao(UserPersonalProfileDao userPersonalProfileDao) {
		this.userPersonalProfileDao = userPersonalProfileDao;
	}

}
