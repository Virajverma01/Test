package generic_utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class WebDriverUtility {
	    WebDriver driver;
	    Actions act;

	    public WebDriverUtility(WebDriver driver) {
	        this.driver = driver;
	        this.act = new Actions(driver);
	    }

	    public void winMax() {
	        driver.manage().window().maximize();
	    }

	    public void winClose() {
	        driver.close();
	    }

	    public void winQuit() {
	        driver.quit();
	    }

	    public Point getPosition() {
	        return driver.manage().window().getPosition();
	    }

	    public void openUrl(String url) {
	        driver.get(url);
	    }

	    public void refresh() {
	        driver.navigate().refresh();
	    }

	    public void back() {
	        driver.navigate().back();
	    }

	    public void forward() {
	        driver.navigate().forward();
	    }

	    public void implicitWait(long seconds) {
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	    }
	    
	    public boolean isDisplayed(WebElement element) {
		    return element.isDisplayed();
		}

		public boolean isEnabled(WebElement element) {
		    return element.isEnabled();
		}

		public boolean isSelected(WebElement element) {
		    return element.isSelected();
		}

		public String getElementText(WebElement element) {
		    return element.getText();
		}

		public String getElementAttribute(WebElement element, String attribute) {
		    return element.getAttribute(attribute);
		}

		public void clearAndType(WebElement element, String value) {
		    element.clear();
		    element.sendKeys(value);
		}

		public String getTitle() {
		    return driver.getTitle();
		}

		public String getCurrentUrl() {
		    return driver.getCurrentUrl();
		}

		public String getPageSource() {
		    return driver.getPageSource();
		}

		public List<WebElement> getAllOptions(WebElement element) {
		    return new Select(element).getOptions();
		}

		public String getFirstSelectedOption(WebElement element) {
		    return new Select(element).getFirstSelectedOption().getText();
		}

		public void deselectAll(WebElement element) {
		    new Select(element).deselectAll();
		}

		public void deselectByIndex(WebElement element, int index) {
		    new Select(element).deselectByIndex(index);
		}

		public void deselectByValue(WebElement element, String value) {
		    new Select(element).deselectByValue(value);
		}

		public void deselectByVisibleText(WebElement element, String text) {
		    new Select(element).deselectByVisibleText(text);
		}
		

	    public WebElement explicitWait(WebElement element, long seconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	        return wait.until(ExpectedConditions.visibilityOf(element));
	    }

	    public WebElement waitForClickable(WebElement element, long seconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	        return wait.until(ExpectedConditions.elementToBeClickable(element));
	    }

	    public boolean waitForAlert(long seconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	        return wait.until(ExpectedConditions.alertIsPresent()) != null;
	    }


	    public void selectByIndex(WebElement element, int index) {
	        new Select(element).selectByIndex(index);
	    }

	    public void selectByValue(WebElement element, String value) {
	        new Select(element).selectByValue(value);
	    }

	    public void selectByVisibleText(WebElement element, String visibleText) {
	        new Select(element).selectByVisibleText(visibleText);
	    }

	    public void hover(WebElement targetElement) {
	        act.moveToElement(targetElement).perform();
	    }

	    public void rightClick(WebElement targetElement) {
	        act.contextClick(targetElement).perform();
	    }

	    public void doubleClick(WebElement targetElement) {
	        act.doubleClick(targetElement).perform();
	    }

	    public void leftClick(WebElement targetElement) {
	        act.click(targetElement).perform();
	    }

	    public void dragAndDrop(WebElement src, WebElement dest) {
	        act.dragAndDrop(src, dest).perform();
	    }

	    public void moveByOffset(int x, int y) {
	        act.moveByOffset(x, y).perform();
	    }

	    public void keyDown(Keys key) {
	        act.keyDown(key).perform();
	    }

	    public void keyUp(Keys key) {
	        act.keyUp(key).perform();
	    }
	    
	    

	    public void jsClick(WebElement element) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	    }

	    public void jsSendKeys(WebElement element, String value) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", element);
	    }

	    public void scrollIntoView(WebElement element) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	    }

	    public void scrollBy(int x, int y) {
	        ((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ")");
	    }

	    public void highlightElement(WebElement element) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
	    }

	    public void acceptAlert() {
	        driver.switchTo().alert().accept();
	    }

	    public void dismissAlert() {
	        driver.switchTo().alert().dismiss();
	    }

	    public String getAlertText() {
	        return driver.switchTo().alert().getText();
	    }

	    public void sendKeysToAlert(String text) {
	        driver.switchTo().alert().sendKeys(text);
	    }

	  
	    public void switchToFrame(int index) {
	        driver.switchTo().frame(index);
	    }

	    public void switchToFrame(String nameOrId) {
	        driver.switchTo().frame(nameOrId);
	    }

	    public void switchToFrame(WebElement frameElement) {
	        driver.switchTo().frame(frameElement);
	    }

	    public void switchToDefaultContent() {
	        driver.switchTo().defaultContent();
	    }

	 
	    public void switchToWindow(String partialTitle) {
	        Set<String> windows = driver.getWindowHandles();
	        for (String win : windows) {
	            if (driver.switchTo().window(win).getTitle().contains(partialTitle)) {
	                break;
	            }
	        }
	    }

	    
	    public String takeScreenshot(String fileName) throws IOException {
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String dest = System.getProperty("user.dir") + "/screenshots/" + fileName + ".png";
	        FileUtils.copyFile(src, new File(dest));
	        return dest;
	    }
	
	
	public void fluentWait(WebElement element, int timeout, int pollingTime) {
	    Wait<WebDriver> wait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(timeout))
	            .pollingEvery(Duration.ofSeconds(pollingTime))
	            .ignoring(NoSuchElementException.class);
	    wait.until(ExpectedConditions.visibilityOf(element));
	}

	public boolean waitForUrlContains(String partialUrl, long seconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	    return wait.until(ExpectedConditions.urlContains(partialUrl));
	}

	
	public String takeElementScreenshot(WebElement element, String fileName) throws IOException {
	    File src = element.getScreenshotAs(OutputType.FILE);
	    String dest = System.getProperty("user.dir") + "/screenshots/" + fileName + ".png";
	    FileUtils.copyFile(src, new File(dest));
	    return dest;
	}

	
	public String jsGetTitle() {
	    return (String) ((JavascriptExecutor) driver).executeScript("return document.title;");
	}

	public void jsRefresh() {
	    ((JavascriptExecutor) driver).executeScript("history.go(0)");
	}

	public String jsGetInnerText(WebElement element) {
	    return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", element);
	}
 
	
	public int getWindowCount() {
	    return driver.getWindowHandles().size();
	}

	public void switchToWindowByIndex(int index) {
	    Set<String> windows = driver.getWindowHandles();
	    int i = 0;
	    for (String win : windows) {
	        if (i == index) {
	            driver.switchTo().window(win);
	            break;
	        }
	        i++;
	    }
	}

	
	public void pressEnter(WebElement element) {
	    element.sendKeys(Keys.ENTER);
	}

	public void pressTab(WebElement element) {
	    element.sendKeys(Keys.TAB);
	}

	public void pressEsc(WebElement element) {
	    element.sendKeys(Keys.ESCAPE);
	}

	
	public void fileUpload(WebElement element, String filePath) {
	    element.sendKeys(filePath);
	}

	public boolean isAlertPresent() {
	    try {
	        driver.switchTo().alert();
	        return true;
	    } catch (NoAlertPresentException e) {
	        return false;
	    }
	}

	public void zoomIn() {
	    ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='120%'");
	}

	public void zoomOut() {
	    ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
	}

	
	public WebElement findById(String id) {
	    return driver.findElement(By.id(id));
	}

	public WebElement findByName(String name) {
	    return driver.findElement(By.name(name));
	}

	public WebElement findByXpath(String xpath) {
	    return driver.findElement(By.xpath(xpath));
	}

	public List<WebElement> findAllByXpath(String xpath) {
	    return driver.findElements(By.xpath(xpath));
	}

	
	public void clickAndHold(WebElement element) {
	    act.clickAndHold(element).perform();
	}

	public void release(WebElement element) {
	    act.release(element).perform();
	}

	public void dragAndDropByOffset(WebElement src, int xOffset, int yOffset) {
	    act.dragAndDropBy(src, xOffset, yOffset).perform();
	}

	public void sendKeysWithActions(WebElement element, String text) {
	    act.moveToElement(element).click().sendKeys(text).perform();
	}

	
	public boolean waitForText(WebElement element, String text, long seconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	    return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public boolean waitForInvisibility(WebElement element, long seconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	    return wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public boolean waitForTitle(String title, long seconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	    return wait.until(ExpectedConditions.titleContains(title));
	}

	
	public byte[] takeScreenshotAsBytes() {
	    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public String takeBase64Screenshot() {
	    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}

	
	public void scrollToBottom() {
	    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollToTop() {
	    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
	}

	public String getPageReadyState() {
	    return (String) ((JavascriptExecutor) driver).executeScript("return document.readyState");
	}

	public void setValueUsingJS(WebElement element, String value) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	
	public void openNewTab() {
	    ((JavascriptExecutor) driver).executeScript("window.open()");
	}

	public void switchToLastTab() {
	    Set<String> windows = driver.getWindowHandles();
	    String lastHandle = windows.toArray()[windows.size() - 1].toString();
	    driver.switchTo().window(lastHandle);
	}

	public void closeCurrentTabAndSwitchBack() {
	    String current = driver.getWindowHandle();
	    driver.close();
	    for (String win : driver.getWindowHandles()) {
	        if (!win.equals(current)) {
	            driver.switchTo().window(win);
	            break;
	        }
	    }
	}

	
	public int getTableRowCount(WebElement table) {
	    return table.findElements(By.tagName("tr")).size();
	}

	public int getTableColumnCount(WebElement table) {
	    return table.findElements(By.tagName("td")).size();
	}

	public List<String> getAllLinksText() {
	    List<WebElement> links = driver.findElements(By.tagName("a"));
	    List<String> linkTexts = new ArrayList<>();
	    for (WebElement link : links) {
	        linkTexts.add(link.getText());
	    }
	    return linkTexts;
	}
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
	    File file = new File(downloadPath + "/" + fileName);
	    return file.exists();
	}

	public void deleteFileIfExists(String downloadPath, String fileName) {
	    File file = new File(downloadPath + "/" + fileName);
	    if (file.exists()) file.delete();
	}

	
	public void pressKey(int keyEvent) throws AWTException {
	    Robot robot = new Robot();
	    robot.keyPress(keyEvent);
	    robot.keyRelease(keyEvent);
	}

	
	public void addCookie(String name, String value) {
	    driver.manage().addCookie(new Cookie(name, value));
	}

	public Cookie getCookie(String name) {
	    return driver.manage().getCookieNamed(name);
	}

	public void deleteCookie(String name) {
	    driver.manage().deleteCookieNamed(name);
	}

	public void deleteAllCookies() {
	    driver.manage().deleteAllCookies();
	}

	
	public void navigateTo(String url) {
	    driver.navigate().to(url);
	}

	public void navigateBack() {
	    driver.navigate().back();
	}

	public void navigateForward() {
	    driver.navigate().forward();
	}

	public void navigateRefresh() {
	    driver.navigate().refresh();
	}

	
	public void ctrlA(WebElement element) {
	    element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	}

	public void ctrlC(WebElement element) {
	    element.sendKeys(Keys.chord(Keys.CONTROL, "c"));
	}

	public void ctrlV(WebElement element) {
	    element.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}

	public Dimension getElementSize(WebElement element) {
	    return element.getSize();
	}

	public Point getElementLocation(WebElement element) {
	    return element.getLocation();
	}

	public String getCssValue(WebElement element, String property) {
	    return element.getCssValue(property);
	}

	public boolean isElementPresent(By locator) {
	    return !driver.findElements(locator).isEmpty();
	}

	
	public void setWindowSize(int width, int height) {
	    driver.manage().window().setSize(new Dimension(width, height));
	}

	public void setWindowPosition(int x, int y) {
	    driver.manage().window().setPosition(new Point(x, y));
	}

	public Rectangle getWindowRect() {
	    return ((WebElement) driver.manage().window()).getRect();
	}

	
	public boolean verifyTitle(String expectedTitle) {
	    return driver.getTitle().equals(expectedTitle);
	}

	public boolean verifyUrl(String expectedUrl) {
	    return driver.getCurrentUrl().equals(expectedUrl);
	}

	public boolean verifyText(WebElement element, String expectedText) {
	    return element.getText().equals(expectedText);
	}

	
	public void switchToParentFrame() {
	    driver.switchTo().parentFrame();
	}

	public int getIframeCount() {
	    return driver.findElements(By.tagName("iframe")).size();
	}

	
	public boolean waitForFileDownload(String downloadPath, String fileName, int timeoutSec) {
	    File file = new File(downloadPath + "/" + fileName);
	    int counter = 0;
	    while (counter < timeoutSec) {
	        if (file.exists()) return true;
	        try { Thread.sleep(1000); } catch (InterruptedException e) {}
	        counter++;
	    }
	    return false;
	}

	
	public void fillInput(WebElement element, String value) {
	    element.clear();
	    element.sendKeys(value);
	}

	public void clearField(WebElement element) {
	    element.clear();
	}

}
