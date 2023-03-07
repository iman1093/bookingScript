package locators;

import org.openqa.selenium.By;

public enum HomePageLocators {
    SEARCH_BAR_LOCATOR(By.id("ss")),
    DATE_LOCATOR(By.className("xp__dates-inner")),
    SEARCH_BUTTON_LOCATOR(By.className("js-sb-submit-text")),
    EXPECTED_CHECK_IN_DATE_LOCATOR(By.xpath("//div[@data-placeholder='Check-in']")),
    EXPECTED_CHECK_OUT_DATE_LOCATOR(By.xpath("//div[@data-placeholder='Check-out']"));
    private final By locator;

    HomePageLocators(By locator) {
        this.locator = locator;
    }

    public By by() {
        return this.locator;
    }
}
