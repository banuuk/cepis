/**
 * 
 */
package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.ReportYearDao;
import edu.uky.cepis.domain.ReportYear;

/**
 * @author cawalk4
 */
public class ReportYearServiceImpl implements ReportYearService {

	private ReportYearDao reportYearDao;
	
	@Override
	public ReportYear findReportYearByCode(String reportYearCode) {
		return getReportYearDao().findReportYearByCode(reportYearCode);
	}

	@Override
	public List<ReportYear> getReportYears() {
		return getReportYearDao().getReportYears();
	}
	
	public ReportYearDao getReportYearDao() {
		return reportYearDao;
	}

	public void setReportYearDao(ReportYearDao reportYearDao) {
		this.reportYearDao = reportYearDao;
	}
}
