// Method overloading and Method overriding
class Parent {
    void show() {
        System.out.println("Parent class");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("Overridden method");
    }

    void show(String str) {
        System.out.println(str + " method");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.show();
        Child child = new Child();
        child.show();
        child.show("Overloaded");
    }
}

/*
Ouput:
        Parent class
        Overridden method
        Overloaded method
*/
