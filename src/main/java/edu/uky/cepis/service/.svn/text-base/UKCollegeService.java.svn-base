/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;
import edu.uky.cepis.domain.component.UKCollege;
import edu.uky.cepis.domain.component.UKDepartment;

/**
 * @author keerthi
 * 
 */
public interface UKCollegeService {
	public UKCollege createUKCollege(String ukCollegeCode, String collegeName,
			String collegeAddress, String collegeSpeedSort,
			String collegePhone, String collegeDeanName);

	public UKCollege updateUKCollege(UKCollege UKCollege, String ukCollegeCode,
			String collegeName, String collegeAddress, String collegeSpeedSort,
			String collegePhone, String collegeDeanName);

	public boolean deleteUKCollege(UKCollege UKCollege);

	public UKCollege findUKCollegeByCode(String ukCollegeCode);

	public UKCollege findUKCollegeByName(String collegeName);

	public UKCollege findUKCollegeByDean(String deanName);

	public List<UKCollege> getUKCollegeList();

	public boolean saveUKCollege(UKCollege UKCollege);

	public boolean addUKDepartmentToUKCollege(UKDepartment uKDepartment,
			UKCollege UKCollege);

	public boolean removeUKDepartmentFromUKCollege(UKDepartment uKDepartment,
			UKCollege UKCollege);
}
