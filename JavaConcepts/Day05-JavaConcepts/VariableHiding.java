class NewClass {
    int n = 1;
}

class NewSubClass extends NewClass {
    String n = "One";
}

public class VariableHiding {
    public static void main(String[] args) {
        NewClass newClass = new NewClass();
        System.out.println(newClass.n);

        NewClass newClass1 = new NewSubClass();
        System.out.println(newClass1.n);

        NewSubClass newSubClass = new NewSubClass();
        System.out.println(newSubClass.n);
    }
}
