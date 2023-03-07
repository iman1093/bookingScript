package locators;

import org.openqa.selenium.By;

public enum HotelLocators {

    SELECT_AMOUNT_LOCATOR(By.xpath("(//select[@data-room-id='78883120'])[1]")),
    HEADER_LOCATOR(By.className("hprt-table-header")),
    RESERVE_LOCATOR(By.className("hprt-reservation-cta")),
    ACTUAL_CHECK_IN_DATE_LOCATOR(By.xpath("//div[@data-placeholder='Check-in']")),
    ACTUAL_CHECK_OUT_DATE_LOCATOR(By.xpath("//div[@data-placeholder='Check-out']"));
    private final By locator;

    HotelLocators(By locator) {
        this.locator = locator;
    }

    public By by() {
        return this.locator;
    }
}
