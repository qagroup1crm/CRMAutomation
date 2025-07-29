package dataProviders;
import org.testng.annotations.DataProvider;
public class CreateUserDP {
	
	
	@DataProvider(name = "invalidEmails")
	public Object[][] invalidEmails() {
	    return new Object[][] {
	        {"abc.com"},
	        {"abc@.com"},
	        {"abc@com"},
	        {"@example.com"},
	        {"abc@.com."},
	        {""},
	        {"abc@yz@example.com"},
	        {"abc#xyz@example.com"},
	        {"abc xyz@example.com"},
	        {"abc.xyz@example..com"},
	        {".abc@xyz.com"},
	        {"abc.@xyz.com"},
	        
	    };
	}
	

}
