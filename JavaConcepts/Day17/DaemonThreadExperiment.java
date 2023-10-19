class ThreadOne implements Runnable{

    @Override
    public void run() {
        System.out.println("From ThreadOne");
    }
}

class ThreadTwo implements Runnable{

    @Override
    public void run() {
        System.out.println("From threadTwo");
    }
}
public class DaemonThreadExperiment  {
    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne();
        Thread thread1 = new Thread(threadOne);
        thread1.setDaemon(true);
        thread1.start(); // this works

        ThreadTwo threadTwo = new ThreadTwo();
        Thread thread2 = new Thread(threadTwo);
        thread2.start();
        thread2.setDaemon(true); // Throws IllegalThreadStateException because we cant set a thread as daemon after starting it
    }
}

/*
Output:
        From ThreadOne
        From threadTwo
        Exception in thread "main" java.lang.IllegalThreadStateException
        at java.base/java.lang.Thread.setDaemon(Thread.java:2239)
        at DaemonThreadExperiment.main(DaemonThreadExperiment.java:26)
*/
