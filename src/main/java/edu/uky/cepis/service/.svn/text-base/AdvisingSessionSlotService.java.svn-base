/**
 * 
 */
package edu.uky.cepis.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import edu.uky.cepis.domain.AdvisingSessionSlot;
import edu.uky.cepis.domain.Advisor;

/**
 * @author scott
 * 
 */
public interface AdvisingSessionSlotService {
	public abstract AdvisingSessionSlot findById(String id);

	public abstract boolean addAdvisingSessionSlotToAdvisor(Advisor advisor,
			int slotNumber, Date slotDate, String status);

	public abstract boolean removeAdvisingSessionSlot(Advisor advisor,
			AdvisingSessionSlot advisingSessionSlot);

	public abstract boolean saveAdvisingSessionSlot(
			AdvisingSessionSlot advisingSessionSlot);

	public abstract boolean updateAdvisingSessionSlot(
			AdvisingSessionSlot advisingSessionSlot, int slotNumber,
			Date slotDate, String status);

	public abstract Set<AdvisingSessionSlot> getAdvisingSessionSlotList(
			Advisor advisor);

	public abstract List<AdvisingSessionSlot> getAdvisingSessionSlotList(
			Advisor advisor, Date selectedWeekDate);
	
	public abstract List<AdvisingSessionSlot> getAvailableAdvisingSessionSlotList(
			Advisor advisor, boolean timeConstraint);
	
	public abstract List<AdvisingSessionSlot> getOrphanAdvisingSessionSlotList(
			Date currentDate, String status);
	public abstract boolean removeAdvisingSessionSlots(
			List<AdvisingSessionSlot> advisingSlots);
}
