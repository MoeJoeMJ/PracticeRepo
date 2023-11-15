import java.lang.Integer.parseInt

fun print(number: String) {
    val num = parseInt(number)
    if (num != null) {
        print(num)
    } else {
        print("Null value")
    }
}
fun main() {
    print("100")
}