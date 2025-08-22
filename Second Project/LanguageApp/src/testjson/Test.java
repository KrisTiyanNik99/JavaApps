package testjson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Test {
    public static void main(String[] args) {

        List<String> allKeys = new ArrayList<>();

        try (InputStream is = Files.newInputStream(Paths.get("src/testjson.json"))) {
            JSONTokener tokener = new JSONTokener(is);
            JSONObject jsonObject = new JSONObject(tokener);

            JSONArray jsonArray = findJSONArrays(jsonObject);

            if (jsonArray != null) {
                System.out.println("JSONArray found: " + jsonArray);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject product = jsonArray.getJSONObject(i);

                    Iterator<String> keys = product.keys();
                    while (keys.hasNext()) {
                        String key = keys.next();
                        if (!allKeys.contains(key)) {
                            allKeys.add(key);
                        }
                    }
                }
            } else {
                System.out.println("No JSONArray found in the given JSON file.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(allKeys);
    }

    private static JSONArray findJSONArrays(JSONObject jsonObject) throws JSONException {
        Iterator<String> keys = jsonObject.keys();


        while (keys.hasNext()) {
            String key = keys.next();
            System.out.println("The key is: " + key);

            // Проверяваме дали стойността на текущия ключ е JSONArray
            if (jsonObject.get(key) instanceof JSONArray) {
                return jsonObject.getJSONArray(key); // Връщаме намерения JSONArray
            }
        }

        // Ако не намерим JSONArray
        return null;
    }
}
