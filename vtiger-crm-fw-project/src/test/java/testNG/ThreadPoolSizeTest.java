package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ThreadPoolSizeTest {
	
	@Test(invocationCount = 10, threadPoolSize = 3)
	   public void case1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(6000);
		driver.quit();
	}

}
