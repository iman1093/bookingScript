package pages;

import static locators.BookPageLocators.HOTEL_NAME_TITLE_LOCATOR;
import static utils.SharedSteps.isElementVisible;

public class BookPage {

    //Prevent instance
    private BookPage() {

    }

    public static BookPage getBookPage() {
        return new BookPage();
    }

    public boolean isHotelNameDisplayed() {
        return isElementVisible(HOTEL_NAME_TITLE_LOCATOR.by());
    }
}
