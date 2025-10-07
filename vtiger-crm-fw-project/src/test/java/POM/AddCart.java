package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCart {
	
	public AddCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()=\"29.99\"]/ancestor::div[contains(@class, 'inventory_item')]//button[text()=\"ADD TO CART\"]")
		     private WebElement btn;
	
	public WebElement btn() {
		return btn;
	}
		     
}
