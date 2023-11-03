import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteArrayToBufferedReader {
    public static void main(String[] args) {
        String str = "Converting to Input Stream";
        byte[] byteArr = str.getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArr);
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
