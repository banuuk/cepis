/**
 * 
 */
package edu.uky.cepis.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import edu.uky.cepis.dao.AdvisingSessionSlotDao;
import edu.uky.cepis.domain.AdvisingSessionSlot;
import edu.uky.cepis.domain.Advisor;

/**
 * @author scott
 */
public class AdvisingSessionSlotServiceImpl implements
		AdvisingSessionSlotService {

	/**
	 * @uml.property name="advisingSessionSlotDao"
	 * @uml.associationEnd
	 */
	private AdvisingSessionSlotDao advisingSessionSlotDao;

	/**
	 * @return the advisingSessionSlotDao
	 * @uml.property name="advisingSessionSlotDao"
	 */
	public AdvisingSessionSlotDao getAdvisingSessionSlotDao() {
		return advisingSessionSlotDao;
	}

	/**
	 * @param advisingSessionSlotDao
	 *            the advisingSessionSlotDao to set
	 * @uml.property name="advisingSessionSlotDao"
	 */
	public void setAdvisingSessionSlotDao(
			AdvisingSessionSlotDao advisingSessionSlotDao) {
		this.advisingSessionSlotDao = advisingSessionSlotDao;
	}

	@Override
	public AdvisingSessionSlot findById(String id) {
		return this.getAdvisingSessionSlotDao().findById(id);
	}

	@Override
	public boolean addAdvisingSessionSlotToAdvisor(Advisor advisor,
			int slotNumber, Date slotDate, String status) {
		return this.getAdvisingSessionSlotDao()
				.addAdvisingSessionSlotToAdvisor(advisor, slotNumber, slotDate,
						status);
	}

	@Override
	public boolean removeAdvisingSessionSlot(Advisor advisor,
			AdvisingSessionSlot advisingSessionSlot) {
		return this.getAdvisingSessionSlotDao().removeAdvisingSessionSlot(
				advisor, advisingSessionSlot);
	}

	@Override
	public boolean saveAdvisingSessionSlot(
			AdvisingSessionSlot advisingSessionSlot) {
		return this.getAdvisingSessionSlotDao().saveAdvisingSessionSlot(
				advisingSessionSlot);
	}

	@Override
	public boolean updateAdvisingSessionSlot(
			AdvisingSessionSlot advisingSessionSlot, int slotNumber,
			Date slotDate, String status) {
		return this.getAdvisingSessionSlotDao().updateAdvisingSessionSlot(
				advisingSessionSlot, slotNumber, slotDate, status);
	}

	@Override
	public Set<AdvisingSessionSlot> getAdvisingSessionSlotList(Advisor advisor) {
		return this.getAdvisingSessionSlotDao().getAdvisingSessionSlotList(
				advisor);
	}

	@Override
	public List<AdvisingSessionSlot> getAdvisingSessionSlotList(
			Advisor advisor, Date selectedWeekDate) {
		return this.getAdvisingSessionSlotDao().getAdvisingSessionSlotList(
				advisor, selectedWeekDate);
	}

	@Override
	public List<AdvisingSessionSlot> getAvailableAdvisingSessionSlotList(
			Advisor advisor, boolean timeConstraint) {
		return this.getAdvisingSessionSlotDao()
				.getAvailableAdvisingSessionSlotList(advisor, timeConstraint);
	}

	@Override
	public List<AdvisingSessionSlot> getOrphanAdvisingSessionSlotList(
			Date currentDate, String status) {
		return this.getAdvisingSessionSlotDao()
				.getOrphanAdvisingSessionSlotList(currentDate, status);
	}

	@Override
	public boolean removeAdvisingSessionSlots(
			List<AdvisingSessionSlot> advisingSlots) {
		return this.getAdvisingSessionSlotDao().removeAdvisingSessionSlots(
				advisingSlots);
	}
}
