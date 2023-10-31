import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MyClass {
    int id;
    String name;
    MyClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void print(){
        System.out.println(id + " " + name);
    }
}

public class Reflection {
    public static void main(String[] args) {
        MyClass myClass = new MyClass(1,"Manoj");
        Class clazz = myClass.getClass();
        Method[] method = clazz.getMethods();
        try {
            method[0].invoke(myClass);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}


/*
Output:
        1 Manoj
*/
