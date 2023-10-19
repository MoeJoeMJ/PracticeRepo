public class CallingStartTwice implements Runnable {
    public static void main(String[] args) {
        CallingStartTwice obj = new CallingStartTwice();
        Thread thread = new Thread(obj);
        thread.start();
        try {
            thread.start(); // Throws IllegalThreadStateException
        } catch (IllegalThreadStateException e) {
            System.err.println("Can't call start twice");
        }

        thread.run();
        thread.run(); // But this is fine because it's just a normal method call

    }

    @Override
    public void run() {
        System.out.println("Run method called");
    }
}

/*
Output:
        Can't call start twice
        Run method called
        Run method called
        Run method called
*/

