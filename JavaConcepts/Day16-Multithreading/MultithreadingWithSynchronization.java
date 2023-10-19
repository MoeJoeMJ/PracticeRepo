class Counter implements Runnable {
    int c;
    @Override
    public void run() {
      synchronized (this) {
        for (int i = 0; i<5; i++) {
            System.out.println(++c);
        }
            System.out.println(Thread.currentThread().getName() + " count: " + c);
      }
    }
}

 class MultithreadingWithSynchronization {
    public static void main(String[] args) {
        Counter counter= new Counter();
        Thread thread1 = new Thread(counter);
        thread1.start();

        Thread thread2 = new Thread(counter);
        thread2.start();
    }
}


/*
Output wihtout Synchronization:
        1
        3
        4
        5
        6
        2
        7
        8
        9
        10
        Thread-1 count: 10
        Thread-0 count: 6
*/

/*
Output with Synchronization:
        1
        2
        3
        4
        5
        Thread-0 count: 5
        6
        7
        8
        9
        10
        Thread-1 count: 10
*/
