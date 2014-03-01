package edu.uky.cepis.view;

import java.util.List;

import edu.uky.cepis.domain.ApplicationStatus;
import edu.uky.cepis.domain.CharacterAndFitness;
import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.Fee;
import edu.uky.cepis.domain.GreTestScore;
import edu.uky.cepis.domain.Letter;
import edu.uky.cepis.domain.PraxisIITestScore;
import edu.uky.cepis.domain.PraxisITestScore;
import edu.uky.cepis.domain.ReportYear;
import edu.uky.cepis.domain.TepAdmission;
import edu.uky.cepis.domain.TepApplication;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.domain.UserProgramProfile;
import edu.uky.cepis.domain.component.UKTerm;
import edu.uky.cepis.domain.embeddedId.FeePK;

public interface TepView{
	
	/***************************TEP ADMISSION***************************/	
	public abstract TepAdmission findTepAdmissionById(long id);
	
	public abstract boolean saveOrUpdateTepAdmission(TepAdmission tepAdmission);
	
	public abstract boolean deleteTepAdmission(TepAdmission tepAdmission);
	
	public abstract List<TepAdmission> getTepAdmissionByExample(TepAdmission tepAdmission);
	
	public abstract List<TepAdmission> getTepAdmissionForUser(User user);
	
	/***************************REPORT YEAR***************************/	
	public abstract ReportYear findReportYearByCode(String reportYearCode);
	
	public abstract List<ReportYear> getReportYears();
	
	/***************************UK TERM***************************/	
	public abstract List<UKTerm> getUKTermList();
	
	public abstract UKTerm findUKTermByID(long uktermid);
	
	public abstract UKTerm findUKTermByCode(String ukTermCode);

	/***************************GRE***************************/	
	public abstract GreTestScore findById(long id);
	
	public abstract List<GreTestScore> findGreTestScoreByExample(GreTestScore greTestScore);
	
	/***************************PraxisII***************************/
	public abstract List<PraxisIITestScore> getPraxisIITestScoreList(User user);

	public abstract PraxisIITestScore findPraxisIITestScoreById(long id);

	/***************************PraxisI***************************/	
	public abstract PraxisITestScore findPraxisITestScoreById(long id);

	public abstract List<PraxisITestScore> getPraxisITestScores(User user);
	
	/***************************PROGRAM PROFILE***************************/	
	public abstract List<UserProgramProfile> getVisibleUserProgramProfiles(User user);
	
	public abstract boolean saveUserProgramProfile(UserProgramProfile userProgramprofile);
	
	/***************************APPLICATION STATUS***************************/	
	public abstract ApplicationStatus findApplicationStatusByCode(String code);
	
	public abstract List<ApplicationStatus> getApplicationStatusList();
	
	/***************************TEP APPLICATION***************************/	
	public abstract TepApplication findTepApplicationById(long id);
	
	public abstract boolean saveOrUpdateTepApplication(TepApplication tepApplication);
	
	public abstract boolean deleteTepApplication(TepApplication tepApplication);
	
	public abstract List<TepApplication> getTepApplicationByExample(TepApplication tepApplication);
	
	public abstract List<TepApplication> getTepApplicationForUser(User user);
	
	/***************************CHARACTER AND FITNESS***************************/	
	public abstract CharacterAndFitness findCharacterAndFitnessById(long id);
	
	public abstract List<CharacterAndFitness> findCharacterAndFitnessByExample(CharacterAndFitness characterAndFitness);
	
	public abstract boolean saveOrUpdateCharacterAndFitness(CharacterAndFitness characterAndFitness);
	
	public abstract boolean deleteCharacterAndFitness(CharacterAndFitness characterAndFitness);
	
	public abstract List<CharacterAndFitness> getCharacterAndFitnessForUser(User user);
	/***************************REFERENCE LETTERS***************************/	
	public abstract Letter findLetterById(long id);
	
	public abstract List<Letter> getLettersByExample(Letter letter);
	
	public abstract boolean saveOrUpdateLetter(Letter letter);
	
	public abstract boolean deleteLetter(Letter letter);
	
	public abstract List<Letter> getLettersForUser(User user);
	
	/***************************FEES***************************/	
	public abstract Fee findFeeById(FeePK id);
	
	public abstract List<Fee> findFeeByExample(Fee fee);
	
	public abstract boolean saveOrUpdateFee(Fee fee);
	
	public abstract boolean deleteFee(Fee fee);
	
	/***************************EMAIL***************************/
	public abstract EmailAddress getUKYEmailAddress(User user);
}