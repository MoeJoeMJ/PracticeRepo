import java.io.*;

public class InputStreamToBufferedReader {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("MyFile.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader =new BufferedReader(inputStreamReader);
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
