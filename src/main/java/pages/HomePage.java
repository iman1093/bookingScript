package pages;

import data_driven.HomePageData;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static data_driven.HomePageData.getHomePageData;
import static locators.HomePageLocators.*;
import static utils.SharedSteps.*;

public class HomePage {

    HomePageData homePageData = getHomePageData();

    //Prevent instance
    private HomePage() {

    }

    public static HomePage getHomePage() {
        return new HomePage();
    }

    public HomePage sendTextToSearchBar(String city) {
        sendTextToElement(city, SEARCH_BAR_LOCATOR.by());
        return this;
    }

    public HomePage selectCheckInDate(String checkInDate) {
        final By checkInDateLocator = By.xpath("//td[@data-date=" + "'" + checkInDate + "'" + "]");
        openDatePicker();
        clickOnElement(checkInDateLocator);
        return this;
    }

    public HomePage selectCheckOutDate(String checkOutDate) {
        final By checkOutDateLocator = By.xpath("//td[@data-date=" + "'" + checkOutDate + "'" + "]");
        clickOnElement(checkOutDateLocator);
        return this;
    }

    public void clickOnSearchButton() {
        clickOnElement(SEARCH_BUTTON_LOCATOR.by());
    }

    public HomePage saveExpectedCheckInDate() {
        Map<String, Object> expectedCheckInDate = new HashMap<>();
        expectedCheckInDate.put("expectedCheckInDate", findElement(EXPECTED_CHECK_IN_DATE_LOCATOR.by()).getText());
        homePageData.updateExpectedCheckInDate(expectedCheckInDate);
        return this;
    }
    public HomePage saveExpectedCheckOutDate() {
        Map<String, Object> expectedCheckOutDate = new HashMap<>();
        expectedCheckOutDate.put("expectedCheckOutDate", findElement(EXPECTED_CHECK_OUT_DATE_LOCATOR.by()).getText());
        homePageData.updateExpectedCheckOutDate(expectedCheckOutDate);
        return this;
    }

    private void openDatePicker() {
        clickOnElement(DATE_LOCATOR.by());
    }
}
