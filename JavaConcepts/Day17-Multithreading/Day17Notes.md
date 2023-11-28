# Multithreading - [link](https://www.javatpoint.com/multithreading-in-java)
- Thread-scheduling
    - Two factors - Priority and time of arrival
    - First come first serve
    - Time-slicing scheduling
    - Preemptive priority scheduling - If a thread is already in runnable state and another thread (that has higher priority) reaches in the runnable state, then the current thread is pre-empted from the processor, and the arrived thread with higher priority gets the CPU time.
- If you sleep a thread for the specified time, the thread scheduler picks up another thread and so on.
- Can't call start() twice because once thread goes to 'terminated' state you can not restart it
- Daemon thread 
    - provides services to user thread for background supporting.
    - when all the user threads dies, JVM terminates this thread automatically.
    - set it as daemon before starting it, otherwise it throws IllegalThreadStateException
### Deadlock prevention - [link](https://jenkov.com/tutorials/java-concurrency/deadlock-prevention.html)
- Lock Ordering
- Lock timeout
- Deadlock detection 
    - Every time a thread takes a lock it is noted in a data structure
    - must transitively examine all requested locks
    - After detecting, should release all locks, backup, wait a random amount of time and then retry.
    -  However, if a lot of threads are competing for the same locks they may repeatedly end up in a deadlock even if they back up and wait.
    - assign a priority of the threads so that some backs up and the rest continue taking the locks
    - assign the priority randomly whenever a deadlock is detected, so that different threads will be given priority every time
    