class SafeThread implements Runnable{
    private int n;

    public SafeThread(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public SafeThread add(int a){
        return new SafeThread(this.n + a); // modify like this to maintain thread safety
    }

    @Override
    public void run() {
        for (int i=0;i<40;i++) {
            SafeThread obj = add(i);
            System.out.println(obj.getN());
        }
    }
}

public class ThreadSafetyAndImmutability {
    public static void main(String[] args) {
        SafeThread safeThread = new SafeThread(5);
        Thread thread = new Thread(safeThread);
        thread.start();
        for (int i = 0; i<50; i++) {
            SafeThread obj = safeThread.add(i);
            System.out.println(obj.getN());
        }
    }
}
