class InitBlock(val parameter: Int = getParam()) {
    val n: Int
    init {
        println("From init block")
       n = 2
    }

    fun printN() {
        println(n)
    }
}

fun getParam(): Int {
    println("From getParam")
    return 10
}

fun main() {
    val initBlock = InitBlock()
    initBlock.printN()
}