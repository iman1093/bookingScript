package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import settings.WebsiteSettings;

import static locators.SearchResultLocators.SEE_AVAILABILITY_BUTTON_LOCATOR;
import static locators.SearchResultLocators.TOLIP_HOTEL_LOCATOR;
import static utils.DriverFactory.getDriver;

public class SearchResultPage {

    private final WebDriver driver = getDriver(WebsiteSettings.browserName);

    //Prevent instance

    public static SearchResultPage getSearchResultPage() {
        return new SearchResultPage();
    }

    public void clickOnAvailabilityButton() {
        WebElement availabilityButton = driver.findElement(RelativeLocator
                .with(SEE_AVAILABILITY_BUTTON_LOCATOR.by())
                .below(TOLIP_HOTEL_LOCATOR.by()));
        availabilityButton.click();
    }
}
