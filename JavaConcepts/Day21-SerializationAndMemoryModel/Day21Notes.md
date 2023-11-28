# GENERAL
- ***SERIALIZATION*** - A Serializable class must have access to the no-arg constructor of its first non-serializable superclass
- ***super()*** doesn't create new instance, when you do new SubClass(), the space for both SubClass and SuperClass (and Object) is allocated as one "lump". - [link](https://stackoverflow.com/a/26202240)
- Constructors are invoked to initialize the instance variables of each class
- You can't ***lock*** on a primitive
- ***Reentrant*** locking allows a synchronized method to make a self-call to another synchronized method on the same object without causing the thread to deadlock or freeze.

# JAVA MEMORY MODEL (CONTINUED...)
- Member variables are stored in heap both when the member variable is of a primitive type, and if it is a reference to an object.
- Static variables are stored in meta space in heap
### Modern Hardware Architecture
- Modern computers have more than one CPUs(may have multiple cores as well) so its possible to have more than one thread to run simultaneously
- Each CPU contains a set of registers which are in-CPU memory
- CPU can perform operations much faster on these registers than it can perform on variables in main memory ()
- CPU also has a cache memory layer - can access this much faster than its main memory
- but typically not as fast as it can access its internal registers.
- it will read part of main memory into its CPU cache. It may even read part of the cache into its internal registers and then perform operations on it
- When the CPU needs to write the result back to main memory it will flush the value from its internal register to the cache memory, and at some point flush the value back to main memory.
- values stored in the cache memory is typically flushed back to main memory when the CPU needs to store something else in the cache memory