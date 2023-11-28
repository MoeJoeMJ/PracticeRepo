import java.io.File;
import java.io.IOException;

public class FileHandling {
    public static void main(String[] args) {
        try {
            File file = new File("MyFile.txt");
            if (file.createNewFile()) {
                System.out.println("File created");
            }
            else {
                System.out.println("File is already exist in the directory.");
            }
            System.out.println(file.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


/*
Output:
        File Created
        MyFile.txt
*/
