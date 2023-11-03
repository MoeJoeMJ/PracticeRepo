import java.io.File;
import java.io.IOException;

public class DeletingTemporaryFile {
    public static void main(String[] args) {

        try {
            File tempFile = File.createTempFile("TempFile",".txt");  // Creates Temporary File
            System.out.println("Path: " + tempFile.getPath());

            tempFile.delete();  // Deletes temporary file
            System.out.println("Does the TempFile still exist? " + tempFile.exists());
            System.out.println(tempFile.getPath()); // Path gets printed even after deleting it because tempFile itself still holds information about the file it used to represent
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
