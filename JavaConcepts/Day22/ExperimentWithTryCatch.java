public class ExperimentWithTryCatch {
    public static void main(String[] args) {
        try {
            try {
                System.out.println("From the inner try block inside the try block");
                System.out.println(1/0);
            }
            catch (ArithmeticException e) {
                System.out.println("From the inner catch block inside the try block");
            }
            System.out.println("From the outer try block");
            System.out.println(1/0);
        }
        catch (ArithmeticException e) {
            try {
                System.out.println("From the inner try block inside the catch block");
                System.out.println(1/0);
            }
            catch (ArithmeticException c) {
                System.out.println("From the inner catch block inside the catch block");
            }
            System.out.println("From the outer catch block");
        }
    }
}
