/**
 * 
 */
package edu.uky.cepis.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import edu.uky.cepis.domain.embeddedId.FeePK;


/**
 * @author cawalk4
 *
 */
@Entity
@Table(name = "tblfees")
public class Fee {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Fees_Number")
	private long id;
	
	@EmbeddedId
	private FeePK feePk;
		
	@Column(name = "Date_on_Cheque", nullable=false)
	private Date checkDate;
			
	@Column(name = "Cheque_Type", nullable=false, length=20)
	private String checkType;
	
	@Column(name = "Fees_Type", nullable=false, length=20)
	private String feeType;
	
	@Column(name = "Amount_Received", nullable=false)
	private float amountReceived;
	
	@Column(name = "Memo", nullable=false, length=100)
	private String memo;
	
	@Column(name = "Name_on_Cheque", nullable=false, length=50)
	private String nameOnCheck;
	
	public Fee(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public FeePK getFeePk() {
		return feePk;
	}

	public void setFeePk(FeePK feePk) {
		this.feePk = feePk;
	}
	
	/* ************************ SIGNATURE DATE ************************ */
	public Date getCheckDate() {
		return checkDate;
	}
	
	public String getCheckDateString() {
		if(getCheckDate() != null){
			String dateString = new SimpleDateFormat("yyyy-MM-dd").format(getCheckDate());
			return dateString;
		}else{
			return " ";
		}
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	
	/* ************************ CHECK TYPE ************************ */
	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feesType) {
		this.feeType = feesType;
	}

	public float getAmountReceived() {
		return amountReceived;
	}

	public void setAmountReceived(float amountReceived) {
		this.amountReceived = amountReceived;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getNameOnCheck() {
		return nameOnCheck;
	}

	public void setNameOnCheck(String nameOnCheck) {
		this.nameOnCheck = nameOnCheck;
	}

	@Override
	public String toString() {
		return "Fee [id=" + id + ", checkDate=" + checkDate + ", checkType="
				+ checkType + ", feeType=" + feeType + ", amountReceived="
				+ amountReceived + ", memo=" + memo + ", nameOnCheck="
				+ nameOnCheck + "]";
	}
	
}
	
