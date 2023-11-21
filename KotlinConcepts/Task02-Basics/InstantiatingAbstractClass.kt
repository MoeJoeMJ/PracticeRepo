abstract class MyAbstractClass {
    abstract fun printHello()
}
fun main() {
    val obj = object: MyAbstractClass() {
        override fun printHello() {
            println("Hello")
        }
    }
    obj.printHello()
}