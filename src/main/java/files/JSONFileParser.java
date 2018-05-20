package files;

import command.add.AddDeleteBookArguments;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONFileParser {

    public List<AddDeleteBookArguments> parseToAddNewBookArguments(String filepath) {
        JSONArray jsonArray = JSONFileReader.getJSONArrayFromFile(filepath);
        List<AddDeleteBookArguments> newBooksArguments = new ArrayList<>();

        jsonArray.forEach(o -> {
            JSONObject jsonObject = (JSONObject) o;
            newBooksArguments.add(new AddDeleteBookArguments(jsonObject.getString("title"), jsonObject.getString("author"), jsonObject.getString("ISBN")));
        });
        return newBooksArguments;
    }
}
