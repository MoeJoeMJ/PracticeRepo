import java.io.*;

public class ReadUsingBufferedInputStream {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("MyFile.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            int data;
            while ((data = bufferedInputStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}


/*
Output:
        First Line
        Second Line
*/
