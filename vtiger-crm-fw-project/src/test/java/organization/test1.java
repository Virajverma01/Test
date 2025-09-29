package organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test1 {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("http://localhost:8888/index.php?action=Login&module=Users");

		FileInputStream fis = new FileInputStream("./src/test/resources/testscriptdata.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		org.apache.poi.ss.usermodel.Sheet sr = wb.getSheet("testscriptdata");

		Row row = sr.getRow(1);

		Cell cl = row.getCell(0);

		String org = cl.getStringCellValue();

		driver.findElement(By.cssSelector("input[name='user_name']")).sendKeys("admin");

		driver.findElement(By.cssSelector("input[name='user_password']")).sendKeys("manager");

		driver.findElement(By.id("submitButton")).click();

		Thread.sleep(6000);

		driver.findElement(By.linkText("Organizations")).click();

		Thread.sleep(3000);

		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

		Thread.sleep(3000);

		String name = org;
		WebElement orgName = driver.findElement(By.cssSelector("input[name='accountname']"));

		orgName.sendKeys(name);

		driver.findElement(By.id("phone")).sendKeys("1873582820");

		driver.findElement(By.id("email1")).sendKeys("example124@gmail.com");

		driver.findElement(By.xpath("//input[contains(@value,'  Save  ')]")).click();

		Thread.sleep(4000);

		driver.quit();
		wb.close();

	}

}
