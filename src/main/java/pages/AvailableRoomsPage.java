package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AvailableRoomsPage extends AbstractBookingPage {

	@FindBy(xpath = "//*[@id='xp__guests__toggle']")
	private WebElement guestsCount;

	@FindBy(xpath = "//*[@id='no_rooms']")
	private WebElement roomsCount;

	@FindBy(xpath = "//*[text()='Проверить цены']")
	private WebElement searchButton;

	@FindBy(xpath = "(//*[@class='sr-cta-button-row'])[1]")
	private WebElement roomsCheckButton;

	@FindBy(xpath = "//*[text()='Отзывы гостей']")
	private WebElement hotelPhotoLink;

	public AvailableRoomsPage(WebDriver webdriver) {
		PageFactory.initElements(webdriver, this);
	}

	public void clickGuestSelection(String roomsNumber) {
		guestsCount.click();
		roomsCount.sendKeys(roomsNumber);
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public void clickSearchAvailableRooms() {
		roomsCheckButton.click();
	}

	public boolean hotelLinkPresents() {
		return hotelPhotoLink.isDisplayed();
	}
}
