package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FiltersPage {
	private WebDriver driver;

	@FindBy(xpath = "//*[@data-id='pri-1']")
	private WebElement priceFilter;

	@FindBy(xpath = "//*[@data-id='ht_id-204']")
	private WebElement accommodationFilter;

	@FindBy(xpath = "//*[@data-id='oos-1']")
	private WebElement availableAccommodationFilter;

	@FindBy(xpath = "//*[@data-id='fc-2']")
	private WebElement freeCancelFilter;

	@FindBy(xpath = "//*[@data-block-id='heading']")
	private WebElement selectedFilters;

	public FiltersPage(WebDriver webdriver) {
		PageFactory.initElements(webdriver, this);
		this.driver = webdriver;
	}

	public void selectFilters() {
		(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOf(priceFilter)).click();
		accommodationFilter.click();
		availableAccommodationFilter.click();
		freeCancelFilter.click();
	}

	public boolean selectedFiltersPresents() {
		return (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOf(selectedFilters)).isDisplayed();

	}

}
