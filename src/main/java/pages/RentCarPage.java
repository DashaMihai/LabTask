package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentCarPage {
	private WebDriver driver;

	@FindBy(xpath = "//*[text()='Аренда машин']")
	private WebElement rentCarButton;

	@FindBy(xpath = "//*[@id='pu-country']")
	private WebElement countryField;

	@FindBy(xpath = "//*[text()='Беларусь']")
	private WebElement country;

	@FindBy(xpath = "//*[@id='pu-city']")
	private WebElement cityField;

	@FindBy(xpath = "//*[text()='Минск']")
	private WebElement city;

	@FindBy(xpath = "//*[@id='pu-location']")
	private WebElement locationField;

	@FindBy(xpath = "//*[text()='Минск международный аэропорт']")
	private WebElement location;

	@FindBy(xpath = "(//*[@class='date-panel__arrow'])[1]")
	private WebElement arrivalDate;

	@FindBy(xpath = "//*[@data-nmonth='11']")
	private WebElement selectMounth;

	@FindBy(xpath = "//*[text()='24']")
	private WebElement selectDay;

	@FindBy(xpath = "//*[@value='Поиск']")
	private WebElement searchButton;

	@FindBy(xpath = "//*[text()='Бронировать '][1]")
	private WebElement bookButton;

	@FindBy(xpath = "//*[@id='addPolicyButton']")
	private WebElement policyButton;

	@FindBy(xpath = "//*[@id='f_name_input']")
	private WebElement nameField;

	@FindBy(xpath = "//*[@id='surname_input']")
	private WebElement surnameField;

	@FindBy(xpath = "//*[@id='booking-form-email']")
	private WebElement emailField;

	@FindBy(xpath = "//*[@id='phone_input']")
	private WebElement phoneField;

	@FindBy(xpath = "//*[@id='btn-submit-dd']")
	private WebElement bookfinishButton;

		
	public RentCarPage(WebDriver webdriver) {
		PageFactory.initElements(webdriver, this);
		this.driver=webdriver;
	}

	public void carSelection() {
		rentCarButton.click();
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(countryField)).click();
		country.click();
		cityField.click();
		city.click();
		locationField.click();
		location.click();
		arrivalDate.click();
		selectMounth.click();
		selectDay.click();
		searchButton.click();
		bookButton.click();
		policyButton.click();

	}

	public void driverDetailtests(String name, String surname, String email, String phone) {
		nameField.sendKeys(name);
		surnameField.sendKeys(surname);
		emailField.sendKeys(email);
		phoneField.sendKeys(phone);
	}

	public boolean completeBookingButtonPresents() {
		return bookfinishButton.isDisplayed();
	}

}
