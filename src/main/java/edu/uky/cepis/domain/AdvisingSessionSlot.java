/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author scott
 */
public class AdvisingSessionSlot implements
		java.util.Comparator<AdvisingSessionSlot>, Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private int slotNumber;
	private Date slotDate;
	private String status;
	private Date lastEdit;
	/**
	 * @uml.property name="advisor"
	 * @uml.associationEnd
	 */
	private Advisor advisor;

	/**
	 * 
	 */
	public AdvisingSessionSlot() {
	}

	/**
	 * @param id
	 * @param slotNumber
	 * @param slotDate
	 * @param status
	 */
	public AdvisingSessionSlot(String id, int slotNumber, Date slotDate,
			String status, Advisor advisor) {
		super();
		this.id = id;
		this.slotNumber = slotNumber;
		this.slotDate = slotDate;
		this.status = status;
		this.lastEdit = new Date();

		this.advisor = advisor;
	}

	/**
	 * @return the id
	 * @uml.property name="id"
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 * @uml.property name="id"
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the slotNumber
	 * @uml.property name="slotNumber"
	 */
	public int getSlotNumber() {
		return slotNumber;
	}

	/**
	 * @param slotNumber
	 *            the slotNumber to set
	 * @uml.property name="slotNumber"
	 */
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	/**
	 * @return the slotDate
	 * @uml.property name="slotDate"
	 */
	public Date getSlotDate() {
		return slotDate;
	}

	/**
	 * @param slotDate
	 *            the slotDate to set
	 * @uml.property name="slotDate"
	 */
	public void setSlotDate(Date slotDate) {
		this.slotDate = slotDate;
	}

	/**
	 * @return the status
	 * @uml.property name="status"
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 * @uml.property name="status"
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the lastEdit
	 * @uml.property name="lastEdit"
	 */
	public Date getLastEdit() {
		return lastEdit;
	}

	/**
	 * @param lastEdit
	 *            the lastEdit to set
	 * @uml.property name="lastEdit"
	 */
	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}

	/**
	 * @return the advisor
	 * @uml.property name="advisor"
	 */
	public Advisor getAdvisor() {
		return advisor;
	}

	/**
	 * @param advisor
	 *            the advisor to set
	 * @uml.property name="advisor"
	 */
	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AdvisingSessionSlot)) {
			return false;
		}
		AdvisingSessionSlot other = (AdvisingSessionSlot) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public int compare(AdvisingSessionSlot o1, AdvisingSessionSlot o2) {
		return o1.getId().compareTo(o2.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		if (slotDate != null && slotNumber >= 0) {
			int year, month, day, hour, minute = 0;
			String s;
			DateFormat formatter;
			Date date;

			Calendar cal = Calendar.getInstance();
			cal.setTime(slotDate);

			formatter = new SimpleDateFormat("yyyy.MM.dd.HH.mm");

			// get the details
			date = slotDate;
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH) + 1;
			day = cal.get(Calendar.DAY_OF_MONTH);

			hour = (int) Math.floor(9 + slotNumber * 30 / 60 - 1);

			if (!((slotNumber % 2) == 0))
				minute = 30;

			s = String.format("%d.%d.%d.%d.%d", year, month, day, hour, minute);

			try {
				date = (Date) formatter.parse(s);
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}

			formatter = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm aaa");
			s = formatter.format(date);
			return s;
		}
		return "AdvisingSessionSlot [id=" + id + ", slotNumber=" + slotNumber
				+ ", slotDate=" + slotDate + ", status=" + status
				+ ", lastEdit=" + lastEdit + ", advisor=" + advisor + "]";
	}

}
