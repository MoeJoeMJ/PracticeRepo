import java.io.*;

// if superclass has implemented Serializable - constructor is not called during Deserialization process.
// if superclass has not implemented Serializable - constructor is called during Deserialization process.

class SuperClass {
    public SuperClass() {
        System.out.println("From Super Constructor");
    }
}
class SuperConstructorCheck extends SuperClass implements Serializable {
    @Serial
    private static final long serialVersionUID = 3;
    public SuperConstructorCheck() {
        System.out.println("From Child constructor");
    }

}

public class IsSuperclassConstructorCalled {
    public static void main(String[] args) {
        SuperConstructorCheck superConstructorCheck = new SuperConstructorCheck();

        try {
            FileOutputStream fileOut = new FileOutputStream("SuperConstructorCheck.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(superConstructorCheck);
            fileOut.close();
            objectOut.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fileIn = new FileInputStream("SuperConstructorCheck.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            SuperConstructorCheck superConstructorCheck1 = (SuperConstructorCheck) objectIn.readObject();
            fileIn.close();
            objectIn.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


/**  Output:
*   From Super Constructor
*   From Child constructor
*   From Super Constructor
*/
