/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.util.Date;

import edu.uky.cepis.domain.component.UKTerm;

/**
 * @author keerthi
 */
public class HoldLift implements Serializable, java.util.Comparator<HoldLift> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property name="id"
	 */
	private long id;
	private User liftedBy;
	private UKTerm term;
	private Date addedOn;

	/**
	 * 
	 */
	public HoldLift() {
	}

	/**
	 * @param liftedBy
	 * @param term
	 */
	public HoldLift(User liftedBy, UKTerm term) {
		this.liftedBy = liftedBy;
		this.term = term;
		this.addedOn = new Date();
	}

	/**
	 * @return the id
	 * @uml.property name="id"
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 * @uml.property name="id"
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the liftedBy
	 */
	public User getLiftedBy() {
		return liftedBy;
	}

	/**
	 * @return the term
	 */
	public UKTerm getTerm() {
		return term;
	}

	/**
	 * @return the addedOn
	 */
	public Date getAddedOn() {
		return addedOn;
	}


	/**
	 * @param liftedBy
	 *            the liftedBy to set
	 */
	public void setLiftedBy(User liftedBy) {
		this.liftedBy = liftedBy;
	}

	/**
	 * @param term
	 *            the term to set
	 */
	public void setTerm(UKTerm term) {
		this.term = term;
	}

	/**
	 * @param addedOn
	 *            the addedOn to set
	 */
	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
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
		result = prime * result + ((addedOn == null) ? 0 : addedOn.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((liftedBy == null) ? 0 : liftedBy.hashCode());
		result = prime * result + ((term == null) ? 0 : term.hashCode());
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
		if (!(obj instanceof HoldLift)) {
			return false;
		}
		HoldLift other = (HoldLift) obj;
		if (addedOn == null) {
			if (other.addedOn != null) {
				return false;
			}
		} else if (!addedOn.equals(other.addedOn)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (liftedBy == null) {
			if (other.liftedBy != null) {
				return false;
			}
		} else if (!liftedBy.equals(other.liftedBy)) {
			return false;
		}
		if (term == null) {
			if (other.term != null) {
				return false;
			}
		} else if (!term.equals(other.term)) {
			return false;
		}
		return true;
	}

	@Override
	public int compare(HoldLift o1, HoldLift o2) {
		return (int) (o1.getId() - o2.getId())
				& o1.liftedBy.compare(o1.liftedBy, o2.liftedBy)
				& o1.term.compare(o1.term, o2.term);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.term+" ( "+this.liftedBy+")";
	}

}
