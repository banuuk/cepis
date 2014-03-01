/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.domain.component.UKDepartment;

/**
 * @author keerthi
 * 
 */
public interface UKDepartmentService {
	public UKDepartment createUKDepartment(String departmentCode,
			String departmentName, String departmentAddress, String speedSort,
			String departmentChairName, String departmentContact,
			String shortDescription, String status);

	public UKDepartment updateUKDepartment(UKDepartment UKDepartment,
			String departmentCode, String departmentName,
			String departmentAddress, String speedSort,
			String departmentChairName, String departmentContact,
			String shortDescription, String status);

	public boolean deleteUKDepartment(UKDepartment uKDepartment);

	public UKDepartment findUKDepartmentByCode(String uKDepartmentCode);

	public UKDepartment findUKDepartmentByName(String collegeName);

	public UKDepartment findUKDepartmentByChair(String chairName);

	public List<UKDepartment> getUKDepartmentList();

	public boolean saveUKDepartment(UKDepartment uKDepartment);

}
