class ClassA {
    public void displayNum(Integer n) {  // Only type Integer goes through this
        System.out.println(n+" printing from non generic method");
    }

    public <T> void displayNum(T n) {  // Numbers other than Integers goes through this
        System.out.println(n+" printing from generic method");
    }
}
public class OverloadingAndGenerics {
    public static void main(String[] args) {

        ClassA classA = new ClassA();

        Integer integer = 1;
        classA.displayNum(integer);

        Double doubleNum = 1.0;
        classA.displayNum(doubleNum);

    }
}
