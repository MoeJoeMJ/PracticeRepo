class ClassA<T extends Number> {
    T someNumber;

    public ClassA(T someNumber) {
        this.someNumber = someNumber;
    }
    

    void faultyPrintNum(ClassA<Number> num) {   // This will not take arguments that are of subclasses of Number
        System.out.println(num);
    }

    <E extends Number> void printNum(E num) {  // This will take subclasses of Number as arguments
        System.out.println(num);
    }

}

public class SubtypesInGenerics {
    public static void main(String[] args) {

        ClassA<Integer> integerObj = new ClassA<>(1);
        integerObj.printNum(Integer.valueOf(6)); // This works because of bounded type parameter
        ClassA<Double> doubleObj = new ClassA<>(8.0);
        integerObj.printNum(Double.valueOf(8)); // This works as well

        /*  integerObj.faultyPrintNum(Integer.valueOf(6)); */ // Doesn't work because ClassA<Integer> isn't subtype of ClassA<Number>

    }
}
