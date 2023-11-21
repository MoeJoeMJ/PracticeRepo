open class SuperClass(val name: String) {
    init {
        println("From init block in superclass")
    }

    constructor(): this(superclassInit()) {
        println("From superclass' secondary constructor")
    }
}

class SubClass(val hello: String, val world: String) : SuperClass() {
    init {
        println("From init block in subclass")
    }

    constructor(): this("hello", subclassInit()) {
        println("From subclass' secondary constructor")
    }
}

fun subclassInit(): String {
    println("Initializes sub class' primary constructor property")
    return "world"
}
fun superclassInit(): String {
    println("Initializes super class' primary constructor property")
    return "hello"
}

fun main() {
    SubClass()
}