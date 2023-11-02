import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromConsole {
    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            String line = bufferedReader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
