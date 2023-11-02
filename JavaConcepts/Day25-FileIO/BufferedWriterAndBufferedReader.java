import java.io.*;

public class BufferedWriterAndBufferedReader {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("MyFile.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("First Line");
            bufferedWriter.newLine();
            bufferedWriter.write("Second Line");
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileReader fileReader = new FileReader("MyFile.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println(bufferedReader.readLine()); // Reads first line
            System.out.println(bufferedReader.readLine()); // Reads second line
            bufferedReader.close();
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
