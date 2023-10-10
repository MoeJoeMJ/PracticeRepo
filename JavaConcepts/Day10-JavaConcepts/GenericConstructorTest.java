class ClassB {

    Number n;

    public <T extends Number> ClassB(T n) {
        this.n = n;
    }

}
public class GenericConstructorTest {
    public static void main(String[] args) {

        Integer integer = 1;
        Double doubleNum = 1.0;
        ClassB integerClassB = new ClassB(integer);
        ClassB doubleClassB = new ClassB(doubleNum);

        System.out.println(integerClassB.n);
        System.out.println(doubleClassB.n);

    }
}
