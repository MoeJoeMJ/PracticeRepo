fun main() {
    val button = "A"

    println(
            // Write your code here
            when(button) {
                "A" -> "Yes"
                "B" -> "No"
                "X" -> "Menu"
                "Y" -> "Nothing"
                else -> "There is no such button"
            }
    )
}