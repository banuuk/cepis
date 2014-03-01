/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.domain.AddressType;

/**
 * @author keerthi
 * 
 */
public interface AddressTypeService {

	public AddressType createAddressType(String code, String desc);

	public AddressType updateAddressType(AddressType addressType, String code,
			String desc);

	public boolean deleteAddressType(AddressType addressType);

	public AddressType findAddressTypeByCode(String code);

	public List<AddressType> getAddressTypeList();

}
