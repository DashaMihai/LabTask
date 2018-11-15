package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewPage {
	private WebDriver driver;

	@FindBy(xpath = "//*[@class='js-reviews-footer-link']")
	private WebElement reviewsButton;

	@FindBy(xpath = "//*[text()='Как прошла ваша поездка?']")
	private WebElement textButton;

	@FindBy(xpath = "//*[@class='revc_write_a_review_login_button']")
	private WebElement singInButton;

	@FindBy(xpath = "(//*[@name='username'])[1]")
	private WebElement loginField;

	@FindBy(xpath = "(//*[@name='password'])[1]")
	private WebElement passwordField;

	@FindBy(xpath = "(//*[@value='Войти'])[1]")
	private WebElement enterButton;

	@FindBy(xpath = "//*[text()='Рассказать о недавних поездках']")
	private WebElement recentTripButton;

	@FindBy(xpath = "(//*[@data-ufi='900047975'])[1]")
	private WebElement writeReviewButton;

	@FindBy(xpath = "//*[@class='ugcc-mlr-city-review-modal-text-wrapper']")
	private WebElement reviewLink;

	public ReviewPage(WebDriver webdriver) {
		PageFactory.initElements(webdriver, this);
		this.driver = webdriver;
	}

	public void enterLoginAndPassword(String login, String password) {
		reviewsButton.click();
		textButton.click();
		singInButton.click();
		loginField.sendKeys(login);
		passwordField.sendKeys(password);
		enterButton.click();
	}

	public void writeReview() {
		(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOf(recentTripButton)).click();
		writeReviewButton.click();
	}

	public boolean reviewPresents() {
		return reviewLink.isDisplayed();
	}
}
