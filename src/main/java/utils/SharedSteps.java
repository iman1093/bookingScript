package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.WebsiteSettings;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static utils.DriverFactory.*;

public final class SharedSteps {
    private static final WebDriver driver = getDriver(WebsiteSettings.browserName);
    private static final WebDriverWait wait = getDriverWait();

    public static void clickOnElement(By elementPath) {
        wait.until(ExpectedConditions.elementToBeClickable(elementPath)).click();
    }

    public static void sendTextToElement(String text, By elementPath) {
        WebElement element = driver.findElement(elementPath);
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public static void selectFromDropDownByValue(String value, By dropDownPath) {
        findDropDownElement(dropDownPath).selectByValue(value);
    }

    public static WebElement findElement(By elementsPath) {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementsPath)));
    }

    public static void goToNewTab() {
        String originalWindow = driver.getWindowHandle();
        wait.until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static boolean isElementVisible(By elementPath) {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementPath))).isDisplayed();
    }

    private static Select findDropDownElement(By dropDownPath) {
        return new Select(driver.findElement(dropDownPath));
    }
}
