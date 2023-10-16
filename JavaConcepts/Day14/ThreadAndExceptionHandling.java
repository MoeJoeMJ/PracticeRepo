public class ThreadAndExceptionHandling implements Runnable {
    public static void main(String[] args) {
        new Thread(new ThreadAndExceptionHandling()).start();
    }

    @Override
    public void run() {
        for ( int i = 0; i<10 ; i++ ) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("HI");

        }
    }
}
