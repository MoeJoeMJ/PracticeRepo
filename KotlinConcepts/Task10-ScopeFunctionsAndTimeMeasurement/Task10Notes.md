# Task 10 - Scope Functions And Time Measurements

## **SCOPE FUNCTIONS**

- They can make your code more concise and readable.
- There are five of them: `[let](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/let.html)`, `[run](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/run.html)`, `[with](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/with.html)`, `[apply](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/apply.html)`, and `[also](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/also.html)`. Basically, these functions all perform the same action: execute a block of code on an object. What's different is how this object becomes available inside the block and what the result of the whole expression is.
-


    | Function | Object reference | Return value | Is extension function |
    | --- | --- | --- | --- |
    | https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/let.html | it | Lambda result | Yes |
    | https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/run.html | this | Lambda result | Yes |
    | https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/run.html | - | Lambda result | No: called without the context object |
    | https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/with.html | this | Lambda result | No: takes the context object as an argument. |
    | https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/apply.html | this | Context object | Yes |
    | https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/also.html | it | Context object | Yes |
- The **return value** of `apply` and `also` is the context object itself. Hence, they can be included into call chains as ***side steps.***
- `let`, `run`, and `with` return the lambda result. So you can use them when assigning the result to a variable, chaining operations on the result, and so on.
- **let**
    - used to invoke one or more functions on results of call chains
    - often used to execute a code block containing non-null values `?.let {}`
    - can also use `let` to introduce local variables with a limited scope to make your code easier to read. `.let { firstItem -> doSomething() }`
- **with -** `with` can be read as "***with this object, do the following.***"
    - use for calling functions on the context object when you don't need to use the returned result
    - can also use `with` to introduce a helper object whose properties or functions are used for calculating and assigning a value.
- **run**
    - `run` is useful when your lambda both initializes objects and computes the return value.
    - You can also invoke `run` as a non-extension function. The non-extension variant of `run` has no context object, but it still returns the lambda result. In code, non-extension `run` can be read as "***run the code block and compute the result.”***
- **apply**
    - use it for code blocks that don't return a value and that mainly operate on the members of the receiver object.
    - To initialize an object
- **also**
    - Use `also` for actions that need a reference to the object rather than its properties and functions

## Time Measurement

- Properties and functions -
    - `toString(DurationUnit, decimal)`
    - `inWholeMinutes`
    - `toDouble(DurationUnit)`
    - `toComponents(h,m,s,ns -> ...)`