/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.Address;
import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.AdvisorGroup;
import edu.uky.cepis.domain.User;

/**
 * Hibernate-based DAO class for CRUD operation on {@link Advisor} object.<br>
 * 
 * {@link SessionFactory} object injected via Spring IoC.
 * 
 * @author keerthi
 * 
 */
@SuppressWarnings("unchecked")
public class AdvisorDaoImpl implements AdvisorDao {


	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.AdvisorDao#addAdvisorToGroup(edu.uky.cepis.domain.
	 * AdvisorGroup, edu.uky.cepis.domain.Advisor)
	 */
	@Override
	public boolean addAdvisorToGroup(AdvisorGroup advisorGroup, Advisor advisor) {
		if (advisorGroup == null || advisor == null) {
			return false;
		}
		AdvisorGroup newAdvisorGroup = (AdvisorGroup) this.sessionFactory
				.getCurrentSession().load(AdvisorGroup.class,
						advisorGroup.getId());
		Advisor newAdvisor = (Advisor) this.sessionFactory.getCurrentSession()
				.load(Advisor.class, advisor.getUserid());
		newAdvisorGroup.getAdvisors().add(newAdvisor);
		this.sessionFactory.getCurrentSession().saveOrUpdate(newAdvisorGroup);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.AdvisorDao#addAdvisorWrapToUser(edu.uky.cepis.domain
	 * .User, java.lang.String)
	 */
	@SuppressWarnings("unused")
	@Override
	public boolean addAdvisorWrapToUser(User user) {
		Advisor advisor = new Advisor(user.getUid());
		if (advisor == null) {
			return false;
		}
		this.saveAdvisor(advisor);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.AdvisorDao#createAdvisorGroup(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public AdvisorGroup createAdvisorGroup(String name, String shortDesc) {
		if (name == null) {
			return null;
		}
		AdvisorGroup advisorGroup = new AdvisorGroup(name, shortDesc);
		this.sessionFactory.getCurrentSession().saveOrUpdate(advisorGroup);
		return advisorGroup;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.AdvisorDao#deleteAdvisorGroup(edu.uky.cepis.domain.
	 * AdvisorGroup)
	 */
	@Override
	public boolean deleteAdvisorGroup(AdvisorGroup advisorGroup) {
		if (advisorGroup == null) {
			return false;
		}
		AdvisorGroup newAdvisorGroup = (AdvisorGroup) this.sessionFactory
				.getCurrentSession().load(AdvisorGroup.class,
						advisorGroup.getId());
		this.sessionFactory.getCurrentSession().delete(newAdvisorGroup);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.AdvisorDao#findAdvisorByID(long)
	 */
	@Override
	public Advisor findAdvisorByID(long advisorid) {
		if (advisorid < 0) {
			return null;
		}
		List<Advisor> advisors = null;
		Advisor advisor = null;
		String hql = "select a from Advisor a where a.advisorid =" + advisorid
				+ "";
		advisors = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (advisors.size() < 1) {
			return null;
		}
		advisor = advisors.get(0);

		return advisor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.AdvisorDao#findAdvisorByUser(java.lang.String)
	 */
	@Override
	public Advisor findAdvisorByUser(String userid) {
		if (userid == null) {
			return null;
		}
		if (userid.equals("")) {
			return null;
		}
		List<Advisor> advisors = null;
		Advisor advisor = null;
		String hql = "select a from Advisor a where a.userid ='" + userid + "'";
		advisors = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (advisors.size() < 1) {
			return null;
		}
		advisor = advisors.get(0);

		return advisor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.AdvisorDao#findAdvisorByUser(edu.uky.cepis.domain.User)
	 */
	@Override
	public Advisor findAdvisorByUser(User user) {
		if (user == null) {
			return null;
		}
		List<Advisor> advisors = null;
		Advisor advisor = null;
		String hql = "select a from Advisor a where a.userid ='"
				+ user.getUid() + "'";
		advisors = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (advisors.size() < 1) {
			return null;
		}
		advisor = advisors.get(0);

		return advisor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.AdvisorDao#getAdvisorGroupList()
	 */
	@Override
	public List<AdvisorGroup> getAdvisorGroupList() {

		List<AdvisorGroup> advisorGroups = new ArrayList<AdvisorGroup>(0);
		String hql = "select a from AdvisorGroup a  order by a.name";
		advisorGroups = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();

		return advisorGroups;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.AdvisorDao#getAdvisorList()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.AdvisorDao#getAdvisorList()
	 */
	@Override
	public List<Advisor> getAdvisorList() {

		List<Advisor> advisors = new ArrayList<Advisor>(0);
		String hql = "from Advisor a where a.shortDesc != null order by a.shortDesc";
		advisors = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();

		return advisors;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.AdvisorDao#getUser(edu.uky.cepis.domain.Advisor)
	 */
	@Override
	public User getUser(Advisor advisor) {

		List<User> users = new ArrayList<User>(0);
		String hql = "select a from User a where a.uid = '"
				+ advisor.getUserid() + "'";
		users = this.sessionFactory.getCurrentSession().createQuery(hql).list();
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uky.cepis.dao.AdvisorDao#isAdvisor(edu.uky.cepis.domain.User)
	 */
	@Override
	public boolean isAdvisor(User user) {
		if (this.findAdvisorByUser(user) == null) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.AdvisorDao#removeAdvisorFromGroup(edu.uky.cepis.domain
	 * .AdvisorGroup, edu.uky.cepis.domain.Advisor)
	 */
	@Override
	public boolean removeAdvisorFromGroup(AdvisorGroup advisorGroup,
			Advisor advisor) {
		if (advisorGroup == null || advisor == null) {
			return false;
		}
		AdvisorGroup newAdvisorGroup = (AdvisorGroup) this.sessionFactory
				.getCurrentSession().load(AdvisorGroup.class,
						advisorGroup.getId());
		Advisor newAdvisor = (Advisor) this.sessionFactory.getCurrentSession()
				.load(Advisor.class, advisor.getUserid());
		if (newAdvisorGroup.getAdvisors().contains(newAdvisor)) {
			newAdvisorGroup.getAdvisors().remove(newAdvisor);
		} else {
			return false;
		}
		this.sessionFactory.getCurrentSession().saveOrUpdate(newAdvisorGroup);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.AdvisorDao#removeAdvisorWrapFromUser(edu.uky.cepis.
	 * domain.Advisor)
	 */
	@Override
	public boolean removeAdvisorWrapFromUser(Advisor advisor) {
		if (advisor == null) {
			return false;
		}
		this.sessionFactory.getCurrentSession().delete(advisor);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.AdvisorDao#removeAdvisorWrapFromUser(edu.uky.cepis.
	 * domain.User)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.AdvisorDao#removeAdvisorWrapFromUser(edu.uky.cepis.
	 * domain.User)
	 */
	@Override
	public boolean removeAdvisorWrapFromUser(User user) {
		Advisor advisor = null;
		advisor = this.findAdvisorByUser(user);
		if (advisor == null) {
			return false;
		}
		this.sessionFactory.getCurrentSession().delete(advisor);
		return true;
	}

	/**
	 * 
	 * Hibernate save or update the {@link Advisor} object.
	 * 
	 * @param advisor
	 * @return
	 */
	public boolean saveAdvisor(Advisor advisor) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(advisor);
		return true;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.AdvisorDao#updateAdvisor(edu.uky.cepis.domain.Advisor)
	 */
	@Override
	public boolean updateAdvisor(Advisor advisor, String shortDesc) {
		if (advisor == null) {
			return false;
		}
		advisor.setShortDesc(shortDesc);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.AdvisorDao#updateAdvisorGroup(edu.uky.cepis.domain.
	 * AdvisorGroup, java.lang.String, java.lang.String)
	 */
	@Override
	public AdvisorGroup updateAdvisorGroup(AdvisorGroup advisorGroup,
			String name, String shortDesc) {
		if (advisorGroup == null || name == null) {
			return null;
		}
		AdvisorGroup newAdvisorGroup = (AdvisorGroup) this.sessionFactory
				.getCurrentSession().load(AdvisorGroup.class,
						advisorGroup.getId());
		newAdvisorGroup.setName(name);
		newAdvisorGroup.setShortDesc(shortDesc);
		newAdvisorGroup.setLastEdit(new Date());
		this.sessionFactory.getCurrentSession().saveOrUpdate(newAdvisorGroup);
		return newAdvisorGroup;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uky.cepis.dao.AdvisorDao#updateAdvisorStatus(edu.uky.cepis.domain
	 * .Advisor, java.lang.String, edu.uky.cepis.domain.Address)
	 */
	@Override
	public boolean updateAdvisorStatus(Advisor advisor, String status,
			Address officeLocation) {
		if (advisor == null) {
			return false;
		}
		Address newaddress = null;
		Advisor newadvisor = (Advisor) this.sessionFactory.getCurrentSession()
				.load(Advisor.class, advisor.getUserid());
		if (officeLocation != null) {
			newaddress = (Address) this.sessionFactory.getCurrentSession()
					.load(Address.class, officeLocation.getId());
		}
		if (newadvisor == null) {
			return false;
		}
		newadvisor.setStatus(status);
		newadvisor.setOfficeLocation(newaddress);
		this.saveAdvisor(newadvisor);
		return true;
	}

}
