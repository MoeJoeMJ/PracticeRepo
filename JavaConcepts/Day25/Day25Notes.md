## General
- Calls in StringBuilder is not synchronized

## BufferedWriter
- BufferedWriter maintains an internal buffer of 8192 characters.
- During the write operation, the characters are written to the internal buffer instead of the disk.
- Once the buffer is filled or the writer is closed, the whole characters in the buffer are written to the disk.
-  the number of communication to the disk is reduced. 
- This is why writing characters is faster using BufferedWriter.

## BufferedReader
- it enables us to minimize the number of I/O operations by reading chunks of characters and storing them in an internal buffer. 
- read() will read the characters (returned as ASCII values), cast them to char and append them to the result.

## URI
- Uniform Resource Identifier
- It is a string of characters that is used to identify any resource on the internet using location, name, or both.
- URL and URN are a subset of URI
- Syntax - scheme:[//authority][/path][?query][#fragment]

## ByteArrayInputStream
- As the name suggests, it can be used to read byte array as input stream.
- contains an internal buffer which is used to read byte array as stream. 
- In this stream, the data is read from a byte array.
## ByteArrayOutputStream
- write the common data into multiple files. 
- This class stream firstly converts the data into a byte array and that array can be converted into many streams when required.
