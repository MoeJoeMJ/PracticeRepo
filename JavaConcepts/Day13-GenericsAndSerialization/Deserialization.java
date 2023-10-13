import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {
    public static void main(String[] args) {
        SerializableClass serializableClass2;
        try {
            FileInputStream fileInputStream = new FileInputStream("SerializationTest.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            serializableClass2 = (SerializableClass) objectInputStream.readObject();

            System.out.println(serializableClass2.num);
            System.out.println(serializableClass2.finalInt);
            System.out.println(serializableClass2.str);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
