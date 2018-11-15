package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractBookingPage {

	@FindBy(xpath = "//*[@data-calendar2-type='checkin']")
	private WebElement openCalendar;

	@FindBy(xpath = "//*[@data-date='2018-11-24']")
	private WebElement arrivalDate;

	@FindBy(xpath = "//*[@data-date='2018-11-25']")
	private WebElement departureDate;

	@FindBy(xpath = "//*[@id='ss']")
	private WebElement searchField;

	public void enterDestination(String destination) {
		searchField.clear();
		searchField.sendKeys(destination);
	}

	public void selectArrivalAndDepartureDates() {
		openCalendar.click();
		arrivalDate.click();
		departureDate.click();
	}
}
