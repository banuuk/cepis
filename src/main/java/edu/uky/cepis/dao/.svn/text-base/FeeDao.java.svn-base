package edu.uky.cepis.dao;

import java.util.List;

import edu.uky.cepis.domain.Fee;
import edu.uky.cepis.domain.embeddedId.FeePK;

/**
 * @author cawalk4
 *
 */
public interface FeeDao{
	
	public Fee findFeeById(FeePK id);
	
	public List<Fee> findFeeByExample(Fee fee);
	
	public boolean saveOrUpdateFee(Fee fee);
	
	public boolean deleteFee(Fee fee);
	
}