public class StaticClassTest {
    static class StaticClass {
        void callMethod() {
            staticMethod(); // Can only call static methods from inner static class
            StaticClassTest staticClassTest = new StaticClassTest();
            staticClassTest.nonStaticMethod(); // Cannot directly call from inner static class

        }
    }

    static void staticMethod() {
        System.out.println("From static method in outer class");
    }

    void nonStaticMethod() {
        System.out.println("From non static method in outer class");
    }

    public static void main(String[] args) {
        StaticClass staticClass = new StaticClass();
        staticClass.callMethod();
    }

}
