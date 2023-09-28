class Constructors {
    public Constructors() {
        System.out.println("From default constructor");
    }
    public Constructors(int n) {
        System.out.println("From parameterised constructor");
    }
}


public class ConstructorOverloading {
    public static void main(String[] args) {
        Constructors constructors = new Constructors();
        Constructors constructors1 = new Constructors(6);
    }
}
