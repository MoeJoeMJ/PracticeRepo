class MyClass(var name: String = "") {
    fun greet(location: String) {
        println("Hello $name, this method is called from within $location")
    }
}
fun main() {

    val obj = MyClass("John")

    // let function
    val let = obj.let {
        it.greet("let")
        it.name.length
    }
    println("Value of 'let': $let")

    // run function
    val run = obj.run {
        greet("run")
        name.length
    }
    println("Value of 'run': $run")

    // with function
    val with = with(obj) {
        greet("with")
        name.length
    }
    println("Value of 'with': $with")

    // apply function
    val newObj = MyClass()
    val initializedObj = newObj.apply { name = "Jack" }
    println("Name: ${initializedObj.name}")
}