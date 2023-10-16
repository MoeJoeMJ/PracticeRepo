abstract class GenericClass<T> {
    abstract void doSomething(T a);
}

class WayOne<T> extends GenericClass<T> {
    @Override
    void doSomething(T a) {
        System.out.println("Way " + a);
    }
}

class WayTwo extends GenericClass<Integer> {

    @Override
    void doSomething(Integer a) {
        System.out.println("Way " + a);
    }
}

public class GenericClassAndOverriding {
    public static void main(String[] args) {
        WayOne<Integer> wayOne = new WayOne<>();
        wayOne.doSomething(1);

        WayTwo wayTwo = new WayTwo();
        wayTwo.doSomething(2);
    }
}
