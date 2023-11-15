typealias Predicate<T> = (T) -> Boolean

fun check(p: Predicate<Int>) = p(42)

fun main() {
    val x: (Int) -> Boolean = { it > 0 }
    println(check(x))
}
