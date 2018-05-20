package files;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Scanner;

public class JSONFileReader {

    public static String getJSONStringFromFile(String path) {
        Scanner scanner;
        InputStream in = FileHandle.inputStreamFromFile(path);
        scanner = new Scanner(in);
        String json = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return json;
    }

    public static JSONArray getJSONArrayFromFile(String path) {
        return new JSONArray(getJSONStringFromFile(path));
    }

    public static boolean objectExists(JSONObject jsonObject, String key) {
        Object o;
        try {
            o = jsonObject.get(key);
        } catch(Exception e) {
            return false;
        }
        return o != null;
    }

}
