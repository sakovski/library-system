package files;

import book.Book;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONFileParser {

    private JSONFileReader jsonFileReader = new JSONFileReader();

    public List<JSONFileArgument> readFromFileToJSONFileArguments(String filepath) {
        JSONArray jsonArray = jsonFileReader.getJSONArrayFromFile(filepath);
        List<JSONFileArgument> newBooksArguments = new ArrayList<>();

        jsonArray.forEach(o -> {
            JSONObject jsonObject = (JSONObject) o;
            newBooksArguments.add(new JSONFileArgument(
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

    public List<JSONFileArgument> readFromBooksToJSONFileArguments(List<Book> books) {
        List<JSONFileArgument> jsonFileArguments = new ArrayList<>();
         books.forEach( b -> {
            String currentUserFirstname;
            String currentUserLastname;
            if(b.getCurrentLibraryUser() == null) {
                currentUserFirstname = "NONE";
                currentUserLastname = "NONE";
            }
            else {
                currentUserFirstname = b.getCurrentLibraryUser().getFirstname();
                currentUserLastname = b.getCurrentLibraryUser().getLastname();
            }
            jsonFileArguments.add(new JSONFileArgument(
                    b.getTitle(),
                    b.getAuthor(),
                    b.getIsbnNumber(),
                    b.isRented,
                    currentUserFirstname,
                    currentUserLastname,
                    b.getDateLastRent().getYear(),
                    b.getDateLastRent().getMonthValue(),
                    b.getDateLastRent().getDayOfMonth()));
                }
        );
         return jsonFileArguments;
    }
}
