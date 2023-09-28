abstract class AbstractClass {

}

public class AbstractClassExtendingObjectClass extends AbstractClass {
    public static void main(String[] args) {

    }
    // As an inherited class can override a method from Object class,
    // the abstract class must have extended the Object class and passed on the behaviours to its subclass
    @Override
    public String toString() {
        return super.toString();
    }
}
