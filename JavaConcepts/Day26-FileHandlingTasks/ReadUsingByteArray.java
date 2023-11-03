import java.io.FileInputStream;
import java.io.IOException;

public class ReadUsingByteArray {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("MyFile.txt");
            byte[] byteArr = new byte[1024];
            int data;
            while ((data = fileInputStream.read(byteArr)) != -1) {
                System.out.println(new String(byteArr,0,data));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
