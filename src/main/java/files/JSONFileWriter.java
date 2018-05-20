package files;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JSONFileWriter {

    public void writeToJsonFile(List<JSONFileArgument> jsonFileArguments, String path) {
        JSONArray mainJsonArray = fillJSONArray(jsonFileArguments);
        writeJSONArrayToFile(mainJsonArray, path);
    }

    private void writeJSONArrayToFile(JSONArray mainJsonArray, String path) {
        File file = new File(path);
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(mainJsonArray.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("ERROR while writing to file!");
        }


    }

    private JSONArray fillJSONArray(List<JSONFileArgument> jsonFileArguments) {
        JSONArray mainJsonArray = new JSONArray();
        jsonFileArguments.forEach( j -> {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("title", j.getBookTitle());
                    jsonObject.put("author", j.getBookAuthor());
                    jsonObject.put("ISBN", j.getBookIsbnNumber());
                    jsonObject.put("isRented", j.isBookRented());
                    jsonObject.put("lastLibraryUser", getLibraryUserObject(j));
                    jsonObject.put("dateLastRented", getLastDateRentedObject(j));
                    mainJsonArray.put(jsonObject);
                }
        );
        return mainJsonArray;
    }

    private JSONObject getLibraryUserObject(JSONFileArgument argument) {
        JSONObject libraryUserObject = new JSONObject();
        libraryUserObject.put("firstname", argument.getLastLibraryUserFirstname());
        libraryUserObject.put("lastname", argument.getLastLibraryUserLastname());
        return libraryUserObject;
    }

    private JSONObject getLastDateRentedObject(JSONFileArgument argument) {
        JSONObject lastDateRentedObject = new JSONObject();
        lastDateRentedObject.put("year", argument.getLastDateRentedYear());
        lastDateRentedObject.put("month", argument.getLastDateRentedMonth());
        lastDateRentedObject.put("day", argument.getLastDateRentedDay());
        return lastDateRentedObject;
    }
}
