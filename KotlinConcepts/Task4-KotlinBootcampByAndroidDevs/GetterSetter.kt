class GetterSetter() {
    val x: Int  // need not be initialized
        get() = 1

    val y: Int = 10 // must be initialized
        get() = field

    var z: Int = 10  // must be initialized or
        get() = 1
    var number: Int = 10 // must be initialized
        get() = field
        set(value) {
            field = value * 2
        }
}

fun main() {
    val getterSetter = GetterSetter()
    getterSetter.number = 10
    println(getterSetter.number)  // prints 20
}

