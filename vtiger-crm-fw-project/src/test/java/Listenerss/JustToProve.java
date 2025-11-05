package Listenerss;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listenerss.listen.class)

public class JustToProve {
	
	@BeforeSuite
	public void bs() {
		System.out.println("I Am @BeforeSuite");
	}
	
	@Test
	public void case1() {
		System.out.println("Test Method");
	}
	
	
	@AfterSuite
	public void as() {
		System.out.println("I Am @AfterSuite");
	}

}
