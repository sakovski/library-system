package files;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandle {

    public static InputStream inputStreamFromFile(String absPath) {
        try {
            Path filePath = Paths.get(absPath);
            InputStream inputStream = Files.newInputStream(filePath);
            return inputStream;
        } catch(Exception e) {
            throw new RuntimeException("Couldnt get resource!");
        }
    }
}
