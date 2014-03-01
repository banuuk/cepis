/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import edu.uky.cepis.dao.HoldLiftDao;
import edu.uky.cepis.domain.AdvisingSession;
import edu.uky.cepis.domain.HoldLift;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author keerthi
 * 
 */
public class HoldLiftServiceImpl implements HoldLiftService {

	private HoldLiftDao holdLiftDao;

	@Override
	public boolean addHoldLift(AdvisingSession advisingSession, User liftedBy,
			UKTerm term) {
		return this.getHoldLiftDao().addHoldLift(advisingSession, liftedBy,
				term);
	}

	@Override
	public HoldLift findById(long id) {
		return this.getHoldLiftDao().findById(id);
	}

	@Override
	public List<HoldLift> getAppointmentHoldLifts(AdvisingSession advisingSession) {
		return this.getHoldLiftDao().getAppointmentHoldLifts(advisingSession);
	}

	@Override
	public List<HoldLift> getHoldLiftsByLifter(User liftedBy) {
		return this.getHoldLiftDao().getHoldLiftsByLifter(liftedBy);
	}

	@Override
	public List<HoldLift> getHoldLiftsByStudent(User user) {
		return this.getHoldLiftDao().getHoldLiftsByStudent(user);
	}

	@Override
	public boolean removeHoldLift(HoldLift holdLift) {
		return this.getHoldLiftDao().removeHoldLift(holdLift);
	}

	@Override
	public HoldLift updateHoldLift(HoldLift holdLift, User liftedBy, UKTerm term) {
		return this.getHoldLiftDao().updateHoldLift(holdLift, liftedBy, term);
	}

	/**
	 * @param holdLiftDao
	 *            the holdLiftDao to set
	 */
	public void setHoldLiftDao(HoldLiftDao holdLiftDao) {
		this.holdLiftDao = holdLiftDao;
	}

	/**
	 * @return the holdLiftDao
	 */
	public HoldLiftDao getHoldLiftDao() {
		return holdLiftDao;
	}

}
