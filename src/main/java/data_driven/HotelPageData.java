package data_driven;

import org.json.simple.JSONObject;
import settings.WebsiteSettings;

import static utils.Helper.readJsonFile;

public class HotelPageData {
    private JSONObject jsonData;

    //Prevent instance
    private HotelPageData() {
        final String filePath = WebsiteSettings.hotelDataFilePath;
        jsonData = readJsonFile(filePath);
    }

    public static HotelPageData getHotelPageData() {
        return new HotelPageData();
    }

    public String getAmount() {
        return (String) jsonData.get("amount");
    }

    public String getBed() {
        return (String) jsonData.get("bed");
    }
}
