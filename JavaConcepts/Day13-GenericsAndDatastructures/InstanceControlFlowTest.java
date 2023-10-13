import java.io.*;

class SuperClass {
    int i;
    public SuperClass ( int i ) {
        this.i = i;
    }
}

class SubClass extends SuperClass implements Serializable {
    public SubClass () {
        super(1);

    }
}
public class InstanceControlFlowTest {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        try {
            FileOutputStream file = new FileOutputStream("SubClass.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(subClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fileIn = new FileInputStream("SubClass.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            SubClass subClass1 = (SubClass) in.readObject(); // Throws "InvalidClassException" as there's no no-arg constructor
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
