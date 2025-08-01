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
	        {"abc@yz@example.com"},
	        {"abc#xyz@example.com"},
	        {"abc xyz@example.com"},
	        {"abc.xyz@example..com"},
	        {".abc@xyz.com"},
	        {"abc.@xyz.com"},
	        
	    };
	}
	
	@DataProvider(name = "validEmails")
	public Object[][] validEmails() {
	    return new Object[][] {
	        {"abc.xyz@gmail.co.in"},
	        {"abc.xyz@gmail.co.in"},
	        {"ABC@GMAIL.COM"},
	        {"abc.xyz@gmail.co.in"},
	        {"abc123@gmail.com"},
	    };
	}
	

}
