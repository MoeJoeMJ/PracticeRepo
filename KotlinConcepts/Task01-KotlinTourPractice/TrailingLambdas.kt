fun repeatN(n: Int, action: () -> Unit) {
    // Write your code here
    for( i in 1..n) {
        action()
    }
}

fun main() {
    // Write your code here
    repeatN(5){println("Hello")}
}