import java.io.File;

public class FileURIReference {
    public static void main(String[] args) {
        File file = new File("MyFile.txt");
        String fileURI = file.toURI().toString();
        System.out.println(fileURI);
    }
}


/*
Output:
        file:/C:/Users/manoj-ts194/IdeaProjects/PracticeRepo/MyFile.txt
*/
