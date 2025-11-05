package ExtentReports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent {

    ExtentReports report;

    @BeforeSuite
    public void repConfig() {
        String rep = JavaUtility.currentTime(); // Assuming you have this method to return timestamp

        // Corrected path & folder name spelling
        ExtentSparkReporter spark = new ExtentSparkReporter("/vtiger-crm-fw-project/reports/" + rep + ".html");
        spark.config().setDocumentTitle("Saucedemo Report");
        spark.config().setReportName("Functional Report");
        spark.config().setTheme(Theme.STANDARD);

        report = new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("Key1", "Value1");
        report.setSystemInfo("Key2", "Value2");
        report.setSystemInfo("Key3", "Value3");
        report.setSystemInfo("Key4", "Value4");
    }

    @Test
    public void login1() {
        ExtentTest test = report.createTest("login1");
        test.log(Status.PASS, "This test has passed");
    }

    @Test
    public void login2() {
        ExtentTest test = report.createTest("login2");
        test.log(Status.FAIL, "This test has failed");
    }

    @Test
    public void login3() {
        ExtentTest test = report.createTest("login3");
        test.log(Status.SKIP, "This test was skipped");
    }

    @Test
    public void login4() {
        ExtentTest test = report.createTest("login4");
        test.log(Status.WARNING, "This test shows a warning");
    }

    @Test
    public void takeScreenshotTest() {
        ExtentTest test = report.createTest("takeScreenshotTest");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/v1/"); // Fixed typo in URL

        TakesScreenshot tks = (TakesScreenshot) driver;
        String ss = tks.getScreenshotAs(OutputType.BASE64);

        test.addScreenCaptureFromBase64String(ss, "Screenshot_" + JavaUtility.currentTime());
        driver.quit();
    }

    @AfterSuite
    public void repBackup() {
        report.flush();
    }
}
