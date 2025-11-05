package Listenerss;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class listen  implements ISuiteListener{

	public void onStart(ISuite suite) {
		System.out.println("Executes Before the @beforeSuite");
	}
	
	public void onFinish(ISuite suite) {
		System.out.println("Executes Befoe the @AfterSuite");
	}
	
	

}
