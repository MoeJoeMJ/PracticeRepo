import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LastModifiedTime {
    public static void main(String[] args) {
        File file = new File("MyFile.txt");
        long lastModified = file.lastModified();
        Date lastModifiedDate = new Date(lastModified);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        String myDate = simpleDateFormat.format(lastModifiedDate);

        System.out.println(myDate);
    }
}
