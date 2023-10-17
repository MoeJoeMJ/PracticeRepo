class NewClass extends MainInAbstract {

}
public abstract class MainInAbstract {
    int n;
    public static void main(String[] args) {
        MainInAbstract newClass = new NewClass(); // Have to create an instance of the concrete class to access
        newClass.printN();
    }
    void printN() {
        System.out.println(n);
    }
}
