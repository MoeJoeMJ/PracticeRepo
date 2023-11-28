class MyClass {
    int variable;
    public MyClass() {
        this.variable = 1;
    }
    public MyClass(int variable) {
        this.variable = variable;
    }
}
public class ConstructorOverloading {
    public static void main(String[] args) {
        MyClass MyClass = new MyClass(9);
        MyClass MyClass1 = new MyClass();
        System.out.println(MyClass.variable);
        System.out.println(MyClass1.variable);
    }
}
