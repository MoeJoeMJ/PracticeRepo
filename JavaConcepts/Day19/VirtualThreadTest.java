class VirtualThread implements Runnable {

    @Override
    public void run() {
        System.out.println("From the Virtual thread");
    }
}

public class VirtualThreadTest {
    public static void main(String[] args) {
        VirtualThread virtualThread = new VirtualThread();
        Thread vThread = Thread.ofVirtual().unstarted(virtualThread); // This or  Thread.ofVirtual().started(virtualThread);
        vThread.start();
    }
}
