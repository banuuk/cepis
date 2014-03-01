package edu.uky.cepis.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.uky.cepis.domain.Address;
import edu.uky.cepis.domain.AddressType;
import edu.uky.cepis.domain.Certification;
import edu.uky.cepis.domain.EmailAddress;
import edu.uky.cepis.domain.EmailAddressType;
import edu.uky.cepis.domain.Fee;
import edu.uky.cepis.domain.Phone;
import edu.uky.cepis.domain.PhoneType;
import edu.uky.cepis.domain.PraxisIITestScore;
import edu.uky.cepis.domain.Ranking;
import edu.uky.cepis.domain.UserProgramProfile;
import edu.uky.cepis.domain.embeddedId.FeePK;
import edu.uky.cepis.util.global.CEPISGlobalComponentConfigurator;
import edu.uky.cepis.view.CertificationView;



/**
 * @author cawalk4
 *
 */
@Component
@Scope("session")
public class CertificationController extends AbstractController {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(CertificationController.class);

	@Resource(name="certificationBean")
	private CertificationView certificationBean;
	
	@Resource(name="cepisGlobalComponentConfigurator")
	private CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator;
		
	private List<String> validStates = new ArrayList<String>(0);	
	
	private List<Certification> certificationList = new ArrayList<Certification>(0);	
	
	private List<Object> oldCertificates = new ArrayList<Object>(0);	
	
	private List<UserProgramProfile> userProgramProfileList = new ArrayList<UserProgramProfile>(0);	
	
	private Date initialDate;	
	
	private Certification selectedCertification;	
	
	private UserProgramProfile selectedUserProgramProfile;	
	
	private Ranking selectedRanking;	
	
	private String status;	
	
	private Date completeDate;		
	
	private String memo;	
	
	private boolean loadArchivedCertification = true;
	
	/************************************FEES************************************/
	private List<Fee> feeList;
	
	private HtmlExtendedDataTable feeTable;
	
	private Fee selectedFee;
			
	private Date feeCheckDate;
	
	private String feeCheckType;
	
	private String feeType;
	
	private float feeAmountReceived;
	
	private String feeMemo;
		
	private Date feeDateReceived;
	
	private String feeCheckNumber;
	
	/************************************PRAXIS II************************************/
	private List<PraxisIITestScore> praxisIITestScoreList;
	
	/************************************EMAIL ADDRESS************************************/
	private EmailAddress selectedEmailAddress;
	
	private List<EmailAddress> emailAddressList = new ArrayList<EmailAddress>(0);
	
	private String emailAddress;
	
	private EmailAddressType selectedEmailAddressType;
	
	
	/************************************ADDRESS************************************/
	private Address selectedAddress;
	
	private List<Address> addressList = new ArrayList<Address>(0);
	
	private String street1;
	
	private String street2;
	
	private String city;
	
	private String state;
	
	private String zip;	
	
	private String country;
	
	private AddressType selectedAddressType;
	
	/************************************PHONE************************************/
	private Phone selectedPhone;
	
	private List<Phone> phoneList = new ArrayList<Phone>(0);
	
	private String phoneNo;
	
	private String ext;
	
	private PhoneType selectedPhoneType;
	
	private String shortDesc;
	
	/************************************CONDITIONAL LOAD BOOLEANS************************************/
	private boolean loadFees;	
	private boolean loadPraxisII;	
	private boolean loadEmailAddresses;	
	private boolean loadPhone;	
	private boolean loadAddresses;
	private boolean loadCertification;	
	
	private static String DEFAULT_FEE_MEMO_STRING = "Fees received without any problem.";
	
	private static String FEE_ADD_SUCCESS = "Fee Added Successfully.";
	private static String FEE_ADD_FAIL = "Fee Add Failed: PLEASE CONTACT AN ADMINISTRATOR";
	private static String FEE_DELETE_SUCCESS = "Fee Deleted Successfully.";
	private static String FEE_DELETE_FAIL = "Fee Delete Failed: PLEASE CONTACT AN ADMINISTRATOR";
	private static String FEE_EDIT_SUCCESS = "Fee Edited Successfully.";
	private static String FEE_EDIT_FAIL = "Fee Edit Failed: PLEASE CONTACT AN ADMINISTRATOR.";
	private static String ERROR_SELECT_FEE = "Please select a Fee from the list.";
	
	private static String CERTIFICATION_ERROR_ADD = "Unknown error: Cannot add Certification information.";

	
	
	
	public String getInitStatesField() {
		ArrayList<String> initStatesValue = new ArrayList<String>(0);
		initStatesValue.add("KY");
		this.setValidStates(initStatesValue);
		this.setInitialDate(new Date());
		return "";
	}
	
	/* ******************************************** Handle Objects Loaded on Each Tab ******************************************** */
	
	public String getSetUpAddTab() {
		setLoadFees(true);
		setLoadPraxisII(true);
		setLoadEmailAddresses(true);
		return "";
	}
	
	public String getSetUpViewTab(){
		setLoadCertification(true);
		setLoadArchivedCertification(true);
		return "";
	}
	
	public String getSetUpEditTab(){
		setLoadCertification(true);
		return "";
	}
	
	public String getSetUpDeleteTab(){
		setLoadCertification(true);
		return "";
	}
	
	/**
	 * Add a Certification to the currently selected user
	 * @return
	 */
	public String addCertificationToUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getConfigurationManager().getSelectedUser() != null
				&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			if (this.getSelectedUserProgramProfile() != null) {
				if (this.getSelectedRanking() != null) {

					if (!this.getCertificationBean()
							.addCertificationToUser(
									this.getConfigurationManager().getSelectedUser(),
									this.getSelectedUserProgramProfile(),
									this.getSelectedRanking(),
									this.getStatus(),
									this.convertValidStatesToString(),
									this.getInitialDate(),
									this.getCompleteDate(), this.getMemo())) {
						message.setSeverity(FacesMessage.SEVERITY_ERROR);
						message.setSummary("["
								+ new Date()
								+ "]" +  CERTIFICATION_ERROR_ADD);
						context.addMessage("msg", message);
					} else {
						message.setSeverity(FacesMessage.SEVERITY_INFO);
						message.setSummary("[" + new Date()
								+ "] Certification added successfully.");
						context.addMessage("msg", message);
						this.setLoadCertification(true);
						clearCertification();
					}
				} else {
					message.setSeverity(FacesMessage.SEVERITY_WARN);
					message.setSummary("[" + new Date()
							+ "] No ranking selected.");
					context.addMessage("msg", message);
				}
			} else {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] No program profile selected.");
				context.addMessage("msg", message);
			}
		} else {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] No user selected.");
			context.addMessage("msg", message);
		}
		return null;
	}
	
	/**
	 * Edit the currently selected Certification
	 * @return
	 */
	public String editCertificationDetail() {
		log.debug("Calling Edit Certification Information");
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getConfigurationManager().getSelectedUser() != null
				&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			if (this.getSelectedCertification() != null
					&& this.getSelectedCertification().getId() > 0) {
				if (this.getSelectedRanking() != null
						&& this.getSelectedRanking().getRankingCode() != null) {
					if (!this.getCertificationBean().updateCertification(
							this.getConfigurationManager().getSelectedUser(),
							this.getSelectedCertification(),
							this.getSelectedUserProgramProfile(),
							this.getSelectedRanking(), this.getStatus(),
							this.convertValidStatesToString(),
							this.getCompleteDate(), this.getMemo())) {
						message.setSeverity(FacesMessage.SEVERITY_ERROR);
						message.setSummary("["
								+ new Date()
								+ "] Unknown error: Cannot update certification information.");
						context.addMessage("msg", message);
					} else {
						message.setSeverity(FacesMessage.SEVERITY_INFO);
						message.setSummary("["
								+ new Date()
								+ "] Certification information updated successfully.");
						context.addMessage("msg", message);
						this.setLoadCertification(true);
						clearCertification();
					}
				} else {
					message.setSeverity(FacesMessage.SEVERITY_WARN);
					message.setSummary("[" + new Date()
							+ "] No ranking selected.");
					context.addMessage("msg", message);
					return null;
				}
			} else {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] No certification information selected.");
				context.addMessage("msg", message);
				return null;
			}
		} else {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] No user selected.");
			context.addMessage("msg", message);
		}
		return null;
	}
	
	/**
	 * Remove the currently selected certification
	 * @return
	 */
	public String removeCertificationFromUser() {
		log.debug("Calling Remove certification information function");
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getConfigurationManager().getSelectedUser() != null
				&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			if (this.getSelectedCertification() == null) {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] No certification information selected.");
				context.addMessage("msg", message);
				return null;
			}
			if (!this.getCertificationBean().removeCertificationFromUser(
					this.getConfigurationManager().getSelectedUser(),
					this.getSelectedCertification())) {
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary("["
						+ new Date()
						+ "] Unknown error: Cannot remove certification information.");
				context.addMessage("msg", message);
			} else {
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary("[" + new Date()
						+ "] Certification information removed successfully.");
				context.addMessage("msg", message);
				this.setLoadCertification(true);
			}
		} else {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] No user selected.");
			context.addMessage("msg", message);
		}
		return null;
	}
	
	private String convertValidStatesToString() {
		log.debug("Calling convertValidStatesToString");
		StringBuffer selectedStates = new StringBuffer();
		int size = this.validStates.size();
		if (size > 0) {
			selectedStates.append(this.validStates.get(0));
			for (int i = 1; i < size; i++) {
				selectedStates.append(",");
				selectedStates.append(this.validStates.get(i));
			}
		}
		log.debug("result: " + selectedStates.toString());
		return selectedStates.toString();
	}
	
	public void valueChangeEditCertification(ActionEvent event) {
		log.debug("Calling valueChangeEditCertification");
		if (this.selectedCertification != null
				&& this.getSelectedCertification().getId() >= 0) {

			this.setSelectedUserProgramProfile(this.getSelectedCertification()
					.getProgramProfile());
			this.setSelectedRanking(this.getSelectedCertification()
					.getRanking());
			this.setStatus(this.getSelectedCertification().getStatus());
			this.setInitialDate(this.getSelectedCertification()
					.getInitialDate());
			this.setCompleteDate(this.getSelectedCertification()
					.getCompleteDate());
			this.setMemo(this.getSelectedCertification().getMemo());
			if (this.getSelectedCertification().getState() != null
					&& this.getSelectedCertification().getState().trim()
							.length() > 0) {
				this.setValidStates(this.convertStringToValidStates(this
						.getSelectedCertification().getState()));
			} else {
				this.setValidStates(new ArrayList<String>(0));
			}
		}
	}

	public void valueChangeEditCertificationStatus(ActionEvent event) {
		log.debug("Calling valueChangeEditCertificationStatus"
				+ this.getCompleteDate());
		if (this.getStatus() != null && this.getStatus().equals("COMPLETE")) {
			if (this.getCompleteDate() == null) {
				log.debug("Complete " + this.getCompleteDate());
				this.setCompleteDate(new Date());
			}
		}
	}
	
	private ArrayList<String> convertStringToValidStates(String states) {
		log.debug("Calling convertStringToValidStates");
		ArrayList<String> parsedStates = new ArrayList<String>(0);
		if (states == null || states.trim().length() < 1) {
			return parsedStates;
		}

		StringTokenizer st = new StringTokenizer(states, ",");
		while (st.hasMoreElements()) {
			parsedStates.add(st.nextElement() + "");
		}
		return parsedStates;
	}
	
	public List<SelectItem> getStates() {
		List<String> states = this.getCepisGlobalComponentConfigurator().getStates();
		List<SelectItem> sItems = new ArrayList<SelectItem>();
		SelectItem sItem = null;
		for (String state : states) {
			sItem = new SelectItem(state, state);
			sItems.add(sItem);
		}
		return sItems;
	}
	
	/* ***************************************** FEES ***************************************** */
	public void takeFeeSelection(){
		if(this.getFeeTable() != null){
			Fee fee = (Fee) this.getFeeTable().getRowData();
			if (fee != null) {
				setSelectedFee(fee);
			}	
		}				
	}
	
	public void addNewFee(){
		FacesContext context = FacesContext.getCurrentInstance();	
		FacesMessage message = new FacesMessage();
		Fee newFee = new Fee();
		FeePK newFeePK = new FeePK();
		
		newFeePK.setCheckNumber(getFeeCheckNumber());
		newFeePK.setDateReceived(getFeeDateReceived());
		newFeePK.setUser(getConfigurationManager().getSelectedUser());
		
		newFee.setFeePk(newFeePK);
		newFee.setCheckDate(getFeeCheckDate());
		newFee.setCheckType(getFeeCheckType());
		newFee.setFeeType(getFeeType());
		newFee.setMemo(getFeeMemo());
		newFee.setAmountReceived(getFeeAmountReceived());
		newFee.setNameOnCheck(" ");
		
		if(getCertificationBean().saveOrUpdateFee(newFee)){
			setLoadFees(true);
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary(FEE_ADD_SUCCESS + " On: " + new Date());
			context.addMessage("msg", message);			
		}else{
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(FEE_ADD_FAIL + " On: " + new Date());
			context.addMessage("msg", message);
		}
		
	}
	
	public void prepEditFee(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		//Check if a Fee is selected
		if(getSelectedFee() == null){				
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(ERROR_SELECT_FEE );
			context.addMessage("msg", message);
		}
	}
	
	public void editFee(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if(getCertificationBean().saveOrUpdateFee(getSelectedFee())){
			setLoadFees(true);
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary(FEE_EDIT_SUCCESS + " On: " + new Date());
			context.addMessage("msg", message);
		}else{
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(FEE_EDIT_FAIL + " On: " + new Date());
			context.addMessage("msg", message);
		}
	}
	
	public void deleteFee(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		
		if(getSelectedFee() == null){
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(ERROR_SELECT_FEE);
			context.addMessage("msg", message);			
		}
		
		if(getCertificationBean().deleteFee(getSelectedFee())){
			setLoadFees(true);
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setSummary(FEE_DELETE_SUCCESS + " On: " + new Date());
			context.addMessage("msg", message);			
		}else{
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(FEE_DELETE_FAIL + " On: " + new Date());
			context.addMessage("msg", message);			
		}
	}
	
	/* ******************************************************************** TRANSCRIPT ******************************************************************** */

	public String getMyUKTranscriptLink() {
		if (this.getConfigurationManager().getSelectedUser() != null
				&& this.getConfigurationManager().getSelectedUser().getUkID() != null
				&& this.getConfigurationManager().getSelectedUser().getUkID().trim() != "") {
			return "https://myuk.uky.edu/irj/servlet/prt/portal/prtroot/cmSA_Advising2.pdf?o="
					+ this.getConfigurationManager().getSelectedUser()
							.getUkID();
		}
		return "/cepis/pages/account/academic-profile/no-transcript.html";
	}
	
	/* ******************************************************************** EMAIL ADDRESS ******************************************************************** */

	public void valueChangeEditEmailAddress(ActionEvent event) {
		log.debug("Calling valueChangeEditEmailAddress");
		if (this.selectedEmailAddress != null
				&& this.getSelectedEmailAddress().getId() >= 0) {
			this.setEmailAddress(this.getSelectedEmailAddress().getAddress());
			this.setSelectedEmailAddressType(this.selectedEmailAddress
					.getType());
			log.debug("Successful");
		}
	}
	
	public String addEmailAddressToUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getConfigurationManager().getSelectedUser() != null
				&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			if (!this.getCertificationBean().addEmailAddressToUserAccount(
					this.getConfigurationManager().getSelectedUser(),
					this.getEmailAddress(), this.getSelectedEmailAddressType())) {
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary("["
						+ new Date()
						+ "] Unknown error: Cannot add Email Address information.");
				context.addMessage("msg", message);
			} else {
				clearEmailAddress();
				setLoadEmailAddresses(true);
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary("[" + new Date()
						+ "] Email Address added successfully.");
				context.addMessage("msg", message);				
			}

		} else {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] No user selected.");
			context.addMessage("msg", message);
		}
		return null;
	}
	
	public String editEmailAddressDetail() {
		log.debug("Calling Edit Email Address Information"
				+ this.getSelectedEmailAddress());
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getConfigurationManager().getSelectedUser() != null
				&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			if (this.getSelectedEmailAddress() == null
					|| this.getSelectedEmailAddress().getId() < 1) {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] No Email Address selected.");
				context.addMessage("msg", message);
				return null;
			}
			if (this.getSelectedEmailAddressType() == null
					|| this.getSelectedEmailAddressType().getCode() == null) {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] No Email Address Type selected.");
				context.addMessage("msg", message);
				return null;
			}
			if (!this.getCertificationBean().updateEmailAddressDetails(
					this.getConfigurationManager().getSelectedUser(),
					this.getSelectedEmailAddress(), this.getEmailAddress(),
					this.getSelectedEmailAddressType())) {
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary("["
						+ new Date()
						+ "] Unknown error: Cannot edit Email Address information.");
				context.addMessage("msg", message);
			} else {
				clearEmailAddress();
				setLoadEmailAddresses(true);
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary("[" + new Date()
						+ "] Email Address updated successfully.");
				context.addMessage("msg", message);
			}
		} else {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] No user selected.");
			context.addMessage("msg", message);
		}
		return null;
	}
	
	public String removeEmailAddressFromUser() {
		log.debug("Calling Remove email address information function");
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getConfigurationManager().getSelectedUser() != null
				&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			if (this.getSelectedEmailAddress() == null) {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] No Email Address information selected.");
				context.addMessage("msg", message);
				return null;
			}
			if (!this.getCertificationBean()
					.removeEmailAddressFromUserAccount(
							this.getConfigurationManager().getSelectedUser(),
							this.getSelectedEmailAddress())) {
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary("["
						+ new Date()
						+ "] Unknown error: Cannot remove Email Address information.");
				context.addMessage("msg", message);
			} else {
				clearEmailAddress();
				setLoadEmailAddresses(true);
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary("[" + new Date()
						+ "] Email Address removed successfully.");
				context.addMessage("msg", message);				
			}

		} else {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] No user selected.");
			context.addMessage("msg", message);
		}
		return null;
	}
			
	/* ******************************************************************** ADDRESS ******************************************************************** */

	public String getSetUpAddressTab() {
		setLoadAddresses(true);
		return "";
	}
	
	public void valueChangeEditAddress(ActionEvent event) {
		log.debug("Calling valueChangeEditAddress");
		if (this.selectedAddress != null
				&& this.getSelectedAddress().getId() >= 0) {
			this.setStreet1(this.selectedAddress.getStreet1());
			this.setStreet2(this.selectedAddress.getStreet2());
			this.setCity(this.selectedAddress.getCity());
			this.setState(this.selectedAddress.getState());
			this.setZip(this.selectedAddress.getZip());
			this.setCountry(this.selectedAddress.getCountry());
			this.setSelectedAddressType(this.selectedAddress.getAddressType());
		}
	}
	
	public String addAddressToUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getConfigurationManager().getSelectedUser() != null
				&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			if (!this.getCertificationBean().addAddressToUserAccount(
					this.getConfigurationManager().getSelectedUser(),
					this.getStreet1(), this.getStreet2(), this.getCity(),
					this.getState(), this.getZip(), this.getCountry(),
					this.getSelectedAddressType())) {
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary("[" + new Date()
						+ "] Unknown error: Cannot add Address information.");
				context.addMessage("msg", message);
			} else {
				clearAddress();
				setLoadAddresses(true);
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary("[" + new Date()
						+ "] Address information added successfully.");
				context.addMessage("msg", message);
			}

		} else {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] No user selected.");
			context.addMessage("msg", message);
		}
		return null;
	}

	public String editAddressDetail() {
		log.debug("Calling Edit Address Information"
				+ this.getSelectedAddressType().getDesc());
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getConfigurationManager().getSelectedUser() != null
				&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			if (this.getSelectedAddress() == null
					|| this.getSelectedAddress().getId() < 1) {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] No Address information selected.");
				context.addMessage("msg", message);
				return null;
			}
			if (this.getSelectedAddressType() == null
					|| this.getSelectedAddressType().getCode() == null) {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] No Addresstype selected.");
				context.addMessage("msg", message);
				return null;
			}
			if (!this.getCertificationBean().updateAddressDetails(
					this.getConfigurationManager().getSelectedUser(),
					this.getSelectedAddress(), this.getStreet1(),
					this.getStreet2(), this.getCity(), this.getState(),
					this.getZip(), this.getCountry(),
					this.getSelectedAddressType())) {
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary("[" + new Date()
						+ "] Unknown error: Cannot update Address information.");
				context.addMessage("msg", message);
			} else {
				clearAddress();
				setLoadAddresses(true);
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary("[" + new Date()
						+ "] Address information updated successfully.");
				context.addMessage("msg", message);
			}

		} else {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] No user selected.");
			context.addMessage("msg", message);
		}
		return null;
	}
	
	public String removeAddressFromUser() {
		log.debug("Calling Remove address information function");
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getConfigurationManager().getSelectedUser() != null
				&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			if (this.getSelectedAddress() == null) {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] No Address information selected.");
				context.addMessage("msg", message);
				return null;
			}
			if (!this.getCertificationBean().removeAddressFromUserAccount(
					this.getConfigurationManager().getSelectedUser(),
					this.getSelectedAddress())) {
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary("[" + new Date()
						+ "] Unknown error: Cannot remove Address information.");
				context.addMessage("msg", message);
			} else {
				clearAddress();
				setLoadAddresses(true);
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary("[" + new Date()
						+ "] Address information removed successfully.");
				context.addMessage("msg", message);				
			}
		} else {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] No user selected.");
			context.addMessage("msg", message);
		}
		return null;
	}
	
	/* ******************************************************************** PHONE ******************************************************************** */
	public String getSetUpPhoneTab() {
		setLoadPhone(true);
		return "";
	}
	
	public void valueChangeEditPhone(ActionEvent event) {
		log.debug("Calling valueChangeEditPhone");
		if (this.selectedPhone != null && this.getSelectedPhone().getId() >= 0) {
			this.setPhoneNo(this.selectedPhone.getPhoneNo());
			this.setExt(this.selectedPhone.getExt());
			this.setSelectedPhoneType(this.selectedPhone.getPhoneType());
			this.setShortDesc(this.selectedPhone.getMemo());
		}
	}
	
	public String addPhoneToUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getConfigurationManager().getSelectedUser() != null
				&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			if (!this.getCertificationBean().addPhoneToUserAccount(
					this.getConfigurationManager().getSelectedUser(),
					this.getPhoneNo(), this.getExt(), this.getShortDesc(),
					this.getSelectedPhoneType())) {
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary("[" + new Date()
						+ "] Unknown error: Cannot add Phone information.");
				context.addMessage("msg", message);
			} else {
				clearPhone();
				setLoadPhone(true);
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary("[" + new Date()
						+ "] Phone information added successfully.");
				context.addMessage("msg", message);
			}
		} else {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] No user selected.");
			context.addMessage("msg", message);
		}
		return null;
	}
	
	public String editPhoneDetail() {
		log.debug("Calling Edit Phone Information"
				+ this.getSelectedPhoneType().getDesc());
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getConfigurationManager().getSelectedUser() != null
				&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			if (this.getSelectedPhone() == null
					|| this.getSelectedPhone().getId() < 1) {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] No Phone information selected.");
				context.addMessage("msg", message);
				return null;
			}
			if (this.getSelectedPhoneType() == null
					|| this.getSelectedPhoneType().getCode() == null) {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] No phone type selected.");
				context.addMessage("msg", message);
				return null;
			}
			if (!this.getCertificationBean().updatePhoneDetails(
					this.getConfigurationManager().getSelectedUser(),
					this.getSelectedPhone(), this.getPhoneNo(), this.getExt(),
					this.getShortDesc(), this.getSelectedPhoneType())) {
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary("[" + new Date()
						+ "] Unknown error: Cannot edit Phone information.");
				context.addMessage("msg", message);
			} else {
				clearPhone();
				setLoadPhone(true);
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary("[" + new Date()
						+ "] Phone information updated successfully.");
				context.addMessage("msg", message);				
			}

		} else {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] No user selected.");
			context.addMessage("msg", message);
		}
		return null;
	}
	
	public String removePhoneFromUser() {
		log.debug("Calling Remove phone information function");
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (this.getConfigurationManager().getSelectedUser() != null
				&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			if (this.getSelectedPhone() == null) {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setSummary("[" + new Date()
						+ "] No Phone information selected.");
				context.addMessage("msg", message);
				return null;
			}
			if (!this.getCertificationBean().removePhoneFromUserAccount(
					this.getConfigurationManager().getSelectedUser(),
					this.getSelectedPhone())) {
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setSummary("[" + new Date()
						+ "] Unknown error: Cannot remove Phone information.");
				context.addMessage("msg", message);
			} else {
				clearPhone();
				setLoadPhone(true);
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setSummary("[" + new Date()
						+ "] Phone information removed successfully.");
				context.addMessage("msg", message);				
			}

		} else {
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setSummary("[" + new Date() + "] No user information.");
			context.addMessage("msg", message);
		}
		return null;
	}
	
	/* ******************************************* CLEAR FORMS ******************************************* */
	private void clearCertification(){
		setSelectedUserProgramProfile(null);
		setSelectedRanking(null);
		setStatus(null);
		setInitialDate(null);
		setCompleteDate(null);
		setMemo(null);
	}
	
	private void clearEmailAddress(){
		setSelectedEmailAddress(null);
		setSelectedEmailAddressType(null);
		setEmailAddress(null);
	}
	
	private void clearPhone(){
		setSelectedPhone(null);
		setSelectedPhoneType(null);
		setPhoneNo(null);
		setExt(null);
		setShortDesc(null);
	}
	
	private void clearAddress(){
		setSelectedAddress(null);
		setStreet1(null);
		setStreet2(null);
		setCity(null);
		setState(null);
		setZip(null);
		setCountry(null);
		setSelectedAddressType(null);
	}

	/* ******************************************************************** Getters And Setters ******************************************************************** */

	public CertificationView getCertificationBean() {
		return certificationBean;
	}

	public void setCertificationBean(CertificationView certificationBean) {
		this.certificationBean = certificationBean;
	}

	public CEPISGlobalComponentConfigurator getCepisGlobalComponentConfigurator() {
		return cepisGlobalComponentConfigurator;
	}

	public void setCepisGlobalComponentConfigurator(
			CEPISGlobalComponentConfigurator cepisGlobalComponentConfigurator) {
		this.cepisGlobalComponentConfigurator = cepisGlobalComponentConfigurator;
	}

	public List<String> getValidStates() {
		return validStates;
	}

	public void setValidStates(List<String> validStates) {
		this.validStates = validStates;
	}
	
	public List<Certification> getCertificationList() {
		System.out.print("Calling Get Certification List: ");
		if (this.isLoadCertification()
				&& this.getConfigurationManager().getSelectedUser() != null
				&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			log.debug("loaded");
			this.setCertificationList(this.getCertificationBean()
					.getCertificationList(
							this.getConfigurationManager().getSelectedUser()));
			this.setLoadCertification(false);
		} else {
			log.debug("skipped");
		}
		return this.certificationList;
	}

	public List<Object> getOldCerticationList() {
		log.debug("Calling Get Old Certification List");

		if (this.isLoadArchivedCertification()
				&& this.getConfigurationManager().getSelectedUser() != null
				&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			oldCertificates = this.getCertificationBean()
					.getOldCertificates(
							this.getConfigurationManager().getSelectedUser());
			this.setLoadArchivedCertification(false);
		} else {
			log.debug("skipped");
		}
		return oldCertificates;
	}

	public void setCertificationList(List<Certification> certificationList) {
		this.certificationList = certificationList;
	}
	
	public List<UserProgramProfile> getUserProgramProfileList() {
		System.out.print("Calling Get Program Profile List: ");
		if (this.getConfigurationManager().getSelectedUser() != null
			&& this.getConfigurationManager().getSelectedUser().getUid() != null) {			
			this.setUserProgramProfileList(this.getCertificationBean().getUserProgramProfiles(
				this.getConfigurationManager().getSelectedUser()));
		} else {
			log.debug("skipped");
		}
		return this.userProgramProfileList;
	}
	
	public void setUserProgramProfileList(
			List<UserProgramProfile> userProgramProfileList) {
		this.userProgramProfileList = userProgramProfileList;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	
	public Certification getSelectedCertification() {
		log.debug("Get Selected Certification function called: " + selectedCertification);
		return selectedCertification;
	}

	public void setSelectedCertification(Certification selectedCertification) {
		log.debug("Set Selected Certification function called: " + selectedCertification);
		this.selectedCertification = selectedCertification;
	}

	public UserProgramProfile getSelectedUserProgramProfile() {
		return selectedUserProgramProfile;
	}

	public void setSelectedUserProgramProfile(UserProgramProfile selectedUserProgramProfile) {
		this.selectedUserProgramProfile = selectedUserProgramProfile;
	}
	
	public Ranking getSelectedRanking() {
		return selectedRanking;
	}

	public void setSelectedRanking(Ranking selectedRanking) {
		this.selectedRanking = selectedRanking;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public boolean isLoadCertification() {
		return loadCertification;
	}

	public void setLoadCertification(boolean loadCertification) {
		this.loadCertification = loadCertification;
	}

	public boolean isLoadArchivedCertification() {
		return loadArchivedCertification;
	}

	public void setLoadArchivedCertification(boolean loadArchivedCertification) {
		this.loadArchivedCertification = loadArchivedCertification;
	}

	public List<Object> getOldCertificates() {
		return oldCertificates;
	}

	public void setOldCertificates(List<Object> oldCertificates) {
		this.oldCertificates = oldCertificates;
	}

	public List<Fee> getFeeList() {		
		if(isLoadFees()
		&& this.getConfigurationManager().getSelectedUser() != null
		&& this.getConfigurationManager().getSelectedUser().getUid() != null){	
			List<Fee> feeList = new ArrayList<Fee>();
			Fee example = new Fee();
			example.setFeePk(new FeePK());
			example.getFeePk().setUser(this.getConfigurationManager().getSelectedUser());
			feeList = getCertificationBean().findFeeByExample(example);
			setLoadFees(false);
			if(feeList != null){
				setFeeList(feeList);
			}else{
				setFeeList(new ArrayList<Fee>());
			}		
		}
		return this.feeList;
	}

	public void setFeeList(List<Fee> feeList) {
		this.feeList = feeList;
	}

	public HtmlExtendedDataTable getFeeTable() {
		return feeTable;
	}

	public void setFeeTable(HtmlExtendedDataTable feeTable) {
		this.feeTable = feeTable;
	}

	public Fee getSelectedFee() {
		if(selectedFee == null){
			setSelectedFee(new Fee());
		}
		return selectedFee;
	}

	public void setSelectedFee(Fee selectedFee) {
		this.selectedFee = selectedFee;
	}

	public Date getFeeCheckDate() {
		return feeCheckDate;
	}

	public void setFeeCheckDate(Date feeCheckDate) {
		this.feeCheckDate = feeCheckDate;
	}

	public String getFeeCheckType() {
		return feeCheckType;
	}

	public void setFeeCheckType(String feeCheckType) {
		this.feeCheckType = feeCheckType;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public float getFeeAmountReceived() {
		return feeAmountReceived;
	}

	public void setFeeAmountReceived(float feeAmountReceived) {
		this.feeAmountReceived = feeAmountReceived;
	}

	public String getFeeMemo() {
		if(this.feeMemo == null){
			return DEFAULT_FEE_MEMO_STRING;
		}else{
			return feeMemo;
		}
	}

	public void setFeeMemo(String feeMemo) {
		this.feeMemo = feeMemo;
	}

	public Date getFeeDateReceived() {
		return feeDateReceived;
	}

	public void setFeeDateReceived(Date feeDateReceived) {
		this.feeDateReceived = feeDateReceived;
	}

	public String getFeeCheckNumber() {
		return feeCheckNumber;
	}

	public void setFeeCheckNumber(String feeCheckNumber) {
		this.feeCheckNumber = feeCheckNumber;
	}

	public List<PraxisIITestScore> getPraxisIITestScoreList() {
		System.out.print("Calling Get PraxisIITestScore List: ");
		if (isLoadPraxisII()
		&& this.getConfigurationManager().getSelectedUser() != null
		&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			log.debug("loaded PraxisIITestScore List");
			this.setPraxisIITestScoreList(this.getCertificationBean().getPraxisIITestScoreList(this.getConfigurationManager().getSelectedUser()));
			setLoadPraxisII(false);
		}else{
			log.debug("skipped PraxisIITestScore");
		}
		
		return this.praxisIITestScoreList;
	}

	public void setPraxisIITestScoreList(
			List<PraxisIITestScore> praxisIITestScoreList) {
		this.praxisIITestScoreList = praxisIITestScoreList;
	}

	public EmailAddress getSelectedEmailAddress() {
		return selectedEmailAddress;
	}

	public void setSelectedEmailAddress(EmailAddress selectedEmailAddress) {
		this.selectedEmailAddress = selectedEmailAddress;
	}

	public List<EmailAddress> getEmailAddressList() {
		System.out.print("Calling Get Email Address List: ");
		if (isLoadEmailAddresses()
		&& this.getConfigurationManager().getSelectedUser() != null
		&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			log.debug("loaded");
			this.setEmailAddressList(this.getCertificationBean()
					.getEmailAddressList(
							this.getConfigurationManager().getSelectedUser()));
			setLoadEmailAddresses(false);
		} else {
			log.debug("skipped");
		}
		return this.emailAddressList;
	}

	public void setEmailAddressList(List<EmailAddress> emailAddressList) {
		this.emailAddressList = emailAddressList;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public EmailAddressType getSelectedEmailAddressType() {
		return selectedEmailAddressType;
	}

	public void setSelectedEmailAddressType(EmailAddressType selectedEmailAddressType) {
		this.selectedEmailAddressType = selectedEmailAddressType;
	}

	public Address getSelectedAddress() {
		return selectedAddress;
	}

	public void setSelectedAddress(Address selectedAddress) {
		this.selectedAddress = selectedAddress;
	}

	public List<Address> getAddressList() {
		System.out.print("Calling Get Address List: ");
		if (isLoadAddresses()
		&& this.getConfigurationManager().getSelectedUser() != null
		&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			log.debug("loaded");
			this.setAddressList(this.getCertificationBean().getAddressList(
					this.getConfigurationManager().getSelectedUser()));
		} else {
			log.debug("skipped");
		}
		return this.addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public AddressType getSelectedAddressType() {
		return selectedAddressType;
	}

	public void setSelectedAddressType(AddressType selectedAddressType) {
		this.selectedAddressType = selectedAddressType;
	}

	public Phone getSelectedPhone() {
		return selectedPhone;
	}

	public void setSelectedPhone(Phone selectedPhone) {
		this.selectedPhone = selectedPhone;
	}

	public List<Phone> getPhoneList() {
		System.out.print("Calling Get Phone List: ");
		if (isLoadPhone()
		&& this.getConfigurationManager().getSelectedUser() != null
		&& this.getConfigurationManager().getSelectedUser().getUid() != null) {
			log.debug("loaded");
			this.setPhoneList(this.getCertificationBean().getPhoneList(
					this.getConfigurationManager().getSelectedUser()));
			setLoadPhone(false);
		} else {
			log.debug("skipped");
		}
		return this.phoneList;
	}

	public void setPhoneList(List<Phone> phoneList) {
		this.phoneList = phoneList;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public PhoneType getSelectedPhoneType() {
		return selectedPhoneType;
	}

	public void setSelectedPhoneType(PhoneType selectedPhoneType) {
		this.selectedPhoneType = selectedPhoneType;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public boolean isLoadFees() {
		return loadFees;
	}

	public void setLoadFees(boolean loadFees) {
		this.loadFees = loadFees;
	}

	public boolean isLoadPraxisII() {
		return loadPraxisII;
	}

	public void setLoadPraxisII(boolean loadPraxisII) {
		this.loadPraxisII = loadPraxisII;
	}

	public boolean isLoadEmailAddresses() {
		return loadEmailAddresses;
	}

	public void setLoadEmailAddresses(boolean loadEmailAddresses) {
		this.loadEmailAddresses = loadEmailAddresses;
	}

	public boolean isLoadPhone() {
		return loadPhone;
	}

	public void setLoadPhone(boolean loadPhone) {
		this.loadPhone = loadPhone;
	}

	public boolean isLoadAddresses() {
		return loadAddresses;
	}

	public void setLoadAddresses(boolean loadAddresses) {
		this.loadAddresses = loadAddresses;
	}
}