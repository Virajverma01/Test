package organization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("http://localhost:8888/index.php?action=Login&module=Users");

		driver.findElement(By.cssSelector("input[name='user_name']")).sendKeys("admin");

		driver.findElement(By.cssSelector("input[name='user_password']")).sendKeys("manager");

		driver.findElement(By.id("submitButton")).click();

		Thread.sleep(6000);

		driver.findElement(By.linkText("Organizations")).click();

		Thread.sleep(3000);

		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

		Thread.sleep(3000);

		String name = "Wipro";
		
        WebElement orgName = driver.findElement(By.cssSelector("input[name='accountname']"));

		orgName.sendKeys(name);

		driver.findElement(By.id("phone")).sendKeys("1234567890");

		driver.findElement(By.id("email1")).sendKeys("example123@gmail.com");
		
		driver.findElement(By.xpath("//input[contains(@value,'  Save  ')]")).click();

		Thread.sleep(4000);

		driver.quit();

	}
	  

}
