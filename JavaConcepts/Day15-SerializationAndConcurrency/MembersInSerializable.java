import java.io.*;

class SerializableClass implements Serializable {
    private static final long serialVersionUID = 1;

    MyClass myClass; // Members in Serializable class should implement serializable as well
    int a;
    public SerializableClass(int a) {
        this.a = a;
        myClass = new MyClass();
    }

}
class MyClass {

}
public class MembersInSerializable {
    public static void main(String[] args) {
        SerializableClass serializableClass = new SerializableClass(1);

        try {
            FileOutputStream fileOut = new FileOutputStream("SerializableClass.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serializableClass); // Throws NotSerializableException
            fileOut.close();
            objectOut.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fileIn = new FileInputStream("SerializableClass.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            SerializableClass serializableClass1 = (SerializableClass) objectIn.readObject();
            fileIn.close();
            objectIn.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
