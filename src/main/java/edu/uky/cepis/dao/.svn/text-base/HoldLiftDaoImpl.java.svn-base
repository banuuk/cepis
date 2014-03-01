/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;

import edu.uky.cepis.domain.AdvisingSession;
import edu.uky.cepis.domain.HoldLift;
import edu.uky.cepis.domain.Phone;
import edu.uky.cepis.domain.PhoneType;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author keerthi
 * 
 */
public class HoldLiftDaoImpl implements HoldLiftDao {

	private static Logger log = Logger.getLogger(HoldLiftDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public HoldLift findById(long id) {
		List<HoldLift> holdLifts = new ArrayList<HoldLift>(0);

		String hql = "select a from HoldLift a where a.id = " + id;
		holdLifts = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (holdLifts.size() > 0)
			return holdLifts.get(0);
		return null;
	}

	@Override
	public List<HoldLift> getHoldLiftsByLifter(User liftedBy) {
		List<HoldLift> holdLifts = new ArrayList<HoldLift>(0);

		String hql = "select a from HoldLift a where a.liftedBy = '"
				+ liftedBy.getUid() + "' order by a.term desc";
		holdLifts = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return holdLifts;
	}

	@Override
	public List<HoldLift> getHoldLiftsByStudent(User user) {
		List<HoldLift> holdLifts = new ArrayList<HoldLift>(0);
		if (user == null) {
			return holdLifts;
		}

		String hql = "select b from AdvisingSession a join a.holdLifts b "
				+ "where a.user.uid='" + user.getUid()
				+ "' order by b.term desc";
		holdLifts = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return holdLifts;
	}

	@Override
	public List<HoldLift> getAppointmentHoldLifts(
			AdvisingSession advisingSession) {
		if (advisingSession == null) {
			return null;
		}

		AdvisingSession newAdvisingSession = (AdvisingSession) this.sessionFactory
				.getCurrentSession().load(AdvisingSession.class,
						advisingSession.getAdvisingSessionID());
		Set<HoldLift> appointmentHoldLifts = newAdvisingSession.getHoldLifts();
		List<HoldLift> holdLifts = new ArrayList<HoldLift>(appointmentHoldLifts);
		if (holdLifts.size() < 1) {
			return new ArrayList<HoldLift>(0);
		}
		return holdLifts;
	}

	@Override
	public boolean addHoldLift(AdvisingSession advisingSession, User liftedBy,
			UKTerm term) {
		if (advisingSession == null || liftedBy == null || term == null) {
			return false;
		}

		HoldLift holdLift = new HoldLift(liftedBy, term);
		if (holdLift == null) {
			System.out.println("Cannot create HoldLift ");
			return false;
		}
		if (!this.saveHoldLift(holdLift)) {
			return false;
		}
		AdvisingSession newAdvisingSession = (AdvisingSession) this.sessionFactory
				.getCurrentSession().load(AdvisingSession.class,
						advisingSession.getAdvisingSessionID());
		if (newAdvisingSession == null) {
			return false;
		}
		Set<HoldLift> holdLifts = newAdvisingSession.getHoldLifts();
		holdLifts.add(holdLift);
		this.saveHoldLift(holdLift);
		return true;

	}

	@Override
	public HoldLift updateHoldLift(HoldLift holdLift, User liftedBy, UKTerm term) {
		if (holdLift == null || liftedBy == null || term == null) {
			return null;
		}

		HoldLift newHoldLift = (HoldLift) this.sessionFactory
				.getCurrentSession().load(HoldLift.class, holdLift.getId());
		if (newHoldLift == null) {
			System.out.println("Cannot create HoldLift ");
			return null;
		}
		newHoldLift.setLiftedBy(liftedBy);
		newHoldLift.setTerm(term);
		this.saveHoldLift(newHoldLift);
		return newHoldLift;

	}

	@Override
	public boolean removeHoldLift(HoldLift holdLift) {
		if (holdLift == null) {
			return false;
		}

		HoldLift newHoldLift = (HoldLift) this.sessionFactory
				.getCurrentSession().load(HoldLift.class, holdLift.getId());
		if (newHoldLift == null) {
			System.out.println("Cannot load HoldLift ");
			return false;
		}
		this.sessionFactory.getCurrentSession().delete(newHoldLift);
		return true;

	}

	public boolean saveHoldLift(HoldLift holdLift) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(holdLift);
		return true;
	}

}
