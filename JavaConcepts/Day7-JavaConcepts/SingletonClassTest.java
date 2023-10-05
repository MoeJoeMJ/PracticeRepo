class SingletonClass {
    private static SingletonClass instance = null;
    private SingletonClass() {

    }
    public static SingletonClass getInstance() {
        if (instance==null) {
            instance = new SingletonClass();
        }
        return instance;
    }
}

public class SingletonClassTest {
    public static void main(String[] args) {
        SingletonClass singletonClass = new SingletonClass(); // Instatntiating Throws error
        SingletonClass singletonClass1 = SingletonClass.getInstance(); // This works
    }
}
