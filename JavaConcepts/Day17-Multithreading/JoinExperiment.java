class MyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }
}

class MyThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("From myThread2 thread" + i);
        }
    }
}

public class JoinExperiment {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        MyThread2 myThread2 = new MyThread2();
        Thread thread2 = new Thread(myThread2);
        thread.start();
        try {
            thread2.join();
            System.out.println("Join 1 called");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread2.start();
        /*try {
            thread2.join();
            System.out.println("Join 2 called");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        for (int i = 0; i < 100; i++) {
            System.out.println("From main thread" + i);
        }
    }
}

