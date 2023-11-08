package KotlinBasics

fun main() {
    var list : MutableList<Int> = mutableListOf()
    for (i in 0..100 step 7) list.add(i)
    print(list)
}