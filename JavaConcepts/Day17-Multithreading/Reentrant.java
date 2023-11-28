class ClassOne implements Runnable {
    public synchronized void methodOne() {
        methodTwo();
        System.out.println("From methodOne");
    }

    public synchronized void methodTwo() {
        System.out.println("From methodTwo");
    }
    @Override
    public void run() {
        methodOne();
    }
}

public class Reentrant {
    public static void main(String[] args) {
        ClassOne classOne = new ClassOne();
        Thread thread = new Thread(classOne);
        thread.start();
    }
}


/*
Output:
        From methodTwo
        From methodOne
*/
