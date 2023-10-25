# CONCURRENCY
## Race Conditions
- is a concurrency problem that may occur inside a critical section
- critical section is a section of code that is executed by multiple threads
- try to breakdown critical sections
## Thread safety vs shared resources
- Local variables - stored in thread's own stack - never shared so thread safe
- Local object references - Object references are thread safe but objects are not if it escapes the method
- Object member variables - if two threads call a method on the same object instance and this method updates object member variables, the method is not thread safe
- The Thread control escape rule - If a resource is created, used and disposed within the control of the same thread, and never escapes the control of this thread,
  the use of that resource is thread safe.
## Thread safety and immutability
- Immutability provides thread safety
- no setter, only getter.
- If you need to perform operations on the ImmutableValue instance you can do so by returning a new instance with the value resulting from the operation.
- even if an object is immutable and thereby thread safe, the reference to this object may not be thread safe
- class is thread safe, but the use of it might not
## Java memory model
- JVM divides into thread stacks and heap
- Each thread has its own thread stack
- Each thread has its own version of local variables
- may pass the copy but not the variable itself
- Objects are stored on the heap no matter what
- but reference to objects are stored on the thread stack
- 