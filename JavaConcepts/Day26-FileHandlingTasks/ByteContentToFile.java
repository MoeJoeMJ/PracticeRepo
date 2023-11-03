import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteContentToFile {
    public static void main(String[] args) {
        String str = "String Content";
        byte[] content = str.getBytes();
        File file = new File("MyFile.txt");

        try(FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(content);  // Writing bte content to file
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
