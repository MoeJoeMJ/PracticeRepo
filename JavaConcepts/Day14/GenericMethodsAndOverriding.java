abstract class ClassA {
    abstract <T>void doSomething(T t);
}
class TypeOne extends ClassA {
    @Override
    <T> void doSomething(T t) {
        System.out.println("Type " + t);
    }
}
class TypeTwo extends ClassA {
    @Override
    <Integer>void doSomething(Integer a) {
        System.out.println("Type " + a);
    }
}
public class GenericMethodsAndOverriding {
    public static void main(String[] args) {
        TypeOne typeOne = new TypeOne();
        typeOne.doSomething(1);

        TypeTwo typeTwo = new TypeTwo();
        typeTwo.doSomething(2);
    }
}
