import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToTemporaryFile {
    public static void main(String[] args) {
        try {
            File tempFile = File.createTempFile("TempFile",".txt");
            FileWriter fileWriter = new FileWriter(tempFile);
            fileWriter.write("Writing to Temporary File"); // Writing to Temporary File
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
