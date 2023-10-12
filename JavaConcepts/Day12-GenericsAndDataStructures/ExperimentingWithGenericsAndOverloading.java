class OverloadTest<T> {

    void overloadedMethod(Object obj) {
        System.out.println("From Object Method");
    }

    void overloadedMethod(String str) {
        System.out.println("From String method");
    }

    void overloadedMethod(Integer integer) {
        System.out.println("From Integer Method");
    }

    void genericMethod(T t) {
        overloadedMethod(t);
    }

}

public class ExperimentingWithGenericsAndOverloading {

    public static void main(String[] args) {
        OverloadTest<String> overloadTest = new OverloadTest<>();
        overloadTest.overloadedMethod("abc"); // Calls String method
        overloadTest.genericMethod("abc"); // Calls the Object method because of type erasure

    }

}
