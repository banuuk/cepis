/**
 * 
 */
package edu.uky.cepis.view.validator;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @author keerthi
 *
 */
public class UKStatusDataValidator implements Validator {

	/* (non-Javadoc)
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) {
		System.out.println("Calling Validator");
		try{
		if(!(arg2 instanceof Object)  ){
			System.out.println("Invalid argument - Not a Set or Collection: " + arg2.getClass());
		}
		}
		catch(ValidatorException e){
			System.out.println("Exception Invalid argument - Not a Set or Collection: " + arg2.getClass());
		}

	}

}
