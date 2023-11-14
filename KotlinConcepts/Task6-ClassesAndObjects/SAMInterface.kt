fun interface Predictor {
    fun predict(i: Int): Boolean
}

fun main() {
    val num: Int = 6
    val isEven = Predictor{ it % 2 == 0 }
    println("is num even? ${isEven.predict(num)}")
}