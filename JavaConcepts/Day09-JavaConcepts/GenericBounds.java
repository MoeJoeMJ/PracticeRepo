class Bounds <T> {

    public void upperBoundPrint(Bounds<? extends Number> num ) {
        System.out.println("Only accepts subtype of Number");
    }

    public void lowerBoundPrint(Bounds<? super Integer> num) {
        System.out.println("Only accepts the supertype of Integer");
    }
}
public class GenericBounds {
    public static void main(String[] args) {
        Bounds<Integer> integerObj = new Bounds<>();
        integerObj.upperBoundPrint(integerObj);

        Bounds<Number> numberObj = new Bounds<>();
        numberObj.upperBoundPrint(numberObj);
    }
}
