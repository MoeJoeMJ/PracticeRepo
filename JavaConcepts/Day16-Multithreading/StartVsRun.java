public class StartVsRun implements Runnable {

    @Override
    public void run() {
        System.out.println("Current thread " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        StartVsRun obj = new StartVsRun();
        Thread thread = new Thread(obj);
        System.out.println("Calling start:");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Calling run:");
        thread.run();
    }
}

/*
Output:
        Calling start:
        Current thread Thread-0
        Calling run:
        Current thread main
*/
