import java.io.File;

public class PrintFilesInDirectory {
    public static void main(String[] args) {
        File directory = new File("JavaConcepts/Day24");
        String[] files = directory.list();
        if (files != null) {
            for (String file : files) {
                System.out.println(file);
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

