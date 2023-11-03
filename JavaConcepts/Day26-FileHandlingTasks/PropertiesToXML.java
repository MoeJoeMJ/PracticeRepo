import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesToXML {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("name","John");
        properties.setProperty("age","18");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("myConfig.xml");
            properties.storeToXML(fileOutputStream,"Stored from property to XML");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
