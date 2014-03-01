/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import edu.uky.cepis.domain.AdvisingSession;
import edu.uky.cepis.domain.HoldLift;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author keerthi
 * 
 */
public interface HoldLiftService {
	public HoldLift findById(long id);

	public List<HoldLift> getHoldLiftsByLifter(User liftedBy);

	public List<HoldLift> getHoldLiftsByStudent(User user);

	public List<HoldLift> getAppointmentHoldLifts(AdvisingSession advisingSession);

	public boolean addHoldLift(AdvisingSession advisingSession, User liftedBy,
			UKTerm term);

	public HoldLift updateHoldLift(HoldLift holdLift, User liftedBy, UKTerm term);

	public boolean removeHoldLift(HoldLift holdLift);

}
