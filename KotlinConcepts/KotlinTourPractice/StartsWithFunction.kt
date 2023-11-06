fun main() {
    val words = listOf("dinosaur", "limousine", "magazine", "language")
    // Write your code here
    for(word in words) {
        if(word.startsWith("l")) {
            println(word)
        }
    }
}