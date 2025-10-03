package organization;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.WebDriverUtility;

public class testscript {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		WebDriverUtility util = new WebDriverUtility(driver);

		// ---------------- Browser Methods ----------------
		util.winMax();
		util.openUrl("https://www.selenium.dev/");
		System.out.println("Title: " + util.getTitle());
		System.out.println("URL: " + util.getCurrentUrl());
		System.out.println("Page Source length: " + util.getPageSource().length());
		System.out.println("Window Position: " + util.getPosition());

		// ---------------- Element Methods ----------------
		WebElement searchBox = util.findByXpath("//input[@type='search']");
		util.clearAndType(searchBox, "WebDriver");
		util.pressEnter(searchBox);

		// Wait for results
		WebElement resultsHeading = util.findByXpath("//h1[contains(text(),'Search Results')]");
		util.explicitWait(resultsHeading, 10);
		System.out.println("Heading: " + util.getElementText(resultsHeading));

		// ---------------- Actions ----------------
		util.scrollIntoView(resultsHeading);
		util.highlightElement(resultsHeading);

		// Some Actions demo
		util.moveByOffset(10, 20);
		util.keyDown(Keys.CANCEL);
		util.keyUp(Keys.ADD);

		// ---------------- JavaScript Methods ----------------
		System.out.println("JS Title: " + util.jsGetTitle());
		System.out.println("Page Ready State: " + util.getPageReadyState());

		util.scrollToBottom();
		util.scrollToTop();

		// ---------------- Alerts (Demo purpose only) ----------------
		// (No alert here, just showing usage)
		/*
		 * if (util.isAlertPresent()) { System.out.println(util.getAlertText());
		 * util.acceptAlert(); }
		 */

		// ---------------- Frames ----------------
		// (No iframe on this page, example usage)
		/*
		 * util.switchToFrame(0); util.switchToDefaultContent();
		 */

		// ---------------- Windows ----------------
		util.openNewTab();
		util.switchToLastTab();
		util.openUrl("https://www.google.com/");
		util.switchToWindowByIndex(0);

		// ---------------- Screenshots ----------------
		try {
			System.out.println("Screenshot: " + util.takeScreenshot("selenium_home"));
			System.out.println("Element Screenshot: " + util.takeElementScreenshot(resultsHeading, "headingElement"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ---------------- Dropdowns (Example) ----------------
		// (Needs a dropdown element, just showing usage)
		/*
		 * WebElement dropdown = util.findById("dropdownId");
		 * util.selectByIndex(dropdown, 1); util.selectByValue(dropdown, "value1");
		 * util.selectByVisibleText(dropdown, "Option 1");
		 */

		// ---------------- Cookies ----------------
		util.addCookie("TestCookie", "123");
		System.out.println("Cookie: " + util.getCookie("TestCookie"));
		util.deleteCookie("TestCookie");
		util.deleteAllCookies();

		// ---------------- Navigation ----------------
		util.navigateTo("https://example.com");
		util.navigateBack();
		util.navigateForward();
		util.navigateRefresh();

		// ---------------- Verify Methods ----------------
		System.out.println("Verify Title: " + util.verifyTitle("Example Domain"));
		System.out.println("Verify URL: " + util.verifyUrl("https://example.com/"));

		// ---------------- Table (example if present) ----------------
		/*
		 * WebElement table = util.findByXpath("//table"); System.out.println("Rows: " +
		 * util.getTableRowCount(table)); System.out.println("Cols: " +
		 * util.getTableColumnCount(table));
		 */

		// ---------------- File Handling ----------------
		// (Needs a download directory & file name)
		/*
		 * boolean isDownloaded = util.waitForFileDownload("C:/Downloads", "file.txt",
		 * 10); System.out.println("File downloaded: " + isDownloaded);
		 */

		// ---------------- Keyboard Shortcuts ----------------
		util.ctrlA(searchBox);
		util.ctrlC(searchBox);
		util.ctrlV(searchBox);

		// ---------------- Extra Actions ----------------
		util.scrollBy(0, 200);
		util.zoomIn();
		util.zoomOut();

		// ---------------- Clean Up ----------------
		util.winQuit();
	}
}
