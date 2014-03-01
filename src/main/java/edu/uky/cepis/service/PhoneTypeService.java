package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.domain.PhoneType;

public interface PhoneTypeService {
	public PhoneType createPhoneType(String code, String desc);

	public PhoneType updatePhoneType(PhoneType phoneType, String code,
			String desc);

	public boolean deletePhoneType(PhoneType phoneType);

	public PhoneType findPhoneTypeByCode(String code);

	public List<PhoneType> getPhoneTypeList();

}
