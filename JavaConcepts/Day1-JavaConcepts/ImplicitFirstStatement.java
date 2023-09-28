class ClassA {
    public ClassA() {
        System.out.println("From ClassA's Constructor"); // Gets printed first
    }
}

class ClassB extends ClassA {
    public ClassB() {
        System.out.println("From ClassB's Default Constructor"); // Implicit super() statement gets executed and calls the ClassA's constructor
    }
    public ClassB(int n) {
        this();
        System.out.println("From ClassB's Parameterised Constructor"); // this() executes first and calls the ClassB's default constructor
    }
}

public class ImplicitFirstStatement {
    public static void main(String[] args) {
        ClassB classB = new ClassB(6); // Calls the Parameterised Constructor
    }
}

/*
Output:
        From ClassA's Constructor
        From ClassB's Default Constructor
        From ClassB's Parameterised Constructor
*/
