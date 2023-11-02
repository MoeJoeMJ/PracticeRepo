import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileToByteArray {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("JavaConcepts/Day24/FileHandling.java");
            byte[] byteArr = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
