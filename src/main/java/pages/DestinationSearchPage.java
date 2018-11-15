package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DestinationSearchPage extends AbstractBookingPage {

	@FindBy(xpath = "//*[text()='Проверить цены']")
	private WebElement searchButton;

	@FindBy(xpath = "//*[@placeholder='Минск']")
	private WebElement destinationLink;

	public DestinationSearchPage(WebDriver webdriver) {
		PageFactory.initElements(webdriver, this);
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public boolean destinationLinkPresents() {
		return destinationLink.isDisplayed();
	}
}
