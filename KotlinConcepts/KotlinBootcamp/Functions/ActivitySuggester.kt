package Functions
fun whatShouldIDoToday(mood: String, weather: String = "Sunny", temperature: Int = 24) : String {
    return when {
        mood == "happy" && weather.lowercase() == "sunny" -> "go for a walk"
        else -> "Stay home and read."
    }
}

fun main(args: Array<String>) {
    println(whatShouldIDoToday("happy"))
}
