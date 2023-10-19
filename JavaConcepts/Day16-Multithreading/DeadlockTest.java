class ThreadOne implements Runnable {

    @Override
    public void run() {
        synchronized (DeadlockTest.resourceOne) {
            System.out.println("Locked resourceOne");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Waiting for resourceTwo");
            synchronized (DeadlockTest.resourceTwo) {
                System.out.println("Locked resourceTwo");
            }
        }
    }
}

class ThreadTwo implements Runnable {

    @Override
    public void run() {
        synchronized (DeadlockTest.resourceTwo) {
            System.out.println("Locked resourceTwo");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Waiting for resourceOne");
            synchronized (DeadlockTest.resourceOne) {
                System.out.println("Locked resourceOne");
            }
        }
    }
}
public class DeadlockTest {
    static String resourceOne = "Resource One";
    static String resourceTwo = "Resource Two";
    public static void main(String[] args) {

        ThreadOne threadOne = new ThreadOne();
        new Thread(threadOne).start();

        ThreadTwo threadTwo = new ThreadTwo();
        new Thread(threadTwo).start();

    }
}


/*
Output:
        Locked resourceOne
        Locked resourceTwo
        Waiting for resourceOne
        Waiting for resourceTwo
*/
