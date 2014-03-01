package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.domain.Fee;
import edu.uky.cepis.domain.embeddedId.FeePK;



/**
 * @author cawalk4
 *
 */
public interface FeeService {
	
	public Fee findFeeById(FeePK id);
	
	public List<Fee> findFeeByExample(Fee fee);
	
	public boolean saveOrUpdateFee(Fee fee);
	
	public boolean deleteFee(Fee fee);
	
}