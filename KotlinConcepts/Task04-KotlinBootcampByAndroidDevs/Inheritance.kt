open class SuperClass(open val superParam: Int) {
}

class SubClass(val subParam: Int) : SuperClass(10) {  // should declare parameters explicitly if there's no default parameters

}

fun main() {
    val subClass = SubClass(10)
}