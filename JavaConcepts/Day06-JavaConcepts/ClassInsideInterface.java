public interface ClassInsideInterface {
    class NewClass {
        public static void main(String[] args) {
            NewClass newClass = new NewClass();
            newClass.printMessage();
        }
        void printMessage() {
            System.out.println("Hello from the Class inside Interface");
        }
    }
}
