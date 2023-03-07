package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import settings.WebsiteSettings;

import static utils.DriverFactory.getDriver;

public class BaseTest {
    private final WebDriver driver = getDriver(WebsiteSettings.browserName);

    @BeforeSuite
    public void setUp() {
        driver.get(WebsiteSettings.homeUrl);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
