
class RawType<T> {
    T a;

    public RawType(T a) {
        this.a = a;
    }

    <E extends Number> void printNum(E num) {  // Takes in a String because of the use of raw type
        System.out.println(num+""+a);
    }

}

public class RawTypeTest {
    public static void main(String[] args) {

        RawType<Integer> integerObj = new RawType("Hello");
        integerObj.printNum(integerObj.a);  // Compiles but throws exception at runtime

        RawType rawObj = new RawType<Integer>(2);
        RawType<String> stringObj = rawObj; // Compiles, but throws exception at runtime.
        System.out.println(stringObj.a);

    }

}
