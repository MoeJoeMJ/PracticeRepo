class LazyProperty {
    val string: String by lazy {
        println("Value initialized")  // Not initialized during object creation
        "Hello"
    }
}

fun main() {
    var obj = LazyProperty()
    println("Object created")
    println(obj.string)
}