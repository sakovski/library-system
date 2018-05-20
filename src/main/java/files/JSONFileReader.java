package files;

import org.json.JSONArray;

import java.io.InputStream;
import java.util.Scanner;

public class JSONFileReader {

    public String getJSONStringFromFile(String path) {
        Scanner scanner;
        InputStream in = FileHandle.inputStreamFromFile(path);
        try {
            scanner = new Scanner(in);
            String json = scanner.useDelimiter("\\Z").next();
            scanner.close();
            return json;
        } catch(NullPointerException ex) {
            throw new RuntimeException("Couldnt find your json file in given path!");
        }
    }

    public JSONArray getJSONArrayFromFile(String path) {
        return new JSONArray(getJSONStringFromFile(path));
    }
}
