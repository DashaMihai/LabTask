package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightTicketsPage {
	private WebDriver driver;
	
	@FindBy(xpath = "//*[text()='Авиабилеты']")
	private WebElement flightTicketsButton;

	@FindBy(xpath = "(//*[@class='fieldBlock airportBlock destinationBlock'])[1]")
	private WebElement destinationField;

	@FindBy(xpath = "//*[@id='ap-MOW/14713']")
	private WebElement airports;

	@FindBy(xpath = "(//*[@aria-label='Календарь'])[1]")
	private WebElement calendar;

	@FindBy(xpath = "(//*[text()='24'])[2]")
	private WebElement dayDepart;

	@FindBy(xpath = "(//*[text()='25'])[2]")
	private WebElement dayBack;

	@FindBy(xpath = "(//*[@class='fieldBlock buttonBlock']")
	private WebElement searchButoon;

	@FindBy(xpath = "//*[@id='c2rt5-price-mb-best']")
	private WebElement buyButoon;

	public FlightTicketsPage(WebDriver webdriver) {
		PageFactory.initElements(webdriver, this);
		this.driver = webdriver;
	}

	public void ticketSelection(String destination) {
		flightTicketsButton.click();
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(destinationField)).sendKeys(destination);
		airports.click();
		calendar.click();
		dayDepart.click();
		dayBack.click();
		searchButoon.click();
	}

	public boolean buyButtonPresents() {
		return buyButoon.isDisplayed();
	}

}
