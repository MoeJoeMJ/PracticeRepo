# CONCURRENCY
## Concurrency models
- Shared state vs separate state
    - Shared state 
        - different threads in the system will share some state among them
        - race conditions and deadlock etc. may occur
    - Separate state
        - different threads in the system do not share any state among them
        - in case the different threads need to communicate, they do so either by exchanging immutable objects among them, or by sending copies of objects (or data) among them.
        - can avoid most of the common concurrency problems.
- Parallel workers
    - Incoming jobs are assigned to different workers
    - Shared state + parallel workers = complex
    - Solved using 
      - non-blocking concurrency algorithms
      - persistent data structures - add all new elements to the head of the list, and return a reference to the newly added element (which then point to the rest of the list). All other threads still keep a reference to the previously first element in the list, and to these threads the list appear unchanged
    - Stateless workers - worker that does not keep state internally (but re-reads it every time it is needed) is called stateless
- Assembly line concurrency model
- Functional parallelism
## Race Conditions
- A condition in which the critical section (a part of the program where shared memory is accessed) is concurrently executed by two or more threads.
- Race condition types
    - Check-then-act - It’s defined by a program flow where a potentially stale observation is used to decide what to do next.
    - Read-modify-write 
- Elimination
    - Avoiding shared state
    - Using Synchronizations and Atomic Operations
## Same threaded system
- a single-threaded systems are scaled out to N single-threaded systems
- difference between a same-threaded and a traditional multi-threaded system is that the threads in a same-threaded system do not share state
## Virtual thread
- much more lightweight in terms of how many resources (RAM) they demand from the system to run.
- Thread.ofVirtual().start(runnable)
- mounted to platform threads
- no time slicing