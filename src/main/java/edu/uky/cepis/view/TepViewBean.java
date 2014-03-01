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



/**
 * @author cawalk4
 *
 */
public class TepViewBean extends CepisWebView implements TepView {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public TepAdmission findTepAdmissionById(long id){
		return this.getTepAdmissionService().findTepAdmissionById(id);
	}
	
	@Override
	public boolean saveOrUpdateTepAdmission(TepAdmission tepAdmission){
		return this.getTepAdmissionService().saveOrUpdateTepAdmission(tepAdmission);
	}
	
	@Override
	public boolean deleteTepAdmission(TepAdmission tepAdmission){
		return this.getTepAdmissionService().deleteTepAdmission(tepAdmission);
	}
	
	@Override
	public List<TepAdmission> getTepAdmissionByExample(TepAdmission tepAdmission){
		return this.getTepAdmissionService().getTepAdmissionByExample(tepAdmission);
	}
	
	@Override
	public List<TepAdmission> getTepAdmissionForUser(User user){
		return this.getTepAdmissionService().getTepAdmissionForUser(user);
	}
	
	@Override
	public List<UKTerm> getUKTermList(){
		return this.getUkTermService().getUKTermList();
	}
	
	@Override
	public UKTerm findUKTermByID(long uktermid){
		return this.getUkTermService().findUKTermByID(uktermid);
	}
	
	@Override
	public UKTerm findUKTermByCode(String ukTermCode){
		return this.getUkTermService().findUKTermByCode(ukTermCode);
	}

	@Override
	public ReportYear findReportYearByCode(String reportYearCode){
		return this.getReportYearService().findReportYearByCode(reportYearCode);
	}
	
	@Override
	public List<ReportYear> getReportYears(){
		return this.getReportYearService().getReportYears();
	}
	
	@Override
	public GreTestScore findById(long id){
		return this.getGreTestScoreService().findById(id);
	}

	@Override
	public List<GreTestScore> findGreTestScoreByExample(GreTestScore greTestScore){
		return this.getGreTestScoreService().findGreTestScoreByExample(greTestScore);
	}
	
	@Override
	public List<PraxisIITestScore> getPraxisIITestScoreList(User user) {
		return this.getPraxisIITestScoreService().getPraxisIITestScoreList(user);
	}
	
	@Override
	public PraxisIITestScore findPraxisIITestScoreById(long id){
		return this.getPraxisIITestScoreService().findPraxisIITestScoreById(id);
	}

	@Override
	public PraxisITestScore findPraxisITestScoreById(long id){
		return this.getPraxisITestScoreService().findPraxisITestScoreById(id);
	}

	@Override
	public List<PraxisITestScore> getPraxisITestScores(User user){
		return this.getPraxisITestScoreService().getPraxisITestScores(user);
	}

	@Override
	public List<UserProgramProfile> getVisibleUserProgramProfiles(User user) {
		return this.getUserProgramProfileService().getVisibleUserProgramProfiles(user);
	}

	@Override
	public boolean saveUserProgramProfile(UserProgramProfile userProgramprofile) {
		return this.getUserProgramProfileService().saveUserProgramProfile(userProgramprofile);
	}
	
	@Override
	public ApplicationStatus findApplicationStatusByCode(String code) {
		return this.getApplicationStatusService().findApplicationStatusByCode(code);
	}

	@Override
	public List<ApplicationStatus> getApplicationStatusList() {
		return this.getApplicationStatusService().getApplicationStatusList();
	}

	@Override
	public TepApplication findTepApplicationById(long id) {
		return this.getTepApplicationService().findTepApplicationById(id);
	}

	@Override
	public boolean saveOrUpdateTepApplication(TepApplication tepApplication) {
		return this.getTepApplicationService().saveOrUpdateTepApplication(tepApplication);
	}

	@Override
	public boolean deleteTepApplication(TepApplication tepApplication) {
		return this.getTepApplicationService().deleteTepApplication(tepApplication);
	}

	@Override
	public List<TepApplication> getTepApplicationByExample(TepApplication tepApplication) {
		return this.getTepApplicationService().getTepApplicationByExample(tepApplication);
	}	

	@Override
	public List<TepApplication> getTepApplicationForUser(User user) {
		return this.getTepApplicationService().getTepApplicationForUser(user);
	}	

	@Override
	public CharacterAndFitness findCharacterAndFitnessById(long id) {
		return this.getCharacterAndFitnessService().findCharacterAndFitnessById(id);
	}

	@Override
	public List<CharacterAndFitness> findCharacterAndFitnessByExample(CharacterAndFitness characterAndFitness) {
		return this.getCharacterAndFitnessService().findCharacterAndFitnessByExample(characterAndFitness);
	}

	@Override
	public boolean saveOrUpdateCharacterAndFitness(CharacterAndFitness characterAndFitness) {
		return this.getCharacterAndFitnessService().saveOrUpdateCharacterAndFitness(characterAndFitness);
	}

	@Override
	public boolean deleteCharacterAndFitness(CharacterAndFitness characterAndFitness) {
		return this.getCharacterAndFitnessService().deleteCharacterAndFitness(characterAndFitness);
	}

	@Override
	public List<CharacterAndFitness> getCharacterAndFitnessForUser(User user) {
		return this.getCharacterAndFitnessService().getCharacterAndFitnessForUser(user);
	}
	
	@Override
	public Letter findLetterById(long id) {
		return this.getLetterService().findLetterById(id);
	}

	@Override
	public List<Letter> getLettersByExample(Letter letter) {
		return this.getLetterService().getLettersByExample(letter);
	}

	@Override
	public boolean saveOrUpdateLetter(Letter letter) {
		return this.getLetterService().saveOrUpdateLetter(letter);
	}

	@Override
	public boolean deleteLetter(Letter letter) {
		return this.getLetterService().deleteLetter(letter);
	}

	@Override
	public Fee findFeeById(FeePK id) {
		return this.getFeeService().findFeeById(id);
	}

	@Override
	public List<Fee> findFeeByExample(Fee fee) {
		return this.getFeeService().findFeeByExample(fee);
	}

	@Override
	public boolean saveOrUpdateFee(Fee fee) {
		return this.getFeeService().saveOrUpdateFee(fee);
	}

	@Override
	public boolean deleteFee(Fee fee) {
		return this.getFeeService().deleteFee(fee);
	}

	@Override
	public List<Letter> getLettersForUser(User user) {
		return this.getLetterService().getLettersForUser(user);
	}

	@Override
	public EmailAddress getUKYEmailAddress(User user) {
		return this.getEmailAddressService().getUKYEmailAddress(user);
	}
}