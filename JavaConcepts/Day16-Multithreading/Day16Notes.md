# CONCURRENCY
## Multithreading - [Link](https://www.tutorialspoint.com/java/java_multithreading.htm)
- Main thread should be the last to finish execution because it performs various shutdown actions
- when a static synchronized method is invoked,the thread acquires the intrinsic lock for the Class object associated with the class. Thus access to class's static fields is controlled by a lock that's distinct from the lock for any instance of the class.
- Life cycle of a thread
    - New Thread - created but not yet started to execute
    - Runnable state - Threads that are ready to run as well as running right now
    - Blocked - when a thread is trying to acquire a lock but currently the lock is acquired by the other thread. Moves to runnable state after acquiring the lock
    - Waiting state - Thread will be in waiting state when it calls wait() method or join() method. It will move to the runnable state when other thread will notify or that thread will be terminated.
    - Timed waiting state - when it calls a method with a time-out parameter. A thread lies in this state until the timeout is completed or until a notification is received. For example, when a thread calls sleep or a conditional wait, it is moved to a timed waiting state.
    - Terminated state - happens either normally or due to segmentation fault or unhandled exception
- thread.run() vs thread.start()
    - calling start will create a new thread and will call run
    - calling run creates no new thread, executes on current thread(main), no multi-threading, run is called as a normal function call.
    - can't call start twice, throws IllegalThreadStateException.
## Synchronization
- Monitors is used to synchronize the action of multiple threads and make sure that only one thread can access the resource at a given point in time.
- Each object in Java is associated with a monitor, which a thread can lock or unlock. Only one thread at a time may hold a lock on a monitor.
- Synchronized blocks are used to keep shared resources within this block
- synchronized(objectidentifier) {} - objectidentifier is reference to an object whose lock associates with the monitor that the synchronized statement represents.
## Synchronized Block vs Synchronized Method - [link](https://stackoverflow.com/a/20907514)
- Synchronized  method acquires a lock on the whole object. This means no other thread can use any synchronized method in the whole object while the method is being run by one thread
- synchronized blocks acquires a lock in the object between parentheses after the synchronized keyword. Meaning no other thread can acquire a lock on the locked object until the synchronized block exits.
- So if you want to lock the whole object, use a synchronized method. If you want to keep other parts of the object accessible to other threads, use synchronized block.
- If you choose the locked object carefully, synchronized blocks will lead to less contention, because the whole object/class is not blocked.
- This applies similarly to static methods: 
    - a synchronized static method will acquire a lock in the whole class object.
    - while a synchronized block inside a static method will acquire a lock in the object between parentheses.
## Inter-thread Communication
- Three methods for inter-thread communication
    - wait() - causes the current thread to wait until another thread invokes notify().
    - notify() - wakes up a single thread that is waiting on this object's monitor
    - notifyAll() - Wakes up all the threads that called wait( ) on the same object.
- Lock vs Monitor - [link](https://www.geeksforgeeks.org/difference-between-lock-and-monitor-in-java-concurren)
    - Lock 
        - Locks have been in existence to implement multithreading much before the monitors have come to usage
        - implemented using lock() and unlock()
    - Monitor
        - Monitors basically ‘monitor’ the access control of shared resources and objects among threads, while others are blocked and made to wait until certain conditions
        - monitors are implemented using synchronized keyword
## Deadlock
- Should avoid nested locks
- Using join can avoid deadlock