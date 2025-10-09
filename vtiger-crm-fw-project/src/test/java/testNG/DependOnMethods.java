package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependOnMethods {
	
	@Test
	public void createAccount(){	
		Reporter.log("Account Is Created!!");
	}
	
	@Test(dependsOnMethods = "createAccount")
		public void modifyAccount() {
			Reporter.log("Account is Modified ");
		}
	
	@Test(dependsOnMethods = "modifyAccount")
	   public void deleteAccount() {
		Reporter.log("Account is Deleted ");
	}

}
