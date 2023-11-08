# Kotlin Bootcamp

- In Kotlin almost everything has a value, even if that value is unit.
  Everything in Kotlin is an expression.
- exceptions are for and while loop, they’re statements.
- Because Default parameters are evaluated at call time by Kotlin
- The difference between EAGER and LAZY
  AN EAGER algorithm executes immediately and returns a result.
  A LAZY algorithm defers computation until it is necessary to execute and then produces a result.
- By default, filter analyst is EAGER that means every time you call filter, it creates a new list with he elements that pass through the filter
- If you want **LAZY** Behaviour, you can use SEQUENCES
- In kotlin everything is public by default
- Just use one primary constructor, constructor overloading is not needed as we can have default parameters with optional values.
- So just use one constructor with init blocks, if needed more flexibility consider adding helper methods
- All classes implicitly extend Any
- Any has three methods: equals(), hashCode() and toString()
- INTERFACE **DELEGATION** let's you add features to a class via composition
  Composition is when you use an instance of another class as opposed to inheriting from it
- **Decomposition** `val (x,y,z) = xyzDataClass` stores properties of class separately in values
- **Sealed** class - a class that can be sub-classed but only inside the file which it's declared
- Constants are top level and and works only in object classes, not in regular classes. To define constant in the class, you have to wrap them into a **companion object**. `companion object {}`
- **Extension Functions** allow you to add functions to an existing class without having access to its source code.
- Extension Functions are great way to add helpful functionality to classes that you don't own
- Extension functions are defined outside of the class they extend. So, they cannot access to private variables.
- Extension functions are always resolved statically based on the variable they're applied to, that is at compile time.
- Inside the body we can test for null by using "?.apply". If object is not null, the apply body will be executed `this?.apply {…}`
- "Aquarium<T: Any>" - this makes it impossible to pass null
- dot(.) has precedence over the exclamation(!) mark
- **Check** throws an error if condition is not true, continues otherwise
- Using reflection to get the class name with just its instance `val className = instance::class.simpleName`
- To make a type reified, `inline fun <reified R: WaterSupply>` Because non reified types are only available at compile time. Not at runtime for isChecks.
- **labelled break** breaks at `break@loop` then jumps to `loop@`
- lambda expression is an instance of function interface
- When the **inline** transform is applied, the call to the lambda is replaced with the instructions inside the Lambda