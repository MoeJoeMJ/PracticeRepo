# Task9-Collections

- `to` notation creates a short-living `Pair` object, so it's recommended that you use it only if performance isn't critical. To avoid excessive memory usage, use alternative ways.

`val numbersMap = mutableMapOf<String, String>().apply { this["one"] = "1"; this["two"] = "2" }`

- New references are created when you initialize a collection variable with an existing collection. So, when the collection instance is altered through a reference, the changes are reflected in all its references.
- If you create a `List` reference to a `MutableList`, the compiler will produce errors if you try to modify the collection through this reference.
- `any()` and `none()` can also be used without a predicate: in this case they just check the collection emptiness. `any()` returns `true` if there are elements and `false` if there aren't; `none()` does the opposite.
- `[slice()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/slice.html)` returns a list of the collection elements with given indices. The indices may be passed either as a [range](https://kotlinlang.org/docs/ranges.html) or as a collection of integer values.
- `**elementAt**()` is useful for collections that do not provide indexed access, or are not statically known to provide one. In case of `List`, it's more idiomatic to use [indexed access operator](https://kotlinlang.org/docs/list-operations.html#retrieve-elements-by-index) (`get()` or `[]`).
- `fold()` and `reduce()` takes two arguments: the previously accumulated value and the collection element.
- The difference between the two functions is that `**fold**()` takes an initial value and uses it as the accumulated value on the first step, whereas the first step of `**reduce**()` uses the first and the second elements as operation arguments on the first step.
- **List specific operations** - `numbers.getOrNull(index), numbers.subList(3, 6), numbers.indexOf(2),`

**add** - `numbers.add(1, "two")`,

**update** - `numbers[1] = "two”` ,

**remove** -`numbers.removeAt(1)` ,

**sort** - `sort*` instead of `sorted*` in the names of all sorting functions: `[sort()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/sort.html)`, `[sortDescending()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/sort-descending.html)`, `[sortBy()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/sort-by.html)`, and so on.

`[shuffle()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/shuffle.html)` instead of `shuffled()` .

````[reverse()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/reverse.html)` instead of `reversed()`.

- **Set specific operations** - `union`, `intersect`, merging differences [`println((numbers - numbers2) union (numbers2 - numbers))` ]

You can also apply `union()`, `intersect()`, and `subtract()` functions to lists. However, their result is ***always*** a `Set`.

- **Map specific operations** -

Retrieve - `map.getOrDefault(”key”,”default”)` , `getOrElse()`,

Filter - `map.filter { (key, value) → key.endsWith("1") && value > 10 }` , `filterKeys{ it<10 }` , `filterValues{ it.endsWith("1")}`

Add/Update - `map.put("three", 3)` , `putAll()`

Remove - `map.remove("one")`