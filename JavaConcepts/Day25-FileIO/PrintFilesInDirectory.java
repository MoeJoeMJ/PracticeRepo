import java.io.File;

public class PrintFilesInDirectory {
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

/*
Output:
        Day24Notes.md
        FileHandling.java
        StringOperations.java
*/

