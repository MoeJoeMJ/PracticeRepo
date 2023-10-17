// Not called during deserialization

import java.io.*;

class ConstructorCheck implements Serializable {
    private static final long serialVersionUID = 2;
    public ConstructorCheck() {
        System.out.println("From the constructor");
    }

}

public class IsConstructorCalled {
    public static void main(String[] args) {
        ConstructorCheck constructorCheck = new ConstructorCheck();

        try {
            FileOutputStream fileOut = new FileOutputStream("ConstructorCheck.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(constructorCheck);
            fileOut.close();
            objectOut.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fileIn = new FileInputStream("ConstructorCheck.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            ConstructorCheck constructorCheck1 = (ConstructorCheck) objectIn.readObject();
            fileIn.close();
            objectIn.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

// Output:
// From the constructor