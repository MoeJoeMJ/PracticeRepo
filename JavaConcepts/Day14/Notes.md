# GENERICS
- Inorder to override a method in generic class
    - with type parameter, both subclass and class has to specify type parameter, type parameter just inside parenthesis.
    - with specific type, just the generic class specifying type parameter is enough, type parameter just inside parenthesis.
- Inorder to override a generic method
    - with type parameter, not just inside parenthesis
    - with specific type, not just inside parenthesis

# [CONCURRENCY](https://docs.oracle.com/javase/tutorial/essential/concurrency/threads.html)
## PROCESSES
- has self contained execution environment, private set of resources, own memory space.
- Processes are synonymous with programs and applications
- a single application may in fact be a set of cooperating processes
- for communication between processes, most operating systems support Inter Process Communication - IPC (pipes and sockets)
- not just for communication between processes on the same system, but processes on different systems
## THREADS
- aka lightweight processes
- also has execution environment, requires fewer memory space than processes
- every process has at least one thread
- thread share resources(memory and open files) efficient but potential problem
- each thread is associated with instance of class Thread
- thread interference - running in different threads, but acting on the same data
- memory consistency errors -  inconsistent views of what should be the same data

