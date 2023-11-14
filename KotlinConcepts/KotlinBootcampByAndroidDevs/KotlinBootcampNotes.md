# Kotlin Bootcamp by Android Devs

- **Boxing** happens automatically, such as for collections. Takes more memory than storing just a number primitive. Do not use boxing unless it is needed.
- does not implicitly convert between number types. because implicit number conversion is a common source of errors in programs.
- `$*variable*` name is replaced with the text representing the value. This is called ***variable interpolation*.**
- With a list defined with `val`, you can't change which list the variable refers to, but you can still change the contents of the list.
- *`println*(arr.***contentToString*()**)`  this is how an array is printed.
- `println()` does not return a value, so it returns `kotlin.Unit`
- **when** makes sure your code covers all the branches if you are checking an enum.
- It is best practice to put parameters without **defaults** first, and the ones with defaults after.
- The **filtering** is not executed at the point of declaration. The **`filter`** operation is waiting to be triggered. It's only when you access elements of the **`filtered`** **`Sequence`** (for example, by iterating over it or using other operations like **`toList()`**) that the filter is applied. At that moment, the **`Sequence`** will filter the elements as needed, and the result is returned to you.
- use the `::` operator. This way Kotlin knows that you are passing the function reference as an argument, not trying to call the function.

  `fun increaseDirty( start: Int ) = start + 1`

  `println(updateDirty(15, **::increaseDirty**))`

- If your constructor needs more initialization code, it can be placed in one or more `**init**` blocks.
- Kotlin coding style says each class should have only one constructor - Try factory function
- Every secondary constructor must call the primary constructor first, either directly using `this()`, or indirectly by calling another secondary constructor.
- init will be called for all constructors
- val need not be initialized if getter assigns value, if getter uses field then must initialize.
- var needs to be initialized compulsorily
- Inheritance subclass must declare the superclass properties explicitly if there’s no default parameter
- **Destructuring** -  If you don't need one or more of the properties, you can skip them by using `_` instead of a variable name, as shown in the code below. `val (rock, _, diver) = d5`
- Can't modify using for-each loop. Since indices is initialized at the first time, so the indices of the forEach operation is never changed after you remove element from a List, but size() is changed.
- Marking a function as “**inline**” means, every time the function is called, the compiler will change the code to replace the lambda with the instructions inside the lambda.

If `myWith()` in the above example is marked with `inline`:

```
inline myWith(fish.name) {
    capitalize()
}

```

it is transformed into a direct call:

```
// with myWith() inline, this becomes
fish.name.capitalize()
```

- **inlining** large functions does increase your code size, so it's best used for simple functions that are used many times like `myWith()`
- **Single Abstract Method** You can instantiate, override and make a call to a SAM with one line of code, using the pattern: `Class.singleAbstractMethod { lambda_of_override }`