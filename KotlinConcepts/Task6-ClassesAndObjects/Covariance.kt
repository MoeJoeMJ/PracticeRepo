class GenericClass<out T>(val data: T) {
    fun doSomething(): T {
        return data
    }
}

fun main() {
    val intObj = GenericClass<Int>(10)
    val numberObj: GenericClass<Number> = intObj
    println(numberObj.doSomething())
}