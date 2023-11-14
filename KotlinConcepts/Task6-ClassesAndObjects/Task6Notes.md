# Task6-ClassesAndObjects

- Even if the class has no primary constructor, the delegation still happens implicitly, and the initializer blocks are still executed
- On the JVM, if all of the primary constructor parameters have default values, the compiler will generate an additional parameterless constructor which will use the default values
- A member marked `override` is itself open, so it may be overridden in subclasses. If you want to prohibit re-overriding, use `final`
- You can also override a `val` property with a `var` property, but not vice versa. This is allowed because a `val` property essentially declares a `get` method, and overriding it as a `var` additionally declares a `set` method in the derived class.