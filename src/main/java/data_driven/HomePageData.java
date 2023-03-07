package data_driven;

import org.json.simple.JSONObject;
import settings.WebsiteSettings;

import java.util.Map;

import static utils.Helper.readJsonFile;
import static utils.Helper.updateJsonFile;

public class HomePageData {

    private JSONObject jsonData;

    //Prevent instance
    private HomePageData() {
        final String filePath = WebsiteSettings.homeDataFilePath;
        jsonData = readJsonFile(filePath);
    }

    public static HomePageData getHomePageData() {
        return new HomePageData();
    }

    public String getCity() {
        return (String) jsonData.get("city");
    }

    public String getCheckInDate() {
        return (String) jsonData.get("checkInDate");
    }

    public String getCheckOutDate() {
        return (String) jsonData.get("checkOutDate");
    }

    public String getExpectedCheckInDate() {
        return (String) jsonData.get("expectedCheckInDate");
    }

    public String getExpectedCheckOutDate() {
        return (String) jsonData.get("expectedCheckOutDate");
    }

    public void updateExpectedCheckInDate(Map<String, Object> expectedCheckInDate) {
        updateJsonFile(WebsiteSettings.homeDataFilePath, expectedCheckInDate, "expectedCheckInDate");
    }

    public void updateExpectedCheckOutDate(Map<String, Object> expectedCheckOutDate) {
        updateJsonFile(WebsiteSettings.homeDataFilePath, expectedCheckOutDate, "expectedCheckOutDate");
    }
}
