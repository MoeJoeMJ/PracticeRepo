# Task 10 - Scope Functions And Time Measurements

## **SCOPE FUNCTIONS**

- They can make your code more concise and readable.
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