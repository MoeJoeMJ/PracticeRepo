
class ParentClass {
    int n;
}

class ChildClass extends ParentClass {

    // Cannot use super keyword in a static context
    static void print() {
       // super.n; // Throws error
    }
}

public class SuperInStaticContext {
    public static void main(String[] args) {

    }
}


