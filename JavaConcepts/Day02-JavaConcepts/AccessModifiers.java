
// A protected instance method can be made public
class Parent {
    protected void show() {
        System.out.println("Protected method");
    }
}

class Child extends Parent {
    @Override
    public void show() {
        System.out.println("Overridden as Public method");
    }
}

class AccessModifiers {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.show(); // Outputs "Overridden as Public method"
    }
}
