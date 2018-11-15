package labtask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AvailableRoomsPage;
import pages.BookingPage;
import pages.DestinationSearchPage;
import pages.FiltersPage;
import pages.FlightTicketsPage;
import pages.RentCarPage;
import pages.ReviewPage;

public class BookingComTest {
	private static final String DESTINATION_CITY = "Минск";
	private static final String MAIN_PAGE_URL = "http://booking.com";
	private static final String LOGIN = "dashamihai@mail.ru";
	private static final String PASSWORD = "dasha2912900";

	private WebDriver driver;
	private DestinationSearchPage destinationPage;
	private FiltersPage filtersPage;
	private ReviewPage reviewPage;
	private AvailableRoomsPage availableRoomsPage;
	private BookingPage bookingPage;
	private RentCarPage rentCarPage;
	private FlightTicketsPage flightTicketsPage;

	@BeforeMethod
	public void beforeMethod() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(MAIN_PAGE_URL);
		destinationPage = new DestinationSearchPage(driver);
		filtersPage = new FiltersPage(driver);
		reviewPage = new ReviewPage(driver);
		availableRoomsPage = new AvailableRoomsPage(driver);
		bookingPage = new BookingPage(driver);
		rentCarPage = new RentCarPage(driver);
		flightTicketsPage = new FlightTicketsPage(driver);
	}

	@Test(priority = 1)
	public void searchDestinationTest() {
		destinationPage.enterDestination(DESTINATION_CITY);
		destinationPage.selectArrivalAndDepartureDates();
		destinationPage.clickSearchButton();
		Assert.assertTrue(destinationPage.destinationLinkPresents());
	}

	@Test(priority = 2)
	public void searchWithFiltersTest() {
		destinationPage.enterDestination(DESTINATION_CITY);
		destinationPage.selectArrivalAndDepartureDates();
		destinationPage.clickSearchButton();
		filtersPage.selectFilters();
		Assert.assertTrue(filtersPage.selectedFiltersPresents());
	}

	@Test(priority = 3)
	public void writeReviewsTest() {
		reviewPage.enterLoginAndPassword(LOGIN, PASSWORD);
		reviewPage.writeReview();
		Assert.assertTrue(reviewPage.reviewPresents());
	}

	@Test(priority = 4)
	public void searchAvailableRoomsTest() {
		availableRoomsPage.enterDestination(DESTINATION_CITY);
		availableRoomsPage.selectArrivalAndDepartureDates();
		String numberOfGuests = "5";
		availableRoomsPage.clickGuestSelection(numberOfGuests);
		availableRoomsPage.clickSearchButton();
		availableRoomsPage.clickSearchAvailableRooms();
		Assert.assertTrue(availableRoomsPage.hotelLinkPresents());

	}

	@Test(priority = 5)
	public void bookingHotelTest() {
		bookingPage.enterDestination(DESTINATION_CITY);
		bookingPage.selectArrivalAndDepartureDates();
		bookingPage.clickSearchButton();
		bookingPage.bookRoom("Ivanov", "daruha2008@yandex.ru");
	}

	@Test(priority = 6)
	public void rentCarTest() {
		rentCarPage.carSelection();
		rentCarPage.driverDetailtests("Darya", "Mihai", "dashamihai@mail.ru", "+375292912900");
		Assert.assertTrue(rentCarPage.completeBookingButtonPresents());
	}

	@Test(priority = 7)
	public void searchFlightTicketsTest() {
		String ticketDestination = "Москва";
		flightTicketsPage.ticketSelection(ticketDestination);
		Assert.assertTrue(flightTicketsPage.buyButtonPresents());
	}

	@AfterMethod
	public void afterClass() {
		driver.quit();
	}

}
