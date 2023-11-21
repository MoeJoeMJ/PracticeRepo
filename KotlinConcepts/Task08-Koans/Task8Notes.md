# Task8-Koans

- `collection.**joinToString**(separator = ", ", prefix = "[", postfix = "]")` called on a collection of strings
- `**.trimIndent()**` Detects a common minimal indent of all the input lines, removes it from every line and also removes the first and the last lines if they are blank
- `**trimMargin()**` trims whitespaces before the marginPrefix. Default is `|` pipe character.
- The `throw` expression has the type `**Nothing**`. When you call a function with `Nothing` as return type, the compiler will know that the execution doesn't continue beyond the call.
- without `**sealed**`  , else is mandatory.
- When you [**import**](https://kotlinlang.org/docs/packages.html#imports) a class or a function, you can specify a different name for it by adding `as NewName`
- Objects with the `[**invoke()](https://kotlinlang.org/docs/operator-overloading.html#invoke-operator)`** method can be invoked as a function.
- **partition**

`val numbers = listOf(1, 3, -4, 2, -11)
val (positive, negative) =
numbers.partition { it > 0 }`

`positive == listOf(1, 3, 2)
negative == listOf(-4, -11)`

- **flatMap**

`val result = listOf("abc", "12")
.flatMap { it.toList() }`

`result == listOf('a', 'b', 'c', '1', '2')`