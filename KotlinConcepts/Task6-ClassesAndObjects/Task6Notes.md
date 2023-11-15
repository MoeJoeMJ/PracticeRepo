# Task6-ClassesAndObjects

- Even if the class has no primary constructor, the delegation still happens implicitly, and the initializer blocks are still executed
- On the JVM, if all of the primary constructor parameters have default values, the compiler will generate an additional parameterless constructor which will use the default values
- A member marked `override` is itself open, so it may be overridden in subclasses. If you want to prohibit re-overriding, use `final`
- You can also override a `val` property with a `var` property, but not vice versa. This is allowed because a `val` property essentially declares a `get` method, and overriding it as a `var` additionally declares a `set` method in the derived class.
- If a class has a member function, and an extension function is defined which has the same receiver type, the same name, and is applicable to given arguments, the ***member always wins***.
- A sealed class is [abstract](https://kotlinlang.org/docs/classes.html#abstract-classes) by itself, it cannot be instantiated directly and can have `abstract` members.
- Constructors of sealed classes can have one of two [visibilities](https://kotlinlang.org/docs/visibility-modifiers.html): `protected` (by default) or `private`
- A nested class marked as `inner` can access the members of its outer class. Inner classes carry a reference to an object of an outer class.
- Since each **enum** is an instance of the enum class, it can be initialized as:

  `enum class Color(val rgb: Int) {
  RED(0xFF0000),
  GREEN(0x00FF00),
  BLUE(0x0000FF)
  }`

- Note that even though the members of **companion objects** look like static members in other languages, at runtime those are still instance members of real objects, and can, for example, implement interfaces. you can have members of companion objects generated as real static methods and fields if you use the `@JvmStatic` annotation.
- The `**by**`-clause in the supertype list for `Derived` indicates that `b` will be stored internally in objects of `Derived` and the compiler will generate all the methods of `Base` that forward to `b`