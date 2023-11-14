# Task5-KotlinConcepts

- The compiler automatically infers the type with the smallest range enough to represent the value starting from `Int`
- On the JVM platform, numbers are stored as primitive types: int, double, and so on. Exceptions are cases when you create a nullable number reference such as Int? or use generics. In these cases numbers are boxed in Java classes Integer, Double, and so on.
- Operator ‘==’ cannot be applied to ‘Int’ and ‘Double’ or two different types
- If you use primitives in an object-type array, this has a performance impact because your primitives are boxed into objects. To avoid boxing overhead, use primitive-type arrays instead.
- `*` The spread operator passes each element of the array as individual arguments to your chosen function
- To compare whether two arrays have the same elements in the same order, use the `[.contentEquals()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/content-equals.html)` and `[.contentDeepEquals()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/content-deep-equals.html)` functions
- For values represented by primitive types at runtime (for example, `Int`), the `===` equality check is equivalent to the `==` check.