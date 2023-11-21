# Task7-KotlinByExample

- Special spread operator `*` lets you pass in `*entries` (a vararg of `String`)
- Inside `**run**` the object is accessed by `this`. This is useful when you want to call the object's methods rather than pass it as an argument.
- Inside let the object is accessed by `**it**`. need to use it to access methods and properties.
- `**with**` Is a non-extension function. Can access members of its argument(object) concisely: you can omit the instance name when referring to its members.
- `**apply**` executes a block of code on an object and returns the object itself. Inside the block, the object is referenced by `this`. This function is handy for initializing objects.
- Delegation just passes on the responsibility to overriding methods to another class
- Delegated properties delegates the calls of the property `set` and `get` methods to a certain object.
- Smart casts nullable to non nullable after being checked

`if (date ≠ null) {`

`date.isLeapYear()  // date changed to non nullable only within the condition`

`}`