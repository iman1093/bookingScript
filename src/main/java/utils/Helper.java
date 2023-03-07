package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Helper {


    /**
     * @param filePath is the json file path
     * @return json object
     */
    public static JSONObject readJsonFile(String filePath) {
        JSONObject obj = null;
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser parser = new JSONParser();
            obj = (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void writeToJson(String filePath, Map<String, Object> map) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filePath), map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param filePath represents the path of the file we want to update 'it's fields.
     * @param map represents the new key,value pair we want to update with.
     * @param key represents the key name we want to update 'it's value.
     */
    public static void updateJsonFile(String filePath, Map<String, Object> map, String key) {
        ObjectMapper mapper = new ObjectMapper();

        JSONObject newObject = new JSONObject(map);
        //Read from file
        JSONObject currentJsonFile = null;
        try {
            currentJsonFile = mapper.readValue(new File(filePath), JSONObject.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        final Object newValue = (Object) newObject.get(key);
        final Object oldValue = (Object) currentJsonFile.get(key);

        //Compare values
        if (!newValue.equals(oldValue)) {
            //Update value in object
            currentJsonFile.put(key, newValue);

            //Write into the file
            try (FileWriter file = new FileWriter(filePath)) {
                file.write(currentJsonFile.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
