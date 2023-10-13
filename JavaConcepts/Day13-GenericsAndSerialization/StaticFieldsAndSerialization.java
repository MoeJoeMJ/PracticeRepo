import java.io.*;

class ClassA {
    static int staticNum = 1;
    int num;
    public ClassA(int num) {
        this.num = num;
    }
}

public class StaticFieldsAndSerialization {
    public static void main(String[] args) {
        ClassA classA = new ClassA(2);
        try {
            FileOutputStream file = new FileOutputStream("ClassA.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(classA);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fileIn = new FileInputStream("ClassA.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ClassA newObj = (ClassA) in.readObject();
            System.out.println(newObj.num);
            System.out.println(newObj.staticNum); // Throws runtime exception "NotSerializableException"
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
