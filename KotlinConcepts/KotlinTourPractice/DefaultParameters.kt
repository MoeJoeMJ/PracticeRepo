fun intervalInSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0) =
        ((hours * 60) + minutes) * 60 + seconds

fun main() {
    println(intervalInSeconds(1, 20, 15))
    println(intervalInSeconds(minutes = 1,seconds = 25))
    println(intervalInSeconds(2))
    println(intervalInSeconds(minutes = 10))
    println(intervalInSeconds(1,seconds = 1))  // Only the subsequent arguments don't need to be named
}