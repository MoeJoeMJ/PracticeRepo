class Parent {

}

class Child extends Parent {

}

public class TypeCasting {
    public static void main(String[] args) {
        short shortNum = 6;
        int intNum = shortNum; // Implicit Upcasting
        double doubleNum = (double) intNum; // Explicit Downcasting

        Parent parent = new Child(); // Implicit Object Upcasting
        Child child = (Child) parent; // Explicit Object Downcasting

    }
}
