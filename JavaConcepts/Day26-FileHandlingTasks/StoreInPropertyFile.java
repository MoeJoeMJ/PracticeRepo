import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class StoreInPropertyFile {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of the file: ");
        String fileName = scanner.next();
        Properties properties = new Properties();

        while (true) {
            System.out.print("Enter a key (or type 'exit' to finish): ");
            String key = scanner.nextLine();
            if ("exit".equalsIgnoreCase(key)) {
                break;
            }
            System.out.print("Enter a value: ");
            String value = scanner.nextLine();
            properties.setProperty(key, value);
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            properties.store(fileOutputStream, "Dynamic property file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

