class MyClass(val name: String,var age: Int) {

}

fun main() {
    val obj = MyClass("John",20)
    println("${obj.name} ${obj.age}")
}