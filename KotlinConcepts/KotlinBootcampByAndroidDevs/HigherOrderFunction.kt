fun higherOrderFunction(num: Int, function: (Int) -> String): String {
    return function(num)
}

var addNum: (Int) -> String = { num -> num.plus(1).toString() }

fun minusNum(num: Int): String = num.minus(1).toString()
fun main() {
    print(higherOrderFunction(5, addNum))
    print(higherOrderFunction(5, ::minusNum))  // passes reference instead of calling the function

}