class MyClass(val id: Int, val name: String, age: Int = getAge()) {
    constructor(id: Int) : this(1, "John") {
        println("From single arg secondary constructor")
    }

    constructor(): this(3) {
        println("From no arg secondary constructor")
    }
}

var getAge: () -> Int = {
    println("From getAge: Primary constructor is called")
    30
}

fun main() {
    val myClass = MyClass()
}