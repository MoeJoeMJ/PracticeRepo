import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FilterByFileExtension {
    public static void main(String[] args) {
        File directory = new File("JavaConcepts/Day24");
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File directory, String filename) {
                if(filename.endsWith(".java")){
                    return true;
                }
                else{
                    return false;
                }
            }
        };
        File[] files = directory.listFiles(filenameFilter);
        for (File file: files) {
            System.out.println(file.getName());
        }
    }
}

/*
Output:
        FileHandling.java
        StringOperations.java
*/
