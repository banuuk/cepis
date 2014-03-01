/**
 * 
 */
package edu.uky.cepis.dao;

import java.util.List;

import edu.uky.cepis.domain.ReportYear;

/**
 * @author cawalk4
 * 
 */
public interface ReportYearDao {
	
	public abstract ReportYear findReportYearByCode(String reportYearCode);
	
	public abstract List<ReportYear> getReportYears();
	
}
