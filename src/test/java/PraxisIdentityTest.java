   
  
import static org.junit.Assert.*;  

import java.util.Date;
  
import org.junit.Test;  
import edu.uky.cepis.dao.PraxisIdentityDao;
import edu.uky.cepis.domain.PraxisIdentity;  
  
public class PraxisIdentityTest {  
    
 private PraxisIdentityDao praxisIdentityDAO;  
   
 	@Test  
 	public void testCreatePraxisIdentity()  {  
		 String candidateID ="testid";
		 String ssn ="233412222";
		 String fName ="First Name";
		 String lName ="Last Name";
		 String address ="address goes here";
		 String city ="my city";
		 String state ="my state";
		 String zip ="zipcode";
		 Date dob = new Date();
		
		 PraxisIdentity identity = praxisIdentityDAO.createPraxisIdentity(candidateID, ssn, lName, fName, address, city, zip, state, dob);  
	    
		 assertEquals(ssn, identity.getSid());  
	 }  
 
/* @Test
	public  void main() {

		try {
			testCreatePraxisIdentity();
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
  
 	} */ 
}