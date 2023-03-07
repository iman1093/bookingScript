package locators;

import org.openqa.selenium.By;

public enum SearchResultLocators {

    TOLIP_HOTEL_LOCATOR(By.xpath("//div[text()='Tolip Hotel Alexandria']")),
    SEE_AVAILABILITY_BUTTON_LOCATOR(By.xpath("//span[(text()='See availability')]"));
    private final By locator;
    SearchResultLocators(By locator) {
        this.locator = locator;
    }

    public By by() {
        return this.locator;
    }
}
