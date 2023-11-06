import java.lang.RuntimeException

fun main() {
    try {
        val num = 10/0
    } catch (e: ArithmeticException) {
        throw RuntimeException(e)
    }
}