class VarArgsTest {

    public void varArgsMethod(String... str) {
        for (String s: str)
            System.out.println(s);
    }

    public void varArgsMethod(int n, String... str) {
        System.out.println(n);
        for (String s : str)
            System.out.println(s);
    }
}
public class VarArgs {
    public static void main(String[] args) {
        VarArgsTest varArgsTest = new VarArgsTest();
        varArgsTest.varArgsMethod("One Parameter","method");
        varArgsTest.varArgsMethod(1,"Overloaded","method");
    }
}
