class ParentClass {
    public ParentClass() {
        System.out.println("From ParentClass's Constructor"); // Gets printed first
    }
}

class ChildClass extends ParentClass {
    public ChildClass() {
        System.out.println("From ChildClass's Default Constructor"); // Implicit super() statement gets executed and calls the ParentClass's constructor
    }
    public ChildClass(int n) {
        this();
        System.out.println("From ChildClass's Parameterised Constructor"); // this() executes first and calls the ChildClass's default constructor
    }
}

public class ImplicitFirstStatement {
    public static void main(String[] args) {
        ChildClass childClass = new ChildClass(6); // Calls the Parameterised Constructor
    }
}

/*
Output:
        From ParentClass's Constructor
        From ChildClass's Default Constructor
        From ChildClass's Parameterised Constructor
*/
