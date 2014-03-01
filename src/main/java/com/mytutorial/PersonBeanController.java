/**
 * 
 */
package com.mytutorial;

/**
 * @author  keerthi
 */

public class PersonBeanController {
	/**
	 * @uml.property  name="person"
	 * @uml.associationEnd  
	 */
	PersonBean person; 
	
	public String getPersonName() {
		return person.getPersonName();
	}

	public void setPersonName(String personName) {
		person.setPersonName(personName);
	}

	/**
	 * @return
	 * @uml.property  name="person"
	 */
	public PersonBean getPerson() {
		return person;
	}

	/**
	 * @param person
	 * @uml.property  name="person"
	 */
	public void setPerson(PersonBean person) {
		this.person = person;
	}

}
