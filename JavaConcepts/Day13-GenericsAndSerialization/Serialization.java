import java.io.*;

class SerializableClass implements Serializable {
    public int num;
    public String str;
    transient final int finalInt = 10; // Final variables will be serialized despite declaring them as final

    public SerializableClass(int num, String str) {
        this.num = num;
        this.str = str;
    }
}
class Serialization {
    public static void main(String[] args) {
        SerializableClass serializableObj = new SerializableClass(1,"Hi");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("SerializationTest.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(serializableObj);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
