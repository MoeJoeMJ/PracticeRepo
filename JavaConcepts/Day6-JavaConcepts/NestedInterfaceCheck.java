interface NewInterface {
    interface NestedInterface {
        void printMessage();
    }
}

public class NestedInterfaceCheck implements NewInterface.NestedInterface {
    public static void main(String[] args) {
        NewInterface.NestedInterface nestedInterface = new NestedInterfaceCheck();
        nestedInterface.printMessage();
    }

    @Override
    public void printMessage() {
        System.out.println("Hello Manoj!");
    }
}
