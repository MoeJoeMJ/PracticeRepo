// SubClass is serializable if parent class implements serializable

import java.io.*;

class ParentClass implements Serializable {

    int i;

    public ParentClass(int i) {
        this.i = i;
    }

    public ParentClass() {

    }
}

class ChildClass extends ParentClass {
    int j;
    public ChildClass(int j) {
        this.j = j;
    }
}

public class SerializingSubclass {
    public static void main(String[] args) {
        ChildClass childClass = new ChildClass(1);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("ChildClass.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(childClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("ChildClass.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ChildClass childClass1 = (ChildClass) objectInputStream.readObject();
            System.out.println(childClass1.j);
            System.out.println(childClass1.i);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
