package organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getDataFromExcel {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("http://localhost:8888/index.php?action=Login&module=Users");

		fileUtility fu = new fileUtility();
		

		driver.findElement(By.cssSelector("input[name='user_name']")).sendKeys("admin");

		driver.findElement(By.cssSelector("input[name='user_password']")).sendKeys("manager");

		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

		String name = fu.getDataFromExcel("org", 3, 0);
		WebElement orgName = driver.findElement(By.cssSelector("input[name='accountname']"));

		orgName.sendKeys(name);

		driver.findElement(By.id("phone")).sendKeys("1873582820");

		driver.findElement(By.id("email1")).sendKeys("example124@gmail.com");

		driver.findElement(By.xpath("//input[contains(@value,'  Save  ')]")).click();

		Thread.sleep(4000);

		driver.quit();
		

	}

}
