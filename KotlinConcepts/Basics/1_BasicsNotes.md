# Basics

## Basic Syntax

- It is not required to match directories and packages: source files can be placed arbitrarily in the file system.
- `main()` when your application doesn't require any command-line arguments to run or when it's primarily designed to perform a specific task without external input. `main(args: Array<String>)` otherwise.
- `val c: Int` Type required when no initializer is provided
- The default constructor with parameters listed in the class declaration is available automatically.
- Classes are final by default; to make a class inheritable, mark it as `open`.
- x and y are automatically cast to non-nullable after null check like this if `(x == null)`
- `obj` is automatically cast to `String` after being checked for specific type like this `if (obj is String)`

## Idioms

- Data class is a POJO class
- When the **lazy** keyword is used, the object will be created only when it is called, otherwise there will be no object creation.
- Object Singleton

  `object Resource {
  val name = "Name"
  }`

- ?. If-not-null shorthand
- ?: if-not-null-else shorthand
- `println(files?.size ?: "empty")` // if file is not null then print size else print “empty”
- Swap two variables using also function

  `var a = 1
  var b = 2
  a = b.also { b = a }`


## Coding Conventions

- Prefer using `if` for binary conditions instead of `when`
- Prefer using higher-order functions (`filter`, `map` etc.) to loops
- Always use immutable collection interfaces (`Collection`, `List`, `Set`, `Map`) to declare collections which are not mutated.