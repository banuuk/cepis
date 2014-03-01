/**
 * 
 */
package edu.uky.cepis.util.batch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

import edu.uky.cepis.domain.PraxisIITest;
import edu.uky.cepis.domain.PraxisIITestScore;
import edu.uky.cepis.domain.User;
import edu.uky.cepis.service.PraxisIITestScoreService;
import edu.uky.cepis.service.PraxisIITestService;
import edu.uky.cepis.service.UserService;
import edu.uky.cepis.util.global.CEPISGlobalComponentConfigurator;


/**
 * @author cawalk4
 * 
 */
public class PraxisTestScoresFieldSetMapper implements FieldSetMapper<List<PraxisIITestScore>> {

	private CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator;
	
	private PraxisIITestService praxisIITestService;
	
	private PraxisIITestScoreService praxisIITestScoreService;
	
	private UserService userService;
	
	private static Logger log = Logger.getLogger(PraxisTestScoresFieldSetMapper.class);
	
	// code,id,ssn,praxisid,lastname,firstname,middlename,gender,dob,street,city,state,zip,country,institution_code,edu_level,ugrad_major,grad_major,ugrad_gpa,ethnic_code,filler,cur_testdate1,cur_testcode1,cur_testscore1,cur_nai1,cur_rei1,cur_filler1,cur_testdate2,cur_testcode2,cur_testscore2,cur_nai2,cur_rei2,cur_filler2,cur_testdate3,cur_testcode3,cur_testscore3,cur_nai3,cur_rei3,cur_filler3,cur_testdate4,cur_testcode4,cur_testscore4,cur_nai4,cur_rei4,cur_filler4,cur_testdate5,cur_testcode5,cur_testscore5,cur_nai5,cur_rei5,cur_filler5,cur_testdate6,cur_testcode6,cur_testscore6,cur_nai6,cur_rei6,cur_filler6,high_testdate1,high_testcode1,high_testscore1,high_nai1,high_rsi1,high_rei1,high_testdate2,high_testcode2,high_testscore2,high_nai2,high_rsi2,high_rei2,high_testdate3,high_testcode3,high_testscore3,high_nai3,high_rsi3,high_rei3,high_testdate4,high_testcode4,high_testscore4,high_nai4,high_rsi4,high_rei4,high_testdate5,high_testcode5,high_testscore5,high_nai5,high_rsi5,high_rei5,high_testdate6,high_testcode6,high_testscore6,high_nai6,high_rsi6,high_rei6,high_testdate7,high_testcode7,high_testscore7,high_nai7,high_rsi7,high_rei7,high_testdate8,high_testcode8,high_testscore8,high_nai8,high_rsi8,high_rei8,high_testdate9,high_testcode9,high_testscore9,high_nai9,high_rsi9,high_rei9,high_testdate10,high_testcode10,high_testscore10,high_nai10,high_rsi10,high_rei10,prog_id,prog_create_date,state_code,full_testdate1,full_testcode1,full_testscore1,full_reqminscore1,full_minscore1,full_reqpassscore1,full_teststatus1,full_testdate2,full_testcode2,full_testscore2,full_reqminscore2,full_minscore2,full_reqpassscore2,full_teststatus2,full_testdate3,full_testcode3,full_testscore3,full_reqminscore3,full_minscore3,full_reqpassscore3,full_teststatus3,full_testdate4,full_testcode4,full_testscore4,full_reqminscore4,full_minscore4,full_reqpassscore4,full_teststatus4,full_testdate5,full_testcode5,full_testscore5,full_reqminscore5,full_minscore5,full_reqpassscore5,full_teststatus5,full_testdate6,full_testcode6,full_testscore6,full_reqminscore6,full_minscore6,full_reqpassscore6,full_teststatus6,full_testdate7,full_testcode7,full_testscore7,full_reqminscore7,full_minscore7,full_reqpassscore7,full_teststatus7,full_testdate8,full_testcode8,full_testscore8,full_reqminscore8,full_minscore8,full_reqpassscore8,full_teststatus8,full_testdate9,full_testcode9,full_testscore9,full_reqminscore9,full_minscore9,full_reqpassscore9,full_teststatus9,full_testdate10,full_testcode10,full_testscore10,full_reqminscore10,full_minscore10,full_reqpassscore10,full_teststatus10,full_testdate11,full_testcode11,full_testscore11,full_reqminscore11,full_minscore11,full_reqpassscore11,full_teststatus11,full_testdate12,full_testcode12,full_testscore12,full_reqminscore12,full_minscore12,full_reqpassscore12,full_teststatus12,full_testdate13,full_testcode13,full_testscore13,full_reqminscore13,full_minscore13,full_reqpassscore13,full_teststatus13,full_testdate14,full_testcode14,full_testscore14,full_reqminscore14,full_minscore14,full_reqpassscore14,full_teststatus14,full_testdate15,full_testcode15,full_testscore15,full_reqminscore15,full_minscore15,full_reqpassscore15,full_teststatus15,full_testdate16,full_testcode16,full_testscore16,full_reqminscore16,full_minscore16,full_reqpassscore16,full_teststatus16,full_testdate17,full_testcode17,full_testscore17,full_reqminscore17,full_minscore17,full_reqpassscore17,full_teststatus17,full_testdate18,full_testcode18,full_testscore18,full_reqminscore18,full_minscore18,full_reqpassscore18,full_teststatus18,full_testdate19,full_testcode19,full_testscore19,full_reqminscore19,full_minscore19,full_reqpassscore19,full_teststatus19,full_testdate20,full_testcode20,full_testscore20,full_reqminscore20,full_minscore20,full_reqpassscore20,full_teststatus20,full_testdate21,full_testcode21,full_testscore21,full_reqminscore21,full_minscore21,full_reqpassscore21,full_teststatus21,full_testdate22,full_testcode22,full_testscore22,full_reqminscore22,full_minscore22,full_reqpassscore22,full_teststatus22,full_testdate23,full_testcode23,full_testscore23,full_reqminscore23,full_minscore23,full_reqpassscore23,full_teststatus23,full_testdate24,full_testcode24,full_testscore24,full_reqminscore24,full_minscore24,full_reqpassscore24,full_teststatus24,full_testdate25,full_testcode25,full_testscore25,full_reqminscore25,full_minscore25,full_reqpassscore25,full_teststatus25,full_testdate26,full_testcode26,full_testscore26,full_reqminscore26,full_minscore26,full_reqpassscore26,full_teststatus26,full_testdate27,full_testcode27,full_testscore27,full_reqminscore27,full_minscore27,full_reqpassscore27,full_teststatus27,full_testdate28,full_testcode28,full_testscore28,full_reqminscore28,full_minscore28,full_reqpassscore28,full_teststatus28,full_testdate29,full_testcode29,full_testscore29,full_reqminscore29,full_minscore29,full_reqpassscore29,full_teststatus29,full_testdate30,full_testcode30,full_testscore30,full_reqminscore30,full_minscore30,full_reqpassscore30,full_teststatus30,full_testdate31,full_testcode31,full_testscore31,full_reqminscore31,full_minscore31,full_reqpassscore31,full_teststatus31,full_testdate32,full_testcode32,full_testscore32,full_reqminscore32,full_minscore32,full_reqpassscore32,full_teststatus32,full_testdate33,full_testcode33,full_testscore33,full_reqminscore33,full_minscore33,full_reqpassscore33,full_teststatus33,full_testdate34,full_testcode34,full_testscore34,full_reqminscore34,full_minscore34,full_reqpassscore34,full_teststatus34,full_testdate35,full_testcode35,full_testscore35,full_reqminscore35,full_minscore35,full_reqpassscore35,full_teststatus35,full_testdate36,full_testcode36,full_testscore36,full_reqminscore36,full_minscore36,full_reqpassscore36,full_teststatus36
	
	@Override
	public List<PraxisIITestScore> mapFieldSet(FieldSet fs) {
			
		log.debug("Mapping PraxisTestScore FieldSets ...");
		
		if (fs == null) {
			return null;
		}

		List<PraxisIITestScore> praxisIITestScores = new ArrayList<PraxisIITestScore>(0);
		
		User user = null;
		
		PraxisIITestScore praxisIITestScore = null;
		
		
		// CEPIS User Record identifiers
		String candidateId = fs.readString("praxisid");
		String ssn = fs.readString("ssn");
		String lastName = fs.readString("lastname");
		String firstName = fs.readString("firstname");
		String middleName = fs.readString("middlename");
		String genderCode = fs.readString("gender");
		String gender;
		String dob = fs.readString("dob");
		Date birthDate = null;
		String nai, rei, rsi;
		
		int naic = 0, reic = 0, rsic = 0;
		
		SimpleDateFormat curTestDateFormat = new SimpleDateFormat("yyyyMMdd");
		
		SimpleDateFormat archiveTestDateFormat = new SimpleDateFormat("MM/dd/yyyy");
				
		HashMap<String, PraxisIITest> praxisTestCache = new HashMap<String, PraxisIITest>();

		
		if (genderCode.equals("1") || genderCode.equalsIgnoreCase("F")) {
			gender = "Female";
		} else if (genderCode.equals("0") || genderCode.equalsIgnoreCase("M")) {
			gender = "Male";
		} else {
			gender = "NA";
		}

		if (dob != null && !dob.isEmpty()) {
			try {
				birthDate = curTestDateFormat.parse(dob);
			} catch (ParseException e) {
				System.err.println(e);
			}
		}
		log.debug("Mapping " + lastName + "," + firstName + " records ...");
		// Test User
		// user = this.getUserService().findByUid("MURKX-0801");
		// Find by Praxis Candidate ID
		if (!(candidateId == null || candidateId.isEmpty())) {
			user = this.getPraxisIITestScoreService()
					.findUserByCandidateId(candidateId);
		}
		if (user == null) {
			// Find by SSN
			if (!(ssn == null || ssn.isEmpty())) {
				user = this.getUserService().findBySSN(ssn);
			}
			if (user == null) {
				// Find by first name and lastname (include lastname1,
				// lastname2,
				// lastname3, lastname4)
				List<User> users = this.getUserService().findByNames(firstName,
						lastName, lastName, lastName, lastName, lastName,
						middleName);
				if (users.size() == 1) {
					user = users.get(0);
				}

				if (user == null) {
					// Find by Birthdate & Gender
					if (!gender.equals("NA") && birthDate != null) {
						users = this.getUserService().findByGenderAndBirthDate(
								gender, birthDate);
						if (users.size() == 1) {
							user = users.get(0);
						}
					}
				}
			}
		}

		// If no user found, write it to the unknown_file
		if (user == null) {
			log.debug("No matching user object found for the record: "
					+ lastName + "," + firstName);
			return praxisIITestScores;
		}
		String testCode = null;
		PraxisIITest praxisTest;
		// Current Test Date
		for (int i = 1; i <= 6; i++) {
			// Uses
			// cur_testdate,cur_testcode,cur_testscore,cur_nai,cur_rei,cur_filler
			if (!fs.readString("cur_testdate" + i).trim().isEmpty()) {
				testCode = fs.readString("cur_testcode" + i);
				if (praxisTestCache.containsKey(testCode)) {
					praxisTest = praxisTestCache.get(testCode);
				} else {
					praxisTest = this.getCepisGlobalComponentConfigurator()
							.findPraxisIITestByCode(testCode);
					if (praxisTest != null) {
						praxisTestCache.put(testCode, praxisTest);
					}
				}
				nai = fs.readString("cur_nai" + i);
				if (nai != null && !nai.isEmpty()) {
					naic = 1;
				}

				rei = fs.readString("cur_rei" + i);
				if (rei != null && !rei.isEmpty()) {
					reic = 1;
				}
				try {					
					praxisIITestScore = new PraxisIITestScore(
							curTestDateFormat.parse(fs
									.readString("cur_testdate" + i)), null,
							candidateId, fs.readDouble("cur_testscore" + i), 0,
							naic, 0, reic);
					praxisIITestScore.setArchived(false);
				} catch (ParseException e) {
					System.err.println(e);
				}
				praxisIITestScore.setUser(user);
				praxisIITestScores.add(praxisIITestScore);
			}
		}

		// Highest Scores For Test Taken in the Last 10 Years.
		for (int i = 1; i <= 10; i++) {
			// Uses
			// high_testdate1,high_testcode1,high_testscore1,high_nai1,high_rsi1,high_rei1
			if (!fs.readString("high_testdate" + i).trim().isEmpty()) {
				testCode = fs.readString("high_testcode" + i);
				if (praxisTestCache.containsKey(testCode)) {
					praxisTest = praxisTestCache.get(testCode);
				} else {
					praxisTest = this.getCepisGlobalComponentConfigurator()
							.findPraxisIITestByCode(testCode);
					if (praxisTest != null) {
						praxisTestCache.put(testCode, praxisTest);
					}
				}
				nai = fs.readString("high_nai" + i);
				if (nai != null && !nai.isEmpty()) {
					naic = 1;
				}
				rsi = fs.readString("high_rsi" + i);
				if (rsi != null && !rsi.isEmpty()) {
					rsic = 1;
				}
				rei = fs.readString("high_rei" + i);
				if (rei != null && !rei.isEmpty()) {
					reic = 1;
				}
				
				try {					
					praxisIITestScore = new PraxisIITestScore(
							curTestDateFormat.parse(fs
									.readString("high_testdate" + i)), null,
							candidateId, fs.readDouble("high_testscore" + i),
							0, naic, rsic, reic);
					praxisIITestScore.setArchived(false);
				} catch (ParseException e) {
					System.err.println(e);
				}
				praxisIITestScore.setUser(user);
				praxisIITestScores.add(praxisIITestScore);
			}
		}

		// Passed/ Non-passed Test Information
		for (int i = 1; i <= 36; i++) {
			// Uses
			// full_testdate1,full_testcode1,full_testscore1,full_reqminscore1,full_minscore1,full_reqpassscore1,full_teststatus1
			if (!fs.readString("full_testdate" + i).trim().isEmpty()) {
				testCode = fs.readString("full_testcode" + i);
				if (praxisTestCache.containsKey(testCode)) {
					praxisTest = praxisTestCache.get(testCode);
				} else {
					praxisTest = this.getCepisGlobalComponentConfigurator()
							.findPraxisIITestByCode(testCode);
					if (praxisTest != null) {
						praxisTestCache.put(testCode, praxisTest);
					}
				}
				try {
					praxisIITestScore = new PraxisIITestScore(
							archiveTestDateFormat.parse(fs.readString("full_testdate" + i)), null,
							candidateId, fs.readDouble("full_testscore" + i),0, 0, 0, 0);
					praxisIITestScore.setArchived(true);
				} catch (ParseException e) {
					System.err.println(e);
				}
				praxisIITestScore.setUser(user);
				praxisIITestScores.add(praxisIITestScore);
			}
		}

		return praxisIITestScores;
	}

	public PraxisIITestService getPraxisIITestService() {
		return praxisIITestService;
	}
	
	public void setPraxisIITestService(PraxisIITestService praxisIITestService) {
		this.praxisIITestService = praxisIITestService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @return the cepisGlobalComponentConfigurator
	 */
	public CEPISGlobalComponentConfigurator getCepisGlobalComponentConfigurator() {
		return cepisGlobalComponentConfigurator;
	}

	/**
	 * @param cepisGlobalComponentConfigurator
	 *            the cepisGlobalComponentConfigurator to set
	 */
	public void setCepisGlobalComponentConfigurator(
			CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator) {
		this.cepisGlobalComponentConfigurator = cepisGlobalComponentConfigurator;
	}

	/**
	 * @return the testScoreService
	 */
	public PraxisIITestScoreService getPraxisIITestScoreService() {
		return praxisIITestScoreService;
	}

	/**
	 * @param testScoreService
	 *            the testScoreService to set
	 */
	public void setPraxisIITestScoreService(PraxisIITestScoreService praxisIITestScoreService) {
		this.praxisIITestScoreService = praxisIITestScoreService;
	}

}
