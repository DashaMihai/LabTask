package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingPage extends AbstractBookingPage {
	private WebDriver driver;

	@FindBy(xpath = "//button[@class='sb-searchbox__button  ']")
	private WebElement searchButton;

	@FindBy(xpath = "(//*[@class='sr-cta-button-row'])[1]")
	private WebElement selectRoom;

	@FindBy(xpath = "(//button[@id='hp_book_now_button'])[2]")
	private WebElement bookingButton;

	@FindBy(xpath = "(//button[@id='hp_book_now_button'])[2]")
	private WebElement bookingNextButton;

	@FindBy(xpath = "//*[@id='lastname']")
	private WebElement lastnameField;

	@FindBy(xpath = "//*[@id='email']")
	private WebElement emailField;

	@FindBy(xpath = "//*[@id='email_confirm']")
	private WebElement emailConfirmField;

	@FindBy(xpath = "//*[@class='submit-button__arrow']")
	private WebElement nextButton;

	@FindBy(xpath = "(//*[@class='submit-button__lock'])[2]")
	private WebElement completeButton;

	public BookingPage(WebDriver webdriver) {
		PageFactory.initElements(webdriver, this);
		this.driver = webdriver;
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public void bookRoom(String lastname, String email) {
		selectRoom.click();
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(bookingButton)).click();
		bookingNextButton.click();
		lastnameField.sendKeys(lastname);
		emailField.sendKeys(email);
		emailConfirmField.sendKeys(email);
		nextButton.click();
	}

	public boolean completeBookingButtonPresents() {
		return completeButton.isDisplayed();
	}
}
