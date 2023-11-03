import java.io.File;

public class IterateFileObjects {
    public static void main(String[] args) {
        File directory = new File("JavaConcepts/Day24");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }
}
