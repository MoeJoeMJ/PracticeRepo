import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadFromPropertiesFileStaticContext {
    static {
        try {
            InputStream inputStream = ReadFromPropertiesFileStaticContext.class.getResourceAsStream("MyProperties.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

    }
}
