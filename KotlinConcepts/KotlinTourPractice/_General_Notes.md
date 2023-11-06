# General

- **Variables** declared outside main() function at the beginning of the program are said to be declared at top level
- To declare a variable without initializing it, specify its type with `:`
- To prevent unwanted modifications, you can obtain read-only views of mutable lists, sets or Maps  by assigning them to a `List Set or Map`:

```kotlin
val shapes: MutableList<String> = mutableListOf("triangle", "square", "circle")
val shapesLocked: List<String> = shapes
```

This is also called **casting**.

- Named arguments `printMessageWithPrefix(prefix = "Log", message = "Hello")`
- Default parameter values `fun printMessageWithPrefix(message: String, prefix: String = "Info")`
- **After skipping the first default parameter value, subsequent arguments must be named.**
- If your function doesn't return a useful value then its return type is `Unit`. `Unit` is a type with only one value – `Unit`.
- Null safety detects potential problems with null values at compile time, rather than at run time.
- By default, a type is not allowed to accept null values. Nullable types are declared by explicitly adding ? after the type declaration. `var nullable: String? = "You can keep a null here”`