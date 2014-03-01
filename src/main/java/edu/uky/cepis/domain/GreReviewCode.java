/**
 * 
 */
package edu.uky.cepis.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author cawalk4
 *
 */
@Entity
@Table(name="lstReview")
public class GreReviewCode implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id	
	@Column(name="ReviewCode", length = 50)
	private String reviewCode;
	
	@Column(name = "Name", length = 50)
	private String name;
	
	@Column(name = "Description", length = 255)
	private String description;
		
				
	public GreReviewCode(){
		
	}


	public String getReviewCode() {
		return reviewCode;
	}


	public void setReviewCode(String reviewCode) {
		this.reviewCode = reviewCode;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((reviewCode == null) ? 0 : reviewCode.hashCode());
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
		GreReviewCode other = (GreReviewCode) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reviewCode == null) {
			if (other.reviewCode != null)
				return false;
		} else if (!reviewCode.equals(other.reviewCode))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "GreReviewCode [reviewCode=" + reviewCode + ", name=" + name
				+ ", description=" + description + "]";
	}


		
	

}
	
