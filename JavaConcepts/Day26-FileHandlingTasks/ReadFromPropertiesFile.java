import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromPropertiesFile {
    private static Properties properties = null;
    static  {
        try {
            FileInputStream fileInputStream = new FileInputStream("MyProperties.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String loadProperties(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println(loadProperties("id"));
    }
}
