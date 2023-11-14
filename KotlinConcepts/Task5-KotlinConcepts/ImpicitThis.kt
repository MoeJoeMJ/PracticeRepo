class A {
    fun print() {
        println("Member function")
    }

    fun invokePrint(omitThis: Boolean = false) {
        if (omitThis) print()
        else this.print()
    }
}

fun print() {
    println("Top level function")
}

fun main() {
    A().invokePrint() // calls member function
    A().invokePrint(omitThis = true)  // calls top level function
}