/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author keerthi
 */
public class SharedUser implements Serializable, java.util.Comparator<SharedUser> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="id"
	 */
	private long id;
	/**
	 * @uml.property  name="street1"
	 */
	private User user;
	/**
	 * @uml.property  name="street2"
	 */
	private boolean allowAddOperation;
	/**
	 * @uml.property  name="city"
	 */
	private boolean allowRemoveOperation;
	
	private Date lastEdit;
	
	public SharedUser(){
		
	}
		/**
	 * @param user
	 * @param allowAddOperation
	 * @param allowRemoveOperation
	 * @param lastEdit
	 */
	public SharedUser(User user, boolean allowAddOperation,
			boolean allowRemoveOperation) {
		this.user = user;
		this.allowAddOperation = allowAddOperation;
		this.allowRemoveOperation = allowRemoveOperation;
		this.lastEdit = new Date();
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @return the allowAddOperation
	 */
	public boolean isAllowAddOperation() {
		return allowAddOperation;
	}
	/**
	 * @return the allowRemoveOperation
	 */
	public boolean isAllowRemoveOperation() {
		return allowRemoveOperation;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @param allowAddOperation the allowAddOperation to set
	 */
	public void setAllowAddOperation(boolean allowAddOperation) {
		this.allowAddOperation = allowAddOperation;
	}
	/**
	 * @param allowRemoveOperation the allowRemoveOperation to set
	 */
	public void setAllowRemoveOperation(boolean allowRemoveOperation) {
		this.allowRemoveOperation = allowRemoveOperation;
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

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (allowAddOperation ? 1231 : 1237);
		result = prime * result + (allowRemoveOperation ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((lastEdit == null) ? 0 : lastEdit.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	/* (non-Javadoc)
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
		if (!(obj instanceof SharedUser)) {
			return false;
		}
		SharedUser other = (SharedUser) obj;
		if (allowAddOperation != other.allowAddOperation) {
			return false;
		}
		if (allowRemoveOperation != other.allowRemoveOperation) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (lastEdit == null) {
			if (other.lastEdit != null) {
				return false;
			}
		} else if (!lastEdit.equals(other.lastEdit)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}
	@Override
	public int compare(SharedUser o1, SharedUser o2) {
		return o1.getUser().getUid().compareTo(o1.getUser().getUid())
				& new Boolean(o1.isAllowAddOperation()).compareTo(new Boolean(o2.allowAddOperation))
				& new Boolean(o1.isAllowRemoveOperation()).compareTo(new Boolean(o2.allowRemoveOperation));
	}

}
