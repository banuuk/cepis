
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


/**
 * @author cawalk4
 * 
 * NOTE: These are also known as "Professional Advisors" (Advisors in TEB166)
 *
 */
@Entity
@Table(name = "lstAdvisor")
@Cache(region="edu.uky.cepis.cache.advisor", usage=CacheConcurrencyStrategy.READ_WRITE)
public class Advisor implements Serializable, Comparator<Advisor> {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AdvisorUID", length=10)
	private String userid;
	
	@Column(name="status", length=10)
	private String status;
	
	@Formula(value="( SELECT concat_ws(' ',a.LName,a.FName) FROM tblIdentity a WHERE a.UID = AdvisorUID )" )
	private String shortDesc;
	
	@ManyToOne (targetEntity = Address.class)
	@NotFound(action=NotFoundAction.IGNORE)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="officeLocation")
	private Address officeLocation;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = AdvisingSession.class, mappedBy="advisor")	
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.advisingsession")
	private Set<AdvisingSession> advisingSessions = new HashSet<AdvisingSession>(0);
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = AdvisingSessionSlot.class, mappedBy="advisor")	
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "edu.uky.cepis.cache.advisingsessionslot")
	private Set<AdvisingSessionSlot> advisingSessionSlots = new HashSet<AdvisingSessionSlot>(0);
	
	
	public Advisor() {	
		
	}
	
	public Advisor(String userid) {
		this.userid = userid;
	}	
 
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public Address getOfficeLocation() {
		return officeLocation;
	}

	public void setOfficeLocation(Address officeLocation) {
		this.officeLocation = officeLocation;
	}

	public Set<AdvisingSession> getAdvisingSessions() {
		return advisingSessions;
	}

	public void setAdvisingSessions(Set<AdvisingSession> advisingSessions) {
		this.advisingSessions = advisingSessions;
	}

	public Set<AdvisingSessionSlot> getAdvisingSessionSlots() {
		return advisingSessionSlots;
	}

	public void setAdvisingSessionSlots(
			Set<AdvisingSessionSlot> advisingSessionSlots) {
		this.advisingSessionSlots = advisingSessionSlots;
	}

	@Override
	public String toString() {
		return shortDesc;
	}
	
	@Override
	public int compare(Advisor o1, Advisor o2) {
		return o1.getUserid().compareTo(o2.getUserid());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Advisor other = (Advisor) obj;
		if (shortDesc == null) {
			if (other.shortDesc != null)
				return false;
		} else if (!shortDesc.equals(other.shortDesc))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
	
}
