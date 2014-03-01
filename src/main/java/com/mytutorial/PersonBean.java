/**
 * 
 */
package com.mytutorial;

/**
 * @author  keerthi
 */
public class PersonBean {
	
	

	/**
	 * @uml.property  name="personName"
	 */
	String personName;
	
	/**
	 * @param personName
	 */
	public PersonBean() {
		super();
		this.personName = " ";
	}
	
	/**
	 * @param personName
	 */
	public PersonBean(String personName) {
		super();
		this.personName = personName;
	}
	/**
	 * @return  the personName
	 * @uml.property  name="personName"
	 */
	public String getPersonName() {
		return personName;
	}

	/**
	 * @param personName  the personName to set
	 * @uml.property  name="personName"
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

}
