# Day 13 Notes

## Why Type Erasure?
### Referred [How We Got the Generics We Have](https://openjdk.org/projects/valhalla/design-notes/in-defense-of-erasure)
- Type abstractions offered by lower level are simpler and weaker than those at the higher level
- No instructions for bytes, shorts, chars, or booleans. Types are erased to ints by compiler. This reduces complexity and improves efficiency of runtime.
- Homogeneous Translation
    - A generic class Foo<T> is translated into a single artifact, such as Foo.class
    - Offers more tye specifity
- Heterogeneous Translation
    - Each instantiation of a generic type or method (Foo<String>, Foo<Integer>) is treated as a separate entity, and generates separate artifacts
    - Wildcard
- Main goal - Gradual migration compatibility
- Creates the possibility of heap pollution (runtime type and compile-time type doesn't match)
- JVM runs over 200 languages (Scala, Kotlin, JRuby,Jython etc.). So the design choices of java is influenced by JVM's ecosystem and other languages.
- It was a choice between performance and type safety

________________________________________________________________________________________________________________________________________________________________________

## Java ByteCode
### Referred [Introduction to Java ByteCode](https://dzone.com/articles/introduction-to-java-bytecode)

- Several add instructions to add two numbers: iadd, ladd, fadd, dadd
- No instructions that directly operate on byte, short, char or boolean values. These values are instead converted to int by the compiler.
- Register based VM - for each thread running in a Java program, a PC register stores the address of the current instruction.
- Stack based VM - for each thread, a stack is allocated where local variables, method arguments, and return values are stored.
- Heap - memory shared by all threads and storing objects (class instances and arrays). Object deallocation is managed by a garbage collector
- Method area - for each loaded class, it stores the code of methods and a table of symbols.
- long and double occupy two local variables
- operand stack used to store intermediate values that would act as operands for instructions, or to push arguments to method invocations.

________________________________________________________________________________________________________________________________________________________________________

## Serialization

- Byte stream is platform independent
- Only non static members are serialized
- Transient keyword to not serialized a field
- If child class is serialized then its parents won't get serialized
- If parent class is serialized then its child will be serialized
- SerialVersionUID to verify whether that sender and receiver of a serialized object have loaded classes for that object which are compatible
- To declare own UID "static final long serialVersionUID=42L;"
- recommended to explicitly declare
- To avoid child getting serialized then we should declare everything in child as transient or override writeObject() and readObject()
 and make it throw NotSerializableException
- Declaring final variables as transient is useless as they're serialized directly by values
- when a class is serializable, but its superclass is not, JVM ignores the original value of that instance variable and saves the default value to the file.
