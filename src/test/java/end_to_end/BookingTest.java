package end_to_end;

import base.BaseTest;
import data_driven.HomePageData;
import data_driven.HotelPageData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookPage;
import pages.HomePage;
import pages.HotelPage;
import pages.SearchResultPage;

import static data_driven.HomePageData.getHomePageData;
import static data_driven.HotelPageData.getHotelPageData;
import static pages.BookPage.getBookPage;
import static pages.HomePage.getHomePage;
import static pages.HotelPage.getHotelPage;

public class BookingTest extends BaseTest {

    HomePage homePage = getHomePage();
    SearchResultPage searchResultPage = new SearchResultPage();
    HotelPage hotelPage = getHotelPage();
    HomePageData homePageData = getHomePageData();
    HotelPageData hotelPageData = getHotelPageData();
    BookPage bookPage = getBookPage();

    @Test
    public void testAvailability() {
        homePage.sendTextToSearchBar(homePageData.getCity())
                .selectCheckInDate(homePageData.getCheckInDate())
                .saveExpectedCheckInDate()
                .selectCheckOutDate(homePageData.getCheckOutDate())
                .saveExpectedCheckOutDate()
                .clickOnSearchButton();
        searchResultPage
                .clickOnAvailabilityButton();
        Assert.assertEquals(hotelPage.getActualCheckInDate(), homePageData.getExpectedCheckInDate());
        Assert.assertEquals(hotelPage.getActualCheckOutDate(), homePageData.getExpectedCheckOutDate());
    }

    @Test
    public void testTitleIsVisible() {
        homePage.sendTextToSearchBar(homePageData.getCity())
                .selectCheckInDate(homePageData.getCheckInDate())
                .saveExpectedCheckInDate()
                .selectCheckOutDate(homePageData.getCheckOutDate())
                .saveExpectedCheckOutDate()
                .clickOnSearchButton();
        searchResultPage
                .clickOnAvailabilityButton();
        hotelPage.selectAmount(hotelPageData.getAmount())
                .selectBed(hotelPageData.getBed())
                .clickOnReserve();
        Assert.assertTrue(bookPage.isHotelNameDisplayed());
    }
}
