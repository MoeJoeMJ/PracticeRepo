# Java IO
## Overview
- stream is a conceptually endless flow of data

## Input Streams & Output Streams
- InputStream class serves as the superclass for all input streams.
- InputStream is an abstract class and not directly useful on its own.
- Some notable subclasses of InputStream
    - AudioInputStream
    - ByteArrayInputStream
    - FileInputStream
    - FilterInputStream
    - StringBufferInputStream
    - ObjectInputStream
- Similar to InputStream, OutputStream is abstract
- Some notable subclasses of OutputStream
    - ByteArrayOutputStream
    - FileOutputStream
    - StringBufferOutputStream
    - ObjectOutputStream
    - DataOutputStream
    - PrintStream
## Absolute Path & Relative Path
- Absolute Path
    - starts with the root element of the file system
    - In windows, the root element is a drive e.g. C:\, D:\, while in unix it is denoted by “/” character.
    - absolute path is static and platform dependent, so it's a bad practice.
- Relative Path
    - Current Working Directory (CWD): Every process or application running on an operating system has a current working directory. This is the directory that the system uses as the starting point for resolving relative paths. When you run a Java application, the CWD is typically the directory from which you started the application (the "launch" directory).
    - Relative Paths: A relative path specifies the location of a file or directory relative to the current working directory. It doesn't start from the root directory. Instead, it describes a path starting from the CWD.
    - For example, if the CWD is "/home/user" and you specify a relative path as "documents/file.txt," the system will look for "file.txt" within the "documents" directory under "/home/user."
## StringBuilder and StringBuffer
- StringBuffer is synchronized and therefore thread-safe.
- StringBuilder is compatible with StringBuffer API but with no guarantee of synchronization.
- StringBuilder is faster and it is recommended to use it in places where there’s no need for thread safety.
- should be used in a single-threaded context, or synchronization should be handled externally.
