# String immutability
- Interning - Since Strings are immutable in Java, the JVM optimizes the amount of memory allocated for them by storing only one copy of each literal String in the pool.
- String is widely used  to store sensitive pieces of information like usernames, passwords, connection URLs, network connections, etc
- They're also thread safe as they're immutable
- the hashCode() method is overridden in String class to facilitate caching, such that the hash is calculated and cached during the first hashCode() call and the same value is returned ever since.
- String pool exists because Strings are immutable
- Benefits - caching, security, synchronization, and performance
- If String objects could be modified, Java’s entire security model would be broken. Here’s a sketch of one potential attack.

```
Good Thread: Open File xyz.
InputStream Constructor; call security manager.
Security manager - Read file xyz - Permission is OK.
Bad Thread wakes up at just this moment.
Changes file name string from 'xyz' to '/etc/passwd'
Yields the CPU
Good Thread
InputStream Constructor: pass /etc/passwd to operating system open syscall
Bad Thread examines memory buffer for useful information to steal
Good Thread: Open File xyz.
InputStream Constructor; call security manager.
Security manager - Read file xyz - Permission is OK.
Bad Thread wakes up at just this moment.
Changes file name string from 'xyz' to '/etc/passwd'
Yields the CPU
Good Thread
InputStream Constructor: pass /etc/passwd to operating system open syscall
Bad Thread examines memory buffer for useful information to steal
```
- Furthermore, the immutability of String objects can lead to better multithreaded performance, as these objects do not require synchronization or checking when used in multithreaded code.

________________________________________________________________________________________________________________________________________________________________________________________________________

- **TRY/CATCH** Should avoid nested try catch but sometimes its unavoidable, especially if your recovery code might throw an exception.