

class MyThread implements Runnable {
    private int count;
    public void add(int n) {
        synchronized (this) {
            this.count = this.count + n;
            System.out.println(count);
        }
    }

    @Override
    public void run() {

    }
}

public class ReadModifyWrite {
    public static void main(String[] args) {
        MyThread myThread= new MyThread();
        Thread thread = new Thread(() -> {
            for (int i=0; i<100; i++) {
                myThread.add(2);
            }
        });
        thread.start();
        Thread thread2 = new Thread(() -> {
            for (int i=0; i<100; i++) {
                myThread.add(3);
            }
        });
        thread2.start();

        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
