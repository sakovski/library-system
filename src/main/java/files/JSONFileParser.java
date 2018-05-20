package files;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONFileParser {

    public List<JSONFileArguments> parseToJSONFileArguments(String filepath) {
        JSONArray jsonArray = JSONFileReader.getJSONArrayFromFile(filepath);
        List<JSONFileArguments> newBooksArguments = new ArrayList<>();

        jsonArray.forEach(o -> {
            JSONObject jsonObject = (JSONObject) o;
            newBooksArguments.add(new JSONFileArguments(
                    jsonObject.getString("title"),
                    jsonObject.getString("author"),
                    jsonObject.getString("ISBN"),
                    jsonObject.getBoolean("isRented"),
                    jsonObject.getJSONObject("lastLibraryUser").getString("firstname"),
                    jsonObject.getJSONObject("lastLibraryUser").getString("lastname"),
                    jsonObject.getJSONObject("dateLastRented").getInt("year"),
                    jsonObject.getJSONObject("dateLastRented").getInt("month"),
                    jsonObject.getJSONObject("dateLastRented").getInt("day")));
        });
        return newBooksArguments;
    }
}
