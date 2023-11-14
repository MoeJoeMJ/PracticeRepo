interface A {
    fun printHello() {
        println("Hello")
    }

    fun printWorld()
}

interface B : A {
    override fun printHello() {
        println("Hi")
    }

    override fun printWorld() {
        println("World")
    }
}

interface C : A {
    override fun printWorld() {
        println("World")
    }
}

interface D : A, B {  // Have to implement all the methods that are inherited
    override fun printHello() {
        super<A>.printHello()
    }

    override fun printWorld() {
        super.printWorld()
    }
}

fun main() {

}