package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;

public class SourceCode {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/v1/");

		LoginPage lp = new LoginPage(driver);

		WebElement un = lp.getun();
		WebElement pwd = lp.getpwd();
		WebElement login = lp.getlogin();

		driver.navigate().refresh();

		un.sendKeys("standard_user");
		pwd.sendKeys("secret_sauce");
		login.click();
		
		
		HomePage hp = new HomePage(driver);
		
		WebElement lg = hp.getlogo();
		
		if(lg.isDisplayed()) {
			System.out.println("LggedIn Succesfully");
		}
		else {
			System.out.println("Failed !! ");
		}
		
		AddCart ac = new AddCart(driver);
		
		WebElement btn = ac.btn();
		btn.click();
					
				
		Thread.sleep(5000);
		driver.quit();
	}

}
