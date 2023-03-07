package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import settings.WebsiteSettings;

import static locators.HotelLocators.*;
import static utils.DriverFactory.getDriver;
import static utils.SharedSteps.*;

public class HotelPage {

    private final WebDriver driver = getDriver(WebsiteSettings.browserName);
    //Prevent instance

    public static HotelPage getHotelPage(){
        return new HotelPage();
    }

    public HotelPage selectAmount(String amount){
        goToNewTab();
        selectFromDropDownByValue(amount,SELECT_AMOUNT_LOCATOR.by());
        return this;
    }

    public HotelPage selectBed(String chosenBed){
        final By bedLocator = By.xpath("//span[contains(text(),"+"'"+chosenBed+"'"+")]");
        WebElement bedSelector = driver.findElement(RelativeLocator
                .with(bedLocator)
                .below(HEADER_LOCATOR.by()));
        bedSelector.click();
        return this;
    }
    public void clickOnReserve(){
        clickOnElement(RESERVE_LOCATOR.by());
    }

    public String getActualCheckInDate(){
        goToNewTab();
        String actualValue = findElement(ACTUAL_CHECK_IN_DATE_LOCATOR.by()).getText();
        System.out.println(actualValue);
        return actualValue;
    }
    public String getActualCheckOutDate(){
        String actualValue = findElement(ACTUAL_CHECK_OUT_DATE_LOCATOR.by()).getText();
        System.out.println(actualValue);
        return actualValue;
    }

}
