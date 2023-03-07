package locators;

import org.openqa.selenium.By;

public enum BookPageLocators {

    HOTEL_NAME_TITLE_LOCATOR(By.className("fcab3ed991"));

    private final By locator;

    BookPageLocators(By locator) {
        this.locator = locator;
    }

    public By by() {
        return this.locator;
    }
}
