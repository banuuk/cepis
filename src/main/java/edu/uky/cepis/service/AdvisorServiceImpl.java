/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.AdvisorDao;
import edu.uky.cepis.domain.Address;
import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.AdvisorGroup;
import edu.uky.cepis.domain.User;

/**
 * @author keerthi
 */
public class AdvisorServiceImpl implements AdvisorService {

	/**
	 * @uml.property name="advisorDao"
	 * @uml.associationEnd
	 */
	private AdvisorDao advisorDao;

	/**
	 * @param advisorDao
	 *            the advisorDao to set
	 * @uml.property name="advisorDao"
	 */
	public void setAdvisorDao(AdvisorDao advisorDao) {
		this.advisorDao = advisorDao;
	}

	/**
	 * @return the advisorDao
	 * @uml.property name="advisorDao"
	 */
	public AdvisorDao getAdvisorDao() {
		return advisorDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.AdvisorService#addAdvisorWrapToUser(edu.uky.cepis
	 * .domain.User, java.lang.String)
	 */
	@Override
	public boolean addAdvisorWrapToUser(User user) {

		return this.getAdvisorDao().addAdvisorWrapToUser(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.AdvisorService#findAdvisorByID(long)
	 */
	@Override
	public Advisor findAdvisorByID(long advisorid) {

		return this.getAdvisorDao().findAdvisorByID(advisorid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.AdvisorService#findAdvisorByUser(edu.uky.cepis.
	 * domain.User)
	 */
	@Override
	public Advisor findAdvisorByUser(User user) {

		return this.getAdvisorDao().findAdvisorByUser(user);
	}

	@Override
	public Advisor findAdvisorByUser(String userid) {

		return this.getAdvisorDao().findAdvisorByUser(userid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.service.AdvisorService#getAdvisorList()
	 */
	@Override
	public List<Advisor> getAdvisorList() {

		return this.getAdvisorDao().getAdvisorList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.AdvisorService#isAdvisor(edu.uky.cepis.domain.User)
	 */
	@Override
	public boolean isAdvisor(User user) {

		return this.getAdvisorDao().isAdvisor(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.AdvisorService#removeAdvisorWrapFromUser(edu.uky
	 * .cepis.domain.User)
	 */
	@Override
	public boolean removeAdvisorWrapFromUser(User user) {

		return this.getAdvisorDao().removeAdvisorWrapFromUser(user);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.service.AdvisorService#updateAdvisor(edu.uky.cepis.domain
	 * .Advisor, java.lang.String)
	 */
	@Override
	public boolean updateAdvisor(Advisor advisor, String shortDesc) {

		return this.getAdvisorDao().updateAdvisor(advisor, shortDesc);
	}

	@Override
	public boolean removeAdvisorWrapFromUser(Advisor advisor) {
		return this.getAdvisorDao().removeAdvisorWrapFromUser(advisor);
	}

	@Override
	public boolean updateAdvisorStatus(Advisor advisor, String status,
			Address officeLocation) {
		return this.getAdvisorDao().updateAdvisorStatus(advisor, status,
				officeLocation);
	}

	@Override
	public User getUser(Advisor advisor) {
		return this.getAdvisorDao().getUser(advisor);
	}

	@Override
	public boolean addAdvisorToGroup(AdvisorGroup advisorGroup, Advisor advisor) {
		return this.getAdvisorDao().addAdvisorToGroup(advisorGroup, advisor);
	}

	@Override
	public AdvisorGroup createAdvisorGroup(String name, String shortDesc) {
		return this.getAdvisorDao().createAdvisorGroup(name, shortDesc);
	}

	@Override
	public boolean deleteAdvisorGroup(AdvisorGroup advisorGroup) {
		return this.getAdvisorDao().deleteAdvisorGroup(advisorGroup);
	}

	@Override
	public boolean removeAdvisorFromGroup(AdvisorGroup advisorGroup,
			Advisor advisor) {
		return this.getAdvisorDao().removeAdvisorFromGroup(advisorGroup,
				advisor);
	}

	@Override
	public AdvisorGroup updateAdvisorGroup(AdvisorGroup advisorGroup,
			String name, String shortDesc) {
		return this.getAdvisorDao().updateAdvisorGroup(advisorGroup, name,
				shortDesc);
	}

	@Override
	public List<AdvisorGroup> getAdvisorGroupList() {
		return this.getAdvisorDao().getAdvisorGroupList();
	}

}
