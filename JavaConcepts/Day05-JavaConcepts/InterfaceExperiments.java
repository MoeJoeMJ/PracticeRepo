interface NewInterface {
    static void display() {
        System.out.println("From New Interface's static method");
    }

    default void newDisplay() {
        System.out.println("From New Interface's default method");
    }
}

interface NewInterface2 {
    static void display() {
        System.out.println("From New Interface 2's static method");
    }
   /*
    default void newDisplay() {
        Having two default methods with same name shows "unrelated defaults" error
    }
    */
}

class ClassNew implements NewInterface {
    static void display() {
        System.out.println("From New Class's static method");
    }
}

public class InterfaceExperiments extends ClassNew implements NewInterface,NewInterface2{
    public static void main(String[] args) {
        ClassNew classNew = new ClassNew();
        classNew.display(); // Method Hiding
        NewInterface.display(); // static methods in interfaces can only be called using class name
        NewInterface2.display();
        classNew.newDisplay();
    }

}
