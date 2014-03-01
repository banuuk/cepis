/**
 * 
 */
package edu.uky.cepis.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.efs.openreports.providers.ProviderException;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;

import edu.uky.cepis.domain.Address;
import edu.uky.cepis.domain.AdvisingSession;
import edu.uky.cepis.domain.AdvisingSessionSlot;
import edu.uky.cepis.domain.Advisor;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserProgramProfile;
import edu.uky.cepis.domain.component.Program;

/**
 * @author scott
 * @author keerthi
 * @author cawalk4
 * 
 */
public class AdvisingSessionDaoImpl implements AdvisingSessionDao {
	private static Logger log = Logger.getLogger(AdvisingSessionDaoImpl.class);
	private Scheduler scheduler;
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public AdvisingSession findById(String id) {
		List<AdvisingSession> advisingSessions = new ArrayList<AdvisingSession>(
				0);
		String hql = "select a from AdvisingSession a where a.id = '" + id
				+ "'";
		advisingSessions = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (advisingSessions.size() > 0)
			return advisingSessions.get(0);
		return null;
	}

	/**
	 * Location Codes: 00 - Unknown location 01 - 166 Taylor Education Building
	 * 02 - 148 Seaton Center
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public String getAppointmentLocation(User user) {
		List<UserProgramProfile> userProgramProfiles = new ArrayList<UserProgramProfile>(
				0);
		String hql = "select b from  edu.uky.cepis.domain.User a join a.userProgramProfiles b  where a.uid like '"
				+ user.getUid() + "%' order by b.userprogramprofileid";
		userProgramProfiles = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		int loc = 1;
		String location = null;
		UserProgramProfile upp = null;
		Program p = null;
		if (userProgramProfiles != null) {
			Iterator<UserProgramProfile> iter = userProgramProfiles.iterator();
			while (iter.hasNext()) {
				upp = iter.next();
				p = upp.getProgram();
				if (p == null) {
					continue;
				}
				// Add more program for custom locations
				if (p.getProgramCode().contains("KINE")
						|| p.getProgramCode().contains("HEPR")) {
					loc = 2;
				}
			}
		}
		switch (loc) {
		case 2:
			location = "148 Seaton Center";
			break;
		default:
			location = "166 Taylor Education Building";
			break;
		}
		return location;
	}

	/**
	 * 
	 * @param advisor
	 * @return
	 */
	@Override
	public String getAppointmentLocation(Advisor advisor) {
		String location = "166 Taylor Education Building";
		if (advisor == null) {
			return location;
		}
		Advisor newadvisor = (Advisor) this.sessionFactory.getCurrentSession()
				.load(Advisor.class, advisor.getUserid());
		if (newadvisor == null) {
			return location;
		}
		Address advisorOfficeLocation = newadvisor.getOfficeLocation();
		if (advisorOfficeLocation == null) {
			advisorOfficeLocation = this.findAddressByAdvisorUID(newadvisor
					.getUserid());
		}
		if (advisorOfficeLocation != null) {
			return advisorOfficeLocation.getStreet1() + " "
					+ advisorOfficeLocation.getStreet2();
		}
		return location;
	}

	public Address findAddressByAdvisorUID(String UID) {
		List<Address> addresses = new ArrayList<Address>(0);
		if (UID == null || UID.equals("")) {
			return null;
		}

		String hql = "select b from edu.uky.cepis.domain.User a join a.addresses b where a.uid = '"
				+ UID + "' and b.addressType.code = 'Office'";
		addresses = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		if (addresses.size() > 0) {
			return addresses.get(0);
		}
		return null;
	}

	@Override
	public synchronized boolean addAdvisingSession(User user, Advisor advisor,
			AdvisingSessionSlot advisingSessionSlot, String sessionType,
			String sessionStatus, String preSessionText, String sessionText,
			String studentNotes, String advisorNotes) {

		if (user == null || advisor == null || advisingSessionSlot == null) {
			return false;
		}

		// Check if someone else scheduled this slot
		AdvisingSessionSlot newadvisingsessionslot = (AdvisingSessionSlot) this.sessionFactory
				.getCurrentSession().load(AdvisingSessionSlot.class,
						advisingSessionSlot.getId());
		if (newadvisingsessionslot.getStatus().compareTo("Available") != 0) {
			return false;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		Advisor newadvisor = (Advisor) this.sessionFactory.getCurrentSession()
				.load(Advisor.class, advisor.getUserid());

		if (newuser == null || newadvisor == null) {
			return false;
		}

		// calculate the date/time of the appointment from the slot
		int year, month, day, hour, minute = 0;
		String s;
		DateFormat formatter;
		Date slotDate = null;

		if (advisingSessionSlot != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(advisingSessionSlot.getSlotDate());

			formatter = new SimpleDateFormat("yyyy.MM.dd.HH.mm");

			// get the details
			slotDate = advisingSessionSlot.getSlotDate();
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH) + 1;
			day = cal.get(Calendar.DAY_OF_MONTH);

			hour = (int) Math.floor(9 + advisingSessionSlot.getSlotNumber()
					* 30 / 60 - 1);

			if (!((advisingSessionSlot.getSlotNumber() % 2) == 0))
				minute = 30;

			s = String.format("%d.%d.%d.%d.%d", year, month, day, hour, minute);

			try {
				slotDate = (Date) formatter.parse(s);
			} catch (ParseException e) {
				log.debug(e.getMessage());
			}
		}

		AdvisingSession advisingSession = new AdvisingSession(
				RandomStringUtils.randomNumeric(32), slotDate, sessionType,
				sessionStatus, preSessionText, sessionText, studentNotes,
				advisorNotes, advisingSessionSlot, newuser, newadvisor);

		advisingSession.getAdvisingSessionSlot().setStatus("Scheduled");

		if (!this.saveAdvisingSession(advisingSession)) {
			return false;
		}

		newuser.getAdvisingSessions().add(advisingSession);
		newadvisor.getAdvisingSessions().add(advisingSession);

		this.sessionFactory.getCurrentSession().saveOrUpdate(newuser);
		this.sessionFactory.getCurrentSession().saveOrUpdate(newadvisor);
		return true;
	}

	@Override
	public AdvisingSession cancelAdvisingSession(AdvisingSession advisingSession) {
		log.debug("Got in the cancel advising session dao");
		if (advisingSession == null) {
			return advisingSession;
		}

		String apptSummary = advisingSession.getSessionText();
		AdvisingSession newadvisingsession = (AdvisingSession) this.sessionFactory
				.getCurrentSession().load(AdvisingSession.class,
						advisingSession.getAdvisingSessionID());

		if (newadvisingsession == null) {
			return null;
		}

		if (newadvisingsession.getAdvisingSessionSlot() == null) {
			return null;
		}
		// free the slot
		newadvisingsession.getAdvisingSessionSlot().setStatus("Available");
		newadvisingsession.setAdvisingSessionSlot(null);

		// keep the session but set its new status
		newadvisingsession.setSessionStatus("Cancelled");
		newadvisingsession.setSessionText(apptSummary);
		this.saveAdvisingSession(newadvisingsession);
		return newadvisingsession;
	}

	@Override
	public boolean removeAdvisingSession(AdvisingSession advisingSession) {
		log.debug("Got in the remove advising session dao");

		User user = advisingSession.getUser();
		Advisor advisor = advisingSession.getAdvisor();

		if (user == null || advisor == null || advisingSession == null) {
			return false;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		Advisor newadvisor = (Advisor) this.sessionFactory.getCurrentSession()
				.load(Advisor.class, advisor.getUserid());
		AdvisingSession newadvisingsession = (AdvisingSession) this.sessionFactory
				.getCurrentSession().load(AdvisingSession.class,
						advisingSession.getAdvisingSessionID());

		if (newuser == null || newadvisor == null || newadvisingsession == null) {
			return false;
		}

		Set<AdvisingSession> userAdvisingSessions = newuser
				.getAdvisingSessions();
		Set<AdvisingSession> advisorAdvisingSessions = newadvisor
				.getAdvisingSessions();

		// free the slot
		if (newadvisingsession.getAdvisingSessionSlot() != null) {
			newadvisingsession.getAdvisingSessionSlot().setStatus("Available");
		}

		// delete the session
		if (userAdvisingSessions.contains(newadvisingsession)
				&& advisorAdvisingSessions.contains(newadvisingsession)) {
			userAdvisingSessions.remove(newadvisingsession);
			advisorAdvisingSessions.remove(newadvisingsession);
			this.sessionFactory.getCurrentSession().delete(newadvisingsession);
			return true;
		}

		return false;
	}

	@Override
	public boolean saveAdvisingSession(AdvisingSession advisingSession) {

		this.sessionFactory.getCurrentSession().saveOrUpdate(advisingSession);
		return true;
	}

	@Override
	public AdvisingSession updateAdvisingSession(
			AdvisingSession advisingSession, String sessionType,
			String sessionStatus, String preSessionText, String sessionText,
			String studentNotes, String advisorNotes,
			AdvisingSessionSlot advisingSessionSlot, boolean noShowEmailSentBoolean) {
		if (advisingSession == null) {
			return null;
		}

		AdvisingSession newadvisingsession = (AdvisingSession) this.sessionFactory
				.getCurrentSession().load(AdvisingSession.class,
						advisingSession.getAdvisingSessionID());

		if (newadvisingsession == null) {
			return null;
		}

		newadvisingsession.setSessionType(sessionType);
		newadvisingsession.setSessionStatus(sessionStatus);
		newadvisingsession.setPreSessionText(preSessionText);
		newadvisingsession.setSessionText(sessionText);
		newadvisingsession.setStudentNotes(studentNotes);
		newadvisingsession.setAdvisorNotes(advisorNotes);
		newadvisingsession.setAdvisingSessionSlot(advisingSessionSlot);
		newadvisingsession.setLastEdit(new Date());
		newadvisingsession.setNoShowEmailSentBoolean(noShowEmailSentBoolean);

		this.saveAdvisingSession(newadvisingsession);
		return newadvisingsession;
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionList(User user,
			Date selectedDate) {
		List<AdvisingSession> advisingSessions = new ArrayList<AdvisingSession>(
				0);
		if (user == null || selectedDate == null) {
			return advisingSessions;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return advisingSessions;
		}
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(selectedDate);
		String hql = "select appt from User as user join user.advisingSessions appt where user.uid ='"
				+ newuser.getUid()
				+ "' and dayofmonth(appt.sessionDate)="
				+ calendar.get(Calendar.DAY_OF_MONTH)
				+ " and month(appt.sessionDate)="
				+ (calendar.get(Calendar.MONTH) + 1)
				+ " and year(appt.sessionDate)="
				+ calendar.get(Calendar.YEAR)
				+ " and appt.sessionStatus = 'Scheduled'";
		advisingSessions = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		return advisingSessions;
	}

	@Override
	public boolean checkInUser(User user, AdvisingSession advisingSession) {
		if (advisingSession == null || user == null) {
			return false;
		}

		User newuser = (User) this.sessionFactory.getCurrentSession().load(
				User.class, user.getUid());
		if (newuser == null) {
			return false;
		}
		AdvisingSession newadvisingsession = (AdvisingSession) this.sessionFactory
				.getCurrentSession().load(AdvisingSession.class,
						advisingSession.getAdvisingSessionID());

		if (newadvisingsession == null) {
			return false;
		}
		if (newuser.getAdvisingSessions().contains(newadvisingsession)) {
			newadvisingsession.setSessionStatus("Checked In");
			newadvisingsession.setLastEdit(new Date());
			this.saveAdvisingSession(newadvisingsession);
			return true;
		}
		return false;
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionList(User user) {
		List<AdvisingSession> advisingSessions = new ArrayList<AdvisingSession>(
				0);
		if (user == null) {
			return advisingSessions;
		}

		String hql = "select appt from User as user join user.advisingSessions appt where user.uid = '"
				+ user.getUid() + "' order by appt.sessionDate desc";
		advisingSessions = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		return advisingSessions;
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionList(Advisor advisor) {
		List<AdvisingSession> advisingSessions = new ArrayList<AdvisingSession>(
				0);
		if (advisor == null) {
			return advisingSessions;
		}

		Advisor newadvisor = (Advisor) this.sessionFactory.getCurrentSession()
				.load(Advisor.class, advisor.getUserid());

		if (newadvisor == null) {
			return advisingSessions;
		}
		advisingSessions = new ArrayList<AdvisingSession>(
				newadvisor.getAdvisingSessions());
		return advisingSessions;
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionList(Advisor advisor,
			Date selectedMonthDate) {
		List<AdvisingSession> advisingSessions = new ArrayList<AdvisingSession>(
				0);

		if (advisor == null || selectedMonthDate == null) {
			return advisingSessions;
		}
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(selectedMonthDate);

		String hql = "select distinct s from AdvisingSession s where s.advisor.userid like '"
				+ advisor.getUserid()
				+ "' and month(s.sessionDate)="
				+ (calendar.get(Calendar.MONTH) + 1)
				+ " and year(s.sessionDate)="
				+ calendar.get(Calendar.YEAR)
				+ " order by s.sessionDate";
		advisingSessions = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (advisingSessions.size() > 0)
			return advisingSessions;
		return new ArrayList<AdvisingSession>(0);
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionListForDay(Advisor advisor,
			Date selectedDate) {
		List<AdvisingSession> advisingSessions = new ArrayList<AdvisingSession>(
				0);
		String operation = "=";
		if (advisor == null) {
			return advisingSessions;
		}
		if (selectedDate == null) {
			log.debug("Selected Date is null");
			selectedDate = new Date();
			operation = ">=";
		}
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(selectedDate);

		String hql = "select distinct s from AdvisingSession s where s.advisor.userid like '"
				+ advisor.getUserid()
				+ "' and dayofmonth(s.sessionDate)"
				+ operation
				+ calendar.get(Calendar.DAY_OF_MONTH)
				+ " and month(s.sessionDate)"
				+ operation
				+ (calendar.get(Calendar.MONTH) + 1)
				+ " and year(s.sessionDate)"
				+ operation
				+ calendar.get(Calendar.YEAR) + " order by s.sessionDate";
		advisingSessions = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (advisingSessions.size() > 0)
			return advisingSessions;
		return new ArrayList<AdvisingSession>(0);
	}

	@Override
	public List<AdvisingSession> getAdvisingSessionListForDay(
			List<Advisor> advisors, Date selectedDate) {
		List<AdvisingSession> advisingSessions = new ArrayList<AdvisingSession>(
				0);

		String operation = "=";
		if (advisors.isEmpty()) {
			return advisingSessions;
		}
		if (selectedDate == null) {
			log.debug("Selected Date is null");
			selectedDate = new Date();
			operation = ">=";
		}

		// build a comma delimited string of advisors id's
		StringBuilder sb = new StringBuilder();
		for (Advisor a : advisors) {
			if (sb.length() > 0)
				sb.append(',');
			sb.append("'");
			sb.append(a.getUserid());
			sb.append("'");
		}

		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(selectedDate);

		String hql = "select distinct s from AdvisingSession s where s.advisor.userid in ("
				+ sb.toString()
				+ ") and dayofmonth(s.sessionDate)"
				+ operation
				+ calendar.get(Calendar.DAY_OF_MONTH)
				+ " and month(s.sessionDate)"
				+ operation
				+ (calendar.get(Calendar.MONTH) + 1)
				+ " and year(s.sessionDate)"
				+ operation
				+ calendar.get(Calendar.YEAR);
		advisingSessions = this.sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		if (advisingSessions.size() > 0)
			return advisingSessions;
		return new ArrayList<AdvisingSession>(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdvisingSession> getAdvisingSessionListForDays(
			List<Advisor> advisors, Date selectedStartDate, Date selectedEndDate) {
		List<AdvisingSession> advisingSessions = new ArrayList<AdvisingSession>(
				0);
		if (advisors.isEmpty()) {
			return advisingSessions;
		}

		if (selectedStartDate == null || selectedEndDate == null
				|| selectedStartDate.after(selectedEndDate)) {
			return advisingSessions;
		}

		// build a comma delimited string of advisors id's
		StringBuilder sb = new StringBuilder();
		for (Advisor a : advisors) {
			if (sb.length() > 0)
				sb.append(',');
			sb.append("'");
			sb.append(a.getUserid());
			sb.append("'");
		}

		Calendar calendar1 = GregorianCalendar.getInstance();
		calendar1.setTime(selectedStartDate);
		Calendar calendar2 = GregorianCalendar.getInstance();
		calendar2.setTime(selectedEndDate);

		String hql = "select distinct s from AdvisingSession s where s.advisor.userid in ("
				+ sb.toString()
				+ ") and s.sessionDate between :start and :end order by s.sessionDate";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("start", calendar1.getTime());
		query.setParameter("end", calendar2.getTime());
		advisingSessions = query.list();
		if (advisingSessions.size() > 0)
			return advisingSessions;
		return new ArrayList<AdvisingSession>(0);
	}

	/**
	 * @param scheduler
	 *            the scheduler to set
	 */
	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	/**
	 * @return the scheduler
	 */
	public Scheduler getScheduler() {
		return scheduler;
	}

	@Override
	public synchronized void scheduleReminderEmail(JobDetail jobDetail,
			SimpleTrigger trigger) throws ProviderException {
		System.out.print("Calling Reminderemail scheduler at ");
		try {
			log.debug(scheduler.scheduleJob(jobDetail, trigger));
		} catch (SchedulerException e) {
			throw new ProviderException(e);
		}

	}

	@Override
	public synchronized void deleteReminderEmail(String name, String group)
			throws ProviderException {
		System.out.print("Calling delete Reminderemail scheduler. Status: ");
		try {
			if (scheduler.getJobDetail(name, group) != null) {
				log.debug("Successful" + scheduler.deleteJob(name, group));
			} else {
				log.debug("Failed.");
			}
		} catch (SchedulerException e) {
			throw new ProviderException(e);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdvisingSession> getIncorrectAdvisingSessionList(
			Date currentDate, String status) {
		List<AdvisingSession> advisingSessions = new ArrayList<AdvisingSession>(0);
		if (currentDate == null) {
			return advisingSessions;
		}
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(currentDate);

		String hql = "select distinct s from AdvisingSession as s where s.sessionStatus = '"
				+ status + "' and s.sessionDate < :date";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("date", calendar.getTime());
		advisingSessions = query.list();
		if (advisingSessions.size() > 0)
			return advisingSessions;
		return new ArrayList<AdvisingSession>(0);
	}

	@Override
	public boolean updateAdvisingSessions(
			List<AdvisingSession> advisingSessions, String newStatus) {
		if (advisingSessions == null || advisingSessions.size() < 1) {
			return false;
		}
		Iterator<AdvisingSession> iter = advisingSessions.iterator();
		AdvisingSession advisingSession = null;
		while (iter.hasNext()) {
			advisingSession = iter.next();
			advisingSession.setSessionStatus(newStatus);
			this.sessionFactory.getCurrentSession().saveOrUpdate(
					advisingSession);
		}
		return true;
	}
	
	
	// Method to get all "new" no show slots ***Will be used to send no show e-mails
	@SuppressWarnings("unchecked")
	public List<AdvisingSession> getNewNoShowAdvisingSessions(){
		log.info("Entered AdvisngSessionDaoImpl getNoShowAdvisingSessions");
		
		Criteria searchCriteria = this.sessionFactory.getCurrentSession().createCriteria(AdvisingSession.class);
		
		// Add restriction to get all "OLD" appointments 
		// (appointments with date before the current date time)
		searchCriteria.add(Restrictions.lt("sessionDate", new Date()));
		
		// Add restriction to get all appointments where status equals Scheduled 
		// (Appointment would have been marked Complete - otherwise -> no show
		searchCriteria.add(Restrictions.eq("sessionStatus", "Scheduled"));
		
		// Add restriction to get only ones where e-mail has not beens sent.
		searchCriteria.add(Restrictions.eq("noShowEmailSent", 0));
		
		if(!searchCriteria.list().isEmpty()){
			return (List<AdvisingSession>) searchCriteria.list();
		}else{
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<AdvisingSession> getNoShowEmailList(){
		log.info("Entered AdvisngSessionDaoImpl getNoShowAdvisingSessions");
		
		Criteria searchCriteria = this.sessionFactory.getCurrentSession().createCriteria(AdvisingSession.class);
		
		// Add restriction to get all appointments where status equals Scheduled 
		// (Appointment would have been marked Complete - otherwise -> no show
		searchCriteria.add(Restrictions.eq("sessionStatus", "No Show"));
		
		// Add restriction to get only ones where e-mail has not beens sent.
		searchCriteria.add(Restrictions.eq("noShowEmailSent", 0));
		
		if(!searchCriteria.list().isEmpty()){
			return (List<AdvisingSession>) searchCriteria.list();
		}else{
			return null;
		}
	}
	
	
	
}
