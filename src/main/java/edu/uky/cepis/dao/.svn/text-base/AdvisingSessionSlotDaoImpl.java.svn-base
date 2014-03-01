/**
 * 
 */
package edu.uky.cepis.dao;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.uky.cepis.domain.AdvisingSessionSlot;
import edu.uky.cepis.domain.Advisor;

/**
 * @author scott
 * @author Keerthi
 * 
 */
public class AdvisingSessionSlotDaoImpl implements AdvisingSessionSlotDao {

	private static Logger log = Logger
			.getLogger(AdvisingSessionSlotDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public AdvisingSessionSlot findById(String id) {
		List<AdvisingSessionSlot> advisingSessionSlots = new ArrayList<AdvisingSessionSlot>(
				0);

		String hql = "select a from AdvisingSessionSlot a where a.id = '" + id
				+ "'";
		advisingSessionSlots = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (advisingSessionSlots.size() > 0)
			return advisingSessionSlots.get(0);
		return null;
	}

	public AdvisingSessionSlot findBySlot(Advisor advisor, int slotNumber,
			Date slotDate) {

		Advisor newadvisor = (Advisor) this.sessionFactory.getCurrentSession()
				.load(Advisor.class, advisor.getUserid());
		if (newadvisor == null) {
			return null;
		}

		Set<AdvisingSessionSlot> advisingSessionSlots = newadvisor
				.getAdvisingSessionSlots();
		Iterator<AdvisingSessionSlot> iter = advisingSessionSlots.iterator();
		while (iter.hasNext()) {
			AdvisingSessionSlot newadvisingsessionslot = iter.next();
			if (newadvisingsessionslot.getSlotDate().equals(slotDate)
					&& newadvisingsessionslot.getSlotNumber() == slotNumber) {
				return newadvisingsessionslot;
			}
		}
		return null;
	}

	@Override
	public boolean addAdvisingSessionSlotToAdvisor(Advisor advisor,
			int slotNumber, Date slotDate, String status) {
		if (advisor == null) {
			return false;
		}

		if (findBySlot(advisor, slotNumber, slotDate) != null) {
			System.out.println("Duplicate slot exists for this advisor");
			return false;
		}

		Advisor newadvisor = (Advisor) this.sessionFactory.getCurrentSession()
				.load(Advisor.class, advisor.getUserid());

		if (newadvisor == null) {
			return false;
		}

		AdvisingSessionSlot advisingSessionSlot = new AdvisingSessionSlot(
				RandomStringUtils.randomNumeric(32), slotNumber, slotDate,
				status, newadvisor);

		if (!this.saveAdvisingSessionSlot(advisingSessionSlot)) {
			return false;
		}

		newadvisor.getAdvisingSessionSlots().add(advisingSessionSlot);
		this.sessionFactory.getCurrentSession().saveOrUpdate(newadvisor);

		return true;
	}

	@Override
	public boolean removeAdvisingSessionSlot(Advisor advisor,
			AdvisingSessionSlot advisingSessionSlot) {
		if (advisor == null || advisingSessionSlot == null) {
			return false;
		}

		Advisor newadvisor = (Advisor) this.sessionFactory.getCurrentSession()
				.load(Advisor.class, advisor.getUserid());
		AdvisingSessionSlot newAdvisingSessionSlot = (AdvisingSessionSlot) this.sessionFactory
				.getCurrentSession().load(AdvisingSessionSlot.class,
						advisingSessionSlot.getId());

		if (newAdvisingSessionSlot == null) {
			return false;
		}
		Set<AdvisingSessionSlot> advisingSessionSlots = newadvisor
				.getAdvisingSessionSlots();

		if (advisingSessionSlots.contains(newAdvisingSessionSlot)) {
			System.out.println("Advisor has this slot");
			advisingSessionSlots.remove(newAdvisingSessionSlot);
			this.sessionFactory.getCurrentSession().delete(
					newAdvisingSessionSlot);
			return true;
		}
		System.out.println("User doesn have this event");
		return false;
	}

	@Override
	public boolean saveAdvisingSessionSlot(
			AdvisingSessionSlot advisingSessionSlot) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(
				advisingSessionSlot);
		return true;
	}

	@Override
	public boolean updateAdvisingSessionSlot(
			AdvisingSessionSlot advisingSessionSlot, int slotNumber,
			Date slotDate, String status) {

		Advisor advisor = advisingSessionSlot.getAdvisor();

		if (advisor == null || advisingSessionSlot == null) {
			return false;
		}

		Advisor newadvisor = (Advisor) this.sessionFactory.getCurrentSession()
				.load(Advisor.class, advisor.getUserid());
		AdvisingSessionSlot newAdvisingSessionSlot = (AdvisingSessionSlot) this.sessionFactory
				.getCurrentSession().load(AdvisingSessionSlot.class,
						advisingSessionSlot.getId());

		if (newadvisor == null || newAdvisingSessionSlot == null) {
			return false;
		}
		if (!newadvisor.getAdvisingSessionSlots().contains(
				newAdvisingSessionSlot)) {
			return false;
		}
		newAdvisingSessionSlot.setSlotNumber(slotNumber);
		newAdvisingSessionSlot.setSlotDate(slotDate);
		newAdvisingSessionSlot.setStatus(status);
		this.saveAdvisingSessionSlot(newAdvisingSessionSlot);
		return true;
	}

	@Override
	public Set<AdvisingSessionSlot> getAdvisingSessionSlotList(Advisor advisor) {
		Set<AdvisingSessionSlot> advisingSessionSlots = new HashSet<AdvisingSessionSlot>(
				0);
		if (advisor == null) {
			return advisingSessionSlots;
		}

		Advisor newadvisor = (Advisor) this.sessionFactory.getCurrentSession()
				.load(Advisor.class, advisor.getUserid());
		if (newadvisor == null) {
			return advisingSessionSlots;
		}
		advisingSessionSlots = newadvisor.getAdvisingSessionSlots();
		return advisingSessionSlots;
	}

	@Override
	public List<AdvisingSessionSlot> getAdvisingSessionSlotList(
			Advisor advisor, Date selectedWeekDate) {
		List<AdvisingSessionSlot> advisingSessionSlots = new ArrayList<AdvisingSessionSlot>(
				0);
		if (advisor == null) {
			return advisingSessionSlots;
		}

		if (selectedWeekDate == null) {
			selectedWeekDate = new Date();
		}

		// get the week number of the selected date(do it this way to prevent
		// inconsistency between java/mysql functions for retrieving week num
		DateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd");

		String sql = "select week('" + formatter.format(selectedWeekDate)
				+ "')";
		List weekNumList = this.sessionFactory.getCurrentSession()
				.createSQLQuery(sql).list();

		BigInteger weekNum = (BigInteger) weekNumList.get(0);

		// get slots from the corresponding week number for the specified
		// advisor
		String hql = "select a from AdvisingSessionSlot as a inner join a.advisor as advisor where advisor.userid = '"
				+ advisor.getUserid() + "' and week(a.slotDate)=" + weekNum;

		advisingSessionSlots = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (advisingSessionSlots.size() > 0)
			return advisingSessionSlots;
		return new ArrayList<AdvisingSessionSlot>(0);
	}

	@Override
	public List<AdvisingSessionSlot> getAvailableAdvisingSessionSlotList(
			Advisor advisor, boolean timeConstraint) {
		List<AdvisingSessionSlot> advisingSessionSlots = new ArrayList<AdvisingSessionSlot>(
				0);
		if (advisor == null) {
			return advisingSessionSlots;
		}

		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());

		// impose a time constraint to restrict what slots students can schedule
		// for
		if (timeConstraint) {

			// 4pm today
			cal.set(Calendar.AM_PM, Calendar.PM);
			cal.set(Calendar.HOUR, 4);
			cal.set(Calendar.MINUTE, 0);

			// Is it before 4pm today?
			if (new Date().compareTo(cal.getTime()) < 0) {
				cal.setTime(new Date());
				cal.add(Calendar.DAY_OF_MONTH, 1);
			} else {
				cal.setTime(new Date());
				cal.add(Calendar.DAY_OF_MONTH, 2);
			}
		} // else, gets all available slots from the current time forward

		String hql = "select a from AdvisingSessionSlot as a inner join a.advisor as advisor where advisor.userid = '"
				+ advisor.getUserid()
				+ "' and '"
				+ new java.sql.Date(cal.getTimeInMillis())
				+ "' <= a.slotDate and a.status = 'Available'";

		advisingSessionSlots = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (advisingSessionSlots.size() > 0)
			return advisingSessionSlots;
		return new ArrayList<AdvisingSessionSlot>(0);
	}

	@Override
	public List<AdvisingSessionSlot> getOrphanAdvisingSessionSlotList(
			Date currentDate, String status) {
		List<AdvisingSessionSlot> advisingSessionSlots = new ArrayList<AdvisingSessionSlot>(
				0);
		if (status == null || status.isEmpty()) {
			return advisingSessionSlots;
		}
		if (currentDate == null) {
			currentDate = new Date();
		}
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.DAY_OF_MONTH, -5);
		log.debug("Removing all the Orphan slots dated before "
				+ calendar.getTime());
		// get old unscheduled slots based on the given date
		String hql = "select distinct s from AdvisingSessionSlot as s where s.status = '"
				+ status + "' and s.slotDate < :date";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setDate("date", calendar.getTime());

		advisingSessionSlots = query.list();
		if (advisingSessionSlots.size() > 0)
			return advisingSessionSlots;
		return new ArrayList<AdvisingSessionSlot>(0);
	}

	@Override
	public boolean removeAdvisingSessionSlots(
			List<AdvisingSessionSlot> advisingSlots) {
		if (advisingSlots == null || advisingSlots.size() < 1) {
			return false;
		}

		Iterator<AdvisingSessionSlot> iter = advisingSlots.iterator();
		while (iter.hasNext()) {
			this.sessionFactory.getCurrentSession().delete(iter.next());
		}
		return true;
	}
}
