fun printString(obj: Any) {
    if(obj is String){
        print(obj)  // obj is automatically casted to String after being checked for type
    }
}
fun main() {
    val string: String = "Hello"
    printString(string)
}