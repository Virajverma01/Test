package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class invocationCount {
	
	@Test(invocationCount = 5)
	   public void demo() {
		Reporter.log("Demo Method");
	}

}
