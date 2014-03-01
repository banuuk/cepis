

package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.FeeDao;
import edu.uky.cepis.domain.Fee;
import edu.uky.cepis.domain.embeddedId.FeePK;

/**
 * @author cawalk4
 *
 */
public class FeeServiceImpl implements FeeService{
	
	private FeeDao feeDao;

	@Override
	public Fee findFeeById(FeePK id) {
		return getFeeDao().findFeeById(id);
	}

	@Override
	public List<Fee> findFeeByExample(Fee fee) {
		return getFeeDao().findFeeByExample(fee);
	}

	@Override
	public boolean saveOrUpdateFee(Fee fee) {
		return getFeeDao().saveOrUpdateFee(fee);
	}

	@Override
	public boolean deleteFee(Fee fee) {
		return getFeeDao().deleteFee(fee);
	}

	public FeeDao getFeeDao() {
		return feeDao;
	}

	public void setFeeDao(FeeDao feeDao) {
		this.feeDao = feeDao;
	}
	
	
}