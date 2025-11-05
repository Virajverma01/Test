package ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentsparkReport {

    @Test
    public void loginTest() 	{  
        ExtentSparkReporter spark = new ExtentSparkReporter("/vtiger-crm-fw-project/src/main/java/report/report.html");
        spark.config().setDocumentTitle("Saucedemo Login Report");
        spark.config().setReportName("Functional Test Report");
        spark.config().setTheme(Theme.STANDARD);

        ExtentReports  extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("OS", "Windows 11");
        extent.setSystemInfo("Version", "2.0");

        
       ExtentTest test = extent.createTest("Login Test");

      
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");
        test.info("Navigated to Saucedemo website");
        test.log(Status.PASS, "This Is Passing");

      
        String title = driver.getTitle();
        test.info("Page title is: " + title);

  
        driver.quit();
        extent.flush();
    }
}
