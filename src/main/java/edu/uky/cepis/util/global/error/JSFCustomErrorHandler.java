/**
 * 
 */
package edu.uky.cepis.util.global.error;

import java.io.IOException;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;

/**
 * @author keerthi
 *
 */
public class JSFCustomErrorHandler  {
	
	public JSFCustomErrorHandler() {
	}
	public void handleException(FacesContext fc, Exception ex) throws IOException,
        FacesException {
       System.out.println("Calling JSFCustomErrorHandler");
	}
	
	

}
