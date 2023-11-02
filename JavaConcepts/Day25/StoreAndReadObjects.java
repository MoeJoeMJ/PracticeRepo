import java.io.*;

class SerializableClass implements Serializable{
    int num;
    String str;

    public SerializableClass(int num, String str) {
        this.num = num;
        this.str = str;
    }
}
public class StoreAndReadObjects {
    public static void main(String[] args) {
        SerializableClass serializableClass = new SerializableClass(1,"Hello");
        try {
            FileOutputStream fileOut = new FileOutputStream("SerializableClass.java");
            ObjectOutputStream ObjectOut = new ObjectOutputStream(fileOut);
            ObjectOut.writeObject(serializableClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fileIn = new FileInputStream("SerializableClass.java");
            ObjectInputStream ObjectIn = new ObjectInputStream(fileIn);
            SerializableClass serializableClass1 = (SerializableClass) ObjectIn.readObject();
            System.out.println(serializableClass1.num + " " + serializableClass1.str);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
Output:
        1 Hello
*/
