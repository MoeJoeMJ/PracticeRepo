class ErrorTest<T extends Exception> {
    public void doSomething() throws T {

    }
}


public class GenericsAndExceptionHandling {
    public static void main(String[] args) {
        ErrorTest<RuntimeException> errorTest = new ErrorTest<>();

        try {
            errorTest.doSomething();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    // Doesn't compile
        /*try {
            errorTest.doSomething();
        } catch (T e) {
            throw new RuntimeException(e);
        }*/

    }
}
