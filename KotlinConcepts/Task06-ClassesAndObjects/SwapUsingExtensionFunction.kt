fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}
fun main() {
    val list = mutableListOf(1, 2, 3)
    list.swap(0, 2)
}