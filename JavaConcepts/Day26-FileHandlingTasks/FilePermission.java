import java.io.*;

public class FilePermission {
    public static void main(String[] args) {

        File file = new File("JavaConcepts/MyFile.txt");
        file.setReadOnly();  // Sets the file to read-only

        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("First attempt");
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Access Denied");
        }

        file.setWritable(true);

        try {
            FileWriter newFileWriter = new FileWriter(file);
            newFileWriter.write("Second attempt");
            newFileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileReader fileReader = new FileReader("JavaConcepts/MyFile.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


/*
Output:
        Access Denied
        Second attempt
*/
